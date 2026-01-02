package pages;

public class ProfilePage extends BasePage {
    public ProfilePage() {
        super();
    }

    private String buttonProfile = "//span[text()=\"Perfil\"]";
    private String buttonEdit = "//button[text()=\"Editar Datos Usuario\"]";
    private String nameUpdate = "//input[@id=\"firstname\"]";
    private String lastnameUpdate = "//input[@id=\"lastname\"]";
    private String emailUpdate = "//input[@id=\"email\"]";
    private String openModalUpdate = "//h2[text()=\"Modificación Datos Usuario\"]";
    private String buttonChangePass = "//button[text()=\"Cambiar Contraseña\"]";
    private String buttonEditUser = "//button[text()=\"Modificar Usuario\"]";
    private String getData = "//td[text()=\"%s\"]";
    private String buttonChangePassEnd = "//div[@role=\"dialog\"]//button[text()=\"Cambiar Contraseña\"]";
    private String modalPassChange = "//div[contains(text(),\"Contraseña cambiada\")]";
    private String openModalChangePass = "//h2[text()=\"Cambiar Contraseña\"]";

    public void clickEditDataUser() {
        clickElement(buttonEdit);
    }

    public void fillEditProfile(String nombre, String apellido, String email) {
        write(nameUpdate, nombre);
        write(lastnameUpdate, apellido);
        write(emailUpdate, email);
    }

    public boolean WindowEdit() {
        return elementIsDisplayed(openModalUpdate);
    }

    public void clickProfile() {
        clickElement(buttonProfile);
    }

    public void clickChangePass() {
        clickElement(buttonChangePass);
    }

    public void clickEditUser() {
        clickElement(buttonEditUser);
    }

    public boolean EditUserSuccess(String nombre, String apellido, String email) {
        return elementIsDisplayed(String.format(getData, nombre))
                && elementIsDisplayed(String.format(getData, apellido))
                && elementIsDisplayed(String.format(getData, email));
    }

    public void clickChangePassEnd() {
        clickElement(buttonChangePassEnd);
    }

    public boolean ChangePassSuccess() {
        return elementIsDisplayed(modalPassChange);
    }

    public boolean EditPassWindow() {
        return elementIsDisplayed(openModalChangePass);
    }

    public boolean editUserFail(String nombre, String apellido, String email) {
        return elementIsDisplayed(String.format(getData, nombre))
                && elementIsDisplayed(String.format(getData, apellido))
                && elementIsDisplayed(String.format(getData, email));
    }

    public boolean buttonStatus() {
        return isElementClickable(buttonEditUser);
    }

}
