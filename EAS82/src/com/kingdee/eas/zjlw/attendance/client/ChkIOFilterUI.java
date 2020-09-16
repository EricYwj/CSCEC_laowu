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
	 * @��������:�󶨹��˿ؼ������������Ķ�Ӧ��ϵ
	 * @author zyynan2289
	 * @date 2009-6-11
	 */
	protected void initElementsInfo() {
		// ����Ԫ�صļ���
		CompositeFilterElement elements = new CompositeFilterElement(0);
		// ҵ������
		CompositeFilterElement dateElement = new CompositeFilterElement(0);
		dateElement.setId("bizDate");
		// ����ҵ�����ڹ���Ԫ�ص�ID������ᵼ������������������ͻ�����߱�������Ч��
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