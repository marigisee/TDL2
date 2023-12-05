### Pasos para crear una conexión con la base de datos mySQL desde JAVA

#### 1. Descargar el conector MySQL JDBC
Dirígete al sitio web de MySQL (https://dev.mysql.com/downloads/connector/j/) y descarga el archivo JAR del conector MySQL JDBC correspondiente a tu versión de MySQL

>En este proyecto, el conector MySQL JDBC utilizado se encuentra ubicado en la raíz.


#### 2. Agregar el conector JAR al proyecto
Como estoy usando IntelliJ, los pasos a realizar son los siguientes:
1. Haz clic derecho en tu proyecto en la barra lateral izquierda.

2. Selecciona "Open Module Settings" (Configuración del módulo).

3. Ve a la pestaña "Libraries" (Bibliotecas) y haz clic en el signo más (+).

4. Selecciona "Java" y busca el archivo JAR del conector MySQL que descargaste. Agrega este archivo JAR a tu proyecto.

### Utilizando DAO para la resolución de la práctica 7

El objetivo principal del patrón DAO es proporcionar una capa de abstracción entre el código de la aplicación y la lógica de acceso a los datos, lo que facilita el mantenimiento y la escalabilidad del sistema.

Esto significa que las operaciones de lectura, escritura, actualización y eliminación de datos **se implementan dentro de los DAO**, permitiendo que el resto del código de la aplicación interactúe con los datos a través de métodos definidos en el DAO, sin necesidad de conocer los detalles de cómo se realiza la interacción con la fuente de datos.

Por lo tanto, para cada tabla existente en la base de datos vamos a crear una **interfaz** del tipo `DAOnombre_tabla` en la cual se van a declarar las distintas operaciones a realizar en dicha tabla.

Al mismo tiempo, para cada tabla existente en la base de datos vamos a crear una clase llamada `DAOnombre_tabla_Impl` en la cual se van a implementar todos los métodos declarados en la respectiva interfaz.

#### ¿Cómo interactúan las clases DAO con la base de datos?

Cada clase DAO tiene una variable de instancia del tipo `connectionDB`, la cual es la encargada de realizar la conexión con la base de datos.

Debido a que la consigna nos pide que el usuario ingrese los siguientes datos (en la clase `Main`) : 
 
- URL
- user
- password

Lo que se implementó fue lo siguiente: 
 1. En el método main se realiza la carga de los anteriores datos (en el método `iniciarSesion()`).
 2. Se crea una instancia del tipo `connectionDB` y se le asignan los valores ingresados por el usuario.
 3. Se crean 3 instancias de las clases DAO correspondientes a las tablas de la base de datos y le pasamos como parámetro la instancia de la clase `connectionDB` creada anteriormente.

#### Operaciones posibles para cada tabla

##### 1. Futbolista

- Ingresar futbolistas
- Listar futbolistas

##### 2. Pais

- Ingresar paises
- Listar paises
- [FALTA IMPLEMENTAR] Modificar pais
- Eliminar pais

##### 3. Sede

- Ingresar sedes
- Listas sedes
- [FALTA IMPLEMENTAR] Modificar sede
- Eliminar sede


#### script.sql

Dentro del proyecto se encuentra el archivo script.sql el cual contiene el script para crear la base de datos y agregar valores de prueba. 

