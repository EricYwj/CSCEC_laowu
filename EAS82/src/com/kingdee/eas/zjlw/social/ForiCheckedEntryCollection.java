package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiCheckedEntryCollection extends AbstractObjectCollection 
{
    public ForiCheckedEntryCollection()
    {
        super(ForiCheckedEntryInfo.class);
    }
    public boolean add(ForiCheckedEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiCheckedEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiCheckedEntryInfo item)
    {
        return removeObject(item);
    }
    public ForiCheckedEntryInfo get(int index)
    {
        return(ForiCheckedEntryInfo)getObject(index);
    }
    public ForiCheckedEntryInfo get(Object key)
    {
        return(ForiCheckedEntryInfo)getObject(key);
    }
    public void set(int index, ForiCheckedEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiCheckedEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiCheckedEntryInfo item)
    {
        return super.indexOf(item);
    }
}