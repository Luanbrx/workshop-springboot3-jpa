# 🛒 workshop-springboot3-jpa

Sistema de **Web Services RESTful** construído com **Spring Boot 3**, implementando um modelo de domínio completo de e-commerce. O projeto segue a **Arquitetura em Camadas** clássica, priorizando produtividade e integração nativa com o ecossistema Spring.

---

## 📑 Sumário

- [Sobre o Projeto](#sobre-o-projeto)
- [Camadas Lógicas](#camadas-lógicas)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Modelo de Domínio](#modelo-de-domínio)
- [Como Começar](#como-começar)
- [Configuração do Banco de Dados](#configuração-do-banco-de-dados-render--postgresql)
- [Executando a Aplicação](#executando-a-aplicação)
- [Funcionalidades](#funcionalidades)
- [Endpoints da API](#endpoints-da-api)

---

## Sobre o Projeto

Este projeto foi desenvolvido como um workshop prático para aprendizado do **Spring Boot 3 com JPA/Hibernate**. Abrange o ciclo completo de uma API REST — desde o mapeamento de entidades e persistência de dados até o tratamento de exceções e o povoamento automático do banco de dados — usando um domínio de e-commerce como contexto de aprendizado.

---

## Camadas Lógicas

A aplicação é organizada nas seguintes camadas lógicas, com responsabilidades bem definidas:

```
┌─────────────────────────────────────────┐
│              Application                │
└────────────────────┬────────────────────┘
                     ↕
┌─────────────────────────────────────────┐
│     Resource Layer (REST Controllers)   │
└────────────────────┬────────────────────┘
                     ↓
┌───────────────────────────┐  ┌──────────┐
│       Service Layer       │  │          │
└────────────────┬──────────┘  │ Entities │
                 ↓             │          │
┌───────────────────────────┐  │          │
│  Data Access Layer        │  │          │
│  (Repositories)           │  └──────────┘
└───────────────────────────┘
```

| Camada | Responsabilidade |
|---|---|
| **Resource** | Expõe os endpoints REST e gerencia requisições/respostas HTTP |
| **Service** | Contém a lógica de negócio e orquestra as operações |
| **Data Access** | Gerencia o acesso aos dados via Spring Data JPA |
| **Entities** | Objetos de domínio mapeados diretamente às tabelas do banco via anotações JPA |

---

## Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| **Java 17** | Linguagem de programação |
| **Spring Boot 3** | Framework da aplicação |
| **Spring Data JPA / Hibernate** | ORM e acesso a dados |
| **Maven** | Gerenciamento de dependências e build |
| **H2 Database** | Banco em memória para o perfil `test` |
| **PostgreSQL** | Banco relacional para os perfis `dev` e produção, hospedado no Render |
| **Docker** | Containerização para deploy |
| **Postman** | Testes e documentação da API |

---

## Modelo de Domínio

O sistema implementa um modelo de domínio completo de e-commerce com as seguintes entidades e relacionamentos:

```
            *                    1..*
Category ───── Product ─────────────── OrderItem
                                           │
                                      quantity : Integer
                                      price : Double
                                      subTotal() : double
                                           │
          *               1..*            │
User ──────── Order ──────────────────────┘
              moment : Date
              orderStatus : OrderStatus
              total() : double
                  │
                0..1
                  │
              Payment
              moment : Date
```

### Entidades

| Entidade | Atributos principais | Descrição |
|---|---|---|
| **User** | id, name, email, phone, password | Clientes cadastrados no sistema |
| **Order** | id, moment, orderStatus | Pedidos realizados por um cliente |
| **OrderItem** | quantity, price, subTotal() | Itens de um pedido, vinculando Order e Product |
| **Product** | id, name, description, price, imgUrl | Produtos disponíveis para compra |
| **Category** | id, name | Categorias (relação muitos-para-muitos com Product) |
| **Payment** | id, moment | Registro de pagamento associado a um pedido |

### Enumeração `OrderStatus`

| Valor | Descrição |
|---|---|
| `WAITING_PAYMENT` | Aguardando pagamento |
| `PAID` | Pago |
| `SHIPPED` | Enviado |
| `DELIVERED` | Entregue |
| `CANCELED` | Cancelado |

---

## Como Começar

### Pré-requisitos

- Java 17+
- Maven 3.8+
- Docker (opcional, para deploy containerizado)
- Uma instância PostgreSQL (ou use o H2 em memória para testes)

### Clonar o Repositório

```bash
git clone https://github.com/Luanbrx/workshop-springboot3-jpa.git
cd workshop-springboot3-jpa
```

---

## Configuração do Banco de Dados (Render & PostgreSQL)

O projeto utiliza **perfis do Spring** para gerenciar diferentes ambientes:

| Perfil | Banco de Dados | Uso |
|---|---|---|
| `test` | H2 (em memória) | Testes unitários e de integração |
| `dev` | PostgreSQL (Render) | Desenvolvimento com banco remoto |

### Configurando o `application-dev.properties`

1. Crie uma instância de PostgreSQL no painel do [Render](https://render.com).
2. Copie suas credenciais (Hostname, nome do banco, usuário e senha).
3. Preencha o arquivo `src/main/resources/application-dev.properties`:

```properties
# Conexão PostgreSQL (Render)
spring.datasource.url=jdbc:postgresql://<SEU_HOSTNAME_RENDER>:5432/<NOME_DO_BANCO>
spring.datasource.username=<SEU_USUARIO>
spring.datasource.password=<SUA_SENHA>

# JPA / Hibernate
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# JWT
jwt.secret=MYJWTSECRET
jwt.expiration=3600000
```

> ⚠️ **Atenção:** Nunca faça commit das suas credenciais reais no controle de versão. Use o arquivo `application-dev.properties.example` como modelo e certifique-se de que `application-dev.properties` está listado no `.gitignore`.

### Configurando o `application-test.properties`

```properties
# H2 Em Memória
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
```

---

## Executando a Aplicação

### Com Maven (perfil dev)

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

### Com Docker

```bash
# Construir a imagem
docker build -t workshop-springboot3-jpa .

# Executar o container
docker run -p 8080:8080 workshop-springboot3-jpa
```

A aplicação estará disponível em `http://localhost:8080`.

---

## Funcionalidades

- ✅ **CRUD Completo** para a entidade `User` (Criar, Listar, Buscar, Atualizar, Deletar)
- ✅ **API REST em camadas** com códigos HTTP apropriados para cada situação
- ✅ **Tratamento de Exceções Personalizado** via `@ControllerAdvice` — ex: `ResourceNotFoundException` retorna 404, `DatabaseException` retorna 400
- ✅ **Database Seeding** — povoa o banco automaticamente ao iniciar nos perfis `dev` e `test` via classe de configuração (`TestConfig` / `DevConfig`)
- ✅ **Configuração Multi-perfil** — H2 para testes, PostgreSQL para desenvolvimento e produção
- ✅ **Deploy Containerizado** — Dockerfile funcional para ambientes containerizados

---

## Endpoints da API

Todos os endpoints podem ser testados utilizando o [Postman](https://www.postman.com/).

### Usuários (`/users`)

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/users` | Lista todos os usuários |
| `GET` | `/users/{id}` | Busca usuário por ID |
| `POST` | `/users` | Cria um novo usuário |
| `PUT` | `/users/{id}` | Atualiza um usuário |
| `DELETE` | `/users/{id}` | Remove um usuário |

### Pedidos (`/orders`)

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/orders` | Lista todos os pedidos |
| `GET` | `/orders/{id}` | Busca pedido por ID |

### Produtos (`/products`)

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/products` | Lista todos os produtos |
| `GET` | `/products/{id}` | Busca produto por ID |

### Categorias (`/categories`)

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/categories` | Lista todas as categorias |
| `GET` | `/categories/{id}` | Busca categoria por ID |

> Desenvolvido com ☕ Java e 💚 Spring Boot
