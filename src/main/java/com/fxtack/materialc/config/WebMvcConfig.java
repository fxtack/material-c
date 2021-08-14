package com.fxtack.materialc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring boot 配置类配置 spring mvc
 *
 * @author fxtack
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/main/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/main/file/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/")
                .addResourceLocations("file:///" + System.getProperties().getProperty("user.home") + "/material/upload/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
