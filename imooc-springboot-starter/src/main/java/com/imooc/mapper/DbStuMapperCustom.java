package com.imooc.mapper;

import com.imooc.my.mapper.MyMapper;
import com.imooc.pojo.DbStu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbStuMapperCustom {

    public List<DbStu> getStuById(String sid);

}