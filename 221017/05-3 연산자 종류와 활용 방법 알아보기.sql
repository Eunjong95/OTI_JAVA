--------------------------------------
--05-3 ������ ������ Ȱ�� ��� �˾ƺ���
--------------------------------------
select email, salary*12 as yearsal
from employees
where salary*12 >=200000;

--���ڿ� ��� ��
select first_name
from employees
where first_name >= 'A' and first_name < 'C';

--� �� ������
select email, job_id
from employees
where job_id != 'IT_PROG' and job_id <> 'FI_ACCOUNT';

--�� ���� ������
select email, job_id
from employees
where NOT(job_id != 'IT_PROG' and job_id <> 'FI_ACCOUNT');

--IN ������
select email, job_id
from employees
where job_id = 'IT_PROG' or job_id = 'FI_ACCOUNT';

select email, job_id
from employees
where job_id in ('IT_PROG', 'FI_ACCOUNT');

/* ���⼭ ���̴� in�� ���� in ������
create table t1(
grade char(1) check(grade in('A', 'B', 'C'));
*/

select email, job_id
from employees
where not job_id in ('IT_PROG', 'FI_ACCOUNT');

select email, job_id
from employees
where job_id not in ('IT_PROG', 'FI_ACCOUNT');

--BETWEEN A AND B ������
select email, salary
from employees
where salary >= 5000 and salary <=7000;

select email, salary
from employees
where salary between 5000 and 7000;

--LIKE ������
select first_name
from employees
where first_name like '%St%';

select first_name, email
from employees
where first_name like '%ev%' or email like '%ev%';

select email
from employees
where email like '_L%';

--IS NULL ������
select employee_id, first_name
from employees
where department_id is null;

select employee_id, first_name
from employees
where department_id is not null;

select * from employees where salary is null;
select * from employees where commission_pct is null;

--null�� ���갪�� null
select (salary*12) + (commission_pct*salary) as yearsal 
from employees;

--UNION ���� ������ 
select email, phone_number
from employees
where department_id = 10 or department_id = 20;

select email, phone_number
from employees
where department_id in(10, 20);

select email, phone_number, department_id
from employees
where department_id = 10
union
select email, phone_number, department_id
from employees
where department_id = 20;