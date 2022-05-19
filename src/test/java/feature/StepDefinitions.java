package feature;

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

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StepDefinitions {

    String perfil = "hector";
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
        assertNotEquals("No se encontraron datos","", username.getText());
    }

    //Primer caso-Registro

    @Given("being in register page")
    public void beingInRegisterPage() {
        WebElement register = driver.findElement(By.linkText("¡Haz click aquí para registrarte!"));
        register.click();
    }

    @When("i write all my information")
    public void iWriteAllMyInformation(){
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement rpassword = driver.findElement(By.id("password2"));
        WebElement email = driver.findElement(By.id("email"));


        username.sendKeys("joel"+userSuffix);
        password.sendKeys("1234");
        rpassword.sendKeys("1234");
        email.sendKeys("joel"+userSuffix+"@gmail.com");
    }

    @And("i click the register button")
    public void iClickTheRegisterButton() {
        clickBoton();
    }

    @Then("a successful registration message should pop out")
    public void aSuccessfulRegistrationMessageShouldPopOut() {
        WebElement alert = driver.findElement(By.className("alert"));

        assertTrue(alert.isDisplayed());
    }

    //Segundo Escenario

    @When("i click the register button without any info")
    public void iClickTheRegisterButtonWithotAnyInfo() {
        clickBoton();
    }


    @Then("should stay in register page")
    public void ShouldStayInRegisterPage() {
        assertNotNull(driver);
        assertEquals("página incorrecta", "https://selenium-automation-microblog.herokuapp.com/auth/register", driver.getCurrentUrl());
    }

    //Tercer Escenario

    @When("i enter my information using an username that already exists")
    public void iEnterMyInformationUsingAnUsernameThatAlreadyExists() {
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement rpassword = driver.findElement(By.id("password2"));
        WebElement email = driver.findElement(By.id("email"));


        username.sendKeys("joel57");
        password.sendKeys("1234");
        rpassword.sendKeys("1234");
        email.sendKeys("joel"+userSuffix+"@gmail.com");
    }


    @Then("an error message should appear")
    public void anErrorMessageShouldAppear() {
        WebElement alert = driver.findElement(By.className("help-block"));
        assertTrue(alert.isDisplayed());
    }

    //Cuarto Escenario

    @When("i enter my information using an email that already is in use")
    public void iEnterMyInformationUsingAnEmailThatAlreadyIsInUse() {
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement rpassword = driver.findElement(By.id("password2"));
        WebElement email = driver.findElement(By.id("email"));


        username.sendKeys("joel"+userSuffix);
        password.sendKeys("1234");
        rpassword.sendKeys("1234");
        email.sendKeys("joel@gmail.com");
    }

    //Quinto Escenario

    @When("i enter my information while the info in both password fields don't coincide")
    public void iEnterMyInformationWhileTheInfoInBothPasswordFieldsDonTCoincide() {
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement rpassword = driver.findElement(By.id("password2"));
        WebElement email = driver.findElement(By.id("email"));


        username.sendKeys("joel"+userSuffix);
        password.sendKeys("123456");
        rpassword.sendKeys("1234");
        email.sendKeys("joel"+userSuffix+"@gmail.com");
    }

    //Sexto Escenario

    @When("i enter my information using an invalid email")
    public void iEnterMyInformationUsingAnInvalidEmail() {
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement rpassword = driver.findElement(By.id("password2"));
        WebElement email = driver.findElement(By.id("email"));


        username.sendKeys("joel"+userSuffix);
        password.sendKeys("1234");
        rpassword.sendKeys("1234");
        email.sendKeys("joel");
    }

    @Given("being logged")
    public void being_logged() {
        test_page_is_not_down();
        IWriteMyInformation();
        IClickTheLoginButton();
        AWelcomeMessagePopsUp();
    }

    //Primer Escenario - Follow Other Profiles

    @When("select other profile")
    public void selectOtherProfile(){

        WebElement pExplore  = driver.findElement(By.cssSelector("[href='/explore']"));
        pExplore.click();
        WebElement sProfile = driver.findElement(By.linkText(perfil));
        sProfile.click();
    }

    @And("click on follow")
    public void clickOnFollow(){
        WebElement bFollow = driver.findElement(By.cssSelector(".btn"));
        bFollow.click();
    }
    @Then("follow-up message")
    public void followUpMessage(){
        WebElement alerta = driver.findElement(By.cssSelector(".alert"));
        assertTrue(alerta.isDisplayed());

    }

    //Segundo Escenario - Follow Other Profiles

    @And("click stop following")
    public void clickStopFollowing(){
        WebElement bFollow = driver.findElement(By.cssSelector(".btn"));
        bFollow.click();
    }

    @Then("not following message")
    public void notFollowingMessage(){
        WebElement alerta = driver.findElement(By.cssSelector(".alert"));
        assertTrue(alerta.isDisplayed());


    }



    //Forgot Password
    //Primer escenario

    @When("Enter email")
    public void enterEmail() {
        WebElement email = driver.findElement(By.id("email"));

        email.sendKeys("joel@gmail.com");
    }

    @And("Click Button")
    public void clickButton() {
        clickBoton();
    }

    //Segundo Escenario

    @When("Enter invalid email")
    public void enterInvalidEmail() {
        WebElement email = driver.findElement(By.id("email"));

        email.sendKeys("joel");
    }

    //Logout
    @When("i click the logout button")
    public void iClickTheLogoutButton() {
        WebElement logbutton = driver.findElement(By.cssSelector("[href='/auth/logout']"));
        logbutton.click();
    }

    @Then("the inputs to login should be displayed")
    public void theInputsToLoginShouldBeDisplayed() {
        WebElement username = driver.findElement(By.id("username"));
        assertTrue(username.isDisplayed());
    }


}

