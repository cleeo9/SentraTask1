package steps;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class OrderBySteps {
    HomePage homePage = new HomePage();

    @When("Hago click en el botón del {string}, ordenar de manera descendente")
    public void clickTitle(String option) throws InterruptedException {
        homePage.descClickOnGrid(option);
    }

    @When("Hago click en el botón del {string}, ordenar de manera ascendente")
    public void doubleClickTitle(String option) {
        homePage.ascClickOnGrid(option);
    }

    @Then("Las tareas se ordenan de manera descendente")
    public void validateTitleDescOrder() {
        Assert.assertEquals(homePage.validateOrder(), "descending");
    }

    @Then("Las tareas se ordenan de manera ascendente")
    public void validateTitleAscOrder() {
        Assert.assertEquals(homePage.validateOrder(), "ascending");
    }

}
