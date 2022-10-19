----------------
--09-1 서브쿼리
----------------
select salary from employees where first_name = 'John';
select salary from employees where employee_id = 110;

select employee_id, salary
from employees
where salary > (select salary from employees where first_name = 'John');

--서브쿼리의 결과 행 수는 메인쿼리의 연산자 종류와 호환 가능해야 한다.
select employee_id, salary
from employees
where salary > (
    select salary 
    from employees 
    where employee_id = 110
);

select employee_id, salary, department_id
from employees
where department_id in (
    select department_id
    from departments
    where department_id < 30
);