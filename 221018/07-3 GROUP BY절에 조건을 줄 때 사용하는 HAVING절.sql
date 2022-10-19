-------------------------------------------------
--07-3 GROUP BY절에 조건을 줄 때 사용하는 HAVING절
-------------------------------------------------
select department_id, job_id, avg(salary)
from employees
where department_id in (10, 20, 30)
group by department_id, job_id
-- having salary > 10000 : 이미 그룹핑이 끝나서 새로운 조건으로 제한할 수는 없다.
having avg(salary) > 5000
order by department_id;