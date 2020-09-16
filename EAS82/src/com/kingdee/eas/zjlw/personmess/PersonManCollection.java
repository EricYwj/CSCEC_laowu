package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonManCollection extends AbstractObjectCollection 
{
    public PersonManCollection()
    {
        super(PersonManInfo.class);
    }
    public boolean add(PersonManInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonManCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonManInfo item)
    {
        return removeObject(item);
    }
    public PersonManInfo get(int index)
    {
        return(PersonManInfo)getObject(index);
    }
    public PersonManInfo get(Object key)
    {
        return(PersonManInfo)getObject(key);
    }
    public void set(int index, PersonManInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonManInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonManInfo item)
    {
        return super.indexOf(item);
    }
}