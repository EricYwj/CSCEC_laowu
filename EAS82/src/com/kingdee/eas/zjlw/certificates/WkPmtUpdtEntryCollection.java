package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtUpdtEntryCollection extends AbstractObjectCollection 
{
    public WkPmtUpdtEntryCollection()
    {
        super(WkPmtUpdtEntryInfo.class);
    }
    public boolean add(WkPmtUpdtEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtUpdtEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtUpdtEntryInfo item)
    {
        return removeObject(item);
    }
    public WkPmtUpdtEntryInfo get(int index)
    {
        return(WkPmtUpdtEntryInfo)getObject(index);
    }
    public WkPmtUpdtEntryInfo get(Object key)
    {
        return(WkPmtUpdtEntryInfo)getObject(key);
    }
    public void set(int index, WkPmtUpdtEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtUpdtEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtUpdtEntryInfo item)
    {
        return super.indexOf(item);
    }
}