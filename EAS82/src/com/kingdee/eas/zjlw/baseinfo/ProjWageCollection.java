package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjWageCollection extends AbstractObjectCollection 
{
    public ProjWageCollection()
    {
        super(ProjWageInfo.class);
    }
    public boolean add(ProjWageInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjWageCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjWageInfo item)
    {
        return removeObject(item);
    }
    public ProjWageInfo get(int index)
    {
        return(ProjWageInfo)getObject(index);
    }
    public ProjWageInfo get(Object key)
    {
        return(ProjWageInfo)getObject(key);
    }
    public void set(int index, ProjWageInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjWageInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjWageInfo item)
    {
        return super.indexOf(item);
    }
}