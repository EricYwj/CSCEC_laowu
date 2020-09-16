/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.eas.base.commonquery.client.CustomerParams;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class ChkFilterUI extends AbstractChkFilterUI {
	private static final Logger logger = CoreUIObject.getLogger(ChkFilterUI.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * output class constructor
	 */
	public ChkFilterUI() throws Exception {
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	// 设置过滤条件
	public FilterInfo getFilterInfo() {
		FilterInfo oldFilter = null;
		if (super.getFilterInfo() != null) {
			oldFilter = super.getFilterInfo();
		} else {
			oldFilter = new FilterInfo();
		}
		// 创建一个andFilte
		FilterInfo andFilter = new FilterInfo();
		// 开始时间<=考勤日期<=结束时间
		Date fromDate = (Date) this.pkBizDateFrom.getValue();
		Date toDate = (Date) this.pkBizDateFTo.getValue();
		if (fromDate != null) {
			String fromStr = sdf.format(fromDate);
			andFilter.getFilterItems().add(new FilterItemInfo("checkTime", fromStr, CompareType.GREATER_EQUALS));
		} 
		if (toDate != null) {
			String toStr = sdf.format(toDate);
			andFilter.getFilterItems().add(new FilterItemInfo("checkTime", toStr, CompareType.LESS_EQUALS));
		} 
		try {
			oldFilter.mergeFilter(andFilter, "and");
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return oldFilter;
	}

	// 保存查询方案
	public void loadData(EntityViewInfo entityViewInfo) {
		super.loadData(entityViewInfo);
		clear();
		FilterItemCollection currentCollection = entityViewInfo.getFilter().getFilterItems();
		if (currentCollection == null || currentCollection.size() == 0)
			return;
		try {
			clear();
			for (int i = 0; i < currentCollection.size(); i++) {
				FilterItemInfo filterItemInfo = currentCollection.get(i);
				if (filterItemInfo.getPropertyName().equals("checkTime") && filterItemInfo.getCompareType().getName().equals(CompareType.GREATER_EQUALS.getName())) {
					Date fromDate = (Date) filterItemInfo.getCompareValue();
					this.pkBizDateFrom.setValue(fromDate);
				}
				if (filterItemInfo.getPropertyName().equals("checkTime") && filterItemInfo.getCompareType().getName().equals(CompareType.LESS_EQUALS.getName())) {
					Date toDate = (Date) filterItemInfo.getCompareValue();
					this.pkBizDateFrom.setValue(toDate);
				}
			}
		} catch (Exception e) {
		}
	}

	// 保存界面参数
	public CustomerParams getCustomerParams() {
		CustomerParams cp = new CustomerParams();
		if (super.getCustomerParams() != null) {
			cp = super.getCustomerParams();
		}
		cp.addCustomerParam("bizDateFrom", pkBizDateFrom.getText());
		cp.addCustomerParam("bizDateFTo", pkBizDateFTo.getText());

		return cp;
	}

	// 设置界面参数
	public void setCustomerParams(CustomerParams cp) {
		if (cp == null) {
			return;
		}
		try {
			CustomerParams result = cp;
			String bizDateFrom = result.getCustomerParam("bizDateFrom");
			if (bizDateFrom != null) {
				this.pkBizDateFrom.setValue(bizDateFrom);
			} else {
				this.pkBizDateFrom.setValue(null);
			}
			String bizDateFTo = result.getCustomerParam("bizDateFTo");
			if (bizDateFTo != null) {
				this.pkBizDateFTo.setValue(bizDateFTo);
			} else {
				this.pkBizDateFTo.setValue(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		super.setCustomerParams(cp);
	}

}