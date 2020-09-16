package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProfDpCollection extends AbstractObjectCollection 
{
    public ProfDpCollection()
    {
        super(ProfDpInfo.class);
    }
    public boolean add(ProfDpInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProfDpCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProfDpInfo item)
    {
        return removeObject(item);
    }
    public ProfDpInfo get(int index)
    {
        return(ProfDpInfo)getObject(index);
    }
    public ProfDpInfo get(Object key)
    {
        return(ProfDpInfo)getObject(key);
    }
    public void set(int index, ProfDpInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProfDpInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProfDpInfo item)
    {
        return super.indexOf(item);
    }
}