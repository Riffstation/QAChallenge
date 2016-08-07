package FenderAutomationFramework;

import org.openqa.selenium.WebDriver;

public class Navigate
{  
    public static<T extends AbstractWidget & INavigable> T GoToPage(Class<T> theClass, WebDriver driver) throws Exception
    {
        T pageInstance = theClass.newInstance();
        pageInstance.NavigateTo(driver);
        pageInstance.Initialise(driver);
        
        return pageInstance;
    }
}
