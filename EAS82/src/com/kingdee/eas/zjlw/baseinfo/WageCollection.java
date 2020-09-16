package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WageCollection extends AbstractObjectCollection 
{
    public WageCollection()
    {
        super(WageInfo.class);
    }
    public boolean add(WageInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WageCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WageInfo item)
    {
        return removeObject(item);
    }
    public WageInfo get(int index)
    {
        return(WageInfo)getObject(index);
    }
    public WageInfo get(Object key)
    {
        return(WageInfo)getObject(key);
    }
    public void set(int index, WageInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WageInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WageInfo item)
    {
        return super.indexOf(item);
    }
}