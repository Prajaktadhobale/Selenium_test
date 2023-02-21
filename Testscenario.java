package TestCase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Parameters;


public class Testscenario {
	WebDriver driver;
	//private String URL = "https://www.lambdatest.com/selenium-playground";
	
	@Parameters({"browser","url"})
	@BeforeTest
	
	public void setup(String browser,@Optional("https://www.lambdatest.com/selenium-playground")String browserurl) throws Exception
{
//	if (browser.equalsIgnoreCase("firefox")) {
//        System.out.println(" Executing on FireFox");
//        WebDriverManager.firefoxdriver().setup();
//		driver.manage().window().maximize();
//        driver.get(URL);
//       
//        
//     } else if (browser.equalsIgnoreCase("chrome")) {
//        System.out.println(" Executing on CHROME");
//        WebDriverManager.chromedriver().setup();
////		//Below 3 lines written to handle show notification in browser
//    	ChromeOptions options = new ChromeOptions();
//    	options.addArguments("--disable-notifications");
//		//options.addArguments("--headless");
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//        driver.get(URL);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//       
//     } else if (browser.equalsIgnoreCase("ie")) {
//        System.out.println("Executing on IE");
//        System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
//        driver.get(URL);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//     } else {
//        throw new IllegalArgumentException("The Browser Type is Undefined");
//     }
//  }
//	
	
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	
	@Test
	public void test() throws InterruptedException {
    //Launch URL
		try{
    driver.get("https://www.lambdatest.com/selenium-playground");
    Thread.sleep(3000);
        //Define Expected Title Value
    String expectedTitle="Selenium Grid Online | Run Selenium Test On Cloud";
     //Validate using TestNG Assertion
    Assert.assertEquals(driver.getTitle(),expectedTitle);
    driver.findElement(By.xpath("//a[@href='https://www.lambdatest.com/selenium-playground/simple-form-demo']")).click();
    
    WebElement userTestBox= driver.findElement(By.id("user-message"));
    ///send values to textbox
    userTestBox.sendKeys("Welcome To LambdaTest");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@id='showInput']")).click();
    Thread.sleep(3000);
    String userTest =userTestBox.getText();
    
    WebElement checktextArea= driver.findElement(By.id("message"));
    //validate the fetched text
    Assert.assertEquals(checktextArea.getText(),"Welcome To LambdaTest","Message is    different");
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void test2() throws InterruptedException {
    //Launch URL
		try{
			driver.get("https://www.lambdatest.com/selenium-playground");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@href='https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo']")).click();		
            Thread.sleep(3000);
            WebElement slider = driver.findElement(By.xpath("(//input[@type='range'])[3]"));
            WebElement output =driver.findElement(By.id("rangeSuccess"));
            		
            Actions move = new Actions(driver);
            Thread.sleep(3000);
            move.dragAndDropBy(slider,118,0).perform();
            Thread.sleep(3000);
            System.out.println("Slider range is :" + output.getText());
            
}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
}
	
	@Test
	public void test3() throws InterruptedException {
    //Launch URL
		try{
			driver.get("https://www.lambdatest.com/selenium-playground");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@href='https://www.lambdatest.com/selenium-playground/input-form-demo']")).click();		
            Thread.sleep(3000);
            
            //
            
            //driver.findElement(By.xpath("//button[text()='Submit']")).click();
            
//            
            
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Prajakta");
            driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("Prajakta@gmail.com");
            driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("Prajakta");
            driver.findElement(By.xpath("//input[@id='company']")).sendKeys("XYZ");
            driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("Prajakta123");
            driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("abc");
            driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("abc123456");
            driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("abc8766");
            driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("maharashtra");
            driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("462632");
            driver.findElement(By.xpath("//button[text()='Submit']")).click();
            
            String expectedText ="“Thanks for contacting us, we will get back to you shortly.”";
            Assert.assertEquals("“Thanks for contacting us, we will get back to you shortly.”",expectedText);
		}
    		catch (Exception e) {
    			e.printStackTrace();
    			Assert.fail(e.getMessage());
    		}
	}
	
	@AfterTest
	 public void closeBrowser() {
	    	driver.close();
	    	System.out.println("Closing the browser");
	 }
}
