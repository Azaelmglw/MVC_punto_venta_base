/**
 * Author:  azaelmglw
 * Created: Nov 5, 2018
 */

CREATE TABLE sucursales(
SucursalID          varchar(4)          NOT NULL    PRIMARY KEY,
Numero              varchar(3)          NOT NULL,
Colonia             varchar(25)         NOT NULL,
Codigo_Postal       char(5)             NOT NULL,
Email               varchar(30)         NOT NULL,
Telefono            char(13)            NOT NULL,
Ciudad              varchar(20)         NOT NULL,
Estado              varchar(20)         NOT NULL,
Activo_Sucursal     boolean             NOT NULL    DEFAULT                     TRUE  
);

CREATE TABLE proveedores(
ProveedorID         varchar(5)          NOT NULL    PRIMARY KEY,
Nombre              varchar(30)         NOT NULL,
Apellido_Paterno    varchar(20)         NOT NULL,
Apellido_Materno    varchar(20)         NOT NULL,
Empresa             varchar(20)         NOT NULL,
Telefono            char(13)            NOT NULL,
Calle               varchar(25)         NOT NULL,
Colonia             varchar(25)         NOT NULL,
Numero              varchar(5)          NOT NULL,
Codigo_Postal       char(5)             NOT NULL,
Email               varchar(30)         NOT NULL,
Ciudad              varchar(20)         NOT NULL,
Estado              varchar(20)         NOT NULL,
Activo_Proveedor    boolean             NOT NULL    DEFAULT                     TRUE
);

CREATE TABLE productos(
ProductoID          varchar(9)          NOT NULL    PRIMARY KEY,
Nombre              varchar(40)         NOT NULL,
Tipo                varchar(30)         NOT NULL,
Marca               varchar(20)         NOT NULL,
Precio_Venta        double precision    NOT NULL    CHECK                       (Precio_Venta > 0),
Unidad_Medida       varchar(2)          NOT NULL,
Activo_Producto     boolean             NOT NULL    DEFAULT                     TRUE
);

CREATE TABLE descuentos(
DescuentoID         varchar(5)          NOT NULL    PRIMARY KEY,
Nombre_Descuento    varchar(15)         NOT NULL,
Porcentaje_Aplicado smallint            NOT NULL    CHECK                       (Porcentaje_Aplicado > 0),
Tipo                varchar(9)          NOT NULL    DEFAULT                     'Acumulado'
);

CREATE TABLE usuarios(
UsuarioID           varchar(7)          NOT NULL    PRIMARY KEY,
SucursalID          varchar(4)          NOT NULL,
Tipo                varchar(13)         NOT NULL    DEFAULT                     'Vendedor',
Nombre              varchar(30)         NOT NULL,
Apellido_Paterno    varchar(20)         NOT NULL,
Apellido_Materno    varchar(20)         NOT NULL,
Telefono            char(13)            NOT NULL,
RFC                 char(16)            NOT NULL,
Calle               varchar(25)         NOT NULL,
Colonia             varchar(25)         NOT NULL,
Numero_Interior     varchar(3)          NOT NULL,
Numero_Exterior     varchar(4)          NOT NULL,
Codigo_Postal       char(5)             NOT NULL,
Email               varchar(30)         NOT NULL,
Ciudad              varchar(20)         NOT NULL,
Estado              varchar(20)         NOT NULL,
Numero_Seguro       char(11)            NOT NULL,
CURP                char(18)            NOT NULL,
Contraseña          binary              NOT NULL,
Activo_Usuario      boolean             NOT NULL   DEFAULT                      TRUE,

FOREIGN KEY         (SucursalID)        REFERENCES sucursales                   (SucursalID)
);

CREATE TABLE clientes(
ClienteID           varchar(10)         NOT NULL    PRIMARY KEY,
DescuentoID         varchar(5)          NOT NULL,
Nombre              varchar(30)         NOT NULL,
Apellido_Paterno    varchar(20)         NOT NULL,
Apellido_Materno    varchar(20)         NOT NULL,
Telefono            char(13)            NOT NULL,
RFC                 char(16)            NOT NULL,
Calle               varchar(25)         NOT NULL,
Colonia             varchar(25)         NOT NULL,
Numero_Interior     varchar(3)          NOT NULL,
Numero_Exterior     varchar(4)          NOT NULL,
Codigo_Postal       char(5)             NOT NULL,
Email               varchar(30)         NOT NULL,
Ciudad              varchar(20)         NOT NULL,
Estado              varchar(20)         NOT NULL,
Fecha_Creacion      date                NOT NULL    DEFAULT                     NOW(),
Total_Acumulado     double precision    NOT NULL    CHECK                       (Total_Acumulado >= 0),
Activo_Cliente      boolean             NOT NULL    DEFAULT                     TRUE,

FOREIGN KEY         (DescuentoID)       REFERENCES  descuentos                  (DescuentoID)                           
);

CREATE TABLE descuentos_acumulado(
DesAcuID            varchar(5)          NOT NULL    PRIMARY KEY,
DescuentoID         varchar(5)          NOT NULL,
Bandera_Acumulacion double precision    NOT NULL    CHECK                       (Bandera_Acumulacion > 0),
Activo_Descuento    boolean             NOT NULL    DEFAULT                     TRUE,

FOREIGN KEY         (DescuentoID)       REFERENCES  descuentos                  (DescuentoID)                  
);

CREATE TABLE descuentos_temporada(
DesTenID            varchar(5)          NOT NULL    PRIMARY KEY,
DescuentoID         varchar(5)          NOT NULL,
Fecha_Inicio        date                NOT NULL    DEFAULT                     NOW(),
Fecha_Expiracion    date                NOT NULL,

FOREIGN KEY         (DescuentoID)       REFERENCES  descuentos                  (DescuentoID)
);

CREATE TABLE proveedores_sucursal(
ProSucID            varchar(6)          NOT NULL    PRIMARY KEY,
SucursalID          varchar(4)          NOT NULL,
ProveedorID         varchar(5)          NOT NULL,
Activo_Distribucion boolean             NOT NULL    DEFAULT                     TRUE,

FOREIGN KEY         (SucursalID)        REFERENCES  sucursales                  (SucursalID),
FOREIGN KEY         (ProveedorID)       REFERENCES  proveedores                 (ProveedorID)
);

CREATE TABLE productos_sucursal(
ProSucID            varchar(15)         NOT NULL    PRIMARY KEY,
SucursalID          varchar(4)          NOT NULL,
ProductoID          varchar(9)          NOT NULL,
Existencia          integer             NOT NULL    CHECK                       (Existencia >= 0),

FOREIGN KEY         (SucursalID)        REFERENCES  sucursales                  (SucursalID),
FOREIGN KEY         (ProductoID)        REFERENCES  productos                   (ProductoID)
);

CREATE TABLE gerentes_sucursal(
GenSucID            varchar(8)          NOT NULL    PRIMARY KEY,
SucursalID          varchar(4)          NOT NULL,
UsuarioID           varchar(7)          NOT NULL,

FOREIGN KEY         (SucursalID)        REFERENCES  sucursales                  (SucursalID),
FOREIGN KEY         (UsuarioID)         REFERENCES  usuarios                    (UsuarioID)
);

CREATE TABLE compras(
CompraID            varchar(12)         NOT NULL    PRIMARY KEY,
ProSucID            varchar(6)          NOT NULL,
UsuarioID           varchar(7)          NOT NULL,
Fecha_Compra        date                NOT NULL,
Subtotal_Compra     double precision    NOT NULL    CHECK                       (Subtotal_Compra >= 0),
IVA                 double precision    NOT NULL    CHECK                       (IVA > 0),
Total               double precision    NOT NULL    CHECK                       (Total > 0),

FOREIGN KEY         (ProSucID)          REFERENCES  proveedores_sucursal        (ProSucID),
FOREIGN KEY         (UsuarioID)         REFERENCES  usuarios                    (UsuarioID)
);

CREATE TABLE ventas(
VentaID             varchar(12)         NOT NULL    PRIMARY KEY,
SucursalID          varchar(4)          NOT NULL,
ClienteID           varchar(10)         NOT NULL,
UsuarioID           varchar(7)          NOT NULL,
Fecha_Venta         date                NOT NULL    DEFAULT                     NOW(),
Subtotal            double precision    NOT NULL    CHECK                       (Subtotal > 0),
Total_Ahorrado      double precision    NOT NULL    CHECK                       (Total_Ahorrado > 0),
IVA                 double precision    NOT NULL    CHECK                       (IVA > 0),
Total               double precision    NOT NULL    CHECK                       (Total > 0),

FOREIGN KEY         (SucursalID)        REFERENCES  sucursales                  (SucursalID),
FOREIGN KEY         (ClienteID)         REFERENCES  clientes                    (ClienteID),
FOREIGN KEY         (UsuarioID)         REFERENCES  usuarios                    (UsuarioID)
);

CREATE TABLE detalle_compras(
DetComID            varchar(13)         NOT NULL    PRIMARY KEY,
CompraID            varchar(12)         NOT NULL,
ProductoID          varchar(9)          NOT NULL,
Cantidad_Producto   smallint            NOT NULL    CHECK                       (Cantidad_Producto > 0),
Precio_Compra       double precision    NOT NULL    CHECK                       (Precio_Compra > 0),
Total               double precision    NOT NULL    CHECK                       (Total > 0),

FOREIGN KEY         (CompraID)          REFERENCES  compras                     (CompraID),
FOREIGN KEY         (ProductoID)        REFERENCES  productos                   (ProductoID)
);

CREATE TABLE detalle_ventas(
DetVenID            varchar(15)         NOT NULL    PRIMARY KEY,
VentaID             varchar(12)         NOT NULL,
ProductoID          varchar(9)          NOT NULL,   
Cantidad_Producto   smallint            NOT NULL    CHECK                       (Cantidad_Producto > 0),
Precio_Venta        double precision    NOT NULL    CHECK                       (Precio_Venta > 0),
Total               double precision    NOT NULL    CHECK                       (Total > 0),

FOREIGN KEY         (VentaID)           REFERENCES  ventas                      (VentaID),
FOREIGN KEY         (ProductoID)        REFERENCES  productos                   (ProductoID)
);