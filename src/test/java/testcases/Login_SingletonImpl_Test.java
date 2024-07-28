package testcases;

import com.beust.jcommander.Parameter;
import driver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Login_SingletonImpl_Test {

    private WebDriver driver;
    @BeforeClass
    @Parameters("browser")
    public void setup(String browser){
        driver= WebDriverManager.getInstance(browser).getDriver();

    }

    @Test
    public void login(){

        driver.get("https://www.orangehrm.com/en/book-a-free-demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        System.out.println("Current Thread "+Thread.currentThread().getName());
    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.quitBrowser();
    }
}
