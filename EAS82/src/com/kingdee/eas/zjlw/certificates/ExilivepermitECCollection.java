package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExilivepermitECCollection extends AbstractObjectCollection 
{
    public ExilivepermitECCollection()
    {
        super(ExilivepermitECInfo.class);
    }
    public boolean add(ExilivepermitECInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExilivepermitECCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExilivepermitECInfo item)
    {
        return removeObject(item);
    }
    public ExilivepermitECInfo get(int index)
    {
        return(ExilivepermitECInfo)getObject(index);
    }
    public ExilivepermitECInfo get(Object key)
    {
        return(ExilivepermitECInfo)getObject(key);
    }
    public void set(int index, ExilivepermitECInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExilivepermitECInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExilivepermitECInfo item)
    {
        return super.indexOf(item);
    }
}