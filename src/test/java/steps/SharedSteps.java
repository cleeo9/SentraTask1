package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.MainPage;

public class SharedSteps { 
    // la clase contiene steps reutilizables

    MainPage landingPage = new MainPage();

    @When("Ingreso el email {string} y contraseña {string}")
    public void fillLoginForm(String email, String contraseña) {
        // aca conecta un paso del archivo .feature con código Java
        landingPage.fillLoginForm(email, contraseña);
    }

    @And("Hago click en el botón Ingresar")
    // Corrección: Cambiado de snake_case a camelCase
    public void clickOnTheLoginButton() { 
        landingPage.clickLogin();
    }

    @Given("Navego a la página de inicio")
    public void iNavigateToSentraTsk() {
        landingPage.iNavigateToSentraTsk();
    }

}
