-----------------------------------
--06-5 �ڷ����� ��ȯ�ϴ� �� ��ȯ �Լ�
-----------------------------------
--��¥,���� �����͸� ���� �����ͷ� ��ȯ�ϴ� to_char �Լ�
--���ϴ� ��� ���·� ��¥ ���
select hire_date from employees;
select to_char(hire_date, 'yyyy.mm.dd hh24:mi:ss') from employees;
select to_char(sysdate, 'yyyy.mm.dd hh24:mi:ss am') from employees;
--���� ������ ������ �����Ͽ� ���
select to_char(salary, 'L99,999.00') from employees;

--���� �����͸� ��¥ �����ͷ� ��ȯ�ϴ� to_date �Լ�
insert into boards values(2,'����2', '2022.10.17');
insert into boards values(3,'����3', to_date('2022.10.17', 'yyyy.mm.dd'));
select * from boards where bdate='2022.10.17';
select * from boards where bdate>'2022-10-16';
select to_date('2022.12.31', 'yyyy.mm.dd') - sysdate from dual;