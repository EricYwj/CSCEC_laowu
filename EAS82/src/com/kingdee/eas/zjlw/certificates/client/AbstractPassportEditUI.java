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
public abstract class AbstractPassportEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPassportEditUI.class);
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
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.eas.zjlw.certificates.PassportInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPassportEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPassportEditUI.class.getName());
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
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol31\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol32\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol33\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol38\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol41\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol42\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol45\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol46\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol47\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol48\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol49\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol50\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol51\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol52\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol53\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol54\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol55\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol56\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol57\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol58\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol59\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol60\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol61\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol62\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol63\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol64\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol65\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol66\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol67\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol68\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol69\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"nation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"passpNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"passportExpireDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"veTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"qualDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"applyDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"tickeTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"AffpersonTicket\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isCancel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cancelDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"cancelReson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isEmbassyReg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"permitProgram\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workProgram\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cooperation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"contactway\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"residence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IdNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"send\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"oldPassport\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"birthPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"birthPlaceFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"passportIDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"passportAgency\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"passportCity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"passportCityF\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"workSuffer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"pmtProfC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"pmtProfFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"fatherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"fatherNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"motherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"motherNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"MaritalStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"laborVisaNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"antiSgTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"docUpDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"docAffiliated\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"VisaReceiveTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"VisaDeliveTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"VisaprocessTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"VisaNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"vsTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol49\" /><t:Column t:key=\"signNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol50\" /><t:Column t:key=\"authType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"copies\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol52\" /><t:Column t:key=\"coupleName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol53\" /><t:Column t:key=\"coupleNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol54\" /><t:Column t:key=\"coupleBirthDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol55\" /><t:Column t:key=\"couplebirthPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol56\" /><t:Column t:key=\"coupleNational\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol57\" /><t:Column t:key=\"coupleWorkPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol58\" /><t:Column t:key=\"acProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol59\" /><t:Column t:key=\"contDepart\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol60\" /><t:Column t:key=\"contSTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol61\" /><t:Column t:key=\"contOtime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /><t:Column t:key=\"ifbuyInsure\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol63\" /><t:Column t:key=\"isHand\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol64\" /><t:Column t:key=\"ifUnexpect\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol65\" /><t:Column t:key=\"personState\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol66\" /><t:Column t:key=\"isPush\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol67\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol68\" /><t:Column t:key=\"sourceEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol69\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{birthDate}</t:Cell><t:Cell>$Resource{nation}</t:Cell><t:Cell>$Resource{passpNum}</t:Cell><t:Cell>$Resource{passportExpireDate}</t:Cell><t:Cell>$Resource{veTime}</t:Cell><t:Cell>$Resource{qualDate}</t:Cell><t:Cell>$Resource{applyDate}</t:Cell><t:Cell>$Resource{tickeTime}</t:Cell><t:Cell>$Resource{AffpersonTicket}</t:Cell><t:Cell>$Resource{isCancel}</t:Cell><t:Cell>$Resource{cancelDate}</t:Cell><t:Cell>$Resource{cancelReson}</t:Cell><t:Cell>$Resource{isEmbassyReg}</t:Cell><t:Cell>$Resource{permitProgram}</t:Cell><t:Cell>$Resource{workProgram}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{contactway}</t:Cell><t:Cell>$Resource{residence}</t:Cell><t:Cell>$Resource{IdNum}</t:Cell><t:Cell>$Resource{send}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{oldPassport}</t:Cell><t:Cell>$Resource{birthPlace}</t:Cell><t:Cell>$Resource{birthPlaceFr}</t:Cell><t:Cell>$Resource{passportIDate}</t:Cell><t:Cell>$Resource{passportAgency}</t:Cell><t:Cell>$Resource{passportCity}</t:Cell><t:Cell>$Resource{passportCityF}</t:Cell><t:Cell>$Resource{workSuffer}</t:Cell><t:Cell>$Resource{pmtProfC}</t:Cell><t:Cell>$Resource{pmtProfFr}</t:Cell><t:Cell>$Resource{fatherName}</t:Cell><t:Cell>$Resource{fatherNameAlphabet}</t:Cell><t:Cell>$Resource{motherName}</t:Cell><t:Cell>$Resource{motherNameAlphabet}</t:Cell><t:Cell>$Resource{MaritalStatus}</t:Cell><t:Cell>$Resource{laborVisaNo}</t:Cell><t:Cell>$Resource{antiSgTime}</t:Cell><t:Cell>$Resource{docUpDate}</t:Cell><t:Cell>$Resource{docAffiliated}</t:Cell><t:Cell>$Resource{VisaReceiveTime}</t:Cell><t:Cell>$Resource{VisaDeliveTime}</t:Cell><t:Cell>$Resource{VisaprocessTime}</t:Cell><t:Cell>$Resource{VisaNum}</t:Cell><t:Cell>$Resource{vsTime}</t:Cell><t:Cell>$Resource{signNum}</t:Cell><t:Cell>$Resource{authType}</t:Cell><t:Cell>$Resource{copies}</t:Cell><t:Cell>$Resource{coupleName}</t:Cell><t:Cell>$Resource{coupleNameAlphabet}</t:Cell><t:Cell>$Resource{coupleBirthDate}</t:Cell><t:Cell>$Resource{couplebirthPlace}</t:Cell><t:Cell>$Resource{coupleNational}</t:Cell><t:Cell>$Resource{coupleWorkPlace}</t:Cell><t:Cell>$Resource{acProf}</t:Cell><t:Cell>$Resource{contDepart}</t:Cell><t:Cell>$Resource{contSTime}</t:Cell><t:Cell>$Resource{contOtime}</t:Cell><t:Cell>$Resource{ifbuyInsure}</t:Cell><t:Cell>$Resource{isHand}</t:Cell><t:Cell>$Resource{ifUnexpect}</t:Cell><t:Cell>$Resource{personState}</t:Cell><t:Cell>$Resource{isPush}</t:Cell><t:Cell>$Resource{personID}</t:Cell><t:Cell>$Resource{sourceEntryID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","name","lastName","firstName","sex","birthDate","nation","passpNum","passportExpireDate","veTime","qualDate","applyDate","tickeTime","AffpersonTicket","isCancel","cancelDate","cancelReson","isEmbassyReg","permitProgram","workProgram","cooperation","contactway","residence","IdNum","send","remark","oldPassport","birthPlace","birthPlaceFr","passportIDate","passportAgency","passportCity","passportCityF","workSuffer","pmtProfC","pmtProfFr","fatherName","fatherNameAlphabet","motherName","motherNameAlphabet","MaritalStatus","laborVisaNo","antiSgTime","docUpDate","docAffiliated","VisaReceiveTime","VisaDeliveTime","VisaprocessTime","VisaNum","vsTime","signNum","authType","copies","coupleName","coupleNameAlphabet","coupleBirthDate","couplebirthPlace","coupleNational","coupleWorkPlace","acProf","contDepart","contSTime","contOtime","ifbuyInsure","isHand","ifUnexpect","personState","isPush","personID","sourceEntryID"});


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
        KDDatePicker kdtEntrys_passportExpireDate_DatePicker = new KDDatePicker();
        kdtEntrys_passportExpireDate_DatePicker.setName("kdtEntrys_passportExpireDate_DatePicker");
        kdtEntrys_passportExpireDate_DatePicker.setVisible(true);
        kdtEntrys_passportExpireDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passportExpireDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportExpireDate_DatePicker);
        this.kdtEntrys.getColumn("passportExpireDate").setEditor(kdtEntrys_passportExpireDate_CellEditor);
        KDDatePicker kdtEntrys_veTime_DatePicker = new KDDatePicker();
        kdtEntrys_veTime_DatePicker.setName("kdtEntrys_veTime_DatePicker");
        kdtEntrys_veTime_DatePicker.setVisible(true);
        kdtEntrys_veTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_veTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_veTime_DatePicker);
        this.kdtEntrys.getColumn("veTime").setEditor(kdtEntrys_veTime_CellEditor);
        KDDatePicker kdtEntrys_qualDate_DatePicker = new KDDatePicker();
        kdtEntrys_qualDate_DatePicker.setName("kdtEntrys_qualDate_DatePicker");
        kdtEntrys_qualDate_DatePicker.setVisible(true);
        kdtEntrys_qualDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_qualDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qualDate_DatePicker);
        this.kdtEntrys.getColumn("qualDate").setEditor(kdtEntrys_qualDate_CellEditor);
        KDDatePicker kdtEntrys_applyDate_DatePicker = new KDDatePicker();
        kdtEntrys_applyDate_DatePicker.setName("kdtEntrys_applyDate_DatePicker");
        kdtEntrys_applyDate_DatePicker.setVisible(true);
        kdtEntrys_applyDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_applyDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_applyDate_DatePicker);
        this.kdtEntrys.getColumn("applyDate").setEditor(kdtEntrys_applyDate_CellEditor);
        KDDatePicker kdtEntrys_tickeTime_DatePicker = new KDDatePicker();
        kdtEntrys_tickeTime_DatePicker.setName("kdtEntrys_tickeTime_DatePicker");
        kdtEntrys_tickeTime_DatePicker.setVisible(true);
        kdtEntrys_tickeTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_tickeTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_tickeTime_DatePicker);
        this.kdtEntrys.getColumn("tickeTime").setEditor(kdtEntrys_tickeTime_CellEditor);
        KDCheckBox kdtEntrys_AffpersonTicket_CheckBox = new KDCheckBox();
        kdtEntrys_AffpersonTicket_CheckBox.setName("kdtEntrys_AffpersonTicket_CheckBox");
        KDTDefaultCellEditor kdtEntrys_AffpersonTicket_CellEditor = new KDTDefaultCellEditor(kdtEntrys_AffpersonTicket_CheckBox);
        this.kdtEntrys.getColumn("AffpersonTicket").setEditor(kdtEntrys_AffpersonTicket_CellEditor);
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
        KDCheckBox kdtEntrys_isEmbassyReg_CheckBox = new KDCheckBox();
        kdtEntrys_isEmbassyReg_CheckBox.setName("kdtEntrys_isEmbassyReg_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isEmbassyReg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isEmbassyReg_CheckBox);
        this.kdtEntrys.getColumn("isEmbassyReg").setEditor(kdtEntrys_isEmbassyReg_CellEditor);
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
        KDTextField kdtEntrys_IdNum_TextField = new KDTextField();
        kdtEntrys_IdNum_TextField.setName("kdtEntrys_IdNum_TextField");
        kdtEntrys_IdNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_IdNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IdNum_TextField);
        this.kdtEntrys.getColumn("IdNum").setEditor(kdtEntrys_IdNum_CellEditor);
        KDCheckBox kdtEntrys_send_CheckBox = new KDCheckBox();
        kdtEntrys_send_CheckBox.setName("kdtEntrys_send_CheckBox");
        KDTDefaultCellEditor kdtEntrys_send_CellEditor = new KDTDefaultCellEditor(kdtEntrys_send_CheckBox);
        this.kdtEntrys.getColumn("send").setEditor(kdtEntrys_send_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        KDTextField kdtEntrys_oldPassport_TextField = new KDTextField();
        kdtEntrys_oldPassport_TextField.setName("kdtEntrys_oldPassport_TextField");
        kdtEntrys_oldPassport_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_oldPassport_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oldPassport_TextField);
        this.kdtEntrys.getColumn("oldPassport").setEditor(kdtEntrys_oldPassport_CellEditor);
        KDTextField kdtEntrys_birthPlace_TextField = new KDTextField();
        kdtEntrys_birthPlace_TextField.setName("kdtEntrys_birthPlace_TextField");
        kdtEntrys_birthPlace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_birthPlace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthPlace_TextField);
        this.kdtEntrys.getColumn("birthPlace").setEditor(kdtEntrys_birthPlace_CellEditor);
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
        KDTextField kdtEntrys_workSuffer_TextField = new KDTextField();
        kdtEntrys_workSuffer_TextField.setName("kdtEntrys_workSuffer_TextField");
        kdtEntrys_workSuffer_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_workSuffer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workSuffer_TextField);
        this.kdtEntrys.getColumn("workSuffer").setEditor(kdtEntrys_workSuffer_CellEditor);
        final KDBizPromptBox kdtEntrys_pmtProfC_PromptBox = new KDBizPromptBox();
        kdtEntrys_pmtProfC_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_pmtProfC_PromptBox.setVisible(true);
        kdtEntrys_pmtProfC_PromptBox.setEditable(true);
        kdtEntrys_pmtProfC_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_pmtProfC_PromptBox.setEditFormat("$number$");
        kdtEntrys_pmtProfC_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_pmtProfC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProfC_PromptBox);
        this.kdtEntrys.getColumn("pmtProfC").setEditor(kdtEntrys_pmtProfC_CellEditor);
        ObjectValueRender kdtEntrys_pmtProfC_OVR = new ObjectValueRender();
        kdtEntrys_pmtProfC_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("pmtProfC").setRenderer(kdtEntrys_pmtProfC_OVR);
        KDTextField kdtEntrys_pmtProfFr_TextField = new KDTextField();
        kdtEntrys_pmtProfFr_TextField.setName("kdtEntrys_pmtProfFr_TextField");
        kdtEntrys_pmtProfFr_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_pmtProfFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pmtProfFr_TextField);
        this.kdtEntrys.getColumn("pmtProfFr").setEditor(kdtEntrys_pmtProfFr_CellEditor);
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
        KDTextField kdtEntrys_laborVisaNo_TextField = new KDTextField();
        kdtEntrys_laborVisaNo_TextField.setName("kdtEntrys_laborVisaNo_TextField");
        kdtEntrys_laborVisaNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_laborVisaNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_laborVisaNo_TextField);
        this.kdtEntrys.getColumn("laborVisaNo").setEditor(kdtEntrys_laborVisaNo_CellEditor);
        KDDatePicker kdtEntrys_antiSgTime_DatePicker = new KDDatePicker();
        kdtEntrys_antiSgTime_DatePicker.setName("kdtEntrys_antiSgTime_DatePicker");
        kdtEntrys_antiSgTime_DatePicker.setVisible(true);
        kdtEntrys_antiSgTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_antiSgTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_antiSgTime_DatePicker);
        this.kdtEntrys.getColumn("antiSgTime").setEditor(kdtEntrys_antiSgTime_CellEditor);
        KDDatePicker kdtEntrys_docUpDate_DatePicker = new KDDatePicker();
        kdtEntrys_docUpDate_DatePicker.setName("kdtEntrys_docUpDate_DatePicker");
        kdtEntrys_docUpDate_DatePicker.setVisible(true);
        kdtEntrys_docUpDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_docUpDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docUpDate_DatePicker);
        this.kdtEntrys.getColumn("docUpDate").setEditor(kdtEntrys_docUpDate_CellEditor);
        KDTextField kdtEntrys_docAffiliated_TextField = new KDTextField();
        kdtEntrys_docAffiliated_TextField.setName("kdtEntrys_docAffiliated_TextField");
        kdtEntrys_docAffiliated_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_docAffiliated_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docAffiliated_TextField);
        this.kdtEntrys.getColumn("docAffiliated").setEditor(kdtEntrys_docAffiliated_CellEditor);
        KDDatePicker kdtEntrys_VisaReceiveTime_DatePicker = new KDDatePicker();
        kdtEntrys_VisaReceiveTime_DatePicker.setName("kdtEntrys_VisaReceiveTime_DatePicker");
        kdtEntrys_VisaReceiveTime_DatePicker.setVisible(true);
        kdtEntrys_VisaReceiveTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_VisaReceiveTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_VisaReceiveTime_DatePicker);
        this.kdtEntrys.getColumn("VisaReceiveTime").setEditor(kdtEntrys_VisaReceiveTime_CellEditor);
        KDDatePicker kdtEntrys_VisaDeliveTime_DatePicker = new KDDatePicker();
        kdtEntrys_VisaDeliveTime_DatePicker.setName("kdtEntrys_VisaDeliveTime_DatePicker");
        kdtEntrys_VisaDeliveTime_DatePicker.setVisible(true);
        kdtEntrys_VisaDeliveTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_VisaDeliveTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_VisaDeliveTime_DatePicker);
        this.kdtEntrys.getColumn("VisaDeliveTime").setEditor(kdtEntrys_VisaDeliveTime_CellEditor);
        KDDatePicker kdtEntrys_VisaprocessTime_DatePicker = new KDDatePicker();
        kdtEntrys_VisaprocessTime_DatePicker.setName("kdtEntrys_VisaprocessTime_DatePicker");
        kdtEntrys_VisaprocessTime_DatePicker.setVisible(true);
        kdtEntrys_VisaprocessTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_VisaprocessTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_VisaprocessTime_DatePicker);
        this.kdtEntrys.getColumn("VisaprocessTime").setEditor(kdtEntrys_VisaprocessTime_CellEditor);
        KDTextField kdtEntrys_VisaNum_TextField = new KDTextField();
        kdtEntrys_VisaNum_TextField.setName("kdtEntrys_VisaNum_TextField");
        kdtEntrys_VisaNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_VisaNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_VisaNum_TextField);
        this.kdtEntrys.getColumn("VisaNum").setEditor(kdtEntrys_VisaNum_CellEditor);
        KDDatePicker kdtEntrys_vsTime_DatePicker = new KDDatePicker();
        kdtEntrys_vsTime_DatePicker.setName("kdtEntrys_vsTime_DatePicker");
        kdtEntrys_vsTime_DatePicker.setVisible(true);
        kdtEntrys_vsTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_vsTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vsTime_DatePicker);
        this.kdtEntrys.getColumn("vsTime").setEditor(kdtEntrys_vsTime_CellEditor);
        KDTextField kdtEntrys_signNum_TextField = new KDTextField();
        kdtEntrys_signNum_TextField.setName("kdtEntrys_signNum_TextField");
        kdtEntrys_signNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_signNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_signNum_TextField);
        this.kdtEntrys.getColumn("signNum").setEditor(kdtEntrys_signNum_CellEditor);
        KDComboBox kdtEntrys_authType_ComboBox = new KDComboBox();
        kdtEntrys_authType_ComboBox.setName("kdtEntrys_authType_ComboBox");
        kdtEntrys_authType_ComboBox.setVisible(true);
        kdtEntrys_authType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.authType").toArray());
        KDTDefaultCellEditor kdtEntrys_authType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_authType_ComboBox);
        this.kdtEntrys.getColumn("authType").setEditor(kdtEntrys_authType_CellEditor);
        KDTextField kdtEntrys_copies_TextField = new KDTextField();
        kdtEntrys_copies_TextField.setName("kdtEntrys_copies_TextField");
        kdtEntrys_copies_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_copies_CellEditor = new KDTDefaultCellEditor(kdtEntrys_copies_TextField);
        this.kdtEntrys.getColumn("copies").setEditor(kdtEntrys_copies_CellEditor);
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
        KDTextField kdtEntrys_acProf_TextField = new KDTextField();
        kdtEntrys_acProf_TextField.setName("kdtEntrys_acProf_TextField");
        kdtEntrys_acProf_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_acProf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_acProf_TextField);
        this.kdtEntrys.getColumn("acProf").setEditor(kdtEntrys_acProf_CellEditor);
        KDTextField kdtEntrys_contDepart_TextField = new KDTextField();
        kdtEntrys_contDepart_TextField.setName("kdtEntrys_contDepart_TextField");
        kdtEntrys_contDepart_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_contDepart_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contDepart_TextField);
        this.kdtEntrys.getColumn("contDepart").setEditor(kdtEntrys_contDepart_CellEditor);
        KDDatePicker kdtEntrys_contSTime_DatePicker = new KDDatePicker();
        kdtEntrys_contSTime_DatePicker.setName("kdtEntrys_contSTime_DatePicker");
        kdtEntrys_contSTime_DatePicker.setVisible(true);
        kdtEntrys_contSTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_contSTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contSTime_DatePicker);
        this.kdtEntrys.getColumn("contSTime").setEditor(kdtEntrys_contSTime_CellEditor);
        KDDatePicker kdtEntrys_contOtime_DatePicker = new KDDatePicker();
        kdtEntrys_contOtime_DatePicker.setName("kdtEntrys_contOtime_DatePicker");
        kdtEntrys_contOtime_DatePicker.setVisible(true);
        kdtEntrys_contOtime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_contOtime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contOtime_DatePicker);
        this.kdtEntrys.getColumn("contOtime").setEditor(kdtEntrys_contOtime_CellEditor);
        KDCheckBox kdtEntrys_ifbuyInsure_CheckBox = new KDCheckBox();
        kdtEntrys_ifbuyInsure_CheckBox.setName("kdtEntrys_ifbuyInsure_CheckBox");
        KDTDefaultCellEditor kdtEntrys_ifbuyInsure_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ifbuyInsure_CheckBox);
        this.kdtEntrys.getColumn("ifbuyInsure").setEditor(kdtEntrys_ifbuyInsure_CellEditor);
        KDCheckBox kdtEntrys_isHand_CheckBox = new KDCheckBox();
        kdtEntrys_isHand_CheckBox.setName("kdtEntrys_isHand_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isHand_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isHand_CheckBox);
        this.kdtEntrys.getColumn("isHand").setEditor(kdtEntrys_isHand_CellEditor);
        KDTextField kdtEntrys_ifUnexpect_TextField = new KDTextField();
        kdtEntrys_ifUnexpect_TextField.setName("kdtEntrys_ifUnexpect_TextField");
        kdtEntrys_ifUnexpect_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_ifUnexpect_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ifUnexpect_TextField);
        this.kdtEntrys.getColumn("ifUnexpect").setEditor(kdtEntrys_ifUnexpect_CellEditor);
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
        KDTextField kdtEntrys_personID_TextField = new KDTextField();
        kdtEntrys_personID_TextField.setName("kdtEntrys_personID_TextField");
        kdtEntrys_personID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_personID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personID_TextField);
        this.kdtEntrys.getColumn("personID").setEditor(kdtEntrys_personID_CellEditor);
        KDTextField kdtEntrys_sourceEntryID_TextField = new KDTextField();
        kdtEntrys_sourceEntryID_TextField.setName("kdtEntrys_sourceEntryID_TextField");
        kdtEntrys_sourceEntryID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_sourceEntryID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sourceEntryID_TextField);
        this.kdtEntrys.getColumn("sourceEntryID").setEditor(kdtEntrys_sourceEntryID_CellEditor);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 498));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(291, 462, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(572, 462, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(931, 464, 28, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(854, 462, 45, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(19, 7, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(314, 6, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(649, 11, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(9, 462, 270, 19));
        this.add(contAuditor, null);
        kdtEntrys.setBounds(new Rectangle(6, 39, 991, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.certificates.PassportEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, null);
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("sex",new Integer(1));
vo.put("passportAgency","10");
vo.put("MaritalStatus","0");
vo.put("authType","0");
vo.put("personState","10");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.certificates.PassportEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.name", String.class, this.kdtEntrys, "name.text");
		dataBinder.registerBinding("entrys.IdNum", String.class, this.kdtEntrys, "IdNum.text");
		dataBinder.registerBinding("entrys.passpNum", String.class, this.kdtEntrys, "passpNum.text");
		dataBinder.registerBinding("entrys.send", boolean.class, this.kdtEntrys, "send.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.sourceEntryID", String.class, this.kdtEntrys, "sourceEntryID.text");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.sex", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "sex.text");
		dataBinder.registerBinding("entrys.birthDate", java.util.Date.class, this.kdtEntrys, "birthDate.text");
		dataBinder.registerBinding("entrys.nation", java.lang.Object.class, this.kdtEntrys, "nation.text");
		dataBinder.registerBinding("entrys.passportExpireDate", java.util.Date.class, this.kdtEntrys, "passportExpireDate.text");
		dataBinder.registerBinding("entrys.veTime", java.util.Date.class, this.kdtEntrys, "veTime.text");
		dataBinder.registerBinding("entrys.qualDate", java.util.Date.class, this.kdtEntrys, "qualDate.text");
		dataBinder.registerBinding("entrys.applyDate", java.util.Date.class, this.kdtEntrys, "applyDate.text");
		dataBinder.registerBinding("entrys.tickeTime", java.util.Date.class, this.kdtEntrys, "tickeTime.text");
		dataBinder.registerBinding("entrys.AffpersonTicket", boolean.class, this.kdtEntrys, "AffpersonTicket.text");
		dataBinder.registerBinding("entrys.isCancel", boolean.class, this.kdtEntrys, "isCancel.text");
		dataBinder.registerBinding("entrys.cancelDate", java.util.Date.class, this.kdtEntrys, "cancelDate.text");
		dataBinder.registerBinding("entrys.cancelReson", String.class, this.kdtEntrys, "cancelReson.text");
		dataBinder.registerBinding("entrys.isEmbassyReg", boolean.class, this.kdtEntrys, "isEmbassyReg.text");
		dataBinder.registerBinding("entrys.permitProgram", java.lang.Object.class, this.kdtEntrys, "permitProgram.text");
		dataBinder.registerBinding("entrys.workProgram", java.lang.Object.class, this.kdtEntrys, "workProgram.text");
		dataBinder.registerBinding("entrys.cooperation", java.lang.Object.class, this.kdtEntrys, "cooperation.text");
		dataBinder.registerBinding("entrys.contactway", String.class, this.kdtEntrys, "contactway.text");
		dataBinder.registerBinding("entrys.residence", String.class, this.kdtEntrys, "residence.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.oldPassport", String.class, this.kdtEntrys, "oldPassport.text");
		dataBinder.registerBinding("entrys.birthPlace", String.class, this.kdtEntrys, "birthPlace.text");
		dataBinder.registerBinding("entrys.birthPlaceFr", String.class, this.kdtEntrys, "birthPlaceFr.text");
		dataBinder.registerBinding("entrys.passportIDate", java.util.Date.class, this.kdtEntrys, "passportIDate.text");
		dataBinder.registerBinding("entrys.passportAgency", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "passportAgency.text");
		dataBinder.registerBinding("entrys.passportCity", java.lang.Object.class, this.kdtEntrys, "passportCity.text");
		dataBinder.registerBinding("entrys.passportCityF", String.class, this.kdtEntrys, "passportCityF.text");
		dataBinder.registerBinding("entrys.workSuffer", String.class, this.kdtEntrys, "workSuffer.text");
		dataBinder.registerBinding("entrys.pmtProfC", java.lang.Object.class, this.kdtEntrys, "pmtProfC.text");
		dataBinder.registerBinding("entrys.pmtProfFr", String.class, this.kdtEntrys, "pmtProfFr.text");
		dataBinder.registerBinding("entrys.fatherName", String.class, this.kdtEntrys, "fatherName.text");
		dataBinder.registerBinding("entrys.fatherNameAlphabet", String.class, this.kdtEntrys, "fatherNameAlphabet.text");
		dataBinder.registerBinding("entrys.motherName", String.class, this.kdtEntrys, "motherName.text");
		dataBinder.registerBinding("entrys.motherNameAlphabet", String.class, this.kdtEntrys, "motherNameAlphabet.text");
		dataBinder.registerBinding("entrys.MaritalStatus", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "MaritalStatus.text");
		dataBinder.registerBinding("entrys.laborVisaNo", String.class, this.kdtEntrys, "laborVisaNo.text");
		dataBinder.registerBinding("entrys.antiSgTime", java.util.Date.class, this.kdtEntrys, "antiSgTime.text");
		dataBinder.registerBinding("entrys.docUpDate", java.util.Date.class, this.kdtEntrys, "docUpDate.text");
		dataBinder.registerBinding("entrys.docAffiliated", String.class, this.kdtEntrys, "docAffiliated.text");
		dataBinder.registerBinding("entrys.VisaReceiveTime", java.util.Date.class, this.kdtEntrys, "VisaReceiveTime.text");
		dataBinder.registerBinding("entrys.VisaDeliveTime", java.util.Date.class, this.kdtEntrys, "VisaDeliveTime.text");
		dataBinder.registerBinding("entrys.VisaprocessTime", java.util.Date.class, this.kdtEntrys, "VisaprocessTime.text");
		dataBinder.registerBinding("entrys.VisaNum", String.class, this.kdtEntrys, "VisaNum.text");
		dataBinder.registerBinding("entrys.vsTime", java.util.Date.class, this.kdtEntrys, "vsTime.text");
		dataBinder.registerBinding("entrys.signNum", String.class, this.kdtEntrys, "signNum.text");
		dataBinder.registerBinding("entrys.authType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "authType.text");
		dataBinder.registerBinding("entrys.copies", String.class, this.kdtEntrys, "copies.text");
		dataBinder.registerBinding("entrys.coupleName", String.class, this.kdtEntrys, "coupleName.text");
		dataBinder.registerBinding("entrys.coupleNameAlphabet", String.class, this.kdtEntrys, "coupleNameAlphabet.text");
		dataBinder.registerBinding("entrys.coupleBirthDate", java.util.Date.class, this.kdtEntrys, "coupleBirthDate.text");
		dataBinder.registerBinding("entrys.couplebirthPlace", String.class, this.kdtEntrys, "couplebirthPlace.text");
		dataBinder.registerBinding("entrys.coupleNational", java.lang.Object.class, this.kdtEntrys, "coupleNational.text");
		dataBinder.registerBinding("entrys.coupleWorkPlace", String.class, this.kdtEntrys, "coupleWorkPlace.text");
		dataBinder.registerBinding("entrys.acProf", String.class, this.kdtEntrys, "acProf.text");
		dataBinder.registerBinding("entrys.contDepart", String.class, this.kdtEntrys, "contDepart.text");
		dataBinder.registerBinding("entrys.contSTime", java.util.Date.class, this.kdtEntrys, "contSTime.text");
		dataBinder.registerBinding("entrys.contOtime", java.util.Date.class, this.kdtEntrys, "contOtime.text");
		dataBinder.registerBinding("entrys.ifbuyInsure", boolean.class, this.kdtEntrys, "ifbuyInsure.text");
		dataBinder.registerBinding("entrys.isHand", boolean.class, this.kdtEntrys, "isHand.text");
		dataBinder.registerBinding("entrys.ifUnexpect", String.class, this.kdtEntrys, "ifUnexpect.text");
		dataBinder.registerBinding("entrys.personState", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "personState.text");
		dataBinder.registerBinding("entrys.isPush", boolean.class, this.kdtEntrys, "isPush.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.certificates.app.PassportEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.certificates.PassportInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.send", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sourceEntryID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportExpireDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.veTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qualDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.applyDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.tickeTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.AffpersonTicket", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isCancel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cancelDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cancelReson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isEmbassyReg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.permitProgram", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workProgram", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contactway", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.residence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oldPassport", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportIDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportAgency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCityF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workSuffer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProfC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProfFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.MaritalStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.laborVisaNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.antiSgTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docUpDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docAffiliated", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.VisaReceiveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.VisaDeliveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.VisaprocessTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.VisaNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vsTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.signNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.authType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.copies", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleBirthDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.couplebirthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNational", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleWorkPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.acProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contDepart", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contSTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contOtime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ifbuyInsure", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isHand", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ifUnexpect", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isPush", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.IdNum"));
    	sic.add(new SelectorItemInfo("entrys.passpNum"));
    	sic.add(new SelectorItemInfo("entrys.send"));
    	sic.add(new SelectorItemInfo("entrys.personID"));
    	sic.add(new SelectorItemInfo("entrys.sourceEntryID"));
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
    	sic.add(new SelectorItemInfo("entrys.passportExpireDate"));
    	sic.add(new SelectorItemInfo("entrys.veTime"));
    	sic.add(new SelectorItemInfo("entrys.qualDate"));
    	sic.add(new SelectorItemInfo("entrys.applyDate"));
    	sic.add(new SelectorItemInfo("entrys.tickeTime"));
    	sic.add(new SelectorItemInfo("entrys.AffpersonTicket"));
    	sic.add(new SelectorItemInfo("entrys.isCancel"));
    	sic.add(new SelectorItemInfo("entrys.cancelDate"));
    	sic.add(new SelectorItemInfo("entrys.cancelReson"));
    	sic.add(new SelectorItemInfo("entrys.isEmbassyReg"));
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
    	sic.add(new SelectorItemInfo("entrys.contactway"));
    	sic.add(new SelectorItemInfo("entrys.residence"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.oldPassport"));
    	sic.add(new SelectorItemInfo("entrys.birthPlace"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceFr"));
    	sic.add(new SelectorItemInfo("entrys.passportIDate"));
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
    	sic.add(new SelectorItemInfo("entrys.workSuffer"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.pmtProfC.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.pmtProfC.id"));
			sic.add(new SelectorItemInfo("entrys.pmtProfC.name"));
        	sic.add(new SelectorItemInfo("entrys.pmtProfC.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.pmtProfFr"));
    	sic.add(new SelectorItemInfo("entrys.fatherName"));
    	sic.add(new SelectorItemInfo("entrys.fatherNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.motherName"));
    	sic.add(new SelectorItemInfo("entrys.motherNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.MaritalStatus"));
    	sic.add(new SelectorItemInfo("entrys.laborVisaNo"));
    	sic.add(new SelectorItemInfo("entrys.antiSgTime"));
    	sic.add(new SelectorItemInfo("entrys.docUpDate"));
    	sic.add(new SelectorItemInfo("entrys.docAffiliated"));
    	sic.add(new SelectorItemInfo("entrys.VisaReceiveTime"));
    	sic.add(new SelectorItemInfo("entrys.VisaDeliveTime"));
    	sic.add(new SelectorItemInfo("entrys.VisaprocessTime"));
    	sic.add(new SelectorItemInfo("entrys.VisaNum"));
    	sic.add(new SelectorItemInfo("entrys.vsTime"));
    	sic.add(new SelectorItemInfo("entrys.signNum"));
    	sic.add(new SelectorItemInfo("entrys.authType"));
    	sic.add(new SelectorItemInfo("entrys.copies"));
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
    	sic.add(new SelectorItemInfo("entrys.acProf"));
    	sic.add(new SelectorItemInfo("entrys.contDepart"));
    	sic.add(new SelectorItemInfo("entrys.contSTime"));
    	sic.add(new SelectorItemInfo("entrys.contOtime"));
    	sic.add(new SelectorItemInfo("entrys.ifbuyInsure"));
    	sic.add(new SelectorItemInfo("entrys.isHand"));
    	sic.add(new SelectorItemInfo("entrys.ifUnexpect"));
    	sic.add(new SelectorItemInfo("entrys.personState"));
    	sic.add(new SelectorItemInfo("entrys.isPush"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.certificates.client", "PassportEditUI");
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
        return com.kingdee.eas.zjlw.certificates.client.PassportEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.PassportFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.PassportInfo objectValue = new com.kingdee.eas.zjlw.certificates.PassportInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/certificates/Passport";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.certificates.app.PassportQuery");
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}