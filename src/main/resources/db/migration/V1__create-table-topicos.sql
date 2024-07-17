create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(100) not null unique,
    data_de_criacao varchar(100) not null,
    estado_do_topico varchar(100) not null,
    autor varchar(100) not null,
    curso varchar(100) not null,

    primary key(id)
);