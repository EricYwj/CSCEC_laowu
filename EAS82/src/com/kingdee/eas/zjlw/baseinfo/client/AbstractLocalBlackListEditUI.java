/**
 * output package name
 */
package com.kingdee.eas.zjlw.baseinfo.client;

import org.apache.log4j.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.event.*;
import javax.swing.KeyStroke;

import com.kingdee.bos.ctrl.swing.*;
import com.kingdee.bos.ctrl.kdf.table.*;
import com.kingdee.bos.ctrl.kdf.data.event.*;
import com.kingdee.bos.dao.*;
import com.kingdee.bos.dao.query.*;
import com.kingdee.bos.metadata.*;
import com.kingdee.bos.metadata.entity.*;
import com.kingdee.bos.ui.face.*;
import com.kingdee.bos.ui.util.ResourceBundleHelper;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.swing.event.*;
import com.kingdee.bos.ctrl.kdf.table.event.*;
import com.kingdee.bos.ctrl.extendcontrols.*;
import com.kingdee.bos.ctrl.kdf.util.render.*;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.appframework.client.servicebinding.ActionProxyFactory;
import com.kingdee.bos.appframework.uistatemanage.ActionStateConst;
import com.kingdee.bos.appframework.validator.ValidateHelper;
import com.kingdee.bos.appframework.uip.UINavigator;


/**
 * output class name
 */
public abstract class AbstractLocalBlackListEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractLocalBlackListEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsocialNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprovince;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjoinTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreason;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisDisable;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdisableTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcountry;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbirthyDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcooperation;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsocialNo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprovince;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkjoinTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtreason;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkdisableTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcountry;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbirthyDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcooperation;
    protected com.kingdee.eas.zjlw.baseinfo.LocalBlackListInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractLocalBlackListEditUI() throws Exception
    {
        super();
        this.defaultObjectName = "editData";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractLocalBlackListEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsocialNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprovince = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjoinTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreason = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisDisable = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contdisableTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcountry = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbirthyDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcooperation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtsocialNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtprovince = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkjoinTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtreason = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkdisableTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcountry = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbirthyDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcooperation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contsocialNo.setName("contsocialNo");
        this.contprovince.setName("contprovince");
        this.contjoinTime.setName("contjoinTime");
        this.contreason.setName("contreason");
        this.chkisDisable.setName("chkisDisable");
        this.contdisableTime.setName("contdisableTime");
        this.contcountry.setName("contcountry");
        this.contbirthyDate.setName("contbirthyDate");
        this.contcooperation.setName("contcooperation");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtsocialNo.setName("txtsocialNo");
        this.prmtprovince.setName("prmtprovince");
        this.pkjoinTime.setName("pkjoinTime");
        this.txtreason.setName("txtreason");
        this.pkdisableTime.setName("pkdisableTime");
        this.prmtcountry.setName("prmtcountry");
        this.pkbirthyDate.setName("pkbirthyDate");
        this.prmtcooperation.setName("prmtcooperation");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setVisible(false);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contsocialNo		
        this.contsocialNo.setBoundLabelText(resHelper.getString("contsocialNo.boundLabelText"));		
        this.contsocialNo.setBoundLabelLength(100);		
        this.contsocialNo.setBoundLabelUnderline(true);		
        this.contsocialNo.setVisible(true);
        // contprovince		
        this.contprovince.setBoundLabelText(resHelper.getString("contprovince.boundLabelText"));		
        this.contprovince.setBoundLabelLength(100);		
        this.contprovince.setBoundLabelUnderline(true);		
        this.contprovince.setVisible(true);
        // contjoinTime		
        this.contjoinTime.setBoundLabelText(resHelper.getString("contjoinTime.boundLabelText"));		
        this.contjoinTime.setBoundLabelLength(100);		
        this.contjoinTime.setBoundLabelUnderline(true);		
        this.contjoinTime.setVisible(true);
        // contreason		
        this.contreason.setBoundLabelText(resHelper.getString("contreason.boundLabelText"));		
        this.contreason.setBoundLabelLength(150);		
        this.contreason.setBoundLabelUnderline(true);		
        this.contreason.setVisible(true);
        // chkisDisable		
        this.chkisDisable.setText(resHelper.getString("chkisDisable.text"));		
        this.chkisDisable.setHorizontalAlignment(2);		
        this.chkisDisable.setEnabled(false);		
        this.chkisDisable.setVisible(false);
        // contdisableTime		
        this.contdisableTime.setBoundLabelText(resHelper.getString("contdisableTime.boundLabelText"));		
        this.contdisableTime.setBoundLabelLength(100);		
        this.contdisableTime.setBoundLabelUnderline(true);		
        this.contdisableTime.setVisible(true);
        // contcountry		
        this.contcountry.setBoundLabelText(resHelper.getString("contcountry.boundLabelText"));		
        this.contcountry.setBoundLabelLength(100);		
        this.contcountry.setBoundLabelUnderline(true);		
        this.contcountry.setVisible(true);
        // contbirthyDate		
        this.contbirthyDate.setBoundLabelText(resHelper.getString("contbirthyDate.boundLabelText"));		
        this.contbirthyDate.setBoundLabelLength(100);		
        this.contbirthyDate.setBoundLabelUnderline(true);		
        this.contbirthyDate.setVisible(true);
        // contcooperation		
        this.contcooperation.setBoundLabelText(resHelper.getString("contcooperation.boundLabelText"));		
        this.contcooperation.setBoundLabelLength(100);		
        this.contcooperation.setBoundLabelUnderline(true);		
        this.contcooperation.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
        // txtDescription
        // txtsocialNo		
        this.txtsocialNo.setHorizontalAlignment(2);		
        this.txtsocialNo.setMaxLength(100);		
        this.txtsocialNo.setRequired(false);
        // prmtprovince		
        this.prmtprovince.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");		
        this.prmtprovince.setEditable(true);		
        this.prmtprovince.setDisplayFormat("$name$");		
        this.prmtprovince.setEditFormat("$number$");		
        this.prmtprovince.setCommitFormat("$number$");		
        this.prmtprovince.setRequired(false);
        // pkjoinTime		
        this.pkjoinTime.setRequired(false);
        // txtreason		
        this.txtreason.setHorizontalAlignment(2);		
        this.txtreason.setMaxLength(200);		
        this.txtreason.setRequired(false);
        // pkdisableTime		
        this.pkdisableTime.setRequired(false);		
        this.pkdisableTime.setEnabled(false);
        // prmtcountry		
        this.prmtcountry.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");		
        this.prmtcountry.setEditable(true);		
        this.prmtcountry.setDisplayFormat("$name$");		
        this.prmtcountry.setEditFormat("$number$");		
        this.prmtcountry.setCommitFormat("$number$");		
        this.prmtcountry.setRequired(false);		
        this.prmtcountry.setEnabled(false);
        // pkbirthyDate		
        this.pkbirthyDate.setRequired(false);
        // prmtcooperation		
        this.prmtcooperation.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcooperation.setVisible(true);		
        this.prmtcooperation.setEditable(true);		
        this.prmtcooperation.setDisplayFormat("$name$");		
        this.prmtcooperation.setEditFormat("$number$");		
        this.prmtcooperation.setCommitFormat("$number$");		
        this.prmtcooperation.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,pkbirthyDate,prmtprovince,prmtcountry,txtsocialNo,pkjoinTime,txtreason,txtDescription,chkisDisable,pkdisableTime,txtSimpleName,txtNumber,prmtcooperation}));
        this.setFocusCycleRoot(true);
		//Register control's property binding
		registerBindings();
		registerUIState();


    }

	public com.kingdee.bos.ctrl.swing.KDToolBar[] getUIMultiToolBar(){
		java.util.List list = new java.util.ArrayList();
		com.kingdee.bos.ctrl.swing.KDToolBar[] bars = super.getUIMultiToolBar();
		if (bars != null) {
			list.addAll(java.util.Arrays.asList(bars));
		}
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(0, 0, 627, 170));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(18, 182, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(12, 11, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(34, 216, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(12, 143, 602, 21));
        this.add(kDLabelContainer4, null);
        contsocialNo.setBounds(new Rectangle(345, 35, 270, 19));
        this.add(contsocialNo, null);
        contprovince.setBounds(new Rectangle(12, 60, 270, 19));
        this.add(contprovince, null);
        contjoinTime.setBounds(new Rectangle(345, 60, 270, 19));
        this.add(contjoinTime, null);
        contreason.setBounds(new Rectangle(12, 108, 602, 30));
        this.add(contreason, null);
        chkisDisable.setBounds(new Rectangle(307, 184, 268, 19));
        this.add(chkisDisable, null);
        contdisableTime.setBounds(new Rectangle(345, 11, 270, 19));
        this.add(contdisableTime, null);
        contcountry.setBounds(new Rectangle(12, 86, 270, 19));
        this.add(contcountry, null);
        contbirthyDate.setBounds(new Rectangle(12, 35, 270, 19));
        this.add(contbirthyDate, null);
        contcooperation.setBounds(new Rectangle(343, 86, 270, 19));
        this.add(contcooperation, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contsocialNo
        contsocialNo.setBoundEditor(txtsocialNo);
        //contprovince
        contprovince.setBoundEditor(prmtprovince);
        //contjoinTime
        contjoinTime.setBoundEditor(pkjoinTime);
        //contreason
        contreason.setBoundEditor(txtreason);
        //contdisableTime
        contdisableTime.setBoundEditor(pkdisableTime);
        //contcountry
        contcountry.setBoundEditor(prmtcountry);
        //contbirthyDate
        contbirthyDate.setBoundEditor(pkbirthyDate);
        //contcooperation
        contcooperation.setBoundEditor(prmtcooperation);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuView);
        this.menuBar.add(menuBiz);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuSubmitOption);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(rMenuItemSubmitAndPrint);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator3);
        menuFile.add(menuItemExitCurrent);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemReset);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemFirst);
        menuView.add(menuItemPre);
        menuView.add(menuItemNext);
        menuView.add(menuItemLast);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuHelp
        menuHelp.add(menuItemHelp);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);
        menuHelp.add(menuItemAbout);

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {
        this.toolBar.add(btnAddNew);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isDisable", boolean.class, this.chkisDisable, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("socialNo", String.class, this.txtsocialNo, "text");
		dataBinder.registerBinding("province", com.kingdee.eas.basedata.assistant.ProvinceInfo.class, this.prmtprovince, "data");
		dataBinder.registerBinding("joinTime", java.util.Date.class, this.pkjoinTime, "value");
		dataBinder.registerBinding("reason", String.class, this.txtreason, "text");
		dataBinder.registerBinding("disableTime", java.util.Date.class, this.pkdisableTime, "value");
		dataBinder.registerBinding("country", com.kingdee.eas.basedata.assistant.CountryInfo.class, this.prmtcountry, "data");
		dataBinder.registerBinding("birthyDate", java.util.Date.class, this.pkbirthyDate, "value");
		dataBinder.registerBinding("cooperation", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcooperation, "data");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.baseinfo.app.LocalBlackListEditUIHandler";
	}
	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
    		request.setClassName(getUIHandlerClassName());
			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
    }
	
	public boolean isPrepareInit() {
    	return false;
    }
    protected void initUIP() {
        super.initUIP();
    }


    /**
     * output onShow method
     */
    public void onShow() throws Exception
    {
        super.onShow();
        this.txtName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.baseinfo.LocalBlackListInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"NONE",editData.getString("number"));
    }
    
    protected void recycleNumberByOrg(IObjectValue editData,String orgType,String number) {
        if (!StringUtils.isEmpty(number))
        {
            try {
            	String companyID = null;            
            	com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID =com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}				
				if (!StringUtils.isEmpty(companyID) && iCodingRuleManager.isExist(editData, companyID) && iCodingRuleManager.isUseIntermitNumber(editData, companyID)) {
					iCodingRuleManager.recycleNumber(editData,companyID,number);					
				}
            }
            catch (Exception e)
            {
                handUIException(e);
            }
        }
    }
    protected void setAutoNumberByOrg(String orgType) {
    	if (editData == null) return;
		if (editData.getNumber() == null) {
            try {
            	String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
		        if (iCodingRuleManager.isExist(editData, companyID)) {
		            if (iCodingRuleManager.isAddView(editData, companyID)) {
		            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
		            }
	                txtNumber.setEnabled(false);
		        }
            }
            catch (Exception e) {
                handUIException(e);
                this.oldData = editData;
                com.kingdee.eas.util.SysUtil.abort();
            } 
        } 
        else {
            if (editData.getNumber().trim().length() > 0) {
                txtNumber.setText(editData.getNumber());
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("NONE");
        dataBinder.loadFields();
    }
		protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
		{
			com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer oufip = new com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer(orgType);
			oufip.getModel().setIsCUFilter(true);
			f7.setFilterInfoProducer(oufip);
		}

    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("isDisable", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("socialNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("province", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("joinTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reason", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("disableTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("country", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("birthyDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cooperation", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
        }
    }

    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
        sic.add(new SelectorItemInfo("isDisable"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("socialNo"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("province.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("province.id"));
        	sic.add(new SelectorItemInfo("province.number"));
        	sic.add(new SelectorItemInfo("province.name"));
		}
        sic.add(new SelectorItemInfo("joinTime"));
        sic.add(new SelectorItemInfo("reason"));
        sic.add(new SelectorItemInfo("disableTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("country.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("country.id"));
        	sic.add(new SelectorItemInfo("country.number"));
        	sic.add(new SelectorItemInfo("country.name"));
		}
        sic.add(new SelectorItemInfo("birthyDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("cooperation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("cooperation.id"));
        	sic.add(new SelectorItemInfo("cooperation.number"));
        	sic.add(new SelectorItemInfo("cooperation.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.client", "LocalBlackListEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.zjlw.baseinfo.client.LocalBlackListEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.baseinfo.LocalBlackListFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.baseinfo.LocalBlackListInfo objectValue = new com.kingdee.eas.zjlw.baseinfo.LocalBlackListInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }



    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}