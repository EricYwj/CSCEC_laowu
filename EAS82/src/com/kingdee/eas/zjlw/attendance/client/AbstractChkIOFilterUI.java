/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

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
public abstract class AbstractChkIOFilterUI extends com.kingdee.eas.scm.common.client.SCMBillFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractChkIOFilterUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer pkBizDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer pkBizDateTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDatePicker1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox kDBizPromptBox1;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDatePicker2;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox kDBizPromptBox2;
    /**
     * output class constructor
     */
    public AbstractChkIOFilterUI() throws Exception
    {
        super();
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractChkIOFilterUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.pkBizDateFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pkBizDateTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDDatePicker1 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDBizPromptBox1 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDatePicker2 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDBizPromptBox2 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkBizDateFrom.setName("pkBizDateFrom");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.pkBizDateTo.setName("pkBizDateTo");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDDatePicker1.setName("kDDatePicker1");
        this.kDBizPromptBox1.setName("kDBizPromptBox1");
        this.kDDatePicker2.setName("kDDatePicker2");
        this.kDBizPromptBox2.setName("kDBizPromptBox2");
        // CustomerQueryPanel		
        this.setToolTipText(resHelper.getString("this.toolTipText"));
        // pkBizDateFrom		
        this.pkBizDateFrom.setBoundLabelText(resHelper.getString("pkBizDateFrom.boundLabelText"));		
        this.pkBizDateFrom.setBoundLabelLength(100);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setEnabled(false);		
        this.kDLabelContainer3.setVisible(false);
        // pkBizDateTo		
        this.pkBizDateTo.setBoundLabelText(resHelper.getString("pkBizDateTo.boundLabelText"));		
        this.pkBizDateTo.setBoundLabelLength(100);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setEnabled(false);		
        this.kDLabelContainer4.setVisible(false);
        // kDDatePicker1
        // kDBizPromptBox1		
        this.kDBizPromptBox1.setEnabled(false);
        // kDDatePicker2
        // kDBizPromptBox2		
        this.kDBizPromptBox2.setEnabled(false);		
        this.kDBizPromptBox2.setVisible(false);
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
        this.setBounds(new Rectangle(10, 10, 1016, 600));
        this.setLayout(null);
        pkBizDateFrom.setBounds(new Rectangle(67, 59, 270, 19));
        this.add(pkBizDateFrom, null);
        kDLabelContainer3.setBounds(new Rectangle(67, 182, 270, 19));
        this.add(kDLabelContainer3, null);
        pkBizDateTo.setBounds(new Rectangle(67, 100, 270, 19));
        this.add(pkBizDateTo, null);
        kDLabelContainer4.setBounds(new Rectangle(67, 225, 270, 19));
        this.add(kDLabelContainer4, null);
        //pkBizDateFrom
        pkBizDateFrom.setBoundEditor(kDDatePicker1);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(kDBizPromptBox1);
        //pkBizDateTo
        pkBizDateTo.setBoundEditor(kDDatePicker2);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(kDBizPromptBox2);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.zjlw.attendance.app.ChkIOFilterUIHandler";
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
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.attendance.client", "ChkIOFilterUI");
    }




}