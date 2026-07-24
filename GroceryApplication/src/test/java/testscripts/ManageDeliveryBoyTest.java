package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import mainUtility.MainExcelutility;
import mainUtility.RandomDataUtility;
import mainprojectPages.HomePage;
import mainprojectPages.MainLoginpage;
import mainprojectPages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends MainProjectBase{
	HomePage hp;
	ManageDeliveryBoyPage md;
	@Test
	public void verifyWhetherUserisAbleToAddNewDeliveryBoy() throws IOException {
		
		String usernamevalue = MainExcelutility.readStringData(0, 0, "LoginPage");
		String passwordvalue = MainExcelutility.readStringData(0, 1,"LoginPage");
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue);
		hp = lp.clickButton();
		md = hp.manageDeliveryBoyClick();
		
		RandomDataUtility rd = new RandomDataUtility();
		String entername = rd.randomFullName();
		String enteremail = rd.randomEmail();
		String phonenumber= rd.randomMobilenumber();
		String enteraddress = rd.randomAddress();
		String enterusername = rd.randomUserName();
		String enterpassword = rd.randomPassword();
		
		md.addNewdeliveryboyClick().entertheName(entername).enterEmail(enteremail).enterPhonenumber(phonenumber).enterAddress(enteraddress).enterUserName(enterusername).enterPassword(enterpassword).saveButtonClick();
		
		boolean  newdeliveryboy=md.isNewDeliveryboyCreated();
		Assert.assertTrue(newdeliveryboy,Constant.ADDDELIVERYBOYERROR);
	}
}
