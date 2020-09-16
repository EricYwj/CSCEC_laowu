package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiAttRuleCollection extends AbstractObjectCollection 
{
    public ForiAttRuleCollection()
    {
        super(ForiAttRuleInfo.class);
    }
    public boolean add(ForiAttRuleInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiAttRuleCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiAttRuleInfo item)
    {
        return removeObject(item);
    }
    public ForiAttRuleInfo get(int index)
    {
        return(ForiAttRuleInfo)getObject(index);
    }
    public ForiAttRuleInfo get(Object key)
    {
        return(ForiAttRuleInfo)getObject(key);
    }
    public void set(int index, ForiAttRuleInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiAttRuleInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiAttRuleInfo item)
    {
        return super.indexOf(item);
    }
}