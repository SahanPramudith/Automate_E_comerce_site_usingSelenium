package pagess;

import org.openqa.selenium.*;
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
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(About));

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
        @FindBy(xpath = "//input[@id='sign-username']")
        WebElement signUserName;
        @FindBy(xpath = "//input[@id='sign-password']")
        WebElement signPassword;
        @FindBy(xpath = "//button[normalize-space()='Sign up']")
        WebElement SignUpButton;
        public void goSingPage() throws InterruptedException {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Signup.click();

            webDriverWait.until(ExpectedConditions.visibilityOf(signUserName));
            signUserName.sendKeys("sahan"+Keys.TAB);
            webDriverWait.until(ExpectedConditions.visibilityOf(signPassword));
            signPassword.sendKeys("123456"+Keys.TAB);
            SignUpButton.click();
            Thread.sleep(3000);
            Alert signAlert = driver.switchTo().alert();
            String signAlertText = signAlert.getText();
            System.out.println("text = " + signAlertText);
            signAlert.accept();
            driver.quit();
        }

        @FindBy(xpath = "//input[@id='loginusername']")
        WebElement loginUserName;
        @FindBy(xpath = "//input[@id='loginpassword']")
        WebElement loginPassword;
        @FindBy(xpath = "//button[normalize-space()='Log in']")
        WebElement loginButton;
        public void goLoginPage(){
//
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Login.click();
           // webDriverWait.until(ExpectedConditions.visibilityOf(Login));


            webDriverWait.until(ExpectedConditions.visibilityOf(loginUserName));
            loginUserName.sendKeys("sahan"+Keys.TAB);
            webDriverWait.until(ExpectedConditions.visibilityOf(loginPassword));
            loginPassword.sendKeys("123456"+Keys.TAB);
            webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
            loginButton.click();



        }




}
