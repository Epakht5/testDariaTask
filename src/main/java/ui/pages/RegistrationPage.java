package ui.pages;

import ui.elements.BaseElement;
import ui.elements.Button;
import ui.elements.TextBox;
import ui.properties.DataReader;

public class RegistrationPage{
    private String login = "//input[@class='inputOutside__input--Ad7Xu' and @placeholder='Login']";
    private String password = "//input[@class='inputOutside__input--Ad7Xu' and @placeholder='Password']";
    private String submit = "//button[@class='bigButton__big-button--BmG4Q bigButton__rounded-corners--c_Xiz bigButton__color-organish--gj0Mz']";

    public void fillLogin(){
        new BaseElement(login).isVisible();
        new TextBox(login).clear();
        new TextBox(login).sendKeys(new DataReader().getLogin());
    }

    public void fillPassword(){
        new TextBox(password).clear();
        new TextBox(password).sendKeys(new DataReader().getPassword());
    }

    public void clickOnSubmit(){
        new Button(submit).click();
    }
}
