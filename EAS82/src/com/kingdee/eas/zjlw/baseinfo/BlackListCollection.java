package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BlackListCollection extends AbstractObjectCollection 
{
    public BlackListCollection()
    {
        super(BlackListInfo.class);
    }
    public boolean add(BlackListInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BlackListCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BlackListInfo item)
    {
        return removeObject(item);
    }
    public BlackListInfo get(int index)
    {
        return(BlackListInfo)getObject(index);
    }
    public BlackListInfo get(Object key)
    {
        return(BlackListInfo)getObject(key);
    }
    public void set(int index, BlackListInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BlackListInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BlackListInfo item)
    {
        return super.indexOf(item);
    }
}