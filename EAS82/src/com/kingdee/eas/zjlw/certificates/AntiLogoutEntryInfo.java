package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;

public class AntiLogoutEntryInfo extends AbstractAntiLogoutEntryInfo implements Serializable 
{
    public AntiLogoutEntryInfo()
    {
        super();
    }
    protected AntiLogoutEntryInfo(String pkField)
    {
        super(pkField);
    }
}