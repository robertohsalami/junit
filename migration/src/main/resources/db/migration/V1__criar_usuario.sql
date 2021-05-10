CREATE TABLE usuario (
	id int8 NOT NULL,
	nome varchar(255) NOT NULL,
	cpf varchar(13) NOT NULL,
	idade integer NOT NULL,
	created_At timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_At timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

insert into usuario(id, nome, cpf, idade) values (1,  'Nataniel', 21132190056, 29);