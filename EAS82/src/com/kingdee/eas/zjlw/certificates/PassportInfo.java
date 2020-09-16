package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;

public class PassportInfo extends AbstractPassportInfo implements Serializable 
{
    public PassportInfo()
    {
        super();
    }
    protected PassportInfo(String pkField)
    {
        super(pkField);
    }
}