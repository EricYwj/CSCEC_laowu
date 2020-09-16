package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LeaveManageEcEntryCollection extends AbstractObjectCollection 
{
    public LeaveManageEcEntryCollection()
    {
        super(LeaveManageEcEntryInfo.class);
    }
    public boolean add(LeaveManageEcEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LeaveManageEcEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LeaveManageEcEntryInfo item)
    {
        return removeObject(item);
    }
    public LeaveManageEcEntryInfo get(int index)
    {
        return(LeaveManageEcEntryInfo)getObject(index);
    }
    public LeaveManageEcEntryInfo get(Object key)
    {
        return(LeaveManageEcEntryInfo)getObject(key);
    }
    public void set(int index, LeaveManageEcEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LeaveManageEcEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LeaveManageEcEntryInfo item)
    {
        return super.indexOf(item);
    }
}