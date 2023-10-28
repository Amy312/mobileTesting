package activities.calculator;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainCalculator {
    public Button fiveButton = new Button(By.xpath("//android.widget.Button[@text='5']"));
    public Button sevenButton = new Button(By.xpath("//android.widget.Button[@text='7']"));
    public Button addButton = new Button(By.id("com.hihonor.calculator:id/op_add"));
    public Button equalButton = new Button(By.id("com.hihonor.calculator:id/eq"));

    public Label resultLabel = new Label(By.xpath("//android.widget.EditText"));

}