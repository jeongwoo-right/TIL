package jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.entity.Users;
import jpa.repository.UsersRepository;

@Service 					// new UserService() <- like @Component
public class UsersService {
	@Autowired
	UsersRepository userrepo;
	
	public void input() {
		Users user1 = new Users();
		user1.setUsername("김자바로 변경");
		user1.setAge(20);		
		user1.setId(1); 		// id 자동으로 만들어지고 있음
		userrepo.save(user1); 	// insert into members values(null, "이자바"); // age는 @Transient 붙어있으므로
		
		Users user2 = new Users();
		user2.setUsername("김자바로 변경");
		user2.setId(1);
		userrepo.save(user2);
		// update members ~~
		
		userrepo.delete(user2);
	}
	
	public Users output(long id) {
		Optional<Users> u = userrepo.findById(id);
		return u;
	}
	
}



