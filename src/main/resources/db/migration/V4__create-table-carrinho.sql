create table carrinho (
id int auto_increment,
produto_id int not null,
usuario varchar(100) not null,
quantidade int not null,

primary key (id),
constraint fk_carrinho_produto_id foreign key (produto_id) references produtos(id)
);