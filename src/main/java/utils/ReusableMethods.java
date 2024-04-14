package utils;


import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

import io.appium.java_client.touch.WaitOptions;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pages.BasePage;

import java.time.Duration;

public class ReusableMethods extends BasePage {

    public static WebDriverWait wait;


    public static void waitFor(int second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }






    public static  void assertThatText(WebElement element,String text) {

        waitForVisibility(element,5000);
        Assert.assertEquals(element.getText(),text);

    }


    public static void scrollElement(double anc, double startP, double endP) {

        Dimension size = driver.manage().window().getSize();


        int anchor = (int) (size.width * anc);
        int startPoint = (int) (size.height * startP);
        int endPoint = (int) (size.height * endP);

        ReusableMethods.waitFor(1);

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();

    }

    public static void textWithClick(String text) {

        driver.findElement(By.xpath("//*[@text " + "=" + " '" + text + "']")).click();

    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {

        wait = new WebDriverWait(driver, Duration.ofMillis(timeToWaitInSec));
        return (WebElement) wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollNClickText(String text) {
        int retry = 0;
        while (retry <= 5) {
            try {
                textWithClick(text);
                break;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                scrollElement(0.1, 0.9, 0.1);
                retry++;
            }
        }
    }








}
