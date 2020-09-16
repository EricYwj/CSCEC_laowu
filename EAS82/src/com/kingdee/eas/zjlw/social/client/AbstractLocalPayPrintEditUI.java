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
public abstract class AbstractLocalPayPrintEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractLocalPayPrintEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojSCNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthYearr;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contProjAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpSecuNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlastName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfirstName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbirthday;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkProj;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcooperation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojNameFr;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprojPri;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbD1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbD2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbM1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbM2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyear1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyear2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contiday1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contiday2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimon1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimon2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contiy1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contiy2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contod1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contod2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contom1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contom2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoy1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoy2;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprojName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtprojSCNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmonthYearr;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtProjAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpSecuNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlastName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfirstName;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbirthday;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtendDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtworkProj;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcooperation;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtprojNameFr;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprojPri;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbD1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbD2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbM1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbM2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbyear1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbyear2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtiday1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtiday2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtimon1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtimon2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtiy1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtiy2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtod1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtod2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtom1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtom2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtoy1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtoy2;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnInitBill;
    protected com.kingdee.eas.zjlw.social.LocalPayPrintInfo editData = null;
    protected ActionInitBill actionInitBill = null;
    /**
     * output class constructor
     */
    public AbstractLocalPayPrintEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractLocalPayPrintEditUI.class.getName());
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
        //actionInitBill
        this.actionInitBill = new ActionInitBill(this);
        getActionManager().registerAction("actionInitBill", actionInitBill);
         this.actionInitBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
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
        this.contprojSCNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthYearr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contProjAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpSecuNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlastName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfirstName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbirthday = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkProj = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcooperation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojNameFr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprojPri = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbD1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbD2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbM1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbM2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyear1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyear2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contiday1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contiday2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimon1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimon2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contiy1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contiy2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contod1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contod2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contom1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contom2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoy1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoy2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtprojName = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtprojSCNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtmonthYearr = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtProjAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpSecuNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtlastName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfirstName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkbirthday = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtendDate = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtworkProj = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcooperation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtprojNameFr = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtprojPri = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbD1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbD2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbM1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbM2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbyear1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbyear2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtiday1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtiday2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtimon1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtimon2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtiy1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtiy2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtod1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtod2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtom1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtom2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtoy1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtoy2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.btnInitBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.contprojSCNum.setName("contprojSCNum");
        this.contmonthYearr.setName("contmonthYearr");
        this.contProjAddress.setName("contProjAddress");
        this.contpSecuNumber.setName("contpSecuNumber");
        this.contlastName.setName("contlastName");
        this.contfirstName.setName("contfirstName");
        this.contbirthday.setName("contbirthday");
        this.contendDate.setName("contendDate");
        this.contworkProj.setName("contworkProj");
        this.contcooperation.setName("contcooperation");
        this.contprojNameFr.setName("contprojNameFr");
        this.contprojPri.setName("contprojPri");
        this.contbD1.setName("contbD1");
        this.contbD2.setName("contbD2");
        this.contbM1.setName("contbM1");
        this.contbM2.setName("contbM2");
        this.contbyear1.setName("contbyear1");
        this.contbyear2.setName("contbyear2");
        this.contiday1.setName("contiday1");
        this.contiday2.setName("contiday2");
        this.contimon1.setName("contimon1");
        this.contimon2.setName("contimon2");
        this.contiy1.setName("contiy1");
        this.contiy2.setName("contiy2");
        this.contod1.setName("contod1");
        this.contod2.setName("contod2");
        this.contom1.setName("contom1");
        this.contom2.setName("contom2");
        this.contoy1.setName("contoy1");
        this.contoy2.setName("contoy2");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtprojName.setName("prmtprojName");
        this.txtprojSCNum.setName("txtprojSCNum");
        this.prmtmonthYearr.setName("prmtmonthYearr");
        this.txtProjAddress.setName("txtProjAddress");
        this.txtpSecuNumber.setName("txtpSecuNumber");
        this.txtlastName.setName("txtlastName");
        this.txtfirstName.setName("txtfirstName");
        this.pkbirthday.setName("pkbirthday");
        this.prmtendDate.setName("prmtendDate");
        this.prmtworkProj.setName("prmtworkProj");
        this.prmtcooperation.setName("prmtcooperation");
        this.txtprojNameFr.setName("txtprojNameFr");
        this.prmtprojPri.setName("prmtprojPri");
        this.txtbD1.setName("txtbD1");
        this.txtbD2.setName("txtbD2");
        this.txtbM1.setName("txtbM1");
        this.txtbM2.setName("txtbM2");
        this.txtbyear1.setName("txtbyear1");
        this.txtbyear2.setName("txtbyear2");
        this.txtiday1.setName("txtiday1");
        this.txtiday2.setName("txtiday2");
        this.txtimon1.setName("txtimon1");
        this.txtimon2.setName("txtimon2");
        this.txtiy1.setName("txtiy1");
        this.txtiy2.setName("txtiy2");
        this.txtod1.setName("txtod1");
        this.txtod2.setName("txtod2");
        this.txtom1.setName("txtom1");
        this.txtom2.setName("txtom2");
        this.txtoy1.setName("txtoy1");
        this.txtoy2.setName("txtoy2");
        this.btnInitBill.setName("btnInitBill");
        // CoreUI		
        this.setEnabled(false);		
        this.setVisible(false);		
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
        this.contCreator.setVisible(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contCreateTime.setVisible(false);
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
        this.contNumber.setEnabled(false);		
        this.contNumber.setVisible(false);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(false);		
        this.contBizDate.setEnabled(false);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contDescription.setEnabled(false);		
        this.contDescription.setVisible(false);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setEnabled(false);		
        this.contAuditor.setVisible(false);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol45\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol46\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol47\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol48\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol49\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol50\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol51\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol52\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol53\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol55\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol56\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol58\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol59\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol60\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol61\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol62\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol63\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol64\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol65\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol66\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol67\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol68\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol69\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol70\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol71\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol72\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol73\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol74\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol75\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol76\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol77\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol78\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol79\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol80\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol81\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol82\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol84\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"maritalStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"country\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"enterDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"secuProf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"basePay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"nWorkDay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"attMthWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"seniWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"nmlBsWgPerHour\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"normalOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"hldBsWgPerHour\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"festOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"totNmlBsWg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"totHldBsWg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"phoneWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"traWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"eatWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"urgeWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"oneTimeWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"bTripWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"riskWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"disasWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"langWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"thingsWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"oneWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"nWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"itmperieTol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"switchWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"areaWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"faraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"liveWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"FamilyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"studyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"fireWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"retirWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"pOverAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"spendWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"grossPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"SociaLevyBase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"secuDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"vacaDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"IRGLBaseW\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"IRGDeduction\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"totCharge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"netPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"soLevyBaseW\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"IRGLBase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol49\" /><t:Column t:key=\"IRGDPerson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol50\" /><t:Column t:key=\"coopCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"securityNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol52\" /><t:Column t:key=\"CCPNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol53\" /><t:Column t:key=\"foriPersID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workProgram\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol55\" /><t:Column t:key=\"cooperation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol56\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"profWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol58\" /><t:Column t:key=\"extProfWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol59\" /><t:Column t:key=\"aftTaxPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol60\" /><t:Column t:key=\"persTax\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol61\" /><t:Column t:key=\"posiPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /><t:Column t:key=\"chineWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol63\" /><t:Column t:key=\"algerWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol64\" /><t:Column t:key=\"unSignWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol65\" /><t:Column t:key=\"profAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol66\" /><t:Column t:key=\"monthAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol67\" /><t:Column t:key=\"indPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol68\" /><t:Column t:key=\"wifeUnWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol69\" /><t:Column t:key=\"unSCVCWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol70\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol71\" /><t:Column t:key=\"prof\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol72\" /><t:Column t:key=\"position\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol73\" /><t:Column t:key=\"absence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol74\" /><t:Column t:key=\"absDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol75\" /><t:Column t:key=\"moreOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol76\" /><t:Column t:key=\"overTraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol77\" /><t:Column t:key=\"monthWork\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol78\" /><t:Column t:key=\"abcdefg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol79\" /><t:Column t:key=\"aaa\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol80\" /><t:Column t:key=\"indate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol81\" /><t:Column t:key=\"outdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol82\" /><t:Column t:key=\"secuProfFr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"birthdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol84\" /><t:Column t:key=\"cfbirthplace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"monthYear\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fadd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{maritalStatus}</t:Cell><t:Cell>$Resource{country}</t:Cell><t:Cell>$Resource{enterDate}</t:Cell><t:Cell>$Resource{secuProf}</t:Cell><t:Cell>$Resource{basePay}</t:Cell><t:Cell>$Resource{nWorkDay}</t:Cell><t:Cell>$Resource{attMthWage}</t:Cell><t:Cell>$Resource{seniWage}</t:Cell><t:Cell>$Resource{nmlBsWgPerHour}</t:Cell><t:Cell>$Resource{normalOver}</t:Cell><t:Cell>$Resource{hldBsWgPerHour}</t:Cell><t:Cell>$Resource{festOver}</t:Cell><t:Cell>$Resource{totNmlBsWg}</t:Cell><t:Cell>$Resource{totHldBsWg}</t:Cell><t:Cell>$Resource{phoneWageC}</t:Cell><t:Cell>$Resource{traWage}</t:Cell><t:Cell>$Resource{eatWage}</t:Cell><t:Cell>$Resource{urgeWage}</t:Cell><t:Cell>$Resource{oneTimeWage}</t:Cell><t:Cell>$Resource{bTripWage}</t:Cell><t:Cell>$Resource{riskWage}</t:Cell><t:Cell>$Resource{disasWage}</t:Cell><t:Cell>$Resource{langWage}</t:Cell><t:Cell>$Resource{thingsWage}</t:Cell><t:Cell>$Resource{oneWorkWage}</t:Cell><t:Cell>$Resource{nWorkWage}</t:Cell><t:Cell>$Resource{itmperieTol}</t:Cell><t:Cell>$Resource{switchWage}</t:Cell><t:Cell>$Resource{areaWage}</t:Cell><t:Cell>$Resource{faraWage}</t:Cell><t:Cell>$Resource{liveWage}</t:Cell><t:Cell>$Resource{FamilyWage}</t:Cell><t:Cell>$Resource{studyWage}</t:Cell><t:Cell>$Resource{fireWage}</t:Cell><t:Cell>$Resource{retirWage}</t:Cell><t:Cell>$Resource{pOverAward}</t:Cell><t:Cell>$Resource{spendWage}</t:Cell><t:Cell>$Resource{grossPay}</t:Cell><t:Cell>$Resource{SociaLevyBase}</t:Cell><t:Cell>$Resource{secuDebit}</t:Cell><t:Cell>$Resource{vacaDebit}</t:Cell><t:Cell>$Resource{IRGLBaseW}</t:Cell><t:Cell>$Resource{IRGDeduction}</t:Cell><t:Cell>$Resource{totCharge}</t:Cell><t:Cell>$Resource{netPay}</t:Cell><t:Cell>$Resource{soLevyBaseW}</t:Cell><t:Cell>$Resource{IRGLBase}</t:Cell><t:Cell>$Resource{IRGDPerson}</t:Cell><t:Cell>$Resource{coopCode}</t:Cell><t:Cell>$Resource{securityNo}</t:Cell><t:Cell>$Resource{CCPNo}</t:Cell><t:Cell>$Resource{foriPersID}</t:Cell><t:Cell>$Resource{workProgram}</t:Cell><t:Cell>$Resource{cooperation}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{profWage}</t:Cell><t:Cell>$Resource{extProfWage}</t:Cell><t:Cell>$Resource{aftTaxPay}</t:Cell><t:Cell>$Resource{persTax}</t:Cell><t:Cell>$Resource{posiPay}</t:Cell><t:Cell>$Resource{chineWage}</t:Cell><t:Cell>$Resource{algerWage}</t:Cell><t:Cell>$Resource{unSignWage}</t:Cell><t:Cell>$Resource{profAward}</t:Cell><t:Cell>$Resource{monthAward}</t:Cell><t:Cell>$Resource{indPay}</t:Cell><t:Cell>$Resource{wifeUnWage}</t:Cell><t:Cell>$Resource{unSCVCWage}</t:Cell><t:Cell>$Resource{personID}</t:Cell><t:Cell>$Resource{prof}</t:Cell><t:Cell>$Resource{position}</t:Cell><t:Cell>$Resource{absence}</t:Cell><t:Cell>$Resource{absDebit}</t:Cell><t:Cell>$Resource{moreOver}</t:Cell><t:Cell>$Resource{overTraWage}</t:Cell><t:Cell>$Resource{monthWork}</t:Cell><t:Cell>$Resource{abcdefg}</t:Cell><t:Cell>$Resource{aaa}</t:Cell><t:Cell>$Resource{indate}</t:Cell><t:Cell>$Resource{outdate}</t:Cell><t:Cell>$Resource{secuProfFr}</t:Cell><t:Cell>$Resource{birthdate}</t:Cell><t:Cell>$Resource{cfbirthplace}</t:Cell><t:Cell>$Resource{monthYear}</t:Cell><t:Cell>$Resource{fadd}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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

                this.kdtEntrys.putBindContents("editData",new String[] {"id","lastName","firstName","maritalStatus","country","enterDate","secuProf","basePay","nWorkDay","attMthWage","seniWage","nmlBsWgPerHour","normalOver","hldBsWgPerHour","festOver","totNmlBsWg","totHldBsWg","phoneWageC","traWage","eatWage","urgeWage","oneTimeWage","bTripWage","riskWage","disasWage","langWage","thingsWage","oneWorkWage","nWorkWage","itmperieTol","switchWage","areaWage","faraWage","liveWage","FamilyWage","studyWage","fireWage","retirWage","pOverAward","spendWage","grossPay","SociaLevyBase","secuDebit","vacaDebit","IRGLBaseW","IRGDeduction","totCharge","netPay","soLevyBaseW","IRGLBase","IRGDPerson","coopCode","securityNo","CCPNo","foriPersID","workProgram","cooperation","remark","profWage","extProfWage","aftTaxPay","persTax","posiPay","chineWage","algerWage","unSignWage","profAward","monthAward","indPay","wifeUnWage","unSCVCWage","personID","prof","position","absence","absDebit","moreOver","overTraWage","monthWork","abcdefg","aaa","indate","outdate","secuProfFr","birthdate","cfbirthplace","monthYear","fadd"});


        this.kdtEntrys.checkParsed();
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
        KDComboBox kdtEntrys_maritalStatus_ComboBox = new KDComboBox();
        kdtEntrys_maritalStatus_ComboBox.setName("kdtEntrys_maritalStatus_ComboBox");
        kdtEntrys_maritalStatus_ComboBox.setVisible(true);
        kdtEntrys_maritalStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.zjlw.certificates.app.mayrStatEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_maritalStatus_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maritalStatus_ComboBox);
        this.kdtEntrys.getColumn("maritalStatus").setEditor(kdtEntrys_maritalStatus_CellEditor);
        final KDBizPromptBox kdtEntrys_country_PromptBox = new KDBizPromptBox();
        kdtEntrys_country_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");
        kdtEntrys_country_PromptBox.setVisible(true);
        kdtEntrys_country_PromptBox.setEditable(true);
        kdtEntrys_country_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_country_PromptBox.setEditFormat("$number$");
        kdtEntrys_country_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_country_CellEditor = new KDTDefaultCellEditor(kdtEntrys_country_PromptBox);
        this.kdtEntrys.getColumn("country").setEditor(kdtEntrys_country_CellEditor);
        ObjectValueRender kdtEntrys_country_OVR = new ObjectValueRender();
        kdtEntrys_country_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("country").setRenderer(kdtEntrys_country_OVR);
        KDDatePicker kdtEntrys_enterDate_DatePicker = new KDDatePicker();
        kdtEntrys_enterDate_DatePicker.setName("kdtEntrys_enterDate_DatePicker");
        kdtEntrys_enterDate_DatePicker.setVisible(true);
        kdtEntrys_enterDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_enterDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_enterDate_DatePicker);
        this.kdtEntrys.getColumn("enterDate").setEditor(kdtEntrys_enterDate_CellEditor);
        final KDBizPromptBox kdtEntrys_secuProf_PromptBox = new KDBizPromptBox();
        kdtEntrys_secuProf_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfQuery");
        kdtEntrys_secuProf_PromptBox.setVisible(true);
        kdtEntrys_secuProf_PromptBox.setEditable(true);
        kdtEntrys_secuProf_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_secuProf_PromptBox.setEditFormat("$number$");
        kdtEntrys_secuProf_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_secuProf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_secuProf_PromptBox);
        this.kdtEntrys.getColumn("secuProf").setEditor(kdtEntrys_secuProf_CellEditor);
        ObjectValueRender kdtEntrys_secuProf_OVR = new ObjectValueRender();
        kdtEntrys_secuProf_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("secuProf").setRenderer(kdtEntrys_secuProf_OVR);
        KDFormattedTextField kdtEntrys_basePay_TextField = new KDFormattedTextField();
        kdtEntrys_basePay_TextField.setName("kdtEntrys_basePay_TextField");
        kdtEntrys_basePay_TextField.setVisible(true);
        kdtEntrys_basePay_TextField.setEditable(true);
        kdtEntrys_basePay_TextField.setHorizontalAlignment(2);
        kdtEntrys_basePay_TextField.setDataType(1);
        	kdtEntrys_basePay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_basePay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_basePay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_basePay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_basePay_TextField);
        this.kdtEntrys.getColumn("basePay").setEditor(kdtEntrys_basePay_CellEditor);
        KDFormattedTextField kdtEntrys_nWorkDay_TextField = new KDFormattedTextField();
        kdtEntrys_nWorkDay_TextField.setName("kdtEntrys_nWorkDay_TextField");
        kdtEntrys_nWorkDay_TextField.setVisible(true);
        kdtEntrys_nWorkDay_TextField.setEditable(true);
        kdtEntrys_nWorkDay_TextField.setHorizontalAlignment(2);
        kdtEntrys_nWorkDay_TextField.setDataType(1);
        	kdtEntrys_nWorkDay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nWorkDay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nWorkDay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nWorkDay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nWorkDay_TextField);
        this.kdtEntrys.getColumn("nWorkDay").setEditor(kdtEntrys_nWorkDay_CellEditor);
        KDFormattedTextField kdtEntrys_attMthWage_TextField = new KDFormattedTextField();
        kdtEntrys_attMthWage_TextField.setName("kdtEntrys_attMthWage_TextField");
        kdtEntrys_attMthWage_TextField.setVisible(true);
        kdtEntrys_attMthWage_TextField.setEditable(true);
        kdtEntrys_attMthWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_attMthWage_TextField.setDataType(1);
        	kdtEntrys_attMthWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_attMthWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_attMthWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_attMthWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_attMthWage_TextField);
        this.kdtEntrys.getColumn("attMthWage").setEditor(kdtEntrys_attMthWage_CellEditor);
        KDFormattedTextField kdtEntrys_seniWage_TextField = new KDFormattedTextField();
        kdtEntrys_seniWage_TextField.setName("kdtEntrys_seniWage_TextField");
        kdtEntrys_seniWage_TextField.setVisible(true);
        kdtEntrys_seniWage_TextField.setEditable(true);
        kdtEntrys_seniWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_seniWage_TextField.setDataType(1);
        	kdtEntrys_seniWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seniWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seniWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seniWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seniWage_TextField);
        this.kdtEntrys.getColumn("seniWage").setEditor(kdtEntrys_seniWage_CellEditor);
        KDFormattedTextField kdtEntrys_nmlBsWgPerHour_TextField = new KDFormattedTextField();
        kdtEntrys_nmlBsWgPerHour_TextField.setName("kdtEntrys_nmlBsWgPerHour_TextField");
        kdtEntrys_nmlBsWgPerHour_TextField.setVisible(true);
        kdtEntrys_nmlBsWgPerHour_TextField.setEditable(true);
        kdtEntrys_nmlBsWgPerHour_TextField.setHorizontalAlignment(2);
        kdtEntrys_nmlBsWgPerHour_TextField.setDataType(1);
        	kdtEntrys_nmlBsWgPerHour_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nmlBsWgPerHour_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nmlBsWgPerHour_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nmlBsWgPerHour_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nmlBsWgPerHour_TextField);
        this.kdtEntrys.getColumn("nmlBsWgPerHour").setEditor(kdtEntrys_nmlBsWgPerHour_CellEditor);
        KDFormattedTextField kdtEntrys_normalOver_TextField = new KDFormattedTextField();
        kdtEntrys_normalOver_TextField.setName("kdtEntrys_normalOver_TextField");
        kdtEntrys_normalOver_TextField.setVisible(true);
        kdtEntrys_normalOver_TextField.setEditable(true);
        kdtEntrys_normalOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_normalOver_TextField.setDataType(1);
        	kdtEntrys_normalOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_normalOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_normalOver_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_normalOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_normalOver_TextField);
        this.kdtEntrys.getColumn("normalOver").setEditor(kdtEntrys_normalOver_CellEditor);
        KDFormattedTextField kdtEntrys_hldBsWgPerHour_TextField = new KDFormattedTextField();
        kdtEntrys_hldBsWgPerHour_TextField.setName("kdtEntrys_hldBsWgPerHour_TextField");
        kdtEntrys_hldBsWgPerHour_TextField.setVisible(true);
        kdtEntrys_hldBsWgPerHour_TextField.setEditable(true);
        kdtEntrys_hldBsWgPerHour_TextField.setHorizontalAlignment(2);
        kdtEntrys_hldBsWgPerHour_TextField.setDataType(1);
        	kdtEntrys_hldBsWgPerHour_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_hldBsWgPerHour_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_hldBsWgPerHour_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_hldBsWgPerHour_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hldBsWgPerHour_TextField);
        this.kdtEntrys.getColumn("hldBsWgPerHour").setEditor(kdtEntrys_hldBsWgPerHour_CellEditor);
        KDFormattedTextField kdtEntrys_festOver_TextField = new KDFormattedTextField();
        kdtEntrys_festOver_TextField.setName("kdtEntrys_festOver_TextField");
        kdtEntrys_festOver_TextField.setVisible(true);
        kdtEntrys_festOver_TextField.setEditable(true);
        kdtEntrys_festOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_festOver_TextField.setDataType(1);
        	kdtEntrys_festOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_festOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_festOver_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_festOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_festOver_TextField);
        this.kdtEntrys.getColumn("festOver").setEditor(kdtEntrys_festOver_CellEditor);
        KDFormattedTextField kdtEntrys_totNmlBsWg_TextField = new KDFormattedTextField();
        kdtEntrys_totNmlBsWg_TextField.setName("kdtEntrys_totNmlBsWg_TextField");
        kdtEntrys_totNmlBsWg_TextField.setVisible(true);
        kdtEntrys_totNmlBsWg_TextField.setEditable(true);
        kdtEntrys_totNmlBsWg_TextField.setHorizontalAlignment(2);
        kdtEntrys_totNmlBsWg_TextField.setDataType(1);
        	kdtEntrys_totNmlBsWg_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totNmlBsWg_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totNmlBsWg_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totNmlBsWg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totNmlBsWg_TextField);
        this.kdtEntrys.getColumn("totNmlBsWg").setEditor(kdtEntrys_totNmlBsWg_CellEditor);
        KDFormattedTextField kdtEntrys_totHldBsWg_TextField = new KDFormattedTextField();
        kdtEntrys_totHldBsWg_TextField.setName("kdtEntrys_totHldBsWg_TextField");
        kdtEntrys_totHldBsWg_TextField.setVisible(true);
        kdtEntrys_totHldBsWg_TextField.setEditable(true);
        kdtEntrys_totHldBsWg_TextField.setHorizontalAlignment(2);
        kdtEntrys_totHldBsWg_TextField.setDataType(1);
        	kdtEntrys_totHldBsWg_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totHldBsWg_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totHldBsWg_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totHldBsWg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totHldBsWg_TextField);
        this.kdtEntrys.getColumn("totHldBsWg").setEditor(kdtEntrys_totHldBsWg_CellEditor);
        KDFormattedTextField kdtEntrys_phoneWageC_TextField = new KDFormattedTextField();
        kdtEntrys_phoneWageC_TextField.setName("kdtEntrys_phoneWageC_TextField");
        kdtEntrys_phoneWageC_TextField.setVisible(true);
        kdtEntrys_phoneWageC_TextField.setEditable(true);
        kdtEntrys_phoneWageC_TextField.setHorizontalAlignment(2);
        kdtEntrys_phoneWageC_TextField.setDataType(1);
        	kdtEntrys_phoneWageC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_phoneWageC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_phoneWageC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_phoneWageC_CellEditor = new KDTDefaultCellEditor(kdtEntrys_phoneWageC_TextField);
        this.kdtEntrys.getColumn("phoneWageC").setEditor(kdtEntrys_phoneWageC_CellEditor);
        KDFormattedTextField kdtEntrys_traWage_TextField = new KDFormattedTextField();
        kdtEntrys_traWage_TextField.setName("kdtEntrys_traWage_TextField");
        kdtEntrys_traWage_TextField.setVisible(true);
        kdtEntrys_traWage_TextField.setEditable(true);
        kdtEntrys_traWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_traWage_TextField.setDataType(1);
        	kdtEntrys_traWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_traWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_traWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_traWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_traWage_TextField);
        this.kdtEntrys.getColumn("traWage").setEditor(kdtEntrys_traWage_CellEditor);
        KDFormattedTextField kdtEntrys_eatWage_TextField = new KDFormattedTextField();
        kdtEntrys_eatWage_TextField.setName("kdtEntrys_eatWage_TextField");
        kdtEntrys_eatWage_TextField.setVisible(true);
        kdtEntrys_eatWage_TextField.setEditable(true);
        kdtEntrys_eatWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_eatWage_TextField.setDataType(1);
        	kdtEntrys_eatWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_eatWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_eatWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_eatWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eatWage_TextField);
        this.kdtEntrys.getColumn("eatWage").setEditor(kdtEntrys_eatWage_CellEditor);
        KDFormattedTextField kdtEntrys_urgeWage_TextField = new KDFormattedTextField();
        kdtEntrys_urgeWage_TextField.setName("kdtEntrys_urgeWage_TextField");
        kdtEntrys_urgeWage_TextField.setVisible(true);
        kdtEntrys_urgeWage_TextField.setEditable(true);
        kdtEntrys_urgeWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_urgeWage_TextField.setDataType(1);
        	kdtEntrys_urgeWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_urgeWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_urgeWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_urgeWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_urgeWage_TextField);
        this.kdtEntrys.getColumn("urgeWage").setEditor(kdtEntrys_urgeWage_CellEditor);
        KDFormattedTextField kdtEntrys_oneTimeWage_TextField = new KDFormattedTextField();
        kdtEntrys_oneTimeWage_TextField.setName("kdtEntrys_oneTimeWage_TextField");
        kdtEntrys_oneTimeWage_TextField.setVisible(true);
        kdtEntrys_oneTimeWage_TextField.setEditable(true);
        kdtEntrys_oneTimeWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_oneTimeWage_TextField.setDataType(1);
        	kdtEntrys_oneTimeWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_oneTimeWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_oneTimeWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_oneTimeWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oneTimeWage_TextField);
        this.kdtEntrys.getColumn("oneTimeWage").setEditor(kdtEntrys_oneTimeWage_CellEditor);
        KDFormattedTextField kdtEntrys_bTripWage_TextField = new KDFormattedTextField();
        kdtEntrys_bTripWage_TextField.setName("kdtEntrys_bTripWage_TextField");
        kdtEntrys_bTripWage_TextField.setVisible(true);
        kdtEntrys_bTripWage_TextField.setEditable(true);
        kdtEntrys_bTripWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_bTripWage_TextField.setDataType(1);
        	kdtEntrys_bTripWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_bTripWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_bTripWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_bTripWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bTripWage_TextField);
        this.kdtEntrys.getColumn("bTripWage").setEditor(kdtEntrys_bTripWage_CellEditor);
        KDFormattedTextField kdtEntrys_riskWage_TextField = new KDFormattedTextField();
        kdtEntrys_riskWage_TextField.setName("kdtEntrys_riskWage_TextField");
        kdtEntrys_riskWage_TextField.setVisible(true);
        kdtEntrys_riskWage_TextField.setEditable(true);
        kdtEntrys_riskWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_riskWage_TextField.setDataType(1);
        	kdtEntrys_riskWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_riskWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_riskWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_riskWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_riskWage_TextField);
        this.kdtEntrys.getColumn("riskWage").setEditor(kdtEntrys_riskWage_CellEditor);
        KDFormattedTextField kdtEntrys_disasWage_TextField = new KDFormattedTextField();
        kdtEntrys_disasWage_TextField.setName("kdtEntrys_disasWage_TextField");
        kdtEntrys_disasWage_TextField.setVisible(true);
        kdtEntrys_disasWage_TextField.setEditable(true);
        kdtEntrys_disasWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_disasWage_TextField.setDataType(1);
        	kdtEntrys_disasWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_disasWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_disasWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_disasWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_disasWage_TextField);
        this.kdtEntrys.getColumn("disasWage").setEditor(kdtEntrys_disasWage_CellEditor);
        KDFormattedTextField kdtEntrys_langWage_TextField = new KDFormattedTextField();
        kdtEntrys_langWage_TextField.setName("kdtEntrys_langWage_TextField");
        kdtEntrys_langWage_TextField.setVisible(true);
        kdtEntrys_langWage_TextField.setEditable(true);
        kdtEntrys_langWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_langWage_TextField.setDataType(1);
        	kdtEntrys_langWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_langWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_langWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_langWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_langWage_TextField);
        this.kdtEntrys.getColumn("langWage").setEditor(kdtEntrys_langWage_CellEditor);
        KDFormattedTextField kdtEntrys_thingsWage_TextField = new KDFormattedTextField();
        kdtEntrys_thingsWage_TextField.setName("kdtEntrys_thingsWage_TextField");
        kdtEntrys_thingsWage_TextField.setVisible(true);
        kdtEntrys_thingsWage_TextField.setEditable(true);
        kdtEntrys_thingsWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_thingsWage_TextField.setDataType(1);
        	kdtEntrys_thingsWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_thingsWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_thingsWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_thingsWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_thingsWage_TextField);
        this.kdtEntrys.getColumn("thingsWage").setEditor(kdtEntrys_thingsWage_CellEditor);
        KDFormattedTextField kdtEntrys_oneWorkWage_TextField = new KDFormattedTextField();
        kdtEntrys_oneWorkWage_TextField.setName("kdtEntrys_oneWorkWage_TextField");
        kdtEntrys_oneWorkWage_TextField.setVisible(true);
        kdtEntrys_oneWorkWage_TextField.setEditable(true);
        kdtEntrys_oneWorkWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_oneWorkWage_TextField.setDataType(1);
        	kdtEntrys_oneWorkWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_oneWorkWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_oneWorkWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_oneWorkWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oneWorkWage_TextField);
        this.kdtEntrys.getColumn("oneWorkWage").setEditor(kdtEntrys_oneWorkWage_CellEditor);
        KDFormattedTextField kdtEntrys_nWorkWage_TextField = new KDFormattedTextField();
        kdtEntrys_nWorkWage_TextField.setName("kdtEntrys_nWorkWage_TextField");
        kdtEntrys_nWorkWage_TextField.setVisible(true);
        kdtEntrys_nWorkWage_TextField.setEditable(true);
        kdtEntrys_nWorkWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_nWorkWage_TextField.setDataType(1);
        	kdtEntrys_nWorkWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_nWorkWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_nWorkWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_nWorkWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nWorkWage_TextField);
        this.kdtEntrys.getColumn("nWorkWage").setEditor(kdtEntrys_nWorkWage_CellEditor);
        KDFormattedTextField kdtEntrys_itmperieTol_TextField = new KDFormattedTextField();
        kdtEntrys_itmperieTol_TextField.setName("kdtEntrys_itmperieTol_TextField");
        kdtEntrys_itmperieTol_TextField.setVisible(true);
        kdtEntrys_itmperieTol_TextField.setEditable(true);
        kdtEntrys_itmperieTol_TextField.setHorizontalAlignment(2);
        kdtEntrys_itmperieTol_TextField.setDataType(1);
        	kdtEntrys_itmperieTol_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_itmperieTol_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_itmperieTol_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_itmperieTol_CellEditor = new KDTDefaultCellEditor(kdtEntrys_itmperieTol_TextField);
        this.kdtEntrys.getColumn("itmperieTol").setEditor(kdtEntrys_itmperieTol_CellEditor);
        KDFormattedTextField kdtEntrys_switchWage_TextField = new KDFormattedTextField();
        kdtEntrys_switchWage_TextField.setName("kdtEntrys_switchWage_TextField");
        kdtEntrys_switchWage_TextField.setVisible(true);
        kdtEntrys_switchWage_TextField.setEditable(true);
        kdtEntrys_switchWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_switchWage_TextField.setDataType(1);
        	kdtEntrys_switchWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_switchWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_switchWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_switchWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_switchWage_TextField);
        this.kdtEntrys.getColumn("switchWage").setEditor(kdtEntrys_switchWage_CellEditor);
        KDFormattedTextField kdtEntrys_areaWage_TextField = new KDFormattedTextField();
        kdtEntrys_areaWage_TextField.setName("kdtEntrys_areaWage_TextField");
        kdtEntrys_areaWage_TextField.setVisible(true);
        kdtEntrys_areaWage_TextField.setEditable(true);
        kdtEntrys_areaWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_areaWage_TextField.setDataType(1);
        	kdtEntrys_areaWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_areaWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_areaWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_areaWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_areaWage_TextField);
        this.kdtEntrys.getColumn("areaWage").setEditor(kdtEntrys_areaWage_CellEditor);
        KDFormattedTextField kdtEntrys_faraWage_TextField = new KDFormattedTextField();
        kdtEntrys_faraWage_TextField.setName("kdtEntrys_faraWage_TextField");
        kdtEntrys_faraWage_TextField.setVisible(true);
        kdtEntrys_faraWage_TextField.setEditable(true);
        kdtEntrys_faraWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_faraWage_TextField.setDataType(1);
        	kdtEntrys_faraWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_faraWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_faraWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_faraWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_faraWage_TextField);
        this.kdtEntrys.getColumn("faraWage").setEditor(kdtEntrys_faraWage_CellEditor);
        KDFormattedTextField kdtEntrys_liveWage_TextField = new KDFormattedTextField();
        kdtEntrys_liveWage_TextField.setName("kdtEntrys_liveWage_TextField");
        kdtEntrys_liveWage_TextField.setVisible(true);
        kdtEntrys_liveWage_TextField.setEditable(true);
        kdtEntrys_liveWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_liveWage_TextField.setDataType(1);
        	kdtEntrys_liveWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_liveWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_liveWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_liveWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_liveWage_TextField);
        this.kdtEntrys.getColumn("liveWage").setEditor(kdtEntrys_liveWage_CellEditor);
        KDFormattedTextField kdtEntrys_FamilyWage_TextField = new KDFormattedTextField();
        kdtEntrys_FamilyWage_TextField.setName("kdtEntrys_FamilyWage_TextField");
        kdtEntrys_FamilyWage_TextField.setVisible(true);
        kdtEntrys_FamilyWage_TextField.setEditable(true);
        kdtEntrys_FamilyWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_FamilyWage_TextField.setDataType(1);
        	kdtEntrys_FamilyWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_FamilyWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_FamilyWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_FamilyWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_FamilyWage_TextField);
        this.kdtEntrys.getColumn("FamilyWage").setEditor(kdtEntrys_FamilyWage_CellEditor);
        KDFormattedTextField kdtEntrys_studyWage_TextField = new KDFormattedTextField();
        kdtEntrys_studyWage_TextField.setName("kdtEntrys_studyWage_TextField");
        kdtEntrys_studyWage_TextField.setVisible(true);
        kdtEntrys_studyWage_TextField.setEditable(true);
        kdtEntrys_studyWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_studyWage_TextField.setDataType(1);
        	kdtEntrys_studyWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_studyWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_studyWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_studyWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_studyWage_TextField);
        this.kdtEntrys.getColumn("studyWage").setEditor(kdtEntrys_studyWage_CellEditor);
        KDFormattedTextField kdtEntrys_fireWage_TextField = new KDFormattedTextField();
        kdtEntrys_fireWage_TextField.setName("kdtEntrys_fireWage_TextField");
        kdtEntrys_fireWage_TextField.setVisible(true);
        kdtEntrys_fireWage_TextField.setEditable(true);
        kdtEntrys_fireWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_fireWage_TextField.setDataType(1);
        	kdtEntrys_fireWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fireWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fireWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fireWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fireWage_TextField);
        this.kdtEntrys.getColumn("fireWage").setEditor(kdtEntrys_fireWage_CellEditor);
        KDFormattedTextField kdtEntrys_retirWage_TextField = new KDFormattedTextField();
        kdtEntrys_retirWage_TextField.setName("kdtEntrys_retirWage_TextField");
        kdtEntrys_retirWage_TextField.setVisible(true);
        kdtEntrys_retirWage_TextField.setEditable(true);
        kdtEntrys_retirWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_retirWage_TextField.setDataType(1);
        	kdtEntrys_retirWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_retirWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_retirWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_retirWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_retirWage_TextField);
        this.kdtEntrys.getColumn("retirWage").setEditor(kdtEntrys_retirWage_CellEditor);
        KDFormattedTextField kdtEntrys_pOverAward_TextField = new KDFormattedTextField();
        kdtEntrys_pOverAward_TextField.setName("kdtEntrys_pOverAward_TextField");
        kdtEntrys_pOverAward_TextField.setVisible(true);
        kdtEntrys_pOverAward_TextField.setEditable(true);
        kdtEntrys_pOverAward_TextField.setHorizontalAlignment(2);
        kdtEntrys_pOverAward_TextField.setDataType(1);
        	kdtEntrys_pOverAward_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_pOverAward_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_pOverAward_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_pOverAward_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pOverAward_TextField);
        this.kdtEntrys.getColumn("pOverAward").setEditor(kdtEntrys_pOverAward_CellEditor);
        KDFormattedTextField kdtEntrys_spendWage_TextField = new KDFormattedTextField();
        kdtEntrys_spendWage_TextField.setName("kdtEntrys_spendWage_TextField");
        kdtEntrys_spendWage_TextField.setVisible(true);
        kdtEntrys_spendWage_TextField.setEditable(true);
        kdtEntrys_spendWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_spendWage_TextField.setDataType(1);
        	kdtEntrys_spendWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_spendWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_spendWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_spendWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_spendWage_TextField);
        this.kdtEntrys.getColumn("spendWage").setEditor(kdtEntrys_spendWage_CellEditor);
        KDFormattedTextField kdtEntrys_grossPay_TextField = new KDFormattedTextField();
        kdtEntrys_grossPay_TextField.setName("kdtEntrys_grossPay_TextField");
        kdtEntrys_grossPay_TextField.setVisible(true);
        kdtEntrys_grossPay_TextField.setEditable(true);
        kdtEntrys_grossPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_grossPay_TextField.setDataType(1);
        	kdtEntrys_grossPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_grossPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_grossPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_grossPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_grossPay_TextField);
        this.kdtEntrys.getColumn("grossPay").setEditor(kdtEntrys_grossPay_CellEditor);
        KDFormattedTextField kdtEntrys_SociaLevyBase_TextField = new KDFormattedTextField();
        kdtEntrys_SociaLevyBase_TextField.setName("kdtEntrys_SociaLevyBase_TextField");
        kdtEntrys_SociaLevyBase_TextField.setVisible(true);
        kdtEntrys_SociaLevyBase_TextField.setEditable(true);
        kdtEntrys_SociaLevyBase_TextField.setHorizontalAlignment(2);
        kdtEntrys_SociaLevyBase_TextField.setDataType(1);
        	kdtEntrys_SociaLevyBase_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_SociaLevyBase_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_SociaLevyBase_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_SociaLevyBase_CellEditor = new KDTDefaultCellEditor(kdtEntrys_SociaLevyBase_TextField);
        this.kdtEntrys.getColumn("SociaLevyBase").setEditor(kdtEntrys_SociaLevyBase_CellEditor);
        KDFormattedTextField kdtEntrys_secuDebit_TextField = new KDFormattedTextField();
        kdtEntrys_secuDebit_TextField.setName("kdtEntrys_secuDebit_TextField");
        kdtEntrys_secuDebit_TextField.setVisible(true);
        kdtEntrys_secuDebit_TextField.setEditable(true);
        kdtEntrys_secuDebit_TextField.setHorizontalAlignment(2);
        kdtEntrys_secuDebit_TextField.setDataType(1);
        	kdtEntrys_secuDebit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_secuDebit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_secuDebit_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_secuDebit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_secuDebit_TextField);
        this.kdtEntrys.getColumn("secuDebit").setEditor(kdtEntrys_secuDebit_CellEditor);
        KDFormattedTextField kdtEntrys_vacaDebit_TextField = new KDFormattedTextField();
        kdtEntrys_vacaDebit_TextField.setName("kdtEntrys_vacaDebit_TextField");
        kdtEntrys_vacaDebit_TextField.setVisible(true);
        kdtEntrys_vacaDebit_TextField.setEditable(true);
        kdtEntrys_vacaDebit_TextField.setHorizontalAlignment(2);
        kdtEntrys_vacaDebit_TextField.setDataType(1);
        	kdtEntrys_vacaDebit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_vacaDebit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_vacaDebit_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_vacaDebit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_vacaDebit_TextField);
        this.kdtEntrys.getColumn("vacaDebit").setEditor(kdtEntrys_vacaDebit_CellEditor);
        KDFormattedTextField kdtEntrys_IRGLBaseW_TextField = new KDFormattedTextField();
        kdtEntrys_IRGLBaseW_TextField.setName("kdtEntrys_IRGLBaseW_TextField");
        kdtEntrys_IRGLBaseW_TextField.setVisible(true);
        kdtEntrys_IRGLBaseW_TextField.setEditable(true);
        kdtEntrys_IRGLBaseW_TextField.setHorizontalAlignment(2);
        kdtEntrys_IRGLBaseW_TextField.setDataType(1);
        	kdtEntrys_IRGLBaseW_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_IRGLBaseW_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_IRGLBaseW_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_IRGLBaseW_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IRGLBaseW_TextField);
        this.kdtEntrys.getColumn("IRGLBaseW").setEditor(kdtEntrys_IRGLBaseW_CellEditor);
        KDFormattedTextField kdtEntrys_IRGDeduction_TextField = new KDFormattedTextField();
        kdtEntrys_IRGDeduction_TextField.setName("kdtEntrys_IRGDeduction_TextField");
        kdtEntrys_IRGDeduction_TextField.setVisible(true);
        kdtEntrys_IRGDeduction_TextField.setEditable(true);
        kdtEntrys_IRGDeduction_TextField.setHorizontalAlignment(2);
        kdtEntrys_IRGDeduction_TextField.setDataType(1);
        	kdtEntrys_IRGDeduction_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_IRGDeduction_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_IRGDeduction_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_IRGDeduction_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IRGDeduction_TextField);
        this.kdtEntrys.getColumn("IRGDeduction").setEditor(kdtEntrys_IRGDeduction_CellEditor);
        KDFormattedTextField kdtEntrys_totCharge_TextField = new KDFormattedTextField();
        kdtEntrys_totCharge_TextField.setName("kdtEntrys_totCharge_TextField");
        kdtEntrys_totCharge_TextField.setVisible(true);
        kdtEntrys_totCharge_TextField.setEditable(true);
        kdtEntrys_totCharge_TextField.setHorizontalAlignment(2);
        kdtEntrys_totCharge_TextField.setDataType(1);
        	kdtEntrys_totCharge_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totCharge_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totCharge_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totCharge_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totCharge_TextField);
        this.kdtEntrys.getColumn("totCharge").setEditor(kdtEntrys_totCharge_CellEditor);
        KDFormattedTextField kdtEntrys_netPay_TextField = new KDFormattedTextField();
        kdtEntrys_netPay_TextField.setName("kdtEntrys_netPay_TextField");
        kdtEntrys_netPay_TextField.setVisible(true);
        kdtEntrys_netPay_TextField.setEditable(true);
        kdtEntrys_netPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_netPay_TextField.setDataType(1);
        	kdtEntrys_netPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_netPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_netPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_netPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_netPay_TextField);
        this.kdtEntrys.getColumn("netPay").setEditor(kdtEntrys_netPay_CellEditor);
        KDFormattedTextField kdtEntrys_soLevyBaseW_TextField = new KDFormattedTextField();
        kdtEntrys_soLevyBaseW_TextField.setName("kdtEntrys_soLevyBaseW_TextField");
        kdtEntrys_soLevyBaseW_TextField.setVisible(true);
        kdtEntrys_soLevyBaseW_TextField.setEditable(true);
        kdtEntrys_soLevyBaseW_TextField.setHorizontalAlignment(2);
        kdtEntrys_soLevyBaseW_TextField.setDataType(1);
        	kdtEntrys_soLevyBaseW_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_soLevyBaseW_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_soLevyBaseW_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_soLevyBaseW_CellEditor = new KDTDefaultCellEditor(kdtEntrys_soLevyBaseW_TextField);
        this.kdtEntrys.getColumn("soLevyBaseW").setEditor(kdtEntrys_soLevyBaseW_CellEditor);
        KDFormattedTextField kdtEntrys_IRGLBase_TextField = new KDFormattedTextField();
        kdtEntrys_IRGLBase_TextField.setName("kdtEntrys_IRGLBase_TextField");
        kdtEntrys_IRGLBase_TextField.setVisible(true);
        kdtEntrys_IRGLBase_TextField.setEditable(true);
        kdtEntrys_IRGLBase_TextField.setHorizontalAlignment(2);
        kdtEntrys_IRGLBase_TextField.setDataType(1);
        	kdtEntrys_IRGLBase_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_IRGLBase_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_IRGLBase_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_IRGLBase_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IRGLBase_TextField);
        this.kdtEntrys.getColumn("IRGLBase").setEditor(kdtEntrys_IRGLBase_CellEditor);
        KDFormattedTextField kdtEntrys_IRGDPerson_TextField = new KDFormattedTextField();
        kdtEntrys_IRGDPerson_TextField.setName("kdtEntrys_IRGDPerson_TextField");
        kdtEntrys_IRGDPerson_TextField.setVisible(true);
        kdtEntrys_IRGDPerson_TextField.setEditable(true);
        kdtEntrys_IRGDPerson_TextField.setHorizontalAlignment(2);
        kdtEntrys_IRGDPerson_TextField.setDataType(1);
        	kdtEntrys_IRGDPerson_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_IRGDPerson_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_IRGDPerson_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_IRGDPerson_CellEditor = new KDTDefaultCellEditor(kdtEntrys_IRGDPerson_TextField);
        this.kdtEntrys.getColumn("IRGDPerson").setEditor(kdtEntrys_IRGDPerson_CellEditor);
        KDTextField kdtEntrys_coopCode_TextField = new KDTextField();
        kdtEntrys_coopCode_TextField.setName("kdtEntrys_coopCode_TextField");
        kdtEntrys_coopCode_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_coopCode_CellEditor = new KDTDefaultCellEditor(kdtEntrys_coopCode_TextField);
        this.kdtEntrys.getColumn("coopCode").setEditor(kdtEntrys_coopCode_CellEditor);
        KDTextField kdtEntrys_securityNo_TextField = new KDTextField();
        kdtEntrys_securityNo_TextField.setName("kdtEntrys_securityNo_TextField");
        kdtEntrys_securityNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_securityNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_securityNo_TextField);
        this.kdtEntrys.getColumn("securityNo").setEditor(kdtEntrys_securityNo_CellEditor);
        KDTextField kdtEntrys_CCPNo_TextField = new KDTextField();
        kdtEntrys_CCPNo_TextField.setName("kdtEntrys_CCPNo_TextField");
        kdtEntrys_CCPNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_CCPNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CCPNo_TextField);
        this.kdtEntrys.getColumn("CCPNo").setEditor(kdtEntrys_CCPNo_CellEditor);
        KDTextField kdtEntrys_foriPersID_TextField = new KDTextField();
        kdtEntrys_foriPersID_TextField.setName("kdtEntrys_foriPersID_TextField");
        kdtEntrys_foriPersID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_foriPersID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_foriPersID_TextField);
        this.kdtEntrys.getColumn("foriPersID").setEditor(kdtEntrys_foriPersID_CellEditor);
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
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        KDFormattedTextField kdtEntrys_profWage_TextField = new KDFormattedTextField();
        kdtEntrys_profWage_TextField.setName("kdtEntrys_profWage_TextField");
        kdtEntrys_profWage_TextField.setVisible(true);
        kdtEntrys_profWage_TextField.setEditable(true);
        kdtEntrys_profWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_profWage_TextField.setDataType(1);
        	kdtEntrys_profWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_profWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_profWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_profWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_profWage_TextField);
        this.kdtEntrys.getColumn("profWage").setEditor(kdtEntrys_profWage_CellEditor);
        KDFormattedTextField kdtEntrys_extProfWage_TextField = new KDFormattedTextField();
        kdtEntrys_extProfWage_TextField.setName("kdtEntrys_extProfWage_TextField");
        kdtEntrys_extProfWage_TextField.setVisible(true);
        kdtEntrys_extProfWage_TextField.setEditable(true);
        kdtEntrys_extProfWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_extProfWage_TextField.setDataType(1);
        	kdtEntrys_extProfWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_extProfWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_extProfWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_extProfWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_extProfWage_TextField);
        this.kdtEntrys.getColumn("extProfWage").setEditor(kdtEntrys_extProfWage_CellEditor);
        KDFormattedTextField kdtEntrys_aftTaxPay_TextField = new KDFormattedTextField();
        kdtEntrys_aftTaxPay_TextField.setName("kdtEntrys_aftTaxPay_TextField");
        kdtEntrys_aftTaxPay_TextField.setVisible(true);
        kdtEntrys_aftTaxPay_TextField.setEditable(true);
        kdtEntrys_aftTaxPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_aftTaxPay_TextField.setDataType(1);
        	kdtEntrys_aftTaxPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_aftTaxPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_aftTaxPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_aftTaxPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_aftTaxPay_TextField);
        this.kdtEntrys.getColumn("aftTaxPay").setEditor(kdtEntrys_aftTaxPay_CellEditor);
        KDFormattedTextField kdtEntrys_persTax_TextField = new KDFormattedTextField();
        kdtEntrys_persTax_TextField.setName("kdtEntrys_persTax_TextField");
        kdtEntrys_persTax_TextField.setVisible(true);
        kdtEntrys_persTax_TextField.setEditable(true);
        kdtEntrys_persTax_TextField.setHorizontalAlignment(2);
        kdtEntrys_persTax_TextField.setDataType(1);
        	kdtEntrys_persTax_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_persTax_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_persTax_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_persTax_CellEditor = new KDTDefaultCellEditor(kdtEntrys_persTax_TextField);
        this.kdtEntrys.getColumn("persTax").setEditor(kdtEntrys_persTax_CellEditor);
        KDFormattedTextField kdtEntrys_posiPay_TextField = new KDFormattedTextField();
        kdtEntrys_posiPay_TextField.setName("kdtEntrys_posiPay_TextField");
        kdtEntrys_posiPay_TextField.setVisible(true);
        kdtEntrys_posiPay_TextField.setEditable(true);
        kdtEntrys_posiPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_posiPay_TextField.setDataType(1);
        	kdtEntrys_posiPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_posiPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_posiPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_posiPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_posiPay_TextField);
        this.kdtEntrys.getColumn("posiPay").setEditor(kdtEntrys_posiPay_CellEditor);
        KDFormattedTextField kdtEntrys_chineWage_TextField = new KDFormattedTextField();
        kdtEntrys_chineWage_TextField.setName("kdtEntrys_chineWage_TextField");
        kdtEntrys_chineWage_TextField.setVisible(true);
        kdtEntrys_chineWage_TextField.setEditable(true);
        kdtEntrys_chineWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_chineWage_TextField.setDataType(1);
        	kdtEntrys_chineWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_chineWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_chineWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_chineWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_chineWage_TextField);
        this.kdtEntrys.getColumn("chineWage").setEditor(kdtEntrys_chineWage_CellEditor);
        KDFormattedTextField kdtEntrys_algerWage_TextField = new KDFormattedTextField();
        kdtEntrys_algerWage_TextField.setName("kdtEntrys_algerWage_TextField");
        kdtEntrys_algerWage_TextField.setVisible(true);
        kdtEntrys_algerWage_TextField.setEditable(true);
        kdtEntrys_algerWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_algerWage_TextField.setDataType(1);
        	kdtEntrys_algerWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_algerWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_algerWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_algerWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_algerWage_TextField);
        this.kdtEntrys.getColumn("algerWage").setEditor(kdtEntrys_algerWage_CellEditor);
        KDTextField kdtEntrys_unSignWage_TextField = new KDTextField();
        kdtEntrys_unSignWage_TextField.setName("kdtEntrys_unSignWage_TextField");
        kdtEntrys_unSignWage_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_unSignWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unSignWage_TextField);
        this.kdtEntrys.getColumn("unSignWage").setEditor(kdtEntrys_unSignWage_CellEditor);
        KDFormattedTextField kdtEntrys_profAward_TextField = new KDFormattedTextField();
        kdtEntrys_profAward_TextField.setName("kdtEntrys_profAward_TextField");
        kdtEntrys_profAward_TextField.setVisible(true);
        kdtEntrys_profAward_TextField.setEditable(true);
        kdtEntrys_profAward_TextField.setHorizontalAlignment(2);
        kdtEntrys_profAward_TextField.setDataType(1);
        	kdtEntrys_profAward_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_profAward_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_profAward_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_profAward_CellEditor = new KDTDefaultCellEditor(kdtEntrys_profAward_TextField);
        this.kdtEntrys.getColumn("profAward").setEditor(kdtEntrys_profAward_CellEditor);
        KDFormattedTextField kdtEntrys_monthAward_TextField = new KDFormattedTextField();
        kdtEntrys_monthAward_TextField.setName("kdtEntrys_monthAward_TextField");
        kdtEntrys_monthAward_TextField.setVisible(true);
        kdtEntrys_monthAward_TextField.setEditable(true);
        kdtEntrys_monthAward_TextField.setHorizontalAlignment(2);
        kdtEntrys_monthAward_TextField.setDataType(1);
        	kdtEntrys_monthAward_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_monthAward_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_monthAward_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_monthAward_CellEditor = new KDTDefaultCellEditor(kdtEntrys_monthAward_TextField);
        this.kdtEntrys.getColumn("monthAward").setEditor(kdtEntrys_monthAward_CellEditor);
        KDFormattedTextField kdtEntrys_indPay_TextField = new KDFormattedTextField();
        kdtEntrys_indPay_TextField.setName("kdtEntrys_indPay_TextField");
        kdtEntrys_indPay_TextField.setVisible(true);
        kdtEntrys_indPay_TextField.setEditable(true);
        kdtEntrys_indPay_TextField.setHorizontalAlignment(2);
        kdtEntrys_indPay_TextField.setDataType(1);
        	kdtEntrys_indPay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_indPay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_indPay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_indPay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_indPay_TextField);
        this.kdtEntrys.getColumn("indPay").setEditor(kdtEntrys_indPay_CellEditor);
        KDFormattedTextField kdtEntrys_wifeUnWage_TextField = new KDFormattedTextField();
        kdtEntrys_wifeUnWage_TextField.setName("kdtEntrys_wifeUnWage_TextField");
        kdtEntrys_wifeUnWage_TextField.setVisible(true);
        kdtEntrys_wifeUnWage_TextField.setEditable(true);
        kdtEntrys_wifeUnWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_wifeUnWage_TextField.setDataType(1);
        	kdtEntrys_wifeUnWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_wifeUnWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_wifeUnWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_wifeUnWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wifeUnWage_TextField);
        this.kdtEntrys.getColumn("wifeUnWage").setEditor(kdtEntrys_wifeUnWage_CellEditor);
        KDFormattedTextField kdtEntrys_unSCVCWage_TextField = new KDFormattedTextField();
        kdtEntrys_unSCVCWage_TextField.setName("kdtEntrys_unSCVCWage_TextField");
        kdtEntrys_unSCVCWage_TextField.setVisible(true);
        kdtEntrys_unSCVCWage_TextField.setEditable(true);
        kdtEntrys_unSCVCWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_unSCVCWage_TextField.setDataType(1);
        	kdtEntrys_unSCVCWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unSCVCWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unSCVCWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unSCVCWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unSCVCWage_TextField);
        this.kdtEntrys.getColumn("unSCVCWage").setEditor(kdtEntrys_unSCVCWage_CellEditor);
        KDTextField kdtEntrys_personID_TextField = new KDTextField();
        kdtEntrys_personID_TextField.setName("kdtEntrys_personID_TextField");
        kdtEntrys_personID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_personID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personID_TextField);
        this.kdtEntrys.getColumn("personID").setEditor(kdtEntrys_personID_CellEditor);
        final KDBizPromptBox kdtEntrys_prof_PromptBox = new KDBizPromptBox();
        kdtEntrys_prof_PromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");
        kdtEntrys_prof_PromptBox.setVisible(true);
        kdtEntrys_prof_PromptBox.setEditable(true);
        kdtEntrys_prof_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_prof_PromptBox.setEditFormat("$number$");
        kdtEntrys_prof_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_prof_CellEditor = new KDTDefaultCellEditor(kdtEntrys_prof_PromptBox);
        this.kdtEntrys.getColumn("prof").setEditor(kdtEntrys_prof_CellEditor);
        ObjectValueRender kdtEntrys_prof_OVR = new ObjectValueRender();
        kdtEntrys_prof_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("prof").setRenderer(kdtEntrys_prof_OVR);
        KDTextField kdtEntrys_position_TextField = new KDTextField();
        kdtEntrys_position_TextField.setName("kdtEntrys_position_TextField");
        kdtEntrys_position_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_position_CellEditor = new KDTDefaultCellEditor(kdtEntrys_position_TextField);
        this.kdtEntrys.getColumn("position").setEditor(kdtEntrys_position_CellEditor);
        KDFormattedTextField kdtEntrys_absence_TextField = new KDFormattedTextField();
        kdtEntrys_absence_TextField.setName("kdtEntrys_absence_TextField");
        kdtEntrys_absence_TextField.setVisible(true);
        kdtEntrys_absence_TextField.setEditable(true);
        kdtEntrys_absence_TextField.setHorizontalAlignment(2);
        kdtEntrys_absence_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_absence_CellEditor = new KDTDefaultCellEditor(kdtEntrys_absence_TextField);
        this.kdtEntrys.getColumn("absence").setEditor(kdtEntrys_absence_CellEditor);
        KDFormattedTextField kdtEntrys_absDebit_TextField = new KDFormattedTextField();
        kdtEntrys_absDebit_TextField.setName("kdtEntrys_absDebit_TextField");
        kdtEntrys_absDebit_TextField.setVisible(true);
        kdtEntrys_absDebit_TextField.setEditable(true);
        kdtEntrys_absDebit_TextField.setHorizontalAlignment(2);
        kdtEntrys_absDebit_TextField.setDataType(1);
        	kdtEntrys_absDebit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_absDebit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_absDebit_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_absDebit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_absDebit_TextField);
        this.kdtEntrys.getColumn("absDebit").setEditor(kdtEntrys_absDebit_CellEditor);
        KDFormattedTextField kdtEntrys_moreOver_TextField = new KDFormattedTextField();
        kdtEntrys_moreOver_TextField.setName("kdtEntrys_moreOver_TextField");
        kdtEntrys_moreOver_TextField.setVisible(true);
        kdtEntrys_moreOver_TextField.setEditable(true);
        kdtEntrys_moreOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_moreOver_TextField.setDataType(1);
        	kdtEntrys_moreOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_moreOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_moreOver_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_moreOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_moreOver_TextField);
        this.kdtEntrys.getColumn("moreOver").setEditor(kdtEntrys_moreOver_CellEditor);
        KDFormattedTextField kdtEntrys_overTraWage_TextField = new KDFormattedTextField();
        kdtEntrys_overTraWage_TextField.setName("kdtEntrys_overTraWage_TextField");
        kdtEntrys_overTraWage_TextField.setVisible(true);
        kdtEntrys_overTraWage_TextField.setEditable(true);
        kdtEntrys_overTraWage_TextField.setHorizontalAlignment(2);
        kdtEntrys_overTraWage_TextField.setDataType(1);
        	kdtEntrys_overTraWage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_overTraWage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_overTraWage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_overTraWage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_overTraWage_TextField);
        this.kdtEntrys.getColumn("overTraWage").setEditor(kdtEntrys_overTraWage_CellEditor);
        KDFormattedTextField kdtEntrys_monthWork_TextField = new KDFormattedTextField();
        kdtEntrys_monthWork_TextField.setName("kdtEntrys_monthWork_TextField");
        kdtEntrys_monthWork_TextField.setVisible(true);
        kdtEntrys_monthWork_TextField.setEditable(true);
        kdtEntrys_monthWork_TextField.setHorizontalAlignment(2);
        kdtEntrys_monthWork_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_monthWork_CellEditor = new KDTDefaultCellEditor(kdtEntrys_monthWork_TextField);
        this.kdtEntrys.getColumn("monthWork").setEditor(kdtEntrys_monthWork_CellEditor);
        KDFormattedTextField kdtEntrys_abcdefg_TextField = new KDFormattedTextField();
        kdtEntrys_abcdefg_TextField.setName("kdtEntrys_abcdefg_TextField");
        kdtEntrys_abcdefg_TextField.setVisible(true);
        kdtEntrys_abcdefg_TextField.setEditable(true);
        kdtEntrys_abcdefg_TextField.setHorizontalAlignment(2);
        kdtEntrys_abcdefg_TextField.setDataType(1);
        	kdtEntrys_abcdefg_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_abcdefg_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_abcdefg_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_abcdefg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_abcdefg_TextField);
        this.kdtEntrys.getColumn("abcdefg").setEditor(kdtEntrys_abcdefg_CellEditor);
        KDFormattedTextField kdtEntrys_aaa_TextField = new KDFormattedTextField();
        kdtEntrys_aaa_TextField.setName("kdtEntrys_aaa_TextField");
        kdtEntrys_aaa_TextField.setVisible(true);
        kdtEntrys_aaa_TextField.setEditable(true);
        kdtEntrys_aaa_TextField.setHorizontalAlignment(2);
        kdtEntrys_aaa_TextField.setDataType(1);
        	kdtEntrys_aaa_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_aaa_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_aaa_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_aaa_CellEditor = new KDTDefaultCellEditor(kdtEntrys_aaa_TextField);
        this.kdtEntrys.getColumn("aaa").setEditor(kdtEntrys_aaa_CellEditor);
        KDDatePicker kdtEntrys_indate_DatePicker = new KDDatePicker();
        kdtEntrys_indate_DatePicker.setName("kdtEntrys_indate_DatePicker");
        kdtEntrys_indate_DatePicker.setVisible(true);
        kdtEntrys_indate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_indate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_indate_DatePicker);
        this.kdtEntrys.getColumn("indate").setEditor(kdtEntrys_indate_CellEditor);
        KDDatePicker kdtEntrys_outdate_DatePicker = new KDDatePicker();
        kdtEntrys_outdate_DatePicker.setName("kdtEntrys_outdate_DatePicker");
        kdtEntrys_outdate_DatePicker.setVisible(true);
        kdtEntrys_outdate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_outdate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_outdate_DatePicker);
        this.kdtEntrys.getColumn("outdate").setEditor(kdtEntrys_outdate_CellEditor);
        KDTextField kdtEntrys_secuProfFr_TextField = new KDTextField();
        kdtEntrys_secuProfFr_TextField.setName("kdtEntrys_secuProfFr_TextField");
        kdtEntrys_secuProfFr_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_secuProfFr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_secuProfFr_TextField);
        this.kdtEntrys.getColumn("secuProfFr").setEditor(kdtEntrys_secuProfFr_CellEditor);
        KDDatePicker kdtEntrys_birthdate_DatePicker = new KDDatePicker();
        kdtEntrys_birthdate_DatePicker.setName("kdtEntrys_birthdate_DatePicker");
        kdtEntrys_birthdate_DatePicker.setVisible(true);
        kdtEntrys_birthdate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_birthdate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_birthdate_DatePicker);
        this.kdtEntrys.getColumn("birthdate").setEditor(kdtEntrys_birthdate_CellEditor);
        KDTextField kdtEntrys_cfbirthplace_TextField = new KDTextField();
        kdtEntrys_cfbirthplace_TextField.setName("kdtEntrys_cfbirthplace_TextField");
        kdtEntrys_cfbirthplace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_cfbirthplace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cfbirthplace_TextField);
        this.kdtEntrys.getColumn("cfbirthplace").setEditor(kdtEntrys_cfbirthplace_CellEditor);
        KDTextField kdtEntrys_monthYear_TextField = new KDTextField();
        kdtEntrys_monthYear_TextField.setName("kdtEntrys_monthYear_TextField");
        kdtEntrys_monthYear_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_monthYear_CellEditor = new KDTDefaultCellEditor(kdtEntrys_monthYear_TextField);
        this.kdtEntrys.getColumn("monthYear").setEditor(kdtEntrys_monthYear_CellEditor);
        KDTextField kdtEntrys_fadd_TextField = new KDTextField();
        kdtEntrys_fadd_TextField.setName("kdtEntrys_fadd_TextField");
        kdtEntrys_fadd_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_fadd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fadd_TextField);
        this.kdtEntrys.getColumn("fadd").setEditor(kdtEntrys_fadd_CellEditor);
        // contprojName		
        this.contprojName.setBoundLabelText(resHelper.getString("contprojName.boundLabelText"));		
        this.contprojName.setBoundLabelLength(100);		
        this.contprojName.setBoundLabelUnderline(true);		
        this.contprojName.setEnabled(false);
        // contprojSCNum		
        this.contprojSCNum.setBoundLabelText(resHelper.getString("contprojSCNum.boundLabelText"));		
        this.contprojSCNum.setBoundLabelLength(100);		
        this.contprojSCNum.setBoundLabelUnderline(true);		
        this.contprojSCNum.setVisible(false);		
        this.contprojSCNum.setEnabled(false);
        // contmonthYearr		
        this.contmonthYearr.setBoundLabelText(resHelper.getString("contmonthYearr.boundLabelText"));		
        this.contmonthYearr.setBoundLabelLength(100);		
        this.contmonthYearr.setBoundLabelUnderline(true);		
        this.contmonthYearr.setVisible(true);		
        this.contmonthYearr.setEnabled(false);
        // contProjAddress		
        this.contProjAddress.setBoundLabelText(resHelper.getString("contProjAddress.boundLabelText"));		
        this.contProjAddress.setBoundLabelLength(100);		
        this.contProjAddress.setBoundLabelUnderline(true);		
        this.contProjAddress.setVisible(false);		
        this.contProjAddress.setEnabled(false);
        // contpSecuNumber		
        this.contpSecuNumber.setBoundLabelText(resHelper.getString("contpSecuNumber.boundLabelText"));		
        this.contpSecuNumber.setBoundLabelLength(100);		
        this.contpSecuNumber.setBoundLabelUnderline(true);		
        this.contpSecuNumber.setVisible(true);
        // contlastName		
        this.contlastName.setBoundLabelText(resHelper.getString("contlastName.boundLabelText"));		
        this.contlastName.setBoundLabelLength(100);		
        this.contlastName.setBoundLabelUnderline(true);		
        this.contlastName.setVisible(true);
        // contfirstName		
        this.contfirstName.setBoundLabelText(resHelper.getString("contfirstName.boundLabelText"));		
        this.contfirstName.setBoundLabelLength(100);		
        this.contfirstName.setBoundLabelUnderline(true);		
        this.contfirstName.setVisible(true);
        // contbirthday		
        this.contbirthday.setBoundLabelText(resHelper.getString("contbirthday.boundLabelText"));		
        this.contbirthday.setBoundLabelLength(100);		
        this.contbirthday.setBoundLabelUnderline(true);		
        this.contbirthday.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // contworkProj		
        this.contworkProj.setBoundLabelText(resHelper.getString("contworkProj.boundLabelText"));		
        this.contworkProj.setBoundLabelLength(100);		
        this.contworkProj.setBoundLabelUnderline(true);		
        this.contworkProj.setVisible(true);
        // contcooperation		
        this.contcooperation.setBoundLabelText(resHelper.getString("contcooperation.boundLabelText"));		
        this.contcooperation.setBoundLabelLength(100);		
        this.contcooperation.setBoundLabelUnderline(true);		
        this.contcooperation.setVisible(true);
        // contprojNameFr		
        this.contprojNameFr.setBoundLabelText(resHelper.getString("contprojNameFr.boundLabelText"));		
        this.contprojNameFr.setBoundLabelLength(100);		
        this.contprojNameFr.setBoundLabelUnderline(true);		
        this.contprojNameFr.setVisible(false);		
        this.contprojNameFr.setEnabled(false);
        // contprojPri		
        this.contprojPri.setBoundLabelText(resHelper.getString("contprojPri.boundLabelText"));		
        this.contprojPri.setBoundLabelLength(100);		
        this.contprojPri.setBoundLabelUnderline(true);		
        this.contprojPri.setVisible(true);
        // contbD1		
        this.contbD1.setBoundLabelText(resHelper.getString("contbD1.boundLabelText"));		
        this.contbD1.setBoundLabelLength(100);		
        this.contbD1.setBoundLabelUnderline(true);		
        this.contbD1.setVisible(false);		
        this.contbD1.setEnabled(false);
        // contbD2		
        this.contbD2.setBoundLabelText(resHelper.getString("contbD2.boundLabelText"));		
        this.contbD2.setBoundLabelLength(100);		
        this.contbD2.setBoundLabelUnderline(true);		
        this.contbD2.setVisible(false);		
        this.contbD2.setEnabled(false);
        // contbM1		
        this.contbM1.setBoundLabelText(resHelper.getString("contbM1.boundLabelText"));		
        this.contbM1.setBoundLabelLength(100);		
        this.contbM1.setBoundLabelUnderline(true);		
        this.contbM1.setVisible(false);		
        this.contbM1.setEnabled(false);
        // contbM2		
        this.contbM2.setBoundLabelText(resHelper.getString("contbM2.boundLabelText"));		
        this.contbM2.setBoundLabelLength(100);		
        this.contbM2.setBoundLabelUnderline(true);		
        this.contbM2.setVisible(false);		
        this.contbM2.setEnabled(false);
        // contbyear1		
        this.contbyear1.setBoundLabelText(resHelper.getString("contbyear1.boundLabelText"));		
        this.contbyear1.setBoundLabelLength(100);		
        this.contbyear1.setBoundLabelUnderline(true);		
        this.contbyear1.setVisible(false);		
        this.contbyear1.setEnabled(false);
        // contbyear2		
        this.contbyear2.setBoundLabelText(resHelper.getString("contbyear2.boundLabelText"));		
        this.contbyear2.setBoundLabelLength(100);		
        this.contbyear2.setBoundLabelUnderline(true);		
        this.contbyear2.setVisible(false);		
        this.contbyear2.setEnabled(false);
        // contiday1		
        this.contiday1.setBoundLabelText(resHelper.getString("contiday1.boundLabelText"));		
        this.contiday1.setBoundLabelLength(100);		
        this.contiday1.setBoundLabelUnderline(true);		
        this.contiday1.setVisible(false);		
        this.contiday1.setEnabled(false);
        // contiday2		
        this.contiday2.setBoundLabelText(resHelper.getString("contiday2.boundLabelText"));		
        this.contiday2.setBoundLabelLength(100);		
        this.contiday2.setBoundLabelUnderline(true);		
        this.contiday2.setVisible(false);		
        this.contiday2.setEnabled(false);
        // contimon1		
        this.contimon1.setBoundLabelText(resHelper.getString("contimon1.boundLabelText"));		
        this.contimon1.setBoundLabelLength(100);		
        this.contimon1.setBoundLabelUnderline(true);		
        this.contimon1.setVisible(false);		
        this.contimon1.setEnabled(false);
        // contimon2		
        this.contimon2.setBoundLabelText(resHelper.getString("contimon2.boundLabelText"));		
        this.contimon2.setBoundLabelLength(100);		
        this.contimon2.setBoundLabelUnderline(true);		
        this.contimon2.setVisible(false);		
        this.contimon2.setEnabled(false);
        // contiy1		
        this.contiy1.setBoundLabelText(resHelper.getString("contiy1.boundLabelText"));		
        this.contiy1.setBoundLabelLength(100);		
        this.contiy1.setBoundLabelUnderline(true);		
        this.contiy1.setVisible(false);		
        this.contiy1.setEnabled(false);
        // contiy2		
        this.contiy2.setBoundLabelText(resHelper.getString("contiy2.boundLabelText"));		
        this.contiy2.setBoundLabelLength(100);		
        this.contiy2.setBoundLabelUnderline(true);		
        this.contiy2.setVisible(false);		
        this.contiy2.setEnabled(false);
        // contod1		
        this.contod1.setBoundLabelText(resHelper.getString("contod1.boundLabelText"));		
        this.contod1.setBoundLabelLength(100);		
        this.contod1.setBoundLabelUnderline(true);		
        this.contod1.setVisible(false);		
        this.contod1.setEnabled(false);
        // contod2		
        this.contod2.setBoundLabelText(resHelper.getString("contod2.boundLabelText"));		
        this.contod2.setBoundLabelLength(100);		
        this.contod2.setBoundLabelUnderline(true);		
        this.contod2.setVisible(false);		
        this.contod2.setEnabled(false);
        // contom1		
        this.contom1.setBoundLabelText(resHelper.getString("contom1.boundLabelText"));		
        this.contom1.setBoundLabelLength(100);		
        this.contom1.setBoundLabelUnderline(true);		
        this.contom1.setVisible(false);		
        this.contom1.setEnabled(false);
        // contom2		
        this.contom2.setBoundLabelText(resHelper.getString("contom2.boundLabelText"));		
        this.contom2.setBoundLabelLength(100);		
        this.contom2.setBoundLabelUnderline(true);		
        this.contom2.setVisible(false);		
        this.contom2.setEnabled(false);
        // contoy1		
        this.contoy1.setBoundLabelText(resHelper.getString("contoy1.boundLabelText"));		
        this.contoy1.setBoundLabelLength(100);		
        this.contoy1.setBoundLabelUnderline(true);		
        this.contoy1.setVisible(false);		
        this.contoy1.setEnabled(false);
        // contoy2		
        this.contoy2.setBoundLabelText(resHelper.getString("contoy2.boundLabelText"));		
        this.contoy2.setBoundLabelLength(100);		
        this.contoy2.setBoundLabelUnderline(true);		
        this.contoy2.setVisible(false);		
        this.contoy2.setEnabled(false);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setVisible(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.kDDateCreateTime.setVisible(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.prmtLastUpdateUser.setVisible(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.kDDateLastUpdateTime.setVisible(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);
        // pkBizDate		
        this.pkBizDate.setEnabled(false);		
        this.pkBizDate.setVisible(false);
        // txtDescription		
        this.txtDescription.setMaxLength(80);		
        this.txtDescription.setEnabled(false);		
        this.txtDescription.setVisible(false);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setVisible(false);
        // prmtprojName		
        this.prmtprojName.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtprojName.setEditable(true);		
        this.prmtprojName.setDisplayFormat("$name$");		
        this.prmtprojName.setEditFormat("$number$");		
        this.prmtprojName.setCommitFormat("$number$");		
        this.prmtprojName.setRequired(false);		
        this.prmtprojName.setEnabled(false);
        // txtprojSCNum		
        this.txtprojSCNum.setHorizontalAlignment(2);		
        this.txtprojSCNum.setMaxLength(100);		
        this.txtprojSCNum.setRequired(false);		
        this.txtprojSCNum.setEnabled(false);		
        this.txtprojSCNum.setVisible(false);
        // prmtmonthYearr		
        this.prmtmonthYearr.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtmonthYearr.setEditable(true);		
        this.prmtmonthYearr.setDisplayFormat("$number$");		
        this.prmtmonthYearr.setEditFormat("$number$");		
        this.prmtmonthYearr.setCommitFormat("$number$");		
        this.prmtmonthYearr.setRequired(false);		
        this.prmtmonthYearr.setEnabled(false);
        // txtProjAddress		
        this.txtProjAddress.setHorizontalAlignment(2);		
        this.txtProjAddress.setMaxLength(100);		
        this.txtProjAddress.setRequired(false);		
        this.txtProjAddress.setEnabled(false);		
        this.txtProjAddress.setVisible(false);
        // txtpSecuNumber		
        this.txtpSecuNumber.setVisible(true);		
        this.txtpSecuNumber.setHorizontalAlignment(2);		
        this.txtpSecuNumber.setMaxLength(100);		
        this.txtpSecuNumber.setRequired(false);
        // txtlastName		
        this.txtlastName.setVisible(true);		
        this.txtlastName.setHorizontalAlignment(2);		
        this.txtlastName.setMaxLength(100);		
        this.txtlastName.setRequired(false);
        // txtfirstName		
        this.txtfirstName.setVisible(true);		
        this.txtfirstName.setHorizontalAlignment(2);		
        this.txtfirstName.setMaxLength(100);		
        this.txtfirstName.setRequired(false);
        // pkbirthday		
        this.pkbirthday.setVisible(true);		
        this.pkbirthday.setRequired(false);
        // prmtendDate		
        this.prmtendDate.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtendDate.setVisible(true);		
        this.prmtendDate.setEditable(true);		
        this.prmtendDate.setDisplayFormat("$number$");		
        this.prmtendDate.setEditFormat("$number$");		
        this.prmtendDate.setCommitFormat("$number$");		
        this.prmtendDate.setRequired(false);
        // prmtworkProj		
        this.prmtworkProj.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtworkProj.setVisible(true);		
        this.prmtworkProj.setEditable(true);		
        this.prmtworkProj.setDisplayFormat("$name$");		
        this.prmtworkProj.setEditFormat("$number$");		
        this.prmtworkProj.setCommitFormat("$number$");		
        this.prmtworkProj.setRequired(false);
        // prmtcooperation		
        this.prmtcooperation.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcooperation.setVisible(true);		
        this.prmtcooperation.setEditable(true);		
        this.prmtcooperation.setDisplayFormat("$name$");		
        this.prmtcooperation.setEditFormat("$number$");		
        this.prmtcooperation.setCommitFormat("$number$");		
        this.prmtcooperation.setRequired(false);
        // txtprojNameFr		
        this.txtprojNameFr.setVisible(false);		
        this.txtprojNameFr.setHorizontalAlignment(2);		
        this.txtprojNameFr.setMaxLength(100);		
        this.txtprojNameFr.setRequired(false);		
        this.txtprojNameFr.setEnabled(false);
        // prmtprojPri		
        this.prmtprojPri.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");		
        this.prmtprojPri.setVisible(false);		
        this.prmtprojPri.setEditable(true);		
        this.prmtprojPri.setDisplayFormat("$name$");		
        this.prmtprojPri.setEditFormat("$number$");		
        this.prmtprojPri.setCommitFormat("$number$");		
        this.prmtprojPri.setRequired(false);		
        this.prmtprojPri.setEnabled(false);
        // txtbD1		
        this.txtbD1.setVisible(false);		
        this.txtbD1.setHorizontalAlignment(2);		
        this.txtbD1.setMaxLength(100);		
        this.txtbD1.setRequired(false);		
        this.txtbD1.setEnabled(false);
        // txtbD2		
        this.txtbD2.setVisible(false);		
        this.txtbD2.setHorizontalAlignment(2);		
        this.txtbD2.setMaxLength(100);		
        this.txtbD2.setRequired(false);		
        this.txtbD2.setEnabled(false);
        // txtbM1		
        this.txtbM1.setVisible(false);		
        this.txtbM1.setHorizontalAlignment(2);		
        this.txtbM1.setMaxLength(100);		
        this.txtbM1.setRequired(false);		
        this.txtbM1.setEnabled(false);
        // txtbM2		
        this.txtbM2.setVisible(false);		
        this.txtbM2.setHorizontalAlignment(2);		
        this.txtbM2.setMaxLength(100);		
        this.txtbM2.setRequired(false);		
        this.txtbM2.setEnabled(false);
        // txtbyear1		
        this.txtbyear1.setVisible(false);		
        this.txtbyear1.setHorizontalAlignment(2);		
        this.txtbyear1.setMaxLength(100);		
        this.txtbyear1.setRequired(false);		
        this.txtbyear1.setEnabled(false);
        // txtbyear2		
        this.txtbyear2.setVisible(false);		
        this.txtbyear2.setHorizontalAlignment(2);		
        this.txtbyear2.setMaxLength(100);		
        this.txtbyear2.setRequired(false);		
        this.txtbyear2.setEnabled(false);
        // txtiday1		
        this.txtiday1.setVisible(false);		
        this.txtiday1.setHorizontalAlignment(2);		
        this.txtiday1.setMaxLength(100);		
        this.txtiday1.setRequired(false);		
        this.txtiday1.setEnabled(false);
        // txtiday2		
        this.txtiday2.setVisible(false);		
        this.txtiday2.setHorizontalAlignment(2);		
        this.txtiday2.setMaxLength(100);		
        this.txtiday2.setRequired(false);		
        this.txtiday2.setEnabled(false);
        // txtimon1		
        this.txtimon1.setVisible(false);		
        this.txtimon1.setHorizontalAlignment(2);		
        this.txtimon1.setMaxLength(100);		
        this.txtimon1.setRequired(false);		
        this.txtimon1.setEnabled(false);
        // txtimon2		
        this.txtimon2.setVisible(false);		
        this.txtimon2.setHorizontalAlignment(2);		
        this.txtimon2.setMaxLength(100);		
        this.txtimon2.setRequired(false);		
        this.txtimon2.setEnabled(false);
        // txtiy1		
        this.txtiy1.setVisible(false);		
        this.txtiy1.setHorizontalAlignment(2);		
        this.txtiy1.setMaxLength(100);		
        this.txtiy1.setRequired(false);		
        this.txtiy1.setEnabled(false);
        // txtiy2		
        this.txtiy2.setVisible(false);		
        this.txtiy2.setHorizontalAlignment(2);		
        this.txtiy2.setMaxLength(100);		
        this.txtiy2.setRequired(false);		
        this.txtiy2.setEnabled(false);
        // txtod1		
        this.txtod1.setVisible(false);		
        this.txtod1.setHorizontalAlignment(2);		
        this.txtod1.setMaxLength(100);		
        this.txtod1.setRequired(false);		
        this.txtod1.setEnabled(false);
        // txtod2		
        this.txtod2.setVisible(false);		
        this.txtod2.setHorizontalAlignment(2);		
        this.txtod2.setMaxLength(100);		
        this.txtod2.setRequired(false);		
        this.txtod2.setEnabled(false);
        // txtom1		
        this.txtom1.setVisible(false);		
        this.txtom1.setHorizontalAlignment(2);		
        this.txtom1.setMaxLength(100);		
        this.txtom1.setRequired(false);		
        this.txtom1.setEnabled(false);
        // txtom2		
        this.txtom2.setVisible(false);		
        this.txtom2.setHorizontalAlignment(2);		
        this.txtom2.setMaxLength(100);		
        this.txtom2.setRequired(false);		
        this.txtom2.setEnabled(false);
        // txtoy1		
        this.txtoy1.setVisible(false);		
        this.txtoy1.setHorizontalAlignment(2);		
        this.txtoy1.setMaxLength(100);		
        this.txtoy1.setRequired(false);		
        this.txtoy1.setEnabled(false);
        // txtoy2		
        this.txtoy2.setVisible(false);		
        this.txtoy2.setHorizontalAlignment(2);		
        this.txtoy2.setMaxLength(100);		
        this.txtoy2.setRequired(false);		
        this.txtoy2.setEnabled(false);
        // btnInitBill
        this.btnInitBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionInitBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnInitBill.setText(resHelper.getString("btnInitBill.text"));		
        this.btnInitBill.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_find"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtprojName,txtprojSCNum,prmtmonthYearr,txtProjAddress,kdtEntrys,txtpSecuNumber,txtlastName,txtfirstName,pkbirthday,txtprojNameFr,prmtprojPri,txtbD1,txtbM1,txtbD2,prmtcooperation,prmtworkProj,prmtendDate,txtoy1,txtom2,txtom1,txtod2,txtod1,txtiy2,txtiy1,txtimon2,txtimon1,txtiday2,txtiday1,txtbyear2,txtbyear1,txtbM2}));
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
        this.setBounds(new Rectangle(0, 10, 1430, 785));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 10, 1430, 785));
        contCreator.setBounds(new Rectangle(10, 706, 215, 19));
        this.add(contCreator, new KDLayout.Constraints(10, 706, 215, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(10, 730, 263, 19));
        this.add(contCreateTime, new KDLayout.Constraints(10, 730, 263, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(480, 730, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(480, 730, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(950, 730, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(950, 730, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(480, 538, 240, 19));
        this.add(contNumber, new KDLayout.Constraints(480, 538, 240, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(480, 706, 187, 19));
        this.add(contBizDate, new KDLayout.Constraints(480, 706, 187, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(950, 706, 189, 19));
        this.add(contDescription, new KDLayout.Constraints(950, 706, 189, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(950, 538, 263, 19));
        this.add(contAuditor, new KDLayout.Constraints(950, 538, 263, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(10, 82, 1408, 424));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.zjlw.social.LocalPayPrintEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(10, 82, 1408, 424, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("maritalStatus","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contprojName.setBounds(new Rectangle(10, 58, 262, 19));
        this.add(contprojName, new KDLayout.Constraints(10, 58, 262, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprojSCNum.setBounds(new Rectangle(10, 514, 262, 19));
        this.add(contprojSCNum, new KDLayout.Constraints(10, 514, 262, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmonthYearr.setBounds(new Rectangle(480, 34, 270, 19));
        this.add(contmonthYearr, new KDLayout.Constraints(480, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contProjAddress.setBounds(new Rectangle(480, 514, 270, 19));
        this.add(contProjAddress, new KDLayout.Constraints(480, 514, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpSecuNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contpSecuNumber, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlastName.setBounds(new Rectangle(480, 10, 270, 19));
        this.add(contlastName, new KDLayout.Constraints(480, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfirstName.setBounds(new Rectangle(950, 10, 270, 19));
        this.add(contfirstName, new KDLayout.Constraints(950, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbirthday.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contbirthday, new KDLayout.Constraints(10, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(950, 34, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(950, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contworkProj.setBounds(new Rectangle(480, 58, 270, 19));
        this.add(contworkProj, new KDLayout.Constraints(480, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcooperation.setBounds(new Rectangle(950, 58, 270, 19));
        this.add(contcooperation, new KDLayout.Constraints(950, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contprojNameFr.setBounds(new Rectangle(950, 514, 270, 19));
        this.add(contprojNameFr, new KDLayout.Constraints(950, 514, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contprojPri.setBounds(new Rectangle(10, 538, 270, 19));
        this.add(contprojPri, new KDLayout.Constraints(10, 538, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbD1.setBounds(new Rectangle(10, 562, 270, 19));
        this.add(contbD1, new KDLayout.Constraints(10, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbD2.setBounds(new Rectangle(480, 562, 270, 19));
        this.add(contbD2, new KDLayout.Constraints(480, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbM1.setBounds(new Rectangle(950, 562, 270, 19));
        this.add(contbM1, new KDLayout.Constraints(950, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbM2.setBounds(new Rectangle(10, 586, 270, 19));
        this.add(contbM2, new KDLayout.Constraints(10, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbyear1.setBounds(new Rectangle(480, 586, 270, 19));
        this.add(contbyear1, new KDLayout.Constraints(480, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbyear2.setBounds(new Rectangle(950, 586, 270, 19));
        this.add(contbyear2, new KDLayout.Constraints(950, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contiday1.setBounds(new Rectangle(10, 610, 270, 19));
        this.add(contiday1, new KDLayout.Constraints(10, 610, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contiday2.setBounds(new Rectangle(480, 610, 270, 19));
        this.add(contiday2, new KDLayout.Constraints(480, 610, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contimon1.setBounds(new Rectangle(950, 610, 270, 19));
        this.add(contimon1, new KDLayout.Constraints(950, 610, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contimon2.setBounds(new Rectangle(10, 634, 270, 19));
        this.add(contimon2, new KDLayout.Constraints(10, 634, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contiy1.setBounds(new Rectangle(480, 634, 270, 19));
        this.add(contiy1, new KDLayout.Constraints(480, 634, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contiy2.setBounds(new Rectangle(950, 634, 270, 19));
        this.add(contiy2, new KDLayout.Constraints(950, 634, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contod1.setBounds(new Rectangle(10, 658, 270, 19));
        this.add(contod1, new KDLayout.Constraints(10, 658, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contod2.setBounds(new Rectangle(480, 658, 270, 19));
        this.add(contod2, new KDLayout.Constraints(480, 658, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contom1.setBounds(new Rectangle(950, 658, 270, 19));
        this.add(contom1, new KDLayout.Constraints(950, 658, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contom2.setBounds(new Rectangle(10, 682, 270, 19));
        this.add(contom2, new KDLayout.Constraints(10, 682, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoy1.setBounds(new Rectangle(480, 682, 270, 19));
        this.add(contoy1, new KDLayout.Constraints(480, 682, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoy2.setBounds(new Rectangle(950, 682, 270, 19));
        this.add(contoy2, new KDLayout.Constraints(950, 682, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contprojSCNum
        contprojSCNum.setBoundEditor(txtprojSCNum);
        //contmonthYearr
        contmonthYearr.setBoundEditor(prmtmonthYearr);
        //contProjAddress
        contProjAddress.setBoundEditor(txtProjAddress);
        //contpSecuNumber
        contpSecuNumber.setBoundEditor(txtpSecuNumber);
        //contlastName
        contlastName.setBoundEditor(txtlastName);
        //contfirstName
        contfirstName.setBoundEditor(txtfirstName);
        //contbirthday
        contbirthday.setBoundEditor(pkbirthday);
        //contendDate
        contendDate.setBoundEditor(prmtendDate);
        //contworkProj
        contworkProj.setBoundEditor(prmtworkProj);
        //contcooperation
        contcooperation.setBoundEditor(prmtcooperation);
        //contprojNameFr
        contprojNameFr.setBoundEditor(txtprojNameFr);
        //contprojPri
        contprojPri.setBoundEditor(prmtprojPri);
        //contbD1
        contbD1.setBoundEditor(txtbD1);
        //contbD2
        contbD2.setBoundEditor(txtbD2);
        //contbM1
        contbM1.setBoundEditor(txtbM1);
        //contbM2
        contbM2.setBoundEditor(txtbM2);
        //contbyear1
        contbyear1.setBoundEditor(txtbyear1);
        //contbyear2
        contbyear2.setBoundEditor(txtbyear2);
        //contiday1
        contiday1.setBoundEditor(txtiday1);
        //contiday2
        contiday2.setBoundEditor(txtiday2);
        //contimon1
        contimon1.setBoundEditor(txtimon1);
        //contimon2
        contimon2.setBoundEditor(txtimon2);
        //contiy1
        contiy1.setBoundEditor(txtiy1);
        //contiy2
        contiy2.setBoundEditor(txtiy2);
        //contod1
        contod1.setBoundEditor(txtod1);
        //contod2
        contod2.setBoundEditor(txtod2);
        //contom1
        contom1.setBoundEditor(txtom1);
        //contom2
        contom2.setBoundEditor(txtom2);
        //contoy1
        contoy1.setBoundEditor(txtoy1);
        //contoy2
        contoy2.setBoundEditor(txtoy2);

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
        this.toolBar.add(btnInitBill);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.zjlw.social.LocalPayPrintEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.lastName", String.class, this.kdtEntrys, "lastName.text");
		dataBinder.registerBinding("entrys.firstName", String.class, this.kdtEntrys, "firstName.text");
		dataBinder.registerBinding("entrys.position", String.class, this.kdtEntrys, "position.text");
		dataBinder.registerBinding("entrys.enterDate", java.util.Date.class, this.kdtEntrys, "enterDate.text");
		dataBinder.registerBinding("entrys.basePay", java.math.BigDecimal.class, this.kdtEntrys, "basePay.text");
		dataBinder.registerBinding("entrys.monthWork", int.class, this.kdtEntrys, "monthWork.text");
		dataBinder.registerBinding("entrys.absence", int.class, this.kdtEntrys, "absence.text");
		dataBinder.registerBinding("entrys.absDebit", java.math.BigDecimal.class, this.kdtEntrys, "absDebit.text");
		dataBinder.registerBinding("entrys.normalOver", java.math.BigDecimal.class, this.kdtEntrys, "normalOver.text");
		dataBinder.registerBinding("entrys.moreOver", java.math.BigDecimal.class, this.kdtEntrys, "moreOver.text");
		dataBinder.registerBinding("entrys.festOver", java.math.BigDecimal.class, this.kdtEntrys, "festOver.text");
		dataBinder.registerBinding("entrys.profWage", java.math.BigDecimal.class, this.kdtEntrys, "profWage.text");
		dataBinder.registerBinding("entrys.extProfWage", java.math.BigDecimal.class, this.kdtEntrys, "extProfWage.text");
		dataBinder.registerBinding("entrys.secuDebit", java.math.BigDecimal.class, this.kdtEntrys, "secuDebit.text");
		dataBinder.registerBinding("entrys.vacaDebit", java.math.BigDecimal.class, this.kdtEntrys, "vacaDebit.text");
		dataBinder.registerBinding("entrys.aftTaxPay", java.math.BigDecimal.class, this.kdtEntrys, "aftTaxPay.text");
		dataBinder.registerBinding("entrys.grossPay", java.math.BigDecimal.class, this.kdtEntrys, "grossPay.text");
		dataBinder.registerBinding("entrys.persTax", java.math.BigDecimal.class, this.kdtEntrys, "persTax.text");
		dataBinder.registerBinding("entrys.posiPay", java.math.BigDecimal.class, this.kdtEntrys, "posiPay.text");
		dataBinder.registerBinding("entrys.chineWage", java.math.BigDecimal.class, this.kdtEntrys, "chineWage.text");
		dataBinder.registerBinding("entrys.algerWage", java.math.BigDecimal.class, this.kdtEntrys, "algerWage.text");
		dataBinder.registerBinding("entrys.traWage", java.math.BigDecimal.class, this.kdtEntrys, "traWage.text");
		dataBinder.registerBinding("entrys.bTripWage", java.math.BigDecimal.class, this.kdtEntrys, "bTripWage.text");
		dataBinder.registerBinding("entrys.oneWorkWage", java.math.BigDecimal.class, this.kdtEntrys, "oneWorkWage.text");
		dataBinder.registerBinding("entrys.riskWage", java.math.BigDecimal.class, this.kdtEntrys, "riskWage.text");
		dataBinder.registerBinding("entrys.disasWage", java.math.BigDecimal.class, this.kdtEntrys, "disasWage.text");
		dataBinder.registerBinding("entrys.oneTimeWage", java.math.BigDecimal.class, this.kdtEntrys, "oneTimeWage.text");
		dataBinder.registerBinding("entrys.eatWage", java.math.BigDecimal.class, this.kdtEntrys, "eatWage.text");
		dataBinder.registerBinding("entrys.overTraWage", java.math.BigDecimal.class, this.kdtEntrys, "overTraWage.text");
		dataBinder.registerBinding("entrys.areaWage", java.math.BigDecimal.class, this.kdtEntrys, "areaWage.text");
		dataBinder.registerBinding("entrys.thingsWage", java.math.BigDecimal.class, this.kdtEntrys, "thingsWage.text");
		dataBinder.registerBinding("entrys.switchWage", java.math.BigDecimal.class, this.kdtEntrys, "switchWage.text");
		dataBinder.registerBinding("entrys.nWorkWage", java.math.BigDecimal.class, this.kdtEntrys, "nWorkWage.text");
		dataBinder.registerBinding("entrys.liveWage", java.math.BigDecimal.class, this.kdtEntrys, "liveWage.text");
		dataBinder.registerBinding("entrys.spendWage", java.math.BigDecimal.class, this.kdtEntrys, "spendWage.text");
		dataBinder.registerBinding("entrys.fireWage", java.math.BigDecimal.class, this.kdtEntrys, "fireWage.text");
		dataBinder.registerBinding("entrys.retirWage", java.math.BigDecimal.class, this.kdtEntrys, "retirWage.text");
		dataBinder.registerBinding("entrys.faraWage", java.math.BigDecimal.class, this.kdtEntrys, "faraWage.text");
		dataBinder.registerBinding("entrys.pOverAward", java.math.BigDecimal.class, this.kdtEntrys, "pOverAward.text");
		dataBinder.registerBinding("entrys.profAward", java.math.BigDecimal.class, this.kdtEntrys, "profAward.text");
		dataBinder.registerBinding("entrys.langWage", java.math.BigDecimal.class, this.kdtEntrys, "langWage.text");
		dataBinder.registerBinding("entrys.urgeWage", java.math.BigDecimal.class, this.kdtEntrys, "urgeWage.text");
		dataBinder.registerBinding("entrys.monthAward", java.math.BigDecimal.class, this.kdtEntrys, "monthAward.text");
		dataBinder.registerBinding("entrys.indPay", java.math.BigDecimal.class, this.kdtEntrys, "indPay.text");
		dataBinder.registerBinding("entrys.netPay", java.math.BigDecimal.class, this.kdtEntrys, "netPay.text");
		dataBinder.registerBinding("entrys.unSignWage", String.class, this.kdtEntrys, "unSignWage.text");
		dataBinder.registerBinding("entrys.country", java.lang.Object.class, this.kdtEntrys, "country.text");
		dataBinder.registerBinding("entrys.workProgram", java.lang.Object.class, this.kdtEntrys, "workProgram.text");
		dataBinder.registerBinding("entrys.cooperation", java.lang.Object.class, this.kdtEntrys, "cooperation.text");
		dataBinder.registerBinding("entrys.coopCode", String.class, this.kdtEntrys, "coopCode.text");
		dataBinder.registerBinding("entrys.seniWage", java.math.BigDecimal.class, this.kdtEntrys, "seniWage.text");
		dataBinder.registerBinding("entrys.wifeUnWage", java.math.BigDecimal.class, this.kdtEntrys, "wifeUnWage.text");
		dataBinder.registerBinding("entrys.FamilyWage", java.math.BigDecimal.class, this.kdtEntrys, "FamilyWage.text");
		dataBinder.registerBinding("entrys.studyWage", java.math.BigDecimal.class, this.kdtEntrys, "studyWage.text");
		dataBinder.registerBinding("entrys.unSCVCWage", java.math.BigDecimal.class, this.kdtEntrys, "unSCVCWage.text");
		dataBinder.registerBinding("entrys.personID", String.class, this.kdtEntrys, "personID.text");
		dataBinder.registerBinding("entrys.foriPersID", String.class, this.kdtEntrys, "foriPersID.text");
		dataBinder.registerBinding("entrys.prof", java.lang.Object.class, this.kdtEntrys, "prof.text");
		dataBinder.registerBinding("entrys.secuProf", java.lang.Object.class, this.kdtEntrys, "secuProf.text");
		dataBinder.registerBinding("entrys.IRGDeduction", java.math.BigDecimal.class, this.kdtEntrys, "IRGDeduction.text");
		dataBinder.registerBinding("entrys.SociaLevyBase", java.math.BigDecimal.class, this.kdtEntrys, "SociaLevyBase.text");
		dataBinder.registerBinding("entrys.IRGDPerson", java.math.BigDecimal.class, this.kdtEntrys, "IRGDPerson.text");
		dataBinder.registerBinding("entrys.maritalStatus", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "maritalStatus.text");
		dataBinder.registerBinding("entrys.attMthWage", java.math.BigDecimal.class, this.kdtEntrys, "attMthWage.text");
		dataBinder.registerBinding("entrys.nmlBsWgPerHour", java.math.BigDecimal.class, this.kdtEntrys, "nmlBsWgPerHour.text");
		dataBinder.registerBinding("entrys.hldBsWgPerHour", java.math.BigDecimal.class, this.kdtEntrys, "hldBsWgPerHour.text");
		dataBinder.registerBinding("entrys.totNmlBsWg", java.math.BigDecimal.class, this.kdtEntrys, "totNmlBsWg.text");
		dataBinder.registerBinding("entrys.totHldBsWg", java.math.BigDecimal.class, this.kdtEntrys, "totHldBsWg.text");
		dataBinder.registerBinding("entrys.IRGLBase", java.math.BigDecimal.class, this.kdtEntrys, "IRGLBase.text");
		dataBinder.registerBinding("entrys.totCharge", java.math.BigDecimal.class, this.kdtEntrys, "totCharge.text");
		dataBinder.registerBinding("entrys.soLevyBaseW", java.math.BigDecimal.class, this.kdtEntrys, "soLevyBaseW.text");
		dataBinder.registerBinding("entrys.IRGLBaseW", java.math.BigDecimal.class, this.kdtEntrys, "IRGLBaseW.text");
		dataBinder.registerBinding("entrys.securityNo", String.class, this.kdtEntrys, "securityNo.text");
		dataBinder.registerBinding("entrys.CCPNo", String.class, this.kdtEntrys, "CCPNo.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.nWorkDay", java.math.BigDecimal.class, this.kdtEntrys, "nWorkDay.text");
		dataBinder.registerBinding("entrys.phoneWageC", java.math.BigDecimal.class, this.kdtEntrys, "phoneWageC.text");
		dataBinder.registerBinding("entrys.itmperieTol", java.math.BigDecimal.class, this.kdtEntrys, "itmperieTol.text");
		dataBinder.registerBinding("entrys.abcdefg", java.math.BigDecimal.class, this.kdtEntrys, "abcdefg.text");
		dataBinder.registerBinding("entrys.aaa", java.math.BigDecimal.class, this.kdtEntrys, "aaa.text");
		dataBinder.registerBinding("entrys.indate", java.util.Date.class, this.kdtEntrys, "indate.text");
		dataBinder.registerBinding("entrys.outdate", java.util.Date.class, this.kdtEntrys, "outdate.text");
		dataBinder.registerBinding("entrys.secuProfFr", String.class, this.kdtEntrys, "secuProfFr.text");
		dataBinder.registerBinding("entrys.birthdate", java.util.Date.class, this.kdtEntrys, "birthdate.text");
		dataBinder.registerBinding("entrys.cfbirthplace", String.class, this.kdtEntrys, "cfbirthplace.text");
		dataBinder.registerBinding("entrys.monthYear", String.class, this.kdtEntrys, "monthYear.text");
		dataBinder.registerBinding("entrys.fadd", String.class, this.kdtEntrys, "fadd.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("projName", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtprojName, "data");
		dataBinder.registerBinding("projSCNum", String.class, this.txtprojSCNum, "text");
		dataBinder.registerBinding("monthYearr", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtmonthYearr, "data");
		dataBinder.registerBinding("ProjAddress", String.class, this.txtProjAddress, "text");
		dataBinder.registerBinding("pSecuNumber", String.class, this.txtpSecuNumber, "text");
		dataBinder.registerBinding("lastName", String.class, this.txtlastName, "text");
		dataBinder.registerBinding("firstName", String.class, this.txtfirstName, "text");
		dataBinder.registerBinding("birthday", java.util.Date.class, this.pkbirthday, "value");
		dataBinder.registerBinding("endDate", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtendDate, "data");
		dataBinder.registerBinding("workProj", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtworkProj, "data");
		dataBinder.registerBinding("cooperation", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcooperation, "data");
		dataBinder.registerBinding("projNameFr", String.class, this.txtprojNameFr, "text");
		dataBinder.registerBinding("projPri", com.kingdee.eas.basedata.assistant.ProvinceInfo.class, this.prmtprojPri, "data");
		dataBinder.registerBinding("bD1", String.class, this.txtbD1, "text");
		dataBinder.registerBinding("bD2", String.class, this.txtbD2, "text");
		dataBinder.registerBinding("bM1", String.class, this.txtbM1, "text");
		dataBinder.registerBinding("bM2", String.class, this.txtbM2, "text");
		dataBinder.registerBinding("byear1", String.class, this.txtbyear1, "text");
		dataBinder.registerBinding("byear2", String.class, this.txtbyear2, "text");
		dataBinder.registerBinding("iday1", String.class, this.txtiday1, "text");
		dataBinder.registerBinding("iday2", String.class, this.txtiday2, "text");
		dataBinder.registerBinding("imon1", String.class, this.txtimon1, "text");
		dataBinder.registerBinding("imon2", String.class, this.txtimon2, "text");
		dataBinder.registerBinding("iy1", String.class, this.txtiy1, "text");
		dataBinder.registerBinding("iy2", String.class, this.txtiy2, "text");
		dataBinder.registerBinding("od1", String.class, this.txtod1, "text");
		dataBinder.registerBinding("od2", String.class, this.txtod2, "text");
		dataBinder.registerBinding("om1", String.class, this.txtom1, "text");
		dataBinder.registerBinding("om2", String.class, this.txtom2, "text");
		dataBinder.registerBinding("oy1", String.class, this.txtoy1, "text");
		dataBinder.registerBinding("oy2", String.class, this.txtoy2, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.social.app.LocalPayPrintEditUIHandler";
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
        this.editData = (com.kingdee.eas.zjlw.social.LocalPayPrintInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.position", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.enterDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.basePay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.monthWork", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.absence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.absDebit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.normalOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.moreOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.festOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.profWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.extProfWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuDebit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.vacaDebit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.aftTaxPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.grossPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.persTax", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.posiPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.chineWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.algerWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.traWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bTripWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oneWorkWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.riskWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.disasWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.oneTimeWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eatWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.overTraWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.areaWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.thingsWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.switchWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nWorkWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.liveWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.spendWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fireWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.retirWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.faraWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pOverAward", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.profAward", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.langWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.urgeWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.monthAward", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.indPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.netPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unSignWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.country", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.workProgram", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.coopCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seniWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wifeUnWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FamilyWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.studyWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unSCVCWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.foriPersID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.prof", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuProf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IRGDeduction", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.SociaLevyBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IRGDPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.maritalStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.attMthWage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nmlBsWgPerHour", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hldBsWgPerHour", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.totNmlBsWg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.totHldBsWg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IRGLBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.totCharge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.soLevyBaseW", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.IRGLBaseW", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.securityNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CCPNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nWorkDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.phoneWageC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.itmperieTol", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.abcdefg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.aaa", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.indate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.outdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secuProfFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.birthdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cfbirthplace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.monthYear", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fadd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projSCNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthYearr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ProjAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pSecuNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("firstName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("birthday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workProj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cooperation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projNameFr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("projPri", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bD1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bD2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bM1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bM2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byear1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byear2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("iday1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("iday2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imon1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imon2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("iy1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("iy2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("od1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("od2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("om1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("om2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oy1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oy2", ValidateHelper.ON_SAVE);    		
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.country.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.country.id"));
			sic.add(new SelectorItemInfo("entrys.country.name"));
        	sic.add(new SelectorItemInfo("entrys.country.number"));
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
    	sic.add(new SelectorItemInfo("entrys.coopCode"));
    	sic.add(new SelectorItemInfo("entrys.seniWage"));
    	sic.add(new SelectorItemInfo("entrys.wifeUnWage"));
    	sic.add(new SelectorItemInfo("entrys.FamilyWage"));
    	sic.add(new SelectorItemInfo("entrys.studyWage"));
    	sic.add(new SelectorItemInfo("entrys.unSCVCWage"));
    	sic.add(new SelectorItemInfo("entrys.personID"));
    	sic.add(new SelectorItemInfo("entrys.foriPersID"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.prof.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.prof.id"));
			sic.add(new SelectorItemInfo("entrys.prof.name"));
        	sic.add(new SelectorItemInfo("entrys.prof.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.secuProf.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.secuProf.id"));
			sic.add(new SelectorItemInfo("entrys.secuProf.name"));
        	sic.add(new SelectorItemInfo("entrys.secuProf.number"));
		}
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
    	sic.add(new SelectorItemInfo("entrys.indate"));
    	sic.add(new SelectorItemInfo("entrys.outdate"));
    	sic.add(new SelectorItemInfo("entrys.secuProfFr"));
    	sic.add(new SelectorItemInfo("entrys.birthdate"));
    	sic.add(new SelectorItemInfo("entrys.cfbirthplace"));
    	sic.add(new SelectorItemInfo("entrys.monthYear"));
    	sic.add(new SelectorItemInfo("entrys.fadd"));
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
        sic.add(new SelectorItemInfo("projSCNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("monthYearr.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("monthYearr.id"));
        	sic.add(new SelectorItemInfo("monthYearr.number"));
		}
        sic.add(new SelectorItemInfo("ProjAddress"));
        sic.add(new SelectorItemInfo("pSecuNumber"));
        sic.add(new SelectorItemInfo("lastName"));
        sic.add(new SelectorItemInfo("firstName"));
        sic.add(new SelectorItemInfo("birthday"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("endDate.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("endDate.id"));
        	sic.add(new SelectorItemInfo("endDate.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("workProj.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("workProj.id"));
        	sic.add(new SelectorItemInfo("workProj.number"));
        	sic.add(new SelectorItemInfo("workProj.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("cooperation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("cooperation.id"));
        	sic.add(new SelectorItemInfo("cooperation.number"));
        	sic.add(new SelectorItemInfo("cooperation.name"));
		}
        sic.add(new SelectorItemInfo("projNameFr"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("projPri.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("projPri.id"));
        	sic.add(new SelectorItemInfo("projPri.number"));
        	sic.add(new SelectorItemInfo("projPri.name"));
		}
        sic.add(new SelectorItemInfo("bD1"));
        sic.add(new SelectorItemInfo("bD2"));
        sic.add(new SelectorItemInfo("bM1"));
        sic.add(new SelectorItemInfo("bM2"));
        sic.add(new SelectorItemInfo("byear1"));
        sic.add(new SelectorItemInfo("byear2"));
        sic.add(new SelectorItemInfo("iday1"));
        sic.add(new SelectorItemInfo("iday2"));
        sic.add(new SelectorItemInfo("imon1"));
        sic.add(new SelectorItemInfo("imon2"));
        sic.add(new SelectorItemInfo("iy1"));
        sic.add(new SelectorItemInfo("iy2"));
        sic.add(new SelectorItemInfo("od1"));
        sic.add(new SelectorItemInfo("od2"));
        sic.add(new SelectorItemInfo("om1"));
        sic.add(new SelectorItemInfo("om2"));
        sic.add(new SelectorItemInfo("oy1"));
        sic.add(new SelectorItemInfo("oy2"));
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
     * output actionInitBill_actionPerformed method
     */
    public void actionInitBill_actionPerformed(ActionEvent e) throws Exception
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
	public RequestContext prepareActionInitBill(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionInitBill() {
    	return false;
    }

    /**
     * output ActionInitBill class
     */     
    protected class ActionInitBill extends ItemAction {     
    
        public ActionInitBill()
        {
            this(null);
        }

        public ActionInitBill(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionInitBill.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInitBill.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInitBill.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractLocalPayPrintEditUI.this, "ActionInitBill", "actionInitBill_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.social.client", "LocalPayPrintEditUI");
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
        return com.kingdee.eas.zjlw.social.client.LocalPayPrintEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.social.LocalPayPrintFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.social.LocalPayPrintInfo objectValue = new com.kingdee.eas.zjlw.social.LocalPayPrintInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/zjlw/social/LocalPayPrint";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.zjlw.social.app.LocalPayPrintQuery");
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