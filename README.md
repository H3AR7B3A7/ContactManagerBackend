# Contact Manager

This is the backend for a simple contact manager application, with JWT authentication. The front-end can be
found [here](https://github.com/H3AR7B3A7/EarlyAngularProjects/tree/master/contacts).

## JWT

We can decode our tokens at the [JWT Official Website](https://jwt.io/).

## REST

Representational state transfer ([REST](https://en.wikipedia.org/wiki/Representational_state_transfer)) is a style of
software architecture. As described in a dissertation by Roy Fielding, REST is an "architectural style" that basically
exploits the existing technology and protocols of the Web.

## RESTful

Our service is RESTful when it adheres to the following principles:

- It should be stateless
- It should access all the resources from the server using only URI
- It does not have inbuilt encryption
- It does not have session
- It uses one and only one protocol - HTTP
- For performing CRUD operations, it should use HTTP verbs such as GET, POST, PUT, DELETE
- It should return the result only in the form of JSON or XML, atom, OData etc. (lightweight data )

We can find an interesting post on RESTful design on stackoverflow
[here](https://stackoverflow.com/questions/21863326/delete-multiple-records-using-rest).

## Swagger

We can now just add the **springdoc-openapi-ui** dependency:

```
<dependency>
     <groupId>org.springdoc</groupId>
     <artifactId>springdoc-openapi-ui</artifactId>
     <version>1.5.9</version>
</dependency>
```

And then for the UI just go to:

- http://localhost:8080/swagger-ui.html

For the Json go to:

- http://localhost:8080/v3/api-docs

For yaml:

- http://localhost:8080/v3/api-docs.yaml

That's really all there is to it... No annotations / configuration needed.

If you are using **spring security**, make sure you can reach these paths for it to work:

- /swagger-ui.html
- /swagger-ui/**
- /v3/api-docs/**

We can find more information [here](https://www.baeldung.com/spring-rest-openapi-documentation).

We can also create our own yaml. For that we can find an example [here](https://editor.swagger.io/).

---
*Work in progress ...*