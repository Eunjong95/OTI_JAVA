-----------------------------------------
--09-4 ���� ���� ���� ���� ���߿� ��������
-----------------------------------------
select employee_id, salary, department_id
from employees
where (department_id, salary) in (
    select department_id, max(salary)
    from employees
    group by department_id
);

