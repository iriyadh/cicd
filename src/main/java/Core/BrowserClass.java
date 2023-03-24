package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class BrowserClass {
    public static WebDriver driver;

/*    public WebDriver firefox(String URL) {

        // disable firefox notification - false:enabled - true:disabled
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(new FirefoxProfile());
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("geo.enabled", true);
        options.addPreference("geo.prompt.testing", true);
        options.addPreference("geo.prompt.testing.allow", true);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();
        return driver;

    }*/

    public void browser(String s) {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();
        //0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("URL");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
    }

    public void addCus(String fname, String lname, String postcode) throws InterruptedException {

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fname);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lname);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(postcode);
        Thread.sleep(1000);
    }

    public void clickButt() throws InterruptedException {

        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        Thread.sleep(1000);
    }

    public void alertt() throws InterruptedException {

        //WebDriverWait wait = new WebDriverWait(driver, 20);
        String al = driver.switchTo().alert().getText().toString();
        System.out.println("This is Alert Message >>>>> " + al);
        String msg = "Customer added successfully with customer id :6";

        // assertEquals(al,msg);

        try {
            Assert.assertEquals(al, msg);
        } catch (AssertionError e) {
            System.out.println("Not equal");
            throw e;
        }
        System.out.println("Equal");

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(10000);

        }

    public void selectCustCurr(String customer, String currency) throws InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='userSelect']")).click();
        Thread.sleep(2000);

        //Select dropCustomer = new Select(driver.findElement(By.name("userSelect")));  // //Selecting Items in a Multiple SELECT elements
        //dropCustomer.selectByVisibleText();

        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@id='userSelect']")); //get all the options from the dropdown
        System.out.println("last option is" + allOptions.get(allOptions.size() - 1).getText()); //print last option

        Select dropCurrency = new Select(driver.findElement(By.name("currency")));

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).click();
    }
}
