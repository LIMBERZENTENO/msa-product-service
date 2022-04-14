create database evaluation

use evaluation

create table product(
id int identity(1,1)primary key not null,
name_product varchar(200) not null
)

create table order_product(
id int identity(1,1)primary key not null,
date_order datetime not null,
description varchar(200)
)

create table product_to_pedido(
id_product int  not null,
id_order_product int not null,
foreign key (id_product) references product(id),
foreign key (id_order_product) references order_product(id)
)