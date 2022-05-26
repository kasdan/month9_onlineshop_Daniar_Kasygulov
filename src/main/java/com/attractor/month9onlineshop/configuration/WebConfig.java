package com.attractor.month9onlineshop.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@EnableWebMvc
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final FileStoreConfiguration fileStoreConfiguration;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:static/scripts/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:static/css/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations(String.format("file:%s/", fileStoreConfiguration.getPath()));
    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(localeChangeInterceptor());
//    }
//    private LocaleChangeInterceptor localeChangeInterceptor(){
//        var loc = new LocaleChangeInterceptor();
//        loc.setParamName("lang");
//        return loc;
//    }
//    @Bean
//    public LocaleResolver localeResolver() {
//        return new SessionLocaleResolver();
//    }
}
