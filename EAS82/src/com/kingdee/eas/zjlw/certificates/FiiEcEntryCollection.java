package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FiiEcEntryCollection extends AbstractObjectCollection 
{
    public FiiEcEntryCollection()
    {
        super(FiiEcEntryInfo.class);
    }
    public boolean add(FiiEcEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FiiEcEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FiiEcEntryInfo item)
    {
        return removeObject(item);
    }
    public FiiEcEntryInfo get(int index)
    {
        return(FiiEcEntryInfo)getObject(index);
    }
    public FiiEcEntryInfo get(Object key)
    {
        return(FiiEcEntryInfo)getObject(key);
    }
    public void set(int index, FiiEcEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FiiEcEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FiiEcEntryInfo item)
    {
        return super.indexOf(item);
    }
}