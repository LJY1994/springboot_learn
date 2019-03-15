package cn.sf.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
  * Description:
  * Company:
  * @Author: 01384657
  * Date: 2019/3/12 16:34
  */

@SpringBootApplication
@MapperScan("cn.sf.springbootdemo.dao")
public class SpringbootMysqlMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMysqlMybatisApplication.class, args);
    }

}
