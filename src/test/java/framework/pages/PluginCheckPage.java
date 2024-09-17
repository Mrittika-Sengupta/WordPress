package framework.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PluginCheckPage extends Form {

    // Element for plugins menu
    private final IElement lnkPluginsMenu = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'wp-menu-name') and contains(text(), 'Plugins')]"), "Plugins Menu");

    // Element for installed plugins link
    private final ILink lnkInstalledPlugins = getElementFactory().getLink(By.xpath("//ul[contains(@class, 'wp-submenu')]//a[contains(text(), 'Installed Plugins')]"), "Installed Plugins Link");

    // Plugin installation status
    private final IElement pluginStatus = getElementFactory().getLabel(By.xpath("//tr[td[contains(text(), 'WP Dark Mode')]]"), "Plugin Status");

    // Constructor to initialize plugin check page
    public PluginCheckPage() {
        super(By.id("wpbody-content"), "Plugin Check Page");
    }

    // Method to navigate to the Plugins page
    public void navigateToPlugins() {
        // Click on main plugins menu item
        lnkPluginsMenu.click();

        // Wait for submenu to be visible
        IElement submenu = getElementFactory().getLabel(By.xpath("//ul[contains(@class, 'wp-submenu')]"), "Submenu");
        submenu.state().waitForDisplayed();

        // Click on installed plugins link
        lnkInstalledPlugins.click();
    }

    // Check if the WP Dark Mode Plugin is installed
    public boolean isPluginInstalled() {
        try {
            // Check if the pluginStatus element with 'WP Dark Mode' text is present and visible
            return pluginStatus.state().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
