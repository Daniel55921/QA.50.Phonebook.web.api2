package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class RegistrationTests_negatives extends AppManager {

    @Test
    public void RegistrationNegativeTest_WrongEmailOrPassword() {
        User user = new User("kitkat44@mail.ru", "kit234568!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnRegistrationForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password format");
    }

    @Test
    public void RegistrationNegativeTest_UserAlreadyExists() {
        User user = new User("g@mail.ru", "Home123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnRegistrationForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "User already exists");
    }
}
