package pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBar {
    WebDriver driver;
    public NavBar(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@class='nav-item active']//a[@class='nav-link']")
    WebElement home;
    @FindBy(xpath = "//a[normalize-space()='Contact']")
    WebElement Contact;
    @FindBy(xpath = "//a[normalize-space()='About us']")
    WebElement About;
    @FindBy(xpath = "//a[@id='cartur']")
    WebElement Cart;
    @FindBy(xpath = "//a[@id='login2']")
    WebElement Login;
    @FindBy(xpath = "//a[@id='signin2']")
    WebElement Signup;
    @FindBy(xpath = "//div[@id='exampleModal']//div[@class='modal-content']")
    WebElement modal;
    @FindBy(xpath = "//h5[@id='exampleModalLabel']")
    WebElement modalTitel;
    @FindBy(xpath = "//input[@id='recipient-email']")
    WebElement inputLabel;
    @FindBy(xpath = "//input[@id='recipient-name']")
    WebElement recipientName;
    @FindBy(xpath = "//textarea[@id='message-text']")
    WebElement textArea;
    @FindBy(xpath = " //button[normalize-space()='Send message']")
    WebElement sendButton;



    public void goHomePage(){
        home.click();
        //driver.navigate().back();
    }
    public void goContactPage() throws InterruptedException {
        Contact.click();
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement model = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By) modal));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Wait until modal title is visible
        wait.until(ExpectedConditions.visibilityOf(modalTitel));
        String titelText = modalTitel.getText();
        System.out.println("titelText = " + titelText);

        wait.until(ExpectedConditions.visibilityOf(inputLabel));
        inputLabel.sendKeys("sahan"+ Keys.TAB);
        wait.until(ExpectedConditions.visibilityOf(recipientName));
        recipientName.sendKeys("paramud"+Keys.TAB);

        wait.until(ExpectedConditions.visibilityOf(textArea));
        textArea.sendKeys("sample");

        wait.until(ExpectedConditions.visibilityOf(sendButton));
        sendButton.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }
    public void goAboutPage(){
        About.click();
        String title = driver.getTitle();
        if(title.contains("data:,")){
            System.out.println(" titel is not work " );
        }else {
            System.out.println("titel is work");
        }

    }
    public void goCartPage(){
        Cart.click();

    }
    public void goSingPage(){
        Signup.click();

    }
    public void goLoginPage(){
        Login.click();
    }




}
