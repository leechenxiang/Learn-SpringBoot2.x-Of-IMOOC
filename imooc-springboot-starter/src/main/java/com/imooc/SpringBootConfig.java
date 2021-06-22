package com.imooc;

import com.imooc.pojo.Stu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 为了说明当前类为配置类，加上这个注解以后，会被容器扫描到
/**
 * @Bean
 * @Controller
 * @Service
 * @Repository
 * @Component
 * 这些组件注解也都能使用，根据场景以及类的业务去使用和定义即可
 */
public class SpringBootConfig {

    @Bean
    public Stu stu() {
        return new Stu("jack", 18);
    }
}
