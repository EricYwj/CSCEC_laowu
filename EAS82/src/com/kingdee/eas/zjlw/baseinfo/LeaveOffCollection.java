package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LeaveOffCollection extends AbstractObjectCollection 
{
    public LeaveOffCollection()
    {
        super(LeaveOffInfo.class);
    }
    public boolean add(LeaveOffInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LeaveOffCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LeaveOffInfo item)
    {
        return removeObject(item);
    }
    public LeaveOffInfo get(int index)
    {
        return(LeaveOffInfo)getObject(index);
    }
    public LeaveOffInfo get(Object key)
    {
        return(LeaveOffInfo)getObject(key);
    }
    public void set(int index, LeaveOffInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LeaveOffInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LeaveOffInfo item)
    {
        return super.indexOf(item);
    }
}