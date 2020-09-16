package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtTrnCollection extends AbstractObjectCollection 
{
    public WkPmtTrnCollection()
    {
        super(WkPmtTrnInfo.class);
    }
    public boolean add(WkPmtTrnInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtTrnCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtTrnInfo item)
    {
        return removeObject(item);
    }
    public WkPmtTrnInfo get(int index)
    {
        return(WkPmtTrnInfo)getObject(index);
    }
    public WkPmtTrnInfo get(Object key)
    {
        return(WkPmtTrnInfo)getObject(key);
    }
    public void set(int index, WkPmtTrnInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtTrnInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtTrnInfo item)
    {
        return super.indexOf(item);
    }
}