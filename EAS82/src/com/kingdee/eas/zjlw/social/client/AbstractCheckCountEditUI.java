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
public abstract class AbstractCheckCountEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCheckCountEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpermProj;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillSate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthYearr;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpermProj;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshCount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmonthYearr;
    protected com.kingdee.eas.zjlw.social.CheckCountInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCheckCountEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCheckCountEditUI.class.getName());
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
        this.contpermProj = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillSate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthYearr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpermProj = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billSate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkAuditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtshCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contpermProj.setName("contpermProj");
        this.contbillSate.setName("contbillSate");
        this.contAuditDate.setName("contAuditDate");
        this.contshCount.setName("contshCount");
        this.contmonthYearr.setName("contmonthYearr");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtpermProj.setName("prmtpermProj");
        this.billSate.setName("billSate");
        this.pkAuditDate.setName("pkAuditDate");
        this.txtshCount.setName("txtshCount");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol36\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol45\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol48\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol50\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol51\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol52\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol53\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol54\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol55\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol56\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol57\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol58\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol59\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol60\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol61\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol62\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol63\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol64\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol65\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol66\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol67\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol68\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol69\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol70\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol71\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol72\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol73\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol74\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol75\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol76\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol77\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol78\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol79\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol80\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol81\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol82\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol83\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol84\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"projSocialNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"secuProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"sex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"birthdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"birthPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"nation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"MariState\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"IDNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthIDNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"secuNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"apprTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"endDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"secuProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"nBasePay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"nSeniority\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"seniPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"nWorkDay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"nUlOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"nHlOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"traWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"eWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"totRiskWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"dengWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"vaWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"nUrgeWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"oneTimeWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"outWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"phoneWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"thingsWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"thingsTimes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"totOneWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"oneWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"nWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"nWorkTimes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"langWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"areaWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"switchWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"switchTimes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"faraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"spendWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"itmperie\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"itmperieTol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"coopCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"foriPersID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"CCPNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"address\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workProgram\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol50\" /><t:Column t:key=\"cooperation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"outWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol52\" /><t:Column t:key=\"outTimes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol53\" /><t:Column t:key=\"oveWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol54\" /><t:Column t:key=\"oveTimes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol55\" /><t:Column t:key=\"traWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol56\" /><t:Column t:key=\"eWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol57\" /><t:Column t:key=\"vaWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol58\" /><t:Column t:key=\"thingsWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol59\" /><t:Column t:key=\"switchWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol60\" /><t:Column t:key=\"totAreaWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol61\" /><t:Column t:key=\"totFaraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /><t:Column t:key=\"liveWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol63\" /><t:Column t:key=\"familyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol64\" /><t:Column t:key=\"studyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol65\" /><t:Column t:key=\"fireWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol66\" /><t:Column t:key=\"retirWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol67\" /><t:Column t:key=\"pOverAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol68\" /><t:Column t:key=\"contSDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol69\" /><t:Column t:key=\"contEDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol70\" /><t:Column t:key=\"startDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol71\" /><t:Column t:key=\"nGalaOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol72\" /><t:Column t:key=\"sevWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol73\" /><t:Column t:key=\"sevTimes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol74\" /><t:Column t:key=\"sevWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol75\" /><t:Column t:key=\"profWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol76\" /><t:Column t:key=\"extProfWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol77\" /><t:Column t:key=\"nWorkWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol78\" /><t:Column t:key=\"profAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol79\" /><t:Column t:key=\"unSCVCWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol80\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol81\" /><t:Column t:key=\"prof\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol82\" /><t:Column t:key=\"province\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol83\" /><t:Column t:key=\"nWorkDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol84\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{projSocialNo}</t:Cell><t:Cell>$Resource{secuProj}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{birthdate}</t:Cell><t:Cell>$Resource{birthPlace}</t:Cell><t:Cell>$Resource{nation}</t:Cell><t:Cell>$Resource{MariState}</t:Cell><t:Cell>$Resource{IDNumber}</t:Cell><t:Cell>$Resource{birthIDNumber}</t:Cell><t:Cell>$Resource{secuNum}</t:Cell><t:Cell>$Resource{apprTime}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{secuProf}</t:Cell><t:Cell>$Resource{nBasePay}</t:Cell><t:Cell>$Resource{nSeniority}</t:Cell><t:Cell>$Resource{seniPay}</t:Cell><t:Cell>$Resource{nWorkDay}</t:Cell><t:Cell>$Resource{nUlOver}</t:Cell><t:Cell>$Resource{nHlOver}</t:Cell><t:Cell>$Resource{traWage}</t:Cell><t:Cell>$Resource{eWage}</t:Cell><t:Cell>$Resource{totRiskWage}</t:Cell><t:Cell>$Resource{dengWage}</t:Cell><t:Cell>$Resource{vaWage}</t:Cell><t:Cell>$Resource{nUrgeWage}</t:Cell><t:Cell>$Resource{oneTimeWage}</t:Cell><t:Cell>$Resource{outWageC}</t:Cell><t:Cell>$Resource{phoneWageC}</t:Cell><t:Cell>$Resource{thingsWage}</t:Cell><t:Cell>$Resource{thingsTimes}</t:Cell><t:Cell>$Resource{totOneWage}</t:Cell><t:Cell>$Resource{oneWorkWage}</t:Cell><t:Cell>$Resource{nWorkWage}</t:Cell><t:Cell>$Resource{nWorkTimes}</t:Cell><t:Cell>$Resource{langWage}</t:Cell><t:Cell>$Resource{areaWage}</t:Cell><t:Cell>$Resource{switchWage}</t:Cell><t:Cell>$Resource{switchTimes}</t:Cell><t:Cell>$Resource{faraWage}</t:Cell><t:Cell>$Resource{spendWage}</t:Cell><t:Cell>$Resource{itmperie}</t:Cell><t:Cell>$Resource{itmperieTol}</t:Cell><t:Cell>$Resource{coopCode}</t:Cell><t:Cell>$Resource{foriPersID}</t:Cell><t:Cell>$Resource{CCPNo}</t:Cell><t:Cell>$Resource{address}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{workProgram}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{outWage}</t:Cell><t:Cell>$Resource{outTimes}</t:Cell><t:Cell>$Resource{oveWage}</t:Cell><t:Cell>$Resource{oveTimes}</t:Cell><t:Cell>$Resource{traWageC}</t:Cell><t:Cell>$Resource{eWageC}</t:Cell><t:Cell>$Resource{vaWageC}</t:Cell><t:Cell>$Resource{thingsWageC}</t:Cell><t:Cell>$Resource{switchWageC}</t:Cell><t:Cell>$Resource{totAreaWage}</t:Cell><t:Cell>$Resource{totFaraWage}</t:Cell><t:Cell>$Resource{liveWage}</t:Cell><t:Cell>$Resource{familyWage}</t:Cell><t:Cell>$Resource{studyWage}</t:Cell><t:Cell>$Resource{fireWage}</t:Cell><t:Cell>$Resource{retirWage}</t:Cell><t:Cell>$Resource{pOverAward}</t:Cell><t:Cell>$Resource{contSDate}</t:Cell><t:Cell>$Resource{contEDate}</t:Cell><t:Cell>$Resource{startDate}</t:Cell><t:Cell>$Resource{nGalaOver}</t:Cell><t:Cell>$Resource{sevWage}</t:Cell><t:Cell>$Resource{sevTimes}</t:Cell><t:Cell>$Resource{sevWageC}</t:Cell><t:Cell>$Resource{profWage}</t:Cell><t:Cell>$Resource{extProfWage}</t:Cell><t:Cell>$Resource{nWorkWageC}</t:Cell><t:Cell>$Resource{profAward}</t:Cell><t:Cell>$Resource{unSCVCWage}</t:Cell><t:Cell>$Resource{personID}</t:Cell><t:Cell>$Resource{prof}</t:Cell><t:Cell>$Resource{province}</t:Cell><t:Cell>$Resource{nWorkDays}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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

                this.kdtEntrys.putBindContents("editData",new String[] {"id","projSocialNo","secuProj","lastName","firstName","sex","birthdate","birthPlace","nation","MariState","IDNumber","birthIDNumber","secuNum","apprTime","endDate","secuProf","nBasePay","nSeniority","seniPay","nWorkDay","nUlOver","nHlOver","traWage","eWage","totRiskWage","dengWage","vaWage","nUrgeWage","oneTimeWage","outWageC","phoneWageC","thingsWage","thingsTimes","totOneWage","oneWorkWage","nWorkWage","nWorkTimes","langWage","areaWage","switchWage","switchTimes","faraWage","spendWage","itmperie","itmperieTol","coopCode","foriPersID","CCPNo","address","remark","workProgram","cooperation","outWage","outTimes","oveWage","oveTimes","traWageC","eWageC","vaWageC","thingsWageC","switchWageC","totAreaWage","totFaraWage","liveWage","familyWage","studyWage","fireWage","retirWage","pOverAward","contSDate","contEDate","startDate","nGalaOver","sevWage","sevTimes","sevWageC","profWage","extProfWage","nWorkWageC","profAward","unSCVCWage","personID","prof","province","nWorkDays"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_projSocialNo_TextField = new KDTextField();
        kdtEntrys_projSocialNo_TextField.setName("kdtEntrys_projSocialNo_TextField");
        kdtEntrys_projSocialNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_projSocialNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_projSocialNo_TextField);
        this.kdtEntrys.getColumn("projSocialNo").setEditor(kdtEntrys_projSocialNo_CellEditor);
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
        KDTextField kdtEntrys_birthPlace_TextField = new KDTextField();
        kdtEntrys_birthPlace_TextField.setName("kdtEntrys_birthPlace_TextField");
        kdtEntrys_birthPlace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_birthPlace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlace_TextField);
        this.kdtEntrys.getColumn("birthPlace").setEditor(kdtEntrys_birthPlace_CellEditor);
        final KDBizPromptBox kdtEntrys_nation_PromptBox = new KDBizPromptBox();
        kdtEntrys_nation_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");
        kdtEntrys_nation_PromptBox.setVisible(true);
        kdtEntrys_nation_PromptBox.setEditable(true);
        kdtEntrys_nation_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_nation_PromptBox.setEditFormat("$number$");
        kdtEntrys_nation_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_nation_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nation_PromptBox);
        this.kdtEntrys.getColumn("nation").setEditor(kdtEntrys_nation_CellEditor);
        ObjectValueRender kdtEntrys_nation_OVR = new ObjectValueRender();
        kdtEntrys_nation_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("nation").setRenderer(kdtEntrys_nation_OVR);
        KDComboBox kdtEntrys_MariState_ComboBox = new KDComboBox();
        kdtEntrys_MariState_ComboBox.setName("kdtEntrys_MariState_ComboBox");
        kdtEntrys_MariState_ComboBox.setVisible(true);
        kdtEntrys_MariState_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.mayrStatEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_MariState_CellEditor = new KDTDefaultCellEditor(kdtEntrys_MariState_ComboBox);
        this.kdtEntrys.getColumn("MariState").setEditor(kdtEntrys_MariState_CellEditor);
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
        KDTextField kdtEntrys_secuNum_TextField = new KDTextField();
        kdtEntrys_secuNum_TextField.setName("kdtEntrys_secuNum_TextField");
        kdtEntrys_secuNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_secuNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_secuNum_TextField);
        this.kdtEntrys.getColumn("secuNum").setEditor(kdtEntrys_secuNum_CellEditor);
        KDDatePicker kdtEntrys_apprTime_DatePicker = new KDDatePicker();
        kdtEntrys_apprTime_DatePicker.setName("kdtEntrys_apprTime_DatePicker");
        kdtEntrys_apprTime_DatePicker.setVisible(true);
        kdtEntrys_apprTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_apprTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_apprTime_DatePicker);
        this.kdtEntrys.getColumn("apprTime").setEditor(kdtEntrys_apprTime_CellEditor);
        KDDatePicker kdtEntrys_endDate_DatePicker = new KDDatePicker();
        kdtEntrys_endDate_DatePicker.setName("kdtEntrys_endDate_DatePicker");
        kdtEntrys_endDate_DatePicker.setVisible(true);
        kdtEntrys_endDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_endDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_endDate_DatePicker);
        this.kdtEntrys.getColumn("endDate").setEditor(kdtEntrys_endDate_CellEditor);
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
        	kdtEntrys_nBasePay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nBasePay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nBasePay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nBasePay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nBasePay_TextField);
        this.kdtEntrys.getColumn("nBasePay").setEditor(kdtEntrys_nBasePay_CellEditor);
        KDFormattedTextField kdtEntrys_nSeniority_TextField = new KDFormattedTextField();
        kdtEntrys_nSeniority_TextField.setName("kdtEntrys_nSeniority_TextField");
        kdtEntrys_nSeniority_TextField.setVisible(true);
        kdtEntrys_nSeniority_TextField.setEditable(true);
        kdtEntrys_nSeniority_TextField.setHorizontalAlignment(2);
        kdtEntrys_nSeniority_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_nSeniority_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nSeniority_TextField);
        this.kdtEntrys.getColumn("nSeniority").setEditor(kdtEntrys_nSeniority_CellEditor);
        KDFormattedTextField kdtEntrys_seniPay_TextField = new KDFormattedTextField();
        kdtEntrys_seniPay_TextField.setName("kdtEntrys_seniPay_TextField");
        kdtEntrys_seniPay_TextField.setVisible(true);
        kdtEntrys_seniPay_TextField.setEditable(true);
        kdtEntrys_seniPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_seniPay_TextField.setDataType(1);
        	kdtEntrys_seniPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seniPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seniPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seniPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seniPay_TextField);
        this.kdtEntrys.getColumn("seniPay").setEditor(kdtEntrys_seniPay_CellEditor);
        KDFormattedTextField kdtEntrys_nWorkDay_TextField = new KDFormattedTextField();
        kdtEntrys_nWorkDay_TextField.setName("kdtEntrys_nWorkDay_TextField");
        kdtEntrys_nWorkDay_TextField.setVisible(true);
        kdtEntrys_nWorkDay_TextField.setEditable(true);
        kdtEntrys_nWorkDay_TextField.setHorizontalAlignment(2);
        kdtEntrys_nWorkDay_TextField.setDataType(1);
        	kdtEntrys_nWorkDay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nWorkDay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nWorkDay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nWorkDay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nWorkDay_TextField);
        this.kdtEntrys.getColumn("nWorkDay").setEditor(kdtEntrys_nWorkDay_CellEditor);
        KDFormattedTextField kdtEntrys_nUlOver_TextField = new KDFormattedTextField();
        kdtEntrys_nUlOver_TextField.setName("kdtEntrys_nUlOver_TextField");
        kdtEntrys_nUlOver_TextField.setVisible(true);
        kdtEntrys_nUlOver_TextField.setEditable(true);
        kdtEntrys_nUlOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_nUlOver_TextField.setDataType(1);
        	kdtEntrys_nUlOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nUlOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nUlOver_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nUlOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nUlOver_TextField);
        this.kdtEntrys.getColumn("nUlOver").setEditor(kdtEntrys_nUlOver_CellEditor);
        KDFormattedTextField kdtEntrys_nHlOver_TextField = new KDFormattedTextField();
        kdtEntrys_nHlOver_TextField.setName("kdtEntrys_nHlOver_TextField");
        kdtEntrys_nHlOver_TextField.setVisible(true);
        kdtEntrys_nHlOver_TextField.setEditable(true);
        kdtEntrys_nHlOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_nHlOver_TextField.setDataType(1);
        	kdtEntrys_nHlOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nHlOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nHlOver_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nHlOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nHlOver_TextField);
        this.kdtEntrys.getColumn("nHlOver").setEditor(kdtEntrys_nHlOver_CellEditor);
        final KDBizPromptBox kdtEntrys_traWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_traWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_traWage_PromptBox.setVisible(true);
        kdtEntrys_traWage_PromptBox.setEditable(true);
        kdtEntrys_traWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_traWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_traWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_traWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_traWage_PromptBox);
        this.kdtEntrys.getColumn("traWage").setEditor(kdtEntrys_traWage_CellEditor);
        ObjectValueRender kdtEntrys_traWage_OVR = new ObjectValueRender();
        kdtEntrys_traWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("traWage").setRenderer(kdtEntrys_traWage_OVR);
        final KDBizPromptBox kdtEntrys_eWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_eWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_eWage_PromptBox.setVisible(true);
        kdtEntrys_eWage_PromptBox.setEditable(true);
        kdtEntrys_eWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_eWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_eWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_eWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eWage_PromptBox);
        this.kdtEntrys.getColumn("eWage").setEditor(kdtEntrys_eWage_CellEditor);
        ObjectValueRender kdtEntrys_eWage_OVR = new ObjectValueRender();
        kdtEntrys_eWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("eWage").setRenderer(kdtEntrys_eWage_OVR);
        KDFormattedTextField kdtEntrys_totRiskWage_TextField = new KDFormattedTextField();
        kdtEntrys_totRiskWage_TextField.setName("kdtEntrys_totRiskWage_TextField");
        kdtEntrys_totRiskWage_TextField.setVisible(true);
        kdtEntrys_totRiskWage_TextField.setEditable(true);
        kdtEntrys_totRiskWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_totRiskWage_TextField.setDataType(1);
        	kdtEntrys_totRiskWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totRiskWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totRiskWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totRiskWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totRiskWage_TextField);
        this.kdtEntrys.getColumn("totRiskWage").setEditor(kdtEntrys_totRiskWage_CellEditor);
        final KDBizPromptBox kdtEntrys_dengWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_dengWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_dengWage_PromptBox.setVisible(true);
        kdtEntrys_dengWage_PromptBox.setEditable(true);
        kdtEntrys_dengWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_dengWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_dengWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_dengWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dengWage_PromptBox);
        this.kdtEntrys.getColumn("dengWage").setEditor(kdtEntrys_dengWage_CellEditor);
        ObjectValueRender kdtEntrys_dengWage_OVR = new ObjectValueRender();
        kdtEntrys_dengWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("dengWage").setRenderer(kdtEntrys_dengWage_OVR);
        final KDBizPromptBox kdtEntrys_vaWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_vaWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_vaWage_PromptBox.setVisible(true);
        kdtEntrys_vaWage_PromptBox.setEditable(true);
        kdtEntrys_vaWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_vaWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_vaWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_vaWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vaWage_PromptBox);
        this.kdtEntrys.getColumn("vaWage").setEditor(kdtEntrys_vaWage_CellEditor);
        ObjectValueRender kdtEntrys_vaWage_OVR = new ObjectValueRender();
        kdtEntrys_vaWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("vaWage").setRenderer(kdtEntrys_vaWage_OVR);
        KDFormattedTextField kdtEntrys_nUrgeWage_TextField = new KDFormattedTextField();
        kdtEntrys_nUrgeWage_TextField.setName("kdtEntrys_nUrgeWage_TextField");
        kdtEntrys_nUrgeWage_TextField.setVisible(true);
        kdtEntrys_nUrgeWage_TextField.setEditable(true);
        kdtEntrys_nUrgeWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_nUrgeWage_TextField.setDataType(1);
        	kdtEntrys_nUrgeWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nUrgeWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nUrgeWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nUrgeWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nUrgeWage_TextField);
        this.kdtEntrys.getColumn("nUrgeWage").setEditor(kdtEntrys_nUrgeWage_CellEditor);
        KDFormattedTextField kdtEntrys_oneTimeWage_TextField = new KDFormattedTextField();
        kdtEntrys_oneTimeWage_TextField.setName("kdtEntrys_oneTimeWage_TextField");
        kdtEntrys_oneTimeWage_TextField.setVisible(true);
        kdtEntrys_oneTimeWage_TextField.setEditable(true);
        kdtEntrys_oneTimeWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_oneTimeWage_TextField.setDataType(1);
        	kdtEntrys_oneTimeWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_oneTimeWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_oneTimeWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_oneTimeWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oneTimeWage_TextField);
        this.kdtEntrys.getColumn("oneTimeWage").setEditor(kdtEntrys_oneTimeWage_CellEditor);
        KDFormattedTextField kdtEntrys_outWageC_TextField = new KDFormattedTextField();
        kdtEntrys_outWageC_TextField.setName("kdtEntrys_outWageC_TextField");
        kdtEntrys_outWageC_TextField.setVisible(true);
        kdtEntrys_outWageC_TextField.setEditable(true);
        kdtEntrys_outWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_outWageC_TextField.setDataType(1);
        	kdtEntrys_outWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_outWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_outWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_outWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_outWageC_TextField);
        this.kdtEntrys.getColumn("outWageC").setEditor(kdtEntrys_outWageC_CellEditor);
        KDFormattedTextField kdtEntrys_phoneWageC_TextField = new KDFormattedTextField();
        kdtEntrys_phoneWageC_TextField.setName("kdtEntrys_phoneWageC_TextField");
        kdtEntrys_phoneWageC_TextField.setVisible(true);
        kdtEntrys_phoneWageC_TextField.setEditable(true);
        kdtEntrys_phoneWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_phoneWageC_TextField.setDataType(1);
        	kdtEntrys_phoneWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_phoneWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_phoneWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_phoneWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_phoneWageC_TextField);
        this.kdtEntrys.getColumn("phoneWageC").setEditor(kdtEntrys_phoneWageC_CellEditor);
        final KDBizPromptBox kdtEntrys_thingsWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_thingsWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_thingsWage_PromptBox.setVisible(true);
        kdtEntrys_thingsWage_PromptBox.setEditable(true);
        kdtEntrys_thingsWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_thingsWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_thingsWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_thingsWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_thingsWage_PromptBox);
        this.kdtEntrys.getColumn("thingsWage").setEditor(kdtEntrys_thingsWage_CellEditor);
        ObjectValueRender kdtEntrys_thingsWage_OVR = new ObjectValueRender();
        kdtEntrys_thingsWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("thingsWage").setRenderer(kdtEntrys_thingsWage_OVR);
        KDFormattedTextField kdtEntrys_thingsTimes_TextField = new KDFormattedTextField();
        kdtEntrys_thingsTimes_TextField.setName("kdtEntrys_thingsTimes_TextField");
        kdtEntrys_thingsTimes_TextField.setVisible(true);
        kdtEntrys_thingsTimes_TextField.setEditable(true);
        kdtEntrys_thingsTimes_TextField.setHorizontalAlignment(2);
        kdtEntrys_thingsTimes_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_thingsTimes_CellEditor = new KDTDefaultCellEditor(kdtEntrys_thingsTimes_TextField);
        this.kdtEntrys.getColumn("thingsTimes").setEditor(kdtEntrys_thingsTimes_CellEditor);
        KDFormattedTextField kdtEntrys_totOneWage_TextField = new KDFormattedTextField();
        kdtEntrys_totOneWage_TextField.setName("kdtEntrys_totOneWage_TextField");
        kdtEntrys_totOneWage_TextField.setVisible(true);
        kdtEntrys_totOneWage_TextField.setEditable(true);
        kdtEntrys_totOneWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_totOneWage_TextField.setDataType(1);
        	kdtEntrys_totOneWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totOneWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totOneWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totOneWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totOneWage_TextField);
        this.kdtEntrys.getColumn("totOneWage").setEditor(kdtEntrys_totOneWage_CellEditor);
        final KDBizPromptBox kdtEntrys_oneWorkWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_oneWorkWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_oneWorkWage_PromptBox.setVisible(true);
        kdtEntrys_oneWorkWage_PromptBox.setEditable(true);
        kdtEntrys_oneWorkWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_oneWorkWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_oneWorkWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_oneWorkWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oneWorkWage_PromptBox);
        this.kdtEntrys.getColumn("oneWorkWage").setEditor(kdtEntrys_oneWorkWage_CellEditor);
        ObjectValueRender kdtEntrys_oneWorkWage_OVR = new ObjectValueRender();
        kdtEntrys_oneWorkWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("oneWorkWage").setRenderer(kdtEntrys_oneWorkWage_OVR);
        final KDBizPromptBox kdtEntrys_nWorkWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_nWorkWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_nWorkWage_PromptBox.setVisible(true);
        kdtEntrys_nWorkWage_PromptBox.setEditable(true);
        kdtEntrys_nWorkWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_nWorkWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_nWorkWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_nWorkWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nWorkWage_PromptBox);
        this.kdtEntrys.getColumn("nWorkWage").setEditor(kdtEntrys_nWorkWage_CellEditor);
        ObjectValueRender kdtEntrys_nWorkWage_OVR = new ObjectValueRender();
        kdtEntrys_nWorkWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("nWorkWage").setRenderer(kdtEntrys_nWorkWage_OVR);
        KDFormattedTextField kdtEntrys_nWorkTimes_TextField = new KDFormattedTextField();
        kdtEntrys_nWorkTimes_TextField.setName("kdtEntrys_nWorkTimes_TextField");
        kdtEntrys_nWorkTimes_TextField.setVisible(true);
        kdtEntrys_nWorkTimes_TextField.setEditable(true);
        kdtEntrys_nWorkTimes_TextField.setHorizontalAlignment(2);
        kdtEntrys_nWorkTimes_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_nWorkTimes_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nWorkTimes_TextField);
        this.kdtEntrys.getColumn("nWorkTimes").setEditor(kdtEntrys_nWorkTimes_CellEditor);
        final KDBizPromptBox kdtEntrys_langWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_langWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_langWage_PromptBox.setVisible(true);
        kdtEntrys_langWage_PromptBox.setEditable(true);
        kdtEntrys_langWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_langWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_langWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_langWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_langWage_PromptBox);
        this.kdtEntrys.getColumn("langWage").setEditor(kdtEntrys_langWage_CellEditor);
        ObjectValueRender kdtEntrys_langWage_OVR = new ObjectValueRender();
        kdtEntrys_langWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("langWage").setRenderer(kdtEntrys_langWage_OVR);
        final KDBizPromptBox kdtEntrys_areaWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_areaWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_areaWage_PromptBox.setVisible(true);
        kdtEntrys_areaWage_PromptBox.setEditable(true);
        kdtEntrys_areaWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_areaWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_areaWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_areaWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_areaWage_PromptBox);
        this.kdtEntrys.getColumn("areaWage").setEditor(kdtEntrys_areaWage_CellEditor);
        ObjectValueRender kdtEntrys_areaWage_OVR = new ObjectValueRender();
        kdtEntrys_areaWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("areaWage").setRenderer(kdtEntrys_areaWage_OVR);
        final KDBizPromptBox kdtEntrys_switchWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_switchWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_switchWage_PromptBox.setVisible(true);
        kdtEntrys_switchWage_PromptBox.setEditable(true);
        kdtEntrys_switchWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_switchWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_switchWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_switchWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_switchWage_PromptBox);
        this.kdtEntrys.getColumn("switchWage").setEditor(kdtEntrys_switchWage_CellEditor);
        ObjectValueRender kdtEntrys_switchWage_OVR = new ObjectValueRender();
        kdtEntrys_switchWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("switchWage").setRenderer(kdtEntrys_switchWage_OVR);
        KDFormattedTextField kdtEntrys_switchTimes_TextField = new KDFormattedTextField();
        kdtEntrys_switchTimes_TextField.setName("kdtEntrys_switchTimes_TextField");
        kdtEntrys_switchTimes_TextField.setVisible(true);
        kdtEntrys_switchTimes_TextField.setEditable(true);
        kdtEntrys_switchTimes_TextField.setHorizontalAlignment(2);
        kdtEntrys_switchTimes_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_switchTimes_CellEditor = new KDTDefaultCellEditor(kdtEntrys_switchTimes_TextField);
        this.kdtEntrys.getColumn("switchTimes").setEditor(kdtEntrys_switchTimes_CellEditor);
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
        KDFormattedTextField kdtEntrys_itmperie_TextField = new KDFormattedTextField();
        kdtEntrys_itmperie_TextField.setName("kdtEntrys_itmperie_TextField");
        kdtEntrys_itmperie_TextField.setVisible(true);
        kdtEntrys_itmperie_TextField.setEditable(true);
        kdtEntrys_itmperie_TextField.setHorizontalAlignment(2);
        kdtEntrys_itmperie_TextField.setDataType(1);
        	kdtEntrys_itmperie_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_itmperie_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_itmperie_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_itmperie_CellEditor = new KDTDefaultCellEditor(kdtEntrys_itmperie_TextField);
        this.kdtEntrys.getColumn("itmperie").setEditor(kdtEntrys_itmperie_CellEditor);
        KDFormattedTextField kdtEntrys_itmperieTol_TextField = new KDFormattedTextField();
        kdtEntrys_itmperieTol_TextField.setName("kdtEntrys_itmperieTol_TextField");
        kdtEntrys_itmperieTol_TextField.setVisible(true);
        kdtEntrys_itmperieTol_TextField.setEditable(true);
        kdtEntrys_itmperieTol_TextField.setHorizontalAlignment(2);
        kdtEntrys_itmperieTol_TextField.setDataType(1);
        	kdtEntrys_itmperieTol_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_itmperieTol_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_itmperieTol_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_itmperieTol_CellEditor = new KDTDefaultCellEditor(kdtEntrys_itmperieTol_TextField);
        this.kdtEntrys.getColumn("itmperieTol").setEditor(kdtEntrys_itmperieTol_CellEditor);
        KDTextField kdtEntrys_coopCode_TextField = new KDTextField();
        kdtEntrys_coopCode_TextField.setName("kdtEntrys_coopCode_TextField");
        kdtEntrys_coopCode_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coopCode_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopCode_TextField);
        this.kdtEntrys.getColumn("coopCode").setEditor(kdtEntrys_coopCode_CellEditor);
        KDTextField kdtEntrys_foriPersID_TextField = new KDTextField();
        kdtEntrys_foriPersID_TextField.setName("kdtEntrys_foriPersID_TextField");
        kdtEntrys_foriPersID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_foriPersID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_foriPersID_TextField);
        this.kdtEntrys.getColumn("foriPersID").setEditor(kdtEntrys_foriPersID_CellEditor);
        KDTextField kdtEntrys_CCPNo_TextField = new KDTextField();
        kdtEntrys_CCPNo_TextField.setName("kdtEntrys_CCPNo_TextField");
        kdtEntrys_CCPNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_CCPNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CCPNo_TextField);
        this.kdtEntrys.getColumn("CCPNo").setEditor(kdtEntrys_CCPNo_CellEditor);
        KDTextField kdtEntrys_address_TextField = new KDTextField();
        kdtEntrys_address_TextField.setName("kdtEntrys_address_TextField");
        kdtEntrys_address_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_address_CellEditor = new KDTDefaultCellEditor(kdtEntrys_address_TextField);
        this.kdtEntrys.getColumn("address").setEditor(kdtEntrys_address_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
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
        final KDBizPromptBox kdtEntrys_outWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_outWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_outWage_PromptBox.setVisible(true);
        kdtEntrys_outWage_PromptBox.setEditable(true);
        kdtEntrys_outWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_outWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_outWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_outWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_outWage_PromptBox);
        this.kdtEntrys.getColumn("outWage").setEditor(kdtEntrys_outWage_CellEditor);
        ObjectValueRender kdtEntrys_outWage_OVR = new ObjectValueRender();
        kdtEntrys_outWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("outWage").setRenderer(kdtEntrys_outWage_OVR);
        KDFormattedTextField kdtEntrys_outTimes_TextField = new KDFormattedTextField();
        kdtEntrys_outTimes_TextField.setName("kdtEntrys_outTimes_TextField");
        kdtEntrys_outTimes_TextField.setVisible(true);
        kdtEntrys_outTimes_TextField.setEditable(true);
        kdtEntrys_outTimes_TextField.setHorizontalAlignment(2);
        kdtEntrys_outTimes_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_outTimes_CellEditor = new KDTDefaultCellEditor(kdtEntrys_outTimes_TextField);
        this.kdtEntrys.getColumn("outTimes").setEditor(kdtEntrys_outTimes_CellEditor);
        final KDBizPromptBox kdtEntrys_oveWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_oveWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_oveWage_PromptBox.setVisible(true);
        kdtEntrys_oveWage_PromptBox.setEditable(true);
        kdtEntrys_oveWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_oveWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_oveWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_oveWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oveWage_PromptBox);
        this.kdtEntrys.getColumn("oveWage").setEditor(kdtEntrys_oveWage_CellEditor);
        ObjectValueRender kdtEntrys_oveWage_OVR = new ObjectValueRender();
        kdtEntrys_oveWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("oveWage").setRenderer(kdtEntrys_oveWage_OVR);
        KDFormattedTextField kdtEntrys_oveTimes_TextField = new KDFormattedTextField();
        kdtEntrys_oveTimes_TextField.setName("kdtEntrys_oveTimes_TextField");
        kdtEntrys_oveTimes_TextField.setVisible(true);
        kdtEntrys_oveTimes_TextField.setEditable(true);
        kdtEntrys_oveTimes_TextField.setHorizontalAlignment(2);
        kdtEntrys_oveTimes_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_oveTimes_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oveTimes_TextField);
        this.kdtEntrys.getColumn("oveTimes").setEditor(kdtEntrys_oveTimes_CellEditor);
        KDFormattedTextField kdtEntrys_traWageC_TextField = new KDFormattedTextField();
        kdtEntrys_traWageC_TextField.setName("kdtEntrys_traWageC_TextField");
        kdtEntrys_traWageC_TextField.setVisible(true);
        kdtEntrys_traWageC_TextField.setEditable(true);
        kdtEntrys_traWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_traWageC_TextField.setDataType(1);
        	kdtEntrys_traWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_traWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_traWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_traWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_traWageC_TextField);
        this.kdtEntrys.getColumn("traWageC").setEditor(kdtEntrys_traWageC_CellEditor);
        KDFormattedTextField kdtEntrys_eWageC_TextField = new KDFormattedTextField();
        kdtEntrys_eWageC_TextField.setName("kdtEntrys_eWageC_TextField");
        kdtEntrys_eWageC_TextField.setVisible(true);
        kdtEntrys_eWageC_TextField.setEditable(true);
        kdtEntrys_eWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_eWageC_TextField.setDataType(1);
        	kdtEntrys_eWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_eWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_eWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_eWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eWageC_TextField);
        this.kdtEntrys.getColumn("eWageC").setEditor(kdtEntrys_eWageC_CellEditor);
        KDFormattedTextField kdtEntrys_vaWageC_TextField = new KDFormattedTextField();
        kdtEntrys_vaWageC_TextField.setName("kdtEntrys_vaWageC_TextField");
        kdtEntrys_vaWageC_TextField.setVisible(true);
        kdtEntrys_vaWageC_TextField.setEditable(true);
        kdtEntrys_vaWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_vaWageC_TextField.setDataType(1);
        	kdtEntrys_vaWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_vaWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_vaWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_vaWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vaWageC_TextField);
        this.kdtEntrys.getColumn("vaWageC").setEditor(kdtEntrys_vaWageC_CellEditor);
        KDFormattedTextField kdtEntrys_thingsWageC_TextField = new KDFormattedTextField();
        kdtEntrys_thingsWageC_TextField.setName("kdtEntrys_thingsWageC_TextField");
        kdtEntrys_thingsWageC_TextField.setVisible(true);
        kdtEntrys_thingsWageC_TextField.setEditable(true);
        kdtEntrys_thingsWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_thingsWageC_TextField.setDataType(1);
        	kdtEntrys_thingsWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_thingsWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_thingsWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_thingsWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_thingsWageC_TextField);
        this.kdtEntrys.getColumn("thingsWageC").setEditor(kdtEntrys_thingsWageC_CellEditor);
        KDFormattedTextField kdtEntrys_switchWageC_TextField = new KDFormattedTextField();
        kdtEntrys_switchWageC_TextField.setName("kdtEntrys_switchWageC_TextField");
        kdtEntrys_switchWageC_TextField.setVisible(true);
        kdtEntrys_switchWageC_TextField.setEditable(true);
        kdtEntrys_switchWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_switchWageC_TextField.setDataType(1);
        	kdtEntrys_switchWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_switchWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_switchWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_switchWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_switchWageC_TextField);
        this.kdtEntrys.getColumn("switchWageC").setEditor(kdtEntrys_switchWageC_CellEditor);
        KDFormattedTextField kdtEntrys_totAreaWage_TextField = new KDFormattedTextField();
        kdtEntrys_totAreaWage_TextField.setName("kdtEntrys_totAreaWage_TextField");
        kdtEntrys_totAreaWage_TextField.setVisible(true);
        kdtEntrys_totAreaWage_TextField.setEditable(true);
        kdtEntrys_totAreaWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_totAreaWage_TextField.setDataType(1);
        	kdtEntrys_totAreaWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totAreaWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totAreaWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totAreaWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totAreaWage_TextField);
        this.kdtEntrys.getColumn("totAreaWage").setEditor(kdtEntrys_totAreaWage_CellEditor);
        KDFormattedTextField kdtEntrys_totFaraWage_TextField = new KDFormattedTextField();
        kdtEntrys_totFaraWage_TextField.setName("kdtEntrys_totFaraWage_TextField");
        kdtEntrys_totFaraWage_TextField.setVisible(true);
        kdtEntrys_totFaraWage_TextField.setEditable(true);
        kdtEntrys_totFaraWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_totFaraWage_TextField.setDataType(1);
        	kdtEntrys_totFaraWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totFaraWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totFaraWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totFaraWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totFaraWage_TextField);
        this.kdtEntrys.getColumn("totFaraWage").setEditor(kdtEntrys_totFaraWage_CellEditor);
        final KDBizPromptBox kdtEntrys_liveWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_liveWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_liveWage_PromptBox.setVisible(true);
        kdtEntrys_liveWage_PromptBox.setEditable(true);
        kdtEntrys_liveWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_liveWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_liveWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_liveWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_liveWage_PromptBox);
        this.kdtEntrys.getColumn("liveWage").setEditor(kdtEntrys_liveWage_CellEditor);
        ObjectValueRender kdtEntrys_liveWage_OVR = new ObjectValueRender();
        kdtEntrys_liveWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("liveWage").setRenderer(kdtEntrys_liveWage_OVR);
        final KDBizPromptBox kdtEntrys_familyWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_familyWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_familyWage_PromptBox.setVisible(true);
        kdtEntrys_familyWage_PromptBox.setEditable(true);
        kdtEntrys_familyWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_familyWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_familyWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_familyWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_familyWage_PromptBox);
        this.kdtEntrys.getColumn("familyWage").setEditor(kdtEntrys_familyWage_CellEditor);
        ObjectValueRender kdtEntrys_familyWage_OVR = new ObjectValueRender();
        kdtEntrys_familyWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("familyWage").setRenderer(kdtEntrys_familyWage_OVR);
        final KDBizPromptBox kdtEntrys_studyWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_studyWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_studyWage_PromptBox.setVisible(true);
        kdtEntrys_studyWage_PromptBox.setEditable(true);
        kdtEntrys_studyWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_studyWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_studyWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_studyWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_studyWage_PromptBox);
        this.kdtEntrys.getColumn("studyWage").setEditor(kdtEntrys_studyWage_CellEditor);
        ObjectValueRender kdtEntrys_studyWage_OVR = new ObjectValueRender();
        kdtEntrys_studyWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("studyWage").setRenderer(kdtEntrys_studyWage_OVR);
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
        KDFormattedTextField kdtEntrys_pOverAward_TextField = new KDFormattedTextField();
        kdtEntrys_pOverAward_TextField.setName("kdtEntrys_pOverAward_TextField");
        kdtEntrys_pOverAward_TextField.setVisible(true);
        kdtEntrys_pOverAward_TextField.setEditable(true);
        kdtEntrys_pOverAward_TextField.setHorizontalAlignment(2);
        kdtEntrys_pOverAward_TextField.setDataType(1);
        	kdtEntrys_pOverAward_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_pOverAward_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_pOverAward_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_pOverAward_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pOverAward_TextField);
        this.kdtEntrys.getColumn("pOverAward").setEditor(kdtEntrys_pOverAward_CellEditor);
        KDDatePicker kdtEntrys_contSDate_DatePicker = new KDDatePicker();
        kdtEntrys_contSDate_DatePicker.setName("kdtEntrys_contSDate_DatePicker");
        kdtEntrys_contSDate_DatePicker.setVisible(true);
        kdtEntrys_contSDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_contSDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contSDate_DatePicker);
        this.kdtEntrys.getColumn("contSDate").setEditor(kdtEntrys_contSDate_CellEditor);
        KDDatePicker kdtEntrys_contEDate_DatePicker = new KDDatePicker();
        kdtEntrys_contEDate_DatePicker.setName("kdtEntrys_contEDate_DatePicker");
        kdtEntrys_contEDate_DatePicker.setVisible(true);
        kdtEntrys_contEDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_contEDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contEDate_DatePicker);
        this.kdtEntrys.getColumn("contEDate").setEditor(kdtEntrys_contEDate_CellEditor);
        KDDatePicker kdtEntrys_startDate_DatePicker = new KDDatePicker();
        kdtEntrys_startDate_DatePicker.setName("kdtEntrys_startDate_DatePicker");
        kdtEntrys_startDate_DatePicker.setVisible(true);
        kdtEntrys_startDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_startDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_startDate_DatePicker);
        this.kdtEntrys.getColumn("startDate").setEditor(kdtEntrys_startDate_CellEditor);
        KDFormattedTextField kdtEntrys_nGalaOver_TextField = new KDFormattedTextField();
        kdtEntrys_nGalaOver_TextField.setName("kdtEntrys_nGalaOver_TextField");
        kdtEntrys_nGalaOver_TextField.setVisible(true);
        kdtEntrys_nGalaOver_TextField.setEditable(true);
        kdtEntrys_nGalaOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_nGalaOver_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_nGalaOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nGalaOver_TextField);
        this.kdtEntrys.getColumn("nGalaOver").setEditor(kdtEntrys_nGalaOver_CellEditor);
        final KDBizPromptBox kdtEntrys_sevWage_PromptBox = new KDBizPromptBox();
        kdtEntrys_sevWage_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjWageQuery");
        kdtEntrys_sevWage_PromptBox.setVisible(true);
        kdtEntrys_sevWage_PromptBox.setEditable(true);
        kdtEntrys_sevWage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_sevWage_PromptBox.setEditFormat("$number$");
        kdtEntrys_sevWage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_sevWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sevWage_PromptBox);
        this.kdtEntrys.getColumn("sevWage").setEditor(kdtEntrys_sevWage_CellEditor);
        ObjectValueRender kdtEntrys_sevWage_OVR = new ObjectValueRender();
        kdtEntrys_sevWage_OVR.setFormat(new BizDataFormat("$money$"));
        this.kdtEntrys.getColumn("sevWage").setRenderer(kdtEntrys_sevWage_OVR);
        KDFormattedTextField kdtEntrys_sevTimes_TextField = new KDFormattedTextField();
        kdtEntrys_sevTimes_TextField.setName("kdtEntrys_sevTimes_TextField");
        kdtEntrys_sevTimes_TextField.setVisible(true);
        kdtEntrys_sevTimes_TextField.setEditable(true);
        kdtEntrys_sevTimes_TextField.setHorizontalAlignment(2);
        kdtEntrys_sevTimes_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_sevTimes_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sevTimes_TextField);
        this.kdtEntrys.getColumn("sevTimes").setEditor(kdtEntrys_sevTimes_CellEditor);
        KDFormattedTextField kdtEntrys_sevWageC_TextField = new KDFormattedTextField();
        kdtEntrys_sevWageC_TextField.setName("kdtEntrys_sevWageC_TextField");
        kdtEntrys_sevWageC_TextField.setVisible(true);
        kdtEntrys_sevWageC_TextField.setEditable(true);
        kdtEntrys_sevWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_sevWageC_TextField.setDataType(1);
        	kdtEntrys_sevWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_sevWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_sevWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_sevWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sevWageC_TextField);
        this.kdtEntrys.getColumn("sevWageC").setEditor(kdtEntrys_sevWageC_CellEditor);
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
        KDFormattedTextField kdtEntrys_nWorkWageC_TextField = new KDFormattedTextField();
        kdtEntrys_nWorkWageC_TextField.setName("kdtEntrys_nWorkWageC_TextField");
        kdtEntrys_nWorkWageC_TextField.setVisible(true);
        kdtEntrys_nWorkWageC_TextField.setEditable(true);
        kdtEntrys_nWorkWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_nWorkWageC_TextField.setDataType(1);
        	kdtEntrys_nWorkWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nWorkWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nWorkWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nWorkWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nWorkWageC_TextField);
        this.kdtEntrys.getColumn("nWorkWageC").setEditor(kdtEntrys_nWorkWageC_CellEditor);
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
        KDTextField kdtEntrys_personID_TextField = new KDTextField();
        kdtEntrys_personID_TextField.setName("kdtEntrys_personID_TextField");
        kdtEntrys_personID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_personID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personID_TextField);
        this.kdtEntrys.getColumn("personID").setEditor(kdtEntrys_personID_CellEditor);
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
        kdtEntrys_prof_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("prof").setRenderer(kdtEntrys_prof_OVR);
        final KDBizPromptBox kdtEntrys_province_PromptBox = new KDBizPromptBox();
        kdtEntrys_province_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");
        kdtEntrys_province_PromptBox.setVisible(true);
        kdtEntrys_province_PromptBox.setEditable(true);
        kdtEntrys_province_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_province_PromptBox.setEditFormat("$number$");
        kdtEntrys_province_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_province_CellEditor = new KDTDefaultCellEditor(kdtEntrys_province_PromptBox);
        this.kdtEntrys.getColumn("province").setEditor(kdtEntrys_province_CellEditor);
        ObjectValueRender kdtEntrys_province_OVR = new ObjectValueRender();
        kdtEntrys_province_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("province").setRenderer(kdtEntrys_province_OVR);
        KDFormattedTextField kdtEntrys_nWorkDays_TextField = new KDFormattedTextField();
        kdtEntrys_nWorkDays_TextField.setName("kdtEntrys_nWorkDays_TextField");
        kdtEntrys_nWorkDays_TextField.setVisible(true);
        kdtEntrys_nWorkDays_TextField.setEditable(true);
        kdtEntrys_nWorkDays_TextField.setHorizontalAlignment(2);
        kdtEntrys_nWorkDays_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_nWorkDays_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nWorkDays_TextField);
        this.kdtEntrys.getColumn("nWorkDays").setEditor(kdtEntrys_nWorkDays_CellEditor);
        // contpermProj		
        this.contpermProj.setBoundLabelText(resHelper.getString("contpermProj.boundLabelText"));		
        this.contpermProj.setBoundLabelLength(100);		
        this.contpermProj.setBoundLabelUnderline(true);		
        this.contpermProj.setVisible(true);
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
        // contshCount		
        this.contshCount.setBoundLabelText(resHelper.getString("contshCount.boundLabelText"));		
        this.contshCount.setBoundLabelLength(100);		
        this.contshCount.setBoundLabelUnderline(true);		
        this.contshCount.setVisible(false);
        // contmonthYearr		
        this.contmonthYearr.setBoundLabelText(resHelper.getString("contmonthYearr.boundLabelText"));		
        this.contmonthYearr.setBoundLabelLength(100);		
        this.contmonthYearr.setBoundLabelUnderline(true);		
        this.contmonthYearr.setVisible(true);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));
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
        // prmtpermProj		
        this.prmtpermProj.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtpermProj.setEditable(true);		
        this.prmtpermProj.setDisplayFormat("$name$");		
        this.prmtpermProj.setEditFormat("$number$");		
        this.prmtpermProj.setCommitFormat("$number$");		
        this.prmtpermProj.setRequired(false);		
        this.prmtpermProj.setEnabled(false);
        this.prmtpermProj.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtpermProj_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // billSate		
        this.billSate.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billSate.setRequired(false);		
        this.billSate.setEnabled(false);
        // pkAuditDate		
        this.pkAuditDate.setRequired(false);
        // txtshCount		
        this.txtshCount.setVisible(false);		
        this.txtshCount.setHorizontalAlignment(2);		
        this.txtshCount.setDataType(0);		
        this.txtshCount.setSupportedEmpty(true);		
        this.txtshCount.setRequired(false);
        // prmtmonthYearr		
        this.prmtmonthYearr.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtmonthYearr.setEditable(true);		
        this.prmtmonthYearr.setDisplayFormat("$number$");		
        this.prmtmonthYearr.setEditFormat("$number$");		
        this.prmtmonthYearr.setCommitFormat("$number$");		
        this.prmtmonthYearr.setRequired(false);
        this.prmtmonthYearr.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtmonthYearr_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtpermProj,billSate,pkAuditDate,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtshCount,prmtmonthYearr,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 530));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 530));
        contCreator.setBounds(new Rectangle(18, 495, 213, 19));
        this.add(contCreator, new KDLayout.Constraints(18, 495, 213, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(277, 495, 213, 19));
        this.add(contCreateTime, new KDLayout.Constraints(277, 495, 213, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(440, 553, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(440, 553, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(742, 548, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(742, 548, 270, 19, 0));
        contNumber.setBounds(new Rectangle(17, 8, 217, 19));
        this.add(contNumber, new KDLayout.Constraints(17, 8, 217, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(17, 37, 217, 19));
        this.add(contBizDate, new KDLayout.Constraints(17, 37, 217, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(272, 37, 728, 19));
        this.add(contDescription, new KDLayout.Constraints(272, 37, 728, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(536, 495, 213, 19));
        this.add(contAuditor, new KDLayout.Constraints(536, 495, 213, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(17, 96, 991, 380));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.social.CheckCountEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(17, 96, 991, 380, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("sex",new Integer(1));
vo.put("MariState","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contpermProj.setBounds(new Rectangle(527, 8, 217, 19));
        this.add(contpermProj, new KDLayout.Constraints(527, 8, 217, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillSate.setBounds(new Rectangle(783, 8, 217, 19));
        this.add(contbillSate, new KDLayout.Constraints(783, 8, 217, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditDate.setBounds(new Rectangle(795, 495, 213, 19));
        this.add(contAuditDate, new KDLayout.Constraints(795, 495, 213, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contshCount.setBounds(new Rectangle(136, 129, 270, 19));
        this.add(contshCount, new KDLayout.Constraints(136, 129, 270, 19, 0));
        contmonthYearr.setBounds(new Rectangle(272, 8, 217, 19));
        this.add(contmonthYearr, new KDLayout.Constraints(272, 8, 217, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer1.setBounds(new Rectangle(17, 72, 242, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(17, 72, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contpermProj
        contpermProj.setBoundEditor(prmtpermProj);
        //contbillSate
        contbillSate.setBoundEditor(billSate);
        //contAuditDate
        contAuditDate.setBoundEditor(pkAuditDate);
        //contshCount
        contshCount.setBoundEditor(txtshCount);
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.social.CheckCountEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.sex", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "sex.text");
		dataBinder.registerBinding("entrys.birthdate", java.util.Date.class, this.kdtEntrys, "birthdate.text");
		dataBinder.registerBinding("entrys.province", java.lang.Object.class, this.kdtEntrys, "province.text");
		dataBinder.registerBinding("entrys.birthPlace", String.class, this.kdtEntrys, "birthPlace.text");
		dataBinder.registerBinding("entrys.MariState", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "MariState.text");
		dataBinder.registerBinding("entrys.secuNum", String.class, this.kdtEntrys, "secuNum.text");
		dataBinder.registerBinding("entrys.CCPNo", String.class, this.kdtEntrys, "CCPNo.text");
		dataBinder.registerBinding("entrys.address", String.class, this.kdtEntrys, "address.text");
		dataBinder.registerBinding("entrys.workProgram", java.lang.Object.class, this.kdtEntrys, "workProgram.text");
		dataBinder.registerBinding("entrys.cooperation", java.lang.Object.class, this.kdtEntrys, "cooperation.text");
		dataBinder.registerBinding("entrys.coopCode", String.class, this.kdtEntrys, "coopCode.text");
		dataBinder.registerBinding("entrys.apprTime", java.util.Date.class, this.kdtEntrys, "apprTime.text");
		dataBinder.registerBinding("entrys.contSDate", java.util.Date.class, this.kdtEntrys, "contSDate.text");
		dataBinder.registerBinding("entrys.contEDate", java.util.Date.class, this.kdtEntrys, "contEDate.text");
		dataBinder.registerBinding("entrys.secuProj", java.lang.Object.class, this.kdtEntrys, "secuProj.text");
		dataBinder.registerBinding("entrys.startDate", java.util.Date.class, this.kdtEntrys, "startDate.text");
		dataBinder.registerBinding("entrys.endDate", java.util.Date.class, this.kdtEntrys, "endDate.text");
		dataBinder.registerBinding("entrys.nWorkDays", int.class, this.kdtEntrys, "nWorkDays.text");
		dataBinder.registerBinding("entrys.nGalaOver", int.class, this.kdtEntrys, "nGalaOver.text");
		dataBinder.registerBinding("entrys.nSeniority", int.class, this.kdtEntrys, "nSeniority.text");
		dataBinder.registerBinding("entrys.nBasePay", java.math.BigDecimal.class, this.kdtEntrys, "nBasePay.text");
		dataBinder.registerBinding("entrys.seniPay", java.math.BigDecimal.class, this.kdtEntrys, "seniPay.text");
		dataBinder.registerBinding("entrys.traWage", java.lang.Object.class, this.kdtEntrys, "traWage.text");
		dataBinder.registerBinding("entrys.traWageC", java.math.BigDecimal.class, this.kdtEntrys, "traWageC.text");
		dataBinder.registerBinding("entrys.eWage", java.lang.Object.class, this.kdtEntrys, "eWage.text");
		dataBinder.registerBinding("entrys.eWageC", java.math.BigDecimal.class, this.kdtEntrys, "eWageC.text");
		dataBinder.registerBinding("entrys.sevWage", java.lang.Object.class, this.kdtEntrys, "sevWage.text");
		dataBinder.registerBinding("entrys.sevTimes", int.class, this.kdtEntrys, "sevTimes.text");
		dataBinder.registerBinding("entrys.sevWageC", java.math.BigDecimal.class, this.kdtEntrys, "sevWageC.text");
		dataBinder.registerBinding("entrys.outWage", java.lang.Object.class, this.kdtEntrys, "outWage.text");
		dataBinder.registerBinding("entrys.outTimes", int.class, this.kdtEntrys, "outTimes.text");
		dataBinder.registerBinding("entrys.outWageC", java.math.BigDecimal.class, this.kdtEntrys, "outWageC.text");
		dataBinder.registerBinding("entrys.oveWage", java.lang.Object.class, this.kdtEntrys, "oveWage.text");
		dataBinder.registerBinding("entrys.oveTimes", int.class, this.kdtEntrys, "oveTimes.text");
		dataBinder.registerBinding("entrys.dengWage", java.lang.Object.class, this.kdtEntrys, "dengWage.text");
		dataBinder.registerBinding("entrys.vaWage", java.lang.Object.class, this.kdtEntrys, "vaWage.text");
		dataBinder.registerBinding("entrys.vaWageC", java.math.BigDecimal.class, this.kdtEntrys, "vaWageC.text");
		dataBinder.registerBinding("entrys.nUrgeWage", java.math.BigDecimal.class, this.kdtEntrys, "nUrgeWage.text");
		dataBinder.registerBinding("entrys.oneTimeWage", java.math.BigDecimal.class, this.kdtEntrys, "oneTimeWage.text");
		dataBinder.registerBinding("entrys.thingsWage", java.lang.Object.class, this.kdtEntrys, "thingsWage.text");
		dataBinder.registerBinding("entrys.thingsTimes", int.class, this.kdtEntrys, "thingsTimes.text");
		dataBinder.registerBinding("entrys.thingsWageC", java.math.BigDecimal.class, this.kdtEntrys, "thingsWageC.text");
		dataBinder.registerBinding("entrys.profWage", java.math.BigDecimal.class, this.kdtEntrys, "profWage.text");
		dataBinder.registerBinding("entrys.extProfWage", java.math.BigDecimal.class, this.kdtEntrys, "extProfWage.text");
		dataBinder.registerBinding("entrys.familyWage", java.lang.Object.class, this.kdtEntrys, "familyWage.text");
		dataBinder.registerBinding("entrys.studyWage", java.lang.Object.class, this.kdtEntrys, "studyWage.text");
		dataBinder.registerBinding("entrys.areaWage", java.lang.Object.class, this.kdtEntrys, "areaWage.text");
		dataBinder.registerBinding("entrys.nWorkTimes", int.class, this.kdtEntrys, "nWorkTimes.text");
		dataBinder.registerBinding("entrys.nWorkWage", java.lang.Object.class, this.kdtEntrys, "nWorkWage.text");
		dataBinder.registerBinding("entrys.nWorkWageC", java.math.BigDecimal.class, this.kdtEntrys, "nWorkWageC.text");
		dataBinder.registerBinding("entrys.switchWage", java.lang.Object.class, this.kdtEntrys, "switchWage.text");
		dataBinder.registerBinding("entrys.switchTimes", int.class, this.kdtEntrys, "switchTimes.text");
		dataBinder.registerBinding("entrys.switchWageC", java.math.BigDecimal.class, this.kdtEntrys, "switchWageC.text");
		dataBinder.registerBinding("entrys.liveWage", java.lang.Object.class, this.kdtEntrys, "liveWage.text");
		dataBinder.registerBinding("entrys.spendWage", java.math.BigDecimal.class, this.kdtEntrys, "spendWage.text");
		dataBinder.registerBinding("entrys.fireWage", java.math.BigDecimal.class, this.kdtEntrys, "fireWage.text");
		dataBinder.registerBinding("entrys.retirWage", java.math.BigDecimal.class, this.kdtEntrys, "retirWage.text");
		dataBinder.registerBinding("entrys.faraWage", java.math.BigDecimal.class, this.kdtEntrys, "faraWage.text");
		dataBinder.registerBinding("entrys.pOverAward", java.math.BigDecimal.class, this.kdtEntrys, "pOverAward.text");
		dataBinder.registerBinding("entrys.profAward", java.math.BigDecimal.class, this.kdtEntrys, "profAward.text");
		dataBinder.registerBinding("entrys.unSCVCWage", java.math.BigDecimal.class, this.kdtEntrys, "unSCVCWage.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.foriPersID", String.class, this.kdtEntrys, "foriPersID.text");
		dataBinder.registerBinding("entrys.prof", java.lang.Object.class, this.kdtEntrys, "prof.text");
		dataBinder.registerBinding("entrys.secuProf", java.lang.Object.class, this.kdtEntrys, "secuProf.text");
		dataBinder.registerBinding("entrys.nation", java.lang.Object.class, this.kdtEntrys, "nation.text");
		dataBinder.registerBinding("entrys.oneWorkWage", java.lang.Object.class, this.kdtEntrys, "oneWorkWage.text");
		dataBinder.registerBinding("entrys.totRiskWage", java.math.BigDecimal.class, this.kdtEntrys, "totRiskWage.text");
		dataBinder.registerBinding("entrys.totOneWage", java.math.BigDecimal.class, this.kdtEntrys, "totOneWage.text");
		dataBinder.registerBinding("entrys.totAreaWage", java.math.BigDecimal.class, this.kdtEntrys, "totAreaWage.text");
		dataBinder.registerBinding("entrys.totFaraWage", java.math.BigDecimal.class, this.kdtEntrys, "totFaraWage.text");
		dataBinder.registerBinding("entrys.langWage", java.lang.Object.class, this.kdtEntrys, "langWage.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.nUlOver", java.math.BigDecimal.class, this.kdtEntrys, "nUlOver.text");
		dataBinder.registerBinding("entrys.nHlOver", java.math.BigDecimal.class, this.kdtEntrys, "nHlOver.text");
		dataBinder.registerBinding("entrys.nWorkDay", java.math.BigDecimal.class, this.kdtEntrys, "nWorkDay.text");
		dataBinder.registerBinding("entrys.projSocialNo", String.class, this.kdtEntrys, "projSocialNo.text");
		dataBinder.registerBinding("entrys.phoneWageC", java.math.BigDecimal.class, this.kdtEntrys, "phoneWageC.text");
		dataBinder.registerBinding("entrys.itmperie", java.math.BigDecimal.class, this.kdtEntrys, "itmperie.text");
		dataBinder.registerBinding("entrys.itmperieTol", java.math.BigDecimal.class, this.kdtEntrys, "itmperieTol.text");
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
		dataBinder.registerBinding("permProj", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtpermProj, "data");
		dataBinder.registerBinding("billSate", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSate, "selectedItem");
		dataBinder.registerBinding("AuditDate", java.util.Date.class, this.pkAuditDate, "value");
		dataBinder.registerBinding("shCount", int.class, this.txtshCount, "value");
		dataBinder.registerBinding("monthYearr", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtmonthYearr, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.social.app.CheckCountEditUIHandler";
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
        this.prmtpermProj.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.social.CheckCountInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.province", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.MariState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CCPNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workProgram", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.apprTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contSDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contEDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.startDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nWorkDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nGalaOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nSeniority", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nBasePay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seniPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.traWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.traWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sevWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sevTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sevWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.outWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.outTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.outWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oveWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oveTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dengWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vaWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vaWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nUrgeWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oneTimeWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.thingsWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.thingsTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.thingsWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.profWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.extProfWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.familyWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.studyWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.areaWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nWorkTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nWorkWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nWorkWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.switchWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.switchTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.switchWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.liveWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.spendWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fireWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.retirWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.faraWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pOverAward", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.profAward", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unSCVCWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.foriPersID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.prof", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oneWorkWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.totRiskWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.totOneWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.totAreaWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.totFaraWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.langWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nUlOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nHlOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nWorkDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.projSocialNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.phoneWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.itmperie", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.itmperieTol", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("permProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shCount", ValidateHelper.ON_SAVE);    
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
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output prmtpermProj_dataChanged method
     */
    protected void prmtpermProj_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtmonthYearr_dataChanged method
     */
    protected void prmtmonthYearr_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
		}
    	sic.add(new SelectorItemInfo("entrys.lastName"));
    	sic.add(new SelectorItemInfo("entrys.firstName"));
    	sic.add(new SelectorItemInfo("entrys.sex"));
    	sic.add(new SelectorItemInfo("entrys.birthdate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.province.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.province.id"));
			sic.add(new SelectorItemInfo("entrys.province.name"));
        	sic.add(new SelectorItemInfo("entrys.province.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.birthPlace"));
    	sic.add(new SelectorItemInfo("entrys.MariState"));
    	sic.add(new SelectorItemInfo("entrys.secuNum"));
    	sic.add(new SelectorItemInfo("entrys.CCPNo"));
    	sic.add(new SelectorItemInfo("entrys.address"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.workProgram.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.workProgram.id"));
			sic.add(new SelectorItemInfo("entrys.workProgram.name"));
        	sic.add(new SelectorItemInfo("entrys.workProgram.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.cooperation.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.cooperation.id"));
			sic.add(new SelectorItemInfo("entrys.cooperation.name"));
        	sic.add(new SelectorItemInfo("entrys.cooperation.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.coopCode"));
    	sic.add(new SelectorItemInfo("entrys.apprTime"));
    	sic.add(new SelectorItemInfo("entrys.contSDate"));
    	sic.add(new SelectorItemInfo("entrys.contEDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.secuProj.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.secuProj.id"));
			sic.add(new SelectorItemInfo("entrys.secuProj.name"));
        	sic.add(new SelectorItemInfo("entrys.secuProj.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.startDate"));
    	sic.add(new SelectorItemInfo("entrys.endDate"));
    	sic.add(new SelectorItemInfo("entrys.nWorkDays"));
    	sic.add(new SelectorItemInfo("entrys.nGalaOver"));
    	sic.add(new SelectorItemInfo("entrys.nSeniority"));
    	sic.add(new SelectorItemInfo("entrys.nBasePay"));
    	sic.add(new SelectorItemInfo("entrys.seniPay"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.traWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.traWage.id"));
			sic.add(new SelectorItemInfo("entrys.traWage.money"));
			sic.add(new SelectorItemInfo("entrys.traWage.name"));
        	sic.add(new SelectorItemInfo("entrys.traWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.traWageC"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.eWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.eWage.id"));
			sic.add(new SelectorItemInfo("entrys.eWage.money"));
			sic.add(new SelectorItemInfo("entrys.eWage.name"));
        	sic.add(new SelectorItemInfo("entrys.eWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.eWageC"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.sevWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.sevWage.id"));
			sic.add(new SelectorItemInfo("entrys.sevWage.money"));
			sic.add(new SelectorItemInfo("entrys.sevWage.name"));
        	sic.add(new SelectorItemInfo("entrys.sevWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.sevTimes"));
    	sic.add(new SelectorItemInfo("entrys.sevWageC"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.outWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.outWage.id"));
			sic.add(new SelectorItemInfo("entrys.outWage.money"));
			sic.add(new SelectorItemInfo("entrys.outWage.name"));
        	sic.add(new SelectorItemInfo("entrys.outWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.outTimes"));
    	sic.add(new SelectorItemInfo("entrys.outWageC"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.oveWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.oveWage.id"));
			sic.add(new SelectorItemInfo("entrys.oveWage.money"));
			sic.add(new SelectorItemInfo("entrys.oveWage.name"));
        	sic.add(new SelectorItemInfo("entrys.oveWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.oveTimes"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.dengWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.dengWage.id"));
			sic.add(new SelectorItemInfo("entrys.dengWage.money"));
			sic.add(new SelectorItemInfo("entrys.dengWage.name"));
        	sic.add(new SelectorItemInfo("entrys.dengWage.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.vaWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.vaWage.id"));
			sic.add(new SelectorItemInfo("entrys.vaWage.money"));
			sic.add(new SelectorItemInfo("entrys.vaWage.name"));
        	sic.add(new SelectorItemInfo("entrys.vaWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.vaWageC"));
    	sic.add(new SelectorItemInfo("entrys.nUrgeWage"));
    	sic.add(new SelectorItemInfo("entrys.oneTimeWage"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.thingsWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.thingsWage.id"));
			sic.add(new SelectorItemInfo("entrys.thingsWage.money"));
			sic.add(new SelectorItemInfo("entrys.thingsWage.name"));
        	sic.add(new SelectorItemInfo("entrys.thingsWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.thingsTimes"));
    	sic.add(new SelectorItemInfo("entrys.thingsWageC"));
    	sic.add(new SelectorItemInfo("entrys.profWage"));
    	sic.add(new SelectorItemInfo("entrys.extProfWage"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.familyWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.familyWage.id"));
			sic.add(new SelectorItemInfo("entrys.familyWage.money"));
			sic.add(new SelectorItemInfo("entrys.familyWage.name"));
        	sic.add(new SelectorItemInfo("entrys.familyWage.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.studyWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.studyWage.id"));
			sic.add(new SelectorItemInfo("entrys.studyWage.money"));
			sic.add(new SelectorItemInfo("entrys.studyWage.name"));
        	sic.add(new SelectorItemInfo("entrys.studyWage.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.areaWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.areaWage.id"));
			sic.add(new SelectorItemInfo("entrys.areaWage.money"));
			sic.add(new SelectorItemInfo("entrys.areaWage.name"));
        	sic.add(new SelectorItemInfo("entrys.areaWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.nWorkTimes"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.nWorkWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.nWorkWage.id"));
			sic.add(new SelectorItemInfo("entrys.nWorkWage.money"));
			sic.add(new SelectorItemInfo("entrys.nWorkWage.name"));
        	sic.add(new SelectorItemInfo("entrys.nWorkWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.nWorkWageC"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.switchWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.switchWage.id"));
			sic.add(new SelectorItemInfo("entrys.switchWage.money"));
			sic.add(new SelectorItemInfo("entrys.switchWage.name"));
        	sic.add(new SelectorItemInfo("entrys.switchWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.switchTimes"));
    	sic.add(new SelectorItemInfo("entrys.switchWageC"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.liveWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.liveWage.id"));
			sic.add(new SelectorItemInfo("entrys.liveWage.money"));
			sic.add(new SelectorItemInfo("entrys.liveWage.name"));
        	sic.add(new SelectorItemInfo("entrys.liveWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.spendWage"));
    	sic.add(new SelectorItemInfo("entrys.fireWage"));
    	sic.add(new SelectorItemInfo("entrys.retirWage"));
    	sic.add(new SelectorItemInfo("entrys.faraWage"));
    	sic.add(new SelectorItemInfo("entrys.pOverAward"));
    	sic.add(new SelectorItemInfo("entrys.profAward"));
    	sic.add(new SelectorItemInfo("entrys.unSCVCWage"));
    	sic.add(new SelectorItemInfo("entrys.personID"));
    	sic.add(new SelectorItemInfo("entrys.foriPersID"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.prof.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.prof.id"));
			sic.add(new SelectorItemInfo("entrys.prof.name"));
        	sic.add(new SelectorItemInfo("entrys.prof.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.secuProf.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.secuProf.id"));
			sic.add(new SelectorItemInfo("entrys.secuProf.name"));
        	sic.add(new SelectorItemInfo("entrys.secuProf.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.nation.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.nation.id"));
			sic.add(new SelectorItemInfo("entrys.nation.name"));
        	sic.add(new SelectorItemInfo("entrys.nation.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.oneWorkWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.oneWorkWage.id"));
			sic.add(new SelectorItemInfo("entrys.oneWorkWage.money"));
			sic.add(new SelectorItemInfo("entrys.oneWorkWage.name"));
        	sic.add(new SelectorItemInfo("entrys.oneWorkWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.totRiskWage"));
    	sic.add(new SelectorItemInfo("entrys.totOneWage"));
    	sic.add(new SelectorItemInfo("entrys.totAreaWage"));
    	sic.add(new SelectorItemInfo("entrys.totFaraWage"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.langWage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.langWage.id"));
			sic.add(new SelectorItemInfo("entrys.langWage.money"));
			sic.add(new SelectorItemInfo("entrys.langWage.name"));
        	sic.add(new SelectorItemInfo("entrys.langWage.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.nUlOver"));
    	sic.add(new SelectorItemInfo("entrys.nHlOver"));
    	sic.add(new SelectorItemInfo("entrys.nWorkDay"));
    	sic.add(new SelectorItemInfo("entrys.projSocialNo"));
    	sic.add(new SelectorItemInfo("entrys.phoneWageC"));
    	sic.add(new SelectorItemInfo("entrys.itmperie"));
    	sic.add(new SelectorItemInfo("entrys.itmperieTol"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("permProj.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("permProj.id"));
        	sic.add(new SelectorItemInfo("permProj.number"));
        	sic.add(new SelectorItemInfo("permProj.name"));
		}
        sic.add(new SelectorItemInfo("billSate"));
        sic.add(new SelectorItemInfo("AuditDate"));
        sic.add(new SelectorItemInfo("shCount"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.social.client", "CheckCountEditUI");
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
        return com.kingdee.eas.zjlw.social.client.CheckCountEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.social.CheckCountFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.social.CheckCountInfo objectValue = new com.kingdee.eas.zjlw.social.CheckCountInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/social/CheckCount";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.social.app.CheckCountQuery");
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