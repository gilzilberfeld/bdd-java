package bdd.examples.d06;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class CalculatorPOM {
    private final String server;
    private final String  path = "calculator";
    private Playwright playwright;
    private Browser browser;
    private Page page;

    public CalculatorPOM(String server){
        this.server = server;
    }

    public void initialize(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        page = browser.newPage();
    }
    public void close(){
        page.close();
        browser.close();
        playwright.close();
    }
    public void navigate(){
        String theUrl = server + path;
        page.navigate(theUrl);
    }

    public void press(String key){
        Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(key));
        button.click();
    }

    public String getResult(){
        Locator textbox = page.getByRole(AriaRole.TEXTBOX);
        return textbox.textContent();
    }
}
