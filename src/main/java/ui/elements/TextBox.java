package ui.elements;

public class TextBox extends BaseElement {
    public TextBox(String locator) {
        super(locator);
    }

    public TextBox(){
    }

    public void sendKeys(String text){
        getElement().sendKeys(text);
    }

    public void clear(){
        getElement().clear();
    }
}
