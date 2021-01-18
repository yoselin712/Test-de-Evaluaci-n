DROP TABLE IF EXISTS USUARIO;

CREATE TABLE USUARIO (
     id VARCHAR(36) PRIMARY KEY,
     name VARCHAR(250) NOT NULL,
     email VARCHAR(250) NOT NULL,
     password VARCHAR(15) DEFAULT NULL,
     created TIMESTAMP NULL,
     modified TIMESTAMP NULL,
     last_login TIMESTAMP NULL,
     token VARCHAR(360) NULL,
     isactive INT(1) NULL
);

DROP TABLE IF EXISTS PHONE;

CREATE TABLE PHONE (
      id VARCHAR(36) PRIMARY KEY,
      number VARCHAR(12) NOT NULL,
      citycode VARCHAR(3) NOT NULL,
      contrycode VARCHAR(3) NOT NULL,
      usuario_id VARCHAR(36),
      foreign key (usuario_id) references USUARIO(id)
);