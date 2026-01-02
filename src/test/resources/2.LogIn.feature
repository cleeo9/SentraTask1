Feature: Inicio de Sesión
  Como usuario registrado, deseo poder iniciar sesión en el sitio utilizando
  mi correo y contraseña.

  Scenario Outline: Iniciar Sesión
    Given Navego a la página de inicio
    When Ingreso el email <email> y contraseña <password>
    And Hago click en el botón Ingresar
    Then Ingresa logueado a la plataforma exitosamente

    Examples:
      | email              | password |
      | "pruebaregister15@gmail.com" | "123456"    |

  Scenario Outline: Iniciar Sesión faillido
    Given Navego a la página de inicio
    When Ingreso el email <email> y contraseña <password>
    And Hago click en el botón Ingresar
    Then No logro ingresar a la plataforma

    Examples:
      | email              | password |
      | "pruebaregister15@gmail.com" | "321"    |
