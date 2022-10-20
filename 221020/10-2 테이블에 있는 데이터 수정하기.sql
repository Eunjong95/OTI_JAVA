---------------------------------
--10-2 테이블에 있는 데이터 수정하기
---------------------------------
update members 
set memail='ice@mycompany.com', mage=mage+1, mtel='010-321-4321'
where mid='winter';

update boards set bwriter=(select mid from members where memail='ice@mycompany.com')
where bwriter='winter';