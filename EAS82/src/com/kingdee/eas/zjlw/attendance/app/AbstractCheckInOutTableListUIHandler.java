/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractCheckInOutTableListUIHandler extends com.kingdee.eas.framework.app.ListUIHandler

{
	public void handleActionInit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionInit(request,response,context);
	}
	protected void _handleActionInit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}