package apps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class MicroblogApp {

    LoginPage loginPage;
    RegisterPage registerPage;
    MenuPage menuPage;
    HomePage homePage;
    ForgotPasswordPage forgotPasswordPage;
    ExplorePage explorePage;
    FollowProfilePage followProfilePage;
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

    public ForgotPasswordPage getForgotPasswordPage(){return new ForgotPasswordPage(driver);}

    public ExplorePage getExplorePage() {
        return new ExplorePage(driver);
    }

    public FollowProfilePage getFollowProfilePage() {return new FollowProfilePage(driver);}

    public EditarPerfilPage getEditarPerfilPage() {return new EditarPerfilPage(driver);}
}
