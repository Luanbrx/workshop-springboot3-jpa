workshop-springboot3-jpa

Este projeto é um sistema de Web Services construído com Spring Boot, focado em um modelo de domínio de e-commerce. A estrutura segue o padrão de Arquitetura em Camadas (Layered Architecture), priorizando a produtividade e a integração nativa com o ecossistema Spring.

🏗️ Arquitetura do Projeto

O projeto utiliza a Arquitetura em Camadas tradicional. Esta escolha permite um desenvolvimento ágil e uma separação clara de responsabilidades:

Camadas Lógicas: Divisão estruturada entre Resource (Controllers), Service e Repository.

Acoplamento Pragmático: As entidades de domínio utilizam anotações JPA para mapeamento direto ao banco de dados, otimizando a persistência.

Fluxo de Dados: Utilização das entidades para o tráfego de informações entre as camadas de persistência e a camada REST.

🚀 Tecnologias Utilizadas

Linguagem: Java 17.

Framework: Spring Boot.

Acesso a Dados: JPA / Hibernate.

Gerenciamento de Dependências: Maven.

Bancos de Dados:

H2: Utilizado para o perfil de testes (test) com banco em memória.

PostgreSQL: Utilizado para o ambiente de desenvolvimento e produção, hospedado no Render.

Testes de API: Postman.

📊 Modelo de Domínio

O sistema implementa um modelo de domínio completo para um e-commerce:

User: Cadastro de clientes (Nome, Email, Telefone, Senha).

Order: Pedidos realizados, vinculados a um status (OrderStatus).

Product & Category: Relacionamento muitos-para-muitos entre produtos e suas categorias.

Payment: Registro de informações de pagamento associadas aos pedidos.

⚙️ Configuração do Banco de Dados (Render & PostgreSQL)

Para conectar a aplicação ao banco de dados PostgreSQL hospedado no Render, o arquivo application-dev.properties deve ser configurado da seguinte forma:

Crie uma instância de PostgreSQL no painel do Render.

Obtenha as credenciais (Hostname, Database, Username e Password).

Configure as propriedades no projeto:

# Configurações para o Render (PostgreSQL)
spring.datasource.url=jdbc:postgresql://<HOSTNAME_DO_RENDER>:5432/<NOME_DO_BANCO>
spring.datasource.username=<USUARIO>
spring.datasource.password=<SENHA>

# Hibernate / JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


🛠️ Funcionalidades Implementadas

CRUD Completo: Operações de criação, leitura, atualização e deleção para a entidade de usuários.

Tratamento de Exceções: Sistema de captura de erros personalizado (ex: ResourceNotFoundException) para respostas HTTP amigáveis.

Database Seeding: Classe de configuração que povoa o banco de dados automaticamente ao iniciar o projeto em modo de desenvolvimento ou teste.
