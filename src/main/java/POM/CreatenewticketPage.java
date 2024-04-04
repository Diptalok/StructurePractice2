package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewticketPage {
	
	public CreatenewticketPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@name=\"ticket_title\"]") private WebElement Title;
	@FindBy(xpath = "//input[@value=\"  Save  \"]") private WebElement Save;
	
	public void Title(String value) {
		Title.sendKeys(value);
	}
	
	public void Save() {
		Save.click();
	}
	
}
