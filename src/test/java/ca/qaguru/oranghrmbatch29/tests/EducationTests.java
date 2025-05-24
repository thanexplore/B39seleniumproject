package ca.qaguru.oranghrmbatch29.tests;


import ca.qaguru.oranghrmbatch29.library.TestBase;
import ca.qaguru.oranghrmbatch29.pages.EducationPage;
import ca.qaguru.oranghrmbatch29.pages.HeaderPage;
import ca.qaguru.oranghrmbatch29.pages.LoginPage;
import ca.qaguru.oranghrmbatch29.pages.MenuOptions;
import org.testng.annotations.Test;

import java.util.UUID;

public class EducationTests extends TestBase {
@Test
public void addNewEducation() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "admin123", true, null);
    HeaderPage headerPage = new HeaderPage(driver);
    headerPage.selectMenu(MenuOptions.EDUCATION);
    EducationPage educationPage = new EducationPage(driver);
    educationPage.saveNewEducation("Master's Degree");
   String uuid = UUID.randomUUID().toString();
    educationPage.saveNewEducation("Level1may3" + uuid);
}
}

