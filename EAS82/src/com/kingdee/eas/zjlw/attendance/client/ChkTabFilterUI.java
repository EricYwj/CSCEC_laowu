/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.filter.CheckRadioFilterElement;
import com.kingdee.eas.scm.common.filter.CheckRadioGroupFilterElment;
import com.kingdee.eas.scm.common.filter.CompositeFilterElement;
import com.kingdee.eas.scm.common.filter.FilterElement;
import com.kingdee.eas.scm.common.filter.RangeFilterElement;
import com.kingdee.eas.scm.common.filter.SingleFilterElement;
import com.kingdee.eas.scm.common.verify.VerifyItem;
import com.kingdee.eas.scm.common.verify.VerifyType;

/**
 * output class name
 */
public class ChkTabFilterUI extends AbstractChkTabFilterUI {
	private static final Logger logger = CoreUIObject.getLogger(ChkTabFilterUI.class);
	/**
	 * output class constructor
	 */
	public ChkTabFilterUI() throws Exception {
		super();
		initElementsInfo();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	protected void initElementsInfo() {
		// 过滤元素的集合
		CompositeFilterElement elements = new CompositeFilterElement(0);
		CompositeFilterElement dateElement = new CompositeFilterElement(0);
		
		// 考勤日期
		dateElement.setId("bizDate");
		RangeFilterElement dateRange = null;
		dateRange = new RangeFilterElement("ChkTime", pkBeginTime, pkEndTIme);
		VerifyItem vfitem = null;
		vfitem = new VerifyItem(VerifyType.LESS_EQUAL_TYPE, SCMClientUtils.getResource("CompareDate"));
		dateRange.addVerifyItem(vfitem);
		dateElement.add(dateRange);
		elements.add(dateElement);
		//人员编码
		elements.add(new SingleFilterElement("perId", txtPerId));
		//姓名
		elements.add(new SingleFilterElement("perName", txtPerName));
//		//合作单位
//		elements.add(new CompositeFilterElement("perProj" ));
//		//考勤项目
//		elements.add(new SingleFilterElement("checkAera", kDBizPromptBox1));
		
		getFilterManager().setElement(elements);
	}

	protected OrgType getMainBizOrgType() {
		return OrgType.Purchase;
	}

	protected void setDefaultValue() {
		pkBeginTime.setValue(new Date());
		pkEndTIme.setValue(new Date());
		super.setDefaultValue();
	}

}