package jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import jpa.entity.Memos;
import jpa.entity.Users;

/* 자바 정수표현
 * 4바이트 int
 * 8바이트 long - 자바객체 아님. 키워드 
 * java.lang.Long 클래스 제공 = long 타입 클래스 변환
 * 
 * */

@Repository
public interface MemoRepository extends JpaRepository<Memos, Long>{
	// save() delete() findAll() ==> CRUD
	
	// jpql 문법 (*대신 별칭, Memos 엔티티에 있는대로, 무저건 entity 첫 대문자로 시작!)
	@Query("select m from Memos m where m.writer = :user")
	List<Memos> findMemo(@Param("user") Users user);
	
	// db 종속적 sql
	@Query(value=
			"""
			select * from Memos m join members b on m.writer_id = b.id 
			where m.writer_id=:user
			""", nativeQuery= true)
	List<Memos> findMemo(@Param("user") long user);
	
	
	@Query(value="select count(seq) from memos m where m.writer_id=:writer", nativeQuery = true)
	int findMemoCount(@Param("writer") long writer);
	
	
}
