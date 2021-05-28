drop table if exists tbvendedor;
create table tbvendedor
(
    vende_id_vendedor int auto_increment primary key,
    vende_nombre_vendedor varchar(30) ,
    vende_Apellido_vendedor varchar(30),
    vende_correo_vendedor varchar(30)
);



drop table if exists tbusuario;
CREATE TABLE `tbusuario` (
  `usu_id_usuario` int(11) NOT NULL,
  `usu_nombre_usuario` varchar(30) DEFAULT NULL,
  `usu_apellido_usuario` varchar(30) DEFAULT NULL,
  `usu_correo_vendedor` varchar(30) DEFAULT NULL,
  `contrasena` varchar(30) NOT NULL,
  `num_cel` varchar(20) NOT NULL,
  `usu_dir` varchar(40) NOT NULL,
  `recuperacion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbusuario`
--

INSERT INTO `tbusuario` (`usu_id_usuario`, `usu_nombre_usuario`, `usu_apellido_usuario`, `usu_correo_vendedor`, `contrasena`, `num_cel`, `usu_dir`, `recuperacion`) VALUES
(5, 'Andres Felipe', 'rojas', 'andresolmos2784@gmail.com', '78945', '3103977412', 'diagonal 14c numero19-46b', 'skefalutruc'),
(6, 'clemencia', 'rojas vargas', 'sadasd@gmail.com', '', '304399882', 'diagonal 14c numero19-46b', '');


drop table if exists tbproducto;
create table tbproducto
(   
    pro_id_producto int auto_increment primary key,
    pro_serial varchar(30),
    pro_nombre_producto varchar(30),
    pro_descripcion_producto varchar(400),
    pro_fecha_lote date,
    pro_fecha_vencimiento date,
    pro_precio_producto varchar(4),
    pro_estado_producto varchar(4)
);

drop table if exists tbencabezado_factura;
create table tbencabezado_factura
(   
    enc_id_factura int auto_increment primary key,
    enc_id_comprador int,
    enc_id_pago int,
    enc_id_vendedor int,
    enc_id_envio int,
    enc_forma_pago varchar(30),
    enc_fecha_compra date,
    enc_nombre_comprador varchar(30),
    enc_apellido_comprador varchar(30),
    enc_correo_comprador varchar(30),
    enc_nombre_vendedor varchar(30),
    enc_apellido_vendedor varchar(30), 
    enc_correo_vendedor varchar(30)
);

drop table if exists tbdetalle_factura;
create table tbdetalle_factura
(
    detfac_id_producto int auto_increment primary key,
    detfac_nombre_producto varchar(30),
    detfac_cantidad_producto varchar(30),
    detfac_precio_producto varchar(30)
);

drop table if exists tbenvio;
create table tbenvio
(   
    env_id_envio int auto_increment primary key,
    env_id_comprador int,
    env_id_producto int
);

drop table if exists tbroles;
create table tbroles
(   
    rol_id_rol int auto_increment primary key,
    rol_tipo_rol varchar(30)
);

drop table if exists TBpedido;
create table TBpedido
(   
    pedi_id_pedido int auto_increment primary key,
    pedi_id_producto int,
    pedi_id_vendedor int, 
    pedi_id_comprador int
);

drop table if exists tbcomprador;
create table tbcomprador
(
    compra_id_comprador int auto_increment primary key,
    compra_id_carrito int,
    compra_nombre_comprador varchar(30),
    compra_apellido_comprador varchar(30),
    compra_correo_comprador varchar(30),
    compra_historial varchar(30),
    compra_confianza varchar(10),
    compra_estado_compra varchar(5)
);

drop table if exists tb_forma_pago;
create table tb_forma_pago
(
    formpa_id_pago int auto_increment primary key,
    formpa_descripcion_pago varchar(200)
);


drop table if exists TBcarrito;
create table TBcarrito
(
    carri_id_carrito int auto_increment primary key,
    carri_id_producto int
);

alter table tbenvio add
foreign key (env_id_comprador) references tbcomprador(compra_id_comprador);

alter table tbenvio add
foreign key(env_id_producto) references tbproducto(pro_id_producto);

alter table tbcarrito add
foreign key(carri_id_producto) references tbproducto(pro_id_producto);

alter table tbcomprador add
foreign key (compra_id_carrito) references tbcarrito(carri_id_carrito);

alter table tbencabezado_factura add
foreign key(enc_id_comprador) references tbcomprador(compra_id_comprador);

alter table tbencabezado_factura add
foreign key(enc_id_pago) references tb_forma_pago(formpa_id_pago);

alter table tbencabezado_factura add
foreign key(enc_id_vendedor) references tbvendedor(vende_id_vendedor);

alter table tbencabezado_factura add
foreign key(enc_id_envio) references tbenvio(env_id_envio);

alter table tbenvio add 
foreign key(env_id_comprador) references tbcomprador(compra_id_comprador);

alter table tbenvio add
foreign key(env_id_producto) references tbproducto(pro_id_producto);

alter table tbpedido add
foreign key(pedi_id_vendedor) references tbvendedor(vende_id_vendedor);

alter table tbpedido add
foreign key(pedi_id_comprador) references tbcomprador(compra_id_comprador);



23 de febrero
19:29
