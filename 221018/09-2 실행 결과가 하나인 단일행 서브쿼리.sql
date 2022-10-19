--------------------------------------
--09-2 실행 결과가 하나인 단일행 서브쿼리
--------------------------------------
--110번 보다 입사 날짜가 빠른 사원
select *
from employees
where hire_date < (
    select hire_date
    from employees
    where employee_id = 110
);

--전체 평균 봉급보다 많은 봉급을 가져가는 사원
select *
from employees
where salary > (
    select avg(salary)
    from employees
);