/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

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
public abstract class AbstractAlgattenceResultEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAlgattenceResultEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcheckDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contresult;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnoWorkTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthoOverTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoverTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkOrgId;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcheckDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox result;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnoWorkTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthoOverTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoverTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtworkOrgId;
    protected com.kingdee.eas.zjlw.attendance.AlgattenceResultInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractAlgattenceResultEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAlgattenceResultEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcheckDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contresult = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnoWorkTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthoOverTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoverTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkOrgId = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.pkcheckDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.result = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtnoWorkTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthoOverTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoverTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtworkOrgId = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcheckDate.setName("contcheckDate");
        this.contresult.setName("contresult");
        this.contnoWorkTime.setName("contnoWorkTime");
        this.conthoOverTime.setName("conthoOverTime");
        this.contoverTime.setName("contoverTime");
        this.contworkOrgId.setName("contworkOrgId");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.pkcheckDate.setName("pkcheckDate");
        this.result.setName("result");
        this.txtnoWorkTime.setName("txtnoWorkTime");
        this.txthoOverTime.setName("txthoOverTime");
        this.txtoverTime.setName("txtoverTime");
        this.prmtworkOrgId.setName("prmtworkOrgId");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contcheckDate		
        this.contcheckDate.setBoundLabelText(resHelper.getString("contcheckDate.boundLabelText"));		
        this.contcheckDate.setBoundLabelLength(100);		
        this.contcheckDate.setBoundLabelUnderline(true);		
        this.contcheckDate.setVisible(true);
        // contresult		
        this.contresult.setBoundLabelText(resHelper.getString("contresult.boundLabelText"));		
        this.contresult.setBoundLabelLength(100);		
        this.contresult.setBoundLabelUnderline(true);		
        this.contresult.setVisible(true);
        // contnoWorkTime		
        this.contnoWorkTime.setBoundLabelText(resHelper.getString("contnoWorkTime.boundLabelText"));		
        this.contnoWorkTime.setBoundLabelLength(110);		
        this.contnoWorkTime.setBoundLabelUnderline(true);		
        this.contnoWorkTime.setVisible(true);
        // conthoOverTime		
        this.conthoOverTime.setBoundLabelText(resHelper.getString("conthoOverTime.boundLabelText"));		
        this.conthoOverTime.setBoundLabelLength(100);		
        this.conthoOverTime.setBoundLabelUnderline(true);		
        this.conthoOverTime.setVisible(true);
        // contoverTime		
        this.contoverTime.setBoundLabelText(resHelper.getString("contoverTime.boundLabelText"));		
        this.contoverTime.setBoundLabelLength(100);		
        this.contoverTime.setBoundLabelUnderline(true);		
        this.contoverTime.setVisible(true);
        // contworkOrgId		
        this.contworkOrgId.setBoundLabelText(resHelper.getString("contworkOrgId.boundLabelText"));		
        this.contworkOrgId.setBoundLabelLength(100);		
        this.contworkOrgId.setBoundLabelUnderline(true);		
        this.contworkOrgId.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
        // txtDescription
        // pkcheckDate		
        this.pkcheckDate.setVisible(true);		
        this.pkcheckDate.setRequired(false);
        // result		
        this.result.setVisible(true);		
        this.result.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.attendance.app.algResultEnum").toArray());		
        this.result.setRequired(false);
        // txtnoWorkTime		
        this.txtnoWorkTime.setVisible(true);		
        this.txtnoWorkTime.setHorizontalAlignment(2);		
        this.txtnoWorkTime.setDataType(0);		
        this.txtnoWorkTime.setSupportedEmpty(true);		
        this.txtnoWorkTime.setRequired(false);
        // txthoOverTime		
        this.txthoOverTime.setVisible(true);		
        this.txthoOverTime.setHorizontalAlignment(2);		
        this.txthoOverTime.setDataType(1);		
        this.txthoOverTime.setSupportedEmpty(true);		
        this.txthoOverTime.setMinimumValue( new java.math.BigDecimal("-1.0E27"));		
        this.txthoOverTime.setMaximumValue( new java.math.BigDecimal("1.0E27"));		
        this.txthoOverTime.setPrecision(1);		
        this.txthoOverTime.setRequired(false);
        // txtoverTime		
        this.txtoverTime.setVisible(true);		
        this.txtoverTime.setHorizontalAlignment(2);		
        this.txtoverTime.setDataType(1);		
        this.txtoverTime.setSupportedEmpty(true);		
        this.txtoverTime.setMinimumValue( new java.math.BigDecimal("-1.0E27"));		
        this.txtoverTime.setMaximumValue( new java.math.BigDecimal("1.0E27"));		
        this.txtoverTime.setPrecision(1);		
        this.txtoverTime.setRequired(false);
        // prmtworkOrgId		
        this.prmtworkOrgId.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtworkOrgId.setVisible(true);		
        this.prmtworkOrgId.setEditable(true);		
        this.prmtworkOrgId.setDisplayFormat("$name$");		
        this.prmtworkOrgId.setEditFormat("$number$");		
        this.prmtworkOrgId.setCommitFormat("$number$");		
        this.prmtworkOrgId.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkcheckDate,result,txtnoWorkTime,txthoOverTime,txtoverTime,prmtworkOrgId}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 197));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(63, 49, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(354, 49, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(658, 148, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(63, 150, 562, 19));
        this.add(kDLabelContainer4, null);
        contcheckDate.setBounds(new Rectangle(63, 115, 270, 19));
        this.add(contcheckDate, null);
        contresult.setBounds(new Rectangle(353, 115, 270, 19));
        this.add(contresult, null);
        contnoWorkTime.setBounds(new Rectangle(643, 82, 270, 19));
        this.add(contnoWorkTime, null);
        conthoOverTime.setBounds(new Rectangle(63, 82, 270, 19));
        this.add(conthoOverTime, null);
        contoverTime.setBounds(new Rectangle(353, 82, 270, 19));
        this.add(contoverTime, null);
        contworkOrgId.setBounds(new Rectangle(643, 49, 270, 19));
        this.add(contworkOrgId, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcheckDate
        contcheckDate.setBoundEditor(pkcheckDate);
        //contresult
        contresult.setBoundEditor(result);
        //contnoWorkTime
        contnoWorkTime.setBoundEditor(txtnoWorkTime);
        //conthoOverTime
        conthoOverTime.setBoundEditor(txthoOverTime);
        //contoverTime
        contoverTime.setBoundEditor(txtoverTime);
        //contworkOrgId
        contworkOrgId.setBoundEditor(prmtworkOrgId);

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
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("checkDate", java.util.Date.class, this.pkcheckDate, "value");
		dataBinder.registerBinding("result", com.kingdee.eas.zjlw.attendance.app.algResultEnum.class, this.result, "selectedItem");
		dataBinder.registerBinding("noWorkTime", int.class, this.txtnoWorkTime, "value");
		dataBinder.registerBinding("hoOverTime", java.math.BigDecimal.class, this.txthoOverTime, "value");
		dataBinder.registerBinding("overTime", java.math.BigDecimal.class, this.txtoverTime, "value");
		dataBinder.registerBinding("workOrgId", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtworkOrgId, "data");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.attendance.app.AlgattenceResultEditUIHandler";
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
        this.pkcheckDate.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.attendance.AlgattenceResultInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("result", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("noWorkTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hoOverTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("overTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workOrgId", ValidateHelper.ON_SAVE);    		
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
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
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
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("checkDate"));
        sic.add(new SelectorItemInfo("result"));
        sic.add(new SelectorItemInfo("noWorkTime"));
        sic.add(new SelectorItemInfo("hoOverTime"));
        sic.add(new SelectorItemInfo("overTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("workOrgId.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("workOrgId.id"));
        	sic.add(new SelectorItemInfo("workOrgId.number"));
        	sic.add(new SelectorItemInfo("workOrgId.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.attendance.client", "AlgattenceResultEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.zjlw.attendance.client.AlgattenceResultEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.attendance.AlgattenceResultFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.attendance.AlgattenceResultInfo objectValue = new com.kingdee.eas.zjlw.attendance.AlgattenceResultInfo();
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
		vo.put("result","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}