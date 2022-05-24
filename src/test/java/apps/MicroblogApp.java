package apps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.RegisterPage;

public class MicroblogApp {

    LoginPage loginPage;
    RegisterPage registerPage;
    MenuPage menuPage;
    HomePage homePage;
    WebDriver driver;

    public MicroblogApp(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public RegisterPage getRegisterPage() {return new RegisterPage(driver); }
}
