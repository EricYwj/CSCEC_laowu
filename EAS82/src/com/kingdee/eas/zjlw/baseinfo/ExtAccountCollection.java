package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExtAccountCollection extends AbstractObjectCollection 
{
    public ExtAccountCollection()
    {
        super(ExtAccountInfo.class);
    }
    public boolean add(ExtAccountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExtAccountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExtAccountInfo item)
    {
        return removeObject(item);
    }
    public ExtAccountInfo get(int index)
    {
        return(ExtAccountInfo)getObject(index);
    }
    public ExtAccountInfo get(Object key)
    {
        return(ExtAccountInfo)getObject(key);
    }
    public void set(int index, ExtAccountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExtAccountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExtAccountInfo item)
    {
        return super.indexOf(item);
    }
}