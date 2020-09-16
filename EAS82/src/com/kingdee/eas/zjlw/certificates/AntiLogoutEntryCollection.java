package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AntiLogoutEntryCollection extends AbstractObjectCollection 
{
    public AntiLogoutEntryCollection()
    {
        super(AntiLogoutEntryInfo.class);
    }
    public boolean add(AntiLogoutEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AntiLogoutEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AntiLogoutEntryInfo item)
    {
        return removeObject(item);
    }
    public AntiLogoutEntryInfo get(int index)
    {
        return(AntiLogoutEntryInfo)getObject(index);
    }
    public AntiLogoutEntryInfo get(Object key)
    {
        return(AntiLogoutEntryInfo)getObject(key);
    }
    public void set(int index, AntiLogoutEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AntiLogoutEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AntiLogoutEntryInfo item)
    {
        return super.indexOf(item);
    }
}