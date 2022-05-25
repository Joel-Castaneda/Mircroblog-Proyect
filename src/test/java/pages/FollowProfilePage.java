package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class FollowProfilePage {
    WebDriver driver;


   @FindBy(css = "[href = '/explore']")
   WebElement pageExplore;

   @FindBy(linkText = "Noe12" )
   WebElement perfil;

   @FindBy(css = ".btn")
   WebElement btnFollow;

   @FindBy(css = ".alert")
   WebElement alertaFollow;



    public FollowProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectOtherProfile(){

        pageExplore.click();
        perfil.click();
    }

    public void clickOnFollow(){

        btnFollow.click();
    }

    public void followUpMessage(){

        assertTrue(alertaFollow.isDisplayed());
    }

    public void clickStopFollowing(){
        btnFollow.click();
    }

    public void notFollowingMessage(){
        assertTrue(alertaFollow.isDisplayed());
    }
}
