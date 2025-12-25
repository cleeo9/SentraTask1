# Automatización de plataforma Sentra Tasks

### Estas son las funcionalidades principales que fueron consideradas como historias de usuario para realizar en este programa:

-Registro de usuario: Se realiza en primera instancia un registro de usuario de forma correcta, para despues realizar un segundo registro en donde no coincidan las contraseñas y se considere como fallido el registro de usuario junto a un error que aparece.

-Inicio de sesión: Se realiza un inicio de sesion exitoso con los datos anteriormente registrados, para posterior inicio de sesion fallido con una contraseña incorrecta.

-Modificar información de usuario: Se realiza un login, se dirige al perfil del usuario y se modifica los datos del usuario(Nombre, Apellido, Email). Luego se hace nuevamente un login, se dirige al perfil para hacer un cambio de contraseña. Por ultimo, se busca realizar una modificacion de usuario de forma incorrecta, lo cual, no es posible debido que el sistema permite cualquier tipo de cambio sin restriccion, sin considerar la contraseña que al poner dos distintas no permite presionar el boton para modificar contraseña.

-Ver lista de tareas: Se hace un login con la cuenta de usuario y se visualiza en la "HOME" las tareas registradas por el usuario

-Crear nueva tarea: Se ingresa a traves del login, en la "Home" se presiona el boton para crear una nueva tarea, se ingresan los campos solicitados y con el boton "Crear Tarea" queda registrada correctamente en la lista de tareas.

-Alerta Sin Tareas: Al realizar login en una cuenta que no se han registrado tareas, aparece un mensaje "No existen tareas para el usuario".

-Ordenar tareas por título: Se realiza un login en la cuenta de usuario, desde la vista de tareas se puede ordenar de forma ascendente y descendente por el Titulo de la tarea.

-Ordenar tareas por prioridad: Se realiza un login en la cuenta de usuario, desde la vista de tareas se puede ordenar de forma ascendente y descendente por el numero de Prioridad de la tarea.

-Ordenar tareas por fecha de Termino: Se realiza un login en la cuenta de usuario, desde la vista de tareas se puede ordenar de forma ascendente y descendente por la fecha de Vencimiento de la tarea.

-Marcar tarea como realizada: Se realiza un login en la cuenta de usuario, desde la vista de tareas no aparece ninguna opcion para marcar como realiza la tarea, asi que la historia de usuario no corresponderia.

# Organización

## La organización del proyecto se presenta a continuación:

src/test/java/pages -> (Aqui van las clases que representan una pantalla o componente del sistema)
src/test/java/runner -> (Corresponde al ejecutor de pruebas)
src/test/java/steps -> (Corresponde al ejecutor de pruebas, un tipo de enlace entre java y gherkin)
src/test/java/utils -> (Contiene clases de apoyo para el framework)
src/test/resources/features -> (Corresponde a los escenarios a probar escritos en Gherkin)
target/cucumber-reports -> (Es una salida automatica de la ejecucción)
.gitignore -> (Archivo que ayuda a no subir basura al repositorio)
build.gradle -> (Archivo donde se define como se construye y ejecuta el proyecto)

# Ejecución

Para ejecutar todos los casos de prueba de manera secuencial, se debe acceder al directorio
src/test/java/runner y ejecutar el archivo correspondiente al runner de pruebas.
Al realizar esta acción, el framework iniciará automáticamente la ejecución completa de los escenarios definidos.

En caso de requerir la ejecución de uno o más escenarios específicos, se debe:

1. Acceder al archivo TestRunner.java, ubicado en src/test/java/runner/TestRunner.java.

2. Descomentar la línea N°10 del archivo.

3. Agregar la anotación @Test antes de cada escenario que se desee ejecutar.
