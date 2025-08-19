package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jpa.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	// Users = member 테이블에 save, delete, findByxxxx 미리 제공
	// 상속 메소드 = 어느 entity 적용. pk 컬럼 long 타입
	// + 메소드 정의 = 이름 규칙 = jpa sql 구현
	// findByUsername(String name); ==> select * from members where username = name변수
	
	
}
