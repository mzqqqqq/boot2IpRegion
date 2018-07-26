package com.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>文件名称: Swagger2Config</p>
 * <p>文件描述: 系统配置对象</p>
 * <p>版权所有: 版权所有(C)2017</p>
 * <p>公 司: 深圳竹云科技有限公司</p>
 * <p>内容摘要: 配置外部接口swagger信息</p>
 * <p>其他说明: 无</p>
 * <p>完成日期: 2017/12/28</p>
 * @author zhangzhi
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 创建API应用 apiInfo() 增加API相关信息 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * 仅开放business.dispatchCentre目录下的接口，如果需要测试接口，请自行开放但不要提交
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com")).paths(PathSelectors.any()).build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中） 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Iview测试接口")
                .description("Iview测试接口")
                .termsOfServiceUrl("http://xxx.xxx.xxx.xxx:8080/epass-api/swagger.html").contact(new Contact("Iview测试接口","",""))
                .version("0.0.0.1").build();
    }
}