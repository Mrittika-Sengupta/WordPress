package framework.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import framework.LocatorConstants;
import org.openqa.selenium.By;

public class SiteAnimationCustomization extends Form {

    // Customization button
    private final IButton pnlCustomization = getElementFactory().getButton(
            By.xpath("//div[@data-v-571e2e25 and .//h4[text()='Customization']]"),
            "Customization Panel");

    // Site Animation
    private final ILink lnkSiteAnimation = getElementFactory().getLink(
            By.xpath("//a[text()='Site Animation']"),
            "Site Animation Link");

    // Enable Page Transition Animation toggle
    private final IElement chkEnablePageTransition = getElementFactory().getTextBox(
            By.xpath("//div[contains(@class,'relative w-10 h-full')]"),
            "Enable Page Transition Animation Toggle");

    // Animation effect selection for Roll
    private final IElement optRollEffect =  getElementFactory().getLabel(
            By.xpath("//div[contains(@class, 'cursor-pointer') and .//span[text()='Roll']]//span[contains(@class, 'border')]"),
            "Roll Animation Effect Option");

    // Save changes button
    private final IButton btnSaveChanges = getElementFactory().getButton(By.className("border-blue-500"), "Save Button");
    public SiteAnimationCustomization() {
        super(By.xpath("//div[@data-v-571e2e25 and .//h4[text()='Site Animation']]"), "Site Animation Customization Page");
    }

    // Method to click on Customization
    public void clickCustomizationPanel() {
        pnlCustomization.state().waitForDisplayed();
        pnlCustomization.click();
    }

    // Navigate to Site Animation
    public void clickSiteAnimationLink() {
        lnkSiteAnimation.state().waitForDisplayed();
        lnkSiteAnimation.click();
    }

    // Method to enable Page-Transition Animation if not already enabled
    public void enablePageTransitionAnimation() {
        chkEnablePageTransition.state().waitForDisplayed();
        if (!chkEnablePageTransition.getElement().isSelected()) {
            chkEnablePageTransition.click(); // Enable the toggle if not enabled
        }
    }
    // Method to select the "Roll" animation effect
    public void selectRollEffect() {
        optRollEffect.state().waitForDisplayed();
        optRollEffect.click();
    }

    // Method to save changes
    public void saveChanges() {
        btnSaveChanges.state().waitForClickable();
        btnSaveChanges.click();
    }
}
