
/**
 * Author:  jorge
 * Created: 28-ago-2016
 */

INSERT INTO vendedores (id, nombre, apellido, username, password, saldo, feedback)
    VALUES (default, 'Maribel', 'Gomez', 'Mago', '1234', 3000, 10);

INSERT INTO vendedores (id, nombre, apellido, username, password, saldo, feedback)
    VALUES (default, 'Fina', 'Gomez', 'Figo', '1234', 100, 10);

INSERT INTO CLIENTE (id, nombre, apellido, username, password, saldo)
    VALUES (default, 'Jorge', 'Sanchez', 'Sango', '1234', 3000);

INSERT INTO CLIENTE (id, nombre, apellido, username, password, saldo)
    VALUES (default, 'Adrian', 'Justicia', 'Ajus', '1234', 1900);

INSERT INTO producto (id, nombre, descripcion, foto, disponibilidad, precio,
                     id_vendedores)
    VALUES (default, 'Samsung Galaxy s6', 'Samsung Galaxy s6',
             'img/GalaxyS6.jpg', 20, 400, 1);

INSERT INTO producto (id, nombre, descripcion, foto, disponibilidad, precio,
                     id_vendedores)
    VALUES (default, 'Samsung Galaxy s7', 'Samsung Galaxy s7',
             'img/GalaxyS7.jpg', 20, 650, 1);

INSERT INTO producto (id, nombre, descripcion, foto, disponibilidad, precio,
                     id_vendedores)
    VALUES (default, 'iPhone 6s', 'iPhone 6s',
             'img/iPhone6s.JPG', 5, 10, 1);

INSERT INTO producto (id, nombre, descripcion, foto, disponibilidad, precio,
                     id_vendedores)
    VALUES (default, 'iPhone 6s Plus', 'iPhone 6s Plus',
             'img/iPhone6splus.jpg', 10, 999, 1);
