package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtUpdtECEntryCollection extends AbstractObjectCollection 
{
    public WkPmtUpdtECEntryCollection()
    {
        super(WkPmtUpdtECEntryInfo.class);
    }
    public boolean add(WkPmtUpdtECEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtUpdtECEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtUpdtECEntryInfo item)
    {
        return removeObject(item);
    }
    public WkPmtUpdtECEntryInfo get(int index)
    {
        return(WkPmtUpdtECEntryInfo)getObject(index);
    }
    public WkPmtUpdtECEntryInfo get(Object key)
    {
        return(WkPmtUpdtECEntryInfo)getObject(key);
    }
    public void set(int index, WkPmtUpdtECEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtUpdtECEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtUpdtECEntryInfo item)
    {
        return super.indexOf(item);
    }
}