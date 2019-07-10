package com.yk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yk.interceptor.KaiInterceptor;

@SpringBootApplication
@MapperScan(basePackages={"com.yk.dao","com.yk.shopping.dao"})
public class SpringbootDemoApplication extends SpringBootServletInitializer implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//注册拦截器到Spring MVC机制
		InterceptorRegistration ry = registry.addInterceptor(new KaiInterceptor());
		ry.addPathPatterns("/first/*");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringbootDemoApplication.class);
	}

}
