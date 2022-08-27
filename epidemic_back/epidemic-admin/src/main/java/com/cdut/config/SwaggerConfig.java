package com.cdut.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: cxt
 * @time: 2021/1/22
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi springOpenAPI(){
        return GroupedOpenApi.builder()
                .group("hoshino")
                .pathsToMatch("/**")
                .packagesToScan("com.hoshino")
                .build();
//        return new OpenAPI()
//                .info(new Info().title("SpringShop API")
//                        .description("Spring shop sample application")
//                        .version("v0.0.1")
//                        .license(new License().name("Apache 2.0")
//                        .url("http://springdoc.org")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("SpringShop Wiki Documentation")
//                        .url("https://springshop.wiki.github.org/docs"));
    }
}
