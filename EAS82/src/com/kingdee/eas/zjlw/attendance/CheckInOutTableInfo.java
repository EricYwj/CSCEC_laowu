package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;

public class CheckInOutTableInfo extends AbstractCheckInOutTableInfo implements Serializable 
{
    public CheckInOutTableInfo()
    {
        super();
    }
    protected CheckInOutTableInfo(String pkField)
    {
        super(pkField);
    }
}