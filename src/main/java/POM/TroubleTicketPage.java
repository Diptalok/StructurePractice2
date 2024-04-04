package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage {
	
	public TroubleTicketPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[contains(@alt,\"Cr\")]") private WebElement AddNewticket;
	
	public void AddNewticket() {
		AddNewticket.click();
	}
	
}
