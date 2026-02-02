package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests_negatives extends AppManager {

    @Test
    public void loginNegativeTest_WrongEmail_BlinkField() {
        User user = new User("", "Kit088877!!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void loginNegativeTest_WrongEmail_1space() {
        User user = new User(" ", "Kit088877!!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void loginNegativeTest_WrongEmail_no1dog() {
        User user = new User("cat12322mail", "Kit088877!!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void loginNegativeTest_WrongEmail_is2dog() {
        User user = new User("cat12322@@mail", "Kit088877!!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void loginNegativeTest_WrongEmail_OneCharacter_before1dog() {
        User user = new User("c@mail", "Kit088877!!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void loginNegativeTest_WrongEmail_OneCharacter_after1dog() {
        User user = new User("cat12322@m", "Kit088877!!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void loginNegativeTest_WrongEmail_EnglishOnlyLetters() {
        User user = new User("cat@mail", "Kit088877!!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

}
