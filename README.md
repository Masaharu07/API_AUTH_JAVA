# API de Autenticação — Cadastro e Login

API REST desenvolvida em Java + Spring Boot para cadastro e autenticação de usuários, utilizando PostgreSQL, Spring Security e criptografia de senha com BCrypt.

Este projeto foi criado com fins de estudo para compreender como funciona a autenticação em aplicações backend modernas.

---

## Tecnologias Utilizadas

- Java 21  
- Spring Boot  
- Spring Web  
- Spring Data JPA (Hibernate)  
- Spring Security  
- PostgreSQL  
- Maven  
- BCrypt (criptografia de senha)  

---

## Estrutura do Projeto


src/main/java/com/auth/api_auth_sozinho
│
├── config → Configurações do Spring e Segurança
├── controller → Endpoints da API
├── dtos → Objetos de transferência de dados (JSON)
├── model → Entidades JPA (tabelas do banco)
├── repository → Comunicação com o banco de dados
└── service → Regras de negócio da aplicação


---

## Configuração do Banco de Dados

Edite o arquivo `application.properties`:

properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/api_auth
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Como Executar o Projeto
1. Clonar o repositório
git clone https://github.com/seu-usuario/api-auth.git
2. Entrar na pasta do projeto
cd api-auth
3. Executar a aplicação
mvn spring-boot:run

A API estará disponível em:

http://localhost:8080
Endpoints da API
Cadastro de Usuário
`
POST /auth/register
`

Body (JSON)
`{
  "username": "Marcelo",
  "email": "marcelo@email.com",
  "password": "123123"
}`

Respostas:
201 Created → Usuário criado com sucesso

400 Bad Request → Dados inválidos

409 Conflict → Email ou username já cadastrado

Login
`
POST /auth/login
`

Body (JSON)
`{
  "email": "marcelo@email.com",
  "password": "123123"
}`

Resposta
`{
  "token": "uuid-gerado"
}`

Segurança:
Senhas armazenadas com BCrypt
Spring Security protege as rotas
Rotas públicas: /auth/**
Demais rotas podem ser protegidas com autenticação
Conceitos Praticados
Arquitetura em camadas (Controller, Service, Repository)
Autenticação de usuários
Criptografia de senha
Validação de dados
Integração com PostgreSQL
Configuração de segurança com Spring Security

Melhorias Futuras:
Implementar autenticação com JWT
Criar rotas protegidas por token
Sistema de permissões (ADMIN / USER)
Tratamento global de exceções
Testes automatizados
Dockerização da aplicação

Autor:
Marcelo Masaharu
São Vicente - SP
LinkedIn: https://www.linkedin.com/in/marcelo-masaharu-42720a37a
GitHub: https://github.com/Masaharu07




