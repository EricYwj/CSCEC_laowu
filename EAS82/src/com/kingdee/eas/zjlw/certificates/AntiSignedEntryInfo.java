package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;

public class AntiSignedEntryInfo extends AbstractAntiSignedEntryInfo implements Serializable 
{
    public AntiSignedEntryInfo()
    {
        super();
    }
    protected AntiSignedEntryInfo(String pkField)
    {
        super(pkField);
    }
}