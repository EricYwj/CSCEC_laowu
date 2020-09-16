package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonManEntryCollection extends AbstractObjectCollection 
{
    public PersonManEntryCollection()
    {
        super(PersonManEntryInfo.class);
    }
    public boolean add(PersonManEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonManEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonManEntryInfo item)
    {
        return removeObject(item);
    }
    public PersonManEntryInfo get(int index)
    {
        return(PersonManEntryInfo)getObject(index);
    }
    public PersonManEntryInfo get(Object key)
    {
        return(PersonManEntryInfo)getObject(key);
    }
    public void set(int index, PersonManEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonManEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonManEntryInfo item)
    {
        return super.indexOf(item);
    }
}