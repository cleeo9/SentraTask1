package pages;

public class ProfilePage extends BasePage {

    public ProfilePage() {
        super();
    }

    // Locators
    private String buttonProfile = "//span[text()='Perfil']";
    private String buttonEdit = "//button[text()='Editar Datos Usuario']";
    private String nameUpdate = "//input[@id='firstname']";
    private String lastnameUpdate = "//input[@id='lastname']";
    private String emailUpdate = "//input[@id='email']";
    private String editProfileModal = "//h2[text()='Modificación Datos Usuario']";

    private String buttonChangePassword = "//button[text()='Cambiar Contraseña']";
    private String changePasswordModal = "//h2[text()='Cambiar Contraseña']";
    private String buttonEditUser = "//button[text()='Modificar Usuario']";
    private String buttonChangePasswordEnd =
            "//div[@role='dialog']//button[text()='Cambiar Contraseña']";

    private String passwordChangedMessage =
            "//div[contains(text(),'Contraseña cambiada')]";

    private String tableData = "//td[text()='%s']";

    // =========================
    // Actions
    // =========================

    public void clickProfile() {
        clickElement(buttonProfile);
    }

    public void clickEditDataUser() {
        clickElement(buttonEdit);
    }

    public void fillEditProfile(String nombre, String apellido, String email) {
        write(nameUpdate, nombre);
        write(lastnameUpdate, apellido);
        write(emailUpdate, email);
    }

    public void clickEditUser() {
        clickElement(buttonEditUser);
    }

    public void clickChangePassword() {
        clickElement(buttonChangePassword);
    }

    public void clickChangePasswordEnd() {
        clickElement(buttonChangePasswordEnd);
    }

    // =========================
    // Validations (BOOLEAN)
    // =========================

    /** Modal edición usuario visible */
    public boolean isEditProfileModalDisplayed() {
        return elementIsDisplayed(editProfileModal);
    }

    /** Modal cambio contraseña visible */
    public boolean isEditPasswordModalDisplayed() {
        return elementIsDisplayed(changePasswordModal);
    }

    /** Usuario editado correctamente */
    public boolean isEditUserSuccessful(String nombre, String apellido, String email) {
        return elementIsDisplayed(String.format(tableData, nombre))
                && elementIsDisplayed(String.format(tableData, apellido))
                && elementIsDisplayed(String.format(tableData, email));
    }

    /** Contraseña cambiada correctamente */
    public boolean isChangePasswordSuccessful() {
        return elementIsDisplayed(passwordChangedMessage);
    }

    /** Botón modificar usuario habilitado */
    public boolean isEditUserButtonEnabled() {
        return isElementClickable(buttonEditUser);
    }
}

