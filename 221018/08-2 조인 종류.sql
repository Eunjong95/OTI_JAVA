-----------------
--08-2 ���� ����
-----------------
--� ���� / where���� ���ǽ� �߰�
select email, department_name
from employees e, departments d
where e.department_id = d.department_id;

select email, phone_number, e.department_id, department_name, salary
from employees e, departments d
where e.department_id = d.department_id
    and d.department_id = 20
    and salary > 100;
    
--���������� �̾��� �������� Ȱ���� ���������� ���� ���̺��� �����ϱ�
select employee_id, phone_number, city, department_name
from employees e, departments d, locations l
where e.department_id = d.department_id 
    and d.location_id = l.location_id;

select employee_id, phone_number, region_name
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id 
    and d.location_id = l.location_id
    and l.country_id = c.country_id
    and c.region_id = r.region_id;

--���� ���̺��� �� �� ����Ͽ� ��ü �����ϱ�
select e.employee_id as ���, e.first_name as �̸�, e1.first_name as �������̸�
from employees e, employees e1
where e.employee_id = e1.manager_id;

--�� ����
drop table grade;

create table grade(
    grade_id char(1) primary key,
    low_salary number(8,2) not null,
    high_salary number(8,2) not null
);

insert into grade values ('A', 3001, 99999);
insert into grade values ('B', 2001, 3000);
insert into grade values ('C', 1401, 2000);
insert into grade values ('D', 1201, 1400);
insert into grade values ('E', 700, 1200);
commit;

select employee_id, salary, grade_id
from employees e, grade g
where e.salary between g.low_salary and g.high_salary;

--�ܺ� ����
select employee_id, e.department_id, d.department_id, department_name
from employees e, departments d
where e.department_id(+) = d.department_id;

--����� ���� �μ��� ��ȣ�� �̸�
select d.department_id, department_name
from employees e, departments d
where e.department_id(+) = d.department_id
    and employee_id is null;

select emp.employee_id, emp.manager_id, mgr.first_name
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id(+);

--�����ڰ� ���� ���
select emp.employee_id, emp.manager_id, mgr.first_name
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id(+)
    and emp.manager_id is null;