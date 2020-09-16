package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FiIncomeEntryCollection extends AbstractObjectCollection 
{
    public FiIncomeEntryCollection()
    {
        super(FiIncomeEntryInfo.class);
    }
    public boolean add(FiIncomeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FiIncomeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FiIncomeEntryInfo item)
    {
        return removeObject(item);
    }
    public FiIncomeEntryInfo get(int index)
    {
        return(FiIncomeEntryInfo)getObject(index);
    }
    public FiIncomeEntryInfo get(Object key)
    {
        return(FiIncomeEntryInfo)getObject(key);
    }
    public void set(int index, FiIncomeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FiIncomeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FiIncomeEntryInfo item)
    {
        return super.indexOf(item);
    }
}