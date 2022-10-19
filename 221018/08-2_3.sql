-----------------------------------
--� ���� (���� ���� = Inner Join)
-----------------------------------
--inner join
select email, department_name
from employees e, departments d
where e.department_id = d.department_id;

--SQL-92����
select email, department_name
from employees e
inner join departments d on e.department_id = d.department_id;

--natural join (08-3) / SQL-99���� / �Ȱ��� �÷��� �ϳ� ���� ���
select email, department_name
from employees e natural join departments d;

--�Ȱ��� �÷��� ���� ���� ���: �ϳ��� �����ؼ� �� �� ����
select email, department_name
from employees e join departments d using(department_id);

--���� ���ϴ� ������ �÷��� ������� �����ؼ� ����� ��
select email, department_name
from employees e join departments d 
    on (e.department_id = d.department_id);
    
-----------------------------------
--� ���� (�ܺ� ���� = Outer Join)
-----------------------------------
select email, department_name
from employees e, departments d
where e.department_id(+) = d.department_id;

select email, department_name
from employees e right outer join departments d
on e.department_id = d.department_id;

--
drop table boards;
drop table members;

create table members(
    mid varchar2(10) primary key,
    mname varchar2(20) not null
);
create table boards(
    bno number primary key,
    btitle varchar(100) not null,
    mid varchar2(10) references members (mid) on delete cascade,
    mname varchar2(20) not null
);

insert into members values ('spring', '���ϴ�');
insert into members values ('summer', '�Ͽ���');
insert into members values ('fall', '�谡��');
insert into members values ('winter', '�̰ܿ�');
commit;

insert into boards values (1, '����1', 'spring', '���ϴ�');
insert into boards values (2, '����2', 'fall', '�谡��');
insert into boards values (3, '����3', 'spring', '�̹ٴ�');
commit;

select m.mid, m.mname, bno, btitle, b.mid, b.mname
from members m, boards b
where m.mid = b.mid;

select mid, mname, bno, btitle
from members m natural join boards b;