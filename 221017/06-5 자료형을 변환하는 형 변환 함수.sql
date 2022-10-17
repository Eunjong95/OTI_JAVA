-----------------------------------
--06-5 자료형을 변환하는 형 변환 함수
-----------------------------------
--날짜,숫자 데이터를 문자 데이터로 변환하는 to_char 함수
--원하는 출력 형태로 날짜 출력
select hire_date from employees;
select to_char(hire_date, 'yyyy.mm.dd hh24:mi:ss') from employees;
select to_char(sysdate, 'yyyy.mm.dd hh24:mi:ss am') from employees;
--숫자 데이터 형식을 지정하여 출력
select to_char(salary, 'L99,999.00') from employees;

--문자 데이터를 날짜 데이터로 변환하는 to_date 함수
insert into boards values(2,'제목2', '2022.10.17');
insert into boards values(3,'제목3', to_date('2022.10.17', 'yyyy.mm.dd'));
select * from boards where bdate='2022.10.17';
select * from boards where bdate>'2022-10-16';
select to_date('2022.12.31', 'yyyy.mm.dd') - sysdate from dual;