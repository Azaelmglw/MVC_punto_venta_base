/**
 * Author:  azaelmglw
 * Created: Nov 14, 2018
 */

SELECT
(SELECT COUNT(usuarioid) FROM gerentes_sucursal WHERE sucursalid = 'SU0') AS Current_Managers,
(SELECT COUNT(usuarioid) FROM usuarios WHERE sucursalid = 'SU0') AS Current_Employees,
(SELECT COUNT(proveedorid) FROM proveedores_sucursal WHERE sucursalid = 'SU0') AS Current_Providers,
(SELECT SUM(existencia) FROM productos_sucursal WHERE sucursalid = 'SU0') AS Current_Stock,
(SELECT SUM(total) FROM compras WHERE sucursalid = 'SU0') AS Spent_In_Purchases,
(SELECT SUM(total) FROM ventas WHERE sucursalid = 'SU0') AS Gained_From_Sales
;

SELECT sucursalid, existencia AS Stock FROM productos_sucursal WHERE productoid = 'PR0';

CREATE OR REPLACE VIEW Purchases AS
SELECT
compras.compraid AS "Id",
proveedores_sucursal.sucursalid AS "branch_office_id",
proveedores_sucursal.proveedorid AS "provider_id",
compras.usuarioid AS "user_id",
CONCAT(usuarios.nombre, ' ', usuarios.apellido_paterno, ' ', usuarios.apellido_materno) AS "user_name",
compras.fecha_compra AS "date",
compras.subtotal_compra AS "subtotal",
compras.iva AS "iva",
compras.total AS "total"
FROM compras
INNER JOIN proveedores_sucursal ON (compras.prosucid = proveedores_sucursal.prosucid)
INNER JOIN usuarios ON (compras.usuarioid = usuarios.usuarioid);


