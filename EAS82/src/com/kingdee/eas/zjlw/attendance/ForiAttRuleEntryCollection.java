package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiAttRuleEntryCollection extends AbstractObjectCollection 
{
    public ForiAttRuleEntryCollection()
    {
        super(ForiAttRuleEntryInfo.class);
    }
    public boolean add(ForiAttRuleEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiAttRuleEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiAttRuleEntryInfo item)
    {
        return removeObject(item);
    }
    public ForiAttRuleEntryInfo get(int index)
    {
        return(ForiAttRuleEntryInfo)getObject(index);
    }
    public ForiAttRuleEntryInfo get(Object key)
    {
        return(ForiAttRuleEntryInfo)getObject(key);
    }
    public void set(int index, ForiAttRuleEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiAttRuleEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiAttRuleEntryInfo item)
    {
        return super.indexOf(item);
    }
}