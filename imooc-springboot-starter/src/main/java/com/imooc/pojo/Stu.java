package com.imooc.pojo;

public class Stu {
    public String name;
    public Integer age;

    public Stu(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


//<bean id="stu">
//    <property name="name" value="jack"/>
//    <property name="age" value="18"/>
//</bean>
