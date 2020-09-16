package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttencePersonCollection extends AbstractObjectCollection 
{
    public AttencePersonCollection()
    {
        super(AttencePersonInfo.class);
    }
    public boolean add(AttencePersonInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttencePersonCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttencePersonInfo item)
    {
        return removeObject(item);
    }
    public AttencePersonInfo get(int index)
    {
        return(AttencePersonInfo)getObject(index);
    }
    public AttencePersonInfo get(Object key)
    {
        return(AttencePersonInfo)getObject(key);
    }
    public void set(int index, AttencePersonInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttencePersonInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttencePersonInfo item)
    {
        return super.indexOf(item);
    }
}