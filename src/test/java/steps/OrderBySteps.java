package steps;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List; 
import java.util.Comparator; // Nueva importación para ordenación compleja
import java.time.LocalDateTime; // Nueva importación para manejar fechas
import java.time.format.DateTimeFormatter; // Nueva importación para formatear fechas


public class OrderBySteps {

    // Inicialización de la Page Object
    HomePage homePage = new HomePage();
    
    // Variables de instancia para guardar el estado entre los pasos (When y Then)
    private List<String> currentColumnValues; // Almacena los valores extraídos de la columna de la web.
    private String lastOptionClicked; // Almacena el nombre de la columna ('Titulo', 'Prioridad', etc.).

    // ==========================================================
    // PASOS WHEN (ACCIONES DE CLIC Y CAPTURA DE DATOS)
    // ==========================================================
    
    /**
     * Paso de Cucumber para ordenar de forma descendente.
     * @param option El nombre de la columna (e.g., "titulo", "prioridad").
     */
    @When("Hago click en el botón del {string}, ordenar de manera descendente")
    public void clickTitle(String option) {
        // 1. Ejecutar la acción de clic en la página
        homePage.descClickOnGrid(option);
        
        // 2. Capturar el estado de la aplicación para validación
        this.lastOptionClicked = option;
        // Capturamos los datos DESPUÉS del clic, que deberían estar ordenados
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
        // Capturamos los datos DESPUÉS del clic, que deberían estar ordenados
        this.currentColumnValues = homePage.getColumnValues(option);
    }

    // ==========================================================
    // PASOS THEN (VALIDACIÓN DE ORDEN REAL)
    // ==========================================================
    
    /**
     * Paso de validación para orden descendente.
     */
    @Then("Las tareas se ordenan de manera descendente")
    public void validateTitleDescOrder() {
        // 1. Verificación de UI/ARIA (Opcional)
        Assert.assertEquals(homePage.validateOrder(), "descending", 
            "La cabecera de la columna '" + this.lastOptionClicked + "' no tiene 'aria-sort' en 'descending'.");

        // 2. **Verificación Real de Contenido (Lógica Clave)**
        // Obtenemos la lista esperada con la lógica de ordenamiento correcta (false = Descendente)
        List<String> expectedDescOrder = getExpectedSortedList(false); 

        // Comparar la lista obtenida de la web con la lista esperada
        Assert.assertEquals(this.currentColumnValues, expectedDescOrder, 
            "El contenido de la columna '" + this.lastOptionClicked + "' NO está ordenado descendentemente.");
    }

    /**
     * Paso de validación para orden ascendente.
     */
    @Then("Las tareas se ordenan de manera ascendente")
    public void validateTitleAscOrder() {
        // 1. Verificación de UI/ARIA (Opcional)
        Assert.assertEquals(homePage.validateOrder(), "ascending", 
            "La cabecera de la columna '" + this.lastOptionClicked + "' no tiene 'aria-sort' en 'ascending'.");

        // 2. **Verificación Real de Contenido (Lógica Clave)**
        // Obtenemos la lista esperada con la lógica de ordenamiento correcta (true = Ascendente)
        List<String> expectedAscOrder = getExpectedSortedList(true); 

        // Comparar la lista obtenida de la web con la lista esperada
        Assert.assertEquals(this.currentColumnValues, expectedAscOrder, 
            "El contenido de la columna '" + this.lastOptionClicked + "' NO está ordenado ascendentemente.");
    }
    
    /**
     * Genera la lista esperada aplicando la lógica de ordenamiento correcta (String, Integer o Date).
     * @param isAscending Indica si el orden debe ser ascendente (true) o descendente (false).
     * @return Una nueva lista de Strings ordenada según el tipo de columna.
     */
    private List<String> getExpectedSortedList(boolean isAscending) {
        // Crear una copia de los datos reales para ordenarla con lógica Java
        List<String> expectedList = new ArrayList<>(this.currentColumnValues);
        
        // Determinar la lógica de ordenamiento según el nombre de la columna
        switch (this.lastOptionClicked.toLowerCase()) {
            
            // 1. TÍTULO (STRING / Alfabético)
            case "titulo":
                if (isAscending) {
                    Collections.sort(expectedList);
                } else {
                    Collections.sort(expectedList, Collections.reverseOrder());
                }
                break;

            // 2. PRIORIDAD (INTEGER / Numérico, soporta negativos)
            case "prioridad":
                // Comparator para parsear la String a Integer antes de ordenar
                Comparator<String> integerComparator = (s1, s2) -> {
                    // Manejar posible Not-A-Number (NaN) si la tabla tiene valores vacíos o no numéricos
                    try {
                        Integer i1 = Integer.parseInt(s1);
                        Integer i2 = Integer.parseInt(s2);
                        return isAscending ? i1.compareTo(i2) : i2.compareTo(i1);
                    } catch (NumberFormatException e) {
                        // Tratar elementos no numéricos o vacíos como el valor más bajo o más alto
                        return s1.compareTo(s2); 
                    }
                };
                Collections.sort(expectedList, integerComparator);
                break;

            // 3. FECHA VENCIMIENTO (DATETIME / Cronológico)
            case "fecha vencimiento":
                // Define el formato exacto de tu string de fecha: 2025-12-24T19:25:58
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                
                // Comparator para parsear la String a LocalDateTime
                Comparator<String> dateComparator = (s1, s2) -> {
                    // Manejar posible error de parseo (fechas vacías o mal formadas)
                    try {
                        LocalDateTime d1 = LocalDateTime.parse(s1, formatter);
                        LocalDateTime d2 = LocalDateTime.parse(s2, formatter);
                        return isAscending ? d1.compareTo(d2) : d2.compareTo(d1);
                    } catch (Exception e) {
                        // Tratar fechas vacías o inválidas como el valor más bajo (o alto)
                        return s1.compareTo(s2); 
                    }
                };
                Collections.sort(expectedList, dateComparator);
                break;
                
            default:
                // Fallback de string para cualquier otra columna no definida
                if (isAscending) {
                    Collections.sort(expectedList);
                } else {
                    Collections.sort(expectedList, Collections.reverseOrder());
                }
                break;
        }
        
        return expectedList;
    }
}