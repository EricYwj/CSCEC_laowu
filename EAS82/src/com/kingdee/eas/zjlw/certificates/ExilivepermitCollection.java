package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExilivepermitCollection extends AbstractObjectCollection 
{
    public ExilivepermitCollection()
    {
        super(ExilivepermitInfo.class);
    }
    public boolean add(ExilivepermitInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExilivepermitCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExilivepermitInfo item)
    {
        return removeObject(item);
    }
    public ExilivepermitInfo get(int index)
    {
        return(ExilivepermitInfo)getObject(index);
    }
    public ExilivepermitInfo get(Object key)
    {
        return(ExilivepermitInfo)getObject(key);
    }
    public void set(int index, ExilivepermitInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExilivepermitInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExilivepermitInfo item)
    {
        return super.indexOf(item);
    }
}