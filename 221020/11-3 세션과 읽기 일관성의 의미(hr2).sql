----------------------------------
--11-3 세션과 읽기 일관성의 의미(hr2)
----------------------------------
update boards
set btitle = '수정제목2'
where bno=1;

select *
from boards
where bno =1;