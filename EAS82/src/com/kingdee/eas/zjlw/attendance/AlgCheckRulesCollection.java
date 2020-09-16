package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgCheckRulesCollection extends AbstractObjectCollection 
{
    public AlgCheckRulesCollection()
    {
        super(AlgCheckRulesInfo.class);
    }
    public boolean add(AlgCheckRulesInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgCheckRulesCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgCheckRulesInfo item)
    {
        return removeObject(item);
    }
    public AlgCheckRulesInfo get(int index)
    {
        return(AlgCheckRulesInfo)getObject(index);
    }
    public AlgCheckRulesInfo get(Object key)
    {
        return(AlgCheckRulesInfo)getObject(key);
    }
    public void set(int index, AlgCheckRulesInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgCheckRulesInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgCheckRulesInfo item)
    {
        return super.indexOf(item);
    }
}