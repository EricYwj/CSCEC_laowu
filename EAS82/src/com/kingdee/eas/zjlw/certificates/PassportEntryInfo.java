package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;

public class PassportEntryInfo extends AbstractPassportEntryInfo implements Serializable 
{
    public PassportEntryInfo()
    {
        super();
    }
    protected PassportEntryInfo(String pkField)
    {
        super(pkField);
    }
}