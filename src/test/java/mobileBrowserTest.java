import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class mobileBrowserTest extends BrowserBaseTest{
    @Test
    public void test(){
//        androidDriver.get("https://www.google.com");
//        System.out.printf(androidDriver.getTitle());
//        androidDriver.findElement(By.name("q")).sendKeys("cat");
//        androidDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        androidDriver.get("https://rahulshettyacademy.com/angularAppdemo/");
        androidDriver.findElement(By.xpath("//span[@class ='navbar-toggler-icon']")).click();
        androidDriver.findElement(By.cssSelector("a[routerlink='/products']")).click();
        ((JavascriptExecutor) androidDriver).executeScript("window.scrollBy(0,1000)","");
        Assert.assertEquals(androidDriver.findElement(By.xpath("//a[@href='/angularAppdemo/products/3']")).getText(),"Devops");
    }
}
