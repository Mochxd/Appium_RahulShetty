import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumFluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerce_test_1 extends BaseTest{
    @Test
    public void fillForm() throws InterruptedException {
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Eman Mostafa");
        androidDriver.hideKeyboard();
        androidDriver.findElement(AppiumBy.id("android:id/text1")).click();
        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"Egypt\"));")).click();
        androidDriver.findElement((AppiumBy.id("com.androidsample.generalstore:id/radioFemale"))).click();
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }
    @Test
    public void fAddProductToCart() throws InterruptedException {
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Eman Mostafa");
        androidDriver.hideKeyboard();
        androidDriver.findElement(AppiumBy.id("android:id/text1")).click();
        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"Egypt\"));")).click();
        androidDriver.findElement((AppiumBy.id("com.androidsample.generalstore:id/radioFemale"))).click();
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"Air Jordan 9 Retro\"));")).click();
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Air Jordan 9 Retro\")")));

        androidDriver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
    }
    @Test
    public void fillFormWithoutEnteringName() throws InterruptedException {
        androidDriver.findElement(AppiumBy.id("android:id/text1")).click();
        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"Egypt\"));")).click();
        androidDriver.findElement((AppiumBy.id("com.androidsample.generalstore:id/radioFemale"))).click();
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = androidDriver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");
        System.out.printf(toastMessage);
        Assert.assertEquals(toastMessage,"Please enter your name");
    }
}
