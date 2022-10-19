-----------------------------------
--등가 조인 (내부 조인 = Inner Join)
-----------------------------------
--inner join
select email, department_name
from employees e, departments d
where e.department_id = d.department_id;

--SQL-92문법
select email, department_name
from employees e
inner join departments d on e.department_id = d.department_id;

--natural join (08-3) / SQL-99문법 / 똑같은 컬럼이 하나 있을 경우
select email, department_name
from employees e natural join departments d;

--똑같은 컬럼이 여러 개일 경우: 하나를 지정해서 쓸 수 있음
select email, department_name
from employees e join departments d using(department_id);

--내가 원하는 조건의 컬럼을 마음대로 지정해서 사용할 때
select email, department_name
from employees e join departments d 
    on (e.department_id = d.department_id);
    
-----------------------------------
--등가 조인 (외부 조인 = Outer Join)
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

insert into members values ('spring', '김하늘');
insert into members values ('summer', '하여름');
insert into members values ('fall', '김가을');
insert into members values ('winter', '이겨울');
commit;

insert into boards values (1, '제목1', 'spring', '김하늘');
insert into boards values (2, '제목2', 'fall', '김가을');
insert into boards values (3, '제목3', 'spring', '이바다');
commit;

select m.mid, m.mname, bno, btitle, b.mid, b.mname
from members m, boards b
where m.mid = b.mid;

select mid, mname, bno, btitle
from members m natural join boards b;