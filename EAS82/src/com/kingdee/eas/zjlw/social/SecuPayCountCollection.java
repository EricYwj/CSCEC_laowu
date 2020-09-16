package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SecuPayCountCollection extends AbstractObjectCollection 
{
    public SecuPayCountCollection()
    {
        super(SecuPayCountInfo.class);
    }
    public boolean add(SecuPayCountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SecuPayCountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SecuPayCountInfo item)
    {
        return removeObject(item);
    }
    public SecuPayCountInfo get(int index)
    {
        return(SecuPayCountInfo)getObject(index);
    }
    public SecuPayCountInfo get(Object key)
    {
        return(SecuPayCountInfo)getObject(key);
    }
    public void set(int index, SecuPayCountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SecuPayCountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SecuPayCountInfo item)
    {
        return super.indexOf(item);
    }
}