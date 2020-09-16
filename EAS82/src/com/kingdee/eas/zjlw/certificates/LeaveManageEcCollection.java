package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LeaveManageEcCollection extends AbstractObjectCollection 
{
    public LeaveManageEcCollection()
    {
        super(LeaveManageEcInfo.class);
    }
    public boolean add(LeaveManageEcInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LeaveManageEcCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LeaveManageEcInfo item)
    {
        return removeObject(item);
    }
    public LeaveManageEcInfo get(int index)
    {
        return(LeaveManageEcInfo)getObject(index);
    }
    public LeaveManageEcInfo get(Object key)
    {
        return(LeaveManageEcInfo)getObject(key);
    }
    public void set(int index, LeaveManageEcInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LeaveManageEcInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LeaveManageEcInfo item)
    {
        return super.indexOf(item);
    }
}