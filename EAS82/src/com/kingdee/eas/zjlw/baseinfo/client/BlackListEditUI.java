/**
 * output package name
 */
package com.kingdee.eas.zjlw.baseinfo.client;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.BlackListCollection;
import com.kingdee.eas.zjlw.baseinfo.BlackListFactory;
import com.kingdee.eas.zjlw.baseinfo.BlackListInfo;

/**
 * output class name
 */
public class BlackListEditUI extends AbstractBlackListEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BlackListEditUI.class);
    
    /**
     * output class constructor
     */
    public BlackListEditUI() throws Exception
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
    public static boolean isInteger(String str) {    
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
        return pattern.matcher(str).matches();    
      }  
    //身份证值改变事件
    protected void txtIdNum_vetoableChange(PropertyChangeEvent e)
    		throws Exception {
    	if(e.getNewValue()!=null){
    		String idNum = txtIdNum.getText();
    		String regex="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";//十八位身份证格式
    		boolean tf=idNum.matches(regex);
    		if(!tf){
    			MsgBox.showInfo("身份证号格式错误，请重新填入！");
    			this.abort();
    		}
    		//身份证号获取出生日期
			String yy1 = idNum.substring(6,10);//出生的年份
	        String mm1 = idNum.substring(10,12);//出生的月份
			String dd1 = idNum.substring(12,14);//出生的日期
			String birthday = yy1.concat("-").concat(mm1).concat("-").concat(dd1);
			DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(birthday);
			pkbirthyDate.setValue(date);
    	}else{
    		pkbirthyDate.setValue(null);
    	}
    }
    protected void txtIdNum_(PropertyChangeEvent e)
    		throws Exception {
    	super.txtIdNum_propertyChange(e);
    	
    }
    /**
     * 保存时，验证是否有相同身份证号
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception{
    	checkNumbers();
        super.actionSave_actionPerformed(e);
    }
    
    /**
     * 【身份证、护照号以及社保号为空校验】
     * 
     * @throws BOSException
     */
    private void checkNumbers() throws BOSException {
    	String idnum = txtIdNum.getText();
    	String ppNum = txtSimpleName.getText();
    	String securityNo = txtsecurityNo.getText();
    	EntityViewInfo view = new EntityViewInfo();
    	FilterInfo filter = new FilterInfo();
    	//xr 2016-10-10
//    	if(txtName.getSelectedItemData()==null||"".equals(txtName.getSelectedItemData())){
//    		MsgBox.showInfo("姓名不允许为空！");
//    		this.abort();
//    	}
//    	if(txtSimpleName.getText()==null||"".equals(txtSimpleName.getText())){
//    		MsgBox.showInfo("护照号不允许为空！");
//    		this.abort();
//    	}
//    	if(pkeffectDate.getValue()==null){
//    		MsgBox.showInfo("加入日期不允许为空！");
//    		this.abort();
//    	}
//    	if(txtDescription.getSelectedItemData()==null||"".equals(txtDescription.getSelectedItemData())){
//    		MsgBox.showInfo("加入理由不允许为空！");
//    		this.abort();
//    	}
//    	if(pkbirthyDate.getValue()==null){
//    		MsgBox.showInfo("出生日期不允许为空！");
//    		this.abort();
//    	}
//    	if (this.prmtcountry.getValue() == null) {
//    		MsgBox.showInfo("国籍不允许为空！");
//    		this.abort();
//		}
    	CountryInfo coInfo = (CountryInfo)this.prmtcountry.getValue();
    	if (coInfo != null && "C01".equals(coInfo.getNumber())) {
			if ("".equals(idnum)||idnum==null) {
				MsgBox.showInfo("中国籍人员必须录入身份证号！");
	    		this.abort();
			}
			filter.getFilterItems().add(new FilterItemInfo("IdNum", idnum));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("simpleName", ppNum));
		}
    	if(this.editData!=null && this.editData.getId()!=null){
    		filter.getFilterItems().add(new FilterItemInfo("id", this.editData.getId().toString(),CompareType.NOTEQUALS));
    	}
    	view.setFilter(filter);
    	BlackListCollection col = BlackListFactory.getRemoteInstance().getBlackListCollection(view);
    	if(col!=null && col.size()>0){
    		MsgBox.showInfo("已存在身份证号或护照号相同的人员，不允许重复添加！");
    		this.abort();
    	}
	}
    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
//    	BlackListInfo info = this.editData;
//    	String id = info.getIdNum();//身份证号码
//    	String passpNum = info.getSimpleName();//护照号
//    	String secNum = info.getSecurityNo();//社保号
//    	FilterInfo filter = new FilterInfo();
//    	filter.getFilterItems().add(new FilterItemInfo("IdNum",id));
//    	filter.getFilterItems().add(new FilterItemInfo("securityNo",secNum));
//    	filter.getFilterItems().add(new FilterItemInfo("simpleName",passpNum));
//    	filter.setMaskString("#0 OR #1 OR #2");
//    	EntityViewInfo view = new EntityViewInfo();
//    	view.setFilter(filter);
//    	BlackListCollection col = BlackListFactory.getRemoteInstance().getBlackListCollection(view);
//    	if (col != null) {
//			MsgBox.showInfo("不合格人员名单中已存在该人员，不允许重复添加！");
//			abort();
//		}
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
    	//校验新添加的人原是否已经存在
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.baseinfo.BlackListFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.baseinfo.BlackListInfo objectValue = new com.kingdee.eas.zjlw.baseinfo.BlackListInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setEffectDate(new Date());
        objectValue.setIsEffect(true);
        return objectValue;
    }

}