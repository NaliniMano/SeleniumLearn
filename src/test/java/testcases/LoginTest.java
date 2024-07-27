package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    @Test
    public void setUp()
    {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.orangehrm.com/en/book-a-free-demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
}
