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
public abstract class AbstractAntiECEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAntiECEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlSubtime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contISubmitor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
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
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pklSubtime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtISubmitor;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnLogout;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnaAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRollBack;
    protected com.kingdee.eas.zjlw.certificates.AntiECInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionLogout actionLogout = null;
    protected ActionRollBack actionRollBack = null;
    /**
     * output class constructor
     */
    public AbstractAntiECEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAntiECEditUI.class.getName());
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
        //actionLogout
        this.actionLogout = new ActionLogout(this);
        getActionManager().registerAction("actionLogout", actionLogout);
         this.actionLogout.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionRollBack
        this.actionRollBack = new ActionRollBack(this);
        getActionManager().registerAction("actionRollBack", actionRollBack);
         this.actionRollBack.addService(new com.kingdee.eas.framework.client.service.PermissionService());
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
        this.contlSubtime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contISubmitor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.pklSubtime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtISubmitor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnLogout = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnaAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRollBack = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.contlSubtime.setName("contlSubtime");
        this.contISubmitor.setName("contISubmitor");
        this.kDLabelContainer1.setName("kDLabelContainer1");
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
        this.pklSubtime.setName("pklSubtime");
        this.prmtISubmitor.setName("prmtISubmitor");
        this.btnLogout.setName("btnLogout");
        this.btnAudit.setName("btnAudit");
        this.btnUnaAudit.setName("btnUnaAudit");
        this.btnRollBack.setName("btnRollBack");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol21\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol22\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol33\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol34\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol35\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol37\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol42\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol45\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol46\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol47\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol48\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol49\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol50\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol51\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol52\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol53\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol54\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol55\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol56\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol57\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol58\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol59\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol60\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol61\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol62\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"sex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"birDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"birAddrCn\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"birthPlaceFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"natioNal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"passpNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"passpIssDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"passpExDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"passportAgence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"passportCityC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"passportCityF\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"workExp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"quProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"pmtProfFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"fName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"alphFName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"mName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"alphMName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"mayrStat\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"assignDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"sendLaBuDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"laborSignNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"antiSgTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"antiEndTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"ownerSignDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"docUpDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"appAffiliated\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"docAffiliated\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"pmtProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"taskProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"partner\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"signNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"isLogout\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"logoutDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"logoutReson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"isCancel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cancelDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"cancelReson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"idNum\" t:width=\"145\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"actproff\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"sourceEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"authType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"copies\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"coupleName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol49\" /><t:Column t:key=\"coupleNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol50\" /><t:Column t:key=\"coupleBirthDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"coupleBirthPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol52\" /><t:Column t:key=\"coupleNational\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol53\" /><t:Column t:key=\"coupleWorkPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol54\" /><t:Column t:key=\"contactway\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol55\" /><t:Column t:key=\"residence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol56\" /><t:Column t:key=\"oldPassport\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol57\" /><t:Column t:key=\"personState\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol58\" /><t:Column t:key=\"isPush\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol59\" /><t:Column t:key=\"oldEtyId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol60\" /><t:Column t:key=\"leaveTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol61\" /><t:Column t:key=\"immiTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{birDate}</t:Cell><t:Cell>$Resource{birAddrCn}</t:Cell><t:Cell>$Resource{birthPlaceFr}</t:Cell><t:Cell>$Resource{natioNal}</t:Cell><t:Cell>$Resource{passpNo}</t:Cell><t:Cell>$Resource{passpIssDate}</t:Cell><t:Cell>$Resource{passpExDate}</t:Cell><t:Cell>$Resource{passportAgence}</t:Cell><t:Cell>$Resource{passportCityC}</t:Cell><t:Cell>$Resource{passportCityF}</t:Cell><t:Cell>$Resource{workExp}</t:Cell><t:Cell>$Resource{quProf}</t:Cell><t:Cell>$Resource{pmtProfFr}</t:Cell><t:Cell>$Resource{fName}</t:Cell><t:Cell>$Resource{alphFName}</t:Cell><t:Cell>$Resource{mName}</t:Cell><t:Cell>$Resource{alphMName}</t:Cell><t:Cell>$Resource{mayrStat}</t:Cell><t:Cell>$Resource{assignDate}</t:Cell><t:Cell>$Resource{sendLaBuDate}</t:Cell><t:Cell>$Resource{laborSignNo}</t:Cell><t:Cell>$Resource{antiSgTime}</t:Cell><t:Cell>$Resource{antiEndTime}</t:Cell><t:Cell>$Resource{ownerSignDate}</t:Cell><t:Cell>$Resource{docUpDate}</t:Cell><t:Cell>$Resource{appAffiliated}</t:Cell><t:Cell>$Resource{docAffiliated}</t:Cell><t:Cell>$Resource{pmtProj}</t:Cell><t:Cell>$Resource{taskProj}</t:Cell><t:Cell>$Resource{partner}</t:Cell><t:Cell>$Resource{signNum}</t:Cell><t:Cell>$Resource{isLogout}</t:Cell><t:Cell>$Resource{logoutDate}</t:Cell><t:Cell>$Resource{logoutReson}</t:Cell><t:Cell>$Resource{isCancel}</t:Cell><t:Cell>$Resource{cancelDate}</t:Cell><t:Cell>$Resource{cancelReson}</t:Cell><t:Cell>$Resource{idNum}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{actproff}</t:Cell><t:Cell>$Resource{sourceEntryID}</t:Cell><t:Cell>$Resource{personID}</t:Cell><t:Cell>$Resource{authType}</t:Cell><t:Cell>$Resource{copies}</t:Cell><t:Cell>$Resource{coupleName}</t:Cell><t:Cell>$Resource{coupleNameAlphabet}</t:Cell><t:Cell>$Resource{coupleBirthDate}</t:Cell><t:Cell>$Resource{coupleBirthPlace}</t:Cell><t:Cell>$Resource{coupleNational}</t:Cell><t:Cell>$Resource{coupleWorkPlace}</t:Cell><t:Cell>$Resource{contactway}</t:Cell><t:Cell>$Resource{residence}</t:Cell><t:Cell>$Resource{oldPassport}</t:Cell><t:Cell>$Resource{personState}</t:Cell><t:Cell>$Resource{isPush}</t:Cell><t:Cell>$Resource{oldEtyId}</t:Cell><t:Cell>$Resource{leaveTime}</t:Cell><t:Cell>$Resource{immiTime}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        this.kdtEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","name","lastName","firstName","sex","birDate","birAddrCn","birthPlaceFr","natioNal","passpNo","passpIssDate","passpExDate","passportAgence","passportCityC","passportCityF","workExp","quProf","pmtProfFr","fName","alphFName","mName","alphMName","mayrStat","assignDate","sendLaBuDate","laborSignNo","antiSgTime","antiEndTime","ownerSignDate","docUpDate","appAffiliated","docAffiliated","pmtProj","taskProj","partner","signNum","isLogout","logoutDate","logoutReson","isCancel","cancelDate","cancelReson","idNum","remark","actproff","sourceEntryID","personID","authType","copies","coupleName","coupleNameAlphabet","coupleBirthDate","coupleBirthPlace","coupleNational","coupleWorkPlace","contactway","residence","oldPassport","personState","isPush","oldEtyId","leaveTime","immiTime"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_name_TextField = new KDTextField();
        kdtEntrys_name_TextField.setName("kdtEntrys_name_TextField");
        kdtEntrys_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_name_CellEditor = new KDTDefaultCellEditor(kdtEntrys_name_TextField);
        this.kdtEntrys.getColumn("name").setEditor(kdtEntrys_name_CellEditor);
        KDTextField kdtEntrys_lastName_TextField = new KDTextField();
        kdtEntrys_lastName_TextField.setName("kdtEntrys_lastName_TextField");
        kdtEntrys_lastName_TextField.setMaxLength(50);
        KDTDefaultCellEditor kdtEntrys_lastName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lastName_TextField);
        this.kdtEntrys.getColumn("lastName").setEditor(kdtEntrys_lastName_CellEditor);
        KDTextField kdtEntrys_firstName_TextField = new KDTextField();
        kdtEntrys_firstName_TextField.setName("kdtEntrys_firstName_TextField");
        kdtEntrys_firstName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_firstName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_firstName_TextField);
        this.kdtEntrys.getColumn("firstName").setEditor(kdtEntrys_firstName_CellEditor);
        KDComboBox kdtEntrys_sex_ComboBox = new KDComboBox();
        kdtEntrys_sex_ComboBox.setName("kdtEntrys_sex_ComboBox");
        kdtEntrys_sex_ComboBox.setVisible(true);
        kdtEntrys_sex_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());
        KDTDefaultCellEditor kdtEntrys_sex_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sex_ComboBox);
        this.kdtEntrys.getColumn("sex").setEditor(kdtEntrys_sex_CellEditor);
        KDDatePicker kdtEntrys_birDate_DatePicker = new KDDatePicker();
        kdtEntrys_birDate_DatePicker.setName("kdtEntrys_birDate_DatePicker");
        kdtEntrys_birDate_DatePicker.setVisible(true);
        kdtEntrys_birDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_birDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birDate_DatePicker);
        this.kdtEntrys.getColumn("birDate").setEditor(kdtEntrys_birDate_CellEditor);
        KDTextField kdtEntrys_birAddrCn_TextField = new KDTextField();
        kdtEntrys_birAddrCn_TextField.setName("kdtEntrys_birAddrCn_TextField");
        kdtEntrys_birAddrCn_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_birAddrCn_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birAddrCn_TextField);
        this.kdtEntrys.getColumn("birAddrCn").setEditor(kdtEntrys_birAddrCn_CellEditor);
        KDTextField kdtEntrys_birthPlaceFr_TextField = new KDTextField();
        kdtEntrys_birthPlaceFr_TextField.setName("kdtEntrys_birthPlaceFr_TextField");
        kdtEntrys_birthPlaceFr_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_birthPlaceFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlaceFr_TextField);
        this.kdtEntrys.getColumn("birthPlaceFr").setEditor(kdtEntrys_birthPlaceFr_CellEditor);
        final KDBizPromptBox kdtEntrys_natioNal_PromptBox = new KDBizPromptBox();
        kdtEntrys_natioNal_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");
        kdtEntrys_natioNal_PromptBox.setVisible(true);
        kdtEntrys_natioNal_PromptBox.setEditable(true);
        kdtEntrys_natioNal_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_natioNal_PromptBox.setEditFormat("$number$");
        kdtEntrys_natioNal_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_natioNal_CellEditor = new KDTDefaultCellEditor(kdtEntrys_natioNal_PromptBox);
        this.kdtEntrys.getColumn("natioNal").setEditor(kdtEntrys_natioNal_CellEditor);
        ObjectValueRender kdtEntrys_natioNal_OVR = new ObjectValueRender();
        kdtEntrys_natioNal_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("natioNal").setRenderer(kdtEntrys_natioNal_OVR);
        KDTextField kdtEntrys_passpNo_TextField = new KDTextField();
        kdtEntrys_passpNo_TextField.setName("kdtEntrys_passpNo_TextField");
        kdtEntrys_passpNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_passpNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passpNo_TextField);
        this.kdtEntrys.getColumn("passpNo").setEditor(kdtEntrys_passpNo_CellEditor);
        KDDatePicker kdtEntrys_passpIssDate_DatePicker = new KDDatePicker();
        kdtEntrys_passpIssDate_DatePicker.setName("kdtEntrys_passpIssDate_DatePicker");
        kdtEntrys_passpIssDate_DatePicker.setVisible(true);
        kdtEntrys_passpIssDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passpIssDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passpIssDate_DatePicker);
        this.kdtEntrys.getColumn("passpIssDate").setEditor(kdtEntrys_passpIssDate_CellEditor);
        KDDatePicker kdtEntrys_passpExDate_DatePicker = new KDDatePicker();
        kdtEntrys_passpExDate_DatePicker.setName("kdtEntrys_passpExDate_DatePicker");
        kdtEntrys_passpExDate_DatePicker.setVisible(true);
        kdtEntrys_passpExDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passpExDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passpExDate_DatePicker);
        this.kdtEntrys.getColumn("passpExDate").setEditor(kdtEntrys_passpExDate_CellEditor);
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
        kdtEntrys_passportCityF_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_passportCityF_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportCityF_TextField);
        this.kdtEntrys.getColumn("passportCityF").setEditor(kdtEntrys_passportCityF_CellEditor);
        KDFormattedTextField kdtEntrys_workExp_TextField = new KDFormattedTextField();
        kdtEntrys_workExp_TextField.setName("kdtEntrys_workExp_TextField");
        kdtEntrys_workExp_TextField.setVisible(true);
        kdtEntrys_workExp_TextField.setEditable(true);
        kdtEntrys_workExp_TextField.setHorizontalAlignment(2);
        kdtEntrys_workExp_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_workExp_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workExp_TextField);
        this.kdtEntrys.getColumn("workExp").setEditor(kdtEntrys_workExp_CellEditor);
        final KDBizPromptBox kdtEntrys_quProf_PromptBox = new KDBizPromptBox();
        kdtEntrys_quProf_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");
        kdtEntrys_quProf_PromptBox.setVisible(true);
        kdtEntrys_quProf_PromptBox.setEditable(true);
        kdtEntrys_quProf_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_quProf_PromptBox.setEditFormat("$number$");
        kdtEntrys_quProf_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_quProf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_quProf_PromptBox);
        this.kdtEntrys.getColumn("quProf").setEditor(kdtEntrys_quProf_CellEditor);
        ObjectValueRender kdtEntrys_quProf_OVR = new ObjectValueRender();
        kdtEntrys_quProf_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("quProf").setRenderer(kdtEntrys_quProf_OVR);
        KDTextField kdtEntrys_pmtProfFr_TextField = new KDTextField();
        kdtEntrys_pmtProfFr_TextField.setName("kdtEntrys_pmtProfFr_TextField");
        kdtEntrys_pmtProfFr_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_pmtProfFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProfFr_TextField);
        this.kdtEntrys.getColumn("pmtProfFr").setEditor(kdtEntrys_pmtProfFr_CellEditor);
        KDTextField kdtEntrys_fName_TextField = new KDTextField();
        kdtEntrys_fName_TextField.setName("kdtEntrys_fName_TextField");
        kdtEntrys_fName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_fName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fName_TextField);
        this.kdtEntrys.getColumn("fName").setEditor(kdtEntrys_fName_CellEditor);
        KDTextField kdtEntrys_alphFName_TextField = new KDTextField();
        kdtEntrys_alphFName_TextField.setName("kdtEntrys_alphFName_TextField");
        kdtEntrys_alphFName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_alphFName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_alphFName_TextField);
        this.kdtEntrys.getColumn("alphFName").setEditor(kdtEntrys_alphFName_CellEditor);
        KDTextField kdtEntrys_mName_TextField = new KDTextField();
        kdtEntrys_mName_TextField.setName("kdtEntrys_mName_TextField");
        kdtEntrys_mName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_mName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_mName_TextField);
        this.kdtEntrys.getColumn("mName").setEditor(kdtEntrys_mName_CellEditor);
        KDTextField kdtEntrys_alphMName_TextField = new KDTextField();
        kdtEntrys_alphMName_TextField.setName("kdtEntrys_alphMName_TextField");
        kdtEntrys_alphMName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_alphMName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_alphMName_TextField);
        this.kdtEntrys.getColumn("alphMName").setEditor(kdtEntrys_alphMName_CellEditor);
        KDComboBox kdtEntrys_mayrStat_ComboBox = new KDComboBox();
        kdtEntrys_mayrStat_ComboBox.setName("kdtEntrys_mayrStat_ComboBox");
        kdtEntrys_mayrStat_ComboBox.setVisible(true);
        kdtEntrys_mayrStat_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.mayrStatEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_mayrStat_CellEditor = new KDTDefaultCellEditor(kdtEntrys_mayrStat_ComboBox);
        this.kdtEntrys.getColumn("mayrStat").setEditor(kdtEntrys_mayrStat_CellEditor);
        KDDatePicker kdtEntrys_assignDate_DatePicker = new KDDatePicker();
        kdtEntrys_assignDate_DatePicker.setName("kdtEntrys_assignDate_DatePicker");
        kdtEntrys_assignDate_DatePicker.setVisible(true);
        kdtEntrys_assignDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_assignDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_assignDate_DatePicker);
        this.kdtEntrys.getColumn("assignDate").setEditor(kdtEntrys_assignDate_CellEditor);
        KDDatePicker kdtEntrys_sendLaBuDate_DatePicker = new KDDatePicker();
        kdtEntrys_sendLaBuDate_DatePicker.setName("kdtEntrys_sendLaBuDate_DatePicker");
        kdtEntrys_sendLaBuDate_DatePicker.setVisible(true);
        kdtEntrys_sendLaBuDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_sendLaBuDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sendLaBuDate_DatePicker);
        this.kdtEntrys.getColumn("sendLaBuDate").setEditor(kdtEntrys_sendLaBuDate_CellEditor);
        KDTextField kdtEntrys_laborSignNo_TextField = new KDTextField();
        kdtEntrys_laborSignNo_TextField.setName("kdtEntrys_laborSignNo_TextField");
        kdtEntrys_laborSignNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_laborSignNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_laborSignNo_TextField);
        this.kdtEntrys.getColumn("laborSignNo").setEditor(kdtEntrys_laborSignNo_CellEditor);
        KDDatePicker kdtEntrys_antiSgTime_DatePicker = new KDDatePicker();
        kdtEntrys_antiSgTime_DatePicker.setName("kdtEntrys_antiSgTime_DatePicker");
        kdtEntrys_antiSgTime_DatePicker.setVisible(true);
        kdtEntrys_antiSgTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_antiSgTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_antiSgTime_DatePicker);
        this.kdtEntrys.getColumn("antiSgTime").setEditor(kdtEntrys_antiSgTime_CellEditor);
        KDDatePicker kdtEntrys_antiEndTime_DatePicker = new KDDatePicker();
        kdtEntrys_antiEndTime_DatePicker.setName("kdtEntrys_antiEndTime_DatePicker");
        kdtEntrys_antiEndTime_DatePicker.setVisible(true);
        kdtEntrys_antiEndTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_antiEndTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_antiEndTime_DatePicker);
        this.kdtEntrys.getColumn("antiEndTime").setEditor(kdtEntrys_antiEndTime_CellEditor);
        KDDatePicker kdtEntrys_ownerSignDate_DatePicker = new KDDatePicker();
        kdtEntrys_ownerSignDate_DatePicker.setName("kdtEntrys_ownerSignDate_DatePicker");
        kdtEntrys_ownerSignDate_DatePicker.setVisible(true);
        kdtEntrys_ownerSignDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_ownerSignDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ownerSignDate_DatePicker);
        this.kdtEntrys.getColumn("ownerSignDate").setEditor(kdtEntrys_ownerSignDate_CellEditor);
        KDDatePicker kdtEntrys_docUpDate_DatePicker = new KDDatePicker();
        kdtEntrys_docUpDate_DatePicker.setName("kdtEntrys_docUpDate_DatePicker");
        kdtEntrys_docUpDate_DatePicker.setVisible(true);
        kdtEntrys_docUpDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_docUpDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docUpDate_DatePicker);
        this.kdtEntrys.getColumn("docUpDate").setEditor(kdtEntrys_docUpDate_CellEditor);
        KDCheckBox kdtEntrys_appAffiliated_CheckBox = new KDCheckBox();
        kdtEntrys_appAffiliated_CheckBox.setName("kdtEntrys_appAffiliated_CheckBox");
        KDTDefaultCellEditor kdtEntrys_appAffiliated_CellEditor = new KDTDefaultCellEditor(kdtEntrys_appAffiliated_CheckBox);
        this.kdtEntrys.getColumn("appAffiliated").setEditor(kdtEntrys_appAffiliated_CellEditor);
        KDCheckBox kdtEntrys_docAffiliated_CheckBox = new KDCheckBox();
        kdtEntrys_docAffiliated_CheckBox.setName("kdtEntrys_docAffiliated_CheckBox");
        KDTDefaultCellEditor kdtEntrys_docAffiliated_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docAffiliated_CheckBox);
        this.kdtEntrys.getColumn("docAffiliated").setEditor(kdtEntrys_docAffiliated_CellEditor);
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
        KDCheckBox kdtEntrys_isLogout_CheckBox = new KDCheckBox();
        kdtEntrys_isLogout_CheckBox.setName("kdtEntrys_isLogout_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isLogout_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isLogout_CheckBox);
        this.kdtEntrys.getColumn("isLogout").setEditor(kdtEntrys_isLogout_CellEditor);
        KDDatePicker kdtEntrys_logoutDate_DatePicker = new KDDatePicker();
        kdtEntrys_logoutDate_DatePicker.setName("kdtEntrys_logoutDate_DatePicker");
        kdtEntrys_logoutDate_DatePicker.setVisible(true);
        kdtEntrys_logoutDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_logoutDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_logoutDate_DatePicker);
        this.kdtEntrys.getColumn("logoutDate").setEditor(kdtEntrys_logoutDate_CellEditor);
        KDTextField kdtEntrys_logoutReson_TextField = new KDTextField();
        kdtEntrys_logoutReson_TextField.setName("kdtEntrys_logoutReson_TextField");
        kdtEntrys_logoutReson_TextField.setMaxLength(150);
        KDTDefaultCellEditor kdtEntrys_logoutReson_CellEditor = new KDTDefaultCellEditor(kdtEntrys_logoutReson_TextField);
        this.kdtEntrys.getColumn("logoutReson").setEditor(kdtEntrys_logoutReson_CellEditor);
        KDCheckBox kdtEntrys_isCancel_CheckBox = new KDCheckBox();
        kdtEntrys_isCancel_CheckBox.setName("kdtEntrys_isCancel_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isCancel_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isCancel_CheckBox);
        this.kdtEntrys.getColumn("isCancel").setEditor(kdtEntrys_isCancel_CellEditor);
        KDDatePicker kdtEntrys_cancelDate_DatePicker = new KDDatePicker();
        kdtEntrys_cancelDate_DatePicker.setName("kdtEntrys_cancelDate_DatePicker");
        kdtEntrys_cancelDate_DatePicker.setVisible(true);
        kdtEntrys_cancelDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_cancelDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cancelDate_DatePicker);
        this.kdtEntrys.getColumn("cancelDate").setEditor(kdtEntrys_cancelDate_CellEditor);
        KDTextField kdtEntrys_cancelReson_TextField = new KDTextField();
        kdtEntrys_cancelReson_TextField.setName("kdtEntrys_cancelReson_TextField");
        kdtEntrys_cancelReson_TextField.setMaxLength(150);
        KDTDefaultCellEditor kdtEntrys_cancelReson_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cancelReson_TextField);
        this.kdtEntrys.getColumn("cancelReson").setEditor(kdtEntrys_cancelReson_CellEditor);
        KDTextField kdtEntrys_idNum_TextField = new KDTextField();
        kdtEntrys_idNum_TextField.setName("kdtEntrys_idNum_TextField");
        kdtEntrys_idNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_idNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_idNum_TextField);
        this.kdtEntrys.getColumn("idNum").setEditor(kdtEntrys_idNum_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        KDTextField kdtEntrys_actproff_TextField = new KDTextField();
        kdtEntrys_actproff_TextField.setName("kdtEntrys_actproff_TextField");
        kdtEntrys_actproff_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_actproff_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actproff_TextField);
        this.kdtEntrys.getColumn("actproff").setEditor(kdtEntrys_actproff_CellEditor);
        KDTextField kdtEntrys_sourceEntryID_TextField = new KDTextField();
        kdtEntrys_sourceEntryID_TextField.setName("kdtEntrys_sourceEntryID_TextField");
        kdtEntrys_sourceEntryID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_sourceEntryID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sourceEntryID_TextField);
        this.kdtEntrys.getColumn("sourceEntryID").setEditor(kdtEntrys_sourceEntryID_CellEditor);
        KDTextField kdtEntrys_personID_TextField = new KDTextField();
        kdtEntrys_personID_TextField.setName("kdtEntrys_personID_TextField");
        kdtEntrys_personID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_personID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personID_TextField);
        this.kdtEntrys.getColumn("personID").setEditor(kdtEntrys_personID_CellEditor);
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
        kdtEntrys_coupleWorkPlace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coupleWorkPlace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleWorkPlace_TextField);
        this.kdtEntrys.getColumn("coupleWorkPlace").setEditor(kdtEntrys_coupleWorkPlace_CellEditor);
        KDTextField kdtEntrys_contactway_TextField = new KDTextField();
        kdtEntrys_contactway_TextField.setName("kdtEntrys_contactway_TextField");
        kdtEntrys_contactway_TextField.setMaxLength(30);
        KDTDefaultCellEditor kdtEntrys_contactway_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contactway_TextField);
        this.kdtEntrys.getColumn("contactway").setEditor(kdtEntrys_contactway_CellEditor);
        KDTextField kdtEntrys_residence_TextField = new KDTextField();
        kdtEntrys_residence_TextField.setName("kdtEntrys_residence_TextField");
        kdtEntrys_residence_TextField.setMaxLength(150);
        KDTDefaultCellEditor kdtEntrys_residence_CellEditor = new KDTDefaultCellEditor(kdtEntrys_residence_TextField);
        this.kdtEntrys.getColumn("residence").setEditor(kdtEntrys_residence_CellEditor);
        KDTextField kdtEntrys_oldPassport_TextField = new KDTextField();
        kdtEntrys_oldPassport_TextField.setName("kdtEntrys_oldPassport_TextField");
        kdtEntrys_oldPassport_TextField.setMaxLength(40);
        KDTDefaultCellEditor kdtEntrys_oldPassport_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oldPassport_TextField);
        this.kdtEntrys.getColumn("oldPassport").setEditor(kdtEntrys_oldPassport_CellEditor);
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
        KDDatePicker kdtEntrys_leaveTime_DatePicker = new KDDatePicker();
        kdtEntrys_leaveTime_DatePicker.setName("kdtEntrys_leaveTime_DatePicker");
        kdtEntrys_leaveTime_DatePicker.setVisible(true);
        kdtEntrys_leaveTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_leaveTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_leaveTime_DatePicker);
        this.kdtEntrys.getColumn("leaveTime").setEditor(kdtEntrys_leaveTime_CellEditor);
        KDDatePicker kdtEntrys_immiTime_DatePicker = new KDDatePicker();
        kdtEntrys_immiTime_DatePicker.setName("kdtEntrys_immiTime_DatePicker");
        kdtEntrys_immiTime_DatePicker.setVisible(true);
        kdtEntrys_immiTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_immiTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_immiTime_DatePicker);
        this.kdtEntrys.getColumn("immiTime").setEditor(kdtEntrys_immiTime_CellEditor);
        // contbNum		
        this.contbNum.setBoundLabelText(resHelper.getString("contbNum.boundLabelText"));		
        this.contbNum.setBoundLabelLength(100);		
        this.contbNum.setBoundLabelUnderline(true);		
        this.contbNum.setVisible(false);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);
        // contbillSate		
        this.contbillSate.setBoundLabelText(resHelper.getString("contbillSate.boundLabelText"));		
        this.contbillSate.setBoundLabelLength(100);		
        this.contbillSate.setBoundLabelUnderline(true);		
        this.contbillSate.setVisible(true);
        // contlSubtime		
        this.contlSubtime.setBoundLabelText(resHelper.getString("contlSubtime.boundLabelText"));		
        this.contlSubtime.setBoundLabelLength(100);		
        this.contlSubtime.setBoundLabelUnderline(true);		
        this.contlSubtime.setVisible(true);
        // contISubmitor		
        this.contISubmitor.setBoundLabelText(resHelper.getString("contISubmitor.boundLabelText"));		
        this.contISubmitor.setBoundLabelLength(100);		
        this.contISubmitor.setBoundLabelUnderline(true);		
        this.contISubmitor.setVisible(true);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setFont(new java.awt.Font("Dialog",1,9));		
        this.kDLabelContainer1.setForeground(new java.awt.Color(255,0,0));
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
        // pklSubtime		
        this.pklSubtime.setRequired(false);		
        this.pklSubtime.setEnabled(false);
        // prmtISubmitor		
        this.prmtISubmitor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtISubmitor.setEditable(true);		
        this.prmtISubmitor.setDisplayFormat("$number$");		
        this.prmtISubmitor.setEditFormat("$number$");		
        this.prmtISubmitor.setCommitFormat("$number$");		
        this.prmtISubmitor.setRequired(false);		
        this.prmtISubmitor.setEnabled(false);
        // btnLogout
        this.btnLogout.setAction((IItemAction)ActionProxyFactory.getProxy(actionLogout, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnLogout.setText(resHelper.getString("btnLogout.text"));		
        this.btnLogout.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgIcon_unstall"));		
        this.btnLogout.setVisible(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));		
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));
        // btnUnaAudit
        this.btnUnaAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnaAudit.setText(resHelper.getString("btnUnaAudit.text"));		
        this.btnUnaAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_fauditing"));
        // btnRollBack
        this.btnRollBack.setAction((IItemAction)ActionProxyFactory.getProxy(actionRollBack, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRollBack.setText(resHelper.getString("btnRollBack.text"));		
        this.btnRollBack.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgHelp_last"));		
        this.btnRollBack.setVisible(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtbNum,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditDate,billSate,pklSubtime,prmtISubmitor,kdtEntrys}));
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
        this.setBounds(new Rectangle(8, -2, 1155, 503));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(8, -2, 1155, 503));
        contCreator.setBounds(new Rectangle(5, 476, 234, 19));
        this.add(contCreator, new KDLayout.Constraints(5, 476, 234, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(302, 476, 234, 19));
        this.add(contCreateTime, new KDLayout.Constraints(302, 476, 234, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(7, 496, 231, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(7, 496, 231, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(303, 496, 231, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(303, 496, 231, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(8, 6, 253, 19));
        this.add(contNumber, new KDLayout.Constraints(8, 6, 253, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(590, 35, 253, 19));
        this.add(contBizDate, new KDLayout.Constraints(590, 35, 253, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(8, 35, 525, 19));
        this.add(contDescription, new KDLayout.Constraints(8, 35, 525, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(599, 476, 234, 19));
        this.add(contAuditor, new KDLayout.Constraints(599, 476, 234, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(7, 89, 1135, 383));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.certificates.AntiECEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(7, 89, 1135, 383, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("sex",new Integer(1));
vo.put("passportAgence","10");
vo.put("mayrStat","0");
vo.put("authType","0");
vo.put("personState","10");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contbNum.setBounds(new Rectangle(885, 34, 169, 19));
        this.add(contbNum, new KDLayout.Constraints(885, 34, 169, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditDate.setBounds(new Rectangle(898, 476, 235, 19));
        this.add(contauditDate, new KDLayout.Constraints(898, 476, 235, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillSate.setBounds(new Rectangle(883, 6, 253, 19));
        this.add(contbillSate, new KDLayout.Constraints(883, 6, 253, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contlSubtime.setBounds(new Rectangle(590, 6, 253, 19));
        this.add(contlSubtime, new KDLayout.Constraints(590, 6, 253, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contISubmitor.setBounds(new Rectangle(282, 5, 253, 19));
        this.add(contISubmitor, new KDLayout.Constraints(282, 5, 253, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer1.setBounds(new Rectangle(8, 60, 400, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(8, 60, 400, 19, 0));
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
        //contlSubtime
        contlSubtime.setBoundEditor(pklSubtime);
        //contISubmitor
        contISubmitor.setBoundEditor(prmtISubmitor);

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
        this.toolBar.add(btnPrint);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnLogout);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnaAudit);
        this.toolBar.add(btnRollBack);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.certificates.AntiECEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.name", String.class, this.kdtEntrys, "name.text");
		dataBinder.registerBinding("entrys.birDate", java.util.Date.class, this.kdtEntrys, "birDate.text");
		dataBinder.registerBinding("entrys.passpNo", String.class, this.kdtEntrys, "passpNo.text");
		dataBinder.registerBinding("entrys.passpIssDate", java.util.Date.class, this.kdtEntrys, "passpIssDate.text");
		dataBinder.registerBinding("entrys.passpExDate", java.util.Date.class, this.kdtEntrys, "passpExDate.text");
		dataBinder.registerBinding("entrys.birAddrCn", String.class, this.kdtEntrys, "birAddrCn.text");
		dataBinder.registerBinding("entrys.fName", String.class, this.kdtEntrys, "fName.text");
		dataBinder.registerBinding("entrys.alphFName", String.class, this.kdtEntrys, "alphFName.text");
		dataBinder.registerBinding("entrys.mName", String.class, this.kdtEntrys, "mName.text");
		dataBinder.registerBinding("entrys.alphMName", String.class, this.kdtEntrys, "alphMName.text");
		dataBinder.registerBinding("entrys.sendLaBuDate", java.util.Date.class, this.kdtEntrys, "sendLaBuDate.text");
		dataBinder.registerBinding("entrys.antiSgTime", java.util.Date.class, this.kdtEntrys, "antiSgTime.text");
		dataBinder.registerBinding("entrys.sex", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "sex.text");
		dataBinder.registerBinding("entrys.mayrStat", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "mayrStat.text");
		dataBinder.registerBinding("entrys.partner", java.lang.Object.class, this.kdtEntrys, "partner.text");
		dataBinder.registerBinding("entrys.taskProj", java.lang.Object.class, this.kdtEntrys, "taskProj.text");
		dataBinder.registerBinding("entrys.pmtProj", java.lang.Object.class, this.kdtEntrys, "pmtProj.text");
		dataBinder.registerBinding("entrys.quProf", java.lang.Object.class, this.kdtEntrys, "quProf.text");
		dataBinder.registerBinding("entrys.actproff", String.class, this.kdtEntrys, "actproff.text");
		dataBinder.registerBinding("entrys.workExp", int.class, this.kdtEntrys, "workExp.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.idNum", String.class, this.kdtEntrys, "idNum.text");
		dataBinder.registerBinding("entrys.isCancel", boolean.class, this.kdtEntrys, "isCancel.text");
		dataBinder.registerBinding("entrys.natioNal", java.lang.Object.class, this.kdtEntrys, "natioNal.text");
		dataBinder.registerBinding("entrys.signNum", String.class, this.kdtEntrys, "signNum.text");
		dataBinder.registerBinding("entrys.sourceEntryID", String.class, this.kdtEntrys, "sourceEntryID.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.birthPlaceFr", String.class, this.kdtEntrys, "birthPlaceFr.text");
		dataBinder.registerBinding("entrys.passportAgence", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "passportAgence.text");
		dataBinder.registerBinding("entrys.passportCityC", java.lang.Object.class, this.kdtEntrys, "passportCityC.text");
		dataBinder.registerBinding("entrys.passportCityF", String.class, this.kdtEntrys, "passportCityF.text");
		dataBinder.registerBinding("entrys.pmtProfFr", String.class, this.kdtEntrys, "pmtProfFr.text");
		dataBinder.registerBinding("entrys.ownerSignDate", java.util.Date.class, this.kdtEntrys, "ownerSignDate.text");
		dataBinder.registerBinding("entrys.docUpDate", java.util.Date.class, this.kdtEntrys, "docUpDate.text");
		dataBinder.registerBinding("entrys.laborSignNo", String.class, this.kdtEntrys, "laborSignNo.text");
		dataBinder.registerBinding("entrys.docAffiliated", boolean.class, this.kdtEntrys, "docAffiliated.text");
		dataBinder.registerBinding("entrys.isLogout", boolean.class, this.kdtEntrys, "isLogout.text");
		dataBinder.registerBinding("entrys.logoutDate", java.util.Date.class, this.kdtEntrys, "logoutDate.text");
		dataBinder.registerBinding("entrys.logoutReson", String.class, this.kdtEntrys, "logoutReson.text");
		dataBinder.registerBinding("entrys.cancelDate", java.util.Date.class, this.kdtEntrys, "cancelDate.text");
		dataBinder.registerBinding("entrys.cancelReson", String.class, this.kdtEntrys, "cancelReson.text");
		dataBinder.registerBinding("entrys.authType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "authType.text");
		dataBinder.registerBinding("entrys.copies", int.class, this.kdtEntrys, "copies.text");
		dataBinder.registerBinding("entrys.coupleName", String.class, this.kdtEntrys, "coupleName.text");
		dataBinder.registerBinding("entrys.coupleNameAlphabet", String.class, this.kdtEntrys, "coupleNameAlphabet.text");
		dataBinder.registerBinding("entrys.coupleBirthDate", java.util.Date.class, this.kdtEntrys, "coupleBirthDate.text");
		dataBinder.registerBinding("entrys.coupleBirthPlace", String.class, this.kdtEntrys, "coupleBirthPlace.text");
		dataBinder.registerBinding("entrys.coupleNational", java.lang.Object.class, this.kdtEntrys, "coupleNational.text");
		dataBinder.registerBinding("entrys.coupleWorkPlace", String.class, this.kdtEntrys, "coupleWorkPlace.text");
		dataBinder.registerBinding("entrys.contactway", String.class, this.kdtEntrys, "contactway.text");
		dataBinder.registerBinding("entrys.residence", String.class, this.kdtEntrys, "residence.text");
		dataBinder.registerBinding("entrys.oldPassport", String.class, this.kdtEntrys, "oldPassport.text");
		dataBinder.registerBinding("entrys.assignDate", java.util.Date.class, this.kdtEntrys, "assignDate.text");
		dataBinder.registerBinding("entrys.personState", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "personState.text");
		dataBinder.registerBinding("entrys.isPush", boolean.class, this.kdtEntrys, "isPush.text");
		dataBinder.registerBinding("entrys.antiEndTime", java.util.Date.class, this.kdtEntrys, "antiEndTime.text");
		dataBinder.registerBinding("entrys.appAffiliated", boolean.class, this.kdtEntrys, "appAffiliated.text");
		dataBinder.registerBinding("entrys.oldEtyId", String.class, this.kdtEntrys, "oldEtyId.text");
		dataBinder.registerBinding("entrys.leaveTime", java.util.Date.class, this.kdtEntrys, "leaveTime.text");
		dataBinder.registerBinding("entrys.immiTime", java.util.Date.class, this.kdtEntrys, "immiTime.text");
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
		dataBinder.registerBinding("lSubtime", java.util.Date.class, this.pklSubtime, "value");
		dataBinder.registerBinding("ISubmitor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtISubmitor, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.certificates.app.AntiECEditUIHandler";
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
        this.txtbNum.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.certificates.AntiECInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpIssDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpExDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birAddrCn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.alphFName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.mName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.alphMName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendLaBuDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.antiSgTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.mayrStat", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.partner", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.taskProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.quProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actproff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workExp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.idNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isCancel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.natioNal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.signNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sourceEntryID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportAgence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCityC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCityF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProfFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ownerSignDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docUpDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.laborSignNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docAffiliated", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isLogout", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.logoutDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.logoutReson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cancelDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cancelReson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.authType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.copies", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleBirthDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleBirthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNational", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleWorkPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contactway", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.residence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oldPassport", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.assignDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isPush", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.antiEndTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.appAffiliated", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oldEtyId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.leaveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.immiTime", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("lSubtime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ISubmitor", ValidateHelper.ON_SAVE);    		
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
		}
    	sic.add(new SelectorItemInfo("entrys.birDate"));
    	sic.add(new SelectorItemInfo("entrys.passpNo"));
    	sic.add(new SelectorItemInfo("entrys.passpIssDate"));
    	sic.add(new SelectorItemInfo("entrys.passpExDate"));
    	sic.add(new SelectorItemInfo("entrys.birAddrCn"));
    	sic.add(new SelectorItemInfo("entrys.fName"));
    	sic.add(new SelectorItemInfo("entrys.alphFName"));
    	sic.add(new SelectorItemInfo("entrys.mName"));
    	sic.add(new SelectorItemInfo("entrys.alphMName"));
    	sic.add(new SelectorItemInfo("entrys.sendLaBuDate"));
    	sic.add(new SelectorItemInfo("entrys.antiSgTime"));
    	sic.add(new SelectorItemInfo("entrys.sex"));
    	sic.add(new SelectorItemInfo("entrys.mayrStat"));
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
			sic.add(new SelectorItemInfo("entrys.quProf.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.quProf.id"));
			sic.add(new SelectorItemInfo("entrys.quProf.name"));
        	sic.add(new SelectorItemInfo("entrys.quProf.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.actproff"));
    	sic.add(new SelectorItemInfo("entrys.workExp"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.idNum"));
    	sic.add(new SelectorItemInfo("entrys.isCancel"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.natioNal.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.natioNal.id"));
			sic.add(new SelectorItemInfo("entrys.natioNal.name"));
        	sic.add(new SelectorItemInfo("entrys.natioNal.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.signNum"));
    	sic.add(new SelectorItemInfo("entrys.sourceEntryID"));
    	sic.add(new SelectorItemInfo("entrys.personID"));
    	sic.add(new SelectorItemInfo("entrys.lastName"));
    	sic.add(new SelectorItemInfo("entrys.firstName"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceFr"));
    	sic.add(new SelectorItemInfo("entrys.passportAgence"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.passportCityC.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.passportCityC.id"));
			sic.add(new SelectorItemInfo("entrys.passportCityC.name"));
        	sic.add(new SelectorItemInfo("entrys.passportCityC.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.passportCityF"));
    	sic.add(new SelectorItemInfo("entrys.pmtProfFr"));
    	sic.add(new SelectorItemInfo("entrys.ownerSignDate"));
    	sic.add(new SelectorItemInfo("entrys.docUpDate"));
    	sic.add(new SelectorItemInfo("entrys.laborSignNo"));
    	sic.add(new SelectorItemInfo("entrys.docAffiliated"));
    	sic.add(new SelectorItemInfo("entrys.isLogout"));
    	sic.add(new SelectorItemInfo("entrys.logoutDate"));
    	sic.add(new SelectorItemInfo("entrys.logoutReson"));
    	sic.add(new SelectorItemInfo("entrys.cancelDate"));
    	sic.add(new SelectorItemInfo("entrys.cancelReson"));
    	sic.add(new SelectorItemInfo("entrys.authType"));
    	sic.add(new SelectorItemInfo("entrys.copies"));
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
    	sic.add(new SelectorItemInfo("entrys.oldPassport"));
    	sic.add(new SelectorItemInfo("entrys.assignDate"));
    	sic.add(new SelectorItemInfo("entrys.personState"));
    	sic.add(new SelectorItemInfo("entrys.isPush"));
    	sic.add(new SelectorItemInfo("entrys.antiEndTime"));
    	sic.add(new SelectorItemInfo("entrys.appAffiliated"));
    	sic.add(new SelectorItemInfo("entrys.oldEtyId"));
    	sic.add(new SelectorItemInfo("entrys.leaveTime"));
    	sic.add(new SelectorItemInfo("entrys.immiTime"));
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
        sic.add(new SelectorItemInfo("lSubtime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ISubmitor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("ISubmitor.id"));
        	sic.add(new SelectorItemInfo("ISubmitor.number"));
        	sic.add(new SelectorItemInfo("ISubmitor.name"));
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
    	

    /**
     * output actionLogout_actionPerformed method
     */
    public void actionLogout_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionRollBack_actionPerformed method
     */
    public void actionRollBack_actionPerformed(ActionEvent e) throws Exception
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
	public RequestContext prepareActionLogout(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionLogout() {
    	return false;
    }
	public RequestContext prepareActionRollBack(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRollBack() {
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
            innerActionPerformed("eas", AbstractAntiECEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractAntiECEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionLogout class
     */     
    protected class ActionLogout extends ItemAction {     
    
        public ActionLogout()
        {
            this(null);
        }

        public ActionLogout(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionLogout.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionLogout.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionLogout.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractAntiECEditUI.this, "ActionLogout", "actionLogout_actionPerformed", e);
        }
    }

    /**
     * output ActionRollBack class
     */     
    protected class ActionRollBack extends ItemAction {     
    
        public ActionRollBack()
        {
            this(null);
        }

        public ActionRollBack(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionRollBack.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRollBack.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRollBack.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractAntiECEditUI.this, "ActionRollBack", "actionRollBack_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.certificates.client", "AntiECEditUI");
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
        return com.kingdee.eas.zjlw.certificates.client.AntiECEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.AntiECFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.AntiECInfo objectValue = new com.kingdee.eas.zjlw.certificates.AntiECInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/certificates/AntiEC";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.certificates.app.AntiECQuery");
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