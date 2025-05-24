package ca.qaguru.oranghrmbatch29.tests;

import ca.qaguru.oranghrmbatch29.library.TestBase;
import ca.qaguru.oranghrmbatch29.pages.HeaderPage;
import ca.qaguru.oranghrmbatch29.pages.LoginPage;
import ca.qaguru.oranghrmbatch29.pages.MembershipPage;
import ca.qaguru.oranghrmbatch29.pages.MenuOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MembershipTests extends TestBase {

    @Test
    public void addNewMembership(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        MembershipPage membershipPage = new MembershipPage(driver);
        membershipPage.addMembership("ACCA");
    }
}
