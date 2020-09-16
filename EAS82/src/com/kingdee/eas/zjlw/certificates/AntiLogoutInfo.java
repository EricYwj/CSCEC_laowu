package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;

public class AntiLogoutInfo extends AbstractAntiLogoutInfo implements Serializable 
{
    public AntiLogoutInfo()
    {
        super();
    }
    protected AntiLogoutInfo(String pkField)
    {
        super(pkField);
    }
}