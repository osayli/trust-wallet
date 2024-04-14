package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AllPage;
import utils.ReusableMethods;


public class ConnectWalletTest extends BaseTest{

    @Test(description = "Should not buy and token without wallet")
    public void connectWallet() throws InterruptedException {

        AllPage allPage = new AllPage();

        ReusableMethods.waitForVisibility(allPage.onBoardingPage().closeButton,5000);
        allPage.onBoardingPage().closeButton.click();
        Reporter.log("Close alert pop up ");
        allPage.onBoardingPage().getStarted.click();
        Reporter.log("Click the Get Started Button");
        ReusableMethods.scrollNClickText("ETH");
        Reporter.log("Click the ETH Token");
        ReusableMethods.waitForVisibility(allPage.connectWalletPage().buyIcon,5000);
        allPage.connectWalletPage().buyIcon.click();
        Reporter.log("Click Buy Icon");

        String expectedText = "Connect wallet";
        ReusableMethods.assertThatText(allPage.connectWalletPage().connectWallet, expectedText);
        Reporter.log("Assert the message");

    }

}
