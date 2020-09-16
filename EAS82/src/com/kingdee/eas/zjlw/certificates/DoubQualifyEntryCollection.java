package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DoubQualifyEntryCollection extends AbstractObjectCollection 
{
    public DoubQualifyEntryCollection()
    {
        super(DoubQualifyEntryInfo.class);
    }
    public boolean add(DoubQualifyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DoubQualifyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DoubQualifyEntryInfo item)
    {
        return removeObject(item);
    }
    public DoubQualifyEntryInfo get(int index)
    {
        return(DoubQualifyEntryInfo)getObject(index);
    }
    public DoubQualifyEntryInfo get(Object key)
    {
        return(DoubQualifyEntryInfo)getObject(key);
    }
    public void set(int index, DoubQualifyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DoubQualifyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DoubQualifyEntryInfo item)
    {
        return super.indexOf(item);
    }
}