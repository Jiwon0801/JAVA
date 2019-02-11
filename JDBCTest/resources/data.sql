drop table goodsinfo;

create table goodsinfo(
	code char(5) not null,
	name varchar2(30) not null,
	price number not null,
	maker varchar2(20),
	primary key(code)
);

insert into goodsinfo(code, name, price, maker)
values('10001','디지털 TV',350000,'LG');

insert into goodsinfo(code, name, price, maker)
values('10002','DVD 플레이어',250000,'LG');

insert into goodsinfo(code, name, price, maker)
values('10003','디지털 카메라',210000,'삼성');

insert into goodsinfo(code, name, price, maker)
values('10004','전자사전',180000,'아이리버');

insert into goodsinfo(code, name, price, maker)
values('10005','벽걸이 에어컨',400000,'삼성');

commit

select * from goodsinfo;

drop table member;
create table member(
    user_id varchar2(10) constraint MEMBER_USER_ID_PK primary key,
    password varchar2(256),
    name varchar2(20 char),
    email varchar2(64),
    phone varchar2(20),
    address varchar2(100 char),
    reg_date date default sysdate,
    update_date date default sysdate
);



insert into member
select lower(email), '1234', last_name, lower(email) || '@naver.com',
    replace(phone_number,'.','-'), null, hire_date, sysdate
from hr.employees;


alter table member
add salt varchar2(16);

select * from member;

grant select on employees to autocar;


