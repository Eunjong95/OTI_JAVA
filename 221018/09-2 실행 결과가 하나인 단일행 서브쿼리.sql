--------------------------------------
--09-2 ���� ����� �ϳ��� ������ ��������
--------------------------------------
--110�� ���� �Ի� ��¥�� ���� ���
select *
from employees
where hire_date < (
    select hire_date
    from employees
    where employee_id = 110
);

--��ü ��� ���޺��� ���� ������ �������� ���
select *
from employees
where salary > (
    select avg(salary)
    from employees
);