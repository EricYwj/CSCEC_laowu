package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;

public class PmtAppInfo extends AbstractPmtAppInfo implements Serializable 
{
    public PmtAppInfo()
    {
        super();
    }
    protected PmtAppInfo(String pkField)
    {
        super(pkField);
    }
}