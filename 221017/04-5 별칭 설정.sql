------------------------------
--한눈에 보기 좋게 별칭 설정하기
------------------------------
--컬럼 내용을 연산할 경우에는 별칭을 붙여주는 것이 좋다.
select first_name, salary, salary*12 as yearsal
from employees;