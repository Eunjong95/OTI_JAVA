--------------------------------
--13-2 더 빠른 검색을 위한 인덱스
--------------------------------
--빠른 검색을 위한
select * from members where mname like '%길동%';
--인덱스 생성
create index ix_member_mname
on members(mname);

select * from members where mtel like'%1234%' and mcity = '서울';
--복합 인덱스 생성
create index ix_member_mtel_mcity
on members (mtel, mcity); --열 이름 뒤에 asc 또는 desc 붙이기 가능

--인덱스 삭제
drop index ix_member_mtel_mcity;