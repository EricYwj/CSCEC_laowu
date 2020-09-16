/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

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
public abstract class AbstractAlgCheckRulesEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAlgCheckRulesEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproCom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthYear;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaftBefmins;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkdefaultRule;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contamOne;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contamTwo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpmOne;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpmTwo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcooperation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillSatee;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtproCom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmonthYear;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaftBefmins;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker amOne;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker amTwo;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker pmOne;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker pmTwo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcooperation;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSatee;
    protected com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractAlgCheckRulesEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAlgCheckRulesEditUI.class.getName());
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
        this.contproCom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthYear = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaftBefmins = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkdefaultRule = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contamOne = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contamTwo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpmOne = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpmTwo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcooperation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillSatee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtproCom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtmonthYear = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtaftBefmins = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.amOne = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.amTwo = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.pmOne = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.pmTwo = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.prmtcooperation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billSatee = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contproCom.setName("contproCom");
        this.contmonthYear.setName("contmonthYear");
        this.contaftBefmins.setName("contaftBefmins");
        this.contauditDate.setName("contauditDate");
        this.contname.setName("contname");
        this.chkdefaultRule.setName("chkdefaultRule");
        this.contamOne.setName("contamOne");
        this.contamTwo.setName("contamTwo");
        this.contpmOne.setName("contpmOne");
        this.contpmTwo.setName("contpmTwo");
        this.contcooperation.setName("contcooperation");
        this.contbillSatee.setName("contbillSatee");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtproCom.setName("prmtproCom");
        this.prmtmonthYear.setName("prmtmonthYear");
        this.txtaftBefmins.setName("txtaftBefmins");
        this.pkauditDate.setName("pkauditDate");
        this.txtname.setName("txtname");
        this.amOne.setName("amOne");
        this.amTwo.setName("amTwo");
        this.pmOne.setName("pmOne");
        this.pmTwo.setName("pmTwo");
        this.prmtcooperation.setName("prmtcooperation");
        this.billSatee.setName("billSatee");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"day\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"amOnDuty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"amOutDuty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"pmOnDuty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"pmOutDuty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"holiday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"offWork\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"goWork\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{day}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{amOnDuty}</t:Cell><t:Cell>$Resource{amOutDuty}</t:Cell><t:Cell>$Resource{pmOnDuty}</t:Cell><t:Cell>$Resource{pmOutDuty}</t:Cell><t:Cell>$Resource{holiday}</t:Cell><t:Cell>$Resource{offWork}</t:Cell><t:Cell>$Resource{goWork}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","day","week","amOnDuty","amOutDuty","pmOnDuty","pmOutDuty","holiday","offWork","goWork","remark"});


        this.kdtEntrys.checkParsed();
        KDFormattedTextField kdtEntrys_day_TextField = new KDFormattedTextField();
        kdtEntrys_day_TextField.setName("kdtEntrys_day_TextField");
        kdtEntrys_day_TextField.setVisible(true);
        kdtEntrys_day_TextField.setEditable(true);
        kdtEntrys_day_TextField.setHorizontalAlignment(2);
        kdtEntrys_day_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_day_CellEditor = new KDTDefaultCellEditor(kdtEntrys_day_TextField);
        this.kdtEntrys.getColumn("day").setEditor(kdtEntrys_day_CellEditor);
        KDComboBox kdtEntrys_week_ComboBox = new KDComboBox();
        kdtEntrys_week_ComboBox.setName("kdtEntrys_week_ComboBox");
        kdtEntrys_week_ComboBox.setVisible(true);
        kdtEntrys_week_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.cp.wfs.WeekEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_week_CellEditor = new KDTDefaultCellEditor(kdtEntrys_week_ComboBox);
        this.kdtEntrys.getColumn("week").setEditor(kdtEntrys_week_CellEditor);
        KDTimePicker kdtEntrys_amOnDuty_TimePicker = new KDTimePicker();
        kdtEntrys_amOnDuty_TimePicker.setName("kdtEntrys_amOnDuty_TimePicker");
        kdtEntrys_amOnDuty_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_amOnDuty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amOnDuty_TimePicker);
        this.kdtEntrys.getColumn("amOnDuty").setEditor(kdtEntrys_amOnDuty_CellEditor);
        KDTimePicker kdtEntrys_amOutDuty_TimePicker = new KDTimePicker();
        kdtEntrys_amOutDuty_TimePicker.setName("kdtEntrys_amOutDuty_TimePicker");
        kdtEntrys_amOutDuty_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_amOutDuty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amOutDuty_TimePicker);
        this.kdtEntrys.getColumn("amOutDuty").setEditor(kdtEntrys_amOutDuty_CellEditor);
        KDTimePicker kdtEntrys_pmOnDuty_TimePicker = new KDTimePicker();
        kdtEntrys_pmOnDuty_TimePicker.setName("kdtEntrys_pmOnDuty_TimePicker");
        kdtEntrys_pmOnDuty_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_pmOnDuty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmOnDuty_TimePicker);
        this.kdtEntrys.getColumn("pmOnDuty").setEditor(kdtEntrys_pmOnDuty_CellEditor);
        KDTimePicker kdtEntrys_pmOutDuty_TimePicker = new KDTimePicker();
        kdtEntrys_pmOutDuty_TimePicker.setName("kdtEntrys_pmOutDuty_TimePicker");
        kdtEntrys_pmOutDuty_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_pmOutDuty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmOutDuty_TimePicker);
        this.kdtEntrys.getColumn("pmOutDuty").setEditor(kdtEntrys_pmOutDuty_CellEditor);
        KDCheckBox kdtEntrys_holiday_CheckBox = new KDCheckBox();
        kdtEntrys_holiday_CheckBox.setName("kdtEntrys_holiday_CheckBox");
        KDTDefaultCellEditor kdtEntrys_holiday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_holiday_CheckBox);
        this.kdtEntrys.getColumn("holiday").setEditor(kdtEntrys_holiday_CellEditor);
        KDCheckBox kdtEntrys_offWork_CheckBox = new KDCheckBox();
        kdtEntrys_offWork_CheckBox.setName("kdtEntrys_offWork_CheckBox");
        KDTDefaultCellEditor kdtEntrys_offWork_CellEditor = new KDTDefaultCellEditor(kdtEntrys_offWork_CheckBox);
        this.kdtEntrys.getColumn("offWork").setEditor(kdtEntrys_offWork_CellEditor);
        KDCheckBox kdtEntrys_goWork_CheckBox = new KDCheckBox();
        kdtEntrys_goWork_CheckBox.setName("kdtEntrys_goWork_CheckBox");
        KDTDefaultCellEditor kdtEntrys_goWork_CellEditor = new KDTDefaultCellEditor(kdtEntrys_goWork_CheckBox);
        this.kdtEntrys.getColumn("goWork").setEditor(kdtEntrys_goWork_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        // contproCom		
        this.contproCom.setBoundLabelText(resHelper.getString("contproCom.boundLabelText"));		
        this.contproCom.setBoundLabelLength(100);		
        this.contproCom.setBoundLabelUnderline(true);		
        this.contproCom.setVisible(true);
        // contmonthYear		
        this.contmonthYear.setBoundLabelText(resHelper.getString("contmonthYear.boundLabelText"));		
        this.contmonthYear.setBoundLabelLength(100);		
        this.contmonthYear.setBoundLabelUnderline(true);		
        this.contmonthYear.setVisible(true);
        // contaftBefmins		
        this.contaftBefmins.setBoundLabelText(resHelper.getString("contaftBefmins.boundLabelText"));		
        this.contaftBefmins.setBoundLabelLength(120);		
        this.contaftBefmins.setBoundLabelUnderline(true);		
        this.contaftBefmins.setVisible(true);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);		
        this.contauditDate.setEnabled(false);
        // contname		
        this.contname.setBoundLabelText(resHelper.getString("contname.boundLabelText"));		
        this.contname.setBoundLabelLength(100);		
        this.contname.setBoundLabelUnderline(true);		
        this.contname.setVisible(true);
        // chkdefaultRule		
        this.chkdefaultRule.setText(resHelper.getString("chkdefaultRule.text"));		
        this.chkdefaultRule.setHorizontalAlignment(2);
        // contamOne		
        this.contamOne.setBoundLabelText(resHelper.getString("contamOne.boundLabelText"));		
        this.contamOne.setBoundLabelLength(100);		
        this.contamOne.setBoundLabelUnderline(true);		
        this.contamOne.setVisible(true);
        // contamTwo		
        this.contamTwo.setBoundLabelText(resHelper.getString("contamTwo.boundLabelText"));		
        this.contamTwo.setBoundLabelLength(100);		
        this.contamTwo.setBoundLabelUnderline(true);		
        this.contamTwo.setVisible(true);
        // contpmOne		
        this.contpmOne.setBoundLabelText(resHelper.getString("contpmOne.boundLabelText"));		
        this.contpmOne.setBoundLabelLength(100);		
        this.contpmOne.setBoundLabelUnderline(true);		
        this.contpmOne.setVisible(true);
        // contpmTwo		
        this.contpmTwo.setBoundLabelText(resHelper.getString("contpmTwo.boundLabelText"));		
        this.contpmTwo.setBoundLabelLength(100);		
        this.contpmTwo.setBoundLabelUnderline(true);		
        this.contpmTwo.setVisible(true);
        // contcooperation		
        this.contcooperation.setBoundLabelText(resHelper.getString("contcooperation.boundLabelText"));		
        this.contcooperation.setBoundLabelLength(100);		
        this.contcooperation.setBoundLabelUnderline(true);		
        this.contcooperation.setVisible(true);
        // contbillSatee		
        this.contbillSatee.setBoundLabelText(resHelper.getString("contbillSatee.boundLabelText"));		
        this.contbillSatee.setBoundLabelLength(100);		
        this.contbillSatee.setBoundLabelUnderline(true);		
        this.contbillSatee.setVisible(true);		
        this.contbillSatee.setEnabled(false);
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
        // prmtproCom		
        this.prmtproCom.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtproCom.setEditable(true);		
        this.prmtproCom.setDisplayFormat("$name$");		
        this.prmtproCom.setEditFormat("$number$");		
        this.prmtproCom.setCommitFormat("$number$");		
        this.prmtproCom.setRequired(false);
        // prmtmonthYear		
        this.prmtmonthYear.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtmonthYear.setEditable(true);		
        this.prmtmonthYear.setDisplayFormat("$number$");		
        this.prmtmonthYear.setEditFormat("$number$");		
        this.prmtmonthYear.setCommitFormat("$number$");		
        this.prmtmonthYear.setRequired(false);
        this.prmtmonthYear.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtmonthYear_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtaftBefmins		
        this.txtaftBefmins.setHorizontalAlignment(2);		
        this.txtaftBefmins.setDataType(0);		
        this.txtaftBefmins.setSupportedEmpty(true);		
        this.txtaftBefmins.setRequired(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);		
        this.pkauditDate.setEnabled(false);
        // txtname		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(100);		
        this.txtname.setRequired(false);
        this.txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtname_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // amOne
        this.amOne.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    amOne_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // amTwo
        this.amTwo.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    amTwo_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // pmOne
        this.pmOne.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pmOne_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // pmTwo
        this.pmTwo.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pmTwo_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtcooperation		
        this.prmtcooperation.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcooperation.setEditable(true);		
        this.prmtcooperation.setDisplayFormat("$name$");		
        this.prmtcooperation.setEditFormat("$number$");		
        this.prmtcooperation.setCommitFormat("$number$");		
        this.prmtcooperation.setRequired(false);
        // billSatee		
        this.billSatee.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billSatee.setRequired(false);		
        this.billSatee.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pmOne,pmTwo,prmtproCom,prmtmonthYear,txtaftBefmins,pkauditDate,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtname,chkdefaultRule,amOne,amTwo,prmtcooperation,billSatee,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, -91, 1119, 626));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, -91, 1119, 626));
        contCreator.setBounds(new Rectangle(586, 598, 233, 19));
        this.add(contCreator, new KDLayout.Constraints(586, 598, 233, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(874, 599, 233, 19));
        this.add(contCreateTime, new KDLayout.Constraints(874, 599, 233, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(248, 652, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(248, 652, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(629, 653, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(629, 653, 270, 19, 0));
        contNumber.setBounds(new Rectangle(17, 7, 307, 19));
        this.add(contNumber, new KDLayout.Constraints(17, 7, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(403, 36, 307, 19));
        this.add(contBizDate, new KDLayout.Constraints(403, 36, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(15, 155, 696, 19));
        this.add(contDescription, new KDLayout.Constraints(15, 155, 696, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(298, 598, 233, 19));
        this.add(contAuditor, new KDLayout.Constraints(298, 598, 233, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(9, 178, 1102, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.attendance.AlgCheckRulesEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(9, 178, 1102, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("week",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contproCom.setBounds(new Rectangle(17, 66, 307, 19));
        this.add(contproCom, new KDLayout.Constraints(17, 66, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmonthYear.setBounds(new Rectangle(17, 36, 307, 19));
        this.add(contmonthYear, new KDLayout.Constraints(17, 36, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaftBefmins.setBounds(new Rectangle(790, 66, 307, 19));
        this.add(contaftBefmins, new KDLayout.Constraints(790, 66, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditDate.setBounds(new Rectangle(10, 598, 233, 19));
        this.add(contauditDate, new KDLayout.Constraints(10, 598, 233, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contname.setBounds(new Rectangle(403, 7, 307, 19));
        this.add(contname, new KDLayout.Constraints(403, 7, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkdefaultRule.setBounds(new Rectangle(790, 36, 307, 19));
        this.add(chkdefaultRule, new KDLayout.Constraints(790, 36, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contamOne.setBounds(new Rectangle(15, 95, 307, 19));
        this.add(contamOne, new KDLayout.Constraints(15, 95, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contamTwo.setBounds(new Rectangle(403, 95, 307, 19));
        this.add(contamTwo, new KDLayout.Constraints(403, 95, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpmOne.setBounds(new Rectangle(15, 126, 307, 19));
        this.add(contpmOne, new KDLayout.Constraints(15, 126, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpmTwo.setBounds(new Rectangle(403, 126, 307, 19));
        this.add(contpmTwo, new KDLayout.Constraints(403, 126, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcooperation.setBounds(new Rectangle(403, 66, 307, 19));
        this.add(contcooperation, new KDLayout.Constraints(403, 66, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillSatee.setBounds(new Rectangle(790, 7, 307, 19));
        this.add(contbillSatee, new KDLayout.Constraints(790, 7, 307, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contproCom
        contproCom.setBoundEditor(prmtproCom);
        //contmonthYear
        contmonthYear.setBoundEditor(prmtmonthYear);
        //contaftBefmins
        contaftBefmins.setBoundEditor(txtaftBefmins);
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);
        //contname
        contname.setBoundEditor(txtname);
        //contamOne
        contamOne.setBoundEditor(amOne);
        //contamTwo
        contamTwo.setBoundEditor(amTwo);
        //contpmOne
        contpmOne.setBoundEditor(pmOne);
        //contpmTwo
        contpmTwo.setBoundEditor(pmTwo);
        //contcooperation
        contcooperation.setBoundEditor(prmtcooperation);
        //contbillSatee
        contbillSatee.setBoundEditor(billSatee);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.attendance.AlgCheckRulesEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.day", int.class, this.kdtEntrys, "day.text");
		dataBinder.registerBinding("entrys.week", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "week.text");
		dataBinder.registerBinding("entrys.amOnDuty", java.sql.Time.class, this.kdtEntrys, "amOnDuty.text");
		dataBinder.registerBinding("entrys.amOutDuty", java.sql.Time.class, this.kdtEntrys, "amOutDuty.text");
		dataBinder.registerBinding("entrys.pmOnDuty", java.sql.Time.class, this.kdtEntrys, "pmOnDuty.text");
		dataBinder.registerBinding("entrys.pmOutDuty", java.sql.Time.class, this.kdtEntrys, "pmOutDuty.text");
		dataBinder.registerBinding("entrys.holiday", boolean.class, this.kdtEntrys, "holiday.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.offWork", boolean.class, this.kdtEntrys, "offWork.text");
		dataBinder.registerBinding("entrys.goWork", boolean.class, this.kdtEntrys, "goWork.text");
		dataBinder.registerBinding("defaultRule", boolean.class, this.chkdefaultRule, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("proCom", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtproCom, "data");
		dataBinder.registerBinding("monthYear", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtmonthYear, "data");
		dataBinder.registerBinding("aftBefmins", int.class, this.txtaftBefmins, "value");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("name", String.class, this.txtname, "text");
		dataBinder.registerBinding("amOne", java.sql.Time.class, this.amOne, "value");
		dataBinder.registerBinding("amTwo", java.sql.Time.class, this.amTwo, "value");
		dataBinder.registerBinding("pmOne", java.sql.Time.class, this.pmOne, "value");
		dataBinder.registerBinding("pmTwo", java.sql.Time.class, this.pmTwo, "value");
		dataBinder.registerBinding("cooperation", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcooperation, "data");
		dataBinder.registerBinding("billSatee", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSatee, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.attendance.app.AlgCheckRulesEditUIHandler";
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
        this.pmOne.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.day", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amOnDuty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amOutDuty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmOnDuty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmOutDuty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.holiday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.offWork", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.goWork", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultRule", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proCom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthYear", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("aftBefmins", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("amOne", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("amTwo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pmOne", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pmTwo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSatee", ValidateHelper.ON_SAVE);    		
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
     * output prmtmonthYear_dataChanged method
     */
    protected void prmtmonthYear_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtname_actionPerformed method
     */
    protected void txtname_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output amOne_dataChanged method
     */
    protected void amOne_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output amTwo_dataChanged method
     */
    protected void amTwo_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output pmOne_dataChanged method
     */
    protected void pmOne_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output pmTwo_dataChanged method
     */
    protected void pmTwo_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
    	sic.add(new SelectorItemInfo("entrys.day"));
    	sic.add(new SelectorItemInfo("entrys.week"));
    	sic.add(new SelectorItemInfo("entrys.amOnDuty"));
    	sic.add(new SelectorItemInfo("entrys.amOutDuty"));
    	sic.add(new SelectorItemInfo("entrys.pmOnDuty"));
    	sic.add(new SelectorItemInfo("entrys.pmOutDuty"));
    	sic.add(new SelectorItemInfo("entrys.holiday"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.offWork"));
    	sic.add(new SelectorItemInfo("entrys.goWork"));
        sic.add(new SelectorItemInfo("defaultRule"));
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
			sic.add(new SelectorItemInfo("proCom.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("proCom.id"));
        	sic.add(new SelectorItemInfo("proCom.number"));
        	sic.add(new SelectorItemInfo("proCom.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("monthYear.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("monthYear.id"));
        	sic.add(new SelectorItemInfo("monthYear.number"));
		}
        sic.add(new SelectorItemInfo("aftBefmins"));
        sic.add(new SelectorItemInfo("auditDate"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("amOne"));
        sic.add(new SelectorItemInfo("amTwo"));
        sic.add(new SelectorItemInfo("pmOne"));
        sic.add(new SelectorItemInfo("pmTwo"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("cooperation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("cooperation.id"));
        	sic.add(new SelectorItemInfo("cooperation.number"));
        	sic.add(new SelectorItemInfo("cooperation.name"));
		}
        sic.add(new SelectorItemInfo("billSatee"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.attendance.client", "AlgCheckRulesEditUI");
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
        return com.kingdee.eas.zjlw.attendance.client.AlgCheckRulesEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.attendance.AlgCheckRulesFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo objectValue = new com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/attendance/AlgCheckRules";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.attendance.app.AlgCheckRulesQuery");
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
		vo.put("billSatee","10");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}