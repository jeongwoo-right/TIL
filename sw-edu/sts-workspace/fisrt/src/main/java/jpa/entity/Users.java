package jpa.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity 	// jpa 기능으로 orm임을 알려준다 (Users 테이블 생성) / members 테이블을 생성하고 싶다? 아래 @Table
@Table(name="members") // 가독성을 높이려면, 클래스명 == 테이블명 일치시키기
@Component	// ioc, di 
@Setter		// 표현간결식(lombok in build.gradle)
@Getter		// 표현간결식(lombok in build.gradle)
public class Users {
	
	@Id 													// column 중에서 pk를 가지고 있는 column일 때, '@Id'	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	// 값을 만드는 방법: 알아서 DB에 맡길게, mysql - auto_increment
 
	long id; 			// column과 매핑
	
	@Column(length=20, unique=true, nullable=false)
	String username;
	
	@Transient // age 변수 매핑에서 생략
	int age;
}


