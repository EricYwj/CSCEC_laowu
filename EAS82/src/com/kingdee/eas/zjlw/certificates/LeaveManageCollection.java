package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LeaveManageCollection extends AbstractObjectCollection 
{
    public LeaveManageCollection()
    {
        super(LeaveManageInfo.class);
    }
    public boolean add(LeaveManageInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LeaveManageCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LeaveManageInfo item)
    {
        return removeObject(item);
    }
    public LeaveManageInfo get(int index)
    {
        return(LeaveManageInfo)getObject(index);
    }
    public LeaveManageInfo get(Object key)
    {
        return(LeaveManageInfo)getObject(key);
    }
    public void set(int index, LeaveManageInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LeaveManageInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LeaveManageInfo item)
    {
        return super.indexOf(item);
    }
}