package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;

public class AttenceInfo extends AbstractAttenceInfo implements Serializable 
{
    public AttenceInfo()
    {
        super();
    }
    protected AttenceInfo(String pkField)
    {
        super(pkField);
    }
}