drop table employees;

create table employees (
    eno number(4) not null,
    ename varchar2(15) not null
);

insert into employees (eno, ename) values(1, 'ȫ�浿');
insert into employees (eno, ename) values(2, '���ڹ�');
commit;

select * from employees;

--��� ���� ����
delete from employees;
rollback;

--���� ���̺��� ���� ���� �ʱ�ȭ
--�ѹ� ����� �ƴ�
truncate table employees;
rollback;