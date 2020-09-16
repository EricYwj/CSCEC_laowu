package com.kingdee.eas.zjlw.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.entrust.toolkit.util.Map;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.attachment.AttachmentCollection;
import com.kingdee.eas.base.attachment.AttachmentFactory;
import com.kingdee.eas.base.attachment.AttachmentInfo;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IAttachment;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.util.NumericExceptionSubItem;

public class attachmentHelper {

	/**
	 * 【添加附件】 通过分录集合，源单据id，目标单据id，向目标单据增加附件
	 * 
	 * @author ywj 2017-11-16
	 * @param sourceId
	 * @param taskId
	 * @param col
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static void attachHandle(String sourceId, String taskId, BoAttchAssoCollection col) throws BOSException, EASBizException {
		IBoAttchAsso iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance(); // 附件与业务对象关联接口
		for (int i = 0; i < col.size(); i++) {
			BoAttchAssoInfo sourceAttch = col.get(i); // 源单据附件
			BoAttchAssoInfo billAttch = new BoAttchAssoInfo(); // 目标单据附件
			billAttch.setBoID(sourceId); // 源单据ID
			billAttch.setAssoType("系统已有附件"); // 类型
			billAttch.setAttachment(sourceAttch.getAttachment()); // 附件
			billAttch.setAssoBusObjType(BOSUuid.read(taskId.toString()).getType().toString()); // 关联业务对象的类型
			iBoAttchAsso.addnew(billAttch);
		}
	}
	

	/**
	 * 获取单据对应的所有附件，用于前台
	 * 
	 * @author ywj 2017-11-16
	 * @param billId单据主键
	 */
	public static AttachmentCollection getAttachments(String billId) throws BOSException, EASBizException {
		AttachmentCollection attachments = null; // 附件集合
		IBoAttchAsso iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance(); // 附件与业务对象关联接口
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("boID", billId));
		view.setFilter(filter);
		BoAttchAssoCollection coll = iBoAttchAsso.getBoAttchAssoCollection(view); // 查询所关联附件
		if (isNullCollection((Collection) coll)) {
			return attachments;
		}
		attachments = new AttachmentCollection();
		IAttachment iAttachment = AttachmentFactory.getRemoteInstance();
		for (int i = 0; i < coll.size(); i++) {
			BoAttchAssoInfo bo = coll.get(i); // 附件关联对象
			AttachmentInfo attachment = bo.getAttachment(); // 附件对象
			attachment = iAttachment.getAttachmentInfo(new ObjectUuidPK(attachment.getId()));
			attachments.add(attachment);
		}
		return attachments;
	}

	public static Set getAttaIdByAttaCol(AttachmentCollection col) {
		Set idSet = new HashSet();
		for (int i = 0; i < col.size(); i++) {
			idSet.add(col.get(i).getId().toString());
		}
		return idSet;
	}

	/**
	 * 【集合元素比较】 对比集合，返回差异，以oldSet为标准，返回新增加的元素及删除的元素
	 * 
	 * @author ywj 2017-11-16
	 * @param oldSet
	 *            原集合
	 * @param newSet
	 *            新集合
	 * @return HashMap ：addSet新增集合 delSet删除的集合
	 */
	@SuppressWarnings("unchecked")
	public static HashMap verifyCollection(Set oldSet, Set newSet) {
		Set delSet = new HashSet();
		Set addSet = new HashSet();
		HashMap returnMap = new HashMap();
		// 取出新集合不包含的旧集合的元素，即被删除的元素
		for (Iterator iterator = oldSet.iterator(); iterator.hasNext();) {
			Object delElement = (Object) iterator.next();
			if (!newSet.contains(delElement)) {
				delSet.add(delElement);
			}
		}

		// 取出旧集合不包含的新集合的元素，即新增加的元素
		for (Iterator iterator = newSet.iterator(); iterator.hasNext();) {
			Object addElement = (Object) iterator.next();
			if (!oldSet.contains(addElement)) {
				addSet.add(addElement);
			}
		}
		returnMap.put("addSet", addSet);
		returnMap.put("delSet", delSet);
		return returnMap;
	}

	/**
	 * 判断集合是否为空
	 */
	@SuppressWarnings("unchecked")
	public static boolean isNullCollection(Collection col) {
		if (col == null) {
			return false;
		}
		if (col.size() == 0) {
			return false;
		}
		return true;
	}

}
