package FenderOnlineShop.TestDataObjects.Generics;

public class Address 
{
    public String FirstName;
    public String LastName;
    public String Address1;
    public String Address2;
    public String CountryValue; // TODO add enum type instead of String for different dropdown list values.
    public String StateValue; 
    public String City; // TODO add enun type...
    public String ZipCode;
    public String Phone;
    
    //TODO this testData could be initialized with random values....
    public void Initialize()
    {
        FirstName = "Jose";
        LastName = "Mascaro";
        Address1 = "Lobos of New Mexico";
        CountryValue = "US";
        StateValue = "New Mexico";
        City = "Albuquerque";
        ZipCode = "87101";
        Phone = "505-222-4360";
    }   
}
