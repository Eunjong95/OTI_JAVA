drop table member;

create table member(
    mid varchar(10) unique not null, --unique이면서 not null
    memail varchar(50) constraint u_memail unique,
    mname varchar(10) not null
);

insert into member values(null, 'fall@mycompany.com', '홍길동');

select * from member;

desc member;
------------------------------------
drop table member;

create table member(
    mid varchar(10) not null,
    memail varchar(50) null,
    mname varchar(10) not null
);

alter table member 
    modify (
        mid constraint u_mid unique,
        memail constraint u_memail unique        
    );
    
alter table member
    drop constraint u_memail;