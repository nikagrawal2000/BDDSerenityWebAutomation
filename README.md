# WebAutomation of Ecommerce with Serenity and Cucumber

This project uses Cucumber BDD with Serenity using Page Object Model for automated test cases run on Ecommerce website

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

This framework was created by Nikhil Agrawal. All the licenses solely belongs to Nikhil Agrawal


### The project directory structure
The project has build scripts for Maven, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                        Test runners and supporting code
    + resources
      + features                  Feature files
             Ecommerce.feature
      + serenity.conf             url, webdriver, report location and chromeoptions
```
![image](https://github.com/nikagrawal2000/BDDSerenityWebAutomation/assets/3139455/2a286333-5620-494f-8042-a6bfca61be61)

Serenity is integrated with WebdriverManager to download webdriver binaries.

## The Ecommerce test scenario(3 testcases)
TC1:@RegisteredAccessCheckoutPage - Login with valid credentials and access checkout page
In this scenario, 

- User logs in with(pre-created) credentials

- searches for product and adds to cart

- verifies the product has added
- is able access checkout page
                   
 TC2:@NonRegisteredUserAccessCheckoutPage - Guest user(not signed into application) should not be able to access checkout page[Negative Scenario]
 In this scenario
 
- User searches for product and adds to cart
 
- verify the product has added
 
- and tries to access checkout page but test case fails
 
 TC3:@InValidCredentials - User with invalid login or password tries to Sign in
 In this scenario, 
 - invalid user id and password should not be able to login



## Executing the tests
To run the sample project, you can either just run the `SerenityRunnerTest` test runner class, or run `mvn verify`below command from the command line.
```json
$ mvn clean verify
```

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```

To run only specific testcase(or rather tags), use below e.g.
```json
$ mvn clean verify -Dtags="NonRegisteredUserAccessCheckoutPage"
```

## Generating the reports
The test results will be recorded in the `report/index.html` directory. End of test result will give below output for easy copy link of report
```
[INFO] SERENITY REPORTS
[INFO]   - Full Report: file:///C:/Users/nik_a/eclipse-workspace/WebAutomationBDDSerenity/report/index.html
[INFO]   - Single Page HTML Summary: file:///C:/Users/nik_a/eclipse-workspace/WebAutomationBDDSerenity/report/serenity-summary.html
```

## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  
### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
```java
webdriver {
    driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

Serenity uses WebDriverManager to download the WebDriver binaries automatically before the tests are executed.

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _staging_ and _prod_, with different starting URLs for each:
```json
environments {
  default {
    webdriver.base.url = "https://duckduckgo.com"
  }
  dev {
    webdriver.base.url = "https://duckduckgo.com/dev"
  }
  staging {
    webdriver.base.url = "https://duckduckgo.com/staging"
  }
  prod {
    webdriver.base.url = "https://duckduckgo.com/prod"
  }
}
```

You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=staging
```

See [**this article**](https://johnfergusonsmart.com/environment-specific-configuration-in-serenity-bdd/) for more details about this feature.
