-----------------------------------------
--09-5 FROM���� ����ϴ� ���������� WITH��
-----------------------------------------
--from���� ����ϴ� ��������
select email, department_name
from 
(
    select email, department_id
    from employees 
    where department_id in (10,20)
) e,
( 
    select department_id, department_name, location_id
    from departments
) d,
( 
    select location_id, city
    from locations
) l
where e.department_id = d.department_id
     and d.location_id = l.location_id;

--������������ ����� ���������� ��Ī�� ���� �����ϴ� with��
with 
e as (select email, department_id from employees where department_id in (10,20)),
d as ( select department_id, department_name, location_id from departments),
l as ( select location_id, city from locations)
select email, department_name
from e, d, l
where e.department_id = d.department_id
     and d.location_id = l.location_id;
  
--��ȣ ���� ��������(correalted subquery)
select employee_id, department_id, salary
from employees e1
where salary > (
    select min(salary) from employees e2
    where e2.department_id = e1.department_id
)
order by department_id, salary;
    