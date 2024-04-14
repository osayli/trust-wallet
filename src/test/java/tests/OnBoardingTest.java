package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AllPage;
import utils.ReusableMethods;

public class OnBoardingTest extends BaseTest {

    @Test(description = "On Boarding description")
    public void onBoardingTest() {

        AllPage allPage = new AllPage();

        ReusableMethods.waitForVisibility(allPage.onBoardingPage().closeButton,5000);
        allPage.onBoardingPage().closeButton.click();
        Reporter.log("Close alert pop up ");
        allPage.onBoardingPage().getStarted.click();
        Reporter.log("Click the Get Started Button");
    }
}
