drop table if exists board CASCADE;
create table board
(
        id   int generated by default as identity, --게시글 ID, DB내에서 자동생성
        title varchar(100), --게시글 제목
        contents varchar(1000), --게시글 내용
        writer varchar(30),--게시글 작성자
        created date default sysdate,  --작성 날짜, DB내에서 자동생성
        likes int, --좋아요 숫자
        views int, --조회수
        primary key (id) --id를 기본키로 설정
);

create table reply
(
        id int, --게시글 ID
        reply_id int, --댓글 ID
        content varchar(200), --댓글 내용
        writer varchar(30), --댓글 작성자
        created date, --생성일
        primary key (reply_id), --댓글 ID를 기본키로 설정
        foreign key (id) references board (id) --게시글 ID를 외래키값으로 설정
);


insert into board(title, contents, writer, likes) values ('안녕', '안녕', '예지', 0);
insert into board(title, contents, writer, likes) values ('안녕히', '계세요', '채령', 1);
insert into board(title, contents, writer, likes) values ('바이', '안녕', '류진', 3);
insert into board(title, contents, writer, likes) values ('안녕', '안녕', '소연', 5);

select * from board

select *
from board
order by id desc
offset (pageNum-1)*pageRow rows
fetch next pageRow rows only;