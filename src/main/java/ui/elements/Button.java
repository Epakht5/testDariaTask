package ui.elements;

public class Button extends BaseElement {

    public Button(String xpath) {
        super(xpath);
    }

    public Button(String xpath, String elementName) {
        super(xpath, elementName);
    }

    public void click() {
        getElement().click();
    }
}
