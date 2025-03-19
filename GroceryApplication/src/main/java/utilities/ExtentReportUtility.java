package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {//used to generate extends html code
	public static final ExtentReports extentReports = new ExtentReports();//creates a single accessible object

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");

		reporter.config().setReportName("GroceryApplication");
		extentReports.attachReporter(reporter);//extentReports class creation and configuration of html code
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Aparna D ");
		return extentReports;
	}
}
