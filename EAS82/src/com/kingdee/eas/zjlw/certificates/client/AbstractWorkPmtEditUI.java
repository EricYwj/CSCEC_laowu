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
public abstract class AbstractWorkPmtEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractWorkPmtEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillSate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbNum;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billSate;
    protected com.kingdee.eas.zjlw.certificates.WorkPmtInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractWorkPmtEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractWorkPmtEditUI.class.getName());
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
        this.contbNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillSate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.billSate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contbNum.setName("contbNum");
        this.contauditDate.setName("contauditDate");
        this.contbillSate.setName("contbillSate");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtbNum.setName("txtbNum");
        this.pkauditDate.setName("pkauditDate");
        this.billSate.setName("billSate");
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
        this.contNumber.setBoundLabelLength(70);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contNumber.setEnabled(false);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(60);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(70);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol21\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol22\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol25\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol26\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol27\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol31\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol44\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol46\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol47\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol48\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol49\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol51\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol52\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol53\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol54\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol55\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol56\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol57\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol58\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol59\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol60\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol61\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol62\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol63\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol64\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol65\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"sex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"birthday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"birthPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"birthPlaceFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"nation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"passpNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"passportIssueDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"passpExDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"passportAgence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"passportCityCC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"passportCityF\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"actProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"quProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"quprofF\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"workEXP\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"fatherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"fatherNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"motherName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"motherNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"MaritalStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"laborSignNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"docAffiliate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"VisaNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"veTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"vsTima\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"qualDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"authType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"immiTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"papSTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"pType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wPmtNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wPmtGTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"laboreffDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"wPmtSTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"sPAfPerson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"departure\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"leaveTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"isStop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"endTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"cancelReson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"pmtProj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"workOrg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cooperation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"oldPassport\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"dlyChkFrc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"IdNum\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol49\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sourceEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol52\" /><t:Column t:key=\"contactway\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol53\" /><t:Column t:key=\"residence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol54\" /><t:Column t:key=\"coupleName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol55\" /><t:Column t:key=\"coupleNameAlphabet\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol56\" /><t:Column t:key=\"coupleBirthDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol57\" /><t:Column t:key=\"couplebirthPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol58\" /><t:Column t:key=\"coupleNational\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol59\" /><t:Column t:key=\"coupleWorkPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol60\" /><t:Column t:key=\"isHand\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol61\" /><t:Column t:key=\"personState\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /><t:Column t:key=\"isPush\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol63\" /><t:Column t:key=\"copie\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol64\" /><t:Column t:key=\"isEmbassReg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol65\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{sex}</t:Cell><t:Cell>$Resource{birthday}</t:Cell><t:Cell>$Resource{birthPlace}</t:Cell><t:Cell>$Resource{birthPlaceFr}</t:Cell><t:Cell>$Resource{nation}</t:Cell><t:Cell>$Resource{passpNum}</t:Cell><t:Cell>$Resource{passportIssueDate}</t:Cell><t:Cell>$Resource{passpExDate}</t:Cell><t:Cell>$Resource{passportAgence}</t:Cell><t:Cell>$Resource{passportCityCC}</t:Cell><t:Cell>$Resource{passportCityF}</t:Cell><t:Cell>$Resource{actProf}</t:Cell><t:Cell>$Resource{quProf}</t:Cell><t:Cell>$Resource{quprofF}</t:Cell><t:Cell>$Resource{workEXP}</t:Cell><t:Cell>$Resource{fatherName}</t:Cell><t:Cell>$Resource{fatherNameAlphabet}</t:Cell><t:Cell>$Resource{motherName}</t:Cell><t:Cell>$Resource{motherNameAlphabet}</t:Cell><t:Cell>$Resource{MaritalStatus}</t:Cell><t:Cell>$Resource{laborSignNo}</t:Cell><t:Cell>$Resource{docAffiliate}</t:Cell><t:Cell>$Resource{VisaNum}</t:Cell><t:Cell>$Resource{veTime}</t:Cell><t:Cell>$Resource{vsTima}</t:Cell><t:Cell>$Resource{qualDate}</t:Cell><t:Cell>$Resource{authType}</t:Cell><t:Cell>$Resource{immiTime}</t:Cell><t:Cell>$Resource{papSTime}</t:Cell><t:Cell>$Resource{pType}</t:Cell><t:Cell>$Resource{wPmtNum}</t:Cell><t:Cell>$Resource{wPmtGTime}</t:Cell><t:Cell>$Resource{laboreffDate}</t:Cell><t:Cell>$Resource{wPmtSTime}</t:Cell><t:Cell>$Resource{sPAfPerson}</t:Cell><t:Cell>$Resource{departure}</t:Cell><t:Cell>$Resource{leaveTime}</t:Cell><t:Cell>$Resource{isStop}</t:Cell><t:Cell>$Resource{endTime}</t:Cell><t:Cell>$Resource{cancelReson}</t:Cell><t:Cell>$Resource{pmtProj}</t:Cell><t:Cell>$Resource{workOrg}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{oldPassport}</t:Cell><t:Cell>$Resource{dlyChkFrc}</t:Cell><t:Cell>$Resource{IdNum}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{sourceEntryID}</t:Cell><t:Cell>$Resource{personID}</t:Cell><t:Cell>$Resource{contactway}</t:Cell><t:Cell>$Resource{residence}</t:Cell><t:Cell>$Resource{coupleName}</t:Cell><t:Cell>$Resource{coupleNameAlphabet}</t:Cell><t:Cell>$Resource{coupleBirthDate}</t:Cell><t:Cell>$Resource{couplebirthPlace}</t:Cell><t:Cell>$Resource{coupleNational}</t:Cell><t:Cell>$Resource{coupleWorkPlace}</t:Cell><t:Cell>$Resource{isHand}</t:Cell><t:Cell>$Resource{personState}</t:Cell><t:Cell>$Resource{isPush}</t:Cell><t:Cell>$Resource{copie}</t:Cell><t:Cell>$Resource{isEmbassReg}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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

                this.kdtEntrys.putBindContents("editData",new String[] {"id","name","lastName","firstName","sex","birthday","birthPlace","birthPlaceFr","nation","passpNum","passportIssueDate","passpExDate","passportAgence","passportCityCC","passportCityF","actProf","quProf","quprofF","workEXP","fatherName","fatherNameAlphabet","motherName","motherNameAlphabet","MaritalStatus","laborSignNo","docAffiliate","VisaNum","veTime","vsTima","qualDate","authType","immiTime","papSTime","pType","wPmtNum","wPmtGTime","laboreffDate","wPmtSTime","sPAfPerson","departure","leaveTime","isStop","endTime","cancelReson","pmtProj","workOrg","cooperation","oldPassport","dlyChkFrc","IdNum","remark","sourceEntryID","personID","contactway","residence","coupleName","coupleNameAlphabet","coupleBirthDate","couplebirthPlace","coupleNational","coupleWorkPlace","isHand","personState","isPush","copie","isEmbassReg"});


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
        KDDatePicker kdtEntrys_birthday_DatePicker = new KDDatePicker();
        kdtEntrys_birthday_DatePicker.setName("kdtEntrys_birthday_DatePicker");
        kdtEntrys_birthday_DatePicker.setVisible(true);
        kdtEntrys_birthday_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_birthday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthday_DatePicker);
        this.kdtEntrys.getColumn("birthday").setEditor(kdtEntrys_birthday_CellEditor);
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
        KDDatePicker kdtEntrys_passportIssueDate_DatePicker = new KDDatePicker();
        kdtEntrys_passportIssueDate_DatePicker.setName("kdtEntrys_passportIssueDate_DatePicker");
        kdtEntrys_passportIssueDate_DatePicker.setVisible(true);
        kdtEntrys_passportIssueDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passportIssueDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportIssueDate_DatePicker);
        this.kdtEntrys.getColumn("passportIssueDate").setEditor(kdtEntrys_passportIssueDate_CellEditor);
        KDDatePicker kdtEntrys_passpExDate_DatePicker = new KDDatePicker();
        kdtEntrys_passpExDate_DatePicker.setName("kdtEntrys_passpExDate_DatePicker");
        kdtEntrys_passpExDate_DatePicker.setVisible(true);
        kdtEntrys_passpExDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_passpExDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passpExDate_DatePicker);
        this.kdtEntrys.getColumn("passpExDate").setEditor(kdtEntrys_passpExDate_CellEditor);
        KDComboBox kdtEntrys_passportAgence_ComboBox = new KDComboBox();
        kdtEntrys_passportAgence_ComboBox.setName("kdtEntrys_passportAgence_ComboBox");
        kdtEntrys_passportAgence_ComboBox.setVisible(true);
        kdtEntrys_passportAgence_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_passportAgence_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportAgence_ComboBox);
        this.kdtEntrys.getColumn("passportAgence").setEditor(kdtEntrys_passportAgence_CellEditor);
        final KDBizPromptBox kdtEntrys_passportCityCC_PromptBox = new KDBizPromptBox();
        kdtEntrys_passportCityCC_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");
        kdtEntrys_passportCityCC_PromptBox.setVisible(true);
        kdtEntrys_passportCityCC_PromptBox.setEditable(true);
        kdtEntrys_passportCityCC_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_passportCityCC_PromptBox.setEditFormat("$number$");
        kdtEntrys_passportCityCC_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_passportCityCC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportCityCC_PromptBox);
        this.kdtEntrys.getColumn("passportCityCC").setEditor(kdtEntrys_passportCityCC_CellEditor);
        ObjectValueRender kdtEntrys_passportCityCC_OVR = new ObjectValueRender();
        kdtEntrys_passportCityCC_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("passportCityCC").setRenderer(kdtEntrys_passportCityCC_OVR);
        KDTextField kdtEntrys_passportCityF_TextField = new KDTextField();
        kdtEntrys_passportCityF_TextField.setName("kdtEntrys_passportCityF_TextField");
        kdtEntrys_passportCityF_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_passportCityF_CellEditor = new KDTDefaultCellEditor(kdtEntrys_passportCityF_TextField);
        this.kdtEntrys.getColumn("passportCityF").setEditor(kdtEntrys_passportCityF_CellEditor);
        KDTextField kdtEntrys_actProf_TextField = new KDTextField();
        kdtEntrys_actProf_TextField.setName("kdtEntrys_actProf_TextField");
        kdtEntrys_actProf_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_actProf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actProf_TextField);
        this.kdtEntrys.getColumn("actProf").setEditor(kdtEntrys_actProf_CellEditor);
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
        KDTextField kdtEntrys_quprofF_TextField = new KDTextField();
        kdtEntrys_quprofF_TextField.setName("kdtEntrys_quprofF_TextField");
        kdtEntrys_quprofF_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_quprofF_CellEditor = new KDTDefaultCellEditor(kdtEntrys_quprofF_TextField);
        this.kdtEntrys.getColumn("quprofF").setEditor(kdtEntrys_quprofF_CellEditor);
        KDFormattedTextField kdtEntrys_workEXP_TextField = new KDFormattedTextField();
        kdtEntrys_workEXP_TextField.setName("kdtEntrys_workEXP_TextField");
        kdtEntrys_workEXP_TextField.setVisible(true);
        kdtEntrys_workEXP_TextField.setEditable(true);
        kdtEntrys_workEXP_TextField.setHorizontalAlignment(2);
        kdtEntrys_workEXP_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_workEXP_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workEXP_TextField);
        this.kdtEntrys.getColumn("workEXP").setEditor(kdtEntrys_workEXP_CellEditor);
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
        KDTextField kdtEntrys_laborSignNo_TextField = new KDTextField();
        kdtEntrys_laborSignNo_TextField.setName("kdtEntrys_laborSignNo_TextField");
        kdtEntrys_laborSignNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_laborSignNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_laborSignNo_TextField);
        this.kdtEntrys.getColumn("laborSignNo").setEditor(kdtEntrys_laborSignNo_CellEditor);
        KDCheckBox kdtEntrys_docAffiliate_CheckBox = new KDCheckBox();
        kdtEntrys_docAffiliate_CheckBox.setName("kdtEntrys_docAffiliate_CheckBox");
        KDTDefaultCellEditor kdtEntrys_docAffiliate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_docAffiliate_CheckBox);
        this.kdtEntrys.getColumn("docAffiliate").setEditor(kdtEntrys_docAffiliate_CellEditor);
        KDTextField kdtEntrys_VisaNum_TextField = new KDTextField();
        kdtEntrys_VisaNum_TextField.setName("kdtEntrys_VisaNum_TextField");
        kdtEntrys_VisaNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_VisaNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_VisaNum_TextField);
        this.kdtEntrys.getColumn("VisaNum").setEditor(kdtEntrys_VisaNum_CellEditor);
        KDDatePicker kdtEntrys_veTime_DatePicker = new KDDatePicker();
        kdtEntrys_veTime_DatePicker.setName("kdtEntrys_veTime_DatePicker");
        kdtEntrys_veTime_DatePicker.setVisible(true);
        kdtEntrys_veTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_veTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_veTime_DatePicker);
        this.kdtEntrys.getColumn("veTime").setEditor(kdtEntrys_veTime_CellEditor);
        KDDatePicker kdtEntrys_vsTima_DatePicker = new KDDatePicker();
        kdtEntrys_vsTima_DatePicker.setName("kdtEntrys_vsTima_DatePicker");
        kdtEntrys_vsTima_DatePicker.setVisible(true);
        kdtEntrys_vsTima_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_vsTima_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vsTima_DatePicker);
        this.kdtEntrys.getColumn("vsTima").setEditor(kdtEntrys_vsTima_CellEditor);
        KDDatePicker kdtEntrys_qualDate_DatePicker = new KDDatePicker();
        kdtEntrys_qualDate_DatePicker.setName("kdtEntrys_qualDate_DatePicker");
        kdtEntrys_qualDate_DatePicker.setVisible(true);
        kdtEntrys_qualDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_qualDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qualDate_DatePicker);
        this.kdtEntrys.getColumn("qualDate").setEditor(kdtEntrys_qualDate_CellEditor);
        KDComboBox kdtEntrys_authType_ComboBox = new KDComboBox();
        kdtEntrys_authType_ComboBox.setName("kdtEntrys_authType_ComboBox");
        kdtEntrys_authType_ComboBox.setVisible(true);
        kdtEntrys_authType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.authType").toArray());
        KDTDefaultCellEditor kdtEntrys_authType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_authType_ComboBox);
        this.kdtEntrys.getColumn("authType").setEditor(kdtEntrys_authType_CellEditor);
        KDDatePicker kdtEntrys_immiTime_DatePicker = new KDDatePicker();
        kdtEntrys_immiTime_DatePicker.setName("kdtEntrys_immiTime_DatePicker");
        kdtEntrys_immiTime_DatePicker.setVisible(true);
        kdtEntrys_immiTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_immiTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_immiTime_DatePicker);
        this.kdtEntrys.getColumn("immiTime").setEditor(kdtEntrys_immiTime_CellEditor);
        KDDatePicker kdtEntrys_papSTime_DatePicker = new KDDatePicker();
        kdtEntrys_papSTime_DatePicker.setName("kdtEntrys_papSTime_DatePicker");
        kdtEntrys_papSTime_DatePicker.setVisible(true);
        kdtEntrys_papSTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_papSTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_papSTime_DatePicker);
        this.kdtEntrys.getColumn("papSTime").setEditor(kdtEntrys_papSTime_CellEditor);
        KDComboBox kdtEntrys_pType_ComboBox = new KDComboBox();
        kdtEntrys_pType_ComboBox.setName("kdtEntrys_pType_ComboBox");
        kdtEntrys_pType_ComboBox.setVisible(true);
        kdtEntrys_pType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.DOCTYPE").toArray());
        KDTDefaultCellEditor kdtEntrys_pType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pType_ComboBox);
        this.kdtEntrys.getColumn("pType").setEditor(kdtEntrys_pType_CellEditor);
        KDTextField kdtEntrys_wPmtNum_TextField = new KDTextField();
        kdtEntrys_wPmtNum_TextField.setName("kdtEntrys_wPmtNum_TextField");
        kdtEntrys_wPmtNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_wPmtNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wPmtNum_TextField);
        this.kdtEntrys.getColumn("wPmtNum").setEditor(kdtEntrys_wPmtNum_CellEditor);
        KDDatePicker kdtEntrys_wPmtGTime_DatePicker = new KDDatePicker();
        kdtEntrys_wPmtGTime_DatePicker.setName("kdtEntrys_wPmtGTime_DatePicker");
        kdtEntrys_wPmtGTime_DatePicker.setVisible(true);
        kdtEntrys_wPmtGTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_wPmtGTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wPmtGTime_DatePicker);
        this.kdtEntrys.getColumn("wPmtGTime").setEditor(kdtEntrys_wPmtGTime_CellEditor);
        KDDatePicker kdtEntrys_laboreffDate_DatePicker = new KDDatePicker();
        kdtEntrys_laboreffDate_DatePicker.setName("kdtEntrys_laboreffDate_DatePicker");
        kdtEntrys_laboreffDate_DatePicker.setVisible(true);
        kdtEntrys_laboreffDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_laboreffDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_laboreffDate_DatePicker);
        this.kdtEntrys.getColumn("laboreffDate").setEditor(kdtEntrys_laboreffDate_CellEditor);
        KDDatePicker kdtEntrys_wPmtSTime_DatePicker = new KDDatePicker();
        kdtEntrys_wPmtSTime_DatePicker.setName("kdtEntrys_wPmtSTime_DatePicker");
        kdtEntrys_wPmtSTime_DatePicker.setVisible(true);
        kdtEntrys_wPmtSTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_wPmtSTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wPmtSTime_DatePicker);
        this.kdtEntrys.getColumn("wPmtSTime").setEditor(kdtEntrys_wPmtSTime_CellEditor);
        KDCheckBox kdtEntrys_sPAfPerson_CheckBox = new KDCheckBox();
        kdtEntrys_sPAfPerson_CheckBox.setName("kdtEntrys_sPAfPerson_CheckBox");
        KDTDefaultCellEditor kdtEntrys_sPAfPerson_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sPAfPerson_CheckBox);
        this.kdtEntrys.getColumn("sPAfPerson").setEditor(kdtEntrys_sPAfPerson_CellEditor);
        KDCheckBox kdtEntrys_departure_CheckBox = new KDCheckBox();
        kdtEntrys_departure_CheckBox.setName("kdtEntrys_departure_CheckBox");
        KDTDefaultCellEditor kdtEntrys_departure_CellEditor = new KDTDefaultCellEditor(kdtEntrys_departure_CheckBox);
        this.kdtEntrys.getColumn("departure").setEditor(kdtEntrys_departure_CellEditor);
        KDDatePicker kdtEntrys_leaveTime_DatePicker = new KDDatePicker();
        kdtEntrys_leaveTime_DatePicker.setName("kdtEntrys_leaveTime_DatePicker");
        kdtEntrys_leaveTime_DatePicker.setVisible(true);
        kdtEntrys_leaveTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_leaveTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_leaveTime_DatePicker);
        this.kdtEntrys.getColumn("leaveTime").setEditor(kdtEntrys_leaveTime_CellEditor);
        KDCheckBox kdtEntrys_isStop_CheckBox = new KDCheckBox();
        kdtEntrys_isStop_CheckBox.setName("kdtEntrys_isStop_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isStop_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isStop_CheckBox);
        this.kdtEntrys.getColumn("isStop").setEditor(kdtEntrys_isStop_CellEditor);
        KDDatePicker kdtEntrys_endTime_DatePicker = new KDDatePicker();
        kdtEntrys_endTime_DatePicker.setName("kdtEntrys_endTime_DatePicker");
        kdtEntrys_endTime_DatePicker.setVisible(true);
        kdtEntrys_endTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_endTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_endTime_DatePicker);
        this.kdtEntrys.getColumn("endTime").setEditor(kdtEntrys_endTime_CellEditor);
        KDTextField kdtEntrys_cancelReson_TextField = new KDTextField();
        kdtEntrys_cancelReson_TextField.setName("kdtEntrys_cancelReson_TextField");
        kdtEntrys_cancelReson_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_cancelReson_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cancelReson_TextField);
        this.kdtEntrys.getColumn("cancelReson").setEditor(kdtEntrys_cancelReson_CellEditor);
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
        final KDBizPromptBox kdtEntrys_workOrg_PromptBox = new KDBizPromptBox();
        kdtEntrys_workOrg_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_workOrg_PromptBox.setVisible(true);
        kdtEntrys_workOrg_PromptBox.setEditable(true);
        kdtEntrys_workOrg_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_workOrg_PromptBox.setEditFormat("$number$");
        kdtEntrys_workOrg_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_workOrg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_workOrg_PromptBox);
        this.kdtEntrys.getColumn("workOrg").setEditor(kdtEntrys_workOrg_CellEditor);
        ObjectValueRender kdtEntrys_workOrg_OVR = new ObjectValueRender();
        kdtEntrys_workOrg_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("workOrg").setRenderer(kdtEntrys_workOrg_OVR);
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
        KDTextField kdtEntrys_oldPassport_TextField = new KDTextField();
        kdtEntrys_oldPassport_TextField.setName("kdtEntrys_oldPassport_TextField");
        kdtEntrys_oldPassport_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_oldPassport_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oldPassport_TextField);
        this.kdtEntrys.getColumn("oldPassport").setEditor(kdtEntrys_oldPassport_CellEditor);
        KDTextField kdtEntrys_dlyChkFrc_TextField = new KDTextField();
        kdtEntrys_dlyChkFrc_TextField.setName("kdtEntrys_dlyChkFrc_TextField");
        kdtEntrys_dlyChkFrc_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_dlyChkFrc_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dlyChkFrc_TextField);
        this.kdtEntrys.getColumn("dlyChkFrc").setEditor(kdtEntrys_dlyChkFrc_CellEditor);
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
        KDCheckBox kdtEntrys_isHand_CheckBox = new KDCheckBox();
        kdtEntrys_isHand_CheckBox.setName("kdtEntrys_isHand_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isHand_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isHand_CheckBox);
        this.kdtEntrys.getColumn("isHand").setEditor(kdtEntrys_isHand_CellEditor);
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
        KDFormattedTextField kdtEntrys_copie_TextField = new KDFormattedTextField();
        kdtEntrys_copie_TextField.setName("kdtEntrys_copie_TextField");
        kdtEntrys_copie_TextField.setVisible(true);
        kdtEntrys_copie_TextField.setEditable(true);
        kdtEntrys_copie_TextField.setHorizontalAlignment(2);
        kdtEntrys_copie_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_copie_CellEditor = new KDTDefaultCellEditor(kdtEntrys_copie_TextField);
        this.kdtEntrys.getColumn("copie").setEditor(kdtEntrys_copie_CellEditor);
        KDCheckBox kdtEntrys_isEmbassReg_CheckBox = new KDCheckBox();
        kdtEntrys_isEmbassReg_CheckBox.setName("kdtEntrys_isEmbassReg_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isEmbassReg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isEmbassReg_CheckBox);
        this.kdtEntrys.getColumn("isEmbassReg").setEditor(kdtEntrys_isEmbassReg_CellEditor);
        // contbNum		
        this.contbNum.setBoundLabelText(resHelper.getString("contbNum.boundLabelText"));		
        this.contbNum.setBoundLabelLength(100);		
        this.contbNum.setBoundLabelUnderline(true);		
        this.contbNum.setVisible(false);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);
        // contbillSate		
        this.contbillSate.setBoundLabelText(resHelper.getString("contbillSate.boundLabelText"));		
        this.contbillSate.setBoundLabelLength(60);		
        this.contbillSate.setBoundLabelUnderline(true);		
        this.contbillSate.setVisible(true);		
        this.contbillSate.setEnabled(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setForeground(new java.awt.Color(255,0,0));
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
        // txtbNum		
        this.txtbNum.setHorizontalAlignment(2);		
        this.txtbNum.setMaxLength(100);		
        this.txtbNum.setRequired(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);
        // billSate		
        this.billSate.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.BillStateEnum").toArray());		
        this.billSate.setRequired(false);		
        this.billSate.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtbNum,pkauditDate,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,billSate,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 557));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 557));
        contCreator.setBounds(new Rectangle(526, 490, 213, 19));
        this.add(contCreator, new KDLayout.Constraints(526, 490, 213, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(784, 490, 213, 19));
        this.add(contCreateTime, new KDLayout.Constraints(784, 490, 213, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(9, 529, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(9, 529, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(319, 530, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(319, 530, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 10, 238, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 10, 238, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(283, 10, 194, 21));
        this.add(contBizDate, new KDLayout.Constraints(283, 10, 194, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(743, 10, 248, 18));
        this.add(contDescription, new KDLayout.Constraints(743, 10, 248, 18, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(10, 490, 213, 19));
        this.add(contAuditor, new KDLayout.Constraints(10, 490, 213, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(10, 58, 991, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(10, 58, 991, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("sex",new Integer(1));
vo.put("passportAgence","10");
vo.put("MaritalStatus","0");
vo.put("authType","0");
vo.put("pType","0");
vo.put("personState","10");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contbNum.setBounds(new Rectangle(260, 139, 215, 19));
        this.add(contbNum, new KDLayout.Constraints(260, 139, 215, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditDate.setBounds(new Rectangle(268, 490, 213, 19));
        this.add(contauditDate, new KDLayout.Constraints(268, 490, 213, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillSate.setBounds(new Rectangle(504, 10, 211, 18));
        this.add(contbillSate, new KDLayout.Constraints(504, 10, 211, 18, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer1.setBounds(new Rectangle(18, 35, 980, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(18, 35, 980, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbNum
        contbNum.setBoundEditor(txtbNum);
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);
        //contbillSate
        contbillSate.setBoundEditor(billSate);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.name", String.class, this.kdtEntrys, "name.text");
		dataBinder.registerBinding("entrys.sex", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "sex.text");
		dataBinder.registerBinding("entrys.birthday", java.util.Date.class, this.kdtEntrys, "birthday.text");
		dataBinder.registerBinding("entrys.IdNum", String.class, this.kdtEntrys, "IdNum.text");
		dataBinder.registerBinding("entrys.passpNum", String.class, this.kdtEntrys, "passpNum.text");
		dataBinder.registerBinding("entrys.passpExDate", java.util.Date.class, this.kdtEntrys, "passpExDate.text");
		dataBinder.registerBinding("entrys.immiTime", java.util.Date.class, this.kdtEntrys, "immiTime.text");
		dataBinder.registerBinding("entrys.papSTime", java.util.Date.class, this.kdtEntrys, "papSTime.text");
		dataBinder.registerBinding("entrys.wPmtGTime", java.util.Date.class, this.kdtEntrys, "wPmtGTime.text");
		dataBinder.registerBinding("entrys.wPmtNum", String.class, this.kdtEntrys, "wPmtNum.text");
		dataBinder.registerBinding("entrys.wPmtSTime", java.util.Date.class, this.kdtEntrys, "wPmtSTime.text");
		dataBinder.registerBinding("entrys.dlyChkFrc", String.class, this.kdtEntrys, "dlyChkFrc.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.pType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "pType.text");
		dataBinder.registerBinding("entrys.pmtProj", java.lang.Object.class, this.kdtEntrys, "pmtProj.text");
		dataBinder.registerBinding("entrys.workOrg", java.lang.Object.class, this.kdtEntrys, "workOrg.text");
		dataBinder.registerBinding("entrys.quProf", java.lang.Object.class, this.kdtEntrys, "quProf.text");
		dataBinder.registerBinding("entrys.quprofF", String.class, this.kdtEntrys, "quprofF.text");
		dataBinder.registerBinding("entrys.actProf", String.class, this.kdtEntrys, "actProf.text");
		dataBinder.registerBinding("entrys.departure", boolean.class, this.kdtEntrys, "departure.text");
		dataBinder.registerBinding("entrys.cooperation", java.lang.Object.class, this.kdtEntrys, "cooperation.text");
		dataBinder.registerBinding("entrys.isStop", boolean.class, this.kdtEntrys, "isStop.text");
		dataBinder.registerBinding("entrys.endTime", java.util.Date.class, this.kdtEntrys, "endTime.text");
		dataBinder.registerBinding("entrys.sourceEntryID", String.class, this.kdtEntrys, "sourceEntryID.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.birthPlace", String.class, this.kdtEntrys, "birthPlace.text");
		dataBinder.registerBinding("entrys.birthPlaceFr", String.class, this.kdtEntrys, "birthPlaceFr.text");
		dataBinder.registerBinding("entrys.nation", java.lang.Object.class, this.kdtEntrys, "nation.text");
		dataBinder.registerBinding("entrys.passportIssueDate", java.util.Date.class, this.kdtEntrys, "passportIssueDate.text");
		dataBinder.registerBinding("entrys.passportAgence", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "passportAgence.text");
		dataBinder.registerBinding("entrys.passportCityF", String.class, this.kdtEntrys, "passportCityF.text");
		dataBinder.registerBinding("entrys.fatherName", String.class, this.kdtEntrys, "fatherName.text");
		dataBinder.registerBinding("entrys.fatherNameAlphabet", String.class, this.kdtEntrys, "fatherNameAlphabet.text");
		dataBinder.registerBinding("entrys.motherName", String.class, this.kdtEntrys, "motherName.text");
		dataBinder.registerBinding("entrys.motherNameAlphabet", String.class, this.kdtEntrys, "motherNameAlphabet.text");
		dataBinder.registerBinding("entrys.MaritalStatus", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "MaritalStatus.text");
		dataBinder.registerBinding("entrys.laborSignNo", String.class, this.kdtEntrys, "laborSignNo.text");
		dataBinder.registerBinding("entrys.VisaNum", String.class, this.kdtEntrys, "VisaNum.text");
		dataBinder.registerBinding("entrys.veTime", java.util.Date.class, this.kdtEntrys, "veTime.text");
		dataBinder.registerBinding("entrys.vsTima", java.util.Date.class, this.kdtEntrys, "vsTima.text");
		dataBinder.registerBinding("entrys.qualDate", java.util.Date.class, this.kdtEntrys, "qualDate.text");
		dataBinder.registerBinding("entrys.cancelReson", String.class, this.kdtEntrys, "cancelReson.text");
		dataBinder.registerBinding("entrys.oldPassport", String.class, this.kdtEntrys, "oldPassport.text");
		dataBinder.registerBinding("entrys.contactway", String.class, this.kdtEntrys, "contactway.text");
		dataBinder.registerBinding("entrys.residence", String.class, this.kdtEntrys, "residence.text");
		dataBinder.registerBinding("entrys.authType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "authType.text");
		dataBinder.registerBinding("entrys.coupleName", String.class, this.kdtEntrys, "coupleName.text");
		dataBinder.registerBinding("entrys.coupleNameAlphabet", String.class, this.kdtEntrys, "coupleNameAlphabet.text");
		dataBinder.registerBinding("entrys.coupleBirthDate", java.util.Date.class, this.kdtEntrys, "coupleBirthDate.text");
		dataBinder.registerBinding("entrys.couplebirthPlace", String.class, this.kdtEntrys, "couplebirthPlace.text");
		dataBinder.registerBinding("entrys.coupleNational", java.lang.Object.class, this.kdtEntrys, "coupleNational.text");
		dataBinder.registerBinding("entrys.coupleWorkPlace", String.class, this.kdtEntrys, "coupleWorkPlace.text");
		dataBinder.registerBinding("entrys.isHand", boolean.class, this.kdtEntrys, "isHand.text");
		dataBinder.registerBinding("entrys.personState", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "personState.text");
		dataBinder.registerBinding("entrys.isPush", boolean.class, this.kdtEntrys, "isPush.text");
		dataBinder.registerBinding("entrys.laboreffDate", java.util.Date.class, this.kdtEntrys, "laboreffDate.text");
		dataBinder.registerBinding("entrys.workEXP", int.class, this.kdtEntrys, "workEXP.text");
		dataBinder.registerBinding("entrys.copie", int.class, this.kdtEntrys, "copie.text");
		dataBinder.registerBinding("entrys.docAffiliate", boolean.class, this.kdtEntrys, "docAffiliate.text");
		dataBinder.registerBinding("entrys.passportCityCC", java.lang.Object.class, this.kdtEntrys, "passportCityCC.text");
		dataBinder.registerBinding("entrys.sPAfPerson", boolean.class, this.kdtEntrys, "sPAfPerson.text");
		dataBinder.registerBinding("entrys.isEmbassReg", boolean.class, this.kdtEntrys, "isEmbassReg.text");
		dataBinder.registerBinding("entrys.leaveTime", java.util.Date.class, this.kdtEntrys, "leaveTime.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("bNum", String.class, this.txtbNum, "text");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("billSate", com.kingdee.eas.zjlw.certificates.app.BillStateEnum.class, this.billSate, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.certificates.app.WorkPmtEditUIHandler";
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
        this.txtbNum.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.zjlw.certificates.WorkPmtInfo)ov;
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
	 * ????????��??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IdNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passpExDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.immiTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.papSTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wPmtGTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wPmtNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wPmtSTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dlyChkFrc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pmtProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.quProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.quprofF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.departure", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isStop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.endTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sourceEntryID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthPlaceFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportIssueDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportAgence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCityF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fatherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.motherNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.MaritalStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.laborSignNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.VisaNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.veTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vsTima", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qualDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cancelReson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oldPassport", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contactway", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.residence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.authType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNameAlphabet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleBirthDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.couplebirthPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleNational", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coupleWorkPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isHand", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isPush", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.laboreffDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workEXP", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.copie", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.docAffiliate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.passportCityCC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sPAfPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isEmbassReg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.leaveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billSate", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.sex"));
    	sic.add(new SelectorItemInfo("entrys.birthday"));
    	sic.add(new SelectorItemInfo("entrys.IdNum"));
    	sic.add(new SelectorItemInfo("entrys.passpNum"));
    	sic.add(new SelectorItemInfo("entrys.passpExDate"));
    	sic.add(new SelectorItemInfo("entrys.immiTime"));
    	sic.add(new SelectorItemInfo("entrys.papSTime"));
    	sic.add(new SelectorItemInfo("entrys.wPmtGTime"));
    	sic.add(new SelectorItemInfo("entrys.wPmtNum"));
    	sic.add(new SelectorItemInfo("entrys.wPmtSTime"));
    	sic.add(new SelectorItemInfo("entrys.dlyChkFrc"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.pType"));
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
			sic.add(new SelectorItemInfo("entrys.workOrg.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.workOrg.id"));
			sic.add(new SelectorItemInfo("entrys.workOrg.name"));
        	sic.add(new SelectorItemInfo("entrys.workOrg.number"));
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
    	sic.add(new SelectorItemInfo("entrys.quprofF"));
    	sic.add(new SelectorItemInfo("entrys.actProf"));
    	sic.add(new SelectorItemInfo("entrys.departure"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.cooperation.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.cooperation.id"));
			sic.add(new SelectorItemInfo("entrys.cooperation.name"));
        	sic.add(new SelectorItemInfo("entrys.cooperation.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.isStop"));
    	sic.add(new SelectorItemInfo("entrys.endTime"));
    	sic.add(new SelectorItemInfo("entrys.sourceEntryID"));
    	sic.add(new SelectorItemInfo("entrys.personID"));
    	sic.add(new SelectorItemInfo("entrys.lastName"));
    	sic.add(new SelectorItemInfo("entrys.firstName"));
    	sic.add(new SelectorItemInfo("entrys.birthPlace"));
    	sic.add(new SelectorItemInfo("entrys.birthPlaceFr"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.nation.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.nation.id"));
			sic.add(new SelectorItemInfo("entrys.nation.name"));
        	sic.add(new SelectorItemInfo("entrys.nation.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.passportIssueDate"));
    	sic.add(new SelectorItemInfo("entrys.passportAgence"));
    	sic.add(new SelectorItemInfo("entrys.passportCityF"));
    	sic.add(new SelectorItemInfo("entrys.fatherName"));
    	sic.add(new SelectorItemInfo("entrys.fatherNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.motherName"));
    	sic.add(new SelectorItemInfo("entrys.motherNameAlphabet"));
    	sic.add(new SelectorItemInfo("entrys.MaritalStatus"));
    	sic.add(new SelectorItemInfo("entrys.laborSignNo"));
    	sic.add(new SelectorItemInfo("entrys.VisaNum"));
    	sic.add(new SelectorItemInfo("entrys.veTime"));
    	sic.add(new SelectorItemInfo("entrys.vsTima"));
    	sic.add(new SelectorItemInfo("entrys.qualDate"));
    	sic.add(new SelectorItemInfo("entrys.cancelReson"));
    	sic.add(new SelectorItemInfo("entrys.oldPassport"));
    	sic.add(new SelectorItemInfo("entrys.contactway"));
    	sic.add(new SelectorItemInfo("entrys.residence"));
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
    	sic.add(new SelectorItemInfo("entrys.isHand"));
    	sic.add(new SelectorItemInfo("entrys.personState"));
    	sic.add(new SelectorItemInfo("entrys.isPush"));
    	sic.add(new SelectorItemInfo("entrys.laboreffDate"));
    	sic.add(new SelectorItemInfo("entrys.workEXP"));
    	sic.add(new SelectorItemInfo("entrys.copie"));
    	sic.add(new SelectorItemInfo("entrys.docAffiliate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.passportCityCC.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.passportCityCC.id"));
			sic.add(new SelectorItemInfo("entrys.passportCityCC.name"));
        	sic.add(new SelectorItemInfo("entrys.passportCityCC.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.sPAfPerson"));
    	sic.add(new SelectorItemInfo("entrys.isEmbassReg"));
    	sic.add(new SelectorItemInfo("entrys.leaveTime"));
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
        sic.add(new SelectorItemInfo("bNum"));
        sic.add(new SelectorItemInfo("auditDate"));
        sic.add(new SelectorItemInfo("billSate"));
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
        return new MetaDataPK("com.kingdee.eas.zjlw.certificates.client", "WorkPmtEditUI");
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
        return com.kingdee.eas.zjlw.certificates.client.WorkPmtEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.WorkPmtFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.WorkPmtInfo objectValue = new com.kingdee.eas.zjlw.certificates.WorkPmtInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/certificates/WorkPmt";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.certificates.app.WorkPmtQuery");
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