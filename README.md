# Biblioteca Virtual com Spring WebMVC

Este projeto implementa uma biblioteca virtual utilizando o framework Spring Boot, seguindo a arquitetura MVC (Model-View-Controller). A aplicação permite gerenciar livros e usuários, oferecendo operações de cadastro, consulta e empréstimo de livros.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto.
- **Spring Boot**: Framework que facilita a configuração e o desenvolvimento de aplicações Java.
- **Spring WebMVC**: Módulo do Spring que permite a construção de aplicações web seguindo o padrão MVC.
- **Thymeleaf**: Motor de templates utilizado para renderizar as views no lado do servidor.
- **Spring Data JPA**: Abstração que facilita a interação com o banco de dados utilizando o padrão JPA.
- **H2 Database**: Banco de dados em memória utilizado para fins de desenvolvimento e testes.

## Arquitetura MVC

A aplicação está estruturada conforme o padrão MVC, que divide a aplicação em três camadas principais:

1. **Model (Modelo)**: Representa os dados e a lógica de negócios da aplicação. Nesta camada, estão as classes que mapeiam as entidades do domínio, como `Livro` e `Usuario`.

2. **View (Visão)**: Responsável pela interface com o usuário. Utiliza o Thymeleaf para renderizar páginas HTML dinâmicas baseadas nos dados fornecidos pelos controllers.

3. **Controller (Controle)**: Gerencia as requisições do usuário, processa os dados através do modelo e retorna as respostas apropriadas através das views.

## Estrutura do Projeto

A estrutura de diretórios do projeto é organizada da seguinte forma:

- `src/main/java/com/exemplo/biblioteca/`
  - `model/`: Contém as classes das entidades do domínio.
  - `repository/`: Contém as interfaces que estendem `JpaRepository` para acesso aos dados.
  - `controller/`: Contém as classes que lidam com as requisições HTTP e definem os endpoints da aplicação.
  - `service/`: (Opcional) Pode conter classes que implementam a lógica de negócios, separando-a dos controllers.

- `src/main/resources/`
  - `templates/`: Contém os arquivos HTML que são processados pelo Thymeleaf.
  - `static/`: Contém recursos estáticos como CSS, JavaScript e imagens.
  - `application.properties`: Arquivo de configuração da aplicação.

## Configuração e Execução

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/jhonieldorschulz/library-spring-webmvc.git
   ```

2. **Navegue até o diretório do projeto**:

   ```bash
   cd library-spring-webmvc
   ```

3. **Execute a aplicação**:

   ```bash
   ./mvnw spring-boot:run
   ```

   A aplicação estará disponível em `http://localhost:8080`.

## Funcionalidades

- **Gerenciamento de Livros**: Cadastro, edição, exclusão e listagem de livros disponíveis na biblioteca.
- **Gerenciamento de Usuários**: Cadastro, edição, exclusão e listagem de usuários da biblioteca.
- **Empréstimo de Livros**: Funcionalidade que permite registrar o empréstimo e a devolução de livros pelos usuários.

## Considerações Finais

Este projeto serve como uma base para o desenvolvimento de aplicações web utilizando Spring Boot e o padrão MVC. Ele demonstra a integração entre as diversas camadas da aplicação e o uso de tecnologias populares no ecossistema Java. 
