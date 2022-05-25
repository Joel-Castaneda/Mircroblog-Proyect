package pages;

import org.openqa.selenium.By;
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


    @FindBy(css = "[href='/auth/logout']")
    WebElement logoutBtn;
    @FindBy(css = "[href='/explore']")
    WebElement ExplorePage;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validarMensajeDeBienvenida(String user) {
        assertTrue(welcomeHdr.getText().contains(user));
    }

    public void clickLogOut(){
        logoutBtn.click();
    }

    public void clickExplorePage() {
        ExplorePage.click();
    }
}
