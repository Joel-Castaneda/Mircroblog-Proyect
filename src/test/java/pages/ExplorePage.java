package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExplorePage {
    WebDriver driver;
    @FindBy (xpath = "/html/body/div/table[1]/tbody/tr/td[2]/span[2]")
    WebElement mensaje;
    @FindBy (xpath ="//span[3]/a")
    WebElement traducir;
    @FindBy (xpath = "//td[2]/span[3]")
    WebElement error;
    @FindBy (xpath ="/html/body/div/table[1]/tbody/tr/td[2]/a")
    WebElement perfil;
    @FindBy (xpath ="/html/body/div/table[1]/tbody/tr/td[1]/img")
    WebElement imageProfile;
    public ExplorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void verificarmensajesenviados() {
        assertTrue(mensaje.isDisplayed());
    }
    public void traducirmensajes() {
    traducir.click();
    }
    public void verificarerrordemensaje() { assertTrue(error.isDisplayed());

    }
    public void verificarquenohayaerror() { assertFalse(error.isDisplayed());
    }
    public void visitarotroperfil() {
        perfil.click();
    }
    public void Elperfilesvisible() { assertTrue(imageProfile.isDisplayed());

    }
}
