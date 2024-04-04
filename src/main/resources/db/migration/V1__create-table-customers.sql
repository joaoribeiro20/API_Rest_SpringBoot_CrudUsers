create table customers(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(15) not null unique,
    type varchar(100) not null,
    identityCustomer varchar(100) not null,
    numberIdentity varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    cidade varchar(100) not null,

    primary key(id)

);