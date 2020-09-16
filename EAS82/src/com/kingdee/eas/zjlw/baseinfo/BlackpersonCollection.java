package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BlackpersonCollection extends AbstractObjectCollection 
{
    public BlackpersonCollection()
    {
        super(BlackpersonInfo.class);
    }
    public boolean add(BlackpersonInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BlackpersonCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BlackpersonInfo item)
    {
        return removeObject(item);
    }
    public BlackpersonInfo get(int index)
    {
        return(BlackpersonInfo)getObject(index);
    }
    public BlackpersonInfo get(Object key)
    {
        return(BlackpersonInfo)getObject(key);
    }
    public void set(int index, BlackpersonInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BlackpersonInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BlackpersonInfo item)
    {
        return super.indexOf(item);
    }
}