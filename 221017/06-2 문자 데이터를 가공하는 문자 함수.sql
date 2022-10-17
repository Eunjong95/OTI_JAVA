--------------------------------------
--06-2 문자 데이터를 가공하는 문자 함수
--------------------------------------
--단일 행 함수
select last_name, upper(last_name), lower(last_name), initcap(last_name)
from employees;

--조건식에서 사용된 함수
select first_name
from employees
where lower(first_name) like '%st%'; --대소문자 상관없이 st검색하기 위해 다 lower로 바꿔줌

select email from employees;
select initcap (email) from employees;

--문자열 길이를 구하는 length 함수
create table members(
    mid varchar(50) not null,
    mname varchar(50) not null
);
insert into members values('fall', '한가을');
commit;

select mname, length(mname), lengthb(mname), lengthc(mname), length2(mname), length4(mname) from members;

--문자열 일부를 출력하는 substr 함수
select first_name, substr(first_name, 5) as col1, substr(first_name, -3, 2) as col2
from employees;

--특정 문자를 다른 문자로 바꾸는 replace 함수
select phone_number, replace(phone_number, '.', '-') as phone_number2
from employees;

--데이터 빈 공간을 채우는 lpad, rpad와 substr 활용
select first_name, rpad(substr(first_name, 1, 3), 6, '*') 
from employees;

--문자열 데이터를 연결하는 || 연산자
select first_name || ', ' || last_name as name
from employees;

--문자열 데이터를 연결하는 concat 함수
select concat(first_name, concat(', ', last_name)) as name
from employees;