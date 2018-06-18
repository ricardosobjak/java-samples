﻿# vraptor-fullapp-jpa

Projeto exemplo de utilização do framework Vraptor.

## Tecnologias
Este projeto foi construído com base na seguintes tecnologias:
- Plataforma: JavaEE
- Framework: Vraptor
- Persistência: JPA com Eclipselink e driver para MariaDB
- Páginas: JSP com JSTL


## Servidor de aplicação
 O projeto está preparado para rodar no servidor de aplicação Tomcat 8.
 

## Modo de utilização
- Inicie um servidor de banco de dados MariaDB;
- Crie um banco de dados vazio denominado "test";
- Modifique as credenciais de acesso ao banco de dados no arquivo "persistence.xml";
 

## Recursos
A aplicação foi construída exemplifincando 3 conceitos de desenvolvimento: 
1. Páginas (view) seguindo o padrão do framework Vraptor;
2. Páginas (view) seguindo uma arquitetura REST;
3. API RESTful para consumir os dados em formatos JSON/XML.

## Acessandos as páginas da aplicação
### Acessando as páginas seguindo o padrão do Vraptor (br.edu.utfpr.webapp.vraptor.controller.PessoaController):
 --> /<app-name>/pessoa/list: mostra a listagem de pessoas cadastradas;
 --> /<app-name>/pessoa/form: formulário para cadastro e edição de pessoas.
 
 
### Acessando as páginas seguindo o padrão REST (br.edu.utfpr.webapp.vraptor.controller.Pessoa2Controller):
 --> /<app-name>/people: mostra a listagem de pessoas cadastradas;
 --> /<app-name>/people/<id>: formulário para edição de pessoas;
 --> /<app-name>/people/new: formulário para cadastro de pessoas.
 

### Acessando os dados pela API REST (br.edu.utfpr.webapp.vraptor.controller.api.PessoaController):
 --> /<app-name>/api/pessoa: retorna todas as pessoas cadastradas em formato JSON;
 --> /<app-name>/api/pessoa/<id>: retorna a pessoa identificada pelo id em formato JSON;

 

