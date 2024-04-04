package TestScript;

//import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GeneriUtilities.BaseClass;
import POM.CreatenewticketPage;
import POM.HomePage;
import POM.TroubleTicketPage;

@Listeners(GeneriUtilities.ListenersImplementation.class)
public class TroubleTicketModule_Test extends BaseClass{
	@Test (retryAnalyzer=GeneriUtilities.RetryAnalyzerImplementation.class)
	public void TroubleTicketModuleTest() throws Exception {
		HomePage hp = new HomePage(driver);
		//Assert.fail();
		hp.ClickOnTicket();
		TroubleTicketPage tp = new TroubleTicketPage(driver);
		tp.AddNewticket();
		CreatenewticketPage cp = new CreatenewticketPage(driver);	
		String val = es.ReadData("Sheet1", 0, 0);
		cp.Title(val);
		cp.Save();
	}

}
