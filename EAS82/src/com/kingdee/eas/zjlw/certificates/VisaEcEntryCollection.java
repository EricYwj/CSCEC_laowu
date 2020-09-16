package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class VisaEcEntryCollection extends AbstractObjectCollection 
{
    public VisaEcEntryCollection()
    {
        super(VisaEcEntryInfo.class);
    }
    public boolean add(VisaEcEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(VisaEcEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(VisaEcEntryInfo item)
    {
        return removeObject(item);
    }
    public VisaEcEntryInfo get(int index)
    {
        return(VisaEcEntryInfo)getObject(index);
    }
    public VisaEcEntryInfo get(Object key)
    {
        return(VisaEcEntryInfo)getObject(key);
    }
    public void set(int index, VisaEcEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(VisaEcEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(VisaEcEntryInfo item)
    {
        return super.indexOf(item);
    }
}