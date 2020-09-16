package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DoubEcEntryCollection extends AbstractObjectCollection 
{
    public DoubEcEntryCollection()
    {
        super(DoubEcEntryInfo.class);
    }
    public boolean add(DoubEcEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DoubEcEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DoubEcEntryInfo item)
    {
        return removeObject(item);
    }
    public DoubEcEntryInfo get(int index)
    {
        return(DoubEcEntryInfo)getObject(index);
    }
    public DoubEcEntryInfo get(Object key)
    {
        return(DoubEcEntryInfo)getObject(key);
    }
    public void set(int index, DoubEcEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DoubEcEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DoubEcEntryInfo item)
    {
        return super.indexOf(item);
    }
}