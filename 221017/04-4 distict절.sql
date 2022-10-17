--------------------------------
--distict절 사용
--------------------------------
--사원들이 소속되어 있는 부서 번호 가져오기(중복 제거)
select distinct department_id from employees;

--직무번호와 부서번호를 결합해서 중복을 제거
select distinct job_id, department_id from employees;