package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;        //importa las dependencias necesarias para integrar Cucumber con JUnit

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "steps", plugin = { "pretty",
        "html:target/cucumber-reports" }
        // , tags = "@Tags"                              //aca se define cómo y qué se ejecuta dentro del framework
        )

public class TestRunner {
}