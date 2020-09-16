package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;

public class AttenceEntryInfo extends AbstractAttenceEntryInfo implements Serializable 
{
    public AttenceEntryInfo()
    {
        super();
    }
    protected AttenceEntryInfo(String pkField)
    {
        super(pkField);
    }
}