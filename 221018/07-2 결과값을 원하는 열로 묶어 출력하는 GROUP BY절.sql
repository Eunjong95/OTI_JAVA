-------------------------------------------------
--07-2 결과값을 원하는 열로 묶어 출력하는 GROUP BY절
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

--group by에 있는 컬럼은 select절에 있어야 한다.
select department_id, job_id, max(salary)
from employees
where department_id in (10, 20, 30)
group by department_id, job_id
order by department_id;
