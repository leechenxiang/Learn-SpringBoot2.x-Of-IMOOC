package com.imooc.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component      // 把本配置放入到springboot容器中，使其被扫描到
@ConfigurationProperties(prefix = "user")
@PropertySource(value = "classpath:MyConfig.properties", encoding = "utf-8")
public class MyConfig {
    public String username;
    public Integer age;
    public String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
