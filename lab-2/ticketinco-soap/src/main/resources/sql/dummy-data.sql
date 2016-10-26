-- Tomcat Users
INSERT INTO comprador (id, nombre) VALUES (1, 'tomcat');

-- EVENTO
INSERT INTO evento (id, nombre, fecha) VALUES (1, 'Pilsen Rock', '2016-12-19');
INSERT INTO evento (id, nombre, fecha) VALUES (2, 'Futbol - Campeon del siglo vs cndf', '2016-11-15');
INSERT INTO evento (id, nombre, fecha) VALUES (3, 'Concierto Rombai', '2030-03-24');
INSERT INTO evento (id, nombre, fecha) VALUES (4, 'Film - No respires', '2017-07-08');

-- HORARIO
INSERT INTO horario (id, hora, evento_id) VALUES (1, '10:00', 1);
INSERT INTO horario (id, hora, evento_id) VALUES (2, '16:00', 2);
INSERT INTO horario (id, hora, evento_id) VALUES (3, '12:00', 3);
INSERT INTO horario (id, hora, evento_id) VALUES (4, '14:00', 3);
INSERT INTO horario (id, hora, evento_id) VALUES (7, '18:00', 4);
INSERT INTO horario (id, hora, evento_id) VALUES (8, '21:00', 4);
INSERT INTO horario (id, hora, evento_id) VALUES (9, '23:00', 4);
INSERT INTO horario (id, hora, evento_id) VALUES (10, '02:00', 4);

-- DISPONIBILIDAD
INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (1, 'Unico', 500.0, 100, 1);

INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (2, 'Amsterdam', 300.0, 10, 2);
INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (3, 'Colombes', 100.0, 5, 2);
INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (4, 'Olimpica', 500.0, 25, 2);
INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (5, 'America', 700.0, 20, 2);


INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (6, 'A', 250.0, 30, 3);
INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (7, 'B', 300.0, 30, 4);
INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (8, 'C', 300.0, 30, 4);

INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (9, 'Butaca', 200.0, 30, 7);
INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (10, 'Butaca', 300.0, 50, 8);
INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (11, 'Butaca', 300.0, 15, 9);
INSERT INTO disponibilidad (id, sector, precio, cantidad_disponible, horario_id) VALUES (12, 'ButacaNochera', 100.0, 5, 10);