package cn.sf.springboot_mysql_mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description:
 * Company:
 *
 * @Author: 01384657
 * Date: 2019/3/14 16:04
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createResApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指定了 Swagger 的扫描包名
                .apis(RequestHandlerSelectors.basePackage("cn.sf.springboot_mysql_mybatis"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("springboot 中使用Swagger2 构建API文档")
                .description("1")
                .termsOfServiceUrl("127.0.0.1")
                .contact("jy")
                .version("0.1")
                .build();
    }
}
