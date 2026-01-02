package pages;

// Se importan librerias
import java.time.Duration;
import java.util.List;
import utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.stream.Collectors; 

public class BasePage {

    protected final WebDriver driver;
    // Constante para el tiempo de espera (10 segundos es un buen valor)
    private static final Duration TIMEOUT = Duration.ofSeconds(10); 

    public BasePage() {
        driver = DriverFactory.getDriver();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    // ======= MÉTODOS DE BÚSQUEDA Y ESPERA PRIVADOS =======

    /**
     * Espera y retorna un único WebElement que sea visible en el DOM.
     */
    private WebElement findVisibleElement(String locator) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     * Espera y retorna un único WebElement que sea clickeable.
     */
    private WebElement findClickableElement(String locator) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    
    /**
     * Espera a que al menos un elemento esté visible y retorna una lista de WebElements.
     * @param locator El XPath de los elementos a buscar.
     * @return Una lista de WebElements.
     */
    public List<WebElement> findElements(String locator) {
        // visibilityOfAllElementsLocatedBy espera al menos 1 elemento
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
    }
    
    // ======= ACCIONES BÁSICAS DE LECTURA DE DATOS (NUEVO MÉTODO CLAVE) =======

    /**
     * Obtiene el texto de todos los WebElements encontrados por el localizador.
     * ESTE ES EL MÉTODO CLAVE para obtener los datos de la columna.
     * @param locator El XPath del conjunto de elementos (e.g., //tbody/tr/td[1]).
     * @return Una lista de Strings con el texto de cada elemento.
     */
    public List<String> getElementsText(String locator) {
        List<WebElement> elements = findElements(locator); // Usa el findElements que espera visibilidad
        return elements.stream()
                .map(WebElement::getText) // Mapea cada WebElement a su texto
                .collect(Collectors.toList()); // Colecta los textos en una nueva lista
    }


    // ======= ACCIONES BÁSICAS DE INTERACCIÓN =======

    public void clickElement(String locator) {
        findClickableElement(locator).click();
    }

    public void write(String locator, String keysToSend) {
        WebElement element = findVisibleElement(locator);
        // Limpia el campo antes de escribir (CTRL+A, BACK_SPACE)
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(keysToSend);
    }

    public boolean elementIsDisplayed(String locator) {
        try {
            findVisibleElement(locator); // Espera visibilidad
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeBrowser() {
        driver.quit();
    }

    // ======= MÉTODOS DE VALIDACIÓN =======
    
    public String getAttributeAriaSortFromElement(String locator) {
        return findVisibleElement(locator).getDomAttribute("aria-sort");
    }
    
    // ... (El resto de tus métodos de Dropdown y otros se mantienen)
    
    // ======= DROPDOWN METHODS =======

    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(findVisibleElement(locator));
        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index) {
        Select dropdown = new Select(findVisibleElement(locator));
        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator) {
        Select dropdown = new Select(findVisibleElement(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public boolean isElementClickable(String locator) {
        try {
            findClickableElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}