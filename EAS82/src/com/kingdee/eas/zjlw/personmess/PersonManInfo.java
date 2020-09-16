package com.kingdee.eas.zjlw.personmess;

import java.io.Serializable;

public class PersonManInfo extends AbstractPersonManInfo implements Serializable 
{
    public PersonManInfo()
    {
        super();
    }
    protected PersonManInfo(String pkField)
    {
        super(pkField);
    }
}