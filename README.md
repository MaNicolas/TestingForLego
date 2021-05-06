# TestingForLego
Automation testing for Lego.com using Selenium and Java

Hi,

Here's a test I created using Selenium webdriver and Java. I am using a Maven project structure with TestNG plugin to run my tests. The design pattern is Page Object Model.

I will be testing the website “Lego.com/es-es”.

In order to run the test, you'll need the following setup:
- Java version 1.8.0
- jdk-11.0.6
- Chrome browser version 90
- Firefox browser version 87.0 (64-bit)
- Eclipse IDE
You will find 1 test suite XML files under "src\test\resources\TestSuites":

AllTests.xml (which basically run my test on Chrome and Firefox in parallel)

To run the tests:

- Right click on this file
- "Run as"
- TestNG Suite

You can find a report under "testing-for-lego\test-output\emailable-report.html"

That's it! Thanks for reading me :) Nicolas
