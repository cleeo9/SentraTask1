package steps;

import org.testng.Assert;

import io.cucumber.java.en.Then;

import pages.MainPage;

public class LogInSteps {
    MainPage landingPage = new MainPage();

    @Then("Ingresa logueado a la plataforma  exitosamente")
    public void se_muestra_mensaje() {
        Assert.assertTrue(landingPage.LogInsuccessResult(), "Usuario no logueado correctamente");
    }

    @Then("No logro ingresar a la plataforma")
    public void se_muestra_mensaje_error() {
        Assert.assertTrue(landingPage.LogInFailResult(), "Usuario logueado correctamente");
    }
}