package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import factory.DriverFactory;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.DashboardPage;
import web.pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private Page page;
    private LoginPage login;
    private DashboardPage dashboard;
    private String browser = "chrome";

    @BeforeMethod
    public void setUp(){
        DriverFactory.initPage(browser);
        page = DriverFactory.getPage();
        login = new LoginPage(page);
        dashboard = new DashboardPage(page);
        login.navigateToPage();

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.closeBrowser();
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] takeScreen() {
        return page.screenshot();
    }

    @Step("Login with username: {username}")
    @Test(description = "Verify login successfully when input valid credentials")
    public void loginWithValidCredentials(){
        String username = "Admin";
        String password = "admin123";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(dashboard.isDashboardVisible(), "Dashboard should be visible after successful login");
        login.takeScreenshot("loginsuceess");
        takeScreen();
    }

    /*@Test(description = "Verify login successfully when input leading space in username and valid password")
    public void loginWithLeadingSpaceInUsername(){
        String username = " Admin";
        String password = "admin123";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(dashboard.isDashboardVisible(), "Should login successfully even with leading space in username");
    }

    @Test(description = "Verify login successfully when input trailing space in username and valid password")
    public void loginWithTrailingSpaceInUsername(){
        String username = "Admin ";
        String password = "admin123";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(dashboard.isDashboardVisible(), "Should login successfully even with leading space in username");
    }

    @Test(description = "Verify login successfully when input leading and trailing space in username and valid password")
    public void loginWithLeadingTrailingSpaceInUsername(){
        String username = " Admin ";
        String password = "admin123";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(dashboard.isDashboardVisible(), "Should login successfully even with leading space in username");
    }

    @Test(description = "Verify error message is displayed when input invalid username and valid password")
    public void loginFailWithInvalidUsername(){
        String username = "Admin123";
        String password = "admin123";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(login.isInvalidCredentialsVisible(), "Invalid credentials message should be visible");
    }

    @Test(description = "Verify error message is displayed when input valid username and invalid password")
    public void loginFailWithInvalidPassword(){
        String username = "Admin";
        String password = "admin";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(login.isInvalidCredentialsVisible(), "Invalid credentials message should be visible");
    }

    @Test(description = "Verify error message is displayed when input invalid username and invalid password")
    public void loginFailWithWrongCredentials(){
        String username = "Ad";
        String password = "admin";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(login.isInvalidCredentialsVisible(), "Invalid credentials message should be visible");
    }

    @Test(description = "Verify error message is displayed when blank username and password")
    public void loginFailWithEmptyFields(){
        String username = "";
        String password = "";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(login.isRequiredVisible(), "Required should be visible");
    }

    @Test(description = "Verify error message is displayed when blank username and valid password")
    public void loginFailWithEmptyUsername(){
        String username = "";
        String password = "admin123";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(login.isRequiredVisible(), "Required should be visible");
    }

    @Test(description = "Verify error message is displayed when valid username and blank password")
    public void loginFailWithEmptyPassword(){
        String username = "Admin";
        String password = "";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(login.isRequiredVisible(), "Required should be visible");
    }

    @Test(description = "Verify error message is displayed when input uppercase username and valid password")
    public void loginFailWithUppercaseUsername(){
        String username = "ADMIN";
        String password = "admin123";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(login.isInvalidCredentialsVisible(), "Invalid credentials message should be visible");
    }

    @Test(description = "Verify error message is displayed when input valid username and uppercase password")
    public void loginFailWithUppercasePassword(){
        String username = "Admin";
        String password = "ADMIN123";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(login.isInvalidCredentialsVisible(), "Invalid credentials message should be visible");
    }

    @Test(description = "Verify error message is displayed when login with sql injection")
    public void loginFailWithSqlInjection(){
        String username = "1' or 1=1--";
        String password = "1' or 1=1--";
        login.login(username,password);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertTrue(login.isInvalidCredentialsVisible(), "Invalid credentials message should be visible");
    }*/
}
