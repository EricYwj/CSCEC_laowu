package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;

public class WageInfo extends AbstractWageInfo implements Serializable 
{
    public WageInfo()
    {
        super();
    }
    protected WageInfo(String pkField)
    {
        super(pkField);
    }
}