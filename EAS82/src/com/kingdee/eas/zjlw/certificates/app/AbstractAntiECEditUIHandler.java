/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractAntiECEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAudit(request,response,context);
	}
	protected void _handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionLogout(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionLogout(request,response,context);
	}
	protected void _handleActionLogout(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionRollBack(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionRollBack(request,response,context);
	}
	protected void _handleActionRollBack(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}