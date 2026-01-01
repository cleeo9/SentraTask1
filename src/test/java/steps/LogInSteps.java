package steps;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import pages.MainPage;

public class LogInSteps {

    MainPage landingPage = new MainPage();

    @Then("Ingresa logueado a la plataforma exitosamente")
    public void loginSuccess() {
        Assert.assertTrue(
                landingPage.isLoginSuccessful(),
                "El usuario debería ingresar correctamente a la plataforma"
        );
    }

    @Then("No logro ingresar a la plataforma")
    public void loginFail() {
        Assert.assertFalse(
                landingPage.isLoginSuccessful(),
                "El usuario NO debería ingresar correctamente a la plataforma"
        );
    }
}