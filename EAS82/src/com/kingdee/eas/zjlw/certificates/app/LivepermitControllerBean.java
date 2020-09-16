package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;

import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LivepermitControllerBean extends AbstractLivepermitControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.LivepermitControllerBean");

    // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		LivepermitInfo accInfo = (LivepermitInfo) model;
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
    protected IObjectPK _submit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	LivepermitInfo accInfo = (LivepermitInfo) model;
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
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
    	LivepermitInfo info = (LivepermitInfo) getValue(ctx, pk, getSelector());

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
		writeHistory(ctx,info,true);
		writeLeaveManage(ctx,info);
		
    }
    // 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		LivepermitInfo info = (LivepermitInfo) getValue(ctx, pk,getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("所选行在审核不通过中");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeHistory(ctx,info,false);
		deleteLeaveManage(ctx,info);
	}
	//反写人员历史信息
	private void writeHistory(Context ctx, LivepermitInfo info,boolean isAudit) throws BOSException, EASBizException{
		LivepermitEntryCollection entryCol=info.getEntrys();
    	EntityViewInfo view = new EntityViewInfo();
    	FilterInfo filter = new FilterInfo();
    	SelectorItemCollection sic = new SelectorItemCollection();
    	sic.add("bsnisState");
    	sic.add("hBsnisState");
		for(int i=0;i<entryCol.size();i++){
			LivepermitEntryInfo wpInfo=entryCol.get(i);
			String idNum=wpInfo.getIdNum();
			String passpNum=wpInfo.getPasspNum();
			String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passportNo",passpNum));
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId",wpInfo.getPersonID()));
//			filter.setMaskString("#0 OR #1");
			view.setFilter(filter);
		    Boolean departure=wpInfo.isDeparture();
			Boolean isStop=wpInfo.isIsStop();
			PersonHistoryCollection col = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
			if(col!=null&&col.size()>0){
				PersonHistoryInfo phInfo=col.get(0);
				if(isAudit){
					//phInfo.setHBsnisState(phInfo.getBsnisState());
					phInfo.setBsnisState(perBizStateEnum.RESIDENCE);
				}else{
					phInfo.setBsnisState(perBizStateEnum.WORKPERMIT);
				}
				PersonHistoryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
			}
			
		}
	}
	//是否离境，手动勾选，审核通过后反写到离境单据。
	private void writeLeaveManage(Context ctx, LivepermitInfo info) throws EASBizException, BOSException{
		//LeaveManageInfo lmInfo = new LeaveManageInfo();
		LivepermitEntryCollection  entryCol = info.getEntrys();
		for(int i=0;i<entryCol.size();i++){
			LeaveManageInfo lmInfo = new LeaveManageInfo();
		    LivepermitEntryInfo entryInfo = entryCol.get(i);
		    Boolean departure=entryInfo.isDeparture();
		    Boolean isStop=entryInfo.isIsStop();
		    if(departure||isStop){
			    //表头
				lmInfo.setId(BOSUuid.create(lmInfo.getBOSType()));
				lmInfo.setSourceBillId(info.getId().toString());
				lmInfo.setNumber(info.getNumber());
				lmInfo.setBNum(info.getBNum());
				lmInfo.setBizDate(new Date());
				lmInfo.setBillSate(BillStateEnum.DRAFT);
				// 表体
				// 添加分录
				LeaveManageEntryInfo lmEntryInfo=new LeaveManageEntryInfo();
				lmEntryInfo.setId(BOSUuid.create(lmEntryInfo.getBOSType()));	
				lmEntryInfo.setName(entryInfo.getName());//姓名
				lmEntryInfo.setSex(entryInfo.getSex());//性别
				lmEntryInfo.setLastName(entryInfo.getLastName());//新拼音
				lmEntryInfo.setFirstName(entryInfo.getFirstName());//名拼音
				lmEntryInfo.setNatioNal(entryInfo.getNation());//国籍
				lmEntryInfo.setBirthday(entryInfo.getBirth());//生日
				lmEntryInfo.setIdNum(entryInfo.getIdNum());//身份证号
				lmEntryInfo.setPasspNum(entryInfo.getPasspNum());//护照号
				lmEntryInfo.setBirthPlaceCn(entryInfo.getBirthPlace());//出生地中文
				lmEntryInfo.setBirthPlaceFr(entryInfo.getBirthPlaceFr());//出生地法文
				lmEntryInfo.setPasspIsDate(entryInfo.getPassportIssueDate());//护照签发日期
				lmEntryInfo.setPasspExDate(entryInfo.getPasspExDate());//护照到期日期
				lmEntryInfo.setFatherName(entryInfo.getFatherName());//父亲姓名
				lmEntryInfo.setFatherNameAl(entryInfo.getFatherNameAlphabet());//父亲姓名拼音
				lmEntryInfo.setMotherName(entryInfo.getMotherName());//母亲姓名
				lmEntryInfo.setMotherNameAl(entryInfo.getMotherNameAlphabet());//母亲姓名拼音
				lmEntryInfo.setMaritalStatus(entryInfo.getMaritalStatus());//婚姻状况
				lmEntryInfo.setWPmtNum(entryInfo.getWPmtNum());//劳动证号
				lmEntryInfo.setImmiTime(entryInfo.getImmiTime());//入阿时间
				lmEntryInfo.setWPmtSTime(entryInfo.getWPmtSTime());//劳动证到期时间
				lmEntryInfo.setQuProf(entryInfo.getQuProf());//指标工种
				lmEntryInfo.setQuproff(entryInfo.getPrmtProf());//指标工种（法文）
				lmEntryInfo.setActProff(entryInfo.getActProf());//实际工种
				lmEntryInfo.setPmtProj(entryInfo.getPmtProj());//指标项目
				lmEntryInfo.setTaskProj(entryInfo.getWorkOrg());//工作项目
				lmEntryInfo.setCooperation(entryInfo.getCooperation());//合作单位
				lmEntryInfo.setDocType(entryInfo.getDocType());//居住证类型
				lmEntryInfo.setRePmtNum(null==entryInfo.getRePmtNum()?null:entryInfo.getRePmtNum());//临时居住证号码
				lmEntryInfo.setRePmtETime(null==entryInfo.getRePmtETime()?null:entryInfo.getRePmtETime());//临时居住证到证日期
				lmEntryInfo.setPmtNum(null==entryInfo.getPmtNum()?null:entryInfo.getPmtNum());//正式居住证号
				lmEntryInfo.setPmteffDate(null==entryInfo.getPmteffDate()?null:entryInfo.getPmteffDate());//正式居住证生效日期
				lmEntryInfo.setPmtETime(null==entryInfo.getPmtETime()?null:entryInfo.getPmtETime());//正式居住证居住证到期日期
				lmEntryInfo.setPersonID(entryInfo.getPersonID());//人员主键
				lmEntryInfo.setSourceEntryID(entryInfo.getId().toString());//来源分录
				//lmEntryInfo.setRemark(entryInfo.getRemark());//备注
				if(departure){
					lmEntryInfo.setLeaveType(leaveTypeEnum.LEAVENO);//是否离境，状态为居住证未办！
				}
				if(isStop){
					lmEntryInfo.setLeaveType(leaveTypeEnum.LEAVESTOP);//是否停办，状态为居住证停办！
					//lmEntryInfo.setDptrGTime(entryInfo.getEndTime());//停办时间
				}
				//携带附件
				IBoAttchAsso boaFac = BoAttchAssoFactory.getLocalInstance(ctx);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("id");
				sic.add("attachment.id");
				EntityViewInfo view = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("boID", entryInfo.getId().toString()));
				view.setFilter(filter);
				view.setSelector(sic);
				//根据入境分录ID查询附件
				BoAttchAssoCollection boaCol =boaFac.getBoAttchAssoCollection(view);
				if(boaCol!=null && boaCol.size()>0){
					for(int j=0;j<boaCol.size();j++){
						BoAttchAssoInfo boaInfo = boaCol.get(j);
						//添加附件
						BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
						newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
						newBoaInfo.setBoID(lmEntryInfo.getId().toString());//业务ID：离境分录ID
						newBoaInfo.setAssoType("系统已有附件");//类型
						newBoaInfo.setAttachment(boaInfo.getAttachment());//附件
						newBoaInfo.setAssoBusObjType("3D062727");//关联业务对象的类型：离境分录BOSTYPE
						boaFac.addnew(newBoaInfo);
					}
				}
				lmInfo.getEntrys().add(lmEntryInfo);
				LeaveManageFactory.getLocalInstance(ctx).addnew(lmInfo);
		    }
	   }		
	}
	//反审核，删除离境中的数据
	protected void deleteLeaveManage(Context ctx, LivepermitInfo info) throws EASBizException, BOSException{
		LivepermitEntryCollection  entryCol = info.getEntrys();
		for(int i=0;i<entryCol.size();i++){
			LivepermitEntryInfo entryInfo = entryCol.get(i);
		    EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
		    Boolean departure=entryInfo.isDeparture();
		    Boolean isStop=entryInfo.isIsStop();
		    String id=info.getId().toString();
		    filter.getFilterItems().add(new FilterItemInfo("sourceBillId",id,CompareType.EQUALS));
		    view.setFilter(filter);
			LeaveManageInfo phInfo = LeaveManageFactory.getLocalInstance(ctx).getLeaveManageCollection(view).get(0);
		    if(phInfo!=null&&(departure||isStop)){
		    	LeaveManageFactory.getLocalInstance(ctx).delete(filter);
		    }
		 }
	}
	protected SelectorItemCollection getSelector(){
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		return sic;
	
    }
}