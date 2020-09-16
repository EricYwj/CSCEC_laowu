package com.kingdee.eas.zjlw.personinfo;

import java.io.Serializable;

public class PersonHistoryInfo extends AbstractPersonHistoryInfo implements Serializable 
{
    public PersonHistoryInfo()
    {
        super();
    }
    protected PersonHistoryInfo(String pkField)
    {
        super(pkField);
    }
}