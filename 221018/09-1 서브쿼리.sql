----------------
--09-1 ��������
----------------
select salary from employees where first_name = 'John';
select salary from employees where employee_id = 110;

select employee_id, salary
from employees
where salary > (select salary from employees where first_name = 'John');

--���������� ��� �� ���� ���������� ������ ������ ȣȯ �����ؾ� �Ѵ�.
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