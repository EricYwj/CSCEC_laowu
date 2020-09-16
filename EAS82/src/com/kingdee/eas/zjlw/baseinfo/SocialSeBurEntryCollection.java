package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SocialSeBurEntryCollection extends AbstractObjectCollection 
{
    public SocialSeBurEntryCollection()
    {
        super(SocialSeBurEntryInfo.class);
    }
    public boolean add(SocialSeBurEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SocialSeBurEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SocialSeBurEntryInfo item)
    {
        return removeObject(item);
    }
    public SocialSeBurEntryInfo get(int index)
    {
        return(SocialSeBurEntryInfo)getObject(index);
    }
    public SocialSeBurEntryInfo get(Object key)
    {
        return(SocialSeBurEntryInfo)getObject(key);
    }
    public void set(int index, SocialSeBurEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SocialSeBurEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SocialSeBurEntryInfo item)
    {
        return super.indexOf(item);
    }
}