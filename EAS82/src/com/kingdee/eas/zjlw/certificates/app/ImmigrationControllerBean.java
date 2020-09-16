package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ibm.db2.jcc.sqlj.EntryInfo;
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
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelFactory;
import com.kingdee.eas.zjlw.certificates.ASCancelInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryEntryInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryFactory;
import com.kingdee.eas.zjlw.certificates.IfilentryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.eas.zjlw.certificates.PassportEntryInfo;
import com.kingdee.eas.zjlw.certificates.PassportFactory;
import com.kingdee.eas.zjlw.certificates.PassportInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
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

public class ImmigrationControllerBean extends AbstractImmigrationControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.ImmigrationControllerBean");
 // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		ImmigrationInfo accInfo = (ImmigrationInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		//设置编码
//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
//    	CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
//    	String orgId = currentCompany.getId().toString();
//    	ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
//	    	if(codFactory.isExist(accInfo, orgId)){
//	    		//不允许断号
//	    		if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
//	    			accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//	    		}else{
//	    			if(codFactory.isAddView(accInfo, orgId)){//新增显示
//	    				
//	    			}else{//什么都没勾选
//	    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//	    			}
//	    		}
//	    	}
//    	}
		return super._save(ctx, accInfo);
	}
	//提交 
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException {
    	ImmigrationInfo accInfo = (ImmigrationInfo) model;
    	accInfo.setBillSate(BillStateEnum.CHECKING);
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
    
    /**
     * 业务人员审核通过
     */
    protected void _internalAudit(Context ctx, IObjectPK PK)throws BOSException, EASBizException {
    	ImmigrationInfo info = (ImmigrationInfo) getValue(ctx, PK, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),PK, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("inteAuditor");
		sic.add("inteADate");
		info.setBillSate(BillStateEnum.CHECKING);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
    }
    
    /**
     * 项目经理审核通过
     */
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
    	ImmigrationInfo info = (ImmigrationInfo) getValue(ctx, pk, getSelector());
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
		writeBack(ctx, info, true);		//更改人员状态，反写数据等
		
    }
    
//	private void writePassp(Context ctx, ImmigrationInfo info) throws EASBizException, BOSException {
//			ImmigrationEntryInfo entryInfo = info.getEntrys().get(0);
//			// 表头
//			PassportInfo ascInfo = new PassportInfo();
//			ascInfo.setId(BOSUuid.create(ascInfo.getBOSType()));
//			ascInfo.setSourceBillId(info.getId().toString());
//			ascInfo.setNumber(info.getNumber());
//			// 表体
//			// 添加分录
//			PassportEntryInfo cancelEntryInfo = new PassportEntryInfo();
//			cancelEntryInfo.setId(BOSUuid.create(cancelEntryInfo.getBOSType()));
//			cancelEntryInfo.setName(entryInfo.getName());// 姓名
//			cancelEntryInfo.setIdNum(entryInfo.getIdNum());//身份证号码
//			cancelEntryInfo.setPasspNum(entryInfo.getPasspNum());//护照号码
//			ascInfo.getEntrys().add(cancelEntryInfo);
//			PassportFactory.getLocalInstance(ctx).addnew(ascInfo);
//
//		}
	
//	// 反审核删除护照发放中的数据
//	public void deletePersonHis(Context ctx,ImmigrationInfo info)throws BOSException, EASBizException {
//		FilterInfo filter = new FilterInfo();
//		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", info.getId().toString()));
//		PassportFactory.getLocalInstance(ctx).delete(filter);
//
//	}
//    /**
//     * 劳务部审核
//     */
//    protected void _LWAudit(Context ctx, IObjectPK PK) throws BOSException,EASBizException {
//    	ImmigrationInfo info = (ImmigrationInfo) getValue(ctx, PK, getSelector());
//		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),PK, info.getNumber());
//		SelectorItemCollection sic = new SelectorItemCollection();
//		sic.add("billSate");
//		sic.add("LWAuditor");
//		sic.add("LWAudDate");
//		info.setBillSate(BillStateEnum.CHECKED);
//		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
//		info.setAuditDate(new Date());
//		updatePartial(ctx, info, sic);
//		LogUtil.afterLog(ctx, logPK);
//		writeBack(ctx, info, true);		//更改人员状态，反写数据等
//    }
//    
	/**
	 * 审核不通过
	 */
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		ImmigrationInfo info = (ImmigrationInfo) getValue(ctx, pk,getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		sic.add("inteAuditor");
		sic.add("inteADate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setInteAuditor(null);
		info.setInteADate(null);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx, info, false);
	}
	
	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		return sic;
	}

	/**
	 * 获取双认证未完成人员
	 * @param dqEntryInfo
	 * @return
	 */
	private String checkDQTime(DoubQualifyEntryInfo dqEntryInfo) {
		Date dqFTime = null;
		String tip = "";
		dqFTime = dqEntryInfo.getQualDate();
		Date now = new Date();
		long  day=(dqFTime.getTime()-now.getTime())/86400000;
    	if (day<30) {
    		tip = tip + "姓名：" + dqEntryInfo.getName() + "身份证号或护照号：" + (dqEntryInfo.getIdNum()==null?dqEntryInfo.getPasspNo():dqEntryInfo.getIdNum()) + ";" + "\r\n";
		}
    	return tip;
	}
	

	
	/**
	 * 回写数据
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeBack(Context ctx, ImmigrationInfo info, boolean audMark)throws BOSException, EASBizException {
		ImmigrationEntryCollection entryCol = info.getEntrys();
		ImmigrationEntryInfo entryInfo = new ImmigrationEntryInfo();
		boolean cancelSta = true;
		boolean violSta = true;
		for (int i = 0; i < entryCol.size(); i++) {
			entryInfo = entryCol.get(i);
			cancelSta = entryInfo.isIsCancel();
			violSta = entryInfo.isIfUnexpect();
			updatePerHis(ctx, entryInfo,false,audMark);//更新人员状态
			if (!cancelSta) {
				if (violSta) {//违规入境
					if (audMark) {
						writeViolation(ctx, info, entryInfo);//审核通过回写违规入境单据
					} else {
						deleteViol(ctx, info.getId().toString());// 反审核删除违规入境中的数据
					}
				} else {// 正常状态
					//					if (audMark) {
					//						writePassp(ctx, info);
					//					} else {
					//						deletePersonHis(ctx,info);
					//					}
				}
			}else {//停办
				//writeProjectWork(ctx, entryInfo.getQuProf().getId().toString(),audMark);// 更改指标使用数量
				//updatePerHis(ctx, entryInfo.getIdNum(), entryInfo.getPasspNum(),true,audMark);//更新人员状态
			}
		}
	}
	
	/**
	 * 回写违规入境人员表
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeViolation(Context ctx, ImmigrationInfo info,ImmigrationEntryInfo entryInfo) throws EASBizException, BOSException {
		// 表头
		IfilentryInfo ascInfo = new IfilentryInfo();
		ascInfo.setId(BOSUuid.create(ascInfo.getBOSType()));
		ascInfo.setSourceBillId(info.getId().toString());
//		ascInfo.setContbNum(info.getContbNum());//反签批次号
		ascInfo.setNumber(info.getNumber());//单据编号
		ascInfo.setBillSate(BillStateEnum.DRAFT);//单据状态
		ascInfo.setBizDate(new Date());//业务日期
		// 表体
		// 添加分录
		IfilentryEntryInfo IfilentryEntryInfo = new IfilentryEntryInfo();
		IfilentryEntryInfo.setId(BOSUuid.create(IfilentryEntryInfo.getBOSType()));
		IfilentryEntryInfo.setName(entryInfo.getName());// 姓名
		IfilentryEntryInfo.setLastName(entryInfo.getLastName());//姓拼音
		IfilentryEntryInfo.setFirstName(entryInfo.getFirstName());//名拼音
		IfilentryEntryInfo.setSex(entryInfo.getSex());// 性别
		IfilentryEntryInfo.setBirthdate(entryInfo.getBirthdate());//出生日期
		IfilentryEntryInfo.setNatioNal(entryInfo.getNatioNal());//国籍
		IfilentryEntryInfo.setPasspNum(entryInfo.getPasspNum());//护照号
		IfilentryEntryInfo.setPasspExDate(entryInfo.getPasspExDate());//护照失效日期
		IfilentryEntryInfo.setVeTime(entryInfo.getVeTime());//签证失效日期
		IfilentryEntryInfo.setDbCmpTime(entryInfo.getDbCmpTime());//双认证办理完成时间
		IfilentryEntryInfo.setContDepart(entryInfo.getContDepart());//签订合同单位
		IfilentryEntryInfo.setContSTime(entryInfo.getContSTime());//签订合同日期
		IfilentryEntryInfo.setContOtime(entryInfo.getContOtime());//合同生效日期
		IfilentryEntryInfo.setContItime(entryInfo.getContItime());//合同失效日期
		IfilentryEntryInfo.setIfbuyInsure(entryInfo.isIfbuyInsure());//是否购买保险
		IfilentryEntryInfo.setIsHand(entryInfo.isIsHand());//是否办理国际健康证（红本）
		IfilentryEntryInfo.setApAlgTime(entryInfo.getApAlgTime());//申请入阿时间
		IfilentryEntryInfo.setPmtProj(entryInfo.getPmtProj());// 指标项目
		IfilentryEntryInfo.setTaskProj(entryInfo.getTaskProj());// 工作项目
		IfilentryEntryInfo.setPartner(entryInfo.getPartner());// 合作单位
		IfilentryEntryInfo.setReportAffiliated(entryInfo.isReportAffiliated());//入境申请报告挂靠人
		IfilentryEntryInfo.setIdNum(entryInfo.getIdNum());//身份证号码
		IfilentryEntryInfo.setDescription(entryInfo.getDescription());//备注
		IfilentryEntryInfo.setOldPassport(entryInfo.getOldPassport());//旧护照号码	oldPassport
		IfilentryEntryInfo.setBirthPlaceCn(entryInfo.getBirthPlaceCn());//出生地（中文）	birthPlaceCn
		IfilentryEntryInfo.setBirthPlaceFr(entryInfo.getBirthPlaceFr());//出生地（拼音）	birthPlaceFr
		IfilentryEntryInfo.setPassportIssueDate(entryInfo.getPassportIssueDate());//护照签发日期	passportIssueDate
		IfilentryEntryInfo.setPassportAgence(entryInfo.getPassportAgence());//护照颁发机构	passportAgence
		IfilentryEntryInfo.setPassportCityC(entryInfo.getPassportCityC());//护照签发地（中文）	passportCityC
		IfilentryEntryInfo.setPassportCityF(entryInfo.getPassportCityF());//护照签发地（拼音）	passportCityF
		IfilentryEntryInfo.setWorkSuffer(entryInfo.getWorkSuffer());//工作经验	workSuffer
		IfilentryEntryInfo.setQuProf(entryInfo.getQuProf());// 指标工种
		IfilentryEntryInfo.setPmtProfFr(entryInfo.getPmtProfFr());//指标工种法文	pmtProfFr
		IfilentryEntryInfo.setFatherName(entryInfo.getFatherName());//父亲姓名	fatherName
		IfilentryEntryInfo.setFatherNameAlphabet(entryInfo.getFatherNameAlphabet());//父亲姓名拼音	fatherNameAlphabet
		IfilentryEntryInfo.setMotherName(entryInfo.getMotherName());//母亲姓名	motherName
		IfilentryEntryInfo.setMotherNameAlphabet(entryInfo.getMotherNameAlphabet());//母亲姓名拼音	motherNameAlphabet
		IfilentryEntryInfo.setMaritalStatus(entryInfo.getMaritalStatus());//婚姻状态	MaritalStatus
		IfilentryEntryInfo.setLaborSignNo(entryInfo.getLaborSignNo());//劳动局返签号	laborSignNo
		IfilentryEntryInfo.setAntiSgTime(entryInfo.getAntiSgTime());//返签生效时间	antiSgTime
		IfilentryEntryInfo.setDocUpDate(entryInfo.getDocUpDate());//返签批件上传时间	docUpDate
		IfilentryEntryInfo.setDocAffiliated(entryInfo.isDocAffiliated());//返签批件挂靠人	docAffiliated
		IfilentryEntryInfo.setVgetTime(entryInfo.getVgetTime());//签证资料收到时间	vgetTime
		IfilentryEntryInfo.setVSentTime(entryInfo.getVSentTime());//签证送签时间	vSentTime
		IfilentryEntryInfo.setVcompTime(entryInfo.getVcompTime());//签证办理完成时间
		IfilentryEntryInfo.setVisaNum(entryInfo.getVisaNum());//签证号码	visaNum
		IfilentryEntryInfo.setVsTime(entryInfo.getVsTime());//签证签发日期	vsTime
		IfilentryEntryInfo.setSignNum(entryInfo.getSignNum());//第几次报签	signNum
		IfilentryEntryInfo.setAuthType(entryInfo.getAuthType());//公证认证类型	authType
		IfilentryEntryInfo.setCopies(entryInfo.getCopies());//份数	copies
		IfilentryEntryInfo.setCoupleName(entryInfo.getCoupleName());//配偶姓名	coupleName
		IfilentryEntryInfo.setCoupleNameAlphabet(entryInfo.getCoupleNameAlphabet());//配偶姓名拼音	coupleNameAlphabet
		IfilentryEntryInfo.setCoupleBirthDate(entryInfo.getCoupleBirthDate());//配偶出生日期	coupleBirthDate
		IfilentryEntryInfo.setCoupleBirthPlace(entryInfo.getCoupleBirthPlace());//配偶出生地	coupleBirthPlace
		IfilentryEntryInfo.setCoupleNational(entryInfo.getCoupleNational());//配偶国籍	coupleNational
		IfilentryEntryInfo.setCoupleWorkPlace(entryInfo.getCoupleWorkPlace());//配偶工作单位或项目	coupleWorkPlace
		IfilentryEntryInfo.setContactway(entryInfo.getContactway());//国内联系方式（手机号）	contactway
		IfilentryEntryInfo.setResidence(entryInfo.getResidence());//国内联系详细地址（省市县）	residence
		IfilentryEntryInfo.setActproff(entryInfo.getActproff());//实际专业或工种	actproff
		IfilentryEntryInfo.setSourceEntryID(entryInfo.getId().toString());//来源分录
		IfilentryEntryInfo.setPersonID(entryInfo.getPersonID());//人员id
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
			for(int i=0;i<boaCol.size();i++){
				BoAttchAssoInfo boaInfo = boaCol.get(i);
				//添加附件
				BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
				newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
				newBoaInfo.setBoID(IfilentryEntryInfo.getId().toString());//业务ID：违规入境分录ID
				newBoaInfo.setAssoType("系统已有附件");//类型
				newBoaInfo.setAttachment(boaInfo.getAttachment());//附件
				newBoaInfo.setAssoBusObjType("C23A32B1");//关联业务对象的类型：违规入境分录BOSTYPE
				boaFac.addnew(newBoaInfo);
			}
		}
		ascInfo.getEntrys().add(IfilentryEntryInfo);
		IfilentryFactory.getLocalInstance(ctx).addnew(ascInfo);
	}
	// 反审核删除违规入境中的数据
	public void deleteViol(Context ctx, String ids)throws BOSException, EASBizException {
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", ids));
		IfilentryFactory.getLocalInstance(ctx).delete(filter);

	}
	/**
	 * 更新人员信息表的人员状态
	 * 
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void updatePerHis(Context ctx,ImmigrationEntryInfo entryInfo,boolean isStop, boolean audMark) throws BOSException, EASBizException {
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		//filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
		//filter.getFilterItems().add(new FilterItemInfo("passportNo", passportNo));
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId",entryInfo.getPersonID()));
		view.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("bsnisState");
		sic.add("hBsnisState");
		PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
		for(int i=0;i<personCol.size();i++){//正常状态
			PersonHistoryInfo newper =personCol.get(i);
			perBizStateEnum hState = newper.getHBsnisState();
			newper.setHBsnisState(newper.getBsnisState());
//			if (isStop) {
//				newper.setBsnisState(audMark ? perBizStateEnum.IMMIGRATIONSTOP : hState);
//			}
			newper.setBsnisState(audMark ? perBizStateEnum.IMMIGRATION : perBizStateEnum.VISA);
			PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
		}
	}
	
	/**
	 * 更改指标数量
	 * 
	 * @param ctx
	 * @param id
	 * @param isAudit
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void writeProjectWork(Context ctx, String id, boolean audMark)
			throws EASBizException, BOSException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("useAmount");
		sic.add("leftAmount");
		sic.add("totalAmount");
		if (id != null && !"".equals(id)) {
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx)
					.getProjectWorkInfo(new ObjectUuidPK(id), sic);
			if (audMark) {//非正常状态，审核通过，释放指标，工种使用数量减一
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			} else {//非正常状态，反审核通过，释放指标，工种使用数量加一
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount()- pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}
		
	}
}