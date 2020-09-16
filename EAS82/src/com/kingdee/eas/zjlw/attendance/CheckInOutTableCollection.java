package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckInOutTableCollection extends AbstractObjectCollection 
{
    public CheckInOutTableCollection()
    {
        super(CheckInOutTableInfo.class);
    }
    public boolean add(CheckInOutTableInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckInOutTableCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckInOutTableInfo item)
    {
        return removeObject(item);
    }
    public CheckInOutTableInfo get(int index)
    {
        return(CheckInOutTableInfo)getObject(index);
    }
    public CheckInOutTableInfo get(Object key)
    {
        return(CheckInOutTableInfo)getObject(key);
    }
    public void set(int index, CheckInOutTableInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckInOutTableInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckInOutTableInfo item)
    {
        return super.indexOf(item);
    }
}