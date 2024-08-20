import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class eCommerce_test_1 extends BaseTest{

    @Test
    public void fillForm() throws InterruptedException {
        FillForm fillForm = new FillForm(androidDriver);
        fillForm.enterName("Eman Mostafa");
        fillForm.selectCountry("Egypt");
        fillForm.selectFemaleGender();
        fillForm.clickLetsShop();
    }
    @Test
    public void AddProductToCart() throws InterruptedException {
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

    }
    @Test
    public void AddProductToCart2() throws InterruptedException {
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
                        + "new UiSelector().text(\"Air Jordan 9 Retro\"));"));

        int productCount = androidDriver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();
        for (int i = 0; i < productCount; i++) {
            String productName = androidDriver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Air Jordan 9 Retro")) {
                androidDriver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.attributeContains(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"),"text","Cart"));

        Assert.assertEquals(androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText(),"Air Jordan 9 Retro");
    }
    @Test
    public void AddProductToCart3() throws InterruptedException {
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Eman Mostafa");
        androidDriver.hideKeyboard();
        androidDriver.findElement(AppiumBy.id("android:id/text1")).click();
        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"Albania\"));")).click();

        androidDriver.findElement((AppiumBy.id("com.androidsample.generalstore:id/radioFemale"))).click();
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        androidDriver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        androidDriver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();


        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")));

        List<WebElement> price = androidDriver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        double sum = 0;
        for (WebElement element : price) {
            String priceString = element.getText();
            double priceValue = stringParse(priceString);
            sum += priceValue;
        }

        WebElement totalAmountLbl = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")));
        double actualResult = stringParse(totalAmountLbl.getText());
        Assert.assertEquals(actualResult, sum);
        longPress(androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton")));
        androidDriver.findElement(AppiumBy.id("android:id/button1")).click();
        androidDriver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(4000);
        Set<String> contextHandles = androidDriver.getContextHandles();
        for (String context : contextHandles) {
            System.out.println(context);
        }
        androidDriver.context("WEBVIEW_com.androidsample.generalstore");
        androidDriver.findElement(By.name("q")).sendKeys("cat");
        androidDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(200);
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        androidDriver.context("NATIVE_APP");
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