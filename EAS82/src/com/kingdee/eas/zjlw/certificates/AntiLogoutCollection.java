package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AntiLogoutCollection extends AbstractObjectCollection 
{
    public AntiLogoutCollection()
    {
        super(AntiLogoutInfo.class);
    }
    public boolean add(AntiLogoutInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AntiLogoutCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AntiLogoutInfo item)
    {
        return removeObject(item);
    }
    public AntiLogoutInfo get(int index)
    {
        return(AntiLogoutInfo)getObject(index);
    }
    public AntiLogoutInfo get(Object key)
    {
        return(AntiLogoutInfo)getObject(key);
    }
    public void set(int index, AntiLogoutInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AntiLogoutInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AntiLogoutInfo item)
    {
        return super.indexOf(item);
    }
}