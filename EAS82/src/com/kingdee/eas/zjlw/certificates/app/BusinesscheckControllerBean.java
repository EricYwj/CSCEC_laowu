package com.kingdee.eas.zjlw.certificates.app;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.certificates.BusinesscheckInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;

public class BusinesscheckControllerBean extends AbstractBusinesscheckControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.BusinesscheckControllerBean");
 // 保存
    protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	BusinesscheckInfo accInfo = (BusinesscheckInfo) model;
    	accInfo.setBillSate(BillStateEnum.DRAFT);
    	//设置编码
    	//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
    	//    	CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
    	//    	String orgId = currentCompany.getId().toString();
    	//    	ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
    	//    	if(codFactory.isExist(accInfo, orgId)){
    	//    		//不允许断号
    	//    		if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
    	//    			accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    	//    		}else{
    	//    			if(codFactory.isAddView(accInfo, orgId)){//新增显示
    	//    				
    	//    			}else{//什么都没勾选
    	//    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    	//    			}
    	//    		}
    	//    	}
    	//    	}


    	return super._save(ctx, accInfo);
    }
	//提交 
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException {
    	BusinesscheckInfo accInfo = (BusinesscheckInfo) model;
    	accInfo.setBillSate(BillStateEnum.SUBMIT);
    	//设置编码
    	//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
    	//    		CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
    	//    		String orgId = currentCompany.getId().toString();
    	//    		ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
    	//    		if(codFactory.isExist(accInfo, orgId)){
    	//    			//不允许断号
    	//    			if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
    	//    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    	//    			}else{
    	//    				if(codFactory.isAddView(accInfo, orgId)){//新增显示
    	//
    	//    				}else{//什么都没勾选
    	//    					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    	//    				}
    	//    			}
    	//    		}
    	//    	}
    	return super._submit(ctx, accInfo);
    }
    //审核通过
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)
    		throws EASBizException, BOSException {
    	BusinesscheckInfo info = (BusinesscheckInfo) getValue(ctx, pk, getSelector());

		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "40"));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("所选行已存在审核通过的数据，不能审核！");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		
    }
    // 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		BusinesscheckInfo info = (BusinesscheckInfo) getValue(ctx, pk,
				getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(
				new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("所选行已存在审核通过的数据，不能审核！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),
				pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);

		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
	}
	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		return sic;
	}
}