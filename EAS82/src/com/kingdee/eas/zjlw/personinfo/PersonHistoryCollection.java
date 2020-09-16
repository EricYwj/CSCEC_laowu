package com.kingdee.eas.zjlw.personinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonHistoryCollection extends AbstractObjectCollection 
{
    public PersonHistoryCollection()
    {
        super(PersonHistoryInfo.class);
    }
    public boolean add(PersonHistoryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonHistoryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonHistoryInfo item)
    {
        return removeObject(item);
    }
    public PersonHistoryInfo get(int index)
    {
        return(PersonHistoryInfo)getObject(index);
    }
    public PersonHistoryInfo get(Object key)
    {
        return(PersonHistoryInfo)getObject(key);
    }
    public void set(int index, PersonHistoryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonHistoryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonHistoryInfo item)
    {
        return super.indexOf(item);
    }
}