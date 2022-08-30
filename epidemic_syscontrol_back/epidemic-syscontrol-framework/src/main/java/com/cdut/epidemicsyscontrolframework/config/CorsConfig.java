package com.cdut.epidemicsyscontrolframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//允许跨域
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    private static final long MAX_AGE = 24 * 60 * 60;

    /**
     * 开启springboot跨域 还要额外开启spring security跨域
     * 因为springboot允许请求跨域后还要经过security的过滤器链 如果security检查到没有配置还是不能跨域的
     * {@link ResourcesConfig#addCorsMappings(CorsRegistry)}
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","DELETE","PUT")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}

