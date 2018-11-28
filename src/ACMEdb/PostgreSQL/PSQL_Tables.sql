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
Estado              varchar(21)         NOT NULL,
Activo_Sucursal     boolean             NOT NULL    DEFAULT                     'T'  
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
Estado              varchar(21)         NOT NULL,
Activo_Proveedor    boolean             NOT NULL    DEFAULT                     'T'
);

CREATE TABLE productos(
ProductoID          varchar(9)          NOT NULL    PRIMARY KEY,
Nombre              varchar(40)         NOT NULL,
Tipo                varchar(30)         NOT NULL,
Marca               varchar(20)         NOT NULL,
Precio_Venta        double precision    CHECK       (Precio_Venta >= 0)         NOT NULL,
Unidad_Medida       varchar(2)          NOT NULL,
Activo_Producto     boolean             NOT NULL    DEFAULT                     'T'
);

CREATE TABLE descuentos(
DescuentoID         varchar(5)          NOT NULL    PRIMARY KEY,
Nombre_Descuento    varchar(15)         NOT NULL,
Porcentaje_Aplicado smallint            CHECK       (Porcentaje_Aplicado > 0)   NOT NULL,
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
Estado              varchar(21)         NOT NULL,
Numero_Seguro       char(11)            NOT NULL,
CURP                char(18)            NOT NULL,
Contraseña          bytea               NOT NULL,
Activo_Usuario      boolean             NOT NULL   DEFAULT                      'T',

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
Estado              varchar(21)         NOT NULL,
Fecha_Creacion      date                NOT NULL    DEFAULT                     NOW(),
Total_Acumulado     double precision    CHECK       (Total_Acumulado >= 0)      NOT NULL    DEFAULT     0,
Activo_Cliente      boolean             NOT NULL    DEFAULT                     'T',

FOREIGN KEY         (DescuentoID)       REFERENCES  descuentos                  (DescuentoID)                           
);

CREATE TABLE descuentos_acumulado(
DesAcuID            varchar(5)          NOT NULL    PRIMARY KEY,
DescuentoID         varchar(5)          NOT NULL,
Bandera_Acumulacion double precision    CHECK       (Bandera_Acumulacion >= 0)  NOT NULL,
Activo_Descuento    boolean             NOT NULL    DEFAULT                     'T',

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
Activo_Distribucion boolean             NOT NULL    DEFAULT                     'T',

FOREIGN KEY         (SucursalID)        REFERENCES  sucursales                  (SucursalID),
FOREIGN KEY         (ProveedorID)       REFERENCES  proveedores                 (ProveedorID)
);

CREATE TABLE productos_sucursal(
ProSucID            varchar(15)         NOT NULL    PRIMARY KEY,
SucursalID          varchar(4)          NOT NULL,
ProductoID          varchar(9)          NOT NULL,
Existencia          integer             CHECK       (Existencia >= 0)           NOT NULL,

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
Fecha_Compra        date                NOT NULL    DEFAULT                     NOW(),
Subtotal_Compra     double precision    CHECK       (Subtotal_Compra >= 0)      NOT NULL,
IVA                 double precision    CHECK       (IVA > 0)                   NOT NULL,
Total               double precision    CHECK       (Total > 0)                 NOT NULL,

FOREIGN KEY         (ProSucID)          REFERENCES  proveedores_sucursal        (ProSucID),
FOREIGN KEY         (UsuarioID)         REFERENCES  usuarios                    (UsuarioID)
);

CREATE TABLE ventas(
VentaID             varchar(12)         NOT NULL   PRIMARY KEY,
SucursalID          varchar(4)          NOT NULL,
ClienteID           varchar(10)         NOT NULL,
UsuarioID           varchar(7)          NOT NULL,
Fecha_Venta         date                NOT NULL    DEFAULT                     NOW(),
Subtotal_Venta      double precision    CHECK       (Subtotal_Venta > 0)        NOT NULL,
Total_Ahorrado      double precision    CHECK       (Total_Ahorrado > 0)        NOT NULL,
IVA                 double precision    CHECK       (IVA > 0)                   NOT NULL,
Total               double precision    CHECK       (Total > 0)                 NOT NULL,

FOREIGN KEY         (SucursalID)        REFERENCES  sucursales                  (SucursalID),
FOREIGN KEY         (ClienteID)         REFERENCES  clientes                    (ClienteID),
FOREIGN KEY         (UsuarioID)         REFERENCES  usuarios                    (UsuarioID)
);

CREATE TABLE detalle_compras(
DetComID            varchar(13)         NOT NULL    PRIMARY KEY,
CompraID            varchar(12)         NOT NULL,
ProductoID          varchar(9)          NOT NULL,
Cantidad_Producto   smallint            CHECK       (Cantidad_Producto > 0)     NOT NULL,
Precio_Compra       double precision    CHECK       (Precio_Compra > 0)         NOT NULL,
Total               double precision    CHECK       (Total > 0)                 NOT NULL,

FOREIGN KEY         (CompraID)          REFERENCES  compras                     (CompraID),
FOREIGN KEY         (ProductoID)        REFERENCES  productos                   (ProductoID)
);

CREATE TABLE detalle_ventas(
DetVenID            varchar(15)         NOT NULL    PRIMARY KEY,
VentaID             varchar(12)         NOT NULL,
ProductoID          varchar(9)          NOT NULL,   
Cantidad_Producto   smallint            CHECK       (Cantidad_Producto > 0)     NOT NULL,
Precio_Venta        double precision    CHECK       (Precio_Venta > 0)          NOT NULL,
Total               double precision    CHECK       (Total > 0)                 NOT NULL,

FOREIGN KEY         (VentaID)           REFERENCES  ventas                      (VentaID),
FOREIGN KEY         (ProductoID)        REFERENCES  productos                   (ProductoID)
);
