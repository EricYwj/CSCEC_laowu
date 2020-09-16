package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ImmiEcEntryCollection extends AbstractObjectCollection 
{
    public ImmiEcEntryCollection()
    {
        super(ImmiEcEntryInfo.class);
    }
    public boolean add(ImmiEcEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ImmiEcEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ImmiEcEntryInfo item)
    {
        return removeObject(item);
    }
    public ImmiEcEntryInfo get(int index)
    {
        return(ImmiEcEntryInfo)getObject(index);
    }
    public ImmiEcEntryInfo get(Object key)
    {
        return(ImmiEcEntryInfo)getObject(key);
    }
    public void set(int index, ImmiEcEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ImmiEcEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ImmiEcEntryInfo item)
    {
        return super.indexOf(item);
    }
}