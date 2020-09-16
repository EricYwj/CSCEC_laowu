package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DoubEcCollection extends AbstractObjectCollection 
{
    public DoubEcCollection()
    {
        super(DoubEcInfo.class);
    }
    public boolean add(DoubEcInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DoubEcCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DoubEcInfo item)
    {
        return removeObject(item);
    }
    public DoubEcInfo get(int index)
    {
        return(DoubEcInfo)getObject(index);
    }
    public DoubEcInfo get(Object key)
    {
        return(DoubEcInfo)getObject(key);
    }
    public void set(int index, DoubEcInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DoubEcInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DoubEcInfo item)
    {
        return super.indexOf(item);
    }
}