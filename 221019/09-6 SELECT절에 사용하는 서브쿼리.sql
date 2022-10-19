-----------------------------------
--09-6 SELECT���� ����ϴ� ��������
-----------------------------------
--���1
select employee_id, first_name, job_id, salary, grade_id, department_id
from employees, grade
where salary between low_salary and high_salary
    and department_id = 30;
--���2
select employee_id, first_name, job_id, salary, department_id, grade_id
from(
select employee_id, first_name, job_id, salary, department_id
from employees
where department_id = 30
) e,
grade g
where salary between low_salary and high_salary; --from�� ���̺� �ΰ��� �����Ƿ� ��������
--���3
select employee_id, first_name, job_id, salary, department_id, 
    (
    select grade_id
    from grade
    where e.salary between low_salary and high_salary
    ) as grade_id
from employees e
where department_id = 30;

-------
--quiz
-------
select employee_id, first_name, job_id, department_name
from employees
where job_id = 'ST_CLERK';

--���1: Join
select employee_id, first_name, job_id, department_name
from employees e, departments d
where e.department_id = d.department_id
    and job_id = 'ST_CLERK';
    
--���2: from (��������)
select employee_id, first_name, job_id, e.department_id, department_name
from (
select employee_id, first_name, job_id, department_id
from employees
where job_id = 'ST_CLERK'
)e, 
departments d
where e.department_id = d.department_id; --���̺��� �ΰ��ϱ� �������� 

--���3: select (��������)
select employee_id, first_name, job_id, 
    (
    select department_name
    from departments 
    where e.department_id = department_id
    ) as department_name
from employees e
where job_id = 'ST_CLERK';
