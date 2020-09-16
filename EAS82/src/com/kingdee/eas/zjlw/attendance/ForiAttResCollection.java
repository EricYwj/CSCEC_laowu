package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiAttResCollection extends AbstractObjectCollection 
{
    public ForiAttResCollection()
    {
        super(ForiAttResInfo.class);
    }
    public boolean add(ForiAttResInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiAttResCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiAttResInfo item)
    {
        return removeObject(item);
    }
    public ForiAttResInfo get(int index)
    {
        return(ForiAttResInfo)getObject(index);
    }
    public ForiAttResInfo get(Object key)
    {
        return(ForiAttResInfo)getObject(key);
    }
    public void set(int index, ForiAttResInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiAttResInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiAttResInfo item)
    {
        return super.indexOf(item);
    }
}