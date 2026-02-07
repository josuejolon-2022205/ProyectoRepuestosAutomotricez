Drop database if exists DBRepuestosAutomotriz_in5cm; 
create database DBRepuestosAutomotriz_in5cm; 
use DBRepuestosAutomotriz_in5cm; 

create table Proveedores( 
	id_proveedor int auto_increment not null, 
	nombre_proveedor varchar(60) not null, 
	telefono_proveedor int not null, 
	direccion varchar(100) not null, 
	email_proveedor varchar(100) not null, 
	primary key PK_id_proveedor(id_proveedor) 
    
); 

create table Empleados( 
	id_empleado int auto_increment not null, 
	nombre_empleado varchar(60) not null, 
	apellido_empleado varchar(60) not null, 
	puesto_empleado varchar(20) null, 
	email_empleado varchar(100) not null, 
	primary key PK_id_empleado(id_empleado) 
    
); 

create table Repuestos( 
	id_repuesto int auto_increment not null, 
	nombre_repuesto varchar(60) not null, 
	categoria_repuesto varchar(60) not null, 
	precio_compra double not null, 
	precio_venta double not null, 
	id_proveedor int not null, 
	primary key PK_id_repuesto(id_repuesto), 
	constraint FK_repuesto_proveedor foreign key (id_proveedor)  
	references proveedores(id_proveedor) on delete cascade 
    
); 

create table Ventas( 
	id_venta int auto_increment not null, 
	fecha_venta date not null, 
	cantidad int not null, 
	total double not null, 
	id_empleado int not null, 
	id_repuesto int not null, 
	primary key PK_id_venta(id_venta), 
	constraint FK_ventas_empleado foreign key (id_empleado)  
	references Empleados(id_empleado) on delete cascade, 
	constraint FK_ventas_repuestos foreign key (id_repuesto)  
	references Repuestos(id_repuesto) on delete cascade 
    
);


delimiter $$
create procedure sp_agregarProveedor(
    in p_nombreProveedor varchar(60),
    in p_telefonoProveedor int,
    in p_direccion varchar(100),
    in p_emailProveedor varchar(100)

)
begin
	insert into Proveedores(nombre_proveedor, telefono_proveedor, direccion, email_proveedor) values
    (p_nombreProveedor, p_telefonoProveedor, p_direccion, p_emailProveedor);
    select last_insert_id() as id_proveedor;
    
end $$
delimiter ;

call sp_agregarProveedor('autopartes gomez', 5551234, 'calle principal 123', 'autopartesgomez@gmail.com');
call sp_agregarProveedor('repuestos unidos', 5555678, 'avenida central 45', 'repuestosunidos@gmail.com');
call sp_agregarProveedor('importadora f1', 5559012, 'zona industrial b6', 'importadoraf1@gmail.com');
call sp_agregarProveedor('frenos y mas', 5553456, 'boulevard los proceres 78', 'frenosymas@gmail.com');
call sp_agregarProveedor('llantas el rayo', 5557890, 'calle 10 sur 22', 'llantaselrayo@gmail.com');
call sp_agregarProveedor('motores del norte', 5551122, 'sector norte bodega 3', 'motoresdelnorte@gmail.com');
call sp_agregarProveedor('electrico auto', 5553344, 'avenida las americas 9', 'electricoauto@gmail.com');
call sp_agregarProveedor('lubricantes express', 5555566, 'carretera nacional km 5', 'lubricantesexpress@gmail.com');
call sp_agregarProveedor('clutch y prensa', 5557788, 'diagonal 4-50 zona 1', 'clutchyprensa@gmail.com');
call sp_agregarProveedor('filtros premium', 5559900, 'parque logistico local 12', 'filtrospremium@gmail.com');


delimiter $$
create procedure sp_mostrarProveedor()
begin
	select * from Proveedores order by id_proveedor;
end $$
delimiter ;

delimiter $$
create procedure sp_actualizarProveedor(
	in p_idProveedor int,
    in p_nombreProveedor varchar(60),
    in p_telefonoProveedor int,
    in p_direccion varchar(100),
    in p_emailProveedor varchar(100)
    
)
begin
	update Proveedores set nombre_proveedor = p_nombreProveedor, telefono_proveedor = p_telefonoProveedor, direccion = p_direccion, email_proveedor = p_emailProveedor
    where id_proveedor = p_idProveedor;
end $$
delimiter ;

delimiter $$
create procedure sp_eliminarProveedor(
	in p_idProveedor int 
)
begin
	delete from Proveedores where id_proveedor = p_idProveedor;
    
end $$
delimiter ;

delimiter $$
create procedure sp_mostrarEmpleados()
begin
	select * from Empleados order by id_empleado;
end $$
delimiter ;

delimiter $$
create procedure sp_agregarEmpleado(
	in p_nombreEmpleado varchar(60),
    in p_apellidoEmpleado varchar(60),
    in p_puestoEmpleado varchar (20),
    in p_emailEmpleado varchar(100)
)
begin
	insert into Empleados(nombre_empleado, apellido_empleado, puesto_empleado, email_empleado) values
    (p_nombreEmpleado, p_apellidoEmpleado, p_puestoEmpleado, p_emailEmpleado);
    select last_insert_id() as id_empleado;
end $$
delimiter ;

call sp_agregarEmpleado('juan','perez','vendedor','juan.perez@gmail.com');
call sp_agregarEmpleado('maria','lopez','cajera','maria.lopez@gmail.com');
call sp_agregarEmpleado('carlos','garcia','gerente','carlos.garcia@gmail.com');
call sp_agregarEmpleado('ana','martinez','vendedora','ana.martinez@gmail.com');
call sp_agregarEmpleado('luis','rodriguez','vendedor','luis.rodriguez@gmail.com');
call sp_agregarEmpleado('sofia','hernandez','atencion','sofia.hernandez@gmail.com');
call sp_agregarEmpleado('pedro','sanchez','vendedor','pedro.sanchez@gmail.com');
call sp_agregarEmpleado('laura','diaz','cajera','laura.diaz@gmail.com');
call sp_agregarEmpleado('jorge','castro','supervisor','jorge.castro@gmail.com');
call sp_agregarEmpleado('elena','ruiz','vendedora','elena.ruiz@gmail.com');



delimiter $$
create procedure sp_actualizarEmpleado(
	in p_idEmpleado int,
    in p_nombreEmpleado varchar(60),
    in p_apellidoEmpleado varchar(60),
    in p_puestoEmpleado varchar (20),
    in p_emailEmpleado varchar(100)
)
begin
	update Empleados set nombre_empleado = p_nombreEmpleado, apellido_empleado = p_apellidoEmpleado, puesto_empleado = p_puestoEmpleado, email_empleado = p_emailEmpleado
    where id_empleado = p_idEmpleado;
    
end $$
delimiter ;

delimiter $$
create procedure sp_eliminarEmpleado(
	in p_idEmpleado int
)
begin
	delete from Empleados where id_empleado = p_idEmpleado;
end $$
delimiter ;

delimiter $$
create procedure sp_mostrarRepuestos()
begin
	select * from Repuestos order by id_repuesto;
end $$
delimiter ;

delimiter $$
create procedure sp_agregarRepuesto(
	in p_nombreRepuesto varchar(60), 
    in p_categoriaRepuesto varchar(60),
    in p_precioCompra double,
    in p_precioVenta double,
    in p_idProveedor int

)
begin
	insert into Repuestos(nombre_repuesto, categoria_repuesto, precio_compra, precio_venta, id_proveedor)values
    (p_nombreRepuesto, p_categoriaRepuesto, p_precioCompra, p_precioVenta, p_idProveedor);
    
end $$
delimiter ; 

call sp_agregarRepuesto('pastillas de freno','frenos',15.50,25.00,4);
call sp_agregarRepuesto('filtro de aceite','motor',5.00,12.00,10);
call sp_agregarRepuesto('bujia iridium','encendido',8.00,15.00,7);
call sp_agregarRepuesto('aceite 10w40','lubricantes',20.00,35.00,8);
call sp_agregarRepuesto('disco de embrague','transmision',45.00,75.00,9);
call sp_agregarRepuesto('faro delantero','iluminacion',30.00,55.00,3);
call sp_agregarRepuesto('bateria 12v','electrico',50.00,85.00,7);
call sp_agregarRepuesto('amortiguador tras','suspension',25.00,45.00,1);
call sp_agregarRepuesto('radiador h2o','refrigeracion',60.00,110.00,6);
call sp_agregarRepuesto('correa tiempo','motor',12.00,28.00,1);


delimiter $$
create procedure sp_actualizarRepuesto(
	in p_idRepuesto int,
	in p_nombreRepuesto varchar(60), 
    in p_categoriaRepuesto varchar(60),
    in p_precioCompra double,
    in p_precioVenta double
    
)
begin
	update Repuestos set nombre_repuesto = p_nombreRepuesto, categoria_repuesto = p_categoriaRepuesto, precio_compra = p_precioCompra, precio_venta = p_precioVenta 
    where id_repuesto = p_idRepuesto;
    select last_insert_id() as id_repuesto;
end $$
delimiter ;

delimiter $$
create procedure sp_eliminarRepuesto(
	in p_idRepuesto int
)	
begin
	delete from Repuestos where id_repuesto = p_idRepuesto;
end $$
delimiter ;

delimiter $$
create procedure sp_mostrarVentas()
begin
	select * from Ventas order by id_venta;
end $$
delimiter ; 


delimiter $$
create procedure sp_agregarVenta(
	in p_fechaVenta date,
    in p_cantidad int,
    in p_total double,
    in p_idEmpleado int,
    in p_idRepuesto int

)
begin
	insert into Ventas(fecha_venta, cantidad, total, id_empleado, id_repuesto)values
    (p_fechaVenta, p_cantidad, p_total, p_idEmpleado, p_idRepuesto);
    
end $$
delimiter ;

call sp_agregarVenta('2024-02-01',2,50.00,1,1);
call sp_agregarVenta('2024-02-01',1,12.00,4,2);
call sp_agregarVenta('2024-02-02',4,60.00,5,3);
call sp_agregarVenta('2024-02-02',1,35.00,7,4);
call sp_agregarVenta('2024-02-03',1,75.00,10,5);
call sp_agregarVenta('2024-02-03',2,110.00,1,6);
call sp_agregarVenta('2024-02-03',1,85.00,4,7);
call sp_agregarVenta('2024-02-04',2,90.00,5,8);
call sp_agregarVenta('2024-02-04',1,110.00,7,9);
call sp_agregarVenta('2024-02-04',1,28.00,10,10);


delimiter $$
create procedure sp_actualizarVenta(
	in p_idVenta int,
	in p_fechaVenta date,
    in p_cantidad int,
    in p_total double,
    in p_idEmpleado int,
    in p_idRepuesto int

)
begin
	update Ventas set fecha_venta = p_fechaVenta, cantidad = p_cantidad,  total = p_total, id_empleado = p_idEmpleado, id_Repuesto = p_idRepuesto 
    where id_venta = p_idVenta; 
    select last_insert_id() as id_venta;

end $$
delimiter ;

delimiter $$
create procedure sp_eliminarVenta(
	in p_idVenta int
)
begin 
	delete from Ventas where id_venta = p_idVenta;
end $$
delimiter ;