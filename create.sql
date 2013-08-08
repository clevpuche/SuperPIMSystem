
create table Anotacao(
id int identity Primary key,
titulo varchar,
conteudo varchar
);

create table Compromisso(
id int identity Primary key,
data Date,
hora varchar,
localidade varchar,
detalhes varchar,
notificacao boolean,
fuiNotificadoVespera boolean,
fuiNotificadoDia boolean
);

create table Contato(
id int identity Primary key,
nome varchar,
DDD Integer,
tel varchar,
cel varchar,
msn varchar,
skype varchar,
estado varchar,
cidade varchar,
bairro varchar,
endereco varchar,
site varchar,
informacoesAdd varchar,
email varchar
);

create table Receita(
id int identity Primary key,
nomeDaReceita varchar,
ModoDePreparo varchar,
categoria varchar,
ingredientes varchar
);

create table Senha(
id int identity Primary key,
usuario varchar,
senha varchar,
comentario varchar
);

create table Uteis(
 id int identity Primary key,
 descricao varchar,
 tel varchar
);

create table DadosPessoais(
id int primary key,
nome varchar,
email varchar
);