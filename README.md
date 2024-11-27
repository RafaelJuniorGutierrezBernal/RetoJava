## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and
> update the related settings there.

## Dependency Management
-- README

Sistema Interplanetario

Presentamos un simulador de viaje interplanetario que permite  seleccionar un destino, elegir una nave, ajustar los recursos necesarios para el viaje y ver cómo la misión progresa. En el transcurso del viaje, el sistema va simulando eventos aleatorios, como fallas en el sistema, lluvias de asteroides, etc,  que pueden afectar el tiempo de viaje.

Descripción
El programa simula un viaje a varios planetas del sistema solar partiendo desde la tierra y los usuarios podrán.

Seleccionar un planeta destino.
Elegir una nave con diferentes velocidades.
Ajustar los recursos necesarios, como gasolina y comida, con relación al tiempo estimado de viaje.
Experimentar eventos aleatorios que pueden entorpecer la misión.
El programa permite que el viaje sea dinámico, mostrando el progreso en tiempo real y notificando al     usuario sobre posibles problemas que puedan surgir durante el trayecto.

Características

Selección de destino interplanetario (Mercurio, Venus, Marte, Júpiter, Saturno, Urano, Neptuno).
Tres tipos de naves con diferentes velocidades.
Ajuste de recursos necesarios (gasolina y comida) en función del tiempo estimado de viaje.
Simulación de eventos aleatorios que afectan el tiempo de viaje (fallas en el sistema, lluvia de asteroides, falta de combustible, problemas de comunicación).
Barra de progreso que muestra el avance del viaje y la cantidad de recursos restantes.

Tecnologías Utilizadas
Lenguaje de programación: Java
Librerías: Ninguna externa, solo librerías estándar de Java (como Scanner, ArrayList, Ramdon, etc.).
Instalación
Requisitos
Para correr este sistema, necesitas tener instalado:
Java 8 o superior.

Al ejecutar el programa, se mostrará un menú interactivo en la consola. Las opciones disponibles son:

Seleccionar destino: El usuario podrá elegir uno de los planetas del sistema solar para viajar.
Seleccionar nave: El usuario podrá elegir entre tres tipos de naves con diferentes velocidades.
Iniciar simulación: Después de seleccionar un destino y una nave, el programa calculará el tiempo de viaje, ajustará los recursos necesarios y simulará el progreso del viaje.
Salir: Termina la ejecución del programa.
El programa calculará automáticamente la cantidad de gasolina y comida necesarias para el viaje según la distancia y el número de pasajeros. Sin embargo, el usuario puede ajustar estos valores antes de iniciar el viaje.

Ejemplo de uso:


=== MENÚ INTERPLANETARIO ===
1. Seleccionar destino.
2. Seleccionar nave.
3. Iniciar simulación.
4. Salir.

Ingrese la opción: 1
Seleccione un destino:
1. Mercurio
2. Venus
3. Marte
4. Júpiter
5. Saturno
6. Urano
7. Neptuno

Ingrese el número del planeta que desea visitar: 3
Planeta seleccionado: Marte
Descripción: Conocido como el planeta rojo, a una distancia promedio de 78 millones de km desde la Tierra.

¿Está seguro de que desea viajar a Marte (si/no)? si

Seleccione una nave:
1. Exploradora (velocidad: 20000 km/h)
2. Carga pesada (velocidad: 15000 km/h)
3. Velocidad maxima (velocidad: 30000 km/h)

Ingrese el número de la nave que desea utilizar: 3
Nave seleccionada: Velocidad maxima

Ingrese el número de pasajeros: 5

Recursos calculados automáticamente para el viaje:
Gasolina estimada: 180000.0 litros
Comida estimada: 10 raciones

¿Deseas ajustar los recursos? (si/no): no
Se utilizaron los valores predeterminados: Gasolina = 180000.0 litros, Comida = 10 raciones.

Distancia al planeta: 78000000.0 km
Tiempo de viaje estimado: 2600.0 horas
Tiempo total del viaje (incluyendo retrasos): 2600 horas.
Progreso: [==========          ] 20% | Gasolina restante: 174000.0 | Comida restante: 6.0 raciones



The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
