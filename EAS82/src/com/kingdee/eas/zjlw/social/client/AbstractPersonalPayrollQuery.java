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
public abstract class AbstractPersonalPayrollQuery extends com.kingdee.eas.framework.client.CommonQueryListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPersonalPayrollQuery.class);
    /**
     * output class constructor
     */
    public AbstractPersonalPayrollQuery() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPersonalPayrollQuery.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.zjlw.social.app", "personalPayrollQuery");
        // CoreUI		
        this.btnPageSetup.setVisible(false);		
        this.btnCloud.setVisible(false);		
        this.btnXunTong.setVisible(false);		
        this.kDSeparatorCloud.setVisible(false);		
        this.menuItemPageSetup.setVisible(false);		
        this.menuItemCloudFeed.setVisible(false);		
        this.menuItemCloudScreen.setEnabled(false);		
        this.menuItemCloudScreen.setVisible(false);		
        this.menuItemCloudShare.setVisible(false);		
        this.kdSeparatorFWFile1.setVisible(false);
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"lastName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"firstName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"position\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"enterDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"basePay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"monthWork\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"absence\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"absDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"normalOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"moreOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"festOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"profWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"extProfWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"secuDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"vacaDebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"aftTaxPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"grossPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"persTax\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"posiPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"chineWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"algerWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"traWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bTripWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"oneWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"riskWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"disasWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"oneTimeWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"eatWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"overTraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"areaWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"thingsWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"switchWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"nWorkWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"liveWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"spendWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fireWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"retirWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"faraWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"pOverAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"profAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"langWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"urgeWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"monthAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"indPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"netPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unSignWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"coopCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"seniWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wifeUnWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"FamilyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"studyWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unSCVCWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"foriPersID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IRGDeduction\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"SociaLevyBase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IRGDPerson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"maritalStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"attMthWage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"nmlBsWgPerHour\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"hldBsWgPerHour\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"totNmlBsWg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"totHldBsWg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IRGLBase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"totCharge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"soLevyBaseW\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IRGLBaseW\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"securityNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"CCPNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"nWorkDay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"phoneWageC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"itmperieTol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"abcdefg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"aaa\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workProgram.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"prof.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"secuProf.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cooperation.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"parent.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{lastName}</t:Cell><t:Cell>$Resource{firstName}</t:Cell><t:Cell>$Resource{position}</t:Cell><t:Cell>$Resource{enterDate}</t:Cell><t:Cell>$Resource{basePay}</t:Cell><t:Cell>$Resource{monthWork}</t:Cell><t:Cell>$Resource{absence}</t:Cell><t:Cell>$Resource{absDebit}</t:Cell><t:Cell>$Resource{normalOver}</t:Cell><t:Cell>$Resource{moreOver}</t:Cell><t:Cell>$Resource{festOver}</t:Cell><t:Cell>$Resource{profWage}</t:Cell><t:Cell>$Resource{extProfWage}</t:Cell><t:Cell>$Resource{secuDebit}</t:Cell><t:Cell>$Resource{vacaDebit}</t:Cell><t:Cell>$Resource{aftTaxPay}</t:Cell><t:Cell>$Resource{grossPay}</t:Cell><t:Cell>$Resource{persTax}</t:Cell><t:Cell>$Resource{posiPay}</t:Cell><t:Cell>$Resource{chineWage}</t:Cell><t:Cell>$Resource{algerWage}</t:Cell><t:Cell>$Resource{traWage}</t:Cell><t:Cell>$Resource{bTripWage}</t:Cell><t:Cell>$Resource{oneWorkWage}</t:Cell><t:Cell>$Resource{riskWage}</t:Cell><t:Cell>$Resource{disasWage}</t:Cell><t:Cell>$Resource{oneTimeWage}</t:Cell><t:Cell>$Resource{eatWage}</t:Cell><t:Cell>$Resource{overTraWage}</t:Cell><t:Cell>$Resource{areaWage}</t:Cell><t:Cell>$Resource{thingsWage}</t:Cell><t:Cell>$Resource{switchWage}</t:Cell><t:Cell>$Resource{nWorkWage}</t:Cell><t:Cell>$Resource{liveWage}</t:Cell><t:Cell>$Resource{spendWage}</t:Cell><t:Cell>$Resource{fireWage}</t:Cell><t:Cell>$Resource{retirWage}</t:Cell><t:Cell>$Resource{faraWage}</t:Cell><t:Cell>$Resource{pOverAward}</t:Cell><t:Cell>$Resource{profAward}</t:Cell><t:Cell>$Resource{langWage}</t:Cell><t:Cell>$Resource{urgeWage}</t:Cell><t:Cell>$Resource{monthAward}</t:Cell><t:Cell>$Resource{indPay}</t:Cell><t:Cell>$Resource{netPay}</t:Cell><t:Cell>$Resource{unSignWage}</t:Cell><t:Cell>$Resource{coopCode}</t:Cell><t:Cell>$Resource{seniWage}</t:Cell><t:Cell>$Resource{wifeUnWage}</t:Cell><t:Cell>$Resource{FamilyWage}</t:Cell><t:Cell>$Resource{studyWage}</t:Cell><t:Cell>$Resource{unSCVCWage}</t:Cell><t:Cell>$Resource{personID}</t:Cell><t:Cell>$Resource{foriPersID}</t:Cell><t:Cell>$Resource{IRGDeduction}</t:Cell><t:Cell>$Resource{SociaLevyBase}</t:Cell><t:Cell>$Resource{IRGDPerson}</t:Cell><t:Cell>$Resource{maritalStatus}</t:Cell><t:Cell>$Resource{attMthWage}</t:Cell><t:Cell>$Resource{nmlBsWgPerHour}</t:Cell><t:Cell>$Resource{hldBsWgPerHour}</t:Cell><t:Cell>$Resource{totNmlBsWg}</t:Cell><t:Cell>$Resource{totHldBsWg}</t:Cell><t:Cell>$Resource{IRGLBase}</t:Cell><t:Cell>$Resource{totCharge}</t:Cell><t:Cell>$Resource{soLevyBaseW}</t:Cell><t:Cell>$Resource{IRGLBaseW}</t:Cell><t:Cell>$Resource{securityNo}</t:Cell><t:Cell>$Resource{CCPNo}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{nWorkDay}</t:Cell><t:Cell>$Resource{phoneWageC}</t:Cell><t:Cell>$Resource{itmperieTol}</t:Cell><t:Cell>$Resource{abcdefg}</t:Cell><t:Cell>$Resource{aaa}</t:Cell><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{workProgram.name}</t:Cell><t:Cell>$Resource{prof.name}</t:Cell><t:Cell>$Resource{secuProf.name}</t:Cell><t:Cell>$Resource{cooperation.name}</t:Cell><t:Cell>$Resource{parent.number}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"lastName","firstName","position","enterDate","basePay","monthWork","absence","absDebit","normalOver","moreOver","festOver","profWage","extProfWage","secuDebit","vacaDebit","aftTaxPay","grossPay","persTax","posiPay","chineWage","algerWage","traWage","bTripWage","oneWorkWage","riskWage","disasWage","oneTimeWage","eatWage","overTraWage","areaWage","thingsWage","switchWage","nWorkWage","liveWage","spendWage","fireWage","retirWage","faraWage","pOverAward","profAward","langWage","urgeWage","monthAward","indPay","netPay","unSignWage","coopCode","seniWage","wifeUnWage","FamilyWage","studyWage","unSCVCWage","personID","foriPersID","IRGDeduction","SociaLevyBase","IRGDPerson","maritalStatus","attMthWage","nmlBsWgPerHour","hldBsWgPerHour","totNmlBsWg","totHldBsWg","IRGLBase","totCharge","soLevyBaseW","IRGLBaseW","securityNo","CCPNo","remark","nWorkDay","phoneWageC","itmperieTol","abcdefg","aaa","seq","id","workProgram.name","prof.name","secuProf.name","cooperation.name","parent.number"});

		
        this.menuItemImportData.setVisible(false);		
        this.menuItemExportData.setVisible(false);		
        this.menuTools.setEnabled(false);		
        this.menuTools.setVisible(false);		
        this.menuItemToHTML.setEnabled(false);		
        this.menuItemCopyScreen.setEnabled(false);		
        this.menuBiz.setEnabled(false);		
        this.menuBiz.setVisible(false);		
        this.separatorFW2.setVisible(false);		
        this.btnCancel.setVisible(false);		
        this.btnCancelCancel.setVisible(false);
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
        this.setLayout(null);
        tblMain.setBounds(new Rectangle(10, 10, 996, 580));
        this.add(tblMain, null);

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
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemExitCurrent);
        //menuEdit
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator3);
        menuEdit.add(menuItemQuery);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemView);
        menuView.add(menuItemLocate);
        menuView.add(menuItemRefresh);
        menuView.add(separatorView1);
        menuView.add(menuItemQueryScheme);
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
        this.toolBar.add(btnQuery);
        this.toolBar.add(btnLocate);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnQueryScheme);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.social.app.PersonalPayrollQueryHandler";
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
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
        sic.add(new SelectorItemInfo("lastName"));
        sic.add(new SelectorItemInfo("firstName"));
        sic.add(new SelectorItemInfo("position"));
        sic.add(new SelectorItemInfo("enterDate"));
        sic.add(new SelectorItemInfo("basePay"));
        sic.add(new SelectorItemInfo("monthWork"));
        sic.add(new SelectorItemInfo("absence"));
        sic.add(new SelectorItemInfo("absDebit"));
        sic.add(new SelectorItemInfo("normalOver"));
        sic.add(new SelectorItemInfo("moreOver"));
        sic.add(new SelectorItemInfo("festOver"));
        sic.add(new SelectorItemInfo("profWage"));
        sic.add(new SelectorItemInfo("extProfWage"));
        sic.add(new SelectorItemInfo("secuDebit"));
        sic.add(new SelectorItemInfo("vacaDebit"));
        sic.add(new SelectorItemInfo("aftTaxPay"));
        sic.add(new SelectorItemInfo("grossPay"));
        sic.add(new SelectorItemInfo("persTax"));
        sic.add(new SelectorItemInfo("posiPay"));
        sic.add(new SelectorItemInfo("chineWage"));
        sic.add(new SelectorItemInfo("algerWage"));
        sic.add(new SelectorItemInfo("traWage"));
        sic.add(new SelectorItemInfo("bTripWage"));
        sic.add(new SelectorItemInfo("oneWorkWage"));
        sic.add(new SelectorItemInfo("riskWage"));
        sic.add(new SelectorItemInfo("disasWage"));
        sic.add(new SelectorItemInfo("oneTimeWage"));
        sic.add(new SelectorItemInfo("eatWage"));
        sic.add(new SelectorItemInfo("overTraWage"));
        sic.add(new SelectorItemInfo("areaWage"));
        sic.add(new SelectorItemInfo("thingsWage"));
        sic.add(new SelectorItemInfo("switchWage"));
        sic.add(new SelectorItemInfo("nWorkWage"));
        sic.add(new SelectorItemInfo("liveWage"));
        sic.add(new SelectorItemInfo("spendWage"));
        sic.add(new SelectorItemInfo("fireWage"));
        sic.add(new SelectorItemInfo("retirWage"));
        sic.add(new SelectorItemInfo("faraWage"));
        sic.add(new SelectorItemInfo("pOverAward"));
        sic.add(new SelectorItemInfo("profAward"));
        sic.add(new SelectorItemInfo("langWage"));
        sic.add(new SelectorItemInfo("urgeWage"));
        sic.add(new SelectorItemInfo("monthAward"));
        sic.add(new SelectorItemInfo("indPay"));
        sic.add(new SelectorItemInfo("netPay"));
        sic.add(new SelectorItemInfo("unSignWage"));
        sic.add(new SelectorItemInfo("coopCode"));
        sic.add(new SelectorItemInfo("seniWage"));
        sic.add(new SelectorItemInfo("wifeUnWage"));
        sic.add(new SelectorItemInfo("FamilyWage"));
        sic.add(new SelectorItemInfo("studyWage"));
        sic.add(new SelectorItemInfo("unSCVCWage"));
        sic.add(new SelectorItemInfo("personID"));
        sic.add(new SelectorItemInfo("foriPersID"));
        sic.add(new SelectorItemInfo("IRGDeduction"));
        sic.add(new SelectorItemInfo("SociaLevyBase"));
        sic.add(new SelectorItemInfo("IRGDPerson"));
        sic.add(new SelectorItemInfo("maritalStatus"));
        sic.add(new SelectorItemInfo("attMthWage"));
        sic.add(new SelectorItemInfo("nmlBsWgPerHour"));
        sic.add(new SelectorItemInfo("hldBsWgPerHour"));
        sic.add(new SelectorItemInfo("totNmlBsWg"));
        sic.add(new SelectorItemInfo("totHldBsWg"));
        sic.add(new SelectorItemInfo("IRGLBase"));
        sic.add(new SelectorItemInfo("totCharge"));
        sic.add(new SelectorItemInfo("soLevyBaseW"));
        sic.add(new SelectorItemInfo("IRGLBaseW"));
        sic.add(new SelectorItemInfo("securityNo"));
        sic.add(new SelectorItemInfo("CCPNo"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("nWorkDay"));
        sic.add(new SelectorItemInfo("phoneWageC"));
        sic.add(new SelectorItemInfo("itmperieTol"));
        sic.add(new SelectorItemInfo("abcdefg"));
        sic.add(new SelectorItemInfo("aaa"));
        sic.add(new SelectorItemInfo("seq"));
        sic.add(new SelectorItemInfo("id"));
        sic.add(new SelectorItemInfo("workProgram.name"));
        sic.add(new SelectorItemInfo("prof.name"));
        sic.add(new SelectorItemInfo("secuProf.name"));
        sic.add(new SelectorItemInfo("cooperation.name"));
        sic.add(new SelectorItemInfo("parent.number"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.social.client", "PersonalPayrollQuery");
    }




}