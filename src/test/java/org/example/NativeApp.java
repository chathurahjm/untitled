package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NativeApp {



    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", "/Users/chathurajayasinghe/Library/Developer/Xcode/DerivedData/Calculator-fcbxdwkdxuhovvfhtehmrybyeeek/Build/Products/Debug-iphonesimulator/Calculator.app");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("automationName", "XCUITest");
        desiredCapabilities.setCapability("platformVersion", "14.4");
        desiredCapabilities.setCapability("deviceName", "iPhone 12 Pro Max");

        URL remoteUrl = new URL("http://localhost:4724/wd/hub");

        driver = new IOSDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"2\"]");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"+\"]");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"3\"]");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"=\"]");
        el4.click();


        MobileElement el5 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Calculator\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
        el5.click();

        String output= el5.getText();
        System.out.println(output);
       // int number = Integer.parseInt(output);

        Assert.assertEquals(output,"5");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
