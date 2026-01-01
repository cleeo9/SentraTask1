package steps;

import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ProfilePage;
import pages.MainPage;

public class EditUserSteps {

    MainPage landingPage = new MainPage();
    ProfilePage profilePage = new ProfilePage();

    // Navegación
    @Given("Navego a la página del perfil")
    public void navigateToProfile() {
        landingPage.navigateToProfile();
    }

    @And("Hago click en el botón Perfil")
    public void clickProfile() {
        profilePage.clickProfile();
    }

    // ===============================
    // Scenario: Editar datos usuario
    // ===============================

    @And("Hago click en el botón editar datos usuario")
    public void clickEditDataUser() {
        profilePage.clickEditDataUser();
    }

    @And("Se abre modal de modificación datos del usuario")
    public void editProfileWindow() {
        Assert.assertTrue(
                profilePage.isEditProfileModalDisplayed(),
                "El modal de modificación de datos del usuario debería estar visible"
        );
    }

    @And("Ingreso nuevo nombre {string}, nuevo apellido {string} y nuevo email {string}")
    public void fillEditProfile(String nombre, String apellido, String email) {
        profilePage.fillEditProfile(nombre, apellido, email);
    }

    @And("Hago click en el botón modificar usuario")
    public void clickEditUser() {
        profilePage.clickEditUser();
    }

    @Then("Los datos del usuario nombre {string}, apellido {string} y el email {string} se modifican correctamente")
    public void editUserSuccess(String nombre, String apellido, String email) {
        Assert.assertTrue(
                profilePage.isEditUserSuccessful(nombre, apellido, email),
                "Los datos del usuario deberían modificarse correctamente"
        );
    }

    // ===============================
    // Scenario: Cambiar contraseña
    // ===============================

    @Given("Hago click en el botón cambiar contraseña")
    public void clickChangePassword() {
        profilePage.clickChangePassword();
    }

    @And("Se abre modal de modificación de la contraseña")
    public void editPasswordWindow() {
        Assert.assertTrue(
                profilePage.isEditPasswordModalDisplayed(),
                "El modal de modificación de contraseña debería estar visible"
        );
    }

    @And("Ingreso nueva contraseña {string} y repito la nueva contraseña {string}")
    public void fillNewPassword(String password, String repeatPassword) {
        landingPage.fillNewPassword(password, repeatPassword);
    }

    @And("Hago click en el botón Cambiar contraseña")
    public void clickChangePasswordEnd() {
        profilePage.clickChangePasswordEnd();
    }

    @Then("La contraseña del usuario se cambia correctamente")
    public void changePasswordSuccess() {
        Assert.assertTrue(
                profilePage.isChangePasswordSuccessful(),
                "La contraseña del usuario debería cambiarse correctamente"
        );
    }

    @Then("El boton modificar usuario se encuentra inhabilitado")
    public void editUserFail() {
        Assert.assertFalse(
                profilePage.isEditUserButtonEnabled(),
                "El botón modificar usuario NO debería estar habilitado"
        );
    }
}
