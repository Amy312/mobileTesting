package tareas.clock;

import activities.clock.MainClockView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session.Session;

public class StartAppTest {
    MainClockView mainClockView = new MainClockView();
    @Test
    public void verifyToast(){
        mainClockView.accessButton1.click();
        mainClockView.firstAlarmSw.click();

        String toastText = mainClockView.toast.getText();
        System.out.println("Texto del Toast: " + toastText);
        Assertions.assertTrue(mainClockView.toast.getText().contains("La alarma"), "Error!");
    }
    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }
}
