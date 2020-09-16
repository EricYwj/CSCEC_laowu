/**
 * output package name
 */
package com.kingdee.eas.zjlw.reports;

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
public abstract class AbstractPslPayrollFilterUI extends com.kingdee.eas.scm.common.client.SCMBillFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPslPayrollFilterUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlFirstName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlLastName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtFirstName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlastName;
    /**
     * output class constructor
     */
    public AbstractPslPayrollFilterUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPslPayrollFilterUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kdlFirstName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdlLastName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtFirstName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtlastName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kdlFirstName.setName("kdlFirstName");
        this.kdlLastName.setName("kdlLastName");
        this.txtFirstName.setName("txtFirstName");
        this.txtlastName.setName("txtlastName");
        // CustomerQueryPanel
        // kdlFirstName		
        this.kdlFirstName.setBoundLabelText(resHelper.getString("kdlFirstName.boundLabelText"));		
        this.kdlFirstName.setBoundLabelLength(100);
        // kdlLastName		
        this.kdlLastName.setBoundLabelText(resHelper.getString("kdlLastName.boundLabelText"));		
        this.kdlLastName.setBoundLabelLength(100);
        // txtFirstName
        // txtlastName
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
        kdlFirstName.setBounds(new Rectangle(115, 168, 270, 19));
        this.add(kdlFirstName, null);
        kdlLastName.setBounds(new Rectangle(115, 291, 270, 19));
        this.add(kdlLastName, null);
        //kdlFirstName
        kdlFirstName.setBoundEditor(txtFirstName);
        //kdlLastName
        kdlLastName.setBoundEditor(txtlastName);

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
	    return "com.kingdee.eas.zjlw.reports.PslPayrollFilterUIHandler";
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
        return new MetaDataPK("com.kingdee.eas.zjlw.reports", "PslPayrollFilterUI");
    }




}