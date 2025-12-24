package steps;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.TaskPage;

public class AlertNotTask {
    HomePage homePage = new HomePage();
    TaskPage taskPage = new TaskPage();

    @Then("Se visualiza alerta de usuario sin tareas")
    public void alertNotTask() {
        Assert.assertTrue(taskPage.alertNotTask(), "No se visualiza alerta de usuario sin tareas");
    }
}