# Spring
## 스프링의 특징
- 자바 웹 + DB 연동 등 백엔드 개발이 가능한 framework
- Spring의 설정 간소화 (Spring보다 편하게 하려고 만들었다)

### 라이브러리
- 특정 언어로 작성한 프로그램 개발 시 빈번히 재사용되는 기능을 모듈화하여 제공되는 모듈 집합
- 프로그램 개발 시 개발자 목적에 맞게 쉽게 삽입하여 사용

### 프레임워크
- 미리 틀이 구성되어 개발자들이 제한된 프로그래밍 설계 규격에 맞추어 개발하는 방식
- "기본적으로 프레임워크에서 완성된 코드를 제공"받고 나머지 코드를 완성하여 개발
- 이 때 프레임워크에서 완성된 코드 사용 시에도 프레임워크에서 정한 규칙을 지키며 설계 개발하고 내가 작성한 개발자 코드와 연동
- 특히 "개발제어권이 프레임워크에 있다"는 점에 라이브러리와의 차이점

## Spring IoC, DI
### IoC
- Inversion Of Control (제어권의 역전)
- 외부에서 만들어진 객체를 받는다
- 외부: Spring

### DI
- Dependency Injection (의존성 주입)
- 결합도를 낮추자 
- 개발을 하다보면 유지보수, 추가수정되어야 할 것이 많음 -> 결합도가 낮아야 유지보수 추가수정에 용이
- XML이나 annotation을 이용해 의존성 주입
- A 클래스가 동작하기 위해 B 클래스가 필요하다면, A 클래스는 B 클래스에 의존한다.
- 문제점: A 클래스가 동작하기 위해 B 클래스 대신 C 클래스가 필요하다면, A 클래스는 B 클래스에 의존하는 코드 부분을 C 코드에 의존하는 코드로 수정해야 한다.
	- B 클래스와 A 클래스의 결합도가 높다.

- 클래스 간의 결합도 낮추는 방법 (ioc)
 	1. new 사용 X
	2. 객체 종류 다양 / 교체될 수 있다 - 인터페이스 구조
	
## MVC
- 웹 애플리케이션을 화면 부분(View), 요청 처리 부분(Controller), 로직 처리 부분(Model)으로 나누어 개발하는 개발 방법론
- Controller: 사용자의 요청 및 흐름 제어를 담당 (Client 요청 받아 분석)
- Model: 비즈니스 로직 처리
- View: 사용자에게 보여줄 화면 담당

## Spring MVC

```java
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
```
