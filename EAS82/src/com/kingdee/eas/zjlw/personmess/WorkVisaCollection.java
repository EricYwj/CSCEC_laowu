package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkVisaCollection extends AbstractObjectCollection 
{
    public WorkVisaCollection()
    {
        super(WorkVisaInfo.class);
    }
    public boolean add(WorkVisaInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkVisaCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkVisaInfo item)
    {
        return removeObject(item);
    }
    public WorkVisaInfo get(int index)
    {
        return(WorkVisaInfo)getObject(index);
    }
    public WorkVisaInfo get(Object key)
    {
        return(WorkVisaInfo)getObject(key);
    }
    public void set(int index, WorkVisaInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkVisaInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkVisaInfo item)
    {
        return super.indexOf(item);
    }
}