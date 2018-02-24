package com.tzg.xhd.tbooking.common;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
    /**
     * 插入单条数据
     * null的属性不会保存，会使用数据库默认值
     * @param model
     */
    void save(T model);

    /**
     * 插入多条数据
     * 该接口要求实体包含id属性并且必须为自增列
     * @param models
     */
    void save(List<T> models);//批量持久化

    /**
     * 通过主键删除数据
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 通过其他字段删除数据
     * @param model
     */
    void deleteByModel(T model);

    /**
     * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     * eg：ids -> “1,2,3,4”
     * @param ids
     */
    void deleteByIds(String ids);

    /**
     * 根据主键更新属性不为null的值
     * @param model
     */
    void update(T model);

    /**
     * 通过主键查找数据
     * @param id
     * @return
     */
    T findById(Integer id);

    /**
     * 通过实体类中其他字段查找数据
     * @param model
     * @return
     */
    List<T> findByModel(T model);

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个ID查找
     * eg：ids -> “1,2,3,4”
     * @param ids
     * @return
     */
    List<T> findByIds(String ids);

    /**
     * 根据条件查找
     * @param condition
     * @return
     */
    List<T> findByCondition(Condition condition);

    /**
     * select *
     * @return
     */
    List<T> findAll();
}
