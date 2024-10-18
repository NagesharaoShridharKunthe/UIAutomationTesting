# UIAutomationTesting

## Introduction:

This project automates various test cases on the website [Automation Practice](https://www.rahulshettyacademy.com/AutomationPractice/) using **Selenium WebDriver**. The tests are written in **Java** and use **JUnit** for assertions.

##Features##

The project covers UI automation, including dropdown selections, autocomplete suggestions, tab handling, and web table validation, ensuring the website's functionality is thoroughly tested. Assertions to verify expected outcomes without using print statements.

## Prerequisites:

- **Java 11+** installed
- **Maven** installed
- A suitable **IDE** (e.g., IntelliJ IDEA)
- **Google Chrome** and the **ChromeDriver** installed
- **Selenium WebDriver** and **JUnit** dependencies included in `pom.xml`

## Installation and Setup:

To set up and run the automated tests, follow these steps:

- **Clone the Repository**:
   Clone the GitHub repository to your local machine using the following command:
   ```bash
   git clone https://github.com/NagesharaoShridharKunthe/UIAutomationTesting.git
- **Navigate to the Repository**: ``` cd <path>```
- **Install Dependencies**: ```mvn clean install```
- **Configure WebDriver Update the path to your chromedriver in the test classes**:
```
 System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
```
## Running Tests:

Execute the tests with:```mvn test```

## Project Structure:

```
UIAutomationTesting/
│
├── .idea
│   ├── .gitignore
│   ├── encodings.xml
│   ├── misc.xml
│   └── vcs.xml
├── drivers
│   └── chromedriver
├── src/
│   └── test/
│       └── java/
│           └── UITests.java
├── .gitignore
└── pom.xml
```

## Writing Tests:

Tests in this project are written using JUnit and Selenium. Each test case is implemented as a method within the UITests.java file, with each method focusing on a specific UI interaction.

Each test typically includes the following components:

- Setup and Teardown: Methods annotated with @BeforeEach and @AfterEach to initialize and clean up the WebDriver instance.
- Assertions: Using JUnit assertions to verify expected outcomes.

## Example Test Case:

```java
@Test
    public void testDropdown() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropdown);
        select.selectByValue("option2");
        String selectedText = select.getFirstSelectedOption().getText();
        assertEquals(selectedText, "Option2", "Option2 is not selected in dropdown");
        Thread.sleep(2000);
    }
```

## Execution Result

Reports are generated in the console output when tests are executed. You can see a summary of passed and failed tests directly in your terminal.
