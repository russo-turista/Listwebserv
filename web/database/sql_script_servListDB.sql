-------------------
DROP DATABASE  IF EXISTS ServListDB;
---------------------------
CREATE DATABASE ServListDB
       OWNER  postgres
       ENCODING  'UTF8'
       TABLESPACE  pg_default
       CONNECTION LIMIT  -1;
----------------------------
CREATE TYPE STATE_TYPE AS ENUM ('OK', 'WARN', 'FAIL');
CREATE TABLE server (
	idServer  SERIAL PRIMARY KEY,
	hostName		VARCHAR(128)	          NOT NULL UNIQUE,
	hostPort		INT  DEFAULT 80           NOT NULL,
	urlPath			VARCHAR(128) DEFAULT '/'  NOT NULL,
	lastCheck 		TIMESTAMP,
	created		    TIMESTAMP   		      NOT NULL,
	active	        BOOLEAN                   NOT NULL,
	state			STATE_TYPE				  NOT NULL,
	response			TEXT,
	ipAddress		VARCHAR(128)			  NOT NULL

);

CREATE TABLE users (
		idUser  SERIAL PRIMARY KEY,
		name           VARCHAR(128)      NOT NULL,
	    login          VARCHAR(16)       NOT NULL UNIQUE,
	    password       VARCHAR(64)		 NOT NULL,
	    email		   VARCHAR(64)       NOT NULL,
	    created		   TIMESTAMP   		 NOT NULL,
	    lastLogin	   TIMESTAMP,
	    active	       BOOLEAN           NOT NULL,
	    admin	       BOOLEAN           NOT NULL

);
CREATE TABLE userLists(
	    idUser INTEGER REFERENCES users ON DELETE CASCADE,
	    idServer INTEGER REFERENCES server ON DELETE CASCADE,
	    PRIMARY KEY (idUser, idServer)
);
CREATE TABLE config(
		timeRequest                     INTEGER,
		timeOutWaiting 					INTEGER,
		timeUpdate 						INTEGER,
		addressSMTP 					VARCHAR(128),
		portSMTP 						INTEGER DEFAULT 25
);
INSERT INTO users (NAME, LOGIN, PASSWORD, EMAIL, CREATED, LASTLOGIN, ACTIVE, ADMIN)
    VALUES ('admin', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'admin@mail.ru', '1994-11-29', '2014-03-20', true, true);
    

INSERT INTO server (HOSTNAME, RESPONSEHOST, LASTCHECK, CREATED, ACTIVE, STATE, IPADDRESS )
    VALUES ('ya.ru', 'good', '2014-03-19', '2014-03-01', true, 'OK', '10.12.12.1');

 INSERT INTO employeeLists (ID_EMPLOYEE, ID_SERVER)
 	VALUES (2,2);
DELETE FROM server WHERE ID_SERVER = 1;