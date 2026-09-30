# Biblioteca API

API REST para gerenciamento de biblioteca, construída do zero com Java e Spring Boot como parte da minha formação em back-end.

---

## Sobre o projeto

Sistema que gerencia autores e livros com relacionamento entre as entidades. Foi o primeiro projeto que fiz usando Spring Boot de verdade — o objetivo era entender na prática como funciona uma API REST completa: arquitetura em camadas, persistência com JPA, validação de dados, tratamento de exceções e boas práticas de código.

Ainda está em desenvolvimento. As próximas etapas incluem sistema de empréstimos, busca customizada e DTOs.

---

## Stack

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_4-6DB33F?style=flat-square&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-005C84?style=flat-square&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)

- Java 21
- Spring Boot 4
- Spring Data JPA + Hibernate
- PostgreSQL
- Bean Validation
- Lombok
- Maven

---

## Funcionalidades

### Autores
- Criar autor
- Listar todos
- Buscar por id
- Atualizar
- Deletar

### Livros
- Criar livro (validando se o autor existe)
- Listar todos
- Buscar por id
- Atualizar
- Deletar

### Tratamento de erros
- Retorna **404** com mensagem quando um recurso não é encontrado
- Retorna **400** com detalhes quando os dados enviados são inválidos
- Validação cruzada: não permite criar livro com autor inexistente

---

## Endpoints

### Autores

| Método | Rota | Descrição |
|---|---|---|
| GET | `/autores` | Lista todos os autores |
| GET | `/autores/{id}` | Busca um autor pelo id |
| POST | `/autores` | Cria um novo autor |
| PUT | `/autores/{id}` | Atualiza um autor |
| DELETE | `/autores/{id}` | Deleta um autor |

**Exemplo de POST:**
```json
{
  "nome": "Machado de Assis",
  "nacionalidade": "Brasileiro",
  "dataNascimento": "1839-06-21"
}
Livros
Método	Rota	Descrição
GET	/livros	Lista todos os livros
GET	/livros/{id}	Busca um livro pelo id
POST	/livros	Cria um novo livro
PUT	/livros/{id}	Atualiza um livro
DELETE	/livros/{id}	Deleta um livro
Exemplo de POST:

json
{
  "titulo": "Dom Casmurro",
  "isbn": "978-85-1234-567-8",
  "anoPublicacao": 1899,
  "disponivel": true,
  "autor": {
    "autorId": 1
  }
}
Como rodar localmente
Pré-requisitos
Java 21

Maven

PostgreSQL rodando

1. Clonar o repositório
bash
git clone https://github.com/PedroABatista/biblioteca-api.git
cd biblioteca-api
2. Criar o banco no PostgreSQL
sql
CREATE DATABASE biblioteca_db;
3. Configurar o application.properties
Edita o arquivo em src/main/resources/application.properties com seus dados:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
4. Rodar a aplicação
bash
./mvnw spring-boot:run
A API sobe em http://localhost:8080.

Estrutura do projeto
text
src/main/java/biblioteca_api/
├── controller/    endpoints da API
├── exception/     exceptions customizadas e handler global
├── model/         entidades JPA
├── repository/    acesso ao banco
└── service/       regras de negócio
O que aprendi construindo isso
Arquitetura em camadas (Controller → Service → Repository)

Mapeamento objeto-relacional com JPA/Hibernate

Relacionamento @ManyToOne entre entidades

Validação de dados com Bean Validation

Tratamento global de exceções com @RestControllerAdvice

Injeção de dependência via construtor

Boas práticas de API REST

Próximos passos
□ Sistema de empréstimos de livros
□ DTOs para não expor entidades direto
□ Busca customizada por título/autor
□ Testes unitários
□ Deploy no Render
□ Documentação com Swagger
Contato
Email: ordep.pedro99@gmail.com

LinkedIn: in/pedrohabatista

GitHub: @PedroABatista

text

---

## 📌 Sobre esse README

**Pontos importantes:**

1. **A seção "O que aprendi"** — recrutador adora isso. Mostra que você **reflete** sobre o que faz, não só copia código.

2. **Os "Próximos passos"** — quando você completar cada item, vai lá e marca com `[x]`. Isso mostra **evolução**. Recrutador que olha duas vezes vê progresso.

3. **Os endpoints estão documentados** — quem abrir o repo sabe exatamente como usar.

4. **O tom é natural** — sem "Este projeto tem como objetivo..." que é cara de IA. É você falando.

5. **Não tem screenshot ainda** — quando fizer o deploy, você pode adicionar um print dos endpoints no Postman aqui no README.

---

## 🎯 Onde salvar

Cria o arquivo `README.md` na **raiz do projeto** (mesma pasta do `pom.xml`), cola esse conteúdo, e commita:

```bash
git add README.md
git commit -m "adiciona readme do projeto"
git push
