# Fejlsztés

## Környezet

- Telepítsd a Java JDK 21-et.
- Állítsd be az `JAVA_HOME` környezeti változót a JDK telepítési könyvtárára. (`C:\Program Files\Java\jdk-21`)
- Add hozzá a `%JAVA_HOME%\bin` mappát a rendszer `PATH` változóihoz.
- Ellenőrzés CMD-ben:
```bash
java -version
```
- Használj Visual Studio Code-ot fejlesztéshez.
    - Telepítsd a [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) bővítményt.
    - Telepítsd a [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items/?itemName=vmware.vscode-boot-dev-pack) bővítményt.

## Futtatás

- Adatbázis magától létrejön emiatt: `- ./db-init:/docker-entrypoint-initdb.d`

### Localhost

- Docker telepítése 
- postgres adatbázis futtatása docker-compose-ból
- Web applikáció futtatása `Spring Boot Dashboard`-ból [URL](http://localhost:8080/orders)

### Docker

- Docker telepítése 
- docker-compose futtatása [URL](http://localhost:8080/orders)
