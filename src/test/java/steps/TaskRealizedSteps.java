package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.TaskPage;
import org.testng.Assert;

public class TaskRealizedSteps {

    TaskPage taskPage = new TaskPage();

    @Given("Selecciono la tarea de la tabla")
    public void ClickTask() {
        taskPage.clickTask();
    }

    @When("Presiono el botón de marcar tarea completada")
    public void ClickTaskCompleted() {

        Assert.assertTrue(taskPage.isClickleableButton(), "No encuentra el boton Tarea Completada");
        taskPage.clickTaskCompleted();
    }

    @Then("El estado de la tarea cambia a completada")
    public void changeTaskStatus() {
        Assert.assertTrue(taskPage.changeTaskStatus(), "El estado de la tarea no cambia");
    }
}