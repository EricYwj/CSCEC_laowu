/**
 * output package name
 */
package com.kingdee.eas.zjlw.personmess.client;

import org.apache.log4j.Logger;
import com.kingdee.bos.appframework.uip.ControllerBase;
import com.kingdee.bos.appframework.uip.Navigator;
import com.kingdee.bos.ui.face.CoreUIObject;

/**
 * output class name
 */
public class AbstractLocalInfoEditUIController extends ControllerBase {
    private static final Logger logger = CoreUIObject.getLogger(AbstractLocalInfoEditUIController.class);
    
    /**
     * output class constructor
     */
    public AbstractLocalInfoEditUIController(Navigator navigator) {
        super(navigator);
    }

    public void actionAudit() throws Exception {
    	
    	this.getNavigator().setNextUIName(null);
		
    	this.getNavigator().setOprtState(null);
		
        this.getNavigator().setUIContext(((AbstractLocalInfoEditUI)this.getNavigator().getOwner()).getUIContext());
        
        this.beforeActionAuditNavigate();        
        this.getNavigator().navigate();
        this.afterActionAuditNavigate();                
    }
    
    protected void beforeActionAuditNavigate() throws Exception {
    }
    
    protected void afterActionAuditNavigate() throws Exception {
    }
}