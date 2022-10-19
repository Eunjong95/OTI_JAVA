-----------------------------------------
--09-4 비교할 열이 여러 개인 다중열 서브쿼리
-----------------------------------------
select employee_id, salary, department_id
from employees
where (department_id, salary) in (
    select department_id, max(salary)
    from employees
    group by department_id
);

