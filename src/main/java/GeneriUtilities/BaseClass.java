package GeneriUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import POM.HomePage;
import POM.LogInPage;

public class BaseClass {
	
	public PropertiesFile pf = new PropertiesFile();
	public ExcelSheet es = new ExcelSheet();
	public SeleniumUtilities sutil = new SeleniumUtilities();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite
	public void DBConfig() {
		System.out.println("DB Connection successful");
	}
	
	//@Parameters("Browser")
	@BeforeClass
	public void BrowserLaunch(/*String browser*/) throws Exception {
		driver = new ChromeDriver();	
		/*if (browser.equals("Edge") ){
			driver = new EdgeDriver();	
			
		}
		else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();	
			
		}
		else if (browser.equals("Chrome")) {
			driver = new ChromeDriver();	
			
		}*/
		sDriver=driver;
		String URL = pf.ReadData("url");
		driver.get(URL);		
		sutil.maxwindow(driver);
		sutil.implicitWait(driver);
	}
	
	@BeforeMethod
	public void LogIntoApp() throws Exception {
		String USER = pf.ReadData("username");
		String PASS = pf.ReadData("password");
		LogInPage lp = new LogInPage(driver);
		lp.logIntoApp(USER,PASS);
	}
	
	@AfterMethod
	public void signoutApp() {
		HomePage hp = new HomePage(driver);
		WebElement mh = hp.getMouseHover();
		sutil.MouseHover(driver, mh);
		WebElement so = hp.getSignOut();
		sutil.explicitWait(driver, so);
		hp.SignOut();
		System.out.println("Sign Out successful");
	}
	
	@AfterClass
	public void BrowserClose() {
		driver.close();
		System.out.println("Browser closing successful");
	}
	
	@AfterSuite
	public void DBClose() {
		System.out.println("DB close successful");
	}

}
