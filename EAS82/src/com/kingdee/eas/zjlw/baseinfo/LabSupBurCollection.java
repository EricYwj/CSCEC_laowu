package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LabSupBurCollection extends AbstractObjectCollection 
{
    public LabSupBurCollection()
    {
        super(LabSupBurInfo.class);
    }
    public boolean add(LabSupBurInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LabSupBurCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LabSupBurInfo item)
    {
        return removeObject(item);
    }
    public LabSupBurInfo get(int index)
    {
        return(LabSupBurInfo)getObject(index);
    }
    public LabSupBurInfo get(Object key)
    {
        return(LabSupBurInfo)getObject(key);
    }
    public void set(int index, LabSupBurInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LabSupBurInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LabSupBurInfo item)
    {
        return super.indexOf(item);
    }
}