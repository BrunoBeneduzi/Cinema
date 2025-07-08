# Projeto CINEMA 🎬

Este projeto é uma **API REST** desenvolvida com **Spring Boot** que armazena informações sobre **filmes e atores** que participaram deles. Também utiliza **Spring Security** para controlar o acesso às funcionalidades da API.

---

## 🔐 Autenticação e Acesso

A API conta com um sistema de **login e autenticação via Spring Security**.  
Para **adicionar, editar, excluir ou visualizar** os dados, é necessário estar **logado**.

---

## ✅ Funcionalidades

- 🔸 Adicionar filmes e atores *(ao adicionar um filme, os atores também são cadastrados)*
- 🔸 Editar informações de filmes e atores
- 🔸 Excluir filmes

---

## 🎞️ Estrutura das Entidades

### 🎬 Filme

```java
Long id;
String nomeFilme;
Double nota;
String nomeDiretor;
LocalDate dataDeLancamento;
List<Atores> atores;
```

### 🎭 Ator

```java
Long id;
String nomeCompleto;
LocalDate dataDeNascimento;
Long quantidadeDePremios; // Quantidade de prêmios que o ator ganhou (sem especificar quais)
String nacionalidade;
```

### 👤 Usuário

```java
Long id;
String login;
String senha; // A senha é codificada
```

Todos os usuários cadastrados têm **permissão total** para editar, excluir, adicionar e visualizar os dados.

---

## 🚀 Tecnologias Utilizadas

- ✅ Java
- ✅ Spring Boot
- ✅ Spring Data JPA
- ✅ Spring Security
- ✅ MySQL
- ✅ Bean Validation
- ✅ Postman (para testes de API)
- ✅ Arquitetura em Camadas (Controller, Service, Repository)
- ✅ JWT: https://jwt.io/libraries?filter (Ela adiciona suporte para criar, assinar, verificar e decodificar tokens JWT (JSON Web Tokens) no seu projeto Java.)

---

---

## 📌 Informação Útil

Este projeto já inclui a dependência da biblioteca **Java JWT** da Auth0, utilizada para:

- Gerar tokens para autenticação
- Validar tokens recebidos
- Extrair informações (claims) dos tokens

Essa funcionalidade é essencial para o controle de acesso seguro usando **JWT (JSON Web Tokens)**.

Dependência já presente no `pom.xml`:

```xml
<dependency>
  <groupId>com.auth0</groupId>
  <artifactId>java-jwt</artifactId>
  <version>4.5.0</version>
</dependency>
```

---
---

---

## 🧭 Passo a Passo para Executar o Projeto

### 🔽 1. Clonar o Repositório

```bash
git clone https://github.com/BrunoBeneduzi/Cinema.git
```

---

### 🛠️ 2. Configurar o Banco de Dados

- Crie um banco de dados chamado `cinema`.
- Se estiver usando **MySQL**, basta dar *play* no projeto.
- Se estiver usando outro banco de dados:
  - Altere as dependências no `pom.xml`
  - Configure corretamente o `application.properties` com as credenciais e URL do seu banco.

---

### 👤 3. Cadastrar um Usuário

Para acessar as funcionalidades da API, é necessário criar um usuário.

**Requisição:**

```http
POST http://localhost:8080/login/cadastrar
```

**Exemplo de corpo da requisição (JSON):**

```json
{
  "login": "Admin@teste.com",
  "senha": "12345"
}
```

---

### 🔐 4. Autenticar-se (Login) e Obter Token

Após criar o usuário, faça login para obter o token JWT. Ele é válido por 3 horas.

**Requisição:**

```http
POST http://localhost:8080/login
```

**Corpo da requisição:**

```json
{
  "login": "Admin@teste.com",
  "senha": "12345"
}
```
![image](https://github.com/user-attachments/assets/c606f93b-00a8-4de2-8377-85ca186802bc)


- Copie o token JWT retornado
- Em ferramentas como Postman, adicione o token no cabeçalho:
  - Aba **Authorization**
  - Tipo: **Bearer Token**
  - Cole o token

![image](https://github.com/user-attachments/assets/f9d2579f-b84f-4dbb-9704-eb5f20f12e3d)

---

## 📡 Exemplos de Requisições

### 📥 GET – Consultar Dados

#### 🔍 Filmes

```http
GET /filme?nomeFilme         → Retorna todos os filmes
GET /filme?nomeFilme=senhor  → Busca por nome parcial
GET /filme?nomeDiretor=bruno → Busca por diretor
GET /filme?nota=7            → Retorna filmes com nota ≥ 7
GET /filme?id=1              → Retorna filme por ID
```

#### 🎭 Atores

```http
GET /ator?nomeCompleto         → Retorna todos os atores
GET /ator?nomeFilme=senhor     → Busca por filme relacionado
GET /ator?nomeDiretor=bruno    → Busca por diretor
GET /ator?nota=7               → Retorna filmes com nota ≥ 7
GET /ator?id=1                 → Retorna ator por ID
```

---

### ➕ POST – Cadastrar Filme e Atores

**Requisição:**

```http
POST /filme
```

**Exemplo de corpo da requisição:**

```json
[
  {
    "nomeFilme": "Matrix",
    "nota": 9.5,
    "nomeDiretor": "Wachowski",
    "dataDeLancamento": "1999-03-31",
    "atores": [
      {
        "nomeCompleto": "Keanu Reeves",
        "dataDeNascimento": "1964-09-02",
        "qtdPremios": 5,
        "nacionalidade": "Canadense"
      }
    ]
  }
]
```

> 🎯 Observação: A data deve estar no formato `yyyy-MM-dd`.

---

### ✏️ PUT – Atualizar Informações

**Requisição:**

```http
PUT /filme/{id}
```

**Exemplo de atualização parcial (nota):**

```json
{
  "nota": 10
}
```

---

### 🗑️ DELETE – Excluir Filme

**Requisição:**

```http
DELETE http://localhost:8080/filme/6
```

---

Pronto! Agora você pode usar a API para gerenciar seus filmes e atores com segurança e controle via autenticação JWT. 🎥✅



