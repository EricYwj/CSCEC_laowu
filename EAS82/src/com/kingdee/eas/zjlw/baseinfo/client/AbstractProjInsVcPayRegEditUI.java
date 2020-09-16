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
public abstract class AbstractProjInsVcPayRegEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractProjInsVcPayRegEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojNameFr;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBankAccCptDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contIESS;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contInsRegAplDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contInsRegCptDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvcPayBru;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvcPayRegAplDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvcPayRegCptDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprojName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtprojNameFr;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkactBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBankAccCptDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtIESS;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkInsRegAplDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkInsRegCptDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtvcPayBru;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkvcPayRegAplDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkvcPayRegCptDate;
    protected com.kingdee.eas.zjlw.baseinfo.ProjInsVcPayRegInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractProjInsVcPayRegEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractProjInsVcPayRegEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        _tempStr = resHelper.getString("ActionPrint.SHORT_DESCRIPTION");
        actionPrint.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.LONG_DESCRIPTION");
        actionPrint.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.NAME");
        actionPrint.putValue(ItemAction.NAME, _tempStr);
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrintPreview
        actionPrintPreview.setEnabled(true);
        actionPrintPreview.setDaemonRun(false);

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl P"));
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojNameFr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBankAccCptDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contIESS = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contInsRegAplDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contInsRegCptDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvcPayBru = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvcPayRegAplDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvcPayRegCptDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtprojName = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtprojNameFr = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkactBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkBankAccCptDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtIESS = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkInsRegAplDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkInsRegCptDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtvcPayBru = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkvcPayRegAplDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkvcPayRegCptDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contprojName.setName("contprojName");
        this.contprojNameFr.setName("contprojNameFr");
        this.contactBeginDate.setName("contactBeginDate");
        this.contBankAccCptDate.setName("contBankAccCptDate");
        this.contIESS.setName("contIESS");
        this.contInsRegAplDate.setName("contInsRegAplDate");
        this.contInsRegCptDate.setName("contInsRegCptDate");
        this.contvcPayBru.setName("contvcPayBru");
        this.contvcPayRegAplDate.setName("contvcPayRegAplDate");
        this.contvcPayRegCptDate.setName("contvcPayRegCptDate");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtprojName.setName("prmtprojName");
        this.txtprojNameFr.setName("txtprojNameFr");
        this.pkactBeginDate.setName("pkactBeginDate");
        this.pkBankAccCptDate.setName("pkBankAccCptDate");
        this.txtIESS.setName("txtIESS");
        this.pkInsRegAplDate.setName("pkInsRegAplDate");
        this.pkInsRegCptDate.setName("pkInsRegCptDate");
        this.txtvcPayBru.setName("txtvcPayBru");
        this.pkvcPayRegAplDate.setName("pkvcPayRegAplDate");
        this.pkvcPayRegCptDate.setName("pkvcPayRegCptDate");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.menuItemCreateTo.setVisible(true);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuTable1.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemCopyLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // contCreator		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(false);
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contprojName		
        this.contprojName.setBoundLabelText(resHelper.getString("contprojName.boundLabelText"));		
        this.contprojName.setBoundLabelLength(100);		
        this.contprojName.setBoundLabelUnderline(true);		
        this.contprojName.setVisible(true);
        // contprojNameFr		
        this.contprojNameFr.setBoundLabelText(resHelper.getString("contprojNameFr.boundLabelText"));		
        this.contprojNameFr.setBoundLabelLength(100);		
        this.contprojNameFr.setBoundLabelUnderline(true);		
        this.contprojNameFr.setVisible(true);
        // contactBeginDate		
        this.contactBeginDate.setBoundLabelText(resHelper.getString("contactBeginDate.boundLabelText"));		
        this.contactBeginDate.setBoundLabelLength(100);		
        this.contactBeginDate.setBoundLabelUnderline(true);		
        this.contactBeginDate.setVisible(true);
        // contBankAccCptDate		
        this.contBankAccCptDate.setBoundLabelText(resHelper.getString("contBankAccCptDate.boundLabelText"));		
        this.contBankAccCptDate.setBoundLabelLength(140);		
        this.contBankAccCptDate.setBoundLabelUnderline(true);		
        this.contBankAccCptDate.setVisible(true);
        // contIESS		
        this.contIESS.setBoundLabelText(resHelper.getString("contIESS.boundLabelText"));		
        this.contIESS.setBoundLabelLength(100);		
        this.contIESS.setBoundLabelUnderline(true);		
        this.contIESS.setVisible(true);
        // contInsRegAplDate		
        this.contInsRegAplDate.setBoundLabelText(resHelper.getString("contInsRegAplDate.boundLabelText"));		
        this.contInsRegAplDate.setBoundLabelLength(140);		
        this.contInsRegAplDate.setBoundLabelUnderline(true);		
        this.contInsRegAplDate.setVisible(true);
        // contInsRegCptDate		
        this.contInsRegCptDate.setBoundLabelText(resHelper.getString("contInsRegCptDate.boundLabelText"));		
        this.contInsRegCptDate.setBoundLabelLength(140);		
        this.contInsRegCptDate.setBoundLabelUnderline(true);		
        this.contInsRegCptDate.setVisible(true);
        // contvcPayBru		
        this.contvcPayBru.setBoundLabelText(resHelper.getString("contvcPayBru.boundLabelText"));		
        this.contvcPayBru.setBoundLabelLength(100);		
        this.contvcPayBru.setBoundLabelUnderline(true);		
        this.contvcPayBru.setVisible(true);
        // contvcPayRegAplDate		
        this.contvcPayRegAplDate.setBoundLabelText(resHelper.getString("contvcPayRegAplDate.boundLabelText"));		
        this.contvcPayRegAplDate.setBoundLabelLength(140);		
        this.contvcPayRegAplDate.setBoundLabelUnderline(true);		
        this.contvcPayRegAplDate.setVisible(true);
        // contvcPayRegCptDate		
        this.contvcPayRegCptDate.setBoundLabelText(resHelper.getString("contvcPayRegCptDate.boundLabelText"));		
        this.contvcPayRegCptDate.setBoundLabelLength(140);		
        this.contvcPayRegCptDate.setBoundLabelUnderline(true);		
        this.contvcPayRegCptDate.setVisible(true);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // pkBizDate		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtprojName		
        this.prmtprojName.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtprojName.setVisible(true);		
        this.prmtprojName.setEditable(true);		
        this.prmtprojName.setDisplayFormat("$name$");		
        this.prmtprojName.setEditFormat("$number$");		
        this.prmtprojName.setCommitFormat("$number$");		
        this.prmtprojName.setRequired(false);
        // txtprojNameFr		
        this.txtprojNameFr.setVisible(true);		
        this.txtprojNameFr.setHorizontalAlignment(2);		
        this.txtprojNameFr.setMaxLength(200);		
        this.txtprojNameFr.setRequired(false);
        // pkactBeginDate		
        this.pkactBeginDate.setVisible(true);		
        this.pkactBeginDate.setRequired(false);
        // pkBankAccCptDate		
        this.pkBankAccCptDate.setVisible(true);		
        this.pkBankAccCptDate.setRequired(false);
        // txtIESS		
        this.txtIESS.setVisible(true);		
        this.txtIESS.setHorizontalAlignment(2);		
        this.txtIESS.setMaxLength(100);		
        this.txtIESS.setRequired(false);
        // pkInsRegAplDate		
        this.pkInsRegAplDate.setVisible(true);		
        this.pkInsRegAplDate.setRequired(false);
        // pkInsRegCptDate		
        this.pkInsRegCptDate.setVisible(true);		
        this.pkInsRegCptDate.setRequired(false);
        // txtvcPayBru		
        this.txtvcPayBru.setVisible(true);		
        this.txtvcPayBru.setHorizontalAlignment(2);		
        this.txtvcPayBru.setMaxLength(100);		
        this.txtvcPayBru.setRequired(false);
        // pkvcPayRegAplDate		
        this.pkvcPayRegAplDate.setVisible(true);		
        this.pkvcPayRegAplDate.setRequired(false);
        // pkvcPayRegCptDate		
        this.pkvcPayRegCptDate.setVisible(true);		
        this.pkvcPayRegCptDate.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtprojName,txtprojNameFr,pkactBeginDate,txtIESS}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 269));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(8, 134, 927, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contAuditor, null);
        contprojName.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contprojName, null);
        contprojNameFr.setBounds(new Rectangle(341, 34, 602, 19));
        this.add(contprojNameFr, null);
        contactBeginDate.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contactBeginDate, null);
        contBankAccCptDate.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contBankAccCptDate, null);
        contIESS.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contIESS, null);
        contInsRegAplDate.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contInsRegAplDate, null);
        contInsRegCptDate.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contInsRegCptDate, null);
        contvcPayBru.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contvcPayBru, null);
        contvcPayRegAplDate.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contvcPayRegAplDate, null);
        contvcPayRegCptDate.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contvcPayRegCptDate, null);
        kDLabelContainer1.setBounds(new Rectangle(9, 168, 729, 19));
        this.add(kDLabelContainer1, null);
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contprojName
        contprojName.setBoundEditor(prmtprojName);
        //contprojNameFr
        contprojNameFr.setBoundEditor(txtprojNameFr);
        //contactBeginDate
        contactBeginDate.setBoundEditor(pkactBeginDate);
        //contBankAccCptDate
        contBankAccCptDate.setBoundEditor(pkBankAccCptDate);
        //contIESS
        contIESS.setBoundEditor(txtIESS);
        //contInsRegAplDate
        contInsRegAplDate.setBoundEditor(pkInsRegAplDate);
        //contInsRegCptDate
        contInsRegCptDate.setBoundEditor(pkInsRegCptDate);
        //contvcPayBru
        contvcPayBru.setBoundEditor(txtvcPayBru);
        //contvcPayRegAplDate
        contvcPayRegAplDate.setBoundEditor(pkvcPayRegAplDate);
        //contvcPayRegCptDate
        contvcPayRegCptDate.setBoundEditor(pkvcPayRegCptDate);

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
        this.menuBar.add(menuTable1);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
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
        menuFile.add(kDSeparator6);
        menuFile.add(menuItemSendMail);
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
        menuEdit.add(separator1);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(separator2);
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
        menuView.add(separator3);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(kDSeparator7);
        menuView.add(menuItemLocate);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(kDMenuItemSendMessage);
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
        this.toolBar.add(btnSave);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
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
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("projName", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtprojName, "data");
		dataBinder.registerBinding("projNameFr", String.class, this.txtprojNameFr, "text");
		dataBinder.registerBinding("actBeginDate", java.util.Date.class, this.pkactBeginDate, "value");
		dataBinder.registerBinding("BankAccCptDate", java.util.Date.class, this.pkBankAccCptDate, "value");
		dataBinder.registerBinding("IESS", String.class, this.txtIESS, "text");
		dataBinder.registerBinding("InsRegAplDate", java.util.Date.class, this.pkInsRegAplDate, "value");
		dataBinder.registerBinding("InsRegCptDate", java.util.Date.class, this.pkInsRegCptDate, "value");
		dataBinder.registerBinding("vcPayBru", String.class, this.txtvcPayBru, "text");
		dataBinder.registerBinding("vcPayRegAplDate", java.util.Date.class, this.pkvcPayRegAplDate, "value");
		dataBinder.registerBinding("vcPayRegCptDate", java.util.Date.class, this.pkvcPayRegCptDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.baseinfo.app.ProjInsVcPayRegEditUIHandler";
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
        this.prmtprojName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.baseinfo.ProjInsVcPayRegInfo)ov;
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projNameFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actBeginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BankAccCptDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("IESS", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InsRegAplDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InsRegCptDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("vcPayBru", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("vcPayRegAplDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("vcPayRegCptDate", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("projName.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("projName.id"));
        	sic.add(new SelectorItemInfo("projName.number"));
        	sic.add(new SelectorItemInfo("projName.name"));
		}
        sic.add(new SelectorItemInfo("projNameFr"));
        sic.add(new SelectorItemInfo("actBeginDate"));
        sic.add(new SelectorItemInfo("BankAccCptDate"));
        sic.add(new SelectorItemInfo("IESS"));
        sic.add(new SelectorItemInfo("InsRegAplDate"));
        sic.add(new SelectorItemInfo("InsRegCptDate"));
        sic.add(new SelectorItemInfo("vcPayBru"));
        sic.add(new SelectorItemInfo("vcPayRegAplDate"));
        sic.add(new SelectorItemInfo("vcPayRegCptDate"));
        return sic;
    }        
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
    	if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSubmit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmit() {
    	return false;
    }
	public RequestContext prepareActionPrint(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrint(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrint() {
    	return false;
    }
	public RequestContext prepareActionPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrintPreview(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintPreview() {
    	return false;
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.client", "ProjInsVcPayRegEditUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.zjlw.baseinfo.client.ProjInsVcPayRegEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.baseinfo.ProjInsVcPayRegFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.baseinfo.ProjInsVcPayRegInfo objectValue = new com.kingdee.eas.zjlw.baseinfo.ProjInsVcPayRegInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/baseinfo/ProjInsVcPayReg";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.app.ProjInsVcPayRegQuery");
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