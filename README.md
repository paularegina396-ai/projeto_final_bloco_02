# 💊 Projeto Farmácia - API RESTful

[![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Swagger](https://img.shields.io/badge/Swagger-OpenAPI--3-85EA2D.svg)](http://localhost:8080/swagger-ui/index.html)

API RESTful desenvolvida em Java com Spring Boot para gerenciamento do sistema de e-commerce de uma Farmácia. O projeto conta com relacionamentos entre entidades, validações de dados, endpoints customizados e documentação interativa via **Swagger / OpenAPI**.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência de Dados)
* **Spring Validation** (Validação de Atributos)
* **MySQL** (Banco de Dados relacional)
* **Springdoc OpenAPI / Swagger UI** (Documentação interativa da API)

---

## 🗄️ Modelo de Dados (DER)

A aplicação conta com um relacionamento **1:N (Um para Muitos)** bidirecional entre `Categoria` e `Produto`:
* **Uma Categoria** pode conter **vários Produtos**.
* **Um Produto** pertence a apenas **uma Categoria**.

---

## 📋 Entidades e Atributos

### 🏷️ Categoria (`tb_categoria`)
| Atributo    | Tipo            | Regras / Anotações                                     |
| :---------- | :-------------- | :----------------------------------------------------- |
| `id`        | `Long`          | Primary Key, `@Id`, `@GeneratedValue(IDENTITY)`        |
| `tipo`      | `String`        | `@NotBlank`, `@Size(min = 2, max = 25)`                |
| `descricao` | `String`        | `@NotBlank`, `@Size(min = 2, max = 500)`               |
| `produto`   | `List<Produto>` | `@OneToMany(mappedBy = "categoria", cascade = REMOVE)` |

### 📦 Produto (`tb_produto`)
| Atributo    | Tipo         | Regras / Anotações                               |
| :---------- | :----------- | :----------------------------------------------- |
| `id`        | `Long`       | Primary Key, `@Id`, `@GeneratedValue(IDENTITY)`  |
| `nome`      | `String`     | `@NotBlank`, `@Size(min = 5, max = 100)`         |
| `preco`     | `BigDecimal` | `@NotNull`, Precision(6,2)                       |
| `descricao` | `String`     | `@NotBlank`, `@Size(min = 10, max = 1000)`       |
| `estoque`   | `int`        | `@NotNull`, `@Positive` (> 0)                    |
| `categoria` | `Categoria`  | `@ManyToOne`, `@JsonIgnoreProperties("produto")` |

---

## 🚀 Endpoints da API

### 🏷️ Categoria (`/categoria`)

| Método   | Endpoint                 | Descrição                                |
| :------- | :----------------------- | :--------------------------------------- |
| `GET`    | `/categoria`             | Listar todas as categorias               |
| `GET`    | `/categoria/{id}`        | Buscar categoria por ID                  |
| `GET`    | `/categoria/tipo/{tipo}` | Buscar categorias por tipo (Ignore Case) |
| `POST`   | `/categoria`             | Cadastrar uma nova categoria             |
| `PUT`    | `/categoria`             | Atualizar uma categoria existente        |
| `DELETE` | `/categoria/{id}`        | Deletar uma categoria por ID             |

---

### 📦 Produto (`/produtos`)

| Método   | Endpoint                          | Descrição                                                    |
| :------- | :-------------------------------- | :----------------------------------------------------------- |
| `GET`    | `/produtos`                       | Listar todos os produtos                                     |
| `GET`    | `/produtos/{id}`                  | Buscar produto por ID                                        |
| `GET`    | `/produtos/descricao/{descricao}` | Buscar produtos por trecho da descrição                      |
| `GET`    | `/produtos/preco/{preco}`         | **[Método Extra]** Buscar produtos com preço menor ou igual ao valor informado (Ordenado por preço crescente) |
| `POST`   | `/produtos`                       | Cadastrar um novo produto (Requer ID de Categoria válido)    |
| `PUT`    | `/produtos`                       | Atualizar produto existente                                  |
| `DELETE` | `/produtos/{id}`                  | Deletar produto por ID                                       |

---

## 📄 Documentação OpenAPI / Swagger UI

A documentação interativa da API pode ser acessada com a aplicação em execução no seguinte endereço:

```text
http://localhost:8080/swagger-ui/index.html
```

## ⚙️ Como Executar o Projeto Localmente

1. **Clone o repositório:**

   Bash

   ```
   git clone [https://github.com/paularegina396-ai/projeto_final_bloco_02.git](https://github.com/paularegina396-ai/projeto_final_bloco_02.git)
   ```

2. **Configure o Banco de Dados MySQL:** Certifique-se de que o serviço do MySQL está rodando na sua máquina e ajuste o arquivo `src/main/resources/application.properties`:

   Properties

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/db_farmacia?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

3. **Execute a aplicação:**

   - Importe o projeto no **Spring Tool Suite (STS)** ou IDE de sua preferência.
   - Execute a classe principal `FarmaciaApplication.java`.