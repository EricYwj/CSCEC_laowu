/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class PersonalPayrollListUI extends AbstractPersonalPayrollListUI {
	private static final Logger logger = CoreUIObject.getLogger(PersonalPayrollListUI.class);

	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
	}

	protected boolean isIgnoreCUFilter() {
		return true;
	}

	/**
	 * output class constructor
	 */
	public PersonalPayrollListUI() throws Exception {
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

}