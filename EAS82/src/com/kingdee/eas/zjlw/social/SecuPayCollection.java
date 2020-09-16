package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SecuPayCollection extends AbstractObjectCollection 
{
    public SecuPayCollection()
    {
        super(SecuPayInfo.class);
    }
    public boolean add(SecuPayInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SecuPayCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SecuPayInfo item)
    {
        return removeObject(item);
    }
    public SecuPayInfo get(int index)
    {
        return(SecuPayInfo)getObject(index);
    }
    public SecuPayInfo get(Object key)
    {
        return(SecuPayInfo)getObject(key);
    }
    public void set(int index, SecuPayInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SecuPayInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SecuPayInfo item)
    {
        return super.indexOf(item);
    }
}