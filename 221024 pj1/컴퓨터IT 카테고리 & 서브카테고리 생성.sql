------------------------------------------
--'컴퓨터/IT' 카테고리 & 서브 카테고리 생성
------------------------------------------

insert into category values (seq_categpry_no.nextval, '컴퓨터/IT');

insert into subcategory values (seq_sub_no.nextval, '컴퓨터공학', 6);
insert into subcategory values (seq_sub_no.nextval, '보안/해킹', 7);
insert into subcategory values (seq_sub_no.nextval, '데이터베이스', 8);
insert into subcategory values (seq_sub_no.nextval, '웹프로그래밍', 9);
insert into subcategory values (seq_sub_no.nextval, '모바일프로그래밍', 10);