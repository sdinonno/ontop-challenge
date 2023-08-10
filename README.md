# ontop-challenge
UI Automation Framework to resolve the challenge of Ontop using Selenium WebDriver and Java.

## Disclaimer
Amazon has a good anti-bot detection mechanism and the WebDriver is considered as one of them. If you run the test, and it fails so most probably your IP was blocked or Amazon is not displaying all the elements of the DOM for anti-bot policy.
Since that, it was difficult to debug and test my own work.

Screen when Amazon does not display all the elements. That's to avoid WebScraping. The test won't work.
![amazon-less-elements.png](md-files%2Famazon-less-elements.png)

When Amazon detects a bot or has blocked your IP before, sometimes require you enter a code to be sure you are not a robot.
The test only will work if you enter manually the code to continue with the execution. To do that, you need to deactivate headless mode.
![amazon-require-code.png](md-files%2Famazon-require-code.png)

If Amazon does not detect the WebDriver as a bot, you should see the following page and the test should work.
![amazon-ok.png](md-files%2Famazon-ok.png)

## Tech stack
* Java 8 or higher (https://www.oracle.com/java/technologies/downloads)
* Maven 3.8.3 or higher (https://maven.apache.org/download.cgi)
* Selenium
* TestNG

## How to run the tests?

### From command line
````shell
1. cd ../ontop-challenge
2. mvn -D clean test
````

Also, you can add some tags using:
````shell
1. cd ../ontop-challenge
2. mvn -D clean test -Dcucumber.filter.tags="@regression"
````

### From runner
Find the **TestRunner** (src/test/java/runner/RunCucumberTest.java), write the tags you want to execute and run it!

### From a test
Find  a test in the folder **src/test/java/features** and execute it!

## Project structure
````shell
src
   |-- main
   |   |-- java
   |   |   |-- context
   |   |   |   |-- Context.java
   |   |   |   |-- ScenarioContext.java
   |   |   |   |-- TestContext.java
   |   |   |-- managers
   |   |   |   |-- DriverManager.java
   |   |   |   |-- PageObjectManager.java
   |   |   |-- models
   |   |   |   |-- Product.java
   |   |   |-- pages
   |   |   |   |-- BasePage.java
   |   |   |   |-- HomePage.java
   |   |   |   |-- ProductPage.java
   |   |   |   |-- SearchResultsPage.java
   |   |   |-- utils
   |   |   |   |-- Screenshots.java
   |-- test
   |   |-- java
   |   |   |-- runner
   |   |   |   |-- RunCucumberTest.java
   |   |   |-- steps
   |   |   |   |-- CommonStepdefs.java
   |   |   |   |-- HomeStepdefs.java
   |   |   |   |-- Hooks.java
   |   |   |   |-- ProductStepdefs.java
   |   |   |   |-- SearchResultsStepdefs.java
   |   |-- resources
   |   |   |-- features
   |   |   |   |-- SearchProduct.feature
````

## Solution
I have applied Page Object Model pattern in order to enhance test maintainability, improve code readability, and promote reusability in my test automation framework.

Additionally, I have employed Dependency Injection in my Cucumber-based test framework to efficiently share contextual information, such as test data and state, between different steps within the same scenario. This approach enables me to maintain a clear separation of concerns and improve the overall organization of my test code.

Last but not least, I have added a GitHub Action workflow to run the tests when a new PR is 

## Next steps (improvements)
* Adapt WebDriver options to be able to run the test in a mobile view.
* Add support for another browsers: Firefox, Safari, Edge, etc.
* Attach the product screenshot in the report.
* Delete report and screenshots folders and ignore them in .gitignore. It is not a good practice track them. I just save them to show you and met the requirements.
* Improve some locators in order to reuse them for all the products. This is difficult because Amazon has different type of elements with different descriptions.
* Improve GitHub Action workflow.

## Contributing
If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement". Thanks!
````text
1. Fork the Project
2. Create your Feature Branch (git checkout -b feature/AmazingFeature)
3. Commit your Changes (git commit -m 'Add some AmazingFeature')
4. Push to the Branch (git push origin feature/AmazingFeature)
5. Open a Pull Request