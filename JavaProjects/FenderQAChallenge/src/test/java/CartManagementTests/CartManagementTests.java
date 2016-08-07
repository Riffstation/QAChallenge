package CartManagementTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import FenderAutomationFramework.Navigate;
import FenderOnlineShop.PageObjects.CheckOutLoginPage;
import FenderOnlineShop.PageObjects.CheckOutPage;
import FenderOnlineShop.PageObjects.ElectricGuitarPage;
import FenderOnlineShop.PageObjects.ElectricGuitarsPage;
import FenderOnlineShop.PageObjects.ShoppingCartPage;
import FenderOnlineShop.TestDataObjects.Generics.Address;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CartManagementTests {
    
    @Test
    public void FenderQAChallengeExample() throws Exception 
    {
        // TODO move the driver initialization to a test base class into the test automation framework (TAF), anyway should be one driver instance 
        // per test, I would like to do something similar to IDisposable pattern which is used in .Net, so each test will have his own environment
        // that is necessary if we would like to run the tests in parallel.
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(options);
        
        ElectricGuitarsPage electricGuitarsPage = Navigate.GoToPage(ElectricGuitarsPage.class, driver);
        ElectricGuitarPage electricGuitarPage = electricGuitarsPage.SelectElectricGuitarByIndex(1);
        electricGuitarPage.AddToCart();
        
        ShoppingCartPage shoppingCartPage = Navigate.GoToPage(ShoppingCartPage.class, driver);
        CheckOutLoginPage checkOutLoginPage = shoppingCartPage.GoToSecureCheckout();
        
        CheckOutPage checkOutPage = checkOutLoginPage.CheckOutAsAGuest();
        
        Address validAddress = new Address();
        validAddress.Initialize();
        
        checkOutPage.InsertAddress(validAddress);
        
        checkOutPage.GotoStep2Billing();
        
        Assert.assertTrue(checkOutPage.GetActiveStepName().contains("BILLING"));
        
        driver.quit();
    }
    
}
