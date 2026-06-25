# Folha de Pagamento
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue)
![Maven](https://img.shields.io/badge/Maven-red)
![JUnit](https://img.shields.io/badge/JUnit-5-green)
![Mockito](https://img.shields.io/badge/Mockito-blue)
![JPA](https://img.shields.io/badge/JPA-gray)
![Thunder Client](https://img.shields.io/badge/Thunder%20Client-purple)
![Postbird](https://img.shields.io/badge/Postbird-blue)
## Descrição
[Sistema que simula e calcula com algumas regras de negócio como imposto e bônus, tratamento de erros e validações uma folha de pagamento de funcionários de uma empresa. Serve para aprimorar minhas habilidades em desenvolvimento back-end e banco de dados relacionais.](https://github.com/paulobigliardi/folha-pagamento.git)
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
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/folha_pagamento
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
### - Rodar o Projeto com Maven
Rodar o projeto com o comando /mvnw spring-boot:run para inicializar o sistema.
## Endpoints
### Funcionario
- GET /funcionarios — lista todos os funcionários
- POST /funcionarios — cadastra um funcionário
``` json
 {
  "nome": "João Silva",
  "salario": 2000.00
}
```
- PUT /funcionarios/{id} — atualiza um funcionário
``` json
 {
    "nome": "João Silva",
    "salario": 2200.00
}
```
- DELETE /funcionarios/{id} — deleta um funcionário
### Gerente
- GET /gerentes - lista todos os gerentes
- POST /gerentes - cadastra um novo gerente
```json
 {
    "nome": "Pietro Santos",
    "salario": 6000.00,
    "bonus": 1200.00
}
```
- PUT /gerentes/{id} - atualiza um gerente
``` json
 {
    "nome": "Pietro Santos",
    "salario": 6600.00,
    "bonus": 1400.00
}
```
- DELETE /gerentes/{id} - deleta um gerente
## Regras de Negócio
### Cálculo do INSS
O sistema calcula o desconto do INSS de forma progressiva, igual funciona na vida real. Antes eu tava usando um imposto fixo de 9% pra todo mundo, mas aí aprendi que o INSS tem faixas de alíquota que mudam conforme o salário. Agora o cálculo segue a tabela abaixo:

| Faixa Salarial           | Alíquota |
|--------------------------|----------|
| Até R$ 1.621,00          | 7,5%     |
| De R$ 1.621,01 a R$ 2.902,84 | 9%   |
| De R$ 2.902,85 a R$ 4.354,27 | 12%  |
| De R$ 4.354,28 a R$ 8.475,55 | 14%  |

Cada faixa é calculada separadamente e os valores são somados, igual o imposto de renda progressivo. O salário líquido é o salário bruto menos o total do INSS.

Para gerentes, o salário líquido também soma o bônus depois do desconto do INSS.

### Geração de ID
O ID dos funcionários agora é gerado usando uma sequence do PostgreSQL (`funcionario_id_seq`), o que garante que os IDs sejam únicos e não tenham buracos causados por estratégias automáticas do JPA.

### Formatação dos Campos Numéricos
Os campos `imposto` e `salarioLiquido` agora são retornados na resposta JSON sempre com duas casas decimais, usando a anotação `@JsonFormat`. Isso deixa a resposta mais legível e consistente.
