
# spring-boot-simple-api

This repository contains a simple CRUD API using Spring BOOT


To install the Spring Boot simple API, you can follow these steps:

## Installation

Clean and Build Maven after it should appear jar file in target folder

```bash

./mvnw clean install

```

## Deployment

To deploy this project run

```bash
    
docker run -p 3306:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=simple_api -e MYSQL_USER=test-user -e MYSQL_PASSWORD=test-pass -d mysql

docker build -t simpleapi .

docker run -p 8080:8080 --link mysql-container --name simpleapi simpleapi

```