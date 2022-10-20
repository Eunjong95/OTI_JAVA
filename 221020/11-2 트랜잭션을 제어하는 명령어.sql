---------------------------------
--11-2 Ʈ������� �����ϴ� ��ɾ�
---------------------------------
drop table accounts;

create table accounts (
    ano varchar2(15) primary key,
    owner varchar2(10) not null,
    balance number not null
);

--Ʈ����� ����
insert into accounts values('111-111', 'ȫ�浿', 10000);
insert into accounts values('111-112', '���ڹ�', 0);
commit;
--Ʈ����� ����

--Ʈ����� ����
update accounts set balance = balance-1000 where ano = '111-111';
update accounts set balance = balance+1000 where ano = '111-112';
rollback;
--Ʈ����� ����

--savepoint ���
--Ʈ����� ����
insert into accounts values('111-113', 'ȫ�漭', 10000);
insert into accounts values('111-114', 'ȫ�泲', 0);

savepoint insertedPoint;

update accounts set balance = balance-1000 where ano = '111-111';
update accounts set balance = balance+1000 where ano = '111-112';

savepoint updatedPoint;

delete from accounts where ano = '111-114';

rollback to updatedPoint;
--Ʈ����� ����

select * from accounts;