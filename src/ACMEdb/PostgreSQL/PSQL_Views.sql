/**
 * Author:  azaelmglw
 * Created: Nov 19, 2018
 */

CREATE OR REPLACE VIEW Purchases AS
SELECT
compras.compraid AS "Id",
proveedores_sucursal.sucursalid AS "Branch_Office_Id",
proveedores_sucursal.proveedorid AS "Provider_Id",
proveedores.empresa AS "Brand",
compras.usuarioid AS "User_Id",
CONCAT(usuarios.nombre, ' ', usuarios.apellido_paterno, ' ', usuarios.apellido_materno) AS "User_Name",
compras.fecha_compra AS "Date",
compras.subtotal_compra AS "Subtotal",
compras.iva AS "Iva",
compras.total AS "Total"
FROM compras
INNER JOIN proveedores_sucursal ON (compras.prosucid = proveedores_sucursal.prosucid)
INNER JOIN proveedores ON (proveedores_sucursal.proveedorid = proveedores.proveedorid)
INNER JOIN usuarios ON (compras.usuarioid = usuarios.usuarioid);

CREATE OR REPLACE VIEW Sales AS
SELECT
ventas.ventaid AS "Id",
ventas.sucursalid AS "Branch_Office_Id",
CONCAT(clientes.nombre, ' ', clientes.apellido_paterno, ' ', clientes.apellido_materno) AS "Client_Name",
ventas.usuarioid AS "User_Id",
CONCAT(usuarios.nombre, ' ', usuarios.apellido_paterno, ' ', usuarios.apellido_materno) AS "User_Name",
ventas.fecha_venta AS "Date",
ventas.subtotal_venta AS "Subtotal",
ventas.total_ahorrado AS "Saved_Total",
ventas.iva AS "Iva",
ventas.total AS "Total"
FROM Ventas
INNER JOIN clientes ON (ventas.clienteid = clientes.clienteid)
INNER JOIN usuarios ON (ventas.usuarioid = usuarios.usuarioid);



