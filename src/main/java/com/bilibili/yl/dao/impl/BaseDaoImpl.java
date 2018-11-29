package com.bilibili.yl.dao.impl;

import com.bilibili.yl.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

    private SessionFactory sessionFactory;

    public BaseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T find(Class<T> clazz, ID id) {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public void create(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void save(T t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    public List list(String hql, int firstResult, int maxResults, Map<String, Object> map) {
        Query query = getQuery(hql, map);
        return query.setFirstResult(firstResult).setMaxResults(maxResults).list();
    }

    @Override
    public Query getQuery(String hql, Map<String, Object> map) {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        if (map != null) {
            Set<String> keySet = map.keySet();
            for (String string : keySet) {
                Object obj = map.get(string);
                //这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (obj instanceof Collection<?>) {
                    query.setParameterList(string, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    query.setParameterList(string, (Object[]) obj);
                } else {
                    query.setParameter(string, obj);
                }
            }
        }
        return query;
    }

    @Override
    public List list(String hql, Map<String, Object> map) {
        Query query = getQuery(hql, map);
        return query.list();
    }

    @Override
    public Long getTotalCount(String hql, Map<String, Object> map) {
        Query query = getQuery(hql, map);
        Object obj = query.uniqueResult();
        return (Long) obj;
    }
}
