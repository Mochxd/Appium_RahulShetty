import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FillForm {
    private AndroidDriver androidDriver;
    private By nameField = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private By countryDropdown = AppiumBy.id("android:id/text1");
    private By femaleRadioButton = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private By letsShopButton = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

    public FillForm(AndroidDriver driver) {
        this.androidDriver = driver;
    }
    public void enterName(String name) {
        androidDriver.findElement(nameField).sendKeys(name);
    }

    public void selectCountry(String countryName) {
        androidDriver.findElement(countryDropdown).click();
        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"" + countryName + "\"));")).click();
    }
    public void selectFemaleGender() {
        androidDriver.findElement(femaleRadioButton).click();
    }
    public void clickLetsShop() {
        androidDriver.findElement(letsShopButton).click();
    }
}
