package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EpEcEntryCollection extends AbstractObjectCollection 
{
    public EpEcEntryCollection()
    {
        super(EpEcEntryInfo.class);
    }
    public boolean add(EpEcEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EpEcEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EpEcEntryInfo item)
    {
        return removeObject(item);
    }
    public EpEcEntryInfo get(int index)
    {
        return(EpEcEntryInfo)getObject(index);
    }
    public EpEcEntryInfo get(Object key)
    {
        return(EpEcEntryInfo)getObject(key);
    }
    public void set(int index, EpEcEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EpEcEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EpEcEntryInfo item)
    {
        return super.indexOf(item);
    }
}