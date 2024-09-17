package framework.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import aquality.selenium.browser.AqualityServices;
import framework.LocatorConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomizationAccessibilitySettings extends Form {

    // Advanced Settings
    private final IElement Accessibility = getElementFactory().getLabel(
            By.xpath("//div[contains(@class, 'flex') and .//h4[text()='Advanced']]"),"Advanced Dropdown");

    //Accessibility Settings
    private final ILink lnkAccessibilitySettings = getElementFactory().getLink(
            By.xpath("//a[text()='Accessibility']"),
            "Accessibility Settings");

    //Keyboard Shortcut
    private final IElement lblKeyboardShortcut =  getElementFactory().getButton(
            By.xpath("//label[.//div[text()='Keyboard Shortcut']]//div[contains(@class, 'bg-blue-600')]"),
            "Keyboard Shortcut Enabled");

    // Save Changes button
    private final IButton saveButton2 = getElementFactory().getButton(By.xpath("//button[contains(@class, 'bg-blue-500') and contains(@class, 'text-white') and text()='Save Changes']"),"Save Button2");


    public CustomizationAccessibilitySettings() {
        super(By.xpath("//div[@data-v-571e2e25 and .//h4[text()='Advanced']]"), "Customization Accessibility Settings Page");
    }

    public void Advanced(){
        Accessibility.clickAndWait();

        JavascriptExecutor js = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", lnkAccessibilitySettings.getElement());

        WebDriverWait wait = new WebDriverWait(AqualityServices.getBrowser().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lnkAccessibilitySettings.getElement()));

        lnkAccessibilitySettings.getElement().click();

    }

    // Method to click on the Accessibility Settings link
    public void clickAccessibilitySettingsLink() {
        lnkAccessibilitySettings.click();
    }

    // Method to disable the Keyboard Shortcut
    public void KeyboardShortcut() {
        lblKeyboardShortcut.click();
    }

    // Method to save changes
    public void Changes() {
        saveButton2.state().waitForClickable();
        saveButton2.click();

    }
}

