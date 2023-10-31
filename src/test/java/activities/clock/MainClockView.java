package activities.clock;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class MainClockView {
    public Button accessButton1 = new Button(By.id("com.android.permissioncontroller:id/permission_allow_button"));
    public Button firstAlarmSw = new Button(By.xpath("(//android.widget.Switch[@resource-id=\"com.hihonor.deskclock:id/clock_onoff\"])[1]"));
    public Label toast = new Label(By.xpath("//android.widget.Toast"));

    public Button addAlarmButton = new Button(By.id("com.hihonor.deskclock:id/float_add"));
    public Button nameAlarmButton = new Button(By.xpath("//android.widget.TextView[@resource-id=\"androidhnext:id/detail\" and @text=\"Alarma\"]"));
    public TextBox nameAlarmTextBox = new TextBox(By.id("com.hihonor.deskclock:id/username_edit"));
    public Button acceptNameButton = new Button(By.id("android:id/button1"));
    public Button checkButton = new Button(By.id("android:id/icon2"));
    public Label nameAlarmLabel;

    public void setNameAlarmLabel(String nameAlarmLabel) {
        this.nameAlarmLabel = new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.hihonor.deskclock:id/am_digital\" and contains(@text,\""+nameAlarmLabel+"\")]"));
    }
}
