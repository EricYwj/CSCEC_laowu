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
public abstract class AbstractDoubEcEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDoubEcEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillSate;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkifNeed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contneedReson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtneedReson;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.zjlw.certificates.DoubEcInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractDoubEcEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDoubEcEditUI.class.getName());
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
        this.contbillSate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkifNeed = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contneedReson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billSate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtneedReson = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.contbillSate.setName("contbillSate");
        this.chkifNeed.setName("chkifNeed");
        this.contneedReson.setName("contneedReson");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billSate.setName("billSate");
        this.txtneedReson.setName("txtneedReson");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol27\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol28\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol30\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol32\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"namePY\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"genDers\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"birthdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"birthPlaceCn\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"birthPlaceFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"IdNum\" t:width=\"145\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"actProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"pmtProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"pmtProfFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"natioNal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"passpNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"workSuffer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"type\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"copies\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"assignDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"qualbaNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"notiDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"notaDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"qualSendDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"qualDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"wkPmtGet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wpCopies\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"pmtFiDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"dbFiDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"pmtProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"taskProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"partner\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"ifstop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"stopTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"stopRes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"isIfilentry\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"desCription\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sourceEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"oldEtyId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{namePY}</t:Cell><t:Cell>$Resource{genDers}</t:Cell><t:Cell>$Resource{birthdate}</t:Cell><t:Cell>$Resource{birthPlaceCn}</t:Cell><t:Cell>$Resource{birthPlaceFr}</t:Cell><t:Cell>$Resource{IdNum}</t:Cell><t:Cell>$Resource{actProf}</t:Cell><t:Cell>$Resource{pmtProf}</t:Cell><t:Cell>$Resource{pmtProfFr}</t:Cell><t:Cell>$Resource{natioNal}</t:Cell><t:Cell>$Resource{passpNo}</t:Cell><t:Cell>$Resource{workSuffer}</t:Cell><t:Cell>$Resource{type}</t:Cell><t:Cell>$Resource{copies}</t:Cell><t:Cell>$Resource{assignDate}</t:Cell><t:Cell>$Resource{qualbaNum}</t:Cell><t:Cell>$Resource{notiDate}</t:Cell><t:Cell>$Resource{notaDate}</t:Cell><t:Cell>$Resource{qualSendDate}</t:Cell><t:Cell>$Resource{qualDate}</t:Cell><t:Cell>$Resource{wkPmtGet}</t:Cell><t:Cell>$Resource{wpCopies}</t:Cell><t:Cell>$Resource{pmtFiDate}</t:Cell><t:Cell>$Resource{dbFiDate}</t:Cell><t:Cell>$Resource{pmtProj}</t:Cell><t:Cell>$Resource{taskProj}</t:Cell><t:Cell>$Resource{partner}</t:Cell><t:Cell>$Resource{ifstop}</t:Cell><t:Cell>$Resource{stopTime}</t:Cell><t:Cell>$Resource{stopRes}</t:Cell><t:Cell>$Resource{isIfilentry}</t:Cell><t:Cell>$Resource{desCription}</t:Cell><t:Cell>$Resource{sourceEntryID}</t:Cell><t:Cell>$Resource{personID}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{oldEtyId}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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

                this.kdtEntrys.putBindContents("editData",new String[] {"id","name","namePY","genDers","birthdate","birthPlaceCn","birthPlaceFr","IdNum","actProf","pmtProf","pmtProfFr","natioNal","passpNo","workSuffer","type","copies","assignDate","qualbaNum","notiDate","notaDate","qualSendDate","qualDate","wkPmtGet","wpCopies","pmtFiDate","dbFiDate","pmtProj","taskProj","partner","ifstop","stopTime","stopRes","isIfilentry","desCription","sourceEntryID","personID","lastName","firstName","oldEtyId"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_name_TextField = new KDTextField();
        kdtEntrys_name_TextField.setName("kdtEntrys_name_TextField");
        kdtEntrys_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_name_CellEditor = new KDTDefaultCellEditor(kdtEntrys_name_TextField);
        this.kdtEntrys.getColumn("name").setEditor(kdtEntrys_name_CellEditor);
        KDTextField kdtEntrys_namePY_TextField = new KDTextField();
        kdtEntrys_namePY_TextField.setName("kdtEntrys_namePY_TextField");
        kdtEntrys_namePY_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_namePY_CellEditor = new KDTDefaultCellEditor(kdtEntrys_namePY_TextField);
        this.kdtEntrys.getColumn("namePY").setEditor(kdtEntrys_namePY_CellEditor);
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
        KDTextField kdtEntrys_birthPlaceCn_TextField = new KDTextField();
        kdtEntrys_birthPlaceCn_TextField.setName("kdtEntrys_birthPlaceCn_TextField");
        kdtEntrys_birthPlaceCn_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_birthPlaceCn_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlaceCn_TextField);
        this.kdtEntrys.getColumn("birthPlaceCn").setEditor(kdtEntrys_birthPlaceCn_CellEditor);
        KDTextField kdtEntrys_birthPlaceFr_TextField = new KDTextField();
        kdtEntrys_birthPlaceFr_TextField.setName("kdtEntrys_birthPlaceFr_TextField");
        kdtEntrys_birthPlaceFr_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_birthPlaceFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlaceFr_TextField);
        this.kdtEntrys.getColumn("birthPlaceFr").setEditor(kdtEntrys_birthPlaceFr_CellEditor);
        KDTextField kdtEntrys_IdNum_TextField = new KDTextField();
        kdtEntrys_IdNum_TextField.setName("kdtEntrys_IdNum_TextField");
        kdtEntrys_IdNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_IdNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IdNum_TextField);
        this.kdtEntrys.getColumn("IdNum").setEditor(kdtEntrys_IdNum_CellEditor);
        KDTextField kdtEntrys_actProf_TextField = new KDTextField();
        kdtEntrys_actProf_TextField.setName("kdtEntrys_actProf_TextField");
        kdtEntrys_actProf_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_actProf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actProf_TextField);
        this.kdtEntrys.getColumn("actProf").setEditor(kdtEntrys_actProf_CellEditor);
        final KDBizPromptBox kdtEntrys_pmtProf_PromptBox = new KDBizPromptBox();
        kdtEntrys_pmtProf_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");
        kdtEntrys_pmtProf_PromptBox.setVisible(true);
        kdtEntrys_pmtProf_PromptBox.setEditable(true);
        kdtEntrys_pmtProf_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_pmtProf_PromptBox.setEditFormat("$number$");
        kdtEntrys_pmtProf_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_pmtProf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProf_PromptBox);
        this.kdtEntrys.getColumn("pmtProf").setEditor(kdtEntrys_pmtProf_CellEditor);
        ObjectValueRender kdtEntrys_pmtProf_OVR = new ObjectValueRender();
        kdtEntrys_pmtProf_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("pmtProf").setRenderer(kdtEntrys_pmtProf_OVR);
        KDTextField kdtEntrys_pmtProfFr_TextField = new KDTextField();
        kdtEntrys_pmtProfFr_TextField.setName("kdtEntrys_pmtProfFr_TextField");
        kdtEntrys_pmtProfFr_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_pmtProfFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProfFr_TextField);
        this.kdtEntrys.getColumn("pmtProfFr").setEditor(kdtEntrys_pmtProfFr_CellEditor);
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
        KDFormattedTextField kdtEntrys_workSuffer_TextField = new KDFormattedTextField();
        kdtEntrys_workSuffer_TextField.setName("kdtEntrys_workSuffer_TextField");
        kdtEntrys_workSuffer_TextField.setVisible(true);
        kdtEntrys_workSuffer_TextField.setEditable(true);
        kdtEntrys_workSuffer_TextField.setHorizontalAlignment(2);
        kdtEntrys_workSuffer_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_workSuffer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workSuffer_TextField);
        this.kdtEntrys.getColumn("workSuffer").setEditor(kdtEntrys_workSuffer_CellEditor);
        KDComboBox kdtEntrys_type_ComboBox = new KDComboBox();
        kdtEntrys_type_ComboBox.setName("kdtEntrys_type_ComboBox");
        kdtEntrys_type_ComboBox.setVisible(true);
        kdtEntrys_type_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.authType").toArray());
        KDTDefaultCellEditor kdtEntrys_type_CellEditor = new KDTDefaultCellEditor(kdtEntrys_type_ComboBox);
        this.kdtEntrys.getColumn("type").setEditor(kdtEntrys_type_CellEditor);
        KDFormattedTextField kdtEntrys_copies_TextField = new KDFormattedTextField();
        kdtEntrys_copies_TextField.setName("kdtEntrys_copies_TextField");
        kdtEntrys_copies_TextField.setVisible(true);
        kdtEntrys_copies_TextField.setEditable(true);
        kdtEntrys_copies_TextField.setHorizontalAlignment(2);
        kdtEntrys_copies_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_copies_CellEditor = new KDTDefaultCellEditor(kdtEntrys_copies_TextField);
        this.kdtEntrys.getColumn("copies").setEditor(kdtEntrys_copies_CellEditor);
        KDDatePicker kdtEntrys_assignDate_DatePicker = new KDDatePicker();
        kdtEntrys_assignDate_DatePicker.setName("kdtEntrys_assignDate_DatePicker");
        kdtEntrys_assignDate_DatePicker.setVisible(true);
        kdtEntrys_assignDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_assignDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_assignDate_DatePicker);
        this.kdtEntrys.getColumn("assignDate").setEditor(kdtEntrys_assignDate_CellEditor);
        KDTextField kdtEntrys_qualbaNum_TextField = new KDTextField();
        kdtEntrys_qualbaNum_TextField.setName("kdtEntrys_qualbaNum_TextField");
        kdtEntrys_qualbaNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_qualbaNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qualbaNum_TextField);
        this.kdtEntrys.getColumn("qualbaNum").setEditor(kdtEntrys_qualbaNum_CellEditor);
        KDDatePicker kdtEntrys_notiDate_DatePicker = new KDDatePicker();
        kdtEntrys_notiDate_DatePicker.setName("kdtEntrys_notiDate_DatePicker");
        kdtEntrys_notiDate_DatePicker.setVisible(true);
        kdtEntrys_notiDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_notiDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_notiDate_DatePicker);
        this.kdtEntrys.getColumn("notiDate").setEditor(kdtEntrys_notiDate_CellEditor);
        KDDatePicker kdtEntrys_notaDate_DatePicker = new KDDatePicker();
        kdtEntrys_notaDate_DatePicker.setName("kdtEntrys_notaDate_DatePicker");
        kdtEntrys_notaDate_DatePicker.setVisible(true);
        kdtEntrys_notaDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_notaDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_notaDate_DatePicker);
        this.kdtEntrys.getColumn("notaDate").setEditor(kdtEntrys_notaDate_CellEditor);
        KDDatePicker kdtEntrys_qualSendDate_DatePicker = new KDDatePicker();
        kdtEntrys_qualSendDate_DatePicker.setName("kdtEntrys_qualSendDate_DatePicker");
        kdtEntrys_qualSendDate_DatePicker.setVisible(true);
        kdtEntrys_qualSendDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_qualSendDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qualSendDate_DatePicker);
        this.kdtEntrys.getColumn("qualSendDate").setEditor(kdtEntrys_qualSendDate_CellEditor);
        KDDatePicker kdtEntrys_qualDate_DatePicker = new KDDatePicker();
        kdtEntrys_qualDate_DatePicker.setName("kdtEntrys_qualDate_DatePicker");
        kdtEntrys_qualDate_DatePicker.setVisible(true);
        kdtEntrys_qualDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_qualDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qualDate_DatePicker);
        this.kdtEntrys.getColumn("qualDate").setEditor(kdtEntrys_qualDate_CellEditor);
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
        KDDatePicker kdtEntrys_pmtFiDate_DatePicker = new KDDatePicker();
        kdtEntrys_pmtFiDate_DatePicker.setName("kdtEntrys_pmtFiDate_DatePicker");
        kdtEntrys_pmtFiDate_DatePicker.setVisible(true);
        kdtEntrys_pmtFiDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_pmtFiDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtFiDate_DatePicker);
        this.kdtEntrys.getColumn("pmtFiDate").setEditor(kdtEntrys_pmtFiDate_CellEditor);
        KDDatePicker kdtEntrys_dbFiDate_DatePicker = new KDDatePicker();
        kdtEntrys_dbFiDate_DatePicker.setName("kdtEntrys_dbFiDate_DatePicker");
        kdtEntrys_dbFiDate_DatePicker.setVisible(true);
        kdtEntrys_dbFiDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_dbFiDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dbFiDate_DatePicker);
        this.kdtEntrys.getColumn("dbFiDate").setEditor(kdtEntrys_dbFiDate_CellEditor);
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
        KDCheckBox kdtEntrys_ifstop_CheckBox = new KDCheckBox();
        kdtEntrys_ifstop_CheckBox.setName("kdtEntrys_ifstop_CheckBox");
        KDTDefaultCellEditor kdtEntrys_ifstop_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ifstop_CheckBox);
        this.kdtEntrys.getColumn("ifstop").setEditor(kdtEntrys_ifstop_CellEditor);
        KDDatePicker kdtEntrys_stopTime_DatePicker = new KDDatePicker();
        kdtEntrys_stopTime_DatePicker.setName("kdtEntrys_stopTime_DatePicker");
        kdtEntrys_stopTime_DatePicker.setVisible(true);
        kdtEntrys_stopTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_stopTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stopTime_DatePicker);
        this.kdtEntrys.getColumn("stopTime").setEditor(kdtEntrys_stopTime_CellEditor);
        KDTextField kdtEntrys_stopRes_TextField = new KDTextField();
        kdtEntrys_stopRes_TextField.setName("kdtEntrys_stopRes_TextField");
        kdtEntrys_stopRes_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_stopRes_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stopRes_TextField);
        this.kdtEntrys.getColumn("stopRes").setEditor(kdtEntrys_stopRes_CellEditor);
        KDCheckBox kdtEntrys_isIfilentry_CheckBox = new KDCheckBox();
        kdtEntrys_isIfilentry_CheckBox.setName("kdtEntrys_isIfilentry_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isIfilentry_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isIfilentry_CheckBox);
        this.kdtEntrys.getColumn("isIfilentry").setEditor(kdtEntrys_isIfilentry_CellEditor);
        KDTextField kdtEntrys_desCription_TextField = new KDTextField();
        kdtEntrys_desCription_TextField.setName("kdtEntrys_desCription_TextField");
        kdtEntrys_desCription_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_desCription_CellEditor = new KDTDefaultCellEditor(kdtEntrys_desCription_TextField);
        this.kdtEntrys.getColumn("desCription").setEditor(kdtEntrys_desCription_CellEditor);
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
        KDTextField kdtEntrys_lastName_TextField = new KDTextField();
        kdtEntrys_lastName_TextField.setName("kdtEntrys_lastName_TextField");
        kdtEntrys_lastName_TextField.setMaxLength(50);
        KDTDefaultCellEditor kdtEntrys_lastName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lastName_TextField);
        this.kdtEntrys.getColumn("lastName").setEditor(kdtEntrys_lastName_CellEditor);
        KDTextField kdtEntrys_firstName_TextField = new KDTextField();
        kdtEntrys_firstName_TextField.setName("kdtEntrys_firstName_TextField");
        kdtEntrys_firstName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_firstName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_firstName_TextField);
        this.kdtEntrys.getColumn("firstName").setEditor(kdtEntrys_firstName_CellEditor);
        KDTextField kdtEntrys_oldEtyId_TextField = new KDTextField();
        kdtEntrys_oldEtyId_TextField.setName("kdtEntrys_oldEtyId_TextField");
        kdtEntrys_oldEtyId_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_oldEtyId_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oldEtyId_TextField);
        this.kdtEntrys.getColumn("oldEtyId").setEditor(kdtEntrys_oldEtyId_CellEditor);
        // contbillSate		
        this.contbillSate.setBoundLabelText(resHelper.getString("contbillSate.boundLabelText"));		
        this.contbillSate.setBoundLabelLength(100);		
        this.contbillSate.setBoundLabelUnderline(true);		
        this.contbillSate.setVisible(true);
        // chkifNeed		
        this.chkifNeed.setText(resHelper.getString("chkifNeed.text"));		
        this.chkifNeed.setHorizontalAlignment(2);		
        this.chkifNeed.setEnabled(false);
        // contneedReson		
        this.contneedReson.setBoundLabelText(resHelper.getString("contneedReson.boundLabelText"));		
        this.contneedReson.setBoundLabelLength(100);		
        this.contneedReson.setBoundLabelUnderline(true);		
        this.contneedReson.setVisible(true);
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
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // billSate		
        this.billSate.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billSate.setRequired(false);
        // txtneedReson		
        this.txtneedReson.setHorizontalAlignment(2);		
        this.txtneedReson.setMaxLength(255);		
        this.txtneedReson.setRequired(false);		
        this.txtneedReson.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));		
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));		
        this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_fauditing"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,billSate,txtDescription,chkifNeed,txtneedReson,kDDateCreateTime,prmtCreator,prmtAuditor,kDDateLastUpdateTime,prmtLastUpdateUser,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 514));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 514));
        contCreator.setBounds(new Rectangle(11, 482, 227, 19));
        this.add(contCreator, new KDLayout.Constraints(11, 482, 227, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(264, 482, 227, 19));
        this.add(contCreateTime, new KDLayout.Constraints(264, 482, 227, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(12, 526, 223, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(12, 526, 223, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(266, 522, 223, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(266, 522, 223, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(4, 6, 277, 19));
        this.add(contNumber, new KDLayout.Constraints(4, 6, 277, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(359, 6, 277, 19));
        this.add(contBizDate, new KDLayout.Constraints(359, 6, 277, 19, 0));
        contDescription.setBounds(new Rectangle(4, 30, 990, 19));
        this.add(contDescription, new KDLayout.Constraints(4, 30, 990, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(517, 482, 227, 19));
        this.add(contAuditor, new KDLayout.Constraints(517, 482, 227, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(4, 80, 991, 392));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.certificates.DoubEcEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(4, 80, 991, 392, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("genDers",new Integer(1));
vo.put("type","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contbillSate.setBounds(new Rectangle(714, 7, 277, 19));
        this.add(contbillSate, new KDLayout.Constraints(714, 7, 277, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkifNeed.setBounds(new Rectangle(4, 57, 140, 19));
        this.add(chkifNeed, new KDLayout.Constraints(4, 57, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contneedReson.setBounds(new Rectangle(363, 55, 631, 19));
        this.add(contneedReson, new KDLayout.Constraints(363, 55, 631, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contbillSate
        contbillSate.setBoundEditor(billSate);
        //contneedReson
        contneedReson.setBoundEditor(txtneedReson);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.certificates.DoubEcEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.name", String.class, this.kdtEntrys, "name.text");
		dataBinder.registerBinding("entrys.IdNum", String.class, this.kdtEntrys, "IdNum.text");
		dataBinder.registerBinding("entrys.passpNo", String.class, this.kdtEntrys, "passpNo.text");
		dataBinder.registerBinding("entrys.notiDate", java.util.Date.class, this.kdtEntrys, "notiDate.text");
		dataBinder.registerBinding("entrys.notaDate", java.util.Date.class, this.kdtEntrys, "notaDate.text");
		dataBinder.registerBinding("entrys.qualSendDate", java.util.Date.class, this.kdtEntrys, "qualSendDate.text");
		dataBinder.registerBinding("entrys.qualDate", java.util.Date.class, this.kdtEntrys, "qualDate.text");
		dataBinder.registerBinding("entrys.stopRes", String.class, this.kdtEntrys, "stopRes.text");
		dataBinder.registerBinding("entrys.stopTime", java.util.Date.class, this.kdtEntrys, "stopTime.text");
		dataBinder.registerBinding("entrys.partner", java.lang.Object.class, this.kdtEntrys, "partner.text");
		dataBinder.registerBinding("entrys.taskProj", java.lang.Object.class, this.kdtEntrys, "taskProj.text");
		dataBinder.registerBinding("entrys.pmtProj", java.lang.Object.class, this.kdtEntrys, "pmtProj.text");
		dataBinder.registerBinding("entrys.type", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "type.text");
		dataBinder.registerBinding("entrys.pmtProf", java.lang.Object.class, this.kdtEntrys, "pmtProf.text");
		dataBinder.registerBinding("entrys.genDers", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "genDers.text");
		dataBinder.registerBinding("entrys.qualbaNum", String.class, this.kdtEntrys, "qualbaNum.text");
		dataBinder.registerBinding("entrys.desCription", String.class, this.kdtEntrys, "desCription.text");
		dataBinder.registerBinding("entrys.actProf", String.class, this.kdtEntrys, "actProf.text");
		dataBinder.registerBinding("entrys.ifstop", boolean.class, this.kdtEntrys, "ifstop.text");
		dataBinder.registerBinding("entrys.isIfilentry", boolean.class, this.kdtEntrys, "isIfilentry.text");
		dataBinder.registerBinding("entrys.sourceEntryID", String.class, this.kdtEntrys, "sourceEntryID.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.namePY", String.class, this.kdtEntrys, "namePY.text");
		dataBinder.registerBinding("entrys.birthdate", java.util.Date.class, this.kdtEntrys, "birthdate.text");
		dataBinder.registerBinding("entrys.birthPlaceCn", String.class, this.kdtEntrys, "birthPlaceCn.text");
		dataBinder.registerBinding("entrys.birthPlaceFr", String.class, this.kdtEntrys, "birthPlaceFr.text");
		dataBinder.registerBinding("entrys.pmtProfFr", String.class, this.kdtEntrys, "pmtProfFr.text");
		dataBinder.registerBinding("entrys.natioNal", java.lang.Object.class, this.kdtEntrys, "natioNal.text");
		dataBinder.registerBinding("entrys.workSuffer", int.class, this.kdtEntrys, "workSuffer.text");
		dataBinder.registerBinding("entrys.copies", int.class, this.kdtEntrys, "copies.text");
		dataBinder.registerBinding("entrys.assignDate", java.util.Date.class, this.kdtEntrys, "assignDate.text");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.oldEtyId", String.class, this.kdtEntrys, "oldEtyId.text");
		dataBinder.registerBinding("entrys.wkPmtGet", boolean.class, this.kdtEntrys, "wkPmtGet.text");
		dataBinder.registerBinding("entrys.wpCopies", int.class, this.kdtEntrys, "wpCopies.text");
		dataBinder.registerBinding("entrys.pmtFiDate", java.util.Date.class, this.kdtEntrys, "pmtFiDate.text");
		dataBinder.registerBinding("entrys.dbFiDate", java.util.Date.class, this.kdtEntrys, "dbFiDate.text");
		dataBinder.registerBinding("ifNeed", boolean.class, this.chkifNeed, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billSate", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSate, "selectedItem");
		dataBinder.registerBinding("needReson", String.class, this.txtneedReson, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.certificates.app.DoubEcEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.certificates.DoubEcInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IdNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.notiDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.notaDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qualSendDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qualDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stopRes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stopTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.partner", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.taskProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.type", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.genDers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qualbaNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.desCription", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ifstop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isIfilentry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sourceEntryID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.namePY", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceCn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProfFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.natioNal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workSuffer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.copies", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.assignDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oldEtyId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wkPmtGet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wpCopies", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtFiDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dbFiDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ifNeed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("needReson", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.IdNum"));
    	sic.add(new SelectorItemInfo("entrys.passpNo"));
    	sic.add(new SelectorItemInfo("entrys.notiDate"));
    	sic.add(new SelectorItemInfo("entrys.notaDate"));
    	sic.add(new SelectorItemInfo("entrys.qualSendDate"));
    	sic.add(new SelectorItemInfo("entrys.qualDate"));
    	sic.add(new SelectorItemInfo("entrys.stopRes"));
    	sic.add(new SelectorItemInfo("entrys.stopTime"));
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
    	sic.add(new SelectorItemInfo("entrys.type"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.pmtProf.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.pmtProf.id"));
			sic.add(new SelectorItemInfo("entrys.pmtProf.name"));
        	sic.add(new SelectorItemInfo("entrys.pmtProf.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.genDers"));
    	sic.add(new SelectorItemInfo("entrys.qualbaNum"));
    	sic.add(new SelectorItemInfo("entrys.desCription"));
    	sic.add(new SelectorItemInfo("entrys.actProf"));
    	sic.add(new SelectorItemInfo("entrys.ifstop"));
    	sic.add(new SelectorItemInfo("entrys.isIfilentry"));
    	sic.add(new SelectorItemInfo("entrys.sourceEntryID"));
    	sic.add(new SelectorItemInfo("entrys.personID"));
    	sic.add(new SelectorItemInfo("entrys.namePY"));
    	sic.add(new SelectorItemInfo("entrys.birthdate"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceCn"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceFr"));
    	sic.add(new SelectorItemInfo("entrys.pmtProfFr"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.natioNal.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.natioNal.id"));
			sic.add(new SelectorItemInfo("entrys.natioNal.name"));
        	sic.add(new SelectorItemInfo("entrys.natioNal.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.workSuffer"));
    	sic.add(new SelectorItemInfo("entrys.copies"));
    	sic.add(new SelectorItemInfo("entrys.assignDate"));
    	sic.add(new SelectorItemInfo("entrys.lastName"));
    	sic.add(new SelectorItemInfo("entrys.firstName"));
    	sic.add(new SelectorItemInfo("entrys.oldEtyId"));
    	sic.add(new SelectorItemInfo("entrys.wkPmtGet"));
    	sic.add(new SelectorItemInfo("entrys.wpCopies"));
    	sic.add(new SelectorItemInfo("entrys.pmtFiDate"));
    	sic.add(new SelectorItemInfo("entrys.dbFiDate"));
        sic.add(new SelectorItemInfo("ifNeed"));
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
        sic.add(new SelectorItemInfo("billSate"));
        sic.add(new SelectorItemInfo("needReson"));
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
            innerActionPerformed("eas", AbstractDoubEcEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractDoubEcEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.certificates.client", "DoubEcEditUI");
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
        return com.kingdee.eas.zjlw.certificates.client.DoubEcEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.DoubEcFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.DoubEcInfo objectValue = new com.kingdee.eas.zjlw.certificates.DoubEcInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/certificates/DoubEc";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.certificates.app.DoubEcQuery");
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