Feature: Marcar tarea como realizada
  Como usuario, quiero poder marcar una tarea como realizada para
  eliminarla de mi lista de tareas pendientes y mantener un registro de las
  tareas completadas.

  Background: Se hace Login a la página
    Given Navego a la página de inicio
    When Ingreso el email "lcruz@sentra.cl" y contraseña "lcruz03"
    And Hago click en el botón Ingresar
    Then Hago click en el botón Home

  Scenario: Cambiar estado Tarea
    Given Selecciono la tarea de la tabla
    When Presiono el botón de marcar tarea completada
    Then El estado de la tarea cambia a completada
