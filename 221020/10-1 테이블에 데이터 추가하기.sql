-----------------------------
--10-1 ���̺� ������ �߰��ϱ�
-----------------------------
drop table boards;
drop table members;

create table members (
    mid varchar2(20) primary key,
    mname varchar2(20) not null,
    memail varchar2(100) unique null,
    mage number check(mage>0 and mage<300),
    mtel varchar2(20),
    mcity varchar2(20) default '����' not null 
);

insert into members values ('winter', '������', 'snow@mycompany.com', '25', '010-123-1234', '�λ�');
insert into members values ('spring', '����', null, '25', null, default);
insert into members (mid,mname) values ('summer', '�Ͽ���'); 
--->insert������ ���� ���̺��� �÷��� ���������� ��, ���̺� ���� �� default�� �ְ� not null�� �־����� ���� ����

select * from members;
commit;

create table boards (
    bno number primary key, 
    btitle varchar2(100) not null,
    bcontent clob not null,
    bwriter varchar2(20) references members (mid) on delete cascade,
    bdate date default sysdate not null
);

insert into boards values (1, '����1', '����1', 'winter', sysdate); 
--> sysdate�� ���� ������ ��¥ ����
insert into boards values (2, '����2', '����2', 'winter', '2022.12.25');
insert into boards values (3, '����3', '����3', 'summer', default);
insert into boards (bno, btitle, bcontent, bwriter) values (4, '����4', '����4', 'summer');
---> insert������ ���� ���̺��� �÷��� ���������� ��, ���̺� ���� �� default�� �ְ� not null�� �־����� ���� ����
insert into boards values (5, '����5', '����5', 'winter', to_date('12.25.2022', 'mm.dd.yyyy'));
---> to_date �Լ� ���