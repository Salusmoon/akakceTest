package mobileautomation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Test",
        features = "src/test/resource/feature",
        glue = {"base",
                "stepDefinitions"
        }
)
public class CucumberRunner {

}
