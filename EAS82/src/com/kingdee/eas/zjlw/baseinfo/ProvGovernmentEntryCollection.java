package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProvGovernmentEntryCollection extends AbstractObjectCollection 
{
    public ProvGovernmentEntryCollection()
    {
        super(ProvGovernmentEntryInfo.class);
    }
    public boolean add(ProvGovernmentEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProvGovernmentEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProvGovernmentEntryInfo item)
    {
        return removeObject(item);
    }
    public ProvGovernmentEntryInfo get(int index)
    {
        return(ProvGovernmentEntryInfo)getObject(index);
    }
    public ProvGovernmentEntryInfo get(Object key)
    {
        return(ProvGovernmentEntryInfo)getObject(key);
    }
    public void set(int index, ProvGovernmentEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProvGovernmentEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProvGovernmentEntryInfo item)
    {
        return super.indexOf(item);
    }
}