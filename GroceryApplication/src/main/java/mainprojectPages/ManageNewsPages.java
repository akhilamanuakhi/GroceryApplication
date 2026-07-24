package mainprojectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPages {

	public WebDriver driver;
		
		public ManageNewsPages(WebDriver driver) {
			this.driver = driver;
			
			PageFactory.initElements(driver, this);		
		}
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement addNewnews;
		@FindBy(id="news") WebElement news;
		@FindBy(xpath="//button[@name='create']")WebElement save;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchnews;
		@FindBy(xpath="//input[@class='form-control']")WebElement title;
		@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement titlesearch;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement addednews;
		@FindBy(xpath ="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement pagetext;
		
		public boolean isNewnewsCreated() {
			return  addednews.isDisplayed();
		}
		public String getPageText() {
			return pagetext.getText();
		}
		public ManageNewsPages addNewNews() {	
			addNewnews.click();
			return this;
		}
		public ManageNewsPages entertheNews(String addnews) {
			news.sendKeys(addnews);
			return this;	
		}
		public ManageNewsPages saveClick() {
			save.click();
			return this;
		}
		public ManageNewsPages searchNewNews() {
			searchnews.click();
			return this;
		}
		public ManageNewsPages addTitleofNews(String addnews) {
			title.sendKeys(addnews);
			return this;
		}
		public ManageNewsPages titleSearchbuttonClick() {
			titlesearch.click();
			return this;
		}
}
