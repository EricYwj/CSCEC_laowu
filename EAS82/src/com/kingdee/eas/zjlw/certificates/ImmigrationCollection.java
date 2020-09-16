package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ImmigrationCollection extends AbstractObjectCollection 
{
    public ImmigrationCollection()
    {
        super(ImmigrationInfo.class);
    }
    public boolean add(ImmigrationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ImmigrationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ImmigrationInfo item)
    {
        return removeObject(item);
    }
    public ImmigrationInfo get(int index)
    {
        return(ImmigrationInfo)getObject(index);
    }
    public ImmigrationInfo get(Object key)
    {
        return(ImmigrationInfo)getObject(key);
    }
    public void set(int index, ImmigrationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ImmigrationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ImmigrationInfo item)
    {
        return super.indexOf(item);
    }
}