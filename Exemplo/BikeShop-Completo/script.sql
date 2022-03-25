create schema bikeshop2;

use bikeshop2;

CREATE TABLE marca (
  codmarca int NOT NULL AUTO_INCREMENT,
  nomemarca varchar(45),
  PRIMARY KEY (codmarca)
);

CREATE TABLE bike (
  codbike int NOT NULL AUTO_INCREMENT,
  modelo varchar(45),
  codmarca int not null,
  preco decimal(10,2),
  imagem longblob,
  PRIMARY KEY (codbike),
  FOREIGN KEY (codmarca) REFERENCES marca (codmarca)
);

CREATE TABLE usuario (
  codusuario int NOT NULL AUTO_INCREMENT,
  nomeusuario varchar(50),
  login varchar(40),
  senha varchar(40),
  email varchar(60),
  tipo tinyint COMMENT '1 -> admin\n0 -> usuario comun',
  PRIMARY KEY (codusuario)
);


INSERT INTO marca 
VALUES (1,'Scott'),
       (2,'Caloi'),
       (3,'Groove'),
       (4,'Merida');
INSERT INTO bike 
	VALUES (2,'Riff 70',3,6500.00,NULL),
           (3,'Strada',2,2500.00,NULL),
           (4,'Explorer 30',2,3600.00,NULL),
           (5,'Spark RC 900 SL',1,69999.00,NULL),
           (8,'Warp Tri 5000 Carbon',4,12999.00,NULL),
           (10,'Caloi Ceci',2,1200.00,NULL),
           (11,'Explorer 10',2,2500.00,NULL),
           (16,'XL',2,10.00,NULL);
INSERT INTO usuario 
	VALUES (1,'Fernando Herrmann','herrmann','1234','fernandoherrmann@ifsul.edu.br',1);
