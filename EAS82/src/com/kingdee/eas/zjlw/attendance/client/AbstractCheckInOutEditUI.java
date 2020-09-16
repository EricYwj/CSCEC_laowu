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
public abstract class AbstractCheckInOutEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCheckInOutEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperProj;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperId;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcheckTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcheckType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcheAera;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmachineId;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtperName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtperProj;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtperId;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcheckTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcheckType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcheAera;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmachineId;
    protected com.kingdee.eas.zjlw.attendance.CheckInOutInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCheckInOutEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCheckInOutEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperProj = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperId = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcheckTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcheckType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcheAera = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmachineId = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtperName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtperProj = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtperId = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcheckTime = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcheckType = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcheAera = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmachineId = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contperName.setName("contperName");
        this.contperProj.setName("contperProj");
        this.contperId.setName("contperId");
        this.contcheckTime.setName("contcheckTime");
        this.contcheckType.setName("contcheckType");
        this.contcheAera.setName("contcheAera");
        this.contmachineId.setName("contmachineId");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtperName.setName("txtperName");
        this.txtperProj.setName("txtperProj");
        this.txtperId.setName("txtperId");
        this.txtcheckTime.setName("txtcheckTime");
        this.txtcheckType.setName("txtcheckType");
        this.txtcheAera.setName("txtcheAera");
        this.txtmachineId.setName("txtmachineId");
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
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contperName		
        this.contperName.setBoundLabelText(resHelper.getString("contperName.boundLabelText"));		
        this.contperName.setBoundLabelLength(100);		
        this.contperName.setBoundLabelUnderline(true);		
        this.contperName.setVisible(true);
        // contperProj		
        this.contperProj.setBoundLabelText(resHelper.getString("contperProj.boundLabelText"));		
        this.contperProj.setBoundLabelLength(100);		
        this.contperProj.setBoundLabelUnderline(true);		
        this.contperProj.setVisible(true);
        // contperId		
        this.contperId.setBoundLabelText(resHelper.getString("contperId.boundLabelText"));		
        this.contperId.setBoundLabelLength(100);		
        this.contperId.setBoundLabelUnderline(true);		
        this.contperId.setVisible(true);
        // contcheckTime		
        this.contcheckTime.setBoundLabelText(resHelper.getString("contcheckTime.boundLabelText"));		
        this.contcheckTime.setBoundLabelLength(100);		
        this.contcheckTime.setBoundLabelUnderline(true);		
        this.contcheckTime.setVisible(true);
        // contcheckType		
        this.contcheckType.setBoundLabelText(resHelper.getString("contcheckType.boundLabelText"));		
        this.contcheckType.setBoundLabelLength(100);		
        this.contcheckType.setBoundLabelUnderline(true);		
        this.contcheckType.setVisible(true);
        // contcheAera		
        this.contcheAera.setBoundLabelText(resHelper.getString("contcheAera.boundLabelText"));		
        this.contcheAera.setBoundLabelLength(100);		
        this.contcheAera.setBoundLabelUnderline(true);		
        this.contcheAera.setVisible(true);
        // contmachineId		
        this.contmachineId.setBoundLabelText(resHelper.getString("contmachineId.boundLabelText"));		
        this.contmachineId.setBoundLabelLength(100);		
        this.contmachineId.setBoundLabelUnderline(true);		
        this.contmachineId.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(false);
        // txtName		
        this.txtName.setVisible(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
        // txtDescription		
        this.txtDescription.setVisible(false);
        // txtperName		
        this.txtperName.setHorizontalAlignment(2);		
        this.txtperName.setMaxLength(100);		
        this.txtperName.setRequired(false);
        // txtperProj		
        this.txtperProj.setHorizontalAlignment(2);		
        this.txtperProj.setMaxLength(100);		
        this.txtperProj.setRequired(false);
        // txtperId		
        this.txtperId.setVisible(true);		
        this.txtperId.setHorizontalAlignment(2);		
        this.txtperId.setMaxLength(100);		
        this.txtperId.setRequired(false);
        // txtcheckTime		
        this.txtcheckTime.setVisible(true);		
        this.txtcheckTime.setHorizontalAlignment(2);		
        this.txtcheckTime.setMaxLength(100);		
        this.txtcheckTime.setRequired(false);
        // txtcheckType		
        this.txtcheckType.setVisible(true);		
        this.txtcheckType.setHorizontalAlignment(2);		
        this.txtcheckType.setMaxLength(100);		
        this.txtcheckType.setRequired(false);
        // txtcheAera		
        this.txtcheAera.setVisible(true);		
        this.txtcheAera.setHorizontalAlignment(2);		
        this.txtcheAera.setMaxLength(100);		
        this.txtcheAera.setRequired(false);
        // txtmachineId		
        this.txtmachineId.setVisible(true);		
        this.txtmachineId.setHorizontalAlignment(2);		
        this.txtmachineId.setMaxLength(100);		
        this.txtmachineId.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,txtperName,txtperProj,txtperId,txtcheckTime,txtcheckType,txtcheAera,txtmachineId}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 247));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(29, 367, 141, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(503, 369, 124, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(143, 371, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(665, 361, 270, 19));
        this.add(kDLabelContainer4, null);
        contperName.setBounds(new Rectangle(368, 62, 270, 19));
        this.add(contperName, null);
        contperProj.setBounds(new Rectangle(698, 62, 270, 19));
        this.add(contperProj, null);
        contperId.setBounds(new Rectangle(37, 62, 270, 19));
        this.add(contperId, null);
        contcheckTime.setBounds(new Rectangle(37, 114, 270, 19));
        this.add(contcheckTime, null);
        contcheckType.setBounds(new Rectangle(368, 114, 270, 19));
        this.add(contcheckType, null);
        contcheAera.setBounds(new Rectangle(698, 114, 270, 19));
        this.add(contcheAera, null);
        contmachineId.setBounds(new Rectangle(37, 166, 270, 19));
        this.add(contmachineId, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contperName
        contperName.setBoundEditor(txtperName);
        //contperProj
        contperProj.setBoundEditor(txtperProj);
        //contperId
        contperId.setBoundEditor(txtperId);
        //contcheckTime
        contcheckTime.setBoundEditor(txtcheckTime);
        //contcheckType
        contcheckType.setBoundEditor(txtcheckType);
        //contcheAera
        contcheAera.setBoundEditor(txtcheAera);
        //contmachineId
        contmachineId.setBoundEditor(txtmachineId);

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
		dataBinder.registerBinding("perName", String.class, this.txtperName, "text");
		dataBinder.registerBinding("perProj", String.class, this.txtperProj, "text");
		dataBinder.registerBinding("perId", String.class, this.txtperId, "text");
		dataBinder.registerBinding("checkTime", String.class, this.txtcheckTime, "text");
		dataBinder.registerBinding("checkType", String.class, this.txtcheckType, "text");
		dataBinder.registerBinding("cheAera", String.class, this.txtcheAera, "text");
		dataBinder.registerBinding("machineId", String.class, this.txtmachineId, "text");		
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
	    return "com.kingdee.eas.zjlw.attendance.app.CheckInOutEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.attendance.CheckInOutInfo)ov;
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
		getValidateHelper().registerBindProperty("perName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cheAera", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("machineId", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("perName"));
        sic.add(new SelectorItemInfo("perProj"));
        sic.add(new SelectorItemInfo("perId"));
        sic.add(new SelectorItemInfo("checkTime"));
        sic.add(new SelectorItemInfo("checkType"));
        sic.add(new SelectorItemInfo("cheAera"));
        sic.add(new SelectorItemInfo("machineId"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.attendance.client", "CheckInOutEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.zjlw.attendance.client.CheckInOutEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.attendance.CheckInOutFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.attendance.CheckInOutInfo objectValue = new com.kingdee.eas.zjlw.attendance.CheckInOutInfo();
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