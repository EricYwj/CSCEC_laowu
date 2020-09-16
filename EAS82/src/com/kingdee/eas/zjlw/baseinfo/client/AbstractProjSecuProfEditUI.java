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
public abstract class AbstractProjSecuProfEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractProjSecuProfEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasePay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproCom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprofType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnBasePay;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisStop;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstopTimes;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojProf;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasePay;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtproCom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprofType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnBasePay;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkstopTimes;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtremark;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtprojProf;
    protected com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractProjSecuProfEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractProjSecuProfEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasePay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproCom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprofType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnBasePay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisStop = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contstopTimes = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojProf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtbasePay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtproCom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtprofType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtnBasePay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkstopTimes = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtprojProf = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contbasePay.setName("contbasePay");
        this.contproCom.setName("contproCom");
        this.contprofType.setName("contprofType");
        this.contnBasePay.setName("contnBasePay");
        this.chkisStop.setName("chkisStop");
        this.contstopTimes.setName("contstopTimes");
        this.contremark.setName("contremark");
        this.contprojProf.setName("contprojProf");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtbasePay.setName("txtbasePay");
        this.prmtproCom.setName("prmtproCom");
        this.prmtprofType.setName("prmtprofType");
        this.txtnBasePay.setName("txtnBasePay");
        this.pkstopTimes.setName("pkstopTimes");
        this.txtremark.setName("txtremark");
        this.txtprojProf.setName("txtprojProf");
        // CoreUI		
        this.setBorder(null);		
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
        this.kDLabelContainer2.setBoundLabelLength(80);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(60);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);
        // contbasePay		
        this.contbasePay.setBoundLabelText(resHelper.getString("contbasePay.boundLabelText"));		
        this.contbasePay.setBoundLabelLength(80);		
        this.contbasePay.setBoundLabelUnderline(true);		
        this.contbasePay.setVisible(true);
        // contproCom		
        this.contproCom.setBoundLabelText(resHelper.getString("contproCom.boundLabelText"));		
        this.contproCom.setBoundLabelLength(60);		
        this.contproCom.setBoundLabelUnderline(true);		
        this.contproCom.setVisible(true);
        // contprofType		
        this.contprofType.setBoundLabelText(resHelper.getString("contprofType.boundLabelText"));		
        this.contprofType.setBoundLabelLength(80);		
        this.contprofType.setBoundLabelUnderline(true);		
        this.contprofType.setVisible(true);
        // contnBasePay		
        this.contnBasePay.setBoundLabelText(resHelper.getString("contnBasePay.boundLabelText"));		
        this.contnBasePay.setBoundLabelLength(80);		
        this.contnBasePay.setBoundLabelUnderline(true);		
        this.contnBasePay.setVisible(true);
        // chkisStop		
        this.chkisStop.setText(resHelper.getString("chkisStop.text"));		
        this.chkisStop.setHorizontalAlignment(2);
        // contstopTimes		
        this.contstopTimes.setBoundLabelText(resHelper.getString("contstopTimes.boundLabelText"));		
        this.contstopTimes.setBoundLabelLength(60);		
        this.contstopTimes.setBoundLabelUnderline(true);		
        this.contstopTimes.setVisible(true);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(40);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // contprojProf		
        this.contprojProf.setBoundLabelText(resHelper.getString("contprojProf.boundLabelText"));		
        this.contprojProf.setBoundLabelLength(80);		
        this.contprojProf.setBoundLabelUnderline(true);		
        this.contprojProf.setVisible(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription		
        this.txtDescription.setVisible(false);
        // txtbasePay		
        this.txtbasePay.setHorizontalAlignment(2);		
        this.txtbasePay.setDataType(1);		
        this.txtbasePay.setSupportedEmpty(true);		
        this.txtbasePay.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasePay.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasePay.setPrecision(2);		
        this.txtbasePay.setRequired(false);
        // prmtproCom		
        this.prmtproCom.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtproCom.setEditable(true);		
        this.prmtproCom.setDisplayFormat("$name$");		
        this.prmtproCom.setEditFormat("$number$");		
        this.prmtproCom.setCommitFormat("$number$");		
        this.prmtproCom.setRequired(false);
        // prmtprofType		
        this.prmtprofType.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.SecuProfQuery");		
        this.prmtprofType.setEditable(true);		
        this.prmtprofType.setDisplayFormat("$name$");		
        this.prmtprofType.setEditFormat("$number$");		
        this.prmtprofType.setCommitFormat("$number$");		
        this.prmtprofType.setRequired(false);
        prmtprofType.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtprofType_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtnBasePay		
        this.txtnBasePay.setHorizontalAlignment(2);		
        this.txtnBasePay.setDataType(1);		
        this.txtnBasePay.setSupportedEmpty(true);		
        this.txtnBasePay.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txtnBasePay.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txtnBasePay.setPrecision(10);		
        this.txtnBasePay.setRequired(false);
        // pkstopTimes		
        this.pkstopTimes.setRequired(false);
        // txtremark		
        this.txtremark.setHorizontalAlignment(2);		
        this.txtremark.setMaxLength(100);		
        this.txtremark.setRequired(false);
        // txtprojProf		
        this.txtprojProf.setVisible(false);		
        this.txtprojProf.setHorizontalAlignment(2);		
        this.txtprojProf.setMaxLength(100);		
        this.txtprojProf.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtbasePay,prmtproCom,prmtprofType,txtSimpleName,txtDescription,txtNumber,txtName,txtnBasePay,chkisStop,pkstopTimes,txtremark,txtprojProf}));
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
        this.setBounds(new Rectangle(0, 0, 1000, 1000));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1000, 1000));
        kDLabelContainer1.setBounds(new Rectangle(613, 31, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(613, 31, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer2.setBounds(new Rectangle(18, 31, 267, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(18, 31, 267, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(16, 75, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(16, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(649, 353, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(649, 353, 270, 19, 0));
        contbasePay.setBounds(new Rectangle(314, 29, 270, 19));
        this.add(contbasePay, new KDLayout.Constraints(314, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contproCom.setBounds(new Rectangle(16, 120, 270, 19));
        this.add(contproCom, new KDLayout.Constraints(16, 120, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprofType.setBounds(new Rectangle(314, 74, 270, 19));
        this.add(contprofType, new KDLayout.Constraints(314, 74, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnBasePay.setBounds(new Rectangle(314, 120, 270, 19));
        this.add(contnBasePay, new KDLayout.Constraints(314, 120, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisStop.setBounds(new Rectangle(613, 121, 80, 19));
        this.add(chkisStop, new KDLayout.Constraints(613, 121, 80, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstopTimes.setBounds(new Rectangle(613, 75, 270, 19));
        this.add(contstopTimes, new KDLayout.Constraints(613, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contremark.setBounds(new Rectangle(15, 164, 871, 19));
        this.add(contremark, new KDLayout.Constraints(15, 164, 871, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contprojProf.setBounds(new Rectangle(669, 225, 270, 19));
        this.add(contprojProf, new KDLayout.Constraints(669, 225, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contbasePay
        contbasePay.setBoundEditor(txtbasePay);
        //contproCom
        contproCom.setBoundEditor(prmtproCom);
        //contprofType
        contprofType.setBoundEditor(prmtprofType);
        //contnBasePay
        contnBasePay.setBoundEditor(txtnBasePay);
        //contstopTimes
        contstopTimes.setBoundEditor(pkstopTimes);
        //contremark
        contremark.setBoundEditor(txtremark);
        //contprojProf
        contprojProf.setBoundEditor(txtprojProf);

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
		dataBinder.registerBinding("basePay", java.math.BigDecimal.class, this.txtbasePay, "value");
		dataBinder.registerBinding("proCom", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtproCom, "data");
		dataBinder.registerBinding("profType", com.kingdee.eas.zjlw.baseinfo.SecuProfInfo.class, this.prmtprofType, "data");
		dataBinder.registerBinding("nBasePay", java.math.BigDecimal.class, this.txtnBasePay, "value");
		dataBinder.registerBinding("stopTimes", java.util.Date.class, this.pkstopTimes, "value");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("projProf", String.class, this.txtprojProf, "text");		
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
	    return "com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfEditUIHandler";
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
        this.txtbasePay.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo)ov;
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
		getValidateHelper().registerBindProperty("isStop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basePay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proCom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("profType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nBasePay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stopTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projProf", ValidateHelper.ON_SAVE);    		
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
     * output prmtprofType_Changed() method
     */
    public void prmtprofType_Changed() throws Exception
    {
        System.out.println("prmtprofType_Changed() Function is executed!");
            txtnBasePay.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtprofType.getData(),"basePay")));


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
        sic.add(new SelectorItemInfo("basePay"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("proCom.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("proCom.id"));
        	sic.add(new SelectorItemInfo("proCom.number"));
        	sic.add(new SelectorItemInfo("proCom.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("profType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("profType.id"));
        	sic.add(new SelectorItemInfo("profType.number"));
        	sic.add(new SelectorItemInfo("profType.name"));
		}
        sic.add(new SelectorItemInfo("nBasePay"));
        sic.add(new SelectorItemInfo("stopTimes"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("projProf"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.client", "ProjSecuProfEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.zjlw.baseinfo.client.ProjSecuProfEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.baseinfo.ProjSecuProfFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo objectValue = new com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo();
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