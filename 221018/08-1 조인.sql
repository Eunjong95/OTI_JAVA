------------
--08-1 ����
------------
select email, phone_number, department_name
from employees, departments
where employees.department_id = departments.department_id;

--alias ����(e,d)
select email, phone_number, department_name
from employees e, departments d
where e.department_id = d.department_id;

select employee_id, email, phone_number, department_name
from employees e, departments d
where e.department_id = d.department_id;

--���� ���ǰ� �ָ��ϸ� �������� ������ e/d.department_id ����� �Ѵ�.
select email, phone_number, e.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;
