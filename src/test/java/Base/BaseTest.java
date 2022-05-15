package Base;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BaseTest {
    WebDriver driver;

    public void validarDriver(){
        assertNotNull(driver);
        assertEquals("página incorrecta", "https://selenium-automation-microblog.herokuapp.com/auth/login", driver.getCurrentUrl());
    }

    public void clickBoton(){
        WebElement button = driver.findElement(By.className("btn"));
        button.click();
    }


    public BaseTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Before
    public void openBrowser(){
        driver = new ChromeDriver();

        driver.get("https://selenium-automation-microblog.herokuapp.com/auth/login");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
