# Workshop Spring Boot & JPA/Hibernate

[cite_start]Este projeto é um sistema de **Web Services** construído com **Spring Boot**, focado em um modelo de domínio de e-commerce[cite: 4, 7]. [cite_start]A estrutura segue o padrão de **Arquitetura em Camadas (Layered Architecture)**[cite: 8, 122], priorizando a produtividade e a integração nativa com o ecossistema Spring.

[cite_start]Link do repositório base: [workshop-springboot3-jpa](https://github.com/acenelio/workshop-springboot3-jpa)[cite: 13].

## 🏗️ Arquitetura do Projeto

[cite_start]Embora o projeto seja organizado, ele utiliza a **Arquitetura em Camadas** tradicional em vez de uma Clean Architecture pura[cite: 8, 122]. As principais características são:

* [cite_start]**Camadas Lógicas**: Separação clara entre Resource (Controllers), Service e Repository[cite: 8, 122].
* [cite_start]**Acoplamento Pragmático**: As entidades de domínio utilizam anotações JPA para mapeamento direto ao banco de dados[cite: 149].
* [cite_start]**Fluxo de Dados**: Utilização das entidades para o tráfego de informações entre as camadas de persistência e a camada REST[cite: 124, 126, 127].



## 🚀 Tecnologias Utilizadas

* [cite_start]**Linguagem**: Java 17[cite: 363].
* [cite_start]**Framework**: Spring Boot[cite: 14].
* [cite_start]**Acesso a Dados**: JPA / Hibernate[cite: 4].
* [cite_start]**Gerenciamento de Dependências**: Maven[cite: 15].
* **Bancos de Dados**:
    * [cite_start]**H2**: Utilizado para o perfil de testes (`test`) com banco em memória[cite: 9, 16].
    * [cite_start]**PostgreSQL**: Utilizado para o ambiente de desenvolvimento/produção, hospedado no **Render**[cite: 17].
* [cite_start]**Testes de API**: Postman[cite: 19].

## 📊 Modelo de Domínio

[cite_start]O sistema implementa um modelo de domínio robusto para e-commerce[cite: 21]:
* [cite_start]**User**: Cadastro de clientes (Nome, Email, Telefone, Senha)[cite: 44, 46, 47, 48, 49].
* [cite_start]**Order**: Pedidos realizados, vinculados a um status (`OrderStatus`)[cite: 36, 37, 54].
* [cite_start]**Product & Category**: Relacionamento muitos-para-muitos entre produtos e suas categorias[cite: 22, 32, 219].
* [cite_start]**Payment**: Registro de pagamentos associados aos pedidos[cite: 51, 230].



