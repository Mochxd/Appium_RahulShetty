import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class dragAndDrop extends  BaseTest {
    @Test
    public void AppiumTest() throws MalformedURLException {
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = androidDriver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        dragAndDrop(source, 600, 600);

        Assert.assertEquals(androidDriver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText(),"Dropped!");
    }
}