package com.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    String username = "test_magento@gmail.com";
    String password = "selenium@123";
    String invalidPassword = "selenium@1233";

    String url = "https://magento.softwaretestingboard.com/";

    @BeforeTest
    public void setUp(){
        System.out.println("Deschide pagina magento.softwaretestingboard.com");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(testName = "Invalid Login test", priority = 1)
    public void invalidLogin() {


//        System.out.println("Deschide pagina https://magento.softwaretestingboard.com/");
//        System.out.println("Asteapta 2 secunde");
//        sleep(2000);
//
//        System.out.println("Click pe Sign In din header");
//        WebElement signInButtonLink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
//        signInButtonLink.click();
//        sleep(2000);
//
//        System.out.println("Completeaza campul email");
//        WebElement usernameInput = driver.findElement(By.id("email"));
//        usernameInput.sendKeys(username);
//        sleep(2000);
//
//        System.out.println("Completeaza campul password");
//        WebElement passwordInput = driver.findElement(By.id("pass"));
//        passwordInput.sendKeys(invalidPassword);
//        sleep(2000);
//
//        System.out.println("Clik pe butonul Sign In de la formular");
//        WebElement loginButton = driver.findElement(By.id("send2"));
//        loginButton.click();
//        sleep(2000);




        Helper.login(username,invalidPassword,driver);

        System.out.println("Verifica ca apare mesajul de eroare ");
        String errorMessage ="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement errorMessageArea = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
        Assert.assertEquals(errorMessage, errorMessageArea.getText());
        sleep(2000);
    }

    @Test(testName = "Login test", priority = 2)
    public void validLogin() {

//        System.out.println("Deschide pagina https://magento.softwaretestingboard.com/");
//        sleep(2000);
//
//        System.out.println("Click pe Sign In din header");
//        WebElement signInButtonLink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
//        signInButtonLink.click();
//        sleep(2000);
//
//        System.out.println("Completeaza campul email");
//        WebElement usernameInput = driver.findElement(By.id("email"));
//        usernameInput.sendKeys(username);
//        sleep(2000);
//
//        System.out.println("Completeaza campul password");
//        WebElement passwordInput = driver.findElement(By.id("pass"));
//        passwordInput.sendKeys(invalidPassword);
//        sleep(2000);
//
//        System.out.println("Clik pe butonul Sign In de la formular");
//        WebElement loginButton = driver.findElement(By.id("send2"));
//        loginButton.click();
//        sleep(2000);



        Helper.login(username,password,driver);


        System.out.println("Se verifica daca mesajul 'Welcome, test magento' este prezent in header");
        String welcomeMessage ="Welcome, test magento!";
        WebElement welcomeMessageArea = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));
        sleep(2000);
        Assert.assertEquals(welcomeMessage, welcomeMessageArea.getText());
    }


    @AfterTest
    public void tearDown(){

        System.out.println(" Inchide pagina");
        driver.close();
    }

    public static void sleep(int miliseconds) {

        try {
            Thread.sleep((miliseconds));
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

}
