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
	ID_SERVER  SERIAL PRIMARY KEY,
	HOSTNAME		VARCHAR(128)	          NOT NULL,
	HOSTPORT		INT  DEFAULT 80           NOT NULL,
	URLPATH			VARCHAR(128) DEFAULT '/'  NOT NULL,
	RESPONSE_HOST   TEXT,
	LAST_CHECK 		TIMESTAMP,
	CREATED		    TIMESTAMP   		      NOT NULL,
	ACTIVE	        BOOLEAN                   NOT NULL,
	STATE			STATE_TYPE				  NOT NULL,
	IP_ADRESS		VARCHAR(128)			  NOT NULL
	
);

CREATE TABLE employee (
	ID_EMPLOYEE  SERIAL PRIMARY KEY,
		NAME           VARCHAR(128)      NOT NULL,
	    LOGIN          VARCHAR(16)       NOT NULL,
	    PASSWORD       VARCHAR(16)		 NOT NULL,
	    EMAIL		   VARCHAR(64)       NOT NULL,
	    CREATED		   TIMESTAMP   		 NOT NULL,
	    LAST_LOGIN	   TIMESTAMP,
	    ACTIVE	       BOOLEAN           NOT NULL,
	    ADMIN	       BOOLEAN           NOT NULL
   
);
CREATE TABLE employeeLists(
    ID_EMPLOYEE INTEGER REFERENCES employee ON DELETE CASCADE,
    ID_SERVER INTEGER REFERENCES server ON DELETE CASCADE,
    PRIMARY KEY (ID_EMPLOYEE, ID_SERVER)
);

INSERT INTO employee (NAME, LOGIN, PASSWORD, EMAIL, CREATED, LAST_LOGIN, ACTIVE, ADMIN)
    VALUES ('Vasya', 'ytug', 'ttttsle', 'ytug@mail.ru', '1994-11-29', '2014-03-20', true, true);
    
INSERT INTO server (HOSTNAME, RESPONSE_HOST, LAST_CHECK, CREATED, ACTIVE, STATE, IP_ADRESS )
    VALUES ('ya.ru', 'good', '2014-03-19', '2014-03-01', true, 'OK', '10.12.12.1');  
      
 INSERT INTO employeeLists (ID_EMPLOYEE, ID_SERVER) 	
 	VALUES (2,2);  
 	
DELETE FROM server WHERE ID_SERVER = 1; 	  