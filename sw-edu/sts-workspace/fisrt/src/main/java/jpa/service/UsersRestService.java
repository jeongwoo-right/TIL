package jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import jpa.entity.Users;
import jpa.repository.UsersRepository;

@Service //new UserService
public class UsersRestService {
	
	@Autowired
	UsersRepository userrepo;
	
	public Users input(Users user1) { //ioc
		userrepo.save(user1);
		return userrepo.findById(user1.getId()).get();
	}
	
	// 조회
	public Users output(long id) {
		Optional<Users> u = userrepo.findById(id); // id 컬럼값이 매개변수 감지하는 데이터조회 sql 변경 jpa
		if(u.isPresent()) {
			System.out.println(u.get());
			return u.get();
		}
		return null;
	}
	
	// 이자바 0개, 1개, 2개 이상 조회 메소드
	// username 검색
	// 모든 회원들 조회 메소드
	public List<Users> getUsers(String name){
		if(name.isBlank()) {
			return userrepo.findAll();
		}
		else {
			return userrepo.findFirst3ByUsernameLikeOrderByUsernameDesc("%" + name + "%");
			// 자동 sql
			/* select * members
			where username like '%길동%'
			order by id desc
			limit 0, 3 ---> db 종속 %
			*/
		}
	}
	
	// 모든 회원들 조회 - 페이지별조회 메소드
	public Page<Users> getUsersPage(Pageable pageable) {// 한페이지당 보여줄 회원수, 몇페이지
		return userrepo.findAll(pageable);
	}
}
