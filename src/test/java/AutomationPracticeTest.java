import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
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
    @Test
    public void switchTab() throws InterruptedException {
        driver.findElement(By.id("opentab")).click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String expectedTitle = "QAClick Academy - A Testing Academy to Learn, Earn and Shine";
        assertTrue(driver.getTitle().contains(expectedTitle));

        assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());
        assertTrue(driver.findElement(By.linkText("Courses")).isDisplayed());
        assertTrue(driver.findElement(By.linkText("Access all our Courses")).isDisplayed());
        assertTrue(driver.findElement(By.linkText("Learn More")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//div[@class='apply-cont apply-color-2']/a")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='Contact']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='Blog']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='About us']")).isDisplayed());
        Thread.sleep(2000);
    }
    @Test
    public void testAlerts() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Nagesharao");
        Thread.sleep(2000);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.id("name")).sendKeys("Nagesharao");
        Thread.sleep(2000);
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();
        Thread.sleep(2000);
    }
    @Test
    public void testWebTable() throws InterruptedException {
        List<WebElement> courses = driver.findElements(By.cssSelector("table#product tbody tr"));
        for (WebElement course : courses) {
            if (course.getText().contains("Master Selenium Automation in simple Python Language")) {
                String price = course.findElement(By.xpath("./td[3]")).getText();
                assertEquals("35", price, "Course price is not 35");
            }
        }
        Thread.sleep(2000);
    }
    @Test
    public void testTotalAmount() {
        // Locate the amounts in the fixed header table (4th column)
        List<WebElement> amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//td[4]"));

        // Calculate the total sum of all the amounts
        int total = amounts.stream().mapToInt(e -> Integer.parseInt(e.getText().trim())).sum();
        String displayedTotalText = driver.findElement(By.xpath("//div[contains(text(),'Total Amount Collected:')]")).getText();
        int displayedTotal = Integer.parseInt(displayedTotalText.split(":")[1].trim());
        assertEquals(total, displayedTotal, "Total amount does not match");
    }
}