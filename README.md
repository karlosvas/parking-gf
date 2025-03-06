# Aplicación de Parking 🅿

Esta es una aplicación en Java que simula un sistema de estacionamiento. La aplicación permite gestionar ubicaciones, tickets, pagos y validaciones, todo ello a través de una interfaz gráfica con Java.  
Proyecto propuesto por el Centro Gregorio Fernández (Valladolid)

### Integrantes
@karlosvas
@Rs-845

## Instalación y Compilación 

Para compilar el proyecto, ejecuta el siguiente comando en la raíz del proyecto:

```sh
mvn clean install
```

## Ejecución

Para iniciar la aplicación, ejecuta la clase `Principal` o dirijete a la clase mencionada y pulsando el botón de play o run dependiendo de tu IDE:

```sh
mvn exec:java -Dexec.mainClass="com.gregorio.parking.Principal"
```

## Descripción de Componentes Principales 🚗

- **Principal**: Clase principal que inicia la aplicación y configura el aspecto visual (por ejemplo, el look and feel Nimbus).
- **Terminal**: Interfaz de usuario que gestiona la interacción y las operaciones del parking.
- **Maquina**: Encapsula la lógica de negocio del sistema de parking, incluyendo la generación de tickets y la validación de pagos.
- **Ubicacion**: Representa la localización de un vehículo dentro del estacionamiento.
- **DineroInsuficiente**: Excepción personalizada que se lanza cuando el dinero introducido no es suficiente para cubrir el coste de un ticket.
- **Validation**: Conjunto de métodos de validación para entradas de datos, como el formato de fechas y números.
- **FondoPanel**: Utilidad para configurar imágenes de fondo en paneles de la interfaz.

## Licencia

Este proyecto se distribuye bajo la licencia MIT.
Para más referencias, consulta el archivo [LICENSE](./LICENSE).