package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProfDpTreeCollection extends AbstractObjectCollection 
{
    public ProfDpTreeCollection()
    {
        super(ProfDpTreeInfo.class);
    }
    public boolean add(ProfDpTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProfDpTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProfDpTreeInfo item)
    {
        return removeObject(item);
    }
    public ProfDpTreeInfo get(int index)
    {
        return(ProfDpTreeInfo)getObject(index);
    }
    public ProfDpTreeInfo get(Object key)
    {
        return(ProfDpTreeInfo)getObject(key);
    }
    public void set(int index, ProfDpTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProfDpTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProfDpTreeInfo item)
    {
        return super.indexOf(item);
    }
}