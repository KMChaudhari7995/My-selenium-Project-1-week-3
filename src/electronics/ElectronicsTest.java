package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setBaseUrl()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
     //1.1
         mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        String actualMessage= "Cell phones";
        WebElement expectedMessage = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        String expectedMessage1= expectedMessage.getText();
        Assert.assertEquals("Error",actualMessage,expectedMessage1);
    }

@Test
public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException{
        //2.1
    mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
    //2.2
    mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
    //2.3
    String actualMessage= "Cell phones";
    WebElement expectedMessage = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
    String expectedMessage1= expectedMessage.getText();
    Assert.assertEquals("Error",actualMessage,expectedMessage1);
    //2.4
    Thread.sleep(2000);
    clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
    //clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
    //2.5
    Thread.sleep(2000);
    clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
    //2.6
    String expectedNokia ="Nokia Lumia 1020";
    String actualNokia =driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/h1[1]")).getText();
    verifyElementMethod(expectedNokia,actualNokia);
    //2.7
    String expectedPrice ="$349.00";
    String actualPrice= driver.findElement(By.xpath("//span[normalize-space()='$349.00']")).getText();
    verifyElementMethod(expectedPrice,actualPrice);

    //2.8
    driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
    driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");

    //2.9
    Thread.sleep(1000);
    clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

    //2.10
    String expectedAdded = "The product has been added to your shopping cart";
    String actualAdded = driver.findElement(By.xpath("//p[@class='content']")).getText();
    verifyElementMethod(expectedAdded,actualAdded);
    clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));

    //2.11
    mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

    //2.12
    String expectedCartMessage = "Shopping cart";
    String actualCartMessage = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
    verifyElementMethod(expectedCartMessage,actualCartMessage);

    //2.13
   /*String expectedNumber = "2";
   String actualNumber = driver.findElement(By.xpath("//input[@id='itemquantity11240']")).getText();
   verifyElementMethod(expectedNumber,actualNumber);
*/
    WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
    String expectedText1 = "2";
    String actualText2 = text.getAttribute("value");
    verifyElementMethod(expectedText1, actualText2);


    //2.14
    String expectedTotalNumber = "$698.00";
    String actualTotalNumber =driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
    verifyElementMethod(expectedTotalNumber,actualTotalNumber);

    //2.15
    selectCheckBox(By.xpath("//input[@id='termsofservice']"));

    //2.16
    clickOnElement(By.xpath("//button[@id='checkout']"));

    //2.17
    String expectedWelcome= "Welcome, Please Sign In!";
    String actualWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
    verifyElementMethod(expectedWelcome,actualWelcome);

    //2.18
    clickOnElement(By.xpath("//a[normalize-space()='Register']"));

    //2.19
    String expectedRegister= "Register";
    String actualRegister= driver.findElement(By.xpath("//h1[normalize-space()='Register']")).getText();
    verifyElementMethod(expectedRegister,actualRegister);

    //2.20
    sendTextToElement(By.id("FirstName"), "Khushi");
    sendTextToElement(By.id("LastName"), "Chaudhari");
  //  selectFromDropDownMenu(By.name("DateOfBirthDay"), "01");
   // selectFromDropDownMenu(By.name("DateOfBirthMonth"), "June");
   // selectFromDropDownMenu(By.name("DateOfBirthYear"), "1995");
    sendTextToElement(By.id("Email"), "khushi7995@gmail.com");
    sendTextToElement(By.id("Password"), "khushi123");
    sendTextToElement(By.id("ConfirmPassword"), "khushi123");

    //2.21
    Thread.sleep(2000);
    clickOnElement(By.id("register-button"));

    //2.22
    String expectedRegistration = "Your registration completed";
    String actualRegistration = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();
    verifyElementMethod(expectedRegistration, actualRegistration);

    //2.23
    clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    //2.24
    String expectedShopping = "Shopping cart";
    String actualShopping =driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
    verifyElementMethod(expectedShopping,actualShopping);


    // 2.24 Click on login
    clickOnElement(By.xpath("//a[normalize-space()='Log in']"));

    //verify text
    //By actualMessage7 = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
    //System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText());
   // assertVerifyText(actualMessage7, "Welcome, Please Sign In!");

    // Enter email
    sendTextToElement(By.xpath("//input[@id='Email']"),"khushi7995@gmail.com");
    // password
    sendTextToElement(By.xpath("//input[@id='Password']"),"khushi123");
    // click
    clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

    // 2.25 click on checkbox “I agree with the terms of service”
    Thread.sleep(2000);
    clickOnElement(By.xpath("//input[@id='termsofservice']"));


    //2.26
    Thread.sleep(2000);
    clickOnElement(By.xpath("//button[@id='checkout']"));

    //2.27
    Thread.sleep(2000);
    /*selectFromDropDownMenu(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
    Thread.sleep(2000);
  //  selectFromDropDownMenu(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "NewYork");
    sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
    sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "wd17");
    Thread.sleep(2000);
    sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "12376");
    Thread.sleep(2000);
    sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "569847555");
*/
    selectFromDropDownMenu(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
    //state
    selectFromDropDownMenu(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"Alaska");
    //city
    sendTextToElement(By.id("BillingNewAddress_City"),"Reading");
    //Address
    sendTextToElement(By.id("BillingNewAddress_Address1"),"CrossWay");
    //Postal code
    sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"363641");
    //Phone number
    sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"9825655114");



    //2.28
    Thread.sleep(2000);
    clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

    //2.29
    Thread.sleep(2000);
    clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

    //2.30
    Thread.sleep(2000);
    clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

    //2.31
    clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
    Thread.sleep(2000);
    clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

    //2.32
    selectFromDropDownMenu(By.xpath("//select[@id='CreditCardType']"), "Visa");

    //2.33
    sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Miss Khushi C");
    sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
    selectFromDropDownMenu(By.xpath("//select[@id='ExpireMonth']"), "10");
    selectFromDropDownMenu(By.xpath("//select[@id='ExpireYear']"), "2027");
    sendTextToElement(By.xpath("//input[@id='CardCode']"), "789");

    //2.34
    clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

    //2.35
    String expectedCard = "Credit Card";
    String actualCard = driver.findElement(By.xpath("//span[contains(text(),'Credit Card')]")).getText();
    verifyElementMethod(expectedCard, actualCard);

    //2.36
    String expectedShippingMethod = "2nd Day Air";
    String actualShippingMethod =driver.findElement(By.xpath("//li[@class='shipping-method']/span[@class='value']")).getText();
    verifyElementMethod(expectedShippingMethod, actualShippingMethod);

    //2.37
    String expectedTotalPrice = "$698.00";
    String actualTotalPrice = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")).getText();
    verifyElementMethod(expectedTotalPrice, actualTotalPrice);

    //2.38
    clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

    //2.39
    String expectedMessage14 = "Thank you";
    String actualMessage14 = driver.findElement(By.xpath("//h1[text()='Thank you']")).getText();
    verifyElementMethod(expectedMessage14, actualMessage14);

    //2.40
    String expectedMessage15 = "Your order has been successfully processed!";
    String actualMessage15 =driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']")).getText();
    verifyElementMethod(expectedMessage15, actualMessage15);

    //2.41
    clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

    //2.42
    String expectedMessage16 = "Welcome to our store";
    String actualMessage16 =driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
    verifyElementMethod(expectedMessage16, actualMessage16);

    //2.43
    clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

    //2.44
    String expectedMessage17 = "https://demo.nopcommerce.com/";
    String actualMessage17 = driver.getCurrentUrl();
   verifyElementMethod(expectedMessage17, actualMessage17);
}



    @After
    public void tearDown()
    {
         driver.close();
    }
}
