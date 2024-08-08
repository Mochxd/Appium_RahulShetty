import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.checkerframework.common.reflection.qual.NewInstance;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasic {
    @Test
    public void AppiumTest() throws MalformedURLException {

        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\zas\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Mostafa");
        options.setApp("D:\\Appium\\Appium_RahulShetty\\src\\main\\resources\\ApiDemos-debug.apk");
        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);

        androidDriver.quit();
        service.stop();
    }
}
