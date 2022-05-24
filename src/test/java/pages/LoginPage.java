package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

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
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ingresarCredendiales(String user, String pass) {
        userTxt.sendKeys(user);
        passTxt.sendKeys(pass);

    }

    public void clickBotonSignIn() {
        signInBtn.click();
    }

    public void validarmensajeError() {
        assertTrue(alertaErrorLbl.isDisplayed());
        assertTrue(alertaErrorLbl.getText().equals("Invalid username or password"));
    }
}
