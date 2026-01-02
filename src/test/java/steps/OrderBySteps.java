package steps;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import java.util.ArrayList; // Importación necesaria para crear copias de la lista
import java.util.Collections; // Importación necesaria para Collections.sort() y Collections.reverse()
import java.util.List; // Importación necesaria para List

public class OrderBySteps {

    // Inicialización de la Page Object
    HomePage homePage = new HomePage();
    
    // Variables de instancia para guardar el estado entre los pasos (When y Then)
    private List<String> currentColumnValues; // Almacena los valores extraídos de la columna de la web.
    private String lastOptionClicked; // Almacena el nombre de la columna ('Titulo', 'Prioridad', etc.).

    /**
     * Paso de Cucumber para ordenar de forma descendente.
     * @param option El nombre de la columna (e.g., "titulo", "prioridad").
     */
    @When("Hago click en el botón del {string}, ordenar de manera descendente")
    public void clickTitle(String option) throws InterruptedException {
        // 1. Ejecutar la acción de clic en la página
        homePage.descClickOnGrid(option);
        
        // 2. Capturar el estado de la aplicación para validación
        this.lastOptionClicked = option;
        this.currentColumnValues = homePage.getColumnValues(option);
    }

    /**
     * Paso de Cucumber para ordenar de forma ascendente.
     * @param option El nombre de la columna (e.g., "titulo", "prioridad").
     */
    @When("Hago click en el botón del {string}, ordenar de manera ascendente")
    public void doubleClickTitle(String option) {
        // 1. Ejecutar la acción de clic en la página
        homePage.ascClickOnGrid(option);
        
        // 2. Capturar el estado de la aplicación para validación
        this.lastOptionClicked = option;
        this.currentColumnValues = homePage.getColumnValues(option);
    }

    /**
     * Paso de validación para orden descendente.
     */
    @Then("Las tareas se ordenan de manera descendente")
    public void validateTitleDescOrder() {
        // 1. Verificación de UI/ARIA (Opcional: valida que la cabecera indica el orden)
        Assert.assertEquals(homePage.validateOrder(), "descending", 
            "La cabecera de la columna '" + this.lastOptionClicked + "' no tiene 'aria-sort' en 'descending'.");

        // 2. **Verificación Real de Contenido (Lógica Clave)**
        
        // Crear una copia de los datos reales de la web
        List<String> expectedDescOrder = new ArrayList<>(this.currentColumnValues);
        
        // Ordenar la copia de forma natural (A-Z)
        Collections.sort(expectedDescOrder);
        
        // Invertir el orden (Z-A, descendente)
        Collections.reverse(expectedDescOrder); 

        // Comparar la lista obtenida de la web con la lista esperada y correctamente ordenada
        Assert.assertEquals(this.currentColumnValues, expectedDescOrder, 
            "El contenido de la columna '" + this.lastOptionClicked + "' NO está ordenado descendentemente.");
    }

    /**
     * Paso de validación para orden ascendente.
     */
    @Then("Las tareas se ordenan de manera ascendente")
    public void validateTitleAscOrder() {
        // 1. Verificación de UI/ARIA (Opcional: valida que la cabecera indica el orden)
        Assert.assertEquals(homePage.validateOrder(), "ascending", 
            "La cabecera de la columna '" + this.lastOptionClicked + "' no tiene 'aria-sort' en 'ascending'.");

        // 2. **Verificación Real de Contenido (Lógica Clave)**
        
        // Crear una copia de los datos reales de la web
        List<String> expectedAscOrder = new ArrayList<>(this.currentColumnValues);
        
        // Ordenar la copia de forma natural (A-Z, ascendente)
        Collections.sort(expectedAscOrder);

        // Comparar la lista obtenida de la web con la lista esperada y correctamente ordenada
        Assert.assertEquals(this.currentColumnValues, expectedAscOrder, 
            "El contenido de la columna '" + this.lastOptionClicked + "' NO está ordenado ascendentemente.");
    }
}
