package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DistrGovernmentEntryCollection extends AbstractObjectCollection 
{
    public DistrGovernmentEntryCollection()
    {
        super(DistrGovernmentEntryInfo.class);
    }
    public boolean add(DistrGovernmentEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DistrGovernmentEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DistrGovernmentEntryInfo item)
    {
        return removeObject(item);
    }
    public DistrGovernmentEntryInfo get(int index)
    {
        return(DistrGovernmentEntryInfo)getObject(index);
    }
    public DistrGovernmentEntryInfo get(Object key)
    {
        return(DistrGovernmentEntryInfo)getObject(key);
    }
    public void set(int index, DistrGovernmentEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DistrGovernmentEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DistrGovernmentEntryInfo item)
    {
        return super.indexOf(item);
    }
}