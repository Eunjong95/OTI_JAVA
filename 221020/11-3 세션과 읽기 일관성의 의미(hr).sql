-----------------------------------------
--11-3 ���ǰ� �б� �ϰ����� �ǹ�(hr),lock
-----------------------------------------
update boards
set btitle = '��������1'
where bno=1;
commit;

select *
from boards
where bno =1;