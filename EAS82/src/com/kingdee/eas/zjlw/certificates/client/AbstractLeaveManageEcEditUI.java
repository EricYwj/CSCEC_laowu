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
public abstract class AbstractLeaveManageEcEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractLeaveManageEcEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillSate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbNum;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbNum;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo editData = null;
    protected AcitonAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractLeaveManageEcEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractLeaveManageEcEditUI.class.getName());
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
        this.actionAudit = new AcitonAudit(this);
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
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillSate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.billSate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtbNum = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.contauditDate.setName("contauditDate");
        this.contbillSate.setName("contbillSate");
        this.contbNum.setName("contbNum");
        this.kDLabel1.setName("kDLabel1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditDate.setName("pkauditDate");
        this.billSate.setName("billSate");
        this.txtbNum.setName("txtbNum");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol22\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol25\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol28\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol37\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol38\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol39\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol41\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol43\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"sex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"birthday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"birthPlaceCn\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"birthPlaceFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"natioNal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"passpNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"passpIsDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"passpExDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"actProff\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"quProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"quproff\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"fatherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"fatherNameAl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"motherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"motherNameAl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"MaritalStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"immiTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"wPmtNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"wPmtSTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"docType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"rePmtNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"sRePmtSTime\" t:width=\"115\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"rePmtETime\" t:width=\"115\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"pmtNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"pmteffDate\" t:width=\"115\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"pmtETime\" t:width=\"115\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"leaveApply\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"exitTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"dptrGTime\" t:width=\"140\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"dptrETime\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"backTime\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"dptrTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"leaveType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"carryCertify\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"pmtProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"taskProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"cooperation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"idNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sourceEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"oldEtyId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{birthday}</t:Cell><t:Cell>$Resource{birthPlaceCn}</t:Cell><t:Cell>$Resource{birthPlaceFr}</t:Cell><t:Cell>$Resource{natioNal}</t:Cell><t:Cell>$Resource{passpNum}</t:Cell><t:Cell>$Resource{passpIsDate}</t:Cell><t:Cell>$Resource{passpExDate}</t:Cell><t:Cell>$Resource{actProff}</t:Cell><t:Cell>$Resource{quProf}</t:Cell><t:Cell>$Resource{quproff}</t:Cell><t:Cell>$Resource{fatherName}</t:Cell><t:Cell>$Resource{fatherNameAl}</t:Cell><t:Cell>$Resource{motherName}</t:Cell><t:Cell>$Resource{motherNameAl}</t:Cell><t:Cell>$Resource{MaritalStatus}</t:Cell><t:Cell>$Resource{immiTime}</t:Cell><t:Cell>$Resource{wPmtNum}</t:Cell><t:Cell>$Resource{wPmtSTime}</t:Cell><t:Cell>$Resource{docType}</t:Cell><t:Cell>$Resource{rePmtNum}</t:Cell><t:Cell>$Resource{sRePmtSTime}</t:Cell><t:Cell>$Resource{rePmtETime}</t:Cell><t:Cell>$Resource{pmtNum}</t:Cell><t:Cell>$Resource{pmteffDate}</t:Cell><t:Cell>$Resource{pmtETime}</t:Cell><t:Cell>$Resource{leaveApply}</t:Cell><t:Cell>$Resource{exitTime}</t:Cell><t:Cell>$Resource{dptrGTime}</t:Cell><t:Cell>$Resource{dptrETime}</t:Cell><t:Cell>$Resource{backTime}</t:Cell><t:Cell>$Resource{dptrTime}</t:Cell><t:Cell>$Resource{leaveType}</t:Cell><t:Cell>$Resource{carryCertify}</t:Cell><t:Cell>$Resource{pmtProj}</t:Cell><t:Cell>$Resource{taskProj}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{idNum}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{sourceEntryID}</t:Cell><t:Cell>$Resource{personID}</t:Cell><t:Cell>$Resource{oldEtyId}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","name","lastName","firstName","sex","birthday","birthPlaceCn","birthPlaceFr","natioNal","passpNum","passpIsDate","passpExDate","actProff","quProf","quproff","fatherName","fatherNameAl","motherName","motherNameAl","MaritalStatus","immiTime","wPmtNum","wPmtSTime","docType","rePmtNum","sRePmtSTime","rePmtETime","pmtNum","pmteffDate","pmtETime","leaveApply","exitTime","dptrGTime","dptrETime","backTime","dptrTime","leaveType","carryCertify","pmtProj","taskProj","cooperation","idNum","remark","sourceEntryID","personID","oldEtyId"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_name_TextField = new KDTextField();
        kdtEntrys_name_TextField.setName("kdtEntrys_name_TextField");
        kdtEntrys_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_name_CellEditor = new KDTDefaultCellEditor(kdtEntrys_name_TextField);
        this.kdtEntrys.getColumn("name").setEditor(kdtEntrys_name_CellEditor);
        KDTextField kdtEntrys_lastName_TextField = new KDTextField();
        kdtEntrys_lastName_TextField.setName("kdtEntrys_lastName_TextField");
        kdtEntrys_lastName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_lastName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lastName_TextField);
        this.kdtEntrys.getColumn("lastName").setEditor(kdtEntrys_lastName_CellEditor);
        KDTextField kdtEntrys_firstName_TextField = new KDTextField();
        kdtEntrys_firstName_TextField.setName("kdtEntrys_firstName_TextField");
        kdtEntrys_firstName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_firstName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_firstName_TextField);
        this.kdtEntrys.getColumn("firstName").setEditor(kdtEntrys_firstName_CellEditor);
        KDComboBox kdtEntrys_sex_ComboBox = new KDComboBox();
        kdtEntrys_sex_ComboBox.setName("kdtEntrys_sex_ComboBox");
        kdtEntrys_sex_ComboBox.setVisible(true);
        kdtEntrys_sex_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());
        KDTDefaultCellEditor kdtEntrys_sex_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sex_ComboBox);
        this.kdtEntrys.getColumn("sex").setEditor(kdtEntrys_sex_CellEditor);
        KDDatePicker kdtEntrys_birthday_DatePicker = new KDDatePicker();
        kdtEntrys_birthday_DatePicker.setName("kdtEntrys_birthday_DatePicker");
        kdtEntrys_birthday_DatePicker.setVisible(true);
        kdtEntrys_birthday_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_birthday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthday_DatePicker);
        this.kdtEntrys.getColumn("birthday").setEditor(kdtEntrys_birthday_CellEditor);
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
        KDTextField kdtEntrys_passpNum_TextField = new KDTextField();
        kdtEntrys_passpNum_TextField.setName("kdtEntrys_passpNum_TextField");
        kdtEntrys_passpNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_passpNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passpNum_TextField);
        this.kdtEntrys.getColumn("passpNum").setEditor(kdtEntrys_passpNum_CellEditor);
        KDDatePicker kdtEntrys_passpIsDate_DatePicker = new KDDatePicker();
        kdtEntrys_passpIsDate_DatePicker.setName("kdtEntrys_passpIsDate_DatePicker");
        kdtEntrys_passpIsDate_DatePicker.setVisible(true);
        kdtEntrys_passpIsDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passpIsDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passpIsDate_DatePicker);
        this.kdtEntrys.getColumn("passpIsDate").setEditor(kdtEntrys_passpIsDate_CellEditor);
        KDDatePicker kdtEntrys_passpExDate_DatePicker = new KDDatePicker();
        kdtEntrys_passpExDate_DatePicker.setName("kdtEntrys_passpExDate_DatePicker");
        kdtEntrys_passpExDate_DatePicker.setVisible(true);
        kdtEntrys_passpExDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passpExDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passpExDate_DatePicker);
        this.kdtEntrys.getColumn("passpExDate").setEditor(kdtEntrys_passpExDate_CellEditor);
        KDTextField kdtEntrys_actProff_TextField = new KDTextField();
        kdtEntrys_actProff_TextField.setName("kdtEntrys_actProff_TextField");
        kdtEntrys_actProff_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_actProff_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actProff_TextField);
        this.kdtEntrys.getColumn("actProff").setEditor(kdtEntrys_actProff_CellEditor);
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
        KDTextField kdtEntrys_quproff_TextField = new KDTextField();
        kdtEntrys_quproff_TextField.setName("kdtEntrys_quproff_TextField");
        kdtEntrys_quproff_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_quproff_CellEditor = new KDTDefaultCellEditor(kdtEntrys_quproff_TextField);
        this.kdtEntrys.getColumn("quproff").setEditor(kdtEntrys_quproff_CellEditor);
        KDTextField kdtEntrys_fatherName_TextField = new KDTextField();
        kdtEntrys_fatherName_TextField.setName("kdtEntrys_fatherName_TextField");
        kdtEntrys_fatherName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_fatherName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fatherName_TextField);
        this.kdtEntrys.getColumn("fatherName").setEditor(kdtEntrys_fatherName_CellEditor);
        KDTextField kdtEntrys_fatherNameAl_TextField = new KDTextField();
        kdtEntrys_fatherNameAl_TextField.setName("kdtEntrys_fatherNameAl_TextField");
        kdtEntrys_fatherNameAl_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_fatherNameAl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fatherNameAl_TextField);
        this.kdtEntrys.getColumn("fatherNameAl").setEditor(kdtEntrys_fatherNameAl_CellEditor);
        KDTextField kdtEntrys_motherName_TextField = new KDTextField();
        kdtEntrys_motherName_TextField.setName("kdtEntrys_motherName_TextField");
        kdtEntrys_motherName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_motherName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_motherName_TextField);
        this.kdtEntrys.getColumn("motherName").setEditor(kdtEntrys_motherName_CellEditor);
        KDTextField kdtEntrys_motherNameAl_TextField = new KDTextField();
        kdtEntrys_motherNameAl_TextField.setName("kdtEntrys_motherNameAl_TextField");
        kdtEntrys_motherNameAl_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_motherNameAl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_motherNameAl_TextField);
        this.kdtEntrys.getColumn("motherNameAl").setEditor(kdtEntrys_motherNameAl_CellEditor);
        KDComboBox kdtEntrys_MaritalStatus_ComboBox = new KDComboBox();
        kdtEntrys_MaritalStatus_ComboBox.setName("kdtEntrys_MaritalStatus_ComboBox");
        kdtEntrys_MaritalStatus_ComboBox.setVisible(true);
        kdtEntrys_MaritalStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.mayrStatEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_MaritalStatus_CellEditor = new KDTDefaultCellEditor(kdtEntrys_MaritalStatus_ComboBox);
        this.kdtEntrys.getColumn("MaritalStatus").setEditor(kdtEntrys_MaritalStatus_CellEditor);
        KDDatePicker kdtEntrys_immiTime_DatePicker = new KDDatePicker();
        kdtEntrys_immiTime_DatePicker.setName("kdtEntrys_immiTime_DatePicker");
        kdtEntrys_immiTime_DatePicker.setVisible(true);
        kdtEntrys_immiTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_immiTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_immiTime_DatePicker);
        this.kdtEntrys.getColumn("immiTime").setEditor(kdtEntrys_immiTime_CellEditor);
        KDTextField kdtEntrys_wPmtNum_TextField = new KDTextField();
        kdtEntrys_wPmtNum_TextField.setName("kdtEntrys_wPmtNum_TextField");
        kdtEntrys_wPmtNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_wPmtNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wPmtNum_TextField);
        this.kdtEntrys.getColumn("wPmtNum").setEditor(kdtEntrys_wPmtNum_CellEditor);
        KDDatePicker kdtEntrys_wPmtSTime_DatePicker = new KDDatePicker();
        kdtEntrys_wPmtSTime_DatePicker.setName("kdtEntrys_wPmtSTime_DatePicker");
        kdtEntrys_wPmtSTime_DatePicker.setVisible(true);
        kdtEntrys_wPmtSTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_wPmtSTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wPmtSTime_DatePicker);
        this.kdtEntrys.getColumn("wPmtSTime").setEditor(kdtEntrys_wPmtSTime_CellEditor);
        KDComboBox kdtEntrys_docType_ComboBox = new KDComboBox();
        kdtEntrys_docType_ComboBox.setName("kdtEntrys_docType_ComboBox");
        kdtEntrys_docType_ComboBox.setVisible(true);
        kdtEntrys_docType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.DOCTYPE").toArray());
        KDTDefaultCellEditor kdtEntrys_docType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docType_ComboBox);
        this.kdtEntrys.getColumn("docType").setEditor(kdtEntrys_docType_CellEditor);
        KDTextField kdtEntrys_rePmtNum_TextField = new KDTextField();
        kdtEntrys_rePmtNum_TextField.setName("kdtEntrys_rePmtNum_TextField");
        kdtEntrys_rePmtNum_TextField.setMaxLength(60);
        KDTDefaultCellEditor kdtEntrys_rePmtNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_rePmtNum_TextField);
        this.kdtEntrys.getColumn("rePmtNum").setEditor(kdtEntrys_rePmtNum_CellEditor);
        KDDatePicker kdtEntrys_sRePmtSTime_DatePicker = new KDDatePicker();
        kdtEntrys_sRePmtSTime_DatePicker.setName("kdtEntrys_sRePmtSTime_DatePicker");
        kdtEntrys_sRePmtSTime_DatePicker.setVisible(true);
        kdtEntrys_sRePmtSTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_sRePmtSTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sRePmtSTime_DatePicker);
        this.kdtEntrys.getColumn("sRePmtSTime").setEditor(kdtEntrys_sRePmtSTime_CellEditor);
        KDDatePicker kdtEntrys_rePmtETime_DatePicker = new KDDatePicker();
        kdtEntrys_rePmtETime_DatePicker.setName("kdtEntrys_rePmtETime_DatePicker");
        kdtEntrys_rePmtETime_DatePicker.setVisible(true);
        kdtEntrys_rePmtETime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_rePmtETime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_rePmtETime_DatePicker);
        this.kdtEntrys.getColumn("rePmtETime").setEditor(kdtEntrys_rePmtETime_CellEditor);
        KDTextField kdtEntrys_pmtNum_TextField = new KDTextField();
        kdtEntrys_pmtNum_TextField.setName("kdtEntrys_pmtNum_TextField");
        kdtEntrys_pmtNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_pmtNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtNum_TextField);
        this.kdtEntrys.getColumn("pmtNum").setEditor(kdtEntrys_pmtNum_CellEditor);
        KDDatePicker kdtEntrys_pmteffDate_DatePicker = new KDDatePicker();
        kdtEntrys_pmteffDate_DatePicker.setName("kdtEntrys_pmteffDate_DatePicker");
        kdtEntrys_pmteffDate_DatePicker.setVisible(true);
        kdtEntrys_pmteffDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_pmteffDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmteffDate_DatePicker);
        this.kdtEntrys.getColumn("pmteffDate").setEditor(kdtEntrys_pmteffDate_CellEditor);
        KDDatePicker kdtEntrys_pmtETime_DatePicker = new KDDatePicker();
        kdtEntrys_pmtETime_DatePicker.setName("kdtEntrys_pmtETime_DatePicker");
        kdtEntrys_pmtETime_DatePicker.setVisible(true);
        kdtEntrys_pmtETime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_pmtETime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtETime_DatePicker);
        this.kdtEntrys.getColumn("pmtETime").setEditor(kdtEntrys_pmtETime_CellEditor);
        KDDatePicker kdtEntrys_leaveApply_DatePicker = new KDDatePicker();
        kdtEntrys_leaveApply_DatePicker.setName("kdtEntrys_leaveApply_DatePicker");
        kdtEntrys_leaveApply_DatePicker.setVisible(true);
        kdtEntrys_leaveApply_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_leaveApply_CellEditor = new KDTDefaultCellEditor(kdtEntrys_leaveApply_DatePicker);
        this.kdtEntrys.getColumn("leaveApply").setEditor(kdtEntrys_leaveApply_CellEditor);
        KDDatePicker kdtEntrys_exitTime_DatePicker = new KDDatePicker();
        kdtEntrys_exitTime_DatePicker.setName("kdtEntrys_exitTime_DatePicker");
        kdtEntrys_exitTime_DatePicker.setVisible(true);
        kdtEntrys_exitTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_exitTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_exitTime_DatePicker);
        this.kdtEntrys.getColumn("exitTime").setEditor(kdtEntrys_exitTime_CellEditor);
        KDDatePicker kdtEntrys_dptrGTime_DatePicker = new KDDatePicker();
        kdtEntrys_dptrGTime_DatePicker.setName("kdtEntrys_dptrGTime_DatePicker");
        kdtEntrys_dptrGTime_DatePicker.setVisible(true);
        kdtEntrys_dptrGTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_dptrGTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dptrGTime_DatePicker);
        this.kdtEntrys.getColumn("dptrGTime").setEditor(kdtEntrys_dptrGTime_CellEditor);
        KDDatePicker kdtEntrys_dptrETime_DatePicker = new KDDatePicker();
        kdtEntrys_dptrETime_DatePicker.setName("kdtEntrys_dptrETime_DatePicker");
        kdtEntrys_dptrETime_DatePicker.setVisible(true);
        kdtEntrys_dptrETime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_dptrETime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dptrETime_DatePicker);
        this.kdtEntrys.getColumn("dptrETime").setEditor(kdtEntrys_dptrETime_CellEditor);
        KDDatePicker kdtEntrys_backTime_DatePicker = new KDDatePicker();
        kdtEntrys_backTime_DatePicker.setName("kdtEntrys_backTime_DatePicker");
        kdtEntrys_backTime_DatePicker.setVisible(true);
        kdtEntrys_backTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_backTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_backTime_DatePicker);
        this.kdtEntrys.getColumn("backTime").setEditor(kdtEntrys_backTime_CellEditor);
        KDDatePicker kdtEntrys_dptrTime_DatePicker = new KDDatePicker();
        kdtEntrys_dptrTime_DatePicker.setName("kdtEntrys_dptrTime_DatePicker");
        kdtEntrys_dptrTime_DatePicker.setVisible(true);
        kdtEntrys_dptrTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_dptrTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dptrTime_DatePicker);
        this.kdtEntrys.getColumn("dptrTime").setEditor(kdtEntrys_dptrTime_CellEditor);
        KDComboBox kdtEntrys_leaveType_ComboBox = new KDComboBox();
        kdtEntrys_leaveType_ComboBox.setName("kdtEntrys_leaveType_ComboBox");
        kdtEntrys_leaveType_ComboBox.setVisible(true);
        kdtEntrys_leaveType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.leaveTypeEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_leaveType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_leaveType_ComboBox);
        this.kdtEntrys.getColumn("leaveType").setEditor(kdtEntrys_leaveType_CellEditor);
        KDCheckBox kdtEntrys_carryCertify_CheckBox = new KDCheckBox();
        kdtEntrys_carryCertify_CheckBox.setName("kdtEntrys_carryCertify_CheckBox");
        KDTDefaultCellEditor kdtEntrys_carryCertify_CellEditor = new KDTDefaultCellEditor(kdtEntrys_carryCertify_CheckBox);
        this.kdtEntrys.getColumn("carryCertify").setEditor(kdtEntrys_carryCertify_CellEditor);
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
        final KDBizPromptBox kdtEntrys_cooperation_PromptBox = new KDBizPromptBox();
        kdtEntrys_cooperation_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_cooperation_PromptBox.setVisible(true);
        kdtEntrys_cooperation_PromptBox.setEditable(true);
        kdtEntrys_cooperation_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_cooperation_PromptBox.setEditFormat("$number$");
        kdtEntrys_cooperation_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_cooperation_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cooperation_PromptBox);
        this.kdtEntrys.getColumn("cooperation").setEditor(kdtEntrys_cooperation_CellEditor);
        ObjectValueRender kdtEntrys_cooperation_OVR = new ObjectValueRender();
        kdtEntrys_cooperation_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("cooperation").setRenderer(kdtEntrys_cooperation_OVR);
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
        KDTextField kdtEntrys_oldEtyId_TextField = new KDTextField();
        kdtEntrys_oldEtyId_TextField.setName("kdtEntrys_oldEtyId_TextField");
        kdtEntrys_oldEtyId_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_oldEtyId_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oldEtyId_TextField);
        this.kdtEntrys.getColumn("oldEtyId").setEditor(kdtEntrys_oldEtyId_CellEditor);
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
        // contbNum		
        this.contbNum.setBoundLabelText(resHelper.getString("contbNum.boundLabelText"));		
        this.contbNum.setBoundLabelLength(100);		
        this.contbNum.setBoundLabelUnderline(true);		
        this.contbNum.setVisible(false);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
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
        // pkauditDate		
        this.pkauditDate.setRequired(false);
        // billSate		
        this.billSate.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billSate.setRequired(false);
        // txtbNum		
        this.txtbNum.setVisible(false);		
        this.txtbNum.setHorizontalAlignment(2);		
        this.txtbNum.setMaxLength(100);		
        this.txtbNum.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));		
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));		
        this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_fauditing"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkauditDate,billSate,txtbNum,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 491));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 491));
        contCreator.setBounds(new Rectangle(10, 463, 218, 19));
        this.add(contCreator, new KDLayout.Constraints(10, 463, 218, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(267, 463, 218, 19));
        this.add(contCreateTime, new KDLayout.Constraints(267, 463, 218, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(396, 581, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(396, 581, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(732, 583, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(732, 583, 270, 19, 0));
        contNumber.setBounds(new Rectangle(10, 6, 215, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 6, 215, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(526, 6, 215, 19));
        this.add(contBizDate, new KDLayout.Constraints(526, 6, 215, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(10, 32, 989, 19));
        this.add(contDescription, new KDLayout.Constraints(10, 32, 989, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(524, 463, 218, 19));
        this.add(contAuditor, new KDLayout.Constraints(524, 463, 218, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(10, 98, 991, 364));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.certificates.LeaveManageEcEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(10, 98, 991, 364, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("sex",new Integer(1));
vo.put("MaritalStatus","0");
vo.put("docType","0");
vo.put("leaveType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contauditDate.setBounds(new Rectangle(783, 463, 218, 19));
        this.add(contauditDate, new KDLayout.Constraints(783, 463, 218, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillSate.setBounds(new Rectangle(275, 6, 215, 19));
        this.add(contbillSate, new KDLayout.Constraints(275, 6, 215, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbNum.setBounds(new Rectangle(782, 6, 215, 19));
        this.add(contbNum, new KDLayout.Constraints(782, 6, 215, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel1.setBounds(new Rectangle(10, 63, 991, 19));
        this.add(kDLabel1, new KDLayout.Constraints(10, 63, 991, 19, 0));
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
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);
        //contbillSate
        contbillSate.setBoundEditor(billSate);
        //contbNum
        contbNum.setBoundEditor(txtbNum);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.certificates.LeaveManageEcEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.name", String.class, this.kdtEntrys, "name.text");
		dataBinder.registerBinding("entrys.sex", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "sex.text");
		dataBinder.registerBinding("entrys.birthday", java.util.Date.class, this.kdtEntrys, "birthday.text");
		dataBinder.registerBinding("entrys.immiTime", java.util.Date.class, this.kdtEntrys, "immiTime.text");
		dataBinder.registerBinding("entrys.wPmtNum", String.class, this.kdtEntrys, "wPmtNum.text");
		dataBinder.registerBinding("entrys.wPmtSTime", java.util.Date.class, this.kdtEntrys, "wPmtSTime.text");
		dataBinder.registerBinding("entrys.pmtNum", String.class, this.kdtEntrys, "pmtNum.text");
		dataBinder.registerBinding("entrys.pmtETime", java.util.Date.class, this.kdtEntrys, "pmtETime.text");
		dataBinder.registerBinding("entrys.dptrTime", java.util.Date.class, this.kdtEntrys, "dptrTime.text");
		dataBinder.registerBinding("entrys.dptrGTime", java.util.Date.class, this.kdtEntrys, "dptrGTime.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.taskProj", java.lang.Object.class, this.kdtEntrys, "taskProj.text");
		dataBinder.registerBinding("entrys.pmtProj", java.lang.Object.class, this.kdtEntrys, "pmtProj.text");
		dataBinder.registerBinding("entrys.quProf", java.lang.Object.class, this.kdtEntrys, "quProf.text");
		dataBinder.registerBinding("entrys.quproff", String.class, this.kdtEntrys, "quproff.text");
		dataBinder.registerBinding("entrys.actProff", String.class, this.kdtEntrys, "actProff.text");
		dataBinder.registerBinding("entrys.idNum", String.class, this.kdtEntrys, "idNum.text");
		dataBinder.registerBinding("entrys.exitTime", java.util.Date.class, this.kdtEntrys, "exitTime.text");
		dataBinder.registerBinding("entrys.passpNum", String.class, this.kdtEntrys, "passpNum.text");
		dataBinder.registerBinding("entrys.leaveType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "leaveType.text");
		dataBinder.registerBinding("entrys.backTime", java.util.Date.class, this.kdtEntrys, "backTime.text");
		dataBinder.registerBinding("entrys.sourceEntryID", String.class, this.kdtEntrys, "sourceEntryID.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.leaveApply", java.util.Date.class, this.kdtEntrys, "leaveApply.text");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.birthPlaceCn", String.class, this.kdtEntrys, "birthPlaceCn.text");
		dataBinder.registerBinding("entrys.birthPlaceFr", String.class, this.kdtEntrys, "birthPlaceFr.text");
		dataBinder.registerBinding("entrys.natioNal", java.lang.Object.class, this.kdtEntrys, "natioNal.text");
		dataBinder.registerBinding("entrys.passpExDate", java.util.Date.class, this.kdtEntrys, "passpExDate.text");
		dataBinder.registerBinding("entrys.passpIsDate", java.util.Date.class, this.kdtEntrys, "passpIsDate.text");
		dataBinder.registerBinding("entrys.fatherName", String.class, this.kdtEntrys, "fatherName.text");
		dataBinder.registerBinding("entrys.fatherNameAl", String.class, this.kdtEntrys, "fatherNameAl.text");
		dataBinder.registerBinding("entrys.motherName", String.class, this.kdtEntrys, "motherName.text");
		dataBinder.registerBinding("entrys.motherNameAl", String.class, this.kdtEntrys, "motherNameAl.text");
		dataBinder.registerBinding("entrys.docType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "docType.text");
		dataBinder.registerBinding("entrys.rePmtNum", String.class, this.kdtEntrys, "rePmtNum.text");
		dataBinder.registerBinding("entrys.sRePmtSTime", java.util.Date.class, this.kdtEntrys, "sRePmtSTime.text");
		dataBinder.registerBinding("entrys.rePmtETime", java.util.Date.class, this.kdtEntrys, "rePmtETime.text");
		dataBinder.registerBinding("entrys.pmteffDate", java.util.Date.class, this.kdtEntrys, "pmteffDate.text");
		dataBinder.registerBinding("entrys.dptrETime", java.util.Date.class, this.kdtEntrys, "dptrETime.text");
		dataBinder.registerBinding("entrys.carryCertify", boolean.class, this.kdtEntrys, "carryCertify.text");
		dataBinder.registerBinding("entrys.cooperation", java.lang.Object.class, this.kdtEntrys, "cooperation.text");
		dataBinder.registerBinding("entrys.MaritalStatus", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "MaritalStatus.text");
		dataBinder.registerBinding("entrys.oldEtyId", String.class, this.kdtEntrys, "oldEtyId.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("billSate", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSate, "selectedItem");
		dataBinder.registerBinding("bNum", String.class, this.txtbNum, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.certificates.app.LeaveManageEcEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.immiTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wPmtNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wPmtSTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtETime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dptrTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dptrGTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.taskProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.quProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.quproff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actProff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.idNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.exitTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.leaveType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.backTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sourceEntryID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.leaveApply", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceCn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.natioNal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpExDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpIsDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherNameAl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherNameAl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.rePmtNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sRePmtSTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.rePmtETime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmteffDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dptrETime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.carryCertify", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.MaritalStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oldEtyId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bNum", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.birthday"));
    	sic.add(new SelectorItemInfo("entrys.immiTime"));
    	sic.add(new SelectorItemInfo("entrys.wPmtNum"));
    	sic.add(new SelectorItemInfo("entrys.wPmtSTime"));
    	sic.add(new SelectorItemInfo("entrys.pmtNum"));
    	sic.add(new SelectorItemInfo("entrys.pmtETime"));
    	sic.add(new SelectorItemInfo("entrys.dptrTime"));
    	sic.add(new SelectorItemInfo("entrys.dptrGTime"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
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
    	sic.add(new SelectorItemInfo("entrys.quproff"));
    	sic.add(new SelectorItemInfo("entrys.actProff"));
    	sic.add(new SelectorItemInfo("entrys.idNum"));
    	sic.add(new SelectorItemInfo("entrys.exitTime"));
    	sic.add(new SelectorItemInfo("entrys.passpNum"));
    	sic.add(new SelectorItemInfo("entrys.leaveType"));
    	sic.add(new SelectorItemInfo("entrys.backTime"));
    	sic.add(new SelectorItemInfo("entrys.sourceEntryID"));
    	sic.add(new SelectorItemInfo("entrys.personID"));
    	sic.add(new SelectorItemInfo("entrys.leaveApply"));
    	sic.add(new SelectorItemInfo("entrys.lastName"));
    	sic.add(new SelectorItemInfo("entrys.firstName"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceCn"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceFr"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.natioNal.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.natioNal.id"));
			sic.add(new SelectorItemInfo("entrys.natioNal.name"));
        	sic.add(new SelectorItemInfo("entrys.natioNal.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.passpExDate"));
    	sic.add(new SelectorItemInfo("entrys.passpIsDate"));
    	sic.add(new SelectorItemInfo("entrys.fatherName"));
    	sic.add(new SelectorItemInfo("entrys.fatherNameAl"));
    	sic.add(new SelectorItemInfo("entrys.motherName"));
    	sic.add(new SelectorItemInfo("entrys.motherNameAl"));
    	sic.add(new SelectorItemInfo("entrys.docType"));
    	sic.add(new SelectorItemInfo("entrys.rePmtNum"));
    	sic.add(new SelectorItemInfo("entrys.sRePmtSTime"));
    	sic.add(new SelectorItemInfo("entrys.rePmtETime"));
    	sic.add(new SelectorItemInfo("entrys.pmteffDate"));
    	sic.add(new SelectorItemInfo("entrys.dptrETime"));
    	sic.add(new SelectorItemInfo("entrys.carryCertify"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.cooperation.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.cooperation.id"));
			sic.add(new SelectorItemInfo("entrys.cooperation.name"));
        	sic.add(new SelectorItemInfo("entrys.cooperation.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.MaritalStatus"));
    	sic.add(new SelectorItemInfo("entrys.oldEtyId"));
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
        sic.add(new SelectorItemInfo("auditDate"));
        sic.add(new SelectorItemInfo("billSate"));
        sic.add(new SelectorItemInfo("bNum"));
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
     * output acitonAudit_actionPerformed method
     */
    public void acitonAudit_actionPerformed(ActionEvent e) throws Exception
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
	public RequestContext prepareAcitonAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareAcitonAudit() {
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
     * output AcitonAudit class
     */     
    protected class AcitonAudit extends ItemAction {     
    
        public AcitonAudit()
        {
            this(null);
        }

        public AcitonAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("AcitonAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("AcitonAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("AcitonAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractLeaveManageEcEditUI.this, "AcitonAudit", "acitonAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractLeaveManageEcEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.certificates.client", "LeaveManageEcEditUI");
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
        return com.kingdee.eas.zjlw.certificates.client.LeaveManageEcEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.LeaveManageEcFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo objectValue = new com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/certificates/LeaveManageEc";
	}
    protected IMetaDataPK getTDQueryPK() {
	return null;    	
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