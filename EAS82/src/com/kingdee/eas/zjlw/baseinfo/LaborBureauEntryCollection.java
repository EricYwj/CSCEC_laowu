package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LaborBureauEntryCollection extends AbstractObjectCollection 
{
    public LaborBureauEntryCollection()
    {
        super(LaborBureauEntryInfo.class);
    }
    public boolean add(LaborBureauEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LaborBureauEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LaborBureauEntryInfo item)
    {
        return removeObject(item);
    }
    public LaborBureauEntryInfo get(int index)
    {
        return(LaborBureauEntryInfo)getObject(index);
    }
    public LaborBureauEntryInfo get(Object key)
    {
        return(LaborBureauEntryInfo)getObject(key);
    }
    public void set(int index, LaborBureauEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LaborBureauEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LaborBureauEntryInfo item)
    {
        return super.indexOf(item);
    }
}