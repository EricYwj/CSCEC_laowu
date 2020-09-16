package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckInOutCollection extends AbstractObjectCollection 
{
    public CheckInOutCollection()
    {
        super(CheckInOutInfo.class);
    }
    public boolean add(CheckInOutInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckInOutCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckInOutInfo item)
    {
        return removeObject(item);
    }
    public CheckInOutInfo get(int index)
    {
        return(CheckInOutInfo)getObject(index);
    }
    public CheckInOutInfo get(Object key)
    {
        return(CheckInOutInfo)getObject(key);
    }
    public void set(int index, CheckInOutInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckInOutInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckInOutInfo item)
    {
        return super.indexOf(item);
    }
}