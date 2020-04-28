package com.zerobank.step_definitions;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(){
        Driver.getDriver(ConfigurationReader.getProperty("browser")).manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        //if scenario failed
        if (scenario.isFailed()){
            TakesScreenshot takesScreenshot= (TakesScreenshot) Driver.getDriver(ConfigurationReader.getProperty("browser"));
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //attach screenshot to the report
            scenario.embed(image,"image/png",scenario.getName());
        }
        System.out.println("Test clean up");
        Driver.closeDriver();
    }
}
