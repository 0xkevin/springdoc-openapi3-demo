/**
 * 
 */
package com.kevin.demo.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;


/**
 * @author kevin
 *
 */
@OpenAPIDefinition(
        info = @Info(
                title = "${spring.application.name}",
                version = "1.0.0",
                description = "OpenApi3.0",
                license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")
        		),
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
        tags = {
        		@Tag(name = "Header：" + HttpHeaders.AUTHORIZATION, description = "登录之后获取的JWT Token，类型是bearer"),
        		@Tag(name = "Header：Accept-Language", description = "国际化语言：zh-CN（中文），en-US（英文）")
        }
)
@SecurityScheme(
	    name = HttpHeaders.AUTHORIZATION,
	    type = SecuritySchemeType.HTTP,
	    bearerFormat = "JWT",
	    scheme = "bearer"
	)
@Configuration
public class OpenApiConfig {

	@Bean
	public GroupedOpenApi bookOpenApi() {
		String packagesToscan[] = {"com.kevin.demo.book"};
		return GroupedOpenApi.builder().group("Books").packagesToScan(packagesToscan)
				.build();
	}
	
	@Bean
	public GroupedOpenApi storeOpenApi() {
		String packagesToscan[] = {"com.kevin.demo.store"};
		return GroupedOpenApi.builder().group("Stores").packagesToScan(packagesToscan)
				.build();
	}
}
