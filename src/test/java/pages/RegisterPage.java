package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    WebDriver driver;

    WebElement registerHdr;

    WebElement usernameTxt;

    WebElement emailTxt;

    WebElement passwordTxt;

    WebElement repeatPasswordTxt;

    WebElement registerBtn;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //comportamiento - metodos - pasos y verificaciones.
    public void registrarUsuario(String username, String email,
                                 String password) {
        usernameTxt.sendKeys(username);
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        repeatPasswordTxt.sendKeys(password);
        registerBtn.click();
    }



}
