# Folha de Pagamento
## Descrição
[Sistema que simula e calcula com algumas regras de negócio como imposto e bonus, tratamento de erros e validações uma folha de pagamento de funcionários de uma empresa. Serve para aprimorar minhas habilidades em desenvolvimento back-end e banco de dados relacionais.](https://github.com/paulobigliardi/folha-pagamento.git)
## Tecnologias
- Java 21
- Spring Boot 
- JPA 
- Postgres
## Ferramentas
- Maven
- Thunder Client 
- Postbird
- Git
## Testes 
- JUnit
- Mockito
## Como Rodar Localmente
### Pré-requisitos
- Java
- Maven
- Spring Boot
- PostgreSQL
### - Criar Banco de Dados
Utilizando o Postbird criar um banco de dados com o nome folha_pagamento e criar com CREATE DATABASE folha_pagamento para a empresa, utilizando Funcionarios e Gerentes.
### - Configurar as credenciais do Banco de Dados 
No application.properties criar as credenciais spring.datasource.url, spring.datasource.username e spring.datasource.password, para garantir a segurança do banco de dados no projeto.
### - Rodar o Projeto com Maven
Rodar o projeto com o comando /mvnw spring-boot:run para inicializar o sistema.
## Endpoints
### Funcionario
- GET /funcionarios — lista todos os funcionários
- POST /funcionarios — cadastra um funcionário
- PUT /funcionarios/{id} — atualiza um funcionário 
- DELETE /funcionarios/{id} — deleta um funcionário
### Gerente
- GET /gerentes - lista todos os gerentes
- POST /gerentes - cadastra um novo gerente
- PUT /gerentes/{id} - atualiza um gerente
- DELETE /gerentes/{id} - deleta um gerente