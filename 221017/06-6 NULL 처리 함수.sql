---------------------
--06-6 NULL ó�� �Լ�
---------------------
select 10 + nvl(null,0) from dual;

select salary*12 + nvl(commission_pct,0)*salary 
from employees;

select salary*12 + nvl2(commission_pct, commission_pct*salary ,0)
from employees;
