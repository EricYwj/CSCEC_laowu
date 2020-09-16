package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;

public class AntiSignedInfo extends AbstractAntiSignedInfo implements Serializable 
{
    public AntiSignedInfo()
    {
        super();
    }
    protected AntiSignedInfo(String pkField)
    {
        super(pkField);
    }
}