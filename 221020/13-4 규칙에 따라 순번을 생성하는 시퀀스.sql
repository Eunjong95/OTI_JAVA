--------------------------------------
--13-4 ��Ģ�� ���� ������ �����ϴ� ������
--------------------------------------
drop table boards;

create table boards (
    bno number primary key,
    btitle varchar(100) not null,
    bcontent clob not null
);

--Sequence ����
create sequence seq_boards_bno;

select seq_boards_bno.nextval from dual;
select seq_boards_bno.currval from dual;

insert into boards values(seq_boards_bno.nextval, '����', '����');
select * from boards;