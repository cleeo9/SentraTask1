Feature: Ver alerta de usuario sin tareas
Como usuario, quiero poder ver cuando no tengo 
tareas asignadas en mi perfil

  Scenario: Validar usuario sin tareas
    Given Navego a la página de inicio
    When Ingreso el email "SINTAREAS@SINTAREAS.CL" y contraseña "123"
    And Hago click en el botón Ingresar
    When Hago click en el botón Home
    And Estoy en la pantalla Home
    Then Se visualiza alerta de usuario sin tareas
