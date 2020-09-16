/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.filter.CompositeFilterElement;
import com.kingdee.eas.scm.common.filter.RangeFilterElement;
import com.kingdee.eas.scm.common.verify.VerifyItem;
import com.kingdee.eas.scm.common.verify.VerifyType;

/**
 * output class name
 */
public class ChkIOFilterUI extends AbstractChkIOFilterUI {
	private static final Logger logger = CoreUIObject
			.getLogger(ChkIOFilterUI.class);

	/**
	 * output class constructor
	 */
	public ChkIOFilterUI() throws Exception {
		super();
		initElementsInfo();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	/**
	 * @功能描述:绑定过滤控件跟过滤条件的对应关系
	 * @author zyynan2289
	 * @date 2009-6-11
	 */
	protected void initElementsInfo() {
		// 过滤元素的集合
		CompositeFilterElement elements = new CompositeFilterElement(0);
		// 业务日期
		CompositeFilterElement dateElement = new CompositeFilterElement(0);
		dateElement.setId("bizDate");
		// 设置业务日期过滤元素的ID，否则会导致与其他过滤条件冲突，或者本条件无效。
		RangeFilterElement dateRange = null;
		dateRange = new RangeFilterElement("bizDate", pkBizDateFrom,pkBizDateTo);
		VerifyItem vfitem = null;
		vfitem = new VerifyItem(VerifyType.LESS_EQUAL_TYPE, SCMClientUtils.getResource("CompareDate"));
		dateRange.addVerifyItem(vfitem);
		dateElement.add(dateRange);
		elements.add(dateElement);
		getFilterManager().setElement(elements);
	}

}