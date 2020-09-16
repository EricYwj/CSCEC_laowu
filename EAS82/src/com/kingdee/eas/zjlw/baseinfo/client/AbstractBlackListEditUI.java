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
public abstract class AbstractBlackListEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBlackListEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contProvence;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteffectDate;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisEffect;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contIdNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsecurityNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcountry;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkifDisable;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbirthyDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcooperation;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnation;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtProvence;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkeffectDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtIdNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsecurityNo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcountry;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbirthyDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcooperation;
    protected com.kingdee.eas.zjlw.baseinfo.BlackListInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractBlackListEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBlackListEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contProvence = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisEffect = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contIdNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsecurityNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcountry = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkifDisable = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contbirthyDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcooperation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtnation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtProvence = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkeffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtIdNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsecurityNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcountry = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbirthyDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcooperation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contnation.setName("contnation");
        this.contProvence.setName("contProvence");
        this.conteffectDate.setName("conteffectDate");
        this.chkisEffect.setName("chkisEffect");
        this.contIdNum.setName("contIdNum");
        this.contsecurityNo.setName("contsecurityNo");
        this.contcountry.setName("contcountry");
        this.chkifDisable.setName("chkifDisable");
        this.contbirthyDate.setName("contbirthyDate");
        this.contcooperation.setName("contcooperation");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtnation.setName("prmtnation");
        this.prmtProvence.setName("prmtProvence");
        this.pkeffectDate.setName("pkeffectDate");
        this.txtIdNum.setName("txtIdNum");
        this.txtsecurityNo.setName("txtsecurityNo");
        this.prmtcountry.setName("prmtcountry");
        this.pkbirthyDate.setName("pkbirthyDate");
        this.prmtcooperation.setName("prmtcooperation");
        // CoreUI		
        this.btnSubmit.setVisible(false);		
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
        // contnation		
        this.contnation.setBoundLabelText(resHelper.getString("contnation.boundLabelText"));		
        this.contnation.setBoundLabelLength(100);		
        this.contnation.setBoundLabelUnderline(true);		
        this.contnation.setVisible(false);
        // contProvence		
        this.contProvence.setBoundLabelText(resHelper.getString("contProvence.boundLabelText"));		
        this.contProvence.setBoundLabelLength(100);		
        this.contProvence.setBoundLabelUnderline(true);		
        this.contProvence.setVisible(true);
        // conteffectDate		
        this.conteffectDate.setBoundLabelText(resHelper.getString("conteffectDate.boundLabelText"));		
        this.conteffectDate.setBoundLabelLength(100);		
        this.conteffectDate.setBoundLabelUnderline(true);		
        this.conteffectDate.setVisible(true);
        // chkisEffect		
        this.chkisEffect.setText(resHelper.getString("chkisEffect.text"));		
        this.chkisEffect.setVisible(false);		
        this.chkisEffect.setHorizontalAlignment(2);		
        this.chkisEffect.setEnabled(false);
        // contIdNum		
        this.contIdNum.setBoundLabelText(resHelper.getString("contIdNum.boundLabelText"));		
        this.contIdNum.setBoundLabelLength(100);		
        this.contIdNum.setBoundLabelUnderline(true);		
        this.contIdNum.setVisible(true);
        // contsecurityNo		
        this.contsecurityNo.setBoundLabelText(resHelper.getString("contsecurityNo.boundLabelText"));		
        this.contsecurityNo.setBoundLabelLength(100);		
        this.contsecurityNo.setBoundLabelUnderline(true);		
        this.contsecurityNo.setVisible(true);
        // contcountry		
        this.contcountry.setBoundLabelText(resHelper.getString("contcountry.boundLabelText"));		
        this.contcountry.setBoundLabelLength(100);		
        this.contcountry.setBoundLabelUnderline(true);		
        this.contcountry.setVisible(true);
        // chkifDisable		
        this.chkifDisable.setText(resHelper.getString("chkifDisable.text"));		
        this.chkifDisable.setVisible(false);		
        this.chkifDisable.setHorizontalAlignment(2);
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
        // txtDescription
        // prmtnation		
        this.prmtnation.setQueryInfo("com.kingdee.eas.basedata.hraux.app.NationalityQuery");		
        this.prmtnation.setVisible(false);		
        this.prmtnation.setEditable(true);		
        this.prmtnation.setDisplayFormat("$name$");		
        this.prmtnation.setEditFormat("$number$");		
        this.prmtnation.setCommitFormat("$number$");		
        this.prmtnation.setRequired(false);
        // prmtProvence		
        this.prmtProvence.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");		
        this.prmtProvence.setEditable(true);		
        this.prmtProvence.setDisplayFormat("$name$");		
        this.prmtProvence.setEditFormat("$number$");		
        this.prmtProvence.setCommitFormat("$number$");		
        this.prmtProvence.setRequired(false);
        // pkeffectDate		
        this.pkeffectDate.setRequired(false);
        // txtIdNum		
        this.txtIdNum.setHorizontalAlignment(2);		
        this.txtIdNum.setMaxLength(100);		
        this.txtIdNum.setRequired(false);
        this.txtIdNum.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                try {
                    txtIdNum_propertyChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.txtIdNum.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent e) {
                try {
                    txtIdNum_vetoableChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtsecurityNo		
        this.txtsecurityNo.setHorizontalAlignment(2);		
        this.txtsecurityNo.setMaxLength(100);		
        this.txtsecurityNo.setRequired(false);
        // prmtcountry		
        this.prmtcountry.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");		
        this.prmtcountry.setEditable(true);		
        this.prmtcountry.setDisplayFormat("$name$");		
        this.prmtcountry.setEditFormat("$number$");		
        this.prmtcountry.setCommitFormat("$number$");		
        this.prmtcountry.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtnation,prmtProvence,pkeffectDate,chkisEffect,txtIdNum,pkbirthyDate,txtsecurityNo,prmtcountry,chkifDisable,prmtcooperation}));
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
        this.setBounds(new Rectangle(0, 0, 642, 168));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(17, 209, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(15, 17, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(15, 58, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(329, 58, 270, 19));
        this.add(kDLabelContainer4, null);
        contnation.setBounds(new Rectangle(92, 302, 270, 19));
        this.add(contnation, null);
        contProvence.setBounds(new Rectangle(301, 174, 270, 19));
        this.add(contProvence, null);
        conteffectDate.setBounds(new Rectangle(329, 17, 270, 19));
        this.add(conteffectDate, null);
        chkisEffect.setBounds(new Rectangle(335, 210, 134, 19));
        this.add(chkisEffect, null);
        contIdNum.setBounds(new Rectangle(15, 99, 270, 19));
        this.add(contIdNum, null);
        contsecurityNo.setBounds(new Rectangle(9, 173, 270, 19));
        this.add(contsecurityNo, null);
        contcountry.setBounds(new Rectangle(329, 99, 270, 19));
        this.add(contcountry, null);
        chkifDisable.setBounds(new Rectangle(501, 208, 78, 19));
        this.add(chkifDisable, null);
        contbirthyDate.setBounds(new Rectangle(15, 134, 270, 19));
        this.add(contbirthyDate, null);
        contcooperation.setBounds(new Rectangle(328, 135, 270, 19));
        this.add(contcooperation, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contnation
        contnation.setBoundEditor(prmtnation);
        //contProvence
        contProvence.setBoundEditor(prmtProvence);
        //conteffectDate
        conteffectDate.setBoundEditor(pkeffectDate);
        //contIdNum
        contIdNum.setBoundEditor(txtIdNum);
        //contsecurityNo
        contsecurityNo.setBoundEditor(txtsecurityNo);
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
		dataBinder.registerBinding("isEffect", boolean.class, this.chkisEffect, "selected");
		dataBinder.registerBinding("ifDisable", boolean.class, this.chkifDisable, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("nation", com.kingdee.eas.basedata.hraux.NationalityInfo.class, this.prmtnation, "data");
		dataBinder.registerBinding("Provence", com.kingdee.eas.basedata.assistant.ProvinceInfo.class, this.prmtProvence, "data");
		dataBinder.registerBinding("effectDate", java.util.Date.class, this.pkeffectDate, "value");
		dataBinder.registerBinding("IdNum", String.class, this.txtIdNum, "text");
		dataBinder.registerBinding("securityNo", String.class, this.txtsecurityNo, "text");
		dataBinder.registerBinding("country", com.kingdee.eas.basedata.assistant.CountryInfo.class, this.prmtcountry, "data");
		dataBinder.registerBinding("birthyDate", java.util.Date.class, this.pkbirthyDate, "value");
		dataBinder.registerBinding("cooperation", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcooperation, "data");		
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
	    return "com.kingdee.eas.zjlw.baseinfo.app.BlackListEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.baseinfo.BlackListInfo)ov;
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
		getValidateHelper().registerBindProperty("isEffect", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ifDisable", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Provence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("effectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("IdNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("securityNo", ValidateHelper.ON_SAVE);    
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
     * output txtIdNum_propertyChange method
     */
    protected void txtIdNum_propertyChange(java.beans.PropertyChangeEvent e) throws Exception
    {
    }

    /**
     * output txtIdNum_vetoableChange method
     */
    protected void txtIdNum_vetoableChange(java.beans.PropertyChangeEvent e) throws Exception
    {
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
        sic.add(new SelectorItemInfo("isEffect"));
        sic.add(new SelectorItemInfo("ifDisable"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("nation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("nation.id"));
        	sic.add(new SelectorItemInfo("nation.number"));
        	sic.add(new SelectorItemInfo("nation.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Provence.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("Provence.id"));
        	sic.add(new SelectorItemInfo("Provence.number"));
        	sic.add(new SelectorItemInfo("Provence.name"));
		}
        sic.add(new SelectorItemInfo("effectDate"));
        sic.add(new SelectorItemInfo("IdNum"));
        sic.add(new SelectorItemInfo("securityNo"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.client", "BlackListEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.zjlw.baseinfo.client.BlackListEditUI.class.getName();
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
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.baseinfo.BlackListInfo objectValue = new com.kingdee.eas.zjlw.baseinfo.BlackListInfo();
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