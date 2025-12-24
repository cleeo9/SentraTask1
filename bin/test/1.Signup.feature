Feature: Registro de usuario
  Como nuevo usuario, quiero poder registrarme en el sitio
  proporcionando mi nombre, apellido, correo y contraseña para poder
  acceder a las funcionalidades del sitio.

  Background:
    Given Navego a la página de inicio
    When Hago click en el botón de registro

  Scenario: Desplegar modal de registro
    Given Se despliega modal con el formulario de registro
    Then Hago click en botón Cancelar

  Scenario Outline: Registrar usuario
    Given Ingreso el nombre <name>, apellido <lastname> , email <e-mail>, contraseña <password>
    When Hago click en el botón Registrar Usuario
    Then Se muestra mensaje Usuario creado correctamente

    Examples:
      | name     | lastname    | e-mail                      | password |
      | "Prueba1" | "Registrar" | "pruebaregister12@gmail.com" | "123456" |

  Scenario Outline: Registrar usuario faillido
    Given Ingreso el nombre <name>, apellido <lastname>, email <e-mail>, contraseña <password> y contraseña incorrecta <password2>
    When Hago click en el botón Registrar Usuario
    Then Se muestra mensaje de error

    Examples:
      | name      | lastname       | e-mail                 | password | password2 |
      | "Prueba2" | "RegisterFallido" | "PruebaFallida@gmail.com" | "123456" | "9876"    |
