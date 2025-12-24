Feature: Ordenar tareas por título
Como usuario, deseo poder ordenar mi lista de tareas por título, ya sea
de manera ascendente o descendente, para encontrar y organizar mis
tareas de manera efectiva.

  Background: Se hace Login a la página
    Given Navego a la página de inicio
    When Ingreso el email "lcruz@sentra.cl" y contraseña "lcruz03"
    And Hago click en el botón Ingresar
    Then Hago click en el botón Home

  Scenario: Ordenar tareas por Título de manera ascendente
    Given Hago click en el botón del "Titulo", ordenar de manera ascendente
    Then Las tareas se ordenan de manera ascendente

  Scenario: Ordenar tareas por Título de manera descendente
    Given Hago click en el botón del "Titulo", ordenar de manera descendente
    Then Las tareas se ordenan de manera descendente

  Scenario: Ordenar tareas por  Fecha vencimiento de manera ascendente
    Given Hago click en el botón del "Fecha Vencimiento", ordenar de manera ascendente
    Then Las tareas se ordenan de manera ascendente

  Scenario: Ordenar tareas por  Fecha vencimiento de manera descendente
    Given Hago click en el botón del "Fecha Vencimiento", ordenar de manera descendente
    Then Las tareas se ordenan de manera descendente

  Scenario: Ordenar tareas por  Prioridad de manera ascendente
    Given Hago click en el botón del "Prioridad", ordenar de manera ascendente
    Then Las tareas se ordenan de manera ascendente

  Scenario: Ordenar tareas por  Prioridad de manera descendente
    Given Hago click en el botón del "Prioridad", ordenar de manera descendente
    Then Las tareas se ordenan de manera descendente
