package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjectWorkCollection extends AbstractObjectCollection 
{
    public ProjectWorkCollection()
    {
        super(ProjectWorkInfo.class);
    }
    public boolean add(ProjectWorkInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjectWorkCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjectWorkInfo item)
    {
        return removeObject(item);
    }
    public ProjectWorkInfo get(int index)
    {
        return(ProjectWorkInfo)getObject(index);
    }
    public ProjectWorkInfo get(Object key)
    {
        return(ProjectWorkInfo)getObject(key);
    }
    public void set(int index, ProjectWorkInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjectWorkInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjectWorkInfo item)
    {
        return super.indexOf(item);
    }
}