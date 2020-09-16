package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtTrnECCollection extends AbstractObjectCollection 
{
    public WkPmtTrnECCollection()
    {
        super(WkPmtTrnECInfo.class);
    }
    public boolean add(WkPmtTrnECInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtTrnECCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtTrnECInfo item)
    {
        return removeObject(item);
    }
    public WkPmtTrnECInfo get(int index)
    {
        return(WkPmtTrnECInfo)getObject(index);
    }
    public WkPmtTrnECInfo get(Object key)
    {
        return(WkPmtTrnECInfo)getObject(key);
    }
    public void set(int index, WkPmtTrnECInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtTrnECInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtTrnECInfo item)
    {
        return super.indexOf(item);
    }
}