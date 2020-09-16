package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WkPmtTrnECEntryCollection extends AbstractObjectCollection 
{
    public WkPmtTrnECEntryCollection()
    {
        super(WkPmtTrnECEntryInfo.class);
    }
    public boolean add(WkPmtTrnECEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WkPmtTrnECEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WkPmtTrnECEntryInfo item)
    {
        return removeObject(item);
    }
    public WkPmtTrnECEntryInfo get(int index)
    {
        return(WkPmtTrnECEntryInfo)getObject(index);
    }
    public WkPmtTrnECEntryInfo get(Object key)
    {
        return(WkPmtTrnECEntryInfo)getObject(key);
    }
    public void set(int index, WkPmtTrnECEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WkPmtTrnECEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WkPmtTrnECEntryInfo item)
    {
        return super.indexOf(item);
    }
}