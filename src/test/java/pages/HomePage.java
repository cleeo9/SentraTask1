package pages;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }
                //Corresponden a los localizadores de XPath de la pagina HOME
    private String homeText = "//div[text()=\"Home\"]";
    private String buttonHome = "//span[text()=\"Home\"]";
    private String titleGrid = "//th/span[contains(text(),'T')]";
    private String expireDateGrid = "//th/span[contains(text(),'Fecha Venc')]";
    private String priorityGrid = "//th/span[contains(text(),'Prio')]";
    private String validateOrder = "//th[@aria-sort]";


    // DE ACA VA EL CAMBIO
    private String titleColumnData = "//tbody/a[1]/td[1]";
    private String expireDateColumnData = "//tbody/a[1]/td[3]"; 
    private String priorityColumnData = "//tbody/a[1]/td[4]";


    public List<String> getColumnValues(String option) {
    String locator = "";
    option = option.toLowerCase();

    if (option.equals("titulo")) {
        locator = titleColumnData;
    } else if (option.equals("prioridad")) {
        locator = priorityColumnData;
    } else if (option.equals("fecha vencimiento")) {
        locator = expireDateColumnData;
    } else {
        throw new IllegalArgumentException("Opción de columna no válida: " + option);
    }

    // Este método debe obtener todos los elementos con 'locator' y devolver sus textos.
    // (Asumo que tienes un método 'getElementsText' o similar en tu BasePage)
    // *** DEBES IMPLEMENTAR O USAR UN MÉTODO EN BASEPAGE QUE HAGA ESTO ***
    return getElementsText(locator); // Ejemplo: Implementar List<String> getElementsText(String locator)
   }

   // HASTA ACA VA EL CAMBIOOOOOOOOOOOOOOOOOOOO

    public boolean NavigateHome() {
        return elementIsDisplayed(homeText);               //Valida que el usuario se encuentre en la HOME

    }

    public void clickHome() {
        clickElement(buttonHome);
    }

    public void descClickOnGrid(String option) {                //Ordenamiento Descendente de la grilla
        option = option.toLowerCase();

        if (option.equals("titulo")) {
            clickElement(titleGrid);

        } else if (option.equals("prioridad")) {
            clickElement(priorityGrid);
            clickElement(priorityGrid);
        } else if (option.equals("fecha vencimiento")) {
            clickElement(expireDateGrid);
            clickElement(expireDateGrid);
        }
    }

    public void ascClickOnGrid(String option) {               //Ordenamiento ascendente de la grilla
        option = option.toLowerCase();

        if (option.equals("titulo")) {
            clickElement(titleGrid);
            clickElement(titleGrid);
        } else if (option.equals("prioridad")) {
            clickElement(priorityGrid);
        } else if (option.equals("fecha vencimiento")) {
            clickElement(expireDateGrid);
        }
    }

    public String validateOrder() {                               //Valida el orden de la grilla
        return getAttributeAriaSortFromElement(validateOrder);
    }

}
