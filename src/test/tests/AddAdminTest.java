package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.AddAdminPage;
import web.pages.AdminPage;
import web.pages.DashboardPage;
import web.pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class AddAdminTest {
    private Page page;
    private LoginPage login;
    private DashboardPage dashboard;
    private AdminPage adminPage;
    private AddAdminPage addAdminPage;
    private String browser = "chrome";

    @BeforeMethod
    public void setUp(){
        DriverFactory.initPage(browser);
        page = DriverFactory.getPage();
        login = new LoginPage(page);
        dashboard = new DashboardPage(page);
        adminPage = new AdminPage(page);
        addAdminPage = new AddAdminPage(page);
        adminPage.navigateToPage();

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.closeBrowser();
    }

    @Test(description = "Verify user is created successfully when input valid fields")
    public void createUserSuccess(){
        String username = "Admin";
        String password = "admin123";
        String employeeName = "Qwerty LName";
        String newUsername = "LName123";
        String newPasswordUser = "Lname123.";
        String newConfirmPasswordUser = "Lname123.";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(dashboard.isDashboardVisible(), "Dashboard should be visible after successful login");
        dashboard.navigateToAdminPage();
        adminPage.clickAdd();
        addAdminPage.addUser(employeeName,newUsername,newPasswordUser,newConfirmPasswordUser);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(adminPage.verifyCreateUserSuccess(newUsername), "User is NOT EXIST");

    }

}
