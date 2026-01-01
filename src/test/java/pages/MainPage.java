package pages;

public class MainPage extends BasePage {

    // Locators
    private String buttonLogin = "//button[text()='Ingresar']";
    private String loginSuccess = "//span[text()='Home']";
    private String emailLoginInput = "//input[@id='email']";
    private String passwordLoginInput = "//input[@id='password']";

    private String buttonSignUp = "//button[text()='Crear Nuevo Usuario']";
    private String buttonRegister = "//button[text()='Registrar Usuario']";
    private String signUpSuccessMessage = "//div[text()='Usuario creado correctamente']";
    private String signUpFailMessage = "//div[text()='Contraseñas no coinciden']";

    private String firstNameInput = "//input[@id='firstname']";
    private String lastNameInput = "//input[@id='lastname']";
    private String emailInput = "//input[@id='email' and contains(@class,'MuiInputBase-input')]";
    private String passwordInput = "//input[@id='password' and contains(@class,'MuiInputBase-input')]";
    private String repeatPasswordInput = "//input[@id='repeat_password']";

    private String loginFailMessage = "//div[@role='alert']";
    private String buttonCancel = "//button[text()='Cancelar']";

    public MainPage() {
        super();
    }

    // Navigation
    public void navigateToSentraTask() {
        navigateTo("http://192.168.80.43:10300");
    }

    public void navigateToProfile() {
        navigateTo("http://192.168.80.43:10300/perfil");
    }

    // Actions
    public void clickLogin() {
        clickElement(buttonLogin);
    }

    public void clickSignUp() {
        clickElement(buttonSignUp);
    }

    public void clickRegister() {
        clickElement(buttonRegister);
    }

    public void clickCancel() {
        clickElement(buttonCancel);
    }

    // Forms
    public void fillLoginForm(String email, String password) {
        write(emailLoginInput, email);
        write(passwordLoginInput, password);
    }

    public void fillSignUpForm(
            String firstName,
            String lastName,
            String email,
            String password,
            String repeatPassword) {

        write(firstNameInput, firstName);
        write(lastNameInput, lastName);
        write(emailInput, email);
        write(passwordInput, password);
        write(repeatPasswordInput, repeatPassword);
    }

    public void fillNewPassword(String password, String repeatPassword) {
        write(passwordInput, password);
        write(repeatPasswordInput, repeatPassword);
    }

    // Validations
    public boolean isLoginSuccessful() {
        return elementIsDisplayed(loginSuccess);
    }

    public boolean isLoginFailed() {
        return elementIsDisplayed(loginFailMessage);
    }

    public boolean isSignUpSuccessful() {
        return elementIsDisplayed(signUpSuccessMessage);
    }

    public boolean isSignUpFailed() {
        return elementIsDisplayed(signUpFailMessage);
    }

    public boolean isRegisterButtonVisible() {
        return elementIsDisplayed(buttonRegister);
    }
}
