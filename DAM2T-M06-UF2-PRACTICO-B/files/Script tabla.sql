#drop schema StucomDam2t;
create schema StucomDam2t;
use StucomDam2t;

create table StucomDam2t.Entrada (
	id int auto_increment primary key,
    entrada varchar(100)
);

insert into StucomDam2t.Entrada (entrada) values ('X Pino Europa');
insert into StucomDam2t.Entrada (entrada) values ('X Roble Europa');
insert into StucomDam2t.Entrada (entrada) values ('X Nogal USA');
insert into StucomDam2t.Entrada (entrada) values ('X Nogal Asia');
insert into StucomDam2t.Entrada (entrada) values ('X Pino USA');
insert into StucomDam2t.Entrada (entrada) values ('S FJÄLLBO');
insert into StucomDam2t.Entrada (entrada) values ('M Estanteria 1 1');
insert into StucomDam2t.Entrada (entrada) values ('M Vitrina 2 1');
insert into StucomDam2t.Entrada (entrada) values ('M Escritorio 1 1');
insert into StucomDam2t.Entrada (entrada) values ('S BESTA');
insert into StucomDam2t.Entrada (entrada) values ('M Escritorio 2 2');
insert into StucomDam2t.Entrada (entrada) values ('M Mueblebar 3 2');