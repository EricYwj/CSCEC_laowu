package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ASCancelCollection extends AbstractObjectCollection 
{
    public ASCancelCollection()
    {
        super(ASCancelInfo.class);
    }
    public boolean add(ASCancelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ASCancelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ASCancelInfo item)
    {
        return removeObject(item);
    }
    public ASCancelInfo get(int index)
    {
        return(ASCancelInfo)getObject(index);
    }
    public ASCancelInfo get(Object key)
    {
        return(ASCancelInfo)getObject(key);
    }
    public void set(int index, ASCancelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ASCancelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ASCancelInfo item)
    {
        return super.indexOf(item);
    }
}