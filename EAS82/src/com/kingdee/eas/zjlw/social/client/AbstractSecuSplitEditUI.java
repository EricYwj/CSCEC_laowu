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
public abstract class AbstractSecuSplitEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSecuSplitEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillSate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contforiScCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalgScCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsecuCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contforiScMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalgScMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contforiVcMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalgVcMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contscVcCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojFR;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojSC;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthYearr;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisOk;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprojName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtforiScCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalgScCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsecuCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtforiScMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalgScMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtforiVcMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalgVcMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtscVcCount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtprojFR;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtprojSC;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmonthYearr;
    protected com.kingdee.eas.zjlw.social.SecuSplitInfo editData = null;
    protected ActionUpdateData actionUpdateData = null;
    /**
     * output class constructor
     */
    public AbstractSecuSplitEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSecuSplitEditUI.class.getName());
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
        //actionUpdateData
        this.actionUpdateData = new ActionUpdateData(this);
        getActionManager().registerAction("actionUpdateData", actionUpdateData);
         this.actionUpdateData.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contprojName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillSate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contforiScCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalgScCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsecuCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contforiScMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalgScMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contforiVcMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalgVcMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contscVcCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojFR = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojSC = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthYearr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisOk = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtprojName = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billSate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkAuditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtforiScCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalgScCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsecuCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtforiScMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalgScMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtforiVcMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalgVcMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtscVcCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtprojFR = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtprojSC = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.contprojName.setName("contprojName");
        this.contbillSate.setName("contbillSate");
        this.contAuditDate.setName("contAuditDate");
        this.contforiScCount.setName("contforiScCount");
        this.contalgScCount.setName("contalgScCount");
        this.contsecuCount.setName("contsecuCount");
        this.contforiScMoney.setName("contforiScMoney");
        this.contalgScMoney.setName("contalgScMoney");
        this.contforiVcMoney.setName("contforiVcMoney");
        this.contalgVcMoney.setName("contalgVcMoney");
        this.contscVcCount.setName("contscVcCount");
        this.contprojFR.setName("contprojFR");
        this.contprojSC.setName("contprojSC");
        this.contmonthYearr.setName("contmonthYearr");
        this.chkisOk.setName("chkisOk");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtprojName.setName("prmtprojName");
        this.billSate.setName("billSate");
        this.pkAuditDate.setName("pkAuditDate");
        this.txtforiScCount.setName("txtforiScCount");
        this.txtalgScCount.setName("txtalgScCount");
        this.txtsecuCount.setName("txtsecuCount");
        this.txtforiScMoney.setName("txtforiScMoney");
        this.txtalgScMoney.setName("txtalgScMoney");
        this.txtforiVcMoney.setName("txtforiVcMoney");
        this.txtalgVcMoney.setName("txtalgVcMoney");
        this.txtscVcCount.setName("txtscVcCount");
        this.txtprojFR.setName("txtprojFR");
        this.txtprojSC.setName("txtprojSC");
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
        this.contBizDate.setEnabled(false);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"cooperation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"workProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"coopCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"coopAlgSc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"coopAlgScM\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"coopAlgVcM\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"localIRGC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"coopForiSc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"coopForiScM\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"coopForiVcM\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"foriIRGC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"coopScPers\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"coopScMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"vcCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"IRGCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"coopAlgScNew\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"coopForiScNew\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"coopScPersNew\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{workProj}</t:Cell><t:Cell>$Resource{coopCode}</t:Cell><t:Cell>$Resource{coopAlgSc}</t:Cell><t:Cell>$Resource{coopAlgScM}</t:Cell><t:Cell>$Resource{coopAlgVcM}</t:Cell><t:Cell>$Resource{localIRGC}</t:Cell><t:Cell>$Resource{coopForiSc}</t:Cell><t:Cell>$Resource{coopForiScM}</t:Cell><t:Cell>$Resource{coopForiVcM}</t:Cell><t:Cell>$Resource{foriIRGC}</t:Cell><t:Cell>$Resource{coopScPers}</t:Cell><t:Cell>$Resource{coopScMoney}</t:Cell><t:Cell>$Resource{vcCount}</t:Cell><t:Cell>$Resource{IRGCount}</t:Cell><t:Cell>$Resource{coopAlgScNew}</t:Cell><t:Cell>$Resource{coopForiScNew}</t:Cell><t:Cell>$Resource{coopScPersNew}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","cooperation","workProj","coopCode","coopAlgSc","coopAlgScM","coopAlgVcM","localIRGC","coopForiSc","coopForiScM","coopForiVcM","foriIRGC","coopScPers","coopScMoney","vcCount","IRGCount","coopAlgScNew","coopForiScNew","coopScPersNew"});


        this.kdtEntrys.checkParsed();
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
        final KDBizPromptBox kdtEntrys_workProj_PromptBox = new KDBizPromptBox();
        kdtEntrys_workProj_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_workProj_PromptBox.setVisible(true);
        kdtEntrys_workProj_PromptBox.setEditable(true);
        kdtEntrys_workProj_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_workProj_PromptBox.setEditFormat("$number$");
        kdtEntrys_workProj_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_workProj_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workProj_PromptBox);
        this.kdtEntrys.getColumn("workProj").setEditor(kdtEntrys_workProj_CellEditor);
        ObjectValueRender kdtEntrys_workProj_OVR = new ObjectValueRender();
        kdtEntrys_workProj_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("workProj").setRenderer(kdtEntrys_workProj_OVR);
        KDTextField kdtEntrys_coopCode_TextField = new KDTextField();
        kdtEntrys_coopCode_TextField.setName("kdtEntrys_coopCode_TextField");
        kdtEntrys_coopCode_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coopCode_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopCode_TextField);
        this.kdtEntrys.getColumn("coopCode").setEditor(kdtEntrys_coopCode_CellEditor);
        KDFormattedTextField kdtEntrys_coopAlgSc_TextField = new KDFormattedTextField();
        kdtEntrys_coopAlgSc_TextField.setName("kdtEntrys_coopAlgSc_TextField");
        kdtEntrys_coopAlgSc_TextField.setVisible(true);
        kdtEntrys_coopAlgSc_TextField.setEditable(true);
        kdtEntrys_coopAlgSc_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopAlgSc_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_coopAlgSc_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopAlgSc_TextField);
        this.kdtEntrys.getColumn("coopAlgSc").setEditor(kdtEntrys_coopAlgSc_CellEditor);
        KDFormattedTextField kdtEntrys_coopAlgScM_TextField = new KDFormattedTextField();
        kdtEntrys_coopAlgScM_TextField.setName("kdtEntrys_coopAlgScM_TextField");
        kdtEntrys_coopAlgScM_TextField.setVisible(true);
        kdtEntrys_coopAlgScM_TextField.setEditable(true);
        kdtEntrys_coopAlgScM_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopAlgScM_TextField.setDataType(1);
        	kdtEntrys_coopAlgScM_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_coopAlgScM_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_coopAlgScM_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_coopAlgScM_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopAlgScM_TextField);
        this.kdtEntrys.getColumn("coopAlgScM").setEditor(kdtEntrys_coopAlgScM_CellEditor);
        KDFormattedTextField kdtEntrys_coopAlgVcM_TextField = new KDFormattedTextField();
        kdtEntrys_coopAlgVcM_TextField.setName("kdtEntrys_coopAlgVcM_TextField");
        kdtEntrys_coopAlgVcM_TextField.setVisible(true);
        kdtEntrys_coopAlgVcM_TextField.setEditable(true);
        kdtEntrys_coopAlgVcM_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopAlgVcM_TextField.setDataType(1);
        	kdtEntrys_coopAlgVcM_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_coopAlgVcM_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_coopAlgVcM_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_coopAlgVcM_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopAlgVcM_TextField);
        this.kdtEntrys.getColumn("coopAlgVcM").setEditor(kdtEntrys_coopAlgVcM_CellEditor);
        KDFormattedTextField kdtEntrys_localIRGC_TextField = new KDFormattedTextField();
        kdtEntrys_localIRGC_TextField.setName("kdtEntrys_localIRGC_TextField");
        kdtEntrys_localIRGC_TextField.setVisible(true);
        kdtEntrys_localIRGC_TextField.setEditable(true);
        kdtEntrys_localIRGC_TextField.setHorizontalAlignment(2);
        kdtEntrys_localIRGC_TextField.setDataType(1);
        	kdtEntrys_localIRGC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_localIRGC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_localIRGC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_localIRGC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_localIRGC_TextField);
        this.kdtEntrys.getColumn("localIRGC").setEditor(kdtEntrys_localIRGC_CellEditor);
        KDFormattedTextField kdtEntrys_coopForiSc_TextField = new KDFormattedTextField();
        kdtEntrys_coopForiSc_TextField.setName("kdtEntrys_coopForiSc_TextField");
        kdtEntrys_coopForiSc_TextField.setVisible(true);
        kdtEntrys_coopForiSc_TextField.setEditable(true);
        kdtEntrys_coopForiSc_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopForiSc_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_coopForiSc_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopForiSc_TextField);
        this.kdtEntrys.getColumn("coopForiSc").setEditor(kdtEntrys_coopForiSc_CellEditor);
        KDFormattedTextField kdtEntrys_coopForiScM_TextField = new KDFormattedTextField();
        kdtEntrys_coopForiScM_TextField.setName("kdtEntrys_coopForiScM_TextField");
        kdtEntrys_coopForiScM_TextField.setVisible(true);
        kdtEntrys_coopForiScM_TextField.setEditable(true);
        kdtEntrys_coopForiScM_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopForiScM_TextField.setDataType(1);
        	kdtEntrys_coopForiScM_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_coopForiScM_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_coopForiScM_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_coopForiScM_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopForiScM_TextField);
        this.kdtEntrys.getColumn("coopForiScM").setEditor(kdtEntrys_coopForiScM_CellEditor);
        KDFormattedTextField kdtEntrys_coopForiVcM_TextField = new KDFormattedTextField();
        kdtEntrys_coopForiVcM_TextField.setName("kdtEntrys_coopForiVcM_TextField");
        kdtEntrys_coopForiVcM_TextField.setVisible(true);
        kdtEntrys_coopForiVcM_TextField.setEditable(true);
        kdtEntrys_coopForiVcM_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopForiVcM_TextField.setDataType(1);
        	kdtEntrys_coopForiVcM_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_coopForiVcM_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_coopForiVcM_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_coopForiVcM_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopForiVcM_TextField);
        this.kdtEntrys.getColumn("coopForiVcM").setEditor(kdtEntrys_coopForiVcM_CellEditor);
        KDFormattedTextField kdtEntrys_foriIRGC_TextField = new KDFormattedTextField();
        kdtEntrys_foriIRGC_TextField.setName("kdtEntrys_foriIRGC_TextField");
        kdtEntrys_foriIRGC_TextField.setVisible(true);
        kdtEntrys_foriIRGC_TextField.setEditable(true);
        kdtEntrys_foriIRGC_TextField.setHorizontalAlignment(2);
        kdtEntrys_foriIRGC_TextField.setDataType(1);
        	kdtEntrys_foriIRGC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_foriIRGC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_foriIRGC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_foriIRGC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_foriIRGC_TextField);
        this.kdtEntrys.getColumn("foriIRGC").setEditor(kdtEntrys_foriIRGC_CellEditor);
        KDFormattedTextField kdtEntrys_coopScPers_TextField = new KDFormattedTextField();
        kdtEntrys_coopScPers_TextField.setName("kdtEntrys_coopScPers_TextField");
        kdtEntrys_coopScPers_TextField.setVisible(true);
        kdtEntrys_coopScPers_TextField.setEditable(true);
        kdtEntrys_coopScPers_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopScPers_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_coopScPers_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopScPers_TextField);
        this.kdtEntrys.getColumn("coopScPers").setEditor(kdtEntrys_coopScPers_CellEditor);
        KDFormattedTextField kdtEntrys_coopScMoney_TextField = new KDFormattedTextField();
        kdtEntrys_coopScMoney_TextField.setName("kdtEntrys_coopScMoney_TextField");
        kdtEntrys_coopScMoney_TextField.setVisible(true);
        kdtEntrys_coopScMoney_TextField.setEditable(true);
        kdtEntrys_coopScMoney_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopScMoney_TextField.setDataType(1);
        	kdtEntrys_coopScMoney_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_coopScMoney_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_coopScMoney_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_coopScMoney_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopScMoney_TextField);
        this.kdtEntrys.getColumn("coopScMoney").setEditor(kdtEntrys_coopScMoney_CellEditor);
        KDFormattedTextField kdtEntrys_vcCount_TextField = new KDFormattedTextField();
        kdtEntrys_vcCount_TextField.setName("kdtEntrys_vcCount_TextField");
        kdtEntrys_vcCount_TextField.setVisible(true);
        kdtEntrys_vcCount_TextField.setEditable(true);
        kdtEntrys_vcCount_TextField.setHorizontalAlignment(2);
        kdtEntrys_vcCount_TextField.setDataType(1);
        	kdtEntrys_vcCount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_vcCount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_vcCount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_vcCount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vcCount_TextField);
        this.kdtEntrys.getColumn("vcCount").setEditor(kdtEntrys_vcCount_CellEditor);
        KDFormattedTextField kdtEntrys_IRGCount_TextField = new KDFormattedTextField();
        kdtEntrys_IRGCount_TextField.setName("kdtEntrys_IRGCount_TextField");
        kdtEntrys_IRGCount_TextField.setVisible(true);
        kdtEntrys_IRGCount_TextField.setEditable(true);
        kdtEntrys_IRGCount_TextField.setHorizontalAlignment(2);
        kdtEntrys_IRGCount_TextField.setDataType(1);
        	kdtEntrys_IRGCount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_IRGCount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_IRGCount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_IRGCount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IRGCount_TextField);
        this.kdtEntrys.getColumn("IRGCount").setEditor(kdtEntrys_IRGCount_CellEditor);
        KDFormattedTextField kdtEntrys_coopAlgScNew_TextField = new KDFormattedTextField();
        kdtEntrys_coopAlgScNew_TextField.setName("kdtEntrys_coopAlgScNew_TextField");
        kdtEntrys_coopAlgScNew_TextField.setVisible(true);
        kdtEntrys_coopAlgScNew_TextField.setEditable(true);
        kdtEntrys_coopAlgScNew_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopAlgScNew_TextField.setDataType(1);
        	kdtEntrys_coopAlgScNew_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_coopAlgScNew_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_coopAlgScNew_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_coopAlgScNew_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopAlgScNew_TextField);
        this.kdtEntrys.getColumn("coopAlgScNew").setEditor(kdtEntrys_coopAlgScNew_CellEditor);
        KDFormattedTextField kdtEntrys_coopForiScNew_TextField = new KDFormattedTextField();
        kdtEntrys_coopForiScNew_TextField.setName("kdtEntrys_coopForiScNew_TextField");
        kdtEntrys_coopForiScNew_TextField.setVisible(true);
        kdtEntrys_coopForiScNew_TextField.setEditable(true);
        kdtEntrys_coopForiScNew_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopForiScNew_TextField.setDataType(1);
        	kdtEntrys_coopForiScNew_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_coopForiScNew_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_coopForiScNew_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_coopForiScNew_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopForiScNew_TextField);
        this.kdtEntrys.getColumn("coopForiScNew").setEditor(kdtEntrys_coopForiScNew_CellEditor);
        KDFormattedTextField kdtEntrys_coopScPersNew_TextField = new KDFormattedTextField();
        kdtEntrys_coopScPersNew_TextField.setName("kdtEntrys_coopScPersNew_TextField");
        kdtEntrys_coopScPersNew_TextField.setVisible(true);
        kdtEntrys_coopScPersNew_TextField.setEditable(true);
        kdtEntrys_coopScPersNew_TextField.setHorizontalAlignment(2);
        kdtEntrys_coopScPersNew_TextField.setDataType(1);
        	kdtEntrys_coopScPersNew_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_coopScPersNew_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_coopScPersNew_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_coopScPersNew_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopScPersNew_TextField);
        this.kdtEntrys.getColumn("coopScPersNew").setEditor(kdtEntrys_coopScPersNew_CellEditor);
        // contprojName		
        this.contprojName.setBoundLabelText(resHelper.getString("contprojName.boundLabelText"));		
        this.contprojName.setBoundLabelLength(100);		
        this.contprojName.setBoundLabelUnderline(true);		
        this.contprojName.setEnabled(false);
        // contbillSate		
        this.contbillSate.setBoundLabelText(resHelper.getString("contbillSate.boundLabelText"));		
        this.contbillSate.setBoundLabelLength(100);		
        this.contbillSate.setBoundLabelUnderline(true);		
        this.contbillSate.setEnabled(false);
        // contAuditDate		
        this.contAuditDate.setBoundLabelText(resHelper.getString("contAuditDate.boundLabelText"));		
        this.contAuditDate.setBoundLabelLength(100);		
        this.contAuditDate.setBoundLabelUnderline(true);		
        this.contAuditDate.setVisible(true);
        // contforiScCount		
        this.contforiScCount.setBoundLabelText(resHelper.getString("contforiScCount.boundLabelText"));		
        this.contforiScCount.setBoundLabelLength(100);		
        this.contforiScCount.setBoundLabelUnderline(true);		
        this.contforiScCount.setVisible(false);
        // contalgScCount		
        this.contalgScCount.setBoundLabelText(resHelper.getString("contalgScCount.boundLabelText"));		
        this.contalgScCount.setBoundLabelLength(110);		
        this.contalgScCount.setBoundLabelUnderline(true);		
        this.contalgScCount.setVisible(false);
        // contsecuCount		
        this.contsecuCount.setBoundLabelText(resHelper.getString("contsecuCount.boundLabelText"));		
        this.contsecuCount.setBoundLabelLength(100);		
        this.contsecuCount.setBoundLabelUnderline(true);		
        this.contsecuCount.setVisible(false);
        // contforiScMoney		
        this.contforiScMoney.setBoundLabelText(resHelper.getString("contforiScMoney.boundLabelText"));		
        this.contforiScMoney.setBoundLabelLength(100);		
        this.contforiScMoney.setBoundLabelUnderline(true);		
        this.contforiScMoney.setVisible(false);
        // contalgScMoney		
        this.contalgScMoney.setBoundLabelText(resHelper.getString("contalgScMoney.boundLabelText"));		
        this.contalgScMoney.setBoundLabelLength(110);		
        this.contalgScMoney.setBoundLabelUnderline(true);		
        this.contalgScMoney.setVisible(false);
        // contforiVcMoney		
        this.contforiVcMoney.setBoundLabelText(resHelper.getString("contforiVcMoney.boundLabelText"));		
        this.contforiVcMoney.setBoundLabelLength(120);		
        this.contforiVcMoney.setBoundLabelUnderline(true);		
        this.contforiVcMoney.setVisible(false);
        // contalgVcMoney		
        this.contalgVcMoney.setBoundLabelText(resHelper.getString("contalgVcMoney.boundLabelText"));		
        this.contalgVcMoney.setBoundLabelLength(140);		
        this.contalgVcMoney.setBoundLabelUnderline(true);		
        this.contalgVcMoney.setVisible(false);
        // contscVcCount		
        this.contscVcCount.setBoundLabelText(resHelper.getString("contscVcCount.boundLabelText"));		
        this.contscVcCount.setBoundLabelLength(110);		
        this.contscVcCount.setBoundLabelUnderline(true);		
        this.contscVcCount.setVisible(false);
        // contprojFR		
        this.contprojFR.setBoundLabelText(resHelper.getString("contprojFR.boundLabelText"));		
        this.contprojFR.setBoundLabelLength(100);		
        this.contprojFR.setBoundLabelUnderline(true);		
        this.contprojFR.setVisible(true);		
        this.contprojFR.setEnabled(false);
        // contprojSC		
        this.contprojSC.setBoundLabelText(resHelper.getString("contprojSC.boundLabelText"));		
        this.contprojSC.setBoundLabelLength(100);		
        this.contprojSC.setBoundLabelUnderline(true);		
        this.contprojSC.setEnabled(false);
        // contmonthYearr		
        this.contmonthYearr.setBoundLabelText(resHelper.getString("contmonthYearr.boundLabelText"));		
        this.contmonthYearr.setBoundLabelLength(100);		
        this.contmonthYearr.setBoundLabelUnderline(true);		
        this.contmonthYearr.setEnabled(false);
        // chkisOk		
        this.chkisOk.setText(resHelper.getString("chkisOk.text"));		
        this.chkisOk.setHorizontalAlignment(2);
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
        this.pkBizDate.setEnabled(false);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtprojName		
        this.prmtprojName.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtprojName.setEditable(true);		
        this.prmtprojName.setDisplayFormat("$name$");		
        this.prmtprojName.setEditFormat("$number$");		
        this.prmtprojName.setCommitFormat("$number$");		
        this.prmtprojName.setRequired(false);		
        this.prmtprojName.setEnabled(false);
        this.prmtprojName.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtprojName_dataChanged(e);
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
        // txtforiScCount		
        this.txtforiScCount.setHorizontalAlignment(2);		
        this.txtforiScCount.setDataType(0);		
        this.txtforiScCount.setSupportedEmpty(true);		
        this.txtforiScCount.setRequired(false);		
        this.txtforiScCount.setVisible(false);
        // txtalgScCount		
        this.txtalgScCount.setHorizontalAlignment(2);		
        this.txtalgScCount.setDataType(0);		
        this.txtalgScCount.setSupportedEmpty(true);		
        this.txtalgScCount.setRequired(false);		
        this.txtalgScCount.setVisible(false);
        // txtsecuCount		
        this.txtsecuCount.setHorizontalAlignment(2);		
        this.txtsecuCount.setDataType(0);		
        this.txtsecuCount.setSupportedEmpty(true);		
        this.txtsecuCount.setRequired(false);		
        this.txtsecuCount.setVisible(false);
        // txtforiScMoney		
        this.txtforiScMoney.setHorizontalAlignment(2);		
        this.txtforiScMoney.setDataType(1);		
        this.txtforiScMoney.setSupportedEmpty(true);		
        this.txtforiScMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtforiScMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtforiScMoney.setPrecision(2);		
        this.txtforiScMoney.setRequired(false);		
        this.txtforiScMoney.setVisible(false);
        // txtalgScMoney		
        this.txtalgScMoney.setHorizontalAlignment(2);		
        this.txtalgScMoney.setDataType(1);		
        this.txtalgScMoney.setSupportedEmpty(true);		
        this.txtalgScMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalgScMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalgScMoney.setPrecision(2);		
        this.txtalgScMoney.setRequired(false);		
        this.txtalgScMoney.setVisible(false);
        // txtforiVcMoney		
        this.txtforiVcMoney.setHorizontalAlignment(2);		
        this.txtforiVcMoney.setDataType(1);		
        this.txtforiVcMoney.setSupportedEmpty(true);		
        this.txtforiVcMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtforiVcMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtforiVcMoney.setPrecision(2);		
        this.txtforiVcMoney.setRequired(false);		
        this.txtforiVcMoney.setVisible(false);
        // txtalgVcMoney		
        this.txtalgVcMoney.setHorizontalAlignment(2);		
        this.txtalgVcMoney.setDataType(1);		
        this.txtalgVcMoney.setSupportedEmpty(true);		
        this.txtalgVcMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalgVcMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalgVcMoney.setPrecision(2);		
        this.txtalgVcMoney.setRequired(false);		
        this.txtalgVcMoney.setVisible(false);
        // txtscVcCount		
        this.txtscVcCount.setHorizontalAlignment(2);		
        this.txtscVcCount.setDataType(1);		
        this.txtscVcCount.setSupportedEmpty(true);		
        this.txtscVcCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtscVcCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtscVcCount.setPrecision(2);		
        this.txtscVcCount.setRequired(false);		
        this.txtscVcCount.setVisible(false);
        // txtprojFR		
        this.txtprojFR.setHorizontalAlignment(2);		
        this.txtprojFR.setMaxLength(100);		
        this.txtprojFR.setRequired(false);		
        this.txtprojFR.setEnabled(false);
        // txtprojSC		
        this.txtprojSC.setHorizontalAlignment(2);		
        this.txtprojSC.setMaxLength(100);		
        this.txtprojSC.setRequired(false);		
        this.txtprojSC.setEnabled(false);
        // prmtmonthYearr		
        this.prmtmonthYearr.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtmonthYearr.setEditable(true);		
        this.prmtmonthYearr.setDisplayFormat("$number$");		
        this.prmtmonthYearr.setEditFormat("$number$");		
        this.prmtmonthYearr.setCommitFormat("$number$");		
        this.prmtmonthYearr.setRequired(false);		
        this.prmtmonthYearr.setEnabled(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtprojName,billSate,pkAuditDate,txtforiScCount,txtalgScCount,txtsecuCount,txtforiScMoney,txtalgScMoney,txtforiVcMoney,txtalgVcMoney,txtscVcCount,txtprojFR,txtprojSC,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,prmtmonthYearr,chkisOk,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, -36, 1013, 563));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, -36, 1013, 563));
        contCreator.setBounds(new Rectangle(4, 532, 226, 19));
        this.add(contCreator, new KDLayout.Constraints(4, 532, 226, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(259, 532, 226, 19));
        this.add(contCreateTime, new KDLayout.Constraints(259, 532, 226, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(439, 609, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(439, 609, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(729, 609, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(729, 609, 270, 19, 0));
        contNumber.setBounds(new Rectangle(12, 11, 239, 19));
        this.add(contNumber, new KDLayout.Constraints(12, 11, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(263, 11, 239, 19));
        this.add(contBizDate, new KDLayout.Constraints(263, 11, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(513, 37, 239, 19));
        this.add(contDescription, new KDLayout.Constraints(513, 37, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(514, 532, 226, 19));
        this.add(contAuditor, new KDLayout.Constraints(514, 532, 226, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(6, 112, 991, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.social.SecuSplitEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(6, 112, 991, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contprojName.setBounds(new Rectangle(514, 11, 239, 19));
        this.add(contprojName, new KDLayout.Constraints(514, 11, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillSate.setBounds(new Rectangle(764, 37, 239, 19));
        this.add(contbillSate, new KDLayout.Constraints(764, 37, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditDate.setBounds(new Rectangle(769, 532, 226, 19));
        this.add(contAuditDate, new KDLayout.Constraints(769, 532, 226, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contforiScCount.setBounds(new Rectangle(254, 115, 239, 19));
        this.add(contforiScCount, new KDLayout.Constraints(254, 115, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contalgScCount.setBounds(new Rectangle(3, 115, 239, 19));
        this.add(contalgScCount, new KDLayout.Constraints(3, 115, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsecuCount.setBounds(new Rectangle(9, 133, 239, 19));
        this.add(contsecuCount, new KDLayout.Constraints(9, 133, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contforiScMoney.setBounds(new Rectangle(756, 115, 239, 19));
        this.add(contforiScMoney, new KDLayout.Constraints(756, 115, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contalgScMoney.setBounds(new Rectangle(505, 115, 239, 19));
        this.add(contalgScMoney, new KDLayout.Constraints(505, 115, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contforiVcMoney.setBounds(new Rectangle(260, 133, 239, 19));
        this.add(contforiVcMoney, new KDLayout.Constraints(260, 133, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contalgVcMoney.setBounds(new Rectangle(511, 133, 239, 19));
        this.add(contalgVcMoney, new KDLayout.Constraints(511, 133, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contscVcCount.setBounds(new Rectangle(762, 133, 239, 19));
        this.add(contscVcCount, new KDLayout.Constraints(762, 133, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contprojFR.setBounds(new Rectangle(765, 11, 239, 19));
        this.add(contprojFR, new KDLayout.Constraints(765, 11, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contprojSC.setBounds(new Rectangle(11, 37, 239, 19));
        this.add(contprojSC, new KDLayout.Constraints(11, 37, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmonthYearr.setBounds(new Rectangle(262, 37, 239, 19));
        this.add(contmonthYearr, new KDLayout.Constraints(262, 37, 239, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisOk.setBounds(new Rectangle(12, 63, 561, 19));
        this.add(chkisOk, new KDLayout.Constraints(12, 63, 561, 19, 0));
        kDLabelContainer1.setBounds(new Rectangle(12, 86, 991, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(12, 86, 991, 19, 0));
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
        //contprojName
        contprojName.setBoundEditor(prmtprojName);
        //contbillSate
        contbillSate.setBoundEditor(billSate);
        //contAuditDate
        contAuditDate.setBoundEditor(pkAuditDate);
        //contforiScCount
        contforiScCount.setBoundEditor(txtforiScCount);
        //contalgScCount
        contalgScCount.setBoundEditor(txtalgScCount);
        //contsecuCount
        contsecuCount.setBoundEditor(txtsecuCount);
        //contforiScMoney
        contforiScMoney.setBoundEditor(txtforiScMoney);
        //contalgScMoney
        contalgScMoney.setBoundEditor(txtalgScMoney);
        //contforiVcMoney
        contforiVcMoney.setBoundEditor(txtforiVcMoney);
        //contalgVcMoney
        contalgVcMoney.setBoundEditor(txtalgVcMoney);
        //contscVcCount
        contscVcCount.setBoundEditor(txtscVcCount);
        //contprojFR
        contprojFR.setBoundEditor(txtprojFR);
        //contprojSC
        contprojSC.setBoundEditor(txtprojSC);
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.social.SecuSplitEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.cooperation", java.lang.Object.class, this.kdtEntrys, "cooperation.text");
		dataBinder.registerBinding("entrys.coopCode", String.class, this.kdtEntrys, "coopCode.text");
		dataBinder.registerBinding("entrys.coopAlgSc", int.class, this.kdtEntrys, "coopAlgSc.text");
		dataBinder.registerBinding("entrys.coopForiSc", int.class, this.kdtEntrys, "coopForiSc.text");
		dataBinder.registerBinding("entrys.coopScPers", int.class, this.kdtEntrys, "coopScPers.text");
		dataBinder.registerBinding("entrys.coopScMoney", java.math.BigDecimal.class, this.kdtEntrys, "coopScMoney.text");
		dataBinder.registerBinding("entrys.coopForiVcM", java.math.BigDecimal.class, this.kdtEntrys, "coopForiVcM.text");
		dataBinder.registerBinding("entrys.coopAlgVcM", java.math.BigDecimal.class, this.kdtEntrys, "coopAlgVcM.text");
		dataBinder.registerBinding("entrys.coopAlgScM", java.math.BigDecimal.class, this.kdtEntrys, "coopAlgScM.text");
		dataBinder.registerBinding("entrys.coopForiScM", java.math.BigDecimal.class, this.kdtEntrys, "coopForiScM.text");
		dataBinder.registerBinding("entrys.localIRGC", java.math.BigDecimal.class, this.kdtEntrys, "localIRGC.text");
		dataBinder.registerBinding("entrys.foriIRGC", java.math.BigDecimal.class, this.kdtEntrys, "foriIRGC.text");
		dataBinder.registerBinding("entrys.vcCount", java.math.BigDecimal.class, this.kdtEntrys, "vcCount.text");
		dataBinder.registerBinding("entrys.IRGCount", java.math.BigDecimal.class, this.kdtEntrys, "IRGCount.text");
		dataBinder.registerBinding("entrys.workProj", java.lang.Object.class, this.kdtEntrys, "workProj.text");
		dataBinder.registerBinding("entrys.coopAlgScNew", java.math.BigDecimal.class, this.kdtEntrys, "coopAlgScNew.text");
		dataBinder.registerBinding("entrys.coopForiScNew", java.math.BigDecimal.class, this.kdtEntrys, "coopForiScNew.text");
		dataBinder.registerBinding("entrys.coopScPersNew", java.math.BigDecimal.class, this.kdtEntrys, "coopScPersNew.text");
		dataBinder.registerBinding("isOk", boolean.class, this.chkisOk, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("projName", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtprojName, "data");
		dataBinder.registerBinding("billSate", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSate, "selectedItem");
		dataBinder.registerBinding("AuditDate", java.util.Date.class, this.pkAuditDate, "value");
		dataBinder.registerBinding("foriScCount", int.class, this.txtforiScCount, "value");
		dataBinder.registerBinding("algScCount", int.class, this.txtalgScCount, "value");
		dataBinder.registerBinding("secuCount", int.class, this.txtsecuCount, "value");
		dataBinder.registerBinding("foriScMoney", java.math.BigDecimal.class, this.txtforiScMoney, "value");
		dataBinder.registerBinding("algScMoney", java.math.BigDecimal.class, this.txtalgScMoney, "value");
		dataBinder.registerBinding("foriVcMoney", java.math.BigDecimal.class, this.txtforiVcMoney, "value");
		dataBinder.registerBinding("algVcMoney", java.math.BigDecimal.class, this.txtalgVcMoney, "value");
		dataBinder.registerBinding("scVcCount", java.math.BigDecimal.class, this.txtscVcCount, "value");
		dataBinder.registerBinding("projFR", String.class, this.txtprojFR, "text");
		dataBinder.registerBinding("projSC", String.class, this.txtprojSC, "text");
		dataBinder.registerBinding("monthYearr", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtmonthYearr, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.social.app.SecuSplitEditUIHandler";
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
        this.prmtprojName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.social.SecuSplitInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopAlgSc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopForiSc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopScPers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopScMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopForiVcM", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopAlgVcM", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopAlgScM", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopForiScM", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.localIRGC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.foriIRGC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vcCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IRGCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopAlgScNew", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopForiScNew", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopScPersNew", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isOk", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("foriScCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("algScCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("secuCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("foriScMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("algScMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("foriVcMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("algVcMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("scVcCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projFR", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projSC", ValidateHelper.ON_SAVE);    
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
     * output prmtprojName_dataChanged method
     */
    protected void prmtprojName_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
    	sic.add(new SelectorItemInfo("entrys.coopAlgSc"));
    	sic.add(new SelectorItemInfo("entrys.coopForiSc"));
    	sic.add(new SelectorItemInfo("entrys.coopScPers"));
    	sic.add(new SelectorItemInfo("entrys.coopScMoney"));
    	sic.add(new SelectorItemInfo("entrys.coopForiVcM"));
    	sic.add(new SelectorItemInfo("entrys.coopAlgVcM"));
    	sic.add(new SelectorItemInfo("entrys.coopAlgScM"));
    	sic.add(new SelectorItemInfo("entrys.coopForiScM"));
    	sic.add(new SelectorItemInfo("entrys.localIRGC"));
    	sic.add(new SelectorItemInfo("entrys.foriIRGC"));
    	sic.add(new SelectorItemInfo("entrys.vcCount"));
    	sic.add(new SelectorItemInfo("entrys.IRGCount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.workProj.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.workProj.id"));
			sic.add(new SelectorItemInfo("entrys.workProj.name"));
        	sic.add(new SelectorItemInfo("entrys.workProj.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.coopAlgScNew"));
    	sic.add(new SelectorItemInfo("entrys.coopForiScNew"));
    	sic.add(new SelectorItemInfo("entrys.coopScPersNew"));
        sic.add(new SelectorItemInfo("isOk"));
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
			sic.add(new SelectorItemInfo("projName.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("projName.id"));
        	sic.add(new SelectorItemInfo("projName.number"));
        	sic.add(new SelectorItemInfo("projName.name"));
		}
        sic.add(new SelectorItemInfo("billSate"));
        sic.add(new SelectorItemInfo("AuditDate"));
        sic.add(new SelectorItemInfo("foriScCount"));
        sic.add(new SelectorItemInfo("algScCount"));
        sic.add(new SelectorItemInfo("secuCount"));
        sic.add(new SelectorItemInfo("foriScMoney"));
        sic.add(new SelectorItemInfo("algScMoney"));
        sic.add(new SelectorItemInfo("foriVcMoney"));
        sic.add(new SelectorItemInfo("algVcMoney"));
        sic.add(new SelectorItemInfo("scVcCount"));
        sic.add(new SelectorItemInfo("projFR"));
        sic.add(new SelectorItemInfo("projSC"));
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
    	

    /**
     * output actionUpdateData_actionPerformed method
     */
    public void actionUpdateData_actionPerformed(ActionEvent e) throws Exception
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
	public RequestContext prepareActionUpdateData(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUpdateData() {
    	return false;
    }

    /**
     * output ActionUpdateData class
     */     
    protected class ActionUpdateData extends ItemAction {     
    
        public ActionUpdateData()
        {
            this(null);
        }

        public ActionUpdateData(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionUpdateData.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateData.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateData.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSecuSplitEditUI.this, "ActionUpdateData", "actionUpdateData_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.social.client", "SecuSplitEditUI");
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
        return com.kingdee.eas.zjlw.social.client.SecuSplitEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.social.SecuSplitFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.social.SecuSplitInfo objectValue = new com.kingdee.eas.zjlw.social.SecuSplitInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/social/SecuSplit";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.social.app.SecuSplitQuery");
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