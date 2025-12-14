## Autor del proyecto
_**Nombre completo:** Mónica Figueroa
_**Sección:** 2
_**Analista Programador Computacional**

---

## Descripción general del proyecto

El proyecto SalmonttAppSumativa3 es una aplicación desarrollada en Java que amplía el sistema modelado en entregas anteriores, incorporando una interfaz gráfica simple (GUI) y el uso de inetrfaces, manteniendo una correcta jerarquía de clases y aplicando conceptos fundamentales de Programación Orientada a Objetos y buenas prácticas de desarrollo en Java.
El sistema permite registrar distinta entidades importantes para la empresa salmonera (como centros de cultivo, plantas de proceso y proveedores) mediante una interfaz gráfica construida con JFrame, y visualizar un resumen de los datos ingresados.

### Conceptos aplicados
- Herencia y jerarquía de clases.
- Abstracción (uso de clase abstracta).
- Uso de interfaces (`Registrable`)
- Implementación de métodos abstractos desde interfaces.
- Sobrescritura de métodos mediante @Override.
- Polimorfismo en tiempo de ejecución.
- Uso de colecciones genéricas (`List<Registrable>`).
- Uso del operador `instanceof` para lógica diferenciada.
- Encapsulamiento.
- Separación de responsabilidades.
- Interfaz gráfica con JFrame.
- Organización lógica mediante paquetes (model, data y ui).
- Documentación con Javadoc.

## Objetivos del proyecto

### Objetivo general
Desarrollar una aplicación Java que permita gestionar distintas entidades de una empresa salmonera, utilizando interfaces, herencia, polimorfismo y una interfaz gráfica simple para el ingreso y visualización de datos.
### Objetivos específicos

1. Diseñar una interfaz llamada `Registrable`con al menos un método abstracto.
2. Crear una **Superclase abstracta** llamada UnidadOperativa.
3. Implementar al menos **tres clases concretas** que implementen la interfaz `Registrable`.
4. Sobrescribir el método `mostrarResumen()`en cada clase concreta.
5. Gesdtionar las entidades mediante una **colección genérica** (`ArrayList<Registrable>`).
6. Utilizar el operador `instanceof`para identificar el tipo real de los objetos.
7. Implementar una **interfaz gráfica simple con JFrame** que permita:
- Ingresar datos para distintos tipos de entidades.
- Mostrar un resumen de los objetos creados.
8. Mantener una correcta **separación por capas** (model, data, ui).
9. Documentar el documento utilizando **Javadoc**.

## Abstract v/s interface
La **interfaz** `Registrable` define un comportamiento común (`mostrarResumen()`), obligando a todas las clases que la implementan a entregar su propia versión del método.
La **clase abstracta** `UnidadOperativa`permite compartir atributos y comportamiento común ( nombre y comuna), evitando duplicación de código.
Esta combinación permite **flexibilidad**, **reutilización** y una jerarquía clara alineada con las buenas prácticas.
## Uso de instanceof
Este operador se utiliza dentro de la clase `GestorEntidades`para identificar el tipo específico de cada entidad registrada y aplicar lógica diferenciada cuando corresponde.
## Descripción de paquetes
### `ui/`
Contiene las clases responsables de la ejecución del programa y la interfaz gráfica:
- `Main`
- `RegistroGUI`
### `data/`
Incluye `Entidades`, encargada de administrar la colección de entidades registradas.
### `model/` 
Contiene toda la jerarquía de clases y la interfaz:

- `Registrable` (interface)
- `UnidadOperativa` (Superclase abstracta)
- `CentroCultivo` (subclase)
- `PlantaProceso` (subclase)
- `Proveedor` (subclase)

## Estructura del proyecto
```SalmonttAppSumativa3
├ .idea/
├ .mvn/
├ docs/
├ src/
|  └ main/
|     ├ java/
|     |  └ org.example/
|     |     ├ data/
|     |     |  └ GestorEntidades.java
|     |     ├ model/
|     |     |  ├ CentroCultivo.java
|     |     |  ├ PlantaProceso.java
|     |     |  ├ Registrable.java
|     |     |  ├ UnidadOperativa.java
|     |     ├ ui/
|     |     |  ├  Main.java
|     |     |  └ Registrable.java
|     └ resources/
├ test/
├ target/
├ .gitignore
├ pom.xml
└ README.md
```
## Interfaz gráfica
Fue desarrollado utilizando **JFrame** y permite:
- Ingresar datos para distintos tipos de entidades.
- Validar campos obligatorios.
- Registrar entidades en el sistema.
- Mostrar un resumen de todas las entidades registradas en un área de texto.
- Salir de la aplicación mediante un botón de salir.

## Instrucciones para clonar y ejecutar el proyecto
1. Clonar el repositorio desde GitHub.
```bash
Git clone [codigo]
```
2. Abre el proyecto en IntelliJ IDEA.
3. Ejecutar la clase org.example.ui.Main.java
4. La interfaz gráfica se abrirá y permitirá registrar entidades y  visualizar sus resúmenes.