package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import mainUtility.MainExcelutility;
import mainprojectPages.HomePage;
import mainprojectPages.MainLoginpage;

public class HomeTest extends MainProjectBase{
	HomePage hp;
	@Test	
	public void verifywhethertheUserisAbletoSuccessfullyLogOut() throws IOException {
		
		String usernamevalue = MainExcelutility.readStringData(0, 0, "LoginPage");
		String passwordvalue = MainExcelutility.readStringData(0, 1,"LoginPage");
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue);
		hp = lp.clickButton();
		
		hp.adminclickButton();
		lp=hp.logoutclickButton();
		//assert equal
		String expected = "7rmart supermarket";
		String actual = lp.getPageText();
		Assert.assertEquals(expected, actual,Constant.LOGOUTERROR);
	}
}
