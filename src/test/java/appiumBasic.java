import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class appiumBasic extends BaseTest{
    @Test
    public void AppiumTest() throws MalformedURLException {
        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
        androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        androidDriver.findElement(AppiumBy.id("android:id/widget_frame")).click();
        androidDriver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String title = androidDriver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(title,"WiFi settings");

        androidDriver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Mohamed Wifi");
        androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
}
