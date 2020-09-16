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
public abstract class AbstractProjectOrgEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractProjectOrgEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continsEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpermitEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continsuranceAcc;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contProjConnector;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitialDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontructTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contProjManager;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contowner;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprovince;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdprtName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnameFR;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddressFR;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproCom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconExpDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconSgnDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvcPayAcc;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contVPAccEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpmtEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisLogin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continExtAccount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDistrGov;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continEmploBur;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continLabSupBur;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continLeaveOff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continSocialSeBur;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continLaborBureau;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continPoliceOff;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinsEndDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkpermitEndDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkactEndDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinsuranceAcc;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtProjConnector;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkactBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinitialDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcontructTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox projStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtProjManager;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtowner;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprovince;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdprtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnameFR;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddressFR;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtproCom;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkconExpDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkconSgnDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtvcPayAcc;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkVPAccEndDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkpmtEndDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox area;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinExtAccount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinDistrGov;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinEmploBur;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinLabSupBur;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinLeaveOff;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinSocialSeBur;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtinLaborBureau;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinPoliceOff;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractProjectOrgEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractProjectOrgEditUI.class.getName());
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
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.continsEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpermitEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continsuranceAcc = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contProjConnector = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitialDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontructTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contProjManager = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contowner = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprovince = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdprtName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnameFR = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaddressFR = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproCom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconExpDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconSgnDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvcPayAcc = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contVPAccEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpmtEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisLogin = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.continExtAccount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDistrGov = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continEmploBur = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continLabSupBur = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continLeaveOff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continSocialSeBur = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continLaborBureau = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continPoliceOff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pkinsEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkpermitEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkactEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtinsuranceAcc = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtProjConnector = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkactBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkinitialDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtcontructTime = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.projStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtProjManager = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtowner = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtprovince = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdprtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtnameFR = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaddressFR = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtproCom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkconExpDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkconSgnDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtvcPayAcc = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkVPAccEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkpmtEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.area = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinExtAccount = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinDistrGov = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinEmploBur = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinLabSupBur = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinLeaveOff = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinSocialSeBur = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtinLaborBureau = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtinPoliceOff = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.continsEndDate.setName("continsEndDate");
        this.contpermitEndDate.setName("contpermitEndDate");
        this.contactEndDate.setName("contactEndDate");
        this.contendDate.setName("contendDate");
        this.continsuranceAcc.setName("continsuranceAcc");
        this.contProjConnector.setName("contProjConnector");
        this.contactBeginDate.setName("contactBeginDate");
        this.continitialDate.setName("continitialDate");
        this.contcontructTime.setName("contcontructTime");
        this.contprojStatus.setName("contprojStatus");
        this.contProjManager.setName("contProjManager");
        this.contowner.setName("contowner");
        this.contprovince.setName("contprovince");
        this.contdprtName.setName("contdprtName");
        this.contnameFR.setName("contnameFR");
        this.contaddressFR.setName("contaddressFR");
        this.contproCom.setName("contproCom");
        this.contconExpDate.setName("contconExpDate");
        this.contconSgnDate.setName("contconSgnDate");
        this.contvcPayAcc.setName("contvcPayAcc");
        this.contVPAccEndDate.setName("contVPAccEndDate");
        this.contpmtEndDate.setName("contpmtEndDate");
        this.contarea.setName("contarea");
        this.contDescription.setName("contDescription");
        this.chkisLogin.setName("chkisLogin");
        this.continExtAccount.setName("continExtAccount");
        this.continDistrGov.setName("continDistrGov");
        this.continEmploBur.setName("continEmploBur");
        this.continLabSupBur.setName("continLabSupBur");
        this.continLeaveOff.setName("continLeaveOff");
        this.continSocialSeBur.setName("continSocialSeBur");
        this.continLaborBureau.setName("continLaborBureau");
        this.continPoliceOff.setName("continPoliceOff");
        this.pkinsEndDate.setName("pkinsEndDate");
        this.pkpermitEndDate.setName("pkpermitEndDate");
        this.pkactEndDate.setName("pkactEndDate");
        this.pkendDate.setName("pkendDate");
        this.txtinsuranceAcc.setName("txtinsuranceAcc");
        this.txtProjConnector.setName("txtProjConnector");
        this.pkactBeginDate.setName("pkactBeginDate");
        this.pkinitialDate.setName("pkinitialDate");
        this.txtcontructTime.setName("txtcontructTime");
        this.projStatus.setName("projStatus");
        this.txtProjManager.setName("txtProjManager");
        this.txtowner.setName("txtowner");
        this.prmtprovince.setName("prmtprovince");
        this.prmtdprtName.setName("prmtdprtName");
        this.txtnameFR.setName("txtnameFR");
        this.txtaddressFR.setName("txtaddressFR");
        this.prmtproCom.setName("prmtproCom");
        this.pkconExpDate.setName("pkconExpDate");
        this.pkconSgnDate.setName("pkconSgnDate");
        this.txtvcPayAcc.setName("txtvcPayAcc");
        this.pkVPAccEndDate.setName("pkVPAccEndDate");
        this.pkpmtEndDate.setName("pkpmtEndDate");
        this.area.setName("area");
        this.txtDescription.setName("txtDescription");
        this.txtinExtAccount.setName("txtinExtAccount");
        this.txtinDistrGov.setName("txtinDistrGov");
        this.txtinEmploBur.setName("txtinEmploBur");
        this.txtinLabSupBur.setName("txtinLabSupBur");
        this.txtinLeaveOff.setName("txtinLeaveOff");
        this.txtinSocialSeBur.setName("txtinSocialSeBur");
        this.prmtinLaborBureau.setName("prmtinLaborBureau");
        this.txtinPoliceOff.setName("txtinPoliceOff");
        this.kDTable1.setName("kDTable1");
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setVisible(false);
        // kDTabbedPane1
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));
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
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setVisible(false);
        // kDPanel1
        // kDPanel2
        // continsEndDate		
        this.continsEndDate.setBoundLabelText(resHelper.getString("continsEndDate.boundLabelText"));		
        this.continsEndDate.setBoundLabelLength(100);		
        this.continsEndDate.setBoundLabelUnderline(true);		
        this.continsEndDate.setVisible(true);
        // contpermitEndDate		
        this.contpermitEndDate.setBoundLabelText(resHelper.getString("contpermitEndDate.boundLabelText"));		
        this.contpermitEndDate.setBoundLabelLength(100);		
        this.contpermitEndDate.setBoundLabelUnderline(true);		
        this.contpermitEndDate.setVisible(true);
        // contactEndDate		
        this.contactEndDate.setBoundLabelText(resHelper.getString("contactEndDate.boundLabelText"));		
        this.contactEndDate.setBoundLabelLength(100);		
        this.contactEndDate.setBoundLabelUnderline(true);		
        this.contactEndDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // continsuranceAcc		
        this.continsuranceAcc.setBoundLabelText(resHelper.getString("continsuranceAcc.boundLabelText"));		
        this.continsuranceAcc.setBoundLabelLength(100);		
        this.continsuranceAcc.setBoundLabelUnderline(true);		
        this.continsuranceAcc.setVisible(true);
        // contProjConnector		
        this.contProjConnector.setBoundLabelText(resHelper.getString("contProjConnector.boundLabelText"));		
        this.contProjConnector.setBoundLabelLength(100);		
        this.contProjConnector.setBoundLabelUnderline(true);		
        this.contProjConnector.setVisible(true);
        // contactBeginDate		
        this.contactBeginDate.setBoundLabelText(resHelper.getString("contactBeginDate.boundLabelText"));		
        this.contactBeginDate.setBoundLabelLength(100);		
        this.contactBeginDate.setBoundLabelUnderline(true);		
        this.contactBeginDate.setVisible(true);
        // continitialDate		
        this.continitialDate.setBoundLabelText(resHelper.getString("continitialDate.boundLabelText"));		
        this.continitialDate.setBoundLabelLength(100);		
        this.continitialDate.setBoundLabelUnderline(true);		
        this.continitialDate.setVisible(true);
        // contcontructTime		
        this.contcontructTime.setBoundLabelText(resHelper.getString("contcontructTime.boundLabelText"));		
        this.contcontructTime.setBoundLabelLength(100);		
        this.contcontructTime.setBoundLabelUnderline(true);		
        this.contcontructTime.setVisible(true);
        // contprojStatus		
        this.contprojStatus.setBoundLabelText(resHelper.getString("contprojStatus.boundLabelText"));		
        this.contprojStatus.setBoundLabelLength(100);		
        this.contprojStatus.setBoundLabelUnderline(true);		
        this.contprojStatus.setVisible(true);
        // contProjManager		
        this.contProjManager.setBoundLabelText(resHelper.getString("contProjManager.boundLabelText"));		
        this.contProjManager.setBoundLabelLength(100);		
        this.contProjManager.setBoundLabelUnderline(true);		
        this.contProjManager.setVisible(true);
        // contowner		
        this.contowner.setBoundLabelText(resHelper.getString("contowner.boundLabelText"));		
        this.contowner.setBoundLabelLength(100);		
        this.contowner.setBoundLabelUnderline(true);		
        this.contowner.setVisible(true);
        // contprovince		
        this.contprovince.setBoundLabelText(resHelper.getString("contprovince.boundLabelText"));		
        this.contprovince.setBoundLabelLength(100);		
        this.contprovince.setBoundLabelUnderline(true);		
        this.contprovince.setVisible(true);
        // contdprtName		
        this.contdprtName.setBoundLabelText(resHelper.getString("contdprtName.boundLabelText"));		
        this.contdprtName.setBoundLabelLength(100);		
        this.contdprtName.setBoundLabelUnderline(true);		
        this.contdprtName.setVisible(true);
        // contnameFR		
        this.contnameFR.setBoundLabelText(resHelper.getString("contnameFR.boundLabelText"));		
        this.contnameFR.setBoundLabelLength(100);		
        this.contnameFR.setBoundLabelUnderline(true);		
        this.contnameFR.setVisible(true);
        // contaddressFR		
        this.contaddressFR.setBoundLabelText(resHelper.getString("contaddressFR.boundLabelText"));		
        this.contaddressFR.setBoundLabelLength(100);		
        this.contaddressFR.setBoundLabelUnderline(true);		
        this.contaddressFR.setVisible(true);
        // contproCom		
        this.contproCom.setBoundLabelText(resHelper.getString("contproCom.boundLabelText"));		
        this.contproCom.setBoundLabelLength(100);		
        this.contproCom.setBoundLabelUnderline(true);		
        this.contproCom.setVisible(true);
        // contconExpDate		
        this.contconExpDate.setBoundLabelText(resHelper.getString("contconExpDate.boundLabelText"));		
        this.contconExpDate.setBoundLabelLength(100);		
        this.contconExpDate.setBoundLabelUnderline(true);		
        this.contconExpDate.setVisible(true);
        // contconSgnDate		
        this.contconSgnDate.setBoundLabelText(resHelper.getString("contconSgnDate.boundLabelText"));		
        this.contconSgnDate.setBoundLabelLength(100);		
        this.contconSgnDate.setBoundLabelUnderline(true);		
        this.contconSgnDate.setVisible(true);
        // contvcPayAcc		
        this.contvcPayAcc.setBoundLabelText(resHelper.getString("contvcPayAcc.boundLabelText"));		
        this.contvcPayAcc.setBoundLabelLength(100);		
        this.contvcPayAcc.setBoundLabelUnderline(true);		
        this.contvcPayAcc.setVisible(true);
        // contVPAccEndDate		
        this.contVPAccEndDate.setBoundLabelText(resHelper.getString("contVPAccEndDate.boundLabelText"));		
        this.contVPAccEndDate.setBoundLabelLength(120);		
        this.contVPAccEndDate.setBoundLabelUnderline(true);		
        this.contVPAccEndDate.setVisible(true);
        // contpmtEndDate		
        this.contpmtEndDate.setBoundLabelText(resHelper.getString("contpmtEndDate.boundLabelText"));		
        this.contpmtEndDate.setBoundLabelLength(100);		
        this.contpmtEndDate.setBoundLabelUnderline(true);		
        this.contpmtEndDate.setVisible(true);
        // contarea		
        this.contarea.setBoundLabelText(resHelper.getString("contarea.boundLabelText"));		
        this.contarea.setBoundLabelLength(100);		
        this.contarea.setBoundLabelUnderline(true);		
        this.contarea.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // chkisLogin		
        this.chkisLogin.setText(resHelper.getString("chkisLogin.text"));		
        this.chkisLogin.setHorizontalAlignment(2);
        // continExtAccount		
        this.continExtAccount.setBoundLabelText(resHelper.getString("continExtAccount.boundLabelText"));		
        this.continExtAccount.setBoundLabelLength(100);		
        this.continExtAccount.setBoundLabelUnderline(true);		
        this.continExtAccount.setVisible(true);
        // continDistrGov		
        this.continDistrGov.setBoundLabelText(resHelper.getString("continDistrGov.boundLabelText"));		
        this.continDistrGov.setBoundLabelLength(100);		
        this.continDistrGov.setBoundLabelUnderline(true);		
        this.continDistrGov.setVisible(true);
        // continEmploBur		
        this.continEmploBur.setBoundLabelText(resHelper.getString("continEmploBur.boundLabelText"));		
        this.continEmploBur.setBoundLabelLength(100);		
        this.continEmploBur.setBoundLabelUnderline(true);		
        this.continEmploBur.setVisible(true);
        // continLabSupBur		
        this.continLabSupBur.setBoundLabelText(resHelper.getString("continLabSupBur.boundLabelText"));		
        this.continLabSupBur.setBoundLabelLength(100);		
        this.continLabSupBur.setBoundLabelUnderline(true);		
        this.continLabSupBur.setVisible(true);
        // continLeaveOff		
        this.continLeaveOff.setBoundLabelText(resHelper.getString("continLeaveOff.boundLabelText"));		
        this.continLeaveOff.setBoundLabelLength(100);		
        this.continLeaveOff.setBoundLabelUnderline(true);		
        this.continLeaveOff.setVisible(true);
        // continSocialSeBur		
        this.continSocialSeBur.setBoundLabelText(resHelper.getString("continSocialSeBur.boundLabelText"));		
        this.continSocialSeBur.setBoundLabelLength(100);		
        this.continSocialSeBur.setBoundLabelUnderline(true);		
        this.continSocialSeBur.setVisible(true);
        // continLaborBureau		
        this.continLaborBureau.setBoundLabelText(resHelper.getString("continLaborBureau.boundLabelText"));		
        this.continLaborBureau.setBoundLabelLength(100);		
        this.continLaborBureau.setBoundLabelUnderline(true);		
        this.continLaborBureau.setVisible(true);
        // continPoliceOff		
        this.continPoliceOff.setBoundLabelText(resHelper.getString("continPoliceOff.boundLabelText"));		
        this.continPoliceOff.setBoundLabelLength(100);		
        this.continPoliceOff.setBoundLabelUnderline(true);		
        this.continPoliceOff.setVisible(true);
        // pkinsEndDate		
        this.pkinsEndDate.setRequired(false);
        // pkpermitEndDate		
        this.pkpermitEndDate.setRequired(false);
        // pkactEndDate		
        this.pkactEndDate.setRequired(false);
        // pkendDate		
        this.pkendDate.setRequired(false);
        // txtinsuranceAcc		
        this.txtinsuranceAcc.setHorizontalAlignment(2);		
        this.txtinsuranceAcc.setMaxLength(100);		
        this.txtinsuranceAcc.setRequired(false);
        // txtProjConnector		
        this.txtProjConnector.setHorizontalAlignment(2);		
        this.txtProjConnector.setMaxLength(100);		
        this.txtProjConnector.setRequired(false);
        // pkactBeginDate		
        this.pkactBeginDate.setRequired(false);
        // pkinitialDate		
        this.pkinitialDate.setRequired(false);
        // txtcontructTime		
        this.txtcontructTime.setHorizontalAlignment(2);		
        this.txtcontructTime.setMaxLength(100);		
        this.txtcontructTime.setRequired(false);
        // projStatus		
        this.projStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.projStatusEnum").toArray());		
        this.projStatus.setRequired(false);
        // txtProjManager		
        this.txtProjManager.setHorizontalAlignment(2);		
        this.txtProjManager.setMaxLength(100);		
        this.txtProjManager.setRequired(false);
        // txtowner		
        this.txtowner.setHorizontalAlignment(2);		
        this.txtowner.setMaxLength(100);		
        this.txtowner.setRequired(false);
        // prmtprovince		
        this.prmtprovince.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");		
        this.prmtprovince.setEditable(true);		
        this.prmtprovince.setDisplayFormat("$name$");		
        this.prmtprovince.setEditFormat("$number$");		
        this.prmtprovince.setCommitFormat("$number$");		
        this.prmtprovince.setRequired(false);
        // prmtdprtName		
        this.prmtdprtName.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtdprtName.setEditable(true);		
        this.prmtdprtName.setDisplayFormat("$name$");		
        this.prmtdprtName.setEditFormat("$number$");		
        this.prmtdprtName.setCommitFormat("$number$");		
        this.prmtdprtName.setRequired(false);
        // txtnameFR		
        this.txtnameFR.setHorizontalAlignment(2);		
        this.txtnameFR.setMaxLength(100);		
        this.txtnameFR.setRequired(false);
        // txtaddressFR		
        this.txtaddressFR.setHorizontalAlignment(2);		
        this.txtaddressFR.setMaxLength(100);		
        this.txtaddressFR.setRequired(false);
        // prmtproCom		
        this.prmtproCom.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtproCom.setEditable(true);		
        this.prmtproCom.setDisplayFormat("$name$");		
        this.prmtproCom.setEditFormat("$number$");		
        this.prmtproCom.setCommitFormat("$number$");		
        this.prmtproCom.setRequired(false);
        // pkconExpDate		
        this.pkconExpDate.setRequired(false);
        // pkconSgnDate		
        this.pkconSgnDate.setRequired(false);
        // txtvcPayAcc		
        this.txtvcPayAcc.setHorizontalAlignment(2);		
        this.txtvcPayAcc.setMaxLength(100);		
        this.txtvcPayAcc.setRequired(false);
        // pkVPAccEndDate		
        this.pkVPAccEndDate.setRequired(false);
        // pkpmtEndDate		
        this.pkpmtEndDate.setRequired(false);
        // area		
        this.area.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum").toArray());		
        this.area.setRequired(false);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        this.txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtDescription_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txtinExtAccount		
        this.txtinExtAccount.setHorizontalAlignment(2);		
        this.txtinExtAccount.setMaxLength(150);		
        this.txtinExtAccount.setRequired(false);
        // txtinDistrGov		
        this.txtinDistrGov.setHorizontalAlignment(2);		
        this.txtinDistrGov.setMaxLength(150);		
        this.txtinDistrGov.setRequired(false);
        // txtinEmploBur		
        this.txtinEmploBur.setHorizontalAlignment(2);		
        this.txtinEmploBur.setMaxLength(150);		
        this.txtinEmploBur.setRequired(false);
        // txtinLabSupBur		
        this.txtinLabSupBur.setHorizontalAlignment(2);		
        this.txtinLabSupBur.setMaxLength(150);		
        this.txtinLabSupBur.setRequired(false);
        // txtinLeaveOff		
        this.txtinLeaveOff.setHorizontalAlignment(2);		
        this.txtinLeaveOff.setMaxLength(150);		
        this.txtinLeaveOff.setRequired(false);
        // txtinSocialSeBur		
        this.txtinSocialSeBur.setHorizontalAlignment(2);		
        this.txtinSocialSeBur.setMaxLength(150);		
        this.txtinSocialSeBur.setRequired(false);
        // prmtinLaborBureau		
        this.prmtinLaborBureau.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");		
        this.prmtinLaborBureau.setEditable(true);		
        this.prmtinLaborBureau.setDisplayFormat("$name$");		
        this.prmtinLaborBureau.setEditFormat("$number$");		
        this.prmtinLaborBureau.setCommitFormat("$number$");		
        this.prmtinLaborBureau.setRequired(false);
        // txtinPoliceOff		
        this.txtinPoliceOff.setHorizontalAlignment(2);		
        this.txtinPoliceOff.setMaxLength(150);		
        this.txtinPoliceOff.setRequired(false);
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"profNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"profName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"type\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"totalAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"usedAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"leftAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"enddate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{profNumber}</t:Cell><t:Cell>$Resource{profName}</t:Cell><t:Cell>$Resource{type}</t:Cell><t:Cell>$Resource{totalAmount}</t:Cell><t:Cell>$Resource{usedAmount}</t:Cell><t:Cell>$Resource{leftAmount}</t:Cell><t:Cell>$Resource{enddate}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        this.kDTable1.checkParsed();
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,prmtproCom,txtnameFR,prmtdprtName,prmtprovince,txtowner,txtProjManager,projStatus,txtcontructTime,pkinitialDate,pkactBeginDate,txtProjConnector,txtinsuranceAcc,pkendDate,pkactEndDate,pkpermitEndDate,pkinsEndDate,txtaddressFR,chkisLogin,pkconSgnDate,txtvcPayAcc,area,prmtinLaborBureau,txtinPoliceOff,pkpmtEndDate,pkVPAccEndDate,pkconExpDate,txtinSocialSeBur,txtinLeaveOff,txtinLabSupBur,txtinEmploBur,txtinDistrGov,txtinExtAccount,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate}));
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
        this.setBounds(new Rectangle(0, 0, 996, 509));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(335, 442, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(660, 442, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(335, 466, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(660, 466, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(13, 9, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(10, 466, 270, 19));
        this.add(contBizDate, null);
        contAuditor.setBounds(new Rectangle(10, 442, 270, 19));
        this.add(contAuditor, null);
        kDTabbedPane1.setBounds(new Rectangle(10, 34, 972, 362));
        this.add(kDTabbedPane1, null);
        kDLabelContainer1.setBounds(new Rectangle(14, 406, 969, 19));
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
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 971, 329));        continsEndDate.setBounds(new Rectangle(339, 167, 270, 19));
        kDPanel1.add(continsEndDate, new KDLayout.Constraints(339, 167, 270, 19, 0));
        contpermitEndDate.setBounds(new Rectangle(339, 97, 270, 19));
        kDPanel1.add(contpermitEndDate, new KDLayout.Constraints(339, 97, 270, 19, 0));
        contactEndDate.setBounds(new Rectangle(339, 143, 270, 19));
        kDPanel1.add(contactEndDate, new KDLayout.Constraints(339, 143, 270, 19, 0));
        contendDate.setBounds(new Rectangle(339, 120, 270, 19));
        kDPanel1.add(contendDate, new KDLayout.Constraints(339, 120, 270, 19, 0));
        continsuranceAcc.setBounds(new Rectangle(339, 51, 270, 19));
        kDPanel1.add(continsuranceAcc, new KDLayout.Constraints(339, 51, 270, 19, 0));
        contProjConnector.setBounds(new Rectangle(339, 28, 270, 19));
        kDPanel1.add(contProjConnector, new KDLayout.Constraints(339, 28, 270, 19, 0));
        contactBeginDate.setBounds(new Rectangle(26, 216, 270, 19));
        kDPanel1.add(contactBeginDate, new KDLayout.Constraints(26, 216, 270, 19, 0));
        continitialDate.setBounds(new Rectangle(26, 191, 270, 19));
        kDPanel1.add(continitialDate, new KDLayout.Constraints(26, 191, 270, 19, 0));
        contcontructTime.setBounds(new Rectangle(26, 167, 270, 19));
        kDPanel1.add(contcontructTime, new KDLayout.Constraints(26, 167, 270, 19, 0));
        contprojStatus.setBounds(new Rectangle(26, 51, 270, 19));
        kDPanel1.add(contprojStatus, new KDLayout.Constraints(26, 51, 270, 19, 0));
        contProjManager.setBounds(new Rectangle(26, 97, 270, 19));
        kDPanel1.add(contProjManager, new KDLayout.Constraints(26, 97, 270, 19, 0));
        contowner.setBounds(new Rectangle(26, 75, 270, 19));
        kDPanel1.add(contowner, new KDLayout.Constraints(26, 75, 270, 19, 0));
        contprovince.setBounds(new Rectangle(658, 28, 270, 19));
        kDPanel1.add(contprovince, new KDLayout.Constraints(658, 28, 270, 19, 0));
        contdprtName.setBounds(new Rectangle(26, 241, 270, 19));
        kDPanel1.add(contdprtName, new KDLayout.Constraints(26, 241, 270, 19, 0));
        contnameFR.setBounds(new Rectangle(26, 28, 270, 19));
        kDPanel1.add(contnameFR, new KDLayout.Constraints(26, 28, 270, 19, 0));
        contaddressFR.setBounds(new Rectangle(26, 267, 899, 19));
        kDPanel1.add(contaddressFR, new KDLayout.Constraints(26, 267, 899, 19, 0));
        contproCom.setBounds(new Rectangle(26, 4, 270, 19));
        kDPanel1.add(contproCom, new KDLayout.Constraints(26, 4, 270, 19, 0));
        contconExpDate.setBounds(new Rectangle(26, 143, 270, 19));
        kDPanel1.add(contconExpDate, new KDLayout.Constraints(26, 143, 270, 19, 0));
        contconSgnDate.setBounds(new Rectangle(26, 120, 270, 19));
        kDPanel1.add(contconSgnDate, new KDLayout.Constraints(26, 120, 270, 19, 0));
        contvcPayAcc.setBounds(new Rectangle(339, 75, 270, 19));
        kDPanel1.add(contvcPayAcc, new KDLayout.Constraints(339, 75, 270, 19, 0));
        contVPAccEndDate.setBounds(new Rectangle(339, 191, 270, 19));
        kDPanel1.add(contVPAccEndDate, new KDLayout.Constraints(339, 191, 270, 19, 0));
        contpmtEndDate.setBounds(new Rectangle(339, 216, 270, 19));
        kDPanel1.add(contpmtEndDate, new KDLayout.Constraints(339, 216, 270, 19, 0));
        contarea.setBounds(new Rectangle(658, 4, 270, 19));
        kDPanel1.add(contarea, new KDLayout.Constraints(658, 4, 270, 19, 0));
        contDescription.setBounds(new Rectangle(26, 294, 899, 19));
        kDPanel1.add(contDescription, new KDLayout.Constraints(26, 294, 899, 19, 0));
        chkisLogin.setBounds(new Rectangle(339, 4, 270, 19));
        kDPanel1.add(chkisLogin, new KDLayout.Constraints(339, 4, 270, 19, 0));
        continExtAccount.setBounds(new Rectangle(658, 216, 270, 19));
        kDPanel1.add(continExtAccount, new KDLayout.Constraints(658, 216, 270, 19, 0));
        continDistrGov.setBounds(new Rectangle(658, 191, 270, 19));
        kDPanel1.add(continDistrGov, new KDLayout.Constraints(658, 191, 270, 19, 0));
        continEmploBur.setBounds(new Rectangle(658, 167, 270, 19));
        kDPanel1.add(continEmploBur, new KDLayout.Constraints(658, 167, 270, 19, 0));
        continLabSupBur.setBounds(new Rectangle(658, 143, 270, 19));
        kDPanel1.add(continLabSupBur, new KDLayout.Constraints(658, 143, 270, 19, 0));
        continLeaveOff.setBounds(new Rectangle(658, 120, 270, 19));
        kDPanel1.add(continLeaveOff, new KDLayout.Constraints(658, 120, 270, 19, 0));
        continSocialSeBur.setBounds(new Rectangle(658, 97, 270, 19));
        kDPanel1.add(continSocialSeBur, new KDLayout.Constraints(658, 97, 270, 19, 0));
        continLaborBureau.setBounds(new Rectangle(658, 51, 270, 19));
        kDPanel1.add(continLaborBureau, new KDLayout.Constraints(658, 51, 270, 19, 0));
        continPoliceOff.setBounds(new Rectangle(658, 75, 270, 19));
        kDPanel1.add(continPoliceOff, new KDLayout.Constraints(658, 75, 270, 19, 0));
        //continsEndDate
        continsEndDate.setBoundEditor(pkinsEndDate);
        //contpermitEndDate
        contpermitEndDate.setBoundEditor(pkpermitEndDate);
        //contactEndDate
        contactEndDate.setBoundEditor(pkactEndDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //continsuranceAcc
        continsuranceAcc.setBoundEditor(txtinsuranceAcc);
        //contProjConnector
        contProjConnector.setBoundEditor(txtProjConnector);
        //contactBeginDate
        contactBeginDate.setBoundEditor(pkactBeginDate);
        //continitialDate
        continitialDate.setBoundEditor(pkinitialDate);
        //contcontructTime
        contcontructTime.setBoundEditor(txtcontructTime);
        //contprojStatus
        contprojStatus.setBoundEditor(projStatus);
        //contProjManager
        contProjManager.setBoundEditor(txtProjManager);
        //contowner
        contowner.setBoundEditor(txtowner);
        //contprovince
        contprovince.setBoundEditor(prmtprovince);
        //contdprtName
        contdprtName.setBoundEditor(prmtdprtName);
        //contnameFR
        contnameFR.setBoundEditor(txtnameFR);
        //contaddressFR
        contaddressFR.setBoundEditor(txtaddressFR);
        //contproCom
        contproCom.setBoundEditor(prmtproCom);
        //contconExpDate
        contconExpDate.setBoundEditor(pkconExpDate);
        //contconSgnDate
        contconSgnDate.setBoundEditor(pkconSgnDate);
        //contvcPayAcc
        contvcPayAcc.setBoundEditor(txtvcPayAcc);
        //contVPAccEndDate
        contVPAccEndDate.setBoundEditor(pkVPAccEndDate);
        //contpmtEndDate
        contpmtEndDate.setBoundEditor(pkpmtEndDate);
        //contarea
        contarea.setBoundEditor(area);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //continExtAccount
        continExtAccount.setBoundEditor(txtinExtAccount);
        //continDistrGov
        continDistrGov.setBoundEditor(txtinDistrGov);
        //continEmploBur
        continEmploBur.setBoundEditor(txtinEmploBur);
        //continLabSupBur
        continLabSupBur.setBoundEditor(txtinLabSupBur);
        //continLeaveOff
        continLeaveOff.setBoundEditor(txtinLeaveOff);
        //continSocialSeBur
        continSocialSeBur.setBoundEditor(txtinSocialSeBur);
        //continLaborBureau
        continLaborBureau.setBoundEditor(prmtinLaborBureau);
        //continPoliceOff
        continPoliceOff.setBoundEditor(txtinPoliceOff);
        //kDPanel2
kDPanel2.setLayout(new BorderLayout(0, 0));        kDPanel2.add(kDTable1, BorderLayout.CENTER);

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
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("isLogin", boolean.class, this.chkisLogin, "selected");
		dataBinder.registerBinding("insEndDate", java.util.Date.class, this.pkinsEndDate, "value");
		dataBinder.registerBinding("permitEndDate", java.util.Date.class, this.pkpermitEndDate, "value");
		dataBinder.registerBinding("actEndDate", java.util.Date.class, this.pkactEndDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("insuranceAcc", String.class, this.txtinsuranceAcc, "text");
		dataBinder.registerBinding("ProjConnector", String.class, this.txtProjConnector, "text");
		dataBinder.registerBinding("actBeginDate", java.util.Date.class, this.pkactBeginDate, "value");
		dataBinder.registerBinding("initialDate", java.util.Date.class, this.pkinitialDate, "value");
		dataBinder.registerBinding("contructTime", String.class, this.txtcontructTime, "text");
		dataBinder.registerBinding("projStatus", com.kingdee.eas.zjlw.certificates.app.projStatusEnum.class, this.projStatus, "selectedItem");
		dataBinder.registerBinding("ProjManager", String.class, this.txtProjManager, "text");
		dataBinder.registerBinding("owner", String.class, this.txtowner, "text");
		dataBinder.registerBinding("province", com.kingdee.eas.basedata.assistant.ProvinceInfo.class, this.prmtprovince, "data");
		dataBinder.registerBinding("dprtName", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtdprtName, "data");
		dataBinder.registerBinding("nameFR", String.class, this.txtnameFR, "text");
		dataBinder.registerBinding("addressFR", String.class, this.txtaddressFR, "text");
		dataBinder.registerBinding("proCom", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtproCom, "data");
		dataBinder.registerBinding("conExpDate", java.util.Date.class, this.pkconExpDate, "value");
		dataBinder.registerBinding("conSgnDate", java.util.Date.class, this.pkconSgnDate, "value");
		dataBinder.registerBinding("vcPayAcc", String.class, this.txtvcPayAcc, "text");
		dataBinder.registerBinding("VPAccEndDate", java.util.Date.class, this.pkVPAccEndDate, "value");
		dataBinder.registerBinding("pmtEndDate", java.util.Date.class, this.pkpmtEndDate, "value");
		dataBinder.registerBinding("area", com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum.class, this.area, "selectedItem");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("inExtAccount", String.class, this.txtinExtAccount, "text");
		dataBinder.registerBinding("inDistrGov", String.class, this.txtinDistrGov, "text");
		dataBinder.registerBinding("inEmploBur", String.class, this.txtinEmploBur, "text");
		dataBinder.registerBinding("inLabSupBur", String.class, this.txtinLabSupBur, "text");
		dataBinder.registerBinding("inLeaveOff", String.class, this.txtinLeaveOff, "text");
		dataBinder.registerBinding("inSocialSeBur", String.class, this.txtinSocialSeBur, "text");
		dataBinder.registerBinding("inLaborBureau", com.kingdee.eas.basedata.assistant.ProvinceInfo.class, this.prmtinLaborBureau, "data");
		dataBinder.registerBinding("inPoliceOff", String.class, this.txtinPoliceOff, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.baseinfo.app.ProjectOrgEditUIHandler";
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
        this.txtNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo)ov;
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
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isLogin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("insEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("permitEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("insuranceAcc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ProjConnector", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actBeginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initialDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contructTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ProjManager", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("owner", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("province", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dprtName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nameFR", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("addressFR", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proCom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conExpDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conSgnDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("vcPayAcc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("VPAccEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pmtEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("area", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inExtAccount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDistrGov", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inEmploBur", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inLabSupBur", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inLeaveOff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inSocialSeBur", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inLaborBureau", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inPoliceOff", ValidateHelper.ON_SAVE);    		
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
     * output txtDescription_actionPerformed method
     */
    protected void txtDescription_actionPerformed(java.awt.event.ActionEvent e) throws Exception
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("isLogin"));
        sic.add(new SelectorItemInfo("insEndDate"));
        sic.add(new SelectorItemInfo("permitEndDate"));
        sic.add(new SelectorItemInfo("actEndDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("insuranceAcc"));
        sic.add(new SelectorItemInfo("ProjConnector"));
        sic.add(new SelectorItemInfo("actBeginDate"));
        sic.add(new SelectorItemInfo("initialDate"));
        sic.add(new SelectorItemInfo("contructTime"));
        sic.add(new SelectorItemInfo("projStatus"));
        sic.add(new SelectorItemInfo("ProjManager"));
        sic.add(new SelectorItemInfo("owner"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("province.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("province.id"));
        	sic.add(new SelectorItemInfo("province.number"));
        	sic.add(new SelectorItemInfo("province.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("dprtName.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("dprtName.id"));
        	sic.add(new SelectorItemInfo("dprtName.number"));
        	sic.add(new SelectorItemInfo("dprtName.name"));
		}
        sic.add(new SelectorItemInfo("nameFR"));
        sic.add(new SelectorItemInfo("addressFR"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("proCom.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("proCom.id"));
        	sic.add(new SelectorItemInfo("proCom.number"));
        	sic.add(new SelectorItemInfo("proCom.name"));
		}
        sic.add(new SelectorItemInfo("conExpDate"));
        sic.add(new SelectorItemInfo("conSgnDate"));
        sic.add(new SelectorItemInfo("vcPayAcc"));
        sic.add(new SelectorItemInfo("VPAccEndDate"));
        sic.add(new SelectorItemInfo("pmtEndDate"));
        sic.add(new SelectorItemInfo("area"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("inExtAccount"));
        sic.add(new SelectorItemInfo("inDistrGov"));
        sic.add(new SelectorItemInfo("inEmploBur"));
        sic.add(new SelectorItemInfo("inLabSupBur"));
        sic.add(new SelectorItemInfo("inLeaveOff"));
        sic.add(new SelectorItemInfo("inSocialSeBur"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("inLaborBureau.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("inLaborBureau.id"));
        	sic.add(new SelectorItemInfo("inLaborBureau.number"));
        	sic.add(new SelectorItemInfo("inLaborBureau.name"));
		}
        sic.add(new SelectorItemInfo("inPoliceOff"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.client", "ProjectOrgEditUI");
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
        return com.kingdee.eas.zjlw.baseinfo.client.ProjectOrgEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo objectValue = new com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/baseinfo/ProjectOrg";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.baseinfo.app.ProjectOrgQuery");
	}
    

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kDTable1;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("projStatus","0");
vo.put("area","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}