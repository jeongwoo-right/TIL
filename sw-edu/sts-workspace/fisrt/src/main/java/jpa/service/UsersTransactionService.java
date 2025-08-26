//package jpa.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import jakarta.transaction.Transactional;
//import jpa.entity.Users;
//import jpa.repository.UsersRepository;
//
//@Service 					// new UserService() <- like @Component
//public class UsersTransactionService {
//	@Autowired
//	UsersRepository userrepo;
//	
//	
//	// Controller의 input 메서드 내에서 요청되어 수행
//	public void input() {
//		Users user1 = new Users();
//		user1.setUsername("이자바");
////		user1.setAge(20);		
////		user1.setId(1); 				// id 자동으로 만들어지고 있음
//		userrepo.save(user1); 			// insert into members values(null, "이자바"); // age는 @Transient 붙어있으므로 // user1이 members 테이블에 자동 저장
//		
//		Users user2 = new Users();
//		user2.setUsername("김자바로 변경");
//		user2.setId(1);
//		userrepo.save(user2); 			// pk값을 가지고 있는 row가 이미 있으므로, insert가 아니라 update members ~~
//		
////		userrepo.delete(user2);
//	}
//	
//	
//	// 조회
//	public Users output(long id) {						// return type: Users
//		Optional<Users> u = userrepo.findById(id);		/*id 컬럼 값이 매개변수 일치하는 데이터만 조회 (sql 변경은 jpa가)*/
//		if (u.isPresent()) {							// u(user)가 return됐니?
//			System.out.println(u.get());
//			return u.get();
//		}
//		
//		return null;
//	}
//	
//	@Transactional		// commit / rollback
//	// 초기 5개 회원 가입 메소드(day2.pdf)
//	public int initialInput() {
//		Users user1 = new Users();
//		user1.setUsername("김정우");
//		userrepo.save(user1);		// insert, update, (변경된게 없으면 아무것도 x)
//		
//		System.out.println(userrepo.findById(user1.getId()).orElseThrow());
//		
//		
//		Users user2 = new Users();
//		user2.setUsername("배나연");
//		userrepo.save(user2);
//		
//		Users user3 = new Users();
//		user3.setUsername("김예랑");
//		userrepo.save(user3);
//		
//		Users user4 = new Users();
//		user4.setUsername("이온유");
//		userrepo.save(user4);
//		
//		Users user5 = new Users();
//		user5.setUsername("송승원");
//		userrepo.save(user5);
//		
//		return (int) userrepo.count();		// 기본적으로 long타입 반환
//	}
//	
//	// 이자바 0개 / 1개 / 2개 이상 조회 메소드
//	// username 검색
//	// 모든 회원들 조회 메소드
//	public List<Users> getUsers(String name) {
//		if (name.isBlank()) {
//			return userrepo.findAll();
//		}
//		
//		else {
//			// 자동 sql 
//			// select * from members 
//			// where username like "%길동%" 		--> findByUsernameLike
//			// order by username 				--> OrderByDesc
//			// limt 0, 3 						--> First5
//			return userrepo.findByUsernameLikeOrderByUsernameDesc("%" + name + "%");
//			
//		}
//	}
//	
//	// 모든 회원들 조회 - 페이지별 조회 메소드
//	public Page<Users> getUsersPage(Pageable pageable) { // 한 페이지당 보여줄 회원 수, 몇 페이지 정보 필요
//		return userrepo.findAll(pageable);
//	}
//}
//
//
