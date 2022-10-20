--------------------------------
--13-3 ���̺�ó�� ����ϴ� ��
--------------------------------
create view v_emp
    as(select employee_id, email, salary from employees);
select * from v_emp;

create view v_emp2
as(
     select employee_id, first_name, department_name
     from employees e, departments d
     where e.department_id = d.department_id
);
select * from v_emp2;

--���ѵ� ������ Ȯ���� �� �ְ� �ϱ�
create or replace view v_emp3
as(
    select employee_id, email, salary 
    from employees
    where department_id = 30
);
select * from v_emp3;

drop view v_emp3;
-----------------------------------
--view�� ���ؼ� DML(insert, update, delete)����
drop table products;

create table products (
    pno number primary key,
    pname varchar(50) not null,
    pprice number default 0 not null,
    pdate date default sysdate not null,
    pcompany varchar(50) null
);

create or replace view v_prod
as(select pno, pname, pprice from products);

insert into v_prod values (1, 'TV', 1000);

select * from products;
--------
create or replace view v_emp3
as(
    select employee_id, email, salary, department_id
    from employees
    where department_id = 50
);

update v_emp3 set department_id = 50
where employee_id = 114;

select * from v_emp3;