package org.example;

import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import javax.xml.xpath.XPath;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Validate_a_Valida_User_Login()
    {
        System.setProperty("webdriver.chrome.driver","/Users/chathurajayasinghe/Documents/Data/QA/chromedriver 4");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/");
        String Email = "cjay3@mailinator.com";
        String UserName= "Chathura";

        driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[2]/div/div/a[2]"));

        driver.findElement(By.xpath("//*[@class=\"theme-btn theme-btn-small waves-effect\"]")).click();

        driver.findElement(By.name("first_name")).sendKeys(UserName);
        driver.findElement(By.name("last_name")).sendKeys("Jayasinghe");
        driver.findElement(By.name("phone")).sendKeys("12321231");
        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("password")).sendKeys("Email");
        driver.findElement(By.xpath("//*[@class=\"btn btn-default btn-lg btn-block effect ladda-button waves-effect\"]")).click();

        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("password")).sendKeys("Email");
        driver.findElement(By.xpath("(//*[@class=\"ladda-label\"])[1]")).click();


        String name = driver.findElement(By.className("author__title")).getText();
        System.out.println(name);

        Assert.assertEquals(name,UserName);

    }

    @Test
    public void Validate_a_Valida_User_Login_Mobile() throws MalformedURLException, InterruptedException {

        WebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro Max");
        capabilities.setCapability(MobileCapabilityType.UDID, "78DCD3C1-FCAA-446E-AAE6-6E3EBBAE1C6F");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.phptravels.net/");
        String Email = "cjay"+Math.random()+".@mailinator.com";
        System.out.println(Email);
        String UserName= "Chathura";

        Thread.sleep(7000);
        WebElement downArrow = driver.findElement(By.xpath("//*[@class=\"down-button waves-effect\"]/i"));
        downArrow.click();

        driver.findElement(By.xpath("//*[@class=\"theme-btn theme-btn-small waves-effect\"]")).click();

        driver.findElement(By.name("first_name")).sendKeys(UserName);
        driver.findElement(By.name("last_name")).sendKeys("Jayasinghe");
        driver.findElement(By.name("phone")).sendKeys("12321231");
        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("password")).sendKeys("Email");
        driver.findElement(By.xpath("//*[@class=\"btn btn-default btn-lg btn-block effect ladda-button waves-effect\"]")).click();


        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class=\"alert alert-success signup\"]")));

        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("password")).sendKeys("Email");
        driver.findElement(By.xpath("(//*[@class=\"ladda-label\"])[1]")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//*[@class=\"ladda-label\"])[1]")));

        String name = driver.findElement(By.className("section-heading")).getText();
        System.out.println(name);
        //UserName.
        System.out.println(UserName);

        Assert.assertTrue(name.contains(UserName));
    }



}




//Open https://www.phptravels.net/
//click log
//Enter user name passsword
//Navigate to user details
//Validate the email address whterh it is the same email adress we enter at the user login screen