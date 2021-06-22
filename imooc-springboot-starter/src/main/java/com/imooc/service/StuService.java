package com.imooc.service;

import com.imooc.pojo.DbStu;

import java.util.List;

public interface StuService {

    /**
     * 新增stu到数据库
     * @param stu
     */
    public void saveStu(DbStu stu);

    /**
     * 根据主键查询对象信息
     * @param id
     */
    public DbStu queryById(String id);

    public DbStu queryByIdCustom(String id);

    /**
     * 根据条件查询stu的list结果集
     * @param name
     * @param sex
     * @return
     */
    public List<DbStu> queryByCondition(String name, Integer sex);

    /**
     * 根据条件查询，分页
     * @param name
     * @param sex
     * @param page: 第几页
     * @param pageSize: 每一页有多少条数据
     * @return
     */
    public List<DbStu> queryByCondition(String name,
                                        Integer sex,
                                        Integer page,
                                        Integer pageSize);

    /**
     * 修改stu到数据库
     * @param stu
     */
    public void updateStu(DbStu stu);

    /**
     * 根据条件删除stu
     * @param stu
     */
    public void deleteStu(DbStu stu);

    /**
     * 用于演示事务
     */
    public void testTrans();
}
