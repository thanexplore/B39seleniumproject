package ca.qaguru.oranghrmbatch29.tests;

import ca.qaguru.oranghrmbatch29.library.TestBase;
import ca.qaguru.oranghrmbatch29.pages.LoginPage;
import org.testng.annotations.Test;

public class ParameterizationTest extends TestBase {
    @Test(dataProvider = "LoginInfo", dataProviderClass = ca.qaguru.oranghrmbatch29.tests.ParameterizationTestData.class)
    public void sampleTest(String username, String password){
        System.out.println("Username : "+ username + " Password: "+ password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password,false,"Invalid credentials");
    }
}
