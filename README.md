# Examen Interciclo - Sistema de Mensajes

Este proyecto implementa un sistema de mensajes distribuido con los siguientes componentes:

- Frontend Angular
- Servidor WebSocket-TCP
- Servidor Java
- Cliente de Mensajes Aleatorios

## Requisitos

- Docker
- Docker Compose

## Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/FepDev25/Examen-final
cd Examen-final
```

2. Iniciar los servicios:
```bash
docker-compose up
```

o 

```bash
docker compose up
```

## Acceso a la aplicación

- Frontend: http://localhost:4200
- WebSocket: ws://localhost:8080
- Servidor Java: localhost:12345

## Estructura del proyecto

- `angular-app/`: Frontend en Angular
- `puente-tcp-ws/`: Servidor puente WebSocket-TCP
- `servidor/`: Servidor Java principal
- `mensajesaleatorios/`: Cliente Java de mensajes aleatorios

## Imágenes Docker

Las imágenes están disponibles en Docker Hub:

- felipe2p05/examen-angular-app
- felipe2p05/examen-puente-ws
- felipe2p05/examen-servidor
- felipe2p05/examen-mensajes-aleatorios 