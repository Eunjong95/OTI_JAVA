-----------------
--13-3-2 ROWNUM
-----------------
select employee_id, first_name
from employees;
--
select rownum, employee_id, first_name
from employees;
--
select rownum, employee_id, first_name
from employees
order by employee_id;
--
select rownum, first_name, salary
from employees
order by salary;
--
select rownum, first_name, salary
from (
    select first_name, salary
    from employees
    order by salary
)
where rownum <= 5;
--���� �������� ���� �࿡ ���� rownum �ο��� �Ұ���
select rownum, first_name, salary
from (
    select first_name, salary
    from employees
    order by salary
)
where rownum > 5;
--------------------------------------
--paging(����¡) ó�� : �������� ��� ��
--------------------------------------
select rnum, employee_id, first_name
from (
    select rownum as rnum, employee_id, first_name
    from (
        select employee_id, first_name
        from employees
        order by employee_id
    )
    where rownum <= 30
)
where rnum >= 21;
-----
select rnum, employee_id, first_name
from (
    select rownum as rnum, employee_id, first_name
    from (
        select employee_id, first_name
        from employees
        order by employee_id
    )
    where rownum <= 50 --(pageNo*rowsPerPage)
)
where rnum >= 41 --(pageNo-1)*rowsPerPage+1;

/* Pager ����
[ó��] 1, 2, 3, 4, 5 [����][�ǳ�]
[ó��][����] 6, 7, 8, 9, 10 [����][�ǳ�]
[ó��][����] 11, 12, 13, 14, 15 [����][�ǳ�]
...
[ó��][����] 96, 97 [�ǳ�]

�������� ���(rowsPerPage): 10 ��
�׷�� ��������(pagesPerGroup): 5 ������

��ü ���(totalRows): 973 �� (select count(*) from table)

��ü ������ ��: Math.ceil((double)totalRows / rowPerpage)
�� �������� ���� ���ȣ: (page-1) * rowsPerPage + 1
�� �������� �� ���ȣ: page * rowsPerPage 
�� �׷��� ���� ������ ��ȣ: (group-1) * pagesPerGroup + 1
�� �׷��� �� ������ ��ȣ: group * pagesPerGroup
*/
