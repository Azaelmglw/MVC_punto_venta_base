/**
 * Author:  azaelmglw
 * Created: Nov 5, 2018
 */

CREATE EXTENSION pgcrypto;

GRANT ALL PRIVILEGES ON 
sucursales,             proveedores,        productos,              descuentos,
usuarios,               clientes,           descuentos_acumulado,   descuentos_temporada,
proveedores_sucursal,   productos_sucursal, gerentes_sucursal,      compras,
ventas,                 detalle_compras,    detalle_ventas,         purchases,
sales,                  managers
TO azaelmglw;