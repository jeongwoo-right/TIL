package jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.entity.Memos;
import jpa.entity.Users;
import jpa.repository.MemoRepository;
import jpa.repository.UsersRepository;

@Service
public class MemoService {
	
	// memotime-현재시간, seq(pk, 자동 증가)
	
	
	@Autowired
	MemoRepository memoRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	public List<Memos> input(String username, String title, String contents) {
		// USERNAME에 해당하는 USERS 조회
		// findByUsername - select * from members where username=???
		
		// USERS 존재 O	- 메모 작성
		// USERS 존재 X 	- 메모 작성 + 회원 INSERT
		
		Users writer = usersRepository.findByUsername(username);
		
		// writer가 없으면 만들어라.
		if (writer == null) {
			writer = new Users();
			writer.setUsername(username);
			// Users 객체 생성 --> db insert x
		}
		
		Memos memo = new Memos();
		memo.setWriter(writer);
		memo.setTitle(title);
		memo.setContents(contents);
		memoRepository.save(memo);
		return memoRepository.findAll();
	}
	
	// jpql  - user 본인이 입력한 메모 내용만 달라!
	public List<Memos> output(String username) {
		Users writer = usersRepository.findByUsername(username);
		System.out.println(memoRepository.findMemoCount(writer.getId()));
		return memoRepository.findMemo(writer.getId());
	}
	
	
	
}

/*
	스프링부트 시작 		- members 테이블, memos 테이블 생성
	UsersController - initialInput - 5명 회원 저장 구현 
	http://127.0.0.1:8080/initialInput
	http://127.0.0.1:8080/inputmemo?username=배나연&title=메모1&contents=배나연이 메모1을 작성합니다.
 */



