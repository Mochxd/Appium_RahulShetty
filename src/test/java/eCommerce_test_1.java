import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

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
}
