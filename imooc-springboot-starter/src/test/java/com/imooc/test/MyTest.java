package com.imooc.test;

import com.imooc.pojo.DbStu;
import com.imooc.service.StuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest // 表示当前会被springboot加载，加载为测试类
public class MyTest {

    @Autowired
    private StuService stuService;

    @Test
    public void testSaveStu() {
        DbStu stu = new DbStu();
        stu.setId(UUID.randomUUID().toString());
        stu.setName("test");
        stu.setSex(1);
        stuService.saveStu(stu);
//        int a = 1 / 0;
    }

}
