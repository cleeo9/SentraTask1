package steps;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import pages.MainPage;

public class LogInSteps {
    MainPage landingPage = new MainPage();

    @Then("Ingresa logueado a la plataforma exitosamente")
    public void se_muestra_mensaje() {
        // Si falla, el mensaje dice: "Usuario no logueado correctamente" (¡CORRECTO!)
        Assert.assertTrue(landingPage.LogInsuccessResult(), "Usuario no logueado correctamente");
    }

    @Then("No logro ingresar a la plataforma")
    public void se_muestra_mensaje_error() {
        // Si falla, el mensaje dice: "No se muestra el mensaje de error de login"
        // (La prueba falla porque no se encontró el mensaje de error esperado, lo que implica que el login tuvo éxito).
        // [CORRECCIÓN] Se cambió el mensaje para que refleje lo que se esperaba ver pero no se encontró.
        Assert.assertTrue(landingPage.LogInFailResult(), "No se encuentra el mensaje de error de login esperado");
    }
}