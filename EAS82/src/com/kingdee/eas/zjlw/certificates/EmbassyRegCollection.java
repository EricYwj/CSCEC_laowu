package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EmbassyRegCollection extends AbstractObjectCollection 
{
    public EmbassyRegCollection()
    {
        super(EmbassyRegInfo.class);
    }
    public boolean add(EmbassyRegInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EmbassyRegCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EmbassyRegInfo item)
    {
        return removeObject(item);
    }
    public EmbassyRegInfo get(int index)
    {
        return(EmbassyRegInfo)getObject(index);
    }
    public EmbassyRegInfo get(Object key)
    {
        return(EmbassyRegInfo)getObject(key);
    }
    public void set(int index, EmbassyRegInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EmbassyRegInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EmbassyRegInfo item)
    {
        return super.indexOf(item);
    }
}