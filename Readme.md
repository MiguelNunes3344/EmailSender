# Projeto de Registro de Usuário e Envio de Email com Java Spring

Este é um projeto de exemplo que demonstra como registrar um usuário e enviar um email utilizando o serviço SMTP do Google com o framework Spring em Java.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Google SMTP (para envio de email)
- H2 Database
- Thymeleaf (para as páginas HTML)

## Configuração do Projeto

Antes de executar o projeto, você deve configurar as seguintes informações no arquivo `application.properties`.

### Configuração do Banco de Dados

```properties
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password= 
# H2 CLIENT 
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
# JPA, SQL 
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
```
### Configuração do Google SMTP

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<your account google>
#https://support.google.com/accounts/answer/185833?hl=pt-BR link tutorial for get password
spring.mail.password=<password>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

## Como Executar o Projeto

Siga estas etapas para executar o projeto em sua máquina local:

1. **Clone o Repositório:** 

   ```bash
   git clone https://github.com/MiguelNunes3344/EmailSender.git
   ```
2. **Navegue até o Diretório do Projeto:** 

    ```bash
   cd projeto
   ```

3. **Execute o Projeto usando o Maven:** 
    ```bash
   mvn spring-boot:run
     ```

## Uso do aplicativo

1. **Acesse a pagina inicial em http://localhost:8080/client/register**
2. **Registre um novo usuáriio preenchendo o formulario de registro.**
3. **Após o registro verifique a caixa de entrada do email registrado.**





