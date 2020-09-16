package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjectOrgCollection extends AbstractObjectCollection 
{
    public ProjectOrgCollection()
    {
        super(ProjectOrgInfo.class);
    }
    public boolean add(ProjectOrgInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjectOrgCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjectOrgInfo item)
    {
        return removeObject(item);
    }
    public ProjectOrgInfo get(int index)
    {
        return(ProjectOrgInfo)getObject(index);
    }
    public ProjectOrgInfo get(Object key)
    {
        return(ProjectOrgInfo)getObject(key);
    }
    public void set(int index, ProjectOrgInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjectOrgInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjectOrgInfo item)
    {
        return super.indexOf(item);
    }
}