/**
 * output package name
 */
package com.kingdee.eas.zjlw.personinfo.client;

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
public abstract class AbstractPersonHistoryEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPersonHistoryEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnameCN;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsex;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbirthDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpassportNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpassportIssueDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpassportExpireDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbirthPlaceCn;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbirthPlaceFr;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfatherName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfatherNameAlphabet;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmotherName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmotherNameAlphabet;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoupleName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoupleNameAlphabet;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoupleBirthDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoupleBirthPlace;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoupleWorkPlace;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continnerAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontactway;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoldPassport;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbsnisState;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvisaType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfirstNameAlp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlastNameApl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpermitProfession;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpermitOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcooperation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpassportInst;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmerState;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contidNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrealProf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoupleNation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsecurityNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthBsnisState;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpassportCity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpassportCityF;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoopHis;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoopRecord;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnameCN;
    protected com.kingdee.bos.ctrl.swing.KDComboBox sex;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbirthDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpassportNo;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkpassportIssueDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkpassportExpireDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbirthPlaceCn;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbirthPlaceFr;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfatherName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfatherNameAlphabet;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmotherName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmotherNameAlphabet;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcoupleName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcoupleNameAlphabet;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcoupleBirthDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcoupleBirthPlace;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcoupleWorkPlace;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinnerAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcontactway;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtoldPassport;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtremark;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel12;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel16;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel15;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel7;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel11;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel10;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel8;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel13;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel14;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel9;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblAttachment;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable12;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable15;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable5;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable6;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable7;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable11;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable10;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable8;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable13;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable14;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable9;
    protected com.kingdee.bos.ctrl.swing.KDComboBox bsnisState;
    protected com.kingdee.bos.ctrl.swing.KDComboBox visaType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfirstNameAlp;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlastNameApl;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpermitProfession;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtworkOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpermitOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcooperation;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpassportInst;
    protected com.kingdee.bos.ctrl.swing.KDComboBox merState;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtidNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtrealProf;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnation;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcoupleNation;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsecurityNo;
    protected com.kingdee.bos.ctrl.swing.KDComboBox hBsnisState;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpassportCity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpassportCityF;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcoopHis;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcoopRecord;
    protected com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPersonHistoryEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPersonHistoryEditUI.class.getName());
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
        this.contnameCN = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsex = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbirthDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpassportNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpassportIssueDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpassportExpireDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbirthPlaceCn = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbirthPlaceFr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfatherName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfatherNameAlphabet = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmotherName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmotherNameAlphabet = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoupleName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoupleNameAlphabet = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoupleBirthDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoupleBirthPlace = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoupleWorkPlace = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continnerAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontactway = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoldPassport = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbsnisState = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvisaType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfirstNameAlp = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlastNameApl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpermitProfession = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpermitOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcooperation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpassportInst = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmerState = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contidNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrealProf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoupleNation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsecurityNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthBsnisState = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpassportCity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpassportCityF = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoopHis = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoopRecord = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtnameCN = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.sex = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkbirthDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtpassportNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkpassportIssueDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkpassportExpireDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbirthPlaceCn = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbirthPlaceFr = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfatherName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfatherNameAlphabet = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmotherName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmotherNameAlphabet = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcoupleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcoupleNameAlphabet = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkcoupleBirthDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtcoupleBirthPlace = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcoupleWorkPlace = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinnerAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcontactway = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtoldPassport = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel12 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel16 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel15 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel7 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel11 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel10 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel8 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel13 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel14 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel9 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.tblAttachment = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable12 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable15 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable3 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable2 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable4 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable5 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable6 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable7 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable11 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable10 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable8 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable13 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable14 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable9 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.bsnisState = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.visaType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtfirstNameAlp = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtlastNameApl = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtpermitProfession = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtworkOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpermitOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcooperation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpassportInst = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.merState = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtidNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtrealProf = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtnation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcoupleNation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsecurityNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.hBsnisState = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtpassportCity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpassportCityF = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcoopHis = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcoopRecord = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contnameCN.setName("contnameCN");
        this.contsex.setName("contsex");
        this.contbirthDate.setName("contbirthDate");
        this.contpassportNo.setName("contpassportNo");
        this.contpassportIssueDate.setName("contpassportIssueDate");
        this.contpassportExpireDate.setName("contpassportExpireDate");
        this.contbirthPlaceCn.setName("contbirthPlaceCn");
        this.contbirthPlaceFr.setName("contbirthPlaceFr");
        this.contfatherName.setName("contfatherName");
        this.contfatherNameAlphabet.setName("contfatherNameAlphabet");
        this.contmotherName.setName("contmotherName");
        this.contmotherNameAlphabet.setName("contmotherNameAlphabet");
        this.contcoupleName.setName("contcoupleName");
        this.contcoupleNameAlphabet.setName("contcoupleNameAlphabet");
        this.contcoupleBirthDate.setName("contcoupleBirthDate");
        this.contcoupleBirthPlace.setName("contcoupleBirthPlace");
        this.contcoupleWorkPlace.setName("contcoupleWorkPlace");
        this.continnerAddress.setName("continnerAddress");
        this.contcontactway.setName("contcontactway");
        this.contoldPassport.setName("contoldPassport");
        this.contremark.setName("contremark");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbsnisState.setName("contbsnisState");
        this.contvisaType.setName("contvisaType");
        this.contfirstNameAlp.setName("contfirstNameAlp");
        this.contlastNameApl.setName("contlastNameApl");
        this.contpermitProfession.setName("contpermitProfession");
        this.contworkOrg.setName("contworkOrg");
        this.contpermitOrg.setName("contpermitOrg");
        this.contcooperation.setName("contcooperation");
        this.contpassportInst.setName("contpassportInst");
        this.contmerState.setName("contmerState");
        this.contidNum.setName("contidNum");
        this.contrealProf.setName("contrealProf");
        this.contnation.setName("contnation");
        this.contcoupleNation.setName("contcoupleNation");
        this.contsecurityNo.setName("contsecurityNo");
        this.conthBsnisState.setName("conthBsnisState");
        this.contpassportCity.setName("contpassportCity");
        this.contpassportCityF.setName("contpassportCityF");
        this.contcoopHis.setName("contcoopHis");
        this.contcoopRecord.setName("contcoopRecord");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtnameCN.setName("txtnameCN");
        this.sex.setName("sex");
        this.pkbirthDate.setName("pkbirthDate");
        this.txtpassportNo.setName("txtpassportNo");
        this.pkpassportIssueDate.setName("pkpassportIssueDate");
        this.pkpassportExpireDate.setName("pkpassportExpireDate");
        this.txtbirthPlaceCn.setName("txtbirthPlaceCn");
        this.txtbirthPlaceFr.setName("txtbirthPlaceFr");
        this.txtfatherName.setName("txtfatherName");
        this.txtfatherNameAlphabet.setName("txtfatherNameAlphabet");
        this.txtmotherName.setName("txtmotherName");
        this.txtmotherNameAlphabet.setName("txtmotherNameAlphabet");
        this.txtcoupleName.setName("txtcoupleName");
        this.txtcoupleNameAlphabet.setName("txtcoupleNameAlphabet");
        this.pkcoupleBirthDate.setName("pkcoupleBirthDate");
        this.txtcoupleBirthPlace.setName("txtcoupleBirthPlace");
        this.txtcoupleWorkPlace.setName("txtcoupleWorkPlace");
        this.txtinnerAddress.setName("txtinnerAddress");
        this.txtcontactway.setName("txtcontactway");
        this.txtoldPassport.setName("txtoldPassport");
        this.txtremark.setName("txtremark");
        this.kDPanel12.setName("kDPanel12");
        this.kDPanel16.setName("kDPanel16");
        this.kDPanel15.setName("kDPanel15");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel5.setName("kDPanel5");
        this.kDPanel6.setName("kDPanel6");
        this.kDPanel7.setName("kDPanel7");
        this.kDPanel11.setName("kDPanel11");
        this.kDPanel10.setName("kDPanel10");
        this.kDPanel8.setName("kDPanel8");
        this.kDPanel13.setName("kDPanel13");
        this.kDPanel14.setName("kDPanel14");
        this.kDPanel9.setName("kDPanel9");
        this.tblAttachment.setName("tblAttachment");
        this.kDTable12.setName("kDTable12");
        this.kDTable15.setName("kDTable15");
        this.kDTable1.setName("kDTable1");
        this.kDTable3.setName("kDTable3");
        this.kDTable2.setName("kDTable2");
        this.kDTable4.setName("kDTable4");
        this.kDTable5.setName("kDTable5");
        this.kDTable6.setName("kDTable6");
        this.kDTable7.setName("kDTable7");
        this.kDTable11.setName("kDTable11");
        this.kDTable10.setName("kDTable10");
        this.kDTable8.setName("kDTable8");
        this.kDTable13.setName("kDTable13");
        this.kDTable14.setName("kDTable14");
        this.kDTable9.setName("kDTable9");
        this.bsnisState.setName("bsnisState");
        this.visaType.setName("visaType");
        this.txtfirstNameAlp.setName("txtfirstNameAlp");
        this.txtlastNameApl.setName("txtlastNameApl");
        this.prmtpermitProfession.setName("prmtpermitProfession");
        this.prmtworkOrg.setName("prmtworkOrg");
        this.prmtpermitOrg.setName("prmtpermitOrg");
        this.prmtcooperation.setName("prmtcooperation");
        this.txtpassportInst.setName("txtpassportInst");
        this.merState.setName("merState");
        this.txtidNum.setName("txtidNum");
        this.txtrealProf.setName("txtrealProf");
        this.prmtnation.setName("prmtnation");
        this.prmtcoupleNation.setName("prmtcoupleNation");
        this.txtsecurityNo.setName("txtsecurityNo");
        this.hBsnisState.setName("hBsnisState");
        this.prmtpassportCity.setName("prmtpassportCity");
        this.txtpassportCityF.setName("txtpassportCityF");
        this.prmtcoopHis.setName("prmtcoopHis");
        this.txtcoopRecord.setName("txtcoopRecord");
        // CoreUI		
        this.btnAddNew.setVisible(false);		
        this.btnEdit.setVisible(false);		
        this.btnSubmit.setVisible(false);		
        this.btnRemove.setVisible(false);		
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
        this.contDescription.setVisible(false);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setVisible(false);
        // contnameCN		
        this.contnameCN.setBoundLabelText(resHelper.getString("contnameCN.boundLabelText"));		
        this.contnameCN.setBoundLabelLength(100);		
        this.contnameCN.setBoundLabelUnderline(true);		
        this.contnameCN.setVisible(true);
        // contsex		
        this.contsex.setBoundLabelText(resHelper.getString("contsex.boundLabelText"));		
        this.contsex.setBoundLabelLength(100);		
        this.contsex.setBoundLabelUnderline(true);		
        this.contsex.setVisible(true);
        // contbirthDate		
        this.contbirthDate.setBoundLabelText(resHelper.getString("contbirthDate.boundLabelText"));		
        this.contbirthDate.setBoundLabelLength(100);		
        this.contbirthDate.setBoundLabelUnderline(true);		
        this.contbirthDate.setVisible(true);
        // contpassportNo		
        this.contpassportNo.setBoundLabelText(resHelper.getString("contpassportNo.boundLabelText"));		
        this.contpassportNo.setBoundLabelLength(100);		
        this.contpassportNo.setBoundLabelUnderline(true);		
        this.contpassportNo.setVisible(true);
        // contpassportIssueDate		
        this.contpassportIssueDate.setBoundLabelText(resHelper.getString("contpassportIssueDate.boundLabelText"));		
        this.contpassportIssueDate.setBoundLabelLength(100);		
        this.contpassportIssueDate.setBoundLabelUnderline(true);		
        this.contpassportIssueDate.setVisible(true);
        // contpassportExpireDate		
        this.contpassportExpireDate.setBoundLabelText(resHelper.getString("contpassportExpireDate.boundLabelText"));		
        this.contpassportExpireDate.setBoundLabelLength(100);		
        this.contpassportExpireDate.setBoundLabelUnderline(true);		
        this.contpassportExpireDate.setVisible(true);
        // contbirthPlaceCn		
        this.contbirthPlaceCn.setBoundLabelText(resHelper.getString("contbirthPlaceCn.boundLabelText"));		
        this.contbirthPlaceCn.setBoundLabelLength(100);		
        this.contbirthPlaceCn.setBoundLabelUnderline(true);		
        this.contbirthPlaceCn.setVisible(true);
        // contbirthPlaceFr		
        this.contbirthPlaceFr.setBoundLabelText(resHelper.getString("contbirthPlaceFr.boundLabelText"));		
        this.contbirthPlaceFr.setBoundLabelLength(100);		
        this.contbirthPlaceFr.setBoundLabelUnderline(true);		
        this.contbirthPlaceFr.setVisible(true);
        // contfatherName		
        this.contfatherName.setBoundLabelText(resHelper.getString("contfatherName.boundLabelText"));		
        this.contfatherName.setBoundLabelLength(100);		
        this.contfatherName.setBoundLabelUnderline(true);		
        this.contfatherName.setVisible(true);
        // contfatherNameAlphabet		
        this.contfatherNameAlphabet.setBoundLabelText(resHelper.getString("contfatherNameAlphabet.boundLabelText"));		
        this.contfatherNameAlphabet.setBoundLabelLength(100);		
        this.contfatherNameAlphabet.setBoundLabelUnderline(true);		
        this.contfatherNameAlphabet.setVisible(true);
        // contmotherName		
        this.contmotherName.setBoundLabelText(resHelper.getString("contmotherName.boundLabelText"));		
        this.contmotherName.setBoundLabelLength(100);		
        this.contmotherName.setBoundLabelUnderline(true);		
        this.contmotherName.setVisible(true);
        // contmotherNameAlphabet		
        this.contmotherNameAlphabet.setBoundLabelText(resHelper.getString("contmotherNameAlphabet.boundLabelText"));		
        this.contmotherNameAlphabet.setBoundLabelLength(100);		
        this.contmotherNameAlphabet.setBoundLabelUnderline(true);		
        this.contmotherNameAlphabet.setVisible(true);
        // contcoupleName		
        this.contcoupleName.setBoundLabelText(resHelper.getString("contcoupleName.boundLabelText"));		
        this.contcoupleName.setBoundLabelLength(100);		
        this.contcoupleName.setBoundLabelUnderline(true);		
        this.contcoupleName.setVisible(true);
        // contcoupleNameAlphabet		
        this.contcoupleNameAlphabet.setBoundLabelText(resHelper.getString("contcoupleNameAlphabet.boundLabelText"));		
        this.contcoupleNameAlphabet.setBoundLabelLength(100);		
        this.contcoupleNameAlphabet.setBoundLabelUnderline(true);		
        this.contcoupleNameAlphabet.setVisible(true);
        // contcoupleBirthDate		
        this.contcoupleBirthDate.setBoundLabelText(resHelper.getString("contcoupleBirthDate.boundLabelText"));		
        this.contcoupleBirthDate.setBoundLabelLength(100);		
        this.contcoupleBirthDate.setBoundLabelUnderline(true);		
        this.contcoupleBirthDate.setVisible(true);
        // contcoupleBirthPlace		
        this.contcoupleBirthPlace.setBoundLabelText(resHelper.getString("contcoupleBirthPlace.boundLabelText"));		
        this.contcoupleBirthPlace.setBoundLabelLength(100);		
        this.contcoupleBirthPlace.setBoundLabelUnderline(true);		
        this.contcoupleBirthPlace.setVisible(true);
        // contcoupleWorkPlace		
        this.contcoupleWorkPlace.setBoundLabelText(resHelper.getString("contcoupleWorkPlace.boundLabelText"));		
        this.contcoupleWorkPlace.setBoundLabelLength(110);		
        this.contcoupleWorkPlace.setBoundLabelUnderline(true);		
        this.contcoupleWorkPlace.setVisible(true);
        // continnerAddress		
        this.continnerAddress.setBoundLabelText(resHelper.getString("continnerAddress.boundLabelText"));		
        this.continnerAddress.setBoundLabelLength(100);		
        this.continnerAddress.setBoundLabelUnderline(true);		
        this.continnerAddress.setVisible(true);
        // contcontactway		
        this.contcontactway.setBoundLabelText(resHelper.getString("contcontactway.boundLabelText"));		
        this.contcontactway.setBoundLabelLength(100);		
        this.contcontactway.setBoundLabelUnderline(true);		
        this.contcontactway.setVisible(true);
        // contoldPassport		
        this.contoldPassport.setBoundLabelText(resHelper.getString("contoldPassport.boundLabelText"));		
        this.contoldPassport.setBoundLabelLength(100);		
        this.contoldPassport.setBoundLabelUnderline(true);		
        this.contoldPassport.setVisible(true);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(100);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // kDTabbedPane1
        // contbsnisState		
        this.contbsnisState.setBoundLabelText(resHelper.getString("contbsnisState.boundLabelText"));		
        this.contbsnisState.setBoundLabelLength(100);		
        this.contbsnisState.setBoundLabelUnderline(true);		
        this.contbsnisState.setVisible(true);
        // contvisaType		
        this.contvisaType.setBoundLabelText(resHelper.getString("contvisaType.boundLabelText"));		
        this.contvisaType.setBoundLabelLength(100);		
        this.contvisaType.setBoundLabelUnderline(true);		
        this.contvisaType.setVisible(true);
        // contfirstNameAlp		
        this.contfirstNameAlp.setBoundLabelText(resHelper.getString("contfirstNameAlp.boundLabelText"));		
        this.contfirstNameAlp.setBoundLabelLength(100);		
        this.contfirstNameAlp.setBoundLabelUnderline(true);		
        this.contfirstNameAlp.setVisible(true);
        // contlastNameApl		
        this.contlastNameApl.setBoundLabelText(resHelper.getString("contlastNameApl.boundLabelText"));		
        this.contlastNameApl.setBoundLabelLength(100);		
        this.contlastNameApl.setBoundLabelUnderline(true);		
        this.contlastNameApl.setVisible(true);
        // contpermitProfession		
        this.contpermitProfession.setBoundLabelText(resHelper.getString("contpermitProfession.boundLabelText"));		
        this.contpermitProfession.setBoundLabelLength(100);		
        this.contpermitProfession.setBoundLabelUnderline(true);		
        this.contpermitProfession.setVisible(true);
        // contworkOrg		
        this.contworkOrg.setBoundLabelText(resHelper.getString("contworkOrg.boundLabelText"));		
        this.contworkOrg.setBoundLabelLength(100);		
        this.contworkOrg.setBoundLabelUnderline(true);		
        this.contworkOrg.setVisible(true);
        // contpermitOrg		
        this.contpermitOrg.setBoundLabelText(resHelper.getString("contpermitOrg.boundLabelText"));		
        this.contpermitOrg.setBoundLabelLength(100);		
        this.contpermitOrg.setBoundLabelUnderline(true);		
        this.contpermitOrg.setVisible(true);
        // contcooperation		
        this.contcooperation.setBoundLabelText(resHelper.getString("contcooperation.boundLabelText"));		
        this.contcooperation.setBoundLabelLength(100);		
        this.contcooperation.setBoundLabelUnderline(true);		
        this.contcooperation.setVisible(true);
        // contpassportInst		
        this.contpassportInst.setBoundLabelText(resHelper.getString("contpassportInst.boundLabelText"));		
        this.contpassportInst.setBoundLabelLength(100);		
        this.contpassportInst.setBoundLabelUnderline(true);		
        this.contpassportInst.setVisible(true);
        // contmerState		
        this.contmerState.setBoundLabelText(resHelper.getString("contmerState.boundLabelText"));		
        this.contmerState.setBoundLabelLength(100);		
        this.contmerState.setBoundLabelUnderline(true);		
        this.contmerState.setVisible(true);
        // contidNum		
        this.contidNum.setBoundLabelText(resHelper.getString("contidNum.boundLabelText"));		
        this.contidNum.setBoundLabelLength(100);		
        this.contidNum.setBoundLabelUnderline(true);		
        this.contidNum.setVisible(true);
        // contrealProf		
        this.contrealProf.setBoundLabelText(resHelper.getString("contrealProf.boundLabelText"));		
        this.contrealProf.setBoundLabelLength(100);		
        this.contrealProf.setBoundLabelUnderline(true);		
        this.contrealProf.setVisible(true);
        // contnation		
        this.contnation.setBoundLabelText(resHelper.getString("contnation.boundLabelText"));		
        this.contnation.setBoundLabelLength(100);		
        this.contnation.setBoundLabelUnderline(true);		
        this.contnation.setVisible(true);
        // contcoupleNation		
        this.contcoupleNation.setBoundLabelText(resHelper.getString("contcoupleNation.boundLabelText"));		
        this.contcoupleNation.setBoundLabelLength(100);		
        this.contcoupleNation.setBoundLabelUnderline(true);		
        this.contcoupleNation.setVisible(true);
        // contsecurityNo		
        this.contsecurityNo.setBoundLabelText(resHelper.getString("contsecurityNo.boundLabelText"));		
        this.contsecurityNo.setBoundLabelLength(100);		
        this.contsecurityNo.setBoundLabelUnderline(true);		
        this.contsecurityNo.setVisible(true);
        // conthBsnisState		
        this.conthBsnisState.setBoundLabelText(resHelper.getString("conthBsnisState.boundLabelText"));		
        this.conthBsnisState.setBoundLabelLength(100);		
        this.conthBsnisState.setBoundLabelUnderline(true);		
        this.conthBsnisState.setVisible(false);
        // contpassportCity		
        this.contpassportCity.setBoundLabelText(resHelper.getString("contpassportCity.boundLabelText"));		
        this.contpassportCity.setBoundLabelLength(100);		
        this.contpassportCity.setBoundLabelUnderline(true);		
        this.contpassportCity.setVisible(true);
        // contpassportCityF		
        this.contpassportCityF.setBoundLabelText(resHelper.getString("contpassportCityF.boundLabelText"));		
        this.contpassportCityF.setBoundLabelLength(140);		
        this.contpassportCityF.setBoundLabelUnderline(true);		
        this.contpassportCityF.setVisible(true);
        // contcoopHis		
        this.contcoopHis.setBoundLabelText(resHelper.getString("contcoopHis.boundLabelText"));		
        this.contcoopHis.setBoundLabelLength(100);		
        this.contcoopHis.setBoundLabelUnderline(true);		
        this.contcoopHis.setVisible(true);
        // contcoopRecord		
        this.contcoopRecord.setBoundLabelText(resHelper.getString("contcoopRecord.boundLabelText"));		
        this.contcoopRecord.setBoundLabelLength(125);		
        this.contcoopRecord.setBoundLabelUnderline(true);		
        this.contcoopRecord.setVisible(true);
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
        // pkBizDate		
        this.pkBizDate.setVisible(false);		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);		
        this.txtDescription.setVisible(false);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setVisible(false);
        // txtnameCN		
        this.txtnameCN.setHorizontalAlignment(2);		
        this.txtnameCN.setMaxLength(100);		
        this.txtnameCN.setRequired(false);
        // sex		
        this.sex.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());		
        this.sex.setRequired(false);
        // pkbirthDate		
        this.pkbirthDate.setRequired(false);
        // txtpassportNo		
        this.txtpassportNo.setHorizontalAlignment(2);		
        this.txtpassportNo.setMaxLength(100);		
        this.txtpassportNo.setRequired(false);
        // pkpassportIssueDate		
        this.pkpassportIssueDate.setRequired(false);
        // pkpassportExpireDate		
        this.pkpassportExpireDate.setRequired(false);
        // txtbirthPlaceCn		
        this.txtbirthPlaceCn.setHorizontalAlignment(2);		
        this.txtbirthPlaceCn.setMaxLength(100);		
        this.txtbirthPlaceCn.setRequired(false);
        // txtbirthPlaceFr		
        this.txtbirthPlaceFr.setHorizontalAlignment(2);		
        this.txtbirthPlaceFr.setMaxLength(100);		
        this.txtbirthPlaceFr.setRequired(false);
        // txtfatherName		
        this.txtfatherName.setHorizontalAlignment(2);		
        this.txtfatherName.setMaxLength(100);		
        this.txtfatherName.setRequired(false);
        // txtfatherNameAlphabet		
        this.txtfatherNameAlphabet.setHorizontalAlignment(2);		
        this.txtfatherNameAlphabet.setMaxLength(100);		
        this.txtfatherNameAlphabet.setRequired(false);
        // txtmotherName		
        this.txtmotherName.setHorizontalAlignment(2);		
        this.txtmotherName.setMaxLength(100);		
        this.txtmotherName.setRequired(false);
        // txtmotherNameAlphabet		
        this.txtmotherNameAlphabet.setHorizontalAlignment(2);		
        this.txtmotherNameAlphabet.setMaxLength(100);		
        this.txtmotherNameAlphabet.setRequired(false);
        // txtcoupleName		
        this.txtcoupleName.setHorizontalAlignment(2);		
        this.txtcoupleName.setMaxLength(100);		
        this.txtcoupleName.setRequired(false);
        // txtcoupleNameAlphabet		
        this.txtcoupleNameAlphabet.setHorizontalAlignment(2);		
        this.txtcoupleNameAlphabet.setMaxLength(100);		
        this.txtcoupleNameAlphabet.setRequired(false);
        // pkcoupleBirthDate		
        this.pkcoupleBirthDate.setRequired(false);
        // txtcoupleBirthPlace		
        this.txtcoupleBirthPlace.setHorizontalAlignment(2);		
        this.txtcoupleBirthPlace.setMaxLength(100);		
        this.txtcoupleBirthPlace.setRequired(false);
        // txtcoupleWorkPlace		
        this.txtcoupleWorkPlace.setHorizontalAlignment(2);		
        this.txtcoupleWorkPlace.setMaxLength(100);		
        this.txtcoupleWorkPlace.setRequired(false);
        // txtinnerAddress		
        this.txtinnerAddress.setHorizontalAlignment(2);		
        this.txtinnerAddress.setMaxLength(100);		
        this.txtinnerAddress.setRequired(false);
        // txtcontactway		
        this.txtcontactway.setHorizontalAlignment(2);		
        this.txtcontactway.setMaxLength(100);		
        this.txtcontactway.setRequired(false);
        // txtoldPassport		
        this.txtoldPassport.setHorizontalAlignment(2);		
        this.txtoldPassport.setMaxLength(100);		
        this.txtoldPassport.setRequired(false);
        // txtremark		
        this.txtremark.setHorizontalAlignment(2);		
        this.txtremark.setMaxLength(100);		
        this.txtremark.setRequired(false);
        // kDPanel12
        // kDPanel16
        // kDPanel15
        // kDPanel1
        // kDPanel3
        // kDPanel2
        // kDPanel4
        // kDPanel5
        // kDPanel6
        // kDPanel7
        // kDPanel11
        // kDPanel10
        // kDPanel8
        // kDPanel13
        // kDPanel14
        // kDPanel9
        // tblAttachment
		String tblAttachmentStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"idNum\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{idNum}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblAttachment.setFormatXml(resHelper.translateString("tblAttachment",tblAttachmentStrXML));

        

        this.tblAttachment.checkParsed();
        // kDTable12
		String kDTable12StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sex\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthdate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"nation\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"idNum\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"acProf\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"pmtProfC\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"workProgram\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitProgram\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cooperation\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"passportNo\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"passportAgency\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"score\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"oldPassport\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{birthdate}</t:Cell><t:Cell>$Resource{nation}</t:Cell><t:Cell>$Resource{idNum}</t:Cell><t:Cell>$Resource{acProf}</t:Cell><t:Cell>$Resource{pmtProfC}</t:Cell><t:Cell>$Resource{workProgram}</t:Cell><t:Cell>$Resource{permitProgram}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{passportNo}</t:Cell><t:Cell>$Resource{passportAgency}</t:Cell><t:Cell>$Resource{score}</t:Cell><t:Cell>$Resource{oldPassport}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable12.setFormatXml(resHelper.translateString("kDTable12",kDTable12StrXML));

        

        this.kDTable12.checkParsed();
        // kDTable15
		String kDTable15StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sex\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"idNum\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"nation\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"passportNo\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"passportIssueDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"passportExpireDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cooperation\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"handleProject\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workProgram\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"heard\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{idNum}</t:Cell><t:Cell>$Resource{nation}</t:Cell><t:Cell>$Resource{passportNo}</t:Cell><t:Cell>$Resource{passportIssueDate}</t:Cell><t:Cell>$Resource{passportExpireDate}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{handleProject}</t:Cell><t:Cell>$Resource{workProgram}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable15.setFormatXml(resHelper.translateString("kDTable15",kDTable15StrXML));

        

        this.kDTable15.checkParsed();
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"belongOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"effectDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{permitOrg}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{belongOrg}</t:Cell><t:Cell>$Resource{effectDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        this.kDTable1.checkParsed();
        // kDTable3
		String kDTable3StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"belongOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"notaryDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qualifyplace\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"qualifyNumber\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"qualifystartDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qualifDoneDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Type\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"ceaseReeason\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"ceaseTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"applier\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"applyTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{permitOrg}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{belongOrg}</t:Cell><t:Cell>$Resource{notaryDate}</t:Cell><t:Cell>$Resource{qualifyplace}</t:Cell><t:Cell>$Resource{qualifyNumber}</t:Cell><t:Cell>$Resource{qualifystartDate}</t:Cell><t:Cell>$Resource{qualifDoneDate}</t:Cell><t:Cell>$Resource{Type}</t:Cell><t:Cell>$Resource{ceaseReeason}</t:Cell><t:Cell>$Resource{ceaseTime}</t:Cell><t:Cell>$Resource{applier}</t:Cell><t:Cell>$Resource{applyTime}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable3.setFormatXml(resHelper.translateString("kDTable3",kDTable3StrXML));

        

        this.kDTable3.checkParsed();
        // kDTable2
		String kDTable2StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"belongOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"effectDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"endDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{permitOrg}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{belongOrg}</t:Cell><t:Cell>$Resource{effectDate}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable2.setFormatXml(resHelper.translateString("kDTable2",kDTable2StrXML));

        

        this.kDTable2.checkParsed();
        // kDTable4
		String kDTable4StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"140\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitOrg\" t:width=\"140\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"140\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"belongOrg\" t:width=\"140\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"effectDate\" t:width=\"140\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"endDate\" t:width=\"140\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"155\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{permitOrg}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{belongOrg}</t:Cell><t:Cell>$Resource{effectDate}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable4.setFormatXml(resHelper.translateString("kDTable4",kDTable4StrXML));

        

        this.kDTable4.checkParsed();
        // kDTable5
		String kDTable5StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"belongOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"effectDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"230\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{permitOrg}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{belongOrg}</t:Cell><t:Cell>$Resource{effectDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable5.setFormatXml(resHelper.translateString("kDTable5",kDTable5StrXML));

        

        this.kDTable5.checkParsed();
        // kDTable6
		String kDTable6StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"belongOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"effectDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{permitOrg}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{belongOrg}</t:Cell><t:Cell>$Resource{effectDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable6.setFormatXml(resHelper.translateString("kDTable6",kDTable6StrXML));

        

        this.kDTable6.checkParsed();
        // kDTable7
		String kDTable7StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitnumber\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"belongOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"effectDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"expireDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"times\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{permitOrg}</t:Cell><t:Cell>$Resource{permitnumber}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{belongOrg}</t:Cell><t:Cell>$Resource{effectDate}</t:Cell><t:Cell>$Resource{expireDate}</t:Cell><t:Cell>$Resource{times}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable7.setFormatXml(resHelper.translateString("kDTable7",kDTable7StrXML));

        

        this.kDTable7.checkParsed();
        // kDTable11
		String kDTable11StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"HpapSTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"papSTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HwPmtGTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wPmtGTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HwPmtNum\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wPmtNum\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"hWPmtSTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wPmtSTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{HpapSTime}</t:Cell><t:Cell>$Resource{papSTime}</t:Cell><t:Cell>$Resource{HwPmtGTime}</t:Cell><t:Cell>$Resource{wPmtGTime}</t:Cell><t:Cell>$Resource{HwPmtNum}</t:Cell><t:Cell>$Resource{wPmtNum}</t:Cell><t:Cell>$Resource{hWPmtSTime}</t:Cell><t:Cell>$Resource{wPmtSTime}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable11.setFormatXml(resHelper.translateString("kDTable11",kDTable11StrXML));

        

        this.kDTable11.checkParsed();
        // kDTable10
		String kDTable10StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"pmtProj\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HpmtProj\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HworkOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"quProf\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HquProf\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{pmtProj}</t:Cell><t:Cell>$Resource{HpmtProj}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{HworkOrg}</t:Cell><t:Cell>$Resource{quProf}</t:Cell><t:Cell>$Resource{HquProf}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable10.setFormatXml(resHelper.translateString("kDTable10",kDTable10StrXML));

        

        this.kDTable10.checkParsed();
        // kDTable8
		String kDTable8StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitnumber\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"belongOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"effectDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"expireDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{permitOrg}</t:Cell><t:Cell>$Resource{permitnumber}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{belongOrg}</t:Cell><t:Cell>$Resource{effectDate}</t:Cell><t:Cell>$Resource{expireDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable8.setFormatXml(resHelper.translateString("kDTable8",kDTable8StrXML));

        

        this.kDTable8.checkParsed();
        // kDTable13
		String kDTable13StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"rePmtETime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HrePmtETime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sRePmtSTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HsRePmtSTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"pmtETime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HpmtETime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"papSTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HpapSTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"pmtNum\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HpmtNum\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{rePmtETime}</t:Cell><t:Cell>$Resource{HrePmtETime}</t:Cell><t:Cell>$Resource{sRePmtSTime}</t:Cell><t:Cell>$Resource{HsRePmtSTime}</t:Cell><t:Cell>$Resource{pmtETime}</t:Cell><t:Cell>$Resource{HpmtETime}</t:Cell><t:Cell>$Resource{papSTime}</t:Cell><t:Cell>$Resource{HpapSTime}</t:Cell><t:Cell>$Resource{pmtNum}</t:Cell><t:Cell>$Resource{HpmtNum}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable13.setFormatXml(resHelper.translateString("kDTable13",kDTable13StrXML));

        

        this.kDTable13.checkParsed();
        // kDTable14
		String kDTable14StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"pmtProj\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HpmtProj\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HworkOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"quProf\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"HquProf\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{pmtProj}</t:Cell><t:Cell>$Resource{HpmtProj}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{HworkOrg}</t:Cell><t:Cell>$Resource{quProf}</t:Cell><t:Cell>$Resource{HquProf}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable14.setFormatXml(resHelper.translateString("kDTable14",kDTable14StrXML));

        

        this.kDTable14.checkParsed();
        // kDTable9
		String kDTable9StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"belongOrg\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"effectDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{permitOrg}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{belongOrg}</t:Cell><t:Cell>$Resource{effectDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable9.setFormatXml(resHelper.translateString("kDTable9",kDTable9StrXML));

        

        this.kDTable9.checkParsed();
        // bsnisState		
        this.bsnisState.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.perBizStateEnum").toArray());		
        this.bsnisState.setRequired(false);
        // visaType		
        this.visaType.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.visaTypeEnum").toArray());		
        this.visaType.setRequired(false);
        // txtfirstNameAlp		
        this.txtfirstNameAlp.setHorizontalAlignment(2);		
        this.txtfirstNameAlp.setMaxLength(100);		
        this.txtfirstNameAlp.setRequired(false);
        // txtlastNameApl		
        this.txtlastNameApl.setHorizontalAlignment(2);		
        this.txtlastNameApl.setMaxLength(100);		
        this.txtlastNameApl.setRequired(false);
        // prmtpermitProfession		
        this.prmtpermitProfession.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");		
        this.prmtpermitProfession.setEditable(true);		
        this.prmtpermitProfession.setDisplayFormat("$name$");		
        this.prmtpermitProfession.setEditFormat("$number$");		
        this.prmtpermitProfession.setCommitFormat("$number$");		
        this.prmtpermitProfession.setRequired(false);
        // prmtworkOrg		
        this.prmtworkOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtworkOrg.setEditable(true);		
        this.prmtworkOrg.setDisplayFormat("$name$");		
        this.prmtworkOrg.setEditFormat("$number$");		
        this.prmtworkOrg.setCommitFormat("$number$");		
        this.prmtworkOrg.setRequired(false);
        // prmtpermitOrg		
        this.prmtpermitOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtpermitOrg.setEditable(true);		
        this.prmtpermitOrg.setDisplayFormat("$name$");		
        this.prmtpermitOrg.setEditFormat("$number$");		
        this.prmtpermitOrg.setCommitFormat("$number$");		
        this.prmtpermitOrg.setRequired(false);
        // prmtcooperation		
        this.prmtcooperation.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcooperation.setEditable(true);		
        this.prmtcooperation.setDisplayFormat("$name$");		
        this.prmtcooperation.setEditFormat("$number$");		
        this.prmtcooperation.setCommitFormat("$number$");		
        this.prmtcooperation.setRequired(false);
        // txtpassportInst		
        this.txtpassportInst.setHorizontalAlignment(2);		
        this.txtpassportInst.setMaxLength(100);		
        this.txtpassportInst.setRequired(false);
        // merState		
        this.merState.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.mayrStatEnum").toArray());		
        this.merState.setRequired(false);
        // txtidNum		
        this.txtidNum.setHorizontalAlignment(2);		
        this.txtidNum.setMaxLength(100);		
        this.txtidNum.setRequired(false);
        // txtrealProf		
        this.txtrealProf.setHorizontalAlignment(2);		
        this.txtrealProf.setMaxLength(100);		
        this.txtrealProf.setRequired(false);
        // prmtnation		
        this.prmtnation.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");		
        this.prmtnation.setEditable(true);		
        this.prmtnation.setDisplayFormat("$name$");		
        this.prmtnation.setEditFormat("$number$");		
        this.prmtnation.setCommitFormat("$number$");		
        this.prmtnation.setRequired(false);
        // prmtcoupleNation		
        this.prmtcoupleNation.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");		
        this.prmtcoupleNation.setEditable(true);		
        this.prmtcoupleNation.setDisplayFormat("$name$");		
        this.prmtcoupleNation.setEditFormat("$number$");		
        this.prmtcoupleNation.setCommitFormat("$number$");		
        this.prmtcoupleNation.setRequired(false);
        // txtsecurityNo		
        this.txtsecurityNo.setHorizontalAlignment(2);		
        this.txtsecurityNo.setMaxLength(100);		
        this.txtsecurityNo.setRequired(false);
        // hBsnisState		
        this.hBsnisState.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.perBizStateEnum").toArray());		
        this.hBsnisState.setRequired(false);
        // prmtpassportCity		
        this.prmtpassportCity.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");		
        this.prmtpassportCity.setVisible(true);		
        this.prmtpassportCity.setEditable(true);		
        this.prmtpassportCity.setDisplayFormat("$name$");		
        this.prmtpassportCity.setEditFormat("$number$");		
        this.prmtpassportCity.setCommitFormat("$number$");		
        this.prmtpassportCity.setRequired(false);
        // txtpassportCityF		
        this.txtpassportCityF.setVisible(true);		
        this.txtpassportCityF.setHorizontalAlignment(2);		
        this.txtpassportCityF.setMaxLength(100);		
        this.txtpassportCityF.setRequired(false);
        // prmtcoopHis		
        this.prmtcoopHis.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcoopHis.setVisible(true);		
        this.prmtcoopHis.setEditable(true);		
        this.prmtcoopHis.setDisplayFormat("$name$");		
        this.prmtcoopHis.setEditFormat("$number$");		
        this.prmtcoopHis.setCommitFormat("$number$");		
        this.prmtcoopHis.setRequired(false);
        // txtcoopRecord		
        this.txtcoopRecord.setVisible(true);		
        this.txtcoopRecord.setHorizontalAlignment(2);		
        this.txtcoopRecord.setMaxLength(200);		
        this.txtcoopRecord.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtnameCN,txtfirstNameAlp,txtlastNameApl,sex,pkbirthDate,txtbirthPlaceCn,txtbirthPlaceFr,prmtnation,txtpassportNo,pkpassportIssueDate,pkpassportExpireDate,txtpassportInst,txtfatherName,txtfatherNameAlphabet,txtmotherName,txtmotherNameAlphabet,txtcoupleName,txtcoupleNameAlphabet,pkcoupleBirthDate,txtcoupleBirthPlace,txtcoupleWorkPlace,txtinnerAddress,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtcontactway,txtoldPassport,txtremark,bsnisState,visaType,prmtpermitProfession,prmtworkOrg,prmtpermitOrg,prmtcooperation,merState,txtidNum,txtrealProf,prmtcoupleNation,txtsecurityNo,hBsnisState,prmtpassportCity,txtpassportCityF,txtcoopRecord}));
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
        this.setBounds(new Rectangle(0, 0, 1158, 769));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1158, 769));
        contCreator.setBounds(new Rectangle(443, 760, 112, 19));
        this.add(contCreator, new KDLayout.Constraints(443, 760, 112, 19, 0));
        contCreateTime.setBounds(new Rectangle(685, 760, 112, 19));
        this.add(contCreateTime, new KDLayout.Constraints(685, 760, 112, 19, 0));
        contLastUpdateUser.setBounds(new Rectangle(41, 753, 146, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(41, 753, 146, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(808, 760, 112, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(808, 760, 112, 19, 0));
        contNumber.setBounds(new Rectangle(14, 6, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(14, 6, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(564, 760, 112, 19));
        this.add(contBizDate, new KDLayout.Constraints(564, 760, 112, 19, 0));
        contDescription.setBounds(new Rectangle(322, 760, 112, 19));
        this.add(contDescription, new KDLayout.Constraints(322, 760, 112, 19, 0));
        contAuditor.setBounds(new Rectangle(201, 760, 112, 19));
        this.add(contAuditor, new KDLayout.Constraints(201, 760, 112, 19, 0));
        contnameCN.setBounds(new Rectangle(14, 29, 270, 19));
        this.add(contnameCN, new KDLayout.Constraints(14, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsex.setBounds(new Rectangle(876, 29, 270, 19));
        this.add(contsex, new KDLayout.Constraints(876, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbirthDate.setBounds(new Rectangle(14, 52, 270, 19));
        this.add(contbirthDate, new KDLayout.Constraints(14, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpassportNo.setBounds(new Rectangle(14, 98, 270, 19));
        this.add(contpassportNo, new KDLayout.Constraints(14, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpassportIssueDate.setBounds(new Rectangle(588, 98, 270, 19));
        this.add(contpassportIssueDate, new KDLayout.Constraints(588, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpassportExpireDate.setBounds(new Rectangle(876, 98, 270, 19));
        this.add(contpassportExpireDate, new KDLayout.Constraints(876, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbirthPlaceCn.setBounds(new Rectangle(588, 52, 270, 19));
        this.add(contbirthPlaceCn, new KDLayout.Constraints(588, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbirthPlaceFr.setBounds(new Rectangle(876, 52, 270, 19));
        this.add(contbirthPlaceFr, new KDLayout.Constraints(876, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfatherName.setBounds(new Rectangle(14, 167, 270, 19));
        this.add(contfatherName, new KDLayout.Constraints(14, 167, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfatherNameAlphabet.setBounds(new Rectangle(304, 167, 270, 19));
        this.add(contfatherNameAlphabet, new KDLayout.Constraints(304, 167, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmotherName.setBounds(new Rectangle(588, 167, 270, 19));
        this.add(contmotherName, new KDLayout.Constraints(588, 167, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmotherNameAlphabet.setBounds(new Rectangle(876, 167, 270, 19));
        this.add(contmotherNameAlphabet, new KDLayout.Constraints(876, 167, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcoupleName.setBounds(new Rectangle(14, 191, 270, 19));
        this.add(contcoupleName, new KDLayout.Constraints(14, 191, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcoupleNameAlphabet.setBounds(new Rectangle(304, 191, 270, 19));
        this.add(contcoupleNameAlphabet, new KDLayout.Constraints(304, 191, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcoupleBirthDate.setBounds(new Rectangle(588, 191, 270, 19));
        this.add(contcoupleBirthDate, new KDLayout.Constraints(588, 191, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcoupleBirthPlace.setBounds(new Rectangle(14, 215, 270, 19));
        this.add(contcoupleBirthPlace, new KDLayout.Constraints(14, 215, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcoupleWorkPlace.setBounds(new Rectangle(304, 215, 270, 19));
        this.add(contcoupleWorkPlace, new KDLayout.Constraints(304, 215, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continnerAddress.setBounds(new Rectangle(876, 75, 271, 19));
        this.add(continnerAddress, new KDLayout.Constraints(876, 75, 271, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontactway.setBounds(new Rectangle(588, 75, 270, 19));
        this.add(contcontactway, new KDLayout.Constraints(588, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoldPassport.setBounds(new Rectangle(14, 121, 270, 19));
        this.add(contoldPassport, new KDLayout.Constraints(14, 121, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contremark.setBounds(new Rectangle(14, 240, 560, 19));
        this.add(contremark, new KDLayout.Constraints(14, 240, 560, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(8, 266, 1141, 486));
        this.add(kDTabbedPane1, new KDLayout.Constraints(8, 266, 1141, 486, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbsnisState.setBounds(new Rectangle(588, 6, 270, 19));
        this.add(contbsnisState, new KDLayout.Constraints(588, 6, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contvisaType.setBounds(new Rectangle(304, 6, 270, 19));
        this.add(contvisaType, new KDLayout.Constraints(304, 6, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfirstNameAlp.setBounds(new Rectangle(304, 29, 270, 19));
        this.add(contfirstNameAlp, new KDLayout.Constraints(304, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlastNameApl.setBounds(new Rectangle(588, 29, 270, 19));
        this.add(contlastNameApl, new KDLayout.Constraints(588, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpermitProfession.setBounds(new Rectangle(304, 121, 270, 19));
        this.add(contpermitProfession, new KDLayout.Constraints(304, 121, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contworkOrg.setBounds(new Rectangle(304, 144, 270, 19));
        this.add(contworkOrg, new KDLayout.Constraints(304, 144, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpermitOrg.setBounds(new Rectangle(14, 144, 270, 19));
        this.add(contpermitOrg, new KDLayout.Constraints(14, 144, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcooperation.setBounds(new Rectangle(588, 144, 270, 19));
        this.add(contcooperation, new KDLayout.Constraints(588, 144, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpassportInst.setBounds(new Rectangle(304, 98, 270, 19));
        this.add(contpassportInst, new KDLayout.Constraints(304, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmerState.setBounds(new Rectangle(876, 121, 270, 19));
        this.add(contmerState, new KDLayout.Constraints(876, 121, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contidNum.setBounds(new Rectangle(14, 75, 270, 19));
        this.add(contidNum, new KDLayout.Constraints(14, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrealProf.setBounds(new Rectangle(588, 121, 270, 19));
        this.add(contrealProf, new KDLayout.Constraints(588, 121, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnation.setBounds(new Rectangle(304, 52, 270, 19));
        this.add(contnation, new KDLayout.Constraints(304, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcoupleNation.setBounds(new Rectangle(876, 191, 270, 19));
        this.add(contcoupleNation, new KDLayout.Constraints(876, 191, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsecurityNo.setBounds(new Rectangle(304, 75, 270, 19));
        this.add(contsecurityNo, new KDLayout.Constraints(304, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthBsnisState.setBounds(new Rectangle(876, 6, 270, 19));
        this.add(conthBsnisState, new KDLayout.Constraints(876, 6, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpassportCity.setBounds(new Rectangle(588, 215, 270, 19));
        this.add(contpassportCity, new KDLayout.Constraints(588, 215, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpassportCityF.setBounds(new Rectangle(876, 215, 270, 19));
        this.add(contpassportCityF, new KDLayout.Constraints(876, 215, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcoopHis.setBounds(new Rectangle(876, 144, 270, 19));
        this.add(contcoopHis, new KDLayout.Constraints(876, 144, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcoopRecord.setBounds(new Rectangle(588, 241, 556, 19));
        this.add(contcoopRecord, new KDLayout.Constraints(588, 241, 556, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contnameCN
        contnameCN.setBoundEditor(txtnameCN);
        //contsex
        contsex.setBoundEditor(sex);
        //contbirthDate
        contbirthDate.setBoundEditor(pkbirthDate);
        //contpassportNo
        contpassportNo.setBoundEditor(txtpassportNo);
        //contpassportIssueDate
        contpassportIssueDate.setBoundEditor(pkpassportIssueDate);
        //contpassportExpireDate
        contpassportExpireDate.setBoundEditor(pkpassportExpireDate);
        //contbirthPlaceCn
        contbirthPlaceCn.setBoundEditor(txtbirthPlaceCn);
        //contbirthPlaceFr
        contbirthPlaceFr.setBoundEditor(txtbirthPlaceFr);
        //contfatherName
        contfatherName.setBoundEditor(txtfatherName);
        //contfatherNameAlphabet
        contfatherNameAlphabet.setBoundEditor(txtfatherNameAlphabet);
        //contmotherName
        contmotherName.setBoundEditor(txtmotherName);
        //contmotherNameAlphabet
        contmotherNameAlphabet.setBoundEditor(txtmotherNameAlphabet);
        //contcoupleName
        contcoupleName.setBoundEditor(txtcoupleName);
        //contcoupleNameAlphabet
        contcoupleNameAlphabet.setBoundEditor(txtcoupleNameAlphabet);
        //contcoupleBirthDate
        contcoupleBirthDate.setBoundEditor(pkcoupleBirthDate);
        //contcoupleBirthPlace
        contcoupleBirthPlace.setBoundEditor(txtcoupleBirthPlace);
        //contcoupleWorkPlace
        contcoupleWorkPlace.setBoundEditor(txtcoupleWorkPlace);
        //continnerAddress
        continnerAddress.setBoundEditor(txtinnerAddress);
        //contcontactway
        contcontactway.setBoundEditor(txtcontactway);
        //contoldPassport
        contoldPassport.setBoundEditor(txtoldPassport);
        //contremark
        contremark.setBoundEditor(txtremark);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel12, resHelper.getString("kDPanel12.constraints"));
        kDTabbedPane1.add(kDPanel16, resHelper.getString("kDPanel16.constraints"));
        kDTabbedPane1.add(kDPanel15, resHelper.getString("kDPanel15.constraints"));
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane1.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        kDTabbedPane1.add(kDPanel6, resHelper.getString("kDPanel6.constraints"));
        kDTabbedPane1.add(kDPanel7, resHelper.getString("kDPanel7.constraints"));
        kDTabbedPane1.add(kDPanel11, resHelper.getString("kDPanel11.constraints"));
        kDTabbedPane1.add(kDPanel10, resHelper.getString("kDPanel10.constraints"));
        kDTabbedPane1.add(kDPanel8, resHelper.getString("kDPanel8.constraints"));
        kDTabbedPane1.add(kDPanel13, resHelper.getString("kDPanel13.constraints"));
        kDTabbedPane1.add(kDPanel14, resHelper.getString("kDPanel14.constraints"));
        kDTabbedPane1.add(kDPanel9, resHelper.getString("kDPanel9.constraints"));
        //kDPanel12
kDPanel12.setLayout(new BorderLayout(0, 0));        kDPanel12.add(tblAttachment, BorderLayout.CENTER);
        //kDPanel16
kDPanel16.setLayout(new BorderLayout(0, 0));        kDPanel16.add(kDTable12, BorderLayout.CENTER);
        //kDPanel15
kDPanel15.setLayout(new BorderLayout(0, 0));        kDPanel15.add(kDTable15, BorderLayout.CENTER);
        //kDPanel1
kDPanel1.setLayout(new BorderLayout(0, 0));        kDPanel1.add(kDTable1, BorderLayout.CENTER);
        //kDPanel3
kDPanel3.setLayout(new BorderLayout(0, 0));        kDPanel3.add(kDTable3, BorderLayout.CENTER);
        //kDPanel2
kDPanel2.setLayout(new BorderLayout(0, 0));        kDPanel2.add(kDTable2, BorderLayout.CENTER);
        //kDPanel4
kDPanel4.setLayout(new BorderLayout(0, 0));        kDPanel4.add(kDTable4, BorderLayout.CENTER);
        //kDPanel5
kDPanel5.setLayout(new BorderLayout(0, 0));        kDPanel5.add(kDTable5, BorderLayout.CENTER);
        //kDPanel6
kDPanel6.setLayout(new BorderLayout(0, 0));        kDPanel6.add(kDTable6, BorderLayout.CENTER);
        //kDPanel7
kDPanel7.setLayout(new BorderLayout(0, 0));        kDPanel7.add(kDTable7, BorderLayout.CENTER);
        //kDPanel11
kDPanel11.setLayout(new BorderLayout(0, 0));        kDPanel11.add(kDTable11, BorderLayout.CENTER);
        //kDPanel10
kDPanel10.setLayout(new BorderLayout(0, 0));        kDPanel10.add(kDTable10, BorderLayout.CENTER);
        //kDPanel8
kDPanel8.setLayout(new BorderLayout(0, 0));        kDPanel8.add(kDTable8, BorderLayout.CENTER);
        //kDPanel13
kDPanel13.setLayout(new BorderLayout(0, 0));        kDPanel13.add(kDTable13, BorderLayout.CENTER);
        //kDPanel14
kDPanel14.setLayout(new BorderLayout(0, 0));        kDPanel14.add(kDTable14, BorderLayout.CENTER);
        //kDPanel9
kDPanel9.setLayout(new BorderLayout(0, 0));        kDPanel9.add(kDTable9, BorderLayout.CENTER);
        //contbsnisState
        contbsnisState.setBoundEditor(bsnisState);
        //contvisaType
        contvisaType.setBoundEditor(visaType);
        //contfirstNameAlp
        contfirstNameAlp.setBoundEditor(txtfirstNameAlp);
        //contlastNameApl
        contlastNameApl.setBoundEditor(txtlastNameApl);
        //contpermitProfession
        contpermitProfession.setBoundEditor(prmtpermitProfession);
        //contworkOrg
        contworkOrg.setBoundEditor(prmtworkOrg);
        //contpermitOrg
        contpermitOrg.setBoundEditor(prmtpermitOrg);
        //contcooperation
        contcooperation.setBoundEditor(prmtcooperation);
        //contpassportInst
        contpassportInst.setBoundEditor(txtpassportInst);
        //contmerState
        contmerState.setBoundEditor(merState);
        //contidNum
        contidNum.setBoundEditor(txtidNum);
        //contrealProf
        contrealProf.setBoundEditor(txtrealProf);
        //contnation
        contnation.setBoundEditor(prmtnation);
        //contcoupleNation
        contcoupleNation.setBoundEditor(prmtcoupleNation);
        //contsecurityNo
        contsecurityNo.setBoundEditor(txtsecurityNo);
        //conthBsnisState
        conthBsnisState.setBoundEditor(hBsnisState);
        //contpassportCity
        contpassportCity.setBoundEditor(prmtpassportCity);
        //contpassportCityF
        contpassportCityF.setBoundEditor(txtpassportCityF);
        //contcoopHis
        contcoopHis.setBoundEditor(prmtcoopHis);
        //contcoopRecord
        contcoopRecord.setBoundEditor(txtcoopRecord);

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
		dataBinder.registerBinding("nameCN", String.class, this.txtnameCN, "text");
		dataBinder.registerBinding("sex", com.kingdee.eas.basedata.person.Genders.class, this.sex, "selectedItem");
		dataBinder.registerBinding("birthDate", java.util.Date.class, this.pkbirthDate, "value");
		dataBinder.registerBinding("passportNo", String.class, this.txtpassportNo, "text");
		dataBinder.registerBinding("passportIssueDate", java.util.Date.class, this.pkpassportIssueDate, "value");
		dataBinder.registerBinding("passportExpireDate", java.util.Date.class, this.pkpassportExpireDate, "value");
		dataBinder.registerBinding("birthPlaceCn", String.class, this.txtbirthPlaceCn, "text");
		dataBinder.registerBinding("birthPlaceFr", String.class, this.txtbirthPlaceFr, "text");
		dataBinder.registerBinding("fatherName", String.class, this.txtfatherName, "text");
		dataBinder.registerBinding("fatherNameAlphabet", String.class, this.txtfatherNameAlphabet, "text");
		dataBinder.registerBinding("motherName", String.class, this.txtmotherName, "text");
		dataBinder.registerBinding("motherNameAlphabet", String.class, this.txtmotherNameAlphabet, "text");
		dataBinder.registerBinding("coupleName", String.class, this.txtcoupleName, "text");
		dataBinder.registerBinding("coupleNameAlphabet", String.class, this.txtcoupleNameAlphabet, "text");
		dataBinder.registerBinding("coupleBirthDate", java.util.Date.class, this.pkcoupleBirthDate, "value");
		dataBinder.registerBinding("coupleBirthPlace", String.class, this.txtcoupleBirthPlace, "text");
		dataBinder.registerBinding("coupleWorkPlace", String.class, this.txtcoupleWorkPlace, "text");
		dataBinder.registerBinding("innerAddress", String.class, this.txtinnerAddress, "text");
		dataBinder.registerBinding("contactway", String.class, this.txtcontactway, "text");
		dataBinder.registerBinding("oldPassport", String.class, this.txtoldPassport, "text");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("bsnisState", com.kingdee.eas.zjlw.certificates.app.perBizStateEnum.class, this.bsnisState, "selectedItem");
		dataBinder.registerBinding("visaType", com.kingdee.eas.zjlw.certificates.app.visaTypeEnum.class, this.visaType, "selectedItem");
		dataBinder.registerBinding("firstNameAlp", String.class, this.txtfirstNameAlp, "text");
		dataBinder.registerBinding("lastNameApl", String.class, this.txtlastNameApl, "text");
		dataBinder.registerBinding("permitProfession", com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo.class, this.prmtpermitProfession, "data");
		dataBinder.registerBinding("workOrg", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtworkOrg, "data");
		dataBinder.registerBinding("permitOrg", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtpermitOrg, "data");
		dataBinder.registerBinding("cooperation", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcooperation, "data");
		dataBinder.registerBinding("passportInst", String.class, this.txtpassportInst, "text");
		dataBinder.registerBinding("merState", com.kingdee.eas.zjlw.certificates.app.mayrStatEnum.class, this.merState, "selectedItem");
		dataBinder.registerBinding("idNum", String.class, this.txtidNum, "text");
		dataBinder.registerBinding("realProf", String.class, this.txtrealProf, "text");
		dataBinder.registerBinding("nation", com.kingdee.eas.basedata.assistant.CountryInfo.class, this.prmtnation, "data");
		dataBinder.registerBinding("coupleNation", com.kingdee.eas.basedata.assistant.CountryInfo.class, this.prmtcoupleNation, "data");
		dataBinder.registerBinding("securityNo", String.class, this.txtsecurityNo, "text");
		dataBinder.registerBinding("hBsnisState", com.kingdee.eas.zjlw.certificates.app.perBizStateEnum.class, this.hBsnisState, "selectedItem");
		dataBinder.registerBinding("passportCity", com.kingdee.eas.basedata.assistant.ProvinceInfo.class, this.prmtpassportCity, "data");
		dataBinder.registerBinding("passportCityF", String.class, this.txtpassportCityF, "text");
		dataBinder.registerBinding("coopHis", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcoopHis, "data");
		dataBinder.registerBinding("coopRecord", String.class, this.txtcoopRecord, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.personinfo.app.PersonHistoryEditUIHandler";
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
        this.txtnameCN.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo)ov;
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
		getValidateHelper().registerBindProperty("nameCN", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("birthDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("passportNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("passportIssueDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("passportExpireDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("birthPlaceCn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("birthPlaceFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fatherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fatherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("motherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("motherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coupleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coupleNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coupleBirthDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coupleBirthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coupleWorkPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("innerAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contactway", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oldPassport", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bsnisState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("visaType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("firstNameAlp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastNameApl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("permitProfession", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("permitOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("passportInst", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("merState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("idNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("realProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coupleNation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("securityNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hBsnisState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("passportCity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("passportCityF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coopHis", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coopRecord", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("nameCN"));
        sic.add(new SelectorItemInfo("sex"));
        sic.add(new SelectorItemInfo("birthDate"));
        sic.add(new SelectorItemInfo("passportNo"));
        sic.add(new SelectorItemInfo("passportIssueDate"));
        sic.add(new SelectorItemInfo("passportExpireDate"));
        sic.add(new SelectorItemInfo("birthPlaceCn"));
        sic.add(new SelectorItemInfo("birthPlaceFr"));
        sic.add(new SelectorItemInfo("fatherName"));
        sic.add(new SelectorItemInfo("fatherNameAlphabet"));
        sic.add(new SelectorItemInfo("motherName"));
        sic.add(new SelectorItemInfo("motherNameAlphabet"));
        sic.add(new SelectorItemInfo("coupleName"));
        sic.add(new SelectorItemInfo("coupleNameAlphabet"));
        sic.add(new SelectorItemInfo("coupleBirthDate"));
        sic.add(new SelectorItemInfo("coupleBirthPlace"));
        sic.add(new SelectorItemInfo("coupleWorkPlace"));
        sic.add(new SelectorItemInfo("innerAddress"));
        sic.add(new SelectorItemInfo("contactway"));
        sic.add(new SelectorItemInfo("oldPassport"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("bsnisState"));
        sic.add(new SelectorItemInfo("visaType"));
        sic.add(new SelectorItemInfo("firstNameAlp"));
        sic.add(new SelectorItemInfo("lastNameApl"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("permitProfession.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("permitProfession.id"));
        	sic.add(new SelectorItemInfo("permitProfession.number"));
        	sic.add(new SelectorItemInfo("permitProfession.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("workOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("workOrg.id"));
        	sic.add(new SelectorItemInfo("workOrg.number"));
        	sic.add(new SelectorItemInfo("workOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("permitOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("permitOrg.id"));
        	sic.add(new SelectorItemInfo("permitOrg.number"));
        	sic.add(new SelectorItemInfo("permitOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("cooperation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("cooperation.id"));
        	sic.add(new SelectorItemInfo("cooperation.number"));
        	sic.add(new SelectorItemInfo("cooperation.name"));
		}
        sic.add(new SelectorItemInfo("passportInst"));
        sic.add(new SelectorItemInfo("merState"));
        sic.add(new SelectorItemInfo("idNum"));
        sic.add(new SelectorItemInfo("realProf"));
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
			sic.add(new SelectorItemInfo("coupleNation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("coupleNation.id"));
        	sic.add(new SelectorItemInfo("coupleNation.number"));
        	sic.add(new SelectorItemInfo("coupleNation.name"));
		}
        sic.add(new SelectorItemInfo("securityNo"));
        sic.add(new SelectorItemInfo("hBsnisState"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("passportCity.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("passportCity.id"));
        	sic.add(new SelectorItemInfo("passportCity.number"));
        	sic.add(new SelectorItemInfo("passportCity.name"));
		}
        sic.add(new SelectorItemInfo("passportCityF"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("coopHis.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("coopHis.id"));
        	sic.add(new SelectorItemInfo("coopHis.number"));
        	sic.add(new SelectorItemInfo("coopHis.name"));
		}
        sic.add(new SelectorItemInfo("coopRecord"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.personinfo.client", "PersonHistoryEditUI");
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
        return com.kingdee.eas.zjlw.personinfo.client.PersonHistoryEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo objectValue = new com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/personinfo/PersonHistory";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.personinfo.app.PersonHistoryQuery");
	}
    

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return tblAttachment;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("sex",new Integer(1));
vo.put("bsnisState","10");
vo.put("visaType","0");
vo.put("merState","0");
vo.put("hBsnisState","10");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}