--------------------------------------
--���̺� ���� �� ����, �̸� ����
--------------------------------------
/*
���� �� �ּ� ó��
*/

--���̺� ����
create table emp_ddl (
    empno number(4) not null,
    ename varchar2(10) not null
    );

--���̺� ����
drop table emp_ddl;

--�� ����
insert into emp_ddl (empno, ename) values(1, 'winter');
insert into emp_ddl (empno, ename) values(2, 'summer');
commit;

--������ �����Ͱ� �ִ� ���̺��� �÷��� ���� �߰��� ������
--null�� ����ϵ��� �ؾ� ��.
--not null�� ����� ������ �����͸� ä��� �Ŀ� not null�� �����ؾ� ��.
alter table emp_ddl
    add (
        city varchar(10) null, 
        age number(3) null
    );
    
--���̺��� �̸� ����
alter table emp_ddl 
    rename to employees;
    
--�÷� �̸� ����
alter table employees 
    rename column city to ecity;
    
alter table employees
    rename column age to eage;
    
--�÷��� ������ Ÿ�� ����
alter table employees
    modify (
        ename varchar2(15),
        ecity varchar2(20)
    );
    
--�÷� �����ϱ�
alter table employees
    drop column eage;
    
alter table employees
    drop (ename, ecity);
    
