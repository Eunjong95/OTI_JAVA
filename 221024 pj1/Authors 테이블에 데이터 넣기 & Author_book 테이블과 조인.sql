----------------------------------------------------------
--Authors ���̺� ������ �ֱ� & Author_book ���̺�� ����
----------------------------------------------------------
insert into authors values(seq_author_no.nextval, 'Ÿ���ͽ� ���ͽ�', '���ۿ� 2010�⿡ �շ��� ���� ����Ʈ���� �����Ͼ�. ������ C++ ǥ�� ���̺귯���� �����ϴ� �۷ι� ������ȸ �������̸�, ���ۿ����� �Ŵ� 12,000���� �����Ͼ �����ϴ� 2�� 5õ�� ������ �ڵ�� �̷���� C++ �ڵ庣�̽��� ���̺귯�� ������ �ð� �ֽ��ϴ�. ���� 7�� ������ �ֽ� �ڵ�ȭ �� ������ ����Ͽ� ���� C++ �ڵ庣�̽��� �⺻ ������ҵ��� �籸��, ��������, �����ϴ� ���� �̲������ϴ�. �� �������� ����� ���� ū �����͸� 10�� �ȿ� �鸸�� ���� ������Ʈ�� �����߽��ϴ�.');
insert into authors values(seq_author_no.nextval, '�� �ǽ���', '���ۿ��� 2005����� ����Ʈ���� �����Ͼ �κ� ��ũƼ�� �����ͷ� �ٹ��ϸ� ������� �� ���� �ֿ� ���α׷��� ���̵带 �ۼ��ϰ� �����ϴ� ������ ����߽��ϴ�. 2011����ʹ� ���� C++ ���̺귯������ �շ��Ͽ� ���� C++ �����ڷḦ �����, (Ÿ���ͽ��� �Բ�) ���� C++ ���� Ŭ������ ��Ī������, ������ ���� �ҽ� C++ �ڵ��� Abseil�� ����ȭ�� �����߽��ϴ�. �Ż��߼��� �������б����� ��ġ�� �л�� ���� �л縦 �޾ҽ��ϴ�. ���ۿ� �շ��ϱ� ������ �Ǿ, ����Ƽ�� Ȧ, �پ��� ��ŸƮ������ ���������� �ٹ��߾����ϴ�.');
insert into authors values(seq_author_no.nextval, '���̷� ����Ʈ', '���ۿ� 2012�⿡ �շ��� ����Ʈ���� �����Ͼ�. ���� C++ �ڵ庣�̽��� ��Ը� �������� ������ ����߽��ϴ�. ���� ���翡�� ���� �ڵ庣�̽��� ���� ���� ������ ������� �ղ����� ������ �ڵ� ���� ���� �׷��� �̲��� �ֽ��ϴ�. �ػ罺 ���б����� ����Ʈ���� �����Ͼ �ڻ� ������ �޾Ұ� ī�ױ� ��� ���б����� ������ �湮 ������ ���� ���Դϴ�. ���۷��� ����� Ȱ���� Ȱ���ϸ� ����Ʈ���� �������� �� ��ȭ ���� �м� ������ ������ ����մϴ�.');
select book_no from books where book_name = '���� �����Ͼ�� �̷��� ���Ѵ�';
select author_no from authors where author_name = 'Ÿ���ͽ� ���ͽ�';
select author_no from authors where author_name = '�� �ǽ���';
select author_no from authors where author_name = '���̷� ����Ʈ';
insert into author_book values(17, 28);
insert into author_book values(18, 28);
insert into author_book values(19, 28);

insert into authors values(seq_author_no.nextval, '���ؼ�', '�������� ���������� ���� �Ŀ� �ٰ� �ڵ带 �а� ���� ���� �ߴ�. ������ ML GDE(Machine Learning Google Developer Expert)�� Ȱ���ϰ� �ְ�, �ӽŷ��װ� �����׿� ���� å�� �����ϰ� �����ϸ鼭 ����Ʈ����� ������ ��踦 ��̷Ӱ� Ž���ϰ� �ִ�.
������� �ӽŷ��� 2�ǡ�(�Ѻ��̵��, 2020)�� �����ؼ� ���� ���� �ӽŷ���, ������ å�� �츮���� �Ű�� ��Do it! ������ �Թ���(�������ۺ���, 2019)�� �����ߴ�.
https://tensorflow.blog');
select book_no from books where book_name = 'ȥ�� �����ϴ� �ӽŷ���+������';
select author_no from authors where author_name = '���ؼ�';
insert into author_book values(24, 48);

insert into authors values(seq_author_no.nextval, 'Behrouz', 'Behrouz�� ���� ������ �����̸� ��ǻ�� ���� �ý��� ���� ���߿� �����ߴ�. ���� ���� ȸ�翡 �ý��� ���� �����õ� �����ϰ� �ִ�. C�� C++ ���� �ܿ��� ��ǻ�� ��Ʈ��ũ(Top-Down Approach, TCP / IP Protocol Suite �� Local Area Networks)�� ����� �پ��� ������ �����ߴ�.');
select book_no from books where book_name = '��ȣ�а� ��Ʈ��ũ ����';
select author_no from authors where author_name = 'Behrouz';
insert into author_book values(27, 29);

insert into authors values(seq_author_no.nextval, '���� �Ƶ��ε�', '���ͳݿ��� �� ������ ���� ���� �α� �ִ� ���� �Ʒ� �ڿ� �� �ϳ��� hacksplaining.com�� �������. ���� ȸ��� ��ŸƮ���� ���� �ڵ带 �ۼ��߰�, ���� �̲����� ������ �������� ���� ������� ��ȣ�ϴ� ����� �����ϰ� �����ϱ� ���� Ʃ�丮��� �����ߴ�.');
select book_no from books where book_name = '�� �����ڸ� ���� �� ����';
select author_no from authors where author_name = '���� �Ƶ��ε�';
insert into author_book values(29, 30);

insert into authors values(seq_author_no.nextval, '��ȣ��', '�����δ� ����ó������縦 ���� IT ��� �����ý���, ����ó������� ��������(���� �����ȸ���� ��õ�ϴ�), ����ó������� ������ ������ �Ŵ�����Ʈ, ����ó������� ���⹮�� �ؼ���, ����ó������� ��86ȸ ���⹮�� �ؼ���, ����ó������� �հ�������, ����ó������� �ٽɹ��� �ؼ��� 1��, ����ó������� �ٽɹ��� �ؼ��� 2��, �����ý��۰����� �հ�������, �����ý��۰����� ���⹮�� �ؼ���, Advanced Oracle Database Ȱ��� Ʃ��, ���� �����ͺ��̽� ���� �����, CEO�� �������� IT�� �ٶ��� ���� �ִ�.');
insert into authors values(seq_author_no.nextval, '������', '�Ѿ翩�ڴ��б� ����Ʈ IT�� ����, ���йڻ��.');
insert into authors values(seq_author_no.nextval, '������', '��ǥ������ ��2022 �̱��� ADsP �����ͺм� ������������/�� �ִ�.');
select book_no from books where book_name = '�̱��� SQL ������ �̷м�+���⹮��';
select author_no from authors where author_name = '��ȣ��';
select author_no from authors where author_name = '������';
select author_no from authors where author_name = '������';
insert into author_book values(34, 31);
insert into author_book values(35, 31);
insert into author_book values(36, 31);

insert into authors values(seq_author_no.nextval,'������', '�����Ŵ뿡�� ��ǻ�Ͱ����� ���������� ���� ������ ����̴�. DB Ʃ��, ������ ��Ʈ ����, ���� �𵨸� �� ������ ������Ʈ�� ���������� �̲� ������ ����ȸ���Ʈ��. �ǹ��� �ƴ϶� ���� ���� Ư���� ��� Ư���� ���� �Ƿ��� ������ �������� �����ް� �ִ�. ���̹� ī�� �������Ϳ� ����顯���� ��Į���������̶�� �̸����� Ʃ�� ���ǿ� ���� ����� �Ͽ� �ҵ�κ��� ����ް� �ִ�.');
select book_no from books where book_name = '����Ŭ Ʃ�� ������';
select author_no from authors where author_name = '������';
insert into author_book values(39, 32);

insert into authors values(seq_author_no.nextval, '�����', '���ڴ� 2010�� ��Do it! HTML5 + CSS3�� �Ⱓ ���� ������ HTML5 ���Ǹ� �ؿԴ�. ��Ÿ���� HTML �������� ���ڴ� �� ��â����� ASP�� JAVA �� ���� ������ �����ϸ鼭 �� ����� ������ ������ �����ߴ�. ���� HTML�� DHTML(Dynamic HTML), CSS, JavaScript �� �� ���� ����� �� �� ���� ���� �� �ִ� ���� 60�� ���� �����ߴ�. ���� ����ũ�μ���Ʈ ���� �ְ� �����(Microsoft Most Valuable Professional)�� Ȱ�� �ϰ� �ִ�.');
select book_no from books where book_name = 'Do it! HTML+CSS+�ڹٽ�ũ��Ʈ �� ǥ���� ����';
select author_no from authors where author_name = '�����';
insert into author_book values(44, 33);

insert into authors values(seq_author_no.nextval, '������', '�ＺSDS���� ������ �����Ͼ� �� �鿣�� �����ڷ� �ٹ�������, ����� �����ѻ�󿡼� ���� �ý��� ���� ������ ����ϰ� �ֽ��ϴ�. �׸��� ��Ʃ�� ���������� ��Ʃ������� ��ϸ鼭 ���α׷��� ������ �����ϰ� �ֽ��ϴ�.');
select book_no from books where book_name = '������ ��Ʈ �ٽ� ���̵�';
select author_no from authors where author_name = '������';
insert into author_book values(47, 34);

insert into authors values(seq_author_no.nextval, '�質��', '�̸�Ƽ�� �۰�. ��⿹������б� ��ȭâ�۰�, ���������������б� ���������ΰ��� ��ġ�� �׸����� ���� �̾��. ���� �� �׷��� �����̳ʷ� ���� �ϴٰ� ���� �۰��� �Ǳ� ���� ������ ��縦 �����ߴ�. ���� �۰� �غ� �� �쿬�� ��ȸ�� ������ �̸�Ƽ�� ������ ��2�� �λ��� �����־���.
ģ���� �׸�ü�� ���� ���� ������ ����ϴ� �̸�Ƽ�ܸ��� �Ѱᰰ�� �α⸦ ������ �ִ�. ���� 6�Ⱓ �����ϸ� ���� �̸�Ƽ�� ���� ���Ͽ츦 ���� ���� �����ϰ��� ���ʿ� ������. ���� ���ǳ� ��� ���� ���� Ȱ�� ������ ������ �ִ� ���̴�.');
select book_no from books where book_name = '������ �� ���� īī�� �̸�Ƽ�� �����';
select author_no from authors where author_name = '�質��';
insert into author_book values(59, 38);

insert into authors values(seq_author_no.nextval, '�����', '������ ������ ��̰� ��վ�� �Ѵٴ� ������ ���� �ִ� �������̸�, IT ����� ����ġ�� ���� ������ �����ϴ� �������̴�. ����, ����ڸ� �ູ�ϰ� ����� ���񽺸� ����� ���� ���� �߿��ϴٰ� �����. ���� ����(��)���� �ִϸ��̼� ��Ʈ���� ���� ������(laftel.net)�� ����Ʈ���� ������ �ϰ� �ִ�. �׸��� �����ڵ��� ��α� ������ ���α�(velog.io)�� � �� �����ϰ� �ִ�.');
select book_no from books where book_name = '����Ʈ ����Ƽ�긦 �ٷ�� ���';
select author_no from authors where author_name = '�����';
insert into author_book values(60, 36);

commit;