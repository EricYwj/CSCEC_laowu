package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LabSupBurEntryCollection extends AbstractObjectCollection 
{
    public LabSupBurEntryCollection()
    {
        super(LabSupBurEntryInfo.class);
    }
    public boolean add(LabSupBurEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LabSupBurEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LabSupBurEntryInfo item)
    {
        return removeObject(item);
    }
    public LabSupBurEntryInfo get(int index)
    {
        return(LabSupBurEntryInfo)getObject(index);
    }
    public LabSupBurEntryInfo get(Object key)
    {
        return(LabSupBurEntryInfo)getObject(key);
    }
    public void set(int index, LabSupBurEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LabSupBurEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LabSupBurEntryInfo item)
    {
        return super.indexOf(item);
    }
}