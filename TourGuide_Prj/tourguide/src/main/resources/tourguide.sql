drop table tourguide;

create table tourguide(
	num	number primary key,
	name varchar2(100 char),
	region varchar2(100 char),
	city varchar2(256 char),
	content varchar2(1000 char),
	address varchar2(256 char),
	homepage varchar2(512)
);

drop sequence tourguide_seq;
create sequence tourguide_seq;

select * from tourguide;
-- num, name, region, city, content, address, homepage

delete  from tourguide
where num >100;
commit