-------------------------------------------
--07-1 하나의 열에 출력 결과를 담는 다중행 함수
-------------------------------------------
select sum(salary) from employees;

select count(employee_id) from employees;
select count(department_id) from employees; --count는 null을 세지 않음
select count(*) from employees; --*는 전체 행을 의미해서 null도 포함
