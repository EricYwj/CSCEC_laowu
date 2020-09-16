package com.kingdee.eas.zjlw.social;

import java.io.Serializable;

public class PayrollInfo extends AbstractPayrollInfo implements Serializable 
{
    public PayrollInfo()
    {
        super();
    }
    protected PayrollInfo(String pkField)
    {
        super(pkField);
    }
}