---------------------------------------
--05-1 �ʿ��� �����͸� �� ����ϴ� where��
---------------------------------------
--order by �� where �ڿ� ��ġ�ؾ� �Ѵ�.
select email, job_id, salary, hire_date
from employees
where department_id = 30
order by hire_date;
