//package jpa.controller;
//
//import jpa.entity.Users;
//import jpa.repository.UsersRepository;
//import jpa.service.UsersService;
//import jpa.service.UsersTransactionService;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
////@Component // new UserControllers() 역할만 수행
//
//@Controller 				// new UserControllers() + 요청받아 처리하는 능력 위임
//public class UsersTransactionController {
//	@Autowired 				// jpa와 jpa 하위 패키지 모두 찾아서, Controller한테 주겠다?
//	UsersTransactionService service;
//	
//	
//	
//	@RequestMapping("/jpainput")
//	@ResponseBody
//	public String input() {
//		// 요청 - 처리 필요 일 객체 선택 (UsersRepository)
//		service.input();	// "이자바" save
//		return "jpa 이용하여 members 테이블에 data 저장 완료";
//	}	
//	
//	
//	
//	@RequestMapping("/output")
//	@ResponseBody			// @RequestMapping 메소드 리턴타입 스트링 - 요청했던 브라우저로 전달되는 결과값
//	public String output(@RequestParam("id") long id) {
//		// User 정보 출력
//		Users u = service.output(id);
//		if (u != null) {
//			return u.toString();
//		}	
//			
//		return "찾는 멤버가 없어요";
//	}
//	
//	
//	@RequestMapping("/transactionInput")
//	@ResponseBody			// @RequestMapping 메소드 리턴타입 스트링 - 요청했던 브라우저로 전달되는 결과값
//	public String initialInput() {
//		int count = service.initialInput();		// 5명 저장. 저장된 회원명수 리턴
//		return "members 테이블에 " + count + " 명의 회원 가입 완료";
//	}
//	
//	
//	@RequestMapping("/users")
//	@ResponseBody			// @RequestMapping 메소드 리턴타입 스트링 - 요청했던 브라우저로 전달되는 결과값
//	public List<Users> getUsers(@RequestParam(name = "name", required=false, defaultValue="") String name) {
//		List<Users> list = service.getUsers(name);
//		return list;
//	}
//	
//	
//	@RequestMapping("/userspage")
//	@ResponseBody			// @RequestMapping 메소드 리턴타입 스트링 - 요청했던 브라우저로 전달되는 결과값
//	public List<Users> getUsersPage(Pageable pageable) {
//		Page<Users> page = service.getUsersPage(pageable);
//		List<Users> list = page.getContent();
//		return list;
//	}
//	
//}
//
//// http://127.0.0.1:8080/jpainput
//// http://127.0.0.1:8080/output?id=1
//// http://127.0.0.1:8080/initialInput 실행 - 5명씩 저장
//// http://127.0.0.1:8080/users 실행 - 모든 회원 조회 출력
//// http://127.0.0.1:8080/users?name=길동 실행 - username 길동 포함하는 회원 조회 출력
//
//
