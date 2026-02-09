🩺 VollMed API

A VollMed é uma API REST desenvolvida para a gestão de uma clínica médica fictícia. O sistema permite o gerenciamento de médicos, pacientes e o agendamento de consultas, aplicando conceitos de boas práticas, segurança e performance.
🚀 Funcionalidades

    CRUD de Médicos: Cadastro, listagem (com paginação), atualização e exclusão lógica

    CRUD de Pacientes: Cadastro, listagem, atualização e exclusão lógica

    Agendamento de Consultas: Regras de negócio para horários de atendimento, especialidades e cancelamentos

    Segurança: Autenticação e autorização via tokens JWT (JSON Web Token)

    Validações: Uso de Bean Validation para integridade dos dados

    Documentação: Documentação interativa dos endpoints

🛠️ Tecnologias Utilizadas

    Java 17

    Spring Boot 3

    Spring Data JPA (Persistência de dados)

    Spring Security (Autenticação e controle de acesso)

    Flyway (Gerenciamento de migrations do banco de dados)

    MySQL (Banco de dados relacional)

    Lombok (Produtividade no código Java)

    Maven (Gerenciador de dependências)

📋 Pré-requisitos

Para rodar o projeto localmente, você precisará de:

    JDK 17 ou superior

    MySQL Server 8.0+

    Uma IDE de sua preferência (IntelliJ, Eclipse, VS Code)

🔧 Configuração e Instalação

    Clone o repositório:

bash
git clone https://github.com/lucas-bernardo-souza/VollMed.git

    Configure o banco de dados: no arquivo src/main/resources/application.properties, ajuste as credenciais do seu MySQL:

text
spring.datasource.url=jdbc:mysql://localhost:3306/vollmed_api
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

    Configure a variável de ambiente para o JWT: o projeto utiliza uma chave secreta para assinar os tokens. Você pode definir uma variável de ambiente chamada API_SECURITY_TOKEN ou ajustar temporariamente no application.properties.

    Execute a aplicação:

bash
mvn spring-boot:run

🔐 Autenticação

Para acessar os endpoints protegidos, é necessário realizar login no endpoint /login enviando login e senha. O retorno será um token JWT que deve ser enviado no header das próximas requisições:

text
Authorization: Bearer <seu_token>

✍️ Autor

Desenvolvido por Lucas Bernardo Souza – [Seu LinkedIn](https://www.linkedin.com/in/lucasbernardodesouza/)
