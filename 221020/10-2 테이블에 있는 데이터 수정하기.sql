---------------------------------
--10-2 ���̺� �ִ� ������ �����ϱ�
---------------------------------
update members 
set memail='ice@mycompany.com', mage=mage+1, mtel='010-321-4321'
where mid='winter';

update boards set bwriter=(select mid from members where memail='ice@mycompany.com')
where bwriter='winter';