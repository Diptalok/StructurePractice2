package GeneriUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test Execution Started");
		
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+" Test Execution passed");
		System.out.println(methodName+" Test Execution passed");
		
		JavaUtility j = new JavaUtility();
		String passed_Screenshot = j.getDate();
		SeleniumUtilities s = new SeleniumUtilities();
		try {
			String path = s.screenshot(BaseClass.sDriver,"validation for pass"+passed_Screenshot);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+" Test Execution failed");
		System.out.println(methodName+" Test Execution failed");
		
		JavaUtility j = new JavaUtility();
		SeleniumUtilities s = new SeleniumUtilities();
		String failed_Screenshot = j.getDate();
		try {
			String path = s.screenshot(BaseClass.sDriver,"validation for failure"+failed_Screenshot);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test Execution skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite started");
		
		JavaUtility j = new JavaUtility();
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\Extent Report\\Test Report - "+j.getDate()+".html");
		rep.config().setDocumentTitle("Execution report");
		rep.config().setReportName("Ticket Report");
		rep.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base Platform", "windows");
		report.setSystemInfo("Base url", "https://localhost:8888");
		report.setSystemInfo("Reporter name","Miku");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite finished");
		report.flush();
	}

}
