/**
 * output package name
 */
package com.kingdee.eas.hr.org.client;

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
public abstract class AbstractHRPositionMainListUI extends com.kingdee.eas.framework.client.TreeListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractHRPositionMainListUI.class);
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane tabPositionPanel;
    protected com.kingdee.bos.ctrl.swing.KDPanel rightPanel;
    protected com.kingdee.bos.ctrl.swing.KDPanel posiHierPanel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labPositionRel;
    protected com.kingdee.bos.ctrl.swing.KDTreeView treeView2;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbxMain;
    protected com.kingdee.bos.ctrl.swing.KDTree treeMain2;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkInclude;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox showInvalidationPosition;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkShowVirtualOrg;
    protected javax.swing.JToolBar.Separator separator1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnImportPosition;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnDeletePosition;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnMovePosition;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnMovePosition1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCopyPosition;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPositionMap;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPositionOutLine;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnSetEmpCompet;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPositionPersonMatch;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnOrder;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemImportPosition;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemMovePosition;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemDelPosition;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemOrder;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator3;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemPositionMap;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemPositionOutLine;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemPositionPersonMatch;
    protected ActionImportPosition actionImportPosition = null;
    protected ActionDeletePosition actionDeletePosition = null;
    protected ActionMovePosition actionMovePosition = null;
    protected ActionPositionMap actionPositionMap = null;
    protected ActionPositionOutLine actionPositionOutLine = null;
    protected ActionPositionPersonMatch actionPositionPersonMatch = null;
    protected ActionOrder actionOrder = null;
    protected ActionSetEmpCompet actionSetEmpCompet = null;
    protected ActionCopyPosition actionCopyPosition = null;
    protected ActionMovePosition2 actionMovePosition2 = null;
    /**
     * output class constructor
     */
    public AbstractHRPositionMainListUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractHRPositionMainListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.base.message", "MsgQuery");
        //actionImportPosition
        this.actionImportPosition = new ActionImportPosition(this);
        getActionManager().registerAction("actionImportPosition", actionImportPosition);
         this.actionImportPosition.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionImportPosition.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionImportPosition.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionDeletePosition
        this.actionDeletePosition = new ActionDeletePosition(this);
        getActionManager().registerAction("actionDeletePosition", actionDeletePosition);
         this.actionDeletePosition.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionDeletePosition.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionDeletePosition.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionMovePosition
        this.actionMovePosition = new ActionMovePosition(this);
        getActionManager().registerAction("actionMovePosition", actionMovePosition);
         this.actionMovePosition.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionMovePosition.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionMovePosition.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPositionMap
        this.actionPositionMap = new ActionPositionMap(this);
        getActionManager().registerAction("actionPositionMap", actionPositionMap);
         this.actionPositionMap.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPositionMap.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPositionMap.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPositionOutLine
        this.actionPositionOutLine = new ActionPositionOutLine(this);
        getActionManager().registerAction("actionPositionOutLine", actionPositionOutLine);
         this.actionPositionOutLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPositionOutLine.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPositionOutLine.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPositionPersonMatch
        this.actionPositionPersonMatch = new ActionPositionPersonMatch(this);
        getActionManager().registerAction("actionPositionPersonMatch", actionPositionPersonMatch);
         this.actionPositionPersonMatch.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPositionPersonMatch.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPositionPersonMatch.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionOrder
        this.actionOrder = new ActionOrder(this);
        getActionManager().registerAction("actionOrder", actionOrder);
         this.actionOrder.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionOrder.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionOrder.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionSetEmpCompet
        this.actionSetEmpCompet = new ActionSetEmpCompet(this);
        getActionManager().registerAction("actionSetEmpCompet", actionSetEmpCompet);
         this.actionSetEmpCompet.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionCopyPosition
        this.actionCopyPosition = new ActionCopyPosition(this);
        getActionManager().registerAction("actionCopyPosition", actionCopyPosition);
         this.actionCopyPosition.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionMovePosition2
        this.actionMovePosition2 = new ActionMovePosition2(this);
        getActionManager().registerAction("actionMovePosition2", actionMovePosition2);
         this.actionMovePosition2.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.tabPositionPanel = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.rightPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.posiHierPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.labPositionRel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.treeView2 = new com.kingdee.bos.ctrl.swing.KDTreeView();
        this.cbxMain = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.treeMain2 = new com.kingdee.bos.ctrl.swing.KDTree();
        this.chkInclude = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.showInvalidationPosition = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkShowVirtualOrg = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.separator1 = new javax.swing.JToolBar.Separator();
        this.btnImportPosition = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnDeletePosition = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnMovePosition = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnMovePosition1 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnCopyPosition = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnPositionMap = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnPositionOutLine = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnSetEmpCompet = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnPositionPersonMatch = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnOrder = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.menuItemImportPosition = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemMovePosition = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemDelPosition = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemOrder = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDSeparator3 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.menuItemPositionMap = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemPositionOutLine = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemPositionPersonMatch = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.tabPositionPanel.setName("tabPositionPanel");
        this.rightPanel.setName("rightPanel");
        this.posiHierPanel.setName("posiHierPanel");
        this.labPositionRel.setName("labPositionRel");
        this.treeView2.setName("treeView2");
        this.cbxMain.setName("cbxMain");
        this.treeMain2.setName("treeMain2");
        this.chkInclude.setName("chkInclude");
        this.showInvalidationPosition.setName("showInvalidationPosition");
        this.chkShowVirtualOrg.setName("chkShowVirtualOrg");
        this.separator1.setName("separator1");
        this.btnImportPosition.setName("btnImportPosition");
        this.btnDeletePosition.setName("btnDeletePosition");
        this.btnMovePosition.setName("btnMovePosition");
        this.btnMovePosition1.setName("btnMovePosition1");
        this.btnCopyPosition.setName("btnCopyPosition");
        this.btnPositionMap.setName("btnPositionMap");
        this.btnPositionOutLine.setName("btnPositionOutLine");
        this.btnSetEmpCompet.setName("btnSetEmpCompet");
        this.btnPositionPersonMatch.setName("btnPositionPersonMatch");
        this.btnOrder.setName("btnOrder");
        this.menuItemImportPosition.setName("menuItemImportPosition");
        this.menuItemMovePosition.setName("menuItemMovePosition");
        this.menuItemDelPosition.setName("menuItemDelPosition");
        this.menuItemOrder.setName("menuItemOrder");
        this.kDSeparator3.setName("kDSeparator3");
        this.menuItemPositionMap.setName("menuItemPositionMap");
        this.menuItemPositionOutLine.setName("menuItemPositionOutLine");
        this.menuItemPositionPersonMatch.setName("menuItemPositionPersonMatch");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"false\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"DefaultPosition\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"deletedStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"adminOrgName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"adminDisplayName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"description\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"effectDate\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"valiDate\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"asd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{DefaultPosition}</t:Cell><t:Cell>$Resource{deletedStatus}</t:Cell><t:Cell>$Resource{adminOrgName}</t:Cell><t:Cell>$Resource{adminDisplayName}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{effectDate}</t:Cell><t:Cell>$Resource{valiDate}</t:Cell><t:Cell>$Resource{asd}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"id","number","name","DefaultPosition","deletedStatus","AdminOrgUnit.name","AdminOrgUnit.displayName","description","effectDate","valiDate","asd"});


        this.tblMain.checkParsed();
        this.tblMain.getGroupManager().setGroup(true);
        this.btnAddNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                try {
                    btnAddNew_mousePressed(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuBiz.setEnabled(true);		
        this.menuBiz.setVisible(true);		
        this.menuItemCancelCancel.setText(resHelper.getString("menuItemCancelCancel.text"));		
        this.menuItemCancelCancel.setToolTipText(resHelper.getString("menuItemCancelCancel.toolTipText"));		
        this.menuItemCancel.setText(resHelper.getString("menuItemCancel.text"));		
        this.menuItemCancel.setToolTipText(resHelper.getString("menuItemCancel.toolTipText"));		
        this.btnCancel.setText(resHelper.getString("btnCancel.text"));		
        this.btnCancel.setToolTipText(resHelper.getString("btnCancel.toolTipText"));		
        this.btnCancel.setVisible(true);		
        this.btnCancelCancel.setText(resHelper.getString("btnCancelCancel.text"));		
        this.btnCancelCancel.setToolTipText(resHelper.getString("btnCancelCancel.toolTipText"));		
        this.btnCancelCancel.setVisible(true);		
        this.pnlMain.setDividerLocation(300);		
        this.treeView.setShowControlPanel(true);		
        this.treeView.setTitle(resHelper.getString("treeView.title"));		
        this.treeView.setShowButton(false);		
        this.separatorEdit1.setVisible(true);
        // tabPositionPanel		
        this.tabPositionPanel.setPreferredSize(new Dimension(300,5));
        // rightPanel
        // posiHierPanel		
        this.posiHierPanel.setPreferredSize(new Dimension(78,72));
        // labPositionRel		
        this.labPositionRel.setBoundLabelText(resHelper.getString("labPositionRel.boundLabelText"));		
        this.labPositionRel.setBoundLabelLength(100);		
        this.labPositionRel.setBoundLabelUnderline(true);		
        this.labPositionRel.setPreferredSize(new Dimension(78,19));
        // treeView2		
        this.treeView2.setShowButton(false);		
        this.treeView2.setTitle(resHelper.getString("treeView2.title"));
        // cbxMain
        this.cbxMain.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                try {
                    cbxMain_itemStateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // treeMain2
        this.treeMain2.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
                try {
                    treeMain2_valueChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // chkInclude		
        this.chkInclude.setText(resHelper.getString("chkInclude.text"));		
        this.chkInclude.setToolTipText(resHelper.getString("chkInclude.toolTipText"));
        this.chkInclude.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                try {
                    chkInclude_itemStateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // showInvalidationPosition		
        this.showInvalidationPosition.setText(resHelper.getString("showInvalidationPosition.text"));
        this.showInvalidationPosition.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                try {
                    showInvalidationPosition_itemStateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // chkShowVirtualOrg		
        this.chkShowVirtualOrg.setText(resHelper.getString("chkShowVirtualOrg.text"));
        this.chkShowVirtualOrg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                try {
                    chkShowVirtualOrg_itemStateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // separator1		
        this.separator1.setOrientation(1);
        // btnImportPosition
        this.btnImportPosition.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportPosition, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnImportPosition.setText(resHelper.getString("btnImportPosition.text"));
        // btnDeletePosition
        this.btnDeletePosition.setAction((IItemAction)ActionProxyFactory.getProxy(actionDeletePosition, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnDeletePosition.setText(resHelper.getString("btnDeletePosition.text"));
        // btnMovePosition
        this.btnMovePosition.setAction((IItemAction)ActionProxyFactory.getProxy(actionMovePosition, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnMovePosition.setText(resHelper.getString("btnMovePosition.text"));
        // btnMovePosition1
        this.btnMovePosition1.setAction((IItemAction)ActionProxyFactory.getProxy(actionMovePosition2, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnMovePosition1.setText(resHelper.getString("btnMovePosition1.text"));		
        this.btnMovePosition1.setToolTipText(resHelper.getString("btnMovePosition1.toolTipText"));
        // btnCopyPosition
        this.btnCopyPosition.setAction((IItemAction)ActionProxyFactory.getProxy(actionCopyPosition, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnCopyPosition.setText(resHelper.getString("btnCopyPosition.text"));		
        this.btnCopyPosition.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_copy"));
        // btnPositionMap
        this.btnPositionMap.setAction((IItemAction)ActionProxyFactory.getProxy(actionPositionMap, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnPositionMap.setText(resHelper.getString("btnPositionMap.text"));
        // btnPositionOutLine
        this.btnPositionOutLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionPositionOutLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnPositionOutLine.setText(resHelper.getString("btnPositionOutLine.text"));
        // btnSetEmpCompet
        this.btnSetEmpCompet.setAction((IItemAction)ActionProxyFactory.getProxy(actionSetEmpCompet, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnSetEmpCompet.setText(resHelper.getString("btnSetEmpCompet.text"));		
        this.btnSetEmpCompet.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_distributebatch"));
        // btnPositionPersonMatch
        this.btnPositionPersonMatch.setAction((IItemAction)ActionProxyFactory.getProxy(actionPositionPersonMatch, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnPositionPersonMatch.setText(resHelper.getString("btnPositionPersonMatch.text"));
        // btnOrder
        this.btnOrder.setAction((IItemAction)ActionProxyFactory.getProxy(actionOrder, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnOrder.setText(resHelper.getString("btnOrder.text"));
        // menuItemImportPosition
        this.menuItemImportPosition.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportPosition, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemImportPosition.setText(resHelper.getString("menuItemImportPosition.text"));
        // menuItemMovePosition
        this.menuItemMovePosition.setAction((IItemAction)ActionProxyFactory.getProxy(actionMovePosition, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemMovePosition.setText(resHelper.getString("menuItemMovePosition.text"));
        // menuItemDelPosition
        this.menuItemDelPosition.setAction((IItemAction)ActionProxyFactory.getProxy(actionDeletePosition, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemDelPosition.setText(resHelper.getString("menuItemDelPosition.text"));
        // menuItemOrder
        this.menuItemOrder.setAction((IItemAction)ActionProxyFactory.getProxy(actionOrder, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemOrder.setText(resHelper.getString("menuItemOrder.text"));		
        this.menuItemOrder.setToolTipText(resHelper.getString("menuItemOrder.toolTipText"));		
        this.menuItemOrder.setMnemonic(83);
        // kDSeparator3
        // menuItemPositionMap
        this.menuItemPositionMap.setAction((IItemAction)ActionProxyFactory.getProxy(actionPositionMap, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemPositionMap.setText(resHelper.getString("menuItemPositionMap.text"));
        // menuItemPositionOutLine
        this.menuItemPositionOutLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionPositionOutLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemPositionOutLine.setText(resHelper.getString("menuItemPositionOutLine.text"));		
        this.menuItemPositionOutLine.setMnemonic(74);
        // menuItemPositionPersonMatch
        this.menuItemPositionPersonMatch.setAction((IItemAction)ActionProxyFactory.getProxy(actionPositionPersonMatch, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemPositionPersonMatch.setText(resHelper.getString("menuItemPositionPersonMatch.text"));		
        this.menuItemPositionPersonMatch.setMnemonic(67);
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
        this.setBounds(new Rectangle(10, 10, 1016, 630));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1016, 630));
        pnlMain.setBounds(new Rectangle(10, 10, 996, 580));
        this.add(pnlMain, new KDLayout.Constraints(10, 10, 996, 580, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //pnlMain
        pnlMain.add(tabPositionPanel, "left");
        pnlMain.add(rightPanel, "right");
        //tabPositionPanel
        tabPositionPanel.add(treeView, resHelper.getString("treeView.constraints"));
        tabPositionPanel.add(posiHierPanel, resHelper.getString("posiHierPanel.constraints"));
        //treeView
        treeView.setTree(treeMain);
        //posiHierPanel
posiHierPanel.setLayout(new BorderLayout(0, 0));        posiHierPanel.add(labPositionRel, BorderLayout.NORTH);
        posiHierPanel.add(treeView2, BorderLayout.CENTER);
        //labPositionRel
        labPositionRel.setBoundEditor(cbxMain);
        //treeView2
        treeView2.setTree(treeMain2);
        //rightPanel
        rightPanel.setLayout(new KDLayout());
        rightPanel.putClientProperty("OriginalBounds", new Rectangle(0, 0, 685, 579));        tblMain.setBounds(new Rectangle(0, 19, 688, 561));
        rightPanel.add(tblMain, new KDLayout.Constraints(0, 19, 688, 561, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkInclude.setBounds(new Rectangle(0, 0, 88, 19));
        rightPanel.add(chkInclude, new KDLayout.Constraints(0, 0, 88, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        showInvalidationPosition.setBounds(new Rectangle(92, 0, 106, 19));
        rightPanel.add(showInvalidationPosition, new KDLayout.Constraints(92, 0, 106, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        chkShowVirtualOrg.setBounds(new Rectangle(206, 0, 140, 19));
        rightPanel.add(chkShowVirtualOrg, new KDLayout.Constraints(206, 0, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));

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
        menuFile.add(menuItemImportPosition);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemExitCurrent);
        //menuEdit
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemMovePosition);
        menuEdit.add(menuItemMoveTree);
        menuEdit.add(menuItemDelPosition);
        menuEdit.add(menuItemOrder);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemView);
        menuView.add(menuItemLocate);
        menuView.add(kDSeparator3);
        menuView.add(menuItemQuery);
        menuView.add(menuItemRefresh);
        menuView.add(menuItemQueryScheme);
        menuView.add(menuItemPositionMap);
        menuView.add(separatorView1);
        menuView.add(menuItemPositionOutLine);
        menuView.add(menuItemPositionPersonMatch);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
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
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(btnLocate);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnQuery);
        this.toolBar.add(btnPrint);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(btnMoveTree);
        this.toolBar.add(btnQueryScheme);
        this.toolBar.add(separator1);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnImportPosition);
        this.toolBar.add(btnDeletePosition);
        this.toolBar.add(btnMovePosition);
        this.toolBar.add(btnMovePosition1);
        this.toolBar.add(btnCopyPosition);
        this.toolBar.add(btnPositionMap);
        this.toolBar.add(btnPositionOutLine);
        this.toolBar.add(btnSetEmpCompet);
        this.toolBar.add(btnPositionPersonMatch);
        this.toolBar.add(btnOrder);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.hr.org.app.HRPositionMainListUIHandler";
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
			protected com.kingdee.eas.basedata.org.OrgType getMainBizOrgType() {
			return com.kingdee.eas.basedata.org.OrgType.getEnum("ControlUnit");
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
     * output btnAddNew_mousePressed method
     */
    protected void btnAddNew_mousePressed(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output cbxMain_itemStateChanged method
     */
    protected void cbxMain_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
    }

    /**
     * output treeMain2_valueChanged method
     */
    protected void treeMain2_valueChanged(javax.swing.event.TreeSelectionEvent e) throws Exception
    {
    }

    /**
     * output chkInclude_itemStateChanged method
     */
    protected void chkInclude_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
    }

    /**
     * output showInvalidationPosition_itemStateChanged method
     */
    protected void showInvalidationPosition_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
    }

    /**
     * output chkShowVirtualOrg_itemStateChanged method
     */
    protected void chkShowVirtualOrg_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
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
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("DefaultPosition"));
        sic.add(new SelectorItemInfo("effectDate"));
        sic.add(new SelectorItemInfo("valiDate"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("AdminOrgUnit.name"));
        sic.add(new SelectorItemInfo("deletedStatus"));
        sic.add(new SelectorItemInfo("AdminOrgUnit.displayName"));
        sic.add(new SelectorItemInfo("asd"));
        return sic;
    }            protected java.util.List getQuerySorterFields() 
    { 
        java.util.List sorterFieldList = new ArrayList(); 
        sorterFieldList.add("AdminOrgUnit.sortCode"); 
        sorterFieldList.add("index"); 
        return sorterFieldList; 
    } 
    protected java.util.List getQueryPKFields() 
    { 
        java.util.List pkList = new ArrayList(); 
        pkList.add("id"); 
        return pkList;
    }
    	

    /**
     * output actionImportPosition_actionPerformed method
     */
    public void actionImportPosition_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionDeletePosition_actionPerformed method
     */
    public void actionDeletePosition_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionMovePosition_actionPerformed method
     */
    public void actionMovePosition_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionPositionMap_actionPerformed method
     */
    public void actionPositionMap_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionPositionOutLine_actionPerformed method
     */
    public void actionPositionOutLine_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionPositionPersonMatch_actionPerformed method
     */
    public void actionPositionPersonMatch_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionOrder_actionPerformed method
     */
    public void actionOrder_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionSetEmpCompet_actionPerformed method
     */
    public void actionSetEmpCompet_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionCopyPosition_actionPerformed method
     */
    public void actionCopyPosition_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionMovePosition2_actionPerformed method
     */
    public void actionMovePosition2_actionPerformed(ActionEvent e) throws Exception
    {
    }
	public RequestContext prepareActionImportPosition(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImportPosition() {
    	return false;
    }
	public RequestContext prepareActionDeletePosition(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionDeletePosition() {
    	return false;
    }
	public RequestContext prepareActionMovePosition(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMovePosition() {
    	return false;
    }
	public RequestContext prepareActionPositionMap(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPositionMap() {
    	return false;
    }
	public RequestContext prepareActionPositionOutLine(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPositionOutLine() {
    	return false;
    }
	public RequestContext prepareActionPositionPersonMatch(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPositionPersonMatch() {
    	return false;
    }
	public RequestContext prepareActionOrder(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionOrder() {
    	return false;
    }
	public RequestContext prepareActionSetEmpCompet(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSetEmpCompet() {
    	return false;
    }
	public RequestContext prepareActionCopyPosition(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCopyPosition() {
    	return false;
    }
	public RequestContext prepareActionMovePosition2(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMovePosition2() {
    	return false;
    }

    /**
     * output ActionImportPosition class
     */     
    protected class ActionImportPosition extends ItemAction {     
    
        public ActionImportPosition()
        {
            this(null);
        }

        public ActionImportPosition(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionImportPosition.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportPosition.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportPosition.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionImportPosition", "actionImportPosition_actionPerformed", e);
        }
    }

    /**
     * output ActionDeletePosition class
     */     
    protected class ActionDeletePosition extends ItemAction {     
    
        public ActionDeletePosition()
        {
            this(null);
        }

        public ActionDeletePosition(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionDeletePosition.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDeletePosition.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDeletePosition.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionDeletePosition", "actionDeletePosition_actionPerformed", e);
        }
    }

    /**
     * output ActionMovePosition class
     */     
    protected class ActionMovePosition extends ItemAction {     
    
        public ActionMovePosition()
        {
            this(null);
        }

        public ActionMovePosition(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionMovePosition.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMovePosition.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMovePosition.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionMovePosition", "actionMovePosition_actionPerformed", e);
        }
    }

    /**
     * output ActionPositionMap class
     */     
    protected class ActionPositionMap extends ItemAction {     
    
        public ActionPositionMap()
        {
            this(null);
        }

        public ActionPositionMap(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl C"));
            _tempStr = resHelper.getString("ActionPositionMap.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPositionMap.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPositionMap.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionPositionMap", "actionPositionMap_actionPerformed", e);
        }
    }

    /**
     * output ActionPositionOutLine class
     */     
    protected class ActionPositionOutLine extends ItemAction {     
    
        public ActionPositionOutLine()
        {
            this(null);
        }

        public ActionPositionOutLine(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl J"));
            _tempStr = resHelper.getString("ActionPositionOutLine.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPositionOutLine.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPositionOutLine.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionPositionOutLine", "actionPositionOutLine_actionPerformed", e);
        }
    }

    /**
     * output ActionPositionPersonMatch class
     */     
    protected class ActionPositionPersonMatch extends ItemAction {     
    
        public ActionPositionPersonMatch()
        {
            this(null);
        }

        public ActionPositionPersonMatch(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionPositionPersonMatch.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPositionPersonMatch.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPositionPersonMatch.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionPositionPersonMatch", "actionPositionPersonMatch_actionPerformed", e);
        }
    }

    /**
     * output ActionOrder class
     */     
    protected class ActionOrder extends ItemAction {     
    
        public ActionOrder()
        {
            this(null);
        }

        public ActionOrder(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
            _tempStr = resHelper.getString("ActionOrder.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOrder.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOrder.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionOrder", "actionOrder_actionPerformed", e);
        }
    }

    /**
     * output ActionSetEmpCompet class
     */     
    protected class ActionSetEmpCompet extends ItemAction {     
    
        public ActionSetEmpCompet()
        {
            this(null);
        }

        public ActionSetEmpCompet(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionSetEmpCompet.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSetEmpCompet.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSetEmpCompet.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionSetEmpCompet", "actionSetEmpCompet_actionPerformed", e);
        }
    }

    /**
     * output ActionCopyPosition class
     */     
    protected class ActionCopyPosition extends ItemAction {     
    
        public ActionCopyPosition()
        {
            this(null);
        }

        public ActionCopyPosition(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCopyPosition.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCopyPosition.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCopyPosition.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionCopyPosition", "actionCopyPosition_actionPerformed", e);
        }
    }

    /**
     * output ActionMovePosition2 class
     */     
    protected class ActionMovePosition2 extends ItemAction {     
    
        public ActionMovePosition2()
        {
            this(null);
        }

        public ActionMovePosition2(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionMovePosition2.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMovePosition2.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMovePosition2.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractHRPositionMainListUI.this, "ActionMovePosition2", "actionMovePosition2_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.hr.org.client", "HRPositionMainListUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.hr.org.client.HRPositionEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.basedata.org.PositionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.basedata.org.PositionInfo objectValue = new com.kingdee.eas.basedata.org.PositionInfo();		
        return objectValue;
    }




}