--------------------------------------
--13-4 규칙에 따라 순번을 생성하는 시퀀스
--------------------------------------
drop table boards;

create table boards (
    bno number primary key,
    btitle varchar(100) not null,
    bcontent clob not null
);

--Sequence 생성
create sequence seq_boards_bno;

select seq_boards_bno.nextval from dual;
select seq_boards_bno.currval from dual;

insert into boards values(seq_boards_bno.nextval, '제목', '내용');
select * from boards;