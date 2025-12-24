package pages;

public class MainPage extends BasePage {                                  //Centraliza todos los localizadores de Xpath utilizados en la pagina principal
    private String buttonLogin = "//button[text()=\"Ingresar\"]";
    private String logInSuccess = "//span[text()=\"Home\"]";
    private String passLogin = "//input[@id=\"password\"]";
    private String emailLogin = "//input[@id=\"email\"]";
    private String buttonSignUp = "//button[text()=\"Crear Nuevo Usuario\"]";
    private String buttonRegister = "//button[text()=\"Registrar Usuario\"]";
    private String signUpSuccess = "//div[text()=\"Usuario creado correctamente\"]";
    private String nombreInput = "//input[@id=\"firstname\"]";
    private String apellidoInput = "//input[@id=\"lastname\"]";
    private String emailInput = "//input[@class =\"MuiInputBase-input MuiInput-input css-mnn31\" and @id=\"email\" ] ";
    private String contraseñaInput = "//input[@class =\"MuiInputBase-input MuiInput-input css-mnn31\" and @id=\"password\" ] ";
    private String repetirContraseñaInput = "//input[@class =\"MuiInputBase-input MuiInput-input css-mnn31\" and @id=\"repeat_password\"]";
    private String logInFail = "//div[@role=\"alert\"]";
    private String signUpFail = "//div[text()=\"Contraseñas no coinciden\"]";
    private String buttonCancel = "//button[text()=\"Cancelar\"]";

    public MainPage() {
        super();
    }

    public void iNavigateToSentraTsk() {          //Este bloque encapsula la navegación directa a distintas secciones del sistema
        navigateTo("http://192.168.80.43:10300");

    }

    public void clickSignUp() {    //aca se agrupan las acciones de clic de la página
        clickElement(buttonSignUp);
    }

    public boolean firstResult() {         //Este bloque valida resultados exitosos de acciones del usuario
        return elementIsDisplayed(buttonRegister);
    }

    public boolean successResult() {
        System.out.println(elementIsDisplayed(signUpSuccess));
        return elementIsDisplayed(signUpSuccess);
    }

    public void fillSignUpForm(String nombre, String apellido, String email, String contraseña) {
        write(nombreInput, nombre);
        write(apellidoInput, apellido);                  ////encapsula el llenado del formulario de registro con datos válidos
        write(emailInput, email);
        write(contraseñaInput, contraseña);
        write(repetirContraseñaInput, contraseña);
    }

    public void clickRegister() {
        clickElement(buttonRegister);
    }

    public void fillLoginForm(String email, String contraseña) {
        write(emailLogin, email);
        write(passLogin, contraseña);

    }

    public void clickLogin() {
        clickElement(buttonLogin);
    }

    public boolean LogInsuccessResult() {
        System.out.println(elementIsDisplayed(logInSuccess));
        return elementIsDisplayed(logInSuccess);
    }

    public void iNavigateToprofile() {
        navigateTo("http://192.168.80.43:10300/perfil");

    }

    public void fillNewPass(String contraseña, String repetirContraseña) {
        write(contraseñaInput, contraseña);
        write(repetirContraseñaInput, repetirContraseña);
    }

    public boolean LogInFailResult() {                           //permite validar mensajes de error
        System.out.println(elementIsDisplayed(logInFail));
        return elementIsDisplayed(logInFail);
    }

    public boolean failResult() {
        System.out.println(elementIsDisplayed(signUpFail));
        return elementIsDisplayed(signUpFail);
    }
                
    public void fillFailSignUpForm(String nombre, String apellido, String email, String contraseña,
            String contraseña2) {                                              
        write(nombreInput, nombre);
        write(apellidoInput, apellido);                      //encapsula el llenado del formulario de registro con datos no validos
        write(emailInput, email);
        write(contraseñaInput, contraseña);
        write(repetirContraseñaInput, contraseña2);
    }

    public void ToClickCancel() {
        clickElement(buttonCancel);

    }
}