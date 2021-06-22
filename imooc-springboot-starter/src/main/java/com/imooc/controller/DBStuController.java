package com.imooc.controller;

import com.imooc.pojo.DbStu;
import com.imooc.pojo.bo.DbStuBO;
import com.imooc.service.StuService;
import com.imooc.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("dbstu")
@Slf4j
public class DBStuController {

    @Autowired
    private StuService stuService;

    @GetMapping("{stuId}/get")
    public String getStu(@PathVariable("stuId") String stuId,
                         @RequestParam Integer id,
                         @RequestParam String name) {

        /**
         * @RequestParam: 用于获得url中的请求参数，如果参数变量名保持一致，该注解可以省略
         */

        log.info("stuId=" + stuId);
        log.info("id=" + id);
        log.info("name=" + name);

        return "查询Stu";
    }

    @GetMapping("/get")
    public JSONResult getStu(String stuId) {
        DbStu stu = stuService.queryById(stuId);

        List<DbStu> list = stuService.queryByCondition("abc", 1);

        DbStu stu2 = stuService.queryByIdCustom(stuId);

        return JSONResult.ok(stu2);
    }

    @GetMapping("/pagedList")
    public JSONResult pagedList(Integer page, Integer pageSize) {

        List<DbStu> list = stuService.queryByCondition("abc",
                                                        1,
                                                        page,
                                                        pageSize);

        return JSONResult.ok(list);
    }

    @GetMapping("create")
    public JSONResult createStu() {

        String sid = UUID.randomUUID().toString();

        DbStu stu = new DbStu();

        stu.setId(sid);
        stu.setName("慕课网");
        stu.setSex(1);

        stuService.saveStu(stu);

        return JSONResult.ok();
    }

    @PostMapping("create2")
    public JSONResult createStu2(@Valid @RequestBody DbStuBO stuBO,
                                 BindingResult result) {
        // 判断BindingResult是否有错误，错误信息会包含在里面，如果有则直接return
        if (result.hasErrors()) {
            Map<String, String> map = getErrors(result);
            return JSONResult.errorMap(map);
        }

        String sid = UUID.randomUUID().toString();

        DbStu stu = new DbStu();
        BeanUtils.copyProperties(stuBO, stu);
        stu.setId(sid);

        stuService.saveStu(stu);

        return JSONResult.ok();
    }

    public Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList) {
            String field = error.getField();
            String msg = error.getDefaultMessage();
            map.put(field, msg);
        }
        return map;
    }

//    @PutMapping("update")
    @GetMapping("update")
    public JSONResult updateStu() {

        DbStu stu = new DbStu();
        stu.setId("1111");
        stu.setName("已经修改的name");
        stu.setSex(2);

        stuService.updateStu(stu);

        return JSONResult.ok();
    }

//    @DeleteMapping("delete")
    @GetMapping("delete")
    public String deleteStu() {

        DbStu stu = new DbStu();
//        stu.setId("r32re132");
        stu.setSex(2);
        stu.setName("abc");

        stuService.deleteStu(stu);

        return "删除Stu";
    }


    @GetMapping("testTrans")
    public JSONResult testTrans() {
        stuService.testTrans();
        return JSONResult.ok();
    }
}
