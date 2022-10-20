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
--아직 가져오지 않은 행에 대해 rownum 부여는 불가능
select rownum, first_name, salary
from (
    select first_name, salary
    from employees
    order by salary
)
where rownum > 5;
--------------------------------------
--paging(페이징) 처리 : 프젝에서 써야 됨
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

/* Pager 설명
[처음] 1, 2, 3, 4, 5 [다음][맨끝]
[처음][이전] 6, 7, 8, 9, 10 [다음][맨끝]
[처음][이전] 11, 12, 13, 14, 15 [다음][맨끝]
...
[처음][이전] 96, 97 [맨끝]

페이지당 행수(rowsPerPage): 10 행
그룹당 페이지수(pagesPerGroup): 5 페이지

전체 행수(totalRows): 973 행 (select count(*) from table)

전체 페이지 수: Math.ceil((double)totalRows / rowPerpage)
각 페이지의 시작 행번호: (page-1) * rowsPerPage + 1
각 페이지의 끝 행번호: page * rowsPerPage 
각 그룹의 시작 페이지 번호: (group-1) * pagesPerGroup + 1
각 그룹의 끝 페이지 번호: group * pagesPerGroup
*/
