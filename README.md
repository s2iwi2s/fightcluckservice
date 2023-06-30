# fightcluckservice

## Read Me First

#### Deploy in docker
```editorconfig
mvnw package -Pprod verify jib:dockerBuild -DskipTests
docker compose -f src/main/docker/app.yml up
```







# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/#build-image)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#features.docker-compose)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#using.devtools)
* [Config Client Quick Start](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_client_side_usage)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.

However, no services were found. As of now, the application won't start!

Please make sure to add at least one service in the `compose.yaml` file.

