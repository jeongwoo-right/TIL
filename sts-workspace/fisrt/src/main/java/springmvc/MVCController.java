package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCController {
	@RequestMapping("/start")
	public String start() {
		return "start";
	}
	
}

// @Controller + @RequestMapping("/start")
/* 1. Spring boot app 실행 
 * 2. tomcat 서버 내장 (port-8080) - tomcat web 서버 시작
 * 3. http://127.0.0.1:8080/start - 웹브라우저 주소표시줄
 * 4. MVCController - start 호출
 * 5. CONTROLLER - MODEL 생성(선택적), VIEW 선택 // VIEW - start.jsp
 * 6. start.jsp 파일 정의, .jsp 뷰 설정
 * */


/*
1. src/main/resources/application.properties 파일 - 부가적인 설정
2. build.gradle 파일 
 */
