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
insert into members values('fall', '�Ѱ���');
insert into freeboards values (1, '��ǳ', 'fall');
insert into freeboards values (2, '��', 'winter');

-------------------------------------------------------
drop table freeboards;
--���1
create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) constraint fk_bwriter references members (mid)
);

alter table freeboards
    add constraint pk_bno primary key (bno);
    
--���2
create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) not null, --bwriter �̹� ����
    constraint fk_bwriter foreign key(bwriter) references members (mid) --�� �� ���� �����ؼ� �� ���� ����������ؼ� foreign key() ��� ��
);

alter table freeboards
    add constraint pk_bno primary key (bno);

--���3 (���̺� ���� �� ���� ���� �߰�) -> ���� ���� ��
create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) not null
);

alter table freeboards
    add constraint pk_bno primary key (bno);
alter table freeboards
    add constraint fk_bwriter foreign key(bwriter) references members (mid); 
    
insert into freeboards values (1, '��ǳ', 'fall');
insert into freeboards values (2, '��', 'winter');------(x)
-----------------------------------------------------------------
--�����ϰ� �ִ� Ű�� ������ �� ����
delete from member where mid = 'fall';
delete from freeboards where bno=1;
--���1
--�����ϴ� ��� Ű�� ������ ���� ����
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
    
insert into freeboards values (1, '��ǳ', 'fall');
delete from members where mid = 'fall';

--���2
drop table freeboards;
create table freeboards (
    bno number not null,
    btitle varchar(50) not null,
    bwriter varchar(10) null --not null�̸� delete set null �Ұ���
);

alter table freeboards
    add constraint pk_bno primary key (bno);
alter table freeboards    
    add constraint fk_bwriter foreign key(bwriter) 
    references members (mid) on delete set null;
    
insert into freeboards values (1, '��ǳ', 'fall');
delete from members where mid = 'fall';