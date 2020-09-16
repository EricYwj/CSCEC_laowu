package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtUpdtCollection extends AbstractObjectCollection 
{
    public WkPmtUpdtCollection()
    {
        super(WkPmtUpdtInfo.class);
    }
    public boolean add(WkPmtUpdtInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtUpdtCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtUpdtInfo item)
    {
        return removeObject(item);
    }
    public WkPmtUpdtInfo get(int index)
    {
        return(WkPmtUpdtInfo)getObject(index);
    }
    public WkPmtUpdtInfo get(Object key)
    {
        return(WkPmtUpdtInfo)getObject(key);
    }
    public void set(int index, WkPmtUpdtInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtUpdtInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtUpdtInfo item)
    {
        return super.indexOf(item);
    }
}