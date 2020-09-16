package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SocialSeBurCollection extends AbstractObjectCollection 
{
    public SocialSeBurCollection()
    {
        super(SocialSeBurInfo.class);
    }
    public boolean add(SocialSeBurInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SocialSeBurCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SocialSeBurInfo item)
    {
        return removeObject(item);
    }
    public SocialSeBurInfo get(int index)
    {
        return(SocialSeBurInfo)getObject(index);
    }
    public SocialSeBurInfo get(Object key)
    {
        return(SocialSeBurInfo)getObject(key);
    }
    public void set(int index, SocialSeBurInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SocialSeBurInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SocialSeBurInfo item)
    {
        return super.indexOf(item);
    }
}