package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtDstryECEntryCollection extends AbstractObjectCollection 
{
    public WkPmtDstryECEntryCollection()
    {
        super(WkPmtDstryECEntryInfo.class);
    }
    public boolean add(WkPmtDstryECEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtDstryECEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtDstryECEntryInfo item)
    {
        return removeObject(item);
    }
    public WkPmtDstryECEntryInfo get(int index)
    {
        return(WkPmtDstryECEntryInfo)getObject(index);
    }
    public WkPmtDstryECEntryInfo get(Object key)
    {
        return(WkPmtDstryECEntryInfo)getObject(key);
    }
    public void set(int index, WkPmtDstryECEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtDstryECEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtDstryECEntryInfo item)
    {
        return super.indexOf(item);
    }
}