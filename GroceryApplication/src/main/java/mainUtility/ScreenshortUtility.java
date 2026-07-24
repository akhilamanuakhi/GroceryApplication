package mainUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshortUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {
		//TakeScreenshot is predefined interface to capture screenshot
		TakesScreenshot scrShot = (TakesScreenshot) driver; //casting to get the driver control to interface
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //file created to store temporarily the captured screenshot
		//current date and time with seconds.SimpleDateFormat is predefined class
		
		//folder creation.System is predefined class and getProperty("user.dir") is that class
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory
		if (!f1.exists()) {

		f1.mkdirs();//if not created folder mkdir used to create a folder
		}
		//saving the screenshot to varable destination in .png format with name "failed testcase
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";
		//copying the file permanently to finaldestination from screenshot
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
		}

}
