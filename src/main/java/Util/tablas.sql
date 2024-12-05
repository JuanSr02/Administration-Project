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
    plano VARCHAR(255), -- Ruta del plano
    moneda VARCHAR(10),
    formaPago VARCHAR(50),
    estado VARCHAR(50),
    fotos JSON, -- Array de rutas de fotos
    notas TEXT,
    duenio INT, -- Relación con Persona (dueño)
    FOREIGN KEY (duenio) REFERENCES Persona(ID)
);
CREATE TABLE IF NOT EXISTS Martillero (
    ID INT PRIMARY KEY, -- Mismo ID que Persona
    matricula VARCHAR(50) NOT NULL UNIQUE,
    propiedades JSON, -- Array de IDs de propiedades
    FOREIGN KEY (ID) REFERENCES Persona(ID) -- Relación con Persona
);

CREATE TABLE IF NOT EXISTS Casa (
    ID INT PRIMARY KEY, -- Mismo ID que Propiedad
    M2Cubiertos INT,
    M2Descubiertos INT,
    Ambientes VARCHAR(100),
    estadoProp VARCHAR(50),
    servicios_comodidades TEXT,
    Precio_Venta_Alquiler DOUBLE,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID) -- Relación con Propiedad
);
CREATE TABLE IF NOT EXISTS Departamento (
    ID INT PRIMARY KEY, -- Mismo ID que Propiedad
    M2Cubiertos INT,
    M2Descubiertos INT,
    Ambientes VARCHAR(100),
    estadoProp VARCHAR(50),
    servicios_comodidades TEXT,
    Precio_Venta_Alquiler DOUBLE,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID) -- Relación con Propiedad
);
CREATE TABLE IF NOT EXISTS LocalComercial (
    ID INT PRIMARY KEY, -- Mismo ID que Propiedad
    M2Cubiertos INT,
    Ambientes VARCHAR(100),
    estadoProp VARCHAR(50),
    Precio_Venta_Alquiler DOUBLE,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID) -- Relación con Propiedad
);
CREATE TABLE IF NOT EXISTS Terreno_Lote (
    ID INT PRIMARY KEY, -- Mismo ID que Propiedad
    M2s INT,
    estadoProp VARCHAR(50),
    servicios_comodidades TEXT,
    Precio_Venta_Alquiler DOUBLE,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID) -- Relación con Propiedad
);
CREATE TABLE IF NOT EXISTS Transaccion (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    nombreComprador INT, -- Relación con Persona (comprador)
    IDinmueble INT, -- Relación con Propiedad
    fecha DATE,
    monto DOUBLE,
    FOREIGN KEY (nombreComprador) REFERENCES Persona(ID),
    FOREIGN KEY (IDinmueble) REFERENCES Propiedad(ID)
);