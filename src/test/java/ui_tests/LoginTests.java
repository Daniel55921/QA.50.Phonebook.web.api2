package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTests extends AppManager {
    @Test
    public void loginPositiveTest() {
        System.out.println("first test");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationForm("cat12322@mail",
                "Kit088877!!");
        loginPage.clickBtnLoginForm();
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

    }
}
