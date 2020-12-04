package com.kevin.demo.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;


/**
 * @author kevin
 *
 */
@OpenAPIDefinition(
		// openapi定义描述
        info = @Info(
                title = "${spring.application.name}",
                version = "1.0.0",
                description = "OpenApi3.0",
                license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")
        		),
        // 请求服务地址配置，可以按不同的环境配置		
        servers = {
        		@Server(
		        		url = "http://localhost:8181",
		        		description = "本地地址"
		        		),
        		@Server(
		        		url = "http://dev1-api.kevin.com",
		        		description = "dev1环境地址"
		        		),
        		@Server(
                		url = "http://test1-api.kevin.com",
                		description = "test1环境地址"
                		),
        		@Server(
                		url = "http://api.kevin.com",
                		description = "生产环境地址"
                		)
        },
        // 这个tags可以用来定义一些公共参数说明，比如：token或者其他自定义key
        tags = {
        		@Tag(name = "Header：" + HttpHeaders.AUTHORIZATION, description = "登录之后获取的JWT Token，类型是bearer"),
        		@Tag(name = "Header：Accept-Language", description = "国际化语言：zh-CN（中文），en-US（英文）")
        }
)
// 安全配置：JWT Token。也可以配置其他类型的鉴权，比如：basic
@SecurityScheme(
	    name = HttpHeaders.AUTHORIZATION,
	    type = SecuritySchemeType.HTTP,
	    bearerFormat = "JWT",
	    scheme = "bearer"
	)
@Configuration
public class OpenApiConfig {
	
	// 分组配置：Books
	@Bean
	public GroupedOpenApi bookOpenApi() {
		String packagesToscan[] = {"com.kevin.demo.book"};
		return GroupedOpenApi.builder().group("Books").packagesToScan(packagesToscan)
				.build();
	}
	// 分组配置：Stores
	@Bean
	public GroupedOpenApi storeOpenApi() {
		String packagesToscan[] = {"com.kevin.demo.store"};
		return GroupedOpenApi.builder().group("Stores").packagesToScan(packagesToscan)
				.build();
	}
}
