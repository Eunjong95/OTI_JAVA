drop table freeboards;
drop table members;
--���1
create table members(
    mid varchar(20) primary key,
    mname varchar(20) not null,
    mage number(3) check(mage>0 and mage<200),
    mgrade char(1) check(mgrade in ('A', 'B', 'C')) --in():()�߿� �ϳ�
);

insert into members
values('winter', '�Ѱܿ�', -25, 'A');

--���2
create table members(
    mid varchar(20) primary key,
    mname varchar(20) not null,
    mage number(3) not null,
    mgrade char(1) not null,
    constraint ck_mage check(mage>0 and mage<200),
    constraint ck_mgrade check(mgrade in ('A', 'B', 'C'))
);

--���3
create table members(
    mid varchar(20) primary key,
    mname varchar(20) not null,
    mage number(3) not null,
    mgrade char(1) not null    
);

alter table members
    add constraint pk_mid primary key (mid);

alter table members
    add constraint ck_mage check(mage>0 and mage<200);

alter table members
    add constraint ck_mgrade check(mgrade in ('A', 'B', 'C'));