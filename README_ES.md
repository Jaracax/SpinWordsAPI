<div align="center"><h3><a href="README.md">Ingles</a> | <a href="README_ES.md">Español</a></h3></div>
<div align="center"><h1>SpinWords Api</h1></div>

#### La API de SpinWords toma un valor de tipo String e invierte cada palabra si dicha palabra tiene una longitud cinco o más caracteres.

#### En la actualización más reciente, se introdujo un nuevo método que tome la longitud de cada palabra como parámetro para que la inversion sea personalizada.

## Desarrollo y estado
El desarrollo de este proyecto consistirá en:
+ Añadir la lógica de Java para invertir las palabras. ✅
+ Hacer uso de las anotaciones de SpringBoot para crear un servicio RESTful. ✅
+ Refinar la lógica de Java para hacer el proyecto mas preciso y con mas funcionalidades. ✅
+ Utilizar JDBC y JPA para conectarse a una base de datos local. ✅
+ Añadir Junit test para asegurarse del buen funcionamiento de la aplicacion. ✅

## Propósito del proyecto

+ El proposito principal de este proyecto es para demostrar mi conocimiento y habilidades en las siguientes tecnologias:
    + Java
    - SpringBoot
    + Git
    - JDBC
    - JPA
    - MySQL
    - Junit
    - Mockito

## Estructura del proyecto
El proyecto esta estructurado de la siguiente manera:
#### com.example.SpinWordsApi
Este es el paquete central donde esta el "main method" de la aplicacion y el resto de sub-paquetes.
#### Entity
Aqui encontraremos la clase "SentenceEntity" que representa una entidad en la base de datos.
#### SentenceController
Aqui esta la clase "SpinWordsController" que se encarga de manejar los metodos HTTP.
#### Service
Aqui encontraremos dos interfaces "SentenceRepository", "SentenceService" y la clase "SentenceServiceImpl".

###### SentenceRepository
Esta interfaz extiende la interfaz de JpaRepository para que podamos hacer uso de los endpoints comunes que ofrece Jpa, además
hay un método personalizado para obtener "sentences" con una consulta personalizada llamada "findByOriginalSentenceLengthGreaterThan"

###### SentenceService
Esta interfaz ofrece dos métodos abstractos que serán los responsables de la lógica principal de este código.

###### SentenceServiceImpl
Esta clase implementa la interfaz "SentenceService" y es la encargada de revertir las oraciones y guardarlas en la base de datos.
