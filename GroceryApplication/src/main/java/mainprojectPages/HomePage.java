package mainprojectPages;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mainUtility.PageUtility;

public class HomePage {
	
	PageUtility p= new PageUtility();
	public WebDriver driver;
	
	public  HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement pagetext;
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath ="//a[@class= 'dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']") WebElement logout;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminuser;
	@FindBy(xpath="//a[@class='small-box-footer'and @href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement managenews;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")WebElement managedlvryboy;
	
	public boolean isAdminbuttonEnabled() {
		return admin.isDisplayed();	
	}
	public HomePage adminclickButton() {
		admin.click();
		return this;
	}
	public MainLoginpage logoutclickButton() {
		logout.click();
		return new MainLoginpage(driver);
	}
	public String getPageText() {
		return pagetext.getText();
	}
	public AdminUsersPage adminUserClickButton() {
		adminuser.click();
		return new AdminUsersPage(driver);
	}
	public ManageNewsPages manageNewsClickButton() {
		p.click(driver, managenews);
		return new ManageNewsPages(driver);
	}
	public ManageDeliveryBoyPage manageDeliveryBoyClick() {
		managedlvryboy.click();
		return new ManageDeliveryBoyPage(driver);
	}
}
