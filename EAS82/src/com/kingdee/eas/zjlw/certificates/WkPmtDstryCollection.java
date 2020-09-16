package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtDstryCollection extends AbstractObjectCollection 
{
    public WkPmtDstryCollection()
    {
        super(WkPmtDstryInfo.class);
    }
    public boolean add(WkPmtDstryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtDstryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtDstryInfo item)
    {
        return removeObject(item);
    }
    public WkPmtDstryInfo get(int index)
    {
        return(WkPmtDstryInfo)getObject(index);
    }
    public WkPmtDstryInfo get(Object key)
    {
        return(WkPmtDstryInfo)getObject(key);
    }
    public void set(int index, WkPmtDstryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtDstryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtDstryInfo item)
    {
        return super.indexOf(item);
    }
}