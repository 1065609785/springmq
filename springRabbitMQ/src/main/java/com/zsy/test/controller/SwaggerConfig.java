
 /**
 * Project Name:springRabbitMQ
 * File Name:SwaggerConfig.java
 * Package Name:com.zsy.test
 * Date:2018年1月2日上午10:52:50
 * Copyright (c) 2018, zhaoshouyun All Rights Reserved.
 *
*/
/**
 * Project Name:springRabbitMQ
 * File Name:SwaggerConfig.java
 * Package Name:com.zsy.test
 * Date:2018年1月2日上午10:52:50
 * Copyright (c) 2018, zhaoshouyun All Rights Reserved.
 *
 */

package com.zsy.test.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName: SwaggerConfig 
 * Function: TODO ADD FUNCTION. 
 * date: 2018年1月2日 上午10:52:50 
 * @author zhaoshouyun
 * @version 
 * @since JDK 1.7
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.zsy.test.swaggerController";
	    public static final String VERSION = "1.0.0";

	    ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Swagger API")
	                .description("This is to show api description")
	                .license("Apache 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	                .termsOfServiceUrl("")
	                .version(VERSION)
	                .contact(new Contact("","", "1065609785@qq.com"))
	                .build();
	    }

	    @Bean
	    public Docket customImplementation(){
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
	                .build()
	                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
	                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
	                .apiInfo(apiInfo());
	    }
}

