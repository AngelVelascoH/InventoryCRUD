-- Crear la tabla "ubicacion"
CREATE TABLE location (
                           locationId INT PRIMARY KEY AUTO_INCREMENT,
                           state VARCHAR(255) NOT NULL,
                           address VARCHAR(255) ,
                           phoneNumber VARCHAR(15)
);

-- Crear la tabla "item" con una clave foránea hacia "ubicacion"
CREATE TABLE item (
                      itemId INT PRIMARY KEY NOT NULL,
                      itemName VARCHAR(255) NOT NULL,
                      description TEXT,
                      location INT,
                      FOREIGN KEY (location) REFERENCES location(locationId)
);
