[![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk&logoColor=white)](https://www.oracle.com/java/technologies/downloads/)
[![JavaFX](https://img.shields.io/badge/JavaFX-21-orange?logo=java&logoColor=white)](https://openjfx.io/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Hibernate](https://img.shields.io/badge/Hibernate-6.4.0-red?logo=hibernate&logoColor=white)](https://hibernate.org/)
[![JPA](https://img.shields.io/badge/JPA-Java%20Persistence%20API-green?logo=java&logoColor=white)](https://jakarta.ee/specifications/persistence/)
[![MVC](https://img.shields.io/badge/Pattern-MVC-yellow?logo=code&logoColor=white)](https://en.wikipedia.org/wiki/Model–view–controller)

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
<img width="1000" height="839" alt="{9BB56F4D-2948-41BD-ACF2-47C658FA7F47}" src="https://github.com/user-attachments/assets/294412a5-4e36-4899-8471-f0d3d0ee3348" />
<img width="991" height="828" alt="{9D8F516B-A643-4D85-89FF-2619B96117A8}" src="https://github.com/user-attachments/assets/97e0e843-f880-4786-84eb-31316671d367" />
<img width="981" height="820" alt="{6B6D25D2-B1ED-433F-B605-544F6A638AEA}" src="https://github.com/user-attachments/assets/e819f7ca-bb61-45c8-9d58-a0a67f0defa0" />
<img width="974" height="806" alt="{3C78ABA9-7F4E-49F8-9A63-4BF4586505A8}" src="https://github.com/user-attachments/assets/c57c168a-eb42-4d2f-8565-62b6ccfa6fdd" />


---

## 📌 Notas

* El sistema está orientado a la gestión de propiedades para **martilleros públicos**.
* Incluye soporte para imágenes de propiedades dentro del flujo de administración.
* Persistencia robusta gracias a **Hibernate + MySQL**.

---

## 👨‍💻 Autor

* Juan Manuel Sanchez Rodriguez.
