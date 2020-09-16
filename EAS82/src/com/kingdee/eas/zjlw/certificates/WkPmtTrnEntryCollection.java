package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtTrnEntryCollection extends AbstractObjectCollection 
{
    public WkPmtTrnEntryCollection()
    {
        super(WkPmtTrnEntryInfo.class);
    }
    public boolean add(WkPmtTrnEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtTrnEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtTrnEntryInfo item)
    {
        return removeObject(item);
    }
    public WkPmtTrnEntryInfo get(int index)
    {
        return(WkPmtTrnEntryInfo)getObject(index);
    }
    public WkPmtTrnEntryInfo get(Object key)
    {
        return(WkPmtTrnEntryInfo)getObject(key);
    }
    public void set(int index, WkPmtTrnEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtTrnEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtTrnEntryInfo item)
    {
        return super.indexOf(item);
    }
}