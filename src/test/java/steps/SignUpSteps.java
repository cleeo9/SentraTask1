package steps;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.MainPage;

public class SignUpSteps {

    MainPage landingPage = new MainPage();

    @When("Hago click en el botón de registro")
    public void ToClickSignUp() throws InterruptedException {
        landingPage.clickSignUp();
    }

    @Given("Se despliega modal con el formulario de registro")
    public void SignUpWindow() {
        Assert.assertTrue(landingPage.firstResult(), "No se levanta modal Registrar Usuario");
    }

    @Then("Hago click en botón Cancelar")
    public void ToClickCancel() throws InterruptedException {
        landingPage.ToClickCancel();
    }

    @Given("Ingreso el nombre {string}, apellido {string} , email {string}, contraseña {string}")
    public void ingreso_el_nombre_prueba_apellido_junior_email_prueba_gmail_com_contraseña(
            String nombre, String apellido, String email, String contraseña) {
        landingPage.fillSignUpForm(nombre, apellido, email, contraseña);
    }

    @When("Hago click en el botón Registrar Usuario")
    public void hago_clic_en_el_botón() {
        landingPage.clickRegister();
    }

    @Then("Se muestra mensaje Usuario creado correctamente")
    public void se_muestra_mensaje() {
        Assert.assertTrue(landingPage.successResult(), "Usuario no queda registrado correctamente");
    }

    @Given("Ingreso el nombre {string}, apellido {string}, email {string}, contraseña {string} y contraseña incorrecta {string}")
    public void ingreso_el_nombre_prueba_apellido_junior_email_prueba_gmail_com_contraseña_y_contraseña_fail(
            String nombre, String apellido, String email, String contraseña, String contraseña2) {
        landingPage.fillFailSignUpForm(nombre, apellido, email, contraseña, contraseña2);
    }

    @Then("Se muestra mensaje de error")
    public void se_muestra_mensaje_fail() {
        Assert.assertTrue(landingPage.failResult(), "Usuario registrado correctamente");
    }

}