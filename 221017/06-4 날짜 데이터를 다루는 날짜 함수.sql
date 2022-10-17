------------------------------------
--06-4 날짜 데이터를 다루는 날짜 함수
------------------------------------
create table boards (
    bno number primary key,
    btitle varchar(50) not null,
    bdate date not null
);

insert into boards
values(1, '제목', sysdate); --매개변수가 없을 경우에는 함수명으로만 호출 가능
select * from boards;

--날짜 연산 (일수 계산)
select sysdate, sysdate+14 as twoweeksLater 
from dual; --dual은 가상의 테이블

--디데이 구하는 법
select round(to_date('2022-12-31', 'YYYY-MM-dd') - sysdate) as dxmas
from dual;

--날짜 연산 (월수 계산: add_months)
select sysdate, add_months(sysdate, 1)
from dual;

--개월 수 차이 (months_between)
select months_between(to_date('2022-12-31', 'YYYY-MM-dd'), sysdate) 
from dual;

--돌아오는 요일 구하는 next_day 함수
select sysdate, next_day(sysdate, '금') 
from dual;

--달의 마지막 날짜를 구하는 last_day 함수
select sysdate, last_day(sysdate) 
from dual;
