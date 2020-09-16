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
public abstract class AbstractCertAddEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCertAddEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfullName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsex;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproProvince;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contphotoNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmailbox;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqqNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwechatNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbelongArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrespContent;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfullName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox sex;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtworkPro;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtproProvince;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtphotoNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmailbox;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtqqNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtwechatNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtremark;
    protected com.kingdee.bos.ctrl.swing.KDComboBox belongArea;
    protected com.kingdee.bos.ctrl.swing.KDComboBox respContent;
    protected com.kingdee.eas.zjlw.baseinfo.CertAddInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCertAddEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCertAddEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfullName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsex = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproProvince = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contphotoNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmailbox = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqqNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwechatNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbelongArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrespContent = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtfullName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.sex = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtworkPro = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtproProvince = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtphotoNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmailbox = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtqqNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtwechatNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.belongArea = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.respContent = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contfullName.setName("contfullName");
        this.contsex.setName("contsex");
        this.contworkPro.setName("contworkPro");
        this.contproProvince.setName("contproProvince");
        this.contphotoNum.setName("contphotoNum");
        this.contmailbox.setName("contmailbox");
        this.contqqNum.setName("contqqNum");
        this.contwechatNum.setName("contwechatNum");
        this.contremark.setName("contremark");
        this.contbelongArea.setName("contbelongArea");
        this.contrespContent.setName("contrespContent");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtfullName.setName("txtfullName");
        this.sex.setName("sex");
        this.prmtworkPro.setName("prmtworkPro");
        this.prmtproProvince.setName("prmtproProvince");
        this.txtphotoNum.setName("txtphotoNum");
        this.txtmailbox.setName("txtmailbox");
        this.txtqqNum.setName("txtqqNum");
        this.txtwechatNum.setName("txtwechatNum");
        this.txtremark.setName("txtremark");
        this.belongArea.setName("belongArea");
        this.respContent.setName("respContent");
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
        // contfullName		
        this.contfullName.setBoundLabelText(resHelper.getString("contfullName.boundLabelText"));		
        this.contfullName.setBoundLabelLength(100);		
        this.contfullName.setBoundLabelUnderline(true);		
        this.contfullName.setVisible(true);
        // contsex		
        this.contsex.setBoundLabelText(resHelper.getString("contsex.boundLabelText"));		
        this.contsex.setBoundLabelLength(100);		
        this.contsex.setBoundLabelUnderline(true);		
        this.contsex.setVisible(true);
        // contworkPro		
        this.contworkPro.setBoundLabelText(resHelper.getString("contworkPro.boundLabelText"));		
        this.contworkPro.setBoundLabelLength(100);		
        this.contworkPro.setBoundLabelUnderline(true);		
        this.contworkPro.setVisible(true);
        // contproProvince		
        this.contproProvince.setBoundLabelText(resHelper.getString("contproProvince.boundLabelText"));		
        this.contproProvince.setBoundLabelLength(100);		
        this.contproProvince.setBoundLabelUnderline(true);		
        this.contproProvince.setVisible(true);
        // contphotoNum		
        this.contphotoNum.setBoundLabelText(resHelper.getString("contphotoNum.boundLabelText"));		
        this.contphotoNum.setBoundLabelLength(100);		
        this.contphotoNum.setBoundLabelUnderline(true);		
        this.contphotoNum.setVisible(true);
        // contmailbox		
        this.contmailbox.setBoundLabelText(resHelper.getString("contmailbox.boundLabelText"));		
        this.contmailbox.setBoundLabelLength(100);		
        this.contmailbox.setBoundLabelUnderline(true);		
        this.contmailbox.setVisible(true);
        // contqqNum		
        this.contqqNum.setBoundLabelText(resHelper.getString("contqqNum.boundLabelText"));		
        this.contqqNum.setBoundLabelLength(100);		
        this.contqqNum.setBoundLabelUnderline(true);		
        this.contqqNum.setVisible(true);
        // contwechatNum		
        this.contwechatNum.setBoundLabelText(resHelper.getString("contwechatNum.boundLabelText"));		
        this.contwechatNum.setBoundLabelLength(100);		
        this.contwechatNum.setBoundLabelUnderline(true);		
        this.contwechatNum.setVisible(true);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(100);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // contbelongArea		
        this.contbelongArea.setBoundLabelText(resHelper.getString("contbelongArea.boundLabelText"));		
        this.contbelongArea.setBoundLabelLength(100);		
        this.contbelongArea.setBoundLabelUnderline(true);		
        this.contbelongArea.setVisible(true);
        // contrespContent		
        this.contrespContent.setBoundLabelText(resHelper.getString("contrespContent.boundLabelText"));		
        this.contrespContent.setBoundLabelLength(100);		
        this.contrespContent.setBoundLabelUnderline(true);		
        this.contrespContent.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtfullName		
        this.txtfullName.setHorizontalAlignment(2);		
        this.txtfullName.setMaxLength(100);		
        this.txtfullName.setRequired(false);
        // sex		
        this.sex.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());		
        this.sex.setRequired(false);
        // prmtworkPro		
        this.prmtworkPro.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtworkPro.setEditable(true);		
        this.prmtworkPro.setDisplayFormat("$name$");		
        this.prmtworkPro.setEditFormat("$number$");		
        this.prmtworkPro.setCommitFormat("$number$");		
        this.prmtworkPro.setRequired(false);
        // prmtproProvince		
        this.prmtproProvince.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");		
        this.prmtproProvince.setEditable(true);		
        this.prmtproProvince.setDisplayFormat("$name$");		
        this.prmtproProvince.setEditFormat("$number$");		
        this.prmtproProvince.setCommitFormat("$number$");		
        this.prmtproProvince.setRequired(false);
        // txtphotoNum		
        this.txtphotoNum.setHorizontalAlignment(2);		
        this.txtphotoNum.setMaxLength(100);		
        this.txtphotoNum.setRequired(false);
        // txtmailbox		
        this.txtmailbox.setHorizontalAlignment(2);		
        this.txtmailbox.setMaxLength(100);		
        this.txtmailbox.setRequired(false);
        // txtqqNum		
        this.txtqqNum.setHorizontalAlignment(2);		
        this.txtqqNum.setMaxLength(100);		
        this.txtqqNum.setRequired(false);
        // txtwechatNum		
        this.txtwechatNum.setHorizontalAlignment(2);		
        this.txtwechatNum.setMaxLength(100);		
        this.txtwechatNum.setRequired(false);
        // txtremark		
        this.txtremark.setHorizontalAlignment(2);		
        this.txtremark.setMaxLength(100);		
        this.txtremark.setRequired(false);
        // belongArea		
        this.belongArea.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum").toArray());		
        this.belongArea.setRequired(false);
        // respContent		
        this.respContent.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.RespContentEnum").toArray());		
        this.respContent.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtfullName,sex,prmtworkPro,belongArea,prmtproProvince,respContent,txtphotoNum,txtqqNum,txtmailbox,txtwechatNum,txtremark,txtName,txtNumber,txtDescription,txtSimpleName}));
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
        this.setBounds(new Rectangle(0, 0, 670, 220));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(541, 318, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(535, 236, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(537, 273, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(543, 370, 270, 19));
        this.add(kDLabelContainer4, null);
        contfullName.setBounds(new Rectangle(16, 8, 270, 19));
        this.add(contfullName, null);
        contsex.setBounds(new Rectangle(353, 8, 270, 19));
        this.add(contsex, null);
        contworkPro.setBounds(new Rectangle(16, 37, 270, 19));
        this.add(contworkPro, null);
        contproProvince.setBounds(new Rectangle(16, 66, 270, 19));
        this.add(contproProvince, null);
        contphotoNum.setBounds(new Rectangle(16, 95, 270, 19));
        this.add(contphotoNum, null);
        contmailbox.setBounds(new Rectangle(16, 127, 270, 19));
        this.add(contmailbox, null);
        contqqNum.setBounds(new Rectangle(353, 95, 270, 19));
        this.add(contqqNum, null);
        contwechatNum.setBounds(new Rectangle(353, 127, 270, 19));
        this.add(contwechatNum, null);
        contremark.setBounds(new Rectangle(16, 170, 607, 33));
        this.add(contremark, null);
        contbelongArea.setBounds(new Rectangle(353, 37, 270, 19));
        this.add(contbelongArea, null);
        contrespContent.setBounds(new Rectangle(353, 66, 270, 19));
        this.add(contrespContent, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contfullName
        contfullName.setBoundEditor(txtfullName);
        //contsex
        contsex.setBoundEditor(sex);
        //contworkPro
        contworkPro.setBoundEditor(prmtworkPro);
        //contproProvince
        contproProvince.setBoundEditor(prmtproProvince);
        //contphotoNum
        contphotoNum.setBoundEditor(txtphotoNum);
        //contmailbox
        contmailbox.setBoundEditor(txtmailbox);
        //contqqNum
        contqqNum.setBoundEditor(txtqqNum);
        //contwechatNum
        contwechatNum.setBoundEditor(txtwechatNum);
        //contremark
        contremark.setBoundEditor(txtremark);
        //contbelongArea
        contbelongArea.setBoundEditor(belongArea);
        //contrespContent
        contrespContent.setBoundEditor(respContent);

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
		dataBinder.registerBinding("fullName", String.class, this.txtfullName, "text");
		dataBinder.registerBinding("sex", com.kingdee.eas.basedata.person.Genders.class, this.sex, "selectedItem");
		dataBinder.registerBinding("workPro", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtworkPro, "data");
		dataBinder.registerBinding("proProvince", com.kingdee.eas.basedata.assistant.ProvinceInfo.class, this.prmtproProvince, "data");
		dataBinder.registerBinding("photoNum", String.class, this.txtphotoNum, "text");
		dataBinder.registerBinding("mailbox", String.class, this.txtmailbox, "text");
		dataBinder.registerBinding("qqNum", String.class, this.txtqqNum, "text");
		dataBinder.registerBinding("wechatNum", String.class, this.txtwechatNum, "text");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("belongArea", com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum.class, this.belongArea, "selectedItem");
		dataBinder.registerBinding("respContent", com.kingdee.eas.zjlw.certificates.app.RespContentEnum.class, this.respContent, "selectedItem");		
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
	    return "com.kingdee.eas.zjlw.baseinfo.app.CertAddEditUIHandler";
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
        this.txtfullName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.baseinfo.CertAddInfo)ov;
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
		getValidateHelper().registerBindProperty("fullName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proProvince", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("photoNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mailbox", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qqNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wechatNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("belongArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("respContent", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("fullName"));
        sic.add(new SelectorItemInfo("sex"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("workPro.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("workPro.id"));
        	sic.add(new SelectorItemInfo("workPro.number"));
        	sic.add(new SelectorItemInfo("workPro.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("proProvince.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("proProvince.id"));
        	sic.add(new SelectorItemInfo("proProvince.number"));
        	sic.add(new SelectorItemInfo("proProvince.name"));
		}
        sic.add(new SelectorItemInfo("photoNum"));
        sic.add(new SelectorItemInfo("mailbox"));
        sic.add(new SelectorItemInfo("qqNum"));
        sic.add(new SelectorItemInfo("wechatNum"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("belongArea"));
        sic.add(new SelectorItemInfo("respContent"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.client", "CertAddEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.zjlw.baseinfo.client.CertAddEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.baseinfo.CertAddFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.baseinfo.CertAddInfo objectValue = new com.kingdee.eas.zjlw.baseinfo.CertAddInfo();
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
vo.put("belongArea","0");
vo.put("respContent","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}