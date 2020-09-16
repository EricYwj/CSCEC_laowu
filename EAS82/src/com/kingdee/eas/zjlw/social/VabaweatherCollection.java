package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class VabaweatherCollection extends AbstractObjectCollection 
{
    public VabaweatherCollection()
    {
        super(VabaweatherInfo.class);
    }
    public boolean add(VabaweatherInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(VabaweatherCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(VabaweatherInfo item)
    {
        return removeObject(item);
    }
    public VabaweatherInfo get(int index)
    {
        return(VabaweatherInfo)getObject(index);
    }
    public VabaweatherInfo get(Object key)
    {
        return(VabaweatherInfo)getObject(key);
    }
    public void set(int index, VabaweatherInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(VabaweatherInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(VabaweatherInfo item)
    {
        return super.indexOf(item);
    }
}