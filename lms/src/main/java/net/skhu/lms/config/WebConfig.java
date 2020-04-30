package net.skhu.lms.config;

import net.skhu.lms.interceptor.LoginInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/test"); // 인터셉터를 적용할 url을 적어주지 않으면 오류 발생
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
