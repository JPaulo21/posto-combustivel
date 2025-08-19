# API Posto de Combustível

## Sobre

A API Posto de Combustível é uma aplicação desenvolvida em Java com Spring Boot, que permite o gerenciamento de tipos de
combustíveis, bombas de combustível e abastecimento.

## Tecnologias Utilizadas
![Gradle](https://img.shields.io/badge/gradle-%2302303A.svg?style=for-the-badge&logo=gradle&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![H2Database](https://img.shields.io/badge/h2database-%23%2309476B.svg?style=for-the-badge&logo=h2database&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%232496ED.svg?style=for-the-badge&logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/swagger-%2385EA2D.svg?style=for-the-badge&logo=swagger&logoColor=white)

## Necessário
- Docker

## Instalação
```bash 
   docker build -t api-posto-combustivel:1.0 .
```
```bash
   docker run --name api-posto -p 8080:8080 api-posto-combustivel:1.0
```

## Uso
Link do [Swagger](http://localhost:8080/posto-combustivel/swagger-ui/index.html) para verificar os endpoints disponíveis.

### - Tipos de combustiveis
| Método | Endpoint                                     | Descrição                     |
|--------|----------------------------------------------|-------------------------------|
| GET    | /posto-combustivel/v1/tipos-combustivel      | Retorna todos os combustiveis |
| GET    | /posto-combustivel/v1/tipos-combustivel/{id} | Retorna um combustivel pelo ID |
| POST   | /posto-combustivel/v1/tipos-combustivel      | Cria um novo combustivel      |
| PUT    | /posto-combustivel/v1/tipos-combustivel/{id} | Atualiza um combustivel existente |
| DELETE | /posto-combustivel/v1/tipos-combustivel/{id} | Deleta um combustivel pelo ID |

### - Bomba de combustível

| Método | Endpoint | Descrição                              |
|--------|----------|----------------------------------------|
| GET    | /posto-combustivel/v1/bomba-combustivel      | Retorna todas as bombas de combustivel |
| POST   | /posto-combustivel/v1/bomba-combustivel      | Cria uma nova bomba de combustivel     |
| DELETE | /posto-combustivel/v1/bomba-combustivel/{id} | Deleta uma bomba de combustivel pelo ID |

### - Abastecimento

| Método | Endpoint                                  | Descrição                        |
|--------|-------------------------------------------|----------------------------------|
| GET    | /posto-combustivel/v1/abastecimento/{id}  | Retorna um abastecimento pelo ID |
| POST   | /posto-combustivel/v1/abastecimento       | Cria um novo abastecimento       |




