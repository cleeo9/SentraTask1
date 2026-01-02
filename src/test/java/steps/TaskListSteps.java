package steps;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.TaskPage;

public class TaskListSteps {

    HomePage homePage = new HomePage();
    TaskPage taskPage = new TaskPage();

    @When("Hago click en el botón Home")
    public void clickHomeButton() { // <-- Nombre de método corregido a camelCase
        homePage.clickHome();
    }

    // NUEVO PASO @THEN para verificar la navegación (Resultado de la acción anterior)
    @Then("Estoy en la pantalla Home") 
    public void validateHomePageNavigation() { // <-- Método renombrado y con mejor semántica
        Assert.assertTrue(homePage.NavigateHome(), "La navegación a la página Home ha fallado");
    }

    @Then("Se Visualizan las tareas asignadas a mi cuenta")
    public void validateTaskListIsDisplayed() { // <-- Método renombrado
        Assert.assertTrue(taskPage.TaskList(), "No se visualizan las tareas asignadas");
    }
}