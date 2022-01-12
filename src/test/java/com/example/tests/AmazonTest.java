package com.example.tests;


import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
@CucumberOptions(
        features = "classpath:/src/test/cucumber/amazon.feature",
        glue = {"com.example.cucumber.steps"},
        plugin = {"pretty","html:Report"},
        dryRun = true,
        monochrome = true
)

public class AmazonTest {


}
