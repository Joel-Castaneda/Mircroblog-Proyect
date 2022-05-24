package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

import static org.junit.Assert.*;

public class RegisterPage {

    WebDriver driver;

    WebElement registerHdr;

    @FindBy(id = "username")
    WebElement usernameTxt;

    @FindBy(id = "email")
    WebElement emailTxt;

    @FindBy(id = "password")
    WebElement passwordTxt;

    @FindBy(id = "password2")
    WebElement repeatPasswordTxt;

    @FindBy(css = ".btn")
    WebElement registerBtn;

    @FindBy(css = ".help-block")
    WebElement helpAlrt;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //comportamiento - metodos - pasos y verificaciones.
    public void registrarUsuario(String username, String email,
                                 String password) {
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");

        usernameTxt.sendKeys(username+userSuffix);
        emailTxt.sendKeys(email+userSuffix+"@gmail.com");
        passwordTxt.sendKeys(password);
        repeatPasswordTxt.sendKeys(password);
        registerBtn.click();
    }

    public void clickBotonDeRegistro(){
        registerBtn.click();
    }

    public void validarDireccion(){
        assertNotNull(driver);
        assertEquals("página incorrecta", "https://selenium-automation-microblog.herokuapp.com/auth/register", driver.getCurrentUrl());
    }

    public void registroconUsuarioYaExistente(String username, String email,
                                              String password){
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");

        usernameTxt.sendKeys(username);
        emailTxt.sendKeys(email+userSuffix+"@gmail.com");
        passwordTxt.sendKeys(password);
        repeatPasswordTxt.sendKeys(password);
        registerBtn.click();
    }

    public void mensajeDeError(){
        assertTrue(helpAlrt.isDisplayed());
    }

    public void registroconEmailYaExistente(String username, String email,
                                            String password){
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");

        usernameTxt.sendKeys(username+userSuffix);
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        repeatPasswordTxt.sendKeys(password);
        registerBtn.click();
    }

    public void registroconContraseñasQueNoCoinciden(String username, String email,
                                                     String password, String password2){
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");

        usernameTxt.sendKeys(username+userSuffix);
        emailTxt.sendKeys(email+userSuffix+"@gmail.com");
        passwordTxt.sendKeys(password);
        repeatPasswordTxt.sendKeys(password2);
        registerBtn.click();
    }

    public void registroconEmailInvalido(String username, String email,
                                         String password){
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");

        usernameTxt.sendKeys(username+userSuffix);
        emailTxt.sendKeys(email+userSuffix);
        passwordTxt.sendKeys(password);
        repeatPasswordTxt.sendKeys(password);
        registerBtn.click();
    }
}
