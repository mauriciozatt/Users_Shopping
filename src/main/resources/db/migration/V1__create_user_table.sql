CREATE TABLE USERS(
ID BIGINT PRIMARY KEY,
NOME VARCHAR(100) NOT NULL,
CPF VARCHAR(100) NOT NULL, 
ENDERECO VARCHAR(100) NOT NULL, 
EMAIL VARCHAR(100) NOT NULL, 
TELEFONE VARCHAR(100) NOT NULL, 
DATA_CADASTRO TIMESTAMP NOT NULL
)