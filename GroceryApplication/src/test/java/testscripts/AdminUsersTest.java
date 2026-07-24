package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import mainUtility.MainExcelutility;
import mainUtility.RandomDataUtility;
import mainprojectPages.AdminUsersPage;
import mainprojectPages.HomePage;
import mainprojectPages.MainLoginpage;

public class AdminUsersTest extends MainProjectBase {
	HomePage hp;
	AdminUsersPage aup;
	@Test
	public void verifyWhetherUserisAbletoCreateNewAdminUser() throws IOException {
		
		String usernamevalue = MainExcelutility.readStringData(0, 0, "LoginPage");
		String passwordvalue = MainExcelutility.readStringData(0, 1,"LoginPage");
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue);
		hp=lp.clickButton();
		
		aup = hp.adminUserClickButton();
		RandomDataUtility rd = new RandomDataUtility();
		String newusername = rd.randomUserName();
		String newpassword =rd.randomPassword();
		aup.addnewClick().enterUsername(newusername).enterPassword(newpassword).userTypeDropdown().saveClick();
		
		boolean  newuser=aup.isNewUserCreated();
		Assert.assertTrue(newuser,Constant.CREATEADMINUSERERROR);
	}
	@Test
	public void verifyWhetherUserisAbleToSearchNewlyAddedUser() throws IOException {
		String usernamevalue = MainExcelutility.readStringData(0, 0, "LoginPage");
		String passwordvalue = MainExcelutility.readStringData(0, 1,"LoginPage");
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue);
		hp = lp.clickButton();	
		aup = hp.adminUserClickButton();
		
		String newusername = MainExcelutility.readStringData(0, 0, "NewUser");
		aup.searchClick().searchUsername(newusername).searchUserTypeDropdown().searchButtonClick();
		
		boolean searchresult=aup.isUserSearch();
		Assert.assertTrue(searchresult,Constant.SEARCHNEWLYADDEDUSERERROR);	
	}
}
