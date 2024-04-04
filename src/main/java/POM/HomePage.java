package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Trouble Tickets") private WebElement ticket;
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement mouseHover;
	@FindBy(linkText = "Sign Out") private WebElement signout;

	public void ClickOnTicket() {
		ticket.click();
	}
	
	public WebElement getMouseHover() {
		return mouseHover;
	}
	
	public WebElement getSignOut() {
		return signout;
	}
	
	public void SignOut() {
		signout.click();
	}

}
