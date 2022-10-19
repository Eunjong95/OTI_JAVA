----------------------------------------
--09-3 ���� ����� ���� ���� ������ ��������
----------------------------------------
select salary from employees;
select max(salary) from employees;

--������ ��������
select employee_id, first_name
from employees
where salary = (select max(salary) from employees);

--������ ��������
select employee_id, first_name
from employees
where department_id in (
    select department_id 
    from departments 
    where location_id = 1700
    );

--In ������
select employee_id, first_name, job_id, department_id
from employees
where salary in(select max(salary)
from employees
group by department_id);

--Any, Some ������
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
    and salary >= any ( --salary�� �� ���� ���� ���̶� 
        select avg(salary) --select�ڿ� department_id ���� �ȵ�
        from employees
        group by department_id
    );
    
--All ������
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
    
--Exists ������
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
    where department_id in (e.department_id + 200) --�ܺ������� �����͸� �޾Ƽ� ���������� true�� ��� �ܺ������� ����ȴ�
);

--�Խù��� ���� �ۼ����� ���� ����� ���̵�� �̸��� �������ÿ�
--Join ��İ� Subquery ������� �غ�����.
select * from members;
select * from boards;

--���1: Join �̿�
select m.mid, m.mname
from members m, boards b
where m.mid = b.mid(+) --������� ���ָ� m�� �����͵��� �� b�� ��
    and b.mid is null; --b�� ���� null�� �����͵��� ���
    
--���2: Subquery �̿�
select mid, mname
from members m
where not exists (
    select mid
    from boards b
    where b.mid = m.mid
);

--�ٹ����ð� �þ�Ʋ�� ����� �̸��ϰ� ��ȭ��ȣ�� �������ÿ�
--���1: Join �̿�
select email, phone_number
from employees e, departments d, locations l
where e.department_id = d.department_id
    and d.location_id = l.location_id
    and city = 'Seattle'
;

--���2: Subquery �̿�
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