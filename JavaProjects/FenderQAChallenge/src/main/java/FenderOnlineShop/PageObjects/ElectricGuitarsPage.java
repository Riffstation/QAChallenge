package FenderOnlineShop.PageObjects;

import FenderAutomationFramework.AbstractWidget;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import FenderAutomationFramework.INavigable;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;

public class ElectricGuitarsPage extends AbstractWidget implements INavigable 
{
    //Constructors
    
    public ElectricGuitarsPage() { };
    public ElectricGuitarsPage(WebDriver driver) { super(driver); };
    
    @Override
    public boolean IsDoneLoading() 
    {
        return ModelsLink.isDisplayed()
            && PlatformLink.isDisplayed();
    }
    
    //region Widget elements
    
    @FindBy(how = How.CSS, using = "a[data-reactid='.0.0.0.$0.0']")
    private WebElement ModelsLink;

    @FindBy(how = How.CSS, using = "a[data-reactid='.0.0.0.$1.0']")
    private WebElement PlatformLink;
    
    @FindBy(how = How.CSS, using = "div.product-tile a:first-child") // second child belongs to the mobile web version
    private List<WebElement> GuitarsResults;
  
    //endregion 
    
    @Override
    public void NavigateTo(WebDriver driver) 
    {
        driver.navigate().to(LandingPageUrl + "/electric-guitars/");
    }
    
    public void SelectGuitarByModel(String modelName)
    {
        ModelsLink.click();
    }
    
    public ElectricGuitarPage SelectRandomElectricGuitar()
    {
        int numberOfResults = GuitarsResults.size();
        
        if(numberOfResults > 0)
        {
            Random random = new Random();
            int randomGuitarPosition = random.nextInt(numberOfResults-1);
            
            return SelectElectricGuitarByIndex(randomGuitarPosition);
        }
        
        // TODO Logger.Debug("not any guitar has been found.");
        return null;
    }
    
    public ElectricGuitarPage SelectElectricGuitarByIndex(int index)
    {
        int numberOfResults = GuitarsResults.size();
        
        if(numberOfResults > 0 && index < numberOfResults)
        {
            ClickElement(GuitarsResults.get(index));
     
            return new ElectricGuitarPage(Driver);
        }
        
        // TODO Logger.Debug("not any guitar has been found.");
        return null;
    }
    
}
