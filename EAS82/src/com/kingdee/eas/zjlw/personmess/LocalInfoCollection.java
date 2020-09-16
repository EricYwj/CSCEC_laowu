package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LocalInfoCollection extends AbstractObjectCollection 
{
    public LocalInfoCollection()
    {
        super(LocalInfoInfo.class);
    }
    public boolean add(LocalInfoInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LocalInfoCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LocalInfoInfo item)
    {
        return removeObject(item);
    }
    public LocalInfoInfo get(int index)
    {
        return(LocalInfoInfo)getObject(index);
    }
    public LocalInfoInfo get(Object key)
    {
        return(LocalInfoInfo)getObject(key);
    }
    public void set(int index, LocalInfoInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LocalInfoInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LocalInfoInfo item)
    {
        return super.indexOf(item);
    }
}