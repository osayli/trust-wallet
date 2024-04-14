package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.DriverUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

   public ExtentReports extentReports;
    public static ExtentTest extentTest;
    public ExtentHtmlReporter extentHtmlReporter;
    @BeforeClass
    public void setUp() {
        DriverUtils.initializeDriver();


            extentReports=new ExtentReports();

            String filePath=System.getProperty("user.dir")+"/test-output/myprojectreport.html";

            extentHtmlReporter=new ExtentHtmlReporter(filePath);

            extentReports.attachReporter(extentHtmlReporter);

            extentReports.setSystemInfo("Environment","QA Environment");
            extentReports.setSystemInfo("Automation Engineer","O.SAYLI");
            extentHtmlReporter.config().setDocumentTitle("TrustWallet");
            extentHtmlReporter.config().setReportName("TrustWallet Automation Reports");
    }

    @AfterClass
    public void tearDown(ITestResult result) throws IOException {
        DriverUtils.quitDriver();

        if(result.getStatus()==ITestResult.FAILURE){

            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

            TakesScreenshot ts = (TakesScreenshot) DriverUtils.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);

            String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + date + ".png";
            File finalDestination = new File(target);

            FileUtils.copyFile(source, finalDestination);

            extentTest.fail("TEST CASE IS FAILED : "+result.getName());
        }else if (result.getStatus()==ITestResult.SKIP){
            extentTest.skip("TEST CASE IS SKIPPED : "+result.getName());
        }
        extentReports.flush();
    }

}
