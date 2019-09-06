package com.jtzh.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig implements WebMvcConfigurer {
 
   
   
	@Override
	public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("*")
            .allowCredentials(true)
            .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS","OPTION")
            .maxAge(3600);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration  interceptorRegistration  =registry.addInterceptor(new LoginInterceptor());
		interceptorRegistration.addPathPatterns("/**");
		interceptorRegistration.excludePathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/file/**","/templates/**","/static/**").addResourceLocations("file:D:/ynw/",ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/",ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}


   
}
