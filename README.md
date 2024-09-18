# WordPress WP Dark Mode Automation Test Suite

This repository contains an automation test suite to validate the functionality of the "WP Dark Mode" plugin on a WordPress site. The suite includes test scenarios for installing the plugin, configuring settings, and verifying the dark mode on the admin dashboard and front end.

Prerequisites
Before running the test suite, ensure that the following tools and dependencies are installed:

Java Development Kit (JDK): Version 8 or above
IntelliJ IDEA (or any preferred Java IDE)
Maven (for managing dependencies)
Aquality Framework (To know more about Aquality Framework, check the link 'https://github.com/aquality-automation'
Selenium WebDriver (included as a Maven dependency)
ChromeDriver (or any other driver if using a different browser)
Git
WordPress Login Credentials (stored in .env file)

Steps to Install Prerequisites
Java Development Kit (JDK): Download and install JDK from Oracle or your preferred source.

IntelliJ IDEA: Download and install IntelliJ IDEA from JetBrains.

Maven: Ensure Maven is installed by running mvn -version in the command line. If not installed, you can download it from Apache Maven.

ChromeDriver: Download the ChromeDriver compatible with your Chrome browser version from ChromeDriver Downloads. Add it to your system PATH.

Getting Started
Clone the Repository
bash
Copy code
git clone https://github.com/yourusername/wordpress-darkmode-automation.git
cd wordpress
Environment Variables
Create a .env file in the root directory to store your WordPress credentials:

makefile
Copy code
WORDPRESS_URL=http://your-wordpress-site.com
WORDPRESS_USERNAME=your-username
WORDPRESS_PASSWORD=your-password
Install Dependencies
This project uses Maven to manage dependencies. All required dependencies are listed in the pom.xml file. 

To install them, run the following command in the project directory:

bash
Copy code
mvn clean install

Project Structure
src/test/java/pages: Contains page object models (POM) for different WordPress pages (Login Page, WP Dark Mode Page, etc.).
src/test/java/tests: Contains the test cases for each of the scenarios.
.env: Stores environment variables for WordPress URL and credentials.
pom.xml: Maven configuration file with dependencies.

Tests Included
Login to WordPress
Check if the WP Dark Mode Plugin is Active
Install and Activate WP Dark Mode Plugin (if not already active)
Enable Admin Dashboard Dark Mode
Verify Dark Mode in Admin Dashboard
Customize Floating Switch Style
Change Floating Switch Size and Position
Disable Keyboard Shortcuts
Enable Page Transition Animation
Validate Front-End Dark Mode
How to Run the Test Suite
Open the project in IntelliJ IDEA.

Set up your WordPress credentials in the .env file.

Ensure the ChromeDriver is installed and added to your system's PATH.

Run the test suite using Maven.
In the terminal, navigate to the project directory and execute:

bash
Copy code
mvn test
Running Tests Individually
To run a specific test, you can specify the test class in the command:

bash
Copy code
mvn -Dtest=LoginTest test
Reports
After the test execution, reports are generated automatically. You can find them in the target/surefire-reports directory.

Configurations
Browser Configurations

The default browser for the tests is Chrome. You can change the browser by modifying the src/test/resources/config.json file.

json
Copy code
{
  "browser": "chrome"
}
You can set this to firefox or other browsers if necessary.
