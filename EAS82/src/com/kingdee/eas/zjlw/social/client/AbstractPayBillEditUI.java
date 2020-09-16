/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

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
public abstract class AbstractPayBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPayBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojSCNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojAddr;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthYearr;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprojName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtprojSCNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtprojAddr;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmonthYearr;
    protected com.kingdee.eas.zjlw.social.PayBillInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPayBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPayBillEditUI.class.getName());
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
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbillSate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojSCNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojAddr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthYearr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billSate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkAuditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtprojName = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtprojSCNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtprojAddr = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtmonthYearr = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
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
        this.contAuditDate.setName("contAuditDate");
        this.contprojName.setName("contprojName");
        this.contprojSCNum.setName("contprojSCNum");
        this.contprojAddr.setName("contprojAddr");
        this.contmonthYearr.setName("contmonthYearr");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billSate.setName("billSate");
        this.pkAuditDate.setName("pkAuditDate");
        this.prmtprojName.setName("prmtprojName");
        this.txtprojSCNum.setName("txtprojSCNum");
        this.txtprojAddr.setName("txtprojAddr");
        this.prmtmonthYearr.setName("prmtmonthYearr");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol45\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol46\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol47\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol48\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isMarry\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"prof\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"enterDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"basePay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"monthWork\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"absence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"absDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"normalOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"moreOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"festOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"profWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"extProfWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"secuDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"vacaDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"persTax\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"chineWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"algerWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"traWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"bTripWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"oneWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"riskWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"disasWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"eatWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"overTraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"areaWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"thingsWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"switchWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"nWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"liveWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"spendWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"fireWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"retirWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"faraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"unSignWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"profAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"langWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"urgeWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"monthAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"indPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"netPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"seniWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"wifeUnWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"FamilyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"studyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"unSCVCWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{isMarry}</t:Cell><t:Cell>$Resource{prof}</t:Cell><t:Cell>$Resource{enterDate}</t:Cell><t:Cell>$Resource{basePay}</t:Cell><t:Cell>$Resource{monthWork}</t:Cell><t:Cell>$Resource{absence}</t:Cell><t:Cell>$Resource{absDebit}</t:Cell><t:Cell>$Resource{normalOver}</t:Cell><t:Cell>$Resource{moreOver}</t:Cell><t:Cell>$Resource{festOver}</t:Cell><t:Cell>$Resource{profWage}</t:Cell><t:Cell>$Resource{extProfWage}</t:Cell><t:Cell>$Resource{secuDebit}</t:Cell><t:Cell>$Resource{vacaDebit}</t:Cell><t:Cell>$Resource{persTax}</t:Cell><t:Cell>$Resource{chineWage}</t:Cell><t:Cell>$Resource{algerWage}</t:Cell><t:Cell>$Resource{traWage}</t:Cell><t:Cell>$Resource{bTripWage}</t:Cell><t:Cell>$Resource{oneWorkWage}</t:Cell><t:Cell>$Resource{riskWage}</t:Cell><t:Cell>$Resource{disasWage}</t:Cell><t:Cell>$Resource{eatWage}</t:Cell><t:Cell>$Resource{overTraWage}</t:Cell><t:Cell>$Resource{areaWage}</t:Cell><t:Cell>$Resource{thingsWage}</t:Cell><t:Cell>$Resource{switchWage}</t:Cell><t:Cell>$Resource{nWorkWage}</t:Cell><t:Cell>$Resource{liveWage}</t:Cell><t:Cell>$Resource{spendWage}</t:Cell><t:Cell>$Resource{fireWage}</t:Cell><t:Cell>$Resource{retirWage}</t:Cell><t:Cell>$Resource{faraWage}</t:Cell><t:Cell>$Resource{unSignWage}</t:Cell><t:Cell>$Resource{profAward}</t:Cell><t:Cell>$Resource{langWage}</t:Cell><t:Cell>$Resource{urgeWage}</t:Cell><t:Cell>$Resource{monthAward}</t:Cell><t:Cell>$Resource{indPay}</t:Cell><t:Cell>$Resource{netPay}</t:Cell><t:Cell>$Resource{seniWage}</t:Cell><t:Cell>$Resource{wifeUnWage}</t:Cell><t:Cell>$Resource{FamilyWage}</t:Cell><t:Cell>$Resource{studyWage}</t:Cell><t:Cell>$Resource{unSCVCWage}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","lastName","firstName","sex","isMarry","prof","enterDate","basePay","monthWork","absence","absDebit","normalOver","moreOver","festOver","profWage","extProfWage","secuDebit","vacaDebit","persTax","chineWage","algerWage","traWage","bTripWage","oneWorkWage","riskWage","disasWage","eatWage","overTraWage","areaWage","thingsWage","switchWage","nWorkWage","liveWage","spendWage","fireWage","retirWage","faraWage","unSignWage","profAward","langWage","urgeWage","monthAward","indPay","netPay","seniWage","wifeUnWage","FamilyWage","studyWage","unSCVCWage"});


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
        KDCheckBox kdtEntrys_isMarry_CheckBox = new KDCheckBox();
        kdtEntrys_isMarry_CheckBox.setName("kdtEntrys_isMarry_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isMarry_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isMarry_CheckBox);
        this.kdtEntrys.getColumn("isMarry").setEditor(kdtEntrys_isMarry_CellEditor);
        final KDBizPromptBox kdtEntrys_prof_PromptBox = new KDBizPromptBox();
        kdtEntrys_prof_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");
        kdtEntrys_prof_PromptBox.setVisible(true);
        kdtEntrys_prof_PromptBox.setEditable(true);
        kdtEntrys_prof_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_prof_PromptBox.setEditFormat("$number$");
        kdtEntrys_prof_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_prof_CellEditor = new KDTDefaultCellEditor(kdtEntrys_prof_PromptBox);
        this.kdtEntrys.getColumn("prof").setEditor(kdtEntrys_prof_CellEditor);
        ObjectValueRender kdtEntrys_prof_OVR = new ObjectValueRender();
        kdtEntrys_prof_OVR.setFormat(new BizDataFormat("$name$( $nameFR$)"));
        this.kdtEntrys.getColumn("prof").setRenderer(kdtEntrys_prof_OVR);
        KDDatePicker kdtEntrys_enterDate_DatePicker = new KDDatePicker();
        kdtEntrys_enterDate_DatePicker.setName("kdtEntrys_enterDate_DatePicker");
        kdtEntrys_enterDate_DatePicker.setVisible(true);
        kdtEntrys_enterDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_enterDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_enterDate_DatePicker);
        this.kdtEntrys.getColumn("enterDate").setEditor(kdtEntrys_enterDate_CellEditor);
        KDFormattedTextField kdtEntrys_basePay_TextField = new KDFormattedTextField();
        kdtEntrys_basePay_TextField.setName("kdtEntrys_basePay_TextField");
        kdtEntrys_basePay_TextField.setVisible(true);
        kdtEntrys_basePay_TextField.setEditable(true);
        kdtEntrys_basePay_TextField.setHorizontalAlignment(2);
        kdtEntrys_basePay_TextField.setDataType(1);
        	kdtEntrys_basePay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_basePay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_basePay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_basePay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_basePay_TextField);
        this.kdtEntrys.getColumn("basePay").setEditor(kdtEntrys_basePay_CellEditor);
        KDFormattedTextField kdtEntrys_monthWork_TextField = new KDFormattedTextField();
        kdtEntrys_monthWork_TextField.setName("kdtEntrys_monthWork_TextField");
        kdtEntrys_monthWork_TextField.setVisible(true);
        kdtEntrys_monthWork_TextField.setEditable(true);
        kdtEntrys_monthWork_TextField.setHorizontalAlignment(2);
        kdtEntrys_monthWork_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_monthWork_CellEditor = new KDTDefaultCellEditor(kdtEntrys_monthWork_TextField);
        this.kdtEntrys.getColumn("monthWork").setEditor(kdtEntrys_monthWork_CellEditor);
        KDFormattedTextField kdtEntrys_absence_TextField = new KDFormattedTextField();
        kdtEntrys_absence_TextField.setName("kdtEntrys_absence_TextField");
        kdtEntrys_absence_TextField.setVisible(true);
        kdtEntrys_absence_TextField.setEditable(true);
        kdtEntrys_absence_TextField.setHorizontalAlignment(2);
        kdtEntrys_absence_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_absence_CellEditor = new KDTDefaultCellEditor(kdtEntrys_absence_TextField);
        this.kdtEntrys.getColumn("absence").setEditor(kdtEntrys_absence_CellEditor);
        KDFormattedTextField kdtEntrys_absDebit_TextField = new KDFormattedTextField();
        kdtEntrys_absDebit_TextField.setName("kdtEntrys_absDebit_TextField");
        kdtEntrys_absDebit_TextField.setVisible(true);
        kdtEntrys_absDebit_TextField.setEditable(true);
        kdtEntrys_absDebit_TextField.setHorizontalAlignment(2);
        kdtEntrys_absDebit_TextField.setDataType(1);
        	kdtEntrys_absDebit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_absDebit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_absDebit_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_absDebit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_absDebit_TextField);
        this.kdtEntrys.getColumn("absDebit").setEditor(kdtEntrys_absDebit_CellEditor);
        KDFormattedTextField kdtEntrys_normalOver_TextField = new KDFormattedTextField();
        kdtEntrys_normalOver_TextField.setName("kdtEntrys_normalOver_TextField");
        kdtEntrys_normalOver_TextField.setVisible(true);
        kdtEntrys_normalOver_TextField.setEditable(true);
        kdtEntrys_normalOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_normalOver_TextField.setDataType(1);
        	kdtEntrys_normalOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_normalOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_normalOver_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_normalOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_normalOver_TextField);
        this.kdtEntrys.getColumn("normalOver").setEditor(kdtEntrys_normalOver_CellEditor);
        KDFormattedTextField kdtEntrys_moreOver_TextField = new KDFormattedTextField();
        kdtEntrys_moreOver_TextField.setName("kdtEntrys_moreOver_TextField");
        kdtEntrys_moreOver_TextField.setVisible(true);
        kdtEntrys_moreOver_TextField.setEditable(true);
        kdtEntrys_moreOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_moreOver_TextField.setDataType(1);
        	kdtEntrys_moreOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_moreOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_moreOver_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_moreOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_moreOver_TextField);
        this.kdtEntrys.getColumn("moreOver").setEditor(kdtEntrys_moreOver_CellEditor);
        KDFormattedTextField kdtEntrys_festOver_TextField = new KDFormattedTextField();
        kdtEntrys_festOver_TextField.setName("kdtEntrys_festOver_TextField");
        kdtEntrys_festOver_TextField.setVisible(true);
        kdtEntrys_festOver_TextField.setEditable(true);
        kdtEntrys_festOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_festOver_TextField.setDataType(1);
        	kdtEntrys_festOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_festOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_festOver_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_festOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_festOver_TextField);
        this.kdtEntrys.getColumn("festOver").setEditor(kdtEntrys_festOver_CellEditor);
        KDFormattedTextField kdtEntrys_profWage_TextField = new KDFormattedTextField();
        kdtEntrys_profWage_TextField.setName("kdtEntrys_profWage_TextField");
        kdtEntrys_profWage_TextField.setVisible(true);
        kdtEntrys_profWage_TextField.setEditable(true);
        kdtEntrys_profWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_profWage_TextField.setDataType(1);
        	kdtEntrys_profWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_profWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_profWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_profWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_profWage_TextField);
        this.kdtEntrys.getColumn("profWage").setEditor(kdtEntrys_profWage_CellEditor);
        KDFormattedTextField kdtEntrys_extProfWage_TextField = new KDFormattedTextField();
        kdtEntrys_extProfWage_TextField.setName("kdtEntrys_extProfWage_TextField");
        kdtEntrys_extProfWage_TextField.setVisible(true);
        kdtEntrys_extProfWage_TextField.setEditable(true);
        kdtEntrys_extProfWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_extProfWage_TextField.setDataType(1);
        	kdtEntrys_extProfWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_extProfWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_extProfWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_extProfWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_extProfWage_TextField);
        this.kdtEntrys.getColumn("extProfWage").setEditor(kdtEntrys_extProfWage_CellEditor);
        KDFormattedTextField kdtEntrys_secuDebit_TextField = new KDFormattedTextField();
        kdtEntrys_secuDebit_TextField.setName("kdtEntrys_secuDebit_TextField");
        kdtEntrys_secuDebit_TextField.setVisible(true);
        kdtEntrys_secuDebit_TextField.setEditable(true);
        kdtEntrys_secuDebit_TextField.setHorizontalAlignment(2);
        kdtEntrys_secuDebit_TextField.setDataType(1);
        	kdtEntrys_secuDebit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_secuDebit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_secuDebit_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_secuDebit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_secuDebit_TextField);
        this.kdtEntrys.getColumn("secuDebit").setEditor(kdtEntrys_secuDebit_CellEditor);
        KDFormattedTextField kdtEntrys_vacaDebit_TextField = new KDFormattedTextField();
        kdtEntrys_vacaDebit_TextField.setName("kdtEntrys_vacaDebit_TextField");
        kdtEntrys_vacaDebit_TextField.setVisible(true);
        kdtEntrys_vacaDebit_TextField.setEditable(true);
        kdtEntrys_vacaDebit_TextField.setHorizontalAlignment(2);
        kdtEntrys_vacaDebit_TextField.setDataType(1);
        	kdtEntrys_vacaDebit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_vacaDebit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_vacaDebit_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_vacaDebit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vacaDebit_TextField);
        this.kdtEntrys.getColumn("vacaDebit").setEditor(kdtEntrys_vacaDebit_CellEditor);
        KDFormattedTextField kdtEntrys_persTax_TextField = new KDFormattedTextField();
        kdtEntrys_persTax_TextField.setName("kdtEntrys_persTax_TextField");
        kdtEntrys_persTax_TextField.setVisible(true);
        kdtEntrys_persTax_TextField.setEditable(true);
        kdtEntrys_persTax_TextField.setHorizontalAlignment(2);
        kdtEntrys_persTax_TextField.setDataType(1);
        	kdtEntrys_persTax_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_persTax_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_persTax_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_persTax_CellEditor = new KDTDefaultCellEditor(kdtEntrys_persTax_TextField);
        this.kdtEntrys.getColumn("persTax").setEditor(kdtEntrys_persTax_CellEditor);
        KDFormattedTextField kdtEntrys_chineWage_TextField = new KDFormattedTextField();
        kdtEntrys_chineWage_TextField.setName("kdtEntrys_chineWage_TextField");
        kdtEntrys_chineWage_TextField.setVisible(true);
        kdtEntrys_chineWage_TextField.setEditable(true);
        kdtEntrys_chineWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_chineWage_TextField.setDataType(1);
        	kdtEntrys_chineWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_chineWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_chineWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_chineWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_chineWage_TextField);
        this.kdtEntrys.getColumn("chineWage").setEditor(kdtEntrys_chineWage_CellEditor);
        KDFormattedTextField kdtEntrys_algerWage_TextField = new KDFormattedTextField();
        kdtEntrys_algerWage_TextField.setName("kdtEntrys_algerWage_TextField");
        kdtEntrys_algerWage_TextField.setVisible(true);
        kdtEntrys_algerWage_TextField.setEditable(true);
        kdtEntrys_algerWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_algerWage_TextField.setDataType(1);
        	kdtEntrys_algerWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_algerWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_algerWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_algerWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_algerWage_TextField);
        this.kdtEntrys.getColumn("algerWage").setEditor(kdtEntrys_algerWage_CellEditor);
        KDFormattedTextField kdtEntrys_traWage_TextField = new KDFormattedTextField();
        kdtEntrys_traWage_TextField.setName("kdtEntrys_traWage_TextField");
        kdtEntrys_traWage_TextField.setVisible(true);
        kdtEntrys_traWage_TextField.setEditable(true);
        kdtEntrys_traWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_traWage_TextField.setDataType(1);
        	kdtEntrys_traWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_traWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_traWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_traWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_traWage_TextField);
        this.kdtEntrys.getColumn("traWage").setEditor(kdtEntrys_traWage_CellEditor);
        KDFormattedTextField kdtEntrys_bTripWage_TextField = new KDFormattedTextField();
        kdtEntrys_bTripWage_TextField.setName("kdtEntrys_bTripWage_TextField");
        kdtEntrys_bTripWage_TextField.setVisible(true);
        kdtEntrys_bTripWage_TextField.setEditable(true);
        kdtEntrys_bTripWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_bTripWage_TextField.setDataType(1);
        	kdtEntrys_bTripWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_bTripWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_bTripWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_bTripWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bTripWage_TextField);
        this.kdtEntrys.getColumn("bTripWage").setEditor(kdtEntrys_bTripWage_CellEditor);
        KDFormattedTextField kdtEntrys_oneWorkWage_TextField = new KDFormattedTextField();
        kdtEntrys_oneWorkWage_TextField.setName("kdtEntrys_oneWorkWage_TextField");
        kdtEntrys_oneWorkWage_TextField.setVisible(true);
        kdtEntrys_oneWorkWage_TextField.setEditable(true);
        kdtEntrys_oneWorkWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_oneWorkWage_TextField.setDataType(1);
        	kdtEntrys_oneWorkWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_oneWorkWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_oneWorkWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_oneWorkWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oneWorkWage_TextField);
        this.kdtEntrys.getColumn("oneWorkWage").setEditor(kdtEntrys_oneWorkWage_CellEditor);
        KDFormattedTextField kdtEntrys_riskWage_TextField = new KDFormattedTextField();
        kdtEntrys_riskWage_TextField.setName("kdtEntrys_riskWage_TextField");
        kdtEntrys_riskWage_TextField.setVisible(true);
        kdtEntrys_riskWage_TextField.setEditable(true);
        kdtEntrys_riskWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_riskWage_TextField.setDataType(1);
        	kdtEntrys_riskWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_riskWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_riskWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_riskWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_riskWage_TextField);
        this.kdtEntrys.getColumn("riskWage").setEditor(kdtEntrys_riskWage_CellEditor);
        KDFormattedTextField kdtEntrys_disasWage_TextField = new KDFormattedTextField();
        kdtEntrys_disasWage_TextField.setName("kdtEntrys_disasWage_TextField");
        kdtEntrys_disasWage_TextField.setVisible(true);
        kdtEntrys_disasWage_TextField.setEditable(true);
        kdtEntrys_disasWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_disasWage_TextField.setDataType(1);
        	kdtEntrys_disasWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_disasWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_disasWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_disasWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_disasWage_TextField);
        this.kdtEntrys.getColumn("disasWage").setEditor(kdtEntrys_disasWage_CellEditor);
        KDFormattedTextField kdtEntrys_eatWage_TextField = new KDFormattedTextField();
        kdtEntrys_eatWage_TextField.setName("kdtEntrys_eatWage_TextField");
        kdtEntrys_eatWage_TextField.setVisible(true);
        kdtEntrys_eatWage_TextField.setEditable(true);
        kdtEntrys_eatWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_eatWage_TextField.setDataType(1);
        	kdtEntrys_eatWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_eatWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_eatWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_eatWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eatWage_TextField);
        this.kdtEntrys.getColumn("eatWage").setEditor(kdtEntrys_eatWage_CellEditor);
        KDFormattedTextField kdtEntrys_overTraWage_TextField = new KDFormattedTextField();
        kdtEntrys_overTraWage_TextField.setName("kdtEntrys_overTraWage_TextField");
        kdtEntrys_overTraWage_TextField.setVisible(true);
        kdtEntrys_overTraWage_TextField.setEditable(true);
        kdtEntrys_overTraWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_overTraWage_TextField.setDataType(1);
        	kdtEntrys_overTraWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_overTraWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_overTraWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_overTraWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_overTraWage_TextField);
        this.kdtEntrys.getColumn("overTraWage").setEditor(kdtEntrys_overTraWage_CellEditor);
        KDFormattedTextField kdtEntrys_areaWage_TextField = new KDFormattedTextField();
        kdtEntrys_areaWage_TextField.setName("kdtEntrys_areaWage_TextField");
        kdtEntrys_areaWage_TextField.setVisible(true);
        kdtEntrys_areaWage_TextField.setEditable(true);
        kdtEntrys_areaWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_areaWage_TextField.setDataType(1);
        	kdtEntrys_areaWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_areaWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_areaWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_areaWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_areaWage_TextField);
        this.kdtEntrys.getColumn("areaWage").setEditor(kdtEntrys_areaWage_CellEditor);
        KDFormattedTextField kdtEntrys_thingsWage_TextField = new KDFormattedTextField();
        kdtEntrys_thingsWage_TextField.setName("kdtEntrys_thingsWage_TextField");
        kdtEntrys_thingsWage_TextField.setVisible(true);
        kdtEntrys_thingsWage_TextField.setEditable(true);
        kdtEntrys_thingsWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_thingsWage_TextField.setDataType(1);
        	kdtEntrys_thingsWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_thingsWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_thingsWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_thingsWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_thingsWage_TextField);
        this.kdtEntrys.getColumn("thingsWage").setEditor(kdtEntrys_thingsWage_CellEditor);
        KDFormattedTextField kdtEntrys_switchWage_TextField = new KDFormattedTextField();
        kdtEntrys_switchWage_TextField.setName("kdtEntrys_switchWage_TextField");
        kdtEntrys_switchWage_TextField.setVisible(true);
        kdtEntrys_switchWage_TextField.setEditable(true);
        kdtEntrys_switchWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_switchWage_TextField.setDataType(1);
        	kdtEntrys_switchWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_switchWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_switchWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_switchWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_switchWage_TextField);
        this.kdtEntrys.getColumn("switchWage").setEditor(kdtEntrys_switchWage_CellEditor);
        KDFormattedTextField kdtEntrys_nWorkWage_TextField = new KDFormattedTextField();
        kdtEntrys_nWorkWage_TextField.setName("kdtEntrys_nWorkWage_TextField");
        kdtEntrys_nWorkWage_TextField.setVisible(true);
        kdtEntrys_nWorkWage_TextField.setEditable(true);
        kdtEntrys_nWorkWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_nWorkWage_TextField.setDataType(1);
        	kdtEntrys_nWorkWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nWorkWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nWorkWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nWorkWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nWorkWage_TextField);
        this.kdtEntrys.getColumn("nWorkWage").setEditor(kdtEntrys_nWorkWage_CellEditor);
        KDFormattedTextField kdtEntrys_liveWage_TextField = new KDFormattedTextField();
        kdtEntrys_liveWage_TextField.setName("kdtEntrys_liveWage_TextField");
        kdtEntrys_liveWage_TextField.setVisible(true);
        kdtEntrys_liveWage_TextField.setEditable(true);
        kdtEntrys_liveWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_liveWage_TextField.setDataType(1);
        	kdtEntrys_liveWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_liveWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_liveWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_liveWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_liveWage_TextField);
        this.kdtEntrys.getColumn("liveWage").setEditor(kdtEntrys_liveWage_CellEditor);
        KDFormattedTextField kdtEntrys_spendWage_TextField = new KDFormattedTextField();
        kdtEntrys_spendWage_TextField.setName("kdtEntrys_spendWage_TextField");
        kdtEntrys_spendWage_TextField.setVisible(true);
        kdtEntrys_spendWage_TextField.setEditable(true);
        kdtEntrys_spendWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_spendWage_TextField.setDataType(1);
        	kdtEntrys_spendWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_spendWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_spendWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_spendWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_spendWage_TextField);
        this.kdtEntrys.getColumn("spendWage").setEditor(kdtEntrys_spendWage_CellEditor);
        KDFormattedTextField kdtEntrys_fireWage_TextField = new KDFormattedTextField();
        kdtEntrys_fireWage_TextField.setName("kdtEntrys_fireWage_TextField");
        kdtEntrys_fireWage_TextField.setVisible(true);
        kdtEntrys_fireWage_TextField.setEditable(true);
        kdtEntrys_fireWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_fireWage_TextField.setDataType(1);
        	kdtEntrys_fireWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fireWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fireWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fireWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fireWage_TextField);
        this.kdtEntrys.getColumn("fireWage").setEditor(kdtEntrys_fireWage_CellEditor);
        KDFormattedTextField kdtEntrys_retirWage_TextField = new KDFormattedTextField();
        kdtEntrys_retirWage_TextField.setName("kdtEntrys_retirWage_TextField");
        kdtEntrys_retirWage_TextField.setVisible(true);
        kdtEntrys_retirWage_TextField.setEditable(true);
        kdtEntrys_retirWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_retirWage_TextField.setDataType(1);
        	kdtEntrys_retirWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_retirWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_retirWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_retirWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_retirWage_TextField);
        this.kdtEntrys.getColumn("retirWage").setEditor(kdtEntrys_retirWage_CellEditor);
        KDFormattedTextField kdtEntrys_faraWage_TextField = new KDFormattedTextField();
        kdtEntrys_faraWage_TextField.setName("kdtEntrys_faraWage_TextField");
        kdtEntrys_faraWage_TextField.setVisible(true);
        kdtEntrys_faraWage_TextField.setEditable(true);
        kdtEntrys_faraWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_faraWage_TextField.setDataType(1);
        	kdtEntrys_faraWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_faraWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_faraWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_faraWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_faraWage_TextField);
        this.kdtEntrys.getColumn("faraWage").setEditor(kdtEntrys_faraWage_CellEditor);
        KDTextField kdtEntrys_unSignWage_TextField = new KDTextField();
        kdtEntrys_unSignWage_TextField.setName("kdtEntrys_unSignWage_TextField");
        kdtEntrys_unSignWage_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_unSignWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unSignWage_TextField);
        this.kdtEntrys.getColumn("unSignWage").setEditor(kdtEntrys_unSignWage_CellEditor);
        KDFormattedTextField kdtEntrys_profAward_TextField = new KDFormattedTextField();
        kdtEntrys_profAward_TextField.setName("kdtEntrys_profAward_TextField");
        kdtEntrys_profAward_TextField.setVisible(true);
        kdtEntrys_profAward_TextField.setEditable(true);
        kdtEntrys_profAward_TextField.setHorizontalAlignment(2);
        kdtEntrys_profAward_TextField.setDataType(1);
        	kdtEntrys_profAward_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_profAward_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_profAward_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_profAward_CellEditor = new KDTDefaultCellEditor(kdtEntrys_profAward_TextField);
        this.kdtEntrys.getColumn("profAward").setEditor(kdtEntrys_profAward_CellEditor);
        KDFormattedTextField kdtEntrys_langWage_TextField = new KDFormattedTextField();
        kdtEntrys_langWage_TextField.setName("kdtEntrys_langWage_TextField");
        kdtEntrys_langWage_TextField.setVisible(true);
        kdtEntrys_langWage_TextField.setEditable(true);
        kdtEntrys_langWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_langWage_TextField.setDataType(1);
        	kdtEntrys_langWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_langWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_langWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_langWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_langWage_TextField);
        this.kdtEntrys.getColumn("langWage").setEditor(kdtEntrys_langWage_CellEditor);
        KDFormattedTextField kdtEntrys_urgeWage_TextField = new KDFormattedTextField();
        kdtEntrys_urgeWage_TextField.setName("kdtEntrys_urgeWage_TextField");
        kdtEntrys_urgeWage_TextField.setVisible(true);
        kdtEntrys_urgeWage_TextField.setEditable(true);
        kdtEntrys_urgeWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_urgeWage_TextField.setDataType(1);
        	kdtEntrys_urgeWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_urgeWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_urgeWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_urgeWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_urgeWage_TextField);
        this.kdtEntrys.getColumn("urgeWage").setEditor(kdtEntrys_urgeWage_CellEditor);
        KDFormattedTextField kdtEntrys_monthAward_TextField = new KDFormattedTextField();
        kdtEntrys_monthAward_TextField.setName("kdtEntrys_monthAward_TextField");
        kdtEntrys_monthAward_TextField.setVisible(true);
        kdtEntrys_monthAward_TextField.setEditable(true);
        kdtEntrys_monthAward_TextField.setHorizontalAlignment(2);
        kdtEntrys_monthAward_TextField.setDataType(1);
        	kdtEntrys_monthAward_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_monthAward_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_monthAward_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_monthAward_CellEditor = new KDTDefaultCellEditor(kdtEntrys_monthAward_TextField);
        this.kdtEntrys.getColumn("monthAward").setEditor(kdtEntrys_monthAward_CellEditor);
        KDFormattedTextField kdtEntrys_indPay_TextField = new KDFormattedTextField();
        kdtEntrys_indPay_TextField.setName("kdtEntrys_indPay_TextField");
        kdtEntrys_indPay_TextField.setVisible(true);
        kdtEntrys_indPay_TextField.setEditable(true);
        kdtEntrys_indPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_indPay_TextField.setDataType(1);
        	kdtEntrys_indPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_indPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_indPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_indPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_indPay_TextField);
        this.kdtEntrys.getColumn("indPay").setEditor(kdtEntrys_indPay_CellEditor);
        KDFormattedTextField kdtEntrys_netPay_TextField = new KDFormattedTextField();
        kdtEntrys_netPay_TextField.setName("kdtEntrys_netPay_TextField");
        kdtEntrys_netPay_TextField.setVisible(true);
        kdtEntrys_netPay_TextField.setEditable(true);
        kdtEntrys_netPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_netPay_TextField.setDataType(1);
        	kdtEntrys_netPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_netPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_netPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_netPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_netPay_TextField);
        this.kdtEntrys.getColumn("netPay").setEditor(kdtEntrys_netPay_CellEditor);
        KDFormattedTextField kdtEntrys_seniWage_TextField = new KDFormattedTextField();
        kdtEntrys_seniWage_TextField.setName("kdtEntrys_seniWage_TextField");
        kdtEntrys_seniWage_TextField.setVisible(true);
        kdtEntrys_seniWage_TextField.setEditable(true);
        kdtEntrys_seniWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_seniWage_TextField.setDataType(1);
        	kdtEntrys_seniWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seniWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seniWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seniWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seniWage_TextField);
        this.kdtEntrys.getColumn("seniWage").setEditor(kdtEntrys_seniWage_CellEditor);
        KDFormattedTextField kdtEntrys_wifeUnWage_TextField = new KDFormattedTextField();
        kdtEntrys_wifeUnWage_TextField.setName("kdtEntrys_wifeUnWage_TextField");
        kdtEntrys_wifeUnWage_TextField.setVisible(true);
        kdtEntrys_wifeUnWage_TextField.setEditable(true);
        kdtEntrys_wifeUnWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_wifeUnWage_TextField.setDataType(1);
        	kdtEntrys_wifeUnWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_wifeUnWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_wifeUnWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_wifeUnWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wifeUnWage_TextField);
        this.kdtEntrys.getColumn("wifeUnWage").setEditor(kdtEntrys_wifeUnWage_CellEditor);
        KDFormattedTextField kdtEntrys_FamilyWage_TextField = new KDFormattedTextField();
        kdtEntrys_FamilyWage_TextField.setName("kdtEntrys_FamilyWage_TextField");
        kdtEntrys_FamilyWage_TextField.setVisible(true);
        kdtEntrys_FamilyWage_TextField.setEditable(true);
        kdtEntrys_FamilyWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_FamilyWage_TextField.setDataType(1);
        	kdtEntrys_FamilyWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_FamilyWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_FamilyWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_FamilyWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_FamilyWage_TextField);
        this.kdtEntrys.getColumn("FamilyWage").setEditor(kdtEntrys_FamilyWage_CellEditor);
        KDFormattedTextField kdtEntrys_studyWage_TextField = new KDFormattedTextField();
        kdtEntrys_studyWage_TextField.setName("kdtEntrys_studyWage_TextField");
        kdtEntrys_studyWage_TextField.setVisible(true);
        kdtEntrys_studyWage_TextField.setEditable(true);
        kdtEntrys_studyWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_studyWage_TextField.setDataType(1);
        	kdtEntrys_studyWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_studyWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_studyWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_studyWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_studyWage_TextField);
        this.kdtEntrys.getColumn("studyWage").setEditor(kdtEntrys_studyWage_CellEditor);
        KDFormattedTextField kdtEntrys_unSCVCWage_TextField = new KDFormattedTextField();
        kdtEntrys_unSCVCWage_TextField.setName("kdtEntrys_unSCVCWage_TextField");
        kdtEntrys_unSCVCWage_TextField.setVisible(true);
        kdtEntrys_unSCVCWage_TextField.setEditable(true);
        kdtEntrys_unSCVCWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_unSCVCWage_TextField.setDataType(1);
        	kdtEntrys_unSCVCWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unSCVCWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unSCVCWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unSCVCWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unSCVCWage_TextField);
        this.kdtEntrys.getColumn("unSCVCWage").setEditor(kdtEntrys_unSCVCWage_CellEditor);
        // contbillSate		
        this.contbillSate.setBoundLabelText(resHelper.getString("contbillSate.boundLabelText"));		
        this.contbillSate.setBoundLabelLength(100);		
        this.contbillSate.setBoundLabelUnderline(true);		
        this.contbillSate.setVisible(true);
        // contAuditDate		
        this.contAuditDate.setBoundLabelText(resHelper.getString("contAuditDate.boundLabelText"));		
        this.contAuditDate.setBoundLabelLength(100);		
        this.contAuditDate.setBoundLabelUnderline(true);		
        this.contAuditDate.setVisible(true);
        // contprojName		
        this.contprojName.setBoundLabelText(resHelper.getString("contprojName.boundLabelText"));		
        this.contprojName.setBoundLabelLength(100);		
        this.contprojName.setBoundLabelUnderline(true);		
        this.contprojName.setVisible(true);
        // contprojSCNum		
        this.contprojSCNum.setBoundLabelText(resHelper.getString("contprojSCNum.boundLabelText"));		
        this.contprojSCNum.setBoundLabelLength(100);		
        this.contprojSCNum.setBoundLabelUnderline(true);		
        this.contprojSCNum.setVisible(true);
        // contprojAddr		
        this.contprojAddr.setBoundLabelText(resHelper.getString("contprojAddr.boundLabelText"));		
        this.contprojAddr.setBoundLabelLength(100);		
        this.contprojAddr.setBoundLabelUnderline(true);		
        this.contprojAddr.setVisible(true);
        // contmonthYearr		
        this.contmonthYearr.setBoundLabelText(resHelper.getString("contmonthYearr.boundLabelText"));		
        this.contmonthYearr.setBoundLabelLength(100);		
        this.contmonthYearr.setBoundLabelUnderline(true);		
        this.contmonthYearr.setVisible(true);
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
        // pkAuditDate		
        this.pkAuditDate.setRequired(false);
        // prmtprojName		
        this.prmtprojName.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtprojName.setEditable(true);		
        this.prmtprojName.setDisplayFormat("$name$");		
        this.prmtprojName.setEditFormat("$number$");		
        this.prmtprojName.setCommitFormat("$number$");		
        this.prmtprojName.setRequired(false);
        // txtprojSCNum		
        this.txtprojSCNum.setHorizontalAlignment(2);		
        this.txtprojSCNum.setMaxLength(100);		
        this.txtprojSCNum.setRequired(false);
        // txtprojAddr		
        this.txtprojAddr.setHorizontalAlignment(2);		
        this.txtprojAddr.setMaxLength(100);		
        this.txtprojAddr.setRequired(false);
        // prmtmonthYearr		
        this.prmtmonthYearr.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtmonthYearr.setEditable(true);		
        this.prmtmonthYearr.setDisplayFormat("$number$");		
        this.prmtmonthYearr.setEditFormat("$number$");		
        this.prmtmonthYearr.setCommitFormat("$number$");		
        this.prmtmonthYearr.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billSate,pkAuditDate,prmtprojName,txtprojSCNum,txtprojAddr,prmtmonthYearr,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 10, 1152, 528));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 10, 1152, 528));
        contCreator.setBounds(new Rectangle(17, 496, 263, 19));
        this.add(contCreator, new KDLayout.Constraints(17, 496, 263, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(302, 496, 263, 19));
        this.add(contCreateTime, new KDLayout.Constraints(302, 496, 263, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(440, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(440, 555, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(730, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 555, 270, 19, 0));
        contNumber.setBounds(new Rectangle(24, 10, 262, 19));
        this.add(contNumber, new KDLayout.Constraints(24, 10, 262, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(307, 10, 262, 19));
        this.add(contBizDate, new KDLayout.Constraints(307, 10, 262, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(875, 41, 262, 19));
        this.add(contDescription, new KDLayout.Constraints(875, 41, 262, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(587, 496, 263, 19));
        this.add(contAuditor, new KDLayout.Constraints(587, 496, 263, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(20, 73, 1120, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.social.PayBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(20, 73, 1120, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("sex",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contbillSate.setBounds(new Rectangle(875, 10, 262, 19));
        this.add(contbillSate, new KDLayout.Constraints(875, 10, 262, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditDate.setBounds(new Rectangle(873, 496, 263, 19));
        this.add(contAuditDate, new KDLayout.Constraints(873, 496, 263, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contprojName.setBounds(new Rectangle(24, 41, 262, 19));
        this.add(contprojName, new KDLayout.Constraints(24, 41, 262, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprojSCNum.setBounds(new Rectangle(305, 41, 262, 19));
        this.add(contprojSCNum, new KDLayout.Constraints(305, 41, 262, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprojAddr.setBounds(new Rectangle(586, 41, 270, 19));
        this.add(contprojAddr, new KDLayout.Constraints(586, 41, 270, 19, 0));
        contmonthYearr.setBounds(new Rectangle(586, 10, 270, 19));
        this.add(contmonthYearr, new KDLayout.Constraints(586, 10, 270, 19, 0));
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
        //contAuditDate
        contAuditDate.setBoundEditor(pkAuditDate);
        //contprojName
        contprojName.setBoundEditor(prmtprojName);
        //contprojSCNum
        contprojSCNum.setBoundEditor(txtprojSCNum);
        //contprojAddr
        contprojAddr.setBoundEditor(txtprojAddr);
        //contmonthYearr
        contmonthYearr.setBoundEditor(prmtmonthYearr);

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
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.social.PayBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.enterDate", java.util.Date.class, this.kdtEntrys, "enterDate.text");
		dataBinder.registerBinding("entrys.basePay", java.math.BigDecimal.class, this.kdtEntrys, "basePay.text");
		dataBinder.registerBinding("entrys.monthWork", int.class, this.kdtEntrys, "monthWork.text");
		dataBinder.registerBinding("entrys.absence", int.class, this.kdtEntrys, "absence.text");
		dataBinder.registerBinding("entrys.absDebit", java.math.BigDecimal.class, this.kdtEntrys, "absDebit.text");
		dataBinder.registerBinding("entrys.normalOver", java.math.BigDecimal.class, this.kdtEntrys, "normalOver.text");
		dataBinder.registerBinding("entrys.moreOver", java.math.BigDecimal.class, this.kdtEntrys, "moreOver.text");
		dataBinder.registerBinding("entrys.festOver", java.math.BigDecimal.class, this.kdtEntrys, "festOver.text");
		dataBinder.registerBinding("entrys.profWage", java.math.BigDecimal.class, this.kdtEntrys, "profWage.text");
		dataBinder.registerBinding("entrys.extProfWage", java.math.BigDecimal.class, this.kdtEntrys, "extProfWage.text");
		dataBinder.registerBinding("entrys.secuDebit", java.math.BigDecimal.class, this.kdtEntrys, "secuDebit.text");
		dataBinder.registerBinding("entrys.vacaDebit", java.math.BigDecimal.class, this.kdtEntrys, "vacaDebit.text");
		dataBinder.registerBinding("entrys.persTax", java.math.BigDecimal.class, this.kdtEntrys, "persTax.text");
		dataBinder.registerBinding("entrys.chineWage", java.math.BigDecimal.class, this.kdtEntrys, "chineWage.text");
		dataBinder.registerBinding("entrys.algerWage", java.math.BigDecimal.class, this.kdtEntrys, "algerWage.text");
		dataBinder.registerBinding("entrys.traWage", java.math.BigDecimal.class, this.kdtEntrys, "traWage.text");
		dataBinder.registerBinding("entrys.bTripWage", java.math.BigDecimal.class, this.kdtEntrys, "bTripWage.text");
		dataBinder.registerBinding("entrys.oneWorkWage", java.math.BigDecimal.class, this.kdtEntrys, "oneWorkWage.text");
		dataBinder.registerBinding("entrys.riskWage", java.math.BigDecimal.class, this.kdtEntrys, "riskWage.text");
		dataBinder.registerBinding("entrys.disasWage", java.math.BigDecimal.class, this.kdtEntrys, "disasWage.text");
		dataBinder.registerBinding("entrys.eatWage", java.math.BigDecimal.class, this.kdtEntrys, "eatWage.text");
		dataBinder.registerBinding("entrys.overTraWage", java.math.BigDecimal.class, this.kdtEntrys, "overTraWage.text");
		dataBinder.registerBinding("entrys.areaWage", java.math.BigDecimal.class, this.kdtEntrys, "areaWage.text");
		dataBinder.registerBinding("entrys.thingsWage", java.math.BigDecimal.class, this.kdtEntrys, "thingsWage.text");
		dataBinder.registerBinding("entrys.switchWage", java.math.BigDecimal.class, this.kdtEntrys, "switchWage.text");
		dataBinder.registerBinding("entrys.nWorkWage", java.math.BigDecimal.class, this.kdtEntrys, "nWorkWage.text");
		dataBinder.registerBinding("entrys.liveWage", java.math.BigDecimal.class, this.kdtEntrys, "liveWage.text");
		dataBinder.registerBinding("entrys.spendWage", java.math.BigDecimal.class, this.kdtEntrys, "spendWage.text");
		dataBinder.registerBinding("entrys.fireWage", java.math.BigDecimal.class, this.kdtEntrys, "fireWage.text");
		dataBinder.registerBinding("entrys.retirWage", java.math.BigDecimal.class, this.kdtEntrys, "retirWage.text");
		dataBinder.registerBinding("entrys.faraWage", java.math.BigDecimal.class, this.kdtEntrys, "faraWage.text");
		dataBinder.registerBinding("entrys.profAward", java.math.BigDecimal.class, this.kdtEntrys, "profAward.text");
		dataBinder.registerBinding("entrys.langWage", java.math.BigDecimal.class, this.kdtEntrys, "langWage.text");
		dataBinder.registerBinding("entrys.urgeWage", java.math.BigDecimal.class, this.kdtEntrys, "urgeWage.text");
		dataBinder.registerBinding("entrys.monthAward", java.math.BigDecimal.class, this.kdtEntrys, "monthAward.text");
		dataBinder.registerBinding("entrys.indPay", java.math.BigDecimal.class, this.kdtEntrys, "indPay.text");
		dataBinder.registerBinding("entrys.netPay", java.math.BigDecimal.class, this.kdtEntrys, "netPay.text");
		dataBinder.registerBinding("entrys.unSignWage", String.class, this.kdtEntrys, "unSignWage.text");
		dataBinder.registerBinding("entrys.seniWage", java.math.BigDecimal.class, this.kdtEntrys, "seniWage.text");
		dataBinder.registerBinding("entrys.wifeUnWage", java.math.BigDecimal.class, this.kdtEntrys, "wifeUnWage.text");
		dataBinder.registerBinding("entrys.FamilyWage", java.math.BigDecimal.class, this.kdtEntrys, "FamilyWage.text");
		dataBinder.registerBinding("entrys.studyWage", java.math.BigDecimal.class, this.kdtEntrys, "studyWage.text");
		dataBinder.registerBinding("entrys.unSCVCWage", java.math.BigDecimal.class, this.kdtEntrys, "unSCVCWage.text");
		dataBinder.registerBinding("entrys.sex", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "sex.text");
		dataBinder.registerBinding("entrys.isMarry", boolean.class, this.kdtEntrys, "isMarry.text");
		dataBinder.registerBinding("entrys.prof", java.lang.Object.class, this.kdtEntrys, "prof.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billSate", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSate, "selectedItem");
		dataBinder.registerBinding("AuditDate", java.util.Date.class, this.pkAuditDate, "value");
		dataBinder.registerBinding("projName", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtprojName, "data");
		dataBinder.registerBinding("projSCNum", String.class, this.txtprojSCNum, "text");
		dataBinder.registerBinding("projAddr", String.class, this.txtprojAddr, "text");
		dataBinder.registerBinding("monthYearr", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtmonthYearr, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.social.app.PayBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.social.PayBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.enterDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.basePay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.monthWork", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.absence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.absDebit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.normalOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.moreOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.festOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.profWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.extProfWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuDebit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vacaDebit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.persTax", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.chineWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.algerWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.traWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bTripWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oneWorkWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.riskWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.disasWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eatWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.overTraWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.areaWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.thingsWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.switchWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nWorkWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.liveWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.spendWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fireWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.retirWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.faraWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.profAward", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.langWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.urgeWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.monthAward", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.indPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.netPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unSignWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seniWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wifeUnWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FamilyWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.studyWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unSCVCWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isMarry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.prof", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projSCNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projAddr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthYearr", ValidateHelper.ON_SAVE);    		
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
		}
    	sic.add(new SelectorItemInfo("entrys.lastName"));
    	sic.add(new SelectorItemInfo("entrys.firstName"));
    	sic.add(new SelectorItemInfo("entrys.enterDate"));
    	sic.add(new SelectorItemInfo("entrys.basePay"));
    	sic.add(new SelectorItemInfo("entrys.monthWork"));
    	sic.add(new SelectorItemInfo("entrys.absence"));
    	sic.add(new SelectorItemInfo("entrys.absDebit"));
    	sic.add(new SelectorItemInfo("entrys.normalOver"));
    	sic.add(new SelectorItemInfo("entrys.moreOver"));
    	sic.add(new SelectorItemInfo("entrys.festOver"));
    	sic.add(new SelectorItemInfo("entrys.profWage"));
    	sic.add(new SelectorItemInfo("entrys.extProfWage"));
    	sic.add(new SelectorItemInfo("entrys.secuDebit"));
    	sic.add(new SelectorItemInfo("entrys.vacaDebit"));
    	sic.add(new SelectorItemInfo("entrys.persTax"));
    	sic.add(new SelectorItemInfo("entrys.chineWage"));
    	sic.add(new SelectorItemInfo("entrys.algerWage"));
    	sic.add(new SelectorItemInfo("entrys.traWage"));
    	sic.add(new SelectorItemInfo("entrys.bTripWage"));
    	sic.add(new SelectorItemInfo("entrys.oneWorkWage"));
    	sic.add(new SelectorItemInfo("entrys.riskWage"));
    	sic.add(new SelectorItemInfo("entrys.disasWage"));
    	sic.add(new SelectorItemInfo("entrys.eatWage"));
    	sic.add(new SelectorItemInfo("entrys.overTraWage"));
    	sic.add(new SelectorItemInfo("entrys.areaWage"));
    	sic.add(new SelectorItemInfo("entrys.thingsWage"));
    	sic.add(new SelectorItemInfo("entrys.switchWage"));
    	sic.add(new SelectorItemInfo("entrys.nWorkWage"));
    	sic.add(new SelectorItemInfo("entrys.liveWage"));
    	sic.add(new SelectorItemInfo("entrys.spendWage"));
    	sic.add(new SelectorItemInfo("entrys.fireWage"));
    	sic.add(new SelectorItemInfo("entrys.retirWage"));
    	sic.add(new SelectorItemInfo("entrys.faraWage"));
    	sic.add(new SelectorItemInfo("entrys.profAward"));
    	sic.add(new SelectorItemInfo("entrys.langWage"));
    	sic.add(new SelectorItemInfo("entrys.urgeWage"));
    	sic.add(new SelectorItemInfo("entrys.monthAward"));
    	sic.add(new SelectorItemInfo("entrys.indPay"));
    	sic.add(new SelectorItemInfo("entrys.netPay"));
    	sic.add(new SelectorItemInfo("entrys.unSignWage"));
    	sic.add(new SelectorItemInfo("entrys.seniWage"));
    	sic.add(new SelectorItemInfo("entrys.wifeUnWage"));
    	sic.add(new SelectorItemInfo("entrys.FamilyWage"));
    	sic.add(new SelectorItemInfo("entrys.studyWage"));
    	sic.add(new SelectorItemInfo("entrys.unSCVCWage"));
    	sic.add(new SelectorItemInfo("entrys.sex"));
    	sic.add(new SelectorItemInfo("entrys.isMarry"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.prof.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.prof.id"));
			sic.add(new SelectorItemInfo("entrys.prof.name"));
			sic.add(new SelectorItemInfo("entrys.prof.( "));
			sic.add(new SelectorItemInfo("entrys.prof.nameFR"));
			sic.add(new SelectorItemInfo("entrys.prof.)"));
        	sic.add(new SelectorItemInfo("entrys.prof.number"));
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
        sic.add(new SelectorItemInfo("billSate"));
        sic.add(new SelectorItemInfo("AuditDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("projName.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("projName.id"));
        	sic.add(new SelectorItemInfo("projName.number"));
        	sic.add(new SelectorItemInfo("projName.name"));
		}
        sic.add(new SelectorItemInfo("projSCNum"));
        sic.add(new SelectorItemInfo("projAddr"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("monthYearr.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("monthYearr.id"));
        	sic.add(new SelectorItemInfo("monthYearr.number"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.social.client", "PayBillEditUI");
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
        return com.kingdee.eas.zjlw.social.client.PayBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.social.PayBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.social.PayBillInfo objectValue = new com.kingdee.eas.zjlw.social.PayBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/social/PayBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.social.app.PayBillQuery");
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