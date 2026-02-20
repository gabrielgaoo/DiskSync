# DiskSync-Backend

Repositório criado para um sistema de **delivery de vendas de discos de vinil**, desenvolvido com o objetivo de aprender e aplicar os principais conceitos de **Design Patterns** estudados na disciplina de **Projetos de Sistemas de Software**, ministrada pelo professor **Clayton Vieira Fraga**.

O projeto oferece APIs RESTful para gestão de usuários, carrinho, pedidos, carteira e integração com a API do Spotify para busca e detalhes de álbuns.

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado em seu ambiente:

- **Java 20** 
- **Maven 3.6+** 
- **PostgreSQL 12+** 
- **Git** 

## 🚀 Configuração do Ambiente Local

### 1. Clonar o repositório

```bash
git clone https://github.com/gabrielgaoo/DiskSync.git
```

### 2. Configurar o banco de dados PostgreSQL

Crie um banco de dados PostgreSQL local:

```sql
CREATE DATABASE diskSync;
```

### 3. Configurar variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto ou configure as variáveis de ambiente no seu sistema:

```bash
# Banco de dados
URL_DB=jdbc:postgresql://localhost:5432
DATABASE=disksync
USERNAME=seu_usuario_postgres
PASSWORD=sua_senha_postgres

# Servidor
PORT=8081;

# Segurança JWT
JWT_SECRET=secret;

# Spotify API 
CLIENT_ID=4deafee7ec144975a4589b69c1a8b1e2;
CLIENT_SECRET=96c284ac23f84987aeec2f0732322c81;
```

**Importante:**
- Substitua `seu_usuario_postgres` e `sua_senha_postgres` pelas suas credenciais do PostgreSQL local

### 4. Instalar dependências

No diretório `integration`:

```bash
cd integration
mvn clean install
```

## ▶️ Executar a aplicação

### Usando Maven

```bash
cd integration
mvn spring-boot:run
```

### Usando Java diretamente

```bash
cd integration
mvn clean package
java -jar target/integration-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em: `http://localhost:8081`

### Documentação da API (Swagger)

- **Swagger UI** (interface interativa): [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- **OpenAPI (JSON)**: [http://localhost:8081/v3/api-docs](http://localhost:8081/v3/api-docs)

> Use a porta configurada na variável `PORT` (ex.: 8081). Se alterar a porta, substitua `8081` nas URLs acima.

## 🛠️ Tecnologias utilizadas

- **Spring Boot 3.2.7** - Framework principal
- **Spring Security** - Autenticação e autorização
- **Spring Data JPA** - Persistência de dados
- **PostgreSQL** - Banco de dados
- **JWT (java-jwt)** - Geração e validação de tokens
- **Swagger/OpenAPI** - Documentação da API
- **Lombok** - Redução de código boilerplate
- **Maven** - Gerenciamento de dependências
