-------------------------------------------------
--07-2 ������� ���ϴ� ���� ���� ����ϴ� GROUP BY��
-------------------------------------------------
select department_id, salary
from employees
where department_id in (10, 20, 30)
order by department_id;

select department_id, max(salary)
from employees
where department_id in (10, 20, 30)
group by department_id
order by department_id;

--group by�� �ִ� �÷��� select���� �־�� �Ѵ�.
select department_id, job_id, max(salary)
from employees
where department_id in (10, 20, 30)
group by department_id, job_id
order by department_id;
