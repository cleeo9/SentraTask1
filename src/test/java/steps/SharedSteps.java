package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.MainPage;

public class SharedSteps {   // Steps reutilizables

    MainPage landingPage = new MainPage();

    @When("Ingreso el email {string} y contraseña {string}")
    public void fillLoginForm(String email, String contrasena) {
        landingPage.fillLoginForm(email, contrasena);
    }

    @And("Hago click en el botón Ingresar")
    public void clickLoginButton() {
        landingPage.clickLogin();
    }

    @Given("Navego a la página de inicio")
    public void navigateToSentraTask() {
        landingPage.navigateToSentraTask();
    }
}


