package calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calc {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        //TestObject
        /*
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("deviceName","Samsung_Galaxy_S9_free");
        desiredCapabilities.setCapability("testobject_api_key","248946C208FD40F2BE015DA6212FD9AA");

       URL remoteUrl = new URL("https://us1.appium.testobject.com/wd/hub");

        */

        //Local
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10.0");
        desiredCapabilities.setCapability("automationName", "UIAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");


        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void soma_dois_numeros() {
        MobileElement botao2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        botao2.click();
        MobileElement botaoSomar = (MobileElement) driver.findElementByAccessibilityId("plus");
        botaoSomar.click();
        MobileElement botao3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        botao3.click();
        MobileElement botaoIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        botaoIgual.click();
        MobileElement display = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        Assert.assertEquals("5", display.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}