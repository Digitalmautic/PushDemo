package src.ExtentReports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReport1 {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	WebDriver driver;
	
	@BeforeSuite

	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent. attachReporter(htmlReporter);
	}
	
	
	@BeforeTest
	public void setUp1() 
	{
		String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	
	}

		@Test
		public void test1() throws IOException {

			ExtentTest test = extent.createTest("MyFirstTest", "Sample descriptions");
			
			//goto url
			driver.get("https://www.browserstack.com");
			test.pass("Navigate successfully.");
			
			// log(Status, details)
	        test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	        
	        // test with snapshot
	        test.addScreenCaptureFromPath("screenshot.png");
		}

		@Test
		public void test2() throws IOException {

			ExtentTest test = extent.createTest("MyFirstTest", "Sample descriptions");
			
			// log(Status, details)
	        test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	        
	        // test with snapshot
	        test.addScreenCaptureFromPath("screenshot.png");
		}
		
		@AfterTest
		public void tearDownTest() {

			driver.close();
			driver.quit();
			System.out.println("Test completed successfully...");
		}
		
		@AfterSuite
		public void tearDown() {

			// calling flush writes everything to the log file
	        extent.flush();
		}

		}
