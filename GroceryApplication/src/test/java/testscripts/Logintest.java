package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import mainUtility.MainExcelutility;
import mainprojectPages.HomePage;
import mainprojectPages.MainLoginpage;

public class Logintest extends MainProjectBase {
	HomePage hp;
	@Test(priority=1,description="user is trying to login with valid credentials",groups= {"smoke"})
	
	public void verifywhethertheuserisabletologinwithValidcredentials() throws IOException {
			
		String usernamevalue = MainExcelutility.readStringData(0, 0, "LoginPage");
		String passwordvalue = MainExcelutility.readStringData(0, 1,"LoginPage");
	
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue);
		hp=lp.clickButton();
		//AssertTrue
		
		boolean adminresult =hp.isAdminbuttonEnabled();
		Assert.assertTrue(adminresult,Constant.VALIDCREDENTIALERROR);
		
	}
	@Test(priority=2,description="user is trying to login with invalid credentials",retryAnalyzer = retry.Retry.class)
	public void verifywhethertheuserisabletologinwithInvalidCredentials() throws IOException {
		
		String usernamevalue = MainExcelutility.readStringData(1, 0, "LoginPage");
		String passwordvalue = MainExcelutility.readStringData(1, 1,"LoginPage");
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue).clickButton();
	
		//Assertequal
		String expected = "7rmart supermarket";
		String actual = lp.getPageText();
		Assert.assertEquals(expected, actual,Constant.INVALIDCREDENTIALSERROR);
	}
	@Test(priority=3,description="user is trying to login with invalidusername and valid password ")
	public void verifywhethertheuserisabletologinwithInvalidUsernameandValidpassword() throws IOException {
		
		String usernamevalue = MainExcelutility.readStringData(2, 0, "LoginPage");
		String passwordvalue = MainExcelutility.readStringData(2, 1,"LoginPage");
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue).clickButton();
		
		//Assertequal
				String expected = "7rmart supermarket";
				String actual = lp.getPageText();
				Assert.assertEquals(expected, actual,Constant.INVALIDUSERNAMEERROR);
	}
	
	@Test(priority=4,description="user is trying to login with valid username and invalid password",groups= {"smoke"},dataProvider ="loginProvider" )
	public void verifywhethertheuserisabletologinwithValidusernameInvalidPassword(String usernamevalue,String passwordvalue) throws IOException {
		
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue).clickButton();
		//Assertequal
				String expected = "7rmart supermarket";
				String actual = lp.getPageText();
				Assert.assertEquals(expected, actual,Constant.INVALIDPASSWORDERROR);
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		
	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },//all data is cosidered as object if three objects is there object[][][]
	
		// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
}
