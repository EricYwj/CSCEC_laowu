package com.kingdee.eas.zjlw.personmess;

import java.io.Serializable;

public class PersonManEntryInfo extends AbstractPersonManEntryInfo implements Serializable 
{
    public PersonManEntryInfo()
    {
        super();
    }
    protected PersonManEntryInfo(String pkField)
    {
        super(pkField);
    }
}