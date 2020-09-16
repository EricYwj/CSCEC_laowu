package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;

public class AntiECEntryInfo extends AbstractAntiECEntryInfo implements Serializable 
{
    public AntiECEntryInfo()
    {
        super();
    }
    protected AntiECEntryInfo(String pkField)
    {
        super(pkField);
    }
}