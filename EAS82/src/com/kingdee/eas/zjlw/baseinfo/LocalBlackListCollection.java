package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LocalBlackListCollection extends AbstractObjectCollection 
{
    public LocalBlackListCollection()
    {
        super(LocalBlackListInfo.class);
    }
    public boolean add(LocalBlackListInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LocalBlackListCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LocalBlackListInfo item)
    {
        return removeObject(item);
    }
    public LocalBlackListInfo get(int index)
    {
        return(LocalBlackListInfo)getObject(index);
    }
    public LocalBlackListInfo get(Object key)
    {
        return(LocalBlackListInfo)getObject(key);
    }
    public void set(int index, LocalBlackListInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LocalBlackListInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LocalBlackListInfo item)
    {
        return super.indexOf(item);
    }
}