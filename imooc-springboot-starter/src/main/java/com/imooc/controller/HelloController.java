package com.imooc.controller;

import com.imooc.pojo.MyConfig;
import com.imooc.pojo.Stu;
import com.imooc.pojo.Student;
import com.imooc.utils.JSONResult;
import com.imooc.utils.MyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

//@Controller
@RestController
@Slf4j
public class HelloController {

//    @RequestMapping("hello")
//    @ResponseBody
    @GetMapping("hello")
//    @PostMapping("hello")
//    @DeleteMapping
//    @PutMapping
    public String hello() {
        return "Hello IMOOC~~";
    }


    @Autowired
    private Stu stu;

    @GetMapping("getStu")
    public Object getStu() {
        return stu;
    }

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private MyAsyncTask myAsyncTask;

    @GetMapping("getMyConfig")
    public Object getMyConfig() {
        myAsyncTask.publishMsg();
        log.info("这是跳过异步任务的执行");
        return myConfig;
    }


    @Value("${self.custom.config.sdkSecrect}")
    private String sdkSecrect;
    @Value("${self.custom.config.host}")
    private String host;
    @Value("${self.custom.config.port}")
    private String port;
    @Value("${app.name.xxx.yyy.zzz}")
    private String xyz;

    @GetMapping("getYmlCustomConfig")
    public Object getYmlCustomConfig() {
        return sdkSecrect + ";\t" + host+":"+ port + ";\t" + xyz;
    }


    @GetMapping("getStudent")
    public JSONResult getStudent() {

        Student stu = new Student();
        stu.setName("imooc");
        stu.setAge(18);

//        System.out.println(stu.toString());

        Student stu2 = new Student("风间影月", 20);

        log.debug(stu.toString());
        log.info(stu.toString());
        log.warn(stu.toString());
        log.error(stu.toString());

//        return JSONResult.errorMsg("调用接口错误");
        return JSONResult.ok(stu);
    }

    @PostMapping("upload")
    public String upload(MultipartFile file) throws Exception {

        file.transferTo(new File("/temp/" + file.getOriginalFilename()));

        return "上传成功";
    }

}
