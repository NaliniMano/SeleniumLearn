package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private static volatile WebDriverManager driverManager;
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    private WebDriverManager() {
    }

    private void initDriver(String browser) {
        switch (browser) {
            case "chrome":
                threadLocal.set(new ChromeDriver());
                break;
            case "firefox":
                threadLocal.set(new FirefoxDriver());
                break;
            case "edge":
                threadLocal.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("UnSupported " + browser);

        }

    }
    public static WebDriverManager getInstance(String browser)
    {
        if(driverManager == null)
        {
          synchronized (WebDriverManager.class){
              if(driverManager == null)
              {
                  driverManager = new WebDriverManager();
              }
          }
        }
        if(threadLocal.get() == null)
        {
            driverManager.initDriver(browser);
        }
        return driverManager;
    }

    public  WebDriver getDriver()
    {
        return  threadLocal.get();
    }

    public static  void quitBrowser()
    {
        if(threadLocal!=null)
        {
            threadLocal.get().quit();
            threadLocal.remove();
        }
    }
}



