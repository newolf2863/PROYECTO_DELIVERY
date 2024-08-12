# AMBAR EXPRESS

AMBAR EXPRESS es una aplicación diseñada para la gestión de encomiendas y paquetes. Ofrece funcionalidades para la emisión de facturas, cálculo de precios, y gestión de estados de los paquetes, facilitando así la administración eficiente de envíos y la interacción con los usuarios.

## Tabla de Contenidos
- [Descripción del Proyecto](#descripción-del-proyecto)
- [Características](#características)
- [Instalación](#instalación)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)

## Descripción del Proyecto
AMBAR EXPRESS es una aplicación orientada a la gestión y administración de paquetes y encomiendas. Facilita la cotización y emisión de facturas, la gestión de estados de los paquetes, y la interacción con diferentes tipos de usuarios, como clientes, conductores y recepcionistas. La aplicación permite:

- **Gestión de Paquetes:** Registro, consulta y modificación de paquetes.
- **Emisión de Facturas:** Generación de facturas detalladas para los paquetes.
- **Cálculo de Precios:** Cálculo de precios basado en diversas métricas como dimensiones, peso y distancia.
- **Gestión de Estados:** Actualización y consulta de estados de los paquetes.

## Características
- **Interfaz de Usuario:** Interfaz gráfica amigable para la interacción con la aplicación.
- **Gestión de Inventario:** Administración de los paquetes en inventario.
- **Cálculo Automático de Precios:** Basado en dimensiones, peso y distancia.
- **Emisión y Almacenamiento de Facturas:** Facturación y almacenamiento en formato serializado.
- **Gestión de Usuarios:** Diferentes roles con permisos específicos (Cliente, Conductor, Recepcionista).

## Instalación
### Clonar el Repositorio
```bash
git clone https://github.com/usuario/ambar-express.git](https://github.com/RodraHa/ProyectoPaquetes.git
cd ambar-express
```

## Estructura del Proyecto

- **`mod_administracion`**: Contiene clases para la administración y gestión de usuarios.
- **`mod_facturacion`**: Maneja la lógica relacionada con el cálculo de precios y emisión de facturas.
- **`mod_paquetes`**: Define la estructura y gestión de los paquetes.
- **`mod_incidentes`**: Gestiona los incidentes que pueden ocurrir en el transcurso de la entrega de un paquete.
- **`mod_transporte`**: Administra la asignación y seguimiento de los paquetes en tránsito.
- **`validaciones`**: Valida que los campos en el registro, actualización y demás, sean correctos.
- **`basededatos`**: Crea una conexión a una base de datos y realiza consultas e inserciones en ella.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Serialización**: Para almacenamiento y recuperación de datos de facturas.
- **Swing**: Para la interfaz gráfica de usuario (GUI).

