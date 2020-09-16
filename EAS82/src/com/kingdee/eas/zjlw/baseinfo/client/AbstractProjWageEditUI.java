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
public abstract class AbstractProjWageEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractProjWageEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttype;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproCom;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisStop;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstopTimes;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcooperation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwageType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmoney;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttype;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtproCom;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkstopTimes;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcooperation;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtwageType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtunit;
    protected com.kingdee.eas.zjlw.baseinfo.ProjWageInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractProjWageEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractProjWageEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttype = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproCom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisStop = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contstopTimes = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcooperation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwageType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtmoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmttype = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtproCom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkstopTimes = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcooperation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtwageType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtunit = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contmoney.setName("contmoney");
        this.conttype.setName("conttype");
        this.contproCom.setName("contproCom");
        this.chkisStop.setName("chkisStop");
        this.contstopTimes.setName("contstopTimes");
        this.contcooperation.setName("contcooperation");
        this.contwageType.setName("contwageType");
        this.contunit.setName("contunit");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtmoney.setName("txtmoney");
        this.prmttype.setName("prmttype");
        this.prmtproCom.setName("prmtproCom");
        this.pkstopTimes.setName("pkstopTimes");
        this.prmtcooperation.setName("prmtcooperation");
        this.prmtwageType.setName("prmtwageType");
        this.txtunit.setName("txtunit");
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
        this.kDLabelContainer2.setBoundLabelLength(80);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(60);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(40);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contmoney		
        this.contmoney.setBoundLabelText(resHelper.getString("contmoney.boundLabelText"));		
        this.contmoney.setBoundLabelLength(80);		
        this.contmoney.setBoundLabelUnderline(true);		
        this.contmoney.setVisible(true);
        // conttype		
        this.conttype.setBoundLabelText(resHelper.getString("conttype.boundLabelText"));		
        this.conttype.setBoundLabelLength(80);		
        this.conttype.setBoundLabelUnderline(true);		
        this.conttype.setVisible(true);
        // contproCom		
        this.contproCom.setBoundLabelText(resHelper.getString("contproCom.boundLabelText"));		
        this.contproCom.setBoundLabelLength(60);		
        this.contproCom.setBoundLabelUnderline(true);		
        this.contproCom.setVisible(true);
        // chkisStop		
        this.chkisStop.setText(resHelper.getString("chkisStop.text"));		
        this.chkisStop.setHorizontalAlignment(2);
        // contstopTimes		
        this.contstopTimes.setBoundLabelText(resHelper.getString("contstopTimes.boundLabelText"));		
        this.contstopTimes.setBoundLabelLength(60);		
        this.contstopTimes.setBoundLabelUnderline(true);		
        this.contstopTimes.setVisible(true);
        // contcooperation		
        this.contcooperation.setBoundLabelText(resHelper.getString("contcooperation.boundLabelText"));		
        this.contcooperation.setBoundLabelLength(40);		
        this.contcooperation.setBoundLabelUnderline(true);		
        this.contcooperation.setVisible(false);
        // contwageType		
        this.contwageType.setBoundLabelText(resHelper.getString("contwageType.boundLabelText"));		
        this.contwageType.setBoundLabelLength(80);		
        this.contwageType.setBoundLabelUnderline(true);		
        this.contwageType.setVisible(true);
        // contunit		
        this.contunit.setBoundLabelText(resHelper.getString("contunit.boundLabelText"));		
        this.contunit.setBoundLabelLength(40);		
        this.contunit.setBoundLabelUnderline(true);		
        this.contunit.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(false);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtmoney		
        this.txtmoney.setHorizontalAlignment(2);		
        this.txtmoney.setDataType(1);		
        this.txtmoney.setSupportedEmpty(true);		
        this.txtmoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmoney.setPrecision(2);		
        this.txtmoney.setRequired(false);
        // prmttype		
        this.prmttype.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.WageQuery");		
        this.prmttype.setEditable(true);		
        this.prmttype.setDisplayFormat("$money$");		
        this.prmttype.setEditFormat("$number$");		
        this.prmttype.setCommitFormat("$number$");		
        this.prmttype.setRequired(false);
        // prmtproCom		
        this.prmtproCom.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtproCom.setEditable(true);		
        this.prmtproCom.setDisplayFormat("$name$");		
        this.prmtproCom.setEditFormat("$number$");		
        this.prmtproCom.setCommitFormat("$number$");		
        this.prmtproCom.setRequired(false);
        // pkstopTimes		
        this.pkstopTimes.setRequired(false);
        // prmtcooperation		
        this.prmtcooperation.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcooperation.setVisible(false);		
        this.prmtcooperation.setEditable(true);		
        this.prmtcooperation.setDisplayFormat("$name$");		
        this.prmtcooperation.setEditFormat("$number$");		
        this.prmtcooperation.setCommitFormat("$number$");		
        this.prmtcooperation.setRequired(false);
        // prmtwageType		
        this.prmtwageType.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.WageQuery");		
        this.prmtwageType.setEditable(true);		
        this.prmtwageType.setDisplayFormat("$name$");		
        this.prmtwageType.setEditFormat("$number$");		
        this.prmtwageType.setCommitFormat("$number$");		
        this.prmtwageType.setRequired(false);
        this.prmtwageType.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtwageType_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtunit		
        this.txtunit.setVisible(true);		
        this.txtunit.setHorizontalAlignment(2);		
        this.txtunit.setMaxLength(100);		
        this.txtunit.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,txtmoney,prmttype,prmtproCom,chkisStop,pkstopTimes,prmtcooperation,prmtwageType,txtunit}));
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
        this.setBounds(new Rectangle(0, 0, 1000, 250));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1000, 250));
        kDLabelContainer1.setBounds(new Rectangle(608, 302, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(608, 302, 270, 19, 0));
        kDLabelContainer2.setBounds(new Rectangle(35, 33, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(35, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(337, 33, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(337, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(34, 177, 873, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(34, 177, 873, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmoney.setBounds(new Rectangle(337, 128, 270, 19));
        this.add(contmoney, new KDLayout.Constraints(337, 128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttype.setBounds(new Rectangle(35, 128, 270, 19));
        this.add(conttype, new KDLayout.Constraints(35, 128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contproCom.setBounds(new Rectangle(35, 80, 270, 19));
        this.add(contproCom, new KDLayout.Constraints(35, 80, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisStop.setBounds(new Rectangle(634, 33, 270, 19));
        this.add(chkisStop, new KDLayout.Constraints(634, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstopTimes.setBounds(new Rectangle(634, 80, 270, 19));
        this.add(contstopTimes, new KDLayout.Constraints(634, 80, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcooperation.setBounds(new Rectangle(35, 218, 270, 19));
        this.add(contcooperation, new KDLayout.Constraints(35, 218, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contwageType.setBounds(new Rectangle(337, 80, 270, 19));
        this.add(contwageType, new KDLayout.Constraints(337, 80, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunit.setBounds(new Rectangle(638, 126, 267, 19));
        this.add(contunit, new KDLayout.Constraints(638, 126, 267, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contmoney
        contmoney.setBoundEditor(txtmoney);
        //conttype
        conttype.setBoundEditor(prmttype);
        //contproCom
        contproCom.setBoundEditor(prmtproCom);
        //contstopTimes
        contstopTimes.setBoundEditor(pkstopTimes);
        //contcooperation
        contcooperation.setBoundEditor(prmtcooperation);
        //contwageType
        contwageType.setBoundEditor(prmtwageType);
        //contunit
        contunit.setBoundEditor(txtunit);

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
		dataBinder.registerBinding("isStop", boolean.class, this.chkisStop, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("money", java.math.BigDecimal.class, this.txtmoney, "value");
		dataBinder.registerBinding("type", com.kingdee.eas.zjlw.baseinfo.WageInfo.class, this.prmttype, "data");
		dataBinder.registerBinding("proCom", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtproCom, "data");
		dataBinder.registerBinding("stopTimes", java.util.Date.class, this.pkstopTimes, "value");
		dataBinder.registerBinding("cooperation", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcooperation, "data");
		dataBinder.registerBinding("wageType", com.kingdee.eas.zjlw.baseinfo.WageInfo.class, this.prmtwageType, "data");
		dataBinder.registerBinding("unit", String.class, this.txtunit, "text");		
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
	    return "com.kingdee.eas.zjlw.baseinfo.app.ProjWageEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)ov;
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
	 * ????????��??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("isStop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("money", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("type", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proCom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stopTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wageType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unit", ValidateHelper.ON_SAVE);    		
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
     * output prmtwageType_dataChanged method
     */
    protected void prmtwageType_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
        sic.add(new SelectorItemInfo("isStop"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("money"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("type.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("type.id"));
        	sic.add(new SelectorItemInfo("type.number"));
        	sic.add(new SelectorItemInfo("type.name"));
        	sic.add(new SelectorItemInfo("type.money"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("proCom.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("proCom.id"));
        	sic.add(new SelectorItemInfo("proCom.number"));
        	sic.add(new SelectorItemInfo("proCom.name"));
		}
        sic.add(new SelectorItemInfo("stopTimes"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("cooperation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("cooperation.id"));
        	sic.add(new SelectorItemInfo("cooperation.number"));
        	sic.add(new SelectorItemInfo("cooperation.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("wageType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("wageType.id"));
        	sic.add(new SelectorItemInfo("wageType.number"));
        	sic.add(new SelectorItemInfo("wageType.name"));
		}
        sic.add(new SelectorItemInfo("unit"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.client", "ProjWageEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.zjlw.baseinfo.client.ProjWageEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.baseinfo.ProjWageFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.baseinfo.ProjWageInfo objectValue = new com.kingdee.eas.zjlw.baseinfo.ProjWageInfo();
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