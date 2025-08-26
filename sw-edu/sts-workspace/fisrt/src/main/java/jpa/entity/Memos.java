package jpa.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 				// jpa 기능으로 orm임을 알려준다 (Users 테이블 생성) / members 테이블을 생성하고 싶다? 아래 @Table
@Table(name="memos")	// 가독성을 높이려면, 클래스명 == 테이블명 일치시키기
@Component				// ioc, di 
@Setter					// 표현간결식(lombok in build.gradle)
@Getter					// 표현간결식(lombok in build.gradle)
@EntityListeners(AuditingEntityListener.class)
public class Memos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long seq; 						// 메모 번호
	
	String title;
	String contents;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	Users writer; 				// Users id - fk
	
	@CreatedDate				// memos dml 실행 데이터 생성되는 시각 추적 정보 제공
	LocalDateTime memotime;		// 날짜 데이터
	
}
