package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiPayrollEntryCollection extends AbstractObjectCollection 
{
    public ForiPayrollEntryCollection()
    {
        super(ForiPayrollEntryInfo.class);
    }
    public boolean add(ForiPayrollEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiPayrollEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiPayrollEntryInfo item)
    {
        return removeObject(item);
    }
    public ForiPayrollEntryInfo get(int index)
    {
        return(ForiPayrollEntryInfo)getObject(index);
    }
    public ForiPayrollEntryInfo get(Object key)
    {
        return(ForiPayrollEntryInfo)getObject(key);
    }
    public void set(int index, ForiPayrollEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiPayrollEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiPayrollEntryInfo item)
    {
        return super.indexOf(item);
    }
}