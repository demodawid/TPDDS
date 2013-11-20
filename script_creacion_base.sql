GO
USE [DDS2013]
GO
IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = N'DDS')
EXEC sys.sp_executesql N'CREATE SCHEMA [DDS] AUTHORIZATION [dbo]'
GO


----------------------------------------BANDA------------------------------------
USE [DDS2013]
GO
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [DDS].[Banda](
	[id_banda] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](255) NOT NULL,
 CONSTRAINT [PK_Banda] PRIMARY KEY CLUSTERED 
(
	[id_banda] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

INSERT INTO DDS.Banda (nombre)
VALUES ('ACDC')
INSERT INTO DDS.Banda (nombre)
VALUES ('Led Zeppelin')
INSERT INTO DDS.Banda (nombre)
VALUES ('Metallica')
INSERT INTO DDS.Banda (nombre)
VALUES ('Pink Floyd')
INSERT INTO DDS.Banda (nombre)
VALUES ('Iron Maiden')
INSERT INTO DDS.Banda (nombre)
VALUES ('Black Sabbath')
INSERT INTO DDS.Banda (nombre)
VALUES ('Judas Priest')
INSERT INTO DDS.Banda (nombre)
VALUES ('Deep Purple')
INSERT INTO DDS.Banda (nombre)
VALUES ('Queen')
INSERT INTO DDS.Banda (nombre)
VALUES ('The Beatles')
INSERT INTO DDS.Banda (nombre)
VALUES ('Los Piojos')
INSERT INTO DDS.Banda (nombre)
VALUES ('La Renga')
INSERT INTO DDS.Banda (nombre)
VALUES ('Attaque 77')
----------------------------------------Festival--------------------------------------------
USE [DDS2013]
GO
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [DDS].[Festival](
	[id_festival] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](255) NOT NULL,
	[predio] [varchar](255) NOT NULL,
	[vigente] [bit] NOT NULL,
 CONSTRAINT [PK_Festival] PRIMARY KEY CLUSTERED 
(
	[id_festival] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [DDS].[Festival] ADD  CONSTRAINT [DF_Festival_vigente]  DEFAULT ((1)) FOR [vigente]
GO

INSERT INTO DDS.Festival (nombre, predio)
VALUES ('Quilmes Rock', 'Estadio Monumental')

INSERT INTO DDS.Festival (nombre, predio)
VALUES ('Rock in Rio', 'GEBA')

INSERT INTO DDS.Festival (nombre, predio)
VALUES ('Woodstock', 'Estadio Amalfitani')

----------------------------------------------------NOCHE-----------------------------------------------

USE [DDS2013]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [DDS].[Noche](
	[id_noche] [int] IDENTITY(1,1) NOT NULL,
	[id_festival] [int] NOT NULL,
	[numero] [int] NOT NULL,
	[fecha] [datetime] NOT NULL,
	[fecha_fin_anticipada] [datetime] NOT NULL,
	[descuento] [int] NOT NULL,
	[hora_inicio] [time](7) NOT NULL,
 CONSTRAINT [PK_Noche] PRIMARY KEY CLUSTERED 
(
	[id_noche] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [DDS].[Noche]  WITH CHECK ADD  CONSTRAINT [FK_Noche_Festival] FOREIGN KEY([id_festival])
REFERENCES [DDS].[Festival] ([id_festival])
GO

ALTER TABLE [DDS].[Noche] CHECK CONSTRAINT [FK_Noche_Festival]
GO


INSERT INTO DDS.Noche (id_festival, numero, fecha, fecha_fin_anticipada, descuento, hora_inicio)
VALUES (1, 1, '2013-20-05', '2013-18-05', 20, '20:00:00')
INSERT INTO DDS.Noche (id_festival, numero, fecha, fecha_fin_anticipada, descuento, hora_inicio)
VALUES (1, 2, '2013-21-05', '2013-19-05', 15, '21:00:00')
INSERT INTO DDS.Noche (id_festival, numero, fecha, fecha_fin_anticipada, descuento, hora_inicio)
VALUES (1, 3, '2013-22-05', '2013-20-05', 15, '21:00:00')

INSERT INTO DDS.Noche (id_festival, numero, fecha, fecha_fin_anticipada, descuento, hora_inicio)
VALUES (2, 1, '2013-11-11', '2013-08-11', 15, '21:00:00')
INSERT INTO DDS.Noche (id_festival, numero, fecha, fecha_fin_anticipada, descuento, hora_inicio)
VALUES (2, 2, '2013-12-11', '2013-09-11', 15, '21:30:00')
INSERT INTO DDS.Noche (id_festival, numero, fecha, fecha_fin_anticipada, descuento, hora_inicio)
VALUES (2, 3, '2013-13-11', '2013-10-11', 20, '21:00:00')

INSERT INTO DDS.Noche (id_festival, numero, fecha, fecha_fin_anticipada, descuento, hora_inicio)
VALUES (3, 1, '2013-04-07', '2013-03-07', 10, '22:00:00')
INSERT INTO DDS.Noche (id_festival, numero, fecha, fecha_fin_anticipada, descuento, hora_inicio)
VALUES (3, 2, '2013-05-07', '2013-04-07', 10, '22:00:00')
INSERT INTO DDS.Noche (id_festival, numero, fecha, fecha_fin_anticipada, descuento, hora_inicio)
VALUES (3, 3, '2013-06-07', '2013-05-07', 10, '22:00:00')


--------------------------------------------------NOCHE_BANDA--------------------------------------------
USE [DDS2013]
GO
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [DDS].[Noche_Banda](
	[id_noche] [int] NOT NULL,
	[id_banda] [int] NOT NULL,
	[turno] [int] NOT NULL,
	[duracion_horas] [int] NOT NULL
) ON [PRIMARY]

GO

ALTER TABLE [DDS].[noche_banda]  WITH CHECK ADD  CONSTRAINT [FK_noche_banda_Banda] FOREIGN KEY([id_banda])
REFERENCES [DDS].[Banda] ([id_banda])
GO

ALTER TABLE [DDS].[noche_banda] CHECK CONSTRAINT [FK_noche_banda_Banda]
GO

ALTER TABLE [DDS].[noche_banda]  WITH CHECK ADD  CONSTRAINT [FK_noche_banda_Noche] FOREIGN KEY([id_noche])
REFERENCES [DDS].[Noche] ([id_noche])
GO

ALTER TABLE [DDS].[noche_banda] CHECK CONSTRAINT [FK_noche_banda_Noche]
GO

--Quilmes Rock
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (1, 1, 1, 2)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (1, 2, 2, 2)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (1, 3, 3, 2)

INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (2, 4, 1, 3)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (2, 5, 2, 2)

INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (3, 6, 1, 3)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (3, 7, 2, 3)

--Rock in Rio
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (4, 8, 1, 3)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (4, 9, 2, 2)

INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (5, 10, 1, 2)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (5, 11, 2, 2)

INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (6, 12, 1, 2)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (6, 8, 2, 3)

--Woodstock
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (7, 13, 1, 1)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (7, 1, 2, 2)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (7, 2, 3, 3)

INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (8, 3, 1, 2)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (8, 4, 2, 3)

INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (9, 5, 1, 2)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (9, 6, 2, 3)
INSERT INTO DDS.Noche_Banda (id_noche, id_banda, turno, duracion_horas)
VALUES (9, 7, 3, 2)


----------------------------------------------------Butaca------------------------------------------
USE [DDS2013]
GO
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [DDS].[Butaca](
	[id_butaca] [int] IDENTITY(1,1) NOT NULL,
	[id_noche] [int] NOT NULL,
	[numero] [int] NOT NULL,
	[sector] [varchar](255) NOT NULL,
	[precio] [numeric](18, 2) NOT NULL,
 CONSTRAINT [PK_Butaca] PRIMARY KEY CLUSTERED 
(
	[id_butaca] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [DDS].[Butaca]  WITH CHECK ADD  CONSTRAINT [FK_Butaca_Noche] FOREIGN KEY([id_noche])
REFERENCES [DDS].[Noche] ([id_noche])
GO

ALTER TABLE [DDS].[Butaca] CHECK CONSTRAINT [FK_Butaca_Noche]
GO




--D = Disponible, O = Ocupada
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   1, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   2, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   3, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   4, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   5, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   6, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   7, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   8, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   9, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   10, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (1,   11, 'Platea', 500.0)

INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   1, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   2, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   3, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   4, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   5, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   6, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   7, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   8, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   9, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   10, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (2,   11, 'Platea', 500.0)

INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   1, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   2, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   3, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   4, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   5, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   6, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   7, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   8, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   9, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   10, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (3,   11, 'Platea', 500.0)

INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   1, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   2, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   3, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   4, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   5, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   6, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   7, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   8, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   9, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   10, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (4,   11, 'Platea', 500.0)

INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   1, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   2, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   3, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   4, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   5, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   6, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   7, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   8, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   9, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   10, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (5,   11, 'Platea', 500.0)

INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   1, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   2, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   3, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   4, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   5, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   6, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   7, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   8, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   9, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   10, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (6,   11, 'Platea', 500.0)

INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   1, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   2, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   3, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   4, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   5, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   6, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   7, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   8, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   9, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   10, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (7,   11, 'Platea', 500.0)

INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   1, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   2, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   3, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   4, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   5, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   6, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   7, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   8, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   9, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   10, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (8,   11, 'Platea', 500.0)

INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   1, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   2, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   3, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   4, 'Vip', 1000.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   5, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   6, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   7, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   8, 'Campo', 250.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   9, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   10, 'Platea', 500.0)
INSERT INTO DDS.Butaca (id_noche, numero, sector, precio)
VALUES (9,   11, 'Platea', 500.0)

-------------------------------------------------Entrada--------------------------------------------------
USE [DDS2013]
GO

/****** Object:  Table [DDS].[Entrada]    Script Date: 11/18/2013 03:06:10 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [DDS].[Entrada](
	[id_entrada] [int] IDENTITY(1,1) NOT NULL,
	[id_butaca] [int] NOT NULL,
	[anticipada] [bit] NOT NULL,
	[precio_final] [numeric](18, 2) NOT NULL,
	[fecha_venta] [datetime] NOT NULL,
 CONSTRAINT [PK_Entrada] PRIMARY KEY CLUSTERED 
(
	[id_entrada] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [DDS].[Entrada]  WITH CHECK ADD  CONSTRAINT [FK_Entrada_Butaca] FOREIGN KEY([id_butaca])
REFERENCES [DDS].[Butaca] ([id_butaca])
GO

ALTER TABLE [DDS].[Entrada] CHECK CONSTRAINT [FK_Entrada_Butaca]
GO

INSERT INTO DDS.Entrada(id_butaca, anticipada, precio_final, fecha_venta)
(
	SELECT but.id_butaca, 1, but.precio - ( (but.precio * noc.descuento) / 100 ) as precio_final, noc.fecha_fin_anticipada
	FROM DDS.Butaca but
	INNER JOIN DDS.Noche noc
		ON noc.id_noche = but.id_noche
	WHERE but.id_butaca IN (2,5,11,13,16,22,24,27,33,35,38,44,46,49,55,57,60,66,68,71,77,79,82,88,90,93,99)
)
