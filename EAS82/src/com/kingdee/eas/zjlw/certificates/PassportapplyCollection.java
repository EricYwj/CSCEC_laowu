package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PassportapplyCollection extends AbstractObjectCollection 
{
    public PassportapplyCollection()
    {
        super(PassportapplyInfo.class);
    }
    public boolean add(PassportapplyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PassportapplyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PassportapplyInfo item)
    {
        return removeObject(item);
    }
    public PassportapplyInfo get(int index)
    {
        return(PassportapplyInfo)getObject(index);
    }
    public PassportapplyInfo get(Object key)
    {
        return(PassportapplyInfo)getObject(key);
    }
    public void set(int index, PassportapplyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PassportapplyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PassportapplyInfo item)
    {
        return super.indexOf(item);
    }
}