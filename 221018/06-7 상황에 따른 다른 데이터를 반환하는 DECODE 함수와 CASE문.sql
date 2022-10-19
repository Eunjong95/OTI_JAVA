----------------------------------------------------------
--06-7 상황에 따른 다른 데이터를 반환하는 DECODE 함수와 CASE문
----------------------------------------------------------
--DECODE 함수
select employee_id, first_name, job_id, salary,
    round(decode(job_id,
            'AD_VP',salary*1.1,
            'FI_MGR',salary*1.3,
            salary*1.2)) as upsal
from employees
where job_id in ('AD_VP', 'FI_MGR', 'PU_MAN');

--CASE문
select employee_id, first_name, job_id, salary,
    round(
    case job_id
        when 'AD_VP' then salary*1.1
        when 'FI_MGR' then salary*1.3
        else salary*1.2
    end 
    )as upsal
from employees
where job_id in ('AD_VP', 'FI_MGR', 'PU_MAN');

--기준(원본) 데이터 없이 조건식만으로 case문 사용하기
select employee_id, first_name, commission_pct,
    case
        when commission_pct is null then '해당 사항 없음'
        when commission_pct > 0 then '수당: ' || commission_pct   
    end as comm_text
from employees;