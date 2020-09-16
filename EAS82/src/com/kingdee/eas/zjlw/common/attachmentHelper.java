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
	 * ����Ӹ����� ͨ����¼���ϣ�Դ����id��Ŀ�굥��id����Ŀ�굥�����Ӹ���
	 * 
	 * @author ywj 2017-11-16
	 * @param sourceId
	 * @param taskId
	 * @param col
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static void attachHandle(String sourceId, String taskId, BoAttchAssoCollection col) throws BOSException, EASBizException {
		IBoAttchAsso iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance(); // ������ҵ���������ӿ�
		for (int i = 0; i < col.size(); i++) {
			BoAttchAssoInfo sourceAttch = col.get(i); // Դ���ݸ���
			BoAttchAssoInfo billAttch = new BoAttchAssoInfo(); // Ŀ�굥�ݸ���
			billAttch.setBoID(sourceId); // Դ����ID
			billAttch.setAssoType("ϵͳ���и���"); // ����
			billAttch.setAttachment(sourceAttch.getAttachment()); // ����
			billAttch.setAssoBusObjType(BOSUuid.read(taskId.toString()).getType().toString()); // ����ҵ����������
			iBoAttchAsso.addnew(billAttch);
		}
	}
	

	/**
	 * ��ȡ���ݶ�Ӧ�����и���������ǰ̨
	 * 
	 * @author ywj 2017-11-16
	 * @param billId��������
	 */
	public static AttachmentCollection getAttachments(String billId) throws BOSException, EASBizException {
		AttachmentCollection attachments = null; // ��������
		IBoAttchAsso iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance(); // ������ҵ���������ӿ�
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("boID", billId));
		view.setFilter(filter);
		BoAttchAssoCollection coll = iBoAttchAsso.getBoAttchAssoCollection(view); // ��ѯ����������
		if (isNullCollection((Collection) coll)) {
			return attachments;
		}
		attachments = new AttachmentCollection();
		IAttachment iAttachment = AttachmentFactory.getRemoteInstance();
		for (int i = 0; i < coll.size(); i++) {
			BoAttchAssoInfo bo = coll.get(i); // ������������
			AttachmentInfo attachment = bo.getAttachment(); // ��������
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
	 * ������Ԫ�رȽϡ� �Աȼ��ϣ����ز��죬��oldSetΪ��׼�����������ӵ�Ԫ�ؼ�ɾ����Ԫ��
	 * 
	 * @author ywj 2017-11-16
	 * @param oldSet
	 *            ԭ����
	 * @param newSet
	 *            �¼���
	 * @return HashMap ��addSet�������� delSetɾ���ļ���
	 */
	@SuppressWarnings("unchecked")
	public static HashMap verifyCollection(Set oldSet, Set newSet) {
		Set delSet = new HashSet();
		Set addSet = new HashSet();
		HashMap returnMap = new HashMap();
		// ȡ���¼��ϲ������ľɼ��ϵ�Ԫ�أ�����ɾ����Ԫ��
		for (Iterator iterator = oldSet.iterator(); iterator.hasNext();) {
			Object delElement = (Object) iterator.next();
			if (!newSet.contains(delElement)) {
				delSet.add(delElement);
			}
		}

		// ȡ���ɼ��ϲ��������¼��ϵ�Ԫ�أ��������ӵ�Ԫ��
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
	 * �жϼ����Ƿ�Ϊ��
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
