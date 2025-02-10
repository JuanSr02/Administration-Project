CREATE TABLE IF NOT EXISTS Persona (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    nombreCompleto VARCHAR(255) NOT NULL,
    DNI_CUIT_CUIL VARCHAR(20) NOT NULL UNIQUE,
    telefono VARCHAR(15),
    email VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS Propiedad (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    -- Ruta del plano
    plano VARCHAR(255),
    moneda VARCHAR(10),
    formaPago VARCHAR(50),
    estado VARCHAR(50),
     -- Array de rutas de fotos
    fotos JSON,
    notas_servicios_comodidades VARCHAR(255),
    M2Cubiertos INT,
    M2Descubiertos INT,
    Ambientes VARCHAR(100),
    Precio_Venta_Alquiler DOUBLE,
    -- Relación con Persona (dueño)
    duenio INT,
    -- Relación con Persona (inquilino, si aplica)
    inquilino INT,
    FOREIGN KEY (duenio) REFERENCES Persona(ID) ON DELETE CASCADE,
    FOREIGN KEY (inquilino) REFERENCES Persona(ID)
    );
CREATE TABLE IF NOT EXISTS Casa (
    -- Mismo ID que Propiedad
    ID INT PRIMARY KEY,
    -- Relación con Propiedad
    FOREIGN KEY (ID) REFERENCES Propiedad(ID) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS Departamento (
    -- Mismo ID que Propiedad
    ID INT PRIMARY KEY,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS LocalComercial (
    ID INT PRIMARY KEY,
    -- Relación con Propiedad
    FOREIGN KEY (ID) REFERENCES Propiedad(ID) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS Terreno_Lote (
    ID INT PRIMARY KEY,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS Transaccion (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    -- Relación con Persona (comprador)
    nombreComprador INT,
    -- Relación con Propiedad
    IDinmueble INT,
    fecha VARCHAR(20),
    monto DOUBLE,
    FOREIGN KEY (nombreComprador) REFERENCES Persona(ID) ON DELETE CASCADE,
    FOREIGN KEY (IDinmueble) REFERENCES Propiedad(ID) ON DELETE CASCADE
);