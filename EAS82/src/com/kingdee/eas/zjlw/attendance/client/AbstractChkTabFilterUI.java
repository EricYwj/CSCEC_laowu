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
public abstract class AbstractChkTabFilterUI extends com.kingdee.eas.scm.common.client.SCMBillFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractChkTabFilterUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlBeginTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlEndTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlPerProj;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlCheckArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlPerId;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdlPerName;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBeginTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkEndTIme;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox pkPerProj;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox pkCheckArea;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtPerId;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtPerName;
    /**
     * output class constructor
     */
    public AbstractChkTabFilterUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractChkTabFilterUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kdlBeginTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdlEndTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdlPerProj = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdlCheckArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdlPerId = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdlPerName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pkBeginTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkEndTIme = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkPerProj = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkCheckArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtPerId = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtPerName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kdlBeginTime.setName("kdlBeginTime");
        this.kdlEndTime.setName("kdlEndTime");
        this.kdlPerProj.setName("kdlPerProj");
        this.kdlCheckArea.setName("kdlCheckArea");
        this.kdlPerId.setName("kdlPerId");
        this.kdlPerName.setName("kdlPerName");
        this.pkBeginTime.setName("pkBeginTime");
        this.pkEndTIme.setName("pkEndTIme");
        this.pkPerProj.setName("pkPerProj");
        this.pkCheckArea.setName("pkCheckArea");
        this.txtPerId.setName("txtPerId");
        this.txtPerName.setName("txtPerName");
        // CustomerQueryPanel
        // kdlBeginTime		
        this.kdlBeginTime.setBoundLabelText(resHelper.getString("kdlBeginTime.boundLabelText"));		
        this.kdlBeginTime.setBoundLabelLength(100);
        // kdlEndTime		
        this.kdlEndTime.setBoundLabelText(resHelper.getString("kdlEndTime.boundLabelText"));		
        this.kdlEndTime.setBoundLabelLength(100);
        // kdlPerProj		
        this.kdlPerProj.setBoundLabelText(resHelper.getString("kdlPerProj.boundLabelText"));		
        this.kdlPerProj.setBoundLabelLength(100);		
        this.kdlPerProj.setEnabled(false);		
        this.kdlPerProj.setVisible(false);
        // kdlCheckArea		
        this.kdlCheckArea.setBoundLabelText(resHelper.getString("kdlCheckArea.boundLabelText"));		
        this.kdlCheckArea.setBoundLabelLength(100);		
        this.kdlCheckArea.setEnabled(false);		
        this.kdlCheckArea.setVisible(false);
        // kdlPerId		
        this.kdlPerId.setBoundLabelText(resHelper.getString("kdlPerId.boundLabelText"));		
        this.kdlPerId.setBoundLabelLength(100);		
        this.kdlPerId.setEnabled(false);		
        this.kdlPerId.setVisible(false);
        // kdlPerName		
        this.kdlPerName.setBoundLabelText(resHelper.getString("kdlPerName.boundLabelText"));		
        this.kdlPerName.setBoundLabelLength(100);		
        this.kdlPerName.setEnabled(false);		
        this.kdlPerName.setVisible(false);
        // pkBeginTime
        this.pkBeginTime.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pkBeginTime_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // pkEndTIme
        // pkPerProj		
        this.pkPerProj.setEnabled(false);
        // pkCheckArea		
        this.pkCheckArea.setEnabled(false);		
        this.pkCheckArea.setVisible(false);
        // txtPerId
        // txtPerName
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
        kdlBeginTime.setBounds(new Rectangle(68, 50, 270, 19));
        this.add(kdlBeginTime, null);
        kdlEndTime.setBounds(new Rectangle(68, 112, 270, 19));
        this.add(kdlEndTime, null);
        kdlPerProj.setBounds(new Rectangle(68, 174, 270, 19));
        this.add(kdlPerProj, null);
        kdlCheckArea.setBounds(new Rectangle(68, 236, 270, 19));
        this.add(kdlCheckArea, null);
        kdlPerId.setBounds(new Rectangle(68, 298, 270, 19));
        this.add(kdlPerId, null);
        kdlPerName.setBounds(new Rectangle(68, 363, 270, 19));
        this.add(kdlPerName, null);
        //kdlBeginTime
        kdlBeginTime.setBoundEditor(pkBeginTime);
        //kdlEndTime
        kdlEndTime.setBoundEditor(pkEndTIme);
        //kdlPerProj
        kdlPerProj.setBoundEditor(pkPerProj);
        //kdlCheckArea
        kdlCheckArea.setBoundEditor(pkCheckArea);
        //kdlPerId
        kdlPerId.setBoundEditor(txtPerId);
        //kdlPerName
        kdlPerName.setBoundEditor(txtPerName);

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
	    return "com.kingdee.eas.zjlw.attendance.app.ChkTabFilterUIHandler";
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
     * output pkBeginTime_dataChanged method
     */
    protected void pkBeginTime_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.zjlw.attendance.client", "ChkTabFilterUI");
    }




}