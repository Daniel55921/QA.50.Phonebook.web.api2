package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;


public class LoginTests extends AppManager {
    @Test
    public void loginPositiveTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationForm("cat12322@mail",
                "Kit088877!!");
        loginPage.clickBtnLoginForm();
        Assert.assertTrue(new ContactPage(getDriver()).isTextInBtnAddPresent("ADD"));
    }

    @Test
    public void loginPositiveTestWithUser() {
        User user = new User("cat12322@mail",
                "Kit088877!!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertTrue(new ContactPage(getDriver()).isTextInBtnSignOutPresent("Sign Out"));
    }

    @Test
    public void loginNegativeTest_WrongEmail() {
        User user = new User("cat12322mail", "Kit088877!!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }
}
