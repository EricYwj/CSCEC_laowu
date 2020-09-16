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
public abstract class AbstractAttencePersonEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAttencePersonEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonid;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsex;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcooperationid;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkOrgId;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcheckRuleId;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCheckNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCheckSysDepNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contIdNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpasspNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpersonid;
    protected com.kingdee.bos.ctrl.swing.KDComboBox sex;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnation;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcooperationid;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtworkOrgId;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcheckRuleId;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCheckNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCheckSysDepNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtIdNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpasspNum;
    protected com.kingdee.eas.zjlw.attendance.AttencePersonInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractAttencePersonEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAttencePersonEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsex = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcooperationid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkOrgId = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcheckRuleId = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCheckNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCheckSysDepNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contIdNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpasspNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtpersonid = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.sex = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtnation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcooperationid = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtworkOrgId = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcheckRuleId = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtCheckNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCheckSysDepNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtIdNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpasspNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contpersonid.setName("contpersonid");
        this.contsex.setName("contsex");
        this.contnation.setName("contnation");
        this.contcooperationid.setName("contcooperationid");
        this.contworkOrgId.setName("contworkOrgId");
        this.contcheckRuleId.setName("contcheckRuleId");
        this.contCheckNo.setName("contCheckNo");
        this.contCheckSysDepNo.setName("contCheckSysDepNo");
        this.contIdNum.setName("contIdNum");
        this.contpasspNum.setName("contpasspNum");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtpersonid.setName("txtpersonid");
        this.sex.setName("sex");
        this.prmtnation.setName("prmtnation");
        this.prmtcooperationid.setName("prmtcooperationid");
        this.prmtworkOrgId.setName("prmtworkOrgId");
        this.prmtcheckRuleId.setName("prmtcheckRuleId");
        this.txtCheckNo.setName("txtCheckNo");
        this.txtCheckSysDepNo.setName("txtCheckSysDepNo");
        this.txtIdNum.setName("txtIdNum");
        this.txtpasspNum.setName("txtpasspNum");
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
        // contpersonid		
        this.contpersonid.setBoundLabelText(resHelper.getString("contpersonid.boundLabelText"));		
        this.contpersonid.setBoundLabelLength(100);		
        this.contpersonid.setBoundLabelUnderline(true);		
        this.contpersonid.setVisible(true);
        // contsex		
        this.contsex.setBoundLabelText(resHelper.getString("contsex.boundLabelText"));		
        this.contsex.setBoundLabelLength(100);		
        this.contsex.setBoundLabelUnderline(true);		
        this.contsex.setVisible(true);
        // contnation		
        this.contnation.setBoundLabelText(resHelper.getString("contnation.boundLabelText"));		
        this.contnation.setBoundLabelLength(100);		
        this.contnation.setBoundLabelUnderline(true);		
        this.contnation.setVisible(true);
        // contcooperationid		
        this.contcooperationid.setBoundLabelText(resHelper.getString("contcooperationid.boundLabelText"));		
        this.contcooperationid.setBoundLabelLength(100);		
        this.contcooperationid.setBoundLabelUnderline(true);		
        this.contcooperationid.setVisible(true);
        // contworkOrgId		
        this.contworkOrgId.setBoundLabelText(resHelper.getString("contworkOrgId.boundLabelText"));		
        this.contworkOrgId.setBoundLabelLength(100);		
        this.contworkOrgId.setBoundLabelUnderline(true);		
        this.contworkOrgId.setVisible(true);
        // contcheckRuleId		
        this.contcheckRuleId.setBoundLabelText(resHelper.getString("contcheckRuleId.boundLabelText"));		
        this.contcheckRuleId.setBoundLabelLength(100);		
        this.contcheckRuleId.setBoundLabelUnderline(true);		
        this.contcheckRuleId.setVisible(true);
        // contCheckNo		
        this.contCheckNo.setBoundLabelText(resHelper.getString("contCheckNo.boundLabelText"));		
        this.contCheckNo.setBoundLabelLength(100);		
        this.contCheckNo.setBoundLabelUnderline(true);		
        this.contCheckNo.setVisible(true);
        // contCheckSysDepNo		
        this.contCheckSysDepNo.setBoundLabelText(resHelper.getString("contCheckSysDepNo.boundLabelText"));		
        this.contCheckSysDepNo.setBoundLabelLength(100);		
        this.contCheckSysDepNo.setBoundLabelUnderline(true);		
        this.contCheckSysDepNo.setVisible(true);
        // contIdNum		
        this.contIdNum.setBoundLabelText(resHelper.getString("contIdNum.boundLabelText"));		
        this.contIdNum.setBoundLabelLength(100);		
        this.contIdNum.setBoundLabelUnderline(true);		
        this.contIdNum.setVisible(true);
        // contpasspNum		
        this.contpasspNum.setBoundLabelText(resHelper.getString("contpasspNum.boundLabelText"));		
        this.contpasspNum.setBoundLabelLength(100);		
        this.contpasspNum.setBoundLabelUnderline(true);		
        this.contpasspNum.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtpersonid		
        this.txtpersonid.setVisible(true);		
        this.txtpersonid.setHorizontalAlignment(2);		
        this.txtpersonid.setMaxLength(100);		
        this.txtpersonid.setRequired(false);
        // sex		
        this.sex.setVisible(true);		
        this.sex.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());		
        this.sex.setRequired(false);
        // prmtnation		
        this.prmtnation.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");		
        this.prmtnation.setVisible(true);		
        this.prmtnation.setEditable(true);		
        this.prmtnation.setDisplayFormat("$name$ $number$");		
        this.prmtnation.setEditFormat("$number$");		
        this.prmtnation.setCommitFormat("$number$");		
        this.prmtnation.setRequired(false);
        // prmtcooperationid		
        this.prmtcooperationid.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcooperationid.setVisible(true);		
        this.prmtcooperationid.setEditable(true);		
        this.prmtcooperationid.setDisplayFormat("$name$");		
        this.prmtcooperationid.setEditFormat("$number$");		
        this.prmtcooperationid.setCommitFormat("$number$");		
        this.prmtcooperationid.setRequired(false);
        // prmtworkOrgId		
        this.prmtworkOrgId.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtworkOrgId.setVisible(true);		
        this.prmtworkOrgId.setEditable(true);		
        this.prmtworkOrgId.setDisplayFormat("$name$");		
        this.prmtworkOrgId.setEditFormat("$number$");		
        this.prmtworkOrgId.setCommitFormat("$number$");		
        this.prmtworkOrgId.setRequired(false);
        // prmtcheckRuleId		
        this.prmtcheckRuleId.setQueryInfo("com.kingdee.eas.zjlw.attendance.app.CheckRuleQuery");		
        this.prmtcheckRuleId.setVisible(true);		
        this.prmtcheckRuleId.setEditable(true);		
        this.prmtcheckRuleId.setDisplayFormat("$name$");		
        this.prmtcheckRuleId.setEditFormat("$number$");		
        this.prmtcheckRuleId.setCommitFormat("$number$");		
        this.prmtcheckRuleId.setRequired(false);
        // txtCheckNo		
        this.txtCheckNo.setVisible(true);		
        this.txtCheckNo.setHorizontalAlignment(2);		
        this.txtCheckNo.setMaxLength(100);		
        this.txtCheckNo.setRequired(false);
        // txtCheckSysDepNo		
        this.txtCheckSysDepNo.setVisible(true);		
        this.txtCheckSysDepNo.setHorizontalAlignment(2);		
        this.txtCheckSysDepNo.setMaxLength(100);		
        this.txtCheckSysDepNo.setRequired(false);
        // txtIdNum		
        this.txtIdNum.setVisible(true);		
        this.txtIdNum.setHorizontalAlignment(2);		
        this.txtIdNum.setMaxLength(100);		
        this.txtIdNum.setRequired(false);
        // txtpasspNum		
        this.txtpasspNum.setVisible(true);		
        this.txtpasspNum.setHorizontalAlignment(2);		
        this.txtpasspNum.setMaxLength(100);		
        this.txtpasspNum.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtpersonid,sex,prmtnation,prmtcooperationid,prmtworkOrgId,prmtcheckRuleId,txtCheckNo,txtCheckSysDepNo,txtIdNum,txtpasspNum}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 233));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(34, 44, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(365, 44, 271, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(407, 232, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(35, 190, 603, 19));
        this.add(kDLabelContainer4, null);
        contpersonid.setBounds(new Rectangle(690, 44, 270, 19));
        this.add(contpersonid, null);
        contsex.setBounds(new Rectangle(35, 116, 270, 19));
        this.add(contsex, null);
        contnation.setBounds(new Rectangle(366, 116, 270, 19));
        this.add(contnation, null);
        contcooperationid.setBounds(new Rectangle(35, 152, 270, 19));
        this.add(contcooperationid, null);
        contworkOrgId.setBounds(new Rectangle(366, 152, 270, 19));
        this.add(contworkOrgId, null);
        contcheckRuleId.setBounds(new Rectangle(690, 116, 270, 19));
        this.add(contcheckRuleId, null);
        contCheckNo.setBounds(new Rectangle(690, 80, 270, 19));
        this.add(contCheckNo, null);
        contCheckSysDepNo.setBounds(new Rectangle(690, 154, 270, 19));
        this.add(contCheckSysDepNo, null);
        contIdNum.setBounds(new Rectangle(34, 80, 270, 19));
        this.add(contIdNum, null);
        contpasspNum.setBounds(new Rectangle(365, 80, 270, 19));
        this.add(contpasspNum, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contpersonid
        contpersonid.setBoundEditor(txtpersonid);
        //contsex
        contsex.setBoundEditor(sex);
        //contnation
        contnation.setBoundEditor(prmtnation);
        //contcooperationid
        contcooperationid.setBoundEditor(prmtcooperationid);
        //contworkOrgId
        contworkOrgId.setBoundEditor(prmtworkOrgId);
        //contcheckRuleId
        contcheckRuleId.setBoundEditor(prmtcheckRuleId);
        //contCheckNo
        contCheckNo.setBoundEditor(txtCheckNo);
        //contCheckSysDepNo
        contCheckSysDepNo.setBoundEditor(txtCheckSysDepNo);
        //contIdNum
        contIdNum.setBoundEditor(txtIdNum);
        //contpasspNum
        contpasspNum.setBoundEditor(txtpasspNum);

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
		dataBinder.registerBinding("personid", String.class, this.txtpersonid, "text");
		dataBinder.registerBinding("sex", com.kingdee.eas.basedata.person.Genders.class, this.sex, "selectedItem");
		dataBinder.registerBinding("nation", com.kingdee.eas.basedata.assistant.CountryInfo.class, this.prmtnation, "data");
		dataBinder.registerBinding("cooperationid", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcooperationid, "data");
		dataBinder.registerBinding("workOrgId", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtworkOrgId, "data");
		dataBinder.registerBinding("checkRuleId", com.kingdee.eas.zjlw.attendance.CheckRuleInfo.class, this.prmtcheckRuleId, "data");
		dataBinder.registerBinding("CheckNo", String.class, this.txtCheckNo, "text");
		dataBinder.registerBinding("CheckSysDepNo", String.class, this.txtCheckSysDepNo, "text");
		dataBinder.registerBinding("IdNum", String.class, this.txtIdNum, "text");
		dataBinder.registerBinding("passpNum", String.class, this.txtpasspNum, "text");		
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
	    return "com.kingdee.eas.zjlw.attendance.app.AttencePersonEditUIHandler";
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
        this.txtpersonid.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.attendance.AttencePersonInfo)ov;
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
		getValidateHelper().registerBindProperty("personid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cooperationid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workOrgId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkRuleId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CheckNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CheckSysDepNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("IdNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("passpNum", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("personid"));
        sic.add(new SelectorItemInfo("sex"));
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
			sic.add(new SelectorItemInfo("cooperationid.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("cooperationid.id"));
        	sic.add(new SelectorItemInfo("cooperationid.number"));
        	sic.add(new SelectorItemInfo("cooperationid.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("workOrgId.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("workOrgId.id"));
        	sic.add(new SelectorItemInfo("workOrgId.number"));
        	sic.add(new SelectorItemInfo("workOrgId.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("checkRuleId.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("checkRuleId.id"));
        	sic.add(new SelectorItemInfo("checkRuleId.number"));
        	sic.add(new SelectorItemInfo("checkRuleId.name"));
		}
        sic.add(new SelectorItemInfo("CheckNo"));
        sic.add(new SelectorItemInfo("CheckSysDepNo"));
        sic.add(new SelectorItemInfo("IdNum"));
        sic.add(new SelectorItemInfo("passpNum"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.attendance.client", "AttencePersonEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.zjlw.attendance.client.AttencePersonEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.attendance.AttencePersonFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.attendance.AttencePersonInfo objectValue = new com.kingdee.eas.zjlw.attendance.AttencePersonInfo();
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
		vo.put("sex",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}