package com.kingdee.eas.zjlw.social.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK; //import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; //import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.social.LocalPayPrint;
import com.kingdee.eas.zjlw.social.LocalPayPrintCollection;
import com.kingdee.eas.zjlw.social.LocalPayPrintInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LocalPayPrintControllerBean extends AbstractLocalPayPrintControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.social.app.LocalPayPrintControllerBean");

	@Override
	public void initBill(Context ctx, String sql) throws BOSException, EASBizException {
		DbUtil.execute(ctx, sql.toString());
	}

	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		LocalPayPrintInfo info = (LocalPayPrintInfo) model;
		info = initCont(ctx, info);
		return super._save(ctx,  info);
	}

	/**
	 * 实例化控件
	 * 
	 * @param info
	 * @param ctx
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private LocalPayPrintInfo initCont(Context ctx, LocalPayPrintInfo info) throws EASBizException, BOSException {
		// 项目法文名称、项目社保号、项目法文地址等
		if (info.getProjName() != null) {
			AdminOrgUnitInfo projIdInfo = (AdminOrgUnitInfo) info.getProjName();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("proCom", projIdInfo.getId().toString()));
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("name");
			sic.add("number");
			sic.add("nameFR");
			sic.add("province");
			sic.add("insuranceAcc");
			sic.add("addressFR");
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			view.setSelector(sic);
			ProjectOrgCollection col = ProjectOrgFactory.getLocalInstance(ctx).getProjectOrgCollection(view);
			if (col != null && col.size() != 0) {
				ProjectOrgInfo pro = col.get(0);
				info.setProjNameFr(pro.getNameFR());
				info.setProjPri(pro.getProvince());
				info.setProjSCNum(pro.getInsuranceAcc());
				info.setProjAddress(pro.getAddressFR());
			}
		}
		return info;

	}
}