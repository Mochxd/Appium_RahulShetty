import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class longPressTest extends BaseTest{
    @Test
    public void AppiumTest() throws MalformedURLException {
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement peopleNames = androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
        longPress(peopleNames);
        String menuText = androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Sample menu')]")).getText();
        System.out.printf(menuText);
        Assert.assertEquals(menuText,"Sample menu");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
