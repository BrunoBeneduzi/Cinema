# 🎬 Projeto CINEMA

Esse projeto é uma API que armazena informações sobre filmes 🎥 e atores 🎭 que participaram deles.  
Abaixo está descrito quais informações de filmes e atores são armazenadas.  
Utiliza Spring Security 🔐 para criar um sistema de login, assim, para poder alterar, adicionar ou pesquisar dados é preciso estar logado.  
No **Passo a passo** será mostrado como utilizar o código.

---

## 🚀 Funcionalidades

- ➕ Adicionar filmes e atores (só é possível adicionar atores quando for adicionar um filme).  
- ❌ Excluir filmes.  
- ✏️ Editar filmes e atores.

---

## 🗂️ Modelos de Dados

### 🎞️ Filmes
- `Long id`  
- `String nomeFilme`  
- `Double nota` ⭐  
- `String nomeDiretor` 🎬  
- `LocalDate dataDeLancamento` 📅  
- `List<Atores> atores` 👥  

### 🎭 Atores
- `Long id`  
- `String nomeCompleto`  
- `LocalDate dataDeNascimento` 🎂  
- `Long quantidadeDePremios` 🏆 (É quantos prêmios o ator ganhou na vida, mas não diz quais prêmios foram esses)  
- `String nacionalidade` 🌎  

### 👤 Usuario  
Essa classe é para registrar os usuários.  
- `Long id`  
- `String login` 📧  
- `String senha` 🔑 (a senha é codificada)  

Todos os usuários cadastrados podem editar, excluir, adicionar ou visualizar os dados.

---

## 🛠️ Tecnologias utilizadas

- Java ☕  
- Spring Boot 🌱  
- Spring JPA 📚  
- Spring Security 🔒  
- MySQL 🐬  
- Validations ✔️  
- Postman 📨  
- Arquitetura em camadas 🏗️  
- JWT: https://jwt.io/libraries?filter=java  
  - Essa biblioteca adiciona suporte para criar, assinar, verificar e decodificar tokens JWT (JSON Web Tokens) no seu projeto Java.  
  - Com essa biblioteca, você pode gerar tokens para autenticação, validar tokens recebidos, extrair informações (claims) do token, entre outras funcionalidades relacionadas ao JWT.

<dependency>
  <groupId>com.auth0</groupId>
  <artifactId>java-jwt</artifactId>
  <version>4.5.0</version>
</dependency>

---

## 📝 Passo a passo para baixar e usar o projeto

Passo 1:  
📥 git clone https://github.com/BrunoBeneduzi/Cinema.git

Passo 2:  
⚙️ Depois de baixar é preciso configurar o banco de dados, crie uma dataBase chamada "cinema",  
caso utilize o MySQL você já pode dar play no projeto, caso utilize outro, lembre de alterar no POM.XML as dependências  
para o banco de dados que vai ser utilizado e altere no APPLICATION.PROPERTIES as configurações para o banco que vai ser utilizado.

Passo 3:  
👤 Adicionar um usuário para você conseguir usar o protocolo HTTP para mexer no projeto.

POST http://localhost:8080/login/cadastrar  
Exemplo de usuário, adicione isso no Body do seu software que faz os testes de API.

{
  "login": "Admin@teste.com",
  "senha": "12345"
}

Passo 4:  
🔑 Depois de cadastrar o seu usuário, basta logar com ele, copiar o token que foi gerado (dura 3 horas), e adicionar o token em "Authorization" -> Bearer Token, então vai ser possível mexer no projeto.

![image](https://github.com/user-attachments/assets/fb545658-0c11-4dce-9dd2-e35c767ea4a7)

POST: http://localhost:8080/login  
{
  "login": "Admin@teste.com",
  "senha": "12345"
}

Pronto, agora você pode usar o projeto, abaixo vão exemplos de como adicionar, remover, editar e exibir os dados que foram adicionados no projeto.

---

## 🔍 Requisições GET

Para filmes:  
GET /filme?nomeFilme  <- Retorna todos os filmes 🎥  
GET /filme?nomeFilme=senhor  <- Retorna o nome do filme ou dos filmes que tiverem o nome parecido 🎞️  
GET /filme?nomeDiretor=bruno  
GET /filme?nota=7  <- Retorna todos os filmes com nota igual ou maior que 7 ⭐  
GET /filme?id=1  <- Retorna o filme pelo id 🔢

Para atores:  
GET /ator?nomeCompleto  <- Retorna todos os atores 🎭  
GET /ator?nomeFilme=senhor  <- Retorna os atores do filme que tiverem nome parecido 👥  
GET /ator?nomeDiretor=bruno  
GET /ator?nota=7  <- Retorna atores que participaram de filmes com nota igual ou maior que 7 🏆  
GET /ator?id=1  <- Retorna o ator pelo id 🔢

---

## ➕ Requisições POST

Para filmes:

[
  {
    "nomeFilme": "Nome do Filme",
    "nota": 8.5,
    "nomeDiretor": "Nome do Diretor",
    "dataDeLancamento": "1999-03-31",
    "atores": [
      {
        "nomeCompleto": "Nome do Ator",
        "dataDeNascimento": "1964-09-02",
        "quantidadeDePremios": 3,
        "nacionalidade": "Brasileiro"
      }
    ]
  }
]

---

## ✏️ Requisições PUT

Para filmes:

PUT filme/ID

coloque depois o que deseja mudar no formato de JSON, exemplo:

{
  "nota": 10
}

---

## ❌ Requisições DELETE

Para excluir filmes:

http://localhost:8080/filme/6

---

Use esse link para verificar melhor:  
🌐 http://localhost:8080/swagger-ui/index.html#/
