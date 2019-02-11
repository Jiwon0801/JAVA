drop table sensor;

create table sensor (
	sensor_id number primary key,
	sensor_type varchar2(20),
	value number,
	regDate date default sysdate,
	owner varchar2(30),
	place varchar2(30)
);

drop sequence sensor_seq;
create sequence sensor_seq;

select * from sensor;

insert into sensor(	sensor_id, sensor_type, value, owner, place )
		values(sensor_seq.nextval, 'temp', 10,
				'a', 'a');