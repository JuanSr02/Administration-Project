-- Creación de la tabla Persona
CREATE TABLE IF NOT EXISTS Persona (
    ID INT PRIMARY KEY,
    nombreCompleto VARCHAR(255) NOT NULL,
    DNI_CUIT_CUIL BIGINT UNIQUE NOT NULL,
    telefono BIGINT,
    email VARCHAR(255)
);

-- Creación de la tabla Martillero (hereda de Persona)
CREATE TABLE IF NOT EXISTS Martillero (
    ID INT PRIMARY KEY,
    matricula VARCHAR(50) NOT NULL,
    FOREIGN KEY (ID) REFERENCES Persona(ID)
);

-- Creación de la tabla Propiedad
CREATE TABLE IF NOT EXISTS Propiedad (
    ID INT PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    plano VARCHAR(255),
    moneda VARCHAR(10),
    formaPago VARCHAR(50),
    estado VARCHAR(50),
    fotos TEXT,
    notas TEXT,
    duenioID INT,
    FOREIGN KEY (duenioID) REFERENCES Persona(ID)
);

-- Creación de las tablas específicas de Propiedad
CREATE TABLE IF NOT EXISTS Casa (
    ID INT PRIMARY KEY,
    M2Cubiertos INT,
    M2Descubiertos INT,
    Ambientes VARCHAR(50),
    estadoProp VARCHAR(50),
    servicios_comodidades TEXT,
    Precio_Venta_Alquiler DOUBLE,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID)
);

CREATE TABLE IF NOT EXISTS Departamento (
    ID INT PRIMARY KEY,
    M2Cubiertos INT,
    M2Descubiertos INT,
    Ambientes VARCHAR(50),
    estadoProp VARCHAR(50),
    servicios_comodidades TEXT,
    Precio_Venta_Alquiler DOUBLE,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID)
);

CREATE TABLE IF NOT EXISTS Terreno_Lote (
    ID INT PRIMARY KEY,
    M2s INT,
    estadoProp VARCHAR(50),
    servicios_comodidades TEXT,
    Precio_Venta_Alquiler DOUBLE,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID)
);

CREATE TABLE IF NOT EXISTS LocalComercial (
    ID INT PRIMARY KEY,
    M2Cubiertos INT,
    Ambientes VARCHAR(50),
    estadoProp VARCHAR(50),
    Precio_Venta_Alquiler DOUBLE,
    FOREIGN KEY (ID) REFERENCES Propiedad(ID)
);

-- Creación de la tabla Transaccion
CREATE TABLE IF NOT EXISTS Transaccion (
    ID INT PRIMARY KEY,
    nombreComprador VARCHAR(255),
    IDinmueble INT,
    fecha DATE NOT NULL,
    monto DOUBLE,
    FOREIGN KEY (IDinmueble) REFERENCES Propiedad(ID)
);

-- Inserción de datos de prueba
INSERT INTO Persona (ID, nombreCompleto, DNI_CUIT_CUIL, telefono, email)
VALUES (1, 'Juan Pérez', 20304050607, 1122334455, 'juan.perez@gmail.com'),
       (2, 'Ana Martínez', 27364583922, 1199887766, 'ana.martinez@hotmail.com');

INSERT INTO Martillero (ID, matricula)
VALUES (1, 'MAT12345');

INSERT INTO Propiedad (ID, direccion, plano, moneda, formaPago, estado, fotos, notas, duenioID)
VALUES (1, 'Av. Siempre Viva 742', NULL, 'USD', 'Contado', 'Disponible', 'foto1.jpg,foto2.jpg', 'Excelente ubicación', 2);

INSERT INTO Casa (ID, M2Cubiertos, M2Descubiertos, Ambientes, estadoProp, servicios_comodidades, Precio_Venta_Alquiler)
VALUES (1, 120, 50, '3 ambientes', 'A estrenar', 'Pileta, cochera', 150000);

INSERT INTO Transaccion (ID, nombreComprador, IDinmueble, fecha, monto)
VALUES (1, 'Carlos López', 1, '2024-11-18', 145000);
