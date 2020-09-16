package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SocialAddCollection extends AbstractObjectCollection 
{
    public SocialAddCollection()
    {
        super(SocialAddInfo.class);
    }
    public boolean add(SocialAddInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SocialAddCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SocialAddInfo item)
    {
        return removeObject(item);
    }
    public SocialAddInfo get(int index)
    {
        return(SocialAddInfo)getObject(index);
    }
    public SocialAddInfo get(Object key)
    {
        return(SocialAddInfo)getObject(key);
    }
    public void set(int index, SocialAddInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SocialAddInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SocialAddInfo item)
    {
        return super.indexOf(item);
    }
}