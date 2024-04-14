package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AllPage;
import utils.ReusableMethods;

public class CreateWalletTest extends BaseTest{

    @Test(description = "Should be able to create wallet")
    public void newWallet() throws InterruptedException {
        AllPage allPage = new AllPage();
        ReusableMethods.waitForVisibility(allPage.createWalletPage().closeButton,5000);
        allPage.createWalletPage().closeButton.click();
        Reporter.log("Close alert pop up ");
        ReusableMethods.waitForVisibility(allPage.createWalletPage().getStarted,5000);
        allPage.createWalletPage().getStarted.click();
        Reporter.log("Click the Get Started Button");
        //wait until create wallet button shows up
        ReusableMethods.waitForVisibility(allPage.createWalletPage().createWallet,10000);
        allPage.createWalletPage().createWallet.click();
        Reporter.log("Create wallet");
        //wait until skip button shows up:
        ReusableMethods.waitForVisibility(allPage.backUpPage().skipButton,5000);
        allPage.backUpPage().skipButton.click();
        //wait until numbers show up:
        ReusableMethods.waitForVisibility(allPage.passcodePage().clickOne,5000);
        //Enter six digit passcode
        allPage.passcodePage().clickPasscode("231456");
        Thread.sleep(1000);
        //Confirm six digit passcode
        allPage.passcodePage().clickPasscode("231456");
        String expectedTextWelcome = "Welcome aboard";
        ReusableMethods.assertThatText(allPage.createWalletPage().welcomeAboardText, expectedTextWelcome);

    }


}
