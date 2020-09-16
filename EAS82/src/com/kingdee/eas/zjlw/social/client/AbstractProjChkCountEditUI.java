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
public abstract class AbstractProjChkCountEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractProjChkCountEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.eas.zjlw.social.ProjChkCountInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractProjChkCountEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractProjChkCountEditUI.class.getName());
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
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billSate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
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
        this.contauditDate.setName("contauditDate");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billSate.setName("billSate");
        this.pkauditDate.setName("pkauditDate");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"projName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"province\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"checkdepat\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"checkDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"reason\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"books\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"payDetail\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"persMove\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"algPersM\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"taxBooks\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"taxRepoBok\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"compRule\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"busiNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"gManaNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"chkEDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"chkResult\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fFillPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"fPenalty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"fFine\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"notiDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"locaComm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"natiComm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"judicial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"fillPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"Penalty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"fine\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"endTolFine\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"endDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header2\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{projName}</t:Cell><t:Cell>$Resource{province}</t:Cell><t:Cell>$Resource{checkdepat}</t:Cell><t:Cell>$Resource{checkDate}</t:Cell><t:Cell>$Resource{reason}</t:Cell><t:Cell>$Resource{books}</t:Cell><t:Cell>$Resource{payDetail}</t:Cell><t:Cell>$Resource{persMove}</t:Cell><t:Cell>$Resource{algPersM}</t:Cell><t:Cell>$Resource{taxBooks}</t:Cell><t:Cell>$Resource{taxRepoBok}</t:Cell><t:Cell>$Resource{compRule}</t:Cell><t:Cell>$Resource{busiNum}</t:Cell><t:Cell>$Resource{gManaNum}</t:Cell><t:Cell>$Resource{chkEDate}</t:Cell><t:Cell>$Resource{chkResult}</t:Cell><t:Cell>$Resource{fFillPay}</t:Cell><t:Cell>$Resource{fPenalty}</t:Cell><t:Cell>$Resource{fFine}</t:Cell><t:Cell>$Resource{notiDate}</t:Cell><t:Cell>$Resource{locaComm}</t:Cell><t:Cell>$Resource{natiComm}</t:Cell><t:Cell>$Resource{judicial}</t:Cell><t:Cell>$Resource{fillPay}</t:Cell><t:Cell>$Resource{Penalty}</t:Cell><t:Cell>$Resource{fine}</t:Cell><t:Cell>$Resource{endTolFine}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row><t:Row t:name=\"header3\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id_Row2}</t:Cell><t:Cell>$Resource{projName_Row2}</t:Cell><t:Cell>$Resource{province_Row2}</t:Cell><t:Cell>$Resource{checkdepat_Row2}</t:Cell><t:Cell>$Resource{checkDate_Row2}</t:Cell><t:Cell>$Resource{reason_Row2}</t:Cell><t:Cell>$Resource{books_Row2}</t:Cell><t:Cell>$Resource{payDetail_Row2}</t:Cell><t:Cell>$Resource{persMove_Row2}</t:Cell><t:Cell>$Resource{algPersM_Row2}</t:Cell><t:Cell>$Resource{taxBooks_Row2}</t:Cell><t:Cell>$Resource{taxRepoBok_Row2}</t:Cell><t:Cell>$Resource{compRule_Row2}</t:Cell><t:Cell>$Resource{busiNum_Row2}</t:Cell><t:Cell>$Resource{gManaNum_Row2}</t:Cell><t:Cell>$Resource{chkEDate_Row2}</t:Cell><t:Cell>$Resource{chkResult_Row2}</t:Cell><t:Cell>$Resource{fFillPay_Row2}</t:Cell><t:Cell>$Resource{fPenalty_Row2}</t:Cell><t:Cell>$Resource{fFine_Row2}</t:Cell><t:Cell>$Resource{notiDate_Row2}</t:Cell><t:Cell>$Resource{locaComm_Row2}</t:Cell><t:Cell>$Resource{natiComm_Row2}</t:Cell><t:Cell>$Resource{judicial_Row2}</t:Cell><t:Cell>$Resource{fillPay_Row2}</t:Cell><t:Cell>$Resource{Penalty_Row2}</t:Cell><t:Cell>$Resource{fine_Row2}</t:Cell><t:Cell>$Resource{endTolFine_Row2}</t:Cell><t:Cell>$Resource{endDate_Row2}</t:Cell><t:Cell>$Resource{remark_Row2}</t:Cell></t:Row><t:Row t:name=\"header4\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id_Row3}</t:Cell><t:Cell>$Resource{projName_Row3}</t:Cell><t:Cell>$Resource{province_Row3}</t:Cell><t:Cell>$Resource{checkdepat_Row3}</t:Cell><t:Cell>$Resource{checkDate_Row3}</t:Cell><t:Cell>$Resource{reason_Row3}</t:Cell><t:Cell>$Resource{books_Row3}</t:Cell><t:Cell>$Resource{payDetail_Row3}</t:Cell><t:Cell>$Resource{persMove_Row3}</t:Cell><t:Cell>$Resource{algPersM_Row3}</t:Cell><t:Cell>$Resource{taxBooks_Row3}</t:Cell><t:Cell>$Resource{taxRepoBok_Row3}</t:Cell><t:Cell>$Resource{compRule_Row3}</t:Cell><t:Cell>$Resource{busiNum_Row3}</t:Cell><t:Cell>$Resource{gManaNum_Row3}</t:Cell><t:Cell>$Resource{chkEDate_Row3}</t:Cell><t:Cell>$Resource{chkResult_Row3}</t:Cell><t:Cell>$Resource{fFillPay_Row3}</t:Cell><t:Cell>$Resource{fPenalty_Row3}</t:Cell><t:Cell>$Resource{fFine_Row3}</t:Cell><t:Cell>$Resource{notiDate_Row3}</t:Cell><t:Cell>$Resource{locaComm_Row3}</t:Cell><t:Cell>$Resource{natiComm_Row3}</t:Cell><t:Cell>$Resource{judicial_Row3}</t:Cell><t:Cell>$Resource{fillPay_Row3}</t:Cell><t:Cell>$Resource{Penalty_Row3}</t:Cell><t:Cell>$Resource{fine_Row3}</t:Cell><t:Cell>$Resource{endTolFine_Row3}</t:Cell><t:Cell>$Resource{endDate_Row3}</t:Cell><t:Cell>$Resource{remark_Row3}</t:Cell></t:Row><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id_Row4}</t:Cell><t:Cell>$Resource{projName_Row4}</t:Cell><t:Cell>$Resource{province_Row4}</t:Cell><t:Cell>$Resource{checkdepat_Row4}</t:Cell><t:Cell>$Resource{checkDate_Row4}</t:Cell><t:Cell>$Resource{reason_Row4}</t:Cell><t:Cell>$Resource{books_Row4}</t:Cell><t:Cell>$Resource{payDetail_Row4}</t:Cell><t:Cell>$Resource{persMove_Row4}</t:Cell><t:Cell>$Resource{algPersM_Row4}</t:Cell><t:Cell>$Resource{taxBooks_Row4}</t:Cell><t:Cell>$Resource{taxRepoBok_Row4}</t:Cell><t:Cell>$Resource{compRule_Row4}</t:Cell><t:Cell>$Resource{busiNum_Row4}</t:Cell><t:Cell>$Resource{gManaNum_Row4}</t:Cell><t:Cell>$Resource{chkEDate_Row4}</t:Cell><t:Cell>$Resource{chkResult_Row4}</t:Cell><t:Cell>$Resource{fFillPay_Row4}</t:Cell><t:Cell>$Resource{fPenalty_Row4}</t:Cell><t:Cell>$Resource{fFine_Row4}</t:Cell><t:Cell>$Resource{notiDate_Row4}</t:Cell><t:Cell>$Resource{locaComm_Row4}</t:Cell><t:Cell>$Resource{natiComm_Row4}</t:Cell><t:Cell>$Resource{judicial_Row4}</t:Cell><t:Cell>$Resource{fillPay_Row4}</t:Cell><t:Cell>$Resource{Penalty_Row4}</t:Cell><t:Cell>$Resource{fine_Row4}</t:Cell><t:Cell>$Resource{endTolFine_Row4}</t:Cell><t:Cell>$Resource{endDate_Row4}</t:Cell><t:Cell>$Resource{remark_Row4}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head><t:Block t:top=\"0\" t:left=\"0\" t:bottom=\"3\" t:right=\"0\" /><t:Block t:top=\"1\" t:left=\"1\" t:bottom=\"3\" t:right=\"1\" /><t:Block t:top=\"1\" t:left=\"2\" t:bottom=\"3\" t:right=\"2\" /><t:Block t:top=\"1\" t:left=\"3\" t:bottom=\"3\" t:right=\"3\" /><t:Block t:top=\"1\" t:left=\"4\" t:bottom=\"3\" t:right=\"4\" /><t:Block t:top=\"1\" t:left=\"5\" t:bottom=\"3\" t:right=\"5\" /><t:Block t:top=\"0\" t:left=\"1\" t:bottom=\"0\" t:right=\"16\" /><t:Block t:top=\"1\" t:left=\"6\" t:bottom=\"1\" t:right=\"14\" /><t:Block t:top=\"2\" t:left=\"6\" t:bottom=\"2\" t:right=\"7\" /><t:Block t:top=\"2\" t:left=\"8\" t:bottom=\"2\" t:right=\"9\" /><t:Block t:top=\"2\" t:left=\"10\" t:bottom=\"2\" t:right=\"11\" /><t:Block t:top=\"2\" t:left=\"12\" t:bottom=\"2\" t:right=\"14\" /><t:Block t:top=\"1\" t:left=\"15\" t:bottom=\"3\" t:right=\"15\" /><t:Block t:top=\"1\" t:left=\"16\" t:bottom=\"3\" t:right=\"16\" /><t:Block t:top=\"0\" t:left=\"17\" t:bottom=\"2\" t:right=\"19\" /><t:Block t:top=\"0\" t:left=\"20\" t:bottom=\"3\" t:right=\"20\" /><t:Block t:top=\"0\" t:left=\"21\" t:bottom=\"2\" t:right=\"23\" /><t:Block t:top=\"0\" t:left=\"24\" t:bottom=\"2\" t:right=\"26\" /><t:Block t:top=\"0\" t:left=\"27\" t:bottom=\"3\" t:right=\"27\" /><t:Block t:top=\"0\" t:left=\"28\" t:bottom=\"3\" t:right=\"28\" /><t:Block t:top=\"0\" t:left=\"29\" t:bottom=\"3\" t:right=\"29\" /></t:Head></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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

                this.kdtEntrys.putBindContents("editData",new String[] {"id","projName","province","checkdepat","checkDate","reason","books","payDetail","persMove","algPersM","taxBooks","taxRepoBok","compRule","busiNum","gManaNum","chkEDate","chkResult","fFillPay","fPenalty","fFine","notiDate","locaComm","natiComm","judicial","fillPay","Penalty","fine","endTolFine","endDate","remark"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_projName_PromptBox = new KDBizPromptBox();
        kdtEntrys_projName_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_projName_PromptBox.setVisible(true);
        kdtEntrys_projName_PromptBox.setEditable(true);
        kdtEntrys_projName_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_projName_PromptBox.setEditFormat("$number$");
        kdtEntrys_projName_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_projName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_projName_PromptBox);
        this.kdtEntrys.getColumn("projName").setEditor(kdtEntrys_projName_CellEditor);
        ObjectValueRender kdtEntrys_projName_OVR = new ObjectValueRender();
        kdtEntrys_projName_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("projName").setRenderer(kdtEntrys_projName_OVR);
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
        KDComboBox kdtEntrys_checkdepat_ComboBox = new KDComboBox();
        kdtEntrys_checkdepat_ComboBox.setName("kdtEntrys_checkdepat_ComboBox");
        kdtEntrys_checkdepat_ComboBox.setVisible(true);
        kdtEntrys_checkdepat_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.checkdepatEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_checkdepat_CellEditor = new KDTDefaultCellEditor(kdtEntrys_checkdepat_ComboBox);
        this.kdtEntrys.getColumn("checkdepat").setEditor(kdtEntrys_checkdepat_CellEditor);
        KDDatePicker kdtEntrys_checkDate_DatePicker = new KDDatePicker();
        kdtEntrys_checkDate_DatePicker.setName("kdtEntrys_checkDate_DatePicker");
        kdtEntrys_checkDate_DatePicker.setVisible(true);
        kdtEntrys_checkDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_checkDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_checkDate_DatePicker);
        this.kdtEntrys.getColumn("checkDate").setEditor(kdtEntrys_checkDate_CellEditor);
        KDTextField kdtEntrys_reason_TextField = new KDTextField();
        kdtEntrys_reason_TextField.setName("kdtEntrys_reason_TextField");
        kdtEntrys_reason_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_reason_CellEditor = new KDTDefaultCellEditor(kdtEntrys_reason_TextField);
        this.kdtEntrys.getColumn("reason").setEditor(kdtEntrys_reason_CellEditor);
        KDCheckBox kdtEntrys_books_CheckBox = new KDCheckBox();
        kdtEntrys_books_CheckBox.setName("kdtEntrys_books_CheckBox");
        KDTDefaultCellEditor kdtEntrys_books_CellEditor = new KDTDefaultCellEditor(kdtEntrys_books_CheckBox);
        this.kdtEntrys.getColumn("books").setEditor(kdtEntrys_books_CellEditor);
        KDCheckBox kdtEntrys_payDetail_CheckBox = new KDCheckBox();
        kdtEntrys_payDetail_CheckBox.setName("kdtEntrys_payDetail_CheckBox");
        KDTDefaultCellEditor kdtEntrys_payDetail_CellEditor = new KDTDefaultCellEditor(kdtEntrys_payDetail_CheckBox);
        this.kdtEntrys.getColumn("payDetail").setEditor(kdtEntrys_payDetail_CellEditor);
        KDCheckBox kdtEntrys_persMove_CheckBox = new KDCheckBox();
        kdtEntrys_persMove_CheckBox.setName("kdtEntrys_persMove_CheckBox");
        KDTDefaultCellEditor kdtEntrys_persMove_CellEditor = new KDTDefaultCellEditor(kdtEntrys_persMove_CheckBox);
        this.kdtEntrys.getColumn("persMove").setEditor(kdtEntrys_persMove_CellEditor);
        KDCheckBox kdtEntrys_algPersM_CheckBox = new KDCheckBox();
        kdtEntrys_algPersM_CheckBox.setName("kdtEntrys_algPersM_CheckBox");
        KDTDefaultCellEditor kdtEntrys_algPersM_CellEditor = new KDTDefaultCellEditor(kdtEntrys_algPersM_CheckBox);
        this.kdtEntrys.getColumn("algPersM").setEditor(kdtEntrys_algPersM_CellEditor);
        KDCheckBox kdtEntrys_taxBooks_CheckBox = new KDCheckBox();
        kdtEntrys_taxBooks_CheckBox.setName("kdtEntrys_taxBooks_CheckBox");
        KDTDefaultCellEditor kdtEntrys_taxBooks_CellEditor = new KDTDefaultCellEditor(kdtEntrys_taxBooks_CheckBox);
        this.kdtEntrys.getColumn("taxBooks").setEditor(kdtEntrys_taxBooks_CellEditor);
        KDCheckBox kdtEntrys_taxRepoBok_CheckBox = new KDCheckBox();
        kdtEntrys_taxRepoBok_CheckBox.setName("kdtEntrys_taxRepoBok_CheckBox");
        KDTDefaultCellEditor kdtEntrys_taxRepoBok_CellEditor = new KDTDefaultCellEditor(kdtEntrys_taxRepoBok_CheckBox);
        this.kdtEntrys.getColumn("taxRepoBok").setEditor(kdtEntrys_taxRepoBok_CellEditor);
        KDCheckBox kdtEntrys_compRule_CheckBox = new KDCheckBox();
        kdtEntrys_compRule_CheckBox.setName("kdtEntrys_compRule_CheckBox");
        KDTDefaultCellEditor kdtEntrys_compRule_CellEditor = new KDTDefaultCellEditor(kdtEntrys_compRule_CheckBox);
        this.kdtEntrys.getColumn("compRule").setEditor(kdtEntrys_compRule_CellEditor);
        KDCheckBox kdtEntrys_busiNum_CheckBox = new KDCheckBox();
        kdtEntrys_busiNum_CheckBox.setName("kdtEntrys_busiNum_CheckBox");
        KDTDefaultCellEditor kdtEntrys_busiNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_busiNum_CheckBox);
        this.kdtEntrys.getColumn("busiNum").setEditor(kdtEntrys_busiNum_CellEditor);
        KDCheckBox kdtEntrys_gManaNum_CheckBox = new KDCheckBox();
        kdtEntrys_gManaNum_CheckBox.setName("kdtEntrys_gManaNum_CheckBox");
        KDTDefaultCellEditor kdtEntrys_gManaNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_gManaNum_CheckBox);
        this.kdtEntrys.getColumn("gManaNum").setEditor(kdtEntrys_gManaNum_CellEditor);
        KDDatePicker kdtEntrys_chkEDate_DatePicker = new KDDatePicker();
        kdtEntrys_chkEDate_DatePicker.setName("kdtEntrys_chkEDate_DatePicker");
        kdtEntrys_chkEDate_DatePicker.setVisible(true);
        kdtEntrys_chkEDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_chkEDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_chkEDate_DatePicker);
        this.kdtEntrys.getColumn("chkEDate").setEditor(kdtEntrys_chkEDate_CellEditor);
        KDTextField kdtEntrys_chkResult_TextField = new KDTextField();
        kdtEntrys_chkResult_TextField.setName("kdtEntrys_chkResult_TextField");
        kdtEntrys_chkResult_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_chkResult_CellEditor = new KDTDefaultCellEditor(kdtEntrys_chkResult_TextField);
        this.kdtEntrys.getColumn("chkResult").setEditor(kdtEntrys_chkResult_CellEditor);
        KDFormattedTextField kdtEntrys_fFillPay_TextField = new KDFormattedTextField();
        kdtEntrys_fFillPay_TextField.setName("kdtEntrys_fFillPay_TextField");
        kdtEntrys_fFillPay_TextField.setVisible(true);
        kdtEntrys_fFillPay_TextField.setEditable(true);
        kdtEntrys_fFillPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_fFillPay_TextField.setDataType(1);
        	kdtEntrys_fFillPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fFillPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fFillPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fFillPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fFillPay_TextField);
        this.kdtEntrys.getColumn("fFillPay").setEditor(kdtEntrys_fFillPay_CellEditor);
        KDFormattedTextField kdtEntrys_fPenalty_TextField = new KDFormattedTextField();
        kdtEntrys_fPenalty_TextField.setName("kdtEntrys_fPenalty_TextField");
        kdtEntrys_fPenalty_TextField.setVisible(true);
        kdtEntrys_fPenalty_TextField.setEditable(true);
        kdtEntrys_fPenalty_TextField.setHorizontalAlignment(2);
        kdtEntrys_fPenalty_TextField.setDataType(1);
        	kdtEntrys_fPenalty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fPenalty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fPenalty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fPenalty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fPenalty_TextField);
        this.kdtEntrys.getColumn("fPenalty").setEditor(kdtEntrys_fPenalty_CellEditor);
        KDFormattedTextField kdtEntrys_fFine_TextField = new KDFormattedTextField();
        kdtEntrys_fFine_TextField.setName("kdtEntrys_fFine_TextField");
        kdtEntrys_fFine_TextField.setVisible(true);
        kdtEntrys_fFine_TextField.setEditable(true);
        kdtEntrys_fFine_TextField.setHorizontalAlignment(2);
        kdtEntrys_fFine_TextField.setDataType(1);
        	kdtEntrys_fFine_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fFine_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fFine_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fFine_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fFine_TextField);
        this.kdtEntrys.getColumn("fFine").setEditor(kdtEntrys_fFine_CellEditor);
        KDDatePicker kdtEntrys_notiDate_DatePicker = new KDDatePicker();
        kdtEntrys_notiDate_DatePicker.setName("kdtEntrys_notiDate_DatePicker");
        kdtEntrys_notiDate_DatePicker.setVisible(true);
        kdtEntrys_notiDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_notiDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_notiDate_DatePicker);
        this.kdtEntrys.getColumn("notiDate").setEditor(kdtEntrys_notiDate_CellEditor);
        KDDatePicker kdtEntrys_locaComm_DatePicker = new KDDatePicker();
        kdtEntrys_locaComm_DatePicker.setName("kdtEntrys_locaComm_DatePicker");
        kdtEntrys_locaComm_DatePicker.setVisible(true);
        kdtEntrys_locaComm_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_locaComm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_locaComm_DatePicker);
        this.kdtEntrys.getColumn("locaComm").setEditor(kdtEntrys_locaComm_CellEditor);
        KDDatePicker kdtEntrys_natiComm_DatePicker = new KDDatePicker();
        kdtEntrys_natiComm_DatePicker.setName("kdtEntrys_natiComm_DatePicker");
        kdtEntrys_natiComm_DatePicker.setVisible(true);
        kdtEntrys_natiComm_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_natiComm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_natiComm_DatePicker);
        this.kdtEntrys.getColumn("natiComm").setEditor(kdtEntrys_natiComm_CellEditor);
        KDDatePicker kdtEntrys_judicial_DatePicker = new KDDatePicker();
        kdtEntrys_judicial_DatePicker.setName("kdtEntrys_judicial_DatePicker");
        kdtEntrys_judicial_DatePicker.setVisible(true);
        kdtEntrys_judicial_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_judicial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_judicial_DatePicker);
        this.kdtEntrys.getColumn("judicial").setEditor(kdtEntrys_judicial_CellEditor);
        KDFormattedTextField kdtEntrys_fillPay_TextField = new KDFormattedTextField();
        kdtEntrys_fillPay_TextField.setName("kdtEntrys_fillPay_TextField");
        kdtEntrys_fillPay_TextField.setVisible(true);
        kdtEntrys_fillPay_TextField.setEditable(true);
        kdtEntrys_fillPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_fillPay_TextField.setDataType(1);
        	kdtEntrys_fillPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fillPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fillPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fillPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fillPay_TextField);
        this.kdtEntrys.getColumn("fillPay").setEditor(kdtEntrys_fillPay_CellEditor);
        KDFormattedTextField kdtEntrys_Penalty_TextField = new KDFormattedTextField();
        kdtEntrys_Penalty_TextField.setName("kdtEntrys_Penalty_TextField");
        kdtEntrys_Penalty_TextField.setVisible(true);
        kdtEntrys_Penalty_TextField.setEditable(true);
        kdtEntrys_Penalty_TextField.setHorizontalAlignment(2);
        kdtEntrys_Penalty_TextField.setDataType(1);
        	kdtEntrys_Penalty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_Penalty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_Penalty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_Penalty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Penalty_TextField);
        this.kdtEntrys.getColumn("Penalty").setEditor(kdtEntrys_Penalty_CellEditor);
        KDFormattedTextField kdtEntrys_fine_TextField = new KDFormattedTextField();
        kdtEntrys_fine_TextField.setName("kdtEntrys_fine_TextField");
        kdtEntrys_fine_TextField.setVisible(true);
        kdtEntrys_fine_TextField.setEditable(true);
        kdtEntrys_fine_TextField.setHorizontalAlignment(2);
        kdtEntrys_fine_TextField.setDataType(1);
        	kdtEntrys_fine_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fine_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fine_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fine_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fine_TextField);
        this.kdtEntrys.getColumn("fine").setEditor(kdtEntrys_fine_CellEditor);
        KDFormattedTextField kdtEntrys_endTolFine_TextField = new KDFormattedTextField();
        kdtEntrys_endTolFine_TextField.setName("kdtEntrys_endTolFine_TextField");
        kdtEntrys_endTolFine_TextField.setVisible(true);
        kdtEntrys_endTolFine_TextField.setEditable(true);
        kdtEntrys_endTolFine_TextField.setHorizontalAlignment(2);
        kdtEntrys_endTolFine_TextField.setDataType(1);
        	kdtEntrys_endTolFine_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_endTolFine_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_endTolFine_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_endTolFine_CellEditor = new KDTDefaultCellEditor(kdtEntrys_endTolFine_TextField);
        this.kdtEntrys.getColumn("endTolFine").setEditor(kdtEntrys_endTolFine_CellEditor);
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
        // contbillSate		
        this.contbillSate.setBoundLabelText(resHelper.getString("contbillSate.boundLabelText"));		
        this.contbillSate.setBoundLabelLength(100);		
        this.contbillSate.setBoundLabelUnderline(true);		
        this.contbillSate.setVisible(true);		
        this.contbillSate.setEnabled(false);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);
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
        // billSate		
        this.billSate.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billSate.setRequired(false);		
        this.billSate.setEnabled(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,billSate,pkauditDate,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1169, 505));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1169, 505));
        contCreator.setBounds(new Rectangle(577, 477, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(577, 477, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(878, 477, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(878, 477, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(432, 504, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(432, 504, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(722, 504, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(722, 504, 270, 19, 0));
        contNumber.setBounds(new Rectangle(14, 10, 362, 19));
        this.add(contNumber, new KDLayout.Constraints(14, 10, 362, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(430, 10, 362, 19));
        this.add(contBizDate, new KDLayout.Constraints(430, 10, 362, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(14, 33, 1134, 19));
        this.add(contDescription, new KDLayout.Constraints(14, 33, 1134, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(7, 477, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(7, 477, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(7, 91, 1144, 381));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.social.ProjChkCountEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(7, 91, 1144, 381, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("checkdepat","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contbillSate.setBounds(new Rectangle(847, 10, 300, 19));
        this.add(contbillSate, new KDLayout.Constraints(847, 10, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditDate.setBounds(new Rectangle(307, 477, 240, 19));
        this.add(contauditDate, new KDLayout.Constraints(307, 477, 240, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer1.setBounds(new Rectangle(13, 65, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(13, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.social.ProjChkCountEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.projName", java.lang.Object.class, this.kdtEntrys, "projName.text");
		dataBinder.registerBinding("entrys.province", java.lang.Object.class, this.kdtEntrys, "province.text");
		dataBinder.registerBinding("entrys.checkdepat", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "checkdepat.text");
		dataBinder.registerBinding("entrys.checkDate", java.util.Date.class, this.kdtEntrys, "checkDate.text");
		dataBinder.registerBinding("entrys.books", boolean.class, this.kdtEntrys, "books.text");
		dataBinder.registerBinding("entrys.payDetail", boolean.class, this.kdtEntrys, "payDetail.text");
		dataBinder.registerBinding("entrys.persMove", boolean.class, this.kdtEntrys, "persMove.text");
		dataBinder.registerBinding("entrys.algPersM", boolean.class, this.kdtEntrys, "algPersM.text");
		dataBinder.registerBinding("entrys.taxBooks", boolean.class, this.kdtEntrys, "taxBooks.text");
		dataBinder.registerBinding("entrys.taxRepoBok", boolean.class, this.kdtEntrys, "taxRepoBok.text");
		dataBinder.registerBinding("entrys.compRule", boolean.class, this.kdtEntrys, "compRule.text");
		dataBinder.registerBinding("entrys.busiNum", boolean.class, this.kdtEntrys, "busiNum.text");
		dataBinder.registerBinding("entrys.gManaNum", boolean.class, this.kdtEntrys, "gManaNum.text");
		dataBinder.registerBinding("entrys.reason", String.class, this.kdtEntrys, "reason.text");
		dataBinder.registerBinding("entrys.chkEDate", java.util.Date.class, this.kdtEntrys, "chkEDate.text");
		dataBinder.registerBinding("entrys.chkResult", String.class, this.kdtEntrys, "chkResult.text");
		dataBinder.registerBinding("entrys.notiDate", java.util.Date.class, this.kdtEntrys, "notiDate.text");
		dataBinder.registerBinding("entrys.locaComm", java.util.Date.class, this.kdtEntrys, "locaComm.text");
		dataBinder.registerBinding("entrys.natiComm", java.util.Date.class, this.kdtEntrys, "natiComm.text");
		dataBinder.registerBinding("entrys.judicial", java.util.Date.class, this.kdtEntrys, "judicial.text");
		dataBinder.registerBinding("entrys.fillPay", java.math.BigDecimal.class, this.kdtEntrys, "fillPay.text");
		dataBinder.registerBinding("entrys.Penalty", java.math.BigDecimal.class, this.kdtEntrys, "Penalty.text");
		dataBinder.registerBinding("entrys.fine", java.math.BigDecimal.class, this.kdtEntrys, "fine.text");
		dataBinder.registerBinding("entrys.fFillPay", java.math.BigDecimal.class, this.kdtEntrys, "fFillPay.text");
		dataBinder.registerBinding("entrys.fPenalty", java.math.BigDecimal.class, this.kdtEntrys, "fPenalty.text");
		dataBinder.registerBinding("entrys.fFine", java.math.BigDecimal.class, this.kdtEntrys, "fFine.text");
		dataBinder.registerBinding("entrys.endTolFine", java.math.BigDecimal.class, this.kdtEntrys, "endTolFine.text");
		dataBinder.registerBinding("entrys.endDate", java.util.Date.class, this.kdtEntrys, "endDate.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billSate", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSate, "selectedItem");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.social.app.ProjChkCountEditUIHandler";
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
        this.kDDateLastUpdateTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.social.ProjChkCountInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.projName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.province", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkdepat", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.books", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.payDetail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.persMove", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.algPersM", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.taxBooks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.taxRepoBok", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.compRule", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.busiNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.gManaNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.reason", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.chkEDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.chkResult", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.notiDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.locaComm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.natiComm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.judicial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fillPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Penalty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fine", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fFillPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fPenalty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fFine", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.endTolFine", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    		
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
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.projName.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.projName.id"));
			sic.add(new SelectorItemInfo("entrys.projName.name"));
        	sic.add(new SelectorItemInfo("entrys.projName.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.province.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.province.id"));
			sic.add(new SelectorItemInfo("entrys.province.name"));
        	sic.add(new SelectorItemInfo("entrys.province.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.checkdepat"));
    	sic.add(new SelectorItemInfo("entrys.checkDate"));
    	sic.add(new SelectorItemInfo("entrys.books"));
    	sic.add(new SelectorItemInfo("entrys.payDetail"));
    	sic.add(new SelectorItemInfo("entrys.persMove"));
    	sic.add(new SelectorItemInfo("entrys.algPersM"));
    	sic.add(new SelectorItemInfo("entrys.taxBooks"));
    	sic.add(new SelectorItemInfo("entrys.taxRepoBok"));
    	sic.add(new SelectorItemInfo("entrys.compRule"));
    	sic.add(new SelectorItemInfo("entrys.busiNum"));
    	sic.add(new SelectorItemInfo("entrys.gManaNum"));
    	sic.add(new SelectorItemInfo("entrys.reason"));
    	sic.add(new SelectorItemInfo("entrys.chkEDate"));
    	sic.add(new SelectorItemInfo("entrys.chkResult"));
    	sic.add(new SelectorItemInfo("entrys.notiDate"));
    	sic.add(new SelectorItemInfo("entrys.locaComm"));
    	sic.add(new SelectorItemInfo("entrys.natiComm"));
    	sic.add(new SelectorItemInfo("entrys.judicial"));
    	sic.add(new SelectorItemInfo("entrys.fillPay"));
    	sic.add(new SelectorItemInfo("entrys.Penalty"));
    	sic.add(new SelectorItemInfo("entrys.fine"));
    	sic.add(new SelectorItemInfo("entrys.fFillPay"));
    	sic.add(new SelectorItemInfo("entrys.fPenalty"));
    	sic.add(new SelectorItemInfo("entrys.fFine"));
    	sic.add(new SelectorItemInfo("entrys.endTolFine"));
    	sic.add(new SelectorItemInfo("entrys.endDate"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
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
        sic.add(new SelectorItemInfo("auditDate"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.social.client", "ProjChkCountEditUI");
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
        return com.kingdee.eas.zjlw.social.client.ProjChkCountEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.social.ProjChkCountFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.social.ProjChkCountInfo objectValue = new com.kingdee.eas.zjlw.social.ProjChkCountInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/social/ProjChkCount";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.social.app.ProjChkCountQuery");
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