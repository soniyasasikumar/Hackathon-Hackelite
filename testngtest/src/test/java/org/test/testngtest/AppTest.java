package org.test.testngtest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
	 static WebDriver driver;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
      
    }
    @BeforeMethod
    public static void beforeTestExe() throws InterruptedException
    {
      	 System.out.println("EdgeDriver execution on Windows!!");
          DesiredCapabilities capabilities = DesiredCapabilities.chrome();
         capabilities.setCapability(InternetExplorerDriver.
           INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\Soniya\\Documents\\WORK\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         System.out.println("Execution start on Windows");
         Thread.sleep(2000);
         driver.get("http://localhost:8080/login");
         Thread.sleep(2000);
    }
    /**
     * @throws InterruptedException 
     */
    @Test(priority=1)
    public static void testcase1() throws InterruptedException
    {

     WebDriverWait wait = new WebDriverWait(driver, 100);
     WebElement uname= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='name']")));
     uname = driver.findElement(By.xpath("//input[@name='name']"));
     uname.sendKeys("admin");
     Thread.sleep(1000);
     WebElement pwd= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
     pwd = driver.findElement(By.xpath("//input[@name='password']"));
     pwd.sendKeys("admin");
     Thread.sleep(1000);
     WebElement submit= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[3]")));
     submit = driver.findElement(By.xpath("//input[3]"));
     submit.click();
     
    }
    @Test(priority=2)
    public static void testcase2() throws InterruptedException
    {

        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement uname= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='name']")));
        uname = driver.findElement(By.xpath("//input[@name='name']"));
        uname.sendKeys("test");
        Thread.sleep(1000);
        WebElement pwd= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        pwd = driver.findElement(By.xpath("//input[@name='password']"));
        pwd.sendKeys("test");
        Thread.sleep(1000);
        WebElement submit= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[3]")));
        submit = driver.findElement(By.xpath("//input[3]"));
        submit.click();
       

       }
    
    @AfterMethod
    public static void afterTestExe() throws InterruptedException
    {
    	 driver.quit();
         System.out.println("Execution complete on Windows");
    }

}
