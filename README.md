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

## Despliegue en HP Debian

El servidor inspeccionado usa una stack Docker compartida en `/srv/docker/stack`, con:

- contenedor `caddy` publicando `80/443`
- red Docker externa `web`
- `Caddyfile` bind-mountado desde `/srv/docker/caddy/Caddyfile`

Shopedex debe desplegarse como stack separada en `/srv/docker/shopedex/repo`, sin tocar `compose.yml` de `/srv/docker/stack`.

### 1. Preparar acceso Git en el servidor

Genera una deploy key dedicada en el HP Debian:

```bash
mkdir -p ~/.ssh
ssh-keygen -t ed25519 -f ~/.ssh/id_ed25519_github_practica_pokemon -C "shopedex-deploy" -N ""
chmod 600 ~/.ssh/id_ed25519_github_practica_pokemon
chmod 644 ~/.ssh/id_ed25519_github_practica_pokemon.pub
```

Anade esta entrada en `~/.ssh/config`:

```sshconfig
Host github-practica-pokemon
    HostName github.com
    User git
    IdentityFile ~/.ssh/id_ed25519_github_practica_pokemon
    IdentitiesOnly yes
```

Sube `~/.ssh/id_ed25519_github_practica_pokemon.pub` como deploy key read-only del repo `Garchypielago/PracticaSpringBoot-Pokemon` y valida:

```bash
ssh -T git@github-practica-pokemon
```

### 2. Clonar el repo en la ruta final

```bash
mkdir -p /srv/docker/shopedex
git clone git@github-practica-pokemon:Garchypielago/PracticaSpringBoot-Pokemon.git /srv/docker/shopedex/repo
cd /srv/docker/shopedex/repo
```

### 3. Crear secretos y levantar la stack

```bash
cp .env.example .env
nano .env
sudo docker compose -f docker-compose.server.yml --env-file .env config
sudo docker compose -f docker-compose.server.yml --env-file .env up -d --build
sudo docker compose -f docker-compose.server.yml ps
```

En el servidor no se publica `18080`: `shopedex-app` entra en la red `web` para que Caddy haga proxy por nombre de servicio.

### 4. Publicar en Caddy

Anade este bloque a `/srv/docker/caddy/Caddyfile`:

```caddy
shopedex.alejandrogs.dev {
    reverse_proxy shopedex-app:8080
}
```

Recarga Caddy con el patron actual del servidor:

```bash
sudo docker exec caddy caddy reload --config /etc/caddy/Caddyfile
```

### 5. Crear DNS en Cloudflare

El dominio actual usa Cloudflare. Crea:

- `CNAME shopedex -> alejandrogs.dev`
- Proxy activado igual que en la web principal

### 6. Validacion

```bash
sudo docker compose -f docker-compose.server.yml --env-file .env ps
sudo docker exec caddy wget -qO- http://shopedex-app:8080/actuator/health
curl -I https://shopedex.alejandrogs.dev
```

Comprueba ademas:

- login funcional
- acceso admin con el bootstrap admin
- sprites reales cargando
- `alejandrogs.dev`, `webhook.alejandrogs.dev` y `tv.alejandrogs.xyz` siguen funcionando

### 7. Actualizaciones posteriores

```bash
cd /srv/docker/shopedex/repo
git pull
sudo docker compose -f docker-compose.server.yml --env-file .env up -d --build
```

## Validacion esperada

- `mvn test`
- `mvn package`
- `docker compose config`
- `docker compose up -d --build`
- `curl http://127.0.0.1:18080/actuator/health`
- `sudo docker compose -f docker-compose.server.yml --env-file .env config`
- `sudo docker compose -f docker-compose.server.yml --env-file .env up -d --build`

## Notas

- La app publica el endpoint operativo `/actuator/health`.
- `/admin/**` requiere rol `ADMIN`.
- Si falta un sprite concreto, la UI cae al placeholder local `default.png`.
- El HP Debian actual no tiene acceso GitHub por SSH para este repo hasta que se configure la deploy key dedicada.
- En este entorno local no habia Java instalado durante la refactorizacion, asi que la validacion Maven se hace dentro de contenedores con Java 21.
