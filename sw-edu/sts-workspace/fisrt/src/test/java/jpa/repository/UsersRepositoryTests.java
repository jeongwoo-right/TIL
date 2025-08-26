package jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.first.FisrtApplication;

import jpa.entity.Users;



@SpringBootTest(classes=FisrtApplication.class)
public class UsersRepositoryTests {
	@Autowired
	UsersRepository usersRepository;
	
	
	@BeforeEach
	public void doBefore() {
		// 4
		usersRepository.save(Users.builder().username("배나블리").age(27).build());
		usersRepository.save(Users.builder().username("배나boolean").age(27).build());
		usersRepository.save(Users.builder().username("배나bully").age(27).build());
		usersRepository.save(Users.builder().username("배나푸바오").age(27).build());
	}
	
	@AfterEach
	public void doAfter() {
		
	}

	@Test
	@DisplayName("test1")
	public void test1() {
		assertThat(usersRepository.count()).isEqualTo(4);
		
		assertThat(usersRepository.findFirst3ByUsernameLikeOrderByUsernameDesc("%배나%").size()).isEqualTo(3);
		
		assertThat(usersRepository.findByUsername("배나블리").getId()).isEqualTo(2);
	}

	@RepeatedTest(value = 3, name="{displayName} 중 {currentRepetition} of {totalRepetitions}")
	@DisplayName("test2")
	public void test2() {
	
	}
	
	@Test
	@DisplayName("test3")
	@Disabled("잠시 테스트 중단")
	public void test3() {
		
	}
	
}
