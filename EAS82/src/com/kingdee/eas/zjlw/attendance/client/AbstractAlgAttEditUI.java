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
public abstract class AbstractAlgAttEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAlgAttEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillSate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthYear;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtproCom;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmonthYear;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.eas.zjlw.attendance.AlgAttInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractAlgAttEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAlgAttEditUI.class.getName());
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
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillSate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthYear = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtproCom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.billSate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtmonthYear = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
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
        this.contauditDate.setName("contauditDate");
        this.contbillSate.setName("contbillSate");
        this.contmonthYear.setName("contmonthYear");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtproCom.setName("prmtproCom");
        this.pkauditDate.setName("pkauditDate");
        this.billSate.setName("billSate");
        this.prmtmonthYear.setName("prmtmonthYear");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"personId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"chcNormal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"chkDis\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"noWorkTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"hoOverTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"overTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"traDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"workDay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"CchkNormal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"CchkDis\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"CnoWorkTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"CoverTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"ChoOverTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"CtraDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"CworkDay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"attDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header2\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{personId}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{chcNormal}</t:Cell><t:Cell>$Resource{chkDis}</t:Cell><t:Cell>$Resource{noWorkTime}</t:Cell><t:Cell>$Resource{hoOverTime}</t:Cell><t:Cell>$Resource{overTime}</t:Cell><t:Cell>$Resource{traDays}</t:Cell><t:Cell>$Resource{workDay}</t:Cell><t:Cell>$Resource{CchkNormal}</t:Cell><t:Cell>$Resource{CchkDis}</t:Cell><t:Cell>$Resource{CnoWorkTime}</t:Cell><t:Cell>$Resource{CoverTime}</t:Cell><t:Cell>$Resource{ChoOverTime}</t:Cell><t:Cell>$Resource{CtraDays}</t:Cell><t:Cell>$Resource{CworkDay}</t:Cell><t:Cell>$Resource{attDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id_Row2}</t:Cell><t:Cell>$Resource{personId_Row2}</t:Cell><t:Cell>$Resource{name_Row2}</t:Cell><t:Cell>$Resource{chcNormal_Row2}</t:Cell><t:Cell>$Resource{chkDis_Row2}</t:Cell><t:Cell>$Resource{noWorkTime_Row2}</t:Cell><t:Cell>$Resource{hoOverTime_Row2}</t:Cell><t:Cell>$Resource{overTime_Row2}</t:Cell><t:Cell>$Resource{traDays_Row2}</t:Cell><t:Cell>$Resource{workDay_Row2}</t:Cell><t:Cell>$Resource{CchkNormal_Row2}</t:Cell><t:Cell>$Resource{CchkDis_Row2}</t:Cell><t:Cell>$Resource{CnoWorkTime_Row2}</t:Cell><t:Cell>$Resource{CoverTime_Row2}</t:Cell><t:Cell>$Resource{ChoOverTime_Row2}</t:Cell><t:Cell>$Resource{CtraDays_Row2}</t:Cell><t:Cell>$Resource{CworkDay_Row2}</t:Cell><t:Cell>$Resource{attDate_Row2}</t:Cell><t:Cell>$Resource{remark_Row2}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head><t:Block t:top=\"0\" t:left=\"1\" t:bottom=\"0\" t:right=\"9\" /><t:Block t:top=\"0\" t:left=\"10\" t:bottom=\"0\" t:right=\"18\" /></t:Head></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","personId","name","chcNormal","chkDis","noWorkTime","hoOverTime","overTime","traDays","workDay","CchkNormal","CchkDis","CnoWorkTime","CoverTime","ChoOverTime","CtraDays","CworkDay","attDate","remark"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_personId_TextField = new KDTextField();
        kdtEntrys_personId_TextField.setName("kdtEntrys_personId_TextField");
        kdtEntrys_personId_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_personId_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personId_TextField);
        this.kdtEntrys.getColumn("personId").setEditor(kdtEntrys_personId_CellEditor);
        KDTextField kdtEntrys_name_TextField = new KDTextField();
        kdtEntrys_name_TextField.setName("kdtEntrys_name_TextField");
        kdtEntrys_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_name_CellEditor = new KDTDefaultCellEditor(kdtEntrys_name_TextField);
        this.kdtEntrys.getColumn("name").setEditor(kdtEntrys_name_CellEditor);
        KDFormattedTextField kdtEntrys_chcNormal_TextField = new KDFormattedTextField();
        kdtEntrys_chcNormal_TextField.setName("kdtEntrys_chcNormal_TextField");
        kdtEntrys_chcNormal_TextField.setVisible(true);
        kdtEntrys_chcNormal_TextField.setEditable(true);
        kdtEntrys_chcNormal_TextField.setHorizontalAlignment(2);
        kdtEntrys_chcNormal_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_chcNormal_CellEditor = new KDTDefaultCellEditor(kdtEntrys_chcNormal_TextField);
        this.kdtEntrys.getColumn("chcNormal").setEditor(kdtEntrys_chcNormal_CellEditor);
        KDFormattedTextField kdtEntrys_chkDis_TextField = new KDFormattedTextField();
        kdtEntrys_chkDis_TextField.setName("kdtEntrys_chkDis_TextField");
        kdtEntrys_chkDis_TextField.setVisible(true);
        kdtEntrys_chkDis_TextField.setEditable(true);
        kdtEntrys_chkDis_TextField.setHorizontalAlignment(2);
        kdtEntrys_chkDis_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_chkDis_CellEditor = new KDTDefaultCellEditor(kdtEntrys_chkDis_TextField);
        this.kdtEntrys.getColumn("chkDis").setEditor(kdtEntrys_chkDis_CellEditor);
        KDFormattedTextField kdtEntrys_noWorkTime_TextField = new KDFormattedTextField();
        kdtEntrys_noWorkTime_TextField.setName("kdtEntrys_noWorkTime_TextField");
        kdtEntrys_noWorkTime_TextField.setVisible(true);
        kdtEntrys_noWorkTime_TextField.setEditable(true);
        kdtEntrys_noWorkTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_noWorkTime_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_noWorkTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_noWorkTime_TextField);
        this.kdtEntrys.getColumn("noWorkTime").setEditor(kdtEntrys_noWorkTime_CellEditor);
        KDFormattedTextField kdtEntrys_hoOverTime_TextField = new KDFormattedTextField();
        kdtEntrys_hoOverTime_TextField.setName("kdtEntrys_hoOverTime_TextField");
        kdtEntrys_hoOverTime_TextField.setVisible(true);
        kdtEntrys_hoOverTime_TextField.setEditable(true);
        kdtEntrys_hoOverTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_hoOverTime_TextField.setDataType(1);
        	kdtEntrys_hoOverTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E27"));
        	kdtEntrys_hoOverTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E27"));
        kdtEntrys_hoOverTime_TextField.setPrecision(1);
        KDTDefaultCellEditor kdtEntrys_hoOverTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hoOverTime_TextField);
        this.kdtEntrys.getColumn("hoOverTime").setEditor(kdtEntrys_hoOverTime_CellEditor);
        KDFormattedTextField kdtEntrys_overTime_TextField = new KDFormattedTextField();
        kdtEntrys_overTime_TextField.setName("kdtEntrys_overTime_TextField");
        kdtEntrys_overTime_TextField.setVisible(true);
        kdtEntrys_overTime_TextField.setEditable(true);
        kdtEntrys_overTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_overTime_TextField.setDataType(1);
        	kdtEntrys_overTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E27"));
        	kdtEntrys_overTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E27"));
        kdtEntrys_overTime_TextField.setPrecision(1);
        KDTDefaultCellEditor kdtEntrys_overTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_overTime_TextField);
        this.kdtEntrys.getColumn("overTime").setEditor(kdtEntrys_overTime_CellEditor);
        KDFormattedTextField kdtEntrys_traDays_TextField = new KDFormattedTextField();
        kdtEntrys_traDays_TextField.setName("kdtEntrys_traDays_TextField");
        kdtEntrys_traDays_TextField.setVisible(true);
        kdtEntrys_traDays_TextField.setEditable(true);
        kdtEntrys_traDays_TextField.setHorizontalAlignment(2);
        kdtEntrys_traDays_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_traDays_CellEditor = new KDTDefaultCellEditor(kdtEntrys_traDays_TextField);
        this.kdtEntrys.getColumn("traDays").setEditor(kdtEntrys_traDays_CellEditor);
        KDFormattedTextField kdtEntrys_workDay_TextField = new KDFormattedTextField();
        kdtEntrys_workDay_TextField.setName("kdtEntrys_workDay_TextField");
        kdtEntrys_workDay_TextField.setVisible(true);
        kdtEntrys_workDay_TextField.setEditable(true);
        kdtEntrys_workDay_TextField.setHorizontalAlignment(2);
        kdtEntrys_workDay_TextField.setDataType(1);
        	kdtEntrys_workDay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E27"));
        	kdtEntrys_workDay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E27"));
        kdtEntrys_workDay_TextField.setPrecision(1);
        KDTDefaultCellEditor kdtEntrys_workDay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workDay_TextField);
        this.kdtEntrys.getColumn("workDay").setEditor(kdtEntrys_workDay_CellEditor);
        KDFormattedTextField kdtEntrys_CchkNormal_TextField = new KDFormattedTextField();
        kdtEntrys_CchkNormal_TextField.setName("kdtEntrys_CchkNormal_TextField");
        kdtEntrys_CchkNormal_TextField.setVisible(true);
        kdtEntrys_CchkNormal_TextField.setEditable(true);
        kdtEntrys_CchkNormal_TextField.setHorizontalAlignment(2);
        kdtEntrys_CchkNormal_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_CchkNormal_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CchkNormal_TextField);
        this.kdtEntrys.getColumn("CchkNormal").setEditor(kdtEntrys_CchkNormal_CellEditor);
        KDFormattedTextField kdtEntrys_CchkDis_TextField = new KDFormattedTextField();
        kdtEntrys_CchkDis_TextField.setName("kdtEntrys_CchkDis_TextField");
        kdtEntrys_CchkDis_TextField.setVisible(true);
        kdtEntrys_CchkDis_TextField.setEditable(true);
        kdtEntrys_CchkDis_TextField.setHorizontalAlignment(2);
        kdtEntrys_CchkDis_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_CchkDis_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CchkDis_TextField);
        this.kdtEntrys.getColumn("CchkDis").setEditor(kdtEntrys_CchkDis_CellEditor);
        KDFormattedTextField kdtEntrys_CnoWorkTime_TextField = new KDFormattedTextField();
        kdtEntrys_CnoWorkTime_TextField.setName("kdtEntrys_CnoWorkTime_TextField");
        kdtEntrys_CnoWorkTime_TextField.setVisible(true);
        kdtEntrys_CnoWorkTime_TextField.setEditable(true);
        kdtEntrys_CnoWorkTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_CnoWorkTime_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_CnoWorkTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CnoWorkTime_TextField);
        this.kdtEntrys.getColumn("CnoWorkTime").setEditor(kdtEntrys_CnoWorkTime_CellEditor);
        KDFormattedTextField kdtEntrys_CoverTime_TextField = new KDFormattedTextField();
        kdtEntrys_CoverTime_TextField.setName("kdtEntrys_CoverTime_TextField");
        kdtEntrys_CoverTime_TextField.setVisible(true);
        kdtEntrys_CoverTime_TextField.setEditable(true);
        kdtEntrys_CoverTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_CoverTime_TextField.setDataType(1);
        	kdtEntrys_CoverTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E27"));
        	kdtEntrys_CoverTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E27"));
        kdtEntrys_CoverTime_TextField.setPrecision(1);
        KDTDefaultCellEditor kdtEntrys_CoverTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CoverTime_TextField);
        this.kdtEntrys.getColumn("CoverTime").setEditor(kdtEntrys_CoverTime_CellEditor);
        KDFormattedTextField kdtEntrys_ChoOverTime_TextField = new KDFormattedTextField();
        kdtEntrys_ChoOverTime_TextField.setName("kdtEntrys_ChoOverTime_TextField");
        kdtEntrys_ChoOverTime_TextField.setVisible(true);
        kdtEntrys_ChoOverTime_TextField.setEditable(true);
        kdtEntrys_ChoOverTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_ChoOverTime_TextField.setDataType(1);
        	kdtEntrys_ChoOverTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E27"));
        	kdtEntrys_ChoOverTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E27"));
        kdtEntrys_ChoOverTime_TextField.setPrecision(1);
        KDTDefaultCellEditor kdtEntrys_ChoOverTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ChoOverTime_TextField);
        this.kdtEntrys.getColumn("ChoOverTime").setEditor(kdtEntrys_ChoOverTime_CellEditor);
        KDFormattedTextField kdtEntrys_CtraDays_TextField = new KDFormattedTextField();
        kdtEntrys_CtraDays_TextField.setName("kdtEntrys_CtraDays_TextField");
        kdtEntrys_CtraDays_TextField.setVisible(true);
        kdtEntrys_CtraDays_TextField.setEditable(true);
        kdtEntrys_CtraDays_TextField.setHorizontalAlignment(2);
        kdtEntrys_CtraDays_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_CtraDays_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CtraDays_TextField);
        this.kdtEntrys.getColumn("CtraDays").setEditor(kdtEntrys_CtraDays_CellEditor);
        KDFormattedTextField kdtEntrys_CworkDay_TextField = new KDFormattedTextField();
        kdtEntrys_CworkDay_TextField.setName("kdtEntrys_CworkDay_TextField");
        kdtEntrys_CworkDay_TextField.setVisible(true);
        kdtEntrys_CworkDay_TextField.setEditable(true);
        kdtEntrys_CworkDay_TextField.setHorizontalAlignment(2);
        kdtEntrys_CworkDay_TextField.setDataType(1);
        	kdtEntrys_CworkDay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E27"));
        	kdtEntrys_CworkDay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E27"));
        kdtEntrys_CworkDay_TextField.setPrecision(1);
        KDTDefaultCellEditor kdtEntrys_CworkDay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CworkDay_TextField);
        this.kdtEntrys.getColumn("CworkDay").setEditor(kdtEntrys_CworkDay_CellEditor);
        KDDatePicker kdtEntrys_attDate_DatePicker = new KDDatePicker();
        kdtEntrys_attDate_DatePicker.setName("kdtEntrys_attDate_DatePicker");
        kdtEntrys_attDate_DatePicker.setVisible(true);
        kdtEntrys_attDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_attDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_attDate_DatePicker);
        this.kdtEntrys.getColumn("attDate").setEditor(kdtEntrys_attDate_CellEditor);
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
        this.contproCom.setEnabled(false);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);		
        this.contauditDate.setEnabled(false);
        // contbillSate		
        this.contbillSate.setBoundLabelText(resHelper.getString("contbillSate.boundLabelText"));		
        this.contbillSate.setBoundLabelLength(100);		
        this.contbillSate.setBoundLabelUnderline(true);		
        this.contbillSate.setVisible(true);		
        this.contbillSate.setEnabled(false);
        // contmonthYear		
        this.contmonthYear.setBoundLabelText(resHelper.getString("contmonthYear.boundLabelText"));		
        this.contmonthYear.setBoundLabelLength(100);		
        this.contmonthYear.setBoundLabelUnderline(true);		
        this.contmonthYear.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
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
        this.prmtproCom.setEnabled(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);		
        this.pkauditDate.setEnabled(false);
        // billSate		
        this.billSate.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billSate.setRequired(false);		
        this.billSate.setEnabled(false);
        // prmtmonthYear		
        this.prmtmonthYear.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtmonthYear.setEditable(true);		
        this.prmtmonthYear.setDisplayFormat("$number$");		
        this.prmtmonthYear.setEditFormat("$number$");		
        this.prmtmonthYear.setCommitFormat("$number$");		
        this.prmtmonthYear.setRequired(false);
        // pkbeginDate		
        this.pkbeginDate.setRequired(false);
        this.pkbeginDate.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pkbeginDate_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // pkendDate		
        this.pkendDate.setRequired(false);
        this.pkendDate.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pkendDate_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtproCom,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditDate,billSate,prmtmonthYear,pkbeginDate,pkendDate,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1152, 567));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1152, 567));
        contCreator.setBounds(new Rectangle(559, 540, 254, 19));
        this.add(contCreator, new KDLayout.Constraints(559, 540, 254, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(834, 540, 254, 19));
        this.add(contCreateTime, new KDLayout.Constraints(834, 540, 254, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(35, 588, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(35, 588, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(327, 591, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(327, 591, 270, 19, 0));
        contNumber.setBounds(new Rectangle(9, 12, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(9, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(583, 12, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(583, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(9, 82, 847, 19));
        this.add(contDescription, new KDLayout.Constraints(9, 82, 847, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(11, 540, 254, 19));
        this.add(contAuditor, new KDLayout.Constraints(11, 540, 254, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(10, 120, 1132, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.attendance.AlgAttEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(10, 120, 1132, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contproCom.setBounds(new Rectangle(296, 12, 270, 19));
        this.add(contproCom, new KDLayout.Constraints(296, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditDate.setBounds(new Rectangle(285, 540, 254, 19));
        this.add(contauditDate, new KDLayout.Constraints(285, 540, 254, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillSate.setBounds(new Rectangle(870, 12, 270, 19));
        this.add(contbillSate, new KDLayout.Constraints(870, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmonthYear.setBounds(new Rectangle(9, 47, 270, 19));
        this.add(contmonthYear, new KDLayout.Constraints(9, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(296, 47, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(296, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(583, 47, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(583, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);
        //contbillSate
        contbillSate.setBoundEditor(billSate);
        //contmonthYear
        contmonthYear.setBoundEditor(prmtmonthYear);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.attendance.AlgAttEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.personId", String.class, this.kdtEntrys, "personId.text");
		dataBinder.registerBinding("entrys.name", String.class, this.kdtEntrys, "name.text");
		dataBinder.registerBinding("entrys.noWorkTime", int.class, this.kdtEntrys, "noWorkTime.text");
		dataBinder.registerBinding("entrys.hoOverTime", java.math.BigDecimal.class, this.kdtEntrys, "hoOverTime.text");
		dataBinder.registerBinding("entrys.overTime", java.math.BigDecimal.class, this.kdtEntrys, "overTime.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.attDate", java.util.Date.class, this.kdtEntrys, "attDate.text");
		dataBinder.registerBinding("entrys.CnoWorkTime", int.class, this.kdtEntrys, "CnoWorkTime.text");
		dataBinder.registerBinding("entrys.CoverTime", java.math.BigDecimal.class, this.kdtEntrys, "CoverTime.text");
		dataBinder.registerBinding("entrys.ChoOverTime", java.math.BigDecimal.class, this.kdtEntrys, "ChoOverTime.text");
		dataBinder.registerBinding("entrys.workDay", java.math.BigDecimal.class, this.kdtEntrys, "workDay.text");
		dataBinder.registerBinding("entrys.CworkDay", java.math.BigDecimal.class, this.kdtEntrys, "CworkDay.text");
		dataBinder.registerBinding("entrys.traDays", int.class, this.kdtEntrys, "traDays.text");
		dataBinder.registerBinding("entrys.CtraDays", int.class, this.kdtEntrys, "CtraDays.text");
		dataBinder.registerBinding("entrys.CchkNormal", int.class, this.kdtEntrys, "CchkNormal.text");
		dataBinder.registerBinding("entrys.chcNormal", int.class, this.kdtEntrys, "chcNormal.text");
		dataBinder.registerBinding("entrys.chkDis", int.class, this.kdtEntrys, "chkDis.text");
		dataBinder.registerBinding("entrys.CchkDis", int.class, this.kdtEntrys, "CchkDis.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("proCom", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtproCom, "data");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("billSate", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSate, "selectedItem");
		dataBinder.registerBinding("monthYear", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtmonthYear, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.attendance.app.AlgAttEditUIHandler";
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
        this.prmtproCom.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.attendance.AlgAttInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.personId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.noWorkTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hoOverTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.overTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.attDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CnoWorkTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CoverTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ChoOverTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CworkDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.traDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CtraDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CchkNormal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.chcNormal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.chkDis", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CchkDis", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proCom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthYear", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    		
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
     * output pkbeginDate_dataChanged method
     */
    protected void pkbeginDate_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output pkendDate_dataChanged method
     */
    protected void pkendDate_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
    	sic.add(new SelectorItemInfo("entrys.personId"));
    	sic.add(new SelectorItemInfo("entrys.noWorkTime"));
    	sic.add(new SelectorItemInfo("entrys.hoOverTime"));
    	sic.add(new SelectorItemInfo("entrys.overTime"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.attDate"));
    	sic.add(new SelectorItemInfo("entrys.CnoWorkTime"));
    	sic.add(new SelectorItemInfo("entrys.CoverTime"));
    	sic.add(new SelectorItemInfo("entrys.ChoOverTime"));
    	sic.add(new SelectorItemInfo("entrys.workDay"));
    	sic.add(new SelectorItemInfo("entrys.CworkDay"));
    	sic.add(new SelectorItemInfo("entrys.traDays"));
    	sic.add(new SelectorItemInfo("entrys.CtraDays"));
    	sic.add(new SelectorItemInfo("entrys.CchkNormal"));
    	sic.add(new SelectorItemInfo("entrys.chcNormal"));
    	sic.add(new SelectorItemInfo("entrys.chkDis"));
    	sic.add(new SelectorItemInfo("entrys.CchkDis"));
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
        sic.add(new SelectorItemInfo("auditDate"));
        sic.add(new SelectorItemInfo("billSate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("monthYear.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("monthYear.id"));
        	sic.add(new SelectorItemInfo("monthYear.number"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.attendance.client", "AlgAttEditUI");
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
        return com.kingdee.eas.zjlw.attendance.client.AlgAttEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.attendance.AlgAttFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.attendance.AlgAttInfo objectValue = new com.kingdee.eas.zjlw.attendance.AlgAttInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/attendance/AlgAtt";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.attendance.app.AlgAttQuery");
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