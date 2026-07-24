package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import mainUtility.MainExcelutility;
import mainprojectPages.HomePage;
import mainprojectPages.MainLoginpage;
import mainprojectPages.ManageNewsPages;

public class ManageNewsTest extends MainProjectBase{
	HomePage hp;
	ManageNewsPages mp;
	@Test	
	public void verifyWhethertheUserisAbletoAddnewNews() throws IOException {
		String usernamevalue = MainExcelutility.readStringData(0, 0, "LoginPage");
		String passwordvalue = MainExcelutility.readStringData(0, 1,"LoginPage");
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue);
		hp= lp.clickButton();
				
		mp=hp.manageNewsClickButton();
		String addnews = MainExcelutility.readStringData(0, 0, "News");
		mp.addNewNews().entertheNews(addnews).saveClick();
		
		boolean  news=mp.isNewnewsCreated();
		Assert.assertTrue( news,Constant.ADDNEWSERROR);		
	}
	@Test
	public void verifyWhethertheUserIsAbletoSearchNewlyAddedNews() throws IOException {
		String usernamevalue = MainExcelutility.readStringData(0, 0, "LoginPage");
		String passwordvalue = MainExcelutility.readStringData(0, 1,"LoginPage");
		MainLoginpage lp = new MainLoginpage(driver);
		lp.enterUsername(usernamevalue).enterPassword(passwordvalue);
		hp = lp.clickButton();
		
		mp = hp.manageNewsClickButton();
		String addnews = MainExcelutility.readStringData(0, 0, "News");
		mp.searchNewNews().addTitleofNews(addnews).titleSearchbuttonClick();
		
		String expected = MainExcelutility.readStringData(0, 0, "News");
		String actual = mp.getPageText();
		Assert.assertEquals(expected,actual, Constant.SEARCHNEWNEWSERROR);	
	}

}
