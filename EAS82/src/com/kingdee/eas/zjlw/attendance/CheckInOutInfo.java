package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;

public class CheckInOutInfo extends AbstractCheckInOutInfo implements Serializable 
{
    public CheckInOutInfo()
    {
        super();
    }
    protected CheckInOutInfo(String pkField)
    {
        super(pkField);
    }
}