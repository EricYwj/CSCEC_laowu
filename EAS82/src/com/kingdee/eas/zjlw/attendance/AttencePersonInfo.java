package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;

public class AttencePersonInfo extends AbstractAttencePersonInfo implements Serializable 
{
    public AttencePersonInfo()
    {
        super();
    }
    protected AttencePersonInfo(String pkField)
    {
        super(pkField);
    }
}