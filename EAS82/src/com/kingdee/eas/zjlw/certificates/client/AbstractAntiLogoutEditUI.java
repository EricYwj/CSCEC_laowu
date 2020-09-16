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
public abstract class AbstractAntiLogoutEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAntiLogoutEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillState;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billState;
    protected com.kingdee.eas.zjlw.certificates.AntiLogoutInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractAntiLogoutEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAntiLogoutEditUI.class.getName());
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
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillState = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.billState = new com.kingdee.bos.ctrl.swing.KDComboBox();
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
        this.contbillState.setName("contbillState");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditDate.setName("pkauditDate");
        this.billState.setName("billState");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol21\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol22\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol30\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol31\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol33\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol42\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol45\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol46\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol47\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol48\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol49\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol50\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol51\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol52\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol53\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol54\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol55\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol56\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol57\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol58\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol59\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol60\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol61\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol62\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"sex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"birthDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"nation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"passpNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"quProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"pmtProfFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"laborSignNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"antiSgTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"antiEndTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"subDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"logoutDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"logoutType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"docAffiliatedD\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"docAffiliate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"permitProgram\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"workProgram\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"cooperation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"signNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"IdNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthplace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"birthPlaceFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"passportIDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"passportEDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"passportAgency\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"passportCity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"passportCityF\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"workSuffe\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"fatherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"fatherNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"motherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"motherNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"MaritalStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"assignDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"sendLaBuDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"ownerSignDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"docUpDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"isLogout\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"logoutData\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"logoutReson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"isCancel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"cancelDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"cancelReson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"acProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"authType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"copie\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol49\" /><t:Column t:key=\"coupleName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol50\" /><t:Column t:key=\"coupleNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"coupleBirthDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol52\" /><t:Column t:key=\"couplebirthPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol53\" /><t:Column t:key=\"coupleNational\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol54\" /><t:Column t:key=\"coupleWorkPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol55\" /><t:Column t:key=\"contactway\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol56\" /><t:Column t:key=\"residence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol57\" /><t:Column t:key=\"oldPassport\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol58\" /><t:Column t:key=\"personState\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol59\" /><t:Column t:key=\"isPush\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol60\" /><t:Column t:key=\"sourceEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol61\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{birthDate}</t:Cell><t:Cell>$Resource{nation}</t:Cell><t:Cell>$Resource{passpNum}</t:Cell><t:Cell>$Resource{quProf}</t:Cell><t:Cell>$Resource{pmtProfFr}</t:Cell><t:Cell>$Resource{laborSignNo}</t:Cell><t:Cell>$Resource{antiSgTime}</t:Cell><t:Cell>$Resource{antiEndTime}</t:Cell><t:Cell>$Resource{subDate}</t:Cell><t:Cell>$Resource{logoutDate}</t:Cell><t:Cell>$Resource{logoutType}</t:Cell><t:Cell>$Resource{docAffiliatedD}</t:Cell><t:Cell>$Resource{docAffiliate}</t:Cell><t:Cell>$Resource{permitProgram}</t:Cell><t:Cell>$Resource{workProgram}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{signNum}</t:Cell><t:Cell>$Resource{IdNum}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{birthplace}</t:Cell><t:Cell>$Resource{birthPlaceFr}</t:Cell><t:Cell>$Resource{passportIDate}</t:Cell><t:Cell>$Resource{passportEDate}</t:Cell><t:Cell>$Resource{passportAgency}</t:Cell><t:Cell>$Resource{passportCity}</t:Cell><t:Cell>$Resource{passportCityF}</t:Cell><t:Cell>$Resource{workSuffe}</t:Cell><t:Cell>$Resource{fatherName}</t:Cell><t:Cell>$Resource{fatherNameAlphabet}</t:Cell><t:Cell>$Resource{motherName}</t:Cell><t:Cell>$Resource{motherNameAlphabet}</t:Cell><t:Cell>$Resource{MaritalStatus}</t:Cell><t:Cell>$Resource{assignDate}</t:Cell><t:Cell>$Resource{sendLaBuDate}</t:Cell><t:Cell>$Resource{ownerSignDate}</t:Cell><t:Cell>$Resource{docUpDate}</t:Cell><t:Cell>$Resource{isLogout}</t:Cell><t:Cell>$Resource{logoutData}</t:Cell><t:Cell>$Resource{logoutReson}</t:Cell><t:Cell>$Resource{isCancel}</t:Cell><t:Cell>$Resource{cancelDate}</t:Cell><t:Cell>$Resource{cancelReson}</t:Cell><t:Cell>$Resource{acProf}</t:Cell><t:Cell>$Resource{authType}</t:Cell><t:Cell>$Resource{copie}</t:Cell><t:Cell>$Resource{coupleName}</t:Cell><t:Cell>$Resource{coupleNameAlphabet}</t:Cell><t:Cell>$Resource{coupleBirthDate}</t:Cell><t:Cell>$Resource{couplebirthPlace}</t:Cell><t:Cell>$Resource{coupleNational}</t:Cell><t:Cell>$Resource{coupleWorkPlace}</t:Cell><t:Cell>$Resource{contactway}</t:Cell><t:Cell>$Resource{residence}</t:Cell><t:Cell>$Resource{oldPassport}</t:Cell><t:Cell>$Resource{personState}</t:Cell><t:Cell>$Resource{isPush}</t:Cell><t:Cell>$Resource{sourceEntryID}</t:Cell><t:Cell>$Resource{personID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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

                this.kdtEntrys.putBindContents("editData",new String[] {"id","name","lastName","firstName","sex","birthDate","nation","passpNum","quProf","pmtProfFr","laborSignNo","antiSgTime","antiEndTime","subDate","logoutDate","logoutType","docAffiliatedD","docAffiliate","permitProgram","workProgram","cooperation","signNum","IdNum","remark","birthplace","birthPlaceFr","passportIDate","passportEDate","passportAgency","passportCity","passportCityF","workSuffe","fatherName","fatherNameAlphabet","motherName","motherNameAlphabet","MaritalStatus","assignDate","sendLaBuDate","ownerSignDate","docUpDate","isLogout","logoutData","logoutReson","isCancel","cancelDate","cancelReson","acProf","authType","copie","coupleName","coupleNameAlphabet","coupleBirthDate","couplebirthPlace","coupleNational","coupleWorkPlace","contactway","residence","oldPassport","personState","isPush","sourceEntryID","personID"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_name_TextField = new KDTextField();
        kdtEntrys_name_TextField.setName("kdtEntrys_name_TextField");
        kdtEntrys_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_name_CellEditor = new KDTDefaultCellEditor(kdtEntrys_name_TextField);
        this.kdtEntrys.getColumn("name").setEditor(kdtEntrys_name_CellEditor);
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
        KDDatePicker kdtEntrys_birthDate_DatePicker = new KDDatePicker();
        kdtEntrys_birthDate_DatePicker.setName("kdtEntrys_birthDate_DatePicker");
        kdtEntrys_birthDate_DatePicker.setVisible(true);
        kdtEntrys_birthDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_birthDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthDate_DatePicker);
        this.kdtEntrys.getColumn("birthDate").setEditor(kdtEntrys_birthDate_CellEditor);
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
        KDTextField kdtEntrys_passpNum_TextField = new KDTextField();
        kdtEntrys_passpNum_TextField.setName("kdtEntrys_passpNum_TextField");
        kdtEntrys_passpNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_passpNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passpNum_TextField);
        this.kdtEntrys.getColumn("passpNum").setEditor(kdtEntrys_passpNum_CellEditor);
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
        KDTextField kdtEntrys_pmtProfFr_TextField = new KDTextField();
        kdtEntrys_pmtProfFr_TextField.setName("kdtEntrys_pmtProfFr_TextField");
        kdtEntrys_pmtProfFr_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_pmtProfFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProfFr_TextField);
        this.kdtEntrys.getColumn("pmtProfFr").setEditor(kdtEntrys_pmtProfFr_CellEditor);
        KDTextField kdtEntrys_laborSignNo_TextField = new KDTextField();
        kdtEntrys_laborSignNo_TextField.setName("kdtEntrys_laborSignNo_TextField");
        kdtEntrys_laborSignNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_laborSignNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_laborSignNo_TextField);
        this.kdtEntrys.getColumn("laborSignNo").setEditor(kdtEntrys_laborSignNo_CellEditor);
        KDDatePicker kdtEntrys_antiSgTime_DatePicker = new KDDatePicker();
        kdtEntrys_antiSgTime_DatePicker.setName("kdtEntrys_antiSgTime_DatePicker");
        kdtEntrys_antiSgTime_DatePicker.setVisible(true);
        kdtEntrys_antiSgTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_antiSgTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_antiSgTime_DatePicker);
        this.kdtEntrys.getColumn("antiSgTime").setEditor(kdtEntrys_antiSgTime_CellEditor);
        KDDatePicker kdtEntrys_antiEndTime_DatePicker = new KDDatePicker();
        kdtEntrys_antiEndTime_DatePicker.setName("kdtEntrys_antiEndTime_DatePicker");
        kdtEntrys_antiEndTime_DatePicker.setVisible(true);
        kdtEntrys_antiEndTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_antiEndTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_antiEndTime_DatePicker);
        this.kdtEntrys.getColumn("antiEndTime").setEditor(kdtEntrys_antiEndTime_CellEditor);
        KDDatePicker kdtEntrys_subDate_DatePicker = new KDDatePicker();
        kdtEntrys_subDate_DatePicker.setName("kdtEntrys_subDate_DatePicker");
        kdtEntrys_subDate_DatePicker.setVisible(true);
        kdtEntrys_subDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_subDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_subDate_DatePicker);
        this.kdtEntrys.getColumn("subDate").setEditor(kdtEntrys_subDate_CellEditor);
        KDDatePicker kdtEntrys_logoutDate_DatePicker = new KDDatePicker();
        kdtEntrys_logoutDate_DatePicker.setName("kdtEntrys_logoutDate_DatePicker");
        kdtEntrys_logoutDate_DatePicker.setVisible(true);
        kdtEntrys_logoutDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_logoutDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_logoutDate_DatePicker);
        this.kdtEntrys.getColumn("logoutDate").setEditor(kdtEntrys_logoutDate_CellEditor);
        KDComboBox kdtEntrys_logoutType_ComboBox = new KDComboBox();
        kdtEntrys_logoutType_ComboBox.setName("kdtEntrys_logoutType_ComboBox");
        kdtEntrys_logoutType_ComboBox.setVisible(true);
        kdtEntrys_logoutType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.logoutTypeEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_logoutType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_logoutType_ComboBox);
        this.kdtEntrys.getColumn("logoutType").setEditor(kdtEntrys_logoutType_CellEditor);
        KDCheckBox kdtEntrys_docAffiliatedD_CheckBox = new KDCheckBox();
        kdtEntrys_docAffiliatedD_CheckBox.setName("kdtEntrys_docAffiliatedD_CheckBox");
        KDTDefaultCellEditor kdtEntrys_docAffiliatedD_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docAffiliatedD_CheckBox);
        this.kdtEntrys.getColumn("docAffiliatedD").setEditor(kdtEntrys_docAffiliatedD_CellEditor);
        KDCheckBox kdtEntrys_docAffiliate_CheckBox = new KDCheckBox();
        kdtEntrys_docAffiliate_CheckBox.setName("kdtEntrys_docAffiliate_CheckBox");
        KDTDefaultCellEditor kdtEntrys_docAffiliate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docAffiliate_CheckBox);
        this.kdtEntrys.getColumn("docAffiliate").setEditor(kdtEntrys_docAffiliate_CellEditor);
        final KDBizPromptBox kdtEntrys_permitProgram_PromptBox = new KDBizPromptBox();
        kdtEntrys_permitProgram_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_permitProgram_PromptBox.setVisible(true);
        kdtEntrys_permitProgram_PromptBox.setEditable(true);
        kdtEntrys_permitProgram_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_permitProgram_PromptBox.setEditFormat("$number$");
        kdtEntrys_permitProgram_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_permitProgram_CellEditor = new KDTDefaultCellEditor(kdtEntrys_permitProgram_PromptBox);
        this.kdtEntrys.getColumn("permitProgram").setEditor(kdtEntrys_permitProgram_CellEditor);
        ObjectValueRender kdtEntrys_permitProgram_OVR = new ObjectValueRender();
        kdtEntrys_permitProgram_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("permitProgram").setRenderer(kdtEntrys_permitProgram_OVR);
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
        KDTextField kdtEntrys_signNum_TextField = new KDTextField();
        kdtEntrys_signNum_TextField.setName("kdtEntrys_signNum_TextField");
        kdtEntrys_signNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_signNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_signNum_TextField);
        this.kdtEntrys.getColumn("signNum").setEditor(kdtEntrys_signNum_CellEditor);
        KDTextField kdtEntrys_IdNum_TextField = new KDTextField();
        kdtEntrys_IdNum_TextField.setName("kdtEntrys_IdNum_TextField");
        kdtEntrys_IdNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_IdNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IdNum_TextField);
        this.kdtEntrys.getColumn("IdNum").setEditor(kdtEntrys_IdNum_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        KDTextField kdtEntrys_birthplace_TextField = new KDTextField();
        kdtEntrys_birthplace_TextField.setName("kdtEntrys_birthplace_TextField");
        kdtEntrys_birthplace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_birthplace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthplace_TextField);
        this.kdtEntrys.getColumn("birthplace").setEditor(kdtEntrys_birthplace_CellEditor);
        KDTextField kdtEntrys_birthPlaceFr_TextField = new KDTextField();
        kdtEntrys_birthPlaceFr_TextField.setName("kdtEntrys_birthPlaceFr_TextField");
        kdtEntrys_birthPlaceFr_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_birthPlaceFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlaceFr_TextField);
        this.kdtEntrys.getColumn("birthPlaceFr").setEditor(kdtEntrys_birthPlaceFr_CellEditor);
        KDDatePicker kdtEntrys_passportIDate_DatePicker = new KDDatePicker();
        kdtEntrys_passportIDate_DatePicker.setName("kdtEntrys_passportIDate_DatePicker");
        kdtEntrys_passportIDate_DatePicker.setVisible(true);
        kdtEntrys_passportIDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passportIDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportIDate_DatePicker);
        this.kdtEntrys.getColumn("passportIDate").setEditor(kdtEntrys_passportIDate_CellEditor);
        KDDatePicker kdtEntrys_passportEDate_DatePicker = new KDDatePicker();
        kdtEntrys_passportEDate_DatePicker.setName("kdtEntrys_passportEDate_DatePicker");
        kdtEntrys_passportEDate_DatePicker.setVisible(true);
        kdtEntrys_passportEDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passportEDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportEDate_DatePicker);
        this.kdtEntrys.getColumn("passportEDate").setEditor(kdtEntrys_passportEDate_CellEditor);
        KDComboBox kdtEntrys_passportAgency_ComboBox = new KDComboBox();
        kdtEntrys_passportAgency_ComboBox.setName("kdtEntrys_passportAgency_ComboBox");
        kdtEntrys_passportAgency_ComboBox.setVisible(true);
        kdtEntrys_passportAgency_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_passportAgency_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportAgency_ComboBox);
        this.kdtEntrys.getColumn("passportAgency").setEditor(kdtEntrys_passportAgency_CellEditor);
        final KDBizPromptBox kdtEntrys_passportCity_PromptBox = new KDBizPromptBox();
        kdtEntrys_passportCity_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");
        kdtEntrys_passportCity_PromptBox.setVisible(true);
        kdtEntrys_passportCity_PromptBox.setEditable(true);
        kdtEntrys_passportCity_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_passportCity_PromptBox.setEditFormat("$number$");
        kdtEntrys_passportCity_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_passportCity_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportCity_PromptBox);
        this.kdtEntrys.getColumn("passportCity").setEditor(kdtEntrys_passportCity_CellEditor);
        ObjectValueRender kdtEntrys_passportCity_OVR = new ObjectValueRender();
        kdtEntrys_passportCity_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("passportCity").setRenderer(kdtEntrys_passportCity_OVR);
        KDTextField kdtEntrys_passportCityF_TextField = new KDTextField();
        kdtEntrys_passportCityF_TextField.setName("kdtEntrys_passportCityF_TextField");
        kdtEntrys_passportCityF_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_passportCityF_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportCityF_TextField);
        this.kdtEntrys.getColumn("passportCityF").setEditor(kdtEntrys_passportCityF_CellEditor);
        KDFormattedTextField kdtEntrys_workSuffe_TextField = new KDFormattedTextField();
        kdtEntrys_workSuffe_TextField.setName("kdtEntrys_workSuffe_TextField");
        kdtEntrys_workSuffe_TextField.setVisible(true);
        kdtEntrys_workSuffe_TextField.setEditable(true);
        kdtEntrys_workSuffe_TextField.setHorizontalAlignment(2);
        kdtEntrys_workSuffe_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_workSuffe_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workSuffe_TextField);
        this.kdtEntrys.getColumn("workSuffe").setEditor(kdtEntrys_workSuffe_CellEditor);
        KDTextField kdtEntrys_fatherName_TextField = new KDTextField();
        kdtEntrys_fatherName_TextField.setName("kdtEntrys_fatherName_TextField");
        kdtEntrys_fatherName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_fatherName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fatherName_TextField);
        this.kdtEntrys.getColumn("fatherName").setEditor(kdtEntrys_fatherName_CellEditor);
        KDTextField kdtEntrys_fatherNameAlphabet_TextField = new KDTextField();
        kdtEntrys_fatherNameAlphabet_TextField.setName("kdtEntrys_fatherNameAlphabet_TextField");
        kdtEntrys_fatherNameAlphabet_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_fatherNameAlphabet_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fatherNameAlphabet_TextField);
        this.kdtEntrys.getColumn("fatherNameAlphabet").setEditor(kdtEntrys_fatherNameAlphabet_CellEditor);
        KDTextField kdtEntrys_motherName_TextField = new KDTextField();
        kdtEntrys_motherName_TextField.setName("kdtEntrys_motherName_TextField");
        kdtEntrys_motherName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_motherName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_motherName_TextField);
        this.kdtEntrys.getColumn("motherName").setEditor(kdtEntrys_motherName_CellEditor);
        KDTextField kdtEntrys_motherNameAlphabet_TextField = new KDTextField();
        kdtEntrys_motherNameAlphabet_TextField.setName("kdtEntrys_motherNameAlphabet_TextField");
        kdtEntrys_motherNameAlphabet_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_motherNameAlphabet_CellEditor = new KDTDefaultCellEditor(kdtEntrys_motherNameAlphabet_TextField);
        this.kdtEntrys.getColumn("motherNameAlphabet").setEditor(kdtEntrys_motherNameAlphabet_CellEditor);
        KDComboBox kdtEntrys_MaritalStatus_ComboBox = new KDComboBox();
        kdtEntrys_MaritalStatus_ComboBox.setName("kdtEntrys_MaritalStatus_ComboBox");
        kdtEntrys_MaritalStatus_ComboBox.setVisible(true);
        kdtEntrys_MaritalStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.mayrStatEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_MaritalStatus_CellEditor = new KDTDefaultCellEditor(kdtEntrys_MaritalStatus_ComboBox);
        this.kdtEntrys.getColumn("MaritalStatus").setEditor(kdtEntrys_MaritalStatus_CellEditor);
        KDDatePicker kdtEntrys_assignDate_DatePicker = new KDDatePicker();
        kdtEntrys_assignDate_DatePicker.setName("kdtEntrys_assignDate_DatePicker");
        kdtEntrys_assignDate_DatePicker.setVisible(true);
        kdtEntrys_assignDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_assignDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_assignDate_DatePicker);
        this.kdtEntrys.getColumn("assignDate").setEditor(kdtEntrys_assignDate_CellEditor);
        KDDatePicker kdtEntrys_sendLaBuDate_DatePicker = new KDDatePicker();
        kdtEntrys_sendLaBuDate_DatePicker.setName("kdtEntrys_sendLaBuDate_DatePicker");
        kdtEntrys_sendLaBuDate_DatePicker.setVisible(true);
        kdtEntrys_sendLaBuDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_sendLaBuDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sendLaBuDate_DatePicker);
        this.kdtEntrys.getColumn("sendLaBuDate").setEditor(kdtEntrys_sendLaBuDate_CellEditor);
        KDDatePicker kdtEntrys_ownerSignDate_DatePicker = new KDDatePicker();
        kdtEntrys_ownerSignDate_DatePicker.setName("kdtEntrys_ownerSignDate_DatePicker");
        kdtEntrys_ownerSignDate_DatePicker.setVisible(true);
        kdtEntrys_ownerSignDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_ownerSignDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ownerSignDate_DatePicker);
        this.kdtEntrys.getColumn("ownerSignDate").setEditor(kdtEntrys_ownerSignDate_CellEditor);
        KDDatePicker kdtEntrys_docUpDate_DatePicker = new KDDatePicker();
        kdtEntrys_docUpDate_DatePicker.setName("kdtEntrys_docUpDate_DatePicker");
        kdtEntrys_docUpDate_DatePicker.setVisible(true);
        kdtEntrys_docUpDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_docUpDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docUpDate_DatePicker);
        this.kdtEntrys.getColumn("docUpDate").setEditor(kdtEntrys_docUpDate_CellEditor);
        KDCheckBox kdtEntrys_isLogout_CheckBox = new KDCheckBox();
        kdtEntrys_isLogout_CheckBox.setName("kdtEntrys_isLogout_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isLogout_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isLogout_CheckBox);
        this.kdtEntrys.getColumn("isLogout").setEditor(kdtEntrys_isLogout_CellEditor);
        KDDatePicker kdtEntrys_logoutData_DatePicker = new KDDatePicker();
        kdtEntrys_logoutData_DatePicker.setName("kdtEntrys_logoutData_DatePicker");
        kdtEntrys_logoutData_DatePicker.setVisible(true);
        kdtEntrys_logoutData_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_logoutData_CellEditor = new KDTDefaultCellEditor(kdtEntrys_logoutData_DatePicker);
        this.kdtEntrys.getColumn("logoutData").setEditor(kdtEntrys_logoutData_CellEditor);
        KDTextField kdtEntrys_logoutReson_TextField = new KDTextField();
        kdtEntrys_logoutReson_TextField.setName("kdtEntrys_logoutReson_TextField");
        kdtEntrys_logoutReson_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_logoutReson_CellEditor = new KDTDefaultCellEditor(kdtEntrys_logoutReson_TextField);
        this.kdtEntrys.getColumn("logoutReson").setEditor(kdtEntrys_logoutReson_CellEditor);
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
        KDTextField kdtEntrys_cancelReson_TextField = new KDTextField();
        kdtEntrys_cancelReson_TextField.setName("kdtEntrys_cancelReson_TextField");
        kdtEntrys_cancelReson_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_cancelReson_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cancelReson_TextField);
        this.kdtEntrys.getColumn("cancelReson").setEditor(kdtEntrys_cancelReson_CellEditor);
        KDTextField kdtEntrys_acProf_TextField = new KDTextField();
        kdtEntrys_acProf_TextField.setName("kdtEntrys_acProf_TextField");
        kdtEntrys_acProf_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_acProf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_acProf_TextField);
        this.kdtEntrys.getColumn("acProf").setEditor(kdtEntrys_acProf_CellEditor);
        KDComboBox kdtEntrys_authType_ComboBox = new KDComboBox();
        kdtEntrys_authType_ComboBox.setName("kdtEntrys_authType_ComboBox");
        kdtEntrys_authType_ComboBox.setVisible(true);
        kdtEntrys_authType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.authType").toArray());
        KDTDefaultCellEditor kdtEntrys_authType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_authType_ComboBox);
        this.kdtEntrys.getColumn("authType").setEditor(kdtEntrys_authType_CellEditor);
        KDFormattedTextField kdtEntrys_copie_TextField = new KDFormattedTextField();
        kdtEntrys_copie_TextField.setName("kdtEntrys_copie_TextField");
        kdtEntrys_copie_TextField.setVisible(true);
        kdtEntrys_copie_TextField.setEditable(true);
        kdtEntrys_copie_TextField.setHorizontalAlignment(2);
        kdtEntrys_copie_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_copie_CellEditor = new KDTDefaultCellEditor(kdtEntrys_copie_TextField);
        this.kdtEntrys.getColumn("copie").setEditor(kdtEntrys_copie_CellEditor);
        KDTextField kdtEntrys_coupleName_TextField = new KDTextField();
        kdtEntrys_coupleName_TextField.setName("kdtEntrys_coupleName_TextField");
        kdtEntrys_coupleName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coupleName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleName_TextField);
        this.kdtEntrys.getColumn("coupleName").setEditor(kdtEntrys_coupleName_CellEditor);
        KDTextField kdtEntrys_coupleNameAlphabet_TextField = new KDTextField();
        kdtEntrys_coupleNameAlphabet_TextField.setName("kdtEntrys_coupleNameAlphabet_TextField");
        kdtEntrys_coupleNameAlphabet_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coupleNameAlphabet_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleNameAlphabet_TextField);
        this.kdtEntrys.getColumn("coupleNameAlphabet").setEditor(kdtEntrys_coupleNameAlphabet_CellEditor);
        KDDatePicker kdtEntrys_coupleBirthDate_DatePicker = new KDDatePicker();
        kdtEntrys_coupleBirthDate_DatePicker.setName("kdtEntrys_coupleBirthDate_DatePicker");
        kdtEntrys_coupleBirthDate_DatePicker.setVisible(true);
        kdtEntrys_coupleBirthDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_coupleBirthDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleBirthDate_DatePicker);
        this.kdtEntrys.getColumn("coupleBirthDate").setEditor(kdtEntrys_coupleBirthDate_CellEditor);
        KDTextField kdtEntrys_couplebirthPlace_TextField = new KDTextField();
        kdtEntrys_couplebirthPlace_TextField.setName("kdtEntrys_couplebirthPlace_TextField");
        kdtEntrys_couplebirthPlace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_couplebirthPlace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_couplebirthPlace_TextField);
        this.kdtEntrys.getColumn("couplebirthPlace").setEditor(kdtEntrys_couplebirthPlace_CellEditor);
        final KDBizPromptBox kdtEntrys_coupleNational_PromptBox = new KDBizPromptBox();
        kdtEntrys_coupleNational_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");
        kdtEntrys_coupleNational_PromptBox.setVisible(true);
        kdtEntrys_coupleNational_PromptBox.setEditable(true);
        kdtEntrys_coupleNational_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_coupleNational_PromptBox.setEditFormat("$number$");
        kdtEntrys_coupleNational_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_coupleNational_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleNational_PromptBox);
        this.kdtEntrys.getColumn("coupleNational").setEditor(kdtEntrys_coupleNational_CellEditor);
        ObjectValueRender kdtEntrys_coupleNational_OVR = new ObjectValueRender();
        kdtEntrys_coupleNational_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("coupleNational").setRenderer(kdtEntrys_coupleNational_OVR);
        KDTextField kdtEntrys_coupleWorkPlace_TextField = new KDTextField();
        kdtEntrys_coupleWorkPlace_TextField.setName("kdtEntrys_coupleWorkPlace_TextField");
        kdtEntrys_coupleWorkPlace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coupleWorkPlace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coupleWorkPlace_TextField);
        this.kdtEntrys.getColumn("coupleWorkPlace").setEditor(kdtEntrys_coupleWorkPlace_CellEditor);
        KDTextField kdtEntrys_contactway_TextField = new KDTextField();
        kdtEntrys_contactway_TextField.setName("kdtEntrys_contactway_TextField");
        kdtEntrys_contactway_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_contactway_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contactway_TextField);
        this.kdtEntrys.getColumn("contactway").setEditor(kdtEntrys_contactway_CellEditor);
        KDTextField kdtEntrys_residence_TextField = new KDTextField();
        kdtEntrys_residence_TextField.setName("kdtEntrys_residence_TextField");
        kdtEntrys_residence_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_residence_CellEditor = new KDTDefaultCellEditor(kdtEntrys_residence_TextField);
        this.kdtEntrys.getColumn("residence").setEditor(kdtEntrys_residence_CellEditor);
        KDTextField kdtEntrys_oldPassport_TextField = new KDTextField();
        kdtEntrys_oldPassport_TextField.setName("kdtEntrys_oldPassport_TextField");
        kdtEntrys_oldPassport_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_oldPassport_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oldPassport_TextField);
        this.kdtEntrys.getColumn("oldPassport").setEditor(kdtEntrys_oldPassport_CellEditor);
        KDComboBox kdtEntrys_personState_ComboBox = new KDComboBox();
        kdtEntrys_personState_ComboBox.setName("kdtEntrys_personState_ComboBox");
        kdtEntrys_personState_ComboBox.setVisible(true);
        kdtEntrys_personState_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_personState_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personState_ComboBox);
        this.kdtEntrys.getColumn("personState").setEditor(kdtEntrys_personState_CellEditor);
        KDCheckBox kdtEntrys_isPush_CheckBox = new KDCheckBox();
        kdtEntrys_isPush_CheckBox.setName("kdtEntrys_isPush_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isPush_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isPush_CheckBox);
        this.kdtEntrys.getColumn("isPush").setEditor(kdtEntrys_isPush_CellEditor);
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
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);
        // contbillState		
        this.contbillState.setBoundLabelText(resHelper.getString("contbillState.boundLabelText"));		
        this.contbillState.setBoundLabelLength(100);		
        this.contbillState.setBoundLabelUnderline(true);		
        this.contbillState.setVisible(true);
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
        // billState		
        this.billState.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billState.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkauditDate,billState,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1155, 494));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1155, 494));
        contCreator.setBounds(new Rectangle(8, 463, 226, 19));
        this.add(contCreator, new KDLayout.Constraints(8, 463, 226, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(307, 463, 226, 19));
        this.add(contCreateTime, new KDLayout.Constraints(307, 463, 226, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(248, 463, 8, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(248, 463, 8, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(498, 463, 9, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(498, 463, 9, 19, 0));
        contNumber.setBounds(new Rectangle(20, 11, 237, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 11, 237, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(308, 11, 237, 19));
        this.add(contBizDate, new KDLayout.Constraints(308, 11, 237, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(886, 11, 237, 19));
        this.add(contDescription, new KDLayout.Constraints(886, 11, 237, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(606, 463, 226, 19));
        this.add(contAuditor, new KDLayout.Constraints(606, 463, 226, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(9, 37, 1140, 416));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.certificates.AntiLogoutEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(9, 37, 1140, 416, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("sex",new Integer(1));
vo.put("logoutType","0");
vo.put("passportAgency","10");
vo.put("MaritalStatus","0");
vo.put("authType","0");
vo.put("personState","10");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contauditDate.setBounds(new Rectangle(906, 463, 226, 19));
        this.add(contauditDate, new KDLayout.Constraints(906, 463, 226, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillState.setBounds(new Rectangle(596, 11, 237, 19));
        this.add(contbillState, new KDLayout.Constraints(596, 11, 237, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbillState
        contbillState.setBoundEditor(billState);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.certificates.AntiLogoutEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.name", String.class, this.kdtEntrys, "name.text");
		dataBinder.registerBinding("entrys.IdNum", String.class, this.kdtEntrys, "IdNum.text");
		dataBinder.registerBinding("entrys.passpNum", String.class, this.kdtEntrys, "passpNum.text");
		dataBinder.registerBinding("entrys.subDate", java.util.Date.class, this.kdtEntrys, "subDate.text");
		dataBinder.registerBinding("entrys.logoutDate", java.util.Date.class, this.kdtEntrys, "logoutDate.text");
		dataBinder.registerBinding("entrys.quProf", java.lang.Object.class, this.kdtEntrys, "quProf.text");
		dataBinder.registerBinding("entrys.sourceEntryID", String.class, this.kdtEntrys, "sourceEntryID.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.logoutType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "logoutType.text");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.sex", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "sex.text");
		dataBinder.registerBinding("entrys.birthDate", java.util.Date.class, this.kdtEntrys, "birthDate.text");
		dataBinder.registerBinding("entrys.nation", java.lang.Object.class, this.kdtEntrys, "nation.text");
		dataBinder.registerBinding("entrys.pmtProfFr", String.class, this.kdtEntrys, "pmtProfFr.text");
		dataBinder.registerBinding("entrys.laborSignNo", String.class, this.kdtEntrys, "laborSignNo.text");
		dataBinder.registerBinding("entrys.antiSgTime", java.util.Date.class, this.kdtEntrys, "antiSgTime.text");
		dataBinder.registerBinding("entrys.docAffiliatedD", boolean.class, this.kdtEntrys, "docAffiliatedD.text");
		dataBinder.registerBinding("entrys.permitProgram", java.lang.Object.class, this.kdtEntrys, "permitProgram.text");
		dataBinder.registerBinding("entrys.workProgram", java.lang.Object.class, this.kdtEntrys, "workProgram.text");
		dataBinder.registerBinding("entrys.cooperation", java.lang.Object.class, this.kdtEntrys, "cooperation.text");
		dataBinder.registerBinding("entrys.signNum", String.class, this.kdtEntrys, "signNum.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.birthPlaceFr", String.class, this.kdtEntrys, "birthPlaceFr.text");
		dataBinder.registerBinding("entrys.passportIDate", java.util.Date.class, this.kdtEntrys, "passportIDate.text");
		dataBinder.registerBinding("entrys.passportEDate", java.util.Date.class, this.kdtEntrys, "passportEDate.text");
		dataBinder.registerBinding("entrys.passportAgency", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "passportAgency.text");
		dataBinder.registerBinding("entrys.passportCity", java.lang.Object.class, this.kdtEntrys, "passportCity.text");
		dataBinder.registerBinding("entrys.passportCityF", String.class, this.kdtEntrys, "passportCityF.text");
		dataBinder.registerBinding("entrys.fatherName", String.class, this.kdtEntrys, "fatherName.text");
		dataBinder.registerBinding("entrys.fatherNameAlphabet", String.class, this.kdtEntrys, "fatherNameAlphabet.text");
		dataBinder.registerBinding("entrys.motherName", String.class, this.kdtEntrys, "motherName.text");
		dataBinder.registerBinding("entrys.motherNameAlphabet", String.class, this.kdtEntrys, "motherNameAlphabet.text");
		dataBinder.registerBinding("entrys.MaritalStatus", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "MaritalStatus.text");
		dataBinder.registerBinding("entrys.assignDate", java.util.Date.class, this.kdtEntrys, "assignDate.text");
		dataBinder.registerBinding("entrys.sendLaBuDate", java.util.Date.class, this.kdtEntrys, "sendLaBuDate.text");
		dataBinder.registerBinding("entrys.ownerSignDate", java.util.Date.class, this.kdtEntrys, "ownerSignDate.text");
		dataBinder.registerBinding("entrys.docUpDate", java.util.Date.class, this.kdtEntrys, "docUpDate.text");
		dataBinder.registerBinding("entrys.isLogout", boolean.class, this.kdtEntrys, "isLogout.text");
		dataBinder.registerBinding("entrys.logoutData", java.util.Date.class, this.kdtEntrys, "logoutData.text");
		dataBinder.registerBinding("entrys.logoutReson", String.class, this.kdtEntrys, "logoutReson.text");
		dataBinder.registerBinding("entrys.isCancel", boolean.class, this.kdtEntrys, "isCancel.text");
		dataBinder.registerBinding("entrys.cancelDate", java.util.Date.class, this.kdtEntrys, "cancelDate.text");
		dataBinder.registerBinding("entrys.cancelReson", String.class, this.kdtEntrys, "cancelReson.text");
		dataBinder.registerBinding("entrys.acProf", String.class, this.kdtEntrys, "acProf.text");
		dataBinder.registerBinding("entrys.authType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "authType.text");
		dataBinder.registerBinding("entrys.coupleName", String.class, this.kdtEntrys, "coupleName.text");
		dataBinder.registerBinding("entrys.coupleNameAlphabet", String.class, this.kdtEntrys, "coupleNameAlphabet.text");
		dataBinder.registerBinding("entrys.coupleBirthDate", java.util.Date.class, this.kdtEntrys, "coupleBirthDate.text");
		dataBinder.registerBinding("entrys.couplebirthPlace", String.class, this.kdtEntrys, "couplebirthPlace.text");
		dataBinder.registerBinding("entrys.coupleNational", java.lang.Object.class, this.kdtEntrys, "coupleNational.text");
		dataBinder.registerBinding("entrys.coupleWorkPlace", String.class, this.kdtEntrys, "coupleWorkPlace.text");
		dataBinder.registerBinding("entrys.contactway", String.class, this.kdtEntrys, "contactway.text");
		dataBinder.registerBinding("entrys.residence", String.class, this.kdtEntrys, "residence.text");
		dataBinder.registerBinding("entrys.oldPassport", String.class, this.kdtEntrys, "oldPassport.text");
		dataBinder.registerBinding("entrys.personState", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "personState.text");
		dataBinder.registerBinding("entrys.isPush", boolean.class, this.kdtEntrys, "isPush.text");
		dataBinder.registerBinding("entrys.antiEndTime", java.util.Date.class, this.kdtEntrys, "antiEndTime.text");
		dataBinder.registerBinding("entrys.birthplace", String.class, this.kdtEntrys, "birthplace.text");
		dataBinder.registerBinding("entrys.docAffiliate", boolean.class, this.kdtEntrys, "docAffiliate.text");
		dataBinder.registerBinding("entrys.copie", int.class, this.kdtEntrys, "copie.text");
		dataBinder.registerBinding("entrys.workSuffe", int.class, this.kdtEntrys, "workSuffe.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("billState", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billState, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.certificates.app.AntiLogoutEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.certificates.AntiLogoutInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.IdNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.subDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.logoutDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.quProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sourceEntryID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.logoutType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProfFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.laborSignNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.antiSgTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docAffiliatedD", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.permitProgram", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workProgram", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.signNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportIDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportEDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportAgency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCityF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.MaritalStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.assignDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendLaBuDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ownerSignDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docUpDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isLogout", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.logoutData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.logoutReson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isCancel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cancelDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cancelReson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.acProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.authType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleBirthDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.couplebirthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNational", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleWorkPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contactway", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.residence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oldPassport", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isPush", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.antiEndTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthplace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docAffiliate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.copie", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workSuffe", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billState", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.passpNum"));
    	sic.add(new SelectorItemInfo("entrys.subDate"));
    	sic.add(new SelectorItemInfo("entrys.logoutDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.quProf.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.quProf.id"));
			sic.add(new SelectorItemInfo("entrys.quProf.name"));
        	sic.add(new SelectorItemInfo("entrys.quProf.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.sourceEntryID"));
    	sic.add(new SelectorItemInfo("entrys.personID"));
    	sic.add(new SelectorItemInfo("entrys.logoutType"));
    	sic.add(new SelectorItemInfo("entrys.lastName"));
    	sic.add(new SelectorItemInfo("entrys.firstName"));
    	sic.add(new SelectorItemInfo("entrys.sex"));
    	sic.add(new SelectorItemInfo("entrys.birthDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.nation.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.nation.id"));
			sic.add(new SelectorItemInfo("entrys.nation.name"));
        	sic.add(new SelectorItemInfo("entrys.nation.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.pmtProfFr"));
    	sic.add(new SelectorItemInfo("entrys.laborSignNo"));
    	sic.add(new SelectorItemInfo("entrys.antiSgTime"));
    	sic.add(new SelectorItemInfo("entrys.docAffiliatedD"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.permitProgram.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.permitProgram.id"));
			sic.add(new SelectorItemInfo("entrys.permitProgram.name"));
        	sic.add(new SelectorItemInfo("entrys.permitProgram.number"));
		}
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
    	sic.add(new SelectorItemInfo("entrys.signNum"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceFr"));
    	sic.add(new SelectorItemInfo("entrys.passportIDate"));
    	sic.add(new SelectorItemInfo("entrys.passportEDate"));
    	sic.add(new SelectorItemInfo("entrys.passportAgency"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.passportCity.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.passportCity.id"));
			sic.add(new SelectorItemInfo("entrys.passportCity.name"));
        	sic.add(new SelectorItemInfo("entrys.passportCity.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.passportCityF"));
    	sic.add(new SelectorItemInfo("entrys.fatherName"));
    	sic.add(new SelectorItemInfo("entrys.fatherNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.motherName"));
    	sic.add(new SelectorItemInfo("entrys.motherNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.MaritalStatus"));
    	sic.add(new SelectorItemInfo("entrys.assignDate"));
    	sic.add(new SelectorItemInfo("entrys.sendLaBuDate"));
    	sic.add(new SelectorItemInfo("entrys.ownerSignDate"));
    	sic.add(new SelectorItemInfo("entrys.docUpDate"));
    	sic.add(new SelectorItemInfo("entrys.isLogout"));
    	sic.add(new SelectorItemInfo("entrys.logoutData"));
    	sic.add(new SelectorItemInfo("entrys.logoutReson"));
    	sic.add(new SelectorItemInfo("entrys.isCancel"));
    	sic.add(new SelectorItemInfo("entrys.cancelDate"));
    	sic.add(new SelectorItemInfo("entrys.cancelReson"));
    	sic.add(new SelectorItemInfo("entrys.acProf"));
    	sic.add(new SelectorItemInfo("entrys.authType"));
    	sic.add(new SelectorItemInfo("entrys.coupleName"));
    	sic.add(new SelectorItemInfo("entrys.coupleNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.coupleBirthDate"));
    	sic.add(new SelectorItemInfo("entrys.couplebirthPlace"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.coupleNational.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.coupleNational.id"));
			sic.add(new SelectorItemInfo("entrys.coupleNational.name"));
        	sic.add(new SelectorItemInfo("entrys.coupleNational.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.coupleWorkPlace"));
    	sic.add(new SelectorItemInfo("entrys.contactway"));
    	sic.add(new SelectorItemInfo("entrys.residence"));
    	sic.add(new SelectorItemInfo("entrys.oldPassport"));
    	sic.add(new SelectorItemInfo("entrys.personState"));
    	sic.add(new SelectorItemInfo("entrys.isPush"));
    	sic.add(new SelectorItemInfo("entrys.antiEndTime"));
    	sic.add(new SelectorItemInfo("entrys.birthplace"));
    	sic.add(new SelectorItemInfo("entrys.docAffiliate"));
    	sic.add(new SelectorItemInfo("entrys.copie"));
    	sic.add(new SelectorItemInfo("entrys.workSuffe"));
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
        sic.add(new SelectorItemInfo("billState"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.certificates.client", "AntiLogoutEditUI");
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
        return com.kingdee.eas.zjlw.certificates.client.AntiLogoutEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.AntiLogoutFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.AntiLogoutInfo objectValue = new com.kingdee.eas.zjlw.certificates.AntiLogoutInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/certificates/AntiLogout";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.certificates.app.AntiLogoutQuery");
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
		vo.put("billState","10");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}