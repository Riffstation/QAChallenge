package FenderOnlineShop.PageObjects;

import FenderAutomationFramework.AbstractWidget;
import FenderOnlineShop.TestDataObjects.Generics.Address;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckOutPage extends AbstractWidget 
{
    public CheckOutPage(){}
    public CheckOutPage(WebDriver driver) { super(driver); }
        
    @Override
    public boolean IsDoneLoading() {
        return FirstName.isDisplayed()
            && LastName.isDisplayed()
            && Address1.isDisplayed()
            && City.isDisplayed()
            && ZipCode.isDisplayed()
            && ContinueToBillingStepButtons.get(1).isDisplayed();
    }
    
    //Widget properties 
    
    @FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_firstName")
    private WebElement FirstName;
    
    @FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_lastName")
    private WebElement LastName;  
    
    @FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address1")
    private WebElement Address1;
    
    @FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_country")
    private WebElement CountryDropDown;  
    
    @FindBy(how = How.CSS, using = "#dwfrm_singleshipping_shippingAddress_addressFields_states_state")
    private WebElement StateDropDown;
            
    @FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_city")
    private WebElement City;         
                    
    @FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_zip")
    private WebElement ZipCode;
    
    @FindBy(how = How.NAME, using = "dwfrm_singleshipping_shippingAddress_save")
    private List<WebElement> ContinueToBillingStepButtons;
 
    @FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_phone")
    private WebElement PhoneNumber;
    
    @FindBy(how = How.CSS, using = ".step.active")
    private WebElement ActiveCheckOutStep;
       
    //Widget actions and services
    
    //TODO add log information to all this methods...
    private void SetFirstName(String value)
    {
        SetInputValue(FirstName, value);
    }
    
    private void SetLastName(String value)
    {
        SetInputValue(LastName, value);
    }
    
    private void SetAddress1(String value)
    {
        SetInputValue(Address1, value);
    }
       
    private void SetCity(String value)
    {
        SetInputValue(City, value);
    }
    
    private void SetZipCode(String value)
    {
        SetInputValue(ZipCode, value);
    }
    
    private void SetCountryDropDownValue(String value)
    {
        SelectOptionByValue(CountryDropDown, value);
    }
       
    private void SetStateDropDownValue(String value)
    {
        boolean is = StateDropDown.isDisplayed();
        SelectOptionByValue(StateDropDown, value);
    }
    
    private void SetPhoneNumber(String value)
    {
        SetInputValue(PhoneNumber, value);
    }
  
    public void InsertAddress(Address address)
    {
        SetFirstName(address.FirstName);
        SetLastName(address.LastName);
        SetAddress1(address.Address1);
        SetStateDropDownValue(address.StateValue);
        SetCity(address.City);
        SetZipCode(address.ZipCode);
        SetPhoneNumber(address.Phone);
    }
    
    public void GotoStep2Billing()
    {
        ClickElement(ContinueToBillingStepButtons.get(1));
    }
    
    public String GetActiveStepName()
    {
        WaitForCondition(()-> ActiveCheckOutStep.getText() != "");
        return ActiveCheckOutStep.getText();
    }
}
