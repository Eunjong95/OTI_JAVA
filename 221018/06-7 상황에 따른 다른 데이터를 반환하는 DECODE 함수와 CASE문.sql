----------------------------------------------------------
--06-7 ��Ȳ�� ���� �ٸ� �����͸� ��ȯ�ϴ� DECODE �Լ��� CASE��
----------------------------------------------------------
--DECODE �Լ�
select employee_id, first_name, job_id, salary,
    round(decode(job_id,
            'AD_VP',salary*1.1,
            'FI_MGR',salary*1.3,
            salary*1.2)) as upsal
from employees
where job_id in ('AD_VP', 'FI_MGR', 'PU_MAN');

--CASE��
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

--����(����) ������ ���� ���ǽĸ����� case�� ����ϱ�
select employee_id, first_name, commission_pct,
    case
        when commission_pct is null then '�ش� ���� ����'
        when commission_pct > 0 then '����: ' || commission_pct   
    end as comm_text
from employees;