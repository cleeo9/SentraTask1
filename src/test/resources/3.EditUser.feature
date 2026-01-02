Feature: Modificar información de usuario
Como usuario, quiero poder modificar mi información personal,
incluyendo nombre, apellido, correo y contraseña, para mantener mi
perfil actualizado.

  Background: Se hace Login a la página
    Given Navego a la página de inicio
    When Ingreso el email "pruebaregister15@gmail.com" y contraseña "123456"
    And Hago click en el botón Ingresar

  Scenario: Validar que estoy en la página del Perfil
    Given Hago click en el botón Perfil
    Then Navego a la página del perfil

  Scenario: Modificar datos del perfil de usuario
    Given Hago click en el botón Perfil
    When Navego a la página del perfil
    And Hago click en el botón editar datos usuario
    And Se abre modal de modificación datos del usuario
    And Ingreso nuevo nombre "Juanito", nuevo apellido "Perez" y nuevo email "pruebaregister15@gmail.com"
    And Hago click en el botón modificar usuario
    Then Los datos del usuario nombre "Juanito", apellido "Perez" y el email "pruebaregister15@gmail.com" se modifican correctamente

  Scenario: Cambiar contraseña de usuario
    Given Hago click en el botón Perfil
    When Navego a la página del perfil
    And Hago click en el botón cambiar contraseña
    And Se abre modal de modificación de la contraseña
    And Ingreso nueva contraseña "123456" y repito la nueva contraseña "123456"
    And Hago click en el botón Cambiar contraseña
    Then La contraseña del usuario se cambia correctamente

  Scenario: Modificar datos del perfil de usuario de manera errónea
    Given Hago click en el botón Perfil
    When Navego a la página del perfil
    And Hago click en el botón editar datos usuario
    And Se abre modal de modificación datos del usuario
    And Ingreso nuevo nombre "Pepito", nuevo apellido "Cruz" y nuevo email "PruebaFallida@gmail.com"
    Then El boton modificar usuario se encuentra inhabilitado
