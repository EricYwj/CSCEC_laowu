package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttenceResultCollection extends AbstractObjectCollection 
{
    public AttenceResultCollection()
    {
        super(AttenceResultInfo.class);
    }
    public boolean add(AttenceResultInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttenceResultCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttenceResultInfo item)
    {
        return removeObject(item);
    }
    public AttenceResultInfo get(int index)
    {
        return(AttenceResultInfo)getObject(index);
    }
    public AttenceResultInfo get(Object key)
    {
        return(AttenceResultInfo)getObject(key);
    }
    public void set(int index, AttenceResultInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttenceResultInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttenceResultInfo item)
    {
        return super.indexOf(item);
    }
}