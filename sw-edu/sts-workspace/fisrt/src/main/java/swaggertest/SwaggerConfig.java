package swaggertest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

//전체적인 api 문서 설정 담당
@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
					.components(new Components())
					.info(apiInfo());
	}
	
	
	private Info apiInfo() {
		return new Info()
					.title("Swagger UI - API의 제목 ") // API의 제목
					.description("swaggertest  패키지의 컨트롤러들 명세서입니다.") // API에 대한 설명
					.version("1.0.0"); // API의 버전
	}
}
