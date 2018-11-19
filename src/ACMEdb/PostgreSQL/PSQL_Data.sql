/**
 * Author:  azaelmglw
 * Created: Nov 5, 2018
 */


INSERT INTO sucursales(SucursalID, Numero, Colonia, Codigo_Postal, Email, Telefono, Ciudad, Estado)
VALUES
('SU0', '42', 'Pedregales', '48957', 'acmesu0@gmail.com', '775-128-63-89', 'Tulancingo', 'Hidalgo');


INSERT INTO proveedores(ProveedorID, Nombre, Apellido_Paterno, Apellido_Materno, Empresa, Telefono, Calle, 
Colonia, Numero, Codigo_Postal, Email, Ciudad, Estado)
VALUES
('PR0', 'Carlos',       'Ballarta', 'Hernandez', 'Truper', '775-105-54-55', 'Pajaritos',        'Lindavista',   '407',  '43680',    'caba@gmail.com',   'Tulancingo',   'Hidalgo'),
('PR1', 'Alfredo',      'Beltrán',  'Arreola',   'Ryobi',  '775-420-78-76', 'Compilador',       'Tecnológico',  '198',  '44610',    'alfbe@gmail.com',  'Pachuca',      'Hidalgo'),
('PR2', 'José',         'Perez',    'Mora',      'Ridgid', '775-223-41-02', 'Binario',          'Nativo',       '1',    '43197',    'jospe@gmail.com',  'Ixmiquilpan',  'Hidalgo'),
('PR3', 'Guillermo',    'Ugalde',   'Lopez',     'Bosch',  '775-589-03-12', 'Polimorfa',        'Abstracción',  '3308', '42010',    'guiug@gmail.com',  'Tizayuca',     'Hidalgo'),
('PR4', 'Lizeth',       'Soto',     'Vazquez',   'Makita', '775-951-17-06', 'Improvisación',    'Memoria',      '30', '43680',      'lizso@gmail.com',  'Zimapán',      'Hidalgo');


INSERT INTO productos(ProductoID, Nombre, Tipo, Marca, Precio_Venta, Unidad_Medida)
VALUES
('PR0', 'Martillo',       'Herramientas', 'Truper', 77.18,    'PZ'), 
('PR1', 'Destornillador', 'Herramientas', 'Truper', 44.33,    'PZ'), 
('PR2', 'Taladro',        'Herramientas', 'Truper', 1169.09,  'PZ'), 
('PR3', 'Pinzas',         'Herramientas', 'Truper', 68.92,    'PZ'), 
('PR4', 'Flexometro',     'Herramientas', 'Truper', 72.52,    'PZ');

INSERT INTO descuentos(DescuentoID, Nombre_Descuento, Porcentaje_Aplicado, Tipo)
VALUES
('DE0', 'Global',           3,  'Acumulado'),
('DE1', 'Nivel_1',          5,  'Acumulado'),
('DE2', 'Nivel_2',          7,  'Acumulado'),
('DE3', 'Nivel_3',          10, 'Acumulado'),
('DE4', 'Navidad_2018',     15, 'Temporada');

INSERT INTO usuarios(UsuarioID, SucursalID, Tipo, Nombre, Apellido_Paterno, Apellido_Materno, Telefono,
RFC, Calle, Colonia, Numero_Interior, Numero_Exterior, Codigo_Postal, Email, Ciudad, Estado, Numero_Seguro,
CURP, Contraseña)
VALUES
('US0', 'SU0',  'Administrador',    'Francisco',   'Becerril',   'Montero',    '775-117-98-29', 'BEMF940823T9H1N6',   'Veracruz', 'La Morena',    '7',    '117',  '43672',    'frabe@gmail.com',  'Tulancingo',   'Hidalgo',  '15014985173',  'LEFI861101HQTNYM16', digest('admin', 'sha256')),
('US1', 'SU0',  'Vendedor',         'Ramses',      'Badillo',    'Olguin',     '775-118-45-71', 'BAOR860814G3B0P3',   'Puebla',   'El Paraíso',   '1',    '442',  '43680',    'ramba@gmail.com',  'Tulancingo',   'Hidalgo',  '15022448111',  'ROMO941101HRUYYM16', digest('employee', 'sha256'));


INSERT INTO clientes(ClienteID, DescuentoID, Nombre, Apellido_Paterno, Apellido_Materno, Telefono, RFC, 
Calle, Colonia, Numero_Interior, Numero_Exterior, Codigo_Postal, Email, Ciudad, Estado, Total_Acumulado)
VALUES
('CL0', 'DE0',  'Pedro',    'Tecomalman',   'Gayosso',  '775-982-36-14',    'TEGP920722J9OA7B',   'Arrachera',    'Cortes',       '26',   '420',  '44872',    'pedte@gmail.com',  'Tulancingo', 'Hidalgo', 0),
('CL1', 'DE0',  'Victor',   'Rodriguez',    'Mendez',   '775-910-78-22',    'ROMV950814A0L6M2',   'Limón',        'Cítricos',     '1',    '38',   '43842',    'vicro@gmail.com',  'Tulancingo', 'Hidalgo', 0),
('CL2', 'DE0',  'Berenice', 'Gonzalez',     'Arellano', '775-114-18-73',    'GOAB920820B7T4V6',   'Toronja',      'Cítricos',     '1',    '13',   '43842',    'bergo@gmail.com',  'Tulancingo', 'Hidalgo', 0),
('CL3', 'DE0',  'Verónica', 'Veloz',        'Tirado',   '775-220-85-74',    'VETV9508101F8B5N',   'Adobada',      'Frituras',     '1',    '50',   '45170',    'verve@gmail.com',  'Pachuca',    'Hidalgo', 0),
('CL4', 'DE0',  'Gerardo',  'Nuez',         'Moreno',   '775-398-14-56',    'NUMG910816V8C9X7',   'Enchilada',    'Frituras',     '3',    '123',  '45170',    'gernu@gmail.com',  'Pachuca',    'Hidalgo', 0);


INSERT INTO descuentos_acumulado(DesAcuID, DescuentoID, Bandera_Acumulacion)
VALUES
('DA0', 'DE0',  0),
('DA1', 'DE1',  500),
('DA2', 'DE2',  3000),
('DA3', 'DE3',  15000);

INSERT INTO descuentos_temporada(DestenID, DescuentoID, Fecha_Inicio, Fecha_Expiracion)
VALUES
('DT0', 'DE4',  '2018/5/11',    '2018/12/26');

INSERT INTO proveedores_sucursal(ProSucID, SucursalID, ProveedorID)
VALUES
('PS0',    'SU0',   'PR0'),
('PS1',    'SU0',   'PR1'),
('PS2',    'SU0',   'PR2'),
('PS3',    'SU0',   'PR3'),
('PS4',    'SU0',   'PR4');

INSERT INTO productos_sucursal(ProSucID, SucursalID, ProductoID, Existencia)
VALUES
('PA0', 'SU0',  'PR0',  61),
('PA1', 'SU0',  'PR1',  72),
('PA2', 'SU0',  'PR2',  24),
('PA3', 'SU0',  'PR3',  47),
('PA4', 'SU0',  'PR4',  107);

INSERT INTO gerentes_sucursal(GenSucID, SucursalID, UsuarioID)
VALUES
('GS0', 'SU0',  'US0');

INSERT INTO compras(CompraID, ProSucID, UsuarioID, Subtotal_Compra, IVA, Total)
VALUES
('CO0', 'PS0', 'US1', 3770.76,  '16', 4374.0816),
('CO1', 'PS0', 'US1', 2717.06,  '16', 3151.7896),
('CO2', 'PS0', 'US1', 18648.25, '16', 21631.97),
('CO3', 'PS0', 'US1', 2684.64,  '16', 3114.1824),
('CO4', 'PS0', 'US1', 5626.58,  '16', 6526.8328);

INSERT INTO ventas(VentaID, SucursalID, ClienteID, UsuarioID, Subtotal_Venta, Total_Ahorrado, IVA, Total)
VALUES
('VE0', 'SU0', 'CL0', 'US1',  1252.076,     38.724,  '16',   1452.4082),
('VE1', 'SU0', 'CL1', 'US1',  140.6888,     4.3512,  '16',   163.199),
('VE2', 'SU0', 'CL0', 'US1',  267.4096,     8.2704,  '16',   310.1951),
('VE3', 'SU0', 'CL0', 'US1',  224.5938,     6.9462,  '16',   260.5288),
('VE4', 'SU0', 'CL0', 'US1',  149.7292,     4.6308,  '16',   173.6859);


INSERT INTO detalle_compras(DetComID, CompraID, ProductoID, Cantidad_Producto, Precio_Compra, Total)
VALUES
('DC0', 'CO0', 'PR0', 67,   56.28,   3770.76),
('DC1', 'CO1', 'PR1', 73,   37.22,   2717.06),
('DC2', 'CO2', 'PR2', 25,   745.93,  18648.25),
('DC3', 'CO3', 'PR3', 51,   52.64,   2684.64),
('DC4', 'CO4', 'PR4', 109,  51.62,   5626.58);

INSERT INTO detalle_ventas(DetVenID, VentaID, ProductoID, Cantidad_Producto, Precio_Venta, Total)
VALUES
('DE0', 'VE0', 'PR0',   1,  77.18,      77.18),
('DE1', 'VE0', 'PR1',   1,  44.33,      44.33),
('DE2', 'VE0', 'PR2',   1,  1169.09,    1169.09),
('DE3', 'VE1', 'PR4',   2,  72.52,      145.04),
('DE4', 'VE2', 'PR3',   4,  68.92,      275.68),
('DE5', 'VE3', 'PR0',   3,  77.18,      231.54),
('DE6', 'VE4', 'PR0',   2,  77.18,      154.36);
