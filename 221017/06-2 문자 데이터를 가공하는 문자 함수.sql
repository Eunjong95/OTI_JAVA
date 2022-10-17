--------------------------------------
--06-2 ���� �����͸� �����ϴ� ���� �Լ�
--------------------------------------
--���� �� �Լ�
select last_name, upper(last_name), lower(last_name), initcap(last_name)
from employees;

--���ǽĿ��� ���� �Լ�
select first_name
from employees
where lower(first_name) like '%st%'; --��ҹ��� ������� st�˻��ϱ� ���� �� lower�� �ٲ���

select email from employees;
select initcap (email) from employees;

--���ڿ� ���̸� ���ϴ� length �Լ�
create table members(
    mid varchar(50) not null,
    mname varchar(50) not null
);
insert into members values('fall', '�Ѱ���');
commit;

select mname, length(mname), lengthb(mname), lengthc(mname), length2(mname), length4(mname) from members;

--���ڿ� �Ϻθ� ����ϴ� substr �Լ�
select first_name, substr(first_name, 5) as col1, substr(first_name, -3, 2) as col2
from employees;

--Ư�� ���ڸ� �ٸ� ���ڷ� �ٲٴ� replace �Լ�
select phone_number, replace(phone_number, '.', '-') as phone_number2
from employees;

--������ �� ������ ä��� lpad, rpad�� substr Ȱ��
select first_name, rpad(substr(first_name, 1, 3), 6, '*') 
from employees;

--���ڿ� �����͸� �����ϴ� || ������
select first_name || ', ' || last_name as name
from employees;

--���ڿ� �����͸� �����ϴ� concat �Լ�
select concat(first_name, concat(', ', last_name)) as name
from employees;