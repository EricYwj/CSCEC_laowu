package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CooprationCollection extends AbstractObjectCollection 
{
    public CooprationCollection()
    {
        super(CooprationInfo.class);
    }
    public boolean add(CooprationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CooprationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CooprationInfo item)
    {
        return removeObject(item);
    }
    public CooprationInfo get(int index)
    {
        return(CooprationInfo)getObject(index);
    }
    public CooprationInfo get(Object key)
    {
        return(CooprationInfo)getObject(key);
    }
    public void set(int index, CooprationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CooprationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CooprationInfo item)
    {
        return super.indexOf(item);
    }
}