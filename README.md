# Gerenciador de Tarefas

    Foi utilizado o bando de dados relacional Postgresql, script para criação do banco:
    
    CREATE DATABASE gerenciador_tarefas
      WITH ENCODING='UTF8'
           LC_COLLATE='Portuguese_Brazil.1252'
           LC_CTYPE='Portuguese_Brazil.1252'
           CONNECTION LIMIT=-1;
    
    CREATE TABLE public.tarefas
    (
       id bigserial, 
       descricao character varying(500) NOT NULL, 
       prioridade character varying(5) NOT NULL, 
       concluido boolean NOT NULL DEFAULT false, 
       CONSTRAINT pk_tarefas_id PRIMARY KEY (id)
    ) 
    WITH (
      OIDS = FALSE
    ); 
    
###Swagger

http://localhost:8080/swagger-ui/index.html