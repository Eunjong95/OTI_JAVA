---------------------------------
--���ϴ� ������ ����ϴ� order by
---------------------------------
--���޾� ���� �ø��������� �����ȣ�� ���� ��������
select employee_id, salary
from employees
order by salary asc;

--���޾� ���� ������������ �����ȣ�� ���� ��������
select employee_id, salary
from employees
order by salary desc;

--�μ��� �μ����� �ø��������� �����ϰ�,
--���� �μ� ���� ������ ������������ ����
select department_id, salary
from employees
order by department_id, salary desc;