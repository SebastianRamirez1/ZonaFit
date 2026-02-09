# ZonaFit 💪

ZonaFit es una aplicación desarrollada en **Java** para la gestión de clientes de un gimnasio, siguiendo una **arquitectura por capas** y buenas prácticas de desarrollo usadas en entornos profesionales.

El proyecto está diseñado para ser escalable, mantenible y fácil de extender, separando claramente el acceso a datos, la lógica del dominio y la configuración de infraestructura.

> Estado actual: en desarrollo activo.

---

## 🎯 Propósito del proyecto

- Implementar una arquitectura limpia basada en **DAO (Data Access Object)**
- Gestionar información de clientes mediante una base de datos relacional
- Aplicar buenas prácticas de conexión y acceso a datos con **JDBC**
- Simular un flujo de trabajo real con **Git y GitHub** (ramas, commits, control de cambios)

---

## 🛠️ Tecnologías

- **Java SE**
- **MySQL**
- **JDBC**
- **Maven**
- **Git / GitHub**
- **IntelliJ IDEA**

---

## 🧱 Arquitectura

El proyecto sigue una estructura por capas:

src/
└── main/
└── java/
└── zona_fit/
├── conexion/ # Configuración de la conexión a la base de datos
├── dao/ # Interfaces y clases de acceso a datos (DAO)
├── dominio/ # Clases de dominio (Cliente)
└── main/ # Punto de entrada y pruebas


### Capas principales
- **Dominio**: Representa las entidades del negocio.
- **DAO**: Encapsula todo el acceso a la base de datos.
- **Conexión**: Centraliza la configuración JDBC.
- **Main**: Orquestación y pruebas de ejecución.

---

## ⚙️ Funcionalidades implementadas

- Conexión a base de datos MySQL mediante JDBC
- Listado de clientes
- Búsqueda de cliente por ID
- Mapeo de resultados SQL a objetos de dominio

---

## 🚀 Funcionalidades previstas

- Registro de nuevos clientes
- Actualización de información de clientes
- Eliminación de clientes
- Capa Service para lógica de negocio
- Manejo avanzado de recursos JDBC
- Preparación para integración con frameworks (Spring)

---

## 🗄️ Base de datos

Estructura principal utilizada:

```sql
CREATE TABLE cliente (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  membresia INT
);
▶️ Ejecución del proyecto
Requisitos
JDK 17 o compatible

MySQL Server

Maven configurado

Base de datos creada y accesible

Configura las credenciales de conexión en la clase correspondiente antes de ejecutar.

📌 Notas técnicas
El proyecto prioriza claridad arquitectónica y mantenibilidad

No se utilizan frameworks para mantener el control total sobre JDBC

Pensado como base para evolución a aplicaciones empresariales más complejas

👤 Autor
Sebastian Ramirez
Desarrollador Java
Proyecto de portafolio profesional
