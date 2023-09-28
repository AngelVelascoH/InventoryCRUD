
-- Registros en la tabla "location"
INSERT INTO location (location_id, address, phone_number, state) VALUES (1, 'Cto 8 José de San Martín mz 86', 5524356526, 'Edomex');
INSERT INTO location (location_id, address, phone_number, state) VALUES (2, 'Av. Juárez #123', 5551234567, 'CDMX');
INSERT INTO location (location_id, address, phone_number, state) VALUES (3, 'Av. Monterrey #456', 5567890123, 'NL');
INSERT INTO location (location_id, address, phone_number, state) VALUES (4, 'Paseo de la Reforma #789', 5543219876, 'CDMX');
INSERT INTO location (location_id, address, phone_number, state) VALUES (5, 'Calle Morelos #101', 5576543210, 'Puebla');

-- Registros en la tabla "item"
INSERT INTO item (item_id, description, item_name, location_id) VALUES (1, 'Laptop de 16 pulgadas con procesador Intel Core i7', 'Laptop Dell', 1);
INSERT INTO item (item_id, description, item_name, location_id) VALUES (2, 'Teléfono inteligente de última generación', 'Smartphone Samsung', 2);
INSERT INTO item (item_id, description, item_name, location_id) VALUES (3, 'Tableta Android con pantalla HD', 'Tablet ASUS', 3);
INSERT INTO item (item_id, description, item_name, location_id) VALUES (4, 'Impresora láser en blanco y negro', 'Impresora HP', 4);
INSERT INTO item (item_id, description, item_name, location_id) VALUES (5, 'Cámara digital DSLR con lentes intercambiables', 'Cámara Canon',5);
