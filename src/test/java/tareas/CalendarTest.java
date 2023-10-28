package tareas;

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

public class CalendarTest {
    AppiumDriver phone;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Amy4n");
        capabilities.setCapability("platformVersion","13");
        capabilities.setCapability("appPackage","com.hihonor.calendar");
        capabilities.setCapability("appActivity","com.android.calendar.AllInOneActivity");
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
    public void verifyCreateEvent() {

        String name = "tarea prueba";

        // 1st - Accept tutorial
        phone.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        phone.findElement(By.id("com.hihonor.calendar:id/help_tip_content")).click();
        phone.findElement(By.id("com.hihonor.calendar:id/help_tip_content")).click();

        // 2nd - Create Event
        phone.findElement(By.id("com.hihonor.calendar:id/hnFAB")).click();
        phone.findElement(By.id("com.hihonor.calendar:id/header_title")).sendKeys(name);
        phone.findElement(By.id("android:id/icon2")).click();

        // 3rd Verify if it was created

        String actual = phone.findElement(By.xpath("//android.widget.TextView[@text=\""+ name +"\"]")).getText();
        Assertions.assertEquals(name, actual, "ERROR! no se creo la tarea");
    }
}
