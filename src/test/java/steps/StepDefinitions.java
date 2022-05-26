package steps;

import apps.MicroblogApp;
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
    MicroblogApp microblogApp;

    @Before
    public void openBrowser(){
        driver = new ChromeDriver();
        microblogApp = new MicroblogApp(driver);

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
        microblogApp.getLoginPage().validarDriver();
    }

    @When("i write my information")
    public void IWriteMyInformation(){
        microblogApp.getLoginPage().ingresarCredendiales("joel3124", "1234");
    }

    @And("i click the login button")
    public void IClickTheLoginButton(){
        microblogApp.getLoginPage().clickBotonSignIn();
    }

    @Then("a welcome message pops up")
    public void AWelcomeMessagePopsUp(){
        microblogApp.getHomePage().validarMensajeDeBienvenida("joel3124");
    }

    //Segundo Escenario: usuario incorrecto


    @When("i enter an username not registered with a password")
    public void iEnterAnUsernameNotRegisteredWithAPassword() {

        microblogApp.getLoginPage().ingresarCredendiales("leoj", "1234");
    }


    @Then("an error message appears")
    public void anErrorMessageAppears() {
            microblogApp.getLoginPage().validarAlerta();
    }


    //Tercer Escenario: contraseña incorrecta

    @When("i enter a registered username with a wrong password")
    public void iEnterARegisteredUsernameWithAWrongPassword() {
        microblogApp.getLoginPage().ingresarCredendiales("joel", "123456");
    }

    //Cuarto Escenario: click en el checkbox

    @When("i write my information with the checkbox marked")
    public void iWriteMyInformationWithTheCheckboxMarked() {
        microblogApp.getLoginPage().ingresarCredendiales("joel3124", "1234");
        microblogApp.getLoginPage().clickCheckBox();
    }

    @And("i click on log out")
    public void iClickOnLogOut() {
        microblogApp.getHomePage().clickLogOut();
    }

    @Then("my information should appear already writen")
    public void myInformationShouldAppearAlreadyWriten() {
        microblogApp.getLoginPage().validarUsuario();
    }

    //Primer caso-Registro

    @Given("being in register page")
    public void beingInRegisterPage() {
        microblogApp.getLoginPage().clickPaginaRegistro();
    }

    @When("i write all my information")
    public void iWriteAllMyInformation(){
        microblogApp.getRegisterPage().registrarUsuario("joel", "joel", "1234");
    }

    @And("i click the register button")
    public void iClickTheRegisterButton() {
        microblogApp.getRegisterPage().clickBotonDeRegistro();
    }

    @Then("a successful registration message should pop out")
    public void aSuccessfulRegistrationMessageShouldPopOut() {
        microblogApp.getLoginPage().validarAlerta();
    }

    //Segundo Escenario

    @When("i click the register button without any info")
    public void iClickTheRegisterButtonWithotAnyInfo() {
        microblogApp.getRegisterPage().clickBotonDeRegistro();
    }


    @Then("should stay in register page")
    public void ShouldStayInRegisterPage() {
       microblogApp.getRegisterPage().validarDireccion();
    }

    //Tercer Escenario

    @When("i enter my information using an username that already exists")
    public void iEnterMyInformationUsingAnUsernameThatAlreadyExists() {
        microblogApp.getRegisterPage().registroconUsuarioYaExistente("joel3124","joel",
                "1234");
    }


    @Then("an error message should appear")
    public void anErrorMessageShouldAppear() {
        microblogApp.getRegisterPage().mensajeDeError();
    }

    //Cuarto Escenario

    @When("i enter my information using an email that already is in use")
    public void iEnterMyInformationUsingAnEmailThatAlreadyIsInUse() {
        microblogApp.getRegisterPage().registroconEmailYaExistente("joel","joel@gmail.com","1234");
    }

    //Quinto Escenario

    @When("i enter my information while the info in both password fields don't coincide")
    public void iEnterMyInformationWhileTheInfoInBothPasswordFieldsDonTCoincide() {
        microblogApp.getRegisterPage().registroconContraseñasQueNoCoinciden("joel","joel","1234", "4569");
    }

    //Sexto Escenario

    @When("i enter my information using an invalid email")
    public void iEnterMyInformationUsingAnInvalidEmail() {
        microblogApp.getRegisterPage().registroconEmailInvalido("joel","joel","1234");
    }

    @Given("being logged")
    public void being_logged() {
        microblogApp.getLoginPage().validarDriver();
        microblogApp.getLoginPage().ingresarCredendiales("joel3124", "1234");
        microblogApp.getLoginPage().clickBotonSignIn();
        //microblogApp.getLoginPage().validarAlerta();
    }

    //Primer Escenario - Follow Other Profiles

    @When("select other profile")
    public void selectOtherProfile(){ microblogApp.getFollowProfilePage().selectOtherProfile();}

    @And("click on follow")
    public void clickOnFollow(){ microblogApp.getFollowProfilePage().clickOnFollow();}
    @Then("follow-up message")
    public void followUpMessage(){microblogApp.getFollowProfilePage().followUpMessage();}

    //Segundo Escenario - Follow Other Profiles

    @And("click stop following")
    public void clickStopFollowing(){ microblogApp.getFollowProfilePage().clickStopFollowing();}

    @Then("not following message")
    public void notFollowingMessage(){ microblogApp.getFollowProfilePage().notFollowingMessage();}


    //Explore
    //Primer caso de prueba
    @When("i click the explore link")
    public void iClickTheExploreLink() {
        microblogApp.getHomePage().clickExplorePage();
    }
    @Then("messages are loaded")
    public void messagesAreLoaded() {
        microblogApp.getExplorePage().verificarmensajesenviados();
    }

    //Segundo caso de prueba
    @And("click traslate button")
    public void clickTraslateButton(){
        microblogApp.getExplorePage().traducirmensajes();
    }
    @Then("error msg server appears")
    public void errorMsgServerAppears() {
        microblogApp.getExplorePage().verificarerrordemensaje();
    }

    //Tercer caso de prueba
    @Then("not msg server error appears")
    public void notMsgServerErrorAppears() {
        microblogApp.getExplorePage().verificarquenohayaerror();
    }

    //Cuarto caso de prueba
    @And("click profile button")
    public void clickProfileButton(){
    microblogApp.getExplorePage().visitarotroperfil();
    }
    @Then("profile appears")
    public void profileAppears() {
       microblogApp.getExplorePage().Elperfilesvisible();
    }


    //Forgot Password
    //Primer escenario
    @Given("Click en contraseña olvidada")
    public void clickEnContraseñaOlvidada() {
        microblogApp.getForgotPasswordPage().setContraseñaOlvidadaTxt();
    }

    @When("Enter email")
    public void enterEmail() {
        microblogApp.getForgotPasswordPage().setEmailTxt("joel54@gmail.com");
    }

    @And("Click Button")
    public void clickButton() {
        microblogApp.getForgotPasswordPage().clickContrsañeOlvidadaBtn();
    }

    //Segundo Escenario

    @When("Enter invalid email")
    public void enterInvalidEmail() {
        microblogApp.getForgotPasswordPage().setEmailTxt("asdasd");
    }

    //Logout
    @When("i click the logout button")
    public void iClickTheLogoutButton() {
       microblogApp.getHomePage().clickLogOut();
    }

    @Then("the inputs to login should be displayed")
    public void theInputsToLoginShouldBeDisplayed() {
        microblogApp.getLoginPage().validarAlerta();
    }

    //Send Message
    //Message

    @When("I write the message")
    public void i_write_the_message() {
        WebElement post = driver.findElement(By.id("post"));
        post.sendKeys("Testing");
    }

    @When("click the send button")
    public void click_the_send_button() {
        //clickBoton();
    }

    @Then("the message is sent")
    public void the_message_is_sent() {
        WebElement alert = driver.findElement(By.id("post"));
        assertTrue(alert.isDisplayed());
    }

    //Empty Message

    @When("I write an empty message")
    public void i_write_an_empty_message() {
        WebElement post = driver.findElement(By.id("post"));
        post.sendKeys("");
    }

    @When("click the message button")
    public void click_the_message_button() {
        //clickBoton();
    }

    @Then("the message is not sent")
    public void the_message_is_not_sent() {
        WebElement alert = driver.findElement(By.id("post"));

    }

    //Edit profile


    @When("I input my profile changes")
    public void i_input_my_profile_changes() {
        microblogApp.getEditarPerfilPage().IclickLinkProfile();
        microblogApp.getEditarPerfilPage().IclickEditPRofile();
        microblogApp.getEditarPerfilPage().IPutMyChanges();


    }

    @And("click on send button")
    public void clickOnSendButton() {
        microblogApp.getEditarPerfilPage().IclickButtonSaveChanges();
    }


    @Then("the alert of changes made appears")
    public void theAlertOfChangesMadeAppears() {
        microblogApp.getEditarPerfilPage().TheAlertShows();
    }

    //Omar
    @Given("I am logged in the application")
    public void givenIAmLoggedIn() {
        System.out.println("Hello world!");
    }

    @When("I publish a comment")
    public void iPublishAComment() {
        System.out.println("hallo welt!");
    }
    @Then("I can see the comment in the main page")
    public void iCanSeeTheCommentInTheMainPage() {
        System.out.println("alors, comment vais tu!");
    }

}

