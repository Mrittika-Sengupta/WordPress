package framework.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage extends Form {

    // Username field
    private final ITextBox txtUsername = getElementFactory().getTextBox(By.id("user_login"), "Username");

    // Password field
    private final ITextBox txtPassword = getElementFactory().getTextBox(By.id("user_pass"), "Password");

    // Login button
    private final IButton btnLogin = getElementFactory().getButton(By.id("wp-submit"), "Login");

    // Constructor to initialize login form
    public LoginPage() {
        super(By.id("loginform"), "Login Page");
    }

    // Clear text using JavaScript
    private void clearTextBox(ITextBox textBox) {
        JavascriptExecutor js = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        js.executeScript("arguments[0].value = '';", textBox.getElement());
    }

    // Method to perform login
    public void login(String username, String password) {
        // Clear the username field and type the new username
        clearTextBox(txtUsername);
        txtUsername.type(username);

        // Clear the password field and type the new password
        clearTextBox(txtPassword);
        txtPassword.type(password);

        // Click the login button
        btnLogin.click();
    }
}
