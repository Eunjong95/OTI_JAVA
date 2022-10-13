------------------------------------
--���� ����: Not Null
------------------------------------

drop table members;
create table members (
    mid varchar(20) not null,
    mname varchar(20) not null,
    mtel varchar(20) null
); 

insert into members (mid, mname, mtel) values ('winter', '�Ѱܿ�', '010-123-1234');
--�÷� ����Ʈ�� �����Ǹ�, DB�� �߰��� �÷� ������� ��� �÷��� ���� ����
insert into members values ('winter', '�Ѱܿ�', '010-123-1234');

--��������� null�� ����
insert into members (mid, mname, mtel) values ('winter', '�Ѱܿ�', null);
insert into members values ('winter', '�Ѱܿ�', null);
--�÷� ����Ʈ�� ���� �÷��� null�� �����
insert into members (mid, mname) values ('winter', '�Ѱܿ�');

--Not Null�� null�� ������ �� ����. 
update members set mid = null where mid = 'winter';