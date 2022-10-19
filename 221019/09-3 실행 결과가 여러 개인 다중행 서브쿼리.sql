----------------------------------------
--09-3 실행 결과가 여러 개인 다중행 서브쿼리
----------------------------------------
select salary from employees;
select max(salary) from employees;

--단일행 서브쿼리
select employee_id, first_name
from employees
where salary = (select max(salary) from employees);

--다중행 서브쿼리
select employee_id, first_name
from employees
where department_id in (
    select department_id 
    from departments 
    where location_id = 1700
    );

--In 연산자
select employee_id, first_name, job_id, department_id
from employees
where salary in(select max(salary)
from employees
group by department_id);

--Any, Some 연산자
select employee_id, department_id
from employees
where department_id = any (10, 20);

select employee_id, salary, department_id
from employees
where department_id = 100
    and salary >= some (8000, 9000, 10000);

select employee_id, salary, department_id
from employees
where department_id = 100
    and salary >= any ( --salary에 들어갈 값이 단일 행이라 
        select avg(salary) --select뒤에 department_id 들어가면 안됨
        from employees
        group by department_id
    );
    
--All 연산자
select employee_id, salary, department_id
from employees
where department_id = 100
    and salary >= all (8000, 9000, 10000);

select employee_id, salary, department_id
from employees
where department_id = 100
    and salary >= all (
        select avg(salary)
        from employees
        group by department_id
    );
    
--Exists 연산자
select employee_id, department_id
from employees
where exists (
    select department_name 
    from departments
    where department_id = 120
);

select employee_id, department_id
from employees e
where exists (
    select department_name 
    from departments
    where department_id in (e.department_id + 200) --외부쿼리의 데이터를 받아서 서브쿼리가 true일 경우 외부쿼리가 실행된다
);

--게시물을 전혀 작성하지 않은 멤버의 아이디와 이름을 가져오시오
--Join 방식과 Subquery 방식으로 해보세요.
select * from members;
select * from boards;

--방법1: Join 이용
select m.mid, m.mname
from members m, boards b
where m.mid = b.mid(+) --여기까지 해주면 m의 데이터들이 다 b에 들어감
    and b.mid is null; --b의 값이 null인 데이터들을 골라냄
    
--방법2: Subquery 이용
select mid, mname
from members m
where not exists (
    select mid
    from boards b
    where b.mid = m.mid
);

--근무도시가 시애틀인 사원의 이메일과 전화번호를 가져오시오
--방법1: Join 이용
select email, phone_number
from employees e, departments d, locations l
where e.department_id = d.department_id
    and d.location_id = l.location_id
    and city = 'Seattle'
;

--방법2: Subquery 이용
select email, phone_number
from employees
where department_id in (
    select department_id
    from departments
    where location_id = (
        select location_id
        from locations
        where city = 'Seattle'
    )
);