/**
 */
package com.kingdee.eas.zjlw.personmess.client;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.util.EASResource;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;


import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.person.Genders;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

import com.kingdee.eas.zjlw.baseinfo.BlackListCollection;
import com.kingdee.eas.zjlw.baseinfo.BlackListFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaFactory;
import com.kingdee.eas.zjlw.personmess.BusinessVisaInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class BusinessVisaEditUI extends AbstractBusinessVisaEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BusinessVisaEditUI.class);
    public static Map cityCodes = new HashMap();//省份代码
    public static Map cityCodesFrance = new HashMap();//省份代码法文
    /**
     * output class constructor
     */
    public BusinessVisaEditUI() throws Exception
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
    public void onLoad() throws Exception {
    	super.onLoad();
    	setButtonStatus();
    	//省份代码集合
		cityCodes.put("11", "北京");
		cityCodes.put("12", "天津");
		cityCodes.put("13", "河北");
		cityCodes.put("14", "山西");
		cityCodes.put("15", "内蒙古");
		cityCodes.put("21", "辽宁");
		cityCodes.put("22", "吉林");
		cityCodes.put("23", "黑龙江");
		cityCodes.put("31", "上海");
		cityCodes.put("32", "江苏");
		cityCodes.put("33", "浙江");
		cityCodes.put("34", "安徽");
		cityCodes.put("35", "福建");
		cityCodes.put("36", "江西");
		cityCodes.put("37", "山东");
		cityCodes.put("41", "河南");
		cityCodes.put("42", "湖北");
		cityCodes.put("43", "湖南");
		cityCodes.put("44", "广东");
		cityCodes.put("45", "广西");
		cityCodes.put("46", "海南");
		cityCodes.put("50", "重庆");
		cityCodes.put("51", "四川");
		cityCodes.put("52", "贵州");
		cityCodes.put("53", "云南");
		cityCodes.put("54", "西藏");
		cityCodes.put("61", "陕西");
		cityCodes.put("62", "甘肃");
		cityCodes.put("63", "青海");
		cityCodes.put("64", "宁夏");
		cityCodes.put("65", "新疆");
		cityCodes.put("71", "台湾");
		cityCodes.put("81", "香港");
		cityCodes.put("82", "澳门");
		cityCodes.put("91", "国外");
		//省份代码法文集合
		cityCodesFrance.put("11", "BEIJING ");
		cityCodesFrance.put("12", "TIANJING");
		cityCodesFrance.put("13", "HEBEI");
		cityCodesFrance.put("14", "SHANXI");
		cityCodesFrance.put("15", "NEIMONGOL");
		cityCodesFrance.put("21", "LIAONING");
		cityCodesFrance.put("22", "JILIN");
		cityCodesFrance.put("23", "HEILONGJIANG");
		cityCodesFrance.put("31", "SHANGHAI");
		cityCodesFrance.put("32", "JIANGSU");
		cityCodesFrance.put("33", "ZHEJIANG");
		cityCodesFrance.put("34", "ANHUI");
		cityCodesFrance.put("35", "FUJIAN");
		cityCodesFrance.put("36", "JIANGXI");
		cityCodesFrance.put("37", "SHANDONG");
		cityCodesFrance.put("41", "HENAN");
		cityCodesFrance.put("42", "HUBEI");
		cityCodesFrance.put("43", "HUNAN");
		cityCodesFrance.put("44", "GUANGDONG");
		cityCodesFrance.put("45", "GUANGXI");
		cityCodesFrance.put("46", "HAINAN");
		cityCodesFrance.put("50", "CHONGQING");
		cityCodesFrance.put("51", "SICHUAN");
		cityCodesFrance.put("52", "GUIZHOU");
		cityCodesFrance.put("53", "YUNNAN");
		cityCodesFrance.put("54", "TIBET");
		cityCodesFrance.put("61", "SHAANXI");
		cityCodesFrance.put("62", "GANSU");
		cityCodesFrance.put("63", "QINGHAI");
		cityCodesFrance.put("64", "NINGXIA");
		cityCodesFrance.put("65", "XINJIANG");
		cityCodesFrance.put("71", "TAIWAN");
		cityCodesFrance.put("81", "HONGKONG");
		cityCodesFrance.put("82", "MACAO");
		cityCodesFrance.put("91", "ABROAD");
		checkNameCity();
        //kdtEntrys.getColumn("").getStyleAttributes().setLocked(true);
    };
    protected void checkNameCity() throws ParseException{
		int rowCount=kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row =kdtEntrys.getRow(i);
			if(row.getCell("idNum").getValue()!=null){
				String idNum = row.getCell("idNum").getValue().toString();
				String regex="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";//十八位身份证格式
				boolean tf=idNum.matches(regex);
				if(tf){
					if(row.getCell("birthdate").getValue()==null){
						//身份证号获取出生日期、性别、省份
						String yy1 = idNum.substring(6,10);//出生的年份
						String mm1 = idNum.substring(10,12);//出生的月份
						String dd1 = idNum.substring(12,14);//出生的日期
						String sex = idNum.substring(16, 17);//性别
						String birthday = yy1.concat("-").concat(mm1).concat("-").concat(dd1);
						DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						Date date = sdf.parse(birthday);
						row.getCell("birthdate").setValue(date);
						if(Integer.parseInt(sex)%2==0){
							row.getCell("sex").setValue(Genders.Female);
						}else{
							row.getCell("sex").setValue(Genders.Male);
						}
						row.getCell("birthPlaceCn").setValue(cityCodes.get(idNum.substring(0, 2)));//出生地中文
						row.getCell("birthPlaceFr").setValue(cityCodesFrance.get(idNum.substring(0, 2)));//出生地法文
					}
				}
		    }
		}
	}
    protected void setButtonStatus() {
    	BusinessVisaInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(true);
			this.actionUnAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);

			bill = (BusinessVisaInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())) {// (BillStateEnum.SIGNE.equals(bill.getBillSate()))
					this.actionUnAudit.setVisible(true);
					this.actionUnAudit.setEnabled(true);
					this.actionAudit.setVisible(false);
					this.actionAudit.setEnabled(false);
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					this.actionUnAudit.setVisible(false);
					this.actionUnAudit.setEnabled(false);
					this.actionAudit.setVisible(true);
					this.actionAudit.setEnabled(true);
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}

			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (BusinessVisaInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)
					&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}

			this.actionAudit.setVisible(false);
			this.actionUnAudit.setVisible(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
		}
		if (((this.editData != null) && (BillStateEnum.CHECKED.equals(bill
				.getBillSate())))
				|| ("ADDNEW".equalsIgnoreCase(getOprtState()))) {
			this.actionPrint.setEnabled(false);
			this.actionPrintPreview.setEnabled(false);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}

		if (this.editData != null) {
			bill = (BusinessVisaInfo) this.editData;
			if (!(BillStateEnum.DRAFT.equals(bill.getBillSate()))) {
				this.actionAuditResult.setEnabled(true);
				this.actionMultiapprove.setEnabled(true);
				this.actionNextPerson.setEnabled(true);
				this.actionWorkflowList.setEnabled(true);

				this.actionAuditResult.setVisible(true);
				this.actionMultiapprove.setVisible(true);
				this.actionNextPerson.setVisible(true);
				this.actionWorkflowList.setVisible(true);
			} else {
				this.actionAuditResult.setEnabled(false);
				this.actionMultiapprove.setEnabled(false);
				this.actionNextPerson.setEnabled(false);
				this.actionWorkflowList.setEnabled(false);

				this.actionAuditResult.setVisible(false);
				this.actionMultiapprove.setVisible(false);
				this.actionNextPerson.setVisible(false);
				this.actionWorkflowList.setVisible(false);
			}

		}
    }
    protected void kdtEntrys_editStopped(KDTEditEvent e) throws Exception {
		Object oldValue = e.getOldValue();
		Object newValue = e.getValue();

		if (EcClientHelper.isEqual(oldValue, newValue)) {
			return;
		}
		KDTable tblDetail = (KDTable) e.getSource();
		int colIndex = e.getColIndex();
		int rowIndex = e.getRowIndex();
		tblDetail.putUserProperty("INIT_USERPROPERTIES", Boolean.TRUE);
		Map scaleMap = (Map) tblDetail.getUserProperty("TABLE_SCALE_MAP");
		if (null != scaleMap) {
			Set columnNameSet = scaleMap.keySet();
			String key = tblDetail.getColumnKey(colIndex);
			if ((columnNameSet.contains(key))&& (((oldValue==newValue ||0==EcClientHelper.compareValue(oldValue,newValue))))) {
				return;
			}
		}
		afterEditStopped(tblDetail, oldValue, newValue, colIndex, rowIndex);
	}
	protected void afterEditStopped(KDTable table, Object oldValue,Object newValue, int colIndex, int rowIndex) throws Exception {
		String key = table.getColumn(colIndex).getKey();
		IRow row = table.getRow(rowIndex);
		//不能选择同一身份证号
		if ("idNum".equals(key)){
			if(row.getCell("idNum").getValue()!=null){
				String idNum = row.getCell("idNum").getValue().toString();
				String regex="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";//十八位身份证格式
				boolean tf=idNum.matches(regex);
        		if(!tf){
        			MsgBox.showInfo("身份证格式错误，请重新输入！");
        			row.getCell("idNum").setValue(null);
        			this.abort();
        		}
        		//不允许重复填写
        		int rowCount = kdtEntrys.getRowCount();
    			for(int i=0;i<rowCount;i++){
    				IRow row1 = kdtEntrys.getRow(i);
    				if(i!=rowIndex ){
    					if(row1.getCell("idNum").getValue()!=null){
    						String idNum2 = row1.getCell("idNum").getValue().toString();
    						if(row.getCell("idNum").getValue()!=null){
    							String idNum1 = row.getCell("idNum").getValue().toString();
    							if(idNum2.equals(idNum1)){
    								MsgBox.showInfo("已存在此身份证号数据，请重新输入！");
    								row.getCell("idNum").setValue(null);
    								this.abort();
    							}
    						}
    					}
    				}
    			}
    			//身份证号获取出生日期、性别、省份
				String yy1 = idNum.substring(6,10);//出生的年份
		        String mm1 = idNum.substring(10,12);//出生的月份
				String dd1 = idNum.substring(12,14);//出生的日期
				String sex = idNum.substring(16, 17);//性别
				String birthday = yy1.concat("-").concat(mm1).concat("-").concat(dd1);
				DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(birthday);
				row.getCell("birthdate").setValue(date);
				if(Integer.parseInt(sex)%2==0){
					row.getCell("sex").setValue(Genders.Female);
				}else{
					row.getCell("sex").setValue(Genders.Male);
				}
				row.getCell("birthPlaceCn").setValue(cityCodes.get(idNum.substring(0, 2)));//出生地中文
				row.getCell("birthPlaceFr").setValue(cityCodesFrance.get(idNum.substring(0, 2)));//出生地法文
			}else{
				row.getCell("birthdate").setValue(null);
				row.getCell("birthPlaceCn").setValue(null);
			}
		}
		//不能选择同一护照号
		if ("passportNo".equals(key)){
			int rowCount = kdtEntrys.getRowCount();
			for(int i=0;i<rowCount;i++){
				IRow row1 = kdtEntrys.getRow(i);
				if(i!=rowIndex ){
					if(row1.getCell("passportNo").getValue()!=null){
						String passportNo = row1.getCell("passportNo").getValue().toString();
						if(row.getCell("passportNo").getValue()!=null){
							String passportNo1 = row.getCell("passportNo").getValue().toString();
							if(passportNo.equals(passportNo1)){
								MsgBox.showInfo("已存在此护照号数据，请重新输入！");
								row.getCell("passportNo").setValue(null);
								this.abort();
							}
						}
					}
				}
			}
		}
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
    	//只有暂存状态可以保存
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			BusinessVisaInfo fiInfo = BusinessVisaFactory.getRemoteInstance().getBusinessVisaInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!BillStateEnum.DRAFT.equals(fiInfo.getBillSate())){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复保存！");
				abort();
			}
		}
        super.actionSave_actionPerformed(e);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
    	super.actionSubmit_actionPerformed(e);
    }

    protected void doBeforeSubmit(ActionEvent e) throws Exception {
    	//只有暂存或者已提交状态可以提交
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			BusinessVisaInfo fiInfo = BusinessVisaFactory.getRemoteInstance().getBusinessVisaInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!(BillStateEnum.DRAFT.equals(fiInfo.getBillSate())||BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复提交！");
				abort();
			}
		}
    	super.doBeforeSubmit(e);
    	checkEmpty();//不为空校验
    	checkIdNumAndPassp();//提交同一单据重复校验
    	//checkIdNum();//身份证格式校验
    	//checkDate();//时间校验
    	//checkPersion();//提交人员重复问题
    	//checkBlackList();//不合格人员校验
    	//checkPersionHistory();//人员历史信息校验
    }
  //提交同一单据重复校验
    public void checkIdNumAndPassp(){
		int rowCount=kdtEntrys.getRowCount();
		Set set=new HashSet();
		Set pass=new HashSet();
		for(int i=0;i<rowCount;i++){
			IRow row= kdtEntrys.getRow(i);
			String idNum=(String) row.getCell("idNum").getValue();
			String passportNo=(String) row.getCell("passportNo").getValue();
			//String name=(String) row.getCell("name").getValue();
			//校验是否存在集合中
			if(idNum!=null){
				if (set.remove(idNum)) {
					MsgBox.showInfo("身份证号【"+idNum+"】已存在此身份证号数据，请重新输入！");
					abort();
				}	
		    }
			if(passportNo!=null){
				if (pass.remove(passportNo)) {
					MsgBox.showInfo("护照号【"+passportNo+"】已存在此护照号数据，请重新输入！");
					abort();
				}	
		    }
			set.add(idNum);
			pass.add(passportNo);
		}
	}
    //不为空校验
    protected void checkEmpty() throws BOSException{
    	int rowCount=kdtEntrys.getRowCount();
    	if (rowCount == 0) {
			MsgBox.showInfo("未添加人员信息，不允许提交！");
			abort();
		}
    	for(int i=0;i<rowCount;i++){
    	    IRow row=kdtEntrys.getRow(i);
    	    if(row.getCell("name").getValue()==null){
				MsgBox.showInfo("所选行有姓名未输入，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("sex").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】性别为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("birthdate").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】出生日期为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("birthPlaceCn").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】出生地为空，无法提交，请重新填入！");
    			this.abort();
			}
//    		if(row.getCell("national").getValue()==null){
//				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】国籍为空，无法提交，请重新填入！");
//    			this.abort();
//			}
    		if(row.getCell("passportNo").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】护照号码为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("passportIssueDate").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】护照签发日期为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("passportExpireDate").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】护照失效日期为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("cooperation").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】合作单位为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("handleProject").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】办理项目为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("workProgram").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】工作项目为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("contacts").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】国内联系人为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("contactway").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】联系方式为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("arrivalTime").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】预计来阿时间为空，无法提交，请重新填入！");
    			this.abort();
			}
    		if(row.getCell("residenceTime").getValue()==null){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】预计离阿时间为空，无法提交，请重新填入！");
    			this.abort();
			}
    		checkIdNum(row);//身份证号校验
    		checkDate(row); //时间校验
    		checkPersion(row); //提交重复录入校验
    		checkBlackList(row);//不合格人员名单校验
    		checkPersionHistory(row);//人员历史信息校验
    	}
    }
    //身份证号校验
    protected void checkIdNum(IRow row){
	
		String name=(String) row.getCell("name").getValue();
		String idNum=(String) row.getCell("idNum").getValue();
		String passportNo=(String) row.getCell("passportNo").getValue();
		CountryInfo coInfo=(CountryInfo) row.getCell("national").getValue();
		String regex="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";//十八位身份证格式
		if(coInfo==null){
			MsgBox.showInfo("【"+name+"】的国籍为空，请重新填入！");
			this.abort();
		}else {
			if("C01".equals(coInfo.getNumber())){
	    		//String regex="^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";//十五位身份证格式
    			if(idNum==null){
    				MsgBox.showInfo("【"+name+"】的国籍是中国，请填入身份证号！");
        			this.abort();
    			}
    			if(passportNo==null){
    				MsgBox.showInfo("【"+name+"】的护照号为空，请重新填入！");
        			this.abort();
    			}
    			boolean tf=idNum.matches(regex);
        		if(!tf){
        			MsgBox.showInfo("【"+name+"】的身份证格式错误，请重新填入！");
        			this.abort();
        		}
    		}else{
    			if(passportNo==null){
    				MsgBox.showInfo("【"+name+"】的护照号为空，请重新填入！");
        			this.abort();
    			}
    			if(idNum!=null){
    				MsgBox.showInfo("【"+name+"】的国籍是"+coInfo.getName()+"，不需要填入身份证号！");
        			this.abort();
    			    }
    		    }
		    }
    }
    //时间校验
    protected void checkDate(IRow row){
    	long time=0;
    	long time1=0;
    	long time2=0;
    	Date date=new Date();
		Date passportIssueDate=(Date) row.getCell("passportIssueDate").getValue();//护照签发日期
		Date passportExpireDate=(Date) row.getCell("passportExpireDate").getValue();//护照失效日期
		Date arrivalTime=(Date) row.getCell("arrivalTime").getValue();//预计来阿时间
		Date residenceTime=(Date) row.getCell("residenceTime").getValue();//预计离阿时间
		if(passportIssueDate!=null&&passportExpireDate!=null){
			time=(passportExpireDate.getTime()-passportIssueDate.getTime())/86400000;
			time1=(passportExpireDate.getTime()-date.getTime())/86400000;
			if(time<0){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】护照失效日期小于护照签发日期，请重新填写日期！");
    			this.abort();
			}
			if(time1<270){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】护照有效期不足9个月，不允许信息录入！");
    			this.abort();
			}
		}
		if(arrivalTime!=null&&residenceTime!=null){
			time2=residenceTime.getTime()-arrivalTime.getTime();
			if(time2<0){
				MsgBox.showInfo("【"+row.getCell("name").getValue()+"】预计离阿时间小于预计来阿时间，请重新填写日期！");
    			this.abort();
			}
    	}
    }
    //提交校验本单据中是否存在相同人员且单据状态不为审核通过的数据
	public void checkPersion(IRow row) throws BOSException{
//		Set set = new HashSet();
//		Set passportNo = new HashSet();
//		Set personName = new HashSet();
		
//	    set.add(row.getCell("idNum").getValue()==null?"":row.getCell("idNum").getValue());
//		passportNo.add(row.getCell("passportNo").getValue());
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		FilterInfo filterID = new FilterInfo();
		CountryInfo coInfo=(CountryInfo) row.getCell("national").getValue();
		if("C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", row.getCell("idNum").getValue(), CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("passportNo", row.getCell("passportNo").getValue(),CompareType.EQUALS));
			filter.setMaskString("#0 or #1");
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passportNo", row.getCell("passportNo").getValue(),CompareType.EQUALS));
		}
		filterID.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED ,CompareType.NOTEQUALS));
		if(this.editData.getId()!=null){
			filterID.getFilterItems().add(new FilterItemInfo("parent.id",this.editData.getId().toString() ,CompareType.NOTEQUALS));
		}
		filter.mergeFilter(filterID, "and");
		view.setFilter(filter);
		WorkVisaEntryCollection  col=WorkVisaEntryFactory.getRemoteInstance().getWorkVisaEntryCollection(view);
		if (col != null && col.size() > 0) {
			MsgBox.showInfo("所填人员【" + row.getCell("name").getValue() + "】的身份证号或护照号信息存在未审核的单据，不能重复录入 ！");
			this.abort();
		}
		
	}
    //不合格人员名单校验
    protected void checkBlackList (IRow row) throws BOSException{
//    	Set set= new HashSet();
//    	Set passportNo= new HashSet();
//    		set.add(row.getCell("idNum").getValue());
//    		passportNo.add(row.getCell("passportNo").getValue());
		EntityViewInfo view = new EntityViewInfo();
    	FilterInfo filter = new FilterInfo();
    	CountryInfo coInfo=(CountryInfo) row.getCell("national").getValue();
    	if("C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("IdNum", row.getCell("idNum").getValue(), CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("simpleName", row.getCell("passportNo").getValue(),CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("isEffect", true, CompareType.EQUALS));
			filter.setMaskString("(#0 or #1) and #2");
		}else{
			filter.getFilterItems().add(new FilterItemInfo("simpleName", row.getCell("passportNo").getValue(),CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("isEffect", true, CompareType.EQUALS));
		}
		
		//filter.setMaskString("(#0 or #1) and #2");
		view.setFilter(filter);
		BlackListCollection col = BlackListFactory.getRemoteInstance().getBlackListCollection(view);
		if (col != null && col.size() > 0) {
			MsgBox.showInfo("所填人员【" + row.getCell("name").getValue() + "】的身份证号或护照号信息已在不合格人员名单中，不允许提交！ ");
			this.abort();
		}
    	
    	
    }
    //提交时校验人员历史信息中是否有该人员且状态不为离境，则提示不能重复录入且不允许提交
    public void checkPersionHistory(IRow row) throws BOSException{
//    	Set set = new HashSet();
//    	Set simpleName=new HashSet();
//    	Set personName = new HashSet();
//    	EntityViewInfo view = new EntityViewInfo();
//    	FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
    	FilterInfo filter = new FilterInfo();
       	FilterInfo filterID = new FilterInfo();
    	CountryInfo coInfo=(CountryInfo) row.getCell("national").getValue();
    	if("C01".equals(coInfo.getNumber())){
			filterID.getFilterItems().add(new FilterItemInfo("IdNum", row.getCell("idNum").getValue(), CompareType.EQUALS));
			filterID.getFilterItems().add(new FilterItemInfo("passportNo", row.getCell("passportNo").getValue(),CompareType.EQUALS));
			filterID.setMaskString("#0 or #1");
		}else{
			filterID.getFilterItems().add(new FilterItemInfo("passportNo", row.getCell("passportNo").getValue(),CompareType.EQUALS));
		}
    	filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.DEPARTURE,CompareType.NOTEQUALS));// 离境
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.ANTISTOP,CompareType.NOTEQUALS));// 反签停办并注销
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.VISASTOP,CompareType.NOTEQUALS));// 签证停办并注销
		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.CERTISTOP,CompareType.NOTEQUALS));// 双认证停办
		filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.IMMIGRATIONSTOP,CompareType.NOTEQUALS));// 入境停办
		filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTIDSTRY,CompareType.NOTEQUALS));//反签过期或不来
		filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.PASSPORTISSUEDSTOP,CompareType.NOTEQUALS));//护照发放停办
		filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.VISADSTRY,CompareType.NOTEQUALS));//签证过期或不来
		filter.mergeFilter(filterID, "and");
		view.setFilter(filter);
		PersonHistoryCollection col = PersonHistoryFactory.getRemoteInstance().getPersonHistoryCollection(view);
		if (col != null && col.size() > 0) {
//				for (int i = 0; i < col.size(); i++) {
//					PersonHistoryInfo perInfo = col.get(i);
//					personName.add(perInfo.getNameCN());
//				}
			MsgBox.showInfo("所填人员【" + row.getCell("name").getValue() + "】的身份证号或护照号信息正在办理业务，不能重复录入 ");
			this.abort();
		}
    	
    
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
        return com.kingdee.eas.zjlw.personmess.BusinessVisaFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.personmess.BusinessVisaInfo objectValue = new com.kingdee.eas.zjlw.personmess.BusinessVisaInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        this.billSate.setEnabled(false);
        return objectValue;
    }

}