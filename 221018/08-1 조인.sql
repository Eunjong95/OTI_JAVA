------------
--08-1 조인
------------
select email, phone_number, department_name
from employees, departments
where employees.department_id = departments.department_id;

--alias 설정(e,d)
select email, phone_number, department_name
from employees e, departments d
where e.department_id = d.department_id;

select employee_id, email, phone_number, department_name
from employees e, departments d
where e.department_id = d.department_id;

--열의 정의가 애매하면 오류나기 때문에 e/d.department_id 해줘야 한다.
select email, phone_number, e.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;
