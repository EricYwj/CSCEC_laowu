package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjBWREtyCollection extends AbstractObjectCollection 
{
    public ProjBWREtyCollection()
    {
        super(ProjBWREtyInfo.class);
    }
    public boolean add(ProjBWREtyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjBWREtyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjBWREtyInfo item)
    {
        return removeObject(item);
    }
    public ProjBWREtyInfo get(int index)
    {
        return(ProjBWREtyInfo)getObject(index);
    }
    public ProjBWREtyInfo get(Object key)
    {
        return(ProjBWREtyInfo)getObject(key);
    }
    public void set(int index, ProjBWREtyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjBWREtyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjBWREtyInfo item)
    {
        return super.indexOf(item);
    }
}