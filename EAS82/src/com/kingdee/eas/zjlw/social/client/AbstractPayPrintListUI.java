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
public abstract class AbstractPayPrintListUI extends com.kingdee.eas.framework.client.CoreBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPayPrintListUI.class);
    protected com.kingdee.bos.ctrl.swing.KDSplitPane kDSplitPane1;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer2;
    protected com.kingdee.bos.ctrl.swing.KDTreeView kDTreeView1;
    protected com.kingdee.bos.ctrl.swing.KDTree treeMain;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnImprotData;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected EntityViewInfo payPrintQuery = null;
    protected IMetaDataPK payPrintQueryPK;
    protected ActionTDPrint actionTDPrint = null;
    protected ActionTDPrintPreview actionTDPrintPreview = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    public final static String STATUS_VIEW = "VIEW";
    /**
     * output class constructor
     */
    public AbstractPayPrintListUI() throws Exception
    {
        super();
        this.defaultObjectName = "mainQuery";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractPayPrintListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.zjlw.social.app", "PayPrintQuery");
        payPrintQueryPK = new MetaDataPK("com.kingdee.eas.zjlw.social.app", "PayPrintQuery");
        //actionRemove
        String _tempStr = null;
        actionRemove.setEnabled(true);
        actionRemove.setDaemonRun(false);

        actionRemove.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl D"));
        _tempStr = resHelper.getString("ActionRemove.SHORT_DESCRIPTION");
        actionRemove.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemove.LONG_DESCRIPTION");
        actionRemove.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemove.NAME");
        actionRemove.putValue(ItemAction.NAME, _tempStr);
        this.actionRemove.setBindWorkFlow(true);
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionTDPrint
        this.actionTDPrint = new ActionTDPrint(this);
        getActionManager().registerAction("actionTDPrint", actionTDPrint);
         this.actionTDPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionTDPrintPreview
        this.actionTDPrintPreview = new ActionTDPrintPreview(this);
        getActionManager().registerAction("actionTDPrintPreview", actionTDPrintPreview);
         this.actionTDPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.kDSplitPane1 = new com.kingdee.bos.ctrl.swing.KDSplitPane();
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDContainer2 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDTreeView1 = new com.kingdee.bos.ctrl.swing.KDTreeView();
        this.treeMain = new com.kingdee.bos.ctrl.swing.KDTree();
        this.btnImprotData = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDSplitPane1.setName("kDSplitPane1");
        this.kDContainer1.setName("kDContainer1");
        this.kDContainer2.setName("kDContainer2");
        this.kDTreeView1.setName("kDTreeView1");
        this.treeMain.setName("treeMain");
        this.btnImprotData.setName("btnImprotData");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"createTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lastUpdateTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"auditor.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"auditor.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"creator.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"creator.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lastUpdateUser.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lastUpdateUser.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"handler.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"handler.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"projName.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"monthYearr.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"endDate.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"pSecuNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cooperation.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"projSecuNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workProj.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"projPri.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"projNameFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"addressFR\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"insuranceAcc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.position\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.enterDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.basePay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.monthWork\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.absence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.absDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.normalOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.moreOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.festOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.profWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.extProfWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.secuDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.vacaDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.aftTaxPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.grossPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.persTax\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.posiPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.chineWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.algerWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.traWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.bTripWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.oneWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.riskWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.disasWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.oneTimeWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.eatWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.overTraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.areaWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.thingsWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.switchWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.nWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.liveWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.spendWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.fireWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.retirWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.faraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.pOverAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.profAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.langWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.urgeWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.monthAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.indPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.netPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.unSignWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.coopCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.seniWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.wifeUnWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.FamilyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.studyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.unSCVCWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.foriPersID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.IRGDeduction\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.SociaLevyBase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.IRGDPerson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.maritalStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.attMthWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.nmlBsWgPerHour\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.hldBsWgPerHour\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.totNmlBsWg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.totHldBsWg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.IRGLBase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.totCharge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.soLevyBaseW\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.IRGLBaseW\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.securityNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.CCPNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.nWorkDay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.phoneWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.itmperieTol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.abcdefg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.aaa\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.inDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.outDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.secuProfFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.birthdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.cfbirthplacecn\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.monthYear\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthdayDay1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthdayDay2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthdayMonth1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthdayMonth2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthdayYear1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthdayYear2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDayDay1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDayDay2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDayMonth1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDayMonth2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDayYear1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDayYear2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outDayDay1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outDayDay2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outDayMonth1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outDayMonth2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outDayYear1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outDayYear2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{createTime}</t:Cell><t:Cell>$Resource{lastUpdateTime}</t:Cell><t:Cell>$Resource{auditor.number}</t:Cell><t:Cell>$Resource{auditor.name}</t:Cell><t:Cell>$Resource{creator.number}</t:Cell><t:Cell>$Resource{creator.name}</t:Cell><t:Cell>$Resource{lastUpdateUser.number}</t:Cell><t:Cell>$Resource{lastUpdateUser.name}</t:Cell><t:Cell>$Resource{handler.number}</t:Cell><t:Cell>$Resource{handler.name}</t:Cell><t:Cell>$Resource{projName.name}</t:Cell><t:Cell>$Resource{monthYearr.number}</t:Cell><t:Cell>$Resource{endDate.number}</t:Cell><t:Cell>$Resource{pSecuNumber}</t:Cell><t:Cell>$Resource{cooperation.name}</t:Cell><t:Cell>$Resource{projSecuNumber}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{birthday}</t:Cell><t:Cell>$Resource{workProj.name}</t:Cell><t:Cell>$Resource{projPri.name}</t:Cell><t:Cell>$Resource{projNameFr}</t:Cell><t:Cell>$Resource{addressFR}</t:Cell><t:Cell>$Resource{insuranceAcc}</t:Cell><t:Cell>$Resource{entrys.lastName}</t:Cell><t:Cell>$Resource{entrys.firstName}</t:Cell><t:Cell>$Resource{entrys.position}</t:Cell><t:Cell>$Resource{entrys.enterDate}</t:Cell><t:Cell>$Resource{entrys.basePay}</t:Cell><t:Cell>$Resource{entrys.monthWork}</t:Cell><t:Cell>$Resource{entrys.absence}</t:Cell><t:Cell>$Resource{entrys.absDebit}</t:Cell><t:Cell>$Resource{entrys.normalOver}</t:Cell><t:Cell>$Resource{entrys.moreOver}</t:Cell><t:Cell>$Resource{entrys.festOver}</t:Cell><t:Cell>$Resource{entrys.profWage}</t:Cell><t:Cell>$Resource{entrys.extProfWage}</t:Cell><t:Cell>$Resource{entrys.secuDebit}</t:Cell><t:Cell>$Resource{entrys.vacaDebit}</t:Cell><t:Cell>$Resource{entrys.aftTaxPay}</t:Cell><t:Cell>$Resource{entrys.grossPay}</t:Cell><t:Cell>$Resource{entrys.persTax}</t:Cell><t:Cell>$Resource{entrys.posiPay}</t:Cell><t:Cell>$Resource{entrys.chineWage}</t:Cell><t:Cell>$Resource{entrys.algerWage}</t:Cell><t:Cell>$Resource{entrys.traWage}</t:Cell><t:Cell>$Resource{entrys.bTripWage}</t:Cell><t:Cell>$Resource{entrys.oneWorkWage}</t:Cell><t:Cell>$Resource{entrys.riskWage}</t:Cell><t:Cell>$Resource{entrys.disasWage}</t:Cell><t:Cell>$Resource{entrys.oneTimeWage}</t:Cell><t:Cell>$Resource{entrys.eatWage}</t:Cell><t:Cell>$Resource{entrys.overTraWage}</t:Cell><t:Cell>$Resource{entrys.areaWage}</t:Cell><t:Cell>$Resource{entrys.thingsWage}</t:Cell><t:Cell>$Resource{entrys.switchWage}</t:Cell><t:Cell>$Resource{entrys.nWorkWage}</t:Cell><t:Cell>$Resource{entrys.liveWage}</t:Cell><t:Cell>$Resource{entrys.spendWage}</t:Cell><t:Cell>$Resource{entrys.fireWage}</t:Cell><t:Cell>$Resource{entrys.retirWage}</t:Cell><t:Cell>$Resource{entrys.faraWage}</t:Cell><t:Cell>$Resource{entrys.pOverAward}</t:Cell><t:Cell>$Resource{entrys.profAward}</t:Cell><t:Cell>$Resource{entrys.langWage}</t:Cell><t:Cell>$Resource{entrys.urgeWage}</t:Cell><t:Cell>$Resource{entrys.monthAward}</t:Cell><t:Cell>$Resource{entrys.indPay}</t:Cell><t:Cell>$Resource{entrys.netPay}</t:Cell><t:Cell>$Resource{entrys.unSignWage}</t:Cell><t:Cell>$Resource{entrys.coopCode}</t:Cell><t:Cell>$Resource{entrys.seniWage}</t:Cell><t:Cell>$Resource{entrys.wifeUnWage}</t:Cell><t:Cell>$Resource{entrys.FamilyWage}</t:Cell><t:Cell>$Resource{entrys.studyWage}</t:Cell><t:Cell>$Resource{entrys.unSCVCWage}</t:Cell><t:Cell>$Resource{entrys.personID}</t:Cell><t:Cell>$Resource{entrys.foriPersID}</t:Cell><t:Cell>$Resource{entrys.IRGDeduction}</t:Cell><t:Cell>$Resource{entrys.SociaLevyBase}</t:Cell><t:Cell>$Resource{entrys.IRGDPerson}</t:Cell><t:Cell>$Resource{entrys.maritalStatus}</t:Cell><t:Cell>$Resource{entrys.attMthWage}</t:Cell><t:Cell>$Resource{entrys.nmlBsWgPerHour}</t:Cell><t:Cell>$Resource{entrys.hldBsWgPerHour}</t:Cell><t:Cell>$Resource{entrys.totNmlBsWg}</t:Cell><t:Cell>$Resource{entrys.totHldBsWg}</t:Cell><t:Cell>$Resource{entrys.IRGLBase}</t:Cell><t:Cell>$Resource{entrys.totCharge}</t:Cell><t:Cell>$Resource{entrys.soLevyBaseW}</t:Cell><t:Cell>$Resource{entrys.IRGLBaseW}</t:Cell><t:Cell>$Resource{entrys.securityNo}</t:Cell><t:Cell>$Resource{entrys.CCPNo}</t:Cell><t:Cell>$Resource{entrys.remark}</t:Cell><t:Cell>$Resource{entrys.nWorkDay}</t:Cell><t:Cell>$Resource{entrys.phoneWageC}</t:Cell><t:Cell>$Resource{entrys.itmperieTol}</t:Cell><t:Cell>$Resource{entrys.abcdefg}</t:Cell><t:Cell>$Resource{entrys.aaa}</t:Cell><t:Cell>$Resource{entrys.inDate}</t:Cell><t:Cell>$Resource{entrys.outDate}</t:Cell><t:Cell>$Resource{entrys.secuProfFr}</t:Cell><t:Cell>$Resource{entrys.birthdate}</t:Cell><t:Cell>$Resource{entrys.cfbirthplacecn}</t:Cell><t:Cell>$Resource{entrys.seq}</t:Cell><t:Cell>$Resource{entrys.id}</t:Cell><t:Cell>$Resource{entrys.monthYear}</t:Cell><t:Cell>$Resource{birthdayDay1}</t:Cell><t:Cell>$Resource{birthdayDay2}</t:Cell><t:Cell>$Resource{birthdayMonth1}</t:Cell><t:Cell>$Resource{birthdayMonth2}</t:Cell><t:Cell>$Resource{birthdayYear1}</t:Cell><t:Cell>$Resource{birthdayYear2}</t:Cell><t:Cell>$Resource{inDayDay1}</t:Cell><t:Cell>$Resource{inDayDay2}</t:Cell><t:Cell>$Resource{inDayMonth1}</t:Cell><t:Cell>$Resource{inDayMonth2}</t:Cell><t:Cell>$Resource{inDayYear1}</t:Cell><t:Cell>$Resource{inDayYear2}</t:Cell><t:Cell>$Resource{outDayDay1}</t:Cell><t:Cell>$Resource{outDayDay2}</t:Cell><t:Cell>$Resource{outDayMonth1}</t:Cell><t:Cell>$Resource{outDayMonth2}</t:Cell><t:Cell>$Resource{outDayYear1}</t:Cell><t:Cell>$Resource{outDayYear2}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"id","number","bizDate","description","createTime","lastUpdateTime","auditor.number","auditor.name","creator.number","creator.name","lastUpdateUser.number","lastUpdateUser.name","handler.number","handler.name","projName.name","monthYearr.number","endDate.number","pSecuNumber","cooperation.name","projSecuNumber","lastName","firstName","birthday","workProj.name","projPri.name","projNameFr","addressFR","insuranceAcc","entrys.lastName","entrys.firstName","entrys.position","entrys.enterDate","entrys.basePay","entrys.monthWork","entrys.absence","entrys.absDebit","entrys.normalOver","entrys.moreOver","entrys.festOver","entrys.profWage","entrys.extProfWage","entrys.secuDebit","entrys.vacaDebit","entrys.aftTaxPay","entrys.grossPay","entrys.persTax","entrys.posiPay","entrys.chineWage","entrys.algerWage","entrys.traWage","entrys.bTripWage","entrys.oneWorkWage","entrys.riskWage","entrys.disasWage","entrys.oneTimeWage","entrys.eatWage","entrys.overTraWage","entrys.areaWage","entrys.thingsWage","entrys.switchWage","entrys.nWorkWage","entrys.liveWage","entrys.spendWage","entrys.fireWage","entrys.retirWage","entrys.faraWage","entrys.pOverAward","entrys.profAward","entrys.langWage","entrys.urgeWage","entrys.monthAward","entrys.indPay","entrys.netPay","entrys.unSignWage","entrys.coopCode","entrys.seniWage","entrys.wifeUnWage","entrys.FamilyWage","entrys.studyWage","entrys.unSCVCWage","entrys.personID","entrys.foriPersID","entrys.IRGDeduction","entrys.SociaLevyBase","entrys.IRGDPerson","entrys.maritalStatus","entrys.attMthWage","entrys.nmlBsWgPerHour","entrys.hldBsWgPerHour","entrys.totNmlBsWg","entrys.totHldBsWg","entrys.IRGLBase","entrys.totCharge","entrys.soLevyBaseW","entrys.IRGLBaseW","entrys.securityNo","entrys.CCPNo","entrys.remark","entrys.nWorkDay","entrys.phoneWageC","entrys.itmperieTol","entrys.abcdefg","entrys.aaa","entrys.inDate","entrys.outDate","entrys.secuProfFr","entrys.birthdate","entrys.cfbirthplacecn","entrys.seq","entrys.id","entrys.monthYear","birthdayDay1","birthdayDay2","birthdayMonth1","birthdayMonth2","birthdayYear1","birthdayYear2","inDayDay1","inDayDay2","inDayMonth1","inDayMonth2","inDayYear1","inDayYear2","outDayDay1","outDayDay2","outDayMonth1","outDayMonth2","outDayYear1","outDayYear2"});


        this.tblMain.checkParsed();
        this.tblMain.getGroupManager().setGroup(true);		
        this.separatorFW2.setVisible(true);		
        this.btnAuditResult.setVisible(false);		
        this.menuItemCopyTo.setVisible(false);		
        this.kDSeparator4.setVisible(false);		
        this.kDSeparator6.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // kDSplitPane1		
        this.kDSplitPane1.setDividerLocation(200);
        // kDContainer1		
        this.kDContainer1.setTitle(resHelper.getString("kDContainer1.title"));
        // kDContainer2		
        this.kDContainer2.setTitle(resHelper.getString("kDContainer2.title"));
        // kDTreeView1
        // treeMain
        this.treeMain.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
                try {
                    treeMain_valueChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // btnImprotData
        this.btnImprotData.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportData, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnImprotData.setText(resHelper.getString("btnImprotData.text"));		
        this.btnImprotData.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTree_import"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));		
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));		
        this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_fauditing"));
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
        this.setBounds(new Rectangle(10, 10, 1013, 629));
this.setLayout(new BorderLayout(0, 0));
        this.add(kDSplitPane1, BorderLayout.CENTER);
        //kDSplitPane1
        kDSplitPane1.add(kDContainer1, "left");
        kDSplitPane1.add(kDContainer2, "right");
        //kDContainer1
kDContainer1.getContentPane().setLayout(new BorderLayout(0, 0));        kDContainer1.getContentPane().add(kDTreeView1, BorderLayout.CENTER);
        //kDTreeView1
        kDTreeView1.setTree(treeMain);
        //kDContainer2
kDContainer2.getContentPane().setLayout(new BorderLayout(0, 0));        kDContainer2.getContentPane().add(tblMain, BorderLayout.CENTER);

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
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkFlow);
        this.menuBar.add(menuTools);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(menuItemImportData);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemExportData);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(separatorFile1);
        menuFile.add(menuItemCloudShare);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator1);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemExitCurrent);
        //menuEdit
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator3);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyTo);
        menuEdit.add(kDSeparator4);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemView);
        menuView.add(menuItemLocate);
        menuView.add(kDSeparator5);
        menuView.add(menuItemQuery);
        menuView.add(menuItemRefresh);
        menuView.add(menuItemSwitchView);
        menuView.add(separatorView1);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(menuItemQueryScheme);
        menuView.add(kDSeparator6);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkFlow
        menuWorkFlow.add(menuItemViewDoProccess);
        menuWorkFlow.add(menuItemMultiapprove);
        menuWorkFlow.add(menuItemWorkFlowG);
        menuWorkFlow.add(menuItemWorkFlowList);
        menuWorkFlow.add(separatorWF1);
        menuWorkFlow.add(menuItemNextPerson);
        menuWorkFlow.add(menuItemAuditResult);
        menuWorkFlow.add(kDSeparator7);
        menuWorkFlow.add(menuItemSendSmsMessage);
        //menuTools
        menuTools.add(menuMail);
        menuTools.add(menuItemStartWorkFlow);
        menuTools.add(menuItemPublishReport);
        //menuMail
        menuMail.add(menuItemToHTML);
        menuMail.add(menuItemCopyScreen);
        menuMail.add(menuItemToExcel);
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
        this.toolBar.add(btnView);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnEdit);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnRefresh);
        this.toolBar.add(btnQuery);
        this.toolBar.add(btnLocate);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(btnCopyTo);
        this.toolBar.add(btnQueryScheme);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnWorkFlowList);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnImprotData);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.social.app.PayPrintListUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(String key, IObjectValue dataObject)
    {
        super.setDataObject(key, dataObject);
        if (key.equalsIgnoreCase("payPrintQuery")) {
            this.payPrintQuery = (EntityViewInfo)dataObject;
		}
	}
	protected void Remove() throws Exception {
    	IObjectValue editData = getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
    	super.Remove();
    	recycleNumberByOrg(editData,"",editData.getString("number"));
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

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
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
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
    }

    /**
     * output treeMain_valueChanged method
     */
    protected void treeMain_valueChanged(javax.swing.event.TreeSelectionEvent e) throws Exception
    {
    }

	public SelectorItemCollection getBOTPSelectors() {
			SelectorItemCollection sic = new SelectorItemCollection();
			return sic;
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
        sic.add(new SelectorItemInfo("id"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("auditor.number"));
        sic.add(new SelectorItemInfo("auditor.name"));
        sic.add(new SelectorItemInfo("creator.number"));
        sic.add(new SelectorItemInfo("creator.name"));
        sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        sic.add(new SelectorItemInfo("lastUpdateUser.name"));
        sic.add(new SelectorItemInfo("handler.number"));
        sic.add(new SelectorItemInfo("handler.name"));
        sic.add(new SelectorItemInfo("projName.name"));
        sic.add(new SelectorItemInfo("monthYearr.number"));
        sic.add(new SelectorItemInfo("endDate.number"));
        sic.add(new SelectorItemInfo("pSecuNumber"));
        sic.add(new SelectorItemInfo("cooperation.name"));
        sic.add(new SelectorItemInfo("projSecuNumber"));
        sic.add(new SelectorItemInfo("lastName"));
        sic.add(new SelectorItemInfo("firstName"));
        sic.add(new SelectorItemInfo("birthday"));
        sic.add(new SelectorItemInfo("workProj.name"));
        sic.add(new SelectorItemInfo("projPri.name"));
        sic.add(new SelectorItemInfo("projNameFr"));
        sic.add(new SelectorItemInfo("addressFR"));
        sic.add(new SelectorItemInfo("insuranceAcc"));
        sic.add(new SelectorItemInfo("entrys.lastName"));
        sic.add(new SelectorItemInfo("entrys.firstName"));
        sic.add(new SelectorItemInfo("entrys.position"));
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
        sic.add(new SelectorItemInfo("entrys.aftTaxPay"));
        sic.add(new SelectorItemInfo("entrys.grossPay"));
        sic.add(new SelectorItemInfo("entrys.persTax"));
        sic.add(new SelectorItemInfo("entrys.posiPay"));
        sic.add(new SelectorItemInfo("entrys.chineWage"));
        sic.add(new SelectorItemInfo("entrys.algerWage"));
        sic.add(new SelectorItemInfo("entrys.traWage"));
        sic.add(new SelectorItemInfo("entrys.bTripWage"));
        sic.add(new SelectorItemInfo("entrys.oneWorkWage"));
        sic.add(new SelectorItemInfo("entrys.riskWage"));
        sic.add(new SelectorItemInfo("entrys.disasWage"));
        sic.add(new SelectorItemInfo("entrys.oneTimeWage"));
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
        sic.add(new SelectorItemInfo("entrys.pOverAward"));
        sic.add(new SelectorItemInfo("entrys.profAward"));
        sic.add(new SelectorItemInfo("entrys.langWage"));
        sic.add(new SelectorItemInfo("entrys.urgeWage"));
        sic.add(new SelectorItemInfo("entrys.monthAward"));
        sic.add(new SelectorItemInfo("entrys.indPay"));
        sic.add(new SelectorItemInfo("entrys.netPay"));
        sic.add(new SelectorItemInfo("entrys.unSignWage"));
        sic.add(new SelectorItemInfo("entrys.coopCode"));
        sic.add(new SelectorItemInfo("entrys.seniWage"));
        sic.add(new SelectorItemInfo("entrys.wifeUnWage"));
        sic.add(new SelectorItemInfo("entrys.FamilyWage"));
        sic.add(new SelectorItemInfo("entrys.studyWage"));
        sic.add(new SelectorItemInfo("entrys.unSCVCWage"));
        sic.add(new SelectorItemInfo("entrys.personID"));
        sic.add(new SelectorItemInfo("entrys.foriPersID"));
        sic.add(new SelectorItemInfo("entrys.IRGDeduction"));
        sic.add(new SelectorItemInfo("entrys.SociaLevyBase"));
        sic.add(new SelectorItemInfo("entrys.IRGDPerson"));
        sic.add(new SelectorItemInfo("entrys.maritalStatus"));
        sic.add(new SelectorItemInfo("entrys.attMthWage"));
        sic.add(new SelectorItemInfo("entrys.nmlBsWgPerHour"));
        sic.add(new SelectorItemInfo("entrys.hldBsWgPerHour"));
        sic.add(new SelectorItemInfo("entrys.totNmlBsWg"));
        sic.add(new SelectorItemInfo("entrys.totHldBsWg"));
        sic.add(new SelectorItemInfo("entrys.IRGLBase"));
        sic.add(new SelectorItemInfo("entrys.totCharge"));
        sic.add(new SelectorItemInfo("entrys.soLevyBaseW"));
        sic.add(new SelectorItemInfo("entrys.IRGLBaseW"));
        sic.add(new SelectorItemInfo("entrys.securityNo"));
        sic.add(new SelectorItemInfo("entrys.CCPNo"));
        sic.add(new SelectorItemInfo("entrys.remark"));
        sic.add(new SelectorItemInfo("entrys.nWorkDay"));
        sic.add(new SelectorItemInfo("entrys.phoneWageC"));
        sic.add(new SelectorItemInfo("entrys.itmperieTol"));
        sic.add(new SelectorItemInfo("entrys.abcdefg"));
        sic.add(new SelectorItemInfo("entrys.aaa"));
        sic.add(new SelectorItemInfo("entrys.inDate"));
        sic.add(new SelectorItemInfo("entrys.outDate"));
        sic.add(new SelectorItemInfo("entrys.secuProfFr"));
        sic.add(new SelectorItemInfo("entrys.birthdate"));
        sic.add(new SelectorItemInfo("entrys.cfbirthplacecn"));
        sic.add(new SelectorItemInfo("entrys.seq"));
        sic.add(new SelectorItemInfo("entrys.id"));
        sic.add(new SelectorItemInfo("entrys.monthYear"));
        sic.add(new SelectorItemInfo("birthdayDay1"));
        sic.add(new SelectorItemInfo("birthdayDay2"));
        sic.add(new SelectorItemInfo("birthdayMonth1"));
        sic.add(new SelectorItemInfo("birthdayMonth2"));
        sic.add(new SelectorItemInfo("birthdayYear1"));
        sic.add(new SelectorItemInfo("birthdayYear2"));
        sic.add(new SelectorItemInfo("inDayDay1"));
        sic.add(new SelectorItemInfo("inDayDay2"));
        sic.add(new SelectorItemInfo("inDayMonth1"));
        sic.add(new SelectorItemInfo("inDayMonth2"));
        sic.add(new SelectorItemInfo("inDayYear1"));
        sic.add(new SelectorItemInfo("inDayYear2"));
        sic.add(new SelectorItemInfo("outDayDay1"));
        sic.add(new SelectorItemInfo("outDayDay2"));
        sic.add(new SelectorItemInfo("outDayMonth1"));
        sic.add(new SelectorItemInfo("outDayMonth2"));
        sic.add(new SelectorItemInfo("outDayYear1"));
        sic.add(new SelectorItemInfo("outDayYear2"));
        return sic;
    }            protected java.util.List getQuerySorterFields() 
    { 
        java.util.List sorterFieldList = new ArrayList(); 
        sorterFieldList.add("entrys.monthYear"); 
        sorterFieldList.add("number"); 
        return sorterFieldList; 
    } 
    protected java.util.List getQueryPKFields() 
    { 
        java.util.List pkList = new ArrayList(); 
        pkList.add("id"); 
        return pkList;
    }
    	

    /**
     * output actionRemove_actionPerformed method
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }
    	

    /**
     * output actionTDPrint_actionPerformed method
     */
    public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception
    {
        checkSelected();        
    	ArrayList idList =super.getSelectedIdValues();
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.reportone.r1.print.data.AbstractPrintDataProvider data = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.DefaultNoteDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionTDPrintPreview_actionPerformed method
     */
    public void actionTDPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        checkSelected();
    	ArrayList idList =super.getSelectedIdValues();
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.reportone.r1.print.data.AbstractPrintDataProvider data = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.DefaultNoteDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
	public RequestContext prepareActionRemove(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionRemove(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRemove() {
    	return false;
    }
	public RequestContext prepareActionTDPrint(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionTDPrint() {
    	return false;
    }
	public RequestContext prepareActionTDPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionTDPrintPreview() {
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
     * output ActionTDPrint class
     */     
    protected class ActionTDPrint extends ItemAction {     
    
        public ActionTDPrint()
        {
            this(null);
        }

        public ActionTDPrint(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionTDPrint.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrint.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrint.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractPayPrintListUI.this, "ActionTDPrint", "actionTDPrint_actionPerformed", e);
        }
    }

    /**
     * output ActionTDPrintPreview class
     */     
    protected class ActionTDPrintPreview extends ItemAction {     
    
        public ActionTDPrintPreview()
        {
            this(null);
        }

        public ActionTDPrintPreview(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionTDPrintPreview.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrintPreview.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrintPreview.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractPayPrintListUI.this, "ActionTDPrintPreview", "actionTDPrintPreview_actionPerformed", e);
        }
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
            innerActionPerformed("eas", AbstractPayPrintListUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractPayPrintListUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.social.client", "PayPrintListUI");
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
        return com.kingdee.eas.zjlw.social.client.PayPrintEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.social.PayPrintFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.social.PayPrintInfo objectValue = new com.kingdee.eas.zjlw.social.PayPrintInfo();		
        return objectValue;
    }

    /**
     * output getMergeColumnKeys method
     */
    public String[] getMergeColumnKeys()
    {
        return new String[] {"id","number","bizDate","description","createTime","lastUpdateTime","auditor.number","auditor.name","creator.number","creator.name","lastUpdateUser.number","lastUpdateUser.name","handler.number","handler.name","projName.name","monthYearr.number","endDate.number","pSecuNumber","cooperation.name","projSecuNumber","lastName","firstName","birthday","workProj.name","projPri.name","projNameFr","addressFR","insuranceAcc","birthdayDay1","birthdayDay2","birthdayMonth1","birthdayMonth2","birthdayYear1","birthdayYear2","inDayDay1","inDayDay2","inDayMonth1","inDayMonth2","inDayYear1","inDayYear2","outDayDay1","outDayDay2","outDayMonth1","outDayMonth2","outDayYear1","outDayYear2"};
    }



	protected String getTDFileName() {
    	return "/bim/zjlw/social/PayPrint";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.social.app.PayPrintQuery");
	}

}