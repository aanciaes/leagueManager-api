# League Manager API

### Run on terminal (with maven spring boot plugin)

```Shell
mvn spring-boot:run
```

### Amazon Web Services Deployment / Local Docker deployment
#### (With nginx server)

The project must have a similar structure

```
league-manager
│   docker-compose.yml
│
└───backend
│   │   Dockerfile
│   │   ...
│
└───frontend
    │   Dockerfile
    │   gateway.Nginx
    │   ...
```

### docker-compose.yml

```
version: "2"  
  
  
services:

 league-manager-api:
  build: ./backend
  expose:
   - "8080"
  
 league-manager-webapp:
  build: ./frontend
  depends_on:
   - league-manager-api
  links:
   - league-manager-api:backend
  expose:
   - "80"
  ports:
   - "80:80"

```

(if folder names are different, change on docker-compose.yml to match those names)

### Documentation

Full documentation on http://localhost:8080/swagger-ui.html
