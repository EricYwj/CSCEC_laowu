package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttenceDataCollection extends AbstractObjectCollection 
{
    public AttenceDataCollection()
    {
        super(AttenceDataInfo.class);
    }
    public boolean add(AttenceDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttenceDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttenceDataInfo item)
    {
        return removeObject(item);
    }
    public AttenceDataInfo get(int index)
    {
        return(AttenceDataInfo)getObject(index);
    }
    public AttenceDataInfo get(Object key)
    {
        return(AttenceDataInfo)getObject(key);
    }
    public void set(int index, AttenceDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttenceDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttenceDataInfo item)
    {
        return super.indexOf(item);
    }
}