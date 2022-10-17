---------------------------------------
--05-1 필요한 데이터만 쏙 출력하는 where절
---------------------------------------
--order by 는 where 뒤에 위치해야 한다.
select email, job_id, salary, hire_date
from employees
where department_id = 30
order by hire_date;
