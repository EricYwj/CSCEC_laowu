package com.kingdee.eas.zjlw.reports.app;

import com.kingdee.eas.base.report.ReportTitles;
import com.kingdee.eas.base.report.app.ReportServerBase;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.BaseException;

public class pslPayrollReportServer extends ReportServerBase {

	@Override
	protected IRowSet getReportData(String arg0, RptParams arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ReportTitles getReportTitles(String arg0, RptParams arg1) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	// 获取临时表名称
	protected String buildReportDataForVirtual(String reportID, RptParams filter) throws BaseException {
		// TODO Auto-generated method stub
		return super.buildReportDataForVirtual(reportID, filter);
	}

	// 该方法用于返回一页数据。注意数据排序一致性，避免取数混乱。
	public IRowSet getDataForOnePage(String reportID, RptParams filter, String tableName, int start, int rows) throws BaseException {
		// TODO Auto-generated method stub
		return super.getDataForOnePage(reportID, filter, tableName, start, rows);
	}

}
