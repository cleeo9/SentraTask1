package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utils.DriverFactory;

public class Hooks {
    @Before()
    public void setup(Scenario scenario) {                 //se ejecuta antes de cada escenario.
        DriverFactory.initDriver();
        System.out.println(scenario.getName());

    }

    @After()
    public void tearDown() {                           //se ejecuta después de cada escenario, sin importar si pasó o falló.
        DriverFactory.killDriver();
    }

}
