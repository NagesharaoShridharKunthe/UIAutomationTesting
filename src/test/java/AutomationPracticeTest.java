import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
}