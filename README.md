# Sistema de Cadastro de Empresas e Fornecedores

Este projeto é composto por dois módulos: um back-end desenvolvido com **Spring Boot 3.4.4 e Java 17** e um front-end em **Angular 19**. A aplicação permite o cadastro e listagem de empresas e fornecedores, com validações, máscaras e integração com API externa de CEP.

---

## 🛠 Tecnologias Utilizadas

### 🔙 Back-End (Java + Spring Boot)

- Java 17
- Spring Boot 3.4.4
  - Spring Web
  - Spring Data JPA
  - Bean Validation
  - CORS Configuration
- PostgreSQL
- Lombok
- Maven
- API externa: [BrasilAPI - CEP](https://brasilapi.com.br/api/cep/v1/{cep})

### 🔜 Front-End (Angular 19)

- Angular Standalone Components
- Bootstrap 5
- NGX Mask (para máscaras de input como CNPJ e CEP)
- SCSS
