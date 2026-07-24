package mainprojectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mainUtility.PageUtility;

public class ManageDeliveryBoyPage {
	
	PageUtility p= new PageUtility();
	public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement admininf;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement addnewdeliveryboy;
	@FindBy(id = "name")WebElement name;
	@FindBy(id = "email")WebElement email;
	@FindBy(id = "phone")WebElement phone;
	@FindBy(id ="address")WebElement address;
	@FindBy(id = "username")WebElement username;
	@FindBy(id = "password")WebElement password;
	@FindBy(xpath ="//button[@class='btn btn-danger' and @name='create']")WebElement save;
	
	public boolean isNewDeliveryboyCreated() {
		return admininf.isDisplayed();
	}
	public ManageDeliveryBoyPage addNewdeliveryboyClick() {
		addnewdeliveryboy.click();
		return this;
	}
	public ManageDeliveryBoyPage entertheName(String entername) {
		name.sendKeys(entername);
		return this;
	}
	public ManageDeliveryBoyPage enterEmail(String enteremail) {
		email.sendKeys(enteremail);
		return this;
	}
	public ManageDeliveryBoyPage enterPhonenumber(String phonenumber) {
		phone.sendKeys(phonenumber);
		return this;
	}
	public ManageDeliveryBoyPage enterAddress(String enteraddress) {
		address.sendKeys(enteraddress);
		return this;
	}
	public ManageDeliveryBoyPage enterUserName(String enterusername) {
		username.sendKeys(enterusername);
		return this;
	}
	public ManageDeliveryBoyPage enterPassword(String enterpassword) {
		password.sendKeys(enterpassword);
		return this;
	}
	public ManageDeliveryBoyPage saveButtonClick() {
		p.click(driver,save);
		return this;
	
	}
}
