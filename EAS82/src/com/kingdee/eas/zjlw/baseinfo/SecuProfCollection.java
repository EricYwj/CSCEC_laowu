package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SecuProfCollection extends AbstractObjectCollection 
{
    public SecuProfCollection()
    {
        super(SecuProfInfo.class);
    }
    public boolean add(SecuProfInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SecuProfCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SecuProfInfo item)
    {
        return removeObject(item);
    }
    public SecuProfInfo get(int index)
    {
        return(SecuProfInfo)getObject(index);
    }
    public SecuProfInfo get(Object key)
    {
        return(SecuProfInfo)getObject(key);
    }
    public void set(int index, SecuProfInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SecuProfInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SecuProfInfo item)
    {
        return super.indexOf(item);
    }
}