/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractPayPrintEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleactioninitBill(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleactioninitBill(request,response,context);
	}
	protected void _handleactioninitBill(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}