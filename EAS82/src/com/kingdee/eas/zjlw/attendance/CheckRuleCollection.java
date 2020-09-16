package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckRuleCollection extends AbstractObjectCollection 
{
    public CheckRuleCollection()
    {
        super(CheckRuleInfo.class);
    }
    public boolean add(CheckRuleInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckRuleCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckRuleInfo item)
    {
        return removeObject(item);
    }
    public CheckRuleInfo get(int index)
    {
        return(CheckRuleInfo)getObject(index);
    }
    public CheckRuleInfo get(Object key)
    {
        return(CheckRuleInfo)getObject(key);
    }
    public void set(int index, CheckRuleInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckRuleInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckRuleInfo item)
    {
        return super.indexOf(item);
    }
}