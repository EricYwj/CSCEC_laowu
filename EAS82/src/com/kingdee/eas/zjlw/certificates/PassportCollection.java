package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PassportCollection extends AbstractObjectCollection 
{
    public PassportCollection()
    {
        super(PassportInfo.class);
    }
    public boolean add(PassportInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PassportCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PassportInfo item)
    {
        return removeObject(item);
    }
    public PassportInfo get(int index)
    {
        return(PassportInfo)getObject(index);
    }
    public PassportInfo get(Object key)
    {
        return(PassportInfo)getObject(key);
    }
    public void set(int index, PassportInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PassportInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PassportInfo item)
    {
        return super.indexOf(item);
    }
}