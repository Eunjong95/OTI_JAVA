drop table members;
drop table freeboards;

create table members(
    mid varchar(10) not null,
    mname varchar(20) not null  
);

alter table members
    add constraint pk_mid primary key (mid);

create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) not null
);

alter table freeboards
    add constraint pk_bno primary key (bno);
    
-------------------------------------------------------
insert into members values('fall', '한가을');
insert into freeboards values (1, '단풍', 'fall');
insert into freeboards values (2, '눈', 'winter');

-------------------------------------------------------
drop table freeboards;
--방법1
create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) constraint fk_bwriter references members (mid)
);

alter table freeboards
    add constraint pk_bno primary key (bno);
    
--방법2
create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) not null, --bwriter 이미 선언
    constraint fk_bwriter foreign key(bwriter) references members (mid) --셋 중 뭐를 참조해서 쓸 건지 정의해줘야해서 foreign key() 써야 됨
);

alter table freeboards
    add constraint pk_bno primary key (bno);

--방법3 (테이블 생성 후 제약 조건 추가) -> 가장 많이 씀
create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) not null
);

alter table freeboards
    add constraint pk_bno primary key (bno);
alter table freeboards
    add constraint fk_bwriter foreign key(bwriter) references members (mid); 
    
insert into freeboards values (1, '단풍', 'fall');
insert into freeboards values (2, '눈', 'winter');------(x)
-----------------------------------------------------------------
--참조하고 있는 키는 삭제할 수 없음
delete from member where mid = 'fall';
delete from freeboards where bno=1;
--방법1
--참조하는 모든 키를 포함한 행을 삭제
drop table freeboards;
create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) not null
);

alter table freeboards
    add constraint pk_bno primary key (bno);
alter table freeboards
    add constraint fk_bwriter foreign key(bwriter) 
    references members (mid) on delete cascade;
    
insert into freeboards values (1, '단풍', 'fall');
delete from members where mid = 'fall';

--방법2
drop table freeboards;
create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) null --not null이면 delete set null 불가능
);

alter table freeboards
    add constraint pk_bno primary key (bno);
alter table freeboards    
    add constraint fk_bwriter foreign key(bwriter) 
    references members (mid) on delete set null;
    
insert into freeboards values (1, '단풍', 'fall');
delete from members where mid = 'fall';