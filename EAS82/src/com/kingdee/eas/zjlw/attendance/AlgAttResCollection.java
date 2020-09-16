package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgAttResCollection extends AbstractObjectCollection 
{
    public AlgAttResCollection()
    {
        super(AlgAttResInfo.class);
    }
    public boolean add(AlgAttResInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgAttResCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgAttResInfo item)
    {
        return removeObject(item);
    }
    public AlgAttResInfo get(int index)
    {
        return(AlgAttResInfo)getObject(index);
    }
    public AlgAttResInfo get(Object key)
    {
        return(AlgAttResInfo)getObject(key);
    }
    public void set(int index, AlgAttResInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgAttResInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgAttResInfo item)
    {
        return super.indexOf(item);
    }
}