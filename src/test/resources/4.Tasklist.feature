Feature: Ver lista de tareas
Como usuario, deseo ver una lista de todas las tareas asociadas a mi
cuenta para tener una visión general de mis actividades pendientes.

Background: Se hace Login a la página
  Given Navego a la página de inicio
  When Ingreso el email "lcruz@sentra.cl" y contraseña "lcruz03"
  And Hago click en el botón Ingresar

Scenario: Desplegar lista de tareas
  When Hago click en el botón Home
  Then Estoy en la pantalla Home             
  And Se Visualizan las tareas asignadas a mi cuenta  