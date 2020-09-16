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
public abstract class AbstractCooprationEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCooprationEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshortName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbsLicCode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcapital;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contorgNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttaxCode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlegalPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsptor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrspEffTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrspEndTime;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisRspIdf;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisRspTran;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlevel;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHaveConQlf;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHaveLbrExp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmail;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproCom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttelphone;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtshortName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbsLicCode;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcapital;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtorgNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttaxCode;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlegalPerson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsptor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrspEffTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrspEndTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.swing.KDComboBox level;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmail;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtproCom;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttelphone;
    protected com.kingdee.eas.zjlw.baseinfo.CooprationInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCooprationEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCooprationEditUI.class.getName());
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
        this.contshortName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbsLicCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcapital = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contorgNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttaxCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlegalPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsptor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrspEffTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrspEndTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisRspIdf = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisRspTran = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlevel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHaveConQlf = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisHaveLbrExp = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contmail = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproCom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttelphone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtshortName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbsLicCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcapital = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtorgNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttaxCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbank = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtlegalPerson = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsptor = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkrspEffTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkrspEndTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.level = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtmail = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtproCom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttelphone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contshortName.setName("contshortName");
        this.contbsLicCode.setName("contbsLicCode");
        this.contcapital.setName("contcapital");
        this.contorgNumber.setName("contorgNumber");
        this.conttaxCode.setName("conttaxCode");
        this.contbank.setName("contbank");
        this.contlegalPerson.setName("contlegalPerson");
        this.contsptor.setName("contsptor");
        this.contrspEffTime.setName("contrspEffTime");
        this.contrspEndTime.setName("contrspEndTime");
        this.chkisRspIdf.setName("chkisRspIdf");
        this.chkisRspTran.setName("chkisRspTran");
        this.contaddress.setName("contaddress");
        this.contlevel.setName("contlevel");
        this.chkisHaveConQlf.setName("chkisHaveConQlf");
        this.chkisHaveLbrExp.setName("chkisHaveLbrExp");
        this.contmail.setName("contmail");
        this.contproCom.setName("contproCom");
        this.conttelphone.setName("conttelphone");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtshortName.setName("txtshortName");
        this.txtbsLicCode.setName("txtbsLicCode");
        this.txtcapital.setName("txtcapital");
        this.txtorgNumber.setName("txtorgNumber");
        this.txttaxCode.setName("txttaxCode");
        this.txtbank.setName("txtbank");
        this.txtlegalPerson.setName("txtlegalPerson");
        this.txtsptor.setName("txtsptor");
        this.pkrspEffTime.setName("pkrspEffTime");
        this.pkrspEndTime.setName("pkrspEndTime");
        this.txtaddress.setName("txtaddress");
        this.level.setName("level");
        this.txtmail.setName("txtmail");
        this.prmtproCom.setName("prmtproCom");
        this.txttelphone.setName("txttelphone");
        // CoreUI		
        this.btnAddNew.setVisible(false);		
        this.btnSubmit.setVisible(false);		
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
        this.contCreator.setVisible(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contCreateTime.setVisible(false);
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
        this.contBizDate.setVisible(false);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setVisible(false);
        // contshortName		
        this.contshortName.setBoundLabelText(resHelper.getString("contshortName.boundLabelText"));		
        this.contshortName.setBoundLabelLength(100);		
        this.contshortName.setBoundLabelUnderline(true);		
        this.contshortName.setVisible(true);
        // contbsLicCode		
        this.contbsLicCode.setBoundLabelText(resHelper.getString("contbsLicCode.boundLabelText"));		
        this.contbsLicCode.setBoundLabelLength(100);		
        this.contbsLicCode.setBoundLabelUnderline(true);		
        this.contbsLicCode.setVisible(true);
        // contcapital		
        this.contcapital.setBoundLabelText(resHelper.getString("contcapital.boundLabelText"));		
        this.contcapital.setBoundLabelLength(100);		
        this.contcapital.setBoundLabelUnderline(true);		
        this.contcapital.setVisible(true);
        // contorgNumber		
        this.contorgNumber.setBoundLabelText(resHelper.getString("contorgNumber.boundLabelText"));		
        this.contorgNumber.setBoundLabelLength(100);		
        this.contorgNumber.setBoundLabelUnderline(true);		
        this.contorgNumber.setVisible(true);
        // conttaxCode		
        this.conttaxCode.setBoundLabelText(resHelper.getString("conttaxCode.boundLabelText"));		
        this.conttaxCode.setBoundLabelLength(100);		
        this.conttaxCode.setBoundLabelUnderline(true);		
        this.conttaxCode.setVisible(true);
        // contbank		
        this.contbank.setBoundLabelText(resHelper.getString("contbank.boundLabelText"));		
        this.contbank.setBoundLabelLength(100);		
        this.contbank.setBoundLabelUnderline(true);		
        this.contbank.setVisible(true);
        // contlegalPerson		
        this.contlegalPerson.setBoundLabelText(resHelper.getString("contlegalPerson.boundLabelText"));		
        this.contlegalPerson.setBoundLabelLength(100);		
        this.contlegalPerson.setBoundLabelUnderline(true);		
        this.contlegalPerson.setVisible(true);
        // contsptor		
        this.contsptor.setBoundLabelText(resHelper.getString("contsptor.boundLabelText"));		
        this.contsptor.setBoundLabelLength(100);		
        this.contsptor.setBoundLabelUnderline(true);		
        this.contsptor.setVisible(true);
        // contrspEffTime		
        this.contrspEffTime.setBoundLabelText(resHelper.getString("contrspEffTime.boundLabelText"));		
        this.contrspEffTime.setBoundLabelLength(110);		
        this.contrspEffTime.setBoundLabelUnderline(true);		
        this.contrspEffTime.setVisible(true);
        // contrspEndTime		
        this.contrspEndTime.setBoundLabelText(resHelper.getString("contrspEndTime.boundLabelText"));		
        this.contrspEndTime.setBoundLabelLength(110);		
        this.contrspEndTime.setBoundLabelUnderline(true);		
        this.contrspEndTime.setVisible(true);
        // chkisRspIdf		
        this.chkisRspIdf.setText(resHelper.getString("chkisRspIdf.text"));		
        this.chkisRspIdf.setVisible(true);		
        this.chkisRspIdf.setHorizontalAlignment(2);
        // chkisRspTran		
        this.chkisRspTran.setText(resHelper.getString("chkisRspTran.text"));		
        this.chkisRspTran.setVisible(true);		
        this.chkisRspTran.setHorizontalAlignment(2);
        // contaddress		
        this.contaddress.setBoundLabelText(resHelper.getString("contaddress.boundLabelText"));		
        this.contaddress.setBoundLabelLength(100);		
        this.contaddress.setBoundLabelUnderline(true);		
        this.contaddress.setVisible(true);
        // contlevel		
        this.contlevel.setBoundLabelText(resHelper.getString("contlevel.boundLabelText"));		
        this.contlevel.setBoundLabelLength(100);		
        this.contlevel.setBoundLabelUnderline(true);		
        this.contlevel.setVisible(true);
        // chkisHaveConQlf		
        this.chkisHaveConQlf.setText(resHelper.getString("chkisHaveConQlf.text"));		
        this.chkisHaveConQlf.setVisible(true);		
        this.chkisHaveConQlf.setHorizontalAlignment(2);
        // chkisHaveLbrExp		
        this.chkisHaveLbrExp.setText(resHelper.getString("chkisHaveLbrExp.text"));		
        this.chkisHaveLbrExp.setVisible(true);		
        this.chkisHaveLbrExp.setHorizontalAlignment(2);
        // contmail		
        this.contmail.setBoundLabelText(resHelper.getString("contmail.boundLabelText"));		
        this.contmail.setBoundLabelLength(100);		
        this.contmail.setBoundLabelUnderline(true);		
        this.contmail.setVisible(true);
        // contproCom		
        this.contproCom.setBoundLabelText(resHelper.getString("contproCom.boundLabelText"));		
        this.contproCom.setBoundLabelLength(100);		
        this.contproCom.setBoundLabelUnderline(true);		
        this.contproCom.setVisible(true);
        // conttelphone		
        this.conttelphone.setBoundLabelText(resHelper.getString("conttelphone.boundLabelText"));		
        this.conttelphone.setBoundLabelLength(100);		
        this.conttelphone.setBoundLabelUnderline(true);		
        this.conttelphone.setVisible(true);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setVisible(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.kDDateCreateTime.setVisible(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.prmtLastUpdateUser.setVisible(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.kDDateLastUpdateTime.setVisible(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);
        // pkBizDate		
        this.pkBizDate.setVisible(false);		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setVisible(false);
        // txtshortName		
        this.txtshortName.setVisible(true);		
        this.txtshortName.setHorizontalAlignment(2);		
        this.txtshortName.setMaxLength(100);		
        this.txtshortName.setRequired(false);
        // txtbsLicCode		
        this.txtbsLicCode.setVisible(true);		
        this.txtbsLicCode.setHorizontalAlignment(2);		
        this.txtbsLicCode.setMaxLength(100);		
        this.txtbsLicCode.setRequired(false);
        // txtcapital		
        this.txtcapital.setVisible(true);		
        this.txtcapital.setHorizontalAlignment(2);		
        this.txtcapital.setDataType(1);		
        this.txtcapital.setSupportedEmpty(true);		
        this.txtcapital.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcapital.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcapital.setPrecision(2);		
        this.txtcapital.setRequired(false);
        // txtorgNumber		
        this.txtorgNumber.setVisible(true);		
        this.txtorgNumber.setHorizontalAlignment(2);		
        this.txtorgNumber.setMaxLength(100);		
        this.txtorgNumber.setRequired(false);
        // txttaxCode		
        this.txttaxCode.setVisible(true);		
        this.txttaxCode.setHorizontalAlignment(2);		
        this.txttaxCode.setMaxLength(100);		
        this.txttaxCode.setRequired(false);
        // txtbank		
        this.txtbank.setVisible(true);		
        this.txtbank.setHorizontalAlignment(2);		
        this.txtbank.setMaxLength(100);		
        this.txtbank.setRequired(false);
        // txtlegalPerson		
        this.txtlegalPerson.setVisible(true);		
        this.txtlegalPerson.setHorizontalAlignment(2);		
        this.txtlegalPerson.setMaxLength(100);		
        this.txtlegalPerson.setRequired(false);
        // txtsptor		
        this.txtsptor.setVisible(true);		
        this.txtsptor.setHorizontalAlignment(2);		
        this.txtsptor.setMaxLength(100);		
        this.txtsptor.setRequired(false);
        // pkrspEffTime		
        this.pkrspEffTime.setVisible(true);		
        this.pkrspEffTime.setRequired(false);
        // pkrspEndTime		
        this.pkrspEndTime.setVisible(true);		
        this.pkrspEndTime.setRequired(false);
        // txtaddress		
        this.txtaddress.setVisible(true);		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(100);		
        this.txtaddress.setRequired(false);
        // level		
        this.level.setVisible(true);		
        this.level.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.levelEnum").toArray());		
        this.level.setRequired(false);
        // txtmail		
        this.txtmail.setVisible(true);		
        this.txtmail.setHorizontalAlignment(2);		
        this.txtmail.setMaxLength(100);		
        this.txtmail.setRequired(false);
        // prmtproCom		
        this.prmtproCom.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtproCom.setVisible(true);		
        this.prmtproCom.setEditable(true);		
        this.prmtproCom.setDisplayFormat("$name$");		
        this.prmtproCom.setEditFormat("$number$");		
        this.prmtproCom.setCommitFormat("$number$");		
        this.prmtproCom.setRequired(false);		
        this.prmtproCom.setEnabled(false);
        // txttelphone		
        this.txttelphone.setVisible(true);		
        this.txttelphone.setHorizontalAlignment(2);		
        this.txttelphone.setMaxLength(100);		
        this.txttelphone.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtshortName,txtbsLicCode,txtcapital,txtorgNumber,txttaxCode,txtbank,txtlegalPerson,txtsptor,pkrspEffTime,pkrspEndTime,chkisRspIdf,chkisRspTran,txtaddress,level,chkisHaveConQlf,chkisHaveLbrExp,txtmail,prmtproCom,txttelphone}));
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
        this.setBounds(new Rectangle(0, 0, 982, 375));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(35, 380, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(42, 402, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(338, 379, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(337, 408, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(20, 18, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(613, 378, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(20, 340, 578, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(614, 404, 270, 19));
        this.add(contAuditor, null);
        contshortName.setBounds(new Rectangle(325, 64, 270, 19));
        this.add(contshortName, null);
        contbsLicCode.setBounds(new Rectangle(20, 64, 270, 19));
        this.add(contbsLicCode, null);
        contcapital.setBounds(new Rectangle(20, 110, 270, 19));
        this.add(contcapital, null);
        contorgNumber.setBounds(new Rectangle(20, 156, 270, 19));
        this.add(contorgNumber, null);
        conttaxCode.setBounds(new Rectangle(20, 248, 270, 19));
        this.add(conttaxCode, null);
        contbank.setBounds(new Rectangle(20, 202, 270, 19));
        this.add(contbank, null);
        contlegalPerson.setBounds(new Rectangle(690, 291, 270, 19));
        this.add(contlegalPerson, null);
        contsptor.setBounds(new Rectangle(325, 110, 270, 19));
        this.add(contsptor, null);
        contrspEffTime.setBounds(new Rectangle(325, 156, 270, 19));
        this.add(contrspEffTime, null);
        contrspEndTime.setBounds(new Rectangle(325, 202, 270, 19));
        this.add(contrspEndTime, null);
        chkisRspIdf.setBounds(new Rectangle(690, 108, 270, 19));
        this.add(chkisRspIdf, null);
        chkisRspTran.setBounds(new Rectangle(690, 18, 270, 19));
        this.add(chkisRspTran, null);
        contaddress.setBounds(new Rectangle(20, 294, 578, 19));
        this.add(contaddress, null);
        contlevel.setBounds(new Rectangle(325, 248, 270, 19));
        this.add(contlevel, null);
        chkisHaveConQlf.setBounds(new Rectangle(690, 63, 270, 19));
        this.add(chkisHaveConQlf, null);
        chkisHaveLbrExp.setBounds(new Rectangle(690, 153, 270, 19));
        this.add(chkisHaveLbrExp, null);
        contmail.setBounds(new Rectangle(690, 198, 270, 19));
        this.add(contmail, null);
        contproCom.setBounds(new Rectangle(325, 18, 270, 19));
        this.add(contproCom, null);
        conttelphone.setBounds(new Rectangle(690, 248, 270, 19));
        this.add(conttelphone, null);
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
        //contshortName
        contshortName.setBoundEditor(txtshortName);
        //contbsLicCode
        contbsLicCode.setBoundEditor(txtbsLicCode);
        //contcapital
        contcapital.setBoundEditor(txtcapital);
        //contorgNumber
        contorgNumber.setBoundEditor(txtorgNumber);
        //conttaxCode
        conttaxCode.setBoundEditor(txttaxCode);
        //contbank
        contbank.setBoundEditor(txtbank);
        //contlegalPerson
        contlegalPerson.setBoundEditor(txtlegalPerson);
        //contsptor
        contsptor.setBoundEditor(txtsptor);
        //contrspEffTime
        contrspEffTime.setBoundEditor(pkrspEffTime);
        //contrspEndTime
        contrspEndTime.setBoundEditor(pkrspEndTime);
        //contaddress
        contaddress.setBoundEditor(txtaddress);
        //contlevel
        contlevel.setBoundEditor(level);
        //contmail
        contmail.setBoundEditor(txtmail);
        //contproCom
        contproCom.setBoundEditor(prmtproCom);
        //conttelphone
        conttelphone.setBoundEditor(txttelphone);

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
		dataBinder.registerBinding("isRspIdf", boolean.class, this.chkisRspIdf, "selected");
		dataBinder.registerBinding("isRspTran", boolean.class, this.chkisRspTran, "selected");
		dataBinder.registerBinding("isHaveConQlf", boolean.class, this.chkisHaveConQlf, "selected");
		dataBinder.registerBinding("isHaveLbrExp", boolean.class, this.chkisHaveLbrExp, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("shortName", String.class, this.txtshortName, "text");
		dataBinder.registerBinding("bsLicCode", String.class, this.txtbsLicCode, "text");
		dataBinder.registerBinding("capital", java.math.BigDecimal.class, this.txtcapital, "value");
		dataBinder.registerBinding("orgNumber", String.class, this.txtorgNumber, "text");
		dataBinder.registerBinding("taxCode", String.class, this.txttaxCode, "text");
		dataBinder.registerBinding("bank", String.class, this.txtbank, "text");
		dataBinder.registerBinding("legalPerson", String.class, this.txtlegalPerson, "text");
		dataBinder.registerBinding("sptor", String.class, this.txtsptor, "text");
		dataBinder.registerBinding("rspEffTime", java.util.Date.class, this.pkrspEffTime, "value");
		dataBinder.registerBinding("rspEndTime", java.util.Date.class, this.pkrspEndTime, "value");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("level", com.kingdee.eas.zjlw.certificates.app.levelEnum.class, this.level, "selectedItem");
		dataBinder.registerBinding("mail", String.class, this.txtmail, "text");
		dataBinder.registerBinding("proCom", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtproCom, "data");
		dataBinder.registerBinding("telphone", String.class, this.txttelphone, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.baseinfo.app.CooprationEditUIHandler";
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
        this.txtshortName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.baseinfo.CooprationInfo)ov;
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
		getValidateHelper().registerBindProperty("isRspIdf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isRspTran", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHaveConQlf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHaveLbrExp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shortName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bsLicCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("capital", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("orgNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("taxCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("legalPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sptor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("rspEffTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("rspEndTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("level", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proCom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("telphone", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isRspIdf"));
        sic.add(new SelectorItemInfo("isRspTran"));
        sic.add(new SelectorItemInfo("isHaveConQlf"));
        sic.add(new SelectorItemInfo("isHaveLbrExp"));
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
        sic.add(new SelectorItemInfo("shortName"));
        sic.add(new SelectorItemInfo("bsLicCode"));
        sic.add(new SelectorItemInfo("capital"));
        sic.add(new SelectorItemInfo("orgNumber"));
        sic.add(new SelectorItemInfo("taxCode"));
        sic.add(new SelectorItemInfo("bank"));
        sic.add(new SelectorItemInfo("legalPerson"));
        sic.add(new SelectorItemInfo("sptor"));
        sic.add(new SelectorItemInfo("rspEffTime"));
        sic.add(new SelectorItemInfo("rspEndTime"));
        sic.add(new SelectorItemInfo("address"));
        sic.add(new SelectorItemInfo("level"));
        sic.add(new SelectorItemInfo("mail"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("proCom.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("proCom.id"));
        	sic.add(new SelectorItemInfo("proCom.number"));
        	sic.add(new SelectorItemInfo("proCom.name"));
		}
        sic.add(new SelectorItemInfo("telphone"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.client", "CooprationEditUI");
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
        return com.kingdee.eas.zjlw.baseinfo.client.CooprationEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.baseinfo.CooprationFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.baseinfo.CooprationInfo objectValue = new com.kingdee.eas.zjlw.baseinfo.CooprationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/baseinfo/Coopration";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.app.CooprationQuery");
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
		vo.put("level","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}