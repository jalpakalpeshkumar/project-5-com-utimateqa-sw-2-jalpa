package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {


    String baseUrl = "https://courses.ultimateqa.com/";

    // Set up the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //User should navigate to log in page
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //Click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//article[@class='sign-in__form']/h2")).getText();
        Assert.assertEquals("You are not in Sign In page",expectedText,actualText);
    }

    //Verify the error message
    @Test
    public void verifyTheErrorMessage(){
        //Click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Enter the invalid username
        driver.findElement(By.id("user[email]")).sendKeys("jalpa1234@gmail.com");

        //Enter the invalid password
        driver.findElement(By.id("user[password]")).sendKeys("1316jalpa");

        //Click on the ‘Sign in’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify the error message ‘Invalid email or password.’
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='notice']/ul/li")).getText();
        Assert.assertEquals("Error message is not displayed",expectedErrorMessage,actualErrorMessage);

    }

    //Close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }

}
