package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;


public class HomePage {
    WebDriver driver;

    @FindBy(css = "h1")
    WebElement welcomeHdr;
    WebElement messagePst;

    WebElement signInBtn;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validarMensajeDeBienvenida(String user) {
        //userTxt.sendKeys(user);
        //passTxt.sendKeys(pass);

        assertTrue(welcomeHdr.getText().contains(user));



    }
}
