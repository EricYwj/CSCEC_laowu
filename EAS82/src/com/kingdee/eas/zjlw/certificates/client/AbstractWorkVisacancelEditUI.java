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
public abstract class AbstractWorkVisacancelEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractWorkVisacancelEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contISubmitor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contISubtime;
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
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtISubmitor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkISubtime;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractWorkVisacancelEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractWorkVisacancelEditUI.class.getName());
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
        this.contISubmitor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contISubtime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.prmtISubmitor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkISubtime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
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
        this.contISubmitor.setName("contISubmitor");
        this.contISubtime.setName("contISubtime");
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
        this.prmtISubmitor.setName("prmtISubmitor");
        this.pkISubtime.setName("pkISubtime");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.btnAddNew.setVisible(false);		
        this.btnEdit.setVisible(false);		
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol21\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bornDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"natioNal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"passpNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"prmtPro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workPro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"partner\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"laborSignNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"antiEndTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"docAffiliated\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isCancel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cancelDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"stopRsn\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IdNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"desCription\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"passoTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"passpDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"pmtProfc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"cuproff\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"actProff\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"anSgetDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"vgetTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"vSentTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"vcompTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"vsTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"veTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"sourceEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{bornDate}</t:Cell><t:Cell>$Resource{natioNal}</t:Cell><t:Cell>$Resource{passpNo}</t:Cell><t:Cell>$Resource{prmtPro}</t:Cell><t:Cell>$Resource{workPro}</t:Cell><t:Cell>$Resource{partner}</t:Cell><t:Cell>$Resource{laborSignNo}</t:Cell><t:Cell>$Resource{antiEndTime}</t:Cell><t:Cell>$Resource{docAffiliated}</t:Cell><t:Cell>$Resource{isCancel}</t:Cell><t:Cell>$Resource{cancelDate}</t:Cell><t:Cell>$Resource{stopRsn}</t:Cell><t:Cell>$Resource{IdNum}</t:Cell><t:Cell>$Resource{desCription}</t:Cell><t:Cell>$Resource{passoTime}</t:Cell><t:Cell>$Resource{passpDate}</t:Cell><t:Cell>$Resource{pmtProfc}</t:Cell><t:Cell>$Resource{cuproff}</t:Cell><t:Cell>$Resource{actProff}</t:Cell><t:Cell>$Resource{anSgetDate}</t:Cell><t:Cell>$Resource{vgetTime}</t:Cell><t:Cell>$Resource{vSentTime}</t:Cell><t:Cell>$Resource{vcompTime}</t:Cell><t:Cell>$Resource{vsTime}</t:Cell><t:Cell>$Resource{veTime}</t:Cell><t:Cell>$Resource{sourceEntryID}</t:Cell><t:Cell>$Resource{personID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","name","sex","bornDate","natioNal","passpNo","prmtPro","workPro","partner","laborSignNo","antiEndTime","docAffiliated","isCancel","cancelDate","stopRsn","IdNum","desCription","passoTime","passpDate","pmtProfc","cuproff","actProff","anSgetDate","vgetTime","vSentTime","vcompTime","vsTime","veTime","sourceEntryID","personID"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_name_TextField = new KDTextField();
        kdtEntrys_name_TextField.setName("kdtEntrys_name_TextField");
        kdtEntrys_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_name_CellEditor = new KDTDefaultCellEditor(kdtEntrys_name_TextField);
        this.kdtEntrys.getColumn("name").setEditor(kdtEntrys_name_CellEditor);
        KDComboBox kdtEntrys_sex_ComboBox = new KDComboBox();
        kdtEntrys_sex_ComboBox.setName("kdtEntrys_sex_ComboBox");
        kdtEntrys_sex_ComboBox.setVisible(true);
        kdtEntrys_sex_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());
        KDTDefaultCellEditor kdtEntrys_sex_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sex_ComboBox);
        this.kdtEntrys.getColumn("sex").setEditor(kdtEntrys_sex_CellEditor);
        KDDatePicker kdtEntrys_bornDate_DatePicker = new KDDatePicker();
        kdtEntrys_bornDate_DatePicker.setName("kdtEntrys_bornDate_DatePicker");
        kdtEntrys_bornDate_DatePicker.setVisible(true);
        kdtEntrys_bornDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_bornDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bornDate_DatePicker);
        this.kdtEntrys.getColumn("bornDate").setEditor(kdtEntrys_bornDate_CellEditor);
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
        final KDBizPromptBox kdtEntrys_prmtPro_PromptBox = new KDBizPromptBox();
        kdtEntrys_prmtPro_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_prmtPro_PromptBox.setVisible(true);
        kdtEntrys_prmtPro_PromptBox.setEditable(true);
        kdtEntrys_prmtPro_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_prmtPro_PromptBox.setEditFormat("$number$");
        kdtEntrys_prmtPro_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_prmtPro_CellEditor = new KDTDefaultCellEditor(kdtEntrys_prmtPro_PromptBox);
        this.kdtEntrys.getColumn("prmtPro").setEditor(kdtEntrys_prmtPro_CellEditor);
        ObjectValueRender kdtEntrys_prmtPro_OVR = new ObjectValueRender();
        kdtEntrys_prmtPro_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("prmtPro").setRenderer(kdtEntrys_prmtPro_OVR);
        final KDBizPromptBox kdtEntrys_workPro_PromptBox = new KDBizPromptBox();
        kdtEntrys_workPro_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_workPro_PromptBox.setVisible(true);
        kdtEntrys_workPro_PromptBox.setEditable(true);
        kdtEntrys_workPro_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_workPro_PromptBox.setEditFormat("$number$");
        kdtEntrys_workPro_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_workPro_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workPro_PromptBox);
        this.kdtEntrys.getColumn("workPro").setEditor(kdtEntrys_workPro_CellEditor);
        ObjectValueRender kdtEntrys_workPro_OVR = new ObjectValueRender();
        kdtEntrys_workPro_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("workPro").setRenderer(kdtEntrys_workPro_OVR);
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
        KDTextField kdtEntrys_laborSignNo_TextField = new KDTextField();
        kdtEntrys_laborSignNo_TextField.setName("kdtEntrys_laborSignNo_TextField");
        kdtEntrys_laborSignNo_TextField.setMaxLength(50);
        KDTDefaultCellEditor kdtEntrys_laborSignNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_laborSignNo_TextField);
        this.kdtEntrys.getColumn("laborSignNo").setEditor(kdtEntrys_laborSignNo_CellEditor);
        KDDatePicker kdtEntrys_antiEndTime_DatePicker = new KDDatePicker();
        kdtEntrys_antiEndTime_DatePicker.setName("kdtEntrys_antiEndTime_DatePicker");
        kdtEntrys_antiEndTime_DatePicker.setVisible(true);
        kdtEntrys_antiEndTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_antiEndTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_antiEndTime_DatePicker);
        this.kdtEntrys.getColumn("antiEndTime").setEditor(kdtEntrys_antiEndTime_CellEditor);
        KDCheckBox kdtEntrys_docAffiliated_CheckBox = new KDCheckBox();
        kdtEntrys_docAffiliated_CheckBox.setName("kdtEntrys_docAffiliated_CheckBox");
        KDTDefaultCellEditor kdtEntrys_docAffiliated_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docAffiliated_CheckBox);
        this.kdtEntrys.getColumn("docAffiliated").setEditor(kdtEntrys_docAffiliated_CellEditor);
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
        KDTextField kdtEntrys_stopRsn_TextField = new KDTextField();
        kdtEntrys_stopRsn_TextField.setName("kdtEntrys_stopRsn_TextField");
        kdtEntrys_stopRsn_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_stopRsn_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stopRsn_TextField);
        this.kdtEntrys.getColumn("stopRsn").setEditor(kdtEntrys_stopRsn_CellEditor);
        KDTextField kdtEntrys_IdNum_TextField = new KDTextField();
        kdtEntrys_IdNum_TextField.setName("kdtEntrys_IdNum_TextField");
        kdtEntrys_IdNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_IdNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IdNum_TextField);
        this.kdtEntrys.getColumn("IdNum").setEditor(kdtEntrys_IdNum_CellEditor);
        KDTextField kdtEntrys_desCription_TextField = new KDTextField();
        kdtEntrys_desCription_TextField.setName("kdtEntrys_desCription_TextField");
        kdtEntrys_desCription_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_desCription_CellEditor = new KDTDefaultCellEditor(kdtEntrys_desCription_TextField);
        this.kdtEntrys.getColumn("desCription").setEditor(kdtEntrys_desCription_CellEditor);
        KDDatePicker kdtEntrys_passoTime_DatePicker = new KDDatePicker();
        kdtEntrys_passoTime_DatePicker.setName("kdtEntrys_passoTime_DatePicker");
        kdtEntrys_passoTime_DatePicker.setVisible(true);
        kdtEntrys_passoTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passoTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passoTime_DatePicker);
        this.kdtEntrys.getColumn("passoTime").setEditor(kdtEntrys_passoTime_CellEditor);
        KDDatePicker kdtEntrys_passpDate_DatePicker = new KDDatePicker();
        kdtEntrys_passpDate_DatePicker.setName("kdtEntrys_passpDate_DatePicker");
        kdtEntrys_passpDate_DatePicker.setVisible(true);
        kdtEntrys_passpDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passpDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passpDate_DatePicker);
        this.kdtEntrys.getColumn("passpDate").setEditor(kdtEntrys_passpDate_CellEditor);
        final KDBizPromptBox kdtEntrys_pmtProfc_PromptBox = new KDBizPromptBox();
        kdtEntrys_pmtProfc_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");
        kdtEntrys_pmtProfc_PromptBox.setVisible(true);
        kdtEntrys_pmtProfc_PromptBox.setEditable(true);
        kdtEntrys_pmtProfc_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_pmtProfc_PromptBox.setEditFormat("$number$");
        kdtEntrys_pmtProfc_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_pmtProfc_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProfc_PromptBox);
        this.kdtEntrys.getColumn("pmtProfc").setEditor(kdtEntrys_pmtProfc_CellEditor);
        ObjectValueRender kdtEntrys_pmtProfc_OVR = new ObjectValueRender();
        kdtEntrys_pmtProfc_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("pmtProfc").setRenderer(kdtEntrys_pmtProfc_OVR);
        KDTextField kdtEntrys_cuproff_TextField = new KDTextField();
        kdtEntrys_cuproff_TextField.setName("kdtEntrys_cuproff_TextField");
        kdtEntrys_cuproff_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_cuproff_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cuproff_TextField);
        this.kdtEntrys.getColumn("cuproff").setEditor(kdtEntrys_cuproff_CellEditor);
        KDTextField kdtEntrys_actProff_TextField = new KDTextField();
        kdtEntrys_actProff_TextField.setName("kdtEntrys_actProff_TextField");
        kdtEntrys_actProff_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_actProff_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actProff_TextField);
        this.kdtEntrys.getColumn("actProff").setEditor(kdtEntrys_actProff_CellEditor);
        KDDatePicker kdtEntrys_anSgetDate_DatePicker = new KDDatePicker();
        kdtEntrys_anSgetDate_DatePicker.setName("kdtEntrys_anSgetDate_DatePicker");
        kdtEntrys_anSgetDate_DatePicker.setVisible(true);
        kdtEntrys_anSgetDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_anSgetDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_anSgetDate_DatePicker);
        this.kdtEntrys.getColumn("anSgetDate").setEditor(kdtEntrys_anSgetDate_CellEditor);
        KDDatePicker kdtEntrys_vgetTime_DatePicker = new KDDatePicker();
        kdtEntrys_vgetTime_DatePicker.setName("kdtEntrys_vgetTime_DatePicker");
        kdtEntrys_vgetTime_DatePicker.setVisible(true);
        kdtEntrys_vgetTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_vgetTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vgetTime_DatePicker);
        this.kdtEntrys.getColumn("vgetTime").setEditor(kdtEntrys_vgetTime_CellEditor);
        KDDatePicker kdtEntrys_vSentTime_DatePicker = new KDDatePicker();
        kdtEntrys_vSentTime_DatePicker.setName("kdtEntrys_vSentTime_DatePicker");
        kdtEntrys_vSentTime_DatePicker.setVisible(true);
        kdtEntrys_vSentTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_vSentTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vSentTime_DatePicker);
        this.kdtEntrys.getColumn("vSentTime").setEditor(kdtEntrys_vSentTime_CellEditor);
        KDDatePicker kdtEntrys_vcompTime_DatePicker = new KDDatePicker();
        kdtEntrys_vcompTime_DatePicker.setName("kdtEntrys_vcompTime_DatePicker");
        kdtEntrys_vcompTime_DatePicker.setVisible(true);
        kdtEntrys_vcompTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_vcompTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vcompTime_DatePicker);
        this.kdtEntrys.getColumn("vcompTime").setEditor(kdtEntrys_vcompTime_CellEditor);
        KDDatePicker kdtEntrys_vsTime_DatePicker = new KDDatePicker();
        kdtEntrys_vsTime_DatePicker.setName("kdtEntrys_vsTime_DatePicker");
        kdtEntrys_vsTime_DatePicker.setVisible(true);
        kdtEntrys_vsTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_vsTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vsTime_DatePicker);
        this.kdtEntrys.getColumn("vsTime").setEditor(kdtEntrys_vsTime_CellEditor);
        KDDatePicker kdtEntrys_veTime_DatePicker = new KDDatePicker();
        kdtEntrys_veTime_DatePicker.setName("kdtEntrys_veTime_DatePicker");
        kdtEntrys_veTime_DatePicker.setVisible(true);
        kdtEntrys_veTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_veTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_veTime_DatePicker);
        this.kdtEntrys.getColumn("veTime").setEditor(kdtEntrys_veTime_CellEditor);
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
        // contISubmitor		
        this.contISubmitor.setBoundLabelText(resHelper.getString("contISubmitor.boundLabelText"));		
        this.contISubmitor.setBoundLabelLength(100);		
        this.contISubmitor.setBoundLabelUnderline(true);		
        this.contISubmitor.setVisible(true);
        // contISubtime		
        this.contISubtime.setBoundLabelText(resHelper.getString("contISubtime.boundLabelText"));		
        this.contISubtime.setBoundLabelLength(100);		
        this.contISubtime.setBoundLabelUnderline(true);		
        this.contISubtime.setVisible(true);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);
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
        this.pkBizDate.setEnabled(false);
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
        // prmtISubmitor		
        this.prmtISubmitor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtISubmitor.setEditable(true);		
        this.prmtISubmitor.setDisplayFormat("$number$");		
        this.prmtISubmitor.setEditFormat("$number$");		
        this.prmtISubmitor.setCommitFormat("$number$");		
        this.prmtISubmitor.setRequired(false);		
        this.prmtISubmitor.setEnabled(false);
        // pkISubtime		
        this.pkISubtime.setRequired(false);		
        this.pkISubtime.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));		
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));		
        this.btnAudit.setVisible(false);
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));		
        this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_fauditing"));		
        this.btnUnAudit.setVisible(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtbNum,billSate,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditDate,prmtISubmitor,pkISubtime,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 515));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 515));
        contCreator.setBounds(new Rectangle(9, 486, 215, 19));
        this.add(contCreator, new KDLayout.Constraints(9, 486, 215, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(266, 486, 215, 19));
        this.add(contCreateTime, new KDLayout.Constraints(266, 486, 215, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(-23, 575, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(-23, 575, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(266, 582, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(266, 582, 270, 19, 0));
        contNumber.setBounds(new Rectangle(9, 10, 228, 19));
        this.add(contNumber, new KDLayout.Constraints(9, 10, 228, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(263, 10, 228, 19));
        this.add(contBizDate, new KDLayout.Constraints(263, 10, 228, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(517, 41, 482, 19));
        this.add(contDescription, new KDLayout.Constraints(517, 41, 482, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(523, 486, 215, 19));
        this.add(contAuditor, new KDLayout.Constraints(523, 486, 215, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(9, 68, 991, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.certificates.WorkVisacancelEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(9, 68, 991, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("sex",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contbNum.setBounds(new Rectangle(769, 10, 228, 19));
        this.add(contbNum, new KDLayout.Constraints(769, 10, 228, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditDate.setBounds(new Rectangle(781, 486, 215, 19));
        this.add(contauditDate, new KDLayout.Constraints(781, 486, 215, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillSate.setBounds(new Rectangle(517, 10, 228, 19));
        this.add(contbillSate, new KDLayout.Constraints(517, 10, 228, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contISubmitor.setBounds(new Rectangle(263, 41, 228, 19));
        this.add(contISubmitor, new KDLayout.Constraints(263, 41, 228, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contISubtime.setBounds(new Rectangle(9, 41, 228, 19));
        this.add(contISubtime, new KDLayout.Constraints(9, 41, 228, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
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
        //contISubmitor
        contISubmitor.setBoundEditor(prmtISubmitor);
        //contISubtime
        contISubtime.setBoundEditor(pkISubtime);

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
        this.toolBar.add(btnSubmit);
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.certificates.WorkVisacancelEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.name", String.class, this.kdtEntrys, "name.text");
		dataBinder.registerBinding("entrys.sex", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "sex.text");
		dataBinder.registerBinding("entrys.IdNum", String.class, this.kdtEntrys, "IdNum.text");
		dataBinder.registerBinding("entrys.passpNo", String.class, this.kdtEntrys, "passpNo.text");
		dataBinder.registerBinding("entrys.vgetTime", java.util.Date.class, this.kdtEntrys, "vgetTime.text");
		dataBinder.registerBinding("entrys.anSgetDate", java.util.Date.class, this.kdtEntrys, "anSgetDate.text");
		dataBinder.registerBinding("entrys.passpDate", java.util.Date.class, this.kdtEntrys, "passpDate.text");
		dataBinder.registerBinding("entrys.vSentTime", java.util.Date.class, this.kdtEntrys, "vSentTime.text");
		dataBinder.registerBinding("entrys.vcompTime", java.util.Date.class, this.kdtEntrys, "vcompTime.text");
		dataBinder.registerBinding("entrys.vsTime", java.util.Date.class, this.kdtEntrys, "vsTime.text");
		dataBinder.registerBinding("entrys.veTime", java.util.Date.class, this.kdtEntrys, "veTime.text");
		dataBinder.registerBinding("entrys.partner", java.lang.Object.class, this.kdtEntrys, "partner.text");
		dataBinder.registerBinding("entrys.pmtProfc", java.lang.Object.class, this.kdtEntrys, "pmtProfc.text");
		dataBinder.registerBinding("entrys.cuproff", String.class, this.kdtEntrys, "cuproff.text");
		dataBinder.registerBinding("entrys.actProff", String.class, this.kdtEntrys, "actProff.text");
		dataBinder.registerBinding("entrys.bornDate", java.util.Date.class, this.kdtEntrys, "bornDate.text");
		dataBinder.registerBinding("entrys.passoTime", java.util.Date.class, this.kdtEntrys, "passoTime.text");
		dataBinder.registerBinding("entrys.prmtPro", java.lang.Object.class, this.kdtEntrys, "prmtPro.text");
		dataBinder.registerBinding("entrys.workPro", java.lang.Object.class, this.kdtEntrys, "workPro.text");
		dataBinder.registerBinding("entrys.desCription", String.class, this.kdtEntrys, "desCription.text");
		dataBinder.registerBinding("entrys.sourceEntryID", String.class, this.kdtEntrys, "sourceEntryID.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.natioNal", java.lang.Object.class, this.kdtEntrys, "natioNal.text");
		dataBinder.registerBinding("entrys.laborSignNo", String.class, this.kdtEntrys, "laborSignNo.text");
		dataBinder.registerBinding("entrys.antiEndTime", java.util.Date.class, this.kdtEntrys, "antiEndTime.text");
		dataBinder.registerBinding("entrys.docAffiliated", boolean.class, this.kdtEntrys, "docAffiliated.text");
		dataBinder.registerBinding("entrys.isCancel", boolean.class, this.kdtEntrys, "isCancel.text");
		dataBinder.registerBinding("entrys.cancelDate", java.util.Date.class, this.kdtEntrys, "cancelDate.text");
		dataBinder.registerBinding("entrys.stopRsn", String.class, this.kdtEntrys, "stopRsn.text");
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
		dataBinder.registerBinding("ISubmitor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtISubmitor, "data");
		dataBinder.registerBinding("ISubtime", java.util.Date.class, this.pkISubtime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.certificates.app.WorkVisacancelEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IdNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vgetTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.anSgetDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vSentTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vcompTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vsTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.veTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.partner", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProfc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cuproff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actProff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bornDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passoTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.prmtPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.desCription", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sourceEntryID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.natioNal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.laborSignNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.antiEndTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docAffiliated", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isCancel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cancelDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stopRsn", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("ISubmitor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ISubtime", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
			sic.add(new SelectorItemInfo("entrys.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.sex"));
    	sic.add(new SelectorItemInfo("entrys.IdNum"));
    	sic.add(new SelectorItemInfo("entrys.passpNo"));
    	sic.add(new SelectorItemInfo("entrys.vgetTime"));
    	sic.add(new SelectorItemInfo("entrys.anSgetDate"));
    	sic.add(new SelectorItemInfo("entrys.passpDate"));
    	sic.add(new SelectorItemInfo("entrys.vSentTime"));
    	sic.add(new SelectorItemInfo("entrys.vcompTime"));
    	sic.add(new SelectorItemInfo("entrys.vsTime"));
    	sic.add(new SelectorItemInfo("entrys.veTime"));
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
			sic.add(new SelectorItemInfo("entrys.pmtProfc.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.pmtProfc.id"));
			sic.add(new SelectorItemInfo("entrys.pmtProfc.name"));
        	sic.add(new SelectorItemInfo("entrys.pmtProfc.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.cuproff"));
    	sic.add(new SelectorItemInfo("entrys.actProff"));
    	sic.add(new SelectorItemInfo("entrys.bornDate"));
    	sic.add(new SelectorItemInfo("entrys.passoTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.prmtPro.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.prmtPro.id"));
			sic.add(new SelectorItemInfo("entrys.prmtPro.name"));
        	sic.add(new SelectorItemInfo("entrys.prmtPro.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.workPro.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.workPro.id"));
			sic.add(new SelectorItemInfo("entrys.workPro.name"));
        	sic.add(new SelectorItemInfo("entrys.workPro.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.desCription"));
    	sic.add(new SelectorItemInfo("entrys.sourceEntryID"));
    	sic.add(new SelectorItemInfo("entrys.personID"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.natioNal.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.natioNal.id"));
			sic.add(new SelectorItemInfo("entrys.natioNal.name"));
        	sic.add(new SelectorItemInfo("entrys.natioNal.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.laborSignNo"));
    	sic.add(new SelectorItemInfo("entrys.antiEndTime"));
    	sic.add(new SelectorItemInfo("entrys.docAffiliated"));
    	sic.add(new SelectorItemInfo("entrys.isCancel"));
    	sic.add(new SelectorItemInfo("entrys.cancelDate"));
    	sic.add(new SelectorItemInfo("entrys.stopRsn"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ISubmitor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("ISubmitor.id"));
        	sic.add(new SelectorItemInfo("ISubmitor.number"));
        	sic.add(new SelectorItemInfo("ISubmitor.name"));
		}
        sic.add(new SelectorItemInfo("ISubtime"));
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
            innerActionPerformed("eas", AbstractWorkVisacancelEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractWorkVisacancelEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.certificates.client", "WorkVisacancelEditUI");
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
        return com.kingdee.eas.zjlw.certificates.client.WorkVisacancelEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.WorkVisacancelFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo objectValue = new com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/certificates/WorkVisacancel";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.certificates.app.WorkVisacancelQuery");
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