--방법1
drop table members;

create table members (
    mid varchar(10) primary key,
    mname varchar(10) null
);

insert into members values('winter', '한겨울');
insert into members values('winter', '한겨울'); --(X)
insert into members values(null, '한겨울'); --(X)

select * from members;

-----------------------------------------------
--방법2 (가장 많이 사용됨)
drop table members;

create table members(
    mid varchar(10) not null,
    mname varchar(10) null
);

--컬럼을 대상으로 수정하면서 제약조건 추가 
alter table members
    modify(mid constraint pk_mid primary key);

--제약조건을 대상으로 제약조건 추가
alter table members
    add constraint pk_mid primary key(mid);
    
-----------------------------------------------
drop table members;

create table members(
    first_no char(6) not null,
    second_no char(7) not null,
    mname varchar(10) null
);

alter table members
    add constraint pk_ssn primary key (first_no, second_no);

------------------------------------------------
--방법3 (잘 사용되지 않음)
drop table members;

create table members(
    mid varchar(10) not null,
    mname varchar(10) null,
    constraint pk_mid primary key(mid),
    constraint u_name unique (mname)
);