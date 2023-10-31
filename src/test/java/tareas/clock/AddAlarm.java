package tareas.clock;

import activities.clock.MainClockView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

public class AddAlarm {

    MainClockView mainClockView = new MainClockView();
    @Test
    public void verifyCreateAlarm(){
        String name = "alarma de prueba";
        mainClockView.accessButton1.click();
        mainClockView.addAlarmButton.click();

        mainClockView.nameAlarmButton.click();
        mainClockView.nameAlarmTextBox.click();
        mainClockView.nameAlarmTextBox.clearSetText(name);

        mainClockView.acceptNameButton.click();
        mainClockView.checkButton.click();

        mainClockView.setNameAlarmLabel(name);

        Assertions.assertTrue(mainClockView.nameAlarmLabel.getText().contains(name), "Error!");
    }
    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }
}
