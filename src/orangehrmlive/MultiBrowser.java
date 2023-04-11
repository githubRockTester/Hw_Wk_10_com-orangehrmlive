package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-2 - Project Name: com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup other than Chrome browser
 * 2. Open URL
 * 3. Print the title of the page
 * 4. Print the current url
 * 5. Print the page source
 * 6. Enter the email to email field
 * 7. Enter the password to password field
 * 8. Close the browser
 */
public class MultiBrowser {
    static String browser = "Edge";             //Declared the Browser name as a static
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";   //Declared the Url as a static
    static WebDriver driver;                    //Declared the driver as a static

    public static void main(String[] args) {

        //if condition To set up the multiple browsers
        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("No such browser name available.");
        }
        driver.manage().window().maximize();                                //To maximize the window
        driver.get(baseUrl);                                                //To open the URL into Browser using Get method
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //We give implicit wait to driver
        System.out.println(driver.getTitle());                              //Get the Title of the page using getTitle method
        System.out.println("Current Url: " + driver.getCurrentUrl());       //Get the current URL by using getCurrentUrl method
        System.out.println("Page source: " + driver.getPageSource());       //Get the page source by using getPageSource method
        driver.findElement(By.id("username")).sendKeys("Admin");    //Find the login link and enter user ID
        driver.findElement(By.name("password")).sendKeys("admin123");   //Find the password link and enter password
        driver.close();                                                        //To close the browser


    }
}
