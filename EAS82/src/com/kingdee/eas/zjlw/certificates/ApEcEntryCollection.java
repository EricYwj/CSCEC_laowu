package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ApEcEntryCollection extends AbstractObjectCollection 
{
    public ApEcEntryCollection()
    {
        super(ApEcEntryInfo.class);
    }
    public boolean add(ApEcEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ApEcEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ApEcEntryInfo item)
    {
        return removeObject(item);
    }
    public ApEcEntryInfo get(int index)
    {
        return(ApEcEntryInfo)getObject(index);
    }
    public ApEcEntryInfo get(Object key)
    {
        return(ApEcEntryInfo)getObject(key);
    }
    public void set(int index, ApEcEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ApEcEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ApEcEntryInfo item)
    {
        return super.indexOf(item);
    }
}