package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EmploBurCollection extends AbstractObjectCollection 
{
    public EmploBurCollection()
    {
        super(EmploBurInfo.class);
    }
    public boolean add(EmploBurInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EmploBurCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EmploBurInfo item)
    {
        return removeObject(item);
    }
    public EmploBurInfo get(int index)
    {
        return(EmploBurInfo)getObject(index);
    }
    public EmploBurInfo get(Object key)
    {
        return(EmploBurInfo)getObject(key);
    }
    public void set(int index, EmploBurInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EmploBurInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EmploBurInfo item)
    {
        return super.indexOf(item);
    }
}