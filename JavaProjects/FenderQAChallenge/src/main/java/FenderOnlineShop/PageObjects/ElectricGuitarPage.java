package FenderOnlineShop.PageObjects;

import FenderAutomationFramework.AbstractWidget;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ElectricGuitarPage extends AbstractWidget
{
    @FindBy(how = How.CSS, using = "button#add-to-cart")
    private WebElement AddToCartButton;
    
    @FindBy(how = How.CSS, using = "a.stocknotification-link")
    private WebElement NotificationLink;

    //TODO add the rest of properties of the page...
    
    @Override
    public boolean IsDoneLoading() 
    {
        return true;
        //TODO add the rest of properties here
    }
    
    public ElectricGuitarPage(WebDriver driver) { super(driver); };
    
    //Widget actions
    
    public void AddToCart()
    {
        //TODO ADD Logs at different levels...
        ClickElement(AddToCartButton);
    }
    
    public void NotifyToUser()
    {
        ClickElement(NotificationLink);
        // add mail
        // click submit
    }
    
    // This method behaviour replacing the standard isDisplayed method 
    public boolean IsNotifyUserLink()
    {
        try 
        {
            WaitForCondition(()-> NotificationLink.isDisplayed());
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
}
