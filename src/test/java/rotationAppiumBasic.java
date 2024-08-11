import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class rotationAppiumBasic extends BaseTest{
    @Test
     public void AppiumTest() throws MalformedURLException {
        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
        androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        androidDriver.findElement(AppiumBy.id("android:id/widget_frame")).click();
        DeviceRotation rotation = new DeviceRotation(0,0,90);
        androidDriver.rotate(rotation);
        androidDriver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String title = androidDriver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(title,"WiFi settings");

        androidDriver.setClipboardText("Mohamed Wifi");
        androidDriver.findElement(AppiumBy.id("android:id/edit")).sendKeys(androidDriver.getClipboardText());
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
