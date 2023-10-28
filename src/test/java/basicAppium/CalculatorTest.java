package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTest {
    AppiumDriver phone;
    /*
    * {
  "deviceName": "Amy4n",
  "platformVersion": "13",
  "appPackage": "com.hihonor.calculator",
  "appActivity": "com.hihonor.calculator.Calculator",
  "platformName": "Android",
  "automationName": "uiautomator2"
}*/
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Amy4n");
        capabilities.setCapability("platformVersion","13");
        capabilities.setCapability("appPackage","com.hihonor.calculator");
        capabilities.setCapability("appActivity","com.hihonor.calculator.Calculator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","uiautomator2");

        phone = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        phone.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @AfterEach
    public void closeApp(){
        phone.quit();
    }
    @Test
    public void verifyAddTwoNumbers() throws InterruptedException {
        // click 5
        phone.findElement(By.id("com.hihonor.calculator:id/digit_5")).click();

        // click +
        phone.findElement(By.id("com.hihonor.calculator:id/op_add")).click();

        // click 7
        phone.findElement(By.id("com.hihonor.calculator:id/digit_7")).click();

        // click =
        phone.findElement(By.id("com.hihonor.calculator:id/eq")).click();
        Thread.sleep(5000);

        String expected= "12";
        String actual = phone.findElement(By.id("com.hihonor.calculator:id/formula")).getText();
        Assertions.assertEquals(expected, actual, "ERROR! no esta bien la suma");
    }

    @Test
    public void verifyAddTwoNumbersXpath() throws InterruptedException {
        // click 5
        phone.findElement(By.xpath("//android.widget.Button[@text='5']")).click();

        // click +
        phone.findElement(By.id("com.hihonor.calculator:id/op_add")).click();

        // click 7
        phone.findElement(By.xpath("//android.widget.Button[@text='7']")).click();

        // click =
        phone.findElement(By.id("com.hihonor.calculator:id/eq")).click();
        Thread.sleep(5000);

        String expected= "12";
        String actual = phone.findElement(By.xpath("//android.widget.EditText")).getText();
        Assertions.assertEquals(expected, actual, "ERROR! no esta bien la suma");
    }
}
