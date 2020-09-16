package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtDstryECCollection extends AbstractObjectCollection 
{
    public WkPmtDstryECCollection()
    {
        super(WkPmtDstryECInfo.class);
    }
    public boolean add(WkPmtDstryECInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtDstryECCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtDstryECInfo item)
    {
        return removeObject(item);
    }
    public WkPmtDstryECInfo get(int index)
    {
        return(WkPmtDstryECInfo)getObject(index);
    }
    public WkPmtDstryECInfo get(Object key)
    {
        return(WkPmtDstryECInfo)getObject(key);
    }
    public void set(int index, WkPmtDstryECInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtDstryECInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtDstryECInfo item)
    {
        return super.indexOf(item);
    }
}