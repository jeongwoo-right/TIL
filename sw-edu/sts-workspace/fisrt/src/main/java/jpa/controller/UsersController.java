package jpa.controller;

import jpa.entity.Users;
import jpa.repository.UsersRepository;
import jpa.service.UsersService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Component // new UserControllers() 역할만 수행

@Controller 				// new UserControllers() + 요청받아 처리하는 능력 위임
public class UsersController {
	@Autowired 				// jpa와 jpa 하위 패키지 모두 찾아서, Controller한테 주겠다?
	UsersService service;
	
	@RequestMapping("/jpainput")
	@ResponseBody
	public String input() {
		// 요청 - 처리 필요 일 객체 선택 (UsersRepository)
		service.input();		// "이자바" save
		return "jpa 이용하여 members 테이블에 data 저장 완료";
	}	
	
	@RequestMapping("/output")
	public Optional<Users> output(@RequestParam("id") long id) {
		return service.output(id);
	}
	
}

// http://127.0.0.1:8080/jpainput?username = 이자바

