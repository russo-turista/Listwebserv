
DROP DATABASE  IF EXISTS ServListDB;

CREATE DATABASE "ServListDB";
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE servList (hostName TEXT, hostInfo TEXT);
