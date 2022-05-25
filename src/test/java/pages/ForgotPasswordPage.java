package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    WebDriver driver;

    @FindBy(linkText = "Haz click aquí para pedir una nueva")
    WebElement contraseñaOlvidadalbl;

    @FindBy(id = "email")
    WebElement emailTxt;

    @FindBy(css = ".btn")
    WebElement FPasswordbtn;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setContraseñaOlvidadaTxt(){
        contraseñaOlvidadalbl.click();
    }

    public void setEmailTxt(String email){
        emailTxt.sendKeys(email);
    }

    public void clickContrsañeOlvidadaBtn(){
        FPasswordbtn.click();
    }
}
