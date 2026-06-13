# 🩺 PetHealth API

> Sistema de Gestión Clínica Veterinaria desarrollado con Java y Spring Boot aplicando Arquitectura Limpia (Clean Architecture / Hexagonal Architecture).

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)](https://www.postgresql.org/)
[![Swagger](https://img.shields.io/badge/OpenAPI-Swagger-success)](https://swagger.io/)
[![Architecture](https://img.shields.io/badge/Architecture-Clean%20%7C%20Hexagonal-blueviolet)]()

---

## 📖 Descripción

**PetHealth** es una API REST para la gestión de una clínica veterinaria, diseñada para modelar procesos reales del negocio y demostrar buenas prácticas de desarrollo backend empresarial.

El proyecto fue construido siguiendo principios de:

- Clean Architecture / Hexagonal Architecture
- Principios SOLID
- Separación de responsabilidades
- DTO Pattern
- Validaciones de negocio
- Manejo global de excepciones
- Documentación automática con OpenAPI / Swagger

Su principal objetivo es demostrar competencias en diseño de software, modelado de dominio, arquitectura backend y desarrollo de APIs escalables.

---

## 🎯 Objetivos del Proyecto

Este proyecto fue desarrollado para demostrar experiencia en:

- Diseño de APIs REST profesionales
- Arquitectura limpia y mantenible
- Modelado de dominio basado en reglas de negocio reales
- Desarrollo con Spring Boot
- Persistencia con JPA/Hibernate
- Buenas prácticas de ingeniería de software
- Documentación y mantenibilidad del código

---

# 🏗️ Arquitectura

PetHealth sigue una arquitectura basada en **Clean Architecture (Hexagonal)**, permitiendo mantener una clara separación entre dominio, lógica de negocio e infraestructura.

```text
src/main/java
│
├── domain
│   ├── model
│   └── repository
│
├── application
│   ├── dto
│   ├── service
│   └── service.impl
│
└── infrastructure
    ├── controller
    └── config
```

### Domain

Contiene el núcleo del negocio:

- Entidades
- Reglas del dominio
- Interfaces de repositorio

No depende de frameworks externos.

### Application

Implementa los casos de uso del sistema:

- DTOs
- Servicios
- Validaciones
- Lógica de negocio

### Infrastructure

Contiene los adaptadores externos:

- Controllers REST
- Configuración Swagger
- Persistencia con JPA/Hibernate
- Configuración de perfiles

---

# 🧬 Modelo de Dominio

El sistema representa la operación de una clínica veterinaria mediante cuatro entidades principales.

## 👤 Persona

Representa cualquier individuo dentro del sistema.

### Atributos

- id
- nombre
- apellido
- cedula
- email
- telefono
- tipoPersona

### Tipos disponibles

- DUENO
- VETERINARIO

---

## 👨‍⚕️ Veterinario

Especialización de Persona.

### Información adicional

- especialidad
- numeroLicencia

### Relación

```text
Persona 1 ── 1 Veterinario
```

Implementado mediante:

```java
@OneToOne
@MapsId
```

---

## 🐾 Mascota

Representa una mascota registrada en la clínica.

### Atributos

- id
- nombre
- especie
- raza
- fechaNacimiento

### Relación

```text
Persona (Dueño) 1 ── N Mascotas
```

---

## 🩺 Consulta Médica

Registra la atención veterinaria de una mascota.

### Atributos

- id
- fecha
- motivo
- diagnostico
- costo

### Relaciones

```text
Mascota 1 ── N Consultas
Veterinario 1 ── N Consultas
```

---

# ⚙️ Funcionalidades

## Gestión de Personas

- Crear personas
- Consultar personas
- Actualizar información
- Eliminar registros
- Validación de email único
- Validación de cédula única

### Gestión de Veterinarios

- Crear veterinarios desde una persona existente
- Asignar especialidad
- Asignar licencia profesional
- Mantener integridad Persona ↔ Veterinario

### Gestión de Mascotas

- Registro de mascotas
- Asociación con dueño
- Consulta y actualización de datos
- Validación de existencia del propietario

### Gestión de Consultas Médicas

- Registro de atenciones veterinarias
- Asociación con mascota y veterinario
- Registro de diagnóstico
- Registro de costos
- Historial de consultas

### Manejo Global de Excepciones

Implementación centralizada de errores mediante:

- ResourceNotFoundException
- MethodArgumentNotValidException

Respuestas JSON estandarizadas para todos los errores.

---

# 📚 Documentación API

La API incluye documentación automática mediante Swagger/OpenAPI.

### Swagger Online

https://pethealth-sa6d.onrender.com/swagger-ui/index.html

> ⚠️ La aplicación está desplegada en Render Free Tier. La primera solicitud puede tardar algunos segundos mientras el servicio se activa.

### Swagger Local

```text
http://localhost:8080/swagger-ui.html
```

Swagger permite:

- Explorar endpoints
- Ejecutar pruebas
- Revisar modelos de datos
- Validar request y response
- Consultar códigos de error

---

# 🛠️ Tecnologías Utilizadas

### Backend

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate
- Lombok

### Bases de Datos

- PostgreSQL
- H2 Database

### Documentación

- OpenAPI 3
- Swagger UI

### Arquitectura y Diseño

- Clean Architecture
- Hexagonal Architecture
- DTO Pattern
- Principios SOLID

---

# 🚀 Ejecución Local

## Prerrequisitos

- Java 21+
- Maven 3.9+
- Git

### Clonar repositorio

```bash
git clone https://github.com/AlejandroUyaguari/pethealth.git
cd pethealth
```

### Ejecutar aplicación

```bash
mvn spring-boot:run
```

---

# 🔄 Flujo del Sistema

```text
1. Se registra una Persona

2. Una Persona puede convertirse en:
   - Dueño
   - Veterinario

3. Un Dueño registra Mascotas

4. Un Veterinario atiende Mascotas

5. Se registran Consultas Médicas

6. Toda la información queda disponible mediante la API REST
```
---

# 👨‍💻 Autor

**Néstor Uyaguari**

IT Project Manager | Technical Coordinator | Software Engineer

📍 Santiago, Chile

💼 LinkedIn  
https://www.linkedin.com/in/alejandro-uyaguari-0807b318/

📫 Contacto  
alejandro.uyaguari@outlook.cl

👤 **Portafolio GitHub**  
https://github.com/AlejandroUyaguari/portfolio-nestor-uyaguari
