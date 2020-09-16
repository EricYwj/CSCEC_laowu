package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FiiEcCollection extends AbstractObjectCollection 
{
    public FiiEcCollection()
    {
        super(FiiEcInfo.class);
    }
    public boolean add(FiiEcInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FiiEcCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FiiEcInfo item)
    {
        return removeObject(item);
    }
    public FiiEcInfo get(int index)
    {
        return(FiiEcInfo)getObject(index);
    }
    public FiiEcInfo get(Object key)
    {
        return(FiiEcInfo)getObject(key);
    }
    public void set(int index, FiiEcInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FiiEcInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FiiEcInfo item)
    {
        return super.indexOf(item);
    }
}