package myconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 스프링부트에 객체 생성 + ioc 주입
public class MyPathConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file://c:/upload/");
	}
	
	// c:/upload/a.jpg 폴더 - http://127.0.0.1:8080/upload
	
	
}
