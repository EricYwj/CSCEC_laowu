/**
 * output package name
 */
package com.kingdee.eas.zjlw.personmess.client;

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
public abstract class AbstractLocalInfoEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractLocalInfoEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproCom;
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
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtproCom;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.zjlw.personmess.LocalInfoInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractLocalInfoEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractLocalInfoEditUI.class.getName());
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
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillSate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproCom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.prmtproCom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
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
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.contproCom.setName("contproCom");
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
        this.prmtproCom.setName("prmtproCom");
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
        this.contNumber.setEnabled(false);
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol33\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"birthPlaceF\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"country\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"MaritalStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"childCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"coupleWork\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fatherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"motherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"address\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IDNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthIDNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"CCPNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"securityNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"telephone\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"secuNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"secuProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"nBasePay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"approachTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"contractNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"contrachSigDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"contractTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"secuProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workProgram\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cooperation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cooperationId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"foriPersID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"endDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"personId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{birthdate}</t:Cell><t:Cell>$Resource{birthPlaceF}</t:Cell><t:Cell>$Resource{country}</t:Cell><t:Cell>$Resource{MaritalStatus}</t:Cell><t:Cell>$Resource{childCount}</t:Cell><t:Cell>$Resource{coupleWork}</t:Cell><t:Cell>$Resource{fatherName}</t:Cell><t:Cell>$Resource{motherName}</t:Cell><t:Cell>$Resource{address}</t:Cell><t:Cell>$Resource{IDNumber}</t:Cell><t:Cell>$Resource{birthIDNumber}</t:Cell><t:Cell>$Resource{CCPNo}</t:Cell><t:Cell>$Resource{securityNo}</t:Cell><t:Cell>$Resource{telephone}</t:Cell><t:Cell>$Resource{secuNumber}</t:Cell><t:Cell>$Resource{secuProf}</t:Cell><t:Cell>$Resource{nBasePay}</t:Cell><t:Cell>$Resource{approachTime}</t:Cell><t:Cell>$Resource{contractNo}</t:Cell><t:Cell>$Resource{contrachSigDate}</t:Cell><t:Cell>$Resource{contractTime}</t:Cell><t:Cell>$Resource{secuProj}</t:Cell><t:Cell>$Resource{workProgram}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{cooperationId}</t:Cell><t:Cell>$Resource{foriPersID}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{birthPlace}</t:Cell><t:Cell>$Resource{personId}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        kdtEntrys.addKDTPropertyChangeListener(new KDTPropertyChangeListener() {
		public void propertyChange(KDTPropertyChangeEvent e) {
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

                this.kdtEntrys.putBindContents("editData",new String[] {"id","lastName","firstName","sex","birthdate","birthPlaceF","country","MaritalStatus","childCount","coupleWork","fatherName","motherName","address","IDNumber","birthIDNumber","CCPNo","securityNo","telephone","secuNumber","secuProf","nBasePay","approachTime","contractNo","contrachSigDate","contractTime","secuProj","workProgram","cooperation","cooperationId","foriPersID","endDate","remark","birthPlace","personId"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_lastName_TextField = new KDTextField();
        kdtEntrys_lastName_TextField.setName("kdtEntrys_lastName_TextField");
        kdtEntrys_lastName_TextField.setMaxLength(100);
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
        KDDatePicker kdtEntrys_birthdate_DatePicker = new KDDatePicker();
        kdtEntrys_birthdate_DatePicker.setName("kdtEntrys_birthdate_DatePicker");
        kdtEntrys_birthdate_DatePicker.setVisible(true);
        kdtEntrys_birthdate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_birthdate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthdate_DatePicker);
        this.kdtEntrys.getColumn("birthdate").setEditor(kdtEntrys_birthdate_CellEditor);
        final KDBizPromptBox kdtEntrys_birthPlaceF_PromptBox = new KDBizPromptBox();
        kdtEntrys_birthPlaceF_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");
        kdtEntrys_birthPlaceF_PromptBox.setVisible(true);
        kdtEntrys_birthPlaceF_PromptBox.setEditable(true);
        kdtEntrys_birthPlaceF_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_birthPlaceF_PromptBox.setEditFormat("$number$");
        kdtEntrys_birthPlaceF_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_birthPlaceF_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlaceF_PromptBox);
        this.kdtEntrys.getColumn("birthPlaceF").setEditor(kdtEntrys_birthPlaceF_CellEditor);
        ObjectValueRender kdtEntrys_birthPlaceF_OVR = new ObjectValueRender();
        kdtEntrys_birthPlaceF_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("birthPlaceF").setRenderer(kdtEntrys_birthPlaceF_OVR);
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
        KDComboBox kdtEntrys_MaritalStatus_ComboBox = new KDComboBox();
        kdtEntrys_MaritalStatus_ComboBox.setName("kdtEntrys_MaritalStatus_ComboBox");
        kdtEntrys_MaritalStatus_ComboBox.setVisible(true);
        kdtEntrys_MaritalStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.mayrStatEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_MaritalStatus_CellEditor = new KDTDefaultCellEditor(kdtEntrys_MaritalStatus_ComboBox);
        this.kdtEntrys.getColumn("MaritalStatus").setEditor(kdtEntrys_MaritalStatus_CellEditor);
        KDFormattedTextField kdtEntrys_childCount_TextField = new KDFormattedTextField();
        kdtEntrys_childCount_TextField.setName("kdtEntrys_childCount_TextField");
        kdtEntrys_childCount_TextField.setVisible(true);
        kdtEntrys_childCount_TextField.setEditable(true);
        kdtEntrys_childCount_TextField.setHorizontalAlignment(2);
        kdtEntrys_childCount_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_childCount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_childCount_TextField);
        this.kdtEntrys.getColumn("childCount").setEditor(kdtEntrys_childCount_CellEditor);
        KDCheckBox kdtEntrys_coupleWork_CheckBox = new KDCheckBox();
        kdtEntrys_coupleWork_CheckBox.setName("kdtEntrys_coupleWork_CheckBox");
        KDTDefaultCellEditor kdtEntrys_coupleWork_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleWork_CheckBox);
        this.kdtEntrys.getColumn("coupleWork").setEditor(kdtEntrys_coupleWork_CellEditor);
        KDTextField kdtEntrys_fatherName_TextField = new KDTextField();
        kdtEntrys_fatherName_TextField.setName("kdtEntrys_fatherName_TextField");
        kdtEntrys_fatherName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_fatherName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fatherName_TextField);
        this.kdtEntrys.getColumn("fatherName").setEditor(kdtEntrys_fatherName_CellEditor);
        KDTextField kdtEntrys_motherName_TextField = new KDTextField();
        kdtEntrys_motherName_TextField.setName("kdtEntrys_motherName_TextField");
        kdtEntrys_motherName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_motherName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_motherName_TextField);
        this.kdtEntrys.getColumn("motherName").setEditor(kdtEntrys_motherName_CellEditor);
        KDTextField kdtEntrys_address_TextField = new KDTextField();
        kdtEntrys_address_TextField.setName("kdtEntrys_address_TextField");
        kdtEntrys_address_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_address_CellEditor = new KDTDefaultCellEditor(kdtEntrys_address_TextField);
        this.kdtEntrys.getColumn("address").setEditor(kdtEntrys_address_CellEditor);
        KDTextField kdtEntrys_IDNumber_TextField = new KDTextField();
        kdtEntrys_IDNumber_TextField.setName("kdtEntrys_IDNumber_TextField");
        kdtEntrys_IDNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_IDNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IDNumber_TextField);
        this.kdtEntrys.getColumn("IDNumber").setEditor(kdtEntrys_IDNumber_CellEditor);
        KDTextField kdtEntrys_birthIDNumber_TextField = new KDTextField();
        kdtEntrys_birthIDNumber_TextField.setName("kdtEntrys_birthIDNumber_TextField");
        kdtEntrys_birthIDNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_birthIDNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthIDNumber_TextField);
        this.kdtEntrys.getColumn("birthIDNumber").setEditor(kdtEntrys_birthIDNumber_CellEditor);
        KDTextField kdtEntrys_CCPNo_TextField = new KDTextField();
        kdtEntrys_CCPNo_TextField.setName("kdtEntrys_CCPNo_TextField");
        kdtEntrys_CCPNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_CCPNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CCPNo_TextField);
        this.kdtEntrys.getColumn("CCPNo").setEditor(kdtEntrys_CCPNo_CellEditor);
        KDTextField kdtEntrys_securityNo_TextField = new KDTextField();
        kdtEntrys_securityNo_TextField.setName("kdtEntrys_securityNo_TextField");
        kdtEntrys_securityNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_securityNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_securityNo_TextField);
        this.kdtEntrys.getColumn("securityNo").setEditor(kdtEntrys_securityNo_CellEditor);
        KDTextField kdtEntrys_telephone_TextField = new KDTextField();
        kdtEntrys_telephone_TextField.setName("kdtEntrys_telephone_TextField");
        kdtEntrys_telephone_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_telephone_CellEditor = new KDTDefaultCellEditor(kdtEntrys_telephone_TextField);
        this.kdtEntrys.getColumn("telephone").setEditor(kdtEntrys_telephone_CellEditor);
        final KDBizPromptBox kdtEntrys_secuNumber_PromptBox = new KDBizPromptBox();
        kdtEntrys_secuNumber_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfQuery");
        kdtEntrys_secuNumber_PromptBox.setVisible(true);
        kdtEntrys_secuNumber_PromptBox.setEditable(true);
        kdtEntrys_secuNumber_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_secuNumber_PromptBox.setEditFormat("$number$");
        kdtEntrys_secuNumber_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_secuNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_secuNumber_PromptBox);
        this.kdtEntrys.getColumn("secuNumber").setEditor(kdtEntrys_secuNumber_CellEditor);
        ObjectValueRender kdtEntrys_secuNumber_OVR = new ObjectValueRender();
        kdtEntrys_secuNumber_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("secuNumber").setRenderer(kdtEntrys_secuNumber_OVR);
        final KDBizPromptBox kdtEntrys_secuProf_PromptBox = new KDBizPromptBox();
        kdtEntrys_secuProf_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfQuery");
        kdtEntrys_secuProf_PromptBox.setVisible(true);
        kdtEntrys_secuProf_PromptBox.setEditable(true);
        kdtEntrys_secuProf_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_secuProf_PromptBox.setEditFormat("$number$");
        kdtEntrys_secuProf_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_secuProf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_secuProf_PromptBox);
        this.kdtEntrys.getColumn("secuProf").setEditor(kdtEntrys_secuProf_CellEditor);
        ObjectValueRender kdtEntrys_secuProf_OVR = new ObjectValueRender();
        kdtEntrys_secuProf_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("secuProf").setRenderer(kdtEntrys_secuProf_OVR);
        KDFormattedTextField kdtEntrys_nBasePay_TextField = new KDFormattedTextField();
        kdtEntrys_nBasePay_TextField.setName("kdtEntrys_nBasePay_TextField");
        kdtEntrys_nBasePay_TextField.setVisible(true);
        kdtEntrys_nBasePay_TextField.setEditable(true);
        kdtEntrys_nBasePay_TextField.setHorizontalAlignment(2);
        kdtEntrys_nBasePay_TextField.setDataType(1);
        	kdtEntrys_nBasePay_TextField.setMinimumValue(new java.math.BigDecimal("-3.4028234663852886E38"));
        	kdtEntrys_nBasePay_TextField.setMaximumValue(new java.math.BigDecimal("3.4028234663852886E38"));
        kdtEntrys_nBasePay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nBasePay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nBasePay_TextField);
        this.kdtEntrys.getColumn("nBasePay").setEditor(kdtEntrys_nBasePay_CellEditor);
        KDDatePicker kdtEntrys_approachTime_DatePicker = new KDDatePicker();
        kdtEntrys_approachTime_DatePicker.setName("kdtEntrys_approachTime_DatePicker");
        kdtEntrys_approachTime_DatePicker.setVisible(true);
        kdtEntrys_approachTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_approachTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_approachTime_DatePicker);
        this.kdtEntrys.getColumn("approachTime").setEditor(kdtEntrys_approachTime_CellEditor);
        KDTextField kdtEntrys_contractNo_TextField = new KDTextField();
        kdtEntrys_contractNo_TextField.setName("kdtEntrys_contractNo_TextField");
        kdtEntrys_contractNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_contractNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contractNo_TextField);
        this.kdtEntrys.getColumn("contractNo").setEditor(kdtEntrys_contractNo_CellEditor);
        KDDatePicker kdtEntrys_contrachSigDate_DatePicker = new KDDatePicker();
        kdtEntrys_contrachSigDate_DatePicker.setName("kdtEntrys_contrachSigDate_DatePicker");
        kdtEntrys_contrachSigDate_DatePicker.setVisible(true);
        kdtEntrys_contrachSigDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_contrachSigDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contrachSigDate_DatePicker);
        this.kdtEntrys.getColumn("contrachSigDate").setEditor(kdtEntrys_contrachSigDate_CellEditor);
        KDDatePicker kdtEntrys_contractTime_DatePicker = new KDDatePicker();
        kdtEntrys_contractTime_DatePicker.setName("kdtEntrys_contractTime_DatePicker");
        kdtEntrys_contractTime_DatePicker.setVisible(true);
        kdtEntrys_contractTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_contractTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contractTime_DatePicker);
        this.kdtEntrys.getColumn("contractTime").setEditor(kdtEntrys_contractTime_CellEditor);
        final KDBizPromptBox kdtEntrys_secuProj_PromptBox = new KDBizPromptBox();
        kdtEntrys_secuProj_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_secuProj_PromptBox.setVisible(true);
        kdtEntrys_secuProj_PromptBox.setEditable(true);
        kdtEntrys_secuProj_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_secuProj_PromptBox.setEditFormat("$number$");
        kdtEntrys_secuProj_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_secuProj_CellEditor = new KDTDefaultCellEditor(kdtEntrys_secuProj_PromptBox);
        this.kdtEntrys.getColumn("secuProj").setEditor(kdtEntrys_secuProj_CellEditor);
        ObjectValueRender kdtEntrys_secuProj_OVR = new ObjectValueRender();
        kdtEntrys_secuProj_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("secuProj").setRenderer(kdtEntrys_secuProj_OVR);
        final KDBizPromptBox kdtEntrys_workProgram_PromptBox = new KDBizPromptBox();
        kdtEntrys_workProgram_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_workProgram_PromptBox.setVisible(true);
        kdtEntrys_workProgram_PromptBox.setEditable(true);
        kdtEntrys_workProgram_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_workProgram_PromptBox.setEditFormat("$number$");
        kdtEntrys_workProgram_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_workProgram_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workProgram_PromptBox);
        this.kdtEntrys.getColumn("workProgram").setEditor(kdtEntrys_workProgram_CellEditor);
        ObjectValueRender kdtEntrys_workProgram_OVR = new ObjectValueRender();
        kdtEntrys_workProgram_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("workProgram").setRenderer(kdtEntrys_workProgram_OVR);
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
        KDTextField kdtEntrys_cooperationId_TextField = new KDTextField();
        kdtEntrys_cooperationId_TextField.setName("kdtEntrys_cooperationId_TextField");
        kdtEntrys_cooperationId_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_cooperationId_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cooperationId_TextField);
        this.kdtEntrys.getColumn("cooperationId").setEditor(kdtEntrys_cooperationId_CellEditor);
        KDTextField kdtEntrys_foriPersID_TextField = new KDTextField();
        kdtEntrys_foriPersID_TextField.setName("kdtEntrys_foriPersID_TextField");
        kdtEntrys_foriPersID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_foriPersID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_foriPersID_TextField);
        this.kdtEntrys.getColumn("foriPersID").setEditor(kdtEntrys_foriPersID_CellEditor);
        KDDatePicker kdtEntrys_endDate_DatePicker = new KDDatePicker();
        kdtEntrys_endDate_DatePicker.setName("kdtEntrys_endDate_DatePicker");
        kdtEntrys_endDate_DatePicker.setVisible(true);
        kdtEntrys_endDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_endDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_endDate_DatePicker);
        this.kdtEntrys.getColumn("endDate").setEditor(kdtEntrys_endDate_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        final KDBizPromptBox kdtEntrys_birthPlace_PromptBox = new KDBizPromptBox();
        kdtEntrys_birthPlace_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");
        kdtEntrys_birthPlace_PromptBox.setVisible(true);
        kdtEntrys_birthPlace_PromptBox.setEditable(true);
        kdtEntrys_birthPlace_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_birthPlace_PromptBox.setEditFormat("$number$");
        kdtEntrys_birthPlace_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_birthPlace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlace_PromptBox);
        this.kdtEntrys.getColumn("birthPlace").setEditor(kdtEntrys_birthPlace_CellEditor);
        ObjectValueRender kdtEntrys_birthPlace_OVR = new ObjectValueRender();
        kdtEntrys_birthPlace_OVR.setFormat(new BizDataFormat("$description$"));
        this.kdtEntrys.getColumn("birthPlace").setRenderer(kdtEntrys_birthPlace_OVR);
        KDTextField kdtEntrys_personId_TextField = new KDTextField();
        kdtEntrys_personId_TextField.setName("kdtEntrys_personId_TextField");
        kdtEntrys_personId_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_personId_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personId_TextField);
        this.kdtEntrys.getColumn("personId").setEditor(kdtEntrys_personId_CellEditor);
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
        this.contbillSate.setEnabled(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));
        // contproCom		
        this.contproCom.setBoundLabelText(resHelper.getString("contproCom.boundLabelText"));		
        this.contproCom.setBoundLabelLength(100);		
        this.contproCom.setBoundLabelUnderline(true);		
        this.contproCom.setVisible(true);
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
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);
        // billSate		
        this.billSate.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billSate.setRequired(false);		
        this.billSate.setEnabled(false);
        // prmtproCom		
        this.prmtproCom.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtproCom.setEditable(true);		
        this.prmtproCom.setDisplayFormat("$name$");		
        this.prmtproCom.setEditFormat("$number$");		
        this.prmtproCom.setCommitFormat("$number$");		
        this.prmtproCom.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));		
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));		
        this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_fauditing"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditDate,billSate,prmtproCom,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, -26, 1013, 624));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, -26, 1013, 624));
        contCreator.setBounds(new Rectangle(6, 600, 223, 22));
        this.add(contCreator, new KDLayout.Constraints(6, 600, 223, 22, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(262, 600, 223, 19));
        this.add(contCreateTime, new KDLayout.Constraints(262, 600, 223, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(6, 628, 230, 20));
        this.add(contLastUpdateUser, new KDLayout.Constraints(6, 628, 230, 20, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(262, 631, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(262, 631, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(10, 14, 211, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 14, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(260, 14, 211, 19));
        this.add(contBizDate, new KDLayout.Constraints(260, 14, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(10, 43, 964, 19));
        this.add(contDescription, new KDLayout.Constraints(10, 43, 964, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(518, 596, 223, 20));
        this.add(contAuditor, new KDLayout.Constraints(518, 596, 223, 20, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(7, 104, 993, 489));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(7, 104, 993, 489, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("sex",new Integer(1));
vo.put("MaritalStatus","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contauditDate.setBounds(new Rectangle(776, 599, 223, 20));
        this.add(contauditDate, new KDLayout.Constraints(776, 599, 223, 20, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillSate.setBounds(new Rectangle(761, 14, 211, 19));
        this.add(contbillSate, new KDLayout.Constraints(761, 14, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer1.setBounds(new Rectangle(9, 73, 967, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(9, 73, 967, 19, 0));
        contproCom.setBounds(new Rectangle(510, 14, 211, 19));
        this.add(contproCom, new KDLayout.Constraints(510, 14, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contproCom
        contproCom.setBoundEditor(prmtproCom);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.sex", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "sex.text");
		dataBinder.registerBinding("entrys.birthdate", java.util.Date.class, this.kdtEntrys, "birthdate.text");
		dataBinder.registerBinding("entrys.fatherName", String.class, this.kdtEntrys, "fatherName.text");
		dataBinder.registerBinding("entrys.motherName", String.class, this.kdtEntrys, "motherName.text");
		dataBinder.registerBinding("entrys.telephone", String.class, this.kdtEntrys, "telephone.text");
		dataBinder.registerBinding("entrys.securityNo", String.class, this.kdtEntrys, "securityNo.text");
		dataBinder.registerBinding("entrys.CCPNo", String.class, this.kdtEntrys, "CCPNo.text");
		dataBinder.registerBinding("entrys.address", String.class, this.kdtEntrys, "address.text");
		dataBinder.registerBinding("entrys.contractNo", String.class, this.kdtEntrys, "contractNo.text");
		dataBinder.registerBinding("entrys.approachTime", java.util.Date.class, this.kdtEntrys, "approachTime.text");
		dataBinder.registerBinding("entrys.contrachSigDate", java.util.Date.class, this.kdtEntrys, "contrachSigDate.text");
		dataBinder.registerBinding("entrys.contractTime", java.util.Date.class, this.kdtEntrys, "contractTime.text");
		dataBinder.registerBinding("entrys.workProgram", java.lang.Object.class, this.kdtEntrys, "workProgram.text");
		dataBinder.registerBinding("entrys.MaritalStatus", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "MaritalStatus.text");
		dataBinder.registerBinding("entrys.cooperationId", String.class, this.kdtEntrys, "cooperationId.text");
		dataBinder.registerBinding("entrys.cooperation", java.lang.Object.class, this.kdtEntrys, "cooperation.text");
		dataBinder.registerBinding("entrys.country", java.lang.Object.class, this.kdtEntrys, "country.text");
		dataBinder.registerBinding("entrys.childCount", int.class, this.kdtEntrys, "childCount.text");
		dataBinder.registerBinding("entrys.coupleWork", boolean.class, this.kdtEntrys, "coupleWork.text");
		dataBinder.registerBinding("entrys.secuProj", java.lang.Object.class, this.kdtEntrys, "secuProj.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.foriPersID", String.class, this.kdtEntrys, "foriPersID.text");
		dataBinder.registerBinding("entrys.endDate", java.util.Date.class, this.kdtEntrys, "endDate.text");
		dataBinder.registerBinding("entrys.secuProf", java.lang.Object.class, this.kdtEntrys, "secuProf.text");
		dataBinder.registerBinding("entrys.nBasePay", java.math.BigDecimal.class, this.kdtEntrys, "nBasePay.text");
		dataBinder.registerBinding("entrys.birthPlace", java.lang.Object.class, this.kdtEntrys, "birthPlace.text");
		dataBinder.registerBinding("entrys.birthPlaceF", java.lang.Object.class, this.kdtEntrys, "birthPlaceF.text");
		dataBinder.registerBinding("entrys.secuNumber", java.lang.Object.class, this.kdtEntrys, "secuNumber.text");
		dataBinder.registerBinding("entrys.personId", String.class, this.kdtEntrys, "personId.text");
		dataBinder.registerBinding("entrys.IDNumber", String.class, this.kdtEntrys, "IDNumber.text");
		dataBinder.registerBinding("entrys.birthIDNumber", String.class, this.kdtEntrys, "birthIDNumber.text");
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
		dataBinder.registerBinding("proCom", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtproCom, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.personmess.app.LocalInfoEditUIHandler";
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
        super.setUIController(new LocalInfoEditUIController(super.getNavigator()));
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
        this.editData = (com.kingdee.eas.zjlw.personmess.LocalInfoInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.telephone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.securityNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CCPNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contractNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.approachTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contrachSigDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contractTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workProgram", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.MaritalStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cooperationId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.country", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.childCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleWork", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.foriPersID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nBasePay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IDNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthIDNumber", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("proCom", ValidateHelper.ON_SAVE);    		
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
            if ("secuProf".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())&&kdtEntrys.getRowCount()>0) {
kdtEntrys.getCell(rowIndex,"nBasePay").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"secuProf").getValue(),"basePay")));

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
		}
    	sic.add(new SelectorItemInfo("entrys.lastName"));
    	sic.add(new SelectorItemInfo("entrys.firstName"));
    	sic.add(new SelectorItemInfo("entrys.sex"));
    	sic.add(new SelectorItemInfo("entrys.birthdate"));
    	sic.add(new SelectorItemInfo("entrys.fatherName"));
    	sic.add(new SelectorItemInfo("entrys.motherName"));
    	sic.add(new SelectorItemInfo("entrys.telephone"));
    	sic.add(new SelectorItemInfo("entrys.securityNo"));
    	sic.add(new SelectorItemInfo("entrys.CCPNo"));
    	sic.add(new SelectorItemInfo("entrys.address"));
    	sic.add(new SelectorItemInfo("entrys.contractNo"));
    	sic.add(new SelectorItemInfo("entrys.approachTime"));
    	sic.add(new SelectorItemInfo("entrys.contrachSigDate"));
    	sic.add(new SelectorItemInfo("entrys.contractTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.workProgram.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.workProgram.id"));
			sic.add(new SelectorItemInfo("entrys.workProgram.name"));
        	sic.add(new SelectorItemInfo("entrys.workProgram.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.MaritalStatus"));
    	sic.add(new SelectorItemInfo("entrys.cooperationId"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.cooperation.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.cooperation.id"));
			sic.add(new SelectorItemInfo("entrys.cooperation.name"));
        	sic.add(new SelectorItemInfo("entrys.cooperation.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.country.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.country.id"));
			sic.add(new SelectorItemInfo("entrys.country.name"));
        	sic.add(new SelectorItemInfo("entrys.country.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.childCount"));
    	sic.add(new SelectorItemInfo("entrys.coupleWork"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.secuProj.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.secuProj.id"));
			sic.add(new SelectorItemInfo("entrys.secuProj.name"));
        	sic.add(new SelectorItemInfo("entrys.secuProj.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.foriPersID"));
    	sic.add(new SelectorItemInfo("entrys.endDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.secuProf.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.secuProf.id"));
			sic.add(new SelectorItemInfo("entrys.secuProf.name"));
        	sic.add(new SelectorItemInfo("entrys.secuProf.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.nBasePay"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.birthPlace.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.birthPlace.id"));
			sic.add(new SelectorItemInfo("entrys.birthPlace.description"));
			sic.add(new SelectorItemInfo("entrys.birthPlace.name"));
        	sic.add(new SelectorItemInfo("entrys.birthPlace.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.birthPlaceF.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.birthPlaceF.id"));
			sic.add(new SelectorItemInfo("entrys.birthPlaceF.name"));
        	sic.add(new SelectorItemInfo("entrys.birthPlaceF.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.secuNumber.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.secuNumber.id"));
			sic.add(new SelectorItemInfo("entrys.secuNumber.number"));
			sic.add(new SelectorItemInfo("entrys.secuNumber.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.personId"));
    	sic.add(new SelectorItemInfo("entrys.IDNumber"));
    	sic.add(new SelectorItemInfo("entrys.birthIDNumber"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("proCom.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("proCom.id"));
        	sic.add(new SelectorItemInfo("proCom.number"));
        	sic.add(new SelectorItemInfo("proCom.name"));
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
					((LocalInfoEditUIController)getUIController()).actionAudit();
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
            innerActionPerformed("eas", AbstractLocalInfoEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractLocalInfoEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.personmess.client", "LocalInfoEditUI");
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
        return com.kingdee.eas.zjlw.personmess.client.LocalInfoEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.personmess.LocalInfoFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.personmess.LocalInfoInfo objectValue = new com.kingdee.eas.zjlw.personmess.LocalInfoInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/personmess/LocalInfo";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.personmess.app.LocalInfoQuery");
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