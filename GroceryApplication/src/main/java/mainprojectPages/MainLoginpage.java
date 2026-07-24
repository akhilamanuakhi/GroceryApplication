package mainprojectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mainUtility.WaitUtility;

public class MainLoginpage {
	
	WaitUtility wu=new WaitUtility();
	public WebDriver driver;
	
	public MainLoginpage(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);		
	}
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement pagetext;
	@FindBy(name="username")WebElement username;
	@FindBy(name="password")WebElement password;
	@FindBy(tagName="button")WebElement login;
	
	public  MainLoginpage enterUsername(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
	}
	public MainLoginpage enterPassword(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return this;	//if it is in same page
	}
	public HomePage clickButton() {
		wu.waitUntilElementToBeClickable(driver, login);//calling wait from waitutility method class
		login.click();
		return new HomePage(driver);	//different class
	}
	public String getPageText() {
		return pagetext.getText();
	}
}
