package steps;

import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.MainPage;

public class SignUpSteps {

    MainPage landingPage = new MainPage();

    @When("Hago click en el botón de registro")
    public void clickSignUp() {
        landingPage.clickSignUp();
    }

    @Given("Se despliega modal con el formulario de registro")
    public void signUpWindowIsDisplayed() {
        Assert.assertTrue(
                landingPage.isRegisterButtonVisible(),
                "No se levanta modal Registrar Usuario"
        );
    }

    @Then("Hago click en botón Cancelar")
    public void clickCancel() {
        landingPage.clickCancel();
    }

    // Registro exitoso
    @Given("Ingreso el nombre {string}, apellido {string}, email {string}, contraseña {string}")
    public void fillValidSignUpForm(
            String nombre,
            String apellido,
            String email,
            String password) {

        landingPage.fillSignUpForm(
                nombre,
                apellido,
                email,
                password,
                password
        );
    }

    @When("Hago click en el botón Registrar Usuario")
    public void clickRegister() {
        landingPage.clickRegister();
    }

    @Then("Se muestra mensaje Usuario creado correctamente")
    public void signUpSuccessMessage() {
        Assert.assertTrue(
                landingPage.isSignUpSuccessful(),
                "Usuario no queda registrado correctamente"
        );
    }

    // Registro fallido
    @Given("Ingreso el nombre {string}, apellido {string}, email {string}, contraseña {string} y contraseña incorrecta {string}")
    public void fillInvalidSignUpForm(
            String nombre,
            String apellido,
            String email,
            String password,
            String wrongPassword) {

        landingPage.fillSignUpForm(
                nombre,
                apellido,
                email,
                password,
                wrongPassword
        );
    }

    @Then("Se muestra mensaje de error")
    public void signUpFailMessage() {
        Assert.assertTrue(
                landingPage.isSignUpFailed(),
                "Usuario registrado correctamente"
        );
    }
}
