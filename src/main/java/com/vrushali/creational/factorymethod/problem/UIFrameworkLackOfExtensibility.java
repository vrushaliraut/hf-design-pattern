package com.vrushali.creational.factorymethod.problem;

/*
- This approach is slightly better, but adding a new button type (SuperFancyButton) requires
modifying the createButton() method, adding another if/else condition.
- This becomes unwieldy as you add more button types.
 */
public class UIFrameworkLackOfExtensibility {
    private String buttonType;

    public UIFrameworkLackOfExtensibility(String buttonType) {
        this.buttonType = buttonType;
    }

    public Button createButton() {
        if (buttonType.equals("fancy")) {
            return new FancyButton();
        } else {
            return new Button();
        }
    }

    /* This leads to code duplication.
        The renderButton method has to know how to create and render each type of button.
         If button creation is complex, this logic is duplicated.
     */
    public void render(String buttonType) {
        if (buttonType.equals("fancy")) {
            FancyButton button = new FancyButton();
            button.onClick();
            button.render();
        } else {
            Button button = new Button();
            button.onClick();
            button.render();
        }

    }
}
