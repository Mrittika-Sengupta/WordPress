package framework.pages;

import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.IElement;
import org.openqa.selenium.By;

public class FrontEndDarkMode extends Form {

    // Dark Mode Toggle element
    private final IElement darkModeToggle = getElementFactory().getButton(
            By.className("wp-dark-mode-switch-styled"),
            "Dark Mode Toggle");

    // BuyWithUs link element
    private final IElement siteLink = getElementFactory().getLink(
            By.linkText("BuyWithUs"),
            "BuyWithUs Link");

    public FrontEndDarkMode() {
        super(By.tagName("body"), "Front End Dark Mode Page");
    }

    // Method to click the BuyWithUs link to navigate to the front end
    public void clickSiteLink() {
        siteLink.state().waitForDisplayed(); // Wait for the link to be displayed
        siteLink.click(); // Click the BuyWithUs link
    }

    // Method to activate Dark Mode by clicking the toggle
    public void activateDarkMode() {
        darkModeToggle.state().waitForDisplayed(); // Wait for the toggle to be displayed
        // If Dark Mode is not active, click the toggle to activate it
        if (!isDarkModeActive()) {
            darkModeToggle.click(); // Click the toggle to activate Dark Mode
        }
    }

    // Method to check if Dark Mode is active by verifying the presence of 'active' class
    public boolean isDarkModeActive() {
        darkModeToggle.state().waitForDisplayed(); // Ensure the toggle is visible
        // Check if the toggle button contains the 'active' class, indicating Dark Mode is active
        return darkModeToggle.getAttribute("class").contains("active");
    }
}
