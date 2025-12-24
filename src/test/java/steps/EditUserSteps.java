package steps;

import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ProfilePage;
import pages.MainPage;

public class EditUserSteps {

    MainPage landingPage = new MainPage();
    ProfilePage EditUserPage = new ProfilePage();

    @Given("Navego a la página del perfil")
    public void iNavigateToprofile() {
        landingPage.iNavigateToprofile();
    }

    @And("Hago click en el botón Perfil")
    public void clickProfile() {
        EditUserPage.clickProfile();
    }

    // Scenario 2

    @And("Hago click en el botón editar datos usuario")
    public void clickEditDataUser() {
        EditUserPage.clickEditDataUser();
    }

    @And("Se abre modal de modificación datos del usuario")
    public void EditProfileWindow() {
        Assert.assertTrue(EditUserPage.WindowEdit(), "No se levanta modal Modificar Datos Usuario");
    }

    @And("Ingreso nuevo nombre {string}, nuevo apellido {string} y nuevo email {string}")
    public void fillEditProfile(
            String nombre, String apellido, String email) throws InterruptedException {
        EditUserPage.fillEditProfile(nombre, apellido, email);
    }

    @And("Hago click en el botón modificar usuario")
    public void clickEditUser() {
        EditUserPage.clickEditUser();
    }

    @Then("Los datos del usuario nombre {string}, apellido {string} y el email {string} se modifican correctamente")
    public void se_muestra_mensaje(String nombre, String apellido, String email) {
        Assert.assertTrue(EditUserPage.EditUserSuccess(nombre, apellido, email),
                "Usuario no queda modificado correctamente");
    }

    // Scenario 3

    @Given("Hago click en el botón cambiar contraseña")
    public void clickChangePass() {
        EditUserPage.clickChangePass();

    }

    @And("Se abre modal de modificación de la contraseña")
    public void EditPassWindow() {
        Assert.assertTrue(EditUserPage.EditPassWindow(), "No se levanta modal Modificar la contraseña");

    }

    @And("Ingreso nueva contraseña {string} y repito la nueva contraseña {string}")
    public void Ingreso_nueva_contraseña_y_repito_la_nueva_contraseña(String contraseña, String repetirContraseña) {
        landingPage.fillNewPass(contraseña, repetirContraseña);
    }

    @And("Hago click en el botón Cambiar contraseña")
    public void clickChangePassEnd() {
        EditUserPage.clickChangePassEnd();
    }

    @Then("La contraseña del usuario se cambia correctamente")
    public void ChangePassSuccess() {
        Assert.assertTrue(EditUserPage.ChangePassSuccess(), "La contraseña del usuario no se cambia correctamente");

    }

    @Then("El boton modificar usuario se encuentra inhabilitado")
    public void editUserFail() {
        Assert.assertFalse(EditUserPage.buttonStatus(), "El boton modificar usuario se encuentra habilitado");
    }
}