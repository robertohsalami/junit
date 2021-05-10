CREATE TABLE login_usuario (
    id int8 NOT NULL,
	username varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	name varchar(255) NOT NULL,
	admin BOOLEAN,
	created_At timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_At timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT loginusuario_pkey PRIMARY KEY (id)
);

insert into login_usuario(id, username, password, name, admin) values (1,  'rsalami', '$2a$10$KtkXk402fhrHgAFVvYXCBOGbgGTCGoU4..OrwD5O1YdfEKENAWswe', 'Roberto Henrique Salami', true);
insert into login_usuario(id, username, password, name, admin) values (2,  'toyo', '$2a$10$Q0dscWTwmKqrqIWLKmuWA.Dl1WEscOJl7mRAzGc8HOhv6OCsQCi1q', 'Shimazu Toyohisa', false);