package mainUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	public void selectDragDropWithindex(WebElement element, int index) {
		Select object=new Select(element);
		object.selectByIndex(index);
	}
	public void selectDragDropWithVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}
	public void scroll(WebElement driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		js.executeScript("window.scrollBy(0,350)", "");
	}
	public void click(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element); 
		
	}

}
//ass
//select by index,select by visibletext
//javascript click and javascript scroll 4method