--------------------------------------------
--05-2 ���� �� ���ǽ��� ����ϴ� AND, OR ������
--------------------------------------------
--���ǽ��� and �Ǵ� or�� ������ �� �ִ�.
select email, job_id, salary, hire_date
from employees
where department_id = 30 and salary > 3000
order by hire_date;

select email, job_id, salary, department_id, hire_date
from employees
where department_id = 30 or department_id = 20
order by department_id, hire_date;