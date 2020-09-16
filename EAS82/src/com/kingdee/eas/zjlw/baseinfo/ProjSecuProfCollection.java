package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjSecuProfCollection extends AbstractObjectCollection 
{
    public ProjSecuProfCollection()
    {
        super(ProjSecuProfInfo.class);
    }
    public boolean add(ProjSecuProfInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjSecuProfCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjSecuProfInfo item)
    {
        return removeObject(item);
    }
    public ProjSecuProfInfo get(int index)
    {
        return(ProjSecuProfInfo)getObject(index);
    }
    public ProjSecuProfInfo get(Object key)
    {
        return(ProjSecuProfInfo)getObject(key);
    }
    public void set(int index, ProjSecuProfInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjSecuProfInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjSecuProfInfo item)
    {
        return super.indexOf(item);
    }
}