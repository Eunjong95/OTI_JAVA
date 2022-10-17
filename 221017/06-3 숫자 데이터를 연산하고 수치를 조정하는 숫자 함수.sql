--------------------------------------------------
--06-3 숫자 데이터를 연산하고 수치를 조정하는 숫자 함수
--------------------------------------------------
--숫자 함수
select salary, 
    round(salary/31), 
    round(salary/31, 2),
    trunc(salary/31), 
    trunc(salary/31, 2),
    trunc(salary/31, -2),
    ceil(salary/31),
    floor(salary/31),
    mod(salary, 31)
from employees;