package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EmploBurEntryCollection extends AbstractObjectCollection 
{
    public EmploBurEntryCollection()
    {
        super(EmploBurEntryInfo.class);
    }
    public boolean add(EmploBurEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EmploBurEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EmploBurEntryInfo item)
    {
        return removeObject(item);
    }
    public EmploBurEntryInfo get(int index)
    {
        return(EmploBurEntryInfo)getObject(index);
    }
    public EmploBurEntryInfo get(Object key)
    {
        return(EmploBurEntryInfo)getObject(key);
    }
    public void set(int index, EmploBurEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EmploBurEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EmploBurEntryInfo item)
    {
        return super.indexOf(item);
    }
}