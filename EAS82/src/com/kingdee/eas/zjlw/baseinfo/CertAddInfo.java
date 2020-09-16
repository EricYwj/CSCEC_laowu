package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;

public class CertAddInfo extends AbstractCertAddInfo implements Serializable 
{
    public CertAddInfo()
    {
        super();
    }
    protected CertAddInfo(String pkField)
    {
        super(pkField);
    }
}