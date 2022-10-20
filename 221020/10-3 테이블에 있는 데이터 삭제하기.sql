---------------------------------
--10-3 테이블에 있는 데이터 삭제하기
---------------------------------
delete from boards
where bwriter='winter';

delete from members
where mid='winter';

delete from members
where mid in ('summer', 'fall');