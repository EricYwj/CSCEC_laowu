package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EpEcCollection extends AbstractObjectCollection 
{
    public EpEcCollection()
    {
        super(EpEcInfo.class);
    }
    public boolean add(EpEcInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EpEcCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EpEcInfo item)
    {
        return removeObject(item);
    }
    public EpEcInfo get(int index)
    {
        return(EpEcInfo)getObject(index);
    }
    public EpEcInfo get(Object key)
    {
        return(EpEcInfo)getObject(key);
    }
    public void set(int index, EpEcInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EpEcInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EpEcInfo item)
    {
        return super.indexOf(item);
    }
}