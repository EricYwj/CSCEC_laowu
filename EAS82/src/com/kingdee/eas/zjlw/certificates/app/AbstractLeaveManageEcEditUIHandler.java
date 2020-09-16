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
public abstract class AbstractLeaveManageEcEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleAcitonAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleAcitonAudit(request,response,context);
	}
	protected void _handleAcitonAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}