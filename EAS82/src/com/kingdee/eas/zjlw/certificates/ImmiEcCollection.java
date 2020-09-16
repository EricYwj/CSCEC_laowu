package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ImmiEcCollection extends AbstractObjectCollection 
{
    public ImmiEcCollection()
    {
        super(ImmiEcInfo.class);
    }
    public boolean add(ImmiEcInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ImmiEcCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ImmiEcInfo item)
    {
        return removeObject(item);
    }
    public ImmiEcInfo get(int index)
    {
        return(ImmiEcInfo)getObject(index);
    }
    public ImmiEcInfo get(Object key)
    {
        return(ImmiEcInfo)getObject(key);
    }
    public void set(int index, ImmiEcInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ImmiEcInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ImmiEcInfo item)
    {
        return super.indexOf(item);
    }
}