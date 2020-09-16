package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LeaveManageEntryCollection extends AbstractObjectCollection 
{
    public LeaveManageEntryCollection()
    {
        super(LeaveManageEntryInfo.class);
    }
    public boolean add(LeaveManageEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LeaveManageEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LeaveManageEntryInfo item)
    {
        return removeObject(item);
    }
    public LeaveManageEntryInfo get(int index)
    {
        return(LeaveManageEntryInfo)getObject(index);
    }
    public LeaveManageEntryInfo get(Object key)
    {
        return(LeaveManageEntryInfo)getObject(key);
    }
    public void set(int index, LeaveManageEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LeaveManageEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LeaveManageEntryInfo item)
    {
        return super.indexOf(item);
    }
}