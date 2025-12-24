package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TaskPage;

public class TaskCreateSteps {

    TaskPage taskPage = new TaskPage();

    @Given("Hago click en el botón Nueva Tarea")
    public void clickTaskNew() {
        taskPage.clickTaskNew();
    }

    @Then("Se despliega modal con el formulario de creación de tareas")
    public void taskCreateWindow() {
        Assert.assertTrue(taskPage.taskCreateWindow(), "No se levanta modal de creación de tareas");

    }

    @When("Ingreso el título {string}, descripción {string}, fecha de vencimiento {string} y prioridad {string}")
    public void fillNewTask(String título, String descripción, String fechaDeVencimiento, String prioridad) {
        taskPage.fillNewTask(título, descripción, fechaDeVencimiento, prioridad);
    }

    @And("Hago click en el botón Crear Tarea")
    public void clickTaskCreate() {
        taskPage.clickTaskCreate();
    }

    @Then("Se muestra mensaje Tarea creada correctamente")
    public void taskCreateSuccess() {
        Assert.assertTrue(taskPage.taskCreateSuccess(), "Tarea no queda creada correctamente");
    }
}