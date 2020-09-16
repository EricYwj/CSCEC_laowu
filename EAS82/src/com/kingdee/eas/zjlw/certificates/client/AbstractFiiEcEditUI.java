/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

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
public abstract class AbstractFiiEcEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFiiEcEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillSate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnAuditime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpCauditime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpAudiTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpCauditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbNum;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pknAuditime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkpCauditime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkpAudiTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpCauditor;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.zjlw.certificates.FiiEcInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractFiiEcEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFiiEcEditUI.class.getName());
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
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillSate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnAuditime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpCauditime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpAudiTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpCauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.billSate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pknAuditime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkpCauditime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkpAudiTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtnAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpCauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contbNum.setName("contbNum");
        this.contauditDate.setName("contauditDate");
        this.contbillSate.setName("contbillSate");
        this.contnAuditime.setName("contnAuditime");
        this.contpCauditime.setName("contpCauditime");
        this.contpAudiTime.setName("contpAudiTime");
        this.contnAuditor.setName("contnAuditor");
        this.contpAuditor.setName("contpAuditor");
        this.contpCauditor.setName("contpCauditor");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtbNum.setName("txtbNum");
        this.pkauditDate.setName("pkauditDate");
        this.billSate.setName("billSate");
        this.pknAuditime.setName("pknAuditime");
        this.pkpCauditime.setName("pkpCauditime");
        this.pkpAudiTime.setName("pkpAudiTime");
        this.prmtnAuditor.setName("prmtnAuditor");
        this.prmtpAuditor.setName("prmtpAuditor");
        this.prmtpCauditor.setName("prmtpCauditor");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
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
        this.contNumber.setBoundLabelLength(135);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contNumber.setEnabled(false);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(120);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(false);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(120);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol31\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol32\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol33\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol38\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol41\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol43\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol45\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol46\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol47\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol48\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol49\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol50\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol51\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol52\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"numBer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"fiiDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"genDers\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"birthdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"country\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"passportNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"workSuffer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol8\" /><t:Column t:key=\"actprofF\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol9\" /><t:Column t:key=\"pmtProfC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"pmtProfFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"authType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"copies\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol13\" /><t:Column t:key=\"wkPmtGet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /><t:Column t:key=\"wpCopies\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"pmtProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"taskProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"partner\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"signNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"IdNum\" t:width=\"145\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"sourceEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"birthPlaceCn\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"birthPlaceFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"passportIssueDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"passportExpireDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"passportAgence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"passportCityC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"passportCityF\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"oldPassport\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"fatherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"fatherNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"motherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"motherNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"MaritalStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"coupleName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"coupleNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"coupleBirthDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"coupleBirthPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"coupleNational\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"coupleWorkPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"contactway\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"residence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"personState\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"isPush\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"oldEtyId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol49\" /><t:Column t:key=\"skillShare\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol50\" /><t:Column t:key=\"isWkExprice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"wkExprice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol52\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{numBer}</t:Cell><t:Cell>$Resource{fiiDate}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{genDers}</t:Cell><t:Cell>$Resource{birthdate}</t:Cell><t:Cell>$Resource{country}</t:Cell><t:Cell>$Resource{passportNo}</t:Cell><t:Cell>$Resource{workSuffer}</t:Cell><t:Cell>$Resource{actprofF}</t:Cell><t:Cell>$Resource{pmtProfC}</t:Cell><t:Cell>$Resource{pmtProfFr}</t:Cell><t:Cell>$Resource{authType}</t:Cell><t:Cell>$Resource{copies}</t:Cell><t:Cell>$Resource{wkPmtGet}</t:Cell><t:Cell>$Resource{wpCopies}</t:Cell><t:Cell>$Resource{pmtProj}</t:Cell><t:Cell>$Resource{taskProj}</t:Cell><t:Cell>$Resource{partner}</t:Cell><t:Cell>$Resource{signNum}</t:Cell><t:Cell>$Resource{IdNum}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{personID}</t:Cell><t:Cell>$Resource{sourceEntryID}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{birthPlaceCn}</t:Cell><t:Cell>$Resource{birthPlaceFr}</t:Cell><t:Cell>$Resource{passportIssueDate}</t:Cell><t:Cell>$Resource{passportExpireDate}</t:Cell><t:Cell>$Resource{passportAgence}</t:Cell><t:Cell>$Resource{passportCityC}</t:Cell><t:Cell>$Resource{passportCityF}</t:Cell><t:Cell>$Resource{oldPassport}</t:Cell><t:Cell>$Resource{fatherName}</t:Cell><t:Cell>$Resource{fatherNameAlphabet}</t:Cell><t:Cell>$Resource{motherName}</t:Cell><t:Cell>$Resource{motherNameAlphabet}</t:Cell><t:Cell>$Resource{MaritalStatus}</t:Cell><t:Cell>$Resource{coupleName}</t:Cell><t:Cell>$Resource{coupleNameAlphabet}</t:Cell><t:Cell>$Resource{coupleBirthDate}</t:Cell><t:Cell>$Resource{coupleBirthPlace}</t:Cell><t:Cell>$Resource{coupleNational}</t:Cell><t:Cell>$Resource{coupleWorkPlace}</t:Cell><t:Cell>$Resource{contactway}</t:Cell><t:Cell>$Resource{residence}</t:Cell><t:Cell>$Resource{personState}</t:Cell><t:Cell>$Resource{isPush}</t:Cell><t:Cell>$Resource{oldEtyId}</t:Cell><t:Cell>$Resource{skillShare}</t:Cell><t:Cell>$Resource{isWkExprice}</t:Cell><t:Cell>$Resource{wkExprice}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.kdtEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","numBer","fiiDate","name","genDers","birthdate","country","passportNo","workSuffer","actprofF","pmtProfC","pmtProfFr","authType","copies","wkPmtGet","wpCopies","pmtProj","taskProj","partner","signNum","IdNum","remark","personID","sourceEntryID","firstName","lastName","birthPlaceCn","birthPlaceFr","passportIssueDate","passportExpireDate","passportAgence","passportCityC","passportCityF","oldPassport","fatherName","fatherNameAlphabet","motherName","motherNameAlphabet","MaritalStatus","coupleName","coupleNameAlphabet","coupleBirthDate","coupleBirthPlace","coupleNational","coupleWorkPlace","contactway","residence","personState","isPush","oldEtyId","skillShare","isWkExprice","wkExprice"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_numBer_TextField = new KDTextField();
        kdtEntrys_numBer_TextField.setName("kdtEntrys_numBer_TextField");
        kdtEntrys_numBer_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_numBer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_numBer_TextField);
        this.kdtEntrys.getColumn("numBer").setEditor(kdtEntrys_numBer_CellEditor);
        KDDatePicker kdtEntrys_fiiDate_DatePicker = new KDDatePicker();
        kdtEntrys_fiiDate_DatePicker.setName("kdtEntrys_fiiDate_DatePicker");
        kdtEntrys_fiiDate_DatePicker.setVisible(true);
        kdtEntrys_fiiDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_fiiDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fiiDate_DatePicker);
        this.kdtEntrys.getColumn("fiiDate").setEditor(kdtEntrys_fiiDate_CellEditor);
        KDTextField kdtEntrys_name_TextField = new KDTextField();
        kdtEntrys_name_TextField.setName("kdtEntrys_name_TextField");
        kdtEntrys_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_name_CellEditor = new KDTDefaultCellEditor(kdtEntrys_name_TextField);
        this.kdtEntrys.getColumn("name").setEditor(kdtEntrys_name_CellEditor);
        KDComboBox kdtEntrys_genDers_ComboBox = new KDComboBox();
        kdtEntrys_genDers_ComboBox.setName("kdtEntrys_genDers_ComboBox");
        kdtEntrys_genDers_ComboBox.setVisible(true);
        kdtEntrys_genDers_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());
        KDTDefaultCellEditor kdtEntrys_genDers_CellEditor = new KDTDefaultCellEditor(kdtEntrys_genDers_ComboBox);
        this.kdtEntrys.getColumn("genDers").setEditor(kdtEntrys_genDers_CellEditor);
        KDDatePicker kdtEntrys_birthdate_DatePicker = new KDDatePicker();
        kdtEntrys_birthdate_DatePicker.setName("kdtEntrys_birthdate_DatePicker");
        kdtEntrys_birthdate_DatePicker.setVisible(true);
        kdtEntrys_birthdate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_birthdate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthdate_DatePicker);
        this.kdtEntrys.getColumn("birthdate").setEditor(kdtEntrys_birthdate_CellEditor);
        final KDBizPromptBox kdtEntrys_country_PromptBox = new KDBizPromptBox();
        kdtEntrys_country_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");
        kdtEntrys_country_PromptBox.setVisible(true);
        kdtEntrys_country_PromptBox.setEditable(true);
        kdtEntrys_country_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_country_PromptBox.setEditFormat("$number$");
        kdtEntrys_country_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_country_CellEditor = new KDTDefaultCellEditor(kdtEntrys_country_PromptBox);
        this.kdtEntrys.getColumn("country").setEditor(kdtEntrys_country_CellEditor);
        ObjectValueRender kdtEntrys_country_OVR = new ObjectValueRender();
        kdtEntrys_country_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("country").setRenderer(kdtEntrys_country_OVR);
        KDTextField kdtEntrys_passportNo_TextField = new KDTextField();
        kdtEntrys_passportNo_TextField.setName("kdtEntrys_passportNo_TextField");
        kdtEntrys_passportNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_passportNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportNo_TextField);
        this.kdtEntrys.getColumn("passportNo").setEditor(kdtEntrys_passportNo_CellEditor);
        KDTextField kdtEntrys_workSuffer_TextField = new KDTextField();
        kdtEntrys_workSuffer_TextField.setName("kdtEntrys_workSuffer_TextField");
        kdtEntrys_workSuffer_TextField.setMaxLength(50);
        KDTDefaultCellEditor kdtEntrys_workSuffer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workSuffer_TextField);
        this.kdtEntrys.getColumn("workSuffer").setEditor(kdtEntrys_workSuffer_CellEditor);
        KDTextField kdtEntrys_actprofF_TextField = new KDTextField();
        kdtEntrys_actprofF_TextField.setName("kdtEntrys_actprofF_TextField");
        kdtEntrys_actprofF_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_actprofF_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actprofF_TextField);
        this.kdtEntrys.getColumn("actprofF").setEditor(kdtEntrys_actprofF_CellEditor);
        final KDBizPromptBox kdtEntrys_pmtProfC_PromptBox = new KDBizPromptBox();
        kdtEntrys_pmtProfC_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");
        kdtEntrys_pmtProfC_PromptBox.setVisible(true);
        kdtEntrys_pmtProfC_PromptBox.setEditable(true);
        kdtEntrys_pmtProfC_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_pmtProfC_PromptBox.setEditFormat("$number$");
        kdtEntrys_pmtProfC_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_pmtProfC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProfC_PromptBox);
        this.kdtEntrys.getColumn("pmtProfC").setEditor(kdtEntrys_pmtProfC_CellEditor);
        ObjectValueRender kdtEntrys_pmtProfC_OVR = new ObjectValueRender();
        kdtEntrys_pmtProfC_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("pmtProfC").setRenderer(kdtEntrys_pmtProfC_OVR);
        KDTextField kdtEntrys_pmtProfFr_TextField = new KDTextField();
        kdtEntrys_pmtProfFr_TextField.setName("kdtEntrys_pmtProfFr_TextField");
        kdtEntrys_pmtProfFr_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_pmtProfFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProfFr_TextField);
        this.kdtEntrys.getColumn("pmtProfFr").setEditor(kdtEntrys_pmtProfFr_CellEditor);
        KDComboBox kdtEntrys_authType_ComboBox = new KDComboBox();
        kdtEntrys_authType_ComboBox.setName("kdtEntrys_authType_ComboBox");
        kdtEntrys_authType_ComboBox.setVisible(true);
        kdtEntrys_authType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.authType").toArray());
        KDTDefaultCellEditor kdtEntrys_authType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_authType_ComboBox);
        this.kdtEntrys.getColumn("authType").setEditor(kdtEntrys_authType_CellEditor);
        KDFormattedTextField kdtEntrys_copies_TextField = new KDFormattedTextField();
        kdtEntrys_copies_TextField.setName("kdtEntrys_copies_TextField");
        kdtEntrys_copies_TextField.setVisible(true);
        kdtEntrys_copies_TextField.setEditable(true);
        kdtEntrys_copies_TextField.setHorizontalAlignment(2);
        kdtEntrys_copies_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_copies_CellEditor = new KDTDefaultCellEditor(kdtEntrys_copies_TextField);
        this.kdtEntrys.getColumn("copies").setEditor(kdtEntrys_copies_CellEditor);
        KDCheckBox kdtEntrys_wkPmtGet_CheckBox = new KDCheckBox();
        kdtEntrys_wkPmtGet_CheckBox.setName("kdtEntrys_wkPmtGet_CheckBox");
        KDTDefaultCellEditor kdtEntrys_wkPmtGet_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wkPmtGet_CheckBox);
        this.kdtEntrys.getColumn("wkPmtGet").setEditor(kdtEntrys_wkPmtGet_CellEditor);
        KDFormattedTextField kdtEntrys_wpCopies_TextField = new KDFormattedTextField();
        kdtEntrys_wpCopies_TextField.setName("kdtEntrys_wpCopies_TextField");
        kdtEntrys_wpCopies_TextField.setVisible(true);
        kdtEntrys_wpCopies_TextField.setEditable(true);
        kdtEntrys_wpCopies_TextField.setHorizontalAlignment(2);
        kdtEntrys_wpCopies_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_wpCopies_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wpCopies_TextField);
        this.kdtEntrys.getColumn("wpCopies").setEditor(kdtEntrys_wpCopies_CellEditor);
        final KDBizPromptBox kdtEntrys_pmtProj_PromptBox = new KDBizPromptBox();
        kdtEntrys_pmtProj_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_pmtProj_PromptBox.setVisible(true);
        kdtEntrys_pmtProj_PromptBox.setEditable(true);
        kdtEntrys_pmtProj_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_pmtProj_PromptBox.setEditFormat("$number$");
        kdtEntrys_pmtProj_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_pmtProj_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProj_PromptBox);
        this.kdtEntrys.getColumn("pmtProj").setEditor(kdtEntrys_pmtProj_CellEditor);
        ObjectValueRender kdtEntrys_pmtProj_OVR = new ObjectValueRender();
        kdtEntrys_pmtProj_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("pmtProj").setRenderer(kdtEntrys_pmtProj_OVR);
        final KDBizPromptBox kdtEntrys_taskProj_PromptBox = new KDBizPromptBox();
        kdtEntrys_taskProj_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_taskProj_PromptBox.setVisible(true);
        kdtEntrys_taskProj_PromptBox.setEditable(true);
        kdtEntrys_taskProj_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_taskProj_PromptBox.setEditFormat("$number$");
        kdtEntrys_taskProj_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_taskProj_CellEditor = new KDTDefaultCellEditor(kdtEntrys_taskProj_PromptBox);
        this.kdtEntrys.getColumn("taskProj").setEditor(kdtEntrys_taskProj_CellEditor);
        ObjectValueRender kdtEntrys_taskProj_OVR = new ObjectValueRender();
        kdtEntrys_taskProj_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("taskProj").setRenderer(kdtEntrys_taskProj_OVR);
        final KDBizPromptBox kdtEntrys_partner_PromptBox = new KDBizPromptBox();
        kdtEntrys_partner_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_partner_PromptBox.setVisible(true);
        kdtEntrys_partner_PromptBox.setEditable(true);
        kdtEntrys_partner_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_partner_PromptBox.setEditFormat("$number$");
        kdtEntrys_partner_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_partner_CellEditor = new KDTDefaultCellEditor(kdtEntrys_partner_PromptBox);
        this.kdtEntrys.getColumn("partner").setEditor(kdtEntrys_partner_CellEditor);
        ObjectValueRender kdtEntrys_partner_OVR = new ObjectValueRender();
        kdtEntrys_partner_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("partner").setRenderer(kdtEntrys_partner_OVR);
        KDTextField kdtEntrys_signNum_TextField = new KDTextField();
        kdtEntrys_signNum_TextField.setName("kdtEntrys_signNum_TextField");
        kdtEntrys_signNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_signNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_signNum_TextField);
        this.kdtEntrys.getColumn("signNum").setEditor(kdtEntrys_signNum_CellEditor);
        KDTextField kdtEntrys_IdNum_TextField = new KDTextField();
        kdtEntrys_IdNum_TextField.setName("kdtEntrys_IdNum_TextField");
        kdtEntrys_IdNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_IdNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IdNum_TextField);
        this.kdtEntrys.getColumn("IdNum").setEditor(kdtEntrys_IdNum_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        KDTextField kdtEntrys_personID_TextField = new KDTextField();
        kdtEntrys_personID_TextField.setName("kdtEntrys_personID_TextField");
        kdtEntrys_personID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_personID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personID_TextField);
        this.kdtEntrys.getColumn("personID").setEditor(kdtEntrys_personID_CellEditor);
        KDTextField kdtEntrys_sourceEntryID_TextField = new KDTextField();
        kdtEntrys_sourceEntryID_TextField.setName("kdtEntrys_sourceEntryID_TextField");
        kdtEntrys_sourceEntryID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_sourceEntryID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sourceEntryID_TextField);
        this.kdtEntrys.getColumn("sourceEntryID").setEditor(kdtEntrys_sourceEntryID_CellEditor);
        KDTextField kdtEntrys_firstName_TextField = new KDTextField();
        kdtEntrys_firstName_TextField.setName("kdtEntrys_firstName_TextField");
        kdtEntrys_firstName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_firstName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_firstName_TextField);
        this.kdtEntrys.getColumn("firstName").setEditor(kdtEntrys_firstName_CellEditor);
        KDTextField kdtEntrys_lastName_TextField = new KDTextField();
        kdtEntrys_lastName_TextField.setName("kdtEntrys_lastName_TextField");
        kdtEntrys_lastName_TextField.setMaxLength(50);
        KDTDefaultCellEditor kdtEntrys_lastName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lastName_TextField);
        this.kdtEntrys.getColumn("lastName").setEditor(kdtEntrys_lastName_CellEditor);
        KDTextField kdtEntrys_birthPlaceCn_TextField = new KDTextField();
        kdtEntrys_birthPlaceCn_TextField.setName("kdtEntrys_birthPlaceCn_TextField");
        kdtEntrys_birthPlaceCn_TextField.setMaxLength(50);
        KDTDefaultCellEditor kdtEntrys_birthPlaceCn_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlaceCn_TextField);
        this.kdtEntrys.getColumn("birthPlaceCn").setEditor(kdtEntrys_birthPlaceCn_CellEditor);
        KDTextField kdtEntrys_birthPlaceFr_TextField = new KDTextField();
        kdtEntrys_birthPlaceFr_TextField.setName("kdtEntrys_birthPlaceFr_TextField");
        kdtEntrys_birthPlaceFr_TextField.setMaxLength(50);
        KDTDefaultCellEditor kdtEntrys_birthPlaceFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlaceFr_TextField);
        this.kdtEntrys.getColumn("birthPlaceFr").setEditor(kdtEntrys_birthPlaceFr_CellEditor);
        KDDatePicker kdtEntrys_passportIssueDate_DatePicker = new KDDatePicker();
        kdtEntrys_passportIssueDate_DatePicker.setName("kdtEntrys_passportIssueDate_DatePicker");
        kdtEntrys_passportIssueDate_DatePicker.setVisible(true);
        kdtEntrys_passportIssueDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passportIssueDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportIssueDate_DatePicker);
        this.kdtEntrys.getColumn("passportIssueDate").setEditor(kdtEntrys_passportIssueDate_CellEditor);
        KDDatePicker kdtEntrys_passportExpireDate_DatePicker = new KDDatePicker();
        kdtEntrys_passportExpireDate_DatePicker.setName("kdtEntrys_passportExpireDate_DatePicker");
        kdtEntrys_passportExpireDate_DatePicker.setVisible(true);
        kdtEntrys_passportExpireDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passportExpireDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportExpireDate_DatePicker);
        this.kdtEntrys.getColumn("passportExpireDate").setEditor(kdtEntrys_passportExpireDate_CellEditor);
        KDComboBox kdtEntrys_passportAgence_ComboBox = new KDComboBox();
        kdtEntrys_passportAgence_ComboBox.setName("kdtEntrys_passportAgence_ComboBox");
        kdtEntrys_passportAgence_ComboBox.setVisible(true);
        kdtEntrys_passportAgence_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_passportAgence_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportAgence_ComboBox);
        this.kdtEntrys.getColumn("passportAgence").setEditor(kdtEntrys_passportAgence_CellEditor);
        final KDBizPromptBox kdtEntrys_passportCityC_PromptBox = new KDBizPromptBox();
        kdtEntrys_passportCityC_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");
        kdtEntrys_passportCityC_PromptBox.setVisible(true);
        kdtEntrys_passportCityC_PromptBox.setEditable(true);
        kdtEntrys_passportCityC_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_passportCityC_PromptBox.setEditFormat("$number$");
        kdtEntrys_passportCityC_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_passportCityC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportCityC_PromptBox);
        this.kdtEntrys.getColumn("passportCityC").setEditor(kdtEntrys_passportCityC_CellEditor);
        ObjectValueRender kdtEntrys_passportCityC_OVR = new ObjectValueRender();
        kdtEntrys_passportCityC_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("passportCityC").setRenderer(kdtEntrys_passportCityC_OVR);
        KDTextField kdtEntrys_passportCityF_TextField = new KDTextField();
        kdtEntrys_passportCityF_TextField.setName("kdtEntrys_passportCityF_TextField");
        kdtEntrys_passportCityF_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_passportCityF_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportCityF_TextField);
        this.kdtEntrys.getColumn("passportCityF").setEditor(kdtEntrys_passportCityF_CellEditor);
        KDTextField kdtEntrys_oldPassport_TextField = new KDTextField();
        kdtEntrys_oldPassport_TextField.setName("kdtEntrys_oldPassport_TextField");
        kdtEntrys_oldPassport_TextField.setMaxLength(50);
        KDTDefaultCellEditor kdtEntrys_oldPassport_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oldPassport_TextField);
        this.kdtEntrys.getColumn("oldPassport").setEditor(kdtEntrys_oldPassport_CellEditor);
        KDTextField kdtEntrys_fatherName_TextField = new KDTextField();
        kdtEntrys_fatherName_TextField.setName("kdtEntrys_fatherName_TextField");
        kdtEntrys_fatherName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_fatherName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fatherName_TextField);
        this.kdtEntrys.getColumn("fatherName").setEditor(kdtEntrys_fatherName_CellEditor);
        KDTextField kdtEntrys_fatherNameAlphabet_TextField = new KDTextField();
        kdtEntrys_fatherNameAlphabet_TextField.setName("kdtEntrys_fatherNameAlphabet_TextField");
        kdtEntrys_fatherNameAlphabet_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_fatherNameAlphabet_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fatherNameAlphabet_TextField);
        this.kdtEntrys.getColumn("fatherNameAlphabet").setEditor(kdtEntrys_fatherNameAlphabet_CellEditor);
        KDTextField kdtEntrys_motherName_TextField = new KDTextField();
        kdtEntrys_motherName_TextField.setName("kdtEntrys_motherName_TextField");
        kdtEntrys_motherName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_motherName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_motherName_TextField);
        this.kdtEntrys.getColumn("motherName").setEditor(kdtEntrys_motherName_CellEditor);
        KDTextField kdtEntrys_motherNameAlphabet_TextField = new KDTextField();
        kdtEntrys_motherNameAlphabet_TextField.setName("kdtEntrys_motherNameAlphabet_TextField");
        kdtEntrys_motherNameAlphabet_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_motherNameAlphabet_CellEditor = new KDTDefaultCellEditor(kdtEntrys_motherNameAlphabet_TextField);
        this.kdtEntrys.getColumn("motherNameAlphabet").setEditor(kdtEntrys_motherNameAlphabet_CellEditor);
        KDComboBox kdtEntrys_MaritalStatus_ComboBox = new KDComboBox();
        kdtEntrys_MaritalStatus_ComboBox.setName("kdtEntrys_MaritalStatus_ComboBox");
        kdtEntrys_MaritalStatus_ComboBox.setVisible(true);
        kdtEntrys_MaritalStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.mayrStatEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_MaritalStatus_CellEditor = new KDTDefaultCellEditor(kdtEntrys_MaritalStatus_ComboBox);
        this.kdtEntrys.getColumn("MaritalStatus").setEditor(kdtEntrys_MaritalStatus_CellEditor);
        KDTextField kdtEntrys_coupleName_TextField = new KDTextField();
        kdtEntrys_coupleName_TextField.setName("kdtEntrys_coupleName_TextField");
        kdtEntrys_coupleName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coupleName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleName_TextField);
        this.kdtEntrys.getColumn("coupleName").setEditor(kdtEntrys_coupleName_CellEditor);
        KDTextField kdtEntrys_coupleNameAlphabet_TextField = new KDTextField();
        kdtEntrys_coupleNameAlphabet_TextField.setName("kdtEntrys_coupleNameAlphabet_TextField");
        kdtEntrys_coupleNameAlphabet_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coupleNameAlphabet_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleNameAlphabet_TextField);
        this.kdtEntrys.getColumn("coupleNameAlphabet").setEditor(kdtEntrys_coupleNameAlphabet_CellEditor);
        KDDatePicker kdtEntrys_coupleBirthDate_DatePicker = new KDDatePicker();
        kdtEntrys_coupleBirthDate_DatePicker.setName("kdtEntrys_coupleBirthDate_DatePicker");
        kdtEntrys_coupleBirthDate_DatePicker.setVisible(true);
        kdtEntrys_coupleBirthDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_coupleBirthDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleBirthDate_DatePicker);
        this.kdtEntrys.getColumn("coupleBirthDate").setEditor(kdtEntrys_coupleBirthDate_CellEditor);
        KDTextField kdtEntrys_coupleBirthPlace_TextField = new KDTextField();
        kdtEntrys_coupleBirthPlace_TextField.setName("kdtEntrys_coupleBirthPlace_TextField");
        kdtEntrys_coupleBirthPlace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coupleBirthPlace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleBirthPlace_TextField);
        this.kdtEntrys.getColumn("coupleBirthPlace").setEditor(kdtEntrys_coupleBirthPlace_CellEditor);
        final KDBizPromptBox kdtEntrys_coupleNational_PromptBox = new KDBizPromptBox();
        kdtEntrys_coupleNational_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");
        kdtEntrys_coupleNational_PromptBox.setVisible(true);
        kdtEntrys_coupleNational_PromptBox.setEditable(true);
        kdtEntrys_coupleNational_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_coupleNational_PromptBox.setEditFormat("$number$");
        kdtEntrys_coupleNational_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_coupleNational_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleNational_PromptBox);
        this.kdtEntrys.getColumn("coupleNational").setEditor(kdtEntrys_coupleNational_CellEditor);
        ObjectValueRender kdtEntrys_coupleNational_OVR = new ObjectValueRender();
        kdtEntrys_coupleNational_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("coupleNational").setRenderer(kdtEntrys_coupleNational_OVR);
        KDTextField kdtEntrys_coupleWorkPlace_TextField = new KDTextField();
        kdtEntrys_coupleWorkPlace_TextField.setName("kdtEntrys_coupleWorkPlace_TextField");
        kdtEntrys_coupleWorkPlace_TextField.setMaxLength(150);
        KDTDefaultCellEditor kdtEntrys_coupleWorkPlace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleWorkPlace_TextField);
        this.kdtEntrys.getColumn("coupleWorkPlace").setEditor(kdtEntrys_coupleWorkPlace_CellEditor);
        KDTextField kdtEntrys_contactway_TextField = new KDTextField();
        kdtEntrys_contactway_TextField.setName("kdtEntrys_contactway_TextField");
        kdtEntrys_contactway_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_contactway_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contactway_TextField);
        this.kdtEntrys.getColumn("contactway").setEditor(kdtEntrys_contactway_CellEditor);
        KDTextField kdtEntrys_residence_TextField = new KDTextField();
        kdtEntrys_residence_TextField.setName("kdtEntrys_residence_TextField");
        kdtEntrys_residence_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtEntrys_residence_CellEditor = new KDTDefaultCellEditor(kdtEntrys_residence_TextField);
        this.kdtEntrys.getColumn("residence").setEditor(kdtEntrys_residence_CellEditor);
        KDComboBox kdtEntrys_personState_ComboBox = new KDComboBox();
        kdtEntrys_personState_ComboBox.setName("kdtEntrys_personState_ComboBox");
        kdtEntrys_personState_ComboBox.setVisible(true);
        kdtEntrys_personState_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_personState_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personState_ComboBox);
        this.kdtEntrys.getColumn("personState").setEditor(kdtEntrys_personState_CellEditor);
        KDCheckBox kdtEntrys_isPush_CheckBox = new KDCheckBox();
        kdtEntrys_isPush_CheckBox.setName("kdtEntrys_isPush_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isPush_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isPush_CheckBox);
        this.kdtEntrys.getColumn("isPush").setEditor(kdtEntrys_isPush_CellEditor);
        KDTextField kdtEntrys_oldEtyId_TextField = new KDTextField();
        kdtEntrys_oldEtyId_TextField.setName("kdtEntrys_oldEtyId_TextField");
        kdtEntrys_oldEtyId_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_oldEtyId_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oldEtyId_TextField);
        this.kdtEntrys.getColumn("oldEtyId").setEditor(kdtEntrys_oldEtyId_CellEditor);
        KDFormattedTextField kdtEntrys_skillShare_TextField = new KDFormattedTextField();
        kdtEntrys_skillShare_TextField.setName("kdtEntrys_skillShare_TextField");
        kdtEntrys_skillShare_TextField.setVisible(true);
        kdtEntrys_skillShare_TextField.setEditable(true);
        kdtEntrys_skillShare_TextField.setHorizontalAlignment(2);
        kdtEntrys_skillShare_TextField.setDataType(1);
        	kdtEntrys_skillShare_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_skillShare_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_skillShare_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_skillShare_CellEditor = new KDTDefaultCellEditor(kdtEntrys_skillShare_TextField);
        this.kdtEntrys.getColumn("skillShare").setEditor(kdtEntrys_skillShare_CellEditor);
        KDCheckBox kdtEntrys_isWkExprice_CheckBox = new KDCheckBox();
        kdtEntrys_isWkExprice_CheckBox.setName("kdtEntrys_isWkExprice_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isWkExprice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isWkExprice_CheckBox);
        this.kdtEntrys.getColumn("isWkExprice").setEditor(kdtEntrys_isWkExprice_CellEditor);
        KDFormattedTextField kdtEntrys_wkExprice_TextField = new KDFormattedTextField();
        kdtEntrys_wkExprice_TextField.setName("kdtEntrys_wkExprice_TextField");
        kdtEntrys_wkExprice_TextField.setVisible(true);
        kdtEntrys_wkExprice_TextField.setEditable(true);
        kdtEntrys_wkExprice_TextField.setHorizontalAlignment(2);
        kdtEntrys_wkExprice_TextField.setDataType(1);
        	kdtEntrys_wkExprice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_wkExprice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_wkExprice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_wkExprice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wkExprice_TextField);
        this.kdtEntrys.getColumn("wkExprice").setEditor(kdtEntrys_wkExprice_CellEditor);
        // contbNum		
        this.contbNum.setBoundLabelText(resHelper.getString("contbNum.boundLabelText"));		
        this.contbNum.setBoundLabelLength(120);		
        this.contbNum.setBoundLabelUnderline(true);		
        this.contbNum.setVisible(false);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);		
        this.contauditDate.setEnabled(false);
        // contbillSate		
        this.contbillSate.setBoundLabelText(resHelper.getString("contbillSate.boundLabelText"));		
        this.contbillSate.setBoundLabelLength(120);		
        this.contbillSate.setBoundLabelUnderline(true);		
        this.contbillSate.setVisible(true);		
        this.contbillSate.setEnabled(false);
        // contnAuditime		
        this.contnAuditime.setBoundLabelText(resHelper.getString("contnAuditime.boundLabelText"));		
        this.contnAuditime.setBoundLabelLength(120);		
        this.contnAuditime.setBoundLabelUnderline(true);		
        this.contnAuditime.setVisible(true);		
        this.contnAuditime.setEnabled(false);
        // contpCauditime		
        this.contpCauditime.setBoundLabelText(resHelper.getString("contpCauditime.boundLabelText"));		
        this.contpCauditime.setBoundLabelLength(120);		
        this.contpCauditime.setBoundLabelUnderline(true);		
        this.contpCauditime.setVisible(true);		
        this.contpCauditime.setEnabled(false);
        // contpAudiTime		
        this.contpAudiTime.setBoundLabelText(resHelper.getString("contpAudiTime.boundLabelText"));		
        this.contpAudiTime.setBoundLabelLength(120);		
        this.contpAudiTime.setBoundLabelUnderline(true);		
        this.contpAudiTime.setVisible(true);		
        this.contpAudiTime.setEnabled(false);
        // contnAuditor		
        this.contnAuditor.setBoundLabelText(resHelper.getString("contnAuditor.boundLabelText"));		
        this.contnAuditor.setBoundLabelLength(135);		
        this.contnAuditor.setBoundLabelUnderline(true);		
        this.contnAuditor.setVisible(true);		
        this.contnAuditor.setEnabled(false);
        // contpAuditor		
        this.contpAuditor.setBoundLabelText(resHelper.getString("contpAuditor.boundLabelText"));		
        this.contpAuditor.setBoundLabelLength(135);		
        this.contpAuditor.setBoundLabelUnderline(true);		
        this.contpAuditor.setVisible(true);		
        this.contpAuditor.setEnabled(false);
        // contpCauditor		
        this.contpCauditor.setBoundLabelText(resHelper.getString("contpCauditor.boundLabelText"));		
        this.contpCauditor.setBoundLabelLength(120);		
        this.contpCauditor.setBoundLabelUnderline(true);		
        this.contpCauditor.setVisible(true);		
        this.contpCauditor.setEnabled(false);
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
        this.txtNumber.setEnabled(false);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setVisible(false);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // txtbNum		
        this.txtbNum.setHorizontalAlignment(2);		
        this.txtbNum.setMaxLength(100);		
        this.txtbNum.setRequired(false);		
        this.txtbNum.setVisible(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);		
        this.pkauditDate.setEnabled(false);
        // billSate		
        this.billSate.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billSate.setRequired(false);		
        this.billSate.setEnabled(false);
        // pknAuditime		
        this.pknAuditime.setRequired(false);		
        this.pknAuditime.setEnabled(false);
        // pkpCauditime		
        this.pkpCauditime.setRequired(false);		
        this.pkpCauditime.setEnabled(false);
        // pkpAudiTime		
        this.pkpAudiTime.setRequired(false);		
        this.pkpAudiTime.setEnabled(false);
        // prmtnAuditor		
        this.prmtnAuditor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtnAuditor.setEditable(true);		
        this.prmtnAuditor.setDisplayFormat("$number$");		
        this.prmtnAuditor.setEditFormat("$number$");		
        this.prmtnAuditor.setCommitFormat("$number$");		
        this.prmtnAuditor.setRequired(false);		
        this.prmtnAuditor.setEnabled(false);
        // prmtpAuditor		
        this.prmtpAuditor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtpAuditor.setEditable(true);		
        this.prmtpAuditor.setDisplayFormat("$number$");		
        this.prmtpAuditor.setEditFormat("$number$");		
        this.prmtpAuditor.setCommitFormat("$number$");		
        this.prmtpAuditor.setRequired(false);		
        this.prmtpAuditor.setEnabled(false);
        // prmtpCauditor		
        this.prmtpCauditor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtpCauditor.setEditable(true);		
        this.prmtpCauditor.setDisplayFormat("$number$");		
        this.prmtpCauditor.setEditFormat("$number$");		
        this.prmtpCauditor.setCommitFormat("$number$");		
        this.prmtpCauditor.setRequired(false);		
        this.prmtpCauditor.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));		
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtbNum,pkauditDate,billSate,pknAuditime,pkpCauditime,pkpAudiTime,prmtnAuditor,prmtpAuditor,prmtpCauditor,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 557));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 557));
        contCreator.setBounds(new Rectangle(4, 484, 223, 19));
        this.add(contCreator, new KDLayout.Constraints(4, 484, 223, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(260, 484, 223, 19));
        this.add(contCreateTime, new KDLayout.Constraints(260, 484, 223, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(341, 514, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(341, 514, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(672, 514, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(672, 514, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(4, 12, 231, 19));
        this.add(contNumber, new KDLayout.Constraints(4, 12, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(51, 514, 231, 19));
        this.add(contBizDate, new KDLayout.Constraints(51, 514, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(516, 64, 231, 19));
        this.add(contDescription, new KDLayout.Constraints(516, 64, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(516, 484, 223, 19));
        this.add(contAuditor, new KDLayout.Constraints(516, 484, 223, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(4, 91, 1001, 380));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.certificates.FiiEcEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(4, 91, 1001, 380, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("genDers",new Integer(1));
vo.put("passportAgence","10");
vo.put("MaritalStatus","0");
vo.put("personState","10");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contbNum.setBounds(new Rectangle(774, 14, 231, 19));
        this.add(contbNum, new KDLayout.Constraints(774, 14, 231, 19, 0));
        contauditDate.setBounds(new Rectangle(775, 484, 223, 19));
        this.add(contauditDate, new KDLayout.Constraints(775, 484, 223, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillSate.setBounds(new Rectangle(260, 12, 231, 19));
        this.add(contbillSate, new KDLayout.Constraints(260, 12, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnAuditime.setBounds(new Rectangle(260, 64, 231, 19));
        this.add(contnAuditime, new KDLayout.Constraints(260, 64, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpCauditime.setBounds(new Rectangle(516, 38, 231, 19));
        this.add(contpCauditime, new KDLayout.Constraints(516, 38, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpAudiTime.setBounds(new Rectangle(260, 38, 231, 19));
        this.add(contpAudiTime, new KDLayout.Constraints(260, 38, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnAuditor.setBounds(new Rectangle(4, 64, 231, 19));
        this.add(contnAuditor, new KDLayout.Constraints(4, 64, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpAuditor.setBounds(new Rectangle(4, 38, 231, 19));
        this.add(contpAuditor, new KDLayout.Constraints(4, 38, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpCauditor.setBounds(new Rectangle(516, 12, 231, 19));
        this.add(contpCauditor, new KDLayout.Constraints(516, 12, 231, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contbNum
        contbNum.setBoundEditor(txtbNum);
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);
        //contbillSate
        contbillSate.setBoundEditor(billSate);
        //contnAuditime
        contnAuditime.setBoundEditor(pknAuditime);
        //contpCauditime
        contpCauditime.setBoundEditor(pkpCauditime);
        //contpAudiTime
        contpAudiTime.setBoundEditor(pkpAudiTime);
        //contnAuditor
        contnAuditor.setBoundEditor(prmtnAuditor);
        //contpAuditor
        contpAuditor.setBoundEditor(prmtpAuditor);
        //contpCauditor
        contpCauditor.setBoundEditor(prmtpCauditor);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.certificates.FiiEcEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.numBer", String.class, this.kdtEntrys, "numBer.text");
		dataBinder.registerBinding("entrys.name", String.class, this.kdtEntrys, "name.text");
		dataBinder.registerBinding("entrys.IdNum", String.class, this.kdtEntrys, "IdNum.text");
		dataBinder.registerBinding("entrys.passportNo", String.class, this.kdtEntrys, "passportNo.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.authType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "authType.text");
		dataBinder.registerBinding("entrys.partner", java.lang.Object.class, this.kdtEntrys, "partner.text");
		dataBinder.registerBinding("entrys.taskProj", java.lang.Object.class, this.kdtEntrys, "taskProj.text");
		dataBinder.registerBinding("entrys.pmtProj", java.lang.Object.class, this.kdtEntrys, "pmtProj.text");
		dataBinder.registerBinding("entrys.pmtProfC", java.lang.Object.class, this.kdtEntrys, "pmtProfC.text");
		dataBinder.registerBinding("entrys.actprofF", String.class, this.kdtEntrys, "actprofF.text");
		dataBinder.registerBinding("entrys.signNum", String.class, this.kdtEntrys, "signNum.text");
		dataBinder.registerBinding("entrys.genDers", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "genDers.text");
		dataBinder.registerBinding("entrys.country", java.lang.Object.class, this.kdtEntrys, "country.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.sourceEntryID", String.class, this.kdtEntrys, "sourceEntryID.text");
		dataBinder.registerBinding("entrys.birthdate", java.util.Date.class, this.kdtEntrys, "birthdate.text");
		dataBinder.registerBinding("entrys.workSuffer", String.class, this.kdtEntrys, "workSuffer.text");
		dataBinder.registerBinding("entrys.pmtProfFr", String.class, this.kdtEntrys, "pmtProfFr.text");
		dataBinder.registerBinding("entrys.copies", int.class, this.kdtEntrys, "copies.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.birthPlaceCn", String.class, this.kdtEntrys, "birthPlaceCn.text");
		dataBinder.registerBinding("entrys.birthPlaceFr", String.class, this.kdtEntrys, "birthPlaceFr.text");
		dataBinder.registerBinding("entrys.passportIssueDate", java.util.Date.class, this.kdtEntrys, "passportIssueDate.text");
		dataBinder.registerBinding("entrys.passportExpireDate", java.util.Date.class, this.kdtEntrys, "passportExpireDate.text");
		dataBinder.registerBinding("entrys.passportAgence", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "passportAgence.text");
		dataBinder.registerBinding("entrys.passportCityF", String.class, this.kdtEntrys, "passportCityF.text");
		dataBinder.registerBinding("entrys.oldPassport", String.class, this.kdtEntrys, "oldPassport.text");
		dataBinder.registerBinding("entrys.fatherName", String.class, this.kdtEntrys, "fatherName.text");
		dataBinder.registerBinding("entrys.fatherNameAlphabet", String.class, this.kdtEntrys, "fatherNameAlphabet.text");
		dataBinder.registerBinding("entrys.motherName", String.class, this.kdtEntrys, "motherName.text");
		dataBinder.registerBinding("entrys.motherNameAlphabet", String.class, this.kdtEntrys, "motherNameAlphabet.text");
		dataBinder.registerBinding("entrys.MaritalStatus", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "MaritalStatus.text");
		dataBinder.registerBinding("entrys.coupleName", String.class, this.kdtEntrys, "coupleName.text");
		dataBinder.registerBinding("entrys.coupleNameAlphabet", String.class, this.kdtEntrys, "coupleNameAlphabet.text");
		dataBinder.registerBinding("entrys.coupleBirthDate", java.util.Date.class, this.kdtEntrys, "coupleBirthDate.text");
		dataBinder.registerBinding("entrys.coupleBirthPlace", String.class, this.kdtEntrys, "coupleBirthPlace.text");
		dataBinder.registerBinding("entrys.coupleNational", java.lang.Object.class, this.kdtEntrys, "coupleNational.text");
		dataBinder.registerBinding("entrys.coupleWorkPlace", String.class, this.kdtEntrys, "coupleWorkPlace.text");
		dataBinder.registerBinding("entrys.contactway", String.class, this.kdtEntrys, "contactway.text");
		dataBinder.registerBinding("entrys.residence", String.class, this.kdtEntrys, "residence.text");
		dataBinder.registerBinding("entrys.passportCityC", java.lang.Object.class, this.kdtEntrys, "passportCityC.text");
		dataBinder.registerBinding("entrys.personState", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "personState.text");
		dataBinder.registerBinding("entrys.isPush", boolean.class, this.kdtEntrys, "isPush.text");
		dataBinder.registerBinding("entrys.fiiDate", java.util.Date.class, this.kdtEntrys, "fiiDate.text");
		dataBinder.registerBinding("entrys.oldEtyId", String.class, this.kdtEntrys, "oldEtyId.text");
		dataBinder.registerBinding("entrys.skillShare", java.math.BigDecimal.class, this.kdtEntrys, "skillShare.text");
		dataBinder.registerBinding("entrys.isWkExprice", boolean.class, this.kdtEntrys, "isWkExprice.text");
		dataBinder.registerBinding("entrys.wkExprice", java.math.BigDecimal.class, this.kdtEntrys, "wkExprice.text");
		dataBinder.registerBinding("entrys.wkPmtGet", boolean.class, this.kdtEntrys, "wkPmtGet.text");
		dataBinder.registerBinding("entrys.wpCopies", int.class, this.kdtEntrys, "wpCopies.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("bNum", String.class, this.txtbNum, "text");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("billSate", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSate, "selectedItem");
		dataBinder.registerBinding("nAuditime", java.util.Date.class, this.pknAuditime, "value");
		dataBinder.registerBinding("pCauditime", java.util.Date.class, this.pkpCauditime, "value");
		dataBinder.registerBinding("pAudiTime", java.util.Date.class, this.pkpAudiTime, "value");
		dataBinder.registerBinding("nAuditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtnAuditor, "data");
		dataBinder.registerBinding("pAuditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtpAuditor, "data");
		dataBinder.registerBinding("pCauditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtpCauditor, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.certificates.app.FiiEcEditUIHandler";
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
        this.kDDateLastUpdateTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.certificates.FiiEcInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.numBer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IdNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.authType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.partner", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.taskProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProfC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actprofF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.signNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.genDers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.country", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sourceEntryID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workSuffer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProfFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.copies", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceCn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportIssueDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportExpireDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportAgence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCityF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oldPassport", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.MaritalStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleBirthDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleBirthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNational", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleWorkPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contactway", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.residence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCityC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isPush", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fiiDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oldEtyId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.skillShare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isWkExprice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wkExprice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wkPmtGet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wpCopies", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nAuditime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pCauditime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pAudiTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nAuditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pAuditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pCauditor", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("pmtProfC".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"pmtProfFr").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"pmtProfC").getValue(),"nameFR")));

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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
			sic.add(new SelectorItemInfo("entrys.name"));
        	sic.add(new SelectorItemInfo("entrys.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.numBer"));
    	sic.add(new SelectorItemInfo("entrys.IdNum"));
    	sic.add(new SelectorItemInfo("entrys.passportNo"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.authType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.partner.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.partner.id"));
			sic.add(new SelectorItemInfo("entrys.partner.name"));
        	sic.add(new SelectorItemInfo("entrys.partner.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.taskProj.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.taskProj.id"));
			sic.add(new SelectorItemInfo("entrys.taskProj.name"));
        	sic.add(new SelectorItemInfo("entrys.taskProj.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.pmtProj.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.pmtProj.id"));
			sic.add(new SelectorItemInfo("entrys.pmtProj.name"));
        	sic.add(new SelectorItemInfo("entrys.pmtProj.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.pmtProfC.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.pmtProfC.id"));
			sic.add(new SelectorItemInfo("entrys.pmtProfC.name"));
        	sic.add(new SelectorItemInfo("entrys.pmtProfC.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.actprofF"));
    	sic.add(new SelectorItemInfo("entrys.signNum"));
    	sic.add(new SelectorItemInfo("entrys.genDers"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.country.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.country.id"));
			sic.add(new SelectorItemInfo("entrys.country.name"));
        	sic.add(new SelectorItemInfo("entrys.country.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.personID"));
    	sic.add(new SelectorItemInfo("entrys.sourceEntryID"));
    	sic.add(new SelectorItemInfo("entrys.birthdate"));
    	sic.add(new SelectorItemInfo("entrys.workSuffer"));
    	sic.add(new SelectorItemInfo("entrys.pmtProfFr"));
    	sic.add(new SelectorItemInfo("entrys.copies"));
    	sic.add(new SelectorItemInfo("entrys.firstName"));
    	sic.add(new SelectorItemInfo("entrys.lastName"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceCn"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceFr"));
    	sic.add(new SelectorItemInfo("entrys.passportIssueDate"));
    	sic.add(new SelectorItemInfo("entrys.passportExpireDate"));
    	sic.add(new SelectorItemInfo("entrys.passportAgence"));
    	sic.add(new SelectorItemInfo("entrys.passportCityF"));
    	sic.add(new SelectorItemInfo("entrys.oldPassport"));
    	sic.add(new SelectorItemInfo("entrys.fatherName"));
    	sic.add(new SelectorItemInfo("entrys.fatherNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.motherName"));
    	sic.add(new SelectorItemInfo("entrys.motherNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.MaritalStatus"));
    	sic.add(new SelectorItemInfo("entrys.coupleName"));
    	sic.add(new SelectorItemInfo("entrys.coupleNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.coupleBirthDate"));
    	sic.add(new SelectorItemInfo("entrys.coupleBirthPlace"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.coupleNational.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.coupleNational.id"));
			sic.add(new SelectorItemInfo("entrys.coupleNational.name"));
        	sic.add(new SelectorItemInfo("entrys.coupleNational.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.coupleWorkPlace"));
    	sic.add(new SelectorItemInfo("entrys.contactway"));
    	sic.add(new SelectorItemInfo("entrys.residence"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.passportCityC.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.passportCityC.id"));
			sic.add(new SelectorItemInfo("entrys.passportCityC.name"));
        	sic.add(new SelectorItemInfo("entrys.passportCityC.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.personState"));
    	sic.add(new SelectorItemInfo("entrys.isPush"));
    	sic.add(new SelectorItemInfo("entrys.fiiDate"));
    	sic.add(new SelectorItemInfo("entrys.oldEtyId"));
    	sic.add(new SelectorItemInfo("entrys.skillShare"));
    	sic.add(new SelectorItemInfo("entrys.isWkExprice"));
    	sic.add(new SelectorItemInfo("entrys.wkExprice"));
    	sic.add(new SelectorItemInfo("entrys.wkPmtGet"));
    	sic.add(new SelectorItemInfo("entrys.wpCopies"));
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
        sic.add(new SelectorItemInfo("bNum"));
        sic.add(new SelectorItemInfo("auditDate"));
        sic.add(new SelectorItemInfo("billSate"));
        sic.add(new SelectorItemInfo("nAuditime"));
        sic.add(new SelectorItemInfo("pCauditime"));
        sic.add(new SelectorItemInfo("pAudiTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("nAuditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("nAuditor.id"));
        	sic.add(new SelectorItemInfo("nAuditor.number"));
        	sic.add(new SelectorItemInfo("nAuditor.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pAuditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pAuditor.id"));
        	sic.add(new SelectorItemInfo("pAuditor.number"));
        	sic.add(new SelectorItemInfo("pAuditor.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pCauditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pCauditor.id"));
        	sic.add(new SelectorItemInfo("pCauditor.number"));
        	sic.add(new SelectorItemInfo("pCauditor.name"));
		}
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
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
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
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }
	public RequestContext prepareActionUnAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAudit() {
    	return false;
    }

    /**
     * output ActionAudit class
     */     
    protected class ActionAudit extends ItemAction {     
    
        public ActionAudit()
        {
            this(null);
        }

        public ActionAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFiiEcEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUnAudit class
     */     
    protected class ActionUnAudit extends ItemAction {     
    
        public ActionUnAudit()
        {
            this(null);
        }

        public ActionUnAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionUnAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFiiEcEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.certificates.client", "FiiEcEditUI");
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
        return com.kingdee.eas.zjlw.certificates.client.FiiEcEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.FiiEcFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.FiiEcInfo objectValue = new com.kingdee.eas.zjlw.certificates.FiiEcInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/certificates/FiiEc";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.certificates.app.FiiEcQuery");
	}
    

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billSate","10");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}