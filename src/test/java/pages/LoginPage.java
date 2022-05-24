package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="username")
    WebElement userTxt;

    @FindBy(id="password")
    WebElement passTxt;

    @FindBy(css = ".btn")
    WebElement signInBtn;

    @FindBy(css = ".alert")
    WebElement alertaErrorLbl;

    @FindBy(id = "remember_me")
    WebElement rememberChkbx;

    @FindBy(linkText = "¡Haz click aquí para registrarte!")
    WebElement registerlbl;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validarDriver(){
        assertNotNull(driver);
        assertEquals("página incorrecta", "https://selenium-automation-microblog.herokuapp.com/auth/login", driver.getCurrentUrl());
    }

    public void ingresarCredendiales(String user, String pass) {
        userTxt.sendKeys(user);
        passTxt.sendKeys(pass);
    }

    public void clickBotonSignIn() {
        signInBtn.click();
    }

    public void validarAlerta() {
        assertTrue(alertaErrorLbl.isDisplayed());
        //assertEquals(alertaErrorLbl.getText(),"Nombre de usuario o contraseña inválidos");
    }

    public void clickCheckBox(){
        rememberChkbx.click();
    }

    public void validarUsuario(){
        assertNotEquals("No se encontraron datos","", userTxt.getText());
    }

    public void clickPaginaRegistro() {
        registerlbl.click();
    }


}
