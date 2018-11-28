/**
 * Author:  azaelmglw
 * Created: Nov 14, 2018
 */

CREATE OR REPLACE FUNCTION obtain_branch_office_details(in_sucursalid varchar)
RETURNS TABLE(Current_Managers varchar, Current_Employees varchar, Current_Providers varchar, Current_Stock varchar,
Spent_In_Purchases varchar, Gained_From_Sales varchar) 
AS $$

    DECLARE
    loop_prosucid RECORD;
    purchases_total double precision = 0;

    
    BEGIN
        FOR loop_prosucid IN SELECT prosucid FROM proveedores_sucursal WHERE sucursalid = in_sucursalid ORDER BY prosucid LOOP
                IF (SELECT SUM(total) FROM compras WHERE prosucid = loop_prosucid.prosucid) > 0
                THEN
                    purchases_total = purchases_total + CAST((SELECT SUM(total) FROM compras WHERE prosucid = loop_prosucid.prosucid) AS double precision);
                ELSE
                    purchases_total = purchases_total + 0;
                END IF;
        END LOOP;

        RETURN QUERY 
        SELECT
            CAST((SELECT COUNT(usuarioid) FROM gerentes_sucursal WHERE sucursalid = in_sucursalid) AS varchar),
            CAST((SELECT COUNT(usuarioid) FROM usuarios WHERE sucursalid = in_sucursalid) AS varchar),
            CAST((SELECT COUNT(proveedorid) FROM proveedores_sucursal WHERE sucursalid = in_sucursalid) AS varchar),
            CAST((SELECT SUM(existencia) FROM productos_sucursal WHERE sucursalid = in_sucursalid) AS varchar),
            CAST(purchases_total AS varchar),
            CAST((SELECT SUM(total) FROM ventas WHERE sucursalid = in_sucursalid) AS varchar)
        ;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION obtain_product_branch_offices_stock(in_productoid varchar)
RETURNS TABLE(Branch_Office varchar, Stock varchar)
AS $$

    BEGIN
        RETURN QUERY
        SELECT
            (SELECT sucursalid FROM productos_sucursal WHERE productoid = in_productoid),
            CAST((SELECT existencia FROM productos_sucursal WHERE productoid = in_productoid) AS varchar)
        ;
    END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION obtain_purchase_details(in_compraid varchar)
RETURNS TABLE(Product_Id varchar, Product_Name varchar, Product_Quantity varchar, Purchase_Price varchar, Total varchar)
AS $$

    BEGIN
        RETURN QUERY
        SELECT detalle_compras.productoid,
        productos.nombre, 
        CAST(detalle_compras.cantidad_producto AS varchar),
        CAST(detalle_compras.precio_compra AS varchar),
        CAST(detalle_compras.total AS varchar)
        FROM detalle_compras
        INNER JOIN productos ON (detalle_compras.productoid = productos.productoid)
        WHERE detalle_compras.compraid = in_compraid
        ;
    END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION obtain_sale_details(in_ventaid varchar)
RETURNS TABLE(Product_Id varchar, Product_Name varchar, Product_Quantity varchar, Sale_Price varchar, Total varchar)
AS $$

    BEGIN
        RETURN QUERY
        SELECT detalle_ventas.productoid,
        productos.nombre, 
        CAST(detalle_ventas.cantidad_producto AS varchar),
        CAST(detalle_ventas.precio_venta AS varchar),
        CAST(detalle_ventas.total AS varchar)
        FROM detalle_ventas
        INNER JOIN productos ON (detalle_ventas.productoid = productos.productoid)
        WHERE detalle_ventas.ventaid = in_ventaid
        ;
    END;
$$
LANGUAGE plpgsql;

