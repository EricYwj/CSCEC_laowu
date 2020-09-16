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
public abstract class AbstractHRPositionEditUI extends com.kingdee.eas.hr.base.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractHRPositionEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labNumber;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane positionTabPanel;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDFilterTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDPanel basePanel;
    protected com.kingdee.bos.ctrl.swing.KDPanel posiQualPanel;
    protected com.kingdee.bos.ctrl.swing.KDPanel respPanel;
    protected com.kingdee.bos.ctrl.swing.KDPanel personPanel;
    protected com.kingdee.bos.ctrl.swing.KDPanel competIndexPanel;
    protected com.kingdee.bos.ctrl.swing.KDPanel predecessorPanel;
    protected com.kingdee.bos.ctrl.swing.KDPanel ChildPositionPersonPanel;
    protected com.kingdee.bos.ctrl.swing.KDPanel positionOtherPanel;
    protected com.kingdee.bos.ctrl.swing.KDLabel labDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox btnDefaultPosition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labAdminOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labJob;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labEffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labValiDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangArea txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labPositionPlan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labPositionType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbltPositionLdapProp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lblFluCheckTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lblSuperPositionNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptSuperPosition;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptAdminOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptJob;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dateEffectDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dateValiDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtPositionPlan;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptPositionType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPositionLdapProp;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFluCheckTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSuperPositionNumber;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblPosiQual;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnDelPosiQual;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnImportPosiQual;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAddPosiQual;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUpdatePosiQual;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblResponsibility;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnDelResp;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnImportResp;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUpdateResp;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAddResp;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblPersonList;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblCompetIndex;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnInsert;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnDel;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblPredecessor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblChildPositionPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlHierarchyName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlPositionHierarchyLevel;
    protected com.kingdee.bos.ctrl.swing.KDComboBox kdcHierarchyName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox kdcPositionHierarchyLevel;
    protected com.kingdee.bos.ctrl.swing.KDSplitPane kDSplitPane1;
    protected com.kingdee.bos.ctrl.swing.KDContainer kdcontOtherUp;
    protected com.kingdee.bos.ctrl.swing.KDContainer kdContOtherDown;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblPositionOtherUp;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAddUp;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRemoveUp;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblPositonOtherDown;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAddDown;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRemveDown;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPositionOutLine;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemPositionOutLine;
    protected com.kingdee.eas.basedata.org.PositionInfo editData = null;
    protected EntityViewInfo positionOfPerson = null;
    protected IMetaDataPK positionOfPersonPK;
    protected EntityViewInfo positionRespListQuery = null;
    protected IMetaDataPK positionRespListQueryPK;
    protected EntityViewInfo positionOfPosiQual = null;
    protected IMetaDataPK positionOfPosiQualPK;
    protected EntityViewInfo predecessorPersonQuery = null;
    protected IMetaDataPK predecessorPersonQueryPK;
    protected EntityViewInfo queryChildPositionPersonQuery = null;
    protected IMetaDataPK queryChildPositionPersonQueryPK;
    protected ActionPositionOutLine actionPositionOutLine = null;
    /**
     * output class constructor
     */
    public AbstractHRPositionEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractHRPositionEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        positionOfPersonPK = new MetaDataPK("com.kingdee.eas.basedata.org.app", "PositionOfPerson");
        positionRespListQueryPK = new MetaDataPK("com.kingdee.eas.hr.org.app", "PositionRespListQuery");
        positionOfPosiQualPK = new MetaDataPK("com.kingdee.eas.hr.org.app", "PositionOfPosiQual");
        predecessorPersonQueryPK = new MetaDataPK("com.kingdee.eas.hr.org.app", "PredecessorPersonQuery");
        queryChildPositionPersonQueryPK = new MetaDataPK("com.kingdee.eas.hr.org.app", "ChildPositionPersonQuery");
        //actionPositionOutLine
        this.actionPositionOutLine = new ActionPositionOutLine(this);
        getActionManager().registerAction("actionPositionOutLine", actionPositionOutLine);
         this.actionPositionOutLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPositionOutLine.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPositionOutLine.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        this.labName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.positionTabPanel = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDFilterTextField();
        this.basePanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.posiQualPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.respPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.personPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.competIndexPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.predecessorPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.ChildPositionPersonPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.positionOtherPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.labDescription = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnDefaultPosition = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.labAdminOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labJob = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labEffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labValiDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangArea();
        this.labPositionPlan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labPositionType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbltPositionLdapProp = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lblFluCheckTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lblSuperPositionNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.bizPromptSuperPosition = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptAdminOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptJob = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.dateEffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dateValiDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtPositionPlan = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.bizPromptPositionType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtPositionLdapProp = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtFluCheckTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSuperPositionNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.tblPosiQual = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnDelPosiQual = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnImportPosiQual = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAddPosiQual = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUpdatePosiQual = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tblResponsibility = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnDelResp = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnImportResp = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUpdateResp = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAddResp = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tblPersonList = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.tblCompetIndex = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnInsert = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnDel = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tblPredecessor = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.tblChildPositionPerson = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdlHierarchyName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdlPositionHierarchyLevel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdcHierarchyName = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kdcPositionHierarchyLevel = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDSplitPane1 = new com.kingdee.bos.ctrl.swing.KDSplitPane();
        this.kdcontOtherUp = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kdContOtherDown = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.tblPositionOtherUp = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnAddUp = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRemoveUp = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tblPositonOtherDown = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnAddDown = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRemveDown = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnPositionOutLine = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.menuItemPositionOutLine = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.labName.setName("labName");
        this.labNumber.setName("labNumber");
        this.positionTabPanel.setName("positionTabPanel");
        this.txtName.setName("txtName");
        this.txtNumber.setName("txtNumber");
        this.basePanel.setName("basePanel");
        this.posiQualPanel.setName("posiQualPanel");
        this.respPanel.setName("respPanel");
        this.personPanel.setName("personPanel");
        this.competIndexPanel.setName("competIndexPanel");
        this.predecessorPanel.setName("predecessorPanel");
        this.ChildPositionPersonPanel.setName("ChildPositionPersonPanel");
        this.positionOtherPanel.setName("positionOtherPanel");
        this.labDescription.setName("labDescription");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.btnDefaultPosition.setName("btnDefaultPosition");
        this.labAdminOrgUnit.setName("labAdminOrgUnit");
        this.labJob.setName("labJob");
        this.labEffectDate.setName("labEffectDate");
        this.labValiDate.setName("labValiDate");
        this.txtDescription.setName("txtDescription");
        this.labPositionPlan.setName("labPositionPlan");
        this.labPositionType.setName("labPositionType");
        this.lbltPositionLdapProp.setName("lbltPositionLdapProp");
        this.lblFluCheckTime.setName("lblFluCheckTime");
        this.lblSuperPositionNumber.setName("lblSuperPositionNumber");
        this.bizPromptSuperPosition.setName("bizPromptSuperPosition");
        this.bizPromptAdminOrgUnit.setName("bizPromptAdminOrgUnit");
        this.bizPromptJob.setName("bizPromptJob");
        this.dateEffectDate.setName("dateEffectDate");
        this.dateValiDate.setName("dateValiDate");
        this.txtPositionPlan.setName("txtPositionPlan");
        this.bizPromptPositionType.setName("bizPromptPositionType");
        this.prmtPositionLdapProp.setName("prmtPositionLdapProp");
        this.txtFluCheckTime.setName("txtFluCheckTime");
        this.txtSuperPositionNumber.setName("txtSuperPositionNumber");
        this.tblPosiQual.setName("tblPosiQual");
        this.btnDelPosiQual.setName("btnDelPosiQual");
        this.btnImportPosiQual.setName("btnImportPosiQual");
        this.btnAddPosiQual.setName("btnAddPosiQual");
        this.btnUpdatePosiQual.setName("btnUpdatePosiQual");
        this.tblResponsibility.setName("tblResponsibility");
        this.btnDelResp.setName("btnDelResp");
        this.btnImportResp.setName("btnImportResp");
        this.btnUpdateResp.setName("btnUpdateResp");
        this.btnAddResp.setName("btnAddResp");
        this.tblPersonList.setName("tblPersonList");
        this.tblCompetIndex.setName("tblCompetIndex");
        this.btnInsert.setName("btnInsert");
        this.btnDel.setName("btnDel");
        this.tblPredecessor.setName("tblPredecessor");
        this.tblChildPositionPerson.setName("tblChildPositionPerson");
        this.kdlHierarchyName.setName("kdlHierarchyName");
        this.kdlPositionHierarchyLevel.setName("kdlPositionHierarchyLevel");
        this.kdcHierarchyName.setName("kdcHierarchyName");
        this.kdcPositionHierarchyLevel.setName("kdcPositionHierarchyLevel");
        this.kDSplitPane1.setName("kDSplitPane1");
        this.kdcontOtherUp.setName("kdcontOtherUp");
        this.kdContOtherDown.setName("kdContOtherDown");
        this.tblPositionOtherUp.setName("tblPositionOtherUp");
        this.btnAddUp.setName("btnAddUp");
        this.btnRemoveUp.setName("btnRemoveUp");
        this.tblPositonOtherDown.setName("tblPositonOtherDown");
        this.btnAddDown.setName("btnAddDown");
        this.btnRemveDown.setName("btnRemveDown");
        this.btnPositionOutLine.setName("btnPositionOutLine");
        this.menuItemPositionOutLine.setName("menuItemPositionOutLine");
        // CoreUI		
        this.setBorder(null);		
        this.btnSave.setVisible(false);		
        this.btnCancelCancel.setVisible(false);		
        this.btnCancel.setVisible(false);		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);
        // labName		
        this.labName.setBoundLabelText(resHelper.getString("labName.boundLabelText"));		
        this.labName.setBoundLabelLength(100);		
        this.labName.setBoundLabelUnderline(true);
        // labNumber		
        this.labNumber.setBoundLabelText(resHelper.getString("labNumber.boundLabelText"));		
        this.labNumber.setBoundLabelLength(100);		
        this.labNumber.setBoundLabelUnderline(true);
        // positionTabPanel
        // txtName		
        this.txtName.setMaxLength(80);		
        this.txtName.setRequired(true);
        // txtNumber		
        this.txtNumber.setText(resHelper.getString("txtNumber.text"));		
        this.txtNumber.setFilterType(-1);		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // basePanel
        // posiQualPanel
        // respPanel
        // personPanel
        // competIndexPanel
        // predecessorPanel
        // ChildPositionPersonPanel
        // positionOtherPanel
        // labDescription		
        this.labDescription.setText(resHelper.getString("labDescription.text"));
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // btnDefaultPosition		
        this.btnDefaultPosition.setText(resHelper.getString("btnDefaultPosition.text"));
        this.btnDefaultPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnDefaultPosition_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // labAdminOrgUnit		
        this.labAdminOrgUnit.setBoundLabelText(resHelper.getString("labAdminOrgUnit.boundLabelText"));		
        this.labAdminOrgUnit.setBoundLabelLength(100);		
        this.labAdminOrgUnit.setBoundLabelUnderline(true);
        // labJob		
        this.labJob.setBoundLabelText(resHelper.getString("labJob.boundLabelText"));		
        this.labJob.setBoundLabelLength(100);		
        this.labJob.setBoundLabelUnderline(true);
        // labEffectDate		
        this.labEffectDate.setBoundLabelText(resHelper.getString("labEffectDate.boundLabelText"));		
        this.labEffectDate.setBoundLabelLength(100);		
        this.labEffectDate.setBoundLabelUnderline(true);
        // labValiDate		
        this.labValiDate.setBoundLabelText(resHelper.getString("labValiDate.boundLabelText"));		
        this.labValiDate.setBoundLabelUnderline(true);		
        this.labValiDate.setBoundLabelLength(100);		
        this.labValiDate.setEnabled(false);
        // txtDescription		
        this.txtDescription.setMaxLength(250);
        // labPositionPlan		
        this.labPositionPlan.setBoundLabelText(resHelper.getString("labPositionPlan.boundLabelText"));		
        this.labPositionPlan.setBoundLabelUnderline(true);		
        this.labPositionPlan.setBoundLabelLength(100);		
        this.labPositionPlan.setEnabled(false);
        // labPositionType		
        this.labPositionType.setBoundLabelText(resHelper.getString("labPositionType.boundLabelText"));		
        this.labPositionType.setBoundLabelLength(100);		
        this.labPositionType.setBoundLabelUnderline(true);
        // lbltPositionLdapProp		
        this.lbltPositionLdapProp.setBoundLabelText(resHelper.getString("lbltPositionLdapProp.boundLabelText"));		
        this.lbltPositionLdapProp.setBoundLabelLength(100);		
        this.lbltPositionLdapProp.setBoundLabelUnderline(true);
        // lblFluCheckTime		
        this.lblFluCheckTime.setBoundLabelText(resHelper.getString("lblFluCheckTime.boundLabelText"));		
        this.lblFluCheckTime.setBoundLabelUnderline(true);		
        this.lblFluCheckTime.setBoundLabelLength(100);		
        this.lblFluCheckTime.setVisible(false);
        // lblSuperPositionNumber		
        this.lblSuperPositionNumber.setBoundLabelText(resHelper.getString("lblSuperPositionNumber.boundLabelText"));		
        this.lblSuperPositionNumber.setBoundLabelLength(100);		
        this.lblSuperPositionNumber.setBoundLabelUnderline(true);
        // bizPromptSuperPosition		
        this.bizPromptSuperPosition.setEditable(true);		
        this.bizPromptSuperPosition.setRequired(true);
        this.bizPromptSuperPosition.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    bizPromptSuperPosition_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // bizPromptAdminOrgUnit		
        this.bizPromptAdminOrgUnit.setEditable(true);		
        this.bizPromptAdminOrgUnit.setRequired(true);		
        this.bizPromptAdminOrgUnit.setEnabled(false);
        // bizPromptJob		
        this.bizPromptJob.setEditable(true);
        // dateEffectDate
        // dateValiDate		
        this.dateValiDate.setEnabled(false);
        // txtPositionPlan		
        this.txtPositionPlan.setText(resHelper.getString("txtPositionPlan.text"));		
        this.txtPositionPlan.setEnabled(false);		
        this.txtPositionPlan.setEditable(false);
        // bizPromptPositionType
        // prmtPositionLdapProp		
        this.prmtPositionLdapProp.setDisplayFormat("$name$");		
        this.prmtPositionLdapProp.setEditFormat("$number$");		
        this.prmtPositionLdapProp.setCommitFormat("$number$");		
        this.prmtPositionLdapProp.setQueryInfo("com.kingdee.eas.hr.base.app.PositionTypeLdapQuery");
        // txtFluCheckTime
        // txtSuperPositionNumber		
        this.txtSuperPositionNumber.setEnabled(false);
        // tblPosiQual
		String tblPosiQualStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"false\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"type\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"description\" t:width=\"213\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{type}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblPosiQual.setFormatXml(resHelper.translateString("tblPosiQual",tblPosiQualStrXML));
                this.tblPosiQual.putBindContents("positionOfPosiQual",new String[] {"posiQualificationId","posiQualificationNumber","posiQualificationName","posiQualificationType","posiQualificationDescription"});

        this.tblPosiQual.addRequestRowSetListener(new RequestRowSetListener() {
            public void doRequestRowSet(RequestRowSetEvent e) {
                tblPosiQual_doRequestRowSet(e);
            }
        });

        this.tblPosiQual.checkParsed();
        // btnDelPosiQual		
        this.btnDelPosiQual.setText(resHelper.getString("btnDelPosiQual.text"));		
        this.btnDelPosiQual.setToolTipText(resHelper.getString("btnDelPosiQual.toolTipText"));
        this.btnDelPosiQual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnDelPosiQual_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnImportPosiQual		
        this.btnImportPosiQual.setText(resHelper.getString("btnImportPosiQual.text"));		
        this.btnImportPosiQual.setToolTipText(resHelper.getString("btnImportPosiQual.toolTipText"));
        this.btnImportPosiQual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnImportPosiQual_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnAddPosiQual		
        this.btnAddPosiQual.setToolTipText(resHelper.getString("btnAddPosiQual.toolTipText"));
        this.btnAddPosiQual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnAddPosiQual_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnUpdatePosiQual		
        this.btnUpdatePosiQual.setToolTipText(resHelper.getString("btnUpdatePosiQual.toolTipText"));
        this.btnUpdatePosiQual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnUpdatePosiQual_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // tblResponsibility
		String tblResponsibilityStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"false\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"description\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"job\" t:width=\"210\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{job}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblResponsibility.setFormatXml(resHelper.translateString("tblResponsibility",tblResponsibilityStrXML));
        this.tblResponsibility.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    tblResponsibility_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.tblResponsibility.addKDTSelectListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener() {
            public void tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) {
                try {
                    tblResponsibility_tableSelectChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
                this.tblResponsibility.putBindContents("positionRespListQuery",new String[] {"responsibilityId","responsibilityNumber","responsibilityName","responsibilityDescription","responsibilityWorkTask"});

        this.tblResponsibility.addRequestRowSetListener(new RequestRowSetListener() {
            public void doRequestRowSet(RequestRowSetEvent e) {
                tblResponsibility_doRequestRowSet(e);
            }
        });

        this.tblResponsibility.checkParsed();
        // btnDelResp		
        this.btnDelResp.setText(resHelper.getString("btnDelResp.text"));		
        this.btnDelResp.setToolTipText(resHelper.getString("btnDelResp.toolTipText"));
        this.btnDelResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnDelResp_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnImportResp		
        this.btnImportResp.setText(resHelper.getString("btnImportResp.text"));		
        this.btnImportResp.setToolTipText(resHelper.getString("btnImportResp.toolTipText"));
        this.btnImportResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnImportResp_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnUpdateResp		
        this.btnUpdateResp.setToolTipText(resHelper.getString("btnUpdateResp.toolTipText"));
        this.btnUpdateResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnUpdateResp_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnAddResp		
        this.btnAddResp.setToolTipText(resHelper.getString("btnAddResp.toolTipText"));
        this.btnAddResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnAddResp_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // tblPersonList
		String tblPersonListStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"false\" t:group=\"false\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" /><t:Column t:key=\"state\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" /><t:Column t:key=\"name\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{state}</t:Cell><t:Cell>$Resource{name}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblPersonList.setFormatXml(resHelper.translateString("tblPersonList",tblPersonListStrXML));
        this.tblPersonList.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    tblPersonList_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
                this.tblPersonList.putBindContents("positionOfPerson",new String[] {"id","number","PH.isPrimary","name"});

        this.tblPersonList.addRequestRowSetListener(new RequestRowSetListener() {
            public void doRequestRowSet(RequestRowSetEvent e) {
                tblPersonList_doRequestRowSet(e);
            }
        });

        this.tblPersonList.checkParsed();
        // tblCompetIndex
		String tblCompetIndexStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"false\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"competIndex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"type\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"indexGrade\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"priority\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"description\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"isInherit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"false\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{competIndex}</t:Cell><t:Cell>$Resource{type}</t:Cell><t:Cell>$Resource{indexGrade}</t:Cell><t:Cell>$Resource{priority}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{isInherit}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblCompetIndex.setFormatXml(resHelper.translateString("tblCompetIndex",tblCompetIndexStrXML));

        

        this.tblCompetIndex.checkParsed();
        // btnInsert		
        this.btnInsert.setText(resHelper.getString("btnInsert.text"));		
        this.btnInsert.setToolTipText(resHelper.getString("btnInsert.toolTipText"));
        this.btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnInsert_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnDel		
        this.btnDel.setText(resHelper.getString("btnDel.text"));		
        this.btnDel.setToolTipText(resHelper.getString("btnDel.toolTipText"));
        this.btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnDel_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // tblPredecessor
		String tblPredecessorStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"false\" t:group=\"false\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" /><t:Column t:key=\"adminOrg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" /><t:Column t:key=\"position\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" /><t:Column t:key=\"type\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{adminOrg}</t:Cell><t:Cell>$Resource{position}</t:Cell><t:Cell>$Resource{type}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblPredecessor.setFormatXml(resHelper.translateString("tblPredecessor",tblPredecessorStrXML));
        this.tblPredecessor.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    tblPredecessor_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
                this.tblPredecessor.putBindContents("predecessorPersonQuery",new String[] {"id","number","name","AdminOrg.name","Position2.name","ET.name"});

        this.tblPredecessor.addRequestRowSetListener(new RequestRowSetListener() {
            public void doRequestRowSet(RequestRowSetEvent e) {
                tblPredecessor_doRequestRowSet(e);
            }
        });

        this.tblPredecessor.checkParsed();
        // tblChildPositionPerson
		String tblChildPositionPersonStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"Person.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"Person.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Person.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"adminOrgUnit.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"job.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"JobLevel.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"JobGrade.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Hierarchy.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"Hierarchy.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"PositionHierarchy.level\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"PositionHierarchy.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"ParentPosition.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"PositionMember.isPrimary\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"hrOrgUnit.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{Person.id}</t:Cell><t:Cell>$Resource{Person.number}</t:Cell><t:Cell>$Resource{Person.name}</t:Cell><t:Cell>$Resource{adminOrgUnit.name}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{job.name}</t:Cell><t:Cell>$Resource{JobLevel.name}</t:Cell><t:Cell>$Resource{JobGrade.name}</t:Cell><t:Cell>$Resource{Hierarchy.id}</t:Cell><t:Cell>$Resource{Hierarchy.name}</t:Cell><t:Cell>$Resource{PositionHierarchy.level}</t:Cell><t:Cell>$Resource{PositionHierarchy.id}</t:Cell><t:Cell>$Resource{ParentPosition.id}</t:Cell><t:Cell>$Resource{PositionMember.isPrimary}</t:Cell><t:Cell>$Resource{hrOrgUnit.id}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblChildPositionPerson.setFormatXml(resHelper.translateString("tblChildPositionPerson",tblChildPositionPersonStrXML));
        this.tblChildPositionPerson.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    tblChildPositionPerson_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
                this.tblChildPositionPerson.putBindContents("queryChildPositionPersonQuery",new String[] {"Person.id","Person.number","Person.name","adminOrgUnit.name","name","job.name","JobLevel.name","JobGrade.name","Hierarchy.id","Hierarchy.name","PositionHierarchy.level","PositionHierarchy.id","ParentPosition.id","PositionMember.isPrimary","hrOrgUnit.id"});

        this.tblChildPositionPerson.addRequestRowSetListener(new RequestRowSetListener() {
            public void doRequestRowSet(RequestRowSetEvent e) {
                tblChildPositionPerson_doRequestRowSet(e);
            }
        });

        this.tblChildPositionPerson.checkParsed();
        // kdlHierarchyName		
        this.kdlHierarchyName.setBoundLabelText(resHelper.getString("kdlHierarchyName.boundLabelText"));		
        this.kdlHierarchyName.setBoundLabelUnderline(true);		
        this.kdlHierarchyName.setBoundLabelLength(110);
        // kdlPositionHierarchyLevel		
        this.kdlPositionHierarchyLevel.setBoundLabelText(resHelper.getString("kdlPositionHierarchyLevel.boundLabelText"));		
        this.kdlPositionHierarchyLevel.setBoundLabelLength(110);		
        this.kdlPositionHierarchyLevel.setBoundLabelUnderline(true);
        // kdcHierarchyName
        this.kdcHierarchyName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                try {
                    kdcHierarchyName_itemStateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // kdcPositionHierarchyLevel		
        this.kdcPositionHierarchyLevel.addItems(EnumUtils.getEnumList("com.kingdee.eas.hr.org.PositionHierarchyEnum").toArray());
        this.kdcPositionHierarchyLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                try {
                    kdcPositionHierarchyLevel_itemStateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // kDSplitPane1		
        this.kDSplitPane1.setOrientation(0);		
        this.kDSplitPane1.setPreferredSize(new Dimension(130,100));		
        this.kDSplitPane1.setDividerLocation(150);
        // kdcontOtherUp		
        this.kdcontOtherUp.setFont(resHelper.getFont("kdcontOtherUp.font"));		
        this.kdcontOtherUp.setEnableActive(false);		
        this.kdcontOtherUp.setTitleStyle(2);
        // kdContOtherDown		
        this.kdContOtherDown.setFont(resHelper.getFont("kdContOtherDown.font"));		
        this.kdContOtherDown.setEnableActive(false);		
        this.kdContOtherDown.setTitleStyle(2);
        // tblPositionOtherUp
		String tblPositionOtherUpStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"description\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"positionId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{positionId}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblPositionOtherUp.setFormatXml(resHelper.translateString("tblPositionOtherUp",tblPositionOtherUpStrXML));
        this.tblPositionOtherUp.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    tblPositionOtherUp_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

        

        this.tblPositionOtherUp.checkParsed();
        // btnAddUp		
        this.btnAddUp.setToolTipText(resHelper.getString("btnAddUp.toolTipText"));
        this.btnAddUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnAddUp_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnRemoveUp		
        this.btnRemoveUp.setToolTipText(resHelper.getString("btnRemoveUp.toolTipText"));
        this.btnRemoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnRemoveUp_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // tblPositonOtherDown
		String tblPositonOtherDownStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"description\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"positionId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{positionId}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblPositonOtherDown.setFormatXml(resHelper.translateString("tblPositonOtherDown",tblPositonOtherDownStrXML));
        this.tblPositonOtherDown.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    tblPositonOtherDown_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

        

        this.tblPositonOtherDown.checkParsed();
        // btnAddDown		
        this.btnAddDown.setToolTipText(resHelper.getString("btnAddDown.toolTipText"));
        this.btnAddDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnAddDown_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnRemveDown		
        this.btnRemveDown.setToolTipText(resHelper.getString("btnRemveDown.toolTipText"));
        this.btnRemveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnRemveDown_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnPositionOutLine
        this.btnPositionOutLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionPositionOutLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnPositionOutLine.setText(resHelper.getString("btnPositionOutLine.text"));		
        this.btnPositionOutLine.setToolTipText(resHelper.getString("btnPositionOutLine.toolTipText"));
        // menuItemPositionOutLine
        this.menuItemPositionOutLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionPositionOutLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemPositionOutLine.setText(resHelper.getString("menuItemPositionOutLine.text"));		
        this.menuItemPositionOutLine.setToolTipText(resHelper.getString("menuItemPositionOutLine.toolTipText"));
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
        this.setBounds(new Rectangle(10, 10, 650, 400));
        this.setLayout(null);
        contHROrg.setBounds(new Rectangle(605, 7, 270, 19));
        this.add(contHROrg, null);
        labName.setBounds(new Rectangle(322, 8, 270, 19));
        this.add(labName, null);
        labNumber.setBounds(new Rectangle(8, 8, 270, 19));
        this.add(labNumber, null);
        positionTabPanel.setBounds(new Rectangle(8, 30, 632, 362));
        this.add(positionTabPanel, null);
        //contHROrg
        contHROrg.setBoundEditor(prmtHROrg);
        //labName
        labName.setBoundEditor(txtName);
        //labNumber
        labNumber.setBoundEditor(txtNumber);
        //positionTabPanel
        positionTabPanel.add(basePanel, resHelper.getString("basePanel.constraints"));
        positionTabPanel.add(posiQualPanel, resHelper.getString("posiQualPanel.constraints"));
        positionTabPanel.add(respPanel, resHelper.getString("respPanel.constraints"));
        positionTabPanel.add(personPanel, resHelper.getString("personPanel.constraints"));
        positionTabPanel.add(competIndexPanel, resHelper.getString("competIndexPanel.constraints"));
        positionTabPanel.add(predecessorPanel, resHelper.getString("predecessorPanel.constraints"));
        positionTabPanel.add(ChildPositionPersonPanel, resHelper.getString("ChildPositionPersonPanel.constraints"));
        positionTabPanel.add(positionOtherPanel, resHelper.getString("positionOtherPanel.constraints"));
        //basePanel
        basePanel.setLayout(new KDLayout());
        basePanel.putClientProperty("OriginalBounds", new Rectangle(0, 0, 631, 329));        labDescription.setBounds(new Rectangle(8, 123, 100, 19));
        basePanel.add(labDescription, new KDLayout.Constraints(8, 123, 100, 19, 0));
        kDLabelContainer1.setBounds(new Rectangle(8, 52, 260, 19));
        basePanel.add(kDLabelContainer1, new KDLayout.Constraints(8, 52, 260, 19, 0));
        btnDefaultPosition.setBounds(new Rectangle(8, 99, 95, 19));
        basePanel.add(btnDefaultPosition, new KDLayout.Constraints(8, 99, 95, 19, 0));
        labAdminOrgUnit.setBounds(new Rectangle(8, 8, 260, 19));
        basePanel.add(labAdminOrgUnit, new KDLayout.Constraints(8, 8, 260, 19, 0));
        labJob.setBounds(new Rectangle(337, 8, 260, 19));
        basePanel.add(labJob, new KDLayout.Constraints(337, 8, 260, 19, 0));
        labEffectDate.setBounds(new Rectangle(8, 30, 260, 19));
        basePanel.add(labEffectDate, new KDLayout.Constraints(8, 30, 260, 19, 0));
        labValiDate.setBounds(new Rectangle(337, 30, 260, 19));
        basePanel.add(labValiDate, new KDLayout.Constraints(337, 30, 260, 19, 0));
        txtDescription.setBounds(new Rectangle(10, 141, 611, 168));
        basePanel.add(txtDescription, new KDLayout.Constraints(10, 141, 611, 168, 0));
        labPositionPlan.setBounds(new Rectangle(337, 75, 260, 19));
        basePanel.add(labPositionPlan, new KDLayout.Constraints(337, 75, 260, 19, 0));
        labPositionType.setBounds(new Rectangle(8, 75, 260, 19));
        basePanel.add(labPositionType, new KDLayout.Constraints(8, 75, 260, 19, 0));
        lbltPositionLdapProp.setBounds(new Rectangle(337, 99, 260, 19));
        basePanel.add(lbltPositionLdapProp, new KDLayout.Constraints(337, 99, 260, 19, 0));
        lblFluCheckTime.setBounds(new Rectangle(112, 99, 180, 19));
        basePanel.add(lblFluCheckTime, new KDLayout.Constraints(112, 99, 180, 19, 0));
        lblSuperPositionNumber.setBounds(new Rectangle(336, 52, 260, 19));
        basePanel.add(lblSuperPositionNumber, new KDLayout.Constraints(336, 52, 260, 19, 0));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(bizPromptSuperPosition);
        //labAdminOrgUnit
        labAdminOrgUnit.setBoundEditor(bizPromptAdminOrgUnit);
        //labJob
        labJob.setBoundEditor(bizPromptJob);
        //labEffectDate
        labEffectDate.setBoundEditor(dateEffectDate);
        //labValiDate
        labValiDate.setBoundEditor(dateValiDate);
        //labPositionPlan
        labPositionPlan.setBoundEditor(txtPositionPlan);
        //labPositionType
        labPositionType.setBoundEditor(bizPromptPositionType);
        //lbltPositionLdapProp
        lbltPositionLdapProp.setBoundEditor(prmtPositionLdapProp);
        //lblFluCheckTime
        lblFluCheckTime.setBoundEditor(txtFluCheckTime);
        //lblSuperPositionNumber
        lblSuperPositionNumber.setBoundEditor(txtSuperPositionNumber);
        //posiQualPanel
        posiQualPanel.setLayout(null);        tblPosiQual.setBounds(new Rectangle(8, 30, 615, 295));
        posiQualPanel.add(tblPosiQual, null);
        btnDelPosiQual.setBounds(new Rectangle(570, 8, 22, 19));
        posiQualPanel.add(btnDelPosiQual, null);
        btnImportPosiQual.setBounds(new Rectangle(540, 8, 22, 19));
        posiQualPanel.add(btnImportPosiQual, null);
        btnAddPosiQual.setBounds(new Rectangle(510, 8, 22, 19));
        posiQualPanel.add(btnAddPosiQual, null);
        btnUpdatePosiQual.setBounds(new Rectangle(600, 8, 22, 19));
        posiQualPanel.add(btnUpdatePosiQual, null);
        //respPanel
        respPanel.setLayout(null);        tblResponsibility.setBounds(new Rectangle(8, 30, 615, 295));
        respPanel.add(tblResponsibility, null);
        btnDelResp.setBounds(new Rectangle(570, 8, 22, 19));
        respPanel.add(btnDelResp, null);
        btnImportResp.setBounds(new Rectangle(540, 8, 22, 19));
        respPanel.add(btnImportResp, null);
        btnUpdateResp.setBounds(new Rectangle(599, 8, 22, 19));
        respPanel.add(btnUpdateResp, null);
        btnAddResp.setBounds(new Rectangle(510, 8, 22, 19));
        respPanel.add(btnAddResp, null);
        //personPanel
        personPanel.setLayout(null);        tblPersonList.setBounds(new Rectangle(8, 8, 615, 315));
        personPanel.add(tblPersonList, null);
        //competIndexPanel
        competIndexPanel.setLayout(null);        tblCompetIndex.setBounds(new Rectangle(8, 30, 615, 295));
        competIndexPanel.add(tblCompetIndex, null);
        btnInsert.setBounds(new Rectangle(567, 8, 22, 19));
        competIndexPanel.add(btnInsert, null);
        btnDel.setBounds(new Rectangle(599, 8, 22, 19));
        competIndexPanel.add(btnDel, null);
        //predecessorPanel
        predecessorPanel.setLayout(null);        tblPredecessor.setBounds(new Rectangle(8, 8, 615, 315));
        predecessorPanel.add(tblPredecessor, null);
        //ChildPositionPersonPanel
        ChildPositionPersonPanel.setLayout(null);        tblChildPositionPerson.setBounds(new Rectangle(2, 31, 615, 293));
        ChildPositionPersonPanel.add(tblChildPositionPerson, null);
        kdlHierarchyName.setBounds(new Rectangle(6, 7, 270, 19));
        ChildPositionPersonPanel.add(kdlHierarchyName, null);
        kdlPositionHierarchyLevel.setBounds(new Rectangle(345, 7, 270, 19));
        ChildPositionPersonPanel.add(kdlPositionHierarchyLevel, null);
        //kdlHierarchyName
        kdlHierarchyName.setBoundEditor(kdcHierarchyName);
        //kdlPositionHierarchyLevel
        kdlPositionHierarchyLevel.setBoundEditor(kdcPositionHierarchyLevel);
        //positionOtherPanel
        positionOtherPanel.setLayout(null);        kDSplitPane1.setBounds(new Rectangle(5, 6, 621, 321));
        positionOtherPanel.add(kDSplitPane1, null);
        //kDSplitPane1
        kDSplitPane1.add(kdcontOtherUp, "top");
        kDSplitPane1.add(kdContOtherDown, "bottom");
        //kdcontOtherUp
kdcontOtherUp.getContentPane().setLayout(new BorderLayout(0, 0));        kdcontOtherUp.getContentPane().add(tblPositionOtherUp, BorderLayout.CENTER);
        kdcontOtherUp.getContentPane().add(btnAddUp, BorderLayout.SOUTH);
        kdcontOtherUp.getContentPane().add(btnRemoveUp, BorderLayout.WEST);
        //kdContOtherDown
kdContOtherDown.getContentPane().setLayout(new BorderLayout(0, 0));        kdContOtherDown.getContentPane().add(tblPositonOtherDown, BorderLayout.CENTER);
        kdContOtherDown.getContentPane().add(btnAddDown, BorderLayout.SOUTH);
        kdContOtherDown.getContentPane().add(btnRemveDown, BorderLayout.WEST);

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
        menuView.add(menuItemPositionOutLine);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
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
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnRemove);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnPositionOutLine);
        this.toolBar.add(separatorFW3);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "stringValue");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("adminOrgUnit", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.bizPromptAdminOrgUnit, "data");
		dataBinder.registerBinding("job", com.kingdee.eas.basedata.org.JobInfo.class, this.bizPromptJob, "data");
		dataBinder.registerBinding("effectDate", java.util.Date.class, this.dateEffectDate, "value");
		dataBinder.registerBinding("valiDate", java.util.Date.class, this.dateValiDate, "value");
		dataBinder.registerBinding("PositionType", com.kingdee.eas.basedata.hraux.PositionTypeInfo.class, this.bizPromptPositionType, "data");
		dataBinder.registerBinding("pubProperLdap", com.kingdee.eas.hr.base.PositionTypeLdapInfo.class, this.prmtPositionLdapProp, "data");
		dataBinder.registerBinding("fluCheckTime", int.class, this.txtFluCheckTime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.hr.org.app.HRPositionEditUIHandler";
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
        this.editData = (com.kingdee.eas.basedata.org.PositionInfo)ov;
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(String key, IObjectValue dataObject)
    {
        super.setDataObject(key, dataObject);
        if (key.equalsIgnoreCase("positionOfPerson")) {
            this.positionOfPerson = (EntityViewInfo)dataObject;
		}
        else if (key.equalsIgnoreCase("positionRespListQuery")) {
            this.positionRespListQuery = (EntityViewInfo)dataObject;
		}
        else if (key.equalsIgnoreCase("positionOfPosiQual")) {
            this.positionOfPosiQual = (EntityViewInfo)dataObject;
		}
        else if (key.equalsIgnoreCase("predecessorPersonQuery")) {
            this.predecessorPersonQuery = (EntityViewInfo)dataObject;
		}
        else if (key.equalsIgnoreCase("queryChildPositionPersonQuery")) {
            this.queryChildPositionPersonQuery = (EntityViewInfo)dataObject;
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
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adminOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("job", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("effectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("valiDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PositionType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pubProperLdap", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fluCheckTime", ValidateHelper.ON_SAVE);    		
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
        }
    }

    /**
     * output btnDefaultPosition_actionPerformed method
     */
    protected void btnDefaultPosition_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bizPromptSuperPosition_dataChanged method
     */
    protected void bizPromptSuperPosition_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output tblPosiQual_doRequestRowSet method
     */
    protected void tblPosiQual_doRequestRowSet(RequestRowSetEvent e)
    {
        if (this.positionOfPosiQual != null) {
            int start = ((Integer)e.getParam1()).intValue();
            int length = ((Integer)e.getParam2()).intValue() - start + 1;
            try {
                IQueryExecutor exec = this.getQueryExecutor(this.positionOfPosiQualPK, this.positionOfPosiQual);
                IRowSet rowSet = exec.executeQuery(start,length);
                e.setRowSet(rowSet);
                onGetRowSet(rowSet);
            } catch (Exception ee) {
                handUIException(ee);
            }
        }
    }

    /**
     * output btnDelPosiQual_actionPerformed method
     */
    protected void btnDelPosiQual_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnImportPosiQual_actionPerformed method
     */
    protected void btnImportPosiQual_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnAddPosiQual_actionPerformed method
     */
    protected void btnAddPosiQual_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnUpdatePosiQual_actionPerformed method
     */
    protected void btnUpdatePosiQual_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output tblResponsibility_tableClicked method
     */
    protected void tblResponsibility_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
    }

    /**
     * output tblResponsibility_tableSelectChanged method
     */
    protected void tblResponsibility_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
    }

    /**
     * output tblResponsibility_doRequestRowSet method
     */
    protected void tblResponsibility_doRequestRowSet(RequestRowSetEvent e)
    {
        if (this.positionRespListQuery != null) {
            int start = ((Integer)e.getParam1()).intValue();
            int length = ((Integer)e.getParam2()).intValue() - start + 1;
            try {
                IQueryExecutor exec = this.getQueryExecutor(this.positionRespListQueryPK, this.positionRespListQuery);
                IRowSet rowSet = exec.executeQuery(start,length);
                e.setRowSet(rowSet);
                onGetRowSet(rowSet);
            } catch (Exception ee) {
                handUIException(ee);
            }
        }
    }

    /**
     * output btnDelResp_actionPerformed method
     */
    protected void btnDelResp_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnImportResp_actionPerformed method
     */
    protected void btnImportResp_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnUpdateResp_actionPerformed method
     */
    protected void btnUpdateResp_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnAddResp_actionPerformed method
     */
    protected void btnAddResp_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output tblPersonList_tableClicked method
     */
    protected void tblPersonList_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
    }

    /**
     * output tblPersonList_doRequestRowSet method
     */
    protected void tblPersonList_doRequestRowSet(RequestRowSetEvent e)
    {
        if (this.positionOfPerson != null) {
            int start = ((Integer)e.getParam1()).intValue();
            int length = ((Integer)e.getParam2()).intValue() - start + 1;
            try {
                IQueryExecutor exec = this.getQueryExecutor(this.positionOfPersonPK, this.positionOfPerson);
                IRowSet rowSet = exec.executeQuery(start,length);
                e.setRowSet(rowSet);
                onGetRowSet(rowSet);
            } catch (Exception ee) {
                handUIException(ee);
            }
        }
    }

    /**
     * output btnInsert_actionPerformed method
     */
    protected void btnInsert_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnDel_actionPerformed method
     */
    protected void btnDel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output tblPredecessor_tableClicked method
     */
    protected void tblPredecessor_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
    }

    /**
     * output tblPredecessor_doRequestRowSet method
     */
    protected void tblPredecessor_doRequestRowSet(RequestRowSetEvent e)
    {
        if (this.predecessorPersonQuery != null) {
            int start = ((Integer)e.getParam1()).intValue();
            int length = ((Integer)e.getParam2()).intValue() - start + 1;
            try {
                IQueryExecutor exec = this.getQueryExecutor(this.predecessorPersonQueryPK, this.predecessorPersonQuery);
                IRowSet rowSet = exec.executeQuery(start,length);
                e.setRowSet(rowSet);
                onGetRowSet(rowSet);
            } catch (Exception ee) {
                handUIException(ee);
            }
        }
    }

    /**
     * output tblChildPositionPerson_tableClicked method
     */
    protected void tblChildPositionPerson_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
    }

    /**
     * output tblChildPositionPerson_doRequestRowSet method
     */
    protected void tblChildPositionPerson_doRequestRowSet(RequestRowSetEvent e)
    {
        if (this.queryChildPositionPersonQuery != null) {
            int start = ((Integer)e.getParam1()).intValue();
            int length = ((Integer)e.getParam2()).intValue() - start + 1;
            try {
                IQueryExecutor exec = this.getQueryExecutor(this.queryChildPositionPersonQueryPK, this.queryChildPositionPersonQuery);
                IRowSet rowSet = exec.executeQuery(start,length);
                e.setRowSet(rowSet);
                onGetRowSet(rowSet);
            } catch (Exception ee) {
                handUIException(ee);
            }
        }
    }

    /**
     * output kdcHierarchyName_itemStateChanged method
     */
    protected void kdcHierarchyName_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
    }

    /**
     * output kdcPositionHierarchyLevel_itemStateChanged method
     */
    protected void kdcPositionHierarchyLevel_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
    }

    /**
     * output tblPositionOtherUp_editStopped method
     */
    protected void tblPositionOtherUp_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output btnAddUp_actionPerformed method
     */
    protected void btnAddUp_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnRemoveUp_actionPerformed method
     */
    protected void btnRemoveUp_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output tblPositonOtherDown_editStopped method
     */
    protected void tblPositonOtherDown_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output btnAddDown_actionPerformed method
     */
    protected void btnAddDown_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnRemveDown_actionPerformed method
     */
    protected void btnRemveDown_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }


    /**
     * output getQueryExecutor method
     */
    protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK,EntityViewInfo viewInfo)
    {
        IQueryExecutor exec = QueryExecutorFactory.getRemoteInstance(queryPK);
        exec.setObjectView(viewInfo);
        return exec;
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
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("adminOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("adminOrgUnit.id"));
        	sic.add(new SelectorItemInfo("adminOrgUnit.number"));
        	sic.add(new SelectorItemInfo("adminOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("job.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("job.id"));
        	sic.add(new SelectorItemInfo("job.number"));
        	sic.add(new SelectorItemInfo("job.name"));
		}
        sic.add(new SelectorItemInfo("effectDate"));
        sic.add(new SelectorItemInfo("valiDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PositionType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("PositionType.id"));
        	sic.add(new SelectorItemInfo("PositionType.number"));
        	sic.add(new SelectorItemInfo("PositionType.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pubProperLdap.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pubProperLdap.id"));
        	sic.add(new SelectorItemInfo("pubProperLdap.number"));
        	sic.add(new SelectorItemInfo("pubProperLdap.name"));
		}
        sic.add(new SelectorItemInfo("fluCheckTime"));
        return sic;
    }        
    	

    /**
     * output actionPositionOutLine_actionPerformed method
     */
    public void actionPositionOutLine_actionPerformed(ActionEvent e) throws Exception
    {
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
            innerActionPerformed("eas", AbstractHRPositionEditUI.this, "ActionPositionOutLine", "actionPositionOutLine_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.hr.org.client", "HRPositionEditUI");
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
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }



    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return tblPosiQual;
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