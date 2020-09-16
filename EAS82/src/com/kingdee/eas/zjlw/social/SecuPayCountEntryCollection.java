package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SecuPayCountEntryCollection extends AbstractObjectCollection 
{
    public SecuPayCountEntryCollection()
    {
        super(SecuPayCountEntryInfo.class);
    }
    public boolean add(SecuPayCountEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SecuPayCountEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SecuPayCountEntryInfo item)
    {
        return removeObject(item);
    }
    public SecuPayCountEntryInfo get(int index)
    {
        return(SecuPayCountEntryInfo)getObject(index);
    }
    public SecuPayCountEntryInfo get(Object key)
    {
        return(SecuPayCountEntryInfo)getObject(key);
    }
    public void set(int index, SecuPayCountEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SecuPayCountEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SecuPayCountEntryInfo item)
    {
        return super.indexOf(item);
    }
}