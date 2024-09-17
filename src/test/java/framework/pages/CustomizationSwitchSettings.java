package framework.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import aquality.selenium.browser.AqualityServices;
import framework.LocatorConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CustomizationSwitchSettings extends Form {

    // Customization
    private final IElement pnlCustomization = getElementFactory().getButton(
            By.xpath("//div[@data-v-571e2e25 and .//h4[text()='Customization']]"),
            "Customization Panel");

    // Switch Settings
    private final ILink lnkSwitchSettings = getElementFactory().getLink(
            By.xpath("//a[text()='Switch Settings']"),
            "Switch Settings Link");

    // Floating Switch Style option
    private final IButton btnFloatingSwitchStyle = getElementFactory().getButton(
            By.xpath("//div[@data-size='1' and contains(@class, 'wp-dark-mode-switch-2')]"),
            "Floating Switch Style (Switch 2)");

    // Save Changes button
    private final IButton btnSaveChanges = getElementFactory().getButton(By.className("border-blue-500"), "Save Button");

    // Custom option button
    private final IButton btnCustomOption = getElementFactory().getButton(
            By.xpath("//div[contains(@class, 'cursor-pointer') and .//span[text()='Custom']]"),
            "Custom Option");


    // Slider
    private final IElement sliderScale = getElementFactory().getTextBox(
            By.cssSelector("input.range"),
            "Scale Slider");

    public CustomizationSwitchSettings() {
        super(By.xpath("//div[@data-v-571e2e25 and .//h4[text()='Customization']]"), "Customization Switch Settings Page");
    }

    // Floating Switch Position (Left) option
    private final IButton btnFloatingSwitchLeft = getElementFactory().getButton(
            By.xpath("//div[contains(@class, 'cursor-pointer') and .//span[text()='Left']]"),
            "Floating Switch Position (Left)");

    // Click on the Customization
    public void clickCustomizationPanel() {
        pnlCustomization.state().waitForDisplayed(); // Wait until the panel is displayed
        pnlCustomization.click();
    }

    // Method to click on the Switch Settings link
    public void clickSwitchSettingsLink() {
        lnkSwitchSettings.state().waitForDisplayed(); // Wait until the link is displayed
        lnkSwitchSettings.click();
    }

    // Click on the Floating Switch Style option
    public void clickFloatingSwitchStyle() {
        btnFloatingSwitchStyle.state().waitForDisplayed(); // Wait until the button is visible
        btnFloatingSwitchStyle.click();
    }

    // Method to click on the Custom option
    public void clickCustomOption() {
        btnCustomOption.state().waitForClickable();
        btnCustomOption.click();
    }

    //scroll the page
    private void scrollPage(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    //clear and type into the scale input field
    public void setSliderScale(int value) {
        sliderScale.state().waitForDisplayed();

        // Scroll to the slider element to ensure it's visible
        JavascriptExecutor js = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", sliderScale.getElement());

        // Use JavaScript to set the slider value and style
        js.executeScript("arguments[0].value = arguments[1];", sliderScale.getElement(), value);

        // Trigger the input and change events to notify the application of the value change
        js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", sliderScale.getElement());
        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", sliderScale.getElement());
    }


    // Method to save changes
    public void saveChanges() {
        btnSaveChanges.state().waitForDisplayed();
        btnSaveChanges.click();
    }

    // Method to click on the "Left" option
    public void clickFloatingSwitchLeft() {
        btnFloatingSwitchLeft.state().waitForDisplayed();
        btnFloatingSwitchLeft.click();

    }
}