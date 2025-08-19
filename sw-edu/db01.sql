# ddl - data definition language (반영 - 트랜잭션 자동 commit)
# 데이터를 저장할 구조를 만들겠다
# 테이블 만들 때
drop table if exists users, memos;

CREATE TABLE USERS (
	USERID varchar(20) primary key,
	PASSWORD int,
    USERNAME varchar(30) not null,
    EMAIL varchar(30) unique,
    REGDATE datetime default now()
);

# dml - data manipulation language - 트랜잭션 취소 가능(데이터 조작 언어)
# 5명 정보 저장
insert into users values ('user1', 1111, '사용자1', 'user1@sds.com', now());
insert into users values ('user2', 2222, '사용자2', 'user2@sds.com', default);
insert into users values ('user3', 3333, '사용자3', 'user3@sds.com', now());
insert into users values ('user4', 4444, '사용자4', 'user4@sds.com', now());
insert into users values ('user5', 5555, '사용자5', 'user5@sds.com', now());
# rollback; -- 롤백(DDL은 롤백 불가능, DML은 가능) 
commit; 	-- 커밋

# dql - data query language
select * from users;

# 사용자3 이메일 수정 'user33@multi.com'
update users set email = 'user33@multi.com' where username like '사용자3';

# 사용자3 삭제
delete from users where username = '사용자3';

# update, delete - 1개 레코드만 변경 가능 기본(workbench)

# 제약 조건
-- not null
-- unique
-- foreign key

CREATE TABLE MEMOS (
	memoid int auto_increment primary key,
    title varchar(100) not null,
    contents text,
    writer varchar(20),
    time datetime default now(),
    
    # foreign key 제약 조건
    # writer는 users 테이블에서 userid가 있는 것만 가능
    foreign key(writer) references users(userid) -- 회원만 메모를 쓸 수 있음
    on delete cascade
    on update cascade
);

insert into memos values (null, '메모1', '메모1의 내용', 'user1', default);
insert into memos values (null, '메모2', '메모2의 내용', 'user2', default);
select * from memos;

# foreign key 제약조건에 위배
-- insert into memos values (null, '메모3', '메모3의 내용', 'user3', default);

delete from users where userid = 'user1';
select * from users;
select * from memos; -- user1이 작성한 메모도 사라졌다.(on delete cascade)

# 날짜와 시간 보여주는 양식이 서로 다름
-- now, sysdate 양식 동일 -> 2025=-08-19 10:27:20
-- curdate: 2025-08-19
-- curtime: 10:27:20
select now(), sysdate(), curdate(), curtime();
select now(), date_format(now());