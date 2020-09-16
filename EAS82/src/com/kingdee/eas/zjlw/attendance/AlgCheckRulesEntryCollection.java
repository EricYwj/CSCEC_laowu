package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgCheckRulesEntryCollection extends AbstractObjectCollection 
{
    public AlgCheckRulesEntryCollection()
    {
        super(AlgCheckRulesEntryInfo.class);
    }
    public boolean add(AlgCheckRulesEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgCheckRulesEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgCheckRulesEntryInfo item)
    {
        return removeObject(item);
    }
    public AlgCheckRulesEntryInfo get(int index)
    {
        return(AlgCheckRulesEntryInfo)getObject(index);
    }
    public AlgCheckRulesEntryInfo get(Object key)
    {
        return(AlgCheckRulesEntryInfo)getObject(key);
    }
    public void set(int index, AlgCheckRulesEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgCheckRulesEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgCheckRulesEntryInfo item)
    {
        return super.indexOf(item);
    }
}