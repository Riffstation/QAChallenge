package FenderOnlineShop.PageObjects;

import FenderAutomationFramework.AbstractWidget;
import FenderAutomationFramework.INavigable;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage extends AbstractWidget implements INavigable
{
    public ShoppingCartPage(){}
    public ShoppingCartPage(WebDriver driver) { base(driver); }
    
    @Override
    public boolean IsDoneLoading() 
    {
        return SecureCheckOut.get(2).isDisplayed();
    }
    
    @Override
    public void NavigateTo(WebDriver driver) 
    {
         driver.navigate().to(LandingPageUrl + "/cart");
    }
    
    // Widget elements  
    @FindBy(how = How.CSS, using = "button[name='dwfrm_cart_checkoutCart']")
    private List<WebElement> SecureCheckOut;
    
    // Widget actions and services
    
    public CheckOutLoginPage GoToSecureCheckout()
    {   
        ClickElement(SecureCheckOut.get(2));
        
        return new CheckOutLoginPage(Driver);
    }

    private void base(WebDriver driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
