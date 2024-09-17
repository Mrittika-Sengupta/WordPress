package framework.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import framework.LocatorConstants;
import org.openqa.selenium.By;

public class WPDarkModeSettingsPage extends Form {

    // WP Dark Mode menu
    private final ILink lnkWPDarkModeMenu = getElementFactory().getLink(
            By.xpath("//div[contains(@class, 'wp-menu-name') and contains(text(), 'WP Dark Mode')]"),
            "WP Dark Mode Menu");

    // Admin Panel Dark Mode
    private final ILink lnkAdminPanelDarkMode = getElementFactory().getLink(
            By.xpath("//a[@href='#/admin' and contains(text(), 'Admin Panel Dark Mode')]"),
            "Admin Panel Dark Mode Link");

    // Save Changes button
    private final IButton btnSaveChanges = getElementFactory().getButton(By.className("border-blue-500"), "Save Button");


    // Enable Admin Dashboard Dark Mode toggle button's span
    private final IButton btnEnableDashboardDarkMode = getElementFactory().getButton(
            By.xpath("//div[contains(@class, 'relative w-10')]/span"),
            "Enable Admin Dashboard Dark Mode Toggle");

    // Dark Mode Toggle Switch in the Admin Toolbar
    private final IButton btnDarkModeToggle = getElementFactory().getButton(
            By.xpath("//li[@id='wp-admin-bar-wp-dark-mode-admin-bar-switch']//div[contains(@class, 'switch')]"),
            "Dark Mode Toggle Switch");

    private final ILink lnkDashboardMenu = getElementFactory().getLink(
            By.xpath("//li[@id='menu-dashboard']/a"),
            "Dashboard Menu Link");


    public WPDarkModeSettingsPage() {
        super(By.id("wpbody-content"), "WP Dark Mode Settings Page");
    }


    // Navigate to WP Dark Mode menu
    public void navigateToWPDarkModeMenu() {
        lnkWPDarkModeMenu.click();
    }

    // Click Admin Panel Dark Mode link
    public void clickAdminPanelDarkMode() {
        lnkAdminPanelDarkMode.click();
    }

    // Enable Admin Dashboard Dark Mode
    public void enableAdminDashboardDarkMode() {
        btnEnableDashboardDarkMode.click();
    }

    // Save changes
    public void saveChanges() {
        btnSaveChanges.state().waitForClickable(); // Wait until the button is displayed
        btnSaveChanges.click();
    }

    // Activate dark mode from the toolbar
    public void activateDarkModeFromToolbar() {
        btnDarkModeToggle.state().waitForDisplayed(); // Wait until the toggle is displayed
        btnDarkModeToggle.click();
    }

    // Navigate to the Dashboard
    public void navigateToDashboard() {
        lnkDashboardMenu.click();
    }

    public void WPDarkModeMenu() {
        lnkWPDarkModeMenu.click();
    }

}