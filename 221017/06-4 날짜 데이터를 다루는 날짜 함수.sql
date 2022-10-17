------------------------------------
--06-4 ��¥ �����͸� �ٷ�� ��¥ �Լ�
------------------------------------
create table boards (
    bno number primary key,
    btitle varchar(50) not null,
    bdate date not null
);

insert into boards
values(1, '����', sysdate); --�Ű������� ���� ��쿡�� �Լ������θ� ȣ�� ����
select * from boards;

--��¥ ���� (�ϼ� ���)
select sysdate, sysdate+14 as twoweeksLater 
from dual; --dual�� ������ ���̺�

--���� ���ϴ� ��
select round(to_date('2022-12-31', 'YYYY-MM-dd') - sysdate) as dxmas
from dual;

--��¥ ���� (���� ���: add_months)
select sysdate, add_months(sysdate, 1)
from dual;

--���� �� ���� (months_between)
select months_between(to_date('2022-12-31', 'YYYY-MM-dd'), sysdate) 
from dual;

--���ƿ��� ���� ���ϴ� next_day �Լ�
select sysdate, next_day(sysdate, '��') 
from dual;

--���� ������ ��¥�� ���ϴ� last_day �Լ�
select sysdate, last_day(sysdate) 
from dual;
