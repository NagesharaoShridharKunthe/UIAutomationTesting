import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutomationPracticeTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testRadioButton() throws InterruptedException {
        driver.findElement(By.cssSelector("input[value='radio3']")).click();
        boolean isSelected = driver.findElement(By.cssSelector("input[value='radio3']")).isSelected();
        assertTrue(isSelected, "Radio3 is not selected");
        Thread.sleep(2000);
    }
    @Test
    public void testSuggestionClass() throws InterruptedException {
        driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.ui-menu-item div")));

        List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item div"));
        for (WebElement option : options) {
            if (option.getText().equals("India")) {
                option.click();
                break;
            }
        }
        String selectedValue = driver.findElement(By.id("autocomplete")).getAttribute("value");
        assertEquals(selectedValue, "India", "India is not selected");
        Thread.sleep(2000);
    }
    @Test
    public void testDropdown() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropdown);
        select.selectByValue("option2");
        String selectedText = select.getFirstSelectedOption().getText();
        assertEquals(selectedText, "Option2", "Option2 is not selected in dropdown");
        Thread.sleep(2000);
    }
    @Test
    public void testCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        checkbox.click();
        assertTrue(checkbox.isSelected(), "Checkbox Option1 is not selected");
        Thread.sleep(2000);
    }
}