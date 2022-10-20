-----------------------------------------
--11-3 세션과 읽기 일관성의 의미(hr),lock
-----------------------------------------
update boards
set btitle = '수정제목1'
where bno=1;
commit;

select *
from boards
where bno =1;