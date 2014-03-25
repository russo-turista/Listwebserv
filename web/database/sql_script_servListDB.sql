
DROP DATABASE  IF EXISTS ServListDB;

CREATE DATABASE "ServListDB";
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;
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
	ID_USER  SERIAL PRIMARY KEY,
		NAME           VARCHAR(128)      NOT NULL,
	    LOGIN          VARCHAR(16)       NOT NULL,
	    PASSWORD       VARCHAR(16)		 NOT NULL,
	    EMAIL		   VARCHAR(64)       NOT NULL,
	    CREATED		   TIMESTAMP   		 NOT NULL,
	    LAST_LOGIN	   TIMESTAMP,
	    ACTIVE	       BOOLEAN           NOT NULL,
	    ADMIN	       BOOLEAN           NOT NULL
   
);

--------------------
INSERT INTO server (HOSTNAME, RESPONSE_HOST, LAST_CHECK, CREATED,
ACTIVE, STATE, IP_ADRESS)
    VALUES ('ya.ru', 'good', '2001-11-29, '1994-11-29', true, 'OK', '123.16.30.10');
