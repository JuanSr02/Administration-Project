# 🏠 Administration Project - Software Martillero

Este proyecto implementa un sistema de administración para una **martillera pública**, desarrollado en **Java 21** bajo el patrón **MVC** e interfaz gráfica con **JavaFX**.  
El sistema permite la gestión integral de propiedades y dueños, incluyendo búsqueda, CRUD y manejo de fotos.

---

## 🚀 Funcionalidades principales

- **Gestión de propiedades**  
  - Alta, baja, modificación y búsqueda de propiedades.  
  - Manejo de fotos asociadas a cada propiedad.  

- **Persistencia de datos**  
  - Uso de **JPA + Hibernate** para el mapeo objeto-relacional.  
  - Base de datos **MySQL** local.  

- **Arquitectura**  
  - Implementado bajo el **patrón MVC**.  
  - Interfaz de usuario construida con **JavaFX**.  

---

## 🛠️ Tecnologías utilizadas

- **Lenguaje**: Java 21  
- **Framework UI**: JavaFX  
- **Persistencia**: JPA + Hibernate  
- **Base de datos**: MySQL  
- **Patrón de arquitectura**: MVC  

---

## 📦 Requisitos previos

Para ejecutar el proyecto necesitarás:

- [Java 21](https://www.oracle.com/java/technologies/downloads/)  
- [JavaFX](https://openjfx.io/)  
- [MySQL](https://dev.mysql.com/downloads/)  
- Configurar conexión a la base de datos en el proyecto.  

---

## ▶️ Ejecución

1. Clonar el repositorio:
   git clone https://github.com/JuanSr02/Administration-Project

2. Configurar la base de datos MySQL local.

   * Crear base de datos:

     CREATE DATABASE martillero_db;
     
   * Ajustar credenciales en el archivo de configuración de Hibernate/JPA.

3. Ejecutar la aplicación con JavaFX:

   mvn clean javafx:run

   o bien, desde tu IDE preferido (IntelliJ, Eclipse, NetBeans).

---

## 📸 Capturas de pantalla

*(Agregá aquí screenshots de la interfaz para ilustrar mejor la aplicación)*

---

## 📌 Notas

* El sistema está orientado a la gestión de propiedades para **martilleros públicos**.
* Incluye soporte para imágenes de propiedades dentro del flujo de administración.
* Persistencia robusta gracias a **Hibernate + MySQL**.

---

## 👨‍💻 Autor

* Juan Manuel Sanchez Rodriguez.
