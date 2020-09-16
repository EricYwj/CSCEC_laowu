package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AntiSignedEntryCollection extends AbstractObjectCollection 
{
    public AntiSignedEntryCollection()
    {
        super(AntiSignedEntryInfo.class);
    }
    public boolean add(AntiSignedEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AntiSignedEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AntiSignedEntryInfo item)
    {
        return removeObject(item);
    }
    public AntiSignedEntryInfo get(int index)
    {
        return(AntiSignedEntryInfo)getObject(index);
    }
    public AntiSignedEntryInfo get(Object key)
    {
        return(AntiSignedEntryInfo)getObject(key);
    }
    public void set(int index, AntiSignedEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AntiSignedEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AntiSignedEntryInfo item)
    {
        return super.indexOf(item);
    }
}