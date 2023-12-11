package com.commerce.back.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .components(new Components())
                .info(
                        new Info()
                                .title("2Commerce API List")
                                .description("이커머스 시스템 API 목록")
                                .version("v.0.0.1")
                );
    }
}
