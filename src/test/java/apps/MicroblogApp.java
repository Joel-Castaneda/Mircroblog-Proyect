package apps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class MicroblogApp {

    LoginPage loginPage;
    RegisterPage registerPage;
    MenuPage menuPage;
    HomePage homePage;
    ForgotPasswordPage forgotPasswordPage;
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

<<<<<<< HEAD
    public ForgotPasswordPage getForgotPasswordPage(){return new ForgotPasswordPage(driver);}

=======
    public ExplorePage getExplorePage() {
        return new ExplorePage(driver);
    }
>>>>>>> c21790df109057dbae5ac050f95bb156c56a5edd
}
