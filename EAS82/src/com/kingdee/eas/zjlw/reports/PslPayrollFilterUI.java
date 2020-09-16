/**
 * output package name
 */
package com.kingdee.eas.zjlw.reports;

import java.awt.event.*;
import java.util.Date;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.filter.CompositeFilterElement;
import com.kingdee.eas.scm.common.filter.RangeFilterElement;
import com.kingdee.eas.scm.common.filter.SingleFilterElement;
import com.kingdee.eas.scm.common.verify.VerifyItem;
import com.kingdee.eas.scm.common.verify.VerifyType;

/**
 * output class name
 */
public class PslPayrollFilterUI extends AbstractPslPayrollFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(PslPayrollFilterUI.class);
    
    /**
     * output class constructor
     */
    public PslPayrollFilterUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    
    protected void initElementsInfo() {
		// ����Ԫ�صļ���
		CompositeFilterElement elements = new CompositeFilterElement(0);
		CompositeFilterElement dateElement = new CompositeFilterElement(0);
		
		// ��������
//		dateElement.setId("bizDate");
//		RangeFilterElement dateRange = null;
//		dateRange = new RangeFilterElement("chkTime", pkBeginTime, pkEndTIme);
//		VerifyItem vfitem = null;
//		vfitem = new VerifyItem(VerifyType.LESS_EQUAL_TYPE, SCMClientUtils.getResource("CompareDate"));
//		dateRange.addVerifyItem(vfitem);
//		dateElement.add(dateRange);
//		elements.add(dateElement);
		//��Ա����
		elements.add(new SingleFilterElement("firstName", txtFirstName));
		//����
		elements.add(new SingleFilterElement("lastName", txtlastName));
//		//������λ
//		elements.add(new CompositeFilterElement("perProj" ));
//		//������Ŀ
//		elements.add(new SingleFilterElement("checkAera", kDBizPromptBox1));
		
		getFilterManager().setElement(elements);
	}

	protected OrgType getMainBizOrgType() {
		return OrgType.Purchase;
	}

	protected void setDefaultValue() {
		txtFirstName.setStringValue("");
		txtlastName.setStringValue("");
		super.setDefaultValue();
	}

}