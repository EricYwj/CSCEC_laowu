package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExLivepermitCollection extends AbstractObjectCollection 
{
    public ExLivepermitCollection()
    {
        super(ExLivepermitInfo.class);
    }
    public boolean add(ExLivepermitInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExLivepermitCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExLivepermitInfo item)
    {
        return removeObject(item);
    }
    public ExLivepermitInfo get(int index)
    {
        return(ExLivepermitInfo)getObject(index);
    }
    public ExLivepermitInfo get(Object key)
    {
        return(ExLivepermitInfo)getObject(key);
    }
    public void set(int index, ExLivepermitInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExLivepermitInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExLivepermitInfo item)
    {
        return super.indexOf(item);
    }
}