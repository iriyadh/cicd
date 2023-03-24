package POM;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EriBankWebElement {
    public static AndroidDriver driver;

    public EriBankWebElement(AndroidDriver driver){
        this.driver = driver;
    }

    public void inputField(String username,String password) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@text='Username']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@text='Username']")).sendKeys(username);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@text='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@text='Login']")).click();
    }

    //Second Feature "AppAutomation(MakePayment)"

    public void makePaymentButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
    }
    public void makePaymentFields(String Phone,String Name,String Amount) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Phone']")).sendKeys(Phone);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Name']")).sendKeys(Name);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Amount']")).sendKeys(Amount);

        driver.findElement(By.xpath("//*[@text='Select']")).click();
        TouchAction ta = new TouchAction(driver);
        ta.press(PointOption.point(492, 514)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3800))).moveTo(PointOption.point(578, -1035)).release().perform();

        driver.findElement(By.xpath("//*[@text='Bangladesh']")).click();
        driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
        driver.findElement(By.xpath("//*[@text='Mortgage Request']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Cancel']")));
        driver.findElement(By.xpath("//*[@text='Cancel']")).click();
        driver.findElement(By.xpath("//*[@text='Expense Report']")).click();
        driver.findElement(By.xpath("//*[@text='Back']")).click();
    }
    public void clickSelectButton() throws InterruptedException {
        WebElement testDropDown = driver.findElement(By.xpath("//*[@text='Select']"));
        testDropDown.click();
//        //WebElement testDropDown = driver.findElement(By.id("countryButton"));
//
//        Thread.sleep(3000);
//        Select dropdown = new Select(testDropDown);
//        dropdown.selectByIndex(1);
//
//        //dropdown.selectByVisibleText("USA");
        Actions actions = new Actions(driver);
        actions.moveToElement(testDropDown).perform();
        actions.click().perform();
        // send down arrow key as input
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.click().perform();
        Thread.sleep(2000);

    }
    public void clickSendPaymentButton(){
        driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
