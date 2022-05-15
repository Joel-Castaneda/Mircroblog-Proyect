package Login;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class LoginStepDefs{

    WebDriver driver;

    public void validarDriver(){
        assertNotNull(driver);
        assertEquals("página incorrecta", "https://selenium-automation-microblog.herokuapp.com/auth/login", driver.getCurrentUrl());
    }

    public void clickBoton(){
        WebElement button = driver.findElement(By.className("btn"));
        button.click();
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

    //Primer Escenario: Login Exitoso

    @Given("Test page is not down")
    public void test_page_is_not_down(){
        validarDriver();
    }

    @When("i write my information")
    public void IWriteMyInformation(){
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("joel");
        password.sendKeys("1234");
    }

    @And("i click the login button")
    public void IClickTheLoginButton(){
        clickBoton();
    }

    @Then("a welcome message pops up")
    public void AWelcomeMessagePopsUp(){
        WebElement alert = driver.findElement(By.id("post"));
        assertTrue(alert.isDisplayed());
    }

    //Segundo Escenario: usuario incorrecto


    @When("i enter an username not registered with a password")
    public void iEnterAnUsernameNotRegisteredWithAPassword() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("leoj");
        password.sendKeys("1234");
    }


    @Then("an error message appears")
    public void anErrorMessageAppears() {
        WebElement alert = driver.findElement(By.className("alert"));
        assertTrue(alert.isDisplayed());
    }


    //Tercer Escenario: contraseña incorrecta

    @When("i enter a registered username with a wrong password")
    public void iEnterARegisteredUsernameWithAWrongPassword() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("joel");
        password.sendKeys("123456");
    }

    //Cuarto Escenario: click en el checkbox

    @When("i write my information with the checkbox marked")
    public void iWriteMyInformationWithTheCheckboxMarked() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement checkbox = driver.findElement(By.name("remember_me"));

        username.sendKeys("joel");
        password.sendKeys("1234");
        checkbox.click();
    }

    @And("i click on log out")
    public void iClickOnLogOut() {
        WebElement logout = driver.findElement(By.cssSelector("[href='/auth/logout']"));

        logout.click();
    }

    @Then("my information should appear already writen")
    public void myInformationShouldAppearAlreadyWriten() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        assertNotEquals("No se encontraron datos","", username.getText());
    }
}
