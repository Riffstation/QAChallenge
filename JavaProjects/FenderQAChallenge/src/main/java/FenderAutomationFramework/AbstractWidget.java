package FenderAutomationFramework;

import java.util.function.BooleanSupplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractWidget implements IWidget
{
    public WebDriver Driver;
    public String LandingPageUrl = "http://shop.fender.com/en-US"; //TODO get this from a config file 
    
    protected AbstractWidget() {}; // this is the constructor used when navigate 
    
    protected AbstractWidget(WebDriver driver)
    {
        Driver = driver;
        Initialise(driver);
    }
    
    protected void Initialise(WebDriver driver)
    {
        if(IsNotInitialised()) Driver = driver;
        PageFactory.initElements(driver, this);
        WaitForCondition(()-> this.IsDoneLoading());
    }
    
    protected void WaitForCondition(BooleanSupplier boolFunction)
    {
        WaitForCondition(boolFunction, 10000); 
    }
    
    protected void WaitForCondition(BooleanSupplier boolFunction, int timeOutInMiliSeconds) 
    {
        (new WebDriverWait(Driver, timeOutInMiliSeconds)).until((ExpectedCondition<Boolean>) (WebDriver d) -> {
            try {
                return boolFunction.getAsBoolean();
            } catch(Exception e) {
                PageFactory.initElements(Driver, this);
                return false; 
            }
        });
    }
    
    protected void ClickElement(WebElement element)
    {
        WaitForCondition(()->
        {
            element.click(); 
            return true; 
        });
    }
    
    protected void SetInputValue(WebElement element, String inputValue)
    {
        if(inputValue != null && !inputValue.isEmpty())
        {
            WaitForCondition(() ->
            {
                element.clear();
                element.click();
                element.sendKeys(inputValue);
                return true;
            });
        }
    }    
    
    protected void SelectOptionByValue(WebElement selectElement, String visibleText)
    {
      Select selectOption = new Select(selectElement);
      selectOption.selectByVisibleText(visibleText);
    }
    
    // Private methods
    
    private boolean IsNotInitialised() 
    {
        return Driver == null;
    }
}


