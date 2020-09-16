package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtUpdtECCollection extends AbstractObjectCollection 
{
    public WkPmtUpdtECCollection()
    {
        super(WkPmtUpdtECInfo.class);
    }
    public boolean add(WkPmtUpdtECInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtUpdtECCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtUpdtECInfo item)
    {
        return removeObject(item);
    }
    public WkPmtUpdtECInfo get(int index)
    {
        return(WkPmtUpdtECInfo)getObject(index);
    }
    public WkPmtUpdtECInfo get(Object key)
    {
        return(WkPmtUpdtECInfo)getObject(key);
    }
    public void set(int index, WkPmtUpdtECInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtUpdtECInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtUpdtECInfo item)
    {
        return super.indexOf(item);
    }
}