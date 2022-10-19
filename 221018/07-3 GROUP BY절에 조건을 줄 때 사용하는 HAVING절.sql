-------------------------------------------------
--07-3 GROUP BY���� ������ �� �� ����ϴ� HAVING��
-------------------------------------------------
select department_id, job_id, avg(salary)
from employees
where department_id in (10, 20, 30)
group by department_id, job_id
-- having salary > 10000 : �̹� �׷����� ������ ���ο� �������� ������ ���� ����.
having avg(salary) > 5000
order by department_id;