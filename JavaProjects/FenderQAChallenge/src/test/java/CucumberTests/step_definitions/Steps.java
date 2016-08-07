package CucumberTests.step_definitions;

import FenderAutomationFramework.Navigate;
import FenderOnlineShop.PageObjects.CheckOutLoginPage;
import FenderOnlineShop.PageObjects.CheckOutPage;
import FenderOnlineShop.PageObjects.ElectricGuitarPage;
import FenderOnlineShop.PageObjects.ElectricGuitarsPage;
import FenderOnlineShop.PageObjects.ShoppingCartPage;
import FenderOnlineShop.TestDataObjects.Generics.Address;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Steps 
{
    WebDriver Driver;
    ElectricGuitarsPage electricGuitarsPage;
    ElectricGuitarPage electricGuitarPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;
    
    @Given("^Navigate to Fender electric guitars")
    public void NavigateToElectricGuitars() throws Exception
    {
        // TODO i think that WebDriver instance from the method should be done in another place and not here.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        Driver = new ChromeDriver(options);
 
        Navigate.GoToPage(ElectricGuitarsPage.class, Driver);
    }
    
    @When("^Select a electric guitar which has stock")
    public void SelecElectricGuitar()
    {
        electricGuitarsPage = new ElectricGuitarsPage(Driver);
        electricGuitarsPage.SelectElectricGuitarByIndex(1); //TODO remove harcode value 
    }
    
    @And("^Add the guitar to the shopping cart")
    public void AddToCart()
    {
        electricGuitarPage = new ElectricGuitarPage(Driver);
        electricGuitarPage.AddToCart();
    }
    
    @And("^Navigate to the cart info")
    public void NavigateToCartInfo() throws Exception
    {
        shoppingCartPage = Navigate.GoToPage(ShoppingCartPage.class, Driver);
    }
    
    @And("^Go to secure checkout")
    public void GoToSecureCheckOut()
    {
        shoppingCartPage.GoToSecureCheckout();
    }
    
    @And("^Checkout as a guest")
    public void CheckoutAsGuest()
    {
        CheckOutLoginPage checkOutLogin = new CheckOutLoginPage(Driver);
        checkOutLogin.CheckOutAsAGuest();
    }
    
    @And("^Introduce a valid address")
    public void IntroduceAddress()
    {
        Address address = new Address();
        address.Initialize();
        
        checkOutPage = new CheckOutPage(Driver);
        checkOutPage.InsertAddress(address);
    }
    
    @And("^Continue to billing step")
    public void ContinueToBillingStep()
    {
        checkOutPage.GotoStep2Billing();
    }
       
    @When("^Select an electric guitar which has not stock")
    public void SelecElectricGuitarNoStock()
    {
        electricGuitarsPage = new ElectricGuitarsPage(Driver);
        electricGuitarsPage.SelectElectricGuitarByIndex(3); // TODO remove harcode use a generic non stock guitar
    }
    
    @Then("We should be into checkout bill step")
    public void CheckWeAreInSecondStep()
    {
        try 
        {
            Assert.assertTrue(checkOutPage.GetActiveStepName().contains("BILLING"));
        }
        finally
        {
            Driver.quit();
        }    
    }
    
    @Then("^Is notify user link visible")
    public void CheckIsNotifyLinkVisible()
    {
        electricGuitarPage = new ElectricGuitarPage(Driver);
        
        try 
        {
            Assert.assertTrue(electricGuitarPage.IsNotifyUserLink());
        }
        finally
        {
            Driver.quit();
        }
    }
}
