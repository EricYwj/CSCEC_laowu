/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.Color;
import java.awt.event.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.CooprationFactory;
import com.kingdee.eas.zjlw.baseinfo.CooprationInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.visaTypeEnum;
import com.kingdee.eas.zjlw.personmess.LocalInfoCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryFactory;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonEntryCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonInfo;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class InsurePersonEditUI extends AbstractInsurePersonEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(InsurePersonEditUI.class);
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	//修改简体中文和法文编辑界面的单据名称与列表界面名称一致  modified by wangth on 20170628 start
		String strLanguage = com.kingdee.eas.common.client.SysContext.getSysContext().getLocale().getLanguage();
		if("L1".equals(strLanguage) || "l1".equals(strLanguage)){
			setUITitle("");
		}
		else if("L2".equals(strLanguage) || "l2".equals(strLanguage)){
			setUITitle("属地化员工参保名单");
		}
		else{
//			setUITitle("");
		}
		//修改简体中文和法文编辑界面的单据名称与列表界面名称一致  modified by wangth on 20170628 end
    	this.btnRemove.setVisible(false);
    	this.btnCopy.setVisible(false);
    	
    	if (getOprtState().equals("ADDNEW")) {
    		this.pkBizDate.setValue(new Date());
    		initEntry();
//    		//获取合作单位代码
//    		getCoopCode();
    	}
    	
    	if (getOprtState().equals("EDIT")) {
    		this.pkBizDate.setValue(new Date());
    		//初始化单据
    		updateEntry();
//    		//获取合作单位代码
//    		getCoopCode();
    	}
    	
    	addKdtEntryDetailPanelListener();
    	
    	//不可编辑项
    	kdtEntrys.getColumn("lastName").getStyleAttributes().setLocked(true);//姓
    	kdtEntrys.getColumn("firstName").getStyleAttributes().setLocked(true);//名
    	kdtEntrys.getColumn("sex").getStyleAttributes().setLocked(true);//性别
    	kdtEntrys.getColumn("birthdate").getStyleAttributes().setLocked(true);//出生日期
    	kdtEntrys.getColumn("birthPlaceCn").getStyleAttributes().setLocked(true);//出生地
    	kdtEntrys.getColumn("country").getStyleAttributes().setLocked(true);//国籍
    	kdtEntrys.getColumn("MaritalStatus").getStyleAttributes().setLocked(true);//婚姻状况
    	kdtEntrys.getColumn("address").getStyleAttributes().setLocked(true);//家庭住址
    	kdtEntrys.getColumn("CCPNo").getStyleAttributes().setLocked(true);//CCP账户
    	kdtEntrys.getColumn("securityNo").getStyleAttributes().setLocked(true);//社保号
    	kdtEntrys.getColumn("secuProf").getStyleAttributes().setLocked(true);//社保工种
    	kdtEntrys.getColumn("nBasePay").getStyleAttributes().setLocked(true);//基本工资
    	kdtEntrys.getColumn("approachTime").getStyleAttributes().setLocked(true);//进场日期
    	kdtEntrys.getColumn("secuProj").getStyleAttributes().setLocked(true);//社保项目
    	kdtEntrys.getColumn("workProgram").getStyleAttributes().setLocked(true);//工作项目
    	kdtEntrys.getColumn("cooperation").getStyleAttributes().setLocked(true);//合作单位
    	kdtEntrys.getColumn("cooperationId").getStyleAttributes().setLocked(true);//合作单位代码
    	kdtEntrys.getColumn("foriPersID").getStyleAttributes().setLocked(true);//外会人员编码
    	kdtEntrys.getColumn("endDate").getStyleAttributes().setLocked(true);//离场日期
    }
    
    
    /**
     * 添加分录监听事件，实现分录表格默认值
     */
    private void addKdtEntryDetailPanelListener() {
    	IDetailPanelListener listener = new DetailPanelAdapter() {
    		public void beforeEvent(DetailPanelEvent e) throws Exception {
    			setLineValue(e); //设置分录表格的默认值
    		}
    	};
    	kdtEntrys_detailPanel.addAddListener(listener);//模板增加监听
    }
    
    /**
     * 实现IDetailPanelListener接口
     */
    private static class DetailPanelAdapter implements IDetailPanelListener {
	  public DetailPanelAdapter() {}
	  public void beforeEvent(DetailPanelEvent e) throws Exception {}
	  public void afterEvent(DetailPanelEvent e) throws Exception {}
    }
    /**
     * 新增一行的时候，设置默认值
     */
    private void setLineValue(DetailPanelEvent e) {
    	InsurePersonEntryInfo insEntryInfo = (InsurePersonEntryInfo) e.getObjectValue(); //获取分录对象
    	insEntryInfo.setJoin(true);
    }
    
    
	/**
     * 初始化单据
     * @throws BOSException 
     * @throws EASBizException 
     */
    public void initEntry() throws EASBizException, BOSException {
    	LocalInfoEntryCollection localCol = getLocal();
    	for (int i = 0; i < localCol.size(); i++) {
    		LocalInfoEntryInfo localEInfo = localCol.get(i);
    		init(localEInfo);
		}
	}
    
    /**
     * 编辑时更新分录
     * @throws BOSException 
     * @throws EASBizException 
     */
    private void updateEntry() throws EASBizException, BOSException {
    	//用社保号校验是否重复
    	AdminOrgUnitInfo prmtInfo = (AdminOrgUnitInfo) this.prmtpermitOrg.getValue();
    	FilterInfo filter = new FilterInfo();
    	filter.getFilterItems().add(new FilterItemInfo("parent.permitOrg.id",prmtInfo.getId()));
    	EntityViewInfo view = new EntityViewInfo();
    	view.setFilter(filter);
    	Set fpSCNumSet = new HashSet();
    	InsurePersonEntryCollection foriPersCol = InsurePersonEntryFactory.getRemoteInstance().getInsurePersonEntryCollection(view);
		if (foriPersCol != null && foriPersCol.size() > 0) {
			for (int i = 0; i < foriPersCol.size(); i++) {
				InsurePersonEntryInfo foriPersInfo = foriPersCol.get(i);
				fpSCNumSet.add(foriPersInfo.getPersonID());
			}
		}
		LocalInfoEntryCollection localCol = getLocal();
		if (localCol != null && localCol.size() > 0) {
			for (int i = 0; i < localCol.size(); i++) {
				LocalInfoEntryInfo localInfo = localCol.get(i);
				if (!fpSCNumSet.contains(localInfo.getId().toString())) {
					//向参保人员名单中添加该条数据
					init(localInfo);
				}
			}
		}
	}

    /**
     * 单条分录赋值
     * @param localEInfo
     * @throws EASBizException
     * @throws BOSException
     */
	private void init(LocalInfoEntryInfo localEInfo) throws EASBizException, BOSException {
		IRow row = this.kdtEntrys.addRow();
		AdminOrgUnitInfo workOrg=new AdminOrgUnitInfo();
		AdminOrgUnitInfo secuProj=new AdminOrgUnitInfo();
		AdminOrgUnitInfo cooperation=new AdminOrgUnitInfo();
		if(localEInfo.getWorkProgram()!=null){
			workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(localEInfo.getWorkProgram().getId()));
		}
		if(localEInfo.getSecuProj()!=null){
			secuProj = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(localEInfo.getSecuProj().getId()));
		}
		if(localEInfo.getCooperation()!=null){
			cooperation = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(localEInfo.getCooperation().getId()));
		}
		if (secuProj != null) {
			FilterInfo filter = new FilterInfo();
			EntityViewInfo view = new EntityViewInfo();
			SelectorItemCollection sic = new SelectorItemCollection();
			filter.getFilterItems().add(new FilterItemInfo("proCom.id", secuProj == null ? null : secuProj.getId()));
			sic.add("insuranceAcc");
			view.setFilter(filter);
			view.setSelector(sic);
			ProjectOrgInfo projOInfo = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view).get(0);
			if(projOInfo!=null){
				row.getCell("projSocialNo").setValue(projOInfo.getInsuranceAcc());
			}
		}
//		ProvinceInfo priv = ProvinceFactory.getRemoteInstance().getProvinceInfo(new ObjectUuidPK(localEInfo.getProvinces()==null?null:localEInfo.getProvinces().getId()));
		ProjSecuProfInfo projInfo=new ProjSecuProfInfo();
		if(localEInfo.getSecuProf()!=null){
			projInfo = ProjSecuProfFactory.getRemoteInstance().getProjSecuProfInfo(new ObjectUuidPK(localEInfo.getSecuProf().getId()));

		}
		row.getCell("personID").setValue(localEInfo.getId());//人员主键
		row.getCell("firstName").setValue(localEInfo.getFirstName());//姓	
		row.getCell("lastName").setValue(localEInfo.getLastName());//名	
		row.getCell("sex").setValue(localEInfo.getSex());//性别
		row.getCell("birthdate").setValue(localEInfo.getBirthdate());//出生日期
		if(localEInfo.getCountry()!=null){
			CountryInfo country = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(localEInfo.getCountry()==null?null:localEInfo.getCountry().getId()));
			row.getCell("country").setValue(country);//国籍
		}
		
		if(localEInfo.getBirthPlaceF()!=null){
			ProvinceInfo provInfo = ProvinceFactory.getRemoteInstance().getProvinceInfo(new ObjectUuidPK(localEInfo.getBirthPlaceF().getId()));
			row.getCell("birthPlaceCn").setValue(provInfo.getName());//出生地	
		}
		row.getCell("MaritalStatus").setValue(localEInfo.getMaritalStatus());//婚姻状况
		row.getCell("securityNo").setValue(localEInfo.getSecurityNo());//社保号码
		row.getCell("workProgram").setValue(workOrg);//工作项目
		row.getCell("cooperation").setValue(cooperation);//合作单位
		row.getCell("secuProj").setValue(secuProj);//社保项目
		row.getCell("secuProf").setValue(projInfo);//工种
		row.getCell("nBasePay").setValue(localEInfo.getNBasePay());//基本工资
//		row.getCell("priv").setValue(priv);//家庭所在省份
		row.getCell("address").setValue(localEInfo.getAddress());//家庭住址	
		row.getCell("CCPNo").setValue(localEInfo.getCCPNo());//CCP账户	
		/**
		 * 合作单位代码获取：
		 * 		1.为中建自招人员：
		 * 			a.已维护“中建管理人员”合作单位，number为CSCEC；
		 * 			b.若为中建自招，则合作单位代码为工作项目的number；
		 * 		2.其他正常人员；
		 * 			a.合作单位代码即为cooperation.number;
		 */
		if ("HCSCEC".equals(localEInfo.getCooperationId())) {
			row.getCell("cooperationId").setValue(workOrg.getNumber());
		}else{
			row.getCell("cooperationId").setValue(cooperation.getNumber());//合作单位代码
		}
//		row.getCell("contrachSigDate").setValue(localEInfo.getContrachSigDate());//合同签订日期
//		row.getCell("contractTime").setValue(localEInfo.getContractTime());//合同到期日期	
		row.getCell("foriPersID").setValue(localEInfo.getForiPersID());//外会人员编码
		row.getCell("join").setValue(true);//是否参保
		row.getCell("endDate").setValue(localEInfo.getEndDate());
		row.getCell("approachTime").setValue(localEInfo.getApproachTime());//机票时间
		//2019-8-8 新增 ywj
		row.getCell("IDNumber").setValue(localEInfo.getIDNumber());//身份证号码
		row.getCell("birthIDNumber").setValue(localEInfo.getBirthIDNumber());//出生证明号码
	}


    /**
     * 获取属地化数据
     * @return 
     * @throws BOSException 
     * @throws EASBizException 
     */
	private LocalInfoEntryCollection getLocal() throws EASBizException, BOSException {
		AdminOrgUnitInfo permitInfo = (AdminOrgUnitInfo) this.prmtpermitOrg.getValue();
//		FullOrgUnitInfo fullInfo= (FullOrgUnitInfo) getUIContext().get("projectOrgInfo");
		AdminOrgUnitInfo pmtInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(permitInfo==null?null:permitInfo.getId()));
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
        SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		filter.getFilterItems().add(new FilterItemInfo("secuProj.id",pmtInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
		view.setFilter(filter);
		view.setSelector(sic);
		LocalInfoEntryCollection persHisCol = LocalInfoEntryFactory.getRemoteInstance().getLocalInfoEntryCollection(view);
		if (persHisCol.size() == 0) {
			MsgBox.showInfo("所选项目暂无属地化员工！");
			abort();
		}
		return persHisCol;
	}

//	/**
//     * 获取合作单位代码
//     * @throws BOSException 
//     */
//    private void getCoopCode() throws BOSException {
//    	InsurePersonInfo insInfo = this.editData;
//    	if (insInfo != null) {
//    		InsurePersonEntryInfo insEntryInfo = insInfo.getEntrys().get(0);
//        	FilterInfo filter = new FilterInfo();
//        	SelectorItemCollection sic = new SelectorItemCollection();
//        	EntityViewInfo view = new EntityViewInfo();
//        	filter.getFilterItems().add(new FilterItemInfo("proCom",insEntryInfo.getCooperation() == null ? null : insEntryInfo.getCooperation().getId()));
//        	sic.add("number");
//        	view.setFilter(filter);
//        	view.setSelector(sic);
//        	CooprationInfo coopInfo = CooprationFactory.getRemoteInstance().getCooprationCollection(view).get(0);
//        	insEntryInfo.setCooperationId(coopInfo == null ? null : coopInfo.getNumber());
//		}
//	}

	/**
     * output class constructor
     */
    public InsurePersonEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
    }

    /**
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
    }

    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

    /**
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
    }
    
    protected void doBeforeSave(ActionEvent e) throws Exception {
    	super.doBeforeSave(e);
    	int count = this.kdtEntrys.getRowCount();
    	for (int i = 0; i < count; i++) {
    		long time0=0;
			IRow row = this.kdtEntrys.getRow(i);
			Date secuRegDate=(Date) row.getCell("secuRegDate").getValue();//社保注册时间
    		Date approachTime=(Date) row.getCell("approachTime").getValue();//进场时间
    		if(secuRegDate != null && approachTime != null){
    			time0=(secuRegDate.getTime()-approachTime.getTime())/86400000;
    			//红色预警：社保注册时间-进场时间>10天
    			if(time0<0){
    				MsgBox.showInfo("第"+i+"行，数据填写错误，社保注册时间不可早于进场时间！");
    				abort();
    			}
    		}
		}
    	
    }
    
    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionFirst_actionPerformed
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }

    /**
     * output actionPre_actionPerformed
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }

    /**
     * output actionNext_actionPerformed
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }

    /**
     * output actionLast_actionPerformed
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
        updateEntry();
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionSubmitOption_actionPerformed
     */
    public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmitOption_actionPerformed(e);
    }

    /**
     * output actionReset_actionPerformed
     */
    public void actionReset_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReset_actionPerformed(e);
    }

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output actionAddLine_actionPerformed
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }

    /**
     * output actionCopyLine_actionPerformed
     */
    public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyLine_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionRemoveLine_actionPerformed
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }

    /**
     * output actionCreateFrom_actionPerformed
     */
    public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateFrom_actionPerformed(e);
    }

    /**
     * output actionCopyFrom_actionPerformed
     */
    public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyFrom_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
    }

    /**
     * output actionTraceUp_actionPerformed
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }

    /**
     * output actionTraceDown_actionPerformed
     */
    public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceDown_actionPerformed(e);
    }

    /**
     * output actionViewSubmitProccess_actionPerformed
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
    }

    /**
     * output actionViewDoProccess_actionPerformed
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }

    /**
     * output actionMultiapprove_actionPerformed
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }

    /**
     * output actionNextPerson_actionPerformed
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionVoucher_actionPerformed
     */
    public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionVoucher_actionPerformed(e);
    }

    /**
     * output actionDelVoucher_actionPerformed
     */
    public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelVoucher_actionPerformed(e);
    }

    /**
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionSendingMessage_actionPerformed
     */
    public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendingMessage_actionPerformed(e);
    }

    /**
     * output actionSignature_actionPerformed
     */
    public void actionSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSignature_actionPerformed(e);
    }

    /**
     * output actionWorkflowList_actionPerformed
     */
    public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkflowList_actionPerformed(e);
    }

    /**
     * output actionViewSignature_actionPerformed
     */
    public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSignature_actionPerformed(e);
    }

    /**
     * output actionSendMail_actionPerformed
     */
    public void actionSendMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMail_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionNumberSign_actionPerformed
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.social.InsurePersonFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.social.InsurePersonInfo objectValue = new com.kingdee.eas.zjlw.social.InsurePersonInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        FullOrgUnitInfo fullInfo= (FullOrgUnitInfo) getUIContext().get("projectOrgInfo");
        SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("number"));
		sic.add(new SelectorItemInfo("name"));
        try {
			AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fullInfo.getId()), sic);
			objectValue.setPermitOrg(adminInfo);
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}

        return objectValue;
    }

}