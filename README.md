# WordPress WP Dark Mode Automation Test Suite

This repository contains an automation test suite to validate the functionality of the "WP Dark Mode" plugin on a WordPress site. The suite includes test scenarios for installing the plugin, configuring settings, and verifying the dark mode on the admin dashboard and front end.

## Prerequisites

Before running the test suite, ensure that the following tools and dependencies are installed:

- **Java Development Kit (JDK)**: Version 8 or above
- **IntelliJ IDEA** (or any preferred Java IDE)
- **Maven** (for managing dependencies)
- **Aquality Framework** (To know more about Aquality Framework, check the link [Aquality Framework](https://github.com/aquality-automation))
- **Selenium WebDriver** (included as a Maven dependency)
- **ChromeDriver** (or any other driver if using a different browser)
- **Git**
- **WordPress Login Credentials** (stored in `.env` file)

## Steps to Install Prerequisites

- **Java Development Kit (JDK)**: Download and install JDK from Oracle or your preferred source.
- **IntelliJ IDEA**: Download and install IntelliJ IDEA from JetBrains.
- **Maven**: Ensure Maven is installed by running `mvn -version` in the command line. If not installed, you can download it from Apache Maven.
- **ChromeDriver**: Download the ChromeDriver compatible with your Chrome browser version from ChromeDriver Downloads. Add it to your system PATH.

## Getting Started

### Clone the Repository

```bash
git clone <repository-url>
cd WordPress
Set Up Environment Variables
Create a .env file in the root directory to store your WordPress credentials:


env
Copy code
WORDPRESS_URL=http://your-wordpress-site.com
WORDPRESS_USERNAME=your-username
WORDPRESS_PASSWORD=your-password
Install Project Dependencies
This project uses Maven for dependency management. Install the required dependencies by running:


Copy code
mvn install
```
## Project Structure

- `src/test/java/pages`: Contains page object models (POM) for different WordPress pages (e.g., Login Page, WP Dark Mode Page).
- `src/test/java/tests`: Contains the test cases for each of the scenarios.
- `.env`: Stores environment variables for WordPress URL and credentials.
- `pom.xml`: Maven configuration file with dependencies.

## Test Scenarios

1. **Login to WordPress**
   - Navigate to the WordPress login page.
   - Enter valid credentials and log in.

2. **Check if the WP Dark Mode Plugin is Active**
   - Check the list of installed plugins to verify if "WP Dark Mode" is active.

3. **Install and Activate WP Dark Mode Plugin (if not already active)**
   - If the plugin is not active, install it from the plugin repository.
   - Activate the plugin.

4. **Enable Admin Dashboard Dark Mode**
   - Navigate to WP Dark Mode settings.
   - Enable dark mode for the admin dashboard from Controls → Admin Panel Dark Mode.

5. **Verify Dark Mode in Admin Dashboard**
   - Validate that the dark mode is applied on the admin dashboard.

6. **Customize Floating Switch Style**
   - Navigate to WP Dark Mode settings.
   - From Customization → Switch Settings, change the “Floating Switch Style” from the default selections (select any option except the default).

7. **Change Floating Switch Size and Position**
   - From Customization → Switch Settings → Switch Customization, select a custom switch size and scale it to 220.
   - Change the Floating Switch Position to Left.

8. **Disable Keyboard Shortcuts**
   - Navigate to Accessibility Settings.
   - Disable keyboard shortcuts.

9. **Enable Page Transition Animation**
   - From Customization → Site Animation, enable "Page-Transition Animation".
   - Change the Animation Effect from the default selections.

10. **Validate Front-End Dark Mode**
    - Navigate to the front end of the WordPress site.
    - Verify that dark mode is applied.

## How to Run the Test Suite

Open the project in IntelliJ IDEA.
Ensure your WordPress credentials are set up in the .env file.
Confirm that ChromeDriver is installed and added to your system's PATH.

Run the test suite using Maven:

```bash
mvn test
```

## Running Specific Tests

To run a specific test class, use the following command:

```bash

mvn -Dtest=LoginTest test
```

## Configurations

### Browser Configuration

The default browser for tests is Chrome. To change the browser, modify the src/test/resources/config.json file:
```bash

{
  "browser": "chrome"
}
```

