package com.kingdee.eas.zjlw.social.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK; // import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; // import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.personmess.LocalInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryFactory;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoFactory;
import com.kingdee.eas.zjlw.social.InsurePersonCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.zjlw.social.InsurePersonInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class InsurePersonControllerBean extends AbstractInsurePersonControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.social.app.InsurePersonControllerBean");

	/**
	 * 修复错误数据
	 */
	@SuppressWarnings("unchecked")
	protected void _updateErrData(Context ctx) throws BOSException {
		// 获取属地化信息录入数据
		LocalInfoEntryCollection localInfoEntryCol = getLocalInfoData(ctx);
		/**
		 * 循环参保人员名单，匹配相同的分录（姓and名and出生日期or（社保号 or ccp）），匹配到相同项，则在原集合中删除 取出personid，查找对应的工资数据中的集合 以任一personid为标准，更新所有数据
		 */
		for (int i = 0; i < localInfoEntryCol.size(); i++) {
			LocalInfoEntryInfo localInfoInfo = localInfoEntryCol.get(i);
			String lastName = localInfoInfo.getLastName();
			String firstName = localInfoInfo.getFirstName();
			Date birthDate = localInfoInfo.getBirthdate();
			String secuNum = "";
			if (localInfoInfo.getSecurityNo() != null)
				secuNum = localInfoInfo.getSecurityNo();
			String ccp = "";
			if (localInfoInfo.getCCPNo() != null)
				ccp = localInfoInfo.getCCPNo();
			String personId = localInfoInfo.getPersonId();
			for (int j = 0; j < localInfoEntryCol.size(); j++) {
				LocalInfoEntryInfo forCollocalInfoInfo = localInfoEntryCol.get(j);
				String forCollastName = forCollocalInfoInfo.getLastName();
				String forColfirstName = forCollocalInfoInfo.getFirstName();
				Date forColbirthDate = forCollocalInfoInfo.getBirthdate();
				String forColsecuNum = "";
				if (forCollocalInfoInfo.getSecurityNo() != null)
					forColsecuNum = forCollocalInfoInfo.getSecurityNo();
				String forColccp = "";
				if (forCollocalInfoInfo.getCCPNo() != null)
					forColccp = forCollocalInfoInfo.getCCPNo();
				String forColPersonId = forCollocalInfoInfo.getPersonId();
				if ((forColsecuNum != null && !"".equals(forColsecuNum)) || (forColccp != null && !"".equals(forColccp))) {
					if (lastName.equals(forCollastName) && firstName.equals(forColfirstName) && birthDate.equals(forColbirthDate) || (secuNum.equals(forColsecuNum) || ccp.equals(forColccp)) && !localInfoInfo.getId().toString().equals(forCollocalInfoInfo.getId().toString())) {
						// 更新属地化信息录入
						String updateLocalInfoSql = "update CT_PER_LocalInfoEntry set cfpersonid = '" + personId + "' where cfpersonid = '" + forColPersonId + "'";
						DbUtil.execute(ctx, updateLocalInfoSql);
						// 更新参保人员名单
						String updateInsPerSql = "update CT_SOC_InsurePersonEntry set cfpersonid = '" + personId + "' where cfpersonid = '" + forColPersonId + "'";
						DbUtil.execute(ctx, updateInsPerSql);
						// 更新工资数据
						String updatePayRollSql = "update CT_SOC_PayrollEntry set cfpersonid = '" + personId + "' where cfpersonid = '" + forColPersonId + "'";
						DbUtil.execute(ctx, updatePayRollSql);
						// updatePayRoll(ctx,forColPersonId,personId);
						localInfoEntryCol.remove(forCollocalInfoInfo);
					}
				}
			}
		}
	}

	private LocalInfoEntryCollection getLocalInfoData(Context ctx) throws BOSException {
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		filter.getFilterItems().add(new FilterItemInfo("securityno", CompareType.NOTEMPTY));
		filter.getFilterItems().add(new FilterItemInfo("ccpno", CompareType.NOTEMPTY));
		filter.getFilterItems().add(new FilterItemInfo("parent.billSate", BillStateEnum.CHECKED, CompareType.EQUALS));
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		view.setFilter(filter);
		view.setSelector(sic);
		LocalInfoEntryCollection lec = LocalInfoEntryFactory.getLocalInstance(ctx).getLocalInfoEntryCollection(view);
		return lec;
	}

	private void updatePayRoll(Context ctx, String forColPersonId, String personId) {
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		filter.getFilterItems().add(new FilterItemInfo("cfpersonid", forColPersonId));
	}
}