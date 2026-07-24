package mainProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import mainUtility.ScreenshortUtility;

public class MainProjectBase {
	Properties pro;   //these two classes helps to read data from cofig file
	FileInputStream f;
	public WebDriver driver; 
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
		public void intialiseBrowser(String browsers) throws IOException {
			pro= new Properties();
			f= new FileInputStream(Constant.CONFIGURATION);
			pro.load(f);
			if(browsers.equalsIgnoreCase("Chrome")) {	//equalsignore is used to avoid case sensitivity
				driver =new ChromeDriver();
			}
			else if(browsers.equalsIgnoreCase("Firefox")) {
				driver =new FirefoxDriver();
			}
			else if(browsers.equalsIgnoreCase("Edge")) {
				driver =new EdgeDriver();
			}
			//file input stream and properties to read data
			driver.get(pro.getProperty("URL")); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //used apply wait
			}
	
	@AfterMethod(alwaysRun=true) //@test annotation willnot work
	public void closeBrowser(ITestResult itestresult) throws IOException{
		//itestresult is ainterface which maintance lifecycle of testcase
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			//create object for ScreenshortUtility and call the method getScreenshot
			ScreenshortUtility screenshotutility=new ScreenshortUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
		 // driver.close();
		//driver.quit();
	}

}
