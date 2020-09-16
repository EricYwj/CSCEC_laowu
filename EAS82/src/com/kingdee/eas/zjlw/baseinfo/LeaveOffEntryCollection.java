package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LeaveOffEntryCollection extends AbstractObjectCollection 
{
    public LeaveOffEntryCollection()
    {
        super(LeaveOffEntryInfo.class);
    }
    public boolean add(LeaveOffEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LeaveOffEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LeaveOffEntryInfo item)
    {
        return removeObject(item);
    }
    public LeaveOffEntryInfo get(int index)
    {
        return(LeaveOffEntryInfo)getObject(index);
    }
    public LeaveOffEntryInfo get(Object key)
    {
        return(LeaveOffEntryInfo)getObject(key);
    }
    public void set(int index, LeaveOffEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LeaveOffEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LeaveOffEntryInfo item)
    {
        return super.indexOf(item);
    }
}