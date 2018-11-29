package com.bilibili.yl.dao;

import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T, ID extends Serializable> {
    /**
     * 根据id查询实体
     *
     * @param clazz 实体对象反射.class
     * @param id    主键id
     * @return T 返回一个实体
     */
    T find(Class<T> clazz, ID id);

    /**
     * 添加实体
     *
     * @param t 实体对象
     */
    void create(T t);

    /**
     * 修改实体
     *
     * @param t 实体对象
     */
    void save(T t);

    /**
     * 删除实体
     *
     * @param t 实体对象
     */
    void delete(T t);

    /**
     * 查询某页实体
     *
     * @param hql         查询语句
     * @param firstResult 从第几条开始，注意索引从0开始
     * @param maxResults  最多返回的数据条数
     * @param map         参数键值对
     * @return 返回一个集合
     */
    List list(String hql, int firstResult, int maxResults, Map<String, Object> map);

    /**
     * 带参数的查询
     *
     * @param hql 查询语句
     * @param map 参数键值对
     * @return Query 返回一个Query，.list()方法可以拿到集合
     * */
    Query getQuery(String hql, Map<String, Object> map);

    /**
     * 查询实体
     *
     * @param hql 查询语句
     * @param map 参数键值对
     * @return List 返回一个集合
     */
    List list(String hql, Map<String, Object> map);

    /**
     * 获取记录总数
     *
     * @param hql 查询语句
     * @param map 参数键值对
     * @return 返回类型
     */
    Long getTotalCount(String hql, Map<String, Object> map);
}
