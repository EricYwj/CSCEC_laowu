package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjWageNormEntryCollection extends AbstractObjectCollection 
{
    public ProjWageNormEntryCollection()
    {
        super(ProjWageNormEntryInfo.class);
    }
    public boolean add(ProjWageNormEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjWageNormEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjWageNormEntryInfo item)
    {
        return removeObject(item);
    }
    public ProjWageNormEntryInfo get(int index)
    {
        return(ProjWageNormEntryInfo)getObject(index);
    }
    public ProjWageNormEntryInfo get(Object key)
    {
        return(ProjWageNormEntryInfo)getObject(key);
    }
    public void set(int index, ProjWageNormEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjWageNormEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjWageNormEntryInfo item)
    {
        return super.indexOf(item);
    }
}