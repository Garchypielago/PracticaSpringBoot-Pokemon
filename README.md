# Shopedex

Aplicacion Spring Boot 3.4 + Thymeleaf + MariaDB preparada para desplegarse en `shopedex.alejandrogs.dev` con Docker Compose y Caddy en el host.

## Stack

- Java 21
- Spring Boot 3.4
- Spring MVC + Thymeleaf
- Spring Security + JWT
- Spring Data JPA
- Flyway
- MariaDB
- Docker Compose

## Estructura

- `src/`: aplicacion principal desplegable.
- `legacy/`: material antiguo archivado fuera del flujo de despliegue.
- `docker-compose.yml`: despliegue local standalone con puerto `127.0.0.1:18080`.
- `docker-compose.server.yml`: despliegue para HP Debian con Caddy ya existente en Docker.
- `deploy/caddy/`: snippet de Caddy para Debian.
- `.env.example`: interfaz publica de configuracion.

## Variables de entorno

Copia `.env.example` a `.env` y ajusta:

- `MARIADB_DATABASE`
- `MARIADB_USER`
- `MARIADB_PASSWORD`
- `MARIADB_ROOT_PASSWORD`
- `SECURITY_JWT_SIGNING_KEY_SECRET`
- `SECURITY_JWT_ACCESS_TOKEN_TTL`
- `SECURITY_JWT_REFRESH_TOKEN_TTL`
- `SHOPEDEX_BOOTSTRAP_ADMIN_EMAIL`
- `SHOPEDEX_BOOTSTRAP_ADMIN_PASSWORD`
- `SHOPEDEX_BOOTSTRAP_ADMIN_FIRST_NAME`
- `SHOPEDEX_BOOTSTRAP_ADMIN_LAST_NAME`

## Datos incluidos

Flyway crea el esquema y deja:

- Catalogo completo con 1025 Pokemon y sus stats base.
- Usuarios demo:
  - `ash@example.com` / `ash-demo-123`
  - `misty@example.com` / `misty-demo-123`
- Usuario admin bootstrap controlado por entorno.

Si ya tenias una base creada con el catalogo corto anterior, basta con reconstruir y levantar la app para que Flyway aplique `V4__replace_demo_with_full_catalog.sql`:

1. `docker compose up -d --build`
2. Verifica con `curl http://127.0.0.1:18080/actuator/health`
3. Si quieres forzar una base limpia local, usa `docker compose down -v` y luego `docker compose up -d --build`

## Despliegue local

1. `cp .env.example .env`
2. Edita `.env`
3. `docker compose config`
4. `docker compose up -d --build`
5. Verifica con `curl http://127.0.0.1:18080/actuator/health`

## Notas

- La app publica el endpoint operativo `/actuator/health`.
- `/admin/**` requiere rol `ADMIN`.
- Si falta un sprite concreto, la UI cae al placeholder local `default.png`.
- El HP Debian actual no tiene acceso GitHub por SSH para este repo hasta que se configure la deploy key dedicada.
- En este entorno local no habia Java instalado durante la refactorizacion, asi que la validacion Maven se hace dentro de contenedores con Java 21.
