--------------------------------
--13-2 �� ���� �˻��� ���� �ε���
--------------------------------
--���� �˻��� ����
select * from members where mname like '%�浿%';
--�ε��� ����
create index ix_member_mname
on members(mname);

select * from members where mtel like'%1234%' and mcity = '����';
--���� �ε��� ����
create index ix_member_mtel_mcity
on members (mtel, mcity); --�� �̸� �ڿ� asc �Ǵ� desc ���̱� ����

--�ε��� ����
drop index ix_member_mtel_mcity;