package FenderOnlineShop.PageObjects;

import FenderAutomationFramework.AbstractWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckOutLoginPage extends AbstractWidget
{
    public CheckOutLoginPage(WebDriver driver) { super(driver); }
    
    @FindBy(how = How.CSS, using = "button[name='dwfrm_login_unregistered']")
    private WebElement CheckOutAsGuest;

    @Override
    public boolean IsDoneLoading() {
        return CheckOutAsGuest.isDisplayed();
    }
    
    public CheckOutPage CheckOutAsAGuest()
    {
        ClickElement(CheckOutAsGuest);
        
        return new CheckOutPage(Driver);
    }
    
}
