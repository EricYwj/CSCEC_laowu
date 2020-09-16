package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InsurePersonCollection extends AbstractObjectCollection 
{
    public InsurePersonCollection()
    {
        super(InsurePersonInfo.class);
    }
    public boolean add(InsurePersonInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InsurePersonCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InsurePersonInfo item)
    {
        return removeObject(item);
    }
    public InsurePersonInfo get(int index)
    {
        return(InsurePersonInfo)getObject(index);
    }
    public InsurePersonInfo get(Object key)
    {
        return(InsurePersonInfo)getObject(key);
    }
    public void set(int index, InsurePersonInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InsurePersonInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InsurePersonInfo item)
    {
        return super.indexOf(item);
    }
}