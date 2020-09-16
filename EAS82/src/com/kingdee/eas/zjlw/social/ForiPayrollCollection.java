package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiPayrollCollection extends AbstractObjectCollection 
{
    public ForiPayrollCollection()
    {
        super(ForiPayrollInfo.class);
    }
    public boolean add(ForiPayrollInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiPayrollCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiPayrollInfo item)
    {
        return removeObject(item);
    }
    public ForiPayrollInfo get(int index)
    {
        return(ForiPayrollInfo)getObject(index);
    }
    public ForiPayrollInfo get(Object key)
    {
        return(ForiPayrollInfo)getObject(key);
    }
    public void set(int index, ForiPayrollInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiPayrollInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiPayrollInfo item)
    {
        return super.indexOf(item);
    }
}