-----------------------------
--10-1 테이블에 데이터 추가하기
-----------------------------
drop table boards;
drop table members;

create table members (
    mid varchar2(20) primary key,
    mname varchar2(20) not null,
    memail varchar2(100) unique null,
    mage number check(mage>0 and mage<300),
    mtel varchar2(20),
    mcity varchar2(20) default '서울' not null 
);

insert into members values ('winter', '눈송이', 'snow@mycompany.com', '25', '010-123-1234', '부산');
insert into members values ('spring', '봄이', null, '25', null, default);
insert into members (mid,mname) values ('summer', '하여름'); 
--->insert문에서 기존 테이블의 컬럼을 지정해줬을 때, 테이블 생성 시 default가 있고 not null이 있었더라도 생략 가능

select * from members;
commit;

create table boards (
    bno number primary key, 
    btitle varchar2(100) not null,
    bcontent clob not null,
    bwriter varchar2(20) references members (mid) on delete cascade,
    bdate date default sysdate not null
);

insert into boards values (1, '제목1', '내용1', 'winter', sysdate); 
--> sysdate는 현재 시점의 날짜 리턴
insert into boards values (2, '제목2', '내용2', 'winter', '2022.12.25');
insert into boards values (3, '제목3', '내용3', 'summer', default);
insert into boards (bno, btitle, bcontent, bwriter) values (4, '제목4', '내용4', 'summer');
---> insert문에서 기존 테이블의 컬럼을 지정해줬을 때, 테이블 생성 시 default가 있고 not null이 있었더라도 생략 가능
insert into boards values (5, '제목5', '내용5', 'winter', to_date('12.25.2022', 'mm.dd.yyyy'));
---> to_date 함수 사용