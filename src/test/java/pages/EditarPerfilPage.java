package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class EditarPerfilPage {
    WebDriver driver;

    @FindBy (css = "[href='/user/joel2933']")
    WebElement perfil;

    @FindBy (css = "[href='/edit_profile']")
    WebElement editProfile;

    @FindBy (css = "div.container h1")
    WebElement edit;

    @FindBy (id = "username")
    WebElement nUser;

    @FindBy (id = "about_me")
    WebElement tAboutMe;

    @FindBy (className = "btn")
    WebElement saveChanges;

    @FindBy (css =".alert")
    WebElement alertAppear;


    public void IclickLinkProfile(){
        perfil.click();
    }

    public void IclickEditPRofile(){
        editProfile.click();
        assertTrue(edit.isDisplayed());
    }

    public void IPutMyChanges(){
        int userSuffix = Integer.parseInt(new Random().nextInt(10000) + "");
        nUser.clear();
        nUser.sendKeys("Jaime1"+userSuffix);
        tAboutMe.sendKeys("IDK enjoy life");
    }

    public void IclickButtonSaveChanges(){
        saveChanges.click();

    }

    public void TheAlertShows(){
        assertTrue(alertAppear.isDisplayed());
    }










    public EditarPerfilPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
