package ca.qaguru.oranghrmbatch29.tests;


import ca.qaguru.oranghrmbatch29.library.TestBase;
import ca.qaguru.oranghrmbatch29.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginTestWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123",true,null);
    }

    @Test
    public void loginTestWithInValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("sumo", "blahblah", false,"Invalid credentials");
    }




}
