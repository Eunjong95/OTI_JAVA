---------------------------------
--원하는 순서로 출력하는 order by
---------------------------------
--봉급액 기준 올림차순으로 사원번호와 봉급 가져오기
select employee_id, salary
from employees
order by salary asc;

--봉급액 기준 내림차순으로 사원번호와 봉급 가져오기
select employee_id, salary
from employees
order by salary desc;

--부서는 부서끼리 올림차순으로 정렬하고,
--같은 부서 내의 봉급은 내림차순으로 정렬
select department_id, salary
from employees
order by department_id, salary desc;