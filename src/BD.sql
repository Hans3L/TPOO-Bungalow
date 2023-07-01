CREATE DATABASE HOTEL;
USE HOTEL;
/**tabla bungalow**/
CREATE  TABLE IF NOT EXISTS BUNGALOW (bungalowId int primary key unique, category int not null, priceDay double, statusRoom int not null);
/**tabla producto**/
create table Producto(Producto_id int primary key auto_increment, Producto_name varchar(8),Producto_Detail varchar(35),Producto_Stock int(8),Producto_PrecioUnit double);
/**tabla usuario**/
CREATE  TABLE IF NOT EXISTS USUARIO (UserId int primary key unique, FirstName varchar not null, LastName varchar, Dni varchar not null, Telefono Varchar);

INSERT INTO usuario (UserId, FirstName, LastName, Dni, Telefono ) VALUE (10001,Julio,Fernandez,12345678,987654321);
INSERT INTO usuario (UserId, FirstName, LastName, Dni, Telefono ) VALUE (10002,Juan,Sanchez,17645678,987654321);
INSERT INTO usuario (UserId, FirstName, LastName, Dni, Telefono ) VALUE (10003,Pedro,Lopez,15645678,987654321);

insert into usuarios(firstname,lastname,dni,telefono,email)values ("Juan", "Varillas", "12345678","123123123","jvarilas@gmail.com");
INSERT INTO bungalow (bungalowId, category, priceDay, statusRoom ) VALUE (10001,1,150.0,1);
INSERT INTO bungalow (bungalowId, category, priceDay, statusRoom ) VALUE (10002,3,300.00,0);
INSERT INTO bungalow (bungalowId, category, priceDay, statusRoom ) VALUE (10003,2,200.00,1);
INSERT INTO bungalow (bungalowId, category, priceDay, statusRoom ) VALUE (10004,3,300.00,0);
INSERT INTO bungalow (bungalowId, category, priceDay, statusRoom ) VALUE (10040,2,200.00,1);
insert into Producto values (123456789,'Jabón de cara','Producto de aseo personal',400,2.00);

SELECT * FROM hotel.bungalow;
SELECT * FROM hotel.usuarios;
SELECT * FROM hotel.Producto;