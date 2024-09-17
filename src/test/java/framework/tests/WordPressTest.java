package framework.tests;

import aquality.selenium.browser.AqualityServices;
import framework.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WordPressTest extends BaseTest {

    @Test
    public void testPluginInstallationAndActivation() {

        // Step 1: Log in to your WordPress site
        LoginPage loginPage = new LoginPage();
        PluginCheckPage pluginCheckPage = new PluginCheckPage();
        InstallPluginActivatePage installPluginActivatePage = new InstallPluginActivatePage();
        WPDarkModeSettingsPage wpDarkModeSettingsPage = new WPDarkModeSettingsPage();
        CustomizationSwitchSettings customizationSwitchSettings = new CustomizationSwitchSettings();
        CustomizationAccessibilitySettings customizationAccessibilitySettings = new CustomizationAccessibilitySettings();
        SiteAnimationCustomization siteAnimationCustomization = new SiteAnimationCustomization();
        FrontEndDarkMode frontEndDarkMode = new FrontEndDarkMode();

        String username = dotenv.get("WORDPRESS_USERNAME");
        String password = dotenv.get("WORDPRESS_PASSWORD");

        loginPage.login(username, password);

        // Step 2: Check whether the “WP Dark Mode” Plugin is Active or not
        pluginCheckPage.navigateToPlugins();
        boolean isInstalled = pluginCheckPage.isPluginInstalled();

        if (isInstalled) {
            System.out.println("WP Dark Mode Plugin is already installed.");
        } else {
            // Step 3: If not Active, Install the Plugin and Activate it
            installPluginActivatePage.navigateToAddNewPlugin();
            installPluginActivatePage.installPlugin();
            installPluginActivatePage.navigateToInstalledPlugins();
            installPluginActivatePage.activatePlugin();

            boolean isActive = installPluginActivatePage.isPluginActive();
            Assert.assertTrue(isActive, "WP Dark Mode should be activated");

            System.out.println("WP Dark Mode Plugin was successfully installed and activated.");
        }

        // Step 4: Enable Admin Dashboard Dark Mode from Controls → Admin Panel Dark Mode
        wpDarkModeSettingsPage.navigateToWPDarkModeMenu();
        wpDarkModeSettingsPage.clickAdminPanelDarkMode();
        wpDarkModeSettingsPage.enableAdminDashboardDarkMode();
        wpDarkModeSettingsPage.saveChanges();

        // Step 5: Validate whether the dark mode is working or not on the Admin Dashboard
        wpDarkModeSettingsPage.activateDarkModeFromToolbar();
        wpDarkModeSettingsPage.navigateToDashboard();

        // Step 6: Navigate to WP Dark Mode Customization
        wpDarkModeSettingsPage.WPDarkModeMenu();

        // Step 7: From Customization → Switch Settings → Change the “Floating Switch Style”
        customizationSwitchSettings.clickCustomizationPanel();
        customizationSwitchSettings.clickSwitchSettingsLink();
        customizationSwitchSettings.clickFloatingSwitchStyle();
        customizationSwitchSettings.saveChanges();

        // Step 8: From Customization → Switch Settings → Switch Customization - Set Switch Size to 220

        customizationSwitchSettings.clickCustomOption();
        customizationSwitchSettings.setSliderScale(220); // Set the slider to 220 (68%)
        customizationSwitchSettings.saveChanges();

        // Step 9: From Customization → Switch Settings → Change Floating Switch Position (Left)
        customizationSwitchSettings.clickFloatingSwitchLeft(); // Set Floating Switch Position to Left
        customizationSwitchSettings.saveChanges();

        // Step 10: Disable the Keyboard Shortcut from Accessibility Settings
        customizationAccessibilitySettings.Advanced();
        customizationAccessibilitySettings.clickAccessibilitySettingsLink();
        customizationAccessibilitySettings.KeyboardShortcut();
        customizationAccessibilitySettings.Changes();

        // Step 11: From Customization → Site Animation → Enable Page Transition Animation
        siteAnimationCustomization.clickCustomizationPanel();
        siteAnimationCustomization.clickSiteAnimationLink();
        siteAnimationCustomization.enablePageTransitionAnimation();

        // Step 12: Change the Animation Effect from the default selections
        siteAnimationCustomization.selectRollEffect();
        siteAnimationCustomization.saveChanges();

        // Step 13: Validate whether the dark mode is working or not from the front end
        frontEndDarkMode.clickSiteLink();

        // Step 2: Activate Dark Mode
        frontEndDarkMode.activateDarkMode();

        // Step 3: Verify that Dark Mode is active
        boolean isDarkModeActive = frontEndDarkMode.isDarkModeActive();
        Assert.assertTrue(isDarkModeActive, "Dark Mode should be active.");
    }
}
