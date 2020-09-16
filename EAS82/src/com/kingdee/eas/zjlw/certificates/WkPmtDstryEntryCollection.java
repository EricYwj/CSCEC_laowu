package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtDstryEntryCollection extends AbstractObjectCollection 
{
    public WkPmtDstryEntryCollection()
    {
        super(WkPmtDstryEntryInfo.class);
    }
    public boolean add(WkPmtDstryEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtDstryEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtDstryEntryInfo item)
    {
        return removeObject(item);
    }
    public WkPmtDstryEntryInfo get(int index)
    {
        return(WkPmtDstryEntryInfo)getObject(index);
    }
    public WkPmtDstryEntryInfo get(Object key)
    {
        return(WkPmtDstryEntryInfo)getObject(key);
    }
    public void set(int index, WkPmtDstryEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtDstryEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtDstryEntryInfo item)
    {
        return super.indexOf(item);
    }
}