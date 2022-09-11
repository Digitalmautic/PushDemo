package TakeScreenShot;

import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mongodb.MapReduceCommand.OutputType;

import io.undertow.util.FileUtils;

public class TakeSS {

    @Test
    public void FirstTest() {
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
 WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://www.lambdatest.com/";
        String expectedTitle = "LambdaTest - Perform all your tests on cloud";
        String actualTitle = "";
 
        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
 
        // get the actual value of the title
        actualTitle = driver.getTitle();
 
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        //close Fire fox
        driver.close();
       
	}
	
}
