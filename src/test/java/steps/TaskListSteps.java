package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.TaskPage;

public class TaskListSteps {

    HomePage homePage = new HomePage();
    TaskPage taskPage = new TaskPage();

    @When("Hago click en el botón Home")
    public void ClickHome() {
        homePage.clickHome();
    }

    @And("Estoy en la pantalla Home")
    public void NavigateHome() {
        Assert.assertTrue(homePage.NavigateHome(), "No se levanta modal Modificar Datos Usuario");
    }

    @Then("Se Visualizan las tareas asignadas a mi cuenta")
    public void TaskList() {
        Assert.assertTrue(taskPage.TaskList(), "No se visualizan las tareas");

    }
}
