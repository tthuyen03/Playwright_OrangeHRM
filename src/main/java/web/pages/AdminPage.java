package web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;
import static web.constants.LocatorConstants.TABLE;

public class AdminPage extends BasePage{


    private final Locator btnAdd = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add "));
    private final Locator table = page.locator(TABLE);
    private Locator btnDeleteUser = page.locator("");

    public AdminPage(Page page){
        super(page);

    }

    public ArrayList<String> getHeaderofTable(){

        Locator headerLocator = table.locator("//div[@role='columnheader']");
        int count = headerLocator.count();
        ArrayList<String> headers = new ArrayList<>();
        for(int i = 0; i < count; i++){
            String headerName = headerLocator.nth(i).innerText().trim();
            headers.add(headerName);
        }
        return headers;
    }

    public int getIndexOfColumnName(String colName){
        ArrayList<String> headers = getHeaderofTable();
        for(String header : headers){
            if(header.contains(colName)){
                return headers.indexOf(header) + 1;
            }
        }
        return -1;
    }

    public ArrayList<String> getValueOfColumnName(String colName){
        int index = getIndexOfColumnName(colName);
        Locator elements = table.locator("//div[@role='columnheader' and text()='"+colName+"']//following::div[@role='row']/div["+index+"]");
        ArrayList<String> valueList = new ArrayList<>();
        for(int i = 0; i< elements.count(); i++){
            String value = elements.nth(i).innerText().trim();
            valueList.add(value);
        }
        return valueList;
    }

    public void clickAdd(){
        btnAdd.click();
    }


    public boolean verifyCreateUserSuccess(String colName, String username){
        List<String> userList = getValueOfColumnName(colName);
        System.out.println("User in list:");
        for (String user : userList) {
            System.out.println(user);
        }
        return userList.contains(username);
    }
}
