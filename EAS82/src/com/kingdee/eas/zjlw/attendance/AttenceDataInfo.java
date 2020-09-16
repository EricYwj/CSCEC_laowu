package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;

public class AttenceDataInfo extends AbstractAttenceDataInfo implements Serializable 
{
    public AttenceDataInfo()
    {
        super();
    }
    protected AttenceDataInfo(String pkField)
    {
        super(pkField);
    }
}