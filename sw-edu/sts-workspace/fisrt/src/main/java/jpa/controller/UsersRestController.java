package jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jpa.entity.Users;
import jpa.service.UsersRestService;
import jpa.service.UsersService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="http://localhost:3000")
// nodejs - 스프링프레임워크(tomcat)
public class UsersRestController {
	@Autowired
	UsersRestService service;
	
	@PostMapping
	public Users input(Users users) {
		return service.input(users);
	}
	
	@GetMapping("/{id}")
	public String output(@PathVariable("id") long id) {
		// Users 정보 출력
		Users u = service.output(id);
		if(u != null)
			return u.toString();
		return "찾는 멤버가 없어요";
	}
	
	@GetMapping
	public List<Users> getUsers
	(@RequestParam(name="name", required = false, defaultValue = "")
	String name){
		List<Users> list = service.getUsers(name);
		return list;
	}
	
	@RequestMapping("/userspage")
	public List<Users> getUsersPage(Pageable pageable){
		Page<Users> page = service.getUsersPage(pageable);
		List<Users> list = page.getContent();
		return list;
	}
}
