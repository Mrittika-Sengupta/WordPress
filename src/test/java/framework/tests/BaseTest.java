package framework.tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Browser browser;
    protected Dotenv dotenv;

    @BeforeMethod
    public void setup() {
        dotenv = Dotenv.load();
        browser = AqualityServices.getBrowser();
        browser.maximize();

        String url = dotenv.get("WORDPRESS_URL");

        // Navigate to /wp-login.php page
        browser.goTo(url);

        // Log the URL
        System.out.println("Navigated to URL: " + url);
    }

    @AfterMethod
    public void teardown() {
        browser.quit();
    }
}
