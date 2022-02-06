# hotel-project-server

- Aplicação back do teste prático feita em SpringBoot(Java)
- URL da API na nuvem : https://aw-hotel-api.herokuapp.com
- Swagger da API : https://aw-hotel-api.herokuapp.com/swagger-ui/index.html#

![UML]

## Tecnologias utilizadas
- Java 11
- Maven
- Spring Boot
- Postgresql
- Banco H2
- GIT

## Dependências
- Spring Data JPA
- Spring Validation
- Spring Web
- Spring Devtools
- Postgesql | H2
- Lombok
- Springfox Swagger

## Funcionalidades

 CRUD para o cadastro de hóspedes
 - Create  {baseUrl}/api/hospede (POST) </br>
 - Read  {baseUrl}/api/hospede (GET) </br>
 - Update  {baseUrl}/api/hospede:{} (PUT) </br>

 Permitir realizar o checkin e checkout
- Check in  {baseUrl}/api/hospedagem (POST) 
- Check out  {baseUrl}/api/hospedagem (PATCH) </br>

 Permitir consultar ex-hóspedes
- {baseUrl}/api/hospede/ex_hospedes (GET)</br>

Permitir realizar o pgamento
- {baseUrl}/api/hospedagem/pay (PATCH)</br>
 


## Como rodar local
Pré-requisitos: 
- Java 8
- Intellij IDE
- Postgresql(opcional) </br></br>
- OBS.: Tive que alterar para o java 8 devido a ser compativel com o deploy na nuvem porém o código não alterou.

```bash

# abrir o projeto no Intellij

# baixar as dependência no pom.xml

# Ir no application.properties e alterar o perfil ativo para development ou homologation
# sendo o development para usar com o postgresql local e o homologation o banco h2
```
![UML]()
