package framework.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.time.Duration;

public class InstallPluginActivatePage extends Form {

    // Plugins menu
    private final ILink lnkPluginsMenu = getElementFactory().getLink(
            By.xpath("//div[contains(@class, 'wp-menu-name') and contains(text(), 'Plugins')]"),
            "Plugins Menu");

    // Add New Plugin
    private final ILink lnkAddNewPlugin = getElementFactory().getLink(
            By.xpath("//a[contains(text(), 'Add New')]"), "Add New Plugin Link");

    // Search box
    private final ITextBox txtSearch = getElementFactory().getTextBox(
            By.id("search-plugins"), "Search Box");

    // Install button for the plugin
    private final IButton btnInstall = getElementFactory().getButton(
            By.xpath("//a[contains(@class, 'install-now') and contains(@aria-label, 'Install WP Dark Mode')]"),
            "Install Now Button");

    // Link for Installed Plugins menu
    private final ILink lnkInstalledPlugins = getElementFactory().getLink(
            By.xpath("//ul[contains(@class, 'wp-submenu')]//a[contains(text(), 'Installed Plugins')]"),
            "Installed Plugins Link");

    // Link for Activate button
    private final IButton btnActivate = getElementFactory().getButton(
            By.xpath("//a[@id='activate-wp-dark-mode' and contains(@aria-label, 'Activate WP Dark Mode')]"),
            "Activate WP Dark Mode Link");

    // WP Dark Mode menu name
    private final ITextBox txtWP_DarkModeMenu = getElementFactory().getTextBox(
            By.xpath("//div[contains(@class, 'wp-menu-name') and contains(text(), 'WP Dark Mode')]"),
            "WP Dark Mode Menu");

    public InstallPluginActivatePage() {
        super(By.id("wpbody-content"), "Install and Activate Plugin Page");
    }

    // Method to navigate to Plugins menu
    public void navigateToPlugins() {
        lnkPluginsMenu.click();
    }

    // Method to navigate to Add New Plugin
    public void navigateToAddNewPlugin() {
        navigateToPlugins();
        lnkAddNewPlugin.click();
    }
    // Method to navigate to Installed Plugins
    public void navigateToInstalledPlugins() {
        navigateToPlugins();
        lnkInstalledPlugins.click();
    }

    // Search for the plugin by name
    public void searchForPlugin(String pluginName) {
        txtSearch.clearAndType(pluginName);

    }
    // Install the WP Dark Mode plugin
    public void installPlugin() {
        searchForPlugin("WP Dark Mode");
        btnInstall.click(); // Click on 'Install Now'
        try {
            Thread.sleep(8000); // 15,000 milliseconds = 15 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            throw new RuntimeException("Thread was interrupted while waiting after install", e);
        }

    }
    // Activate the WP Dark Mode plugin
    public void activatePlugin() {
        // Wait for the 'Activate' link to be present, then click
        if (btnActivate.state().waitForDisplayed()) {
            btnActivate.click();
        } else {
            throw new RuntimeException("Activate link for WP Dark Mode was not found.");
        }
    }

    // Check if the plugin is active by verifying the WP Dark Mode menu is displayed
    public boolean isPluginActive() {
        return txtWP_DarkModeMenu.state().waitForDisplayed();
    }
}
