--���1
drop table members;

create table members (
    mid varchar(10) primary key,
    mname varchar(10) null
);

insert into members values('winter', '�Ѱܿ�');
insert into members values('winter', '�Ѱܿ�'); --(X)
insert into members values(null, '�Ѱܿ�'); --(X)

select * from members;

-----------------------------------------------
--���2 (���� ���� ����)
drop table members;

create table members(
    mid varchar(10) not null,
    mname varchar(10) null
);

--�÷��� ������� �����ϸ鼭 �������� �߰� 
alter table members
    modify(mid constraint pk_mid primary key);

--���������� ������� �������� �߰�
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
--���3 (�� ������ ����)
drop table members;

create table members(
    mid varchar(10) not null,
    mname varchar(10) null,
    constraint pk_mid primary key(mid),
    constraint u_name unique (mname)
);