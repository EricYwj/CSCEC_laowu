package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttenceCollection extends AbstractObjectCollection 
{
    public AttenceCollection()
    {
        super(AttenceInfo.class);
    }
    public boolean add(AttenceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttenceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttenceInfo item)
    {
        return removeObject(item);
    }
    public AttenceInfo get(int index)
    {
        return(AttenceInfo)getObject(index);
    }
    public AttenceInfo get(Object key)
    {
        return(AttenceInfo)getObject(key);
    }
    public void set(int index, AttenceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttenceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttenceInfo item)
    {
        return super.indexOf(item);
    }
}