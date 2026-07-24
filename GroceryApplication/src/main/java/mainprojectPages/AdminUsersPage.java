package mainprojectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import mainUtility.PageUtility;

public class AdminUsersPage {
		PageUtility pu =new PageUtility();
		public WebDriver driver;
			
		public AdminUsersPage(WebDriver driver) {
				this.driver = driver;	
				PageFactory.initElements(driver, this);		
			}
			
			@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement admininf;
			@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement addnew;
			@FindBy(id="username")WebElement user;
			@FindBy(id="password") WebElement password;
			@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
			@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @name='Create']") WebElement save;
			@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement search;
			@FindBy(id="un")WebElement searchuser;
			@FindBy(xpath="//select[@id='ut']")WebElement searchUsertype;
			@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @value='sr']") WebElement searchbutton;
			@FindBy(xpath="//td[text()='User1']")WebElement searchinf;
			
			public boolean isNewUserCreated() {
				return admininf.isDisplayed();
			}
			public boolean isUserSearch() {
				return searchinf.isDisplayed();
			}
			public AdminUsersPage addnewClick() {
				addnew.click();
				return this;
			}
			public AdminUsersPage enterUsername(String newusername) {	
				user.sendKeys(newusername);
				return this;
			}
			public AdminUsersPage enterPassword(String newpassword) {	
				password.sendKeys(newpassword);
				return this;
			}
			public AdminUsersPage userTypeDropdown() {
				pu.selectDragDropWithindex(usertype, 2);
				return this;
			}
			public AdminUsersPage saveClick() {
				save.click();
				return this;
			}
			public AdminUsersPage searchClick() {
				search.click();
				return this;
			}
			public AdminUsersPage searchUsername(String newusername) {
				searchuser.sendKeys(newusername);
				return this;
			}
			public AdminUsersPage searchUserTypeDropdown() {
				pu.selectDragDropWithindex(searchUsertype, 2);
				return this;
			}
			public AdminUsersPage searchButtonClick() {
				searchbutton.click();
				return this;
			}				
}
