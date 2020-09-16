package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FiIncomeCollection extends AbstractObjectCollection 
{
    public FiIncomeCollection()
    {
        super(FiIncomeInfo.class);
    }
    public boolean add(FiIncomeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FiIncomeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FiIncomeInfo item)
    {
        return removeObject(item);
    }
    public FiIncomeInfo get(int index)
    {
        return(FiIncomeInfo)getObject(index);
    }
    public FiIncomeInfo get(Object key)
    {
        return(FiIncomeInfo)getObject(key);
    }
    public void set(int index, FiIncomeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FiIncomeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FiIncomeInfo item)
    {
        return super.indexOf(item);
    }
}