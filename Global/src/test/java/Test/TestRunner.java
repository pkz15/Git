package Test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/Test.feature", glue = { "Test" }, monochrome = true, plugin = {
		"pretty", "html:target/HTMLReport/report.html", "json:target/JSONReport/report.json",
		"junit:target/JUNITReport/report.xml" }, tags = "@gd")
public class TestRunner {
}
