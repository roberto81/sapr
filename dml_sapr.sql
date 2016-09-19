CREATE DATABASE IF NOT EXISTS saprsystem;

USE saprsystem;


/*
  DEFINIZIONI DELLE TABELLE NECESSARIE PER LA MEMORIZZAZIONE DEGLI UTENTI
*/

/* definisce la tabella per la memorizzazione degli utenti */
CREATE  TABLE users (
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  age int NOT NULL,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

/* definisce la tabella per i ruoli degli utenti */
CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

/* definisce la tabella per i droni */
CREATE TABLE IF NOT EXISTS drone(
  code varchar(40) NOT NULL,
  brand varchar(40) NOT NULL,
  model varchar(40) NOT NULL,
  number_rotors int(11) NOT NULL,
  engine_power varchar(40) NOT NULL,
  weight float NOT NULL,
  PRIMARY KEY (code)
);

/*
  SEZIONE DEDICATA AGLI INSERIMENTI
*/

/* utenti*/
INSERT INTO users(first_name,last_name,age,username,password,enabled)
VALUES ('roberto','pallotta',35,'roberto01','pallotta', true);
INSERT INTO users(first_name,last_name,age,username,password,enabled)
VALUES ('michela','sellitto',29,'michela01','sellitto', true);
INSERT INTO users(first_name,last_name,age,username,password,enabled)
VALUES ('francesca','pallotta',37,'francesca01','pallotta', true);
INSERT INTO users(first_name,last_name,age,username,password,enabled)
VALUES ('anna','ranghella',61,'anna01','ranghella', true);


INSERT INTO user_roles (username, role)
VALUES ('roberto01', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('michela01', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('francesca01', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('anna01', 'ROLE_USER');

/*droni*/
INSERT INTO drone(code,brand,model,number_rotors,engine_power,weight)
VALUES ('SP01','pluto','ARP1234',4,'batery',1.2);
INSERT INTO drone(code,brand,model,number_rotors,engine_power,weight)
VALUES ('SP02','pippo','123ASP2',3,'batery',2.0);
INSERT INTO drone(code,brand,model,number_rotors,engine_power,weight)
VALUES ('SPD01','chip','CHIPDR435',6,'batery',1);

