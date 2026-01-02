package steps;

import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ProfilePage;
import pages.MainPage;

public class EditUserSteps {

    MainPage landingPage = new MainPage();
    // Es mejor usar un nombre más descriptivo que 'EditUserPage' si la clase es 'ProfilePage'
    ProfilePage profilePage = new ProfilePage(); 

    // ======= NAVEGACIÓN Y PERFIL =======

    @Given("Navego a la página del perfil")
    public void iNavigateToprofile() {
        landingPage.iNavigateToprofile();
    }

    @And("Hago click en el botón Perfil")
    public void clickProfile() {
        profilePage.clickProfile();
    }

    // ======= SCENARIO 2: MODIFICAR DATOS DEL PERFIL =======

    @And("Hago click en el botón editar datos usuario")
    public void clickEditDataUser() {
        profilePage.clickEditDataUser();
    }

    @And("Se abre modal de modificación datos del usuario")
    public void EditProfileWindow() {
        // [CORRECCIÓN] Mensaje de falla: Indica que el modal no se visualiza.
        Assert.assertTrue(profilePage.WindowEdit(), "El modal de Modificación de Datos del Usuario NO está visible");
    }

    @And("Ingreso nuevo nombre {string}, nuevo apellido {string} y nuevo email {string}")
    public void fillEditProfile(
            String nombre, String apellido, String email) throws InterruptedException {
        profilePage.fillEditProfile(nombre, apellido, email);
    }

    @And("Hago click en el botón modificar usuario")
    public void clickEditUser() {
        profilePage.clickEditUser();
    }

    @Then("Los datos del usuario nombre {string}, apellido {string} y el email {string} se modifican correctamente")
    public void se_muestra_mensaje(String nombre, String apellido, String email) {
        // [CORRECCIÓN] Mensaje de falla: Indica que la modificación no se pudo validar.
        Assert.assertTrue(profilePage.EditUserSuccess(nombre, apellido, email),
                "No se pudo validar que los datos del usuario se hayan modificado correctamente");
    }

    // ======= SCENARIO 3: CAMBIAR CONTRASEÑA =======

    @Given("Hago click en el botón cambiar contraseña")
    public void clickChangePass() {
        profilePage.clickChangePass();
    }

    @And("Se abre modal de modificación de la contraseña")
    public void EditPassWindow() {
        // [CORRECCIÓN] Mensaje de falla: Indica que el modal no se visualiza.
        Assert.assertTrue(profilePage.EditPassWindow(), "El modal de Modificación de la Contraseña NO está visible");
    }

    @And("Ingreso nueva contraseña {string} y repito la nueva contraseña {string}")
    public void Ingreso_nueva_contraseña_y_repito_la_nueva_contraseña(String contraseña, String repetirContraseña) {
        landingPage.fillNewPass(contraseña, repetirContraseña);
    }

    @And("Hago click en el botón Cambiar contraseña")
    public void clickChangePassEnd() {
        profilePage.clickChangePassEnd();
    }

    @Then("La contraseña del usuario se cambia correctamente")
    public void ChangePassSuccess() {
        // [CORRECCIÓN] Mensaje de falla: Indica que la validación falló.
        Assert.assertTrue(profilePage.ChangePassSuccess(), "No se muestra el mensaje de éxito del cambio de contraseña");
    }

    // ======= SCENARIO 4: MODIFICACIÓN ERRÓNEA =======

    @Then("El boton modificar usuario se encuentra inhabilitado")
    public void editUserFail() {
        // [CORRECCIÓN] Mensaje de falla:
        // Si la prueba falla (assertFalse devuelve 'false'), significa que el botón está habilitado ('true').
        // El mensaje indica lo que la prueba encontró: "El botón modificar usuario se encuentra HABILITADO cuando no debería".
        Assert.assertFalse(profilePage.buttonStatus(), "El boton modificar usuario se encuentra HABILITADO");
    }
}