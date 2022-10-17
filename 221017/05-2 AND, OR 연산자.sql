--------------------------------------------
--05-2 여러 개 조건식을 사용하는 AND, OR 연산자
--------------------------------------------
--조건식은 and 또는 or로 연결할 수 있다.
select email, job_id, salary, hire_date
from employees
where department_id = 30 and salary > 3000
order by hire_date;

select email, job_id, salary, department_id, hire_date
from employees
where department_id = 30 or department_id = 20
order by department_id, hire_date;